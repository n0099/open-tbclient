package c.b.b.j.f;

import c.b.b.j.f.p;
import c.b.b.n.k.a;
import c.b.b.n.k.h;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c extends b<c.b.b.n.k.a, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a.C1594a f27722b;

    /* loaded from: classes9.dex */
    public static class a extends c.b.b.j.c<c.b.b.n.k.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public boolean f27723b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f27724c;

        /* renamed from: d  reason: collision with root package name */
        public Texture.TextureFilter f27725d;

        /* renamed from: e  reason: collision with root package name */
        public Texture.TextureFilter f27726e;

        /* renamed from: f  reason: collision with root package name */
        public a.C1594a f27727f;

        /* renamed from: g  reason: collision with root package name */
        public String f27728g;

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
            this.f27723b = false;
            this.f27724c = false;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.f27725d = textureFilter;
            this.f27726e = textureFilter;
            this.f27727f = null;
            this.f27728g = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.a
    /* renamed from: f */
    public c.b.b.q.a<c.b.b.j.a> a(String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLL;
        String str2;
        a.C1594a c1594a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, aVar, aVar2)) == null) {
            c.b.b.q.a<c.b.b.j.a> aVar3 = new c.b.b.q.a<>();
            if (aVar2 != null && (c1594a = aVar2.f27727f) != null) {
                this.f27722b = c1594a;
                return aVar3;
            }
            this.f27722b = new a.C1594a(aVar, aVar2 != null && aVar2.f27723b);
            if (aVar2 != null && (str2 = aVar2.f27728g) != null) {
                aVar3.a(new c.b.b.j.a(str2, c.b.b.n.k.h.class));
            } else {
                for (int i2 = 0; i2 < this.f27722b.d().length; i2++) {
                    c.b.b.m.a b2 = b(this.f27722b.c(i2));
                    p.b bVar = new p.b();
                    if (aVar2 != null) {
                        bVar.f27766c = aVar2.f27724c;
                        bVar.f27769f = aVar2.f27725d;
                        bVar.f27770g = aVar2.f27726e;
                    }
                    aVar3.a(new c.b.b.j.a(b2, Texture.class, bVar));
                }
            }
            return aVar3;
        }
        return (c.b.b.q.a) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: g */
    public void c(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, eVar, str, aVar, aVar2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: h */
    public c.b.b.n.k.a d(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, eVar, str, aVar, aVar2)) == null) {
            if (aVar2 != null && (str2 = aVar2.f27728g) != null) {
                String str3 = aVar.s(this.f27722b.f27878b[0]).h().toString();
                h.a f2 = ((c.b.b.n.k.h) eVar.j(str2, c.b.b.n.k.h.class)).f(str3);
                if (f2 != null) {
                    return new c.b.b.n.k.a(aVar, f2);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar2.f27728g);
            }
            int length = this.f27722b.d().length;
            c.b.b.q.a aVar3 = new c.b.b.q.a(length);
            for (int i2 = 0; i2 < length; i2++) {
                aVar3.a(new c.b.b.n.k.i((Texture) eVar.j(this.f27722b.c(i2), Texture.class)));
            }
            return new c.b.b.n.k.a(this.f27722b, (c.b.b.q.a<c.b.b.n.k.i>) aVar3, true);
        }
        return (c.b.b.n.k.a) invokeLLLL.objValue;
    }
}
