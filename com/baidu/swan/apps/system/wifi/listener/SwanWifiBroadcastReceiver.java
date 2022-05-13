package com.baidu.swan.apps.system.wifi.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lb3;
import com.repackage.mb3;
import com.repackage.nb3;
/* loaded from: classes2.dex */
public class SwanWifiBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lb3 mConnectListener;
    public mb3 mConnectSuccessListener;
    public boolean mIsRegistered;
    public boolean mIsWifiDisconnected;
    public nb3 mScanListener;
    public WifiManager mWifiManager;

    public SwanWifiBroadcastReceiver(WifiManager wifiManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wifiManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        char c;
        lb3 lb3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        int hashCode = action.hashCode();
        if (hashCode == -343630553) {
            if (action.equals(McastConfig.ACTION_NETWORK_STATE_CHANGED)) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 233521600) {
            if (hashCode == 1878357501 && action.equals("android.net.wifi.SCAN_RESULTS")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (action.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            nb3 nb3Var = this.mScanListener;
            if (nb3Var != null) {
                nb3Var.a(this.mWifiManager.getScanResults());
            }
        } else if (c == 1) {
            if (intent.getIntExtra("supplicantError", -1) != 1 || (lb3Var = this.mConnectListener) == null) {
                return;
            }
            lb3Var.onError(1);
        } else if (c != 2) {
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
            WifiInfo wifiInfo = (WifiInfo) intent.getParcelableExtra("wifiInfo");
            if (parcelableExtra != null && ((NetworkInfo) parcelableExtra).getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                if (!this.mIsWifiDisconnected) {
                    return;
                }
                lb3 lb3Var2 = this.mConnectListener;
                if (lb3Var2 != null) {
                    lb3Var2.a(wifiInfo);
                }
                mb3 mb3Var = this.mConnectSuccessListener;
                if (mb3Var != null && this.mIsWifiDisconnected) {
                    mb3Var.a(wifiInfo);
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

    public void setConnectListener(lb3 lb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lb3Var) == null) {
            this.mConnectListener = lb3Var;
        }
    }

    public void setConnectSuccessListener(mb3 mb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mb3Var) == null) {
            this.mConnectSuccessListener = mb3Var;
        }
    }

    public void setScanListener(nb3 nb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nb3Var) == null) {
            this.mScanListener = nb3Var;
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
