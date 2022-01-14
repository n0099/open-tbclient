package c.b.b.j.f;

import c.b.b.j.f.p;
import c.b.b.n.k.h;
import c.b.b.q.a;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class o extends n<c.b.b.n.k.h, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public h.c f26999b;

    /* loaded from: classes9.dex */
    public static class a extends c.b.b.j.c<c.b.b.n.k.h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public boolean f27000b;

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
            this.f27000b = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(e eVar) {
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
    /* renamed from: d */
    public c.b.b.q.a<c.b.b.j.a> a(String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar, aVar2)) == null) {
            c.b.b.m.a i2 = aVar.i();
            if (aVar2 != null) {
                this.f26999b = new h.c(aVar, i2, aVar2.f27000b);
            } else {
                this.f26999b = new h.c(aVar, i2, false);
            }
            c.b.b.q.a<c.b.b.j.a> aVar3 = new c.b.b.q.a<>();
            a.b<h.c.p> it = this.f26999b.a().iterator();
            while (it.hasNext()) {
                h.c.p next = it.next();
                p.b bVar = new p.b();
                bVar.f27004b = next.f27160f;
                bVar.f27005c = next.f27159e;
                bVar.f27008f = next.f27161g;
                bVar.f27009g = next.f27162h;
                aVar3.a(new c.b.b.j.a(next.a, Texture.class, bVar));
            }
            return aVar3;
        }
        return (c.b.b.q.a) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.n
    /* renamed from: e */
    public c.b.b.n.k.h c(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, eVar, str, aVar, aVar2)) == null) {
            a.b<h.c.p> it = this.f26999b.a().iterator();
            while (it.hasNext()) {
                h.c.p next = it.next();
                next.f27156b = (Texture) eVar.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            c.b.b.n.k.h hVar = new c.b.b.n.k.h(this.f26999b);
            this.f26999b = null;
            return hVar;
        }
        return (c.b.b.n.k.h) invokeLLLL.objValue;
    }
}
