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
/* loaded from: classes3.dex */
public abstract class e implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static float f22472h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public int f22473b;

    /* renamed from: c  reason: collision with root package name */
    public Texture.TextureFilter f22474c;

    /* renamed from: d  reason: collision with root package name */
    public Texture.TextureFilter f22475d;

    /* renamed from: e  reason: collision with root package name */
    public Texture.TextureWrap f22476e;

    /* renamed from: f  reason: collision with root package name */
    public Texture.TextureWrap f22477f;

    /* renamed from: g  reason: collision with root package name */
    public float f22478g;

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
    public e(int i) {
        this(i, c.b.b.f.f22334e.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            float f2 = f22472h;
            if (f2 > 0.0f) {
                return f2;
            }
            if (c.b.b.f.f22331b.a("GL_EXT_texture_filter_anisotropic")) {
                FloatBuffer c2 = BufferUtils.c(16);
                c2.position(0);
                c2.limit(c2.capacity());
                c.b.b.f.f22335f.i(34047, c2);
                float f3 = c2.get(0);
                f22472h = f3;
                return f3;
            }
            f22472h = 1.0f;
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    public static void q(int i, TextureData textureData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, textureData) == null) {
            r(i, textureData, 0);
        }
    }

    public static void r(int i, TextureData textureData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), textureData, Integer.valueOf(i2)}) == null) || textureData == null) {
            return;
        }
        if (!textureData.a()) {
            textureData.prepare();
        }
        if (textureData.getType() == TextureData.TextureDataType.Custom) {
            textureData.c(i);
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
        c.b.b.f.f22334e.g(3317, 1);
        if (textureData.g()) {
            c.b.b.n.m.h.a(i, d2, d2.n(), d2.l());
        } else {
            c.b.b.f.f22334e.q(i, i2, d2.j(), d2.n(), d2.l(), 0, d2.i(), d2.k(), d2.m());
        }
        if (h2) {
            d2.dispose();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.f.f22334e.N(this.a, this.f22473b);
        }
    }

    public void delete() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (i = this.f22473b) == 0) {
            return;
        }
        c.b.b.f.f22334e.S(i);
        this.f22473b = 0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22475d : (Texture.TextureFilter) invokeV.objValue;
    }

    public Texture.TextureFilter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22474c : (Texture.TextureFilter) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22473b : invokeV.intValue;
    }

    public Texture.TextureWrap j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22476e : (Texture.TextureWrap) invokeV.objValue;
    }

    public Texture.TextureWrap k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22477f : (Texture.TextureWrap) invokeV.objValue;
    }

    public void l(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textureFilter, textureFilter2) == null) {
            this.f22474c = textureFilter;
            this.f22475d = textureFilter2;
            a();
            c.b.b.f.f22334e.j(this.a, 10241, textureFilter.getGLEnum());
            c.b.b.f.f22334e.j(this.a, 10240, textureFilter2.getGLEnum());
        }
    }

    public void m(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, textureWrap, textureWrap2) == null) {
            this.f22476e = textureWrap;
            this.f22477f = textureWrap2;
            a();
            c.b.b.f.f22334e.j(this.a, 10242, textureWrap.getGLEnum());
            c.b.b.f.f22334e.j(this.a, 10243, textureWrap2.getGLEnum());
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
            if (!z && com.badlogic.gdx.math.d.f(min, this.f22478g, 0.1f)) {
                return this.f22478g;
            }
            c.b.b.f.f22335f.u(3553, 34046, min);
            this.f22478g = min;
            return min;
        }
        return invokeCommon.floatValue;
    }

    public void o(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048587, this, textureFilter, textureFilter2, z) == null) {
            if (textureFilter != null && (z || this.f22474c != textureFilter)) {
                c.b.b.f.f22334e.j(this.a, 10241, textureFilter.getGLEnum());
                this.f22474c = textureFilter;
            }
            if (textureFilter2 != null) {
                if (z || this.f22475d != textureFilter2) {
                    c.b.b.f.f22334e.j(this.a, 10240, textureFilter2.getGLEnum());
                    this.f22475d = textureFilter2;
                }
            }
        }
    }

    public void p(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, textureWrap, textureWrap2, z) == null) {
            if (textureWrap != null && (z || this.f22476e != textureWrap)) {
                c.b.b.f.f22334e.j(this.a, 10242, textureWrap.getGLEnum());
                this.f22476e = textureWrap;
            }
            if (textureWrap2 != null) {
                if (z || this.f22477f != textureWrap2) {
                    c.b.b.f.f22334e.j(this.a, 10243, textureWrap2.getGLEnum());
                    this.f22477f = textureWrap2;
                }
            }
        }
    }

    public e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
        this.f22474c = textureFilter;
        this.f22475d = textureFilter;
        Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
        this.f22476e = textureWrap;
        this.f22477f = textureWrap;
        this.f22478g = 1.0f;
        this.a = i;
        this.f22473b = i2;
    }
}
