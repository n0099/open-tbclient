package c.b.b.n.k;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Texture a;

    /* renamed from: b  reason: collision with root package name */
    public float f28021b;

    /* renamed from: c  reason: collision with root package name */
    public float f28022c;

    /* renamed from: d  reason: collision with root package name */
    public float f28023d;

    /* renamed from: e  reason: collision with root package name */
    public float f28024e;

    /* renamed from: f  reason: collision with root package name */
    public int f28025f;

    /* renamed from: g  reason: collision with root package name */
    public int f28026g;

    public i() {
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

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                float f2 = this.f28021b;
                this.f28021b = this.f28023d;
                this.f28023d = f2;
            }
            if (z2) {
                float f3 = this.f28022c;
                this.f28022c = this.f28024e;
                this.f28024e = f3;
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28026g : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28025f : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Math.round(this.f28021b * this.a.x()) : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Math.round(this.f28022c * this.a.u()) : invokeV.intValue;
    }

    public Texture f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (Texture) invokeV.objValue;
    }

    public void g(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            int x = this.a.x();
            int u = this.a.u();
            float f6 = x;
            this.f28025f = Math.round(Math.abs(f4 - f2) * f6);
            float f7 = u;
            int round = Math.round(Math.abs(f5 - f3) * f7);
            this.f28026g = round;
            if (this.f28025f == 1 && round == 1) {
                float f8 = 0.25f / f6;
                f2 += f8;
                f4 -= f8;
                float f9 = 0.25f / f7;
                f3 += f9;
                f5 -= f9;
            }
            this.f28021b = f2;
            this.f28022c = f3;
            this.f28023d = f4;
            this.f28024e = f5;
        }
    }

    public void h(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            float x = 1.0f / this.a.x();
            float u = 1.0f / this.a.u();
            g(i2 * x, i3 * u, (i2 + i4) * x, (i3 + i5) * u);
            this.f28025f = Math.abs(i4);
            this.f28026g = Math.abs(i5);
        }
    }

    public void i(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar) == null) {
            this.a = iVar.a;
            g(iVar.f28021b, iVar.f28022c, iVar.f28023d, iVar.f28024e);
        }
    }

    public void j(i iVar, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{iVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.a = iVar.a;
            h(iVar.d() + i2, iVar.e() + i3, i4, i5);
        }
    }

    public i(Texture texture) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (texture != null) {
            this.a = texture;
            h(0, 0, texture.x(), texture.u());
            return;
        }
        throw new IllegalArgumentException("texture cannot be null.");
    }

    public i(Texture texture, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = texture;
        h(i2, i3, i4, i5);
    }

    public i(i iVar, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j(iVar, i2, i3, i4, i5);
    }
}
