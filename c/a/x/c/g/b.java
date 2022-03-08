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
/* loaded from: classes3.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static long f26541i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static int f26542j = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26543b;

    /* renamed from: c  reason: collision with root package name */
    public e f26544c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f26545d;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f26546e;

    /* renamed from: f  reason: collision with root package name */
    public c f26547f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26548g;

    /* renamed from: h  reason: collision with root package name */
    public long f26549h;

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
        this.a = -1;
        this.f26543b = false;
        this.f26549h = 0L;
        this.f26546e = new MediaCodec.BufferInfo();
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.f26543b && this.a == -1) {
                return;
            }
            int dequeueInputBuffer = this.f26545d.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                if (z) {
                    this.f26545d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
                    return;
                } else {
                    MediaCodec mediaCodec = this.f26545d;
                    MediaCodec.BufferInfo bufferInfo = this.f26546e;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
                }
            }
            b(z, f26542j);
        }
    }

    public final void b(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) != null) {
            return;
        }
        ByteBuffer[] outputBuffers = this.f26545d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f26545d.dequeueOutputBuffer(this.f26546e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f26545d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f26544c.c()) {
                        return;
                    }
                    MediaFormat outputFormat = this.f26545d.getOutputFormat();
                    String str = "encoder output format changed: " + outputFormat;
                    this.a = this.f26544c.a(outputFormat);
                    this.f26543b = true;
                    c cVar = this.f26547f;
                    if (cVar != null) {
                        cVar.c(true);
                    }
                    if (this.f26548g) {
                        this.f26544c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer;
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f26546e.flags & 2) != 0) {
                            this.f26546e.size = 0;
                        }
                        if (this.f26546e.size != 0 && this.f26544c.c()) {
                            byteBuffer.position(this.f26546e.offset);
                            MediaCodec.BufferInfo bufferInfo = this.f26546e;
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            j();
                            this.f26544c.g(this.a, byteBuffer, this.f26546e);
                        }
                        this.f26545d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f26546e.flags & 4) != 0) {
                            if (z) {
                                if (this.f26548g) {
                                    this.f26544c.f();
                                }
                                c cVar2 = this.f26547f;
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
                e eVar = this.f26544c;
                if (eVar != null && eVar.c()) {
                    this.f26545d.signalEndOfInputStream();
                } else {
                    c cVar = this.f26547f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26549h * 1000 : invokeV.longValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f26545d.release();
            this.f26545d = null;
            this.f26544c = null;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f26547f = cVar;
        }
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            ByteBuffer byteBuffer2 = this.f26545d.getInputBuffers()[i2];
            if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
                byteBuffer2.position(0);
                byteBuffer2.put(byteBuffer);
                byteBuffer2.flip();
                MediaCodec.BufferInfo bufferInfo = this.f26546e;
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
            this.f26545d.start();
            c cVar = this.f26547f;
            if (cVar != null) {
                cVar.d(true);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.f26545d.stop();
            } catch (Exception unused) {
            }
        }
    }

    public abstract void j();
}
