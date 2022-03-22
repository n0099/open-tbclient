package c.b.b.j.f;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class p extends c.b.b.j.f.b<Texture, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f22395b;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public TextureData f22396b;

        /* renamed from: c  reason: collision with root package name */
        public Texture f22397c;

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
    public static class b extends c.b.b.j.c<Texture> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public Pixmap.Format f22398b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22399c;

        /* renamed from: d  reason: collision with root package name */
        public Texture f22400d;

        /* renamed from: e  reason: collision with root package name */
        public TextureData f22401e;

        /* renamed from: f  reason: collision with root package name */
        public Texture.TextureFilter f22402f;

        /* renamed from: g  reason: collision with root package name */
        public Texture.TextureFilter f22403g;

        /* renamed from: h  reason: collision with root package name */
        public Texture.TextureWrap f22404h;
        public Texture.TextureWrap i;

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
            this.f22398b = null;
            this.f22399c = false;
            this.f22400d = null;
            this.f22401e = null;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.f22402f = textureFilter;
            this.f22403g = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
            this.f22404h = textureWrap;
            this.i = textureWrap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(e eVar) {
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
        this.f22395b = new a();
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
        TextureData textureData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, eVar, str, aVar, bVar) == null) {
            a aVar2 = this.f22395b;
            aVar2.a = str;
            if (bVar != null && (textureData = bVar.f22401e) != null) {
                aVar2.f22396b = textureData;
                aVar2.f22397c = bVar.f22400d;
            } else {
                boolean z = false;
                a aVar3 = this.f22395b;
                Pixmap.Format format = null;
                aVar3.f22397c = null;
                if (bVar != null) {
                    format = bVar.f22398b;
                    z = bVar.f22399c;
                    aVar3.f22397c = bVar.f22400d;
                }
                this.f22395b.f22396b = TextureData.a.a(aVar, format, z);
            }
            if (this.f22395b.f22396b.a()) {
                return;
            }
            this.f22395b.f22396b.prepare();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: h */
    public Texture d(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, eVar, str, aVar, bVar)) == null) {
            a aVar2 = this.f22395b;
            if (aVar2 == null) {
                return null;
            }
            Texture texture = aVar2.f22397c;
            if (texture != null) {
                texture.A(aVar2.f22396b);
            } else {
                texture = new Texture(this.f22395b.f22396b);
            }
            if (bVar != null) {
                texture.l(bVar.f22402f, bVar.f22403g);
                texture.m(bVar.f22404h, bVar.i);
            }
            return texture;
        }
        return (Texture) invokeLLLL.objValue;
    }
}
