package com.baidu.searchbox.downloads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.baidu.android.common.logging.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.boxdownload.ICyberInvoker;
import com.baidu.searchbox.boxdownload.model.DownloadDbItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.ioc.IDownloadDownloadCenter;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.download.util.DownloadNetworkHelper;
import com.baidu.searchbox.download.util.DownloadStatisticUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.searchbox.videoplayer.interfaces.ICyberVideoDownloadManager;
import com.baidu.searchbox.videoplayer.interfaces.VideoSourceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.e80;
/* loaded from: classes3.dex */
public class DownloadConnectivityChangedReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "DownloadConnectivityChangedReceiver";

    /* renamed from: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ long[] val$ids;

        public AnonymousClass3(long[] jArr, Context context) {
            this.val$ids = jArr;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            long[] jArr = this.val$ids;
            if (jArr == null) {
                jArr = DownloadManagerExt.getInstance().getPauseDownloadIds();
            }
            if (jArr != null && jArr.length != 0) {
                long[] filterCyberDownloadOperate = DownloadCenterUtils.filterCyberDownloadOperate(new ICyberInvoker() { // from class: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver.3.1
                    public void invoke(DownloadDbItem downloadDbItem) {
                        VideoSourceInfo videoSourceInfo = new VideoSourceInfo();
                        videoSourceInfo.passthroughJsonStr = downloadDbItem.getExtraInfo();
                        ((ICyberVideoDownloadManager) ServiceManager.getService(ICyberVideoDownloadManager.SERVICE_REFERENCE)).startDownload(downloadDbItem.getBusinessId(), videoSourceInfo);
                    }
                }, jArr);
                if (filterCyberDownloadOperate != null && filterCyberDownloadOperate.length > 0) {
                    DownloadManagerExt.getInstance().resumeDownload(filterCyberDownloadOperate);
                }
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final Activity topActivity = BdBoxActivityManager.getTopActivity();
                            if (topActivity != null) {
                                boolean checkTopActivityIsFileManagerOrDownloadList = IDownloadDownloadCenter.Impl.get().checkTopActivityIsFileManagerOrDownloadList();
                                UniversalToast duration = UniversalToast.makeText(topActivity, (int) R.string.obfuscated_res_0x7f0f05f9).setDuration(5);
                                if (checkTopActivityIsFileManagerOrDownloadList) {
                                    duration.showToastBottom(false);
                                } else {
                                    duration.setToastCallback(new UniversalToast.ToastCallback() { // from class: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver.3.2.1
                                        @Override // com.baidu.android.ext.widget.toast.UniversalToast.ToastCallback
                                        public void onToastClick() {
                                            Intent intent = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
                                            intent.setPackage(AnonymousClass3.this.val$context.getPackageName());
                                            ActivityUtils.startActivitySafely(topActivity, intent);
                                            DownloadStatisticUtil.ubc("tool", "click", "network_change", "", "resume_toast_click", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
                                        }
                                    }).showClickableToast(false, true);
                                }
                                DownloadStatisticUtil.ubc("tool", "show", "network_change", "", "resume_toast", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
                            }
                        } catch (Exception e) {
                            if (DownloadConnectivityChangedReceiver.DEBUG) {
                                Log.w(DownloadConnectivityChangedReceiver.TAG, "DownloadConnectivityChangedReceiver：onDownloadNetworkChange() fail" + e);
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements Runnable {
        public final /* synthetic */ Context val$context;

        public AnonymousClass4(Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            final long[] pauseDownloadIds = DownloadManagerExt.getInstance().getPauseDownloadIds();
            if (pauseDownloadIds != null && pauseDownloadIds.length != 0) {
                long[] filterCyberDownloadOperate = DownloadCenterUtils.filterCyberDownloadOperate(new ICyberInvoker() { // from class: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver.4.1
                    public void invoke(DownloadDbItem downloadDbItem) {
                        ((ICyberVideoDownloadManager) ServiceManager.getService(ICyberVideoDownloadManager.SERVICE_REFERENCE)).pauseDownload(downloadDbItem.getBusinessId());
                    }
                }, pauseDownloadIds);
                if (filterCyberDownloadOperate != null && filterCyberDownloadOperate.length > 0) {
                    DownloadManagerExt.getInstance().pauseDownload(filterCyberDownloadOperate);
                }
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNetworkHelper.putResumeDownloadTaskIds(pauseDownloadIds);
                        try {
                            final Activity topActivity = BdBoxActivityManager.getTopActivity();
                            if (topActivity != null) {
                                boolean checkTopActivityIsFileManagerOrDownloadList = IDownloadDownloadCenter.Impl.get().checkTopActivityIsFileManagerOrDownloadList();
                                UniversalToast duration = UniversalToast.makeText(topActivity, (int) R.string.obfuscated_res_0x7f0f05fa).setDuration(5);
                                if (checkTopActivityIsFileManagerOrDownloadList) {
                                    duration.showToastBottom(false);
                                } else {
                                    duration.setToastCallback(new UniversalToast.ToastCallback() { // from class: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver.4.2.1
                                        @Override // com.baidu.android.ext.widget.toast.UniversalToast.ToastCallback
                                        public void onToastClick() {
                                            Intent intent = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
                                            intent.setPackage(AnonymousClass4.this.val$context.getPackageName());
                                            ActivityUtils.startActivitySafely(topActivity, intent);
                                            DownloadStatisticUtil.ubc("tool", "click", "network_change", "", "confirm_toast_click", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
                                        }
                                    }).showClickableToast(false, true);
                                }
                                DownloadStatisticUtil.ubc("tool", "show", "network_change", "", "confirm_toast", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
                            }
                        } catch (Exception e) {
                            if (DownloadConnectivityChangedReceiver.DEBUG) {
                                Log.w(DownloadConnectivityChangedReceiver.TAG, "DownloadConnectivityChangedReceiver：onDownloadNetworkChange() fail" + e);
                            }
                        }
                    }
                });
            }
        }
    }

    private void onDownloadNetworkChange(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        try {
            if (intent.getAction().equals(NetworkMonitor.NET_CHANGE_ACTION) && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnectedOrConnecting()) {
                if (DEBUG) {
                    Log.v(TAG, "NET CONNECTED");
                }
                if (activeNetworkInfo.getType() == 1) {
                    long[] resumeDownloadTaskIds = DownloadNetworkHelper.getResumeDownloadTaskIds();
                    PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().remove(DownloadNetworkHelper.APPSEARCH_DOWNLOAD_RESUME_IDS_KEY).apply();
                    ExecutorUtilsExt.postOnSerial(new AnonymousClass3(resumeDownloadTaskIds, context), "resumeDownload");
                    return;
                }
                ExecutorUtilsExt.postOnSerial(new AnonymousClass4(context), "pauseDownload");
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.w(TAG, "DownloadConnectivityChangedReceiver：onDownloadNetworkChange() fail" + e);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        e80.a().d("downloadConnectivityChangedReceiver");
        if (intent.getAction().equals(NetworkMonitor.NET_CHANGE_ACTION)) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                if (DEBUG) {
                    Log.v(TAG, "NET CONNECTED");
                }
                try {
                    DSUtils.startDownloadServices(context);
                    ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadApp.Impl.get().startVideoDownload();
                        }
                    }, "startVideoDownload", 0);
                    IDownloadApp.Impl.get().doWebkitJob(context, QuickPersistConfig.getInstance().getBoolean(QuickPersistConfigConst.KEY_KERNEL_WEBKIT_STATE, false));
                } catch (Throwable th) {
                    if (DEBUG) {
                        th.printStackTrace();
                    }
                }
            } else {
                DownloadManagerExt downloadManagerExt = DownloadManagerExt.getInstance();
                Uri webkitUri = IDownloadApp.Impl.get().getWebkitUri(context);
                DownloadBean queryDownloadData = downloadManagerExt.queryDownloadData(webkitUri);
                if (queryDownloadData != null && (queryDownloadData.getDownloadState() == DownloadState.DOWNLOADING || queryDownloadData.getDownloadState() == DownloadState.DOWNLOAD_PAUSED)) {
                    downloadManagerExt.pauseDownload(webkitUri);
                    QuickPersistConfig.getInstance().putBoolean(QuickPersistConfigConst.KEY_KERNEL_WEBKIT_STATE, true);
                    if (DEBUG) {
                        Log.e(TAG, "DownloadConnectivityChangedReceiver.putBoolean(KERNEL_WEBKIT_STATE, true)");
                    }
                }
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.downloads.DownloadConnectivityChangedReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadApp.Impl.get().pauseInstallToAllWithoutManual(context);
                    }
                }, "pause_CommonPluginDownload", 3);
            }
        }
        onDownloadNetworkChange(context, intent);
        e80.a().b("downloadConnectivityChangedReceiver");
    }
}
