package com.baidu.swan.apps.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCallback;
    public WeakReference<CallbackHandler> mCallbackHandlerWeakRef;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2080550027, "Lcom/baidu/swan/apps/network/NetworkBroadcastReceiver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2080550027, "Lcom/baidu/swan/apps/network/NetworkBroadcastReceiver;");
                return;
            }
        }
        DEBUG = k.a;
    }

    public NetworkBroadcastReceiver(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callbackHandler, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCallbackHandlerWeakRef = new WeakReference<>(callbackHandler);
        this.mCallback = str;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || context == null || intent == null || "android.net.conn.CONNECTIVITY_CHANGE" != intent.getAction() || TextUtils.isEmpty(this.mCallback) || isInitialStickyBroadcast()) {
            return;
        }
        boolean z = DEBUG;
        SwanAppNetworkUtils.k(context, this.mCallbackHandlerWeakRef.get(), this.mCallback);
    }

    public void updateCallback(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str) == null) {
            this.mCallbackHandlerWeakRef = new WeakReference<>(callbackHandler);
            this.mCallback = str;
        }
    }
}
