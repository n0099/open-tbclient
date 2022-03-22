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
/* loaded from: classes3.dex */
public class ETC1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 16;

    /* renamed from: b  reason: collision with root package name */
    public static int f23777b = 36196;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Pixmap a(a aVar, Pixmap.Format format) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aVar, format)) == null) {
            if (aVar.f()) {
                int widthPKM = getWidthPKM(aVar.f23779c, 0);
                i = getHeightPKM(aVar.f23779c, 0);
                i2 = widthPKM;
                i3 = 16;
            } else {
                int i4 = aVar.a;
                i = aVar.f23778b;
                i2 = i4;
                i3 = 0;
            }
            int b2 = b(format);
            Pixmap pixmap = new Pixmap(i2, i, format);
            decodeImage(aVar.f23779c, i3, pixmap.m(), 0, i2, i, b2);
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

    public static native void decodeImage(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4, int i5);

    public static native ByteBuffer encodeImage(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    public static native ByteBuffer encodeImagePKM(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    public static native void formatHeader(ByteBuffer byteBuffer, int i, int i2, int i3);

    public static native int getCompressedDataSize(int i, int i2);

    public static native int getHeightPKM(ByteBuffer byteBuffer, int i);

    public static native int getWidthPKM(ByteBuffer byteBuffer, int i);

    public static native boolean isValidPKM(ByteBuffer byteBuffer, int i);

    /* loaded from: classes3.dex */
    public static final class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23778b;

        /* renamed from: c  reason: collision with root package name */
        public final ByteBuffer f23779c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23780d;

        public a(int i, int i2, ByteBuffer byteBuffer, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f23778b = i2;
            this.f23779c = byteBuffer;
            this.f23780d = i3;
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.g(this.a) && d.g(this.f23778b)) {
                    return;
                }
                System.out.println("ETC1Data warning: non-power-of-two ETC1 textures may crash the driver of PowerVR GPUs");
            }
        }

        @Override // c.b.b.q.h
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                BufferUtils.b(this.f23779c);
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23780d == 16 : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (f()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ETC1.isValidPKM(this.f23779c, 0) ? "valid" : "invalid");
                    sb.append(" pkm [");
                    sb.append(ETC1.getWidthPKM(this.f23779c, 0));
                    sb.append("x");
                    sb.append(ETC1.getHeightPKM(this.f23779c, 0));
                    sb.append("], compressed: ");
                    sb.append(this.f23779c.capacity() - ETC1.a);
                    return sb.toString();
                }
                return "raw [" + this.a + "x" + this.f23778b + "], compressed: " + (this.f23779c.capacity() - ETC1.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.f23779c = BufferUtils.e(dataInputStream.readInt());
                while (true) {
                    int read = dataInputStream.read(bArr);
                    if (read != -1) {
                        this.f23779c.put(bArr, 0, read);
                    } else {
                        this.f23779c.position(0);
                        this.f23779c.limit(this.f23779c.capacity());
                        i0.a(dataInputStream);
                        this.a = ETC1.getWidthPKM(this.f23779c, 0);
                        this.f23778b = ETC1.getHeightPKM(this.f23779c, 0);
                        int i3 = ETC1.a;
                        this.f23780d = i3;
                        this.f23779c.position(i3);
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
