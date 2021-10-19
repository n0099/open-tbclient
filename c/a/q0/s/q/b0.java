package c.a.q0.s.q;

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
public class b0 implements c.a.q0.s.w.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14095a;

    /* renamed from: b  reason: collision with root package name */
    public String f14096b;

    /* renamed from: c  reason: collision with root package name */
    public String f14097c;

    /* renamed from: d  reason: collision with root package name */
    public String f14098d;

    /* renamed from: e  reason: collision with root package name */
    public String f14099e;

    /* renamed from: f  reason: collision with root package name */
    public String f14100f;

    /* renamed from: g  reason: collision with root package name */
    public String f14101g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14102h;

    /* renamed from: i  reason: collision with root package name */
    public String f14103i;

    /* renamed from: j  reason: collision with root package name */
    public float f14104j;
    public List<String> k;

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
        this.f14095a = str;
        this.f14096b = str2;
        this.f14099e = str3;
    }

    @Override // c.a.q0.s.w.b.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14095a : (String) invokeV.objValue;
    }

    @Override // c.a.q0.s.w.b.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14096b : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public b0 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b0 b0Var = new b0();
            b0Var.f14095a = this.f14095a;
            b0Var.f14096b = this.f14096b;
            b0Var.f14097c = this.f14097c;
            b0Var.f14099e = this.f14099e;
            b0Var.f14100f = this.f14100f;
            b0Var.f14101g = this.f14101g;
            b0Var.f14103i = this.f14103i;
            b0Var.f14104j = this.f14104j;
            b0Var.k = this.k;
            b0Var.f14098d = this.f14098d;
            return b0Var;
        }
        return (b0) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14095a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14096b : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14098d : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14097c : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f14103i : (String) invokeV.objValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f14104j : invokeV.floatValue;
    }

    public List<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f14102h : invokeV.booleanValue;
    }

    public void l(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, headImgs) == null) || headImgs == null) {
            return;
        }
        this.f14095a = headImgs.img_url;
        this.f14096b = headImgs.pc_url;
        this.f14097c = headImgs.schema;
        this.f14103i = headImgs.tag_name_url;
        this.f14098d = headImgs.package_name;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int e2 = c.a.e.e.m.b.e(split[0], 1);
                int e3 = c.a.e.e.m.b.e(split[1], 1);
                if (e3 != 0) {
                    this.f14104j = e2 / e3;
                }
            } catch (Exception e4) {
                BdLog.e(e4.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f14099e = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f14100f = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f14101g = str4.trim();
        }
        this.k = headImgs.third_statistics_url;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f14095a = str;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f14096b = str;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f14102h = z;
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
