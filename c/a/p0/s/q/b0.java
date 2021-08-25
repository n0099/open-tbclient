package c.a.p0.s.q;

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
/* loaded from: classes3.dex */
public class b0 implements c.a.p0.s.w.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14131a;

    /* renamed from: b  reason: collision with root package name */
    public String f14132b;

    /* renamed from: c  reason: collision with root package name */
    public String f14133c;

    /* renamed from: d  reason: collision with root package name */
    public String f14134d;

    /* renamed from: e  reason: collision with root package name */
    public String f14135e;

    /* renamed from: f  reason: collision with root package name */
    public String f14136f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14137g;

    /* renamed from: h  reason: collision with root package name */
    public String f14138h;

    /* renamed from: i  reason: collision with root package name */
    public float f14139i;

    /* renamed from: j  reason: collision with root package name */
    public List<String> f14140j;

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
        this.f14131a = str;
        this.f14132b = str2;
        this.f14134d = str3;
    }

    @Override // c.a.p0.s.w.b.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14131a : (String) invokeV.objValue;
    }

    @Override // c.a.p0.s.w.b.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14132b : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public b0 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b0 b0Var = new b0();
            b0Var.f14131a = this.f14131a;
            b0Var.f14132b = this.f14132b;
            b0Var.f14133c = this.f14133c;
            b0Var.f14134d = this.f14134d;
            b0Var.f14135e = this.f14135e;
            b0Var.f14136f = this.f14136f;
            b0Var.f14138h = this.f14138h;
            b0Var.f14139i = this.f14139i;
            b0Var.f14140j = this.f14140j;
            return b0Var;
        }
        return (b0) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14131a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14132b : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14133c : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14138h : (String) invokeV.objValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f14139i : invokeV.floatValue;
    }

    public List<String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f14140j : (List) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f14137g : invokeV.booleanValue;
    }

    public void k(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, headImgs) == null) || headImgs == null) {
            return;
        }
        this.f14131a = headImgs.img_url;
        this.f14132b = headImgs.pc_url;
        this.f14133c = headImgs.schema;
        this.f14138h = headImgs.tag_name_url;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int d2 = c.a.e.e.m.b.d(split[0], 1);
                int d3 = c.a.e.e.m.b.d(split[1], 1);
                if (d3 != 0) {
                    this.f14139i = d2 / d3;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f14134d = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f14135e = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f14136f = str4.trim();
        }
        this.f14140j = headImgs.third_statistics_url;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f14131a = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f14132b = str;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f14137g = z;
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
