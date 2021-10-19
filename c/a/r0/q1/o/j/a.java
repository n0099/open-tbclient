package c.a.r0.q1.o.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.q1.o.f;
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
    public final String f23739a;

    /* renamed from: b  reason: collision with root package name */
    public final String f23740b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23741c;

    /* renamed from: d  reason: collision with root package name */
    public final String f23742d;

    /* renamed from: e  reason: collision with root package name */
    public final String f23743e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23744f;

    /* renamed from: g  reason: collision with root package name */
    public final String f23745g;

    /* renamed from: h  reason: collision with root package name */
    public final String f23746h;

    /* renamed from: i  reason: collision with root package name */
    public final String f23747i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23748j;
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
        this.f23748j = false;
        this.k = false;
        this.f23739a = jSONObject.optString("bIcon");
        this.f23740b = jSONObject.optString("bIconN");
        this.f23741c = jSONObject.optInt("bIconType");
        this.f23742d = jSONObject.optString("bSelIcon");
        this.f23743e = jSONObject.optString("bSelIconN");
        this.f23744f = jSONObject.optInt("bSelIconType");
        this.f23745g = jSONObject.optString("clickAction");
        this.f23746h = jSONObject.optString("preAction");
        this.f23747i = jSONObject.optString("statKey");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23745g : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23748j : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23748j ? this.f23742d : this.f23739a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23748j ? this.f23743e : this.f23740b : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return g(this.f23748j ? this.f23744f : this.f23741c);
        }
        return invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23746h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23747i : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (TextUtils.isEmpty(this.f23739a) && TextUtils.isEmpty(this.f23740b) && TextUtils.isEmpty(this.f23742d) && TextUtils.isEmpty(this.f23743e) && TextUtils.isEmpty(this.f23745g) && TextUtils.isEmpty(this.f23746h) && TextUtils.isEmpty(this.f23747i) && this.f23741c == 0 && this.f23744f == 0) ? false : true : invokeV.booleanValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f23748j = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }
}
