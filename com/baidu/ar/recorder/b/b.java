package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
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
    public static final String TAG = "b";
    public transient /* synthetic */ FieldHolder $fh;
    public int uN;
    public boolean uO;
    public d uP;
    public MediaCodec uQ;
    public MediaCodec.BufferInfo uR;
    public c uS;
    public boolean uT;
    public long uU;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(750732615, "Lcom/baidu/ar/recorder/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(750732615, "Lcom/baidu/ar/recorder/b/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.uN = -1;
        this.uO = false;
        this.uU = 0L;
        this.uR = new MediaCodec.BufferInfo();
    }

    private void R(boolean z) {
        ByteBuffer[] byteBufferArr;
        int i;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            String str3 = TAG;
            com.baidu.ar.h.b.c(str3, "drainEncoder endOfStream = " + z);
            try {
                byteBufferArr = this.uQ.getOutputBuffers();
            } catch (Exception e2) {
                e2.printStackTrace();
                byteBufferArr = null;
            }
            if (byteBufferArr == null) {
                return;
            }
            while (true) {
                try {
                    i = this.uQ.dequeueOutputBuffer(this.uR, 10000L);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    i = 0;
                }
                String str4 = TAG;
                com.baidu.ar.h.b.c(str4, "drainEncoder encoderStatus = " + i);
                if (i == -1) {
                    if (!z) {
                        return;
                    }
                    com.baidu.ar.h.b.c(TAG, "no output available, spinning to await EOS");
                } else if (i == -3) {
                    byteBufferArr = this.uQ.getOutputBuffers();
                } else if (i == -2) {
                    if (this.uP.fU()) {
                        str = TAG;
                        str2 = "format changed twice!!!!";
                        break;
                    }
                    MediaFormat outputFormat = this.uQ.getOutputFormat();
                    String str5 = TAG;
                    com.baidu.ar.h.b.c(str5, "encoder output format changed: " + outputFormat);
                    this.uN = this.uP.a(outputFormat);
                    this.uO = true;
                    c cVar = this.uS;
                    if (cVar != null) {
                        cVar.M(true);
                    }
                    if (this.uT) {
                        this.uP.fV();
                    }
                } else if (i < 0) {
                    String str6 = TAG;
                    com.baidu.ar.h.b.l(str6, "unexpected result from encoder.dequeueOutputBuffer: " + i);
                } else {
                    ByteBuffer byteBuffer = byteBufferArr[i];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + i + " was null");
                    }
                    if ((this.uR.flags & 2) != 0) {
                        com.baidu.ar.h.b.c(TAG, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                        this.uR.size = 0;
                    }
                    if (this.uR.size != 0) {
                        if (this.uP.fU()) {
                            byteBuffer.position(this.uR.offset);
                            MediaCodec.BufferInfo bufferInfo = this.uR;
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            fQ();
                            String str7 = TAG;
                            com.baidu.ar.h.b.c(str7, "drainEncoder writeSampleData mBufferInfo = " + this.uR.presentationTimeUs + "&& size = " + this.uR.size);
                            this.uP.a(this.uN, byteBuffer, this.uR);
                        } else {
                            com.baidu.ar.h.b.c(TAG, "drainEncoder wait for mMuxer start !!!");
                        }
                    }
                    this.uQ.releaseOutputBuffer(i, false);
                    if ((this.uR.flags & 4) != 0) {
                        if (z) {
                            if (this.uT) {
                                this.uP.fW();
                            }
                            c cVar2 = this.uS;
                            if (cVar2 != null) {
                                cVar2.N(true);
                                return;
                            }
                            return;
                        }
                        str = TAG;
                        str2 = "reached end of stream unexpectedly";
                    }
                }
            }
            com.baidu.ar.h.b.b(str, str2);
        }
    }

    private boolean a(int i, ByteBuffer byteBuffer, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), byteBuffer, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            ByteBuffer byteBuffer2 = this.uQ.getInputBuffers()[i];
            if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
                byteBuffer2.position(0);
                byteBuffer2.put(byteBuffer);
                byteBuffer2.flip();
                MediaCodec.BufferInfo bufferInfo = this.uR;
                bufferInfo.offset = 0;
                bufferInfo.size = i2;
                bufferInfo.presentationTimeUs = j / 1000;
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            String str = TAG;
            com.baidu.ar.h.b.c(str, "drainSurface endOfStream = " + z);
            if (z) {
                d dVar = this.uP;
                if (dVar == null || !dVar.fU()) {
                    c cVar = this.uS;
                    if (cVar != null) {
                        cVar.N(true);
                        return;
                    }
                    return;
                }
                this.uQ.signalEndOfInputStream();
            }
            R(z);
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.uS = cVar;
        }
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        MediaCodec mediaCodec;
        int i2;
        int i3;
        long j2;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.uQ == null) {
            return;
        }
        int i5 = -1;
        if (this.uO && this.uN == -1) {
            return;
        }
        try {
            i5 = this.uQ.dequeueInputBuffer(10000L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (i5 >= 0) {
            if (z) {
                com.baidu.ar.h.b.c(TAG, "drainBuffer sending EOS to drainBufferEncoder");
                mediaCodec = this.uQ;
                i2 = 0;
                i3 = 0;
                j2 = 0;
                i4 = 4;
            } else if (!a(i5, byteBuffer, i, j)) {
                return;
            } else {
                mediaCodec = this.uQ;
                MediaCodec.BufferInfo bufferInfo = this.uR;
                i2 = bufferInfo.offset;
                i3 = bufferInfo.size;
                j2 = bufferInfo.presentationTimeUs;
                i4 = 0;
            }
            mediaCodec.queueInputBuffer(i5, i2, i3, j2, i4);
        } else {
            com.baidu.ar.h.b.c(TAG, "drainBuffer encode input buffer not available");
        }
        R(z);
    }

    public abstract void fQ();

    public void fR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.uQ.release();
            this.uQ = null;
            this.uP = null;
        }
    }

    public void fS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.baidu.ar.h.b.c(TAG, "stopEncoder !!!");
            MediaCodec mediaCodec = this.uQ;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void fT() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.baidu.ar.h.b.c(TAG, "startEncoder !!!");
            MediaCodec mediaCodec = this.uQ;
            if (mediaCodec != null) {
                try {
                    mediaCodec.start();
                } catch (Exception e2) {
                    z = false;
                    e2.printStackTrace();
                }
            }
            z = true;
            c cVar = this.uS;
            if (cVar != null) {
                cVar.L(z);
            }
        }
    }
}
