package c.b.b.n.l.i;

import c.b.b.n.e;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a<T extends e> implements Comparable<a<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public T f27416e;

    /* renamed from: f  reason: collision with root package name */
    public Texture.TextureFilter f27417f;

    /* renamed from: g  reason: collision with root package name */
    public Texture.TextureFilter f27418g;

    /* renamed from: h  reason: collision with root package name */
    public Texture.TextureWrap f27419h;

    /* renamed from: i  reason: collision with root package name */
    public Texture.TextureWrap f27420i;

    public a(T t, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, textureFilter, textureFilter2, textureWrap, textureWrap2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27416e = null;
        b(t, textureFilter, textureFilter2, textureWrap, textureWrap2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == this) {
                return 0;
            }
            T t = this.f27416e;
            int i2 = t == null ? 0 : t.f27223e;
            T t2 = aVar.f27416e;
            int i3 = t2 == null ? 0 : t2.f27223e;
            if (i2 != i3) {
                return i2 - i3;
            }
            T t3 = this.f27416e;
            int i4 = t3 == null ? 0 : t3.i();
            T t4 = aVar.f27416e;
            int i5 = t4 == null ? 0 : t4.i();
            if (i4 != i5) {
                return i4 - i5;
            }
            Texture.TextureFilter textureFilter = this.f27417f;
            if (textureFilter != aVar.f27417f) {
                int gLEnum = textureFilter == null ? 0 : textureFilter.getGLEnum();
                Texture.TextureFilter textureFilter2 = aVar.f27417f;
                return gLEnum - (textureFilter2 != null ? textureFilter2.getGLEnum() : 0);
            }
            Texture.TextureFilter textureFilter3 = this.f27418g;
            if (textureFilter3 != aVar.f27418g) {
                int gLEnum2 = textureFilter3 == null ? 0 : textureFilter3.getGLEnum();
                Texture.TextureFilter textureFilter4 = aVar.f27418g;
                return gLEnum2 - (textureFilter4 != null ? textureFilter4.getGLEnum() : 0);
            }
            Texture.TextureWrap textureWrap = this.f27419h;
            if (textureWrap != aVar.f27419h) {
                int gLEnum3 = textureWrap == null ? 0 : textureWrap.getGLEnum();
                Texture.TextureWrap textureWrap2 = aVar.f27419h;
                return gLEnum3 - (textureWrap2 != null ? textureWrap2.getGLEnum() : 0);
            }
            Texture.TextureWrap textureWrap3 = this.f27420i;
            if (textureWrap3 != aVar.f27420i) {
                int gLEnum4 = textureWrap3 == null ? 0 : textureWrap3.getGLEnum();
                Texture.TextureWrap textureWrap4 = aVar.f27420i;
                return gLEnum4 - (textureWrap4 != null ? textureWrap4.getGLEnum() : 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void b(T t, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, textureFilter, textureFilter2, textureWrap, textureWrap2) == null) {
            this.f27416e = t;
            this.f27417f = textureFilter;
            this.f27418g = textureFilter2;
            this.f27419h = textureWrap;
            this.f27420i = textureWrap2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T extends c.b.b.n.e] */
    public <V extends T> void c(a<V> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f27416e = aVar.f27416e;
            this.f27417f = aVar.f27417f;
            this.f27418g = aVar.f27418g;
            this.f27419h = aVar.f27419h;
            this.f27420i = aVar.f27420i;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.f27416e == this.f27416e && aVar.f27417f == this.f27417f && aVar.f27418g == this.f27418g && aVar.f27419h == this.f27419h && aVar.f27420i == this.f27420i;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.f27416e;
            long j2 = (t == null ? 0 : t.f27223e) * 811;
            T t2 = this.f27416e;
            long i2 = (j2 + (t2 == null ? 0 : t2.i())) * 811;
            Texture.TextureFilter textureFilter = this.f27417f;
            long gLEnum = (i2 + (textureFilter == null ? 0 : textureFilter.getGLEnum())) * 811;
            Texture.TextureFilter textureFilter2 = this.f27418g;
            long gLEnum2 = (gLEnum + (textureFilter2 == null ? 0 : textureFilter2.getGLEnum())) * 811;
            Texture.TextureWrap textureWrap = this.f27419h;
            long gLEnum3 = (gLEnum2 + (textureWrap == null ? 0 : textureWrap.getGLEnum())) * 811;
            Texture.TextureWrap textureWrap2 = this.f27420i;
            long gLEnum4 = gLEnum3 + (textureWrap2 != null ? textureWrap2.getGLEnum() : 0);
            return (int) ((gLEnum4 >> 32) ^ gLEnum4);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(T t) {
        this(t, null, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((e) objArr2[0], (Texture.TextureFilter) objArr2[1], (Texture.TextureFilter) objArr2[2], (Texture.TextureWrap) objArr2[3], (Texture.TextureWrap) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

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
        this.f27416e = null;
    }
}
