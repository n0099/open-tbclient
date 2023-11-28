package com.baidu.tbadk.commonReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.downloadball.DownloadFloatBallManager;
import com.baidu.tieba.ts5;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.tieba.ws5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PackageChangedReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_INSTALL = "android.intent.action.PACKAGE_ADDED";
    public static final String ACTION_UNINSTALL = "android.intent.action.PACKAGE_REMOVED";
    public transient /* synthetic */ FieldHolder $fh;

    public PackageChangedReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null) {
            return;
        }
        if (ACTION_INSTALL.equals(intent.getAction())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002501, intent));
            ts5.a().b(intent);
            AdApkInstallHelper.b(intent);
            DownloadFloatBallManager.l().p(intent);
        } else if (ACTION_UNINSTALL.equals(intent.getAction())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002502, intent));
        }
        ws5.r(intent);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002504, intent));
    }
}
