package com.alipay.sdk.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1928a = "\"&";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1929b = "&";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1930c = "bizcontext=\"";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1931d = "bizcontext=";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1932e = "\"";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1933f = "appkey";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1934g = "ty";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1935h = "sv";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1936i = "an";
    public static final String j = "setting";
    public static final String k = "av";
    public static final String l = "sdk_start_time";
    public static final String m = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;
    public String n;
    public String o;
    public Context p;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = "";
        this.o = "";
        this.p = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.n = packageInfo.versionName;
            this.o = packageInfo.packageName;
            this.p = context.getApplicationContext();
        } catch (Exception unused) {
        }
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, this, str)) == null) ? !str.contains(f1928a) : invokeL.booleanValue;
    }

    private String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            try {
                String a2 = a(str, "&", f1931d);
                if (TextUtils.isEmpty(a2)) {
                    str = str + "&" + b(f1931d, "");
                } else {
                    int indexOf = str.indexOf(a2);
                    str = str.substring(0, indexOf) + a(a2, f1931d, "", true) + str.substring(indexOf + a2.length());
                }
            } catch (Throwable unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            try {
                String a2 = a(str, f1928a, f1930c);
                if (TextUtils.isEmpty(a2)) {
                    return str + "&" + b(f1930c, "\"");
                }
                if (!a2.endsWith("\"")) {
                    a2 = a2 + "\"";
                }
                int indexOf = str.indexOf(a2);
                return str.substring(0, indexOf) + a(a2, f1930c, "\"", false) + str.substring(indexOf + a2.length());
            } catch (Throwable unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
                return str;
            }
            if (b(str)) {
                return c(str);
            }
            return d(str);
        }
        return (String) invokeL.objValue;
    }

    private String b(String str, String str2) throws JSONException, UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            String a2 = a("", "");
            return str + a2 + str2;
        }
        return (String) invokeLL.objValue;
    }

    private String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split(str2);
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!TextUtils.isEmpty(split[i2]) && split[i2].startsWith(str3)) {
                    return split[i2];
                }
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", com.alipay.sdk.cons.a.f1834d);
                jSONObject.put("ty", "and_lite");
                jSONObject.put("sv", "h.a.3.6.5");
                if (!this.o.contains(j) || !n.b(this.p)) {
                    jSONObject.put(f1936i, this.o);
                }
                jSONObject.put(k, this.n);
                jSONObject.put(l, System.currentTimeMillis());
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(str, str2);
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                c.a(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    private String a(String str, String str2, String str3, boolean z) throws JSONException, UnsupportedEncodingException {
        InterceptResult invokeCommon;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            String substring = str.substring(str2.length());
            boolean z2 = false;
            String substring2 = substring.substring(0, substring.length() - str3.length());
            if (substring2.length() >= 2 && substring2.startsWith("\"") && substring2.endsWith("\"")) {
                jSONObject = new JSONObject(substring2.substring(1, substring2.length() - 1));
                z2 = true;
            } else {
                jSONObject = new JSONObject(substring2);
            }
            if (!jSONObject.has("appkey")) {
                jSONObject.put("appkey", com.alipay.sdk.cons.a.f1834d);
            }
            if (!jSONObject.has("ty")) {
                jSONObject.put("ty", "and_lite");
            }
            if (!jSONObject.has("sv")) {
                jSONObject.put("sv", "h.a.3.6.5");
            }
            if (!jSONObject.has(f1936i) && (!this.o.contains(j) || !n.b(this.p))) {
                jSONObject.put(f1936i, this.o);
            }
            if (!jSONObject.has(k)) {
                jSONObject.put(k, this.n);
            }
            if (!jSONObject.has(l)) {
                jSONObject.put(l, System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (z2) {
                jSONObject2 = "\"" + jSONObject2 + "\"";
            }
            return str2 + jSONObject2 + str3;
        }
        return (String) invokeCommon.objValue;
    }
}
