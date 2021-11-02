package b.a.r0.z3.i.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.r0.z3.i.d.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.addfilter.InnerVideoProcessor;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes6.dex */
public class f extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f28364e;

    /* renamed from: f  reason: collision with root package name */
    public String f28365f;

    /* renamed from: g  reason: collision with root package name */
    public String f28366g;

    /* renamed from: h  reason: collision with root package name */
    public e f28367h;

    /* renamed from: i  reason: collision with root package name */
    public b.c f28368i;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f28369e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28369e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28369e.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, String str, String str2, e eVar, b.c cVar) {
        super("FilterVideoThread");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, eVar, cVar};
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
        this.f28364e = context;
        this.f28365f = str;
        this.f28366g = str2;
        this.f28367h = eVar;
        this.f28368i = cVar;
    }

    public static String g(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mediaFormat)) == null) ? mediaFormat.getString("mime") : (String) invokeL.objValue;
    }

    public static boolean i(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mediaFormat)) == null) ? g(mediaFormat).startsWith(FileUtils.VIDEO_FILE_START) : invokeL.booleanValue;
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        BdLog.i(str2);
    }

    public static MediaCodecInfo l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
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

    public static void m(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(AdIconUtil.AD_TEXT_ID, null, mediaFormat, mediaFormat2, str, i2) == null) {
            if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
                i2 = mediaFormat.getInteger(str);
            }
            if (mediaFormat2 != null) {
                mediaFormat2.setInteger(str, i2);
            }
        }
    }

    public final MediaExtractor a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(this.f28365f);
            return mediaExtractor;
        }
        return (MediaExtractor) invokeV.objValue;
    }

    public final MediaCodec b(MediaFormat mediaFormat, Surface surface) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaFormat, surface)) == null) {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(g(mediaFormat));
            createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            createDecoderByType.start();
            return createDecoderByType;
        }
        return (MediaCodec) invokeLL.objValue;
    }

    public final MediaCodec c(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mediaCodecInfo, mediaFormat, atomicReference)) == null) {
            MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
            createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            atomicReference.set(createByCodecName.createInputSurface());
            createByCodecName.start();
            return createByCodecName;
        }
        return (MediaCodec) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0106 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0186 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2, g gVar, h hVar) {
        long j;
        int i2;
        ByteBuffer[] byteBufferArr;
        int i3;
        MediaFormat mediaFormat;
        MediaFormat mediaFormat2;
        MediaFormat mediaFormat3;
        boolean z;
        int dequeueOutputBuffer;
        int dequeueInputBuffer;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, mediaExtractor, mediaCodec, mediaCodec2, gVar, hVar) == null) {
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            int i5 = -1;
            int i6 = 0;
            ByteBuffer[] byteBufferArr2 = outputBuffers2;
            MediaFormat mediaFormat4 = null;
            boolean z2 = false;
            int i7 = -1;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            while (!z3 && h()) {
                if (z2 || !((mediaFormat4 == null || this.f28367h.b()) && h() && (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) != i5)) {
                    j = 10000;
                    i2 = i7;
                } else {
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i6);
                    long sampleTime = mediaExtractor.getSampleTime();
                    if (readSampleData >= 0) {
                        i4 = dequeueInputBuffer;
                        j = 10000;
                        i2 = i7;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, mediaExtractor.getSampleFlags());
                    } else {
                        i4 = dequeueInputBuffer;
                        j = 10000;
                        i2 = i7;
                    }
                    boolean z6 = !mediaExtractor.advance();
                    if (z6) {
                        mediaCodec.queueInputBuffer(i4, 0, 0, 0L, 4);
                    }
                    z2 = z6;
                }
                if (!z4 && ((mediaFormat4 == null || this.f28367h.b()) && h() && (dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, j)) != -1)) {
                    if (dequeueOutputBuffer == -3) {
                        outputBuffers = mediaCodec.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        mediaCodec.getOutputFormat();
                    } else {
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if ((bufferInfo.flags & 2) != 0) {
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            boolean z7 = bufferInfo.size != 0;
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z7);
                            if (z7) {
                                hVar.a();
                                hVar.c();
                                gVar.e(bufferInfo.presentationTimeUs * 1000);
                                gVar.f();
                            }
                            if ((bufferInfo.flags & 4) != 0) {
                                mediaCodec2.signalEndOfInputStream();
                                byteBufferArr = outputBuffers;
                                z4 = true;
                                if (z3 && ((mediaFormat4 == null || this.f28367h.b()) && h())) {
                                    int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo2, j);
                                    if (dequeueOutputBuffer2 == -1) {
                                        i3 = i2;
                                    } else {
                                        if (dequeueOutputBuffer2 == -3) {
                                            byteBufferArr2 = mediaCodec2.getOutputBuffers();
                                            mediaFormat = mediaFormat4;
                                            i3 = i2;
                                        } else if (dequeueOutputBuffer2 == -2) {
                                            i3 = i2;
                                            if (i3 >= 0) {
                                                return;
                                            }
                                            mediaFormat = mediaCodec2.getOutputFormat();
                                        } else {
                                            i3 = i2;
                                            ByteBuffer byteBuffer2 = byteBufferArr2[dequeueOutputBuffer2];
                                            if ((bufferInfo2.flags & 2) != 0) {
                                                mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, false);
                                            } else {
                                                if (bufferInfo2.size != 0) {
                                                    this.f28367h.g(i3, byteBuffer2, bufferInfo2);
                                                }
                                                if ((bufferInfo2.flags & 4) != 0) {
                                                    z = false;
                                                    z3 = true;
                                                } else {
                                                    z = false;
                                                }
                                                mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, z);
                                            }
                                        }
                                        if (mediaFormat != null || z5) {
                                            i7 = i3;
                                        } else {
                                            j(InnerVideoProcessor.TAG, "muxer: adding video track.");
                                            i7 = this.f28367h.a(mediaFormat);
                                            z5 = true;
                                        }
                                        if (!this.f28367h.b() && z5) {
                                            this.f28367h.d();
                                            if (!this.f28367h.e()) {
                                                synchronized (this.f28367h) {
                                                    while (!this.f28367h.b()) {
                                                        try {
                                                            mediaFormat3 = mediaFormat;
                                                        } catch (InterruptedException e2) {
                                                            e = e2;
                                                            mediaFormat3 = mediaFormat;
                                                        }
                                                        try {
                                                            this.f28367h.wait(100L);
                                                        } catch (InterruptedException e3) {
                                                            e = e3;
                                                            e.printStackTrace();
                                                            mediaFormat = mediaFormat3;
                                                        }
                                                        mediaFormat = mediaFormat3;
                                                    }
                                                    mediaFormat2 = mediaFormat;
                                                }
                                                outputBuffers = byteBufferArr;
                                                mediaFormat4 = mediaFormat2;
                                                i5 = -1;
                                                i6 = 0;
                                            }
                                        }
                                        mediaFormat2 = mediaFormat;
                                        outputBuffers = byteBufferArr;
                                        mediaFormat4 = mediaFormat2;
                                        i5 = -1;
                                        i6 = 0;
                                    }
                                } else {
                                    i3 = i2;
                                }
                                mediaFormat = mediaFormat4;
                                if (mediaFormat != null) {
                                }
                                i7 = i3;
                                if (!this.f28367h.b()) {
                                    this.f28367h.d();
                                    if (!this.f28367h.e()) {
                                    }
                                }
                                mediaFormat2 = mediaFormat;
                                outputBuffers = byteBufferArr;
                                mediaFormat4 = mediaFormat2;
                                i5 = -1;
                                i6 = 0;
                            }
                            byteBufferArr = outputBuffers;
                            if (z3) {
                            }
                            i3 = i2;
                            mediaFormat = mediaFormat4;
                            if (mediaFormat != null) {
                            }
                            i7 = i3;
                            if (!this.f28367h.b()) {
                            }
                            mediaFormat2 = mediaFormat;
                            outputBuffers = byteBufferArr;
                            mediaFormat4 = mediaFormat2;
                            i5 = -1;
                            i6 = 0;
                        }
                    }
                }
                byteBufferArr = outputBuffers;
                if (z3) {
                }
                i3 = i2;
                mediaFormat = mediaFormat4;
                if (mediaFormat != null) {
                }
                i7 = i3;
                if (!this.f28367h.b()) {
                }
                mediaFormat2 = mediaFormat;
                outputBuffers = byteBufferArr;
                mediaFormat4 = mediaFormat2;
                i5 = -1;
                i6 = 0;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x0209, code lost:
        if (r0 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010a, code lost:
        if (r0 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010c, code lost:
        r0.onGenFilterVideoRecordError(229, b.a.r0.a2.a.a(r1));
     */
    /* JADX WARN: Removed duplicated region for block: B:144:0x020f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0228 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x026e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0256 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x01d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0240 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() throws Exception {
        MediaCodecInfo l;
        Throwable th;
        h hVar;
        g gVar;
        MediaExtractor mediaExtractor;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        Exception exc;
        b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (l = l("video/avc")) == null) {
            return;
        }
        Exception exc2 = null;
        try {
            mediaExtractor = a();
        } catch (Exception e2) {
            e = e2;
            hVar = null;
            gVar = null;
            mediaExtractor = null;
            mediaCodec = null;
        } catch (Throwable th2) {
            th = th2;
            hVar = null;
            gVar = null;
            mediaExtractor = null;
            mediaCodec = null;
        }
        try {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(f(mediaExtractor));
            int integer = trackFormat.getInteger("width");
            int integer2 = trackFormat.getInteger("height");
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f28365f);
            if (TextUtils.equals(mediaMetadataRetriever.extractMetadata(24), "90")) {
                integer2 = integer;
                integer = integer2;
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", integer, integer2);
            createVideoFormat.setInteger("color-format", 2130708361);
            m(trackFormat, createVideoFormat, "bitrate", 2097152);
            m(trackFormat, createVideoFormat, "frame-rate", 20);
            m(trackFormat, createVideoFormat, "i-frame-interval", 1);
            AtomicReference<Surface> atomicReference = new AtomicReference<>();
            mediaCodec = c(l, createVideoFormat, atomicReference);
            try {
                gVar = new g(atomicReference.get());
                try {
                    gVar.c();
                    hVar = new h(this.f28364e, this.f28366g, integer, integer2);
                    try {
                        mediaCodec2 = b(trackFormat, hVar.d());
                    } catch (Exception e3) {
                        e = e3;
                        mediaCodec2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        mediaCodec2 = null;
                    }
                    try {
                        d(mediaExtractor, mediaCodec2, mediaCodec, gVar, hVar);
                        if (mediaExtractor != null) {
                            try {
                                mediaExtractor.release();
                            } catch (Exception e4) {
                                exc2 = e4;
                                b.c cVar2 = this.f28368i;
                                if (cVar2 != null) {
                                    cVar2.onGenFilterVideoRecordError(225, b.a.r0.a2.a.a(exc2));
                                }
                            }
                        }
                        if (mediaCodec2 != null) {
                            try {
                                mediaCodec2.stop();
                                mediaCodec2.release();
                            } catch (Exception e5) {
                                if (exc2 == null) {
                                    exc2 = e5;
                                }
                                b.c cVar3 = this.f28368i;
                                if (cVar3 != null) {
                                    cVar3.onGenFilterVideoRecordError(Constants.METHOD_MEDIA_NOTIFY, b.a.r0.a2.a.a(e5));
                                }
                            }
                        }
                        try {
                            hVar.e();
                        } catch (Exception e6) {
                            if (exc2 == null) {
                                exc2 = e6;
                            }
                            b.c cVar4 = this.f28368i;
                            if (cVar4 != null) {
                                cVar4.onGenFilterVideoRecordError(227, b.a.r0.a2.a.a(e6));
                            }
                        }
                        if (mediaCodec != null) {
                            try {
                                mediaCodec.stop();
                                mediaCodec.release();
                            } catch (Exception e7) {
                                if (exc2 == null) {
                                    exc2 = e7;
                                }
                                b.c cVar5 = this.f28368i;
                                if (cVar5 != null) {
                                    cVar5.onGenFilterVideoRecordError(228, b.a.r0.a2.a.a(e7));
                                }
                            }
                        }
                        try {
                            gVar.d();
                        } catch (Exception e8) {
                            exc = e8;
                            if (exc2 == null) {
                                exc2 = exc;
                            }
                            cVar = this.f28368i;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        hVar = hVar;
                        gVar = gVar;
                        try {
                            e.printStackTrace();
                            if ((Build.VERSION.SDK_INT >= 21 || !(e instanceof MediaCodec.CodecException) || k.isEmpty(e.getMessage()) || !e.getMessage().contains("0xfffffff3")) && this.f28368i != null) {
                                this.f28368i.onGenFilterVideoRecordError(224, b.a.r0.a2.a.a(e));
                            }
                            if (mediaExtractor != null) {
                                try {
                                    mediaExtractor.release();
                                } catch (Exception e10) {
                                    exc2 = e10;
                                    b.c cVar6 = this.f28368i;
                                    if (cVar6 != null) {
                                        cVar6.onGenFilterVideoRecordError(225, b.a.r0.a2.a.a(exc2));
                                    }
                                }
                            }
                            if (mediaCodec2 != null) {
                                try {
                                    mediaCodec2.stop();
                                    mediaCodec2.release();
                                } catch (Exception e11) {
                                    if (exc2 == null) {
                                        exc2 = e11;
                                    }
                                    b.c cVar7 = this.f28368i;
                                    if (cVar7 != null) {
                                        cVar7.onGenFilterVideoRecordError(Constants.METHOD_MEDIA_NOTIFY, b.a.r0.a2.a.a(e11));
                                    }
                                }
                            }
                            if (hVar != null) {
                                try {
                                    hVar.e();
                                } catch (Exception e12) {
                                    if (exc2 == null) {
                                        exc2 = e12;
                                    }
                                    b.c cVar8 = this.f28368i;
                                    if (cVar8 != null) {
                                        cVar8.onGenFilterVideoRecordError(227, b.a.r0.a2.a.a(e12));
                                    }
                                }
                            }
                            if (mediaCodec != null) {
                                try {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                } catch (Exception e13) {
                                    if (exc2 == null) {
                                        exc2 = e13;
                                    }
                                    b.c cVar9 = this.f28368i;
                                    if (cVar9 != null) {
                                        cVar9.onGenFilterVideoRecordError(228, b.a.r0.a2.a.a(e13));
                                    }
                                }
                            }
                            if (gVar != null) {
                                try {
                                    gVar.d();
                                } catch (Exception e14) {
                                    exc = e14;
                                    if (exc2 == null) {
                                        exc2 = exc;
                                    }
                                    cVar = this.f28368i;
                                }
                            }
                            if (exc2 != null) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (mediaExtractor != null) {
                                try {
                                    mediaExtractor.release();
                                } catch (Exception e15) {
                                    exc2 = e15;
                                    b.c cVar10 = this.f28368i;
                                    if (cVar10 != null) {
                                        cVar10.onGenFilterVideoRecordError(225, b.a.r0.a2.a.a(exc2));
                                    }
                                }
                            }
                            if (mediaCodec2 != null) {
                                try {
                                    mediaCodec2.stop();
                                    mediaCodec2.release();
                                } catch (Exception e16) {
                                    if (exc2 == null) {
                                        exc2 = e16;
                                    }
                                    b.c cVar11 = this.f28368i;
                                    if (cVar11 != null) {
                                        cVar11.onGenFilterVideoRecordError(Constants.METHOD_MEDIA_NOTIFY, b.a.r0.a2.a.a(e16));
                                    }
                                }
                            }
                            if (hVar != null) {
                                try {
                                    hVar.e();
                                } catch (Exception e17) {
                                    if (exc2 == null) {
                                        exc2 = e17;
                                    }
                                    b.c cVar12 = this.f28368i;
                                    if (cVar12 != null) {
                                        cVar12.onGenFilterVideoRecordError(227, b.a.r0.a2.a.a(e17));
                                    }
                                }
                            }
                            if (mediaCodec != null) {
                                try {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                } catch (Exception e18) {
                                    if (exc2 == null) {
                                    }
                                    b.c cVar13 = this.f28368i;
                                    if (cVar13 != null) {
                                        cVar13.onGenFilterVideoRecordError(228, b.a.r0.a2.a.a(e18));
                                    }
                                }
                            }
                            if (gVar != null) {
                                try {
                                    gVar.d();
                                } catch (Exception e19) {
                                    b.c cVar14 = this.f28368i;
                                    if (cVar14 != null) {
                                        cVar14.onGenFilterVideoRecordError(229, b.a.r0.a2.a.a(e19));
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        hVar = hVar;
                        gVar = gVar;
                        if (mediaExtractor != null) {
                        }
                        if (mediaCodec2 != null) {
                        }
                        if (hVar != null) {
                        }
                        if (mediaCodec != null) {
                        }
                        if (gVar != null) {
                        }
                        throw th;
                    }
                } catch (Exception e20) {
                    e = e20;
                    hVar = null;
                    mediaCodec2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    hVar = null;
                    mediaCodec2 = null;
                }
            } catch (Exception e21) {
                e = e21;
                hVar = null;
                gVar = null;
                mediaCodec2 = null;
            } catch (Throwable th7) {
                th = th7;
                hVar = null;
                gVar = null;
                mediaCodec2 = null;
            }
        } catch (Exception e22) {
            e = e22;
            hVar = null;
            gVar = null;
            mediaCodec = null;
            mediaCodec2 = mediaCodec;
            e.printStackTrace();
            if (Build.VERSION.SDK_INT >= 21) {
            }
            this.f28368i.onGenFilterVideoRecordError(224, b.a.r0.a2.a.a(e));
            if (mediaExtractor != null) {
            }
            if (mediaCodec2 != null) {
            }
            if (hVar != null) {
            }
            if (mediaCodec != null) {
            }
            if (gVar != null) {
            }
            if (exc2 != null) {
            }
        } catch (Throwable th8) {
            th = th8;
            hVar = null;
            gVar = null;
            mediaCodec = null;
            mediaCodec2 = mediaCodec;
            if (mediaExtractor != null) {
            }
            if (mediaCodec2 != null) {
            }
            if (hVar != null) {
            }
            if (mediaCodec != null) {
            }
            if (gVar != null) {
            }
            throw th;
        }
        if (exc2 != null) {
            throw exc2;
        }
    }

    public final int f(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mediaExtractor)) == null) {
            for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                if (i(mediaExtractor.getTrackFormat(i2))) {
                    mediaExtractor.selectTrack(i2);
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !Thread.currentThread().isInterrupted() : invokeV.booleanValue;
    }

    public abstract void k();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                e();
                if (h()) {
                    b.a.e.e.m.e.a().post(new a(this));
                }
            } catch (Exception unused) {
            }
        }
    }
}
