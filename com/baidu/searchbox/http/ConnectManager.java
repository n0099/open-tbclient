package com.baidu.searchbox.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ConnectManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ConnectManager";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAirModeOn;
    public String mApn;
    public String mHttpProxyIp;
    public int mHttpProxyPort;
    public String mNetType;
    public int mPort;
    public String mProxy;
    public String mSimOperatorCode;
    public String mSimOperatorName;
    public int mSubType;
    public String mSubTypeName;
    public boolean mUseWap;
    public boolean mVpnOn;
    public String mWifiBSSID;
    public String mWifiSSID;

    public ConnectManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHttpProxyPort = -1;
        checkNetworkType(context);
    }

    private void checkApn(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, networkInfo) == null) {
            if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                if (!lowerCase.startsWith(ConectivityUtils.APN_CMWAP) && !lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) && !lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                    if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        this.mUseWap = true;
                        this.mApn = lowerCase;
                        this.mProxy = "10.0.0.200";
                        this.mPort = 80;
                        return;
                    } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                        this.mUseWap = false;
                        this.mApn = lowerCase;
                        return;
                    }
                } else {
                    this.mUseWap = true;
                    this.mApn = lowerCase;
                    this.mProxy = "10.0.0.172";
                    this.mPort = 80;
                    return;
                }
            }
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost != null && defaultHost.length() > 0) {
                this.mProxy = defaultHost;
                if ("10.0.0.172".equals(defaultHost.trim())) {
                    this.mUseWap = true;
                    this.mPort = 80;
                    return;
                } else if ("10.0.0.200".equals(this.mProxy.trim())) {
                    this.mUseWap = true;
                    this.mPort = 80;
                    return;
                } else {
                    this.mUseWap = false;
                    this.mPort = defaultPort;
                    return;
                }
            }
            this.mUseWap = false;
        }
    }

    private void checkNetworkType(Context context) {
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            try {
                networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (NullPointerException unused) {
                networkInfo = null;
            }
            if (networkInfo != null) {
                if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                    this.mNetType = "wifi";
                    this.mUseWap = false;
                    checkWifi(context);
                } else {
                    checkApn(context, networkInfo);
                    this.mNetType = this.mApn;
                }
                checkSIMCard(context);
                this.mSubType = networkInfo.getSubtype();
                this.mSubTypeName = networkInfo.getSubtypeName();
            }
            this.mHttpProxyIp = System.getProperty("http.proxyHost");
            String property = System.getProperty("http.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                this.mHttpProxyPort = Integer.parseInt(property);
            }
            this.mAirModeOn = isAirModeOn(context);
            this.mVpnOn = isVPNConnected(context);
        }
    }

    private void checkSIMCard(Context context) {
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, context) == null) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return;
        }
        this.mSimOperatorName = telephonyManager.getSimOperatorName();
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null || simOperator.length() < 5) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        try {
            int length = simOperator.length();
            if (length > 6) {
                length = 6;
            }
            for (int i = 0; i < length; i++) {
                if (!Character.isDigit(simOperator.charAt(i))) {
                    if (sb.length() > 0) {
                        break;
                    }
                } else {
                    sb.append(simOperator.charAt(i));
                }
            }
            this.mSimOperatorCode = Integer.valueOf(sb.toString()).toString();
        } catch (Exception unused) {
        }
    }

    @RequiresApi(api = 21)
    public static boolean checkVPN(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || connectivityManager.getNetworkInfo(17) == null) {
                return false;
            }
            return connectivityManager.getNetworkInfo(17).isConnectedOrConnecting();
        }
        return invokeL.booleanValue;
    }

    private void checkWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType() || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                    return;
                }
                this.mWifiBSSID = connectionInfo.getBSSID();
                this.mWifiSSID = connectionInfo.getSSID();
            } catch (Exception unused) {
            }
        }
    }

    public static String getNetworkInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "no";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                String lowerCase = activeNetworkInfo.getExtraInfo() == null ? "none" : activeNetworkInfo.getExtraInfo().toLowerCase();
                StringBuilder sb = new StringBuilder();
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (subtype != 20) {
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            sb.append("2g");
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            sb.append("3g");
                            break;
                        case 13:
                            sb.append("4g");
                            break;
                        default:
                            sb.append(activeNetworkInfo.getTypeName());
                            break;
                    }
                } else {
                    sb.append("5g");
                }
                sb.append("_");
                sb.append(lowerCase);
                sb.append("_");
                sb.append(subtypeName);
                return sb.toString();
            }
            return activeNetworkInfo.getTypeName() + "_" + activeNetworkInfo.getSubtypeName();
        }
        return (String) invokeL.objValue;
    }

    public static boolean isAirModeOn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 : invokeL.booleanValue;
    }

    public static boolean isNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isProxyConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return (TextUtils.isEmpty(System.getProperty("http.proxyHost")) || TextUtils.isEmpty(System.getProperty("http.proxyPort"))) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isVPNConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            boolean checkVPN = Build.VERSION.SDK_INT >= 21 ? checkVPN(context) : false;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                if (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                    Iterator it = Collections.list(networkInterfaces).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return checkVPN;
                    }
                    if (!arrayList.contains("tun0")) {
                        if (!arrayList.contains("ppp0") && !checkVPN) {
                            return false;
                        }
                    }
                    return true;
                }
                return checkVPN;
            } catch (SocketException e) {
                e.printStackTrace();
                return checkVPN;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isWifi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
        }
        return invokeL.booleanValue;
    }

    public boolean airModeOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAirModeOn : invokeV.booleanValue;
    }

    public String getApn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mApn : (String) invokeV.objValue;
    }

    public String getHttpProxyIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mHttpProxyIp : (String) invokeV.objValue;
    }

    public int getHttpProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mHttpProxyPort : invokeV.intValue;
    }

    public String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mNetType : (String) invokeV.objValue;
    }

    public String getProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mProxy : (String) invokeV.objValue;
    }

    public int getProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPort : invokeV.intValue;
    }

    public String getSimOperatorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSimOperatorCode : (String) invokeV.objValue;
    }

    public String getSimOperatorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSimOperatorName : (String) invokeV.objValue;
    }

    public int getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mSubType : invokeV.intValue;
    }

    public String getSubTypeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSubTypeName : (String) invokeV.objValue;
    }

    public String getWifiBSSID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mWifiBSSID : (String) invokeV.objValue;
    }

    public String getWifiSSID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mWifiSSID : (String) invokeV.objValue;
    }

    public boolean isVpnOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mVpnOn : invokeV.booleanValue;
    }

    public boolean isWapNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mUseWap : invokeV.booleanValue;
    }
}
