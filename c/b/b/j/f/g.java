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
/* loaded from: classes3.dex */
public abstract class g<P extends a> extends b<c.b.b.n.l.d, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.b.b.q.a<w.b<String, c.b.b.n.l.g.g.b>> f22375b;

    /* renamed from: c  reason: collision with root package name */
    public a f22376c;

    /* loaded from: classes3.dex */
    public static class a extends c.b.b.j.c<c.b.b.n.l.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public p.b f22377b;

        public a() {
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
            p.b bVar = new p.b();
            this.f22377b = bVar;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Linear;
            bVar.f22403g = textureFilter;
            bVar.f22402f = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.Repeat;
            bVar.i = textureWrap;
            bVar.f22404h = textureWrap;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22375b = new c.b.b.q.a<>();
        this.f22376c = new a();
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
            bVar.f22866b = h2;
            synchronized (this.f22375b) {
                this.f22375b.a(bVar);
            }
            p.b bVar2 = p != null ? p.f22377b : this.f22376c.f22377b;
            a.b<ModelMaterial> it = h2.f22610c.iterator();
            while (it.hasNext()) {
                c.b.b.q.a<c.b.b.n.l.g.g.i> aVar3 = it.next().i;
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
            synchronized (this.f22375b) {
                bVar = null;
                for (int i = 0; i < this.f22375b.f22717b; i++) {
                    if (this.f22375b.get(i).a.equals(str)) {
                        bVar = this.f22375b.get(i).f22866b;
                        this.f22375b.i(i);
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
