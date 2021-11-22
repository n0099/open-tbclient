package b.a.q0.s.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes4.dex */
public class b0 implements b.a.q0.s.w.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13992a;

    /* renamed from: b  reason: collision with root package name */
    public String f13993b;

    /* renamed from: c  reason: collision with root package name */
    public String f13994c;

    /* renamed from: d  reason: collision with root package name */
    public String f13995d;

    /* renamed from: e  reason: collision with root package name */
    public String f13996e;

    /* renamed from: f  reason: collision with root package name */
    public String f13997f;

    /* renamed from: g  reason: collision with root package name */
    public String f13998g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13999h;

    /* renamed from: i  reason: collision with root package name */
    public String f14000i;
    public float j;
    public List<String> k;
    public b.a.r0.m3.y l;

    public b0(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13992a = str;
        this.f13993b = str2;
        this.f13996e = str3;
    }

    @Override // b.a.q0.s.w.b.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13992a : (String) invokeV.objValue;
    }

    @Override // b.a.q0.s.w.b.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13993b : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public b0 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b0 b0Var = new b0();
            b0Var.f13992a = this.f13992a;
            b0Var.f13993b = this.f13993b;
            b0Var.f13994c = this.f13994c;
            b0Var.f13996e = this.f13996e;
            b0Var.f13997f = this.f13997f;
            b0Var.f13998g = this.f13998g;
            b0Var.f14000i = this.f14000i;
            b0Var.j = this.j;
            b0Var.k = this.k;
            b0Var.f13995d = this.f13995d;
            return b0Var;
        }
        return (b0) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13992a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13993b : (String) invokeV.objValue;
    }

    public b.a.r0.m3.y f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (b.a.r0.m3.y) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13995d : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13994c : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f14000i : (String) invokeV.objValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : invokeV.floatValue;
    }

    public List<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f13999h : invokeV.booleanValue;
    }

    public void m(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, headImgs) == null) || headImgs == null) {
            return;
        }
        this.f13992a = headImgs.img_url;
        this.f13993b = headImgs.pc_url;
        this.f13994c = headImgs.schema;
        this.f14000i = headImgs.tag_name_url;
        this.f13995d = headImgs.package_name;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int e2 = b.a.e.f.m.b.e(split[0], 1);
                int e3 = b.a.e.f.m.b.e(split[1], 1);
                if (e3 != 0) {
                    this.j = e2 / e3;
                }
            } catch (Exception e4) {
                BdLog.e(e4.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f13996e = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f13997f = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f13998g = str4.trim();
        }
        this.k = headImgs.third_statistics_url;
        b.a.r0.m3.y yVar = new b.a.r0.m3.y();
        this.l = yVar;
        yVar.d(headImgs);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f13992a = str;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f13993b = str;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f13999h = z;
        }
    }

    public b0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
