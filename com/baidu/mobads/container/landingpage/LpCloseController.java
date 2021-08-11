package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.mobads.container.util.XAdRemoteEventDispatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LpCloseController extends XAdRemoteEventDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public static LpCloseController sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public LpCloseReceiver mReceiver;

    public LpCloseController(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
    }

    public static LpCloseController getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (sInstance == null) {
                synchronized (LpCloseController.class) {
                    if (sInstance == null) {
                        sInstance = new LpCloseController(context);
                    }
                }
            }
            return sInstance;
        }
        return (LpCloseController) invokeL.objValue;
    }

    public void onLpClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dispatchEvent(new XAdRemoteEvent("AdLpClosed"));
            getInstance(this.mContext).removeEventListeners("AdLpClosed");
            getInstance(this.mContext).stopListener();
        }
    }

    public void startListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.mReceiver == null) {
                    this.mReceiver = new LpCloseReceiver(this);
                }
                if (this.mContext != null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("lp_close");
                    this.mContext.registerReceiver(this.mReceiver, intentFilter);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void stopListener() {
        Context context;
        LpCloseReceiver lpCloseReceiver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (context = this.mContext) == null || (lpCloseReceiver = this.mReceiver) == null) {
            return;
        }
        try {
            context.unregisterReceiver(lpCloseReceiver);
            this.mReceiver = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
