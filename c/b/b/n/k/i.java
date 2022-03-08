package c.b.b.n.k;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Texture a;

    /* renamed from: b  reason: collision with root package name */
    public float f27312b;

    /* renamed from: c  reason: collision with root package name */
    public float f27313c;

    /* renamed from: d  reason: collision with root package name */
    public float f27314d;

    /* renamed from: e  reason: collision with root package name */
    public float f27315e;

    /* renamed from: f  reason: collision with root package name */
    public int f27316f;

    /* renamed from: g  reason: collision with root package name */
    public int f27317g;

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
                float f2 = this.f27312b;
                this.f27312b = this.f27314d;
                this.f27314d = f2;
            }
            if (z2) {
                float f3 = this.f27313c;
                this.f27313c = this.f27315e;
                this.f27315e = f3;
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27317g : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27316f : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Math.round(this.f27312b * this.a.x()) : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Math.round(this.f27313c * this.a.u()) : invokeV.intValue;
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
            this.f27316f = Math.round(Math.abs(f4 - f2) * f6);
            float f7 = u;
            int round = Math.round(Math.abs(f5 - f3) * f7);
            this.f27317g = round;
            if (this.f27316f == 1 && round == 1) {
                float f8 = 0.25f / f6;
                f2 += f8;
                f4 -= f8;
                float f9 = 0.25f / f7;
                f3 += f9;
                f5 -= f9;
            }
            this.f27312b = f2;
            this.f27313c = f3;
            this.f27314d = f4;
            this.f27315e = f5;
        }
    }

    public void h(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            float x = 1.0f / this.a.x();
            float u = 1.0f / this.a.u();
            g(i2 * x, i3 * u, (i2 + i4) * x, (i3 + i5) * u);
            this.f27316f = Math.abs(i4);
            this.f27317g = Math.abs(i5);
        }
    }

    public void i(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar) == null) {
            this.a = iVar.a;
            g(iVar.f27312b, iVar.f27313c, iVar.f27314d, iVar.f27315e);
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
