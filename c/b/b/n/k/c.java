package c.b.b.n.k;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Texture a;

    /* renamed from: b  reason: collision with root package name */
    public int f27364b;

    /* renamed from: c  reason: collision with root package name */
    public int f27365c;

    /* renamed from: d  reason: collision with root package name */
    public int f27366d;

    /* renamed from: e  reason: collision with root package name */
    public int f27367e;

    /* renamed from: f  reason: collision with root package name */
    public int f27368f;

    /* renamed from: g  reason: collision with root package name */
    public int f27369g;

    /* renamed from: h  reason: collision with root package name */
    public int f27370h;

    /* renamed from: i  reason: collision with root package name */
    public int f27371i;

    /* renamed from: j  reason: collision with root package name */
    public int f27372j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float[] q;
    public int r;
    public final c.b.b.n.a s;
    public float t;
    public float u;
    public float v;
    public float w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(339228207, "Lc/b/b/n/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(339228207, "Lc/b/b/n/k/c;");
            }
        }
    }

    public c(i iVar, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {iVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new c.b.b.n.a(c.b.b.n.a.f27315e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        if (iVar != null) {
            int c2 = (iVar.c() - i2) - i3;
            int b2 = (iVar.b() - i4) - i5;
            i[] iVarArr = new i[9];
            if (i4 > 0) {
                if (i2 > 0) {
                    iVarArr[0] = new i(iVar, 0, 0, i2, i4);
                }
                if (c2 > 0) {
                    iVarArr[1] = new i(iVar, i2, 0, c2, i4);
                }
                if (i3 > 0) {
                    iVarArr[2] = new i(iVar, i2 + c2, 0, i3, i4);
                }
            }
            if (b2 > 0) {
                if (i2 > 0) {
                    iVarArr[3] = new i(iVar, 0, i4, i2, b2);
                }
                if (c2 > 0) {
                    iVarArr[4] = new i(iVar, i2, i4, c2, b2);
                }
                if (i3 > 0) {
                    iVarArr[5] = new i(iVar, i2 + c2, i4, i3, b2);
                }
            }
            if (i5 > 0) {
                if (i2 > 0) {
                    iVarArr[6] = new i(iVar, 0, i4 + b2, i2, i5);
                }
                if (c2 > 0) {
                    iVarArr[7] = new i(iVar, i2, i4 + b2, c2, i5);
                }
                if (i3 > 0) {
                    iVarArr[8] = new i(iVar, i2 + c2, i4 + b2, i3, i5);
                }
            }
            if (i2 == 0 && c2 == 0) {
                iVarArr[1] = iVarArr[2];
                iVarArr[4] = iVarArr[5];
                iVarArr[7] = iVarArr[8];
                iVarArr[2] = null;
                iVarArr[5] = null;
                iVarArr[8] = null;
            }
            if (i4 == 0 && b2 == 0) {
                iVarArr[3] = iVarArr[6];
                iVarArr[4] = iVarArr[7];
                iVarArr[5] = iVarArr[8];
                iVarArr[6] = null;
                iVarArr[7] = null;
                iVarArr[8] = null;
            }
            l(iVarArr);
            return;
        }
        throw new IllegalArgumentException("region cannot be null.");
    }

    public final int a(i iVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{iVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Texture texture = this.a;
            if (texture == null) {
                this.a = iVar.f();
            } else if (texture != iVar.f()) {
                throw new IllegalArgumentException("All regions must be from the same texture.");
            }
            float f2 = iVar.f27408b;
            float f3 = iVar.f27411e;
            float f4 = iVar.f27410d;
            float f5 = iVar.f27409c;
            if (this.a.f() == Texture.TextureFilter.Linear || this.a.h() == Texture.TextureFilter.Linear) {
                if (z) {
                    float x = 0.5f / this.a.x();
                    f2 += x;
                    f4 -= x;
                }
                if (z2) {
                    float u = 0.5f / this.a.u();
                    f3 -= u;
                    f5 += u;
                }
            }
            float[] fArr = this.q;
            int i2 = this.r;
            fArr[i2 + 3] = f2;
            fArr[i2 + 4] = f3;
            fArr[i2 + 8] = f2;
            fArr[i2 + 9] = f5;
            fArr[i2 + 13] = f4;
            fArr[i2 + 14] = f5;
            fArr[i2 + 18] = f4;
            fArr[i2 + 19] = f3;
            this.r = i2 + 20;
            return i2;
        }
        return invokeCommon.intValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : invokeV.floatValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.floatValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f2 = this.w;
            return f2 == -1.0f ? b() : f2;
        }
        return invokeV.floatValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f2 = this.t;
            return f2 == -1.0f ? c() : f2;
        }
        return invokeV.floatValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f2 = this.u;
            return f2 == -1.0f ? h() : f2;
        }
        return invokeV.floatValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f2 = this.v;
            return f2 == -1.0f ? i() : f2;
        }
        return invokeV.floatValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.o : invokeV.floatValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o + this.n + this.p : invokeV.floatValue;
    }

    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k + this.m + this.l : invokeV.floatValue;
    }

    public final void l(i[] iVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iVarArr) == null) {
            if (iVarArr[6] != null) {
                this.f27364b = a(iVarArr[6], false, false);
                this.k = iVarArr[6].c();
                this.p = iVarArr[6].b();
            } else {
                this.f27364b = -1;
            }
            if (iVarArr[7] != null) {
                this.f27365c = a(iVarArr[7], (iVarArr[6] == null && iVarArr[8] == null) ? false : true, false);
                this.m = Math.max(this.m, iVarArr[7].c());
                this.p = Math.max(this.p, iVarArr[7].b());
            } else {
                this.f27365c = -1;
            }
            if (iVarArr[8] != null) {
                this.f27366d = a(iVarArr[8], false, false);
                this.l = Math.max(this.l, iVarArr[8].c());
                this.p = Math.max(this.p, iVarArr[8].b());
            } else {
                this.f27366d = -1;
            }
            if (iVarArr[3] != null) {
                this.f27367e = a(iVarArr[3], false, (iVarArr[0] == null && iVarArr[6] == null) ? false : true);
                this.k = Math.max(this.k, iVarArr[3].c());
                this.n = Math.max(this.n, iVarArr[3].b());
            } else {
                this.f27367e = -1;
            }
            if (iVarArr[4] != null) {
                this.f27368f = a(iVarArr[4], (iVarArr[3] == null && iVarArr[5] == null) ? false : true, (iVarArr[1] == null && iVarArr[7] == null) ? false : true);
                this.m = Math.max(this.m, iVarArr[4].c());
                this.n = Math.max(this.n, iVarArr[4].b());
            } else {
                this.f27368f = -1;
            }
            if (iVarArr[5] != null) {
                this.f27369g = a(iVarArr[5], false, (iVarArr[2] == null && iVarArr[8] == null) ? false : true);
                this.l = Math.max(this.l, iVarArr[5].c());
                this.n = Math.max(this.n, iVarArr[5].b());
            } else {
                this.f27369g = -1;
            }
            if (iVarArr[0] != null) {
                this.f27370h = a(iVarArr[0], false, false);
                this.k = Math.max(this.k, iVarArr[0].c());
                this.o = Math.max(this.o, iVarArr[0].b());
            } else {
                this.f27370h = -1;
            }
            if (iVarArr[1] != null) {
                this.f27371i = a(iVarArr[1], (iVarArr[0] == null && iVarArr[2] == null) ? false : true, false);
                this.m = Math.max(this.m, iVarArr[1].c());
                this.o = Math.max(this.o, iVarArr[1].b());
            } else {
                this.f27371i = -1;
            }
            if (iVarArr[2] != null) {
                this.f27372j = a(iVarArr[2], false, false);
                this.l = Math.max(this.l, iVarArr[2].c());
                this.o = Math.max(this.o, iVarArr[2].b());
            } else {
                this.f27372j = -1;
            }
            int i2 = this.r;
            float[] fArr = this.q;
            if (i2 < fArr.length) {
                float[] fArr2 = new float[i2];
                System.arraycopy(fArr, 0, fArr2, 0, i2);
                this.q = fArr2;
            }
        }
    }

    public void m(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.k *= f2;
            this.l *= f2;
            this.o *= f3;
            this.p *= f3;
            this.m *= f2;
            this.n *= f3;
            float f4 = this.t;
            if (f4 != -1.0f) {
                this.t = f4 * f2;
            }
            float f5 = this.u;
            if (f5 != -1.0f) {
                this.u = f5 * f2;
            }
            float f6 = this.v;
            if (f6 != -1.0f) {
                this.v = f6 * f3;
            }
            float f7 = this.w;
            if (f7 != -1.0f) {
                this.w = f7 * f3;
            }
        }
    }

    public void n(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.t = f2;
            this.u = f3;
            this.v = f4;
            this.w = f5;
        }
    }

    public c(i iVar) {
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
        this.q = new float[180];
        this.s = new c.b.b.n.a(c.b.b.n.a.f27315e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        l(new i[]{null, null, null, null, iVar, null, null, null, null});
    }

    public c(c cVar, c.b.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new c.b.b.n.a(c.b.b.n.a.f27315e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        this.a = cVar.a;
        this.f27364b = cVar.f27364b;
        this.f27365c = cVar.f27365c;
        this.f27366d = cVar.f27366d;
        this.f27367e = cVar.f27367e;
        this.f27368f = cVar.f27368f;
        this.f27369g = cVar.f27369g;
        this.f27370h = cVar.f27370h;
        this.f27371i = cVar.f27371i;
        this.f27372j = cVar.f27372j;
        this.k = cVar.k;
        this.l = cVar.l;
        this.m = cVar.m;
        this.n = cVar.n;
        this.o = cVar.o;
        this.p = cVar.p;
        this.t = cVar.t;
        this.v = cVar.v;
        this.w = cVar.w;
        this.u = cVar.u;
        float[] fArr = new float[cVar.q.length];
        this.q = fArr;
        float[] fArr2 = cVar.q;
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        this.r = cVar.r;
        this.s.e(aVar);
    }
}
