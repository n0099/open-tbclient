package c.b.b.n;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
/* loaded from: classes9.dex */
public abstract class e implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic;
    public static float l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f27924e;

    /* renamed from: f  reason: collision with root package name */
    public int f27925f;

    /* renamed from: g  reason: collision with root package name */
    public Texture.TextureFilter f27926g;

    /* renamed from: h  reason: collision with root package name */
    public Texture.TextureFilter f27927h;

    /* renamed from: i  reason: collision with root package name */
    public Texture.TextureWrap f27928i;

    /* renamed from: j  reason: collision with root package name */
    public Texture.TextureWrap f27929j;

    /* renamed from: k  reason: collision with root package name */
    public float f27930k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(156777225, "Lc/b/b/n/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(156777225, "Lc/b/b/n/e;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(int i2) {
        this(i2, c.b.b.f.f27772e.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            float f2 = l;
            if (f2 > 0.0f) {
                return f2;
            }
            if (c.b.b.f.f27769b.a("GL_EXT_texture_filter_anisotropic")) {
                FloatBuffer c2 = BufferUtils.c(16);
                c2.position(0);
                c2.limit(c2.capacity());
                c.b.b.f.f27773f.i(34047, c2);
                float f3 = c2.get(0);
                l = f3;
                return f3;
            }
            l = 1.0f;
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    public static void q(int i2, TextureData textureData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, textureData) == null) {
            r(i2, textureData, 0);
        }
    }

    public static void r(int i2, TextureData textureData, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), textureData, Integer.valueOf(i3)}) == null) || textureData == null) {
            return;
        }
        if (!textureData.a()) {
            textureData.prepare();
        }
        if (textureData.getType() == TextureData.TextureDataType.Custom) {
            textureData.c(i2);
            return;
        }
        Pixmap d2 = textureData.d();
        boolean h2 = textureData.h();
        if (textureData.e() != d2.h()) {
            Pixmap pixmap = new Pixmap(d2.n(), d2.l(), textureData.e());
            pixmap.o(Pixmap.Blending.None);
            pixmap.a(d2, 0, 0, 0, 0, d2.n(), d2.l());
            if (textureData.h()) {
                d2.dispose();
            }
            d2 = pixmap;
            h2 = true;
        }
        c.b.b.f.f27772e.g(3317, 1);
        if (textureData.g()) {
            c.b.b.n.m.h.a(i2, d2, d2.n(), d2.l());
        } else {
            c.b.b.f.f27772e.q(i2, i3, d2.j(), d2.n(), d2.l(), 0, d2.i(), d2.k(), d2.m());
        }
        if (h2) {
            d2.dispose();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.f.f27772e.N(this.f27924e, this.f27925f);
        }
    }

    public void delete() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (i2 = this.f27925f) == 0) {
            return;
        }
        c.b.b.f.f27772e.S(i2);
        this.f27925f = 0;
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            delete();
        }
    }

    public Texture.TextureFilter f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27927h : (Texture.TextureFilter) invokeV.objValue;
    }

    public Texture.TextureFilter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27926g : (Texture.TextureFilter) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27925f : invokeV.intValue;
    }

    public Texture.TextureWrap j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27928i : (Texture.TextureWrap) invokeV.objValue;
    }

    public Texture.TextureWrap k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f27929j : (Texture.TextureWrap) invokeV.objValue;
    }

    public void l(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textureFilter, textureFilter2) == null) {
            this.f27926g = textureFilter;
            this.f27927h = textureFilter2;
            a();
            c.b.b.f.f27772e.j(this.f27924e, 10241, textureFilter.getGLEnum());
            c.b.b.f.f27772e.j(this.f27924e, 10240, textureFilter2.getGLEnum());
        }
    }

    public void m(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, textureWrap, textureWrap2) == null) {
            this.f27928i = textureWrap;
            this.f27929j = textureWrap2;
            a();
            c.b.b.f.f27772e.j(this.f27924e, 10242, textureWrap.getGLEnum());
            c.b.b.f.f27772e.j(this.f27924e, 10243, textureWrap2.getGLEnum());
        }
    }

    public float n(float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            float g2 = g();
            if (g2 == 1.0f) {
                return 1.0f;
            }
            float min = Math.min(f2, g2);
            if (!z && com.badlogic.gdx.math.d.f(min, this.f27930k, 0.1f)) {
                return this.f27930k;
            }
            c.b.b.f.f27773f.u(3553, 34046, min);
            this.f27930k = min;
            return min;
        }
        return invokeCommon.floatValue;
    }

    public void o(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048587, this, textureFilter, textureFilter2, z) == null) {
            if (textureFilter != null && (z || this.f27926g != textureFilter)) {
                c.b.b.f.f27772e.j(this.f27924e, 10241, textureFilter.getGLEnum());
                this.f27926g = textureFilter;
            }
            if (textureFilter2 != null) {
                if (z || this.f27927h != textureFilter2) {
                    c.b.b.f.f27772e.j(this.f27924e, 10240, textureFilter2.getGLEnum());
                    this.f27927h = textureFilter2;
                }
            }
        }
    }

    public void p(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, textureWrap, textureWrap2, z) == null) {
            if (textureWrap != null && (z || this.f27928i != textureWrap)) {
                c.b.b.f.f27772e.j(this.f27924e, 10242, textureWrap.getGLEnum());
                this.f27928i = textureWrap;
            }
            if (textureWrap2 != null) {
                if (z || this.f27929j != textureWrap2) {
                    c.b.b.f.f27772e.j(this.f27924e, 10243, textureWrap2.getGLEnum());
                    this.f27929j = textureWrap2;
                }
            }
        }
    }

    public e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
        this.f27926g = textureFilter;
        this.f27927h = textureFilter;
        Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
        this.f27928i = textureWrap;
        this.f27929j = textureWrap;
        this.f27930k = 1.0f;
        this.f27924e = i2;
        this.f27925f = i3;
    }
}
