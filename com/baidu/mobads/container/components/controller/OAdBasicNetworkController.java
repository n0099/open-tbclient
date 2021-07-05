package com.baidu.mobads.container.components.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class OAdBasicNetworkController extends OAdBasicReceivableController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NETWORK_CHANGED = "network_changed";
    public static final String TAG = "BasicNetworkController";
    public transient /* synthetic */ FieldHolder $fh;
    public IntentFilter mFilter;
    public int mNetworkListenerCount;
    public OAdBasicNetworkBroadcastReceiver mReceiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OAdBasicNetworkController(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void onConnectionChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dispatchEvent(new XAdRemoteEvent(NETWORK_CHANGED));
        }
    }

    @Override // com.baidu.mobads.container.components.controller.OAdBasicReceivableController
    public void setBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, broadcastReceiver) == null) {
            this.mReceiver = (OAdBasicNetworkBroadcastReceiver) broadcastReceiver;
        }
    }

    @Override // com.baidu.mobads.container.components.controller.OAdBasicController
    public void startListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mNetworkListenerCount == 0) {
                if (this.mReceiver == null) {
                    setBroadcastReceiver(new OAdBasicNetworkBroadcastReceiver(this));
                }
                IntentFilter intentFilter = new IntentFilter();
                this.mFilter = intentFilter;
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.mNetworkListenerCount++;
            this.mContext.registerReceiver(this.mReceiver, this.mFilter);
        }
    }

    @Override // com.baidu.mobads.container.components.controller.OAdBasicController
    public void stopListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mNetworkListenerCount = 0;
            try {
                this.mContext.unregisterReceiver(this.mReceiver);
            } catch (Exception unused) {
            }
        }
    }
}
