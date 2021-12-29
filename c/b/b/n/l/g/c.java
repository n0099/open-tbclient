package c.b.b.n.l.g;

import c.b.b.q.a;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28077b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28078c;

    /* renamed from: d  reason: collision with root package name */
    public final Vector3 f28079d;

    /* renamed from: e  reason: collision with root package name */
    public final Quaternion f28080e;

    /* renamed from: f  reason: collision with root package name */
    public final Vector3 f28081f;

    /* renamed from: g  reason: collision with root package name */
    public final Matrix4 f28082g;

    /* renamed from: h  reason: collision with root package name */
    public final Matrix4 f28083h;

    /* renamed from: i  reason: collision with root package name */
    public c.b.b.q.a<f> f28084i;

    /* renamed from: j  reason: collision with root package name */
    public c f28085j;

    /* renamed from: k  reason: collision with root package name */
    public final c.b.b.q.a<c> f28086k;

    public c() {
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
        this.f28077b = true;
        this.f28079d = new Vector3();
        this.f28080e = new Quaternion(0.0f, 0.0f, 0.0f, 1.0f);
        this.f28081f = new Vector3(1.0f, 1.0f, 1.0f);
        this.f28082g = new Matrix4();
        this.f28083h = new Matrix4();
        this.f28084i = new c.b.b.q.a<>(2);
        this.f28086k = new c.b.b.q.a<>(2);
    }

    public static c f(c.b.b.q.a<c> aVar, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{aVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = aVar.f28217f;
            if (z2) {
                for (int i3 = 0; i3 < i2; i3++) {
                    c cVar = aVar.get(i3);
                    if (cVar.a.equalsIgnoreCase(str)) {
                        return cVar;
                    }
                }
            } else {
                for (int i4 = 0; i4 < i2; i4++) {
                    c cVar2 = aVar.get(i4);
                    if (cVar2.a.equals(str)) {
                        return cVar2;
                    }
                }
            }
            if (z) {
                for (int i5 = 0; i5 < i2; i5++) {
                    c f2 = f(aVar.get(i5).f28086k, str, true, z2);
                    if (f2 != null) {
                        return f2;
                    }
                }
                return null;
            }
            return null;
        }
        return (c) invokeCommon.objValue;
    }

    public <T extends c> int a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? h(-1, t) : invokeL.intValue;
    }

    public void b(boolean z) {
        Matrix4[] matrix4Arr;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            a.b<f> it = this.f28084i.iterator();
            while (it.hasNext()) {
                f next = it.next();
                c.b.b.q.b<c, Matrix4> bVar = next.a;
                if (bVar != null && (matrix4Arr = next.f28089b) != null && (i2 = bVar.f28230g) == matrix4Arr.length) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        next.f28089b[i3].set(next.a.f28228e[i3].f28083h).mul(next.a.f28229f[i3]);
                    }
                }
            }
            if (z) {
                a.b<c> it2 = this.f28086k.iterator();
                while (it2.hasNext()) {
                    it2.next().b(true);
                }
            }
        }
    }

    public Matrix4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.f28078c) {
                this.f28082g.set(this.f28079d, this.f28080e, this.f28081f);
            }
            return this.f28082g;
        }
        return (Matrix4) invokeV.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c();
            e();
            if (z) {
                a.b<c> it = this.f28086k.iterator();
                while (it.hasNext()) {
                    it.next().d(true);
                }
            }
        }
    }

    public Matrix4 e() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f28077b && (cVar = this.f28085j) != null) {
                this.f28083h.set(cVar.f28083h).mul(this.f28082g);
            } else {
                this.f28083h.set(this.f28082g);
            }
            return this.f28083h;
        }
        return (Matrix4) invokeV.objValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28085j : (c) invokeV.objValue;
    }

    public <T extends c> int h(int i2, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, t)) == null) {
            for (c cVar = this; cVar != null; cVar = cVar.g()) {
                if (cVar == t) {
                    throw new GdxRuntimeException("Cannot add a parent as a child");
                }
            }
            c g2 = t.g();
            if (g2 == null || g2.i(t)) {
                if (i2 >= 0) {
                    c.b.b.q.a<c> aVar = this.f28086k;
                    if (i2 < aVar.f28217f) {
                        aVar.insert(i2, t);
                        t.f28085j = this;
                        return i2;
                    }
                }
                c.b.b.q.a<c> aVar2 = this.f28086k;
                int i3 = aVar2.f28217f;
                aVar2.a(t);
                i2 = i3;
                t.f28085j = this;
                return i2;
            }
            throw new GdxRuntimeException("Could not remove child from its current parent");
        }
        return invokeIL.intValue;
    }

    public <T extends c> boolean i(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            if (this.f28086k.i(t, true)) {
                t.f28085j = null;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
