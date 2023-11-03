package com.baidu.searchbox.downloads;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.callback.ISystemFacade;
import com.baidu.searchbox.download.component.DownloadReceiver;
import com.baidu.searchbox.download.component.RealSystemFacade;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.ioc.IDownloadDownloadCenter;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.download.model.DownloadInfo;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DownloadByteConverter;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadStatisticUtil;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.y;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownloadNotification {
    public static final String LOGTAG = "DownloadNotification";
    public static final String TAG = "DownloadNotification";
    public static final String WHERE_COMPLETED = "status >= '200' AND visibility == '1'";
    public static final String WHERE_RUNNING = "(status >= '100') AND (status <= '199') AND (visibility IS NULL OR visibility == '0' OR visibility == '1')";
    public static HashMap<Long, NotificationItem> mLastNotifications;
    public Context mContext;
    public ISystemFacade mISystemFacade;
    public HashMap<Long, NotificationItem> mNotifications;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final boolean DEBUG_LOG = false;
    public static Map<String, Bitmap> mNotificationsIconBitmap = new ConcurrentHashMap();
    @SuppressLint({"StaticFieldLeak"})
    public static volatile DownloadNotification sInstance = null;
    public HashMap<Long, Long> mTimes = new HashMap<>();
    public HashMap<Long, Long> mBytes = new HashMap<>();
    public HashMap<Long, String> mSpeeds = new HashMap<>();
    public Set<Integer> mNotificationHasUBCShow = new TreeSet();
    public Set<Long> waitToNotifyComplete = new HashSet();
    public Set<Long> notifiedCompleteNotifications = new HashSet();

    public static DownloadNotification getInstance() {
        if (sInstance == null) {
            synchronized (DownloadNotification.class) {
                if (sInstance == null) {
                    sInstance = new DownloadNotification();
                }
            }
        }
        return sInstance;
    }

    public void cancelCompleteNotifications() {
        Set<Long> set = this.notifiedCompleteNotifications;
        if (set != null && set.size() != 0) {
            for (Long l : this.notifiedCompleteNotifications) {
                this.mISystemFacade.cancelNotification(l.longValue());
            }
            this.notifiedCompleteNotifications.clear();
        }
    }

    /* loaded from: classes3.dex */
    public static class NotificationItem {
        public String mIcon;
        public int mId;
        public int mProgresss;
        public int mStatus;
        public String mTitle;
        public String mType;
        public long mTotalCurrent = 0;
        public long mTotalTotal = 0;
        public String mPausedText = null;
        public String mTickerText = null;

        public String toString() {
            return "[mId = " + this.mId + " ,mTotalCurrent = " + this.mTotalCurrent + " ,mTotalTotal = " + this.mTotalTotal + " ,mTitle = " + this.mTitle + " ,mPausedText = " + this.mPausedText + " ,mStatus = " + this.mStatus + " ,mType = " + this.mType + " ,mTickerText = " + this.mTickerText + " ,mIcon = " + this.mIcon + " ,mProgress = " + this.mProgresss + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    public DownloadNotification() {
        Context appContext = AppRuntime.getAppContext();
        this.mContext = appContext;
        this.mISystemFacade = new RealSystemFacade(appContext);
        this.mNotifications = new HashMap<>();
        mLastNotifications = new HashMap<>();
    }

    @Nullable
    public static Bitmap getBitmap(String str) {
        Map<String, Bitmap> map = mNotificationsIconBitmap;
        if (map != null && map.containsKey(str)) {
            return mNotificationsIconBitmap.get(str);
        }
        return null;
    }

    private boolean isActiveAndVisible(DownloadInfo downloadInfo) {
        int i = downloadInfo.mStatus;
        if (100 <= i && i < 200 && downloadInfo.mVisibility != 2) {
            return true;
        }
        return false;
    }

    private boolean isCompleteAndVisible(DownloadInfo downloadInfo) {
        if (downloadInfo.mStatus >= 200 && downloadInfo.mVisibility != 2) {
            return true;
        }
        return false;
    }

    public void cancelNotificationIds(long[] jArr) {
        if (jArr != null && jArr.length != 0) {
            for (long j : jArr) {
                this.mISystemFacade.cancelNotification(j);
            }
        }
    }

    public void updateNotification(Collection<DownloadInfo> collection) {
        try {
            updateActiveNotification(collection);
            updateCompletedNotification(collection);
        } catch (Exception e) {
            if (!DEBUG_LOG) {
                return;
            }
            throw new DebugException("DownloadNotificationupdateNotification()", e);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v2 long), ('%' char)] */
    private String getDownloadingText(long j, long j2) {
        if (j <= 0) {
            return "";
        }
        long j3 = (j2 * 100) / j;
        StringBuilder sb = new StringBuilder();
        sb.append(j3);
        sb.append('%');
        return sb.toString();
    }

    public static synchronized void putBitmap(String str, Bitmap bitmap) {
        synchronized (DownloadNotification.class) {
            if (!TextUtils.isEmpty(str) && bitmap != null) {
                if (mNotificationsIconBitmap == null) {
                    mNotificationsIconBitmap = new ConcurrentHashMap();
                }
                mNotificationsIconBitmap.put(str, bitmap);
            }
        }
    }

    private String calculateSpeed(NotificationItem notificationItem) {
        String str;
        long j;
        long j2;
        String str2;
        long j3 = notificationItem.mId;
        long j4 = notificationItem.mTotalCurrent;
        long j5 = notificationItem.mTotalTotal;
        int i = notificationItem.mProgresss;
        if (j5 > 0) {
            str = " | " + ((int) ((j4 * 100.0d) / j5)) + "%";
        } else if (i > 0) {
            str = " | " + i + "%";
        } else {
            str = "";
        }
        if (this.mBytes.containsKey(Long.valueOf(j3))) {
            j = j4 - this.mBytes.get(Long.valueOf(j3)).longValue();
            if (j < 0) {
                j = 0;
            }
        } else {
            j = -1;
        }
        this.mBytes.put(Long.valueOf(j3), Long.valueOf(j4));
        if (this.mTimes.containsKey(Long.valueOf(j3))) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = currentTimeMillis - this.mTimes.get(Long.valueOf(j3)).longValue();
            if (j > 0) {
                this.mTimes.put(Long.valueOf(j3), Long.valueOf(currentTimeMillis));
            }
        } else {
            this.mTimes.put(Long.valueOf(j3), Long.valueOf(System.currentTimeMillis()));
            j2 = 0;
        }
        if (j2 != 0) {
            String convertByte = DownloadByteConverter.convertByte((j / j2) * 1000, 1, false);
            if (!convertByte.equals("0B")) {
                str2 = convertByte + "/s ";
                this.mSpeeds.put(Long.valueOf(j3), convertByte + "/s ");
            } else if (this.mSpeeds.get(Long.valueOf(j3)) != null) {
                str2 = this.mSpeeds.get(Long.valueOf(j3));
            }
            return str2 + str;
        }
        str2 = "0B/s ";
        return str2 + str;
    }

    public static boolean deleteNotificationIcon(Context context, Long l) {
        boolean z = false;
        try {
            NotificationItem notificationItem = mLastNotifications.get(l);
            String str = "";
            if (notificationItem != null) {
                str = notificationItem.mIcon;
            }
            if (!TextUtils.isEmpty(str) && mNotificationsIconBitmap != null && mNotificationsIconBitmap.containsKey(str)) {
                mNotificationsIconBitmap.remove(str);
                z = true;
            }
            if (DEBUG_LOG) {
                Log.d("DownloadNotification", " deleteNotificationIcon(final Context context, final Long id) : \n context = " + DownloadHelper.getDisplayString(context) + "\n id = " + DownloadHelper.getDisplayString(l) + "\n notificationItem = " + DownloadHelper.getDisplayString(notificationItem) + "\n iconUrl = " + DownloadHelper.getDisplayString(str) + "\n isDeleted = " + DownloadHelper.getDisplayString(Boolean.valueOf(z)));
            }
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e("DownloadNotification", "deleteNotificationIcon() \n" + th);
            }
        }
        return z;
    }

    private void loadNotificationIcon(final Context context, final String str) {
        Map<String, Bitmap> map = mNotificationsIconBitmap;
        if (map != null && map.containsKey(str) && mNotificationsIconBitmap.get(str) != null) {
            if (DEBUG_LOG) {
                Log.d("DownloadNotification", " loadNotificationIcon(final Context context, final String url) : onNewResultImpl(Bitmap bitmap)：\n context = " + DownloadHelper.getDisplayString(context) + "\n url = " + DownloadHelper.getDisplayString(str) + "\n return");
                return;
            }
            return;
        }
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setProgressiveRenderingEnabled(true).build(), context).subscribe(new BaseBitmapDataSubscriber() { // from class: com.baidu.searchbox.downloads.DownloadNotification.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            }

            @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
            public void onNewResultImpl(Bitmap bitmap) {
                String str2;
                if (DownloadNotification.DEBUG_LOG) {
                    if ((" loadNotificationIcon(final Context context, final String url) : onNewResultImpl(Bitmap bitmap)：\n context = " + DownloadHelper.getDisplayString(context) + "\n url = " + DownloadHelper.getDisplayString(str) + "\n bitmap" + bitmap) == null) {
                        str2 = " = null";
                    } else {
                        str2 = " != null";
                    }
                    Log.d("DownloadNotification", str2);
                }
                Bitmap bitmap2 = null;
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap2 = bitmap.getConfig() == null ? bitmap.copy(Bitmap.Config.ARGB_8888, true) : bitmap.copy(bitmap.getConfig(), true);
                }
                if (bitmap2 != null) {
                    if (DownloadNotification.mNotificationsIconBitmap == null) {
                        Map unused = DownloadNotification.mNotificationsIconBitmap = new ConcurrentHashMap();
                    }
                    DownloadNotification.putBitmap(str, bitmap2);
                }
            }
        }, CallerThreadExecutor.getInstance());
    }

    private void setItemProgress(VersionedNotification versionedNotification, NotificationItem notificationItem) {
        int i;
        long j = notificationItem.mTotalTotal;
        boolean z = false;
        if (j > 0) {
            i = (int) (((notificationItem.mTotalCurrent * 1.0d) / j) * 1000.0d);
        } else {
            int i2 = notificationItem.mProgresss;
            if (i2 > 0) {
                i = i2 * 10;
            } else {
                i = 0;
            }
        }
        if (notificationItem.mTotalTotal == -1 && notificationItem.mProgresss == 0) {
            z = true;
        }
        versionedNotification.setProgress(1000, i, z);
    }

    private void updateActiveNotification(Collection<DownloadInfo> collection) {
        boolean z;
        DebugException debugException;
        String str;
        int i;
        HashMap<Long, NotificationItem> hashMap = this.mNotifications;
        if (hashMap == null) {
            return;
        }
        if (hashMap != null) {
            mLastNotifications.putAll(hashMap);
        }
        this.mNotifications.clear();
        for (DownloadInfo downloadInfo : collection) {
            if (isActiveAndVisible(downloadInfo)) {
                int i2 = downloadInfo.mStatus;
                if (i2 != 192) {
                    if ((i2 >= 193 && i2 <= 196) || (i = downloadInfo.mStatus) == 488 || i == 489) {
                        NotificationItem notificationItem = mLastNotifications.get(Long.valueOf(downloadInfo.mId));
                        if (notificationItem != null && notificationItem.mStatus == 192) {
                        }
                    }
                }
                long j = downloadInfo.mTotalBytes;
                long j2 = downloadInfo.mCurrentBytes;
                long j3 = downloadInfo.mId;
                String str2 = downloadInfo.mTitle;
                if (str2 == null || str2.length() == 0) {
                    if (!TextUtils.isEmpty(downloadInfo.mHint)) {
                        str2 = downloadInfo.mHint;
                    } else {
                        str2 = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f05fa);
                    }
                }
                NotificationItem notificationItem2 = new NotificationItem();
                notificationItem2.mId = (int) j3;
                notificationItem2.mTitle = str2;
                notificationItem2.mTotalCurrent = j2;
                notificationItem2.mTotalTotal = j;
                notificationItem2.mStatus = downloadInfo.mStatus;
                notificationItem2.mType = downloadInfo.mMimeType;
                notificationItem2.mProgresss = downloadInfo.mProgress;
                if (!TextUtils.isEmpty(downloadInfo.mExtraInfo)) {
                    try {
                        notificationItem2.mIcon = new JSONObject(downloadInfo.mExtraInfo).optString("icon", "");
                    } catch (Exception e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
                if (downloadInfo.mStatus != 192 && notificationItem2.mPausedText == null) {
                    notificationItem2.mPausedText = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f05e2);
                }
                if (DEBUG) {
                    Log.d("DownloadNotification", notificationItem2.toString());
                }
                this.mNotifications.put(Long.valueOf(j3), notificationItem2);
            }
        }
        for (NotificationItem notificationItem3 : this.mNotifications.values()) {
            VersionedNotification versionedNotification = VersionedNotification.getInstance(this.mContext);
            if (DeviceUtil.OSInfo.hasOreo()) {
                versionedNotification.setChannel(IDownloadApp.Impl.get().getDownloadChannel());
            }
            String str3 = notificationItem3.mTitle;
            versionedNotification.setContentTitle(DownloadHelper.getTitleCutOff(str3));
            versionedNotification.setSmallIcon(17301633);
            if (!DownloadNotificationFitter.checkIsMiuiRom()) {
                try {
                    if (DEBUG_LOG) {
                        Log.d("DownloadNotification", " updateActiveNotification(Collection<DownloadInfo> downloads) : for (DownloadInfo download : downloads)：\n item = " + DownloadHelper.getDisplayString(notificationItem3) + "\n item.mType = " + DownloadHelper.getDisplayString(notificationItem3.mType));
                    }
                    if (TextUtils.isEmpty(notificationItem3.mIcon)) {
                        if (DEBUG_LOG) {
                            Log.d("DownloadNotification", " updateActiveNotification(Collection<DownloadInfo> downloads) : for (DownloadInfo download : downloads)：\n TextUtils.isEmpty(item.mIcon)notification.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),\nDownloadHelper.getIconId(title, item.mType)))");
                        }
                        versionedNotification.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), DownloadHelper.getIconId(str3, notificationItem3.mType)));
                    } else {
                        Bitmap bitmap = getBitmap(notificationItem3.mIcon);
                        if (bitmap != null) {
                            if (DEBUG_LOG) {
                                Log.d("DownloadNotification", " updateActiveNotification(Collection<DownloadInfo> downloads) : for (DownloadInfo download : downloads)：\n if (mNotificationsIconBitmap.containsKey(item.mIcon)\n && mNotificationsIconBitmap.get(item.mIcon) != null)\nnotification.setLargeIcon(iconBitmap)");
                            }
                            versionedNotification.setLargeIcon(bitmap);
                        } else {
                            if (DEBUG_LOG) {
                                Log.d("DownloadNotification", " updateActiveNotification(Collection<DownloadInfo> downloads) : for (DownloadInfo download : downloads)：\n else -> else\n notification.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),\nDownloadHelper.getIconId(title, download.mMimeType)))");
                            }
                            versionedNotification.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), DownloadHelper.getIconId(str3, notificationItem3.mType)));
                            loadNotificationIcon(this.mContext, notificationItem3.mIcon);
                        }
                    }
                } finally {
                    if (z) {
                    }
                }
            }
            if (!DownloadNotificationFitter.checkIsMiuiRom()) {
                versionedNotification.setOngoing(true);
            }
            setItemProgress(versionedNotification, notificationItem3);
            if (TextUtils.isEmpty(notificationItem3.mPausedText)) {
                long j4 = notificationItem3.mTotalTotal;
                if (j4 != -1) {
                    String convertByte = DownloadByteConverter.convertByte(j4, 1, false);
                    if (!TextUtils.isEmpty(convertByte)) {
                        versionedNotification.setContentText(convertByte);
                    }
                }
                if (!DownloadNotificationFitter.checkIsVivoVersion25()) {
                    if (DeviceUtil.OSInfo.hasNougat()) {
                        versionedNotification.setSubText(calculateSpeed(notificationItem3));
                    } else {
                        versionedNotification.setContentInfo(calculateSpeed(notificationItem3));
                    }
                }
            } else {
                versionedNotification.setContentText(notificationItem3.mPausedText);
            }
            if (TextUtils.isEmpty(str3)) {
                str = "";
            } else {
                str = str3.toLowerCase(Locale.getDefault());
            }
            int category = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(str), notificationItem3.mType);
            Intent intent = new Intent(Constants.ACTION_LIST);
            intent.setClassName(this.mContext.getPackageName(), DownloadReceiver.class.getName());
            intent.setData(ContentUris.withAppendedId(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, notificationItem3.mId));
            intent.putExtra("multiple", false);
            intent.putExtra(Constants.EXTRA_TYPE, category);
            versionedNotification.setContentIntent(y.a(this.mContext, 0, intent, 0));
            versionedNotification.setWhen(0L);
            if (notificationItem3.mStatus != 192) {
                this.mISystemFacade.cancelNotification(notificationItem3.mId);
            } else {
                if (TextUtils.isEmpty(notificationItem3.mTickerText)) {
                    notificationItem3.mTickerText = notificationItem3.mTitle + " " + this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f05c2);
                }
                versionedNotification.setTicker(notificationItem3.mTickerText);
            }
            this.mISystemFacade.postNotification(notificationItem3.mId, versionedNotification.getNotification());
            this.waitToNotifyComplete.add(Long.valueOf(notificationItem3.mId));
            if (!this.mNotificationHasUBCShow.contains(Integer.valueOf(notificationItem3.mId))) {
                DownloadStatisticUtil.downloadNotificationShow(category);
                this.mNotificationHasUBCShow.add(Integer.valueOf(notificationItem3.mId));
            }
        }
    }

    private void updateCompletedNotification(Collection<DownloadInfo> collection) {
        String str;
        String string;
        Intent intent;
        boolean z;
        DebugException debugException;
        boolean checkTopActivityIsFileManagerOrDownloadList = IDownloadDownloadCenter.Impl.get().checkTopActivityIsFileManagerOrDownloadList();
        for (DownloadInfo downloadInfo : collection) {
            if (isCompleteAndVisible(downloadInfo) && this.waitToNotifyComplete.contains(Long.valueOf(downloadInfo.mId))) {
                Notification.Builder smallIcon = new Notification.Builder(this.mContext).setSmallIcon(17301634);
                if (DeviceUtil.OSInfo.hasOreo()) {
                    IDownloadApp.Impl.get().setNotificationChannelAndGroupId(smallIcon, IDownloadApp.Impl.get().getDownloadedChannel());
                }
                long j = downloadInfo.mId;
                String str2 = downloadInfo.mTitle;
                if (str2 == null || str2.length() == 0) {
                    if (!TextUtils.isEmpty(downloadInfo.mHint)) {
                        str2 = downloadInfo.mHint;
                    } else {
                        str2 = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f05fa);
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str = "";
                } else {
                    str = str2.toLowerCase(Locale.getDefault());
                }
                int category = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(str), downloadInfo.mMimeType);
                Uri withAppendedId = ContentUris.withAppendedId(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, j);
                if (Downloads.Impl.isStatusError(downloadInfo.mStatus)) {
                    string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0eda);
                    intent = new Intent(Constants.ACTION_LIST);
                    smallIcon.setSmallIcon(17301642);
                } else {
                    string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0ed9);
                    int i = downloadInfo.mDestination;
                    if (i != 0 && i != 5) {
                        intent = new Intent(Constants.ACTION_LIST);
                    } else {
                        intent = new Intent(Constants.ACTION_OPEN);
                    }
                }
                intent.setClassName(this.mContext.getPackageName(), DownloadReceiver.class.getName());
                intent.setData(withAppendedId);
                intent.putExtra(Constants.EXTRA_TYPE, category);
                smallIcon.setContentTitle(DownloadHelper.getTitleCutOff(str2)).setContentText(string).setWhen(downloadInfo.mLastMod).setContentIntent(y.a(this.mContext, 0, intent, 0));
                if (!DownloadNotificationFitter.checkIsMiuiRom() && !TextUtils.isEmpty(downloadInfo.mExtraInfo)) {
                    try {
                        if (DEBUG_LOG) {
                            Log.d("DownloadNotification", " updateCompletedNotification(Collection<DownloadInfo> downloads) : for (DownloadInfo download : downloads)：\n download = " + DownloadHelper.getDisplayString(downloadInfo));
                        }
                        String optString = new JSONObject(downloadInfo.mExtraInfo).optString("icon", "");
                        if (TextUtils.isEmpty(optString)) {
                            if (DEBUG_LOG) {
                                Log.d("DownloadNotification", " updateCompletedNotification(Collection<DownloadInfo> downloads) : for (DownloadInfo download : downloads)：\n TextUtils.isEmpty(iconUrl)nb.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),\nDownloadHelper.getIconId(title, download.mMimeType)))");
                            }
                            smallIcon.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), DownloadHelper.getIconId(str2, downloadInfo.mMimeType)));
                        } else {
                            Bitmap bitmap = getBitmap(optString);
                            if (bitmap != null) {
                                if (DEBUG_LOG) {
                                    Log.d("DownloadNotification", " updateCompletedNotification(Collection<DownloadInfo> downloads) : for (DownloadInfo download : downloads)：\n if (mNotificationsIconBitmap.containsKey(iconUrl)\n && mNotificationsIconBitmap.get(iconUrl) != null)\nnb.setLargeIcon(iconBitmap)");
                                }
                                smallIcon.setLargeIcon(bitmap);
                            } else {
                                if (DEBUG_LOG) {
                                    Log.d("DownloadNotification", " updateCompletedNotification(Collection<DownloadInfo> downloads) : for (DownloadInfo download : downloads)：\n iconBitmap == null\n nb.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),\nDownloadHelper.getIconId(title, download.mMimeType)))");
                                }
                                smallIcon.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), DownloadHelper.getIconId(str2, downloadInfo.mMimeType)));
                                loadNotificationIcon(this.mContext, optString);
                            }
                        }
                    } finally {
                        if (z) {
                        }
                    }
                }
                Intent intent2 = new Intent(Constants.ACTION_HIDE);
                intent2.setClassName(this.mContext.getPackageName(), DownloadReceiver.class.getName());
                intent2.setData(withAppendedId);
                smallIcon.setDeleteIntent(y.a(this.mContext, 0, intent2, 0));
                this.waitToNotifyComplete.remove(Long.valueOf(downloadInfo.mId));
                if (!checkTopActivityIsFileManagerOrDownloadList) {
                    if (category == 0 || 3 == category || 4 == category || 8 == category) {
                        this.mISystemFacade.postNotification(downloadInfo.mId, smallIcon.build());
                        this.notifiedCompleteNotifications.add(Long.valueOf(downloadInfo.mId));
                        DownloadStatisticUtil.downloadNotificationShow(category, DownloadStatisticConstants.UBC_VALUE_DOWNLOADED);
                    }
                    updateNotificationStatus(withAppendedId);
                }
            }
        }
    }

    private void updateNotificationStatus(Uri uri) {
        Cursor cursor = null;
        try {
            try {
                Cursor query = this.mContext.getContentResolver().query(uri, null, null, null, null);
                if (query == null) {
                    Closeables.closeSafely(query);
                    return;
                }
                try {
                    if (!query.moveToFirst()) {
                        Closeables.closeSafely(query);
                        return;
                    }
                    int i = query.getInt(query.getColumnIndexOrThrow("status"));
                    int i2 = query.getInt(query.getColumnIndexOrThrow("visibility"));
                    if (Downloads.Impl.isStatusCompleted(i) && i2 == 1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("visibility", (Integer) 0);
                        this.mContext.getContentResolver().update(uri, contentValues, null, null);
                    }
                    Closeables.closeSafely(query);
                } catch (Exception e) {
                    e = e;
                    cursor = query;
                    e.printStackTrace();
                    Closeables.closeSafely(cursor);
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
