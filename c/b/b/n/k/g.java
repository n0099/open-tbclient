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
public class g extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f27146h;

    /* renamed from: i  reason: collision with root package name */
    public final c.b.b.n.a f27147i;

    /* renamed from: j  reason: collision with root package name */
    public float f27148j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public boolean s;

    public g() {
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
        this.f27146h = new float[20];
        this.f27147i = new c.b.b.n.a(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = true;
        t(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void A(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f27148j += f2;
            this.k += f3;
            if (this.s) {
                return;
            }
            if (this.p == 0.0f && this.q == 1.0f && this.r == 1.0f) {
                float[] fArr = this.f27146h;
                fArr[0] = fArr[0] + f2;
                fArr[1] = fArr[1] + f3;
                fArr[5] = fArr[5] + f2;
                fArr[6] = fArr[6] + f3;
                fArr[10] = fArr[10] + f2;
                fArr[11] = fArr[11] + f3;
                fArr[15] = fArr[15] + f2;
                fArr[16] = fArr[16] + f3;
                return;
            }
            this.s = true;
        }
    }

    @Override // c.b.b.n.k.i
    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.a(z, z2);
            float[] fArr = this.f27146h;
            if (z) {
                float f2 = fArr[3];
                fArr[3] = fArr[13];
                fArr[13] = f2;
                float f3 = fArr[8];
                fArr[8] = fArr[18];
                fArr[18] = f3;
            }
            if (z2) {
                float f4 = fArr[4];
                fArr[4] = fArr[14];
                fArr[14] = f4;
                float f5 = fArr[9];
                fArr[9] = fArr[19];
                fArr[19] = f5;
            }
        }
    }

    @Override // c.b.b.n.k.i
    public void g(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            super.g(f2, f3, f4, f5);
            float[] fArr = this.f27146h;
            fArr[3] = f2;
            fArr[4] = f5;
            fArr[8] = f2;
            fArr[9] = f3;
            fArr[13] = f4;
            fArr[14] = f3;
            fArr[18] = f4;
            fArr[19] = f5;
        }
    }

    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : invokeV.floatValue;
    }

    public float l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.floatValue;
    }

    public float m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : invokeV.floatValue;
    }

    public float n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : invokeV.floatValue;
    }

    public float o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f27148j : invokeV.floatValue;
    }

    public float p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.floatValue;
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            float[] fArr = this.f27146h;
            if (z) {
                float f2 = fArr[4];
                fArr[4] = fArr[19];
                fArr[19] = fArr[14];
                fArr[14] = fArr[9];
                fArr[9] = f2;
                float f3 = fArr[3];
                fArr[3] = fArr[18];
                fArr[18] = fArr[13];
                fArr[13] = fArr[8];
                fArr[8] = f3;
                return;
            }
            float f4 = fArr[4];
            fArr[4] = fArr[9];
            fArr[9] = fArr[14];
            fArr[14] = fArr[19];
            fArr[19] = f4;
            float f5 = fArr[3];
            fArr[3] = fArr[8];
            fArr[8] = fArr[13];
            fArr[13] = fArr[18];
            fArr[18] = f5;
        }
    }

    public void r(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            if (gVar != null) {
                System.arraycopy(gVar.f27146h, 0, this.f27146h, 0, 20);
                this.a = gVar.a;
                this.f27174b = gVar.f27174b;
                this.f27175c = gVar.f27175c;
                this.f27176d = gVar.f27176d;
                this.f27177e = gVar.f27177e;
                this.f27148j = gVar.f27148j;
                this.k = gVar.k;
                this.l = gVar.l;
                this.m = gVar.m;
                this.f27178f = gVar.f27178f;
                this.f27179g = gVar.f27179g;
                this.n = gVar.n;
                this.o = gVar.o;
                this.p = gVar.p;
                this.q = gVar.q;
                this.r = gVar.r;
                this.f27147i.e(gVar.f27147i);
                this.s = gVar.s;
                return;
            }
            throw new IllegalArgumentException("sprite cannot be null.");
        }
    }

    public void s(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.f27148j = f2;
            this.k = f3;
            this.l = f4;
            this.m = f5;
            if (this.s) {
                return;
            }
            if (this.p == 0.0f && this.q == 1.0f && this.r == 1.0f) {
                float f6 = f4 + f2;
                float f7 = f5 + f3;
                float[] fArr = this.f27146h;
                fArr[0] = f2;
                fArr[1] = f3;
                fArr[5] = f2;
                fArr[6] = f7;
                fArr[10] = f6;
                fArr[11] = f7;
                fArr[15] = f6;
                fArr[16] = f3;
                return;
            }
            this.s = true;
        }
    }

    public void t(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.f27147i.d(f2, f3, f4, f5);
            float f6 = this.f27147i.f();
            float[] fArr = this.f27146h;
            fArr[2] = f6;
            fArr[7] = f6;
            fArr[12] = f6;
            fArr[17] = f6;
        }
    }

    public void u(c.b.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f27147i.e(aVar);
            float f2 = aVar.f();
            float[] fArr = this.f27146h;
            fArr[2] = f2;
            fArr[7] = f2;
            fArr[12] = f2;
            fArr[17] = f2;
        }
    }

    public void v(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.n = f2;
            this.o = f3;
            this.s = true;
        }
    }

    public void w(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.p = f2;
            this.s = true;
        }
    }

    public void x(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.q = f2;
            this.r = f2;
            this.s = true;
        }
    }

    public void y(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.q = f2;
            this.r = f3;
            this.s = true;
        }
    }

    public void z(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.l = f2;
            this.m = f3;
            if (this.s) {
                return;
            }
            if (this.p == 0.0f && this.q == 1.0f && this.r == 1.0f) {
                float f4 = this.f27148j;
                float f5 = f2 + f4;
                float f6 = this.k;
                float f7 = f3 + f6;
                float[] fArr = this.f27146h;
                fArr[0] = f4;
                fArr[1] = f6;
                fArr[5] = f4;
                fArr[6] = f7;
                fArr[10] = f5;
                fArr[11] = f7;
                fArr[15] = f5;
                fArr[16] = f6;
                return;
            }
            this.s = true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Texture texture) {
        this(texture, 0, 0, texture.x(), texture.u());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Texture) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public g(Texture texture, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f27146h = new float[20];
        this.f27147i = new c.b.b.n.a(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = true;
        if (texture != null) {
            this.a = texture;
            h(i2, i3, i4, i5);
            t(1.0f, 1.0f, 1.0f, 1.0f);
            z(Math.abs(i4), Math.abs(i5));
            v(this.l / 2.0f, this.m / 2.0f);
            return;
        }
        throw new IllegalArgumentException("texture cannot be null.");
    }

    public g(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27146h = new float[20];
        this.f27147i = new c.b.b.n.a(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = true;
        i(iVar);
        t(1.0f, 1.0f, 1.0f, 1.0f);
        z(iVar.c(), iVar.b());
        v(this.l / 2.0f, this.m / 2.0f);
    }

    public g(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27146h = new float[20];
        this.f27147i = new c.b.b.n.a(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = true;
        r(gVar);
    }
}
