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
/* loaded from: classes5.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39579a = "k";

    /* renamed from: b  reason: collision with root package name */
    public static final String f39580b = "cu";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39581c = "cu2";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39582d = "ua";

    /* renamed from: e  reason: collision with root package name */
    public static final String f39583e = "op";

    /* renamed from: f  reason: collision with root package name */
    public static final String f39584f = "bs";

    /* renamed from: g  reason: collision with root package name */
    public static final String f39585g = "bk";

    /* renamed from: h  reason: collision with root package name */
    public static final String f39586h = "lc";

    /* renamed from: i  reason: collision with root package name */
    public static final String f39587i = "sd";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public Pattern f39588j;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static k f39589a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2004368324, "Lcom/baidu/fsg/base/statistics/k$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2004368324, "Lcom/baidu/fsg/base/statistics/k$a;");
                    return;
                }
            }
            f39589a = new k(null);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1047894625, "Lcom/baidu/fsg/base/statistics/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1047894625, "Lcom/baidu/fsg/base/statistics/k;");
        }
    }

    public k() {
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
        this.f39588j = Pattern.compile("\\s*|\t|\r|\n");
    }

    public /* synthetic */ k(j jVar) {
        this();
    }

    public static k c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f39589a : (k) invokeV.objValue;
    }

    private String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    private String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) ? RimArmor.getInstance().getpwProxy() : (String) invokeL.objValue;
    }

    private String e(Context context) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context)) == null) {
            try {
                try {
                    return this.f39588j.matcher(PhoneUtils.getCUID(context)).replaceAll("");
                } catch (Exception unused) {
                    return str;
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String f(Context context) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            try {
                try {
                    return this.f39588j.matcher(PhoneUtils.getCUID2(context)).replaceAll("");
                } catch (Exception unused) {
                    return str;
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, context)) == null) {
            try {
                return BussinessUtils.getUA(context);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("ua", h(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt(f39580b, e(RimStatisticsUtil.getAppContext()));
                jSONObject.put(f39581c, f(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt("op", g(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt("bs", c(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt(f39585g, d(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt("sd", b(RimStatisticsUtil.getAppContext()));
                jSONObject.putOpt(f39586h, a(RimStatisticsUtil.getAppContext()));
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
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

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return new JSONObject().toString();
            } catch (Throwable th) {
                LogUtil.d(f39579a, th.toString());
                return null;
            }
        }
        return (String) invokeV.objValue;
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
}
