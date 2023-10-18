package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c1;
import com.baidu.tieba.h2;
import com.baidu.tieba.r2;
import com.baidu.tieba.y0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class Texture extends h2 {
    public static /* synthetic */ Interceptable $ic;
    public static c1 j;
    public static final Map<Application, r2<Texture>> k;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureData i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class TextureFilter {
        public static final /* synthetic */ TextureFilter[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TextureFilter Linear;
        public static final TextureFilter MipMap;
        public static final TextureFilter MipMapLinearLinear;
        public static final TextureFilter MipMapLinearNearest;
        public static final TextureFilter MipMapNearestLinear;
        public static final TextureFilter MipMapNearestNearest;
        public static final TextureFilter Nearest;
        public transient /* synthetic */ FieldHolder $fh;
        public final int glEnum;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(331001797, "Lcom/badlogic/gdx/graphics/Texture$TextureFilter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(331001797, "Lcom/badlogic/gdx/graphics/Texture$TextureFilter;");
                    return;
                }
            }
            Nearest = new TextureFilter("Nearest", 0, 9728);
            Linear = new TextureFilter("Linear", 1, 9729);
            MipMap = new TextureFilter("MipMap", 2, 9987);
            MipMapNearestNearest = new TextureFilter("MipMapNearestNearest", 3, 9984);
            MipMapLinearNearest = new TextureFilter("MipMapLinearNearest", 4, 9985);
            MipMapNearestLinear = new TextureFilter("MipMapNearestLinear", 5, 9986);
            TextureFilter textureFilter = new TextureFilter("MipMapLinearLinear", 6, 9987);
            MipMapLinearLinear = textureFilter;
            $VALUES = new TextureFilter[]{Nearest, Linear, MipMap, MipMapNearestNearest, MipMapLinearNearest, MipMapNearestLinear, textureFilter};
        }

        public TextureFilter(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.glEnum = i2;
        }

        public static TextureFilter valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (TextureFilter) Enum.valueOf(TextureFilter.class, str);
            }
            return (TextureFilter) invokeL.objValue;
        }

        public static TextureFilter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (TextureFilter[]) $VALUES.clone();
            }
            return (TextureFilter[]) invokeV.objValue;
        }

        public int getGLEnum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.glEnum;
            }
            return invokeV.intValue;
        }

        public boolean isMipMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.glEnum;
                if (i != 9728 && i != 9729) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class TextureWrap {
        public static final /* synthetic */ TextureWrap[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TextureWrap ClampToEdge;
        public static final TextureWrap MirroredRepeat;
        public static final TextureWrap Repeat;
        public transient /* synthetic */ FieldHolder $fh;
        public final int glEnum;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1629707699, "Lcom/badlogic/gdx/graphics/Texture$TextureWrap;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1629707699, "Lcom/badlogic/gdx/graphics/Texture$TextureWrap;");
                    return;
                }
            }
            MirroredRepeat = new TextureWrap("MirroredRepeat", 0, 33648);
            ClampToEdge = new TextureWrap("ClampToEdge", 1, 33071);
            TextureWrap textureWrap = new TextureWrap("Repeat", 2, 10497);
            Repeat = textureWrap;
            $VALUES = new TextureWrap[]{MirroredRepeat, ClampToEdge, textureWrap};
        }

        public TextureWrap(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.glEnum = i2;
        }

        public static TextureWrap valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (TextureWrap) Enum.valueOf(TextureWrap.class, str);
            }
            return (TextureWrap) invokeL.objValue;
        }

        public static TextureWrap[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (TextureWrap[]) $VALUES.clone();
            }
            return (TextureWrap[]) invokeV.objValue;
        }

        public int getGLEnum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.glEnum;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1530523564, "Lcom/badlogic/gdx/graphics/Texture;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1530523564, "Lcom/badlogic/gdx/graphics/Texture;");
                return;
            }
        }
        k = new HashMap();
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i.a();
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (p()) {
                this.b = y0.c.a();
                q(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload unmanaged Texture");
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void m(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            k.remove(application);
        }
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed textures/app: { ");
            for (Application application : k.keySet()) {
                sb.append(k.get(application).b);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void o(Application application) {
        r2<Texture> r2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, application) != null) || (r2Var = k.get(application)) == null) {
            return;
        }
        c1 c1Var = j;
        if (c1Var == null) {
            for (int i = 0; i < r2Var.b; i++) {
                r2Var.get(i).r();
            }
            return;
        }
        c1Var.b();
        r2<? extends Texture> r2Var2 = new r2<>(r2Var);
        r2.b<? extends Texture> it = r2Var2.iterator();
        if (!it.hasNext()) {
            r2Var.clear();
            r2Var.b(r2Var2);
            return;
        }
        j.c(it.next());
        throw null;
    }

    public void q(TextureData textureData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textureData) == null) {
            if (this.i != null && textureData.a() != this.i.a()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = textureData;
            if (!textureData.isPrepared()) {
                textureData.prepare();
            }
            b();
            h2.k(3553, textureData);
            i(this.c, this.d, true);
            j(this.e, this.f, true);
            h(this.g, true);
            y0.c.F(this.a, 0);
        }
    }

    @Override // com.baidu.tieba.h2, com.baidu.tieba.v2
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b == 0) {
            return;
        }
        c();
        if (this.i.a() && k.get(y0.a) != null) {
            k.get(y0.a).g(this, true);
        }
    }
}
