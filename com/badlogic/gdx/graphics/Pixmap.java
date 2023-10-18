package com.badlogic.gdx.graphics;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d2;
import com.baidu.tieba.v2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class Pixmap implements v2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Gdx2DPixmap a;
    public int b;
    public boolean c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Blending {
        public static final /* synthetic */ Blending[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Blending None;
        public static final Blending SourceOver;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2122741143, "Lcom/badlogic/gdx/graphics/Pixmap$Blending;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2122741143, "Lcom/badlogic/gdx/graphics/Pixmap$Blending;");
                    return;
                }
            }
            None = new Blending("None", 0);
            Blending blending = new Blending("SourceOver", 1);
            SourceOver = blending;
            $VALUES = new Blending[]{None, blending};
        }

        public Blending(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Blending valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Blending) Enum.valueOf(Blending.class, str);
            }
            return (Blending) invokeL.objValue;
        }

        public static Blending[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Blending[]) $VALUES.clone();
            }
            return (Blending[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Filter {
        public static final /* synthetic */ Filter[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Filter BiLinear;
        public static final Filter NearestNeighbour;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1197405136, "Lcom/badlogic/gdx/graphics/Pixmap$Filter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1197405136, "Lcom/badlogic/gdx/graphics/Pixmap$Filter;");
                    return;
                }
            }
            NearestNeighbour = new Filter("NearestNeighbour", 0);
            Filter filter = new Filter("BiLinear", 1);
            BiLinear = filter;
            $VALUES = new Filter[]{NearestNeighbour, filter};
        }

        public Filter(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Filter valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Filter) Enum.valueOf(Filter.class, str);
            }
            return (Filter) invokeL.objValue;
        }

        public static Filter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Filter[]) $VALUES.clone();
            }
            return (Filter[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Format {
        public static final /* synthetic */ Format[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Format Alpha;
        public static final Format Intensity;
        public static final Format LuminanceAlpha;
        public static final Format RGB565;
        public static final Format RGB888;
        public static final Format RGBA4444;
        public static final Format RGBA8888;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1020301423, "Lcom/badlogic/gdx/graphics/Pixmap$Format;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1020301423, "Lcom/badlogic/gdx/graphics/Pixmap$Format;");
                    return;
                }
            }
            Alpha = new Format("Alpha", 0);
            Intensity = new Format("Intensity", 1);
            LuminanceAlpha = new Format("LuminanceAlpha", 2);
            RGB565 = new Format("RGB565", 3);
            RGBA4444 = new Format("RGBA4444", 4);
            RGB888 = new Format("RGB888", 5);
            Format format = new Format("RGBA8888", 6);
            RGBA8888 = format;
            $VALUES = new Format[]{Alpha, Intensity, LuminanceAlpha, RGB565, RGBA4444, RGB888, format};
        }

        public Format(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Format fromGdx2DPixmapFormat(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                if (i == 1) {
                    return Alpha;
                }
                if (i == 2) {
                    return LuminanceAlpha;
                }
                if (i == 5) {
                    return RGB565;
                }
                if (i == 6) {
                    return RGBA4444;
                }
                if (i == 3) {
                    return RGB888;
                }
                if (i == 4) {
                    return RGBA8888;
                }
                throw new GdxRuntimeException("Unknown Gdx2DPixmap Format: " + i);
            }
            return (Format) invokeI.objValue;
        }

        public static int toGdx2DPixmapFormat(Format format) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, format)) == null) {
                if (format == Alpha || format == Intensity) {
                    return 1;
                }
                if (format == LuminanceAlpha) {
                    return 2;
                }
                if (format == RGB565) {
                    return 5;
                }
                if (format == RGBA4444) {
                    return 6;
                }
                if (format == RGB888) {
                    return 3;
                }
                if (format == RGBA8888) {
                    return 4;
                }
                throw new GdxRuntimeException("Unknown Format: " + format);
            }
            return invokeL.intValue;
        }

        public static int toGlFormat(Format format) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, format)) == null) {
                return Gdx2DPixmap.n(toGdx2DPixmapFormat(format));
            }
            return invokeL.intValue;
        }

        public static int toGlType(Format format) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, format)) == null) {
                return Gdx2DPixmap.o(toGdx2DPixmapFormat(format));
            }
            return invokeL.intValue;
        }

        public static Format valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
                return (Format) Enum.valueOf(Format.class, str);
            }
            return (Format) invokeL.objValue;
        }

        public static Format[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                return (Format[]) $VALUES.clone();
            }
            return (Format[]) invokeV.objValue;
        }
    }

    public Pixmap(int i, int i2, Format format) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), format};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Blending blending = Blending.SourceOver;
        Filter filter = Filter.BiLinear;
        this.b = 0;
        this.a = new Gdx2DPixmap(i, i2, Format.toGdx2DPixmapFormat(format));
        m(0.0f, 0.0f, 0.0f, 0.0f);
        d();
    }

    public void b(Pixmap pixmap, int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{pixmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.a.c(pixmap.a, i3, i4, i, i2, i5, i6);
        }
    }

    public void c(Pixmap pixmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{pixmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            this.a.d(pixmap.a, i, i2, i3, i4, i5, i6, i7, i8);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.b(this.b);
        }
    }

    @Override // com.baidu.tieba.v2
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.c) {
                this.a.dispose();
                this.c = true;
                return;
            }
            throw new GdxRuntimeException("Pixmap already disposed!");
        }
    }

    public Format e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return Format.fromGdx2DPixmapFormat(this.a.e());
        }
        return (Format) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.g();
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.h();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.i();
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.j();
        }
        return invokeV.intValue;
    }

    public ByteBuffer j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.c) {
                return this.a.k();
            }
            throw new GdxRuntimeException("Pixmap already disposed");
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.l();
        }
        return invokeV.intValue;
    }

    public void l(Blending blending) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, blending) == null) {
            Gdx2DPixmap gdx2DPixmap = this.a;
            if (blending == Blending.None) {
                i = 0;
            } else {
                i = 1;
            }
            gdx2DPixmap.m(i);
        }
    }

    public void m(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.b = d2.b(f, f2, f3, f4);
        }
    }
}
