package com.baidu.swan.apps.system.wifi.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import c.a.r0.a.r2.l.b.a;
import c.a.r0.a.r2.l.b.b;
import c.a.r0.a.r2.l.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SwanWifiBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mConnectListener;
    public b mConnectSuccessListener;
    public boolean mIsRegistered;
    public boolean mIsWifiDisconnected;
    public c mScanListener;
    public WifiManager mWifiManager;

    public SwanWifiBroadcastReceiver(WifiManager wifiManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wifiManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsWifiDisconnected = true;
        this.mIsRegistered = false;
        this.mWifiManager = wifiManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        char c2;
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        int hashCode = action.hashCode();
        if (hashCode == -343630553) {
            if (action.equals(McastConfig.ACTION_NETWORK_STATE_CHANGED)) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 233521600) {
            if (hashCode == 1878357501 && action.equals("android.net.wifi.SCAN_RESULTS")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (action.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            c cVar = this.mScanListener;
            if (cVar != null) {
                cVar.a(this.mWifiManager.getScanResults());
            }
        } else if (c2 == 1) {
            if (intent.getIntExtra("supplicantError", -1) != 1 || (aVar = this.mConnectListener) == null) {
                return;
            }
            aVar.onError(1);
        } else if (c2 != 2) {
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
            WifiInfo wifiInfo = (WifiInfo) intent.getParcelableExtra("wifiInfo");
            if (parcelableExtra != null && ((NetworkInfo) parcelableExtra).getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                if (!this.mIsWifiDisconnected) {
                    return;
                }
                a aVar2 = this.mConnectListener;
                if (aVar2 != null) {
                    aVar2.a(wifiInfo);
                }
                b bVar = this.mConnectSuccessListener;
                if (bVar != null && this.mIsWifiDisconnected) {
                    bVar.a(wifiInfo);
                }
                this.mIsWifiDisconnected = false;
            }
            if (parcelableExtra == null || ((NetworkInfo) parcelableExtra).getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) {
                return;
            }
            this.mIsWifiDisconnected = true;
        }
    }

    public synchronized void registerSelf(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            synchronized (this) {
                if (context != null) {
                    if (!this.mIsRegistered) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
                        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                        intentFilter.addAction(McastConfig.ACTION_NETWORK_STATE_CHANGED);
                        context.registerReceiver(this, intentFilter);
                        this.mIsRegistered = true;
                    }
                }
            }
        }
    }

    public void setConnectListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.mConnectListener = aVar;
        }
    }

    public void setConnectSuccessListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.mConnectSuccessListener = bVar;
        }
    }

    public void setScanListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.mScanListener = cVar;
        }
    }

    public synchronized void unregisterSelf(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            synchronized (this) {
                if (context != null) {
                    if (this.mIsRegistered) {
                        context.unregisterReceiver(this);
                        this.mIsRegistered = false;
                    }
                }
            }
        }
    }
}
