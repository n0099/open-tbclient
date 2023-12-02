package com.baidu.searchbox;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.MigrateStatisticConstants;
import com.baidu.searchbox.download.ioc.IDownloadSetting;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.settings.base.UpdatePackageDownloadInfo;
import com.baidu.tieba.R;
import java.io.File;
import org.apache.commons.codec.digest4util.MD5Utils;
/* loaded from: classes3.dex */
public class DownloadInstallReceiver extends OpenDownloadReceiver {
    /* JADX INFO: Access modifiers changed from: private */
    public void installPackage(Context context, String str) {
        try {
            try {
                Uri.parse(str);
                IDownloadSetting.Impl.get().installClientUpdateApk(context, str);
            } catch (Exception unused) {
                UniversalToast.makeText(context.getApplicationContext(), (int) R.string.obfuscated_res_0x7f0f17c8).setDuration(3).showToast();
            }
        } catch (Throwable th) {
            if (AppConfig.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007f A[Catch: all -> 0x00c7, Exception -> 0x00ca, TRY_LEAVE, TryCatch #4 {Exception -> 0x00ca, all -> 0x00c7, blocks: (B:8:0x002a, B:10:0x0030, B:12:0x0042, B:14:0x0048, B:16:0x004e, B:18:0x006a, B:20:0x0074, B:22:0x007f, B:25:0x0096, B:27:0x00a0, B:29:0x00a6, B:30:0x00b8), top: B:49:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0 A[Catch: all -> 0x00c7, Exception -> 0x00ca, TryCatch #4 {Exception -> 0x00ca, all -> 0x00c7, blocks: (B:8:0x002a, B:10:0x0030, B:12:0x0042, B:14:0x0048, B:16:0x004e, B:18:0x006a, B:20:0x0074, B:22:0x007f, B:25:0x0096, B:27:0x00a0, B:29:0x00a6, B:30:0x00b8), top: B:49:0x002a }] */
    @Override // com.baidu.searchbox.OpenDownloadReceiver, android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        int i;
        UpdatePackageDownloadInfo fullUpdateDownloadInfo;
        File file;
        super.onReceive(context, intent);
        Context applicationContext = context.getApplicationContext();
        ContentResolver contentResolver = context.getContentResolver();
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        Cursor cursor = null;
        final String string = null;
        cursor = null;
        try {
            try {
                Cursor query = contentResolver.query(data, new String[]{"_id", "_data", "mimetype", "status"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            string = query.getString(query.getColumnIndex("_data"));
                            i = query.getInt(query.getColumnIndex("status"));
                            if (Downloads.isStatusCompleted(i) && Downloads.isStatusSuccess(i)) {
                                MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_DOWNLOAD_COMPLETE_TYPE, MigrateStatisticUtils.build(""));
                                IDownloadSetting.Impl.get().doDownloadedNormalStatistic();
                                UpdatePackageDownloadInfo updateDownloadInfo = IDownloadSetting.Impl.get().getUpdateDownloadInfo(context);
                                if (string != null && IDownloadSetting.Impl.get().needPatch(context, data, updateDownloadInfo)) {
                                    file = new File(string);
                                    if (file.exists()) {
                                        IDownloadSetting.Impl.get().asyncInstallPatchPackage(context, ContentUris.parseId(data), file, updateDownloadInfo);
                                        IDownloadSetting.Impl.get().doInstallNormalStatistic();
                                        Closeables.closeSafely(query);
                                        return;
                                    }
                                }
                                fullUpdateDownloadInfo = IDownloadSetting.Impl.get().getFullUpdateDownloadInfo(context);
                                if (fullUpdateDownloadInfo != null) {
                                    final String patchMd5 = fullUpdateDownloadInfo.getPatchMd5();
                                    if (patchMd5 == null) {
                                        installPackage(applicationContext, string);
                                        IDownloadSetting.Impl.get().clearFullUpdateDownloadInfo(context);
                                        IDownloadSetting.Impl.get().doInstallNormalStatistic();
                                    } else {
                                        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.DownloadInstallReceiver.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                String md5 = MD5Utils.toMd5(new File(string), false);
                                                if (TextUtils.equals(patchMd5, md5)) {
                                                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.DownloadInstallReceiver.1.1
                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            DownloadInstallReceiver.this.installPackage(AppRuntime.getAppContext(), string);
                                                            IDownloadSetting.Impl.get().clearFullUpdateDownloadInfo(AppRuntime.getAppContext());
                                                            IDownloadSetting.Impl.get().doInstallNormalStatistic();
                                                        }
                                                    });
                                                    return;
                                                }
                                                DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), string, (String) null);
                                                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.DownloadInstallReceiver.1.2
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        UniversalToast.makeText(AppRuntime.getAppContext(), AppRuntime.getAppContext().getResources().getText(R.string.obfuscated_res_0x7f0f17cd)).showToast();
                                                    }
                                                });
                                                MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UDPATE_VALID_FAILED_TYPE, MigrateStatisticUtils.build(md5));
                                            }
                                        }, "CheckMD5InstallAPK", 1);
                                    }
                                }
                            }
                            Closeables.closeSafely(query);
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor = query;
                        if (AppConfig.isDebug()) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                }
                i = 0;
                if (Downloads.isStatusCompleted(i)) {
                    MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_DOWNLOAD_COMPLETE_TYPE, MigrateStatisticUtils.build(""));
                    IDownloadSetting.Impl.get().doDownloadedNormalStatistic();
                    UpdatePackageDownloadInfo updateDownloadInfo2 = IDownloadSetting.Impl.get().getUpdateDownloadInfo(context);
                    if (string != null) {
                        file = new File(string);
                        if (file.exists()) {
                        }
                    }
                    fullUpdateDownloadInfo = IDownloadSetting.Impl.get().getFullUpdateDownloadInfo(context);
                    if (fullUpdateDownloadInfo != null) {
                    }
                }
                Closeables.closeSafely(query);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
