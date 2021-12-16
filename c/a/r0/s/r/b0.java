package c.a.r0.s.r;

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
/* loaded from: classes6.dex */
public class b0 implements c.a.r0.s.x.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f13223b;

    /* renamed from: c  reason: collision with root package name */
    public String f13224c;

    /* renamed from: d  reason: collision with root package name */
    public String f13225d;

    /* renamed from: e  reason: collision with root package name */
    public String f13226e;

    /* renamed from: f  reason: collision with root package name */
    public String f13227f;

    /* renamed from: g  reason: collision with root package name */
    public String f13228g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13229h;

    /* renamed from: i  reason: collision with root package name */
    public String f13230i;

    /* renamed from: j  reason: collision with root package name */
    public float f13231j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f13232k;
    public c.a.s0.v3.y l;

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
        this.a = str;
        this.f13223b = str2;
        this.f13226e = str3;
    }

    @Override // c.a.r0.s.x.b.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // c.a.r0.s.x.b.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13223b : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public b0 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b0 b0Var = new b0();
            b0Var.a = this.a;
            b0Var.f13223b = this.f13223b;
            b0Var.f13224c = this.f13224c;
            b0Var.f13226e = this.f13226e;
            b0Var.f13227f = this.f13227f;
            b0Var.f13228g = this.f13228g;
            b0Var.f13230i = this.f13230i;
            b0Var.f13231j = this.f13231j;
            b0Var.f13232k = this.f13232k;
            b0Var.f13225d = this.f13225d;
            return b0Var;
        }
        return (b0) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13223b : (String) invokeV.objValue;
    }

    public c.a.s0.v3.y f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (c.a.s0.v3.y) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13225d : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13224c : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f13230i : (String) invokeV.objValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f13231j : invokeV.floatValue;
    }

    public List<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f13232k : (List) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f13229h : invokeV.booleanValue;
    }

    public void m(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, headImgs) == null) || headImgs == null) {
            return;
        }
        this.a = headImgs.img_url;
        this.f13223b = headImgs.pc_url;
        this.f13224c = headImgs.schema;
        this.f13230i = headImgs.tag_name_url;
        this.f13225d = headImgs.package_name;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int e2 = c.a.d.f.m.b.e(split[0], 1);
                int e3 = c.a.d.f.m.b.e(split[1], 1);
                if (e3 != 0) {
                    this.f13231j = e2 / e3;
                }
            } catch (Exception e4) {
                BdLog.e(e4.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f13226e = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f13227f = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f13228g = str4.trim();
        }
        this.f13232k = headImgs.third_statistics_url;
        c.a.s0.v3.y yVar = new c.a.s0.v3.y();
        this.l = yVar;
        yVar.d(headImgs);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.a = str;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f13223b = str;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f13229h = z;
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
