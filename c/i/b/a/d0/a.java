package c.i.b.a.d0;

import android.util.Pair;
import c.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class a extends w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final int f32991b;

    /* renamed from: c  reason: collision with root package name */
    public final q f32992c;

    public a(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32992c = qVar;
        this.f32991b = qVar.getLength();
    }

    @Override // c.i.b.a.w
    public int a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (this.f32991b == 0) {
                return -1;
            }
            int d2 = z ? this.f32992c.d() : 0;
            while (z(d2).p()) {
                d2 = x(d2, z);
                if (d2 == -1) {
                    return -1;
                }
            }
            return w(d2) + z(d2).a(z);
        }
        return invokeZ.intValue;
    }

    @Override // c.i.b.a.w
    public final int b(Object obj) {
        InterceptResult invokeL;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                Object obj2 = pair.first;
                Object obj3 = pair.second;
                int r = r(obj2);
                if (r == -1 || (b2 = z(r).b(obj3)) == -1) {
                    return -1;
                }
                return v(r) + b2;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // c.i.b.a.w
    public int c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            int i2 = this.f32991b;
            if (i2 == 0) {
                return -1;
            }
            int c2 = z ? this.f32992c.c() : i2 - 1;
            while (z(c2).p()) {
                c2 = y(c2, z);
                if (c2 == -1) {
                    return -1;
                }
            }
            return w(c2) + z(c2).c(z);
        }
        return invokeZ.intValue;
    }

    @Override // c.i.b.a.w
    public int e(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int t = t(i2);
            int w = w(t);
            int e2 = z(t).e(i2 - w, i3 == 2 ? 0 : i3, z);
            if (e2 != -1) {
                return w + e2;
            }
            int x = x(t, z);
            while (x != -1 && z(x).p()) {
                x = x(x, z);
            }
            if (x != -1) {
                return w(x) + z(x).a(z);
            }
            if (i3 == 2) {
                return a(z);
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    @Override // c.i.b.a.w
    public final w.b g(int i2, w.b bVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
            int s = s(i2);
            int w = w(s);
            z(s).g(i2 - v(s), bVar, z);
            bVar.f33962c += w;
            if (z) {
                bVar.f33961b = Pair.create(u(s), bVar.f33961b);
            }
            return bVar;
        }
        return (w.b) invokeCommon.objValue;
    }

    @Override // c.i.b.a.w
    public int k(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int t = t(i2);
            int w = w(t);
            int k = z(t).k(i2 - w, i3 == 2 ? 0 : i3, z);
            if (k != -1) {
                return w + k;
            }
            int y = y(t, z);
            while (y != -1 && z(y).p()) {
                y = y(y, z);
            }
            if (y != -1) {
                return w(y) + z(y).c(z);
            }
            if (i3 == 2) {
                return c(z);
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    @Override // c.i.b.a.w
    public final w.c n(int i2, w.c cVar, boolean z, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
            int t = t(i2);
            int w = w(t);
            int v = v(t);
            z(t).n(i2 - w, cVar, z, j2);
            cVar.f33975f += v;
            cVar.f33976g += v;
            return cVar;
        }
        return (w.c) invokeCommon.objValue;
    }

    public abstract int r(Object obj);

    public abstract int s(int i2);

    public abstract int t(int i2);

    public abstract Object u(int i2);

    public abstract int v(int i2);

    public abstract int w(int i2);

    public final int x(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return this.f32992c.b(i2);
            }
            if (i2 < this.f32991b - 1) {
                return i2 + 1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public final int y(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return this.f32992c.a(i2);
            }
            if (i2 > 0) {
                return i2 - 1;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public abstract w z(int i2);
}
