package com.baidu.media.transcoder.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.player.StreamConfig;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@TargetApi(18)
/* loaded from: classes5.dex */
public class c extends com.baidu.media.transcoder.c {
    private String c = null;
    private String d = null;
    private b aIg = null;
    private e aIh = null;
    private int g = -1;
    private int h = -1;
    private int i = 520000;
    private int j = 25;
    private int k = -1;
    private int l = 128000;
    private int m = -1;
    private int n = -1;
    private MediaMuxer aIi = null;
    protected int a = 0;
    protected int b = 0;
    private a aIj = null;
    private f aIk = null;
    private int r = 0;
    private boolean s = false;
    private Object t = new Object();
    private ArrayList<Message> u = new ArrayList<>();
    private InterfaceC0119c aIl = new InterfaceC0119c() { // from class: com.baidu.media.transcoder.a.c.1
        @Override // com.baidu.media.transcoder.a.c.InterfaceC0119c
        public int a(MediaFormat mediaFormat) {
            int addTrack = c.this.aIi.addTrack(mediaFormat);
            c.f(c.this);
            if (c.this.r > 1 || c.this.aIj == null) {
                c.this.aIi.start();
                if (c.this.aIj != null) {
                    c.this.aIj.b(true);
                }
                c.this.aIk.b(true);
            }
            return addTrack;
        }

        @Override // com.baidu.media.transcoder.a.c.InterfaceC0119c
        public int c(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            c.this.aIi.writeSampleData(i, byteBuffer, bufferInfo);
            return 0;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends d {
        private int t;

        public a() {
            super();
            this.t = -1;
            this.r = 0;
        }

        private MediaFormat a(MediaCodecInfo mediaCodecInfo) {
            if (mediaCodecInfo != null) {
                MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", StreamConfig.Audio.AUDIO_FREQUENCY, 2);
                createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, c.this.l);
                createAudioFormat.setInteger("aac-profile", 2);
                return createAudioFormat;
            }
            return null;
        }

        private MediaFormat a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) {
            int i = c.this.k;
            int i2 = c.this.m;
            int i3 = c.this.l;
            if (mediaCodecInfo != null) {
                MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
                if (i2 <= 0) {
                    i2 = 2;
                }
                createAudioFormat.setInteger("channel-count", i2);
                createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
                createAudioFormat.setInteger("aac-profile", 2);
                createAudioFormat.setInteger("max-input-size", 8192);
                return createAudioFormat;
            }
            return null;
        }

        private MediaCodec b(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) {
            try {
                MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
                try {
                    createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                    createByCodecName.start();
                    return createByCodecName;
                } catch (IllegalStateException e) {
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "audio encoder configure or start unknown error.");
                    return null;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                com.baidu.media.transcoder.d.d("MCTranscoder", "audio encoder createDecoderByType unknown error.");
                return null;
            }
        }

        private boolean d(MediaFormat mediaFormat) {
            return f(mediaFormat).startsWith("audio/");
        }

        private MediaCodec e(MediaFormat mediaFormat) {
            try {
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(f(mediaFormat));
                try {
                    createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
                    createDecoderByType.start();
                    return createDecoderByType;
                } catch (IllegalStateException e) {
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "audio decoder configure or start unknown error.");
                    return null;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                com.baidu.media.transcoder.d.d("MCTranscoder", "audio decoder createDecoderByType unknown error.");
                return null;
            }
        }

        @Override // com.baidu.media.transcoder.a.c.d
        public int a() {
            if (this.o) {
                return 1001;
            }
            if (this.aIv == null || this.q) {
                try {
                    if (this.t == -1) {
                        int dequeueOutputBuffer = this.c.dequeueOutputBuffer(this.aIs, 10000L);
                        if (dequeueOutputBuffer == -1) {
                            com.baidu.media.transcoder.d.b("MCTranscoder", "audio process out INFO_TRY_AGAIN_LATER");
                            return 1000;
                        } else if (dequeueOutputBuffer == -3) {
                            this.aIp = this.c.getOutputBuffers();
                            com.baidu.media.transcoder.d.b("MCTranscoder", "audio process out INFO_OUTPUT_BUFFERS_CHANGED");
                            return 1000;
                        } else if (dequeueOutputBuffer == -2) {
                            this.aIu = this.c.getOutputFormat();
                            com.baidu.media.transcoder.d.b("MCTranscoder", "audio process out INFO_OUTPUT_FORMAT_CHANGED");
                            return 1000;
                        } else {
                            ByteBuffer byteBuffer = this.aIp[dequeueOutputBuffer];
                            if ((this.aIs.flags & 2) != 0) {
                                this.c.releaseOutputBuffer(dequeueOutputBuffer, false);
                                com.baidu.media.transcoder.d.b("MCTranscoder", "audio process out BUFFER_FLAG_CODEC_CONFIG");
                                return 1000;
                            }
                            this.t = dequeueOutputBuffer;
                        }
                    }
                    if (this.t != -1) {
                        int dequeueInputBuffer = this.b.dequeueInputBuffer(10000L);
                        if (dequeueInputBuffer < 0) {
                            com.baidu.media.transcoder.d.b("MCTranscoder", "mEncoder.dequeueInputBuffer failed ...");
                            return 1000;
                        }
                        com.baidu.media.transcoder.d.b("MCTranscoder", "mEncoder.dequeueInputBuffer encoderInputBufferIndex:" + dequeueInputBuffer);
                        ByteBuffer byteBuffer2 = this.aIq[dequeueInputBuffer];
                        int i = this.aIs.size;
                        long j = this.aIs.presentationTimeUs;
                        if (i >= 0) {
                            ByteBuffer duplicate = this.aIp[this.t].duplicate();
                            duplicate.position(this.aIs.offset);
                            duplicate.limit(this.aIs.offset + i);
                            com.baidu.media.transcoder.d.b("MCTranscoder", "mEncoder.dequeueInputBuffer size:" + i);
                            byteBuffer2.position(0);
                            byteBuffer2.put(duplicate);
                            this.b.queueInputBuffer(dequeueInputBuffer, 0, i, j, this.aIs.flags);
                        }
                        this.c.releaseOutputBuffer(this.t, false);
                        this.t = -1;
                        if ((this.aIs.flags & 4) != 0) {
                            this.o = true;
                        }
                    }
                    return 0;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "audio decoder error");
                    return -1106;
                } catch (BufferOverflowException e2) {
                    e2.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "audio decoder buffer overflow.");
                    return -1107;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "audio decoder unknown error.");
                    return -1108;
                }
            }
            return 1000;
        }

        @Override // com.baidu.media.transcoder.a.c.d
        protected int a(MediaExtractor mediaExtractor) {
            for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
                if (d(mediaExtractor.getTrackFormat(i))) {
                    mediaExtractor.selectTrack(i);
                    return i;
                }
            }
            return -1007;
        }

        @Override // com.baidu.media.transcoder.a.c.d
        public int a(boolean z) {
            MediaCodecInfo eo;
            MediaFormat a;
            try {
                this.aIn = Bw();
                try {
                    MediaFormat trackFormat = this.aIn.getTrackFormat(a(this.aIn));
                    if (c.this.m < 0) {
                        c.this.m = trackFormat.getInteger("channel-count");
                    }
                    if (c.this.k < 0) {
                        c.this.k = trackFormat.getInteger("sample-rate");
                    }
                    com.baidu.media.transcoder.d.b("MCTranscoder", "inputAudioFormat mime:" + trackFormat.getString(IMediaFormat.KEY_MIME));
                    com.baidu.media.transcoder.d.b("MCTranscoder", "mAudioChannelCount:" + c.this.m + " mAudioSampleRateHZ:" + c.this.k);
                    if (z) {
                        eo = eo("audio/mp4a-latm");
                        a = a(eo);
                    } else {
                        eo = eo(trackFormat.getString(IMediaFormat.KEY_MIME));
                        a = a(eo, trackFormat);
                    }
                    if (a == null || eo == null) {
                        Log.e("MCTranscoder", "找不到声音编码器");
                        return CyberPlayerManager.MEDIA_ERROR_UNSUPPORTED;
                    }
                    Log.e("MCTranscoder", "inputAudioFormat" + trackFormat);
                    Log.e("MCTranscoder", "outputAudioFormat" + a);
                    this.b = b(eo, a);
                    if (this.b == null) {
                        com.baidu.media.transcoder.d.d("MCTranscoder", "createAudioEncoder error");
                        return -1101;
                    }
                    this.c = e(trackFormat);
                    if (this.c == null) {
                        com.baidu.media.transcoder.d.d("MCTranscoder", "createAudioDecoder error");
                        return MessageConfig.GITT_NO_DATA;
                    }
                    try {
                        this.aIo = this.c.getInputBuffers();
                        this.aIp = this.c.getOutputBuffers();
                        this.aIq = this.b.getInputBuffers();
                        this.aIr = this.b.getOutputBuffers();
                        return 0;
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                        com.baidu.media.transcoder.d.d("MCTranscoder", "Audio get buffers error");
                        return -1012;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        com.baidu.media.transcoder.d.d("MCTranscoder", "audio get buffers unknown error.");
                        return -1013;
                    }
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    return -1008;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "audio getTrackFormat unknown error.");
                    return -1009;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
                return -1003;
            } catch (Exception e6) {
                e6.printStackTrace();
                com.baidu.media.transcoder.d.d("MCTranscoder", "audio createExtractor unknown error.");
                return -1004;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends Handler {
        private final WeakReference<c> a;

        public b(c cVar, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = this.a.get();
            if (cVar == null) {
                com.baidu.media.transcoder.d.c("MCTranscoder", "MediaCodecTranscoder went away with unhandled events");
                return;
            }
            switch (message.what) {
                case 0:
                    return;
                case 1:
                    com.baidu.media.transcoder.d.b("MCTranscoder", "MEDIA_PREPARED (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    cVar.b();
                    return;
                case 2:
                    com.baidu.media.transcoder.d.b("MCTranscoder", "MEDIA_TRANSCODER_COMPLETE (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    cVar.c();
                    return;
                case 3:
                    com.baidu.media.transcoder.d.b("MCTranscoder", "MEDIA_TRANSCODER_TERMINAL (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    cVar.d();
                    return;
                case 100:
                    com.baidu.media.transcoder.d.b("MCTranscoder", "MEDIA_ERROR (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    if (cVar.a(message.arg1, message.arg2)) {
                        return;
                    }
                    cVar.c();
                    return;
                case 200:
                    com.baidu.media.transcoder.d.b("MCTranscoder", "MEDIA_INFO (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + message.obj + ")");
                    cVar.a(message.arg1, message.arg2, message.obj);
                    return;
                default:
                    com.baidu.media.transcoder.d.d("MCTranscoder", "Unknown message type " + message.what);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.media.transcoder.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0119c {
        int a(MediaFormat mediaFormat);

        int c(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class d {
        protected MediaCodec.BufferInfo aIs;
        protected MediaCodec.BufferInfo aIt;
        private InterfaceC0119c aIw;
        protected int r;
        protected MediaCodec b = null;
        protected MediaCodec c = null;
        protected MediaExtractor aIn = null;
        protected ByteBuffer[] aIo = null;
        protected ByteBuffer[] aIp = null;
        protected ByteBuffer[] aIq = null;
        protected ByteBuffer[] aIr = null;
        protected int k = -1;
        protected MediaFormat aIu = null;
        protected MediaFormat aIv = null;
        protected boolean n = false;
        protected boolean o = false;
        protected boolean p = false;
        protected boolean q = false;

        public d() {
            this.aIs = null;
            this.aIt = null;
            this.aIs = new MediaCodec.BufferInfo();
            this.aIt = new MediaCodec.BufferInfo();
        }

        protected MediaExtractor Bw() {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(c.this.c);
            return mediaExtractor;
        }

        public int a() {
            return 0;
        }

        protected int a(MediaExtractor mediaExtractor) {
            return -1007;
        }

        public int a(boolean z) {
            return 0;
        }

        public void a(InterfaceC0119c interfaceC0119c) {
            this.aIw = interfaceC0119c;
        }

        public void b() {
            try {
                if (this.c != null) {
                    this.c.stop();
                }
                if (this.b != null) {
                    this.b.stop();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
                com.baidu.media.transcoder.d.d("MCTranscoder", "stop unknown error.");
            }
        }

        public void b(boolean z) {
            this.q = z;
        }

        public void c() {
            try {
                if (this.aIn != null) {
                    this.aIn.release();
                }
                if (this.c != null) {
                    this.c.release();
                }
                if (this.b != null) {
                    this.b.release();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
                com.baidu.media.transcoder.d.d("MCTranscoder", "release unknown error.");
            }
        }

        public boolean d() {
            return this.p;
        }

        protected MediaCodecInfo eo(String str) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
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

        public int f() {
            if (this.n) {
                return 1001;
            }
            if (this.aIv == null || this.q) {
                try {
                    int dequeueInputBuffer = this.c.dequeueInputBuffer(10000L);
                    if (dequeueInputBuffer != -1) {
                        ByteBuffer byteBuffer = this.aIo[dequeueInputBuffer];
                        int readSampleData = this.aIn.readSampleData(byteBuffer, 0);
                        long sampleTime = this.aIn.getSampleTime();
                        if (readSampleData >= 0) {
                            byteBuffer.position(0);
                            byteBuffer.limit(readSampleData);
                            this.c.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, this.aIn.getSampleFlags());
                            c.this.b += readSampleData;
                        }
                        this.n = !this.aIn.advance();
                        if (this.n) {
                            this.c.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        }
                        return 0;
                    }
                    return 1000;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "demuxer error");
                    return -1015;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "demux unknown error.");
                    return -1016;
                }
            }
            return 1000;
        }

        protected String f(MediaFormat mediaFormat) {
            return mediaFormat.getString(IMediaFormat.KEY_MIME);
        }

        public int g() {
            if (this.p) {
                return 1001;
            }
            if (this.aIv == null || this.q) {
                try {
                    int dequeueOutputBuffer = this.b.dequeueOutputBuffer(this.aIt, 10000L);
                    if (dequeueOutputBuffer != -1) {
                        if (dequeueOutputBuffer == -3) {
                            this.aIr = this.b.getOutputBuffers();
                            return 1000;
                        } else if (dequeueOutputBuffer == -2) {
                            this.aIv = this.b.getOutputFormat();
                            if (this.aIw != null) {
                                this.k = this.aIw.a(this.aIv);
                                return 1000;
                            }
                            return 1000;
                        } else {
                            com.baidu.media.transcoder.d.b("MCTranscoder", "EncOutputBufferInfo time:" + this.aIt.presentationTimeUs + " size:" + this.aIt.size + " offset:" + this.aIt.offset + " flag:" + this.aIt.flags);
                            ByteBuffer byteBuffer = this.aIr[dequeueOutputBuffer];
                            if ((this.aIt.flags & 2) != 0) {
                                this.b.releaseOutputBuffer(dequeueOutputBuffer, false);
                                return 1000;
                            }
                            if (this.aIt.size != 0 && this.aIw != null) {
                                this.aIw.c(this.k, byteBuffer, this.aIt);
                            }
                            if ((this.aIt.flags & 4) != 0) {
                                this.p = true;
                            }
                            this.b.releaseOutputBuffer(dequeueOutputBuffer, false);
                            return 0;
                        }
                    }
                    return 1000;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    if (this.r == 0) {
                        com.baidu.media.transcoder.d.d("MCTranscoder", "audio encoder error");
                        return -1104;
                    }
                    com.baidu.media.transcoder.d.d("MCTranscoder", "video encoder error");
                    return -1109;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (this.r == 0) {
                        com.baidu.media.transcoder.d.d("MCTranscoder", "audio encoder unknown error");
                        return -1105;
                    }
                    com.baidu.media.transcoder.d.d("MCTranscoder", "video encoder unknown error");
                    return -1110;
                }
            }
            return 1000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class e extends Thread {
        public e(String str) {
            super(str);
        }

        public void a() {
            c.this.s = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            c.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class f extends d {
        private com.baidu.media.transcoder.a.d aIy;
        private com.baidu.media.transcoder.a.b aIz;

        public f() {
            super();
            this.aIy = null;
            this.aIz = null;
            this.r = 1;
        }

        private MediaCodec a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) {
            try {
                MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
                try {
                    createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                    atomicReference.set(createByCodecName.createInputSurface());
                    createByCodecName.start();
                    return createByCodecName;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "video encoder configure or start unknown error.");
                    return null;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                com.baidu.media.transcoder.d.d("MCTranscoder", "video encoder createDecoderByType unknown error.");
                return null;
            }
        }

        private MediaCodec a(MediaFormat mediaFormat, Surface surface) {
            try {
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(f(mediaFormat));
                try {
                    createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
                    createDecoderByType.start();
                    return createDecoderByType;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "audio decoder configure or start unknown error.");
                    return null;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                com.baidu.media.transcoder.d.d("MCTranscoder", "video decoder createDecoderByType unknown error.");
                return null;
            }
        }

        private boolean d(MediaFormat mediaFormat) {
            return f(mediaFormat).startsWith("video/");
        }

        @Override // com.baidu.media.transcoder.a.c.d
        public int a() {
            if (this.o) {
                return 1001;
            }
            if (this.aIv == null || this.q) {
                try {
                    int dequeueOutputBuffer = this.c.dequeueOutputBuffer(this.aIs, 10000L);
                    if (dequeueOutputBuffer == -1) {
                        com.baidu.media.transcoder.d.b("MCTranscoder", "video process out INFO_TRY_AGAIN_LATER");
                        return 1000;
                    } else if (dequeueOutputBuffer == -3) {
                        this.aIp = this.c.getOutputBuffers();
                        com.baidu.media.transcoder.d.b("MCTranscoder", "video process out INFO_OUTPUT_BUFFERS_CHANGED");
                        return 1000;
                    } else if (dequeueOutputBuffer == -2) {
                        this.aIu = this.c.getOutputFormat();
                        com.baidu.media.transcoder.d.b("MCTranscoder", "video process out INFO_OUTPUT_FORMAT_CHANGED");
                        return 1000;
                    } else {
                        com.baidu.media.transcoder.d.b("MCTranscoder", "video process out decoderOutputBufferIndex:" + dequeueOutputBuffer);
                        ByteBuffer byteBuffer = this.aIp[dequeueOutputBuffer];
                        if ((this.aIs.flags & 2) != 0) {
                            com.baidu.media.transcoder.d.b("MCTranscoder", "video process out BUFFER_FLAG_CODEC_CONFIG");
                            this.c.releaseOutputBuffer(dequeueOutputBuffer, false);
                            return 1000;
                        }
                        boolean z = this.aIs.size != 0;
                        this.c.releaseOutputBuffer(dequeueOutputBuffer, z);
                        if (z) {
                            com.baidu.media.transcoder.d.b("MCTranscoder", "awaitNewImage start ...");
                            this.aIy.b();
                            com.baidu.media.transcoder.d.b("MCTranscoder", "awaitNewImage end ...");
                            this.aIy.c();
                            com.baidu.media.transcoder.d.b("MCTranscoder", "video DecOutputBufferInfo time:" + this.aIs.presentationTimeUs + " size:" + this.aIs.size + " offset:" + this.aIs.offset + " flag:" + this.aIs.flags);
                            this.aIz.a(this.aIs.presentationTimeUs * 1000);
                            this.aIz.b();
                        }
                        if ((this.aIs.flags & 4) != 0) {
                            this.o = true;
                            this.b.signalEndOfInputStream();
                        }
                        return 0;
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "video decode error");
                    return -1111;
                } catch (BufferOverflowException e2) {
                    e2.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "video decoder buffer overflow.");
                    return -1112;
                } catch (RuntimeException e3) {
                    e3.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "video decoder wait surface.");
                    return -1014;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "video decoder unknown error.");
                    return -1113;
                }
            }
            return 1000;
        }

        @Override // com.baidu.media.transcoder.a.c.d
        protected int a(MediaExtractor mediaExtractor) {
            for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
                try {
                    if (d(mediaExtractor.getTrackFormat(i))) {
                        mediaExtractor.selectTrack(i);
                        return i;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "selectTrackIndex error.");
                }
            }
            return -1007;
        }

        @Override // com.baidu.media.transcoder.a.c.d
        public int a(boolean z) {
            MediaCodecInfo eo = eo("video/avc");
            if (eo == null) {
                com.baidu.media.transcoder.d.d("MCTranscoder", "videoCodecInfo is null");
                return -1011;
            }
            try {
                this.aIn = Bw();
                try {
                    MediaFormat trackFormat = this.aIn.getTrackFormat(a(this.aIn));
                    int i = c.this.i;
                    int i2 = c.this.j;
                    Log.i("MCTranscoder", "videoBitRate=" + i);
                    Log.i("MCTranscoder", "videoFrameRate=" + i2);
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", c.this.g, c.this.h);
                    createVideoFormat.setInteger("color-format", 2130708361);
                    createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i);
                    createVideoFormat.setInteger("frame-rate", i2);
                    createVideoFormat.setInteger("i-frame-interval", 10);
                    if (c.this.n != -1 && c.this.n < 40000) {
                        createVideoFormat.setInteger("bitrate-mode", 0);
                    }
                    Log.e("MCTranscoder", "inputvideoFormat=" + trackFormat);
                    Log.e("MCTranscoder", "outputVideoFormat=" + createVideoFormat);
                    AtomicReference<Surface> atomicReference = new AtomicReference<>();
                    this.b = a(eo, createVideoFormat, atomicReference);
                    if (this.b == null && c.this.n != -1 && c.this.n < 40000) {
                        MediaFormat createVideoFormat2 = MediaFormat.createVideoFormat("video/avc", c.this.g, c.this.h);
                        createVideoFormat2.setInteger("color-format", 2130708361);
                        if (c.this.n != -1 && c.this.n < 32000) {
                            i = c.this.g * c.this.h * 4 * 3;
                        }
                        createVideoFormat2.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i);
                        createVideoFormat2.setInteger("frame-rate", i2);
                        createVideoFormat2.setInteger("i-frame-interval", 10);
                        this.b = a(eo, createVideoFormat2, atomicReference);
                    }
                    if (this.b == null) {
                        com.baidu.media.transcoder.d.d("MCTranscoder", "createVideoEncoder error");
                        return -1103;
                    }
                    this.aIz = new com.baidu.media.transcoder.a.b(atomicReference.get());
                    this.aIz.a();
                    this.aIy = new com.baidu.media.transcoder.a.d();
                    this.c = a(trackFormat, this.aIy.a());
                    if (this.c == null) {
                        com.baidu.media.transcoder.d.d("MCTranscoder", "createVideoDecoder error");
                        return -1102;
                    }
                    this.aIo = this.c.getInputBuffers();
                    this.aIp = this.c.getOutputBuffers();
                    this.aIr = this.b.getOutputBuffers();
                    return 0;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "Video get buffers error");
                    return -1012;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.media.transcoder.d.d("MCTranscoder", "video get buffers unknown error.");
                    return -1013;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                com.baidu.media.transcoder.d.d("MCTranscoder", "createExtractor error");
                return -1003;
            } catch (Exception e4) {
                e4.printStackTrace();
                com.baidu.media.transcoder.d.d("MCTranscoder", "createExtractor unknown error.");
                return -1004;
            }
        }
    }

    public c() {
        com.baidu.media.transcoder.d.b("MCTranscoder", "MediaCodec decoder mode. SDK Version:" + getSDKVersion() + " Core Version:" + getCoreVersion());
        f();
    }

    private Message Bv() {
        Message message = null;
        synchronized (this.t) {
            if (this.u.isEmpty()) {
                try {
                    this.t.wait(1000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else {
                message = this.u.get(0);
                this.u.remove(0);
            }
        }
        return message;
    }

    private int a(String str) {
        File file = new File(str);
        com.baidu.media.transcoder.d.b("MCTranscoder", "createFile:" + str);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            return 0;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1000;
        } catch (Exception e3) {
            e3.printStackTrace();
            com.baidu.media.transcoder.d.d("MCTranscoder", "createFile unknown error.");
            return MessageConfig.ERROR_TASK_OUTTIME;
        }
    }

    private void a(boolean z) {
        b(3, z ? 1 : 0);
    }

    private void b(int i, int i2) {
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        synchronized (this.t) {
            this.u.add(message);
            this.t.notifyAll();
        }
    }

    private void b(boolean z) {
        b(4, z ? 1 : 0);
    }

    private boolean e() {
        if (this.g <= 0 || this.h <= 0) {
            if (this.aIg != null) {
                this.aIg.sendEmptyMessage(100);
            }
            return false;
        }
        return true;
    }

    static /* synthetic */ int f(c cVar) {
        int i = cVar.r;
        cVar.r = i + 1;
        return i;
    }

    private void f() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.aIg = new b(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.aIg = new b(this, mainLooper);
            } else {
                this.aIg = null;
            }
        }
        this.aIh = new e("MediaCodecTranscoder");
        this.aIh.start();
    }

    private int g() {
        com.baidu.media.transcoder.d.b("MCTranscoder", "initMedia ...");
        if (probe() == 0) {
            com.baidu.media.transcoder.d.b("MCTranscoder", "initMedia failed, android version is too low...");
            return -1002;
        }
        this.a = (int) new File(this.c).length();
        com.baidu.media.transcoder.d.d("MCTranscoder", "input file totalSize: " + this.a);
        this.aIj = new a();
        this.aIk = new f();
        this.aIj.a(this.aIl);
        this.aIk.a(this.aIl);
        if (this.aIj.a(false) < 0) {
            this.aIj.c();
            this.aIj = null;
            com.baidu.media.transcoder.d.c("MCTranscoder", "not found audio stream...");
        }
        int a2 = this.aIk.a(false);
        if (a2 < 0) {
            com.baidu.media.transcoder.d.b("MCTranscoder", "initVideo failed...");
            return a2;
        }
        try {
            this.aIi = new MediaMuxer(this.d, 0);
            return a2;
        } catch (IOException e2) {
            e2.printStackTrace();
            com.baidu.media.transcoder.d.b("MCTranscoder", "create MediaMuxer failed...");
            return -1005;
        } catch (Exception e3) {
            e3.printStackTrace();
            com.baidu.media.transcoder.d.d("MCTranscoder", "initMedia unknown error.");
            return -1006;
        }
    }

    private int h() {
        int a2;
        int f2;
        if (this.aIk.d() && (this.aIj == null || this.aIj.d())) {
            return 1002;
        }
        int f3 = this.aIk.f();
        if (f3 >= 0) {
            if (this.aIj == null || (f2 = this.aIj.f()) >= 0) {
                int a3 = this.aIk.a();
                if (a3 >= 0) {
                    if (this.aIj == null || (a2 = this.aIj.a()) >= 0) {
                        int g = this.aIk.g();
                        if (g < 0 || this.aIj == null) {
                            return g;
                        }
                        int g2 = this.aIj.g();
                        if (g2 < 0) {
                        }
                        return g2;
                    }
                    return a2;
                }
                return a3;
            }
            return f2;
        }
        return f3;
    }

    private int i() {
        com.baidu.media.transcoder.d.b("MCTranscoder", "onPrepared start...");
        int a2 = a(this.d);
        if (a2 < 0) {
            com.baidu.media.transcoder.d.b("MCTranscoder", "onPrepared createFile error:" + a2);
        } else {
            a2 = g();
            if (a2 < 0) {
            }
        }
        return a2;
    }

    private int j() {
        b(5, 0);
        return 0;
    }

    private int k() {
        return 0;
    }

    private int l() {
        try {
            if (this.aIj != null) {
                this.aIj.b();
                this.aIj = null;
            }
            if (this.aIk != null) {
                this.aIk.b();
                this.aIk = null;
            }
            if (this.aIi != null) {
                this.aIi.stop();
                this.aIi = null;
            }
            p();
            return 0;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            com.baidu.media.transcoder.d.d("MCTranscoder", "onStop IllegalStateException error.");
            return -1017;
        } catch (Exception e3) {
            e3.printStackTrace();
            com.baidu.media.transcoder.d.d("MCTranscoder", "onStop unknown error.");
            return -1018;
        }
    }

    private int m() {
        int i = 0;
        if (this.aIh != null) {
            this.aIh.a();
        }
        try {
            if (this.aIj != null) {
                this.aIj.c();
                this.aIj = null;
            }
            if (this.aIk != null) {
                this.aIk.c();
                this.aIk = null;
            }
            if (this.aIi != null) {
                this.aIi.release();
                this.aIi = null;
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            com.baidu.media.transcoder.d.d("MCTranscoder", "onRelease IllegalStateException error.");
            i = -1019;
        } catch (Exception e3) {
            e3.printStackTrace();
            com.baidu.media.transcoder.d.d("MCTranscoder", "onRelease unknown error.");
            return -1020;
        }
        p();
        return i;
    }

    private int n() {
        return h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o() {
        int i = 0;
        while (!this.s && (i = r()) >= 0 && i != 1002) {
        }
        return i;
    }

    private void p() {
        synchronized (this.t) {
            this.u.clear();
            this.t.notifyAll();
        }
    }

    private int r() {
        int i = 2;
        int i2 = 0;
        Message Bv = Bv();
        if (Bv != null) {
            switch (Bv.what) {
                case 0:
                    i2 = i();
                    i = 1;
                    break;
                case 1:
                    i2 = j();
                    i = 0;
                    break;
                case 2:
                    i2 = k();
                    i = 0;
                    break;
                case 3:
                    i2 = l();
                    if (Bv.arg1 != 0) {
                        i = 3;
                        break;
                    }
                    break;
                case 4:
                    i2 = m();
                    if (Bv.arg1 != 0) {
                        i = 3;
                        break;
                    }
                    break;
                case 5:
                    int n = n();
                    if (n == 1002) {
                        a(false);
                    } else if (n < 0) {
                        m();
                        i2 = n;
                        i = 0;
                        break;
                    } else {
                        b(5, 0);
                    }
                    i2 = 1000;
                    i = 0;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (i2 < 0) {
                Message message = new Message();
                message.what = 100;
                message.arg1 = i2;
                this.aIg.sendMessage(message);
            } else if (i != 0) {
                this.aIg.sendEmptyMessage(i);
            }
        }
        return i2;
    }

    public String getCoreVersion() {
        return null;
    }

    public String getSDKVersion() {
        return "1.0.2.153";
    }

    @Override // com.baidu.media.transcoder.a
    public void prepareAsync() {
        if (e()) {
            b(0, 0);
        }
    }

    @Override // com.baidu.media.transcoder.a
    public int probe() {
        return !com.baidu.media.transcoder.a.a.a() ? 0 : 100;
    }

    @Override // com.baidu.media.transcoder.a
    public void release() {
        b(true);
    }

    @Override // com.baidu.media.transcoder.a
    public void setDataSource(String str) {
        this.c = str;
    }

    @Override // com.baidu.media.transcoder.a
    public void setNativeLogLevel(int i) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.media.transcoder.a
    public void setOption(String str, String str2) {
        char c = 0;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            switch (str.hashCode()) {
                case -1992012396:
                    if (str.equals("duration")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 114:
                    if (str.equals("r")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 115:
                    if (str.equals("s")) {
                        break;
                    }
                    c = 65535;
                    break;
                case 3106:
                    if (str.equals("ac")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3121:
                    if (str.equals("ar")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 96073:
                    if (str.equals("b:a")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 96094:
                    if (str.equals("b:v")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    String[] split = str2.split(Config.EVENT_HEAT_X);
                    if (split.length == 2) {
                        this.g = (Integer.parseInt(split[0]) / 2) * 2;
                        this.h = (Integer.parseInt(split[1]) / 2) * 2;
                        return;
                    }
                    return;
                case 1:
                    this.i = Integer.parseInt(str2);
                    return;
                case 2:
                    this.j = Integer.parseInt(str2);
                    return;
                case 3:
                    this.l = Integer.parseInt(str2);
                    return;
                case 4:
                    this.k = Integer.parseInt(str2);
                    return;
                case 5:
                    this.m = Integer.parseInt(str2);
                    return;
                case 6:
                    this.n = Integer.parseInt(str2);
                    return;
                default:
                    return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.media.transcoder.a
    public void setOutputFile(String str) {
        this.d = str;
    }

    @Override // com.baidu.media.transcoder.a
    public void start() {
        b(1, 0);
    }

    @Override // com.baidu.media.transcoder.a
    public void stop() {
        a(true);
    }
}
