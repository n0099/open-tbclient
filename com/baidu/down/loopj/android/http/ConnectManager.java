package com.baidu.down.loopj.android.http;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
/* loaded from: classes2.dex */
public class ConnectManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ConnectManager";
    public transient /* synthetic */ FieldHolder $fh;
    public String mApn;
    public NetWorkType mNetWorkType;
    public String mPort;
    public String mProxy;
    public boolean mUseWap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-862140903, "Lcom/baidu/down/loopj/android/http/ConnectManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-862140903, "Lcom/baidu/down/loopj/android/http/ConnectManager;");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class NetWorkType {
        public static final /* synthetic */ NetWorkType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetWorkType TYPE_2G;
        public static final NetWorkType TYPE_3G;
        public static final NetWorkType TYPE_4G;
        public static final NetWorkType TYPE_5G;
        public static final NetWorkType TYPE_UNKNOWN;
        public static final NetWorkType TYPE_WF;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1982169525, "Lcom/baidu/down/loopj/android/http/ConnectManager$NetWorkType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1982169525, "Lcom/baidu/down/loopj/android/http/ConnectManager$NetWorkType;");
                    return;
                }
            }
            TYPE_UNKNOWN = new NetWorkType("TYPE_UNKNOWN", 0);
            TYPE_WF = new NetWorkType("TYPE_WF", 1);
            TYPE_2G = new NetWorkType("TYPE_2G", 2);
            TYPE_3G = new NetWorkType("TYPE_3G", 3);
            TYPE_4G = new NetWorkType("TYPE_4G", 4);
            NetWorkType netWorkType = new NetWorkType("TYPE_5G", 5);
            TYPE_5G = netWorkType;
            $VALUES = new NetWorkType[]{TYPE_UNKNOWN, TYPE_WF, TYPE_2G, TYPE_3G, TYPE_4G, netWorkType};
        }

        public NetWorkType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NetWorkType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (NetWorkType) Enum.valueOf(NetWorkType.class, str);
            }
            return (NetWorkType) invokeL.objValue;
        }

        public static NetWorkType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (NetWorkType[]) $VALUES.clone();
            }
            return (NetWorkType[]) invokeV.objValue;
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
        this.mNetWorkType = NetWorkType.TYPE_UNKNOWN;
        checkNetworkType(context);
    }

    private void checkNetworkType(Context context) {
        NetworkInfo activeNetworkInfoSafely;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) && (activeNetworkInfoSafely = Utils.getActiveNetworkInfoSafely(context)) != null) {
            if ("wifi".equals(activeNetworkInfoSafely.getTypeName().toLowerCase())) {
                this.mNetWorkType = NetWorkType.TYPE_WF;
                this.mUseWap = false;
                return;
            }
            checkApn(context, activeNetworkInfoSafely);
            this.mNetWorkType = checkApnType(activeNetworkInfoSafely);
        }
    }

    private void checkApn(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, networkInfo) == null) {
            if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                if (!lowerCase.startsWith(ConectivityUtils.APN_CMWAP) && !lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) && !lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                    if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        this.mUseWap = true;
                        this.mApn = lowerCase;
                        this.mProxy = "10.0.0.200";
                        this.mPort = "80";
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
                    this.mPort = "80";
                    return;
                }
            }
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost != null && defaultHost.length() > 0) {
                this.mProxy = defaultHost;
                if ("10.0.0.172".equals(defaultHost.trim())) {
                    this.mUseWap = true;
                    this.mPort = "80";
                    return;
                } else if ("10.0.0.200".equals(this.mProxy.trim())) {
                    this.mUseWap = true;
                    this.mPort = "80";
                    return;
                } else {
                    this.mUseWap = false;
                    this.mPort = Integer.toString(defaultPort);
                    return;
                }
            }
            this.mUseWap = false;
        }
    }

    private NetWorkType checkApnType(NetworkInfo networkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, networkInfo)) == null) {
            String lowerCase = networkInfo.getTypeName().toLowerCase();
            NetWorkType netWorkType = NetWorkType.TYPE_UNKNOWN;
            if ("wifi".equals(lowerCase)) {
                return NetWorkType.TYPE_WF;
            }
            NetWorkType netWorkType2 = NetWorkType.TYPE_2G;
            int subtype = networkInfo.getSubtype();
            if (subtype != 20) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 11:
                        return netWorkType2;
                    case 3:
                        return NetWorkType.TYPE_3G;
                    case 5:
                        return NetWorkType.TYPE_3G;
                    case 6:
                        return NetWorkType.TYPE_3G;
                    case 7:
                        return NetWorkType.TYPE_3G;
                    case 8:
                        return NetWorkType.TYPE_3G;
                    case 9:
                        return NetWorkType.TYPE_3G;
                    case 10:
                        return NetWorkType.TYPE_3G;
                    case 12:
                        return NetWorkType.TYPE_3G;
                    case 13:
                        return NetWorkType.TYPE_4G;
                    case 14:
                        return NetWorkType.TYPE_3G;
                    case 15:
                        return NetWorkType.TYPE_3G;
                    default:
                        return NetWorkType.TYPE_4G;
                }
            }
            return NetWorkType.TYPE_5G;
        }
        return (NetWorkType) invokeL.objValue;
    }

    public static boolean isNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            NetworkInfo activeNetworkInfoSafely = Utils.getActiveNetworkInfoSafely(context);
            if (activeNetworkInfoSafely != null) {
                return activeNetworkInfoSafely.isConnectedOrConnecting();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String getApn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mApn;
        }
        return (String) invokeV.objValue;
    }

    public NetWorkType getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mNetWorkType;
        }
        return (NetWorkType) invokeV.objValue;
    }

    public String getProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mProxy;
        }
        return (String) invokeV.objValue;
    }

    public String getProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mPort;
        }
        return (String) invokeV.objValue;
    }

    public boolean isWapNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mUseWap;
        }
        return invokeV.booleanValue;
    }
}
