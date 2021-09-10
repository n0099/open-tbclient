package c.a.r0.p1.o.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.p1.o.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f23548a;

    /* renamed from: b  reason: collision with root package name */
    public final String f23549b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23550c;

    /* renamed from: d  reason: collision with root package name */
    public final String f23551d;

    /* renamed from: e  reason: collision with root package name */
    public final String f23552e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23553f;

    /* renamed from: g  reason: collision with root package name */
    public final String f23554g;

    /* renamed from: h  reason: collision with root package name */
    public final String f23555h;

    /* renamed from: i  reason: collision with root package name */
    public final String f23556i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23557j;
    public boolean k;

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
        this.f23557j = false;
        this.k = false;
        this.f23548a = jSONObject.optString("bIcon");
        this.f23549b = jSONObject.optString("bIconN");
        this.f23550c = jSONObject.optInt("bIconType");
        this.f23551d = jSONObject.optString("bSelIcon");
        this.f23552e = jSONObject.optString("bSelIconN");
        this.f23553f = jSONObject.optInt("bSelIconType");
        this.f23554g = jSONObject.optString("clickAction");
        this.f23555h = jSONObject.optString("preAction");
        this.f23556i = jSONObject.optString("statKey");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23554g : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23557j : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23557j ? this.f23551d : this.f23548a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23557j ? this.f23552e : this.f23549b : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return g(this.f23557j ? this.f23553f : this.f23550c);
        }
        return invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23555h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23556i : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (TextUtils.isEmpty(this.f23548a) && TextUtils.isEmpty(this.f23549b) && TextUtils.isEmpty(this.f23551d) && TextUtils.isEmpty(this.f23552e) && TextUtils.isEmpty(this.f23554g) && TextUtils.isEmpty(this.f23555h) && TextUtils.isEmpty(this.f23556i) && this.f23550c == 0 && this.f23553f == 0) ? false : true : invokeV.booleanValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f23557j = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }
}
