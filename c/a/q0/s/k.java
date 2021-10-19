package c.a.q0.s;

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
    public static k f14011f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14012a;

    /* renamed from: b  reason: collision with root package name */
    public int f14013b;

    /* renamed from: c  reason: collision with root package name */
    public String f14014c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14015d;

    /* renamed from: e  reason: collision with root package name */
    public int f14016e;

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
        this.f14012a = 0;
        this.f14013b = 0;
        this.f14014c = null;
        this.f14015d = true;
        this.f14016e = 0;
    }

    public static k c() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            k kVar2 = f14011f;
            if (kVar2 == null) {
                synchronized (k.class) {
                    if (f14011f == null) {
                        f14011f = new k();
                    }
                    kVar = f14011f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14014c : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            int k = j2.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
            this.f14013b = k;
            return k;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int k = c.a.q0.s.d0.b.j().k("image_quality", 0);
            this.f14012a = k;
            return k;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14016e : invokeV.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14012a = c.a.q0.s.d0.b.j().k("image_quality", 0);
            c.a.q0.s.d0.b.j().k("new_abstract_state", 0);
            this.f14016e = c.a.q0.s.d0.b.j().k("view_image_quality", 0);
            boolean g2 = c.a.q0.s.d0.b.j().g("show_images", true);
            this.f14015d = g2;
            if (g2) {
                return;
            }
            this.f14015d = true;
            c.a.q0.s.d0.b.j().C("show_images");
            c.a.q0.s.d0.b.j().v("view_image_quality", 0);
            this.f14016e = 0;
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14015d : invokeV.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f14014c = str;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f14013b == i2) {
            return;
        }
        this.f14013b = i2;
        c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
        j2.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i2);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f14016e == i2) {
            return;
        }
        this.f14016e = i2;
        c.a.q0.s.d0.b.j().v("view_image_quality", i2);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
