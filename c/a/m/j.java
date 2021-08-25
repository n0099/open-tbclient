package c.a.m;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.m.d.a.g;
import c.a.m.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f4037a;

    /* renamed from: b  reason: collision with root package name */
    public String f4038b;

    /* renamed from: c  reason: collision with root package name */
    public int f4039c;

    /* renamed from: d  reason: collision with root package name */
    public int f4040d;

    public j() {
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
        this.f4039c = 2;
        this.f4040d = 0;
    }

    public static j a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            j jVar = new j();
            jVar.f4037a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            jVar.f4040d = length;
            if (length < 14) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                jVar.f4038b = str2;
            }
            return jVar;
        }
        return (j) invokeLL.objValue;
    }

    public static boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 >= 14 : invokeI.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public static j e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? g(j(str)) : (j) invokeL.objValue;
    }

    public static j g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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
                    if (!i("ZGV2aWNlaWQ=").equals(next) && !i("dmVy").equals(next)) {
                        str3 = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(i("ZGV2aWNlaWQ="));
                int i2 = jSONObject.getInt(i("dmVy"));
                int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
                if (!TextUtils.isEmpty(string)) {
                    j jVar = new j();
                    jVar.f4037a = string;
                    jVar.f4039c = i2;
                    jVar.f4040d = length;
                    if (length < 14) {
                        if (!TextUtils.isEmpty(str3)) {
                            str2 = str3;
                        }
                        jVar.f4038b = str2;
                    }
                    jVar.k();
                    return jVar;
                }
            } catch (JSONException e2) {
                c.a.m.i.c.c(e2);
            }
            return null;
        }
        return (j) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? new String(f.b.b(str.getBytes())) : (String) invokeL.objValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] a2 = g.a();
                return new String(c.a.m.d.a.c.d(a2, a2, f.b.b(str.getBytes())));
            } catch (Exception e2) {
                c.a.m.i.c.c(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] a2 = g.a();
                return f.b.a(c.a.m.d.a.c.c(a2, a2, str.getBytes()), "utf-8");
            } catch (UnsupportedEncodingException | Exception e2) {
                c.a.m.i.c.c(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d(this.f4038b) : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c(this.f4040d) : invokeV.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? m(l()) : (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f()) {
                str = "O";
            } else if (!b()) {
                return false;
            } else {
                str = "0";
            }
            this.f4038b = str;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new JSONObject().put(i("ZGV2aWNlaWQ="), this.f4037a).put(i("aW1laQ=="), this.f4038b).put(i("dmVy"), this.f4039c).toString();
            } catch (JSONException e2) {
                c.a.m.i.c.c(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
