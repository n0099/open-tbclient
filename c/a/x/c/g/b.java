package c.a.x.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static long f31055i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static int f31056j = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f31057a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31058b;

    /* renamed from: c  reason: collision with root package name */
    public e f31059c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f31060d;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f31061e;

    /* renamed from: f  reason: collision with root package name */
    public c f31062f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31063g;

    /* renamed from: h  reason: collision with root package name */
    public long f31064h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-92176438, "Lc/a/x/c/g/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-92176438, "Lc/a/x/c/g/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31057a = -1;
        this.f31058b = false;
        this.f31064h = 0L;
        this.f31061e = new MediaCodec.BufferInfo();
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.f31058b && this.f31057a == -1) {
                return;
            }
            int dequeueInputBuffer = this.f31060d.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                if (z) {
                    this.f31060d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
                    return;
                } else {
                    MediaCodec mediaCodec = this.f31060d;
                    MediaCodec.BufferInfo bufferInfo = this.f31061e;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
                }
            }
            b(z, f31056j);
        }
    }

    public final void b(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) != null) {
            return;
        }
        ByteBuffer[] outputBuffers = this.f31060d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f31060d.dequeueOutputBuffer(this.f31061e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f31060d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f31059c.c()) {
                        return;
                    }
                    MediaFormat outputFormat = this.f31060d.getOutputFormat();
                    String str = "encoder output format changed: " + outputFormat;
                    this.f31057a = this.f31059c.a(outputFormat);
                    this.f31058b = true;
                    c cVar = this.f31062f;
                    if (cVar != null) {
                        cVar.c(true);
                    }
                    if (this.f31063g) {
                        this.f31059c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer;
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f31061e.flags & 2) != 0) {
                            this.f31061e.size = 0;
                        }
                        if (this.f31061e.size != 0 && this.f31059c.c()) {
                            byteBuffer.position(this.f31061e.offset);
                            MediaCodec.BufferInfo bufferInfo = this.f31061e;
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            j();
                            this.f31059c.g(this.f31057a, byteBuffer, this.f31061e);
                        }
                        this.f31060d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f31061e.flags & 4) != 0) {
                            if (z) {
                                if (this.f31063g) {
                                    this.f31059c.f();
                                }
                                c cVar2 = this.f31062f;
                                if (cVar2 != null) {
                                    cVar2.a(true);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
            } catch (IllegalStateException unused) {
                System.getProperty("ro.board.platform");
                String str3 = "mEncoder.dequeueOutputBuffer IllegalStateException error hard:" + System.getProperty("ro.board.platform");
                return;
            }
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                e eVar = this.f31059c;
                if (eVar != null && eVar.c()) {
                    this.f31060d.signalEndOfInputStream();
                } else {
                    c cVar = this.f31062f;
                    if (cVar != null) {
                        cVar.a(true);
                        return;
                    }
                    return;
                }
            }
            b(z, 10000);
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31064h * 1000 : invokeV.longValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f31060d.release();
            this.f31060d = null;
            this.f31059c = null;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f31062f = cVar;
        }
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            ByteBuffer byteBuffer2 = this.f31060d.getInputBuffers()[i2];
            if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
                byteBuffer2.position(0);
                byteBuffer2.put(byteBuffer);
                byteBuffer2.flip();
                MediaCodec.BufferInfo bufferInfo = this.f31061e;
                bufferInfo.offset = 0;
                bufferInfo.size = i3;
                bufferInfo.presentationTimeUs = j2 / 1000;
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f31060d.start();
            c cVar = this.f31062f;
            if (cVar != null) {
                cVar.d(true);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.f31060d.stop();
            } catch (Exception unused) {
            }
        }
    }

    public abstract void j();
}
