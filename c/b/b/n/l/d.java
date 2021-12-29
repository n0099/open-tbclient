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
/* loaded from: classes9.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.q.a<c> f28035e;

    /* renamed from: f  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.n.l.g.c> f28036f;

    /* renamed from: g  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.n.l.g.a> f28037g;

    /* renamed from: h  reason: collision with root package name */
    public final c.b.b.q.a<Mesh> f28038h;

    /* renamed from: i  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.n.l.g.b> f28039i;

    /* renamed from: j  reason: collision with root package name */
    public final c.b.b.q.a<h> f28040j;

    /* renamed from: k  reason: collision with root package name */
    public w<f, c.b.b.q.b<String, Matrix4>> f28041k;

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
        this.f28035e = new c.b.b.q.a<>();
        this.f28036f = new c.b.b.q.a<>();
        this.f28037g = new c.b.b.q.a<>();
        this.f28038h = new c.b.b.q.a<>();
        this.f28039i = new c.b.b.q.a<>();
        this.f28040j = new c.b.b.q.a<>();
        this.f28041k = new w<>();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.f28036f.f28217f;
            for (int i3 = 0; i3 < i2; i3++) {
                this.f28036f.get(i3).d(true);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                this.f28036f.get(i4).b(true);
            }
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.b<h> it = this.f28040j.iterator();
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
            cVar.f28034h = modelMaterial.a;
            if (modelMaterial.f32120b != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f28048k, modelMaterial.f32120b));
            }
            if (modelMaterial.f32121c != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f28046i, modelMaterial.f32121c));
            }
            if (modelMaterial.f32122d != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.f28047j, modelMaterial.f32122d));
            }
            if (modelMaterial.f32123e != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.l, modelMaterial.f32123e));
            }
            if (modelMaterial.f32124f != null) {
                cVar.i(new c.b.b.n.l.e.b(c.b.b.n.l.e.b.m, modelMaterial.f32124f));
            }
            if (modelMaterial.f32125g > 0.0f) {
                cVar.i(new c.b.b.n.l.e.c(c.b.b.n.l.e.c.f28050i, modelMaterial.f32125g));
            }
            if (modelMaterial.f32126h != 1.0f) {
                cVar.i(new c.b.b.n.l.e.a(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD, modelMaterial.f32126h));
            }
            w wVar = new w();
            c.b.b.q.a<i> aVar = modelMaterial.f32127i;
            if (aVar != null) {
                a.b<i> it = aVar.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (wVar.a(next.a)) {
                        load = (Texture) wVar.c(next.a);
                    } else {
                        load = bVar.load(next.a);
                        wVar.i(next.a, load);
                        this.f28040j.a(load);
                    }
                    c.b.b.n.l.i.a aVar2 = new c.b.b.n.l.i.a(load);
                    aVar2.f28131f = load.h();
                    aVar2.f28132g = load.f();
                    aVar2.f28133h = load.j();
                    aVar2.f28134i = load.k();
                    Vector2 vector2 = next.f28110b;
                    float f2 = vector2 == null ? 0.0f : vector2.x;
                    Vector2 vector22 = next.f28110b;
                    float f3 = vector22 == null ? 0.0f : vector22.y;
                    Vector2 vector23 = next.f28111c;
                    float f4 = vector23 == null ? 1.0f : vector23.x;
                    Vector2 vector24 = next.f28111c;
                    float f5 = vector24 == null ? 1.0f : vector24.y;
                    int i2 = next.f28112d;
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
            for (c.b.b.n.l.g.g.d dVar : cVar.f28096c) {
                i2 += dVar.f28097b.length;
            }
            boolean z = i2 > 0;
            j jVar = new j(cVar.a);
            int length = cVar.f28095b.length / (jVar.f27939f / 4);
            Mesh mesh = new Mesh(true, length, i2, jVar);
            this.f28038h.a(mesh);
            this.f28040j.a(mesh);
            BufferUtils.a(cVar.f28095b, mesh.m(), cVar.f28095b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (c.b.b.n.l.g.g.d dVar2 : cVar.f28096c) {
                c.b.b.n.l.g.b bVar = new c.b.b.n.l.g.b();
                bVar.a = dVar2.a;
                bVar.f28071b = dVar2.f28098c;
                bVar.f28072c = i3;
                bVar.f28073d = z ? dVar2.f28097b.length : length;
                bVar.f28074e = mesh;
                if (z) {
                    mesh.j().put(dVar2.f28097b);
                }
                i3 += bVar.f28073d;
                this.f28039i.a(bVar);
            }
            mesh.j().position(0);
            a.b<c.b.b.n.l.g.b> it = this.f28039i.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public Iterable<h> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28040j : (Iterable) invokeV.objValue;
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? c.b.b.n.l.g.c.f(this.f28036f, str, z, z2) : (c.b.b.n.l.g.c) invokeCommon.objValue;
    }

    public void l(c.b.b.n.l.g.g.b bVar, c.b.b.n.l.i.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bVar2) == null) {
            o(bVar.f28091b);
            n(bVar.f28092c, bVar2);
            q(bVar.f28093d);
            m(bVar.f28094e);
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
                a.b<c.b.b.n.l.g.g.f> it = aVar3.f28090b.iterator();
                while (it.hasNext()) {
                    c.b.b.n.l.g.g.f next = it.next();
                    c.b.b.n.l.g.c i2 = i(next.a);
                    if (i2 != null) {
                        c.b.b.n.l.g.d dVar = new c.b.b.n.l.g.d();
                        if (next.f28104b != null) {
                            c.b.b.q.a<e<Vector3>> aVar5 = new c.b.b.q.a<>();
                            dVar.a = aVar5;
                            aVar5.e(next.f28104b.f28217f);
                            a.b<g<Vector3>> it2 = next.f28104b.iterator();
                            while (it2.hasNext()) {
                                g<Vector3> next2 = it2.next();
                                float f2 = next2.a;
                                if (f2 > aVar4.a) {
                                    aVar4.a = f2;
                                }
                                c.b.b.q.a<e<Vector3>> aVar6 = dVar.a;
                                float f3 = next2.a;
                                Vector3 vector3 = next2.f28107b;
                                aVar6.a(new e<>(f3, new Vector3(vector3 == null ? i2.f28079d : vector3)));
                            }
                        }
                        if (next.f28105c != null) {
                            c.b.b.q.a<e<Quaternion>> aVar7 = new c.b.b.q.a<>();
                            dVar.f28087b = aVar7;
                            aVar7.e(next.f28105c.f28217f);
                            a.b<g<Quaternion>> it3 = next.f28105c.iterator();
                            while (it3.hasNext()) {
                                g<Quaternion> next3 = it3.next();
                                float f4 = next3.a;
                                if (f4 > aVar4.a) {
                                    aVar4.a = f4;
                                }
                                c.b.b.q.a<e<Quaternion>> aVar8 = dVar.f28087b;
                                float f5 = next3.a;
                                Quaternion quaternion = next3.f28107b;
                                aVar8.a(new e<>(f5, new Quaternion(quaternion == null ? i2.f28080e : quaternion)));
                            }
                        }
                        if (next.f28106d != null) {
                            c.b.b.q.a<e<Vector3>> aVar9 = new c.b.b.q.a<>();
                            dVar.f28088c = aVar9;
                            aVar9.e(next.f28106d.f28217f);
                            a.b<g<Vector3>> it4 = next.f28106d.iterator();
                            while (it4.hasNext()) {
                                g<Vector3> next4 = it4.next();
                                float f6 = next4.a;
                                if (f6 > aVar4.a) {
                                    aVar4.a = f6;
                                }
                                c.b.b.q.a<e<Vector3>> aVar10 = dVar.f28088c;
                                float f7 = next4.a;
                                Vector3 vector32 = next4.f28107b;
                                aVar10.a(new e<>(f7, new Vector3(vector32 == null ? i2.f28081f : vector32)));
                            }
                        }
                        c.b.b.q.a<e<Vector3>> aVar11 = dVar.a;
                        if ((aVar11 != null && aVar11.f28217f > 0) || (((aVar = dVar.f28087b) != null && aVar.f28217f > 0) || ((aVar2 = dVar.f28088c) != null && aVar2.f28217f > 0))) {
                            aVar4.f28069b.a(dVar);
                        }
                    }
                }
                if (aVar4.f28069b.f28217f > 0) {
                    this.f28037g.a(aVar4);
                }
            }
        }
    }

    public void n(Iterable<ModelMaterial> iterable, c.b.b.n.l.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, bVar) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.f28035e.a(f(modelMaterial, bVar));
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
            Vector3 vector3 = eVar.f28099b;
            if (vector3 != null) {
                cVar.f28079d.set(vector3);
            }
            Quaternion quaternion = eVar.f28100c;
            if (quaternion != null) {
                cVar.f28080e.set(quaternion);
            }
            Vector3 vector32 = eVar.f28101d;
            if (vector32 != null) {
                cVar.f28081f.set(vector32);
            }
            c.b.b.n.l.g.g.h[] hVarArr = eVar.f28102e;
            if (hVarArr != null) {
                for (c.b.b.n.l.g.g.h hVar : hVarArr) {
                    c cVar2 = null;
                    if (hVar.f28108b != null) {
                        a.b<c.b.b.n.l.g.b> it = this.f28039i.iterator();
                        while (it.hasNext()) {
                            bVar = it.next();
                            if (hVar.f28108b.equals(bVar.a)) {
                                break;
                            }
                        }
                    }
                    bVar = null;
                    if (hVar.a != null) {
                        a.b<c> it2 = this.f28035e.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            c next = it2.next();
                            if (hVar.a.equals(next.f28034h)) {
                                cVar2 = next;
                                break;
                            }
                        }
                    }
                    if (bVar != null && cVar2 != null) {
                        f fVar = new f();
                        cVar.f28084i.a(fVar);
                        c.b.b.q.b<String, Matrix4> bVar2 = hVar.f28109c;
                        if (bVar2 != null) {
                            this.f28041k.i(fVar, bVar2);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + cVar.a);
                    }
                }
            }
            c.b.b.n.l.g.g.e[] eVarArr = eVar.f28103f;
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
            this.f28041k.clear();
            for (c.b.b.n.l.g.g.e eVar : iterable) {
                this.f28036f.a(p(eVar));
            }
            w.a<f, c.b.b.q.b<String, Matrix4>> b2 = this.f28041k.b();
            b2.d();
            while (b2.hasNext()) {
                w.b next = b2.next();
                K k2 = next.a;
                if (((f) k2).a == null) {
                    ((f) k2).a = new c.b.b.q.b<>(c.b.b.n.l.g.c.class, Matrix4.class);
                }
                ((f) next.a).a.clear();
                b.a b3 = ((c.b.b.q.b) next.f28388b).b();
                b3.iterator();
                while (b3.hasNext()) {
                    w.b next2 = b3.next();
                    ((f) next.a).a.f(i((String) next2.a), new Matrix4((Matrix4) next2.f28388b).inv());
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
        this.f28035e = new c.b.b.q.a<>();
        this.f28036f = new c.b.b.q.a<>();
        this.f28037g = new c.b.b.q.a<>();
        this.f28038h = new c.b.b.q.a<>();
        this.f28039i = new c.b.b.q.a<>();
        this.f28040j = new c.b.b.q.a<>();
        this.f28041k = new w<>();
        l(bVar, bVar2);
    }
}
