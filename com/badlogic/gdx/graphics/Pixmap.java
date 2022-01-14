package com.badlogic.gdx.graphics;

import androidx.core.view.InputDeviceCompat;
import c.b.b.n.a;
import c.b.b.q.h;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class Pixmap implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Gdx2DPixmap f31075e;

    /* renamed from: f  reason: collision with root package name */
    public int f31076f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31077g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

        public Blending(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Blending) Enum.valueOf(Blending.class, str) : (Blending) invokeL.objValue;
        }

        public static Blending[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Blending[]) $VALUES.clone() : (Blending[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

        public Filter(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Filter) Enum.valueOf(Filter.class, str) : (Filter) invokeL.objValue;
        }

        public static Filter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Filter[]) $VALUES.clone() : (Filter[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

        public Format(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Format fromGdx2DPixmapFormat(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 == 1) {
                    return Alpha;
                }
                if (i2 == 2) {
                    return LuminanceAlpha;
                }
                if (i2 == 5) {
                    return RGB565;
                }
                if (i2 == 6) {
                    return RGBA4444;
                }
                if (i2 == 3) {
                    return RGB888;
                }
                if (i2 == 4) {
                    return RGBA8888;
                }
                throw new GdxRuntimeException("Unknown Gdx2DPixmap Format: " + i2);
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
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, format)) == null) ? Gdx2DPixmap.r(toGdx2DPixmapFormat(format)) : invokeL.intValue;
        }

        public static int toGlType(Format format) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, format)) == null) ? Gdx2DPixmap.s(toGdx2DPixmapFormat(format)) : invokeL.intValue;
        }

        public static Format valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? (Format) Enum.valueOf(Format.class, str) : (Format) invokeL.objValue;
        }

        public static Format[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (Format[]) $VALUES.clone() : (Format[]) invokeV.objValue;
        }
    }

    public Pixmap(int i2, int i3, Format format) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), format};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Blending blending = Blending.SourceOver;
        Filter filter = Filter.BiLinear;
        this.f31076f = 0;
        this.f31075e = new Gdx2DPixmap(i2, i3, Format.toGdx2DPixmapFormat(format));
        p(0.0f, 0.0f, 0.0f, 0.0f);
        g();
    }

    public void a(Pixmap pixmap, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{pixmap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.f31075e.g(pixmap.f31075e, i4, i5, i2, i3, i6, i7);
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.f31077g) {
                this.f31075e.dispose();
                this.f31077g = true;
                return;
            }
            throw new GdxRuntimeException("Pixmap already disposed!");
        }
    }

    public void f(Pixmap pixmap, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pixmap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
            this.f31075e.h(pixmap.f31075e, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f31075e.a(this.f31076f);
        }
    }

    public Format h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Format.fromGdx2DPixmapFormat(this.f31075e.i()) : (Format) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31075e.k() : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31075e.l() : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31075e.m() : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31075e.n() : invokeV.intValue;
    }

    public ByteBuffer m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f31077g) {
                return this.f31075e.o();
            }
            throw new GdxRuntimeException("Pixmap already disposed");
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31075e.p() : invokeV.intValue;
    }

    public void o(Blending blending) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, blending) == null) {
            this.f31075e.q(blending == Blending.None ? 0 : 1);
        }
    }

    public void p(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.f31076f = a.b(f2, f3, f4, f5);
        }
    }

    public Pixmap(c.b.b.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Blending blending = Blending.SourceOver;
        Filter filter = Filter.BiLinear;
        this.f31076f = 0;
        try {
            byte[] n = aVar.n();
            this.f31075e = new Gdx2DPixmap(n, 0, n.length, 0);
        } catch (Exception e2) {
            throw new GdxRuntimeException("Couldn't load file: " + aVar, e2);
        }
    }
}
