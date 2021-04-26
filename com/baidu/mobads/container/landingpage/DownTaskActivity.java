package com.baidu.mobads.container.landingpage;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.components.command.OAdRemoteApkDownloaderObserver;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.sdk.api.IActivityImpl;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DownTaskActivity implements IActivityImpl {
    public static final String TAG = "DownTaskActivity";
    public RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();
    public Activity mProxyActivity;

    private void finishActivity() {
        this.mProxyActivity.finish();
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        NetworkInfo activeNetworkInfo;
        Activity activity = this.mProxyActivity;
        if (activity == null) {
            finishActivity();
            return;
        }
        Intent intent = activity.getIntent();
        if (intent == null || !intent.getBooleanExtra("dealWithDownload", false)) {
            return;
        }
        int intExtra = intent.getIntExtra("status", -1);
        String stringExtra = intent.getStringExtra("pk");
        boolean booleanExtra = intent.getBooleanExtra("pausedManually", false);
        IDownloader adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(stringExtra);
        RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
        remoteXAdLogger.d(TAG, "dealWithDownload now: status=" + intExtra + ";pk=" + stringExtra + ";downloader=" + adsApkDownloader);
        if (adsApkDownloader != null && adsApkDownloader.getState() != null) {
            intExtra = adsApkDownloader.getState().getCode();
        }
        if (intExtra == IDownloader.DownloadStatus.COMPLETED.getCode()) {
            String stringExtra2 = intent.getStringExtra("localApkPath");
            if (AdDownloadApkUtils.isInstalled(this.mProxyActivity, stringExtra)) {
                OpenAppUtils.openApp(this.mProxyActivity, stringExtra);
            } else {
                File file = new File(stringExtra2);
                if (file.exists() && file.length() > 0) {
                    Intent installIntent = AppUtils.getInstallIntent(this.mProxyActivity, stringExtra2);
                    if (installIntent != null) {
                        this.mProxyActivity.startActivity(installIntent);
                    } else {
                        this.mAdLogger.i(TAG, "启动activity失败");
                    }
                } else {
                    RemoteXAdLogger remoteXAdLogger2 = this.mAdLogger;
                    remoteXAdLogger2.d(TAG, "文件[" + stringExtra2 + "] 已经被删除");
                }
            }
            OAdRemoteApkDownloaderObserver globalDownloadObserver = OAdRemoteApkDownloaderObserver.getGlobalDownloadObserver(stringExtra);
            if (globalDownloadObserver != null) {
                globalDownloadObserver.clearNotification();
            }
        } else if (intExtra != IDownloader.DownloadStatus.ERROR.getCode() && intExtra != IDownloader.DownloadStatus.PAUSED.getCode()) {
            if ((intExtra == IDownloader.DownloadStatus.DOWNLOADING.getCode() || intExtra == IDownloader.DownloadStatus.INITING.getCode()) && adsApkDownloader != null) {
                adsApkDownloader.setPausedManually(true);
                adsApkDownloader.pause();
            }
        } else {
            if (!booleanExtra && (activeNetworkInfo = ((ConnectivityManager) this.mProxyActivity.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 0) {
                XAdRemoteCommonUtils.setMobileConfirmed(stringExtra);
                if (adsApkDownloader != null) {
                    adsApkDownloader.setDownloadOnlyWifi(false);
                }
            }
            if (adsApkDownloader != null) {
                adsApkDownloader.resume();
            }
        }
        finishActivity();
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i2, int i3) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.mProxyActivity = activity;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
    }
}
