package com.baidu.mobads.container.landingpage;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.components.command.OAdRemoteApkDownloaderObserver;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownTaskActivity implements IActivityImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DownTaskActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public RemoteXAdLogger mAdLogger;
    public Activity mProxyActivity;

    public DownTaskActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdLogger = RemoteXAdLogger.getInstance();
    }

    private void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mProxyActivity.finish();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
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
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            this.mProxyActivity = activity;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jSONObject) == null) {
        }
    }
}
