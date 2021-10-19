package c.a.r0.c4.l.c.d;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.t.u;
import c.a.x0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface;
import com.baidu.ugc.editvideo.faceunity.encoder.MediaCodecHelper;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f16502b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b> f16503a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b extends MediaMetadataRetriever implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f16504e;

        /* renamed from: f  reason: collision with root package name */
        public String f16505f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f16506g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f16507h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ n f16508e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f16509f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f16510g;

            public a(b bVar, n nVar, m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, nVar, mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16510g = bVar;
                this.f16508e = nVar;
                this.f16509f = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<h> arrayList = new ArrayList();
                    ArrayList<h> arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (h hVar : this.f16508e.f16544e) {
                        int i2 = hVar.f16527g;
                        if (i2 == 0) {
                            arrayList.add(hVar);
                        } else if (i2 == 1) {
                            arrayList2.add(hVar);
                        }
                    }
                    if (!c.a.x0.t.h.e(arrayList)) {
                        for (h hVar2 : arrayList) {
                            Bitmap d2 = i.f().d(hVar2.f16521a);
                            if (d2 == null || d2.isRecycled()) {
                                d2 = c.a.x0.t.d.e(hVar2.f16522b, hVar2.f16528h, hVar2.f16529i, hVar2.f16523c);
                                i.f().g().b(hVar2.f16521a, d2);
                                i.f().e().c(hVar2.f16521a, d2);
                            }
                            hVar2.f16525e = d2;
                            hVar2.a();
                        }
                    }
                    if (!c.a.x0.t.h.e(arrayList2)) {
                        for (h hVar3 : arrayList2) {
                            Bitmap d3 = i.f().d(hVar3.f16521a);
                            if (d3 != null && !d3.isRecycled()) {
                                hVar3.f16525e = d3;
                                hVar3.a();
                            } else {
                                arrayList3.add(hVar3);
                            }
                        }
                    }
                    if (c.a.x0.t.h.e(arrayList3)) {
                        this.f16510g.r(this.f16509f);
                        return;
                    }
                    this.f16508e.f16544e = arrayList3;
                    if (!this.f16510g.n()) {
                        this.f16510g.q(this.f16508e);
                    } else {
                        this.f16510g.p(this.f16508e);
                    }
                    this.f16510g.r(this.f16509f);
                }
            }
        }

        /* renamed from: c.a.r0.c4.l.c.d.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0790b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f16511e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f16512f;

            public RunnableC0790b(b bVar, m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16512f = bVar;
                this.f16511e = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                m mVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mVar = this.f16511e) == null) {
                    return;
                }
                mVar.a(this.f16512f);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.media.MediaMetadataRetriever, java.lang.AutoCloseable, java.io.Closeable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                release();
            }
        }

        public final void d(MediaExtractor mediaExtractor, int i2, MediaCodec mediaCodec, BaseOutputSurface baseOutputSurface, List<h> list) throws IOException {
            String str;
            int i3;
            long j2;
            int i4;
            int dequeueInputBuffer;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaExtractor, Integer.valueOf(i2), mediaCodec, baseOutputSurface, list}) == null) {
                ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                long j3 = 0;
                int i5 = 0;
                if (c.a.x0.t.h.b(list) == 1) {
                    h hVar = (h) c.a.x0.t.h.c(list, 0);
                    long j4 = hVar != null ? hVar.f16524d : 0L;
                    if (j4 <= 0) {
                        j4 = 1;
                    }
                    mediaExtractor.getSampleTime();
                    mediaExtractor.seekTo(j4, 0);
                    if (mediaExtractor.getSampleTime() > j4) {
                        mediaExtractor.seekTo(0L, 2);
                    }
                }
                int i6 = 0;
                boolean z = false;
                boolean z2 = false;
                while (!z && !this.f16504e) {
                    if (z2 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                        str = "VideoFrameMetadataRetriever";
                        i3 = i6;
                        j2 = j3;
                    } else {
                        int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i5);
                        if (readSampleData < 0) {
                            str = "VideoFrameMetadataRetriever";
                            i3 = i6;
                            j2 = j3;
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            z2 = true;
                        } else {
                            str = "VideoFrameMetadataRetriever";
                            i3 = i6;
                            j2 = j3;
                            if (mediaExtractor.getSampleTrackIndex() != i2) {
                                c.a.x0.t.c.l(str, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i2);
                            }
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            mediaExtractor.advance();
                        }
                    }
                    if (z) {
                        i4 = i3;
                    } else {
                        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                        if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                            if (dequeueOutputBuffer == -2) {
                                mediaCodec.getOutputFormat();
                            } else if (dequeueOutputBuffer < 0) {
                                c.a.x0.t.c.c(str, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                            } else {
                                boolean z3 = (bufferInfo.flags & 4) != 0 ? true : z;
                                boolean z4 = bufferInfo.size != 0;
                                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z4);
                                if (z4) {
                                    i4 = i3;
                                    h hVar2 = (h) c.a.x0.t.h.c(list, i4);
                                    baseOutputSurface.awaitNewImage();
                                    baseOutputSurface.drawImage((int) (((float) bufferInfo.presentationTimeUs) / 1000.0f));
                                    if (hVar2 != null) {
                                        long j5 = hVar2.f16524d;
                                        if (j5 <= j2) {
                                            j5 = 1;
                                        } else if (i4 == list.size() - 1) {
                                            j5 -= 800000;
                                        }
                                        if (bufferInfo.presentationTimeUs >= j5) {
                                            hVar2.f16525e = baseOutputSurface.getFrameBitmap();
                                            i.f().g().b(hVar2.f16521a, hVar2.f16525e);
                                            hVar2.a();
                                            i.f().e().c(hVar2.f16521a, hVar2.f16525e);
                                            if (i4 == list.size() - 1) {
                                                z3 = true;
                                            }
                                            i6 = i4 + 1;
                                            z = z3;
                                            j3 = j2;
                                            i5 = 0;
                                        }
                                    }
                                } else {
                                    i4 = i3;
                                }
                                z = z3;
                            }
                        }
                        i6 = i3;
                        j3 = j2;
                        i5 = 0;
                    }
                    i6 = i4;
                    j3 = j2;
                    i5 = 0;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(String str, List<h> list, int i2, int i3, float f2) throws IOException {
            MediaExtractor mediaExtractor;
            MediaCodec mediaCodec;
            File file;
            int andSelectVideoTrackIndex;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, list, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)}) == null) {
                c cVar = null;
                try {
                    file = new File(str);
                } catch (Exception e2) {
                    e = e2;
                    mediaExtractor = null;
                    mediaCodec = null;
                } catch (Throwable th) {
                    th = th;
                    mediaExtractor = null;
                    mediaCodec = null;
                }
                if (file.canRead()) {
                    mediaExtractor = new MediaExtractor();
                    try {
                        mediaExtractor.setDataSource(file.toString());
                        andSelectVideoTrackIndex = MediaCodecHelper.getAndSelectVideoTrackIndex(mediaExtractor);
                    } catch (Exception e3) {
                        e = e3;
                        mediaCodec = null;
                    } catch (Throwable th2) {
                        th = th2;
                        mediaCodec = null;
                    }
                    if (andSelectVideoTrackIndex >= 0) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(andSelectVideoTrackIndex);
                        int integer = trackFormat.getInteger("width");
                        int integer2 = trackFormat.getInteger("height");
                        if (i2 == 0 || i3 == 0) {
                            float f3 = f2 % 360.0f;
                            if (f3 != 90.0f && f3 != 270.0f) {
                                i2 = integer;
                                i3 = integer2;
                            }
                            i3 = integer;
                            i2 = integer2;
                        }
                        c cVar2 = new c(i2, i3, true, null);
                        try {
                            cVar2.a(integer, integer2, f2);
                            mediaCodec = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                        } catch (Exception e4) {
                            e = e4;
                            mediaCodec = null;
                        } catch (Throwable th3) {
                            th = th3;
                            mediaCodec = null;
                        }
                        try {
                            mediaCodec.configure(trackFormat, cVar2.getSurface(), (MediaCrypto) null, 0);
                            mediaCodec.start();
                            d(mediaExtractor, andSelectVideoTrackIndex, mediaCodec, cVar2, list);
                            cVar2.release();
                            if (mediaCodec != null) {
                                mediaCodec.stop();
                                mediaCodec.release();
                            }
                        } catch (Exception e5) {
                            e = e5;
                            cVar = cVar2;
                            try {
                                c.a.x0.t.c.g(e);
                                if (cVar != null) {
                                    cVar.release();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                }
                                if (mediaExtractor == null) {
                                    return;
                                }
                                mediaExtractor.release();
                                return;
                            } catch (Throwable th4) {
                                th = th4;
                                if (cVar != null) {
                                    cVar.release();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                }
                                if (mediaExtractor != null) {
                                    mediaExtractor.release();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            cVar = cVar2;
                            if (cVar != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (mediaExtractor != null) {
                            }
                            throw th;
                        }
                        mediaExtractor.release();
                        return;
                    }
                    throw new RuntimeException("No video track found in " + file);
                }
                throw new FileNotFoundException("Unable to read " + file);
            }
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16507h : invokeV.booleanValue;
        }

        public boolean n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16506g && !w.a(this.f16505f) : invokeV.booleanValue;
        }

        public void o(n nVar, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, nVar, mVar) == null) {
                if (nVar != null && !c.a.x0.t.h.e(nVar.f16544e)) {
                    this.f16507h = true;
                    ThreadPool.b().e(new a(this, nVar, mVar));
                    return;
                }
                r(mVar);
            }
        }

        public final void p(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) {
                try {
                    e(nVar.f16540a, nVar.f16544e, nVar.f16542c, nVar.f16543d, nVar.f16541b);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    q(nVar);
                }
            }
        }

        public final void q(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, nVar) == null) {
                try {
                    for (h hVar : nVar.f16544e) {
                        Bitmap frameAtTime = getFrameAtTime(hVar.f16524d, 2);
                        if (frameAtTime != null) {
                            if (nVar.f16542c != 0 && nVar.f16543d != 0) {
                                hVar.f16525e = ThumbnailUtils.extractThumbnail(frameAtTime, nVar.f16542c, nVar.f16543d, 2);
                            }
                            hVar.a();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void r(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mVar) == null) {
                this.f16507h = false;
                u.a().post(new RunnableC0790b(this, mVar));
            }
        }

        @Override // android.media.MediaMetadataRetriever
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                super.release();
                this.f16504e = true;
                this.f16507h = false;
            }
        }

        public void s(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.f16507h = z;
            }
        }

        @Override // android.media.MediaMetadataRetriever
        public void setDataSource(String str) throws IllegalArgumentException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                try {
                    super.setDataSource(str);
                    this.f16505f = str;
                } catch (Exception e2) {
                    c.a.x0.t.c.g(e2);
                }
            }
        }

        public void t(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
                this.f16506g = z;
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16506g = true;
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.f16503a = arrayList;
        arrayList.add(new b(null));
        this.f16503a.add(new b(null));
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f16502b == null) {
                synchronized (e.class) {
                    if (f16502b == null) {
                        f16502b = new e();
                    }
                }
            }
            return f16502b;
        }
        return (e) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        r2.s(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        r0 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized b b() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                bVar = null;
                Iterator<b> it = this.f16503a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    if (next != null && !next.g()) {
                        break;
                    }
                }
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.s(false);
    }
}
