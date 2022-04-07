package com.badlogic.gdx.graphics;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b1;
import com.repackage.h1;
import com.repackage.h3;
import com.repackage.j1;
import com.repackage.m3;
import com.repackage.o5;
import com.repackage.y6;
import com.repackage.z1;
import com.tachikoma.core.component.anim.TimeFunctionConst;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class Texture extends m3 {
    public static /* synthetic */ Interceptable $ic;
    public static j1 j;
    public static final Map<Application, y6<Texture>> k;
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
            Linear = new TextureFilter(TimeFunctionConst.Time.LINEAR, 1, 9729);
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TextureFilter) Enum.valueOf(TextureFilter.class, str) : (TextureFilter) invokeL.objValue;
        }

        public static TextureFilter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TextureFilter[]) $VALUES.clone() : (TextureFilter[]) invokeV.objValue;
        }

        public int getGLEnum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.glEnum : invokeV.intValue;
        }

        public boolean isMipMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.glEnum;
                return (i == 9728 || i == 9729) ? false : true;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TextureWrap) Enum.valueOf(TextureWrap.class, str) : (TextureWrap) invokeL.objValue;
        }

        public static TextureWrap[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TextureWrap[]) $VALUES.clone() : (TextureWrap[]) invokeV.objValue;
        }

        public int getGLEnum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.glEnum : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class a implements h1.a {
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

        @Override // com.repackage.h1.a
        public void a(j1 j1Var, String str, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, j1Var, str, cls) == null) {
                j1Var.A(str, this.a);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Texture(h3 h3Var, boolean z) {
        this(h3Var, (Pixmap.Format) null, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((h3) objArr2[0], (Pixmap.Format) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public static void s(Application application, Texture texture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, application, texture) == null) {
            y6<Texture> y6Var = k.get(application);
            if (y6Var == null) {
                y6Var = new y6<>();
            }
            y6Var.a(texture);
            k.put(application, y6Var);
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
        y6<Texture> y6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, application) == null) || (y6Var = k.get(application)) == null) {
            return;
        }
        j1 j1Var = j;
        if (j1Var == null) {
            for (int i = 0; i < y6Var.b; i++) {
                y6Var.get(i).B();
            }
            return;
        }
        j1Var.h();
        y6<? extends Texture> y6Var2 = new y6<>(y6Var);
        y6.b<? extends Texture> it = y6Var2.iterator();
        while (it.hasNext()) {
            Texture next = it.next();
            String m = j.m(next);
            if (m == null) {
                next.B();
            } else {
                int q = j.q(m);
                j.A(m, 0);
                next.b = 0;
                z1.b bVar = new z1.b();
                bVar.e = next.w();
                bVar.f = next.h();
                bVar.g = next.f();
                bVar.h = next.j();
                bVar.i = next.k();
                bVar.c = next.i.g();
                bVar.d = next;
                bVar.a = new a(q);
                j.C(m);
                next.b = b1.e.a();
                j.w(m, Texture.class, bVar);
            }
        }
        y6Var.clear();
        y6Var.b(y6Var2);
    }

    public void A(TextureData textureData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, textureData) == null) {
            if (this.i != null && textureData.b() != this.i.b()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = textureData;
            if (!textureData.a()) {
                textureData.prepare();
            }
            a();
            m3.q(3553, textureData);
            o(this.c, this.d, true);
            p(this.e, this.f, true);
            n(this.g, true);
            b1.e.N(this.a, 0);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (z()) {
                this.b = b1.e.a();
                A(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload unmanaged Texture");
        }
    }

    @Override // com.repackage.m3, com.repackage.f7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.b == 0) {
            return;
        }
        delete();
        if (!this.i.b() || k.get(b1.a) == null) {
            return;
        }
        k.get(b1.a).j(this, true);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextureData textureData = this.i;
            return textureData instanceof o5 ? textureData.toString() : super.toString();
        }
        return (String) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i.getHeight() : invokeV.intValue;
    }

    public TextureData w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (TextureData) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i.getWidth() : invokeV.intValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i.b() : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Texture(h3 h3Var, Pixmap.Format format, boolean z) {
        this(TextureData.a.a(h3Var, format, z));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h3Var, format, Boolean.valueOf(z)};
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
    public Texture(TextureData textureData) {
        this(3553, b1.e.a(), textureData);
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
        if (textureData.b()) {
            s(b1.a, this);
        }
    }
}
