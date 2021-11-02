package com.baidu.searchbox.ui.animview.praise;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class NetworkMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static String NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public transient /* synthetic */ FieldHolder $fh;
    public ConnectivityManager mConnectivityManager;
    public Context mContext;
    public boolean mIsInit;
    public INetworkMonitorCb mNetworkMonitorCb;
    public ConnectStatusReceiver mReceiver;

    /* loaded from: classes7.dex */
    public static class ConnectStatusReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<INetworkMonitorCb> mINetworkMonitorCb;

        public ConnectStatusReceiver(INetworkMonitorCb iNetworkMonitorCb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iNetworkMonitorCb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mINetworkMonitorCb = new WeakReference<>(iNetworkMonitorCb);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WeakReference<INetworkMonitorCb> weakReference;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || (weakReference = this.mINetworkMonitorCb) == null || weakReference.get() == null) {
                return;
            }
            this.mINetworkMonitorCb.get().onNetworkStateChanged();
        }
    }

    /* loaded from: classes7.dex */
    public interface INetworkMonitorCb {
        void onNetworkStateChanged();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1728549556, "Lcom/baidu/searchbox/ui/animview/praise/NetworkMonitor;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1728549556, "Lcom/baidu/searchbox/ui/animview/praise/NetworkMonitor;");
        }
    }

    public NetworkMonitor(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
        this.mIsInit = false;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mIsInit) {
            return;
        }
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NET_CHANGE_ACTION);
        ConnectStatusReceiver connectStatusReceiver = new ConnectStatusReceiver(this.mNetworkMonitorCb);
        this.mReceiver = connectStatusReceiver;
        this.mContext.registerReceiver(connectStatusReceiver, intentFilter);
        this.mIsInit = true;
    }

    @SuppressLint({"MissingPermission"})
    public boolean isNetworkEnable() {
        InterceptResult invokeV;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsInit && (activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() : invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mIsInit) {
            this.mContext.unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
            this.mConnectivityManager = null;
            this.mIsInit = false;
        }
    }

    public void setNetworkMonitorCb(INetworkMonitorCb iNetworkMonitorCb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iNetworkMonitorCb) == null) {
            this.mNetworkMonitorCb = iNetworkMonitorCb;
        }
    }
}
