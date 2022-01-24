package c.b.b.j.f;

import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d extends c.b.b.j.f.b<Cubemap, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f26996b;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public c.b.b.n.b f26997b;

        /* renamed from: c  reason: collision with root package name */
        public Cubemap f26998c;

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
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends c.b.b.j.c<Cubemap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public Pixmap.Format f26999b;

        /* renamed from: c  reason: collision with root package name */
        public Cubemap f27000c;

        /* renamed from: d  reason: collision with root package name */
        public c.b.b.n.b f27001d;

        /* renamed from: e  reason: collision with root package name */
        public Texture.TextureFilter f27002e;

        /* renamed from: f  reason: collision with root package name */
        public Texture.TextureFilter f27003f;

        /* renamed from: g  reason: collision with root package name */
        public Texture.TextureWrap f27004g;

        /* renamed from: h  reason: collision with root package name */
        public Texture.TextureWrap f27005h;

        public b() {
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
            this.f26999b = null;
            this.f27000c = null;
            this.f27001d = null;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.f27002e = textureFilter;
            this.f27003f = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
            this.f27004g = textureWrap;
            this.f27005h = textureWrap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar) {
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
        this.f26996b = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.a
    /* renamed from: f */
    public c.b.b.q.a<c.b.b.j.a> a(String str, c.b.b.m.a aVar, b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, aVar, bVar)) == null) {
            return null;
        }
        return (c.b.b.q.a) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: g */
    public void c(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, b bVar) {
        c.b.b.n.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, eVar, str, aVar, bVar) == null) {
            a aVar2 = this.f26996b;
            aVar2.a = str;
            if (bVar != null && (bVar2 = bVar.f27001d) != null) {
                aVar2.f26997b = bVar2;
                aVar2.f26998c = bVar.f27000c;
            } else {
                a aVar3 = this.f26996b;
                aVar3.f26998c = null;
                if (bVar != null) {
                    Pixmap.Format format = bVar.f26999b;
                    aVar3.f26998c = bVar.f27000c;
                }
                if (str.contains(".ktx") || str.contains(".zktx")) {
                    this.f26996b.f26997b = new c.b.b.n.m.g(aVar, false);
                }
            }
            if (this.f26996b.f26997b.a()) {
                return;
            }
            this.f26996b.f26997b.prepare();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: h */
    public Cubemap d(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, eVar, str, aVar, bVar)) == null) {
            a aVar2 = this.f26996b;
            if (aVar2 == null) {
                return null;
            }
            Cubemap cubemap = aVar2.f26998c;
            if (cubemap != null) {
                cubemap.y(aVar2.f26997b);
            } else {
                cubemap = new Cubemap(this.f26996b.f26997b);
            }
            if (bVar != null) {
                cubemap.l(bVar.f27002e, bVar.f27003f);
                cubemap.m(bVar.f27004g, bVar.f27005h);
            }
            return cubemap;
        }
        return (Cubemap) invokeLLLL.objValue;
    }
}
