package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.beans.business.core.utils.NetUtils;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.PhoneUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5331a = "cu";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5332b = "cu2";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5333c = "ua";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5334d = "op";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5335e = "bs";

    /* renamed from: f  reason: collision with root package name */
    public static final String f5336f = "bk";

    /* renamed from: g  reason: collision with root package name */
    public static final String f5337g = "lc";

    /* renamed from: h  reason: collision with root package name */
    public static final String f5338h = "sd";

    /* renamed from: i  reason: collision with root package name */
    public static final String f5339i = "j";
    public transient /* synthetic */ FieldHolder $fh;
    public Pattern j;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static j f5340a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2004338533, "Lcom/baidu/fsg/base/statistics/j$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2004338533, "Lcom/baidu/fsg/base/statistics/j$a;");
                    return;
                }
            }
            f5340a = new j(null);
        }

        public a() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1047894594, "Lcom/baidu/fsg/base/statistics/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1047894594, "Lcom/baidu/fsg/base/statistics/j;");
        }
    }

    public /* synthetic */ j(k kVar) {
        this();
    }

    public static j c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f5340a : (j) invokeV.objValue;
    }

    private String d(Context context) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            try {
                try {
                    return this.j.matcher(PhoneUtils.getCUID2(context)).replaceAll("");
                } catch (Exception unused) {
                    return str;
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context)) == null) {
            try {
                return BussinessUtils.getUA(context);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    private String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, this, context)) == null) ? RimArmor.getInstance().getpwProxy() : (String) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("ua", e(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt("cu", c(RimStatisticsUtil.getAppContext()));
                jSONObject.put("cu2", d(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt("op", f(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt("bs", g(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt("bk", h(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt("sd", b(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt("lc", a(RimStatisticsUtil.getAppContext()));
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return new JSONObject().toString();
            } catch (Throwable th) {
                LogUtil.d(f5339i, th.toString());
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = Pattern.compile("\\s*|\t|\r|\n");
    }

    private String c(Context context) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            try {
                try {
                    return this.j.matcher(PhoneUtils.getCUID(context)).replaceAll("");
                } catch (Exception unused) {
                    return str;
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            JSONObject connectedWifi = NetUtils.getConnectedWifi(context);
            if (connectedWifi != null) {
                String optString = connectedWifi.optString("ssid", null);
                return optString != null ? RimArmor.getInstance().encryptProxy(optString) : optString;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            String gPSLocation = PhoneUtils.getGPSLocation(context);
            if (TextUtils.isEmpty(gPSLocation)) {
                return null;
            }
            return RimArmor.getInstance().encryptProxy(gPSLocation);
        }
        return (String) invokeL.objValue;
    }
}
