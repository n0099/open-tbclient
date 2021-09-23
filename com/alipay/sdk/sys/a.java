package com.alipay.sdk.sys;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.l;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static final String f36064j = "\"&";
    public static final String k = "&";
    public static final String l = "bizcontext=\"";
    public static final String m = "bizcontext=";
    public static final String n = "\"";
    public static final String o = "appkey";
    public static final String p = "ty";
    public static final String q = "sv";
    public static final String r = "an";
    public static final String s = "setting";
    public static final String t = "av";
    public static final String u = "sdk_start_time";
    public static final String v = "extInfo";
    public static final String w = "ap_link_token";
    public static final String x = "act_info";
    public static final String y = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36065a;

    /* renamed from: b  reason: collision with root package name */
    public String f36066b;

    /* renamed from: c  reason: collision with root package name */
    public Context f36067c;

    /* renamed from: d  reason: collision with root package name */
    public final String f36068d;

    /* renamed from: e  reason: collision with root package name */
    public final long f36069e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36070f;

    /* renamed from: g  reason: collision with root package name */
    public final String f36071g;

    /* renamed from: h  reason: collision with root package name */
    public final ActivityInfo f36072h;

    /* renamed from: i  reason: collision with root package name */
    public final com.alipay.sdk.app.statistic.b f36073i;

    public a(Context context, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36065a = "";
        this.f36066b = "";
        this.f36067c = null;
        boolean isEmpty = TextUtils.isEmpty(str2);
        this.f36073i = new com.alipay.sdk.app.statistic.b(context, isEmpty);
        this.f36068d = c(str, this.f36066b);
        this.f36069e = SystemClock.elapsedRealtime();
        this.f36070f = l.f();
        this.f36072h = l.a(context);
        this.f36071g = str2;
        if (!isEmpty) {
            com.alipay.sdk.app.statistic.a.a(this, "biz", "eptyp", str2 + "|" + this.f36068d);
            if (this.f36072h != null) {
                str3 = this.f36072h.name + "|" + this.f36072h.launchMode;
            } else {
                str3 = StringUtil.NULL_STRING;
            }
            com.alipay.sdk.app.statistic.a.a(this, "biz", "actInfo", str3);
            com.alipay.sdk.app.statistic.a.a(this, "biz", "sys", l.a(this));
        }
        try {
            this.f36067c = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f36065a = packageInfo.versionName;
            this.f36066b = packageInfo.packageName;
        } catch (Exception e2) {
            c.a(e2);
        }
        if (!isEmpty) {
            com.alipay.sdk.app.statistic.a.a(this, "biz", "u" + l.f());
            com.alipay.sdk.app.statistic.a.a(this, "biz", com.alipay.sdk.app.statistic.b.U, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.app.statistic.a.a(context, this, str, this.f36068d);
        }
        if (isEmpty || !com.alipay.sdk.data.a.u().q()) {
            return;
        }
        com.alipay.sdk.data.a.u().a(this, this.f36067c);
    }

    private boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) ? !str.contains(f36064j) : invokeL.booleanValue;
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return null;
        }
        return (a) invokeV.objValue;
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36067c : (Context) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36066b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36065a : (String) invokeV.objValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            try {
                String a2 = a(str, "&", m);
                if (TextUtils.isEmpty(a2)) {
                    str = str + "&" + b(m, "");
                } else {
                    int indexOf = str.indexOf(a2);
                    str = str.substring(0, indexOf) + a(a2, m, "", true) + str.substring(indexOf + a2.length());
                }
            } catch (Throwable unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            try {
                String a2 = a(str, f36064j, l);
                if (TextUtils.isEmpty(a2)) {
                    return str + "&" + b(l, "\"");
                }
                if (!a2.endsWith("\"")) {
                    a2 = a2 + "\"";
                }
                int indexOf = str.indexOf(a2);
                return str.substring(0, indexOf) + a(a2, l, "\"", false) + str.substring(indexOf + a2.length());
            } catch (Throwable unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    private JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(w, this.f36068d);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
                return str;
            }
            if (d(str)) {
                return b(str);
            }
            return c(str);
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: com.alipay.sdk.sys.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1566a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap<UUID, a> f36074a;

        /* renamed from: b  reason: collision with root package name */
        public static final HashMap<String, a> f36075b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f36076c = "i_uuid_b_c";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1433667487, "Lcom/alipay/sdk/sys/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1433667487, "Lcom/alipay/sdk/sys/a$a;");
                    return;
                }
            }
            f36074a = new HashMap<>();
            f36075b = new HashMap<>();
        }

        public C1566a() {
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

        public static void a(a aVar, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, intent) == null) || aVar == null || intent == null) {
                return;
            }
            UUID randomUUID = UUID.randomUUID();
            f36074a.put(randomUUID, aVar);
            intent.putExtra(f36076c, randomUUID);
        }

        public static a a(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
                if (intent == null) {
                    return null;
                }
                Serializable serializableExtra = intent.getSerializableExtra(f36076c);
                if (serializableExtra instanceof UUID) {
                    return f36074a.remove((UUID) serializableExtra);
                }
                return null;
            }
            return (a) invokeL.objValue;
        }

        public static void a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, str) == null) || aVar == null || TextUtils.isEmpty(str)) {
                return;
            }
            f36075b.put(str, aVar);
        }

        public static a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return f36075b.remove(str);
            }
            return (a) invokeL.objValue;
        }
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

    private String b(String str, String str2) throws JSONException, UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2)) == null) {
            String a2 = a("", "");
            return str + a2 + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            try {
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[4];
                if (str == null) {
                    str = "";
                }
                objArr[0] = str;
                if (str2 == null) {
                    str2 = "";
                }
                objArr[1] = str2;
                objArr[2] = Long.valueOf(System.currentTimeMillis());
                objArr[3] = UUID.randomUUID().toString();
                return String.format("EP%s%s_%s", "1", l.e(String.format(locale, "%s%s%d%s", objArr)), Long.valueOf(System.currentTimeMillis()));
            } catch (Throwable unused) {
                return "-";
            }
        }
        return (String) invokeLL.objValue;
    }

    public String a(String str, String str2) {
        String str3;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", com.alipay.sdk.cons.a.f35962f);
                jSONObject.put("ty", "and_lite");
                jSONObject.put("sv", "h.a.3.8.02");
                if (!this.f36066b.contains(s) || !l.h(this.f36067c)) {
                    jSONObject.put(r, this.f36066b);
                }
                jSONObject.put(t, this.f36065a);
                jSONObject.put(u, System.currentTimeMillis());
                jSONObject.put(v, d());
                if (this.f36072h != null) {
                    str3 = this.f36072h.name + "|" + this.f36072h.launchMode;
                } else {
                    str3 = StringUtil.NULL_STRING;
                }
                jSONObject.put(x, str3);
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
                jSONObject.put("appkey", com.alipay.sdk.cons.a.f35962f);
            }
            if (!jSONObject.has("ty")) {
                jSONObject.put("ty", "and_lite");
            }
            if (!jSONObject.has("sv")) {
                jSONObject.put("sv", "h.a.3.8.02");
            }
            if (!jSONObject.has(r) && (!this.f36066b.contains(s) || !l.h(this.f36067c))) {
                jSONObject.put(r, this.f36066b);
            }
            if (!jSONObject.has(t)) {
                jSONObject.put(t, this.f36065a);
            }
            if (!jSONObject.has(u)) {
                jSONObject.put(u, System.currentTimeMillis());
            }
            if (!jSONObject.has(v)) {
                jSONObject.put(v, d());
            }
            String jSONObject2 = jSONObject.toString();
            if (z2) {
                jSONObject2 = "\"" + jSONObject2 + "\"";
            }
            return str2 + jSONObject2 + str3;
        }
        return (String) invokeCommon.objValue;
    }

    public static HashMap<String, String> a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (aVar != null) {
                hashMap.put("sdk_ver", "15.8.02");
                hashMap.put("app_name", aVar.f36066b);
                hashMap.put("token", aVar.f36068d);
                hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, aVar.f36071g);
                hashMap.put("ts_api_invoke", String.valueOf(aVar.f36069e));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
