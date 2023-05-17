package com.badlogic.gdx.graphics;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a1;
import com.baidu.tieba.c3;
import com.baidu.tieba.e5;
import com.baidu.tieba.o6;
import com.baidu.tieba.q1;
import com.baidu.tieba.s0;
import com.baidu.tieba.x2;
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
public class Texture extends c3 {
    public static /* synthetic */ Interceptable $ic;
    public static a1 j;
    public static final Map<Application, o6<Texture>> k;
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

    /* loaded from: classes.dex */
    public static class a implements y0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // com.baidu.tieba.y0.a
        public void a(a1 a1Var, String str, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, a1Var, str, cls) == null) {
                a1Var.A(str, this.a);
            }
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

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (z()) {
                this.b = s0.e.a();
                A(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload unmanaged Texture");
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextureData textureData = this.i;
            if (textureData instanceof e5) {
                return textureData.toString();
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i.getHeight();
        }
        return invokeV.intValue;
    }

    public TextureData w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (TextureData) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i.getWidth();
        }
        return invokeV.intValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i.a();
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Texture(int i, int i2, TextureData textureData) {
        super(i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), textureData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        A(textureData);
        if (textureData.a()) {
            s(s0.a, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Texture(TextureData textureData) {
        this(3553, s0.e.a(), textureData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textureData};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (TextureData) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void A(TextureData textureData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, textureData) == null) {
            if (this.i != null && textureData.a() != this.i.a()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = textureData;
            if (!textureData.isPrepared()) {
                textureData.prepare();
            }
            a();
            c3.q(3553, textureData);
            o(this.c, this.d, true);
            p(this.e, this.f, true);
            n(this.g, true);
            s0.e.N(this.a, 0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Texture(x2 x2Var, Pixmap.Format format, boolean z) {
        this(TextureData.a.a(x2Var, format, z));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x2Var, format, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((TextureData) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Texture(x2 x2Var, boolean z) {
        this(x2Var, (Pixmap.Format) null, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x2Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((x2) objArr2[0], (Pixmap.Format) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public static void s(Application application, Texture texture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, application, texture) == null) {
            o6<Texture> o6Var = k.get(application);
            if (o6Var == null) {
                o6Var = new o6<>();
            }
            o6Var.a(texture);
            k.put(application, o6Var);
        }
    }

    public static void t(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, application) == null) {
            k.remove(application);
        }
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
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

    public static void y(Application application) {
        o6<Texture> o6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, null, application) != null) || (o6Var = k.get(application)) == null) {
            return;
        }
        a1 a1Var = j;
        if (a1Var == null) {
            for (int i = 0; i < o6Var.b; i++) {
                o6Var.get(i).B();
            }
            return;
        }
        a1Var.h();
        o6<? extends Texture> o6Var2 = new o6<>(o6Var);
        o6.b<? extends Texture> it = o6Var2.iterator();
        while (it.hasNext()) {
            Texture next = it.next();
            String m = j.m(next);
            if (m == null) {
                next.B();
            } else {
                int q = j.q(m);
                j.A(m, 0);
                next.b = 0;
                q1.b bVar = new q1.b();
                bVar.e = next.w();
                bVar.f = next.h();
                bVar.g = next.f();
                bVar.h = next.j();
                bVar.i = next.k();
                bVar.c = next.i.f();
                bVar.d = next;
                bVar.a = new a(q);
                j.C(m);
                next.b = s0.e.a();
                j.w(m, Texture.class, bVar);
            }
        }
        o6Var.clear();
        o6Var.b(o6Var2);
    }

    @Override // com.baidu.tieba.c3, com.baidu.tieba.v6
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.b == 0) {
            return;
        }
        delete();
        if (this.i.a() && k.get(s0.a) != null) {
            k.get(s0.a).i(this, true);
        }
    }
}
