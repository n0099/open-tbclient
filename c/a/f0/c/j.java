package c.a.f0.c;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3437a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1599574652, "Lc/a/f0/c/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1599574652, "Lc/a/f0/c/j;");
                return;
            }
        }
        f3437a = f.f3425b;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 101) {
                    if (i2 != 201) {
                        if (i2 != 202) {
                            if (i2 != 301) {
                                if (i2 != 302) {
                                    switch (i2) {
                                        case 401:
                                            return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_action_sec_check_fail);
                                        case 402:
                                            return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_action_acl_check_fail);
                                        case 403:
                                            return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_action_allow_close);
                                        default:
                                            return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_parse_fail);
                                    }
                                }
                                return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_action_notfound);
                            }
                            return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_module_notfound);
                        }
                        return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_params_parse_fail);
                    }
                    return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_parse_fail);
                }
                return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_not_support);
            }
            return c.a().getString(c.a.m0.d.prologue_united_scheme_err_message_ok);
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> b(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (TextUtils.isEmpty(str)) {
                return hashMap;
            }
            int indexOf = str.indexOf("?");
            int indexOf2 = str.indexOf("#");
            if (indexOf < 0) {
                return hashMap;
            }
            if (indexOf2 < 0) {
                substring = str.substring(indexOf + 1);
            } else {
                substring = str.substring(indexOf + 1, indexOf2);
            }
            String[] split = substring.split("&");
            if (split == null) {
                return hashMap;
            }
            for (String str2 : split) {
                int indexOf3 = str2.indexOf("=");
                if (indexOf3 > 0) {
                    try {
                        hashMap.put(URLDecoder.decode(str2.substring(0, indexOf3)), URLDecoder.decode(str2.substring(indexOf3 + 1)));
                    } catch (IllegalArgumentException e2) {
                        if (f3437a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String[] c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(uri.getPathSegments());
            if (!d(uri)) {
                arrayList.add(0, uri.getHost());
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeL.objValue;
    }

    public static boolean d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            String host = uri.getHost();
            return !TextUtils.isEmpty(host) && host.startsWith("v") && e(host);
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? Pattern.compile("[0-9]").matcher(str).find() : invokeL.booleanValue;
    }

    public static boolean f(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            return TextUtils.equals(f.f3424a, uri.getScheme()) && !TextUtils.isEmpty(uri.getHost());
        }
        return invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return f(Uri.parse(str));
        }
        return invokeL.booleanValue;
    }

    public static JSONObject h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? j(null, i2) : (JSONObject) invokeI.objValue;
    }

    public static JSONObject i(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, null, i2, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", String.valueOf(i2));
                jSONObject.put("message", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeIL.objValue;
    }

    public static JSONObject j(JSONObject jSONObject, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, jSONObject, i2)) == null) ? k(jSONObject, i2, a(i2)) : (JSONObject) invokeLI.objValue;
    }

    public static JSONObject k(JSONObject jSONObject, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65547, null, jSONObject, i2, str)) == null) {
            JSONObject i3 = i(i2, str);
            if (jSONObject != null) {
                try {
                    i3.put("data", jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return i3;
        }
        return (JSONObject) invokeLIL.objValue;
    }
}
