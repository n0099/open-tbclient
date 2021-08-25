package c.a.p0.s.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes3.dex */
public class b1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14141a;

    /* renamed from: b  reason: collision with root package name */
    public int f14142b;

    /* renamed from: c  reason: collision with root package name */
    public int f14143c;

    /* renamed from: d  reason: collision with root package name */
    public int f14144d;

    /* renamed from: e  reason: collision with root package name */
    public int f14145e;

    /* renamed from: f  reason: collision with root package name */
    public int f14146f;

    /* renamed from: g  reason: collision with root package name */
    public int f14147g;

    /* renamed from: h  reason: collision with root package name */
    public int f14148h;

    public b1() {
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
        this.f14141a = 0;
        this.f14142b = 0;
        this.f14145e = 0;
        this.f14146f = 0;
        this.f14147g = 0;
        this.f14148h = 0;
        this.f14143c = 0;
        this.f14144d = 0;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14145e : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14147g : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14148h : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14144d : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14146f : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14143c : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14142b : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14141a : invokeV.intValue;
    }

    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14141a = jSONObject.optInt("total_page", 0);
            this.f14142b = jSONObject.optInt("total_num", 0);
            this.f14143c = jSONObject.optInt("total_count", 0);
            this.f14145e = jSONObject.optInt("current_page", 0);
            this.f14146f = jSONObject.optInt("page_size", 0);
            this.f14147g = jSONObject.optInt("has_more", 0);
            this.f14148h = jSONObject.optInt("has_prev", 0);
            this.f14144d = jSONObject.optInt("lz_total_floor", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(Page page) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, page) == null) || page == null) {
            return;
        }
        this.f14141a = page.total_page.intValue();
        this.f14142b = page.total_num.intValue();
        this.f14143c = page.total_count.intValue();
        this.f14145e = page.current_page.intValue();
        this.f14146f = page.page_size.intValue();
        this.f14147g = page.has_more.intValue();
        this.f14148h = page.has_prev.intValue();
        this.f14144d = page.lz_total_floor.intValue();
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f14145e = i2;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f14147g = i2;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f14148h = i2;
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f14144d = i2;
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f14146f = i2;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f14142b = i2;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f14141a = i2;
        }
    }
}
