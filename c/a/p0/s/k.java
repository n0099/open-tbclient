package c.a.p0.s;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static k f14038f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14039a;

    /* renamed from: b  reason: collision with root package name */
    public int f14040b;

    /* renamed from: c  reason: collision with root package name */
    public String f14041c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14042d;

    /* renamed from: e  reason: collision with root package name */
    public int f14043e;

    public k() {
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
        this.f14039a = 0;
        this.f14040b = 0;
        this.f14041c = null;
        this.f14042d = true;
        this.f14043e = 0;
    }

    public static k c() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            k kVar2 = f14038f;
            if (kVar2 == null) {
                synchronized (k.class) {
                    if (f14038f == null) {
                        f14038f = new k();
                    }
                    kVar = f14038f;
                }
                return kVar;
            }
            return kVar2;
        }
        return (k) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14041c : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
            int k = j2.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
            this.f14040b = k;
            return k;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int k = c.a.p0.s.d0.b.j().k("image_quality", 0);
            this.f14039a = k;
            return k;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14043e : invokeV.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14039a = c.a.p0.s.d0.b.j().k("image_quality", 0);
            c.a.p0.s.d0.b.j().k("new_abstract_state", 0);
            this.f14043e = c.a.p0.s.d0.b.j().k("view_image_quality", 0);
            boolean g2 = c.a.p0.s.d0.b.j().g("show_images", true);
            this.f14042d = g2;
            if (g2) {
                return;
            }
            this.f14042d = true;
            c.a.p0.s.d0.b.j().C("show_images");
            c.a.p0.s.d0.b.j().v("view_image_quality", 0);
            this.f14043e = 0;
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14042d : invokeV.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f14041c = str;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f14040b == i2) {
            return;
        }
        this.f14040b = i2;
        c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
        j2.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i2);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f14043e == i2) {
            return;
        }
        this.f14043e = i2;
        c.a.p0.s.d0.b.j().v("view_image_quality", i2);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
