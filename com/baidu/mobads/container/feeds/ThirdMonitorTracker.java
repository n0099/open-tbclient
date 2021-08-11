package com.baidu.mobads.container.feeds;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.Base64;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ThirdMonitorTracker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_ID = "crid";
    public static final String REGULAR_EXPRESSION = "\\{@([()\\w]+)\\}";
    public static ThirdMonitorTracker mThirdMonitorTracker;
    public transient /* synthetic */ FieldHolder $fh;

    public ThirdMonitorTracker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String convertString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            if (AdURIUtils.isStringAvailable(str) && AdURIUtils.isStringAvailable(str2)) {
                if (PackageTable.MD5.equals(str)) {
                    return EncryptUtils.getMD5(str2);
                }
                if ("toUpper".equals(str)) {
                    return str2.toUpperCase(Locale.getDefault());
                }
                if ("toLower".equals(str)) {
                    return str2.toLowerCase(Locale.getDefault());
                }
                if ("clearColon".equals(str)) {
                    return str2.replace(":", "");
                }
                if ("clearLine".equals(str)) {
                    return str2.replace("-", "");
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    private String executeMethod(Context context, String str, String str2, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, context, str, str2, jSONObject)) == null) {
            if (jSONObject != null && jSONObject.has(str)) {
                return jSONObject.optString(str);
            }
            String info = getInfo(context, str, jSONObject);
            return AdURIUtils.isStringAvailable(info) ? info : convertString(str, str2);
        }
        return (String) invokeLLLL.objValue;
    }

    private String getInfo(Context context, String str, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, context, str, jSONObject)) == null) {
            String appId = DeviceUtils.getInstance().getAppId(context);
            if (jSONObject != null) {
                appId = jSONObject.optString("appsid");
            }
            if ("uid".equals(str)) {
                return Base64.encode(DeviceUtils.getInstance().getDeviceId(context));
            }
            if ("uidtype".equals(str)) {
                return "2";
            }
            if (IAdRequestParam.CHID.equals(str)) {
                return "";
            }
            if (!"ts".equals(str)) {
                return "pid".equals(str) ? appId : IAdRequestParam.CELL_ID.equals(str) ? "mobads" : "";
            }
            return "" + System.currentTimeMillis();
        }
        return (String) invokeLLL.objValue;
    }

    public static ThirdMonitorTracker getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (mThirdMonitorTracker == null) {
                synchronized (ThirdMonitorTracker.class) {
                    if (mThirdMonitorTracker == null) {
                        mThirdMonitorTracker = new ThirdMonitorTracker();
                    }
                }
            }
            return mThirdMonitorTracker;
        }
        return (ThirdMonitorTracker) invokeV.objValue;
    }

    private String handler(Context context, String str, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, context, str, jSONObject)) == null) {
            String str2 = "";
            if (AdURIUtils.isStringAvailable(str)) {
                String[] split = str.replaceAll("\\)*$", "").split("\\(");
                for (int length = split.length - 1; length >= 0; length--) {
                    if (AdURIUtils.isStringAvailable(split[length])) {
                        str2 = executeMethod(context, split[length], str2, jSONObject);
                    }
                }
                return str2;
            }
            return "";
        }
        return (String) invokeLLL.objValue;
    }

    public String build3rdLogUrl(Context context, String str, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, jSONObject)) == null) {
            if (context == null || !AdURIUtils.isStringAvailable(str)) {
                return "";
            }
            Matcher matcher = Pattern.compile(REGULAR_EXPRESSION).matcher(str);
            while (matcher.find()) {
                try {
                    str = str.replaceFirst(REGULAR_EXPRESSION, handler(context, matcher.group(1), jSONObject));
                } catch (Throwable th) {
                    RemoteXAdLogger.getInstance().d(th);
                }
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }
}
