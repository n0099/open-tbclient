package com.baidu.searchbox.downloads.manage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.util.io.Closeables;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.OpenDownloadReceiver;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.component.RealSystemFacade;
import com.baidu.searchbox.download.constants.MigrateStatisticConstants;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.ioc.IDownloadDownloadCenter;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.table.SearchBoxDownloadTable;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.download.util.ExternalStorageCallBack;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.downloads.DownloadMessageSender;
import com.baidu.searchbox.downloads.ExitWithDownloadsDialog;
import com.baidu.searchbox.downloads.ImgDataURISchemeUtil;
import com.baidu.searchbox.newtips.message.NewTipsChangeSourceMessage;
import com.baidu.searchbox.newtips.type.NewTipsSourceID;
import com.baidu.searchbox.ng.browser.explore.model.WebAddress;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.plugins.annotation.PluginAccessable;
import com.baidu.searchbox.videoplayer.interfaces.ICyberVideoDownloadManager;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.MimeTypeMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public final class SearchBoxDownloadManager implements NoProGuard {
    public static volatile SearchBoxDownloadManager sInstance;
    public Context mContext;
    public DownloadManager mDownloadManager;
    public String mLastNetWork;
    public ContentResolver mResolver;
    public HashSet<Long> mVideoCacheIds = new HashSet<>();
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = SearchBoxDownloadManager.class.getSimpleName();
    public static final String[] PROJECTIONS = {"_id", "title", "uri", "mimetype", "_data"};
    public static final String[] PROJECTIONS_FILTER_BY_TYPE = {"_id", "title", "mimetype", "total_bytes", "status", "current_bytes", "lastmod", "_data", "extra_info"};

    public SearchBoxDownloadManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mResolver = context.getApplicationContext().getContentResolver();
        this.mDownloadManager = new DownloadManager(this.mResolver, this.mContext.getPackageName());
    }

    public static SearchBoxDownloadManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (SearchBoxDownloadManager.class) {
                if (sInstance == null) {
                    sInstance = new SearchBoxDownloadManager(context);
                }
            }
        }
        return sInstance;
    }

    public void beginDownload(final ContentValues contentValues) {
        DownloadHelper.checkExternalStorage(contentValues, new ExternalStorageCallBack() { // from class: com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager.1
            @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
            public void onResult(boolean z) {
                if (!z) {
                    return;
                }
                SearchBoxDownloadManager.this.beginDownloadReally(contentValues);
            }
        });
    }

    @Deprecated
    public boolean checkIfNeedShowApkHint(long j) {
        if (!verifyDBExtraInfo(j) && !verifyDBVisibility(j)) {
            return false;
        }
        return true;
    }

    public boolean exitAppWithDownloadTask(Context context) {
        if (hasDownloadingTasks()) {
            ExitWithDownloadsDialog.showDialog(context);
            return true;
        }
        Intent intent = new Intent(DownloadConstants.ACTION_DOWNLOAD_STOP_NOTIFICATION);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
        return false;
    }

    public Uri getDownloadUri(long j) {
        return this.mDownloadManager.getDownloadUri(j);
    }

    public void sendBeginMsg(int i) {
        DownloadMessageSender.sendBeginMsg(i);
    }

    public boolean verifyDBExtraInfo(long j) {
        JSONObject jSONObject;
        String queryExtraInfoByDownloadID = getInstance(this.mContext).queryExtraInfoByDownloadID(String.valueOf(j));
        if (!TextUtils.isEmpty(queryExtraInfoByDownloadID)) {
            try {
                jSONObject = new JSONObject(queryExtraInfoByDownloadID);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                return "1".equals(jSONObject.optString(LibDownloadConstants.APK_AUTO_INSTALL, "0"));
            }
            return false;
        }
        return false;
    }

    public void jumpVideoContinueActivity(long j, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDownloadApp.Impl.get().getVideoContinueActivityKeyDownloadType(), (Integer) 0);
        jumpContinueActivity(j, z, contentValues);
    }

    public void updateDownloadMimeType(long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", str);
        this.mResolver.update(Downloads.Impl.CONTENT_URI, contentValues, "_id = ?", new String[]{String.valueOf(j)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginDownloadReally(ContentValues contentValues) {
        int category = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(contentValues.getAsString("hint")), contentValues.getAsString("mimetype"));
        String netType = new ConnectManager(this.mContext).getNetType();
        if ((category == 0 || category == 6) && netType != null && !netType.equalsIgnoreCase("wifi")) {
            if (DEBUG) {
                String str = TAG;
                Log.v(str, "network type:" + netType);
                Log.v(TAG, "download video in not wifi network");
            }
            contentValues.put("status", (Integer) 193);
            contentValues.put("control", (Integer) 1);
            Uri insertDownload = insertDownload(contentValues, false, category);
            contentValues.put(IDownloadApp.Impl.get().getVideoContinueActivityKeyDownloadType(), Integer.valueOf(category));
            if (insertDownload != null) {
                jumpContinueActivity(ContentUris.parseId(insertDownload), false, contentValues);
            }
        } else if (category == 11) {
            insertDownload(contentValues, false, category);
        } else {
            if (category == 3) {
                contentValues.put("mimetype", "application/vnd.android.package-archive");
            } else if (category == 2 && TextUtils.equals(contentValues.getAsString(ImgDataURISchemeUtil.IMAGE_CUSTOM_KEY), ImgDataURISchemeUtil.IMAGE_LOCAL_PATH)) {
                contentValues.remove(ImgDataURISchemeUtil.IMAGE_CUSTOM_KEY);
                insertDownload(contentValues, false, category);
                return;
            }
            contentValues.put("status", (Integer) 190);
            insertDownload(contentValues, true, category);
        }
        MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_DOWNLOAD_BEGIN_ACTION_TYPE, MigrateStatisticUtils.build(String.valueOf(category)));
    }

    public String[] queryStaticsInfoByDownloadID(String str) {
        String[] strArr = new String[6];
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"total_bytes", "uri", "extra_info", "mimetype", "hint", "referer"}, "_id= ? AND is_visible_in_downloads_ui= ?", new String[]{str, String.valueOf(1)}, null);
                if (cursor != null && cursor.moveToFirst()) {
                    strArr[0] = cursor.getString(cursor.getColumnIndex("uri"));
                    strArr[1] = cursor.getString(cursor.getColumnIndex("total_bytes"));
                    strArr[2] = cursor.getString(cursor.getColumnIndex("referer"));
                    strArr[3] = cursor.getString(cursor.getColumnIndex("hint"));
                    strArr[4] = cursor.getString(cursor.getColumnIndex("mimetype"));
                    strArr[5] = cursor.getString(cursor.getColumnIndex("extra_info"));
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return strArr;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static String encodePath(String str) {
        boolean z;
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c == '[' || c == ']') {
                z = true;
                break;
            }
        }
        z = false;
        if (!z) {
            return str;
        }
        StringBuilder sb = new StringBuilder("");
        for (char c2 : charArray) {
            if (c2 != '[' && c2 != ']') {
                sb.append(c2);
            } else {
                sb.append('%');
                sb.append(Integer.toHexString(c2));
            }
        }
        return sb.toString();
    }

    public long getDownloadTimeByDownloadID(long j) {
        String[] strArr = {String.valueOf(j)};
        Cursor cursor = null;
        long j2 = 0;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"lastmod"}, "_id =? ", strArr, null);
                if (cursor != null && cursor.moveToNext()) {
                    j2 = cursor.getLong(cursor.getColumnIndex("lastmod"));
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return j2;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r7 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r7 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int queryTitleCount(String str) {
        Cursor cursor = null;
        try {
            try {
                new ContentValues().put("title", str);
                cursor = this.mResolver.query(Downloads.Impl.CONTENT_URI, null, "title = ?", new String[]{str}, null);
                if (cursor != null) {
                    int count = cursor.getCount();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return count;
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private Uri insertDownload(ContentValues contentValues, boolean z, int i) {
        Uri uri;
        try {
            uri = this.mResolver.insert(Downloads.Impl.CONTENT_URI, contentValues);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            uri = null;
        }
        if (uri != null) {
            IDownloadApp.Impl.get().doInsertDownloadUriNotNull(contentValues, uri, z, i);
        }
        return uri;
    }

    public void jumpContinueActivity(long j, boolean z, ContentValues contentValues) {
        Intent intent = new Intent(this.mContext, IDownloadApp.Impl.get().getVideoContinueActivity());
        intent.putExtra("download_id", j);
        intent.putExtra(DownloadConstants.DOWNLOAD_PAUSE_TOSTART, z);
        intent.putExtra(IDownloadApp.Impl.get().getVideoContinueActivityKeyDownloadInfo(), contentValues);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.mContext.startActivity(intent);
    }

    public void updateDownloadTitle(String str, String str2, long j) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str);
            contentValues.put("_data", str2);
            this.mResolver.update(Downloads.Impl.CONTENT_URI, contentValues, "_id = ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @PluginAccessable(methodName = "cancelAllNotifications", paramClasses = {})
    public void cancelAllNotifications() {
        RealSystemFacade realSystemFacade = new RealSystemFacade(this.mContext);
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDownloadManager.query(new DownloadManager.Query().setFilterByStatus(7).setOnlyIncludeVisibleInDownloadsUi(true));
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (cursor != null && cursor.getCount() != 0) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    realSystemFacade.cancelNotification(cursor.getLong(columnIndexOrThrow));
                    cursor.moveToNext();
                }
            }
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    @PluginAccessable(methodName = "getTotalDownloadedCount", paramClasses = {})
    public int getTotalDownloadedCount() {
        int i = 0;
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ?", new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, "lastmod DESC");
                if (cursor != null) {
                    i = cursor.getCount();
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return i;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    @PluginAccessable(methodName = "isHaveUnDisplayDownloadFile", paramClasses = {})
    public boolean isHaveUnDisplayDownloadFile() {
        boolean z = true;
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "is_visible_in_downloads_ui= ? AND deleted!= ?", new String[]{String.valueOf(1), String.valueOf(1)}, "lastmod DESC");
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("_id");
                    cursor.moveToFirst();
                    while (IDownloadApp.Impl.get().isRead(cursor.getLong(columnIndex))) {
                        if (!cursor.moveToNext()) {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                    break;
                }
                Closeables.closeSafely(cursor);
                return z;
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                Closeables.closeSafely(cursor);
                return false;
            }
        } catch (Throwable th) {
            Closeables.closeSafely(cursor);
            throw th;
        }
    }

    public void resumeDownloadingVideos() {
        if (DEBUG) {
            Log.v(TAG, "resume paused video tasks");
            String str = TAG;
            Log.v(str, "resume size:" + this.mVideoCacheIds.size());
        }
        if (this.mVideoCacheIds.size() > 0) {
            long[] jArr = new long[this.mVideoCacheIds.size()];
            int i = 0;
            Iterator<Long> it = this.mVideoCacheIds.iterator();
            while (it.hasNext()) {
                jArr[i] = it.next().longValue();
                i++;
            }
            this.mDownloadManager.resumeDownload(jArr);
            this.mVideoCacheIds.clear();
        }
    }

    public void startVideoDownload() {
        String str;
        String netType = new ConnectManager(this.mContext).getNetType();
        if (DEBUG) {
            if (netType != null) {
                String str2 = TAG;
                Log.v(str2, "currentTypenetwork type:" + netType);
            }
            if (this.mLastNetWork != null) {
                String str3 = TAG;
                Log.v(str3, "mLastNetWork type:" + this.mLastNetWork);
            }
        }
        if (!"wifi".equals(netType) && ((str = this.mLastNetWork) == null || !str.equals(netType))) {
            dealVideoTasks();
        }
        this.mLastNetWork = netType;
    }

    public void dealVideoTasks() {
        int i;
        int i2;
        int i3;
        if (DEBUG) {
            Log.v(TAG, "pause all video tasks");
        }
        this.mVideoCacheIds.clear();
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDownloadManager.query(new DownloadManager.Query().setFilterByStatus(7).setOnlyIncludeVisibleInDownloadsUi(true));
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (cursor != null && cursor.getCount() != 0) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("title");
                int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_MEDIA_TYPE);
                int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("status");
                int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("reason");
                int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("uri");
                int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("business_type");
                int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("business_id");
                cursor.moveToFirst();
                int i4 = 0;
                while (!cursor.isAfterLast()) {
                    long j = cursor.getLong(columnIndexOrThrow);
                    String string = cursor.getString(columnIndexOrThrow2);
                    String string2 = cursor.getString(columnIndexOrThrow3);
                    cursor.getString(columnIndexOrThrow6);
                    int i5 = cursor.getInt(columnIndexOrThrow4);
                    int i6 = columnIndexOrThrow;
                    int i7 = cursor.getInt(columnIndexOrThrow5);
                    int i8 = columnIndexOrThrow2;
                    int i9 = cursor.getInt(columnIndexOrThrow7);
                    int i10 = columnIndexOrThrow3;
                    String string3 = cursor.getString(columnIndexOrThrow8);
                    int i11 = columnIndexOrThrow4;
                    if (FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string), string2) == 0) {
                        i = columnIndexOrThrow5;
                        i2 = columnIndexOrThrow6;
                        i3 = columnIndexOrThrow7;
                        if (i5 == 4) {
                            if (i7 == 3 || i7 == 2) {
                                if (i9 == 1 && !TextUtils.isEmpty(string3)) {
                                    ((ICyberVideoDownloadManager) ServiceManager.getService(ICyberVideoDownloadManager.SERVICE_REFERENCE)).pauseDownload(string3);
                                } else {
                                    this.mDownloadManager.pauseDownload(j);
                                }
                                this.mVideoCacheIds.add(Long.valueOf(j));
                                i4++;
                                if (DEBUG) {
                                    String str = TAG;
                                    Log.v(str, "title:" + string);
                                    String str2 = TAG;
                                    Log.v(str2, "mimetype:" + string2);
                                    String str3 = TAG;
                                    Log.v(str3, "pause id:" + j);
                                }
                            }
                        } else {
                            if (i9 == 1 && !TextUtils.isEmpty(string3)) {
                                ((ICyberVideoDownloadManager) ServiceManager.getService(ICyberVideoDownloadManager.SERVICE_REFERENCE)).pauseDownload(string3);
                            } else {
                                this.mDownloadManager.pauseDownload(j);
                            }
                            this.mVideoCacheIds.add(Long.valueOf(j));
                            i4++;
                            if (DEBUG) {
                                String str4 = TAG;
                                Log.v(str4, "title:" + string);
                                String str5 = TAG;
                                Log.v(str5, "mimetype:" + string2);
                                String str6 = TAG;
                                Log.v(str6, "pause id:" + j);
                            }
                            cursor.moveToNext();
                            columnIndexOrThrow = i6;
                            columnIndexOrThrow2 = i8;
                            columnIndexOrThrow3 = i10;
                            columnIndexOrThrow4 = i11;
                            columnIndexOrThrow5 = i;
                            columnIndexOrThrow6 = i2;
                            columnIndexOrThrow7 = i3;
                        }
                    } else {
                        i = columnIndexOrThrow5;
                        i2 = columnIndexOrThrow6;
                        i3 = columnIndexOrThrow7;
                    }
                    cursor.moveToNext();
                    columnIndexOrThrow = i6;
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow3 = i10;
                    columnIndexOrThrow4 = i11;
                    columnIndexOrThrow5 = i;
                    columnIndexOrThrow6 = i2;
                    columnIndexOrThrow7 = i3;
                }
                if (i4 > 0) {
                    sendVideoContinueMsg();
                }
            }
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public void deleteDownload(boolean z, long... jArr) {
        Cursor cursor = null;
        try {
            if (jArr != null) {
                try {
                } catch (Exception e) {
                    e = e;
                }
                if (jArr.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    if (z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("_id");
                        sb.append(" in (");
                        for (long j : jArr) {
                            sb.append("'");
                            sb.append(j);
                            sb.append("',");
                        }
                        Cursor query = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, sb.substring(0, sb.length() - 1) + SmallTailInfo.EMOTION_SUFFIX, null, null);
                        try {
                            query.moveToFirst();
                            while (!query.isAfterLast()) {
                                arrayList.add(query.getString(query.getInt(query.getColumnIndex("_data"))));
                                query.moveToNext();
                            }
                            for (int i = 0; i < arrayList.size(); i++) {
                                String str = (String) arrayList.get(i);
                                if (str != null) {
                                    DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), str, (String) null);
                                }
                            }
                            cursor = query;
                        } catch (Exception e2) {
                            cursor = query;
                            e = e2;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            return;
                        } catch (Throwable th) {
                            cursor = query;
                            th = th;
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    }
                    this.mDownloadManager.remove(jArr);
                    IDownloadApp.Impl.get().delete(jArr);
                    Closeables.closeSafely(cursor);
                    return;
                }
            }
            Closeables.closeSafely((Cursor) null);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void deleteDownloadForOffline(boolean z, long... jArr) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            if (jArr != null) {
                try {
                    if (jArr.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        if (z) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("(");
                            for (int i = 0; i < jArr.length; i++) {
                                if (i > 0) {
                                    sb.append("OR ");
                                }
                                sb.append("_id");
                                sb.append(" = ? ");
                            }
                            sb.append(SmallTailInfo.EMOTION_SUFFIX);
                            String[] strArr = new String[jArr.length];
                            for (int i2 = 0; i2 < jArr.length; i2++) {
                                strArr[i2] = Long.toString(jArr[i2]);
                            }
                            cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, sb.toString(), strArr, null);
                            if (cursor != null) {
                                try {
                                    cursor.moveToFirst();
                                    while (!cursor.isAfterLast()) {
                                        arrayList.add(cursor.getString(cursor.getInt(cursor.getColumnIndex("_data"))));
                                        cursor.moveToNext();
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    cursor2 = cursor;
                                    if (DEBUG) {
                                        e.printStackTrace();
                                    }
                                    Closeables.closeSafely(cursor2);
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    Closeables.closeSafely(cursor2);
                                    throw th;
                                }
                            }
                        } else {
                            cursor = null;
                        }
                        this.mDownloadManager.remove(jArr);
                        if (z) {
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                String str = (String) arrayList.get(i3);
                                if (str != null) {
                                    DownloadMediaHelper.deleteMediaFile(this.mContext, str, (String) null);
                                }
                            }
                        }
                        Closeables.closeSafely(cursor);
                        return;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            Closeables.closeSafely((Cursor) null);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @PluginAccessable(methodName = "doDownload", paramClasses = {ContentValues.class, String.class, String.class, String.class, String.class, String.class, long.class})
    public void doDownload(ContentValues contentValues, String str, String str2, String str3, String str4, String str5, long j) {
        doDownload(contentValues, str, "", str2, str3, str4, str5, j);
    }

    public void doDownloadJob(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        doDownloadJob(str, str2, "", str3, str4, str5, str6, j);
    }

    @PluginAccessable(methodName = "doDownload", paramClasses = {ContentValues.class, String.class, String.class, String.class, String.class, String.class, String.class, long.class})
    public void doDownload(ContentValues contentValues, String str, String str2, String str3, String str4, String str5, String str6, long j) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                str2 = FileClassifyHelper.guessFileName(str, str5, str6);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String encodeUrl = DownloadHelper.encodeUrl(str);
        try {
            WebAddress webAddress = new WebAddress(encodeUrl);
            webAddress.mPath = encodePath(webAddress.mPath);
            if (TextUtils.equals(DownloadConstants.STORY_MIMETYPE, str6)) {
                contentValues.put("title", str2);
            }
            String cookie = CookieManager.getInstance().getCookie(encodeUrl);
            contentValues.put("uri", webAddress.toString());
            contentValues.put("cookiedata", cookie);
            contentValues.put("useragent", str4);
            contentValues.put("notificationpackage", this.mContext.getPackageName());
            contentValues.put("notificationclass", OpenDownloadReceiver.class.getCanonicalName());
            contentValues.put("visibility", (Integer) 1);
            contentValues.put("mimetype", str6);
            contentValues.put("hint", str2);
            contentValues.put("no_integrity", Boolean.TRUE);
            IDownloadApp.Impl.get().doVideoEpisodeVidBussiness(contentValues);
            String asString = contentValues.getAsString(DownloadHelper.DOWNLOAD_PATH);
            if (!TextUtils.isEmpty(asString)) {
                DownloadHelper.setDownloadPath(contentValues, asString, str2, true);
                contentValues.remove(DownloadHelper.DOWNLOAD_PATH);
            }
            contentValues.put("description", webAddress.mHost);
            if (!TextUtils.isEmpty(str3)) {
                contentValues.put("referer", str3);
            }
            if (j > 0) {
                contentValues.put("total_bytes", Long.valueOf(j));
            }
            String asString2 = contentValues.getAsString(IDownloadApp.Impl.get().getStoryRange());
            if (asString2 != null) {
                contentValues.put(Downloads.Impl.COLUMN_RANGE, asString2);
            }
            Long asLong = contentValues.getAsLong(IDownloadApp.Impl.get().getStoryStartRange());
            if (asLong != null) {
                contentValues.put(Downloads.Impl.COLUMN_RANGE_START_BYTE, asLong);
            }
            if (str6 == null) {
                new FetchUrlMimeType(this.mContext).execute(contentValues);
                return;
            }
            if (str6.equalsIgnoreCase("text/plain") || str6.equalsIgnoreCase("application/octet-stream")) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(encodeUrl));
                if (mimeTypeFromExtension == null) {
                    mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2.toLowerCase(Locale.getDefault()).substring(str2.lastIndexOf(46) + 1));
                }
                if (mimeTypeFromExtension != null) {
                    str6 = mimeTypeFromExtension;
                }
                if (str6 != null) {
                    contentValues.put("mimetype", str6);
                }
            }
            beginDownload(contentValues);
        } catch (Exception e2) {
            if (FileClassifyHelper.getCategory("", str6) == 0) {
                IDownloadApp.Impl.get().doVideoDoDownloadBussiness(contentValues, encodeUrl, e2.getMessage());
            }
            if (DEBUG) {
                String str7 = TAG;
                Log.e(str7, "Exception trying to parse url:" + encodeUrl);
            }
        }
    }

    @PluginAccessable(methodName = "doDownload", paramClasses = {String.class, String.class, String.class, String.class, String.class, long.class})
    public void doDownload(String str, String str2, String str3, String str4, String str5, long j) {
        doDownload(new ContentValues(), str, str2, str3, str4, str5, j);
    }

    public void doDownload(String str, String str2, String str3, String str4, String str5, long j, ContentValues contentValues) {
        doDownload(contentValues, str, str2, str3, str4, str5, j);
    }

    public void doDownloadJob(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j) {
        doDownloadJob(str, str2, str3, str4, str5, str6, str7, j, null);
    }

    public void doDownloadJob(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, ContentValues contentValues) {
        ContentValues contentValues2;
        if (contentValues == null) {
            contentValues2 = new ContentValues();
        } else {
            contentValues2 = contentValues;
        }
        if (!TextUtils.isEmpty(str7)) {
            contentValues2.put(DownloadHelper.DOWNLOAD_PATH, str7);
        }
        doDownload(contentValues2, str, str3, str2, str4, str5, str6, j);
    }

    @PluginAccessable(methodName = "getNewNovelCount", paramClasses = {})
    public int getNewNovelCount() {
        int i = 0;
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "status= ? AND is_visible_in_downloads_ui= ? AND mimetype= ? AND deleted!= ?", new String[]{String.valueOf(200), String.valueOf(1), DownloadConstants.STORY_MIMETYPE, String.valueOf(1)}, "lastmod DESC");
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("_id");
                    do {
                        if (!IDownloadApp.Impl.get().isRead(cursor.getLong(columnIndex))) {
                            i++;
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return i;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    @PluginAccessable(methodName = "getNewTotalCount", paramClasses = {})
    public int getNewTotalCount() {
        int i = 0;
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND uri not like '%content://%'", new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, "lastmod DESC");
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("_id");
                    do {
                        if (!IDownloadApp.Impl.get().isRead(cursor.getLong(columnIndex))) {
                            i++;
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return i;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    @PluginAccessable(methodName = "getUnfinishedDownloadCount", paramClasses = {})
    public int getUnfinishedDownloadCount() {
        int i = 0;
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "status!= ? AND is_visible_in_downloads_ui= ? AND deleted!= ?", new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, "lastmod DESC");
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("_id");
                    do {
                        if (!IDownloadApp.Impl.get().isRead(cursor.getLong(columnIndex))) {
                            i++;
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return i;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    @PluginAccessable(methodName = "hasDownloadingTasks", paramClasses = {})
    public boolean hasDownloadingTasks() {
        boolean z = true;
        boolean z2 = false;
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "(status =? OR status =? OR status =? OR status =?) AND is_visible_in_downloads_ui != ?", new String[]{String.valueOf(190), String.valueOf(196), String.valueOf(195), String.valueOf(192), "0"}, null);
                } catch (RuntimeException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (cursor != null && cursor.getCount() > 0) {
                    try {
                        if (DEBUG) {
                            Log.v(TAG, "has downloading tasks");
                        }
                    } catch (Exception e2) {
                        e = e2;
                        z2 = true;
                        if (!DEBUG) {
                            Closeables.closeSafely(cursor);
                            return z2;
                        }
                        Log.e(TAG, "only debug mode could throw this exception for rd to check");
                        throw e;
                    }
                } else {
                    if (DEBUG) {
                        Log.v(TAG, "not has downloading tasks");
                    }
                    z = false;
                }
                return z;
            } finally {
                Closeables.closeSafely((Cursor) null);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @PluginAccessable(methodName = "pauseDownloadingTasks", paramClasses = {})
    public void pauseDownloadingTasks() {
        if (DEBUG) {
            Log.v(TAG, "net work disconnect,pause all downloading tasks");
        }
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDownloadManager.query(new DownloadManager.Query().setOnlyDownloading(true));
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (cursor != null && cursor.getCount() != 0) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                long[] jArr = new long[cursor.getCount()];
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    jArr[cursor.getPosition()] = cursor.getLong(columnIndexOrThrow);
                    if (DEBUG) {
                        String str = TAG;
                        Log.v(str, "" + jArr[cursor.getPosition()]);
                    }
                    cursor.moveToNext();
                }
                this.mDownloadManager.pauseDownload(jArr);
            }
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public boolean isShowInDownloadUI(String str) {
        boolean z = false;
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "extra_info"}, "_id= ?", strArr, null);
                if (cursor != null && cursor.moveToFirst()) {
                    z = TextUtils.equals(String.valueOf(1), cursor.getString(cursor.getColumnIndex(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI)));
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return z;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public synchronized String queryExtraInfoByDownloadID(String str) {
        String str2;
        Cursor cursor;
        Throwable th;
        String[] strArr = {str};
        str2 = null;
        try {
            cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"extra_info"}, "_id= ?", strArr, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex("extra_info"));
                        }
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            Closeables.closeSafely(cursor);
            throw th;
        }
        Closeables.closeSafely(cursor);
        return str2;
    }

    public synchronized String queryFilePathByDownloadID(String str) {
        String str2;
        Cursor cursor;
        Throwable th;
        String[] strArr = {str};
        str2 = null;
        try {
            cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, "_id= ?", strArr, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex("_data"));
                        }
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            Closeables.closeSafely(cursor);
            throw th;
        }
        Closeables.closeSafely(cursor);
        return str2;
    }

    public boolean verifyDBVisibility(long j) {
        boolean z = false;
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "_id =? AND visibility =?", new String[]{String.valueOf(j), String.valueOf(1)}, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z = true;
                    }
                }
            } catch (Exception unused) {
                if (DEBUG) {
                    String str = TAG;
                    Log.v(str, j + "throw an exception not IN download db");
                }
            }
            return z;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    @PluginAccessable(methodName = "pauseAllDownloadingTasks", paramClasses = {})
    public void pauseAllDownloadingTasks() {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            try {
                i = 0;
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "(status =? OR status =? OR status =? OR status =?) AND is_visible_in_downloads_ui != ?", new String[]{String.valueOf(190), String.valueOf(196), String.valueOf(195), String.valueOf(192), "0"}, null);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (cursor != null && cursor.getCount() != 0) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                long[] jArr = new long[cursor.getCount()];
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    long j = cursor.getLong(columnIndexOrThrow);
                    if (DEBUG) {
                        String str = TAG;
                        Log.v(str, "pause id:" + j);
                    }
                    jArr[i] = j;
                    i++;
                    cursor.moveToNext();
                }
                this.mDownloadManager.pauseDownload(jArr);
                Closeables.closeSafely(cursor);
                if (DEBUG) {
                    String str2 = TAG;
                    Log.v(str2, "pauseAllDownloadingTasks tIME COST:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public ArrayList<CategoryInfoData> queryAllCategoryInfo() {
        boolean z;
        ArrayList<CategoryInfoData> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, PROJECTIONS, "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ?", new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, "lastmod DESC");
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("_id");
                    int columnIndex2 = cursor.getColumnIndex("mimetype");
                    int columnIndex3 = cursor.getColumnIndex("title");
                    int columnIndex4 = cursor.getColumnIndex("_data");
                    cursor.moveToFirst();
                    do {
                        CategoryInfoData categoryInfoData = new CategoryInfoData();
                        String string = cursor.getString(columnIndex3);
                        categoryInfoData.mId = cursor.getLong(columnIndex);
                        categoryInfoData.mMimeType = cursor.getString(columnIndex2);
                        categoryInfoData.mType = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string), categoryInfoData.mMimeType);
                        categoryInfoData.mDownloadPath = cursor.getString(columnIndex4);
                        if (!IDownloadApp.Impl.get().isRead(categoryInfoData.mId)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        categoryInfoData.newFlag = z;
                        arrayList.add(categoryInfoData);
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x015b A[LOOP:0: B:8:0x006d->B:43:0x015b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0167 A[EDGE_INSN: B:69:0x0167->B:48:0x0167 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<CategoryInfoData> queryByCategory(int i) {
        Cursor cursor;
        boolean z;
        Cursor cursor2;
        Cursor cursor3;
        ArrayList<CategoryInfoData> arrayList = new ArrayList<>();
        try {
            Cursor query = this.mContext.getContentResolver().query(Downloads.Impl.CONTENT_URI, PROJECTIONS_FILTER_BY_TYPE, "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ?", new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, "lastmod DESC");
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex("_id");
                        int columnIndex2 = query.getColumnIndex("mimetype");
                        int columnIndex3 = query.getColumnIndex("total_bytes");
                        int columnIndex4 = query.getColumnIndex("_data");
                        int columnIndex5 = query.getColumnIndex("title");
                        int columnIndex6 = query.getColumnIndex("lastmod");
                        int columnIndex7 = query.getColumnIndex("extra_info");
                        query.moveToFirst();
                        while (true) {
                            String string = query.getString(columnIndex2);
                            String string2 = query.getString(columnIndex5);
                            int category = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string2), string);
                            if (i == category) {
                                CategoryInfoData categoryInfoData = new CategoryInfoData();
                                categoryInfoData.mId = query.getLong(columnIndex);
                                categoryInfoData.mMimeType = string;
                                categoryInfoData.mType = category;
                                if (!IDownloadApp.Impl.get().isRead(categoryInfoData.mId)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                categoryInfoData.newFlag = z;
                                if (6 == i) {
                                    try {
                                        cursor3 = IDownloadApp.Impl.get().getSearchboxDownloadCursor(categoryInfoData.mId);
                                    } catch (Exception e) {
                                        e = e;
                                        cursor3 = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor2 = null;
                                    }
                                    if (cursor3 != null) {
                                        try {
                                            try {
                                            } catch (Throwable th2) {
                                                th = th2;
                                                cursor2 = cursor3;
                                                Closeables.closeSafely(cursor2);
                                                throw th;
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            if (DEBUG) {
                                                e.printStackTrace();
                                            }
                                            Closeables.closeSafely(cursor3);
                                            categoryInfoData.mSize = query.getLong(columnIndex3);
                                            categoryInfoData.mDownloadPath = query.getString(columnIndex4);
                                            categoryInfoData.mFileName = string2;
                                            categoryInfoData.mCompletionTime = query.getLong(columnIndex6);
                                            categoryInfoData.mExtraInfo = query.getString(columnIndex7);
                                            arrayList.add(categoryInfoData);
                                            if (query.moveToNext()) {
                                            }
                                        }
                                        if (cursor3.moveToFirst()) {
                                            categoryInfoData.mStoryViewProgress = cursor3.getFloat(cursor3.getColumnIndex(SearchBoxDownloadTable.viewprogress.name()));
                                            categoryInfoData.mStoryPosition = cursor3.getString(cursor3.getColumnIndex(SearchBoxDownloadTable.viewposition.name()));
                                            categoryInfoData.mGid = cursor3.getLong(cursor3.getColumnIndex(SearchBoxDownloadTable.gid.name()));
                                            categoryInfoData.mBookDirectoryUrl = cursor3.getString(cursor3.getColumnIndex(SearchBoxDownloadTable.booksrc.name()));
                                            categoryInfoData.mBookType = cursor3.getInt(cursor3.getColumnIndex(SearchBoxDownloadTable.booktype.name()));
                                            categoryInfoData.mFree = cursor3.getString(cursor3.getColumnIndex(SearchBoxDownloadTable.bookfree.name()));
                                            Closeables.closeSafely(cursor3);
                                        }
                                    }
                                    categoryInfoData.mStoryViewProgress = -1.0f;
                                    categoryInfoData.mStoryPosition = "";
                                    Closeables.closeSafely(cursor3);
                                }
                                categoryInfoData.mSize = query.getLong(columnIndex3);
                                categoryInfoData.mDownloadPath = query.getString(columnIndex4);
                                categoryInfoData.mFileName = string2;
                                categoryInfoData.mCompletionTime = query.getLong(columnIndex6);
                                categoryInfoData.mExtraInfo = query.getString(columnIndex7);
                                arrayList.add(categoryInfoData);
                            }
                            if (query.moveToNext()) {
                                break;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely(cursor);
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = query;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
            Closeables.closeSafely(query);
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
        }
        return arrayList;
    }

    public void sendCompleteMsg(long j, String str, String str2, String str3, int i, String str4, String str5) {
        String str6;
        String str7;
        if (i == 6) {
            str6 = "extra";
            IDownloadApp.Impl.get().doNovelSendCompleteMsgJob(j, str, str2, str3, i, str4);
        } else {
            str6 = "extra";
            if (i == 0) {
                if (DEBUG) {
                    Log.d(TAG, "try to show nofication download video complete");
                }
                IDownloadApp.Impl.get().doSendCompleteMsgVideoBussiness(j);
            }
        }
        try {
            Intent intent = new Intent(DownloadConstants.ACTION_DOWNLOAD_COMPLETE);
            intent.putExtra(DownloadConstants.KEY_INTENT_DOWNLOAD_CATEGORY, i);
            intent.putExtra(DownloadConstants.KEY_INTENT_DOWNLOAD_FILENAME, str);
            intent.putExtra(DownloadConstants.DOWNLOAD_SOURCE, str5);
            intent.putExtra(DownloadConstants.DOWNLOAD_TITLE, str3);
            intent.putExtra(str6, str4);
            intent.putExtra(DownloadConstants.KEY_INTENT_DOWNLOAD_ID, j);
            intent.setPackage(this.mContext.getPackageName());
            this.mContext.sendBroadcast(intent);
        } catch (Exception unused) {
        }
        NewTipsChangeSourceMessage.postNewTipsSrcChangeMessage(NewTipsSourceID.Downloading);
        NewTipsChangeSourceMessage.postNewTipsSrcChangeMessage(NewTipsSourceID.DownloadUnread);
        IDownloadDownloadCenter.Impl.get().notifyPersonalCenter();
        if (i == 3) {
            if (DEBUG) {
                Log.v(TAG, "send app complete msg");
            }
            Intent intent2 = new Intent(DownloadConstants.ACTION_DOWNLOAD_APP_COMPLETE);
            intent2.setPackage(this.mContext.getPackageName());
            intent2.setData(Uri.parse("downloadid://" + j));
            intent2.putExtra("download_id", j);
            intent2.putExtra(DownloadConstants.DOWNLOAD_FILENAME, str);
            str7 = str2;
            intent2.putExtra(DownloadConstants.DOWNLOAD_MIMETYPE, str7);
            intent2.putExtra(DownloadConstants.DOWNLOAD_COLUMNTITLE, str3);
            intent2.putExtra(str6, str4);
            intent2.putExtra(DownloadConstants.PERFORM_DOWNLOAD, "1");
            this.mContext.sendStickyBroadcast(intent2);
        } else {
            str7 = str2;
        }
        if (DEBUG) {
            String str8 = TAG;
            Log.v(str8, "统计 file name:" + str);
            String str9 = TAG;
            Log.v(str9, "file mimetype:" + str7);
            String str10 = TAG;
            Log.v(str10, "file type:" + i);
        }
        MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_DOWNLOAD_FINISH_ACTION_TYPE, MigrateStatisticUtils.build(String.valueOf(i)));
    }

    public void sendDownloadMsg(long j, String str, String str2, String str3, String str4, long j2, String str5, String str6) {
        String str7;
        String fileSuffix = FileClassifyHelper.getFileSuffix(str);
        String isStory = IDownloadApp.Impl.get().isStory(j, str2, fileSuffix);
        if (!TextUtils.isEmpty(isStory)) {
            str7 = isStory;
        } else {
            str7 = str2;
        }
        int category = FileClassifyHelper.getCategory(fileSuffix, str7);
        if (category == 6) {
            IDownloadApp.Impl.get().doNovelSendDownloadMsg(j, str, str7, str3, str4, j2, str5, category);
            return;
        }
        sendCompleteMsg(j, str, str7, str3, category, str5, str6);
        try {
            MediaScannerConnection.scanFile(AppRuntime.getAppContext(), new String[]{str}, null, null);
        } catch (Exception unused) {
        }
    }

    public void sendNovelBeginMsg() {
        Intent intent = new Intent(DownloadConstants.ACTION_DOWNLOAD_NOVEL_BEGIN);
        intent.setPackage(this.mContext.getPackageName());
        this.mContext.sendBroadcast(intent);
    }

    public void sendVideoContinueMsg() {
        Intent intent = new Intent(DownloadConstants.ACTION_DOWNLOAD_VIDEO_CONTINUE);
        intent.setPackage(this.mContext.getPackageName());
        if (ContextCompat.checkSelfPermission(this.mContext, "android.permission.BROADCAST_STICKY") == 0) {
            this.mContext.sendStickyBroadcast(intent);
        } else {
            this.mContext.sendBroadcast(intent);
        }
    }
}
