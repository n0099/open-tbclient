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
    public float f22542b;

    /* renamed from: c  reason: collision with root package name */
    public float f22543c;

    /* renamed from: d  reason: collision with root package name */
    public float f22544d;

    /* renamed from: e  reason: collision with root package name */
    public float f22545e;

    /* renamed from: f  reason: collision with root package name */
    public int f22546f;

    /* renamed from: g  reason: collision with root package name */
    public int f22547g;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                float f2 = this.f22542b;
                this.f22542b = this.f22544d;
                this.f22544d = f2;
            }
            if (z2) {
                float f3 = this.f22543c;
                this.f22543c = this.f22545e;
                this.f22545e = f3;
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22547g : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22546f : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Math.round(this.f22542b * this.a.x()) : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Math.round(this.f22543c * this.a.u()) : invokeV.intValue;
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
            this.f22546f = Math.round(Math.abs(f4 - f2) * f6);
            float f7 = u;
            int round = Math.round(Math.abs(f5 - f3) * f7);
            this.f22547g = round;
            if (this.f22546f == 1 && round == 1) {
                float f8 = 0.25f / f6;
                f2 += f8;
                f4 -= f8;
                float f9 = 0.25f / f7;
                f3 += f9;
                f5 -= f9;
            }
            this.f22542b = f2;
            this.f22543c = f3;
            this.f22544d = f4;
            this.f22545e = f5;
        }
    }

    public void h(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            float x = 1.0f / this.a.x();
            float u = 1.0f / this.a.u();
            g(i * x, i2 * u, (i + i3) * x, (i2 + i4) * u);
            this.f22546f = Math.abs(i3);
            this.f22547g = Math.abs(i4);
        }
    }

    public void i(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar) == null) {
            this.a = iVar.a;
            g(iVar.f22542b, iVar.f22543c, iVar.f22544d, iVar.f22545e);
        }
    }

    public void j(i iVar, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{iVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.a = iVar.a;
            h(iVar.d() + i, iVar.e() + i2, i3, i4);
        }
    }

    public i(Texture texture) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public i(Texture texture, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = texture;
        h(i, i2, i3, i4);
    }

    public i(i iVar, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j(iVar, i, i2, i3, i4);
    }
}
