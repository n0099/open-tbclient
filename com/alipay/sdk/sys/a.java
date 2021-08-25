package com.alipay.sdk.sys;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.k;
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

    /* renamed from: a  reason: collision with root package name */
    public static final String f35921a = "\"&";

    /* renamed from: b  reason: collision with root package name */
    public static final String f35922b = "&";

    /* renamed from: c  reason: collision with root package name */
    public static final String f35923c = "bizcontext=\"";

    /* renamed from: d  reason: collision with root package name */
    public static final String f35924d = "bizcontext=";

    /* renamed from: e  reason: collision with root package name */
    public static final String f35925e = "\"";

    /* renamed from: f  reason: collision with root package name */
    public static final String f35926f = "appkey";

    /* renamed from: g  reason: collision with root package name */
    public static final String f35927g = "ty";

    /* renamed from: h  reason: collision with root package name */
    public static final String f35928h = "sv";

    /* renamed from: i  reason: collision with root package name */
    public static final String f35929i = "an";

    /* renamed from: j  reason: collision with root package name */
    public static final String f35930j = "setting";
    public static final String k = "av";
    public static final String l = "sdk_start_time";
    public static final String m = "extInfo";
    public static final String n = "ap_link_token";
    public static final String o = "act_info";
    public static final String p = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;
    public final String q;
    public final long r;
    public final int s;
    public final String t;
    public final com.alipay.sdk.app.statistic.b u;
    public String v;
    public String w;
    public Context x;
    public final ActivityInfo y;

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
        this.v = "";
        this.w = "";
        this.x = null;
        boolean isEmpty = TextUtils.isEmpty(str2);
        this.u = new com.alipay.sdk.app.statistic.b(context, isEmpty);
        this.q = c(str, this.w);
        this.r = SystemClock.elapsedRealtime();
        this.s = k.d();
        this.y = k.h(context);
        this.t = str2;
        if (!isEmpty) {
            com.alipay.sdk.app.statistic.a.b(this, "biz", "eptyp", str2 + "|" + this.q);
            if (this.y != null) {
                str3 = this.y.name + "|" + this.y.launchMode;
            } else {
                str3 = StringUtil.NULL_STRING;
            }
            com.alipay.sdk.app.statistic.a.b(this, "biz", "actInfo", str3);
            com.alipay.sdk.app.statistic.a.b(this, "biz", "sys", k.a(this));
        }
        try {
            this.x = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.v = packageInfo.versionName;
            this.w = packageInfo.packageName;
        } catch (Exception e2) {
            c.a(e2);
        }
        if (!isEmpty) {
            com.alipay.sdk.app.statistic.a.a(this, "biz", "u" + k.d());
            com.alipay.sdk.app.statistic.a.b(this, "biz", com.alipay.sdk.app.statistic.b.K, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.app.statistic.a.a(context, this, str, this.q);
        }
        if (isEmpty || !com.alipay.sdk.data.a.p().n()) {
            return;
        }
        com.alipay.sdk.data.a.p().a(this, this.x);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return null;
        }
        return (a) invokeV.objValue;
    }

    private JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(n, this.q);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
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

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x : (Context) invokeV.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) ? !str.contains(f35921a) : invokeL.booleanValue;
    }

    private String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            try {
                String a2 = a(str, "&", f35924d);
                if (TextUtils.isEmpty(a2)) {
                    str = str + "&" + b(f35924d, "");
                } else {
                    int indexOf = str.indexOf(a2);
                    str = str.substring(0, indexOf) + a(a2, f35924d, "", true) + str.substring(indexOf + a2.length());
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            try {
                String a2 = a(str, f35921a, f35923c);
                if (TextUtils.isEmpty(a2)) {
                    return str + "&" + b(f35923c, "\"");
                }
                if (!a2.endsWith("\"")) {
                    a2 = a2 + "\"";
                }
                int indexOf = str.indexOf(a2);
                return str.substring(0, indexOf) + a(a2, f35923c, "\"", false) + str.substring(indexOf + a2.length());
            } catch (Throwable unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: com.alipay.sdk.sys.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1565a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap<UUID, a> f35931a;

        /* renamed from: b  reason: collision with root package name */
        public static final HashMap<String, a> f35932b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f35933c = "i_uuid_b_c";
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
            f35931a = new HashMap<>();
            f35932b = new HashMap<>();
        }

        public C1565a() {
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
            f35931a.put(randomUUID, aVar);
            intent.putExtra(f35933c, randomUUID);
        }

        public static a a(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
                if (intent == null) {
                    return null;
                }
                Serializable serializableExtra = intent.getSerializableExtra(f35933c);
                if (serializableExtra instanceof UUID) {
                    return f35931a.remove((UUID) serializableExtra);
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
            f35932b.put(str, aVar);
        }

        public static a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return f35932b.remove(str);
            }
            return (a) invokeL.objValue;
        }
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

    private String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, str, str2, str3)) == null) {
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

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
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
                return String.format("EP%s%s_%s", "1", k.f(String.format(locale, "%s%s%d%s", objArr)), Long.valueOf(System.currentTimeMillis()));
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", com.alipay.sdk.cons.a.f35819f);
                jSONObject.put("ty", "and_lite");
                jSONObject.put("sv", "h.a.3.7.7");
                if (!this.w.contains(f35930j) || !k.b(this.x)) {
                    jSONObject.put(f35929i, this.w);
                }
                jSONObject.put(k, this.v);
                jSONObject.put(l, System.currentTimeMillis());
                jSONObject.put(m, e());
                if (this.y != null) {
                    str3 = this.y.name + "|" + this.y.launchMode;
                } else {
                    str3 = StringUtil.NULL_STRING;
                }
                jSONObject.put(o, str3);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
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
                jSONObject.put("appkey", com.alipay.sdk.cons.a.f35819f);
            }
            if (!jSONObject.has("ty")) {
                jSONObject.put("ty", "and_lite");
            }
            if (!jSONObject.has("sv")) {
                jSONObject.put("sv", "h.a.3.7.7");
            }
            if (!jSONObject.has(f35929i) && (!this.w.contains(f35930j) || !k.b(this.x))) {
                jSONObject.put(f35929i, this.w);
            }
            if (!jSONObject.has(k)) {
                jSONObject.put(k, this.v);
            }
            if (!jSONObject.has(l)) {
                jSONObject.put(l, System.currentTimeMillis());
            }
            if (!jSONObject.has(m)) {
                jSONObject.put(m, e());
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (aVar != null) {
                hashMap.put("sdk_ver", "15.7.7");
                hashMap.put("app_name", aVar.w);
                hashMap.put("token", aVar.q);
                hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, aVar.t);
                hashMap.put("ts_api_invoke", String.valueOf(aVar.r));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
