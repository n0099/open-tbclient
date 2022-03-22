package c.b.b.j.f;

import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends c.b.b.j.f.b<Cubemap, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f22362b;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public c.b.b.n.b f22363b;

        /* renamed from: c  reason: collision with root package name */
        public Cubemap f22364c;

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
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends c.b.b.j.c<Cubemap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public Pixmap.Format f22365b;

        /* renamed from: c  reason: collision with root package name */
        public Cubemap f22366c;

        /* renamed from: d  reason: collision with root package name */
        public c.b.b.n.b f22367d;

        /* renamed from: e  reason: collision with root package name */
        public Texture.TextureFilter f22368e;

        /* renamed from: f  reason: collision with root package name */
        public Texture.TextureFilter f22369f;

        /* renamed from: g  reason: collision with root package name */
        public Texture.TextureWrap f22370g;

        /* renamed from: h  reason: collision with root package name */
        public Texture.TextureWrap f22371h;

        public b() {
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
            this.f22365b = null;
            this.f22366c = null;
            this.f22367d = null;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.f22368e = textureFilter;
            this.f22369f = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
            this.f22370g = textureWrap;
            this.f22371h = textureWrap;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22362b = new a();
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
            a aVar2 = this.f22362b;
            aVar2.a = str;
            if (bVar != null && (bVar2 = bVar.f22367d) != null) {
                aVar2.f22363b = bVar2;
                aVar2.f22364c = bVar.f22366c;
            } else {
                a aVar3 = this.f22362b;
                aVar3.f22364c = null;
                if (bVar != null) {
                    Pixmap.Format format = bVar.f22365b;
                    aVar3.f22364c = bVar.f22366c;
                }
                if (str.contains(".ktx") || str.contains(".zktx")) {
                    this.f22362b.f22363b = new c.b.b.n.m.g(aVar, false);
                }
            }
            if (this.f22362b.f22363b.a()) {
                return;
            }
            this.f22362b.f22363b.prepare();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: h */
    public Cubemap d(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, eVar, str, aVar, bVar)) == null) {
            a aVar2 = this.f22362b;
            if (aVar2 == null) {
                return null;
            }
            Cubemap cubemap = aVar2.f22364c;
            if (cubemap != null) {
                cubemap.y(aVar2.f22363b);
            } else {
                cubemap = new Cubemap(this.f22362b.f22363b);
            }
            if (bVar != null) {
                cubemap.l(bVar.f22368e, bVar.f22369f);
                cubemap.m(bVar.f22370g, bVar.f22371h);
            }
            return cubemap;
        }
        return (Cubemap) invokeLLLL.objValue;
    }
}
