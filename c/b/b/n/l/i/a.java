package c.b.b.n.l.i;

import c.b.b.n.e;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a<T extends e> implements Comparable<a<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public T f27681e;

    /* renamed from: f  reason: collision with root package name */
    public Texture.TextureFilter f27682f;

    /* renamed from: g  reason: collision with root package name */
    public Texture.TextureFilter f27683g;

    /* renamed from: h  reason: collision with root package name */
    public Texture.TextureWrap f27684h;

    /* renamed from: i  reason: collision with root package name */
    public Texture.TextureWrap f27685i;

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
        this.f27681e = null;
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
            T t = this.f27681e;
            int i2 = t == null ? 0 : t.f27475e;
            T t2 = aVar.f27681e;
            int i3 = t2 == null ? 0 : t2.f27475e;
            if (i2 != i3) {
                return i2 - i3;
            }
            T t3 = this.f27681e;
            int i4 = t3 == null ? 0 : t3.i();
            T t4 = aVar.f27681e;
            int i5 = t4 == null ? 0 : t4.i();
            if (i4 != i5) {
                return i4 - i5;
            }
            Texture.TextureFilter textureFilter = this.f27682f;
            if (textureFilter != aVar.f27682f) {
                int gLEnum = textureFilter == null ? 0 : textureFilter.getGLEnum();
                Texture.TextureFilter textureFilter2 = aVar.f27682f;
                return gLEnum - (textureFilter2 != null ? textureFilter2.getGLEnum() : 0);
            }
            Texture.TextureFilter textureFilter3 = this.f27683g;
            if (textureFilter3 != aVar.f27683g) {
                int gLEnum2 = textureFilter3 == null ? 0 : textureFilter3.getGLEnum();
                Texture.TextureFilter textureFilter4 = aVar.f27683g;
                return gLEnum2 - (textureFilter4 != null ? textureFilter4.getGLEnum() : 0);
            }
            Texture.TextureWrap textureWrap = this.f27684h;
            if (textureWrap != aVar.f27684h) {
                int gLEnum3 = textureWrap == null ? 0 : textureWrap.getGLEnum();
                Texture.TextureWrap textureWrap2 = aVar.f27684h;
                return gLEnum3 - (textureWrap2 != null ? textureWrap2.getGLEnum() : 0);
            }
            Texture.TextureWrap textureWrap3 = this.f27685i;
            if (textureWrap3 != aVar.f27685i) {
                int gLEnum4 = textureWrap3 == null ? 0 : textureWrap3.getGLEnum();
                Texture.TextureWrap textureWrap4 = aVar.f27685i;
                return gLEnum4 - (textureWrap4 != null ? textureWrap4.getGLEnum() : 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void b(T t, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, textureFilter, textureFilter2, textureWrap, textureWrap2) == null) {
            this.f27681e = t;
            this.f27682f = textureFilter;
            this.f27683g = textureFilter2;
            this.f27684h = textureWrap;
            this.f27685i = textureWrap2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T extends c.b.b.n.e] */
    public <V extends T> void c(a<V> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f27681e = aVar.f27681e;
            this.f27682f = aVar.f27682f;
            this.f27683g = aVar.f27683g;
            this.f27684h = aVar.f27684h;
            this.f27685i = aVar.f27685i;
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
                return aVar.f27681e == this.f27681e && aVar.f27682f == this.f27682f && aVar.f27683g == this.f27683g && aVar.f27684h == this.f27684h && aVar.f27685i == this.f27685i;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.f27681e;
            long j2 = (t == null ? 0 : t.f27475e) * 811;
            T t2 = this.f27681e;
            long i2 = (j2 + (t2 == null ? 0 : t2.i())) * 811;
            Texture.TextureFilter textureFilter = this.f27682f;
            long gLEnum = (i2 + (textureFilter == null ? 0 : textureFilter.getGLEnum())) * 811;
            Texture.TextureFilter textureFilter2 = this.f27683g;
            long gLEnum2 = (gLEnum + (textureFilter2 == null ? 0 : textureFilter2.getGLEnum())) * 811;
            Texture.TextureWrap textureWrap = this.f27684h;
            long gLEnum3 = (gLEnum2 + (textureWrap == null ? 0 : textureWrap.getGLEnum())) * 811;
            Texture.TextureWrap textureWrap2 = this.f27685i;
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
        this.f27681e = null;
    }
}
