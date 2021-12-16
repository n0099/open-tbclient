package c.a.r0.s;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static l f13156f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13157b;

    /* renamed from: c  reason: collision with root package name */
    public String f13158c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13159d;

    /* renamed from: e  reason: collision with root package name */
    public int f13160e;

    public l() {
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
        this.a = 0;
        this.f13157b = 0;
        this.f13158c = null;
        this.f13159d = true;
        this.f13160e = 0;
    }

    public static l c() {
        InterceptResult invokeV;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            l lVar2 = f13156f;
            if (lVar2 == null) {
                synchronized (l.class) {
                    if (f13156f == null) {
                        f13156f = new l();
                    }
                    lVar = f13156f;
                }
                return lVar;
            }
            return lVar2;
        }
        return (l) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13158c : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.r0.s.g0.b j2 = c.a.r0.s.g0.b.j();
            int k2 = j2.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
            this.f13157b = k2;
            return k2;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int k2 = c.a.r0.s.g0.b.j().k("image_quality", 0);
            this.a = k2;
            return k2;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13160e : invokeV.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = c.a.r0.s.g0.b.j().k("image_quality", 0);
            c.a.r0.s.g0.b.j().k("new_abstract_state", 0);
            this.f13160e = c.a.r0.s.g0.b.j().k("view_image_quality", 0);
            boolean g2 = c.a.r0.s.g0.b.j().g("show_images", true);
            this.f13159d = g2;
            if (g2) {
                return;
            }
            this.f13159d = true;
            c.a.r0.s.g0.b.j().C("show_images");
            c.a.r0.s.g0.b.j().v("view_image_quality", 0);
            this.f13160e = 0;
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13159d : invokeV.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f13158c = str;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f13157b == i2) {
            return;
        }
        this.f13157b = i2;
        c.a.r0.s.g0.b j2 = c.a.r0.s.g0.b.j();
        j2.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i2);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f13160e == i2) {
            return;
        }
        this.f13160e = i2;
        c.a.r0.s.g0.b.j().v("view_image_quality", i2);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
