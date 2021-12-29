package c.a.c0.t;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d0.l;
import c.a.c0.e.f;
import c.a.c0.v.e;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, String> f2555b;

    /* renamed from: c  reason: collision with root package name */
    public static final JSONArray f2556c;

    /* renamed from: d  reason: collision with root package name */
    public static final f f2557d;

    /* renamed from: e  reason: collision with root package name */
    public static String f2558e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1062430223, "Lc/a/c0/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1062430223, "Lc/a/c0/t/a;");
                return;
            }
        }
        a = new byte[]{48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -69, 118, 15, 43, -102, -34, -94, -8, -78, 1, 17, -80, 84, 56, 79, 40, -89, 68, 50, 105, -35, 111, -70, 68, -68, -64, 62, 111, -66, -108, 77, 21, 106, 69, -34, 94, -1, 18, -100, -75, 7, 48, -59, 44, 50, -58, -124, 23, -97, -14, 100, 67, 115, -70, 4, 2, 47, -36, 11, 80, 6, -88, 116, -38, -121, -4, -61, -13, -32, 106, 7, 85, -39, 111, 53, 0, -35, Base64.INTERNAL_PADDING, PublicSuffixDatabase.EXCEPTION_MARKER, 106, -125, -59, 100, -42, -32, 15, -108, PublicSuffixDatabase.EXCEPTION_MARKER, -14, 67, 124, 57, -83, -91, -86, -67, -57, 19, 90, -113, -41, 69, -25, 70, 70, 111, -41, -47, 76, -85, 118, -52, 110, -56, -28, 9, 75, 2, 43, -35, 15, 58, 31, 126, 8, 27, -82, -107, 2, 3, 1, 0, 1};
        f2555b = new HashMap();
        f2556c = new JSONArray();
        f2557d = c.a.c0.e.a.a();
        f2558e = null;
        a("is_https", "1");
        a(SearchJsBridge.COOKIE_MOD, f2557d.i());
        a("ua", f2557d.h());
        a("fmt", "json");
        a("apna", f2557d.packageName());
        a("ver", f2557d.o());
        a(SearchJsBridge.COOKIE_OV, f2557d.c());
        a("ot", "2");
        a("ct", "2");
        a("cuid", f2557d.b());
        a("uid", f2557d.l());
        a(TiebaStatic.Params.BDID, f2557d.f());
        a("encrypted_imei", c());
        a("android_id", f2557d.a());
        f2556c.put(b(AdExtParam.KEY_NAD_CORE_VERSION, "4.2.1.3"));
        f2556c.put(b("os_br", Build.BRAND));
        f2556c.put(b("os_mafa", Build.MANUFACTURER));
        f2556c.put(b(AdExtParam.KEY_IADEX, c.a.c0.b.m.a.e()));
        f2556c.put(b(BaseStatisContent.MAC, f2557d.p()));
        f2556c.put(b("oaid_v", f2557d.g()));
        try {
            f2556c.put(b("encoded_ua_new", URLEncoder.encode(c.a.c0.e.a.d(), "utf-8")));
        } catch (UnsupportedEncodingException unused) {
        }
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
                return;
            }
        }
        e.a().b("nad.refresh_count.sp");
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f2555b.put(str, str2);
    }

    public static JSONObject b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("k", str);
                jSONObject.put("v", str2);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String str = f2558e;
            if (str != null) {
                return str;
            }
            try {
                String n = f2557d.n();
                if (TextUtils.isEmpty(n)) {
                    f2558e = "";
                } else {
                    byte[] a2 = l.a(n.getBytes(), l.b(a));
                    if (a2 != null) {
                        f2558e = new String(android.util.Base64.encode(a2, 2));
                    } else {
                        f2558e = "";
                    }
                }
            } catch (Throwable unused) {
                f2558e = "";
            }
            return f2558e;
        }
        return (String) invokeV.objValue;
    }
}
