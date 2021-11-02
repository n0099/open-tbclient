package com.baidu.mobads.container.landingpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class LpCloseReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LP_ACTIVITY_CLOSE_ACTION = "lp_close";
    public transient /* synthetic */ FieldHolder $fh;
    public LpCloseController mController;

    public LpCloseReceiver(LpCloseController lpCloseController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lpCloseController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mController = lpCloseController;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LpCloseController lpCloseController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || !"lp_close".equals(action) || (lpCloseController = this.mController) == null) {
                return;
            }
            lpCloseController.onLpClosed();
        }
    }
}
