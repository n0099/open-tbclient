package b.a.x0.l.d;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import b.a.x0.l.d.f;
import b.a.x0.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.muxer.MultiAudioMixer;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.material.badge.BadgeDrawable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f30605a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements MultiAudioMixer.OnAudioMixListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FileOutputStream f30606a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f30607b;

        public a(String str) throws FileNotFoundException {
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
            this.f30607b = str;
            this.f30606a = new FileOutputStream(this.f30607b);
        }

        @Override // com.baidu.ugc.editvideo.editvideo.muxer.MultiAudioMixer.OnAudioMixListener
        public void onMixComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f30606a != null) {
                        this.f30606a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.ugc.editvideo.editvideo.muxer.MultiAudioMixer.OnAudioMixListener
        public void onMixError(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                try {
                    if (this.f30606a != null) {
                        this.f30606a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.ugc.editvideo.editvideo.muxer.MultiAudioMixer.OnAudioMixListener
        public void onMixing(byte[] bArr) throws IOException {
            FileOutputStream fileOutputStream;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) || (fileOutputStream = this.f30606a) == null) {
                return;
            }
            fileOutputStream.write(bArr);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements a.InterfaceC1481a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1481a f30608a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f30609b;

        public b(a.InterfaceC1481a interfaceC1481a, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1481a, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30608a = interfaceC1481a;
            this.f30609b = sb;
        }

        @Override // b.a.x0.s.a.InterfaceC1481a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (g.f30605a) {
                    g.f30605a.notifyAll();
                }
            }
        }

        @Override // b.a.x0.s.a.InterfaceC1481a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",ffmpegerror:");
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i3);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                StringBuilder sb3 = this.f30609b;
                if (sb3 != null) {
                    sb3.append(sb2);
                }
                synchronized (g.f30605a) {
                    g.f30605a.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // b.a.x0.s.a.InterfaceC1481a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                a.InterfaceC1481a interfaceC1481a = this.f30608a;
                if (interfaceC1481a != null) {
                    interfaceC1481a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1969384978, "Lb/a/x0/l/d/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1969384978, "Lb/a/x0/l/d/g;");
                return;
            }
        }
        f30605a = new Object();
    }

    public static void b(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, bArr, i2, i3) == null) {
            int[] iArr = {96000, 88200, 64000, MediaEncodeParams.AUDIO_SAMPLE_RATE, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
            int i4 = 0;
            while (true) {
                if (i4 >= 13) {
                    i4 = 4;
                    break;
                } else if (iArr[i4] == i3) {
                    break;
                } else {
                    i4++;
                }
            }
            bArr[0] = -1;
            bArr[1] = -7;
            bArr[2] = (byte) (64 + (i4 << 2) + 0);
            bArr[3] = (byte) (128 + (i2 >> 11));
            bArr[4] = (byte) ((i2 & 2047) >> 3);
            bArr[5] = (byte) (((i2 & 7) << 5) + 31);
            bArr[6] = -4;
        }
    }

    public static MediaCodec c(MediaFormat mediaFormat) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, mediaFormat)) == null) {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
            createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.start();
            return createDecoderByType;
        }
        return (MediaCodec) invokeL.objValue;
    }

    public static MediaCodec d(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaCodecInfo, mediaFormat)) == null) {
            MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
            createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            createByCodecName.start();
            return createByCodecName;
        }
        return (MediaCodec) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x042c A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x030a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2, FileOutputStream fileOutputStream, int i2, long j, float f2, f.C1470f c1470f, f.C1470f c1470f2) {
        int i3;
        MediaCodec.BufferInfo bufferInfo;
        MediaCodec.BufferInfo bufferInfo2;
        String str;
        boolean z;
        char c2;
        int i4;
        ByteBuffer[] byteBufferArr;
        MediaCodec mediaCodec3;
        boolean z2;
        MediaCodec.BufferInfo bufferInfo3;
        boolean z3;
        int dequeueInputBuffer;
        boolean z4;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{mediaExtractor, mediaCodec, mediaCodec2, fileOutputStream, Integer.valueOf(i2), Long.valueOf(j), Float.valueOf(f2), c1470f, c1470f2}) == null) {
            MediaCodec mediaCodec4 = mediaCodec;
            long j3 = j;
            String str2 = "MultimediaMixer";
            g("MultimediaMixer", "rate:" + i2 + "," + j3);
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            ByteBuffer[] inputBuffers2 = mediaCodec2.getInputBuffers();
            ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo4 = new MediaCodec.BufferInfo();
            MediaCodec.BufferInfo bufferInfo5 = new MediaCodec.BufferInfo();
            ByteBuffer[] byteBufferArr2 = outputBuffers2;
            long j4 = -1;
            boolean z5 = false;
            int i5 = -1;
            boolean z6 = false;
            boolean z7 = false;
            while (!z6 && f()) {
                if (!z5 && f()) {
                    int dequeueInputBuffer2 = mediaCodec4.dequeueInputBuffer(5000L);
                    if (dequeueInputBuffer2 == -1) {
                        g(str2, "no audio decoder input buffer");
                    } else {
                        g(str2, "audio decoder: returned input buffer: " + dequeueInputBuffer2);
                        int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer2], 0);
                        long sampleTime = mediaExtractor.getSampleTime();
                        int i6 = i5;
                        StringBuilder sb = new StringBuilder();
                        MediaCodec.BufferInfo bufferInfo6 = bufferInfo4;
                        sb.append("audio extractor: returned buffer of size ");
                        sb.append(readSampleData);
                        g(str2, sb.toString());
                        g(str2, "audio extractor: returned buffer for time " + sampleTime);
                        if (j3 == -1 || sampleTime < 1000 * j3) {
                            if (readSampleData >= 0) {
                                i3 = i6;
                                bufferInfo = bufferInfo6;
                                bufferInfo2 = bufferInfo5;
                                str = str2;
                                mediaCodec.queueInputBuffer(dequeueInputBuffer2, 0, readSampleData, sampleTime, mediaExtractor.getSampleFlags());
                            } else {
                                bufferInfo2 = bufferInfo5;
                                str = str2;
                                i3 = i6;
                                bufferInfo = bufferInfo6;
                            }
                            z = !mediaExtractor.advance();
                        } else {
                            bufferInfo2 = bufferInfo5;
                            str = str2;
                            i3 = i6;
                            bufferInfo = bufferInfo6;
                            z = true;
                        }
                        if (z) {
                            g(str, "audio extractor: EOS");
                            mediaCodec.queueInputBuffer(dequeueInputBuffer2, 0, 0, 0L, 4);
                        }
                        if (z7) {
                            i4 = -1;
                            if (i3 == -1 && f()) {
                                int dequeueOutputBuffer = mediaCodec4.dequeueOutputBuffer(bufferInfo, 5000L);
                                if (dequeueOutputBuffer == -1) {
                                    g(str, "no audio decoder output buffer");
                                } else {
                                    if (dequeueOutputBuffer == -3) {
                                        g(str, "audio decoder: output buffers changed");
                                        byteBufferArr = mediaCodec.getOutputBuffers();
                                        c2 = 0;
                                    } else if (dequeueOutputBuffer == -2) {
                                        g(str, "audio decoder: output format changed: " + mediaCodec.getOutputFormat());
                                    } else {
                                        g(str, "audio decoder: returned output buffer: " + dequeueOutputBuffer);
                                        g(str, "audio decoder: returned buffer of size " + bufferInfo.size);
                                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                                        if ((bufferInfo.flags & 2) != 0) {
                                            g(str, "audio decoder: codec config buffer");
                                            c2 = 0;
                                            mediaCodec4.releaseOutputBuffer(dequeueOutputBuffer, false);
                                        } else {
                                            c2 = 0;
                                            g(str, "audio decoder: returned buffer for time " + bufferInfo.presentationTimeUs);
                                            g(str, "audio decoder: output buffer is now pending: " + i3);
                                            byteBufferArr = outputBuffers;
                                            i3 = dequeueOutputBuffer;
                                        }
                                    }
                                    if (i3 != i4 && f()) {
                                        g(str, "audio decoder: attempting to process pending buffer: " + i3);
                                        dequeueInputBuffer = mediaCodec2.dequeueInputBuffer(5000L);
                                        if (dequeueInputBuffer != i4) {
                                            g(str, "no audio encoder input buffer");
                                        } else {
                                            g(str, "audio encoder: returned input buffer: " + dequeueInputBuffer);
                                            ByteBuffer byteBuffer2 = inputBuffers2[dequeueInputBuffer];
                                            int i7 = bufferInfo.size;
                                            long j5 = bufferInfo.presentationTimeUs;
                                            g(str, "audio decoder: processing pending buffer: " + i3);
                                            g(str, "audio decoder: pending buffer of size " + i7);
                                            g(str, "audio decoder: pending buffer for time " + j5);
                                            if (i7 >= 0) {
                                                ByteBuffer duplicate = byteBufferArr[i3].duplicate();
                                                duplicate.position(bufferInfo.offset);
                                                duplicate.limit(bufferInfo.offset + i7);
                                                if (c1470f == null || c1470f2 == null) {
                                                    z4 = true;
                                                } else {
                                                    f.C1470f[] c1470fArr = new f.C1470f[2];
                                                    c1470fArr[c2] = c1470f;
                                                    c1470fArr[1] = c1470f2;
                                                    z4 = f.i(c1470fArr);
                                                }
                                                int i8 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
                                                if ((i8 != 0 || !z4) && i7 > 0) {
                                                    byte[] bArr = new byte[i7];
                                                    j2 = j5;
                                                    duplicate.get(bArr, bufferInfo.offset, i7);
                                                    if (i8 != 0) {
                                                        bArr = k(bArr, f2);
                                                    }
                                                    if (!z4) {
                                                        if (c1470f2.a()) {
                                                            bArr = f.c(c1470f2.f30602c / 8, c1470f.f30602c / 8, bArr);
                                                        }
                                                        if (c1470f2.b()) {
                                                            bArr = f.d(c1470f2.f30601b, c1470f.f30601b, 2, bArr);
                                                            byteBuffer2.position(0);
                                                            byteBuffer2.put(bArr);
                                                        }
                                                    }
                                                    byteBuffer2.position(0);
                                                    byteBuffer2.put(bArr);
                                                } else {
                                                    j2 = j5;
                                                    byteBuffer2.position(0);
                                                    byteBuffer2.put(duplicate);
                                                }
                                                z2 = false;
                                                mediaCodec2.queueInputBuffer(dequeueInputBuffer, 0, i7, j2, bufferInfo.flags);
                                            } else {
                                                z2 = false;
                                            }
                                            mediaCodec3 = mediaCodec;
                                            mediaCodec3.releaseOutputBuffer(i3, z2);
                                            if ((bufferInfo.flags & 4) != 0) {
                                                g(str, "audio decoder: EOS");
                                                i5 = -1;
                                                z7 = true;
                                            } else {
                                                i5 = -1;
                                            }
                                            if (z6 && f()) {
                                                bufferInfo3 = bufferInfo2;
                                                int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo3, 5000L);
                                                if (dequeueOutputBuffer2 == -1) {
                                                    g(str, "no audio encoder output buffer");
                                                } else if (dequeueOutputBuffer2 == -3) {
                                                    g(str, "audio encoder: output buffers changed");
                                                    g(str, "audio encoder: output format changed: " + mediaCodec2.getOutputFormat());
                                                    byteBufferArr2 = mediaCodec2.getOutputBuffers();
                                                    bufferInfo5 = bufferInfo3;
                                                    outputBuffers = byteBufferArr;
                                                    bufferInfo4 = bufferInfo;
                                                    str2 = str;
                                                    j3 = j;
                                                    mediaCodec4 = mediaCodec3;
                                                    z5 = z;
                                                } else if (dequeueOutputBuffer2 == -2) {
                                                    g(str, "audio encoder: output format changed");
                                                    mediaCodec2.getOutputFormat();
                                                } else {
                                                    g(str, "audio encoder: returned output buffer: " + dequeueOutputBuffer2);
                                                    g(str, "audio encoder: returned buffer of size " + bufferInfo3.size);
                                                    ByteBuffer byteBuffer3 = byteBufferArr2[dequeueOutputBuffer2];
                                                    if ((bufferInfo3.flags & 2) != 0) {
                                                        g(str, "audio encoder: codec config buffer");
                                                        mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, z2);
                                                    } else {
                                                        g(str, "audio encoder: returned buffer for time " + bufferInfo3.presentationTimeUs);
                                                        if (bufferInfo3.size != 0 && bufferInfo3.presentationTimeUs > j4) {
                                                            g(str, "audio encoder: writedata " + bufferInfo3.presentationTimeUs);
                                                            long j6 = bufferInfo3.presentationTimeUs;
                                                            int i9 = bufferInfo3.size;
                                                            int i10 = i9 + 7;
                                                            byteBuffer3.position(bufferInfo3.offset);
                                                            byteBuffer3.limit(bufferInfo3.offset + i9);
                                                            byte[] bArr2 = new byte[i10];
                                                            b(bArr2, i10, i2);
                                                            byteBuffer3.get(bArr2, 7, i9);
                                                            byteBuffer3.clear();
                                                            try {
                                                                fileOutputStream.write(bArr2, 0, i10);
                                                            } catch (IOException e2) {
                                                                e2.printStackTrace();
                                                            }
                                                            j4 = j6;
                                                        }
                                                        if ((bufferInfo3.flags & 4) != 0) {
                                                            g(str, "audio encoder: EOS");
                                                            z3 = false;
                                                            z6 = true;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                        mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, z3);
                                                        g(str, "audioEncoder.releaseOutputBuffer" + dequeueOutputBuffer2);
                                                        bufferInfo5 = bufferInfo3;
                                                        outputBuffers = byteBufferArr;
                                                        bufferInfo4 = bufferInfo;
                                                        str2 = str;
                                                        z5 = z;
                                                        mediaCodec4 = mediaCodec;
                                                        j3 = j;
                                                    }
                                                }
                                            } else {
                                                bufferInfo3 = bufferInfo2;
                                            }
                                            bufferInfo5 = bufferInfo3;
                                            outputBuffers = byteBufferArr;
                                            bufferInfo4 = bufferInfo;
                                            str2 = str;
                                            z5 = z;
                                            mediaCodec4 = mediaCodec;
                                            j3 = j;
                                        }
                                    }
                                    mediaCodec3 = mediaCodec;
                                    z2 = false;
                                    i5 = i3;
                                    if (z6) {
                                    }
                                    bufferInfo3 = bufferInfo2;
                                    bufferInfo5 = bufferInfo3;
                                    outputBuffers = byteBufferArr;
                                    bufferInfo4 = bufferInfo;
                                    str2 = str;
                                    z5 = z;
                                    mediaCodec4 = mediaCodec;
                                    j3 = j;
                                }
                            }
                            c2 = 0;
                        } else {
                            c2 = 0;
                            i4 = -1;
                        }
                        byteBufferArr = outputBuffers;
                        if (i3 != i4) {
                            g(str, "audio decoder: attempting to process pending buffer: " + i3);
                            dequeueInputBuffer = mediaCodec2.dequeueInputBuffer(5000L);
                            if (dequeueInputBuffer != i4) {
                            }
                        }
                        mediaCodec3 = mediaCodec;
                        z2 = false;
                        i5 = i3;
                        if (z6) {
                        }
                        bufferInfo3 = bufferInfo2;
                        bufferInfo5 = bufferInfo3;
                        outputBuffers = byteBufferArr;
                        bufferInfo4 = bufferInfo;
                        str2 = str;
                        z5 = z;
                        mediaCodec4 = mediaCodec;
                        j3 = j;
                    }
                }
                i3 = i5;
                bufferInfo = bufferInfo4;
                bufferInfo2 = bufferInfo5;
                str = str2;
                z = z5;
                if (z7) {
                }
                byteBufferArr = outputBuffers;
                if (i3 != i4) {
                }
                mediaCodec3 = mediaCodec;
                z2 = false;
                i5 = i3;
                if (z6) {
                }
                bufferInfo3 = bufferInfo2;
                bufferInfo5 = bufferInfo3;
                outputBuffers = byteBufferArr;
                bufferInfo4 = bufferInfo;
                str2 = str;
                z5 = z;
                mediaCodec4 = mediaCodec;
                j3 = j;
            }
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? !Thread.currentThread().isInterrupted() : invokeV.booleanValue;
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            b.a.x0.t.c.c(str, str2);
        }
    }

    public static boolean h(String str, String[] strArr, StringBuilder sb, a.InterfaceC1481a interfaceC1481a) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, str, strArr, sb, interfaceC1481a)) == null) {
            try {
                f.C1470f e2 = f.e(strArr[0]);
                if (e2 == null) {
                    return false;
                }
                f.j(strArr[0], strArr[1], str, e2.f30601b, new b(interfaceC1481a, sb));
                try {
                    synchronized (f30605a) {
                        f30605a.wait();
                    }
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                if (FileUtils.checkFile(str)) {
                    return true;
                }
                if (sb != null) {
                    sb.append(", mixingAudiobyFfmpeg error");
                }
                return false;
            } catch (Exception e4) {
                if (sb != null) {
                    sb.append(", mixingAudio error :" + e4.getMessage());
                }
                b.a.x0.t.c.g(e4);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean i(String str, float[] fArr, long[] jArr, long[] jArr2, String[] strArr, StringBuilder sb) {
        InterceptResult invokeCommon;
        f.C1470f c1470f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, fArr, jArr, jArr2, strArr, sb})) == null) {
            long[] jArr3 = jArr;
            long[] jArr4 = jArr2;
            if (fArr.length == 2 && jArr3.length == 2 && jArr4.length == 2 && strArr.length == 2) {
                String str2 = new File(strArr[0]).getParent() + "/";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                String str3 = "temp_";
                sb2.append("temp_");
                sb2.append(System.currentTimeMillis());
                String sb3 = sb2.toString();
                long currentTimeMillis = System.currentTimeMillis();
                File[] fileArr = new File[strArr.length];
                try {
                    f.C1470f e2 = f.e(strArr[0]);
                    if (e2 == null) {
                        return false;
                    }
                    f.C1470f c1470f2 = new f.C1470f();
                    int i2 = 0;
                    boolean z = true;
                    while (i2 < strArr.length) {
                        if (i2 != 0) {
                            c1470f = f.e(strArr[i2]);
                            if (c1470f == null) {
                                return false;
                            }
                            z = f.i(e2, c1470f);
                        } else {
                            c1470f = c1470f2;
                        }
                        boolean z2 = z;
                        long j = currentTimeMillis;
                        b.a.x0.l.d.b bVar = new b.a.x0.l.d.b(strArr[i2]);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str2);
                        sb4.append(str3);
                        sb4.append(i2);
                        sb4.append("_");
                        String str4 = sb3;
                        String str5 = str3;
                        sb4.append(System.currentTimeMillis());
                        String sb5 = sb4.toString();
                        if (bVar.a(sb5, z2, e2, c1470f, jArr3[i2], jArr4[i2], 0L) != null) {
                            if (!z2 && i2 != 0 && c1470f.c()) {
                                String str6 = str2 + "resample_" + System.currentTimeMillis();
                                long currentTimeMillis2 = System.currentTimeMillis();
                                boolean n = f.n(sb5, str6, c1470f.f30600a, e2.f30600a);
                                b.a.x0.t.c.d("result : " + n + " resample cost = " + (System.currentTimeMillis() - currentTimeMillis2));
                                if (n) {
                                    sb5 = str6;
                                }
                            }
                            fileArr[i2] = new File(sb5);
                        }
                        i2++;
                        jArr3 = jArr;
                        jArr4 = jArr2;
                        z = z2;
                        c1470f2 = c1470f;
                        str3 = str5;
                        currentTimeMillis = j;
                        sb3 = str4;
                    }
                    String str7 = sb3;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    MultiAudioMixer createAudioMixer = MultiAudioMixer.createAudioMixer();
                    createAudioMixer.setOnAudioMixListener(new a(str7));
                    createAudioMixer.mixAudios(fileArr, new float[]{fArr[0], fArr[1]});
                    b.a.x0.t.c.c("MultimediaMixer", "mixsourcecosttime:" + (System.currentTimeMillis() - currentTimeMillis3));
                    long currentTimeMillis4 = System.currentTimeMillis();
                    b.a.x0.l.d.a aVar = new b.a.x0.l.d.a(str7);
                    aVar.e(e2.f30600a);
                    aVar.d(e2.f30601b);
                    aVar.c(str);
                    b.a.x0.t.c.c("MultimediaMixer", "aacEncodercostTime:" + (System.currentTimeMillis() - currentTimeMillis4));
                    b.a.x0.t.c.c("MultimediaMixer", "auidomixcosttime:" + (System.currentTimeMillis() - currentTimeMillis));
                    return true;
                } catch (Exception e3) {
                    if (sb != null) {
                        sb.append(", mixingAudio error :" + e3.getMessage());
                    }
                    b.a.x0.t.c.g(e3);
                    return false;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean j(String str, String str2, long j, long j2, StringBuilder sb, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), sb, Float.valueOf(f2)})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            g("MultimediaMixer", "path:" + str + "," + str2 + "," + j + "," + j2);
            return o(str, str2, j, j2, sb, f2);
        }
        return invokeCommon.booleanValue;
    }

    public static byte[] k(byte[] bArr, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{bArr, Double.valueOf(d2)})) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            int length = bArr.length / 2;
            short[] sArr = new short[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                double d3 = (short) (((bArr[i3 + 1] & 255) << 8) | (bArr[i3] & 255));
                double d4 = d3 * d2;
                if (d4 <= 32767.0d && d4 >= -32768.0d) {
                    d3 = d4;
                }
                sArr[i2] = (short) d3;
            }
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = i4 * 2;
                bArr[i5] = (byte) (sArr[i4] & 255);
                bArr[i5 + 1] = (byte) ((sArr[i4] & 65280) >> 8);
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static boolean l(String str, String str2, long j, long j2, StringBuilder sb) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), sb})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean j3 = j(str2, str, j, j2, sb, 1.0f);
            b.a.x0.t.c.c("clipMusic", "mp3ToAAC-costtime:" + (System.currentTimeMillis() - currentTimeMillis));
            return j3;
        }
        return invokeCommon.booleanValue;
    }

    public static MediaCodecInfo m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    public static void n(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65550, null, mediaFormat, mediaFormat2, str, i2) == null) {
            if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
                i2 = mediaFormat.getInteger(str);
            }
            if (mediaFormat2 != null) {
                mediaFormat2.setInteger(str, i2);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x0150 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x019e A[Catch: all -> 0x01e9, TRY_LEAVE, TryCatch #1 {all -> 0x01e9, blocks: (B:96:0x0199, B:98:0x019e), top: B:133:0x0199 }] */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v18 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o(String str, String str2, long j, long j2, StringBuilder sb, float f2) {
        InterceptResult invokeCommon;
        Throwable th;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        MediaExtractor mediaExtractor;
        FileOutputStream fileOutputStream3;
        FileOutputStream fileOutputStream4;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), sb, Float.valueOf(f2)})) != null) {
            return invokeCommon.booleanValue;
        }
        if (TextUtils.isEmpty(str2)) {
            if (sb != null) {
                sb.append("transCodeFormat-inputPath-null");
            }
            return false;
        }
        MediaExtractor mediaExtractor2 = null;
        try {
            f.C1470f e2 = f.e(str2);
            if (e2 == null) {
                if (sb != null) {
                    sb.append("transCodeFormat-audioFormatData-null");
                }
                return false;
            }
            MediaExtractor mediaExtractor3 = new MediaExtractor();
            try {
                mediaExtractor3.setDataSource(str2);
                int i2 = 0;
                while (true) {
                    if (i2 >= mediaExtractor3.getTrackCount()) {
                        mediaFormat = null;
                        break;
                    }
                    try {
                        mediaFormat = mediaExtractor3.getTrackFormat(i2);
                        if (mediaFormat.getString("mime").startsWith("audio/")) {
                            mediaExtractor3.selectTrack(i2);
                            break;
                        }
                        i2++;
                    } catch (Exception e3) {
                        e = e3;
                        mediaCodec = null;
                        mediaCodec2 = null;
                        fileOutputStream2 = null;
                        mediaExtractor2 = mediaExtractor3;
                        try {
                            e.printStackTrace();
                            if (sb != null) {
                            }
                            if (mediaExtractor2 != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (mediaCodec2 != null) {
                            }
                            if (fileOutputStream2 != null) {
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (mediaExtractor2 != null) {
                                mediaExtractor2.release();
                            }
                            if (mediaCodec != null) {
                                mediaCodec.stop();
                            }
                            if (mediaCodec2 != null) {
                                mediaCodec2.stop();
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    if (sb != null) {
                                        sb.append("transCodeFormat-fosAccAudioClose-" + e4.getMessage());
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        mediaCodec = null;
                        mediaCodec2 = null;
                        fileOutputStream = null;
                        mediaExtractor2 = mediaExtractor3;
                        if (mediaExtractor2 != null) {
                        }
                        if (mediaCodec != null) {
                        }
                        if (mediaCodec2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                }
                b.a.x0.t.c.c("AndroidAudioDecoder", "startTime:" + j + ",endTime:" + j2);
                if (j > 0) {
                    mediaExtractor3.seekTo(j * 1000, 0);
                }
                if (mediaFormat == null) {
                    b.a.x0.t.c.b("not a valid file with audio track..");
                    if (sb != null) {
                        sb.append("transCodeFormat-not a valid file with audio track");
                    }
                    mediaExtractor3.release();
                    mediaExtractor3.release();
                    return false;
                }
                b.a.x0.t.c.b("mediaFormat " + mediaFormat);
                MediaCodecInfo m = m("audio/mp4a-latm");
                if (m == null) {
                    if (sb != null) {
                        sb.append("transCodeFormat-audioCodecInfo-null");
                    }
                    mediaExtractor3.release();
                    return false;
                }
                MediaFormat mediaFormat2 = new MediaFormat();
                mediaFormat2.setString("mime", "audio/mp4a-latm");
                mediaFormat2.setInteger("aac-profile", 2);
                mediaFormat2.setInteger("max-input-size", 8192);
                n(mediaFormat, mediaFormat2, "sample-rate", MediaEncodeParams.AUDIO_SAMPLE_RATE);
                n(mediaFormat, mediaFormat2, "channel-count", 1);
                n(mediaFormat, mediaFormat2, "bitrate", EncoderParams.AUDIO_BIT_RATE);
                mediaCodec = d(m, mediaFormat2);
                try {
                    mediaCodec2 = c(mediaFormat);
                    try {
                        FileOutputStream fileOutputStream5 = new FileOutputStream(str);
                        try {
                            fileOutputStream4 = fileOutputStream5;
                            mediaExtractor = mediaExtractor3;
                            try {
                                e(mediaExtractor3, mediaCodec2, mediaCodec, fileOutputStream5, e2.f30600a, j2, f2, null, null);
                                mediaExtractor.release();
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                }
                                if (mediaCodec2 != null) {
                                    mediaCodec2.stop();
                                }
                                try {
                                    fileOutputStream4.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    if (sb != null) {
                                        sb.append("transCodeFormat-fosAccAudioClose-" + e5.getMessage());
                                    }
                                }
                                return true;
                            } catch (Exception e6) {
                                e = e6;
                                mediaExtractor2 = mediaExtractor;
                                fileOutputStream2 = fileOutputStream4;
                                e.printStackTrace();
                                if (sb != null) {
                                    sb.append("transCodeFormat-decodeAndencode-" + e.getMessage());
                                }
                                if (mediaExtractor2 != null) {
                                    mediaExtractor2.release();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                }
                                if (mediaCodec2 != null) {
                                    mediaCodec2.stop();
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                        if (sb != null) {
                                            sb.append("transCodeFormat-fosAccAudioClose-" + e7.getMessage());
                                        }
                                    }
                                }
                                return false;
                            } catch (Throwable th4) {
                                th = th4;
                                th = th;
                                fileOutputStream3 = fileOutputStream4;
                                mediaExtractor2 = mediaExtractor;
                                fileOutputStream = fileOutputStream3;
                                if (mediaExtractor2 != null) {
                                }
                                if (mediaCodec != null) {
                                }
                                if (mediaCodec2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            fileOutputStream4 = fileOutputStream5;
                            mediaExtractor = mediaExtractor3;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream4 = fileOutputStream5;
                            mediaExtractor = mediaExtractor3;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        mediaExtractor = mediaExtractor3;
                        fileOutputStream4 = 0;
                    } catch (Throwable th6) {
                        mediaExtractor = mediaExtractor3;
                        th = th6;
                        fileOutputStream3 = null;
                    }
                } catch (Exception e10) {
                    e = e10;
                    mediaExtractor = mediaExtractor3;
                    mediaCodec2 = null;
                    fileOutputStream4 = mediaCodec2;
                    mediaExtractor2 = mediaExtractor;
                    fileOutputStream2 = fileOutputStream4;
                    e.printStackTrace();
                    if (sb != null) {
                    }
                    if (mediaExtractor2 != null) {
                    }
                    if (mediaCodec != null) {
                    }
                    if (mediaCodec2 != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    return false;
                } catch (Throwable th7) {
                    mediaExtractor = mediaExtractor3;
                    th = th7;
                    mediaCodec2 = null;
                    fileOutputStream3 = mediaCodec2;
                    mediaExtractor2 = mediaExtractor;
                    fileOutputStream = fileOutputStream3;
                    if (mediaExtractor2 != null) {
                    }
                    if (mediaCodec != null) {
                    }
                    if (mediaCodec2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                mediaExtractor = mediaExtractor3;
                mediaCodec = null;
                mediaCodec2 = null;
            } catch (Throwable th8) {
                mediaExtractor = mediaExtractor3;
                th = th8;
                mediaCodec = null;
                mediaCodec2 = null;
            }
        } catch (Exception e12) {
            e = e12;
            mediaCodec = null;
            mediaCodec2 = null;
            fileOutputStream2 = null;
        } catch (Throwable th9) {
            th = th9;
            mediaCodec = null;
            mediaCodec2 = null;
            fileOutputStream = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x014b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x014d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x0155 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x015c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0194 A[Catch: all -> 0x01df, TRY_LEAVE, TryCatch #17 {all -> 0x01df, blocks: (B:95:0x018f, B:97:0x0194), top: B:138:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ae  */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean p(String str, String str2, long j, long j2, StringBuilder sb, float f2, f.C1470f c1470f, f.C1470f c1470f2) {
        InterceptResult invokeCommon;
        Throwable th;
        FileOutputStream fileOutputStream;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        MediaExtractor mediaExtractor;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), sb, Float.valueOf(f2), c1470f, c1470f2})) != null) {
            return invokeCommon.booleanValue;
        }
        if (TextUtils.isEmpty(str2)) {
            if (sb != null) {
                sb.append("transCodeFormat-inputPath-null");
            }
            return false;
        }
        FileOutputStream fileOutputStream2 = 0;
        try {
            f.C1470f e2 = f.e(str2);
            if (e2 == null) {
                if (sb != null) {
                    sb.append("transCodeFormat-audioFormatData-null");
                }
                return false;
            }
            MediaExtractor mediaExtractor2 = new MediaExtractor();
            try {
                mediaExtractor2.setDataSource(str2);
                int i2 = 0;
                while (true) {
                    if (i2 >= mediaExtractor2.getTrackCount()) {
                        mediaFormat = null;
                        break;
                    }
                    try {
                        mediaFormat = mediaExtractor2.getTrackFormat(i2);
                        if (mediaFormat.getString("mime").startsWith("audio/")) {
                            mediaExtractor2.selectTrack(i2);
                            break;
                        }
                        i2++;
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                        mediaCodec = null;
                        mediaCodec2 = null;
                        fileOutputStream2 = mediaExtractor2;
                        try {
                            e.printStackTrace();
                            if (sb != null) {
                            }
                            if (fileOutputStream2 != null) {
                            }
                            if (mediaCodec2 != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.release();
                            }
                            if (mediaCodec2 != null) {
                                mediaCodec2.stop();
                            }
                            if (mediaCodec != null) {
                                mediaCodec.stop();
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    if (sb != null) {
                                        sb.append("transCodeFormat-fosAccAudioClose-" + e4.getMessage());
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        mediaCodec = null;
                        mediaCodec2 = null;
                        fileOutputStream2 = mediaExtractor2;
                        if (fileOutputStream2 != null) {
                        }
                        if (mediaCodec2 != null) {
                        }
                        if (mediaCodec != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                }
                b.a.x0.t.c.c("AndroidAudioDecoder", "startTime:" + j + ",endTime:" + j2);
                if (j > 0) {
                    mediaExtractor2.seekTo(j * 1000, 0);
                }
                if (mediaFormat == null) {
                    b.a.x0.t.c.b("not a valid file with audio track..");
                    if (sb != null) {
                        sb.append("transCodeFormat-not a valid file with audio track");
                    }
                    mediaExtractor2.release();
                    mediaExtractor2.release();
                    return false;
                }
                b.a.x0.t.c.b("mediaFormat " + mediaFormat);
                MediaCodecInfo m = m("audio/mp4a-latm");
                if (m == null) {
                    if (sb != null) {
                        sb.append("transCodeFormat-audioCodecInfo-null");
                    }
                    mediaExtractor2.release();
                    return false;
                }
                MediaFormat mediaFormat2 = new MediaFormat();
                mediaFormat2.setString("mime", "audio/mp4a-latm");
                mediaFormat2.setInteger("aac-profile", 2);
                mediaFormat2.setInteger("max-input-size", 8192);
                n(mediaFormat, mediaFormat2, "sample-rate", MediaEncodeParams.AUDIO_SAMPLE_RATE);
                n(mediaFormat, mediaFormat2, "channel-count", 1);
                n(mediaFormat, mediaFormat2, "bitrate", EncoderParams.AUDIO_BIT_RATE);
                MediaCodec d2 = d(m, mediaFormat2);
                try {
                    mediaCodec = c(mediaFormat);
                    try {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(str);
                        try {
                            fileOutputStream2 = fileOutputStream3;
                            mediaExtractor = mediaExtractor2;
                            try {
                                e(mediaExtractor2, mediaCodec, d2, fileOutputStream3, e2.f30600a, j2, f2, c1470f, c1470f2);
                                mediaExtractor.release();
                                if (d2 != null) {
                                    d2.stop();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                }
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    if (sb != null) {
                                        sb.append("transCodeFormat-fosAccAudioClose-" + e5.getMessage());
                                    }
                                }
                                return true;
                            } catch (Exception e6) {
                                e = e6;
                                mediaCodec2 = d2;
                                fileOutputStream = fileOutputStream2;
                                fileOutputStream2 = mediaExtractor;
                                e.printStackTrace();
                                if (sb != null) {
                                    sb.append("transCodeFormat-decodeAndencode-" + e.getMessage());
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.release();
                                }
                                if (mediaCodec2 != null) {
                                    mediaCodec2.stop();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                        if (sb != null) {
                                            sb.append("transCodeFormat-fosAccAudioClose-" + e7.getMessage());
                                        }
                                    }
                                }
                                return false;
                            } catch (Throwable th4) {
                                th = th4;
                                th = th;
                                mediaCodec2 = d2;
                                fileOutputStream = fileOutputStream2;
                                fileOutputStream2 = mediaExtractor;
                                if (fileOutputStream2 != null) {
                                }
                                if (mediaCodec2 != null) {
                                }
                                if (mediaCodec != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            fileOutputStream2 = fileOutputStream3;
                            mediaExtractor = mediaExtractor2;
                            mediaCodec2 = d2;
                            fileOutputStream = fileOutputStream2;
                            fileOutputStream2 = mediaExtractor;
                            e.printStackTrace();
                            if (sb != null) {
                            }
                            if (fileOutputStream2 != null) {
                            }
                            if (mediaCodec2 != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            return false;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream2 = fileOutputStream3;
                            mediaExtractor = mediaExtractor2;
                            th = th;
                            mediaCodec2 = d2;
                            fileOutputStream = fileOutputStream2;
                            fileOutputStream2 = mediaExtractor;
                            if (fileOutputStream2 != null) {
                            }
                            if (mediaCodec2 != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e9) {
                        e = e9;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e10) {
                    e = e10;
                    mediaExtractor = mediaExtractor2;
                    mediaCodec2 = d2;
                    fileOutputStream = null;
                    mediaCodec = null;
                } catch (Throwable th7) {
                    mediaExtractor = mediaExtractor2;
                    th = th7;
                    mediaCodec2 = d2;
                    fileOutputStream = null;
                    mediaCodec = null;
                }
            } catch (Exception e11) {
                e = e11;
                mediaExtractor = mediaExtractor2;
                fileOutputStream = null;
                mediaCodec = null;
                mediaCodec2 = null;
            } catch (Throwable th8) {
                mediaExtractor = mediaExtractor2;
                th = th8;
                fileOutputStream = null;
                mediaCodec = null;
                mediaCodec2 = null;
            }
        } catch (Exception e12) {
            e = e12;
            fileOutputStream = null;
            mediaCodec = null;
            mediaCodec2 = null;
        } catch (Throwable th9) {
            th = th9;
            fileOutputStream = null;
            mediaCodec = null;
            mediaCodec2 = null;
        }
    }
}
