package com.badlogic.gdx.graphics.g2d;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.h;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class Gdx2DPixmap implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public int f23743b;

    /* renamed from: c  reason: collision with root package name */
    public int f23744c;

    /* renamed from: d  reason: collision with root package name */
    public int f23745d;

    /* renamed from: e  reason: collision with root package name */
    public ByteBuffer f23746e;

    /* renamed from: f  reason: collision with root package name */
    public long[] f23747f;

    public Gdx2DPixmap(byte[] bArr, int i, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        long[] jArr = new long[4];
        this.f23747f = jArr;
        ByteBuffer load = load(jArr, bArr, i, i2);
        this.f23746e = load;
        if (load != null) {
            long[] jArr2 = this.f23747f;
            this.a = jArr2[0];
            this.f23743b = (int) jArr2[1];
            this.f23744c = (int) jArr2[2];
            int i6 = (int) jArr2[3];
            this.f23745d = i6;
            if (i3 == 0 || i3 == i6) {
                return;
            }
            f(i3);
            return;
        }
        throw new IOException("Error loading pixmap: " + getFailureReason());
    }

    public static native void clear(long j, int i);

    public static native void drawCircle(long j, int i, int i2, int i3, int i4);

    public static native void drawLine(long j, int i, int i2, int i3, int i4, int i5);

    public static native void drawPixmap(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native void drawRect(long j, int i, int i2, int i3, int i4, int i5);

    public static native void fillCircle(long j, int i, int i2, int i3, int i4);

    public static native void fillRect(long j, int i, int i2, int i3, int i4, int i5);

    public static native void fillTriangle(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native void free(long j);

    public static native String getFailureReason();

    public static native int getPixel(long j, int i, int i2);

    public static String j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            switch (i) {
                case 1:
                    return AnimationProperty.OPACITY;
                case 2:
                    return "luminance alpha";
                case 3:
                    return "rgb888";
                case 4:
                    return "rgba8888";
                case 5:
                    return "rgb565";
                case 6:
                    return "rgba4444";
                default:
                    return "unknown";
            }
        }
        return (String) invokeI.objValue;
    }

    public static native ByteBuffer load(long[] jArr, byte[] bArr, int i, int i2);

    public static native ByteBuffer newPixmap(long[] jArr, int i, int i2, int i3);

    public static int r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            switch (i) {
                case 1:
                    return 6406;
                case 2:
                    return 6410;
                case 3:
                case 5:
                    return 6407;
                case 4:
                case 6:
                    return GeneratedTexture.FORMAT;
                default:
                    throw new GdxRuntimeException("unknown format: " + i);
            }
        }
        return invokeI.intValue;
    }

    public static int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) {
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return 5121;
                case 5:
                    return 33635;
                case 6:
                    return 32819;
                default:
                    throw new GdxRuntimeException("unknown format: " + i);
            }
        }
        return invokeI.intValue;
    }

    public static native void setBlend(long j, int i);

    public static native void setPixel(long j, int i, int i2, int i3);

    public static native void setScale(long j, int i);

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            clear(this.a, i);
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            free(this.a);
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            Gdx2DPixmap gdx2DPixmap = new Gdx2DPixmap(this.f23743b, this.f23744c, i);
            gdx2DPixmap.q(0);
            gdx2DPixmap.g(this, 0, 0, 0, 0, this.f23743b, this.f23744c);
            dispose();
            this.a = gdx2DPixmap.a;
            this.f23745d = gdx2DPixmap.f23745d;
            this.f23744c = gdx2DPixmap.f23744c;
            this.f23747f = gdx2DPixmap.f23747f;
            this.f23746e = gdx2DPixmap.f23746e;
            this.f23743b = gdx2DPixmap.f23743b;
        }
    }

    public void g(Gdx2DPixmap gdx2DPixmap, int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{gdx2DPixmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            drawPixmap(gdx2DPixmap.a, this.a, i, i2, i5, i6, i3, i4, i5, i6);
        }
    }

    public void h(Gdx2DPixmap gdx2DPixmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{gdx2DPixmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            drawPixmap(gdx2DPixmap.a, this.a, i, i2, i3, i4, i5, i6, i7, i8);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23745d : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? l() : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r(this.f23745d) : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? s(this.f23745d) : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f23744c : invokeV.intValue;
    }

    public ByteBuffer o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f23746e : (ByteBuffer) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f23743b : invokeV.intValue;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            setBlend(this.a, i);
        }
    }

    public Gdx2DPixmap(int i, int i2, int i3) throws GdxRuntimeException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long[] jArr = new long[4];
        this.f23747f = jArr;
        ByteBuffer newPixmap = newPixmap(jArr, i, i2, i3);
        this.f23746e = newPixmap;
        if (newPixmap != null) {
            long[] jArr2 = this.f23747f;
            this.a = jArr2[0];
            this.f23743b = (int) jArr2[1];
            this.f23744c = (int) jArr2[2];
            this.f23745d = (int) jArr2[3];
            return;
        }
        throw new GdxRuntimeException("Unable to allocate memory for pixmap: " + i + "x" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + j(i3));
    }
}
