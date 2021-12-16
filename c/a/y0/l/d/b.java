package c.a.y0.l.d;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import c.a.y0.l.d.c;
import c.a.y0.l.d.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str) {
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
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x015c A[Catch: all -> 0x0282, TryCatch #0 {all -> 0x0282, blocks: (B:27:0x00e3, B:29:0x00e9, B:31:0x00f2, B:47:0x0156, B:49:0x015c, B:51:0x0162, B:52:0x016f, B:55:0x0175, B:57:0x0178, B:59:0x0192, B:61:0x0198, B:63:0x01a6, B:65:0x01ac, B:69:0x01b9, B:76:0x01c9, B:78:0x01d0, B:79:0x01d9, B:81:0x01f7, B:83:0x0201, B:86:0x020f, B:89:0x021c, B:33:0x010d, B:35:0x0115, B:39:0x0126, B:44:0x0143, B:42:0x0131, B:93:0x0240, B:95:0x0246, B:96:0x024e), top: B:108:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0209  */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.b a(String str, boolean z, f.C1576f c1576f, f.C1576f c1576f2, long j2, long j3, long j4) throws Exception {
        InterceptResult invokeCommon;
        MediaFormat mediaFormat;
        ByteBuffer[] byteBufferArr;
        long j5;
        int dequeueOutputBuffer;
        ByteBuffer[] byteBufferArr2;
        byte[] bArr;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), c1576f, c1576f2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            f.C1576f c1576f3 = c1576f2;
            long j6 = j3;
            if (TextUtils.isEmpty(str) || c1576f == null || c1576f3 == null) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = this.a;
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str2);
            int i2 = 0;
            while (true) {
                if (i2 >= mediaExtractor.getTrackCount()) {
                    mediaFormat = null;
                    break;
                }
                mediaFormat = mediaExtractor.getTrackFormat(i2);
                if (mediaFormat.getString("mime").startsWith("audio/")) {
                    mediaExtractor.selectTrack(i2);
                    break;
                }
                i2++;
            }
            c.a.y0.t.c.c("AndroidAudioDecoder", "startTime:" + j2 + ",endTime:" + j6);
            if (j2 > 0) {
                mediaExtractor.seekTo(j2 * 1000, 0);
            }
            if (mediaFormat == null) {
                c.a.y0.t.c.b("not a valid file with audio track..");
                mediaExtractor.release();
                return null;
            }
            c.a.y0.t.c.b("mediaFormat " + mediaFormat);
            c.b bVar = new c.b();
            int i3 = c1576f3.f27420b;
            int i4 = c1576f3.a;
            int i5 = c1576f3.f27421c;
            bVar.a = str;
            FileOutputStream fileOutputStream = new FileOutputStream(bVar.a);
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
            createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.start();
            ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
            ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
            double d2 = mediaFormat.getLong("durationUs");
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            boolean z2 = false;
            boolean z3 = false;
            ByteBuffer[] byteBufferArr3 = outputBuffers;
            while (!z2) {
                long j7 = currentTimeMillis;
                if (!z3) {
                    try {
                        int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(5000L);
                        if (dequeueInputBuffer >= 0) {
                            int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                            if (readSampleData < 0) {
                                c.a.y0.t.c.b("saw input EOS.");
                                createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                byteBufferArr = inputBuffers;
                                j5 = 5000;
                            } else {
                                long sampleTime = mediaExtractor.getSampleTime();
                                if (j4 != 0) {
                                    byteBufferArr = inputBuffers;
                                    mediaExtractor.seekTo(sampleTime + j4, 0);
                                } else {
                                    byteBufferArr = inputBuffers;
                                }
                                if (j6 != -1 && sampleTime + j4 >= j6 * 1000) {
                                    createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                    j5 = 5000;
                                }
                                createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                                mediaExtractor.advance();
                                j5 = 5000;
                                dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, j5);
                                if (dequeueOutputBuffer < 0) {
                                    byteBufferArr2 = byteBufferArr3;
                                    if (dequeueOutputBuffer == -3) {
                                        byteBufferArr3 = createDecoderByType.getOutputBuffers();
                                        c.a.y0.t.c.b("output buffers have changed.");
                                        c1576f3 = c1576f2;
                                        inputBuffers = byteBufferArr;
                                        j6 = j3;
                                        currentTimeMillis = j7;
                                    } else if (dequeueOutputBuffer == -2) {
                                        c.a.y0.t.c.b("output format has changed to " + createDecoderByType.getOutputFormat());
                                    }
                                } else if ((bufferInfo.flags & 2) != 0) {
                                    c.a.y0.t.c.b("audio encoder: codec config buffer");
                                    createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    inputBuffers = byteBufferArr;
                                    currentTimeMillis = j7;
                                } else {
                                    if (bufferInfo.size == 0 || dequeueOutputBuffer < 0 || byteBufferArr3.length <= dequeueOutputBuffer) {
                                        byteBufferArr2 = byteBufferArr3;
                                    } else {
                                        ByteBuffer byteBuffer = byteBufferArr3[dequeueOutputBuffer];
                                        byteBuffer.position(bufferInfo.offset);
                                        byteBufferArr2 = byteBufferArr3;
                                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                        byte[] bArr3 = new byte[bufferInfo.size];
                                        byteBuffer.get(bArr3);
                                        if (z) {
                                            bArr = null;
                                            bArr2 = null;
                                        } else {
                                            bArr2 = c1576f2.a() ? f.c(c1576f3.f27421c / 8, c1576f.f27421c / 8, bArr3) : null;
                                            if (c1576f2.b()) {
                                                bArr = f.d(c1576f3.f27420b, c1576f.f27420b, c1576f.f27421c / 8, bArr2 == null ? bArr3 : bArr2);
                                            } else {
                                                bArr = null;
                                            }
                                        }
                                        if (bArr == null) {
                                            bArr = bArr2 == null ? bArr3 : bArr2;
                                        }
                                        fileOutputStream.write(bArr);
                                        if (this.f27402b != null) {
                                            this.f27402b.a(bArr3, bufferInfo.presentationTimeUs / d2);
                                        }
                                        c.a.y0.t.c.b(this.a + " presentationTimeUs : " + bufferInfo.presentationTimeUs);
                                    }
                                    createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    if ((bufferInfo.flags & 4) != 0) {
                                        c.a.y0.t.c.b("saw output EOS.");
                                        z2 = true;
                                    }
                                }
                                byteBufferArr3 = byteBufferArr2;
                                c1576f3 = c1576f2;
                                inputBuffers = byteBufferArr;
                                j6 = j3;
                                currentTimeMillis = j7;
                            }
                            z3 = true;
                            dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, j5);
                            if (dequeueOutputBuffer < 0) {
                            }
                            byteBufferArr3 = byteBufferArr2;
                            c1576f3 = c1576f2;
                            inputBuffers = byteBufferArr;
                            j6 = j3;
                            currentTimeMillis = j7;
                        }
                    } finally {
                        fileOutputStream.close();
                        createDecoderByType.stop();
                        createDecoderByType.release();
                        mediaExtractor.release();
                    }
                }
                byteBufferArr = inputBuffers;
                j5 = 5000;
                dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, j5);
                if (dequeueOutputBuffer < 0) {
                }
                byteBufferArr3 = byteBufferArr2;
                c1576f3 = c1576f2;
                inputBuffers = byteBufferArr;
                j6 = j3;
                currentTimeMillis = j7;
            }
            long j8 = currentTimeMillis;
            if (this.f27402b != null) {
                this.f27402b.a(null, 1.0d);
            }
            c.a.y0.t.c.b("decode " + str + " cost " + (System.currentTimeMillis() - j8) + " milliseconds !");
            return bVar;
        }
        return (c.b) invokeCommon.objValue;
    }
}
