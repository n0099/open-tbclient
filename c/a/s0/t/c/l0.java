package c.a.s0.t.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UpgradePopWindowHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final l0 f13993i;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f13994b;

    /* renamed from: c  reason: collision with root package name */
    public String f13995c;

    /* renamed from: d  reason: collision with root package name */
    public String f13996d;

    /* renamed from: e  reason: collision with root package name */
    public String f13997e;

    /* renamed from: f  reason: collision with root package name */
    public String f13998f;

    /* renamed from: g  reason: collision with root package name */
    public String f13999g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f14000h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92423068, "Lc/a/s0/t/c/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-92423068, "Lc/a/s0/t/c/l0;");
                return;
            }
        }
        f13993i = new l0(false);
    }

    public l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14000h = new ArrayList();
        this.a = z;
    }

    public static l0 j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return f13993i;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("low_version_pop_config");
            if (optJSONObject == null) {
                c.a.s0.s.i0.b.k().y(UpgradePopWindowHelper.SP_UPGRADE_POP_WINDOW_SHOW_DATE, "");
                return f13993i;
            }
            l0 l0Var = new l0(true);
            l0Var.a(optJSONObject);
            return l0Var;
        }
        return (l0) invokeL.objValue;
    }

    public final void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f13994b = jSONObject.optInt("frequency");
            this.f13995c = jSONObject.optString("main_title");
            this.f13996d = jSONObject.optString("sub_title");
            this.f13997e = jSONObject.optString("jump_link");
            this.f13998f = jSONObject.optString("operation_1");
            this.f13999g = jSONObject.optString("operation_2");
            JSONArray optJSONArray = jSONObject.optJSONArray("trigger_scene");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                this.f14000h.add(optJSONArray.optString(i2));
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13994b : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13997e : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13995c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13998f : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13999g : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13996d : (String) invokeV.objValue;
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14000h : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
