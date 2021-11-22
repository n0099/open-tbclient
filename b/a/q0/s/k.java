package b.a.q0.s;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static k f13910f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13911a;

    /* renamed from: b  reason: collision with root package name */
    public int f13912b;

    /* renamed from: c  reason: collision with root package name */
    public String f13913c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13914d;

    /* renamed from: e  reason: collision with root package name */
    public int f13915e;

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
        this.f13911a = 0;
        this.f13912b = 0;
        this.f13913c = null;
        this.f13914d = true;
        this.f13915e = 0;
    }

    public static k c() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            k kVar2 = f13910f;
            if (kVar2 == null) {
                synchronized (k.class) {
                    if (f13910f == null) {
                        f13910f = new k();
                    }
                    kVar = f13910f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13913c : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
            int k = j.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
            this.f13912b = k;
            return k;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int k = b.a.q0.s.e0.b.j().k("image_quality", 0);
            this.f13911a = k;
            return k;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13915e : invokeV.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13911a = b.a.q0.s.e0.b.j().k("image_quality", 0);
            b.a.q0.s.e0.b.j().k("new_abstract_state", 0);
            this.f13915e = b.a.q0.s.e0.b.j().k("view_image_quality", 0);
            boolean g2 = b.a.q0.s.e0.b.j().g("show_images", true);
            this.f13914d = g2;
            if (g2) {
                return;
            }
            this.f13914d = true;
            b.a.q0.s.e0.b.j().C("show_images");
            b.a.q0.s.e0.b.j().v("view_image_quality", 0);
            this.f13915e = 0;
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13914d : invokeV.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f13913c = str;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f13912b == i2) {
            return;
        }
        this.f13912b = i2;
        b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
        j.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i2);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f13915e == i2) {
            return;
        }
        this.f13915e = i2;
        b.a.q0.s.e0.b.j().v("view_image_quality", i2);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
