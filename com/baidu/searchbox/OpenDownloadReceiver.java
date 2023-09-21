package com.baidu.searchbox;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.media.ImageScanner;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.constants.MigrateStatisticConstants;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils;
import com.baidu.searchbox.download.statistics.DownloadActionModel;
import com.baidu.searchbox.download.util.ApkInstallCallBack;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.searchbox.download.util.DownloadStatisticUtil;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ng.browser.init.BlinkInitHelper;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.a20;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OpenDownloadReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String DOC_CONVERT_DOWNLOAD_SOURCE = "docConvert";
    public static final String EXTRA_TYPE_KEY = "category_type";
    public Context mContext;

    /* renamed from: com.baidu.searchbox.OpenDownloadReceiver$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$filePath;

        public AnonymousClass4(String str, Context context) {
            this.val$filePath = str;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApkUtil.installApk(this.val$filePath, new ApkInstallCallBack() { // from class: com.baidu.searchbox.OpenDownloadReceiver.4.1
                @Override // com.baidu.searchbox.download.util.ApkInstallCallBack
                public void onResult(boolean z) {
                    if (!z) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.OpenDownloadReceiver.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                UniversalToast.makeText(AnonymousClass4.this.val$context.getApplicationContext(), (int) R.string.obfuscated_res_0x7f0f05df).setDuration(3).showToast();
                            }
                        });
                    }
                }
            });
        }
    }

    public static boolean checkPluginDownloaded(Context context, Uri uri, String str) {
        DownloadBean queryDownloadData = DownloadManagerExt.getInstance().queryDownloadData(uri);
        if (queryDownloadData == null || queryDownloadData.getCurrentBytes() <= 0 || queryDownloadData.getTotalBytes() != queryDownloadData.getCurrentBytes()) {
            return false;
        }
        return IDownloadApp.Impl.get().doCheckPluginDownloadedJob(context, uri, str);
    }

    private void openFileManagerActivity(Context context) {
        Intent buildDownloadIntent = IDownloadApp.Impl.get().buildDownloadIntent(context, new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
        buildDownloadIntent.setPackage(context.getPackageName());
        buildDownloadIntent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        ActivityUtils.startActivitySafely(context, buildDownloadIntent);
    }

    private void doCloudStatisticJob(long j, String str, String str2, String str3) {
        DownloadActionModel downloadActionModel = new DownloadActionModel();
        downloadActionModel.downloadId = j;
        downloadActionModel.fileName = str;
        downloadActionModel.mimeType = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        downloadActionModel.extraInfo = str3;
        ApkCloudStatisticsUtils.doApkSuccessCloudStatisticJob(downloadActionModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r4.delete(r6, "_data = " + android.database.DatabaseUtils.sqlEscapeString(r5), null) <= 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean deleteFile(ContentResolver contentResolver, String str, String str2) {
        Uri uri;
        if (str2.startsWith("image")) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (str2.startsWith("audio")) {
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else if (str2.startsWith("video")) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = null;
        }
        if (uri != null) {
        }
        if (new File(str).delete()) {
            return true;
        }
        return false;
    }

    private boolean openFile(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null && Build.VERSION.SDK_INT < 24) {
            parse = Uri.fromFile(new File(str));
        }
        intent.setDataAndType(parse, str2);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        ActivityUtils.processFileUriIntent(context, new File(str), intent);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            UniversalToast.makeText(context.getApplicationContext(), (int) R.string.obfuscated_res_0x7f0f05df).setDuration(3).showToast();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOpenEvent(Context context, String str, boolean z, int i, String str2, final String str3, final String str4, final Uri uri, int i2, String str5, String str6, long j, String str7) {
        if (Downloads.ACTION_NOTIFICATION_CLICKED.equals(str)) {
            if (z) {
                DownloadStatisticUtil.downloadNotificationClick(i, DownloadStatisticConstants.UBC_VALUE_DOWNLOADED);
                if (i != 8 && i != 11) {
                    switch (i) {
                        case 0:
                        case 1:
                        case 2:
                        case 4:
                        case 5:
                        case 6:
                            break;
                        case 3:
                            if (TextUtils.isEmpty(str2)) {
                                installApk(context, str3);
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(str2);
                                String optString = jSONObject.optString("package", "");
                                if (ApkUtil.hasInstalled(context, optString, jSONObject.optString("versioncode", "-1"))) {
                                    ApkUtil.openApp(context, optString);
                                    return;
                                } else {
                                    installApk(context, str3);
                                    return;
                                }
                            } catch (Exception e) {
                                if (Constants.LOGVV) {
                                    e.printStackTrace();
                                }
                                installApk(context, str3);
                                return;
                            }
                        default:
                            openFile(context, str3, str4);
                            return;
                    }
                }
                openFileManagerActivity(context);
                return;
            }
            if (TextUtils.equals(str4, IDownloadApp.Impl.get().getStoryMimeType())) {
                BlinkInitHelper.getInstance(context).initBWebkit();
                Intent intent = new Intent(IntentConstants.ACTION_HOME);
                intent.setPackage(context.getPackageName());
                intent.putExtra(DownloadConstants.INTENT_FRAGMENT_NAME_KEY, DownloadConstants.PROTOCOL_NOVEL_NAME);
                Intent putNovelExtra = IDownloadApp.Impl.get().putNovelExtra(intent);
                putNovelExtra.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                context.startActivity(putNovelExtra);
            } else {
                openFileManagerActivity(context);
            }
            MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_NOTIFICATION_DOWNLOAD_LAUNCH_TYPE, MigrateStatisticUtils.build(""));
        } else if ("android.intent.action.DELETE".equals(str)) {
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.OpenDownloadReceiver.3
                @Override // java.lang.Runnable
                public void run() {
                    ContentResolver contentResolver = OpenDownloadReceiver.this.mContext.getContentResolver();
                    if (OpenDownloadReceiver.this.deleteFile(contentResolver, str3, str4)) {
                        contentResolver.delete(uri, null, null);
                    }
                }
            }, "deleteFile");
        } else {
            if (AppConfig.isDebug()) {
                Log.d("OpenDownloadReceiver", "download finished: " + uri);
            }
            if (z) {
                long parseId = ContentUris.parseId(uri);
                if (i2 != 0) {
                    SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).sendDownloadMsg(parseId, str3, str4, str5, str6, j, str2, str7);
                } else if (isDocConvertDownload(i, str7)) {
                    ImageScanner.scanFile(AppRuntime.getAppContext(), new String[]{str3}, new String[]{str4}, null);
                }
                IDownloadApp.Impl.get().downloadedUBCSend(str3, str4, str2);
                if (ApkCloudStatisticsUtils.enableAppsearchCloudStatic()) {
                    doCloudStatisticJob(parseId, str3, str4, str2);
                }
                a20.j(parseId);
            }
        }
    }

    private void installApk(Context context, String str) {
        ExecutorUtilsExt.postOnElastic(new AnonymousClass4(str, context), "OpenDownloadReceiverparseInstallPackageInfo", 2);
    }

    private boolean isDocConvertDownload(int i, String str) {
        if (4 == i && DOC_CONVERT_DOWNLOAD_SOURCE.equals(str)) {
            return true;
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        this.mContext = context;
        final Uri data = intent.getData();
        if (data == null) {
            return;
        }
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.OpenDownloadReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                OpenDownloadReceiver.this.queryFromDB(data, intent);
            }
        }, "queryFromDB");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8 A[Catch: all -> 0x00df, TRY_LEAVE, TryCatch #7 {all -> 0x00df, blocks: (B:3:0x0009, B:35:0x00e2, B:37:0x00e8), top: B:42:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void queryFromDB(final Uri uri, Intent intent) {
        Cursor cursor;
        final boolean z;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = this.mContext.getContentResolver().query(uri, new String[]{"_id", "_data", "mimetype", "status", "title", Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Downloads.Impl.COLUMN_BOUNDARY, Downloads.Impl.COLUMN_DOWNLOAD_MOD, "extra_info", "source"}, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        final String string = query.getString(query.getColumnIndex("_data"));
                        final String string2 = query.getString(query.getColumnIndex("mimetype"));
                        final int category = FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(string), string2);
                        final String action = intent.getAction();
                        int i = query.getInt(query.getColumnIndex("status"));
                        try {
                            if (Downloads.isStatusCompleted(i)) {
                                try {
                                    if (Downloads.isStatusSuccess(i)) {
                                        z = true;
                                        final String string3 = query.getString(query.getColumnIndex("extra_info"));
                                        final int i2 = query.getInt(query.getColumnIndexOrThrow(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI));
                                        final String string4 = query.getString(query.getColumnIndex("title"));
                                        final String string5 = query.getString(query.getColumnIndex(Downloads.Impl.COLUMN_BOUNDARY));
                                        final long j = query.getLong(query.getColumnIndex(Downloads.Impl.COLUMN_DOWNLOAD_MOD));
                                        final String string6 = query.getString(query.getColumnIndex("source"));
                                        cursor = query;
                                        UiThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.OpenDownloadReceiver.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                OpenDownloadReceiver openDownloadReceiver = OpenDownloadReceiver.this;
                                                openDownloadReceiver.handleOpenEvent(openDownloadReceiver.mContext, action, z, category, string3, string, string2, uri, i2, string4, string5, j, string6);
                                            }
                                        });
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    cursor2 = query;
                                    if (AppConfig.isDebug()) {
                                    }
                                    Closeables.closeSafely(cursor2);
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = query;
                                    Closeables.closeSafely(cursor2);
                                    throw th;
                                }
                            }
                            UiThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.OpenDownloadReceiver.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    OpenDownloadReceiver openDownloadReceiver = OpenDownloadReceiver.this;
                                    openDownloadReceiver.handleOpenEvent(openDownloadReceiver.mContext, action, z, category, string3, string, string2, uri, i2, string4, string5, j, string6);
                                }
                            });
                        } catch (Exception e2) {
                            e = e2;
                            cursor2 = cursor;
                            if (AppConfig.isDebug()) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor2);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = cursor;
                            Closeables.closeSafely(cursor2);
                            throw th;
                        }
                        z = false;
                        final String string32 = query.getString(query.getColumnIndex("extra_info"));
                        final int i22 = query.getInt(query.getColumnIndexOrThrow(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI));
                        final String string42 = query.getString(query.getColumnIndex("title"));
                        final String string52 = query.getString(query.getColumnIndex(Downloads.Impl.COLUMN_BOUNDARY));
                        final long j2 = query.getLong(query.getColumnIndex(Downloads.Impl.COLUMN_DOWNLOAD_MOD));
                        final String string62 = query.getString(query.getColumnIndex("source"));
                        cursor = query;
                    } else {
                        cursor = query;
                    }
                    Closeables.closeSafely(cursor);
                } catch (Exception e3) {
                    e = e3;
                    cursor = query;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
