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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22598b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22599c;

    /* renamed from: d  reason: collision with root package name */
    public final Vector3 f22600d;

    /* renamed from: e  reason: collision with root package name */
    public final Quaternion f22601e;

    /* renamed from: f  reason: collision with root package name */
    public final Vector3 f22602f;

    /* renamed from: g  reason: collision with root package name */
    public final Matrix4 f22603g;

    /* renamed from: h  reason: collision with root package name */
    public final Matrix4 f22604h;
    public c.b.b.q.a<f> i;
    public c j;
    public final c.b.b.q.a<c> k;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22598b = true;
        this.f22600d = new Vector3();
        this.f22601e = new Quaternion(0.0f, 0.0f, 0.0f, 1.0f);
        this.f22602f = new Vector3(1.0f, 1.0f, 1.0f);
        this.f22603g = new Matrix4();
        this.f22604h = new Matrix4();
        this.i = new c.b.b.q.a<>(2);
        this.k = new c.b.b.q.a<>(2);
    }

    public static c f(c.b.b.q.a<c> aVar, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{aVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i = aVar.f22717b;
            if (z2) {
                for (int i2 = 0; i2 < i; i2++) {
                    c cVar = aVar.get(i2);
                    if (cVar.a.equalsIgnoreCase(str)) {
                        return cVar;
                    }
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    c cVar2 = aVar.get(i3);
                    if (cVar2.a.equals(str)) {
                        return cVar2;
                    }
                }
            }
            if (z) {
                for (int i4 = 0; i4 < i; i4++) {
                    c f2 = f(aVar.get(i4).k, str, true, z2);
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            a.b<f> it = this.i.iterator();
            while (it.hasNext()) {
                f next = it.next();
                c.b.b.q.b<c, Matrix4> bVar = next.a;
                if (bVar != null && (matrix4Arr = next.f22607b) != null && (i = bVar.f22727c) == matrix4Arr.length) {
                    for (int i2 = 0; i2 < i; i2++) {
                        next.f22607b[i2].set(next.a.a[i2].f22604h).mul(next.a.f22726b[i2]);
                    }
                }
            }
            if (z) {
                a.b<c> it2 = this.k.iterator();
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
            if (!this.f22599c) {
                this.f22603g.set(this.f22600d, this.f22601e, this.f22602f);
            }
            return this.f22603g;
        }
        return (Matrix4) invokeV.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c();
            e();
            if (z) {
                a.b<c> it = this.k.iterator();
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
            if (this.f22598b && (cVar = this.j) != null) {
                this.f22604h.set(cVar.f22604h).mul(this.f22603g);
            } else {
                this.f22604h.set(this.f22603g);
            }
            return this.f22604h;
        }
        return (Matrix4) invokeV.objValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : (c) invokeV.objValue;
    }

    public <T extends c> int h(int i, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, t)) == null) {
            for (c cVar = this; cVar != null; cVar = cVar.g()) {
                if (cVar == t) {
                    throw new GdxRuntimeException("Cannot add a parent as a child");
                }
            }
            c g2 = t.g();
            if (g2 == null || g2.i(t)) {
                if (i >= 0) {
                    c.b.b.q.a<c> aVar = this.k;
                    if (i < aVar.f22717b) {
                        aVar.insert(i, t);
                        t.j = this;
                        return i;
                    }
                }
                c.b.b.q.a<c> aVar2 = this.k;
                int i2 = aVar2.f22717b;
                aVar2.a(t);
                i = i2;
                t.j = this;
                return i;
            }
            throw new GdxRuntimeException("Could not remove child from its current parent");
        }
        return invokeIL.intValue;
    }

    public <T extends c> boolean i(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            if (this.k.j(t, true)) {
                t.j = null;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
