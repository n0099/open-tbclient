package com.baidu.android.util.connect;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.Locale;
@Deprecated
/* loaded from: classes.dex */
public class ConnectManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ConnectManager";
    public transient /* synthetic */ FieldHolder $fh;
    public String mApn;
    public String mNetType;
    public int mPort;
    public String mProxy;
    public int mSubType;
    public String mSubTypeName;
    public boolean mUseWap;

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
        checkNetworkType(context);
    }

    @Deprecated
    public static NetworkInfo getInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return NetWorkUtils.getActiveNetworkInfo(context);
        }
        return (NetworkInfo) invokeL.objValue;
    }

    @Deprecated
    public static boolean isNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return NetWorkUtils.isConnected(context);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isWifi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return NetWorkUtils.isWifiConnected(context);
        }
        return invokeL.booleanValue;
    }

    private void checkApn(NetworkInfo networkInfo) {
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, networkInfo) == null) {
            if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase(Locale.getDefault())) != null) {
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
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, context) == null) && (activeNetworkInfo = NetWorkUtils.getActiveNetworkInfo(context)) != null) {
            if ("wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.getDefault()))) {
                this.mNetType = "wifi";
                this.mUseWap = false;
            } else {
                checkApn(activeNetworkInfo);
                this.mNetType = this.mApn;
            }
            this.mSubType = activeNetworkInfo.getSubtype();
            this.mSubTypeName = activeNetworkInfo.getSubtypeName();
        }
    }

    @Deprecated
    public static String getNetworkInfo(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null || (activeNetworkInfo = NetWorkUtils.getActiveNetworkInfo(context)) == null || !activeNetworkInfo.isConnected()) {
                return "no";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (activeNetworkInfo.getExtraInfo() == null) {
                    lowerCase = "none";
                } else {
                    lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase(Locale.getDefault());
                }
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

    public String getApn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mApn;
        }
        return (String) invokeV.objValue;
    }

    public String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mNetType;
        }
        return (String) invokeV.objValue;
    }

    public String getProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mProxy;
        }
        return (String) invokeV.objValue;
    }

    public int getProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mPort;
        }
        return invokeV.intValue;
    }

    public int getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSubType;
        }
        return invokeV.intValue;
    }

    public String getSubTypeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mSubTypeName;
        }
        return (String) invokeV.objValue;
    }

    public boolean isWapNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mUseWap;
        }
        return invokeV.booleanValue;
    }
}
