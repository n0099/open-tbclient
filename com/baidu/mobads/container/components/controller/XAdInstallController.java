package com.baidu.mobads.container.components.controller;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.controller.InstallReceiver;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class XAdInstallController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "XAdInstallController";
    public static XAdInstallController mAdInstallController;
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteXAdLogger mAdLogger;
    public HashMap<String, InstallReceiver> mReceiverList;
    public HashMap<String, Boolean> mRegisterList;

    public XAdInstallController() {
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
        this.mReceiverList = new HashMap<>();
        this.mRegisterList = new HashMap<>();
        this.mAdLogger = RemoteXAdLogger.getInstance();
    }

    public static XAdInstallController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mAdInstallController == null) {
                synchronized (XAdInstallController.class) {
                    if (mAdInstallController == null) {
                        mAdInstallController = new XAdInstallController();
                    }
                }
            }
            return mAdInstallController;
        }
        return (XAdInstallController) invokeV.objValue;
    }

    private void startListener(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, this, context, str) == null) && context != null && this.mReceiverList.containsKey(str)) {
            if (this.mRegisterList.containsKey(str) && this.mRegisterList.get(str).booleanValue()) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                context.registerReceiver(this.mReceiverList.get(str), intentFilter);
                this.mRegisterList.put(str, Boolean.TRUE);
            } catch (Exception unused) {
                this.mAdLogger.e(TAG, "Install controller start failed.");
            }
        }
    }

    public void registerInstallReceiver(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, xAdRemoteAPKDownloadExtraInfo) == null) || context == null || xAdRemoteAPKDownloadExtraInfo == null) {
            return;
        }
        String str = xAdRemoteAPKDownloadExtraInfo.packageName;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mReceiverList.containsKey(str)) {
            this.mReceiverList.get(str).updateExtraInfo(xAdRemoteAPKDownloadExtraInfo);
        } else {
            this.mReceiverList.put(str, new InstallReceiver(xAdRemoteAPKDownloadExtraInfo));
        }
        startListener(context, str);
    }

    public void setInstallListener(String str, InstallReceiver.InstallListener installListener) {
        InstallReceiver installReceiver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, installListener) == null) || TextUtils.isEmpty(str) || !this.mReceiverList.containsKey(str) || (installReceiver = this.mReceiverList.get(str)) == null) {
            return;
        }
        installReceiver.addInstallListener(installListener);
    }

    public void stopListener(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) && context != null && this.mReceiverList.containsKey(str)) {
            try {
                context.unregisterReceiver(this.mReceiverList.get(str));
                this.mRegisterList.remove(str);
                this.mReceiverList.remove(str);
            } catch (Exception unused) {
                this.mAdLogger.d(TAG, "Install controller stop failed.");
            }
        }
    }
}
