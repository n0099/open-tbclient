package c.b.b.j.f;

import c.b.b.j.f.g.a;
import c.b.b.j.f.p;
import c.b.b.n.l.i.b;
import c.b.b.q.a;
import c.b.b.q.w;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class g<P extends a> extends b<c.b.b.n.l.d, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.b.b.q.a<w.b<String, c.b.b.n.l.g.g.b>> f27367b;

    /* renamed from: c  reason: collision with root package name */
    public a f27368c;

    /* loaded from: classes7.dex */
    public static class a extends c.b.b.j.c<c.b.b.n.l.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public p.b f27369b;

        public a() {
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
            p.b bVar = new p.b();
            this.f27369b = bVar;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Linear;
            bVar.f27395g = textureFilter;
            bVar.f27394f = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.Repeat;
            bVar.f27397i = textureWrap;
            bVar.f27396h = textureWrap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27367b = new c.b.b.q.a<>();
        this.f27368c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [V, c.b.b.n.l.g.g.b] */
    @Override // c.b.b.j.f.a
    /* renamed from: f */
    public c.b.b.q.a<c.b.b.j.a> a(String str, c.b.b.m.a aVar, P p) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, aVar, p)) == null) {
            c.b.b.q.a<c.b.b.j.a> aVar2 = new c.b.b.q.a<>();
            ?? h2 = h(aVar, p);
            if (h2 == 0) {
                return aVar2;
            }
            w.b<String, c.b.b.n.l.g.g.b> bVar = new w.b<>();
            bVar.a = str;
            bVar.f27939b = h2;
            synchronized (this.f27367b) {
                this.f27367b.a(bVar);
            }
            p.b bVar2 = p != null ? p.f27369b : this.f27368c.f27369b;
            a.b<ModelMaterial> it = h2.f27643c.iterator();
            while (it.hasNext()) {
                c.b.b.q.a<c.b.b.n.l.g.g.i> aVar3 = it.next().f31614i;
                if (aVar3 != null) {
                    a.b<c.b.b.n.l.g.g.i> it2 = aVar3.iterator();
                    while (it2.hasNext()) {
                        aVar2.a(new c.b.b.j.a(it2.next().a, Texture.class, bVar2));
                    }
                }
            }
            return aVar2;
        }
        return (c.b.b.q.a) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: g */
    public void c(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, eVar, str, aVar, p) == null) {
        }
    }

    public abstract c.b.b.n.l.g.g.b h(c.b.b.m.a aVar, P p);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: i */
    public c.b.b.n.l.d d(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, P p) {
        InterceptResult invokeLLLL;
        c.b.b.n.l.g.g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, eVar, str, aVar, p)) == null) {
            synchronized (this.f27367b) {
                bVar = null;
                for (int i2 = 0; i2 < this.f27367b.f27768f; i2++) {
                    if (this.f27367b.get(i2).a.equals(str)) {
                        bVar = this.f27367b.get(i2).f27939b;
                        this.f27367b.h(i2);
                    }
                }
            }
            if (bVar == null) {
                return null;
            }
            c.b.b.n.l.d dVar = new c.b.b.n.l.d(bVar, new b.a(eVar));
            Iterator<c.b.b.q.h> it = dVar.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return dVar;
        }
        return (c.b.b.n.l.d) invokeLLLL.objValue;
    }
}
