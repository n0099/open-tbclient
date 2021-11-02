package b.a.x0.l.d;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f29700a;

    /* renamed from: b  reason: collision with root package name */
    public String f29701b;

    /* renamed from: c  reason: collision with root package name */
    public int f29702c;

    /* renamed from: d  reason: collision with root package name */
    public int f29703d;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29700a = 88200L;
        this.f29701b = str;
    }

    public final void a(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bArr, i2) == null) {
            int[] iArr = {96000, 88200, 64000, MediaEncodeParams.AUDIO_SAMPLE_RATE, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
            int i3 = 0;
            while (true) {
                if (i3 >= 13) {
                    i3 = 4;
                    break;
                } else if (iArr[i3] == this.f29702c) {
                    break;
                } else {
                    i3++;
                }
            }
            bArr[0] = -1;
            bArr[1] = -7;
            bArr[2] = (byte) (64 + (i3 << 2) + 0);
            bArr[3] = (byte) (128 + (i2 >> 11));
            bArr[4] = (byte) ((i2 & 2047) >> 3);
            bArr[5] = (byte) (((i2 & 7) << 5) + 31);
            bArr[6] = -4;
        }
    }

    @TargetApi(16)
    public final MediaCodec b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", "audio/mp4a-latm");
            mediaFormat.setInteger("bitrate", EncoderParams.AUDIO_BIT_RATE);
            mediaFormat.setInteger("channel-count", this.f29703d);
            mediaFormat.setInteger("sample-rate", this.f29702c);
            mediaFormat.setInteger("aac-profile", 2);
            createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return createEncoderByType;
        }
        return (MediaCodec) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0223 A[Catch: Exception -> 0x021f, TRY_LEAVE, TryCatch #1 {Exception -> 0x021f, blocks: (B:97:0x021b, B:101:0x0223), top: B:109:0x021b }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x021b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01bf A[SYNTHETIC] */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        ByteBuffer[] byteBufferArr;
        long j;
        long j2;
        long j3;
        long j4;
        int dequeueInputBuffer;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
            return;
        }
        MediaCodec mediaCodec = null;
        try {
            try {
                if (this.f29702c == 0) {
                    this.f29702c = MediaEncodeParams.AUDIO_SAMPLE_RATE;
                }
                if (this.f29703d == 0) {
                    this.f29703d = 1;
                }
                this.f29700a = (this.f29702c * 16) / 8;
                fileInputStream = new FileInputStream(this.f29701b);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            fileOutputStream = null;
        }
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                try {
                    mediaCodec = b();
                    mediaCodec.start();
                    ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
                    ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    byte[] bArr = new byte[4096];
                    ByteBuffer[] byteBufferArr2 = outputBuffers;
                    long j5 = 0;
                    long j6 = 0;
                    boolean z2 = false;
                    int i3 = 0;
                    boolean z3 = false;
                    boolean z4 = false;
                    int i4 = 0;
                    while (!z3) {
                        ByteBuffer[] byteBufferArr3 = byteBufferArr2;
                        if (z4 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                            byteBufferArr = inputBuffers;
                            j = j5;
                            j2 = 10000;
                        } else {
                            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                            byteBuffer.clear();
                            int remaining = byteBuffer.remaining();
                            if (remaining != bArr.length) {
                                bArr = new byte[remaining];
                            }
                            byte[] bArr2 = bArr;
                            if (z2 || (i3 = fileInputStream.read(bArr2)) != -1) {
                                z = z2;
                                i2 = i3;
                            } else {
                                i2 = i3;
                                z = true;
                            }
                            if (z) {
                                j = j5;
                                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                byteBufferArr = inputBuffers;
                                bArr = bArr2;
                                z2 = z;
                                i3 = i2;
                                j2 = 10000;
                                z4 = true;
                            } else {
                                j = j5;
                                byteBuffer.put(bArr2, 0, i2);
                                int i5 = i4 + i2;
                                byteBufferArr = inputBuffers;
                                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i2, j6, 0);
                                i4 = i5;
                                j6 = (long) (((i5 / 2.0d) * 1000000.0d) / this.f29700a);
                                z2 = z;
                                i3 = i2;
                                j2 = 10000;
                                bArr = bArr2;
                            }
                        }
                        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, j2);
                        if (dequeueOutputBuffer < 0) {
                            j3 = j;
                            if (dequeueOutputBuffer == -3) {
                                j5 = j3;
                                byteBufferArr2 = mediaCodec.getOutputBuffers();
                                inputBuffers = byteBufferArr;
                            } else {
                                if (dequeueOutputBuffer == -2) {
                                    b.a.x0.t.c.b("format change : " + mediaCodec.getOutputFormat());
                                }
                                j5 = j3;
                                byteBufferArr2 = byteBufferArr3;
                            }
                        } else if ((bufferInfo.flags & 2) != 0) {
                            b.a.x0.t.c.b("audio encoder: codec config buffer");
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            j3 = j;
                            j5 = j3;
                            byteBufferArr2 = byteBufferArr3;
                        } else {
                            if (bufferInfo.size != 0) {
                                ByteBuffer byteBuffer2 = byteBufferArr3[dequeueOutputBuffer];
                                byteBuffer2.position(bufferInfo.offset);
                                byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                                b.a.x0.t.c.b(String.format(" writing audio sample : size=%s , presentationTimeUs=%s", Integer.valueOf(bufferInfo.size), Long.valueOf(bufferInfo.presentationTimeUs)));
                                j4 = j;
                                if (j4 < bufferInfo.presentationTimeUs) {
                                    long j7 = bufferInfo.presentationTimeUs;
                                    int i6 = bufferInfo.size;
                                    int i7 = i6 + 7;
                                    byteBuffer2.position(bufferInfo.offset);
                                    byteBuffer2.limit(bufferInfo.offset + i6);
                                    byte[] bArr3 = new byte[i7];
                                    a(bArr3, i7);
                                    byteBuffer2.get(bArr3, 7, i6);
                                    fileOutputStream.write(bArr3, 0, i7);
                                    b.a.x0.t.c.b(i7 + " bytes written.");
                                    j5 = j7;
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    byteBufferArr2 = byteBufferArr3;
                                    if ((bufferInfo.flags & 4) == 0) {
                                        inputBuffers = byteBufferArr;
                                        z3 = true;
                                    }
                                } else {
                                    b.a.x0.t.c.b("error sample! its presentationTimeUs should not lower than before. lastPTS = " + j4 + ", bufferPTS = " + bufferInfo.presentationTimeUs);
                                }
                            } else {
                                j4 = j;
                            }
                            j5 = j4;
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            byteBufferArr2 = byteBufferArr3;
                            if ((bufferInfo.flags & 4) == 0) {
                            }
                        }
                        inputBuffers = byteBufferArr;
                    }
                    b.a.x0.t.c.b("acc encode done");
                    if (mediaCodec != null) {
                        try {
                            mediaCodec.release();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                    if (mediaCodec != null) {
                        try {
                            mediaCodec.release();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (mediaCodec != null) {
                    try {
                        mediaCodec.release();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (mediaCodec != null) {
            }
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f29703d = i2;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f29702c = i2;
        }
    }
}
