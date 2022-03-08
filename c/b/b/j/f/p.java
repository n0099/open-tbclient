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
    public a f27139b;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public TextureData f27140b;

        /* renamed from: c  reason: collision with root package name */
        public Texture f27141c;

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

    /* loaded from: classes3.dex */
    public static class b extends c.b.b.j.c<Texture> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public Pixmap.Format f27142b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f27143c;

        /* renamed from: d  reason: collision with root package name */
        public Texture f27144d;

        /* renamed from: e  reason: collision with root package name */
        public TextureData f27145e;

        /* renamed from: f  reason: collision with root package name */
        public Texture.TextureFilter f27146f;

        /* renamed from: g  reason: collision with root package name */
        public Texture.TextureFilter f27147g;

        /* renamed from: h  reason: collision with root package name */
        public Texture.TextureWrap f27148h;

        /* renamed from: i  reason: collision with root package name */
        public Texture.TextureWrap f27149i;

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
            this.f27142b = null;
            this.f27143c = false;
            this.f27144d = null;
            this.f27145e = null;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.f27146f = textureFilter;
            this.f27147g = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
            this.f27148h = textureWrap;
            this.f27149i = textureWrap;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27139b = new a();
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
            a aVar2 = this.f27139b;
            aVar2.a = str;
            if (bVar != null && (textureData = bVar.f27145e) != null) {
                aVar2.f27140b = textureData;
                aVar2.f27141c = bVar.f27144d;
            } else {
                boolean z = false;
                a aVar3 = this.f27139b;
                Pixmap.Format format = null;
                aVar3.f27141c = null;
                if (bVar != null) {
                    format = bVar.f27142b;
                    z = bVar.f27143c;
                    aVar3.f27141c = bVar.f27144d;
                }
                this.f27139b.f27140b = TextureData.a.a(aVar, format, z);
            }
            if (this.f27139b.f27140b.a()) {
                return;
            }
            this.f27139b.f27140b.prepare();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.b
    /* renamed from: h */
    public Texture d(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, eVar, str, aVar, bVar)) == null) {
            a aVar2 = this.f27139b;
            if (aVar2 == null) {
                return null;
            }
            Texture texture = aVar2.f27141c;
            if (texture != null) {
                texture.A(aVar2.f27140b);
            } else {
                texture = new Texture(this.f27139b.f27140b);
            }
            if (bVar != null) {
                texture.l(bVar.f27146f, bVar.f27147g);
                texture.m(bVar.f27148h, bVar.f27149i);
            }
            return texture;
        }
        return (Texture) invokeLLLL.objValue;
    }
}
