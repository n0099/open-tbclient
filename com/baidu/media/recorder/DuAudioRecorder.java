package com.baidu.media.recorder;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.ala.player.StreamConfig;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.media.duplayer.Keep;
import com.google.android.exoplayer2.Format;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class DuAudioRecorder extends CyberAudioRecorder {
    private static ArrayList<String> r = new ArrayList<>();
    private CyberAudioRecorder.OnPreparedListener aMh;
    private CyberAudioRecorder.OnCompletionListener aMi;
    private CyberAudioRecorder.OnErrorListener aMj;
    private CyberAudioRecorder.OnInfoListener aMk;
    private CyberAudioRecorder.OnEncBufferCallbackListener aMl;
    private ByteBuffer aMm;
    private long g;
    private long h;
    private long i;
    private int j;
    private int k;
    private int l;
    private int m;
    @Keep
    private a mEventHandler;
    @Keep
    private long mNativeContext;
    private int n;
    private ExecutorService aMn = null;
    private AudioRecord aMo = null;
    private final Object q = new Object();
    private com.baidu.media.recorder.a aMp = new com.baidu.media.recorder.a();
    private Map<String, String> aMq = new HashMap();
    private Map<String, Long> aMr = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private final WeakReference<DuAudioRecorder> b;

        public a(DuAudioRecorder duAudioRecorder, Looper looper) {
            super(looper);
            this.b = new WeakReference<>(duAudioRecorder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DuAudioRecorder duAudioRecorder = this.b.get();
            if (duAudioRecorder == null || duAudioRecorder.mNativeContext == 0) {
                return;
            }
            switch (message.what) {
                case -1:
                    synchronized (DuAudioRecorder.this.q) {
                        DuAudioRecorder.this.aMp.a(2);
                        DuAudioRecorder.this.q.notifyAll();
                    }
                    if (DuAudioRecorder.this.aMj != null) {
                        DuAudioRecorder.this.aMj.onError(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 0:
                    if (DuAudioRecorder.this.aMk != null) {
                        DuAudioRecorder.this.aMk.onInfo(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 1:
                    DuAudioRecorder.this.nativeStart();
                    synchronized (DuAudioRecorder.this.q) {
                        DuAudioRecorder.this.aMp.a(32);
                        DuAudioRecorder.this.q.notifyAll();
                    }
                    if (DuAudioRecorder.this.aMh != null) {
                        DuAudioRecorder.this.aMh.onPrepared();
                        return;
                    }
                    return;
                case 2:
                    if (DuAudioRecorder.this.aMi != null) {
                        DuAudioRecorder.this.aMi.onCompletion();
                        return;
                    }
                    return;
                case 3:
                    if (DuAudioRecorder.this.aMl != null) {
                        DuAudioRecorder.this.aMl.onFrameRecorded(DuAudioRecorder.this.aMm, message.arg2, (message.arg1 == 1).booleanValue());
                        DuAudioRecorder.this.aMm.rewind();
                        DuAudioRecorder.this.nativeHandledMsgCallback();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static {
        r.add("mp3");
        r.add("aac");
    }

    public DuAudioRecorder() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new a(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new a(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        nativeSetup(new WeakReference(this));
        this.aMp.a(8);
        d();
    }

    private int a(byte[] bArr, int i, int i2) {
        if (this.h > 0) {
            int nativeEncodePCM = nativeEncodePCM(bArr, i, (int) Math.min(this.h, i2));
            this.h -= nativeEncodePCM;
            return nativeEncodePCM;
        } else if (this.h == 0) {
            stop();
            return 0;
        } else {
            return nativeEncodePCM(bArr, i, i2);
        }
    }

    private void a() {
        if (this.aMq != null) {
            for (String str : this.aMq.keySet()) {
                nativeSetParameter(str, this.aMq.get(str));
            }
        }
        if (this.aMr != null) {
            for (String str2 : this.aMr.keySet()) {
                long longValue = this.aMr.get(str2).longValue();
                char c = 65535;
                switch (str2.hashCode()) {
                    case -2122425275:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_ENC_CALLBACK_MAX_SIZE)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -270843446:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_IN_CHANNEL_NB)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 72508987:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_IN_SAMPLE_RATE)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 354717054:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_IN_AUDIO_SOURCE)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 949632340:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_ENC_MAX_DURATION)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1803443154:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_IN_SAMPLE_FORMAT)) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.g = longValue;
                        break;
                    case 1:
                        this.i = 1024 * longValue;
                        break;
                    case 2:
                        this.m = (int) longValue;
                        break;
                    case 3:
                        this.k = (int) longValue;
                        break;
                    case 4:
                        this.j = (int) longValue;
                        break;
                    case 5:
                        this.l = (int) longValue;
                        break;
                    default:
                        nativeSetParameter(str2, longValue);
                        break;
                }
            }
        }
    }

    private void b() {
        int i;
        if (this.l == 1) {
            i = 16;
        } else if (this.l != 2) {
            throw new IllegalArgumentException("KEY_INT_IN_CHANNEL_NB only support 1 or 2");
        } else {
            i = 12;
        }
        this.n = AudioRecord.getMinBufferSize(this.j, i, this.k);
        if (this.n < 0) {
            throw new IllegalArgumentException("AudioRecord.getMinBufferSize error");
        }
        this.aMo = new AudioRecord(this.m, this.j, i, this.k, this.n);
        this.l = this.aMo.getChannelCount();
        this.k = this.aMo.getAudioFormat();
        this.j = this.aMo.getSampleRate();
        nativeSetParameter(CyberAudioRecorder.KEY_INT_IN_CHANNEL_NB, this.l);
        nativeSetParameter(CyberAudioRecorder.KEY_INT_IN_SAMPLE_FORMAT, this.k);
        nativeSetParameter(CyberAudioRecorder.KEY_INT_IN_SAMPLE_RATE, this.j);
        if (this.g > 0) {
            this.h = this.g * this.l * this.j * nativeGetBytesPerSample(this.k);
            if (this.h == 0) {
                CyberLog.w("DuAudioRecorder", "KEY_INT_ENC_MAX_DURATION Invalidation");
                this.h = -1L;
            }
        }
        if (this.i > 0) {
            this.aMm = ByteBuffer.allocateDirect((int) this.i).order(ByteOrder.nativeOrder());
            nativeSetEncCallbackCacheBuffer(this.aMm);
        }
    }

    private void c() {
        if (this.aMo != null) {
            this.aMo.release();
            this.aMo = null;
        }
        d();
    }

    private void d() {
        this.aMm = null;
        this.g = 0L;
        this.h = -1L;
        this.j = StreamConfig.Audio.AUDIO_FREQUENCY;
        this.k = 1;
        this.l = 1;
        this.m = 0;
        this.n = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int read;
        CyberLog.d("DuAudioRecorder", "doRecord in");
        try {
            a();
            b();
            nativePrepare();
            byte[] bArr = new byte[this.n];
            while (true) {
                if (this.aMp.a() != 64) {
                    synchronized (this.q) {
                        int a2 = this.aMp.a();
                        if (a2 == 256 || a2 == 4) {
                            break;
                        } else if (a2 != 64) {
                            try {
                                this.q.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else if (this.aMo.getRecordingState() == 3 && (read = this.aMo.read(bArr, 0, this.n)) > 0) {
                    a(bArr, 0, read);
                }
            }
            nativeStop();
            c();
            CyberLog.d("DuAudioRecorder", "doRecord out");
        } catch (IllegalArgumentException e2) {
            if (this.mEventHandler != null) {
                this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(-1, -1, -1, e2.toString()));
            }
            c();
            CyberLog.d("DuAudioRecorder", "doRecord error");
        }
    }

    private native int nativeEncodePCM(byte[] bArr, int i, int i2);

    private static native int nativeGetBytesPerSample(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeHandledMsgCallback();

    private native void nativePrepare();

    private native void nativeRelease();

    private native void nativeSetEncCallbackCacheBuffer(ByteBuffer byteBuffer);

    private native void nativeSetParameter(String str, long j);

    private native void nativeSetParameter(String str, String str2);

    private native void nativeSetup(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStart();

    private native void nativeStop();

    @Keep
    private static int postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        DuAudioRecorder duAudioRecorder;
        if (obj != null && (duAudioRecorder = (DuAudioRecorder) ((WeakReference) obj).get()) != null) {
            if (duAudioRecorder.mEventHandler != null) {
                synchronized (duAudioRecorder.q) {
                    if (duAudioRecorder.aMp.a() == 4) {
                        duAudioRecorder.mEventHandler.removeCallbacksAndMessages(null);
                        duAudioRecorder.nativeHandledMsgCallback();
                    } else {
                        duAudioRecorder.mEventHandler.sendMessage(duAudioRecorder.mEventHandler.obtainMessage(i, i2, i3, obj2));
                    }
                }
            }
            return 0;
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public ArrayList<String> getSupportEncoder() {
        return r;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void pause() {
        synchronized (this.q) {
            int a2 = this.aMp.a(128);
            if (a2 > 0) {
                this.aMo.stop();
            } else if (a2 < 0) {
                CyberLog.d("DuAudioRecorder", "pause() called on an error status:" + this.aMp.a());
                throw new IllegalArgumentException("start() called on an error status:" + this.aMp.a());
            }
            CyberLog.d("DuAudioRecorder", "pause:" + this.aMp.a() + "ret:" + a2);
            this.q.notifyAll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void prepare() {
        CyberLog.d("DuAudioRecorder", "prepare in");
        synchronized (this.q) {
            if (this.aMp.a(16) <= 0) {
                CyberLog.d("DuAudioRecorder", "prepare() called on an error status:" + this.aMp.a());
                throw new IllegalArgumentException("prepare() called on an error status:" + this.aMp.a());
            } else {
                this.aMn = Executors.newSingleThreadExecutor();
                this.aMn.submit(new Runnable() { // from class: com.baidu.media.recorder.DuAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DuAudioRecorder.this.e();
                    }
                });
            }
        }
        CyberLog.d("DuAudioRecorder", "prepare out");
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void release() {
        CyberLog.d("DuAudioRecorder", "release in");
        synchronized (this.q) {
            this.aMp.a(4);
            this.q.notifyAll();
        }
        this.mEventHandler.removeCallbacksAndMessages(null);
        nativeHandledMsgCallback();
        if (this.aMn != null) {
            try {
                if (!this.aMn.isShutdown()) {
                    this.aMn.shutdown();
                }
                this.aMn.awaitTermination(Format.OFFSET_SAMPLE_RELATIVE, TimeUnit.DAYS);
                this.aMn = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nativeRelease();
        CyberLog.d("DuAudioRecorder", "release out");
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnCompletionListener(CyberAudioRecorder.OnCompletionListener onCompletionListener) {
        this.aMi = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnEncBufferListener(CyberAudioRecorder.OnEncBufferCallbackListener onEncBufferCallbackListener) {
        this.aMl = onEncBufferCallbackListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnErrorListener(CyberAudioRecorder.OnErrorListener onErrorListener) {
        this.aMj = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnInfoListener(CyberAudioRecorder.OnInfoListener onInfoListener) {
        this.aMk = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnPreparedListener(CyberAudioRecorder.OnPreparedListener onPreparedListener) {
        this.aMh = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setParameter(String str, long j) {
        this.aMr.put(str, Long.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setParameter(String str, String str2) {
        this.aMq.put(str, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void start() {
        synchronized (this.q) {
            int a2 = this.aMp.a(64);
            if (a2 > 0) {
                this.aMo.startRecording();
            } else if (a2 < 0) {
                CyberLog.d("DuAudioRecorder", "start() called on an error status:" + this.aMp.a());
                throw new IllegalArgumentException("start() called on an error status:" + this.aMp.a());
            }
            CyberLog.d("DuAudioRecorder", "start:" + this.aMp.a() + "ret:" + a2);
            this.q.notifyAll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void stop() {
        synchronized (this.q) {
            if (this.aMp.a(256) > 0 && this.aMn != null) {
                CyberLog.d("DuAudioRecorder", "stop in");
                this.aMn.shutdown();
                CyberLog.d("DuAudioRecorder", "stop out");
            }
            this.q.notifyAll();
        }
    }
}
