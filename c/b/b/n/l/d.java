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
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
/* loaded from: classes7.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.q.a<c> f27586e;

    /* renamed from: f  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.n.l.g.c> f27587f;

    /* renamed from: g  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.n.l.g.a> f27588g;

    /* renamed from: h  reason: collision with root package name */
    public final c.b.b.q.a<Mesh> f27589h;

    /* renamed from: i  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.n.l.g.b> f27590i;

    /* renamed from: j  reason: collision with root package name */
    public final c.b.b.q.a<h> f27591j;

    /* renamed from: k  reason: collision with root package name */
    public w<f, c.b.b.q.b<String, Matrix4>> f27592k;

    public d() {
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
        this.f27586e = new c.b.b.q.a<>();
        this.f27587f = new c.b.b.q.a<>();
        this.f27588g = new c.b.b.q.a<>();
        this.f27589h = new c.b.b.q.a<>();
        this.f27590i = new c.b.b.q.a<>();
        this.f27591j = new c.b.b.q.a<>();
        this.f27592k = new w<>();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.f27587f.f27768f;
            for (int i3 = 0; i3 < i2; i3++) {
                this.f27587f.get(i3).d(true);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                this.f27587f.get(i4).b(true);
            }
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.b<h> it = this.f27591j.iterator();
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
            cVar.f27585h = modelMaterial.a;
            if (modelMaterial.f31607b != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f27599k, modelMaterial.f31607b));
            }
            if (modelMaterial.f31608c != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f27597i, modelMaterial.f31608c));
            }
            if (modelMaterial.f31609d != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f27598j, modelMaterial.f31609d));
            }
            if (modelMaterial.f31610e != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.l, modelMaterial.f31610e));
            }
            if (modelMaterial.f31611f != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.m, modelMaterial.f31611f));
            }
            if (modelMaterial.f31612g > 0.0f) {
                cVar.i(new c.b.b.n.l.e.c(c.b.b.n.l.e.c.f27601i, modelMaterial.f31612g));
            }
            if (modelMaterial.f31613h != 1.0f) {
                cVar.i(new c.b.b.n.l.e.a(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD, modelMaterial.f31613h));
            }
            w wVar = new w();
            c.b.b.q.a<i> aVar = modelMaterial.f31614i;
            if (aVar != null) {
                a.b<i> it = aVar.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (wVar.a(next.a)) {
                        load = (Texture) wVar.c(next.a);
                    } else {
                        load = bVar.load(next.a);
                        wVar.i(next.a, load);
                        this.f27591j.a(load);
                    }
                    c.b.b.n.l.i.a aVar2 = new c.b.b.n.l.i.a(load);
                    aVar2.f27682f = load.h();
                    aVar2.f27683g = load.f();
                    aVar2.f27684h = load.j();
                    aVar2.f27685i = load.k();
                    Vector2 vector2 = next.f27661b;
                    float f2 = vector2 == null ? 0.0f : vector2.x;
                    Vector2 vector22 = next.f27661b;
                    float f3 = vector22 == null ? 0.0f : vector22.y;
                    Vector2 vector23 = next.f27662c;
                    float f4 = vector23 == null ? 1.0f : vector23.x;
                    Vector2 vector24 = next.f27662c;
                    float f5 = vector24 == null ? 1.0f : vector24.y;
                    int i2 = next.f27663d;
                    if (i2 == 2) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.n, aVar2, f2, f3, f4, f5));
                    } else if (i2 == 3) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.s, aVar2, f2, f3, f4, f5));
                    } else if (i2 == 4) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.r, aVar2, f2, f3, f4, f5));
                    } else if (i2 == 5) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.o, aVar2, f2, f3, f4, f5));
                    } else if (i2 == 7) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.q, aVar2, f2, f3, f4, f5));
                    } else if (i2 == 8) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.p, aVar2, f2, f3, f4, f5));
                    } else if (i2 == 10) {
                        cVar.i(new c.b.b.n.l.e.d(c.b.b.n.l.e.d.t, aVar2, f2, f3, f4, f5));
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
            int i2 = 0;
            for (c.b.b.n.l.g.g.d dVar : cVar.f27647c) {
                i2 += dVar.f27648b.length;
            }
            boolean z = i2 > 0;
            j jVar = new j(cVar.a);
            int length = cVar.f27646b.length / (jVar.f27490f / 4);
            Mesh mesh = new Mesh(true, length, i2, jVar);
            this.f27589h.a(mesh);
            this.f27591j.a(mesh);
            BufferUtils.a(cVar.f27646b, mesh.m(), cVar.f27646b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (c.b.b.n.l.g.g.d dVar2 : cVar.f27647c) {
                c.b.b.n.l.g.b bVar = new c.b.b.n.l.g.b();
                bVar.a = dVar2.a;
                bVar.f27622b = dVar2.f27649c;
                bVar.f27623c = i3;
                bVar.f27624d = z ? dVar2.f27648b.length : length;
                bVar.f27625e = mesh;
                if (z) {
                    mesh.j().put(dVar2.f27648b);
                }
                i3 += bVar.f27624d;
                this.f27590i.a(bVar);
            }
            mesh.j().position(0);
            a.b<c.b.b.n.l.g.b> it = this.f27590i.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public Iterable<h> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27591j : (Iterable) invokeV.objValue;
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? c.b.b.n.l.g.c.f(this.f27587f, str, z, z2) : (c.b.b.n.l.g.c) invokeCommon.objValue;
    }

    public void l(c.b.b.n.l.g.g.b bVar, c.b.b.n.l.i.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bVar2) == null) {
            o(bVar.f27642b);
            n(bVar.f27643c, bVar2);
            q(bVar.f27644d);
            m(bVar.f27645e);
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
                a.b<c.b.b.n.l.g.g.f> it = aVar3.f27641b.iterator();
                while (it.hasNext()) {
                    c.b.b.n.l.g.g.f next = it.next();
                    c.b.b.n.l.g.c i2 = i(next.a);
                    if (i2 != null) {
                        c.b.b.n.l.g.d dVar = new c.b.b.n.l.g.d();
                        if (next.f27655b != null) {
                            c.b.b.q.a<e<Vector3>> aVar5 = new c.b.b.q.a<>();
                            dVar.a = aVar5;
                            aVar5.e(next.f27655b.f27768f);
                            a.b<g<Vector3>> it2 = next.f27655b.iterator();
                            while (it2.hasNext()) {
                                g<Vector3> next2 = it2.next();
                                float f2 = next2.a;
                                if (f2 > aVar4.a) {
                                    aVar4.a = f2;
                                }
                                c.b.b.q.a<e<Vector3>> aVar6 = dVar.a;
                                float f3 = next2.a;
                                Vector3 vector3 = next2.f27658b;
                                aVar6.a(new e<>(f3, new Vector3(vector3 == null ? i2.f27630d : vector3)));
                            }
                        }
                        if (next.f27656c != null) {
                            c.b.b.q.a<e<Quaternion>> aVar7 = new c.b.b.q.a<>();
                            dVar.f27638b = aVar7;
                            aVar7.e(next.f27656c.f27768f);
                            a.b<g<Quaternion>> it3 = next.f27656c.iterator();
                            while (it3.hasNext()) {
                                g<Quaternion> next3 = it3.next();
                                float f4 = next3.a;
                                if (f4 > aVar4.a) {
                                    aVar4.a = f4;
                                }
                                c.b.b.q.a<e<Quaternion>> aVar8 = dVar.f27638b;
                                float f5 = next3.a;
                                Quaternion quaternion = next3.f27658b;
                                aVar8.a(new e<>(f5, new Quaternion(quaternion == null ? i2.f27631e : quaternion)));
                            }
                        }
                        if (next.f27657d != null) {
                            c.b.b.q.a<e<Vector3>> aVar9 = new c.b.b.q.a<>();
                            dVar.f27639c = aVar9;
                            aVar9.e(next.f27657d.f27768f);
                            a.b<g<Vector3>> it4 = next.f27657d.iterator();
                            while (it4.hasNext()) {
                                g<Vector3> next4 = it4.next();
                                float f6 = next4.a;
                                if (f6 > aVar4.a) {
                                    aVar4.a = f6;
                                }
                                c.b.b.q.a<e<Vector3>> aVar10 = dVar.f27639c;
                                float f7 = next4.a;
                                Vector3 vector32 = next4.f27658b;
                                aVar10.a(new e<>(f7, new Vector3(vector32 == null ? i2.f27632f : vector32)));
                            }
                        }
                        c.b.b.q.a<e<Vector3>> aVar11 = dVar.a;
                        if ((aVar11 != null && aVar11.f27768f > 0) || (((aVar = dVar.f27638b) != null && aVar.f27768f > 0) || ((aVar2 = dVar.f27639c) != null && aVar2.f27768f > 0))) {
                            aVar4.f27620b.a(dVar);
                        }
                    }
                }
                if (aVar4.f27620b.f27768f > 0) {
                    this.f27588g.a(aVar4);
                }
            }
        }
    }

    public void n(Iterable<ModelMaterial> iterable, c.b.b.n.l.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, bVar) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.f27586e.a(f(modelMaterial, bVar));
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
            Vector3 vector3 = eVar.f27650b;
            if (vector3 != null) {
                cVar.f27630d.set(vector3);
            }
            Quaternion quaternion = eVar.f27651c;
            if (quaternion != null) {
                cVar.f27631e.set(quaternion);
            }
            Vector3 vector32 = eVar.f27652d;
            if (vector32 != null) {
                cVar.f27632f.set(vector32);
            }
            c.b.b.n.l.g.g.h[] hVarArr = eVar.f27653e;
            if (hVarArr != null) {
                for (c.b.b.n.l.g.g.h hVar : hVarArr) {
                    c cVar2 = null;
                    if (hVar.f27659b != null) {
                        a.b<c.b.b.n.l.g.b> it = this.f27590i.iterator();
                        while (it.hasNext()) {
                            bVar = it.next();
                            if (hVar.f27659b.equals(bVar.a)) {
                                break;
                            }
                        }
                    }
                    bVar = null;
                    if (hVar.a != null) {
                        a.b<c> it2 = this.f27586e.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            c next = it2.next();
                            if (hVar.a.equals(next.f27585h)) {
                                cVar2 = next;
                                break;
                            }
                        }
                    }
                    if (bVar != null && cVar2 != null) {
                        f fVar = new f();
                        cVar.f27635i.a(fVar);
                        c.b.b.q.b<String, Matrix4> bVar2 = hVar.f27660c;
                        if (bVar2 != null) {
                            this.f27592k.i(fVar, bVar2);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + cVar.a);
                    }
                }
            }
            c.b.b.n.l.g.g.e[] eVarArr = eVar.f27654f;
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
            this.f27592k.clear();
            for (c.b.b.n.l.g.g.e eVar : iterable) {
                this.f27587f.a(p(eVar));
            }
            w.a<f, c.b.b.q.b<String, Matrix4>> b2 = this.f27592k.b();
            b2.d();
            while (b2.hasNext()) {
                w.b next = b2.next();
                K k2 = next.a;
                if (((f) k2).a == null) {
                    ((f) k2).a = new c.b.b.q.b<>(c.b.b.n.l.g.c.class, Matrix4.class);
                }
                ((f) next.a).a.clear();
                b.a b3 = ((c.b.b.q.b) next.f27939b).b();
                b3.iterator();
                while (b3.hasNext()) {
                    w.b next2 = b3.next();
                    ((f) next.a).a.f(i((String) next2.a), new Matrix4((Matrix4) next2.f27939b).inv());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27586e = new c.b.b.q.a<>();
        this.f27587f = new c.b.b.q.a<>();
        this.f27588g = new c.b.b.q.a<>();
        this.f27589h = new c.b.b.q.a<>();
        this.f27590i = new c.b.b.q.a<>();
        this.f27591j = new c.b.b.q.a<>();
        this.f27592k = new w<>();
        l(bVar, bVar2);
    }
}
