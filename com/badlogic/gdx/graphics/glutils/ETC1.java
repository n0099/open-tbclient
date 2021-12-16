package com.badlogic.gdx.graphics.glutils;

import c.b.b.q.h;
import c.b.b.q.i0;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.d;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;
/* loaded from: classes9.dex */
public class ETC1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 16;

    /* renamed from: b  reason: collision with root package name */
    public static int f31985b = 36196;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-531216249, "Lcom/badlogic/gdx/graphics/glutils/ETC1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-531216249, "Lcom/badlogic/gdx/graphics/glutils/ETC1;");
        }
    }

    public ETC1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Pixmap a(a aVar, Pixmap.Format format) {
        InterceptResult invokeLL;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aVar, format)) == null) {
            if (aVar.f()) {
                int widthPKM = getWidthPKM(aVar.f31988g, 0);
                i2 = getHeightPKM(aVar.f31988g, 0);
                i3 = widthPKM;
                i4 = 16;
            } else {
                int i5 = aVar.f31986e;
                i2 = aVar.f31987f;
                i3 = i5;
                i4 = 0;
            }
            int b2 = b(format);
            Pixmap pixmap = new Pixmap(i3, i2, format);
            decodeImage(aVar.f31988g, i4, pixmap.m(), 0, i3, i2, b2);
            return pixmap;
        }
        return (Pixmap) invokeLL.objValue;
    }

    public static int b(Pixmap.Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, format)) == null) {
            if (format == Pixmap.Format.RGB565) {
                return 2;
            }
            if (format == Pixmap.Format.RGB888) {
                return 3;
            }
            throw new GdxRuntimeException("Can only handle RGB565 or RGB888 images");
        }
        return invokeL.intValue;
    }

    public static native void decodeImage(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4, int i5, int i6);

    public static native ByteBuffer encodeImage(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5);

    public static native ByteBuffer encodeImagePKM(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5);

    public static native void formatHeader(ByteBuffer byteBuffer, int i2, int i3, int i4);

    public static native int getCompressedDataSize(int i2, int i3);

    public static native int getHeightPKM(ByteBuffer byteBuffer, int i2);

    public static native int getWidthPKM(ByteBuffer byteBuffer, int i2);

    public static native boolean isValidPKM(ByteBuffer byteBuffer, int i2);

    /* loaded from: classes9.dex */
    public static final class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f31986e;

        /* renamed from: f  reason: collision with root package name */
        public final int f31987f;

        /* renamed from: g  reason: collision with root package name */
        public final ByteBuffer f31988g;

        /* renamed from: h  reason: collision with root package name */
        public final int f31989h;

        public a(int i2, int i3, ByteBuffer byteBuffer, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), byteBuffer, Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31986e = i2;
            this.f31987f = i3;
            this.f31988g = byteBuffer;
            this.f31989h = i4;
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.g(this.f31986e) && d.g(this.f31987f)) {
                    return;
                }
                System.out.println("ETC1Data warning: non-power-of-two ETC1 textures may crash the driver of PowerVR GPUs");
            }
        }

        @Override // c.b.b.q.h
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                BufferUtils.b(this.f31988g);
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31989h == 16 : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (f()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ETC1.isValidPKM(this.f31988g, 0) ? "valid" : "invalid");
                    sb.append(" pkm [");
                    sb.append(ETC1.getWidthPKM(this.f31988g, 0));
                    sb.append("x");
                    sb.append(ETC1.getHeightPKM(this.f31988g, 0));
                    sb.append("], compressed: ");
                    sb.append(this.f31988g.capacity() - ETC1.a);
                    return sb.toString();
                }
                return "raw [" + this.f31986e + "x" + this.f31987f + "], compressed: " + (this.f31988g.capacity() - ETC1.a);
            }
            return (String) invokeV.objValue;
        }

        public a(c.b.b.m.a aVar) {
            DataInputStream dataInputStream;
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
            byte[] bArr = new byte[10240];
            DataInputStream dataInputStream2 = null;
            try {
                try {
                    dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(aVar.m())));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f31988g = BufferUtils.e(dataInputStream.readInt());
                while (true) {
                    int read = dataInputStream.read(bArr);
                    if (read != -1) {
                        this.f31988g.put(bArr, 0, read);
                    } else {
                        this.f31988g.position(0);
                        this.f31988g.limit(this.f31988g.capacity());
                        i0.a(dataInputStream);
                        this.f31986e = ETC1.getWidthPKM(this.f31988g, 0);
                        this.f31987f = ETC1.getHeightPKM(this.f31988g, 0);
                        int i4 = ETC1.a;
                        this.f31989h = i4;
                        this.f31988g.position(i4);
                        a();
                        return;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream2 = dataInputStream;
                throw new GdxRuntimeException("Couldn't load pkm file '" + aVar + "'", e);
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                i0.a(dataInputStream2);
                throw th;
            }
        }
    }
}
