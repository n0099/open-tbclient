package com.badlogic.gdx.graphics;

import androidx.core.view.InputDeviceCompat;
import c.b.b.f;
import c.b.b.j.c;
import c.b.b.j.f.p;
import c.b.b.n.e;
import c.b.b.n.m.b;
import c.b.b.q.a;
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
import com.tachikoma.core.component.anim.TimeFunctionConst;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class Texture extends e {
    public static /* synthetic */ Interceptable $ic;
    public static c.b.b.j.e n;
    public static final Map<Application, c.b.b.q.a<Texture>> o;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureData m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

        public TextureFilter(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.glEnum = i3;
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
                int i2 = this.glEnum;
                return (i2 == 9728 || i2 == 9729) ? false : true;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

        public TextureWrap(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.glEnum = i3;
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

    /* loaded from: classes10.dex */
    public static class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        @Override // c.b.b.j.c.a
        public void a(c.b.b.j.e eVar, String str, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, cls) == null) {
                eVar.A(str, this.a);
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
        o = new HashMap();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Texture(c.b.b.m.a aVar, boolean z) {
        this(aVar, (Pixmap.Format) null, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.b.b.m.a) objArr2[0], (Pixmap.Format) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public static void s(Application application, Texture texture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, application, texture) == null) {
            c.b.b.q.a<Texture> aVar = o.get(application);
            if (aVar == null) {
                aVar = new c.b.b.q.a<>();
            }
            aVar.a(texture);
            o.put(application, aVar);
        }
    }

    public static void t(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, application) == null) {
            o.remove(application);
        }
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed textures/app: { ");
            for (Application application : o.keySet()) {
                sb.append(o.get(application).f27595f);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void y(Application application) {
        c.b.b.q.a<Texture> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, application) == null) || (aVar = o.get(application)) == null) {
            return;
        }
        c.b.b.j.e eVar = n;
        if (eVar == null) {
            for (int i2 = 0; i2 < aVar.f27595f; i2++) {
                aVar.get(i2).B();
            }
            return;
        }
        eVar.h();
        c.b.b.q.a<? extends Texture> aVar2 = new c.b.b.q.a<>(aVar);
        a.b<? extends Texture> it = aVar2.iterator();
        while (it.hasNext()) {
            Texture next = it.next();
            String m = n.m(next);
            if (m == null) {
                next.B();
            } else {
                int q = n.q(m);
                n.A(m, 0);
                next.f27320f = 0;
                p.b bVar = new p.b();
                bVar.f27241e = next.w();
                bVar.f27242f = next.h();
                bVar.f27243g = next.f();
                bVar.f27244h = next.j();
                bVar.f27245i = next.k();
                bVar.f27239c = next.m.g();
                bVar.f27240d = next;
                bVar.a = new a(q);
                n.C(m);
                next.f27320f = f.f27173e.a();
                n.w(m, Texture.class, bVar);
            }
        }
        aVar.clear();
        aVar.b(aVar2);
    }

    public void A(TextureData textureData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, textureData) == null) {
            if (this.m != null && textureData.b() != this.m.b()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.m = textureData;
            if (!textureData.a()) {
                textureData.prepare();
            }
            a();
            e.q(3553, textureData);
            o(this.f27321g, this.f27322h, true);
            p(this.f27323i, this.f27324j, true);
            n(this.k, true);
            f.f27173e.N(this.f27319e, 0);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (z()) {
                this.f27320f = f.f27173e.a();
                A(this.m);
                return;
            }
            throw new GdxRuntimeException("Tried to reload unmanaged Texture");
        }
    }

    @Override // c.b.b.n.e, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f27320f == 0) {
            return;
        }
        delete();
        if (!this.m.b() || o.get(f.a) == null) {
            return;
        }
        o.get(f.a).i(this, true);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextureData textureData = this.m;
            return textureData instanceof b ? textureData.toString() : super.toString();
        }
        return (String) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m.getHeight() : invokeV.intValue;
    }

    public TextureData w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : (TextureData) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m.getWidth() : invokeV.intValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m.b() : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Texture(c.b.b.m.a aVar, Pixmap.Format format, boolean z) {
        this(TextureData.a.a(aVar, format, z));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, format, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((TextureData) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Texture(TextureData textureData) {
        this(3553, f.f27173e.a(), textureData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textureData};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (TextureData) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Texture(int i2, int i3, TextureData textureData) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), textureData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        A(textureData);
        if (textureData.b()) {
            s(f.a, this);
        }
    }
}
