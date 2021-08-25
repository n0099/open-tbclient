package c.a.q0.o1.o.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.o1.o.f;
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
    public final String f22958a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22959b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22960c;

    /* renamed from: d  reason: collision with root package name */
    public final String f22961d;

    /* renamed from: e  reason: collision with root package name */
    public final String f22962e;

    /* renamed from: f  reason: collision with root package name */
    public final int f22963f;

    /* renamed from: g  reason: collision with root package name */
    public final String f22964g;

    /* renamed from: h  reason: collision with root package name */
    public final String f22965h;

    /* renamed from: i  reason: collision with root package name */
    public final String f22966i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f22967j;
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
        this.f22967j = false;
        this.k = false;
        this.f22958a = jSONObject.optString("bIcon");
        this.f22959b = jSONObject.optString("bIconN");
        this.f22960c = jSONObject.optInt("bIconType");
        this.f22961d = jSONObject.optString("bSelIcon");
        this.f22962e = jSONObject.optString("bSelIconN");
        this.f22963f = jSONObject.optInt("bSelIconType");
        this.f22964g = jSONObject.optString("clickAction");
        this.f22965h = jSONObject.optString("preAction");
        this.f22966i = jSONObject.optString("statKey");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22964g : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22967j : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22967j ? this.f22961d : this.f22958a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22967j ? this.f22962e : this.f22959b : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return g(this.f22967j ? this.f22963f : this.f22960c);
        }
        return invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22965h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22966i : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (TextUtils.isEmpty(this.f22958a) && TextUtils.isEmpty(this.f22959b) && TextUtils.isEmpty(this.f22961d) && TextUtils.isEmpty(this.f22962e) && TextUtils.isEmpty(this.f22964g) && TextUtils.isEmpty(this.f22965h) && TextUtils.isEmpty(this.f22966i) && this.f22960c == 0 && this.f22963f == 0) ? false : true : invokeV.booleanValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f22967j = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }
}
