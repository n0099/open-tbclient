package c.b.b.n.l;

import androidx.core.view.InputDeviceCompat;
import c.b.b.n.j;
import c.b.b.n.l.g.e;
import c.b.b.n.l.g.f;
import c.b.b.n.l.g.g.g;
import c.b.b.n.l.g.g.i;
import c.b.b.q.a;
import c.b.b.q.b;
import c.b.b.q.h;
import c.b.b.q.w;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.b.b.q.a<c> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.n.l.g.c> f22554b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.n.l.g.a> f22555c;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.q.a<Mesh> f22556d;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.n.l.g.b> f22557e;

    /* renamed from: f  reason: collision with root package name */
    public final c.b.b.q.a<h> f22558f;

    /* renamed from: g  reason: collision with root package name */
    public w<f, c.b.b.q.b<String, Matrix4>> f22559g;

    public d() {
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
        this.a = new c.b.b.q.a<>();
        this.f22554b = new c.b.b.q.a<>();
        this.f22555c = new c.b.b.q.a<>();
        this.f22556d = new c.b.b.q.a<>();
        this.f22557e = new c.b.b.q.a<>();
        this.f22558f = new c.b.b.q.a<>();
        this.f22559g = new w<>();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.f22554b.f22717b;
            for (int i2 = 0; i2 < i; i2++) {
                this.f22554b.get(i2).d(true);
            }
            for (int i3 = 0; i3 < i; i3++) {
                this.f22554b.get(i3).b(true);
            }
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.b<h> it = this.f22558f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public c f(ModelMaterial modelMaterial, c.b.b.n.l.i.b bVar) {
        InterceptResult invokeLL;
        Texture load;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, bVar)) == null) {
            c cVar = new c();
            cVar.f22553d = modelMaterial.a;
            if (modelMaterial.f23770b != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f22567g, modelMaterial.f23770b));
            }
            if (modelMaterial.f23771c != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f22565e, modelMaterial.f23771c));
            }
            if (modelMaterial.f23772d != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f22566f, modelMaterial.f23772d));
            }
            if (modelMaterial.f23773e != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f22568h, modelMaterial.f23773e));
            }
            if (modelMaterial.f23774f != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.i, modelMaterial.f23774f));
            }
            if (modelMaterial.f23775g > 0.0f) {
                cVar.i(new c.b.b.n.l.e.c(c.b.b.n.l.e.c.f22570e, modelMaterial.f23775g));
            }
            if (modelMaterial.f23776h != 1.0f) {
                cVar.i(new c.b.b.n.l.e.a(770, 771, modelMaterial.f23776h));
            }
            w wVar = new w();
            c.b.b.q.a<i> aVar = modelMaterial.i;
            if (aVar != null) {
                a.b<i> it = aVar.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (wVar.a(next.a)) {
                        load = (Texture) wVar.c(next.a);
                    } else {
                        load = bVar.load(next.a);
                        wVar.i(next.a, load);
                        this.f22558f.a(load);
                    }
                    c.b.b.n.l.i.a aVar2 = new c.b.b.n.l.i.a(load);
                    aVar2.f22642b = load.h();
                    aVar2.f22643c = load.f();
                    aVar2.f22644d = load.j();
                    aVar2.f22645e = load.k();
                    Vector2 vector2 = next.f22628b;
                    float f2 = vector2 == null ? 0.0f : vector2.x;
                    Vector2 vector22 = next.f22628b;
                    float f3 = vector22 == null ? 0.0f : vector22.y;
                    Vector2 vector23 = next.f22629c;
                    float f4 = vector23 == null ? 1.0f : vector23.x;
                    Vector2 vector24 = next.f22629c;
                    float f5 = vector24 == null ? 1.0f : vector24.y;
                    int i = next.f22630d;
                    if (i == 2) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.j, aVar2, f2, f3, f4, f5));
                    } else if (i == 3) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.o, aVar2, f2, f3, f4, f5));
                    } else if (i == 4) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.n, aVar2, f2, f3, f4, f5));
                    } else if (i == 5) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.k, aVar2, f2, f3, f4, f5));
                    } else if (i == 7) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.m, aVar2, f2, f3, f4, f5));
                    } else if (i == 8) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.l, aVar2, f2, f3, f4, f5));
                    } else if (i == 10) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.p, aVar2, f2, f3, f4, f5));
                    }
                }
            }
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public void g(c.b.b.n.l.g.g.c cVar) {
        c.b.b.n.l.g.g.d[] dVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            int i = 0;
            for (c.b.b.n.l.g.g.d dVar : cVar.f22614c) {
                i += dVar.f22615b.length;
            }
            boolean z = i > 0;
            j jVar = new j(cVar.a);
            int length = cVar.f22613b.length / (jVar.f22486b / 4);
            Mesh mesh = new Mesh(true, length, i, jVar);
            this.f22556d.a(mesh);
            this.f22558f.a(mesh);
            BufferUtils.a(cVar.f22613b, mesh.m(), cVar.f22613b.length, 0);
            mesh.j().clear();
            int i2 = 0;
            for (c.b.b.n.l.g.g.d dVar2 : cVar.f22614c) {
                c.b.b.n.l.g.b bVar = new c.b.b.n.l.g.b();
                bVar.a = dVar2.a;
                bVar.f22592b = dVar2.f22616c;
                bVar.f22593c = i2;
                bVar.f22594d = z ? dVar2.f22615b.length : length;
                bVar.f22595e = mesh;
                if (z) {
                    mesh.j().put(dVar2.f22615b);
                }
                i2 += bVar.f22594d;
                this.f22557e.a(bVar);
            }
            mesh.j().position(0);
            a.b<c.b.b.n.l.g.b> it = this.f22557e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public Iterable<h> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22558f : (Iterable) invokeV.objValue;
    }

    public c.b.b.n.l.g.c i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? j(str, true) : (c.b.b.n.l.g.c) invokeL.objValue;
    }

    public c.b.b.n.l.g.c j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) ? k(str, z, false) : (c.b.b.n.l.g.c) invokeLZ.objValue;
    }

    public c.b.b.n.l.g.c k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? c.b.b.n.l.g.c.f(this.f22554b, str, z, z2) : (c.b.b.n.l.g.c) invokeCommon.objValue;
    }

    public void l(c.b.b.n.l.g.g.b bVar, c.b.b.n.l.i.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bVar2) == null) {
            o(bVar.f22609b);
            n(bVar.f22610c, bVar2);
            q(bVar.f22611d);
            m(bVar.f22612e);
            a();
        }
    }

    public void m(Iterable<c.b.b.n.l.g.g.a> iterable) {
        c.b.b.q.a<e<Quaternion>> aVar;
        c.b.b.q.a<e<Vector3>> aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (c.b.b.n.l.g.g.a aVar3 : iterable) {
                c.b.b.n.l.g.a aVar4 = new c.b.b.n.l.g.a();
                String str = aVar3.a;
                a.b<c.b.b.n.l.g.g.f> it = aVar3.f22608b.iterator();
                while (it.hasNext()) {
                    c.b.b.n.l.g.g.f next = it.next();
                    c.b.b.n.l.g.c i = i(next.a);
                    if (i != null) {
                        c.b.b.n.l.g.d dVar = new c.b.b.n.l.g.d();
                        if (next.f22622b != null) {
                            c.b.b.q.a<e<Vector3>> aVar5 = new c.b.b.q.a<>();
                            dVar.a = aVar5;
                            aVar5.e(next.f22622b.f22717b);
                            a.b<g<Vector3>> it2 = next.f22622b.iterator();
                            while (it2.hasNext()) {
                                g<Vector3> next2 = it2.next();
                                float f2 = next2.a;
                                if (f2 > aVar4.a) {
                                    aVar4.a = f2;
                                }
                                c.b.b.q.a<e<Vector3>> aVar6 = dVar.a;
                                float f3 = next2.a;
                                Vector3 vector3 = next2.f22625b;
                                aVar6.a(new e<>(f3, new Vector3(vector3 == null ? i.f22600d : vector3)));
                            }
                        }
                        if (next.f22623c != null) {
                            c.b.b.q.a<e<Quaternion>> aVar7 = new c.b.b.q.a<>();
                            dVar.f22605b = aVar7;
                            aVar7.e(next.f22623c.f22717b);
                            a.b<g<Quaternion>> it3 = next.f22623c.iterator();
                            while (it3.hasNext()) {
                                g<Quaternion> next3 = it3.next();
                                float f4 = next3.a;
                                if (f4 > aVar4.a) {
                                    aVar4.a = f4;
                                }
                                c.b.b.q.a<e<Quaternion>> aVar8 = dVar.f22605b;
                                float f5 = next3.a;
                                Quaternion quaternion = next3.f22625b;
                                aVar8.a(new e<>(f5, new Quaternion(quaternion == null ? i.f22601e : quaternion)));
                            }
                        }
                        if (next.f22624d != null) {
                            c.b.b.q.a<e<Vector3>> aVar9 = new c.b.b.q.a<>();
                            dVar.f22606c = aVar9;
                            aVar9.e(next.f22624d.f22717b);
                            a.b<g<Vector3>> it4 = next.f22624d.iterator();
                            while (it4.hasNext()) {
                                g<Vector3> next4 = it4.next();
                                float f6 = next4.a;
                                if (f6 > aVar4.a) {
                                    aVar4.a = f6;
                                }
                                c.b.b.q.a<e<Vector3>> aVar10 = dVar.f22606c;
                                float f7 = next4.a;
                                Vector3 vector32 = next4.f22625b;
                                aVar10.a(new e<>(f7, new Vector3(vector32 == null ? i.f22602f : vector32)));
                            }
                        }
                        c.b.b.q.a<e<Vector3>> aVar11 = dVar.a;
                        if ((aVar11 != null && aVar11.f22717b > 0) || (((aVar = dVar.f22605b) != null && aVar.f22717b > 0) || ((aVar2 = dVar.f22606c) != null && aVar2.f22717b > 0))) {
                            aVar4.f22590b.a(dVar);
                        }
                    }
                }
                if (aVar4.f22590b.f22717b > 0) {
                    this.f22555c.a(aVar4);
                }
            }
        }
    }

    public void n(Iterable<ModelMaterial> iterable, c.b.b.n.l.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, bVar) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, bVar));
            }
        }
    }

    public void o(Iterable<c.b.b.n.l.g.g.c> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (c.b.b.n.l.g.g.c cVar : iterable) {
                g(cVar);
            }
        }
    }

    public c.b.b.n.l.g.c p(c.b.b.n.l.g.g.e eVar) {
        InterceptResult invokeL;
        c.b.b.n.l.g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, eVar)) == null) {
            c.b.b.n.l.g.c cVar = new c.b.b.n.l.g.c();
            cVar.a = eVar.a;
            Vector3 vector3 = eVar.f22617b;
            if (vector3 != null) {
                cVar.f22600d.set(vector3);
            }
            Quaternion quaternion = eVar.f22618c;
            if (quaternion != null) {
                cVar.f22601e.set(quaternion);
            }
            Vector3 vector32 = eVar.f22619d;
            if (vector32 != null) {
                cVar.f22602f.set(vector32);
            }
            c.b.b.n.l.g.g.h[] hVarArr = eVar.f22620e;
            if (hVarArr != null) {
                for (c.b.b.n.l.g.g.h hVar : hVarArr) {
                    c cVar2 = null;
                    if (hVar.f22626b != null) {
                        a.b<c.b.b.n.l.g.b> it = this.f22557e.iterator();
                        while (it.hasNext()) {
                            bVar = it.next();
                            if (hVar.f22626b.equals(bVar.a)) {
                                break;
                            }
                        }
                    }
                    bVar = null;
                    if (hVar.a != null) {
                        a.b<c> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            c next = it2.next();
                            if (hVar.a.equals(next.f22553d)) {
                                cVar2 = next;
                                break;
                            }
                        }
                    }
                    if (bVar != null && cVar2 != null) {
                        f fVar = new f();
                        cVar.i.a(fVar);
                        c.b.b.q.b<String, Matrix4> bVar2 = hVar.f22627c;
                        if (bVar2 != null) {
                            this.f22559g.i(fVar, bVar2);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + cVar.a);
                    }
                }
            }
            c.b.b.n.l.g.g.e[] eVarArr = eVar.f22621f;
            if (eVarArr != null) {
                for (c.b.b.n.l.g.g.e eVar2 : eVarArr) {
                    cVar.a(p(eVar2));
                }
            }
            return cVar;
        }
        return (c.b.b.n.l.g.c) invokeL.objValue;
    }

    public void q(Iterable<c.b.b.n.l.g.g.e> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.f22559g.clear();
            for (c.b.b.n.l.g.g.e eVar : iterable) {
                this.f22554b.a(p(eVar));
            }
            w.a<f, c.b.b.q.b<String, Matrix4>> b2 = this.f22559g.b();
            b2.d();
            while (b2.hasNext()) {
                w.b next = b2.next();
                K k = next.a;
                if (((f) k).a == null) {
                    ((f) k).a = new c.b.b.q.b<>(c.b.b.n.l.g.c.class, Matrix4.class);
                }
                ((f) next.a).a.clear();
                b.a b3 = ((c.b.b.q.b) next.f22866b).b();
                b3.iterator();
                while (b3.hasNext()) {
                    w.b next2 = b3.next();
                    ((f) next.a).a.f(i((String) next2.a), new Matrix4((Matrix4) next2.f22866b).inv());
                }
            }
        }
    }

    public d(c.b.b.n.l.g.g.b bVar, c.b.b.n.l.i.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new c.b.b.q.a<>();
        this.f22554b = new c.b.b.q.a<>();
        this.f22555c = new c.b.b.q.a<>();
        this.f22556d = new c.b.b.q.a<>();
        this.f22557e = new c.b.b.q.a<>();
        this.f22558f = new c.b.b.q.a<>();
        this.f22559g = new w<>();
        l(bVar, bVar2);
    }
}
