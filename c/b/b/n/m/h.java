package c.b.b.n.m;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(339287944, "Lc/b/b/n/m/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(339287944, "Lc/b/b/n/m/h;");
        }
    }

    public static void a(int i2, Pixmap pixmap, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), pixmap, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (!a) {
                b(i2, pixmap, i3, i4);
            } else if (c.b.b.f.a.getType() != Application.ApplicationType.Android && c.b.b.f.a.getType() != Application.ApplicationType.WebGL && c.b.b.f.a.getType() != Application.ApplicationType.iOS) {
                c(i2, pixmap, i3, i4);
            } else {
                d(i2, pixmap);
            }
        }
    }

    public static void b(int i2, Pixmap pixmap, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), pixmap, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            c.b.b.f.f27698e.q(i2, 0, pixmap.j(), pixmap.n(), pixmap.l(), 0, pixmap.i(), pixmap.k(), pixmap.m());
            if (c.b.b.f.f27699f == null && i3 != i4) {
                throw new GdxRuntimeException("texture width and height must be square when using mipmapping.");
            }
            int n = pixmap.n() / 2;
            int l = pixmap.l() / 2;
            int i5 = 1;
            Pixmap pixmap2 = pixmap;
            while (n > 0 && l > 0) {
                Pixmap pixmap3 = new Pixmap(n, l, pixmap2.h());
                pixmap3.o(Pixmap.Blending.None);
                pixmap3.f(pixmap2, 0, 0, pixmap2.n(), pixmap2.l(), 0, 0, n, l);
                if (i5 > 1) {
                    pixmap2.dispose();
                }
                pixmap2 = pixmap3;
                c.b.b.f.f27698e.q(i2, i5, pixmap3.j(), pixmap3.n(), pixmap3.l(), 0, pixmap3.i(), pixmap3.k(), pixmap3.m());
                n = pixmap2.n() / 2;
                l = pixmap2.l() / 2;
                i5++;
            }
        }
    }

    public static void c(int i2, Pixmap pixmap, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), pixmap, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (!c.b.b.f.f27695b.a("GL_ARB_framebuffer_object") && !c.b.b.f.f27695b.a("GL_EXT_framebuffer_object") && c.b.b.f.f27700g == null) {
                b(i2, pixmap, i3, i4);
                return;
            }
            c.b.b.f.f27698e.q(i2, 0, pixmap.j(), pixmap.n(), pixmap.l(), 0, pixmap.i(), pixmap.k(), pixmap.m());
            c.b.b.f.f27699f.F(i2);
        }
    }

    public static void d(int i2, Pixmap pixmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, pixmap) == null) {
            c.b.b.f.f27698e.q(i2, 0, pixmap.j(), pixmap.n(), pixmap.l(), 0, pixmap.i(), pixmap.k(), pixmap.m());
            c.b.b.f.f27699f.F(i2);
        }
    }
}
