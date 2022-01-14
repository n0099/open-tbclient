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
/* loaded from: classes9.dex */
public class Gdx2DPixmap implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f31078e;

    /* renamed from: f  reason: collision with root package name */
    public int f31079f;

    /* renamed from: g  reason: collision with root package name */
    public int f31080g;

    /* renamed from: h  reason: collision with root package name */
    public int f31081h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f31082i;

    /* renamed from: j  reason: collision with root package name */
    public long[] f31083j;

    public Gdx2DPixmap(byte[] bArr, int i2, int i3, int i4) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        long[] jArr = new long[4];
        this.f31083j = jArr;
        ByteBuffer load = load(jArr, bArr, i2, i3);
        this.f31082i = load;
        if (load != null) {
            long[] jArr2 = this.f31083j;
            this.f31078e = jArr2[0];
            this.f31079f = (int) jArr2[1];
            this.f31080g = (int) jArr2[2];
            int i7 = (int) jArr2[3];
            this.f31081h = i7;
            if (i4 == 0 || i4 == i7) {
                return;
            }
            f(i4);
            return;
        }
        throw new IOException("Error loading pixmap: " + getFailureReason());
    }

    public static native void clear(long j2, int i2);

    public static native void drawCircle(long j2, int i2, int i3, int i4, int i5);

    public static native void drawLine(long j2, int i2, int i3, int i4, int i5, int i6);

    public static native void drawPixmap(long j2, long j3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static native void drawRect(long j2, int i2, int i3, int i4, int i5, int i6);

    public static native void fillCircle(long j2, int i2, int i3, int i4, int i5);

    public static native void fillRect(long j2, int i2, int i3, int i4, int i5, int i6);

    public static native void fillTriangle(long j2, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native void free(long j2);

    public static native String getFailureReason();

    public static native int getPixel(long j2, int i2, int i3);

    public static String j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) {
            switch (i2) {
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

    public static native ByteBuffer load(long[] jArr, byte[] bArr, int i2, int i3);

    public static native ByteBuffer newPixmap(long[] jArr, int i2, int i3, int i4);

    public static int r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) {
            switch (i2) {
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
                    throw new GdxRuntimeException("unknown format: " + i2);
            }
        }
        return invokeI.intValue;
    }

    public static int s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) {
            switch (i2) {
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
                    throw new GdxRuntimeException("unknown format: " + i2);
            }
        }
        return invokeI.intValue;
    }

    public static native void setBlend(long j2, int i2);

    public static native void setPixel(long j2, int i2, int i3, int i4);

    public static native void setScale(long j2, int i2);

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            clear(this.f31078e, i2);
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            free(this.f31078e);
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            Gdx2DPixmap gdx2DPixmap = new Gdx2DPixmap(this.f31079f, this.f31080g, i2);
            gdx2DPixmap.q(0);
            gdx2DPixmap.g(this, 0, 0, 0, 0, this.f31079f, this.f31080g);
            dispose();
            this.f31078e = gdx2DPixmap.f31078e;
            this.f31081h = gdx2DPixmap.f31081h;
            this.f31080g = gdx2DPixmap.f31080g;
            this.f31083j = gdx2DPixmap.f31083j;
            this.f31082i = gdx2DPixmap.f31082i;
            this.f31079f = gdx2DPixmap.f31079f;
        }
    }

    public void g(Gdx2DPixmap gdx2DPixmap, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{gdx2DPixmap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            drawPixmap(gdx2DPixmap.f31078e, this.f31078e, i2, i3, i6, i7, i4, i5, i6, i7);
        }
    }

    public void h(Gdx2DPixmap gdx2DPixmap, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{gdx2DPixmap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
            drawPixmap(gdx2DPixmap.f31078e, this.f31078e, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31081h : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? l() : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r(this.f31081h) : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? s(this.f31081h) : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f31080g : invokeV.intValue;
    }

    public ByteBuffer o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31082i : (ByteBuffer) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f31079f : invokeV.intValue;
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            setBlend(this.f31078e, i2);
        }
    }

    public Gdx2DPixmap(int i2, int i3, int i4) throws GdxRuntimeException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long[] jArr = new long[4];
        this.f31083j = jArr;
        ByteBuffer newPixmap = newPixmap(jArr, i2, i3, i4);
        this.f31082i = newPixmap;
        if (newPixmap != null) {
            long[] jArr2 = this.f31083j;
            this.f31078e = jArr2[0];
            this.f31079f = (int) jArr2[1];
            this.f31080g = (int) jArr2[2];
            this.f31081h = (int) jArr2[3];
            return;
        }
        throw new GdxRuntimeException("Unable to allocate memory for pixmap: " + i2 + "x" + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + j(i4));
    }
}
