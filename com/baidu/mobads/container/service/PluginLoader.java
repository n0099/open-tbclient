package com.baidu.mobads.container.service;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.cid.DeviceId;
import com.baidu.mobads.container.remote.location.LocationDexLoader;
import com.baidu.mobads.container.remote.tdid.XSecurityDexLoader;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PluginLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PluginLoader";
    public static String mCuid = "";
    public static String mNcuid = "";
    public static String mTdid = "";
    public static String mZid = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1255136516, "Lcom/baidu/mobads/container/service/PluginLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1255136516, "Lcom/baidu/mobads/container/service/PluginLoader;");
        }
    }

    public PluginLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getCuidFromGalaxy(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (!TextUtils.isEmpty(mCuid)) {
                return mCuid;
            }
            String trustChainCUID = DeviceId.getTrustChainCUID(context);
            mCuid = trustChainCUID;
            return trustChainCUID;
        }
        return (String) invokeL.objValue;
    }

    public static String getLocation(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) ? new LocationDexLoader(context, str).getLocString() : (String) invokeLL.objValue;
    }

    public static String getNCuidFrom27jar(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (TextUtils.isEmpty(mNcuid) && context != null) {
                String trustChainCUID = DeviceId.getTrustChainCUID(context);
                if (TextUtils.isEmpty(trustChainCUID)) {
                    mNcuid = "dt_" + DeviceId.getSelfCUID(context);
                } else {
                    mNcuid = "t_" + trustChainCUID;
                }
                return mNcuid;
            }
            return mNcuid;
        }
        return (String) invokeL.objValue;
    }

    public static boolean getSslExemption(SslErrorHandler sslErrorHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, sslErrorHandler)) == null) {
            if (sslErrorHandler != null) {
                sslErrorHandler.proceed();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String getTdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (!TextUtils.isEmpty(mTdid)) {
                return mTdid;
            }
            JSONObject securityInfo = XSecurityDexLoader.getInstance().getSecurityInfo(context);
            if (securityInfo != null) {
                mTdid = securityInfo.optString("tdid");
            }
            return mTdid;
        }
        return (String) invokeL.objValue;
    }

    public static String getZid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (!TextUtils.isEmpty(mZid)) {
                return mZid;
            }
            JSONObject securityInfo = XSecurityDexLoader.getInstance().getSecurityInfo(context);
            if (securityInfo != null) {
                mZid = securityInfo.optString("zid");
            }
            return mZid;
        }
        return (String) invokeL.objValue;
    }
}
