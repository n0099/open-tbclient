package com.baidu.searchbox.network.outback;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ConnectManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ConnectManager";
    public static String sClientIP;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAirModeOn;
    public String mApn;
    public String mHttpProxyIp;
    public int mHttpProxyPort;
    public String mNetType;
    public int mPort;
    public String mProxy;
    public int mSubType;
    public String mSubTypeName;
    public boolean mUseWap;
    public boolean mVpnOn;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class NetworkStateEnum {
        public static final /* synthetic */ NetworkStateEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetworkStateEnum NO;
        public static final NetworkStateEnum UNKNOWN;
        public static final NetworkStateEnum WIFI;
        public static final NetworkStateEnum _2G;
        public static final NetworkStateEnum _3G;
        public static final NetworkStateEnum _4G;
        public static final NetworkStateEnum _5G;
        public transient /* synthetic */ FieldHolder $fh;
        public final String name;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(779248235, "Lcom/baidu/searchbox/network/outback/ConnectManager$NetworkStateEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(779248235, "Lcom/baidu/searchbox/network/outback/ConnectManager$NetworkStateEnum;");
                    return;
                }
            }
            NO = new NetworkStateEnum(HlsPlaylistParser.BOOLEAN_FALSE, 0, "no");
            WIFI = new NetworkStateEnum("WIFI", 1, "wifi");
            _2G = new NetworkStateEnum("_2G", 2, "2g");
            _3G = new NetworkStateEnum("_3G", 3, "3g");
            _4G = new NetworkStateEnum("_4G", 4, "4g");
            _5G = new NetworkStateEnum("_5G", 5, "5g");
            NetworkStateEnum networkStateEnum = new NetworkStateEnum(RomUtils.UNKNOWN, 6, "unknown");
            UNKNOWN = networkStateEnum;
            $VALUES = new NetworkStateEnum[]{NO, WIFI, _2G, _3G, _4G, _5G, networkStateEnum};
        }

        public NetworkStateEnum(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.name = str2;
        }

        public static NetworkStateEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (NetworkStateEnum) Enum.valueOf(NetworkStateEnum.class, str);
            }
            return (NetworkStateEnum) invokeL.objValue;
        }

        public static NetworkStateEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (NetworkStateEnum[]) $VALUES.clone();
            }
            return (NetworkStateEnum[]) invokeV.objValue;
        }
    }

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

    private void checkApn(NetworkInfo networkInfo) {
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, networkInfo) == null) {
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
                networkInfo = getInfo(context);
            } catch (NullPointerException unused) {
                networkInfo = null;
            }
            if (networkInfo != null) {
                if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                    this.mNetType = "wifi";
                    this.mUseWap = false;
                } else {
                    checkApn(networkInfo);
                    this.mNetType = this.mApn;
                }
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

    public static boolean isVPNConnected(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    if (networkInterface.isUp()) {
                        arrayList.add(networkInterface.getName());
                    }
                }
            } catch (NullPointerException | SocketException e) {
                e.printStackTrace();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                z = checkVPN(context);
            } else {
                z = false;
            }
            if (!arrayList.contains("tun0") && !arrayList.contains("ppp0") && !z) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkVPN(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || connectivityManager.getNetworkInfo(17) == null) {
                return false;
            }
            return connectivityManager.getNetworkInfo(17).isConnectedOrConnecting();
        }
        return invokeL.booleanValue;
    }

    public static NetworkInfo getInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context == null) {
                return null;
            }
            return ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static boolean isAirModeOn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            NetworkInfo info = getInfo(context);
            if (info != null) {
                return info.isConnectedOrConnecting();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isWifi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            NetworkInfo info = getInfo(context);
            if (info != null && info.isConnected() && info.getType() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void updateClientIP(String str) {
        IOutbackClientIPProvider clientIPProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            if (OutbackComponent.getInstance().getContext() != null && (clientIPProvider = OutbackComponent.getInstance().getClientIPProvider()) != null) {
                clientIPProvider.notifyChanged(str);
            }
            if (!Util.isTextEmpty(str)) {
                sClientIP = str;
            }
        }
    }

    public static String getClientIP() {
        InterceptResult invokeV;
        IOutbackClientIPProvider clientIPProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (OutbackComponent.getInstance().getContext() != null && (clientIPProvider = OutbackComponent.getInstance().getClientIPProvider()) != null) {
                return clientIPProvider.getClientIP();
            }
            return sClientIP;
        }
        return (String) invokeV.objValue;
    }

    public static boolean isProxyConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (!TextUtils.isEmpty(property) && !TextUtils.isEmpty(property2)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean airModeOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAirModeOn;
        }
        return invokeV.booleanValue;
    }

    public String getApn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mApn;
        }
        return (String) invokeV.objValue;
    }

    public String getHttpProxyIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mHttpProxyIp;
        }
        return (String) invokeV.objValue;
    }

    public int getHttpProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mHttpProxyPort;
        }
        return invokeV.intValue;
    }

    public String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mNetType;
        }
        return (String) invokeV.objValue;
    }

    public String getProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mProxy;
        }
        return (String) invokeV.objValue;
    }

    public int getProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mPort;
        }
        return invokeV.intValue;
    }

    public int getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mSubType;
        }
        return invokeV.intValue;
    }

    public String getSubTypeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mSubTypeName;
        }
        return (String) invokeV.objValue;
    }

    public boolean isVpnOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mVpnOn;
        }
        return invokeV.booleanValue;
    }

    public boolean isWapNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mUseWap;
        }
        return invokeV.booleanValue;
    }

    public static String getNetworkInfo(Context context) {
        InterceptResult invokeL;
        NetworkInfo info;
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (context == null || (info = getInfo(context)) == null || !info.isConnected()) {
                return "no";
            }
            if (info.getType() == 1) {
                return "wifi";
            }
            if (info.getType() == 0) {
                int subtype = info.getSubtype();
                if (info.getExtraInfo() == null) {
                    lowerCase = "none";
                } else {
                    lowerCase = info.getExtraInfo().toLowerCase();
                }
                StringBuilder sb = new StringBuilder();
                String subtypeName = info.getSubtypeName();
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
                            sb.append(info.getTypeName());
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
            return info.getTypeName() + "_" + info.getSubtypeName();
        }
        return (String) invokeL.objValue;
    }

    public static NetworkStateEnum getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String networkInfo = getNetworkInfo(context);
            if (networkInfo.startsWith("no")) {
                return NetworkStateEnum.NO;
            }
            if (networkInfo.startsWith("wifi")) {
                return NetworkStateEnum.WIFI;
            }
            if (networkInfo.startsWith("2g")) {
                return NetworkStateEnum._2G;
            }
            if (networkInfo.startsWith("3g")) {
                return NetworkStateEnum._3G;
            }
            if (networkInfo.startsWith("4g")) {
                return NetworkStateEnum._4G;
            }
            if (networkInfo.startsWith("5g")) {
                return NetworkStateEnum._5G;
            }
            return NetworkStateEnum.UNKNOWN;
        }
        return (NetworkStateEnum) invokeL.objValue;
    }
}
