package c.a.l;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f3695b;

    /* renamed from: c  reason: collision with root package name */
    public int f3696c;

    /* renamed from: d  reason: collision with root package name */
    public int f3697d;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3696c = 2;
        this.f3697d = 0;
    }

    public static e a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? e(f(str)) : (e) invokeL.objValue;
    }

    public static e b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            e eVar = new e();
            eVar.a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            eVar.f3697d = length;
            if (length < 14) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                eVar.f3695b = str2;
            }
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 >= 14 : invokeI.booleanValue;
    }

    public static e e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                String str2 = "0";
                String str3 = "0";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!k("ZGV2aWNlaWQ=").equals(next) && !k("dmVy").equals(next)) {
                        str3 = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(k("ZGV2aWNlaWQ="));
                int i2 = jSONObject.getInt(k("dmVy"));
                int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
                if (!TextUtils.isEmpty(string)) {
                    e eVar = new e();
                    eVar.a = string;
                    eVar.f3696c = i2;
                    eVar.f3697d = length;
                    if (length < 14) {
                        if (!TextUtils.isEmpty(str3)) {
                            str2 = str3;
                        }
                        eVar.f3695b = str2;
                    }
                    eVar.c();
                    return eVar;
                }
            } catch (JSONException e2) {
                c.a.l.m.c.c(e2);
            }
            return null;
        }
        return (e) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] a = c.a.l.j.a.g.a();
                return new String(c.a.l.j.a.c.c(a, a, c.a.l.k.a.b(str.getBytes())));
            } catch (Exception e2) {
                c.a.l.m.c.c(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] a = c.a.l.j.a.g.a();
                return c.a.l.k.a.a(c.a.l.j.a.c.d(a, a, str.getBytes()), "utf-8");
            } catch (UnsupportedEncodingException | Exception e2) {
                c.a.l.m.c.c(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? new String(c.a.l.k.a.b(str.getBytes())) : (String) invokeL.objValue;
    }

    public static boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (g()) {
                str = "O";
            } else if (!i()) {
                return false;
            } else {
                str = "0";
            }
            this.f3695b = str;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d(this.f3697d) : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? m(this.f3695b) : invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? h(l()) : (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new JSONObject().put(k("ZGV2aWNlaWQ="), this.a).put(k("aW1laQ=="), this.f3695b).put(k("dmVy"), this.f3696c).toString();
            } catch (JSONException e2) {
                c.a.l.m.c.c(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
