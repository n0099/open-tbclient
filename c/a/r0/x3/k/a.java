package c.a.r0.x3.k;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes4.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public long f29076d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29076d = 88200L;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00db A[Catch: all -> 0x01a7, Exception -> 0x01aa, TryCatch #8 {Exception -> 0x01aa, all -> 0x01a7, blocks: (B:13:0x002e, B:17:0x005b, B:19:0x0061, B:21:0x006d, B:24:0x0072, B:29:0x0082, B:33:0x00d5, B:35:0x00db, B:37:0x00e1, B:38:0x00ed, B:40:0x00f1, B:42:0x0123, B:43:0x0158, B:44:0x015d, B:49:0x0174, B:52:0x017c, B:30:0x00a0, B:54:0x019b), top: B:101:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01dc A[Catch: Exception -> 0x01d8, TRY_LEAVE, TryCatch #5 {Exception -> 0x01d8, blocks: (B:84:0x01d4, B:88:0x01dc), top: B:97:0x01d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // c.a.r0.x3.k.d
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        ByteBuffer[] byteBufferArr;
        long j2;
        int dequeueOutputBuffer;
        int dequeueInputBuffer;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
            return;
        }
        a aVar = this;
        FileInputStream fileInputStream = null;
        try {
            try {
                if (aVar.f29081b == 0) {
                    aVar.f29081b = MediaEncodeParams.AUDIO_SAMPLE_RATE;
                }
                if (aVar.f29082c == 0) {
                    aVar.f29082c = 1;
                }
                aVar.f29076d = (aVar.f29081b * 16) / 8;
                FileInputStream fileInputStream2 = new FileInputStream(aVar.f29080a);
                try {
                    fileOutputStream = new FileOutputStream(str);
                    try {
                        MediaCodec f2 = f();
                        f2.start();
                        ByteBuffer[] inputBuffers = f2.getInputBuffers();
                        ByteBuffer[] outputBuffers = f2.getOutputBuffers();
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        byte[] bArr = new byte[4096];
                        ByteBuffer[] byteBufferArr2 = outputBuffers;
                        long j3 = 0;
                        long j4 = 0;
                        boolean z2 = false;
                        int i3 = 0;
                        boolean z3 = false;
                        boolean z4 = false;
                        int i4 = 0;
                        while (!z3) {
                            if (z4 || (dequeueInputBuffer = f2.dequeueInputBuffer(10000L)) < 0) {
                                byteBufferArr = inputBuffers;
                            } else {
                                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                                byteBuffer.clear();
                                int remaining = byteBuffer.remaining();
                                if (remaining != bArr.length) {
                                    bArr = new byte[remaining];
                                }
                                byte[] bArr2 = bArr;
                                if (z2 || (i3 = fileInputStream2.read(bArr2)) != -1) {
                                    z = z2;
                                    i2 = i3;
                                } else {
                                    i2 = i3;
                                    z = true;
                                }
                                if (z) {
                                    f2.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                    byteBufferArr = inputBuffers;
                                    i3 = i2;
                                    bArr = bArr2;
                                    z2 = z;
                                    j2 = 10000;
                                    z4 = true;
                                    dequeueOutputBuffer = f2.dequeueOutputBuffer(bufferInfo, j2);
                                    if (dequeueOutputBuffer < 0) {
                                        if ((bufferInfo.flags & 2) != 0) {
                                            BdLog.i("audio encoder: codec config buffer");
                                            f2.releaseOutputBuffer(dequeueOutputBuffer, false);
                                        } else {
                                            if (bufferInfo.size != 0) {
                                                ByteBuffer byteBuffer2 = byteBufferArr2[dequeueOutputBuffer];
                                                byteBuffer2.position(bufferInfo.offset);
                                                byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                                                BdLog.i(String.format(" writing audio sample : size=%s , presentationTimeUs=%s", Integer.valueOf(bufferInfo.size), Long.valueOf(bufferInfo.presentationTimeUs)));
                                                if (j3 < bufferInfo.presentationTimeUs) {
                                                    long j5 = bufferInfo.presentationTimeUs;
                                                    int i5 = bufferInfo.size;
                                                    int i6 = i5 + 7;
                                                    byteBuffer2.position(bufferInfo.offset);
                                                    byteBuffer2.limit(bufferInfo.offset + i5);
                                                    byte[] bArr3 = new byte[i6];
                                                    aVar.e(bArr3, i6);
                                                    byteBuffer2.get(bArr3, 7, i5);
                                                    fileOutputStream.write(bArr3, 0, i6);
                                                    BdLog.i(i6 + " bytes written.");
                                                    j3 = j5;
                                                } else {
                                                    BdLog.i("error sample! its presentationTimeUs should not lower than before.");
                                                }
                                            }
                                            f2.releaseOutputBuffer(dequeueOutputBuffer, false);
                                            if ((bufferInfo.flags & 4) != 0) {
                                                aVar = this;
                                                inputBuffers = byteBufferArr;
                                                z3 = true;
                                            }
                                        }
                                    } else if (dequeueOutputBuffer == -3) {
                                        byteBufferArr2 = f2.getOutputBuffers();
                                    } else if (dequeueOutputBuffer == -2) {
                                        BdLog.i("format change : " + f2.getOutputFormat());
                                    }
                                    aVar = this;
                                    inputBuffers = byteBufferArr;
                                } else {
                                    int i7 = i2;
                                    byteBuffer.put(bArr2, 0, i7);
                                    int i8 = i4 + i7;
                                    byteBufferArr = inputBuffers;
                                    f2.queueInputBuffer(dequeueInputBuffer, 0, i7, j4, 0);
                                    i4 = i8;
                                    i3 = i7;
                                    j4 = (long) (((i8 / 2.0d) * 1000000.0d) / aVar.f29076d);
                                    bArr = bArr2;
                                    z2 = z;
                                }
                            }
                            j2 = 10000;
                            dequeueOutputBuffer = f2.dequeueOutputBuffer(bufferInfo, j2);
                            if (dequeueOutputBuffer < 0) {
                            }
                            aVar = this;
                            inputBuffers = byteBufferArr;
                        }
                        BdLog.i("acc encode done");
                        fileInputStream2.close();
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    public final void e(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2) == null) {
            int[] iArr = {96000, 88200, 64000, MediaEncodeParams.AUDIO_SAMPLE_RATE, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
            int i3 = 0;
            while (true) {
                if (i3 >= 13) {
                    i3 = 4;
                    break;
                } else if (iArr[i3] == this.f29081b) {
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
    public final MediaCodec f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", "audio/mp4a-latm");
            mediaFormat.setInteger("bitrate", EncoderParams.AUDIO_BIT_RATE);
            mediaFormat.setInteger("channel-count", this.f29082c);
            mediaFormat.setInteger("sample-rate", this.f29081b);
            mediaFormat.setInteger("aac-profile", 2);
            createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return createEncoderByType;
        }
        return (MediaCodec) invokeV.objValue;
    }
}
