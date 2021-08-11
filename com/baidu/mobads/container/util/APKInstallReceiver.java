package com.baidu.mobads.container.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class APKInstallReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public APKInstallReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            String action = intent.getAction();
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d("APKInstallReceiver", "action Receiver :" + action + ", pkg:" + intent.getStringExtra(AsInstallService.SCHEME_PACKAGE_ADDED));
            if ((PackageChangedReceiver.ACTION_INSTALL.equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action) || PackageChangedReceiver.ACTION_UNINSTALL.equals(action)) && !TextUtils.isEmpty(intent.getDataString())) {
                RemoteXAdLogger remoteXAdLogger2 = RemoteXAdLogger.getInstance();
                remoteXAdLogger2.d("APKInstallReceiver", "updateStateByBroadCast:" + intent.getAction() + ", package:" + intent.getDataString());
                APKStateManager.getInstance().actionToSniffByBroadCast(context, intent.getDataString().substring(8));
            }
        }
    }
}
