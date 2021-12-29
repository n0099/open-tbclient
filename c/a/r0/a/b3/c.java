package c.a.r0.a.b3;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.room.RoomMasterTable;
import c.a.r0.a.d2.d;
import c.a.r0.a.h0.g.k;
import c.a.r0.a.k;
import c.a.r0.a.o2.g.h;
import c.a.r0.a.z2.o0;
import c.a.r0.a.z2.q0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(420528285, "Lc/a/r0/a/b3/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(420528285, "Lc/a/r0/a/b3/c;");
                return;
            }
        }
        a = k.a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String n = d.J().r().V().n("mPage");
            if (TextUtils.isEmpty(n)) {
                return str;
            }
            try {
                List<String> c2 = o0.c(new URI(n).getRawQuery());
                if (c2.size() > 0) {
                    for (int i2 = 0; i2 < c2.size(); i2++) {
                        String str2 = c2.get(i2);
                        if (!TextUtils.isEmpty(str2)) {
                            String[] split = str2.split("=");
                            if (split.length > 1) {
                                str = o0.a(str, split[0], split[1]);
                            }
                        }
                    }
                }
                return str;
            } catch (URISyntaxException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                c.a.r0.a.e0.d.i("SwanWebModeUtils", "appendWebUrlQuery: " + e2.getMessage());
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (k.b.a()) {
                str = d() + "?appKey=" + d.J().r().getAppId();
            }
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String e2 = e();
            String valueOf = String.valueOf(b.c().g());
            String a2 = a(str);
            String c2 = c();
            c.a.r0.a.e0.d.i("SwanWebModeUtils", "appendWebUrlQuery: launchUrl : " + a2 + " rawPath : " + c2);
            return Uri.parse(a2).buildUpon().path(c2).appendQueryParameter("_swebfr", e2).appendQueryParameter("_swebcode", valueOf).appendQueryParameter("_swebHost", c.a.r0.a.c1.a.n().a()).build().toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String n = d.J().r().V().n("mPage");
            if (TextUtils.isEmpty(n)) {
                return "";
            }
            try {
                return new URI(n).getPath();
            } catch (URISyntaxException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String string = h.a().getString("web_mode_host_key", "");
            return TextUtils.isEmpty(string) ? "http://radar.bcc-szth.baidu.com:8312" : string;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? q0.G() ? "41" : RoomMasterTable.DEFAULT_ID : (String) invokeV.objValue;
    }

    public static boolean f(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            String optString = jSONObject.optString("invokeFrom");
            return !TextUtils.isEmpty(optString) && TextUtils.equals(optString, "swanWeb");
        }
        return invokeL.booleanValue;
    }

    public static boolean g(c.a.r0.a.u2.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, aVar, i2)) == null) {
            if (i2 == 6) {
                return true;
            }
            if (aVar == null) {
                return false;
            }
            return aVar.h() == 1013 || aVar.h() == 1015;
        }
        return invokeLI.booleanValue;
    }
}
