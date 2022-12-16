package com.baidu.searchbox.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ConnectManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static long DELAY = 5000;
    public static String NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static volatile ConnectManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isConnected;
    public boolean isWifi;
    public long lastConnectedTime;
    public long lastWifiTime;
    public ConnectivityManager mConnectivityManager;
    public Context mContext;
    public boolean mIsInit;
    public ConncetStatusReceiver mReceiver;

    /* renamed from: com.baidu.searchbox.dns.ConnectManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1854128888, "Lcom/baidu/searchbox/dns/ConnectManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1854128888, "Lcom/baidu/searchbox/dns/ConnectManager;");
        }
    }

    /* loaded from: classes2.dex */
    public class ConncetStatusReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConnectManager this$0;

        public ConncetStatusReceiver(ConnectManager connectManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {connectManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = connectManager;
        }

        public /* synthetic */ ConncetStatusReceiver(ConnectManager connectManager, AnonymousClass1 anonymousClass1) {
            this(connectManager);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                ConnectManager connectManager = this.this$0;
                connectManager.isConnected = connectManager.isNetWorkEnable();
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + this.this$0.isConnected + " isSticky: " + isInitialStickyBroadcast());
                }
                DnsUtil.initNetworkStackType();
                if (this.this$0.isConnected && !isInitialStickyBroadcast()) {
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, "clear dns cache and force update domain");
                    }
                    DnsCacheHelper.getCacheHelper().clear();
                    DnsEngine.forceUpdateDomain();
                }
            }
        }
    }

    public ConnectManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
        this.mIsInit = false;
    }

    public static ConnectManager initInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (mInstance == null) {
                synchronized (ConnectManager.class) {
                    if (mInstance == null) {
                        mInstance = new ConnectManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (ConnectManager) invokeL.objValue;
    }

    public static ConnectManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return mInstance;
        }
        return (ConnectManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNetWorkEnable() {
        InterceptResult invokeV;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            ConnectivityManager connectivityManager = this.mConnectivityManager;
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.mIsInit) {
                    this.mContext.unregisterReceiver(this.mReceiver);
                    this.mIsInit = false;
                }
            }
        }
    }

    public boolean isWifiEnabled() {
        InterceptResult invokeV;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ConnectivityManager connectivityManager = this.mConnectivityManager;
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.mIsInit) {
                    if (this.mContext == null) {
                        this.mContext = AppRuntime.getAppContext();
                    }
                    if (this.mContext == null) {
                        this.mIsInit = false;
                        return;
                    }
                    this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(NET_CHANGE_ACTION);
                    ConncetStatusReceiver conncetStatusReceiver = new ConncetStatusReceiver(this, null);
                    this.mReceiver = conncetStatusReceiver;
                    this.mContext.registerReceiver(conncetStatusReceiver, intentFilter);
                    this.mIsInit = true;
                }
            }
        }
    }

    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (System.currentTimeMillis() - this.lastConnectedTime > DELAY) {
                this.isConnected = isNetWorkEnable();
                this.lastConnectedTime = System.currentTimeMillis();
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " is network connect: " + this.isConnected);
            }
            return this.isConnected;
        }
        return invokeV.booleanValue;
    }

    public boolean isWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (System.currentTimeMillis() - this.lastWifiTime > DELAY) {
                this.isWifi = isWifiEnabled();
                this.lastWifiTime = System.currentTimeMillis();
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " is wifi network: " + this.isWifi);
            }
            return this.isWifi;
        }
        return invokeV.booleanValue;
    }
}
