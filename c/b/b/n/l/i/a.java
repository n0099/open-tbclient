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
    public T a;

    /* renamed from: b  reason: collision with root package name */
    public Texture.TextureFilter f22642b;

    /* renamed from: c  reason: collision with root package name */
    public Texture.TextureFilter f22643c;

    /* renamed from: d  reason: collision with root package name */
    public Texture.TextureWrap f22644d;

    /* renamed from: e  reason: collision with root package name */
    public Texture.TextureWrap f22645e;

    public a(T t, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, textureFilter, textureFilter2, textureWrap, textureWrap2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
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
            T t = this.a;
            int i = t == null ? 0 : t.a;
            T t2 = aVar.a;
            int i2 = t2 == null ? 0 : t2.a;
            if (i != i2) {
                return i - i2;
            }
            T t3 = this.a;
            int i3 = t3 == null ? 0 : t3.i();
            T t4 = aVar.a;
            int i4 = t4 == null ? 0 : t4.i();
            if (i3 != i4) {
                return i3 - i4;
            }
            Texture.TextureFilter textureFilter = this.f22642b;
            if (textureFilter != aVar.f22642b) {
                int gLEnum = textureFilter == null ? 0 : textureFilter.getGLEnum();
                Texture.TextureFilter textureFilter2 = aVar.f22642b;
                return gLEnum - (textureFilter2 != null ? textureFilter2.getGLEnum() : 0);
            }
            Texture.TextureFilter textureFilter3 = this.f22643c;
            if (textureFilter3 != aVar.f22643c) {
                int gLEnum2 = textureFilter3 == null ? 0 : textureFilter3.getGLEnum();
                Texture.TextureFilter textureFilter4 = aVar.f22643c;
                return gLEnum2 - (textureFilter4 != null ? textureFilter4.getGLEnum() : 0);
            }
            Texture.TextureWrap textureWrap = this.f22644d;
            if (textureWrap != aVar.f22644d) {
                int gLEnum3 = textureWrap == null ? 0 : textureWrap.getGLEnum();
                Texture.TextureWrap textureWrap2 = aVar.f22644d;
                return gLEnum3 - (textureWrap2 != null ? textureWrap2.getGLEnum() : 0);
            }
            Texture.TextureWrap textureWrap3 = this.f22645e;
            if (textureWrap3 != aVar.f22645e) {
                int gLEnum4 = textureWrap3 == null ? 0 : textureWrap3.getGLEnum();
                Texture.TextureWrap textureWrap4 = aVar.f22645e;
                return gLEnum4 - (textureWrap4 != null ? textureWrap4.getGLEnum() : 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void b(T t, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, textureFilter, textureFilter2, textureWrap, textureWrap2) == null) {
            this.a = t;
            this.f22642b = textureFilter;
            this.f22643c = textureFilter2;
            this.f22644d = textureWrap;
            this.f22645e = textureWrap2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T extends c.b.b.n.e] */
    public <V extends T> void c(a<V> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.a = aVar.a;
            this.f22642b = aVar.f22642b;
            this.f22643c = aVar.f22643c;
            this.f22644d = aVar.f22644d;
            this.f22645e = aVar.f22645e;
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
                return aVar.a == this.a && aVar.f22642b == this.f22642b && aVar.f22643c == this.f22643c && aVar.f22644d == this.f22644d && aVar.f22645e == this.f22645e;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.a;
            long j = (t == null ? 0 : t.a) * 811;
            T t2 = this.a;
            long i = (j + (t2 == null ? 0 : t2.i())) * 811;
            Texture.TextureFilter textureFilter = this.f22642b;
            long gLEnum = (i + (textureFilter == null ? 0 : textureFilter.getGLEnum())) * 811;
            Texture.TextureFilter textureFilter2 = this.f22643c;
            long gLEnum2 = (gLEnum + (textureFilter2 == null ? 0 : textureFilter2.getGLEnum())) * 811;
            Texture.TextureWrap textureWrap = this.f22644d;
            long gLEnum3 = (gLEnum2 + (textureWrap == null ? 0 : textureWrap.getGLEnum())) * 811;
            Texture.TextureWrap textureWrap2 = this.f22645e;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }
}
