package c.a.t0.x1.o.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.x1.o.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25927b;

    /* renamed from: c  reason: collision with root package name */
    public final int f25928c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25929d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25930e;

    /* renamed from: f  reason: collision with root package name */
    public final int f25931f;

    /* renamed from: g  reason: collision with root package name */
    public final String f25932g;

    /* renamed from: h  reason: collision with root package name */
    public final String f25933h;

    /* renamed from: i  reason: collision with root package name */
    public final String f25934i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f25935j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f25936k;

    public a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25935j = false;
        this.f25936k = false;
        this.a = jSONObject.optString("bIcon");
        this.f25927b = jSONObject.optString("bIconN");
        this.f25928c = jSONObject.optInt("bIconType");
        this.f25929d = jSONObject.optString("bSelIcon");
        this.f25930e = jSONObject.optString("bSelIconN");
        this.f25931f = jSONObject.optInt("bSelIconType");
        this.f25932g = jSONObject.optString("clickAction");
        this.f25933h = jSONObject.optString("preAction");
        this.f25934i = jSONObject.optString("statKey");
    }

    public static int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? f.a(i2) : invokeI.intValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f() > 0 : invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25932g : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25935j : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25935j ? this.f25929d : this.a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25935j ? this.f25930e : this.f25927b : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return g(this.f25935j ? this.f25931f : this.f25928c);
        }
        return invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25933h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f25934i : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f25936k : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.f25927b) && TextUtils.isEmpty(this.f25929d) && TextUtils.isEmpty(this.f25930e) && TextUtils.isEmpty(this.f25932g) && TextUtils.isEmpty(this.f25933h) && TextUtils.isEmpty(this.f25934i) && this.f25928c == 0 && this.f25931f == 0) ? false : true : invokeV.booleanValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f25935j = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f25936k = z;
        }
    }
}
