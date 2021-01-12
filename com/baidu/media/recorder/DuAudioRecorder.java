package com.baidu.media.recorder;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.media.duplayer.Keep;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes14.dex */
public class DuAudioRecorder extends CyberAudioRecorder {
    private static ArrayList<String> r = new ArrayList<>();
    private CyberAudioRecorder.OnPreparedListener ceu;
    private CyberAudioRecorder.OnCompletionListener cev;
    private CyberAudioRecorder.OnErrorListener cew;
    private CyberAudioRecorder.OnInfoListener cex;
    private CyberAudioRecorder.OnEncBufferCallbackListener cey;
    private ByteBuffer cez;
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
    private ExecutorService ceA = null;
    private AudioRecord ceB = null;
    private final Object q = new Object();
    private com.baidu.media.recorder.a ceC = new com.baidu.media.recorder.a();
    private Map<String, String> t = new HashMap();
    private Map<String, Long> ceD = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<DuAudioRecorder> f3213b;

        public a(DuAudioRecorder duAudioRecorder, Looper looper) {
            super(looper);
            this.f3213b = new WeakReference<>(duAudioRecorder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DuAudioRecorder duAudioRecorder = this.f3213b.get();
            if (duAudioRecorder == null || duAudioRecorder.mNativeContext == 0) {
                return;
            }
            switch (message.what) {
                case -1:
                    synchronized (DuAudioRecorder.this.q) {
                        DuAudioRecorder.this.ceC.a(2);
                        DuAudioRecorder.this.q.notifyAll();
                    }
                    if (DuAudioRecorder.this.cew != null) {
                        DuAudioRecorder.this.cew.onError(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 0:
                    if (DuAudioRecorder.this.cex != null) {
                        DuAudioRecorder.this.cex.onInfo(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 1:
                    DuAudioRecorder.this.nativeStart();
                    synchronized (DuAudioRecorder.this.q) {
                        DuAudioRecorder.this.ceC.a(32);
                        DuAudioRecorder.this.q.notifyAll();
                    }
                    if (DuAudioRecorder.this.ceu != null) {
                        DuAudioRecorder.this.ceu.onPrepared();
                        return;
                    }
                    return;
                case 2:
                    if (DuAudioRecorder.this.cev != null) {
                        DuAudioRecorder.this.cev.onCompletion();
                        return;
                    }
                    return;
                case 3:
                    if (DuAudioRecorder.this.cey != null) {
                        DuAudioRecorder.this.cey.onFrameRecorded(DuAudioRecorder.this.cez, message.arg2, (message.arg1 == 1).booleanValue());
                        DuAudioRecorder.this.cez.rewind();
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
        this.ceC.a(8);
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
        if (this.t != null) {
            for (String str : this.t.keySet()) {
                nativeSetParameter(str, this.t.get(str));
            }
        }
        if (this.ceD != null) {
            for (String str2 : this.ceD.keySet()) {
                long longValue = this.ceD.get(str2).longValue();
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
        this.ceB = new AudioRecord(this.m, this.j, i, this.k, this.n);
        this.l = this.ceB.getChannelCount();
        this.k = this.ceB.getAudioFormat();
        this.j = this.ceB.getSampleRate();
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
            this.cez = ByteBuffer.allocateDirect((int) this.i).order(ByteOrder.nativeOrder());
            nativeSetEncCallbackCacheBuffer(this.cez);
        }
    }

    private void c() {
        if (this.ceB != null) {
            this.ceB.release();
            this.ceB = null;
        }
        d();
    }

    private int d(int i, int i2, Object obj) {
        if (this.mEventHandler != null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(-1, i, i2, obj));
            return 1;
        }
        return 0;
    }

    private void d() {
        this.cez = null;
        this.g = 0L;
        this.h = -1L;
        this.j = 44100;
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
                if (this.ceC.a() != 64) {
                    synchronized (this.q) {
                        int a2 = this.ceC.a();
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
                } else if (this.ceB.getRecordingState() == 3 && (read = this.ceB.read(bArr, 0, this.n)) > 0) {
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
                    if (duAudioRecorder.ceC.a() == 4) {
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
            int a2 = this.ceC.a(128);
            if (a2 > 0) {
                this.ceB.stop();
            } else if (a2 < 0) {
                CyberLog.d("DuAudioRecorder", "pause() called on an error status:" + this.ceC.a());
                d(-1, -1, "pause() called on an error status:" + this.ceC.a());
            }
            CyberLog.d("DuAudioRecorder", "pause:" + this.ceC.a() + "ret:" + a2);
            this.q.notifyAll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void prepare() {
        CyberLog.d("DuAudioRecorder", "prepare in");
        synchronized (this.q) {
            if (this.ceC.a(16) > 0) {
                this.ceA = Executors.newSingleThreadExecutor();
                this.ceA.submit(new Runnable() { // from class: com.baidu.media.recorder.DuAudioRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DuAudioRecorder.this.e();
                    }
                });
            } else {
                CyberLog.d("DuAudioRecorder", "prepare() called on an error status:" + this.ceC.a());
                d(-1, -1, "prepare() called on an error status:" + this.ceC.a());
            }
        }
        CyberLog.d("DuAudioRecorder", "prepare out");
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void release() {
        CyberLog.d("DuAudioRecorder", "release in");
        synchronized (this.q) {
            this.ceC.a(4);
            this.q.notifyAll();
        }
        this.mEventHandler.removeCallbacksAndMessages(null);
        nativeHandledMsgCallback();
        if (this.ceA != null) {
            try {
                if (!this.ceA.isShutdown()) {
                    this.ceA.shutdown();
                }
                this.ceA.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
                this.ceA = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nativeRelease();
        CyberLog.d("DuAudioRecorder", "release out");
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnCompletionListener(CyberAudioRecorder.OnCompletionListener onCompletionListener) {
        this.cev = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnEncBufferListener(CyberAudioRecorder.OnEncBufferCallbackListener onEncBufferCallbackListener) {
        this.cey = onEncBufferCallbackListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnErrorListener(CyberAudioRecorder.OnErrorListener onErrorListener) {
        this.cew = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnInfoListener(CyberAudioRecorder.OnInfoListener onInfoListener) {
        this.cex = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnPreparedListener(CyberAudioRecorder.OnPreparedListener onPreparedListener) {
        this.ceu = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setParameter(String str, long j) {
        this.ceD.put(str, Long.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setParameter(String str, String str2) {
        this.t.put(str, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void start() {
        synchronized (this.q) {
            int a2 = this.ceC.a(64);
            if (a2 > 0) {
                this.ceB.startRecording();
            } else if (a2 < 0) {
                CyberLog.d("DuAudioRecorder", "start() called on an error status:" + this.ceC.a());
                d(-1, -1, "start() called on an error status:" + this.ceC.a());
            }
            CyberLog.d("DuAudioRecorder", "start:" + this.ceC.a() + "ret:" + a2);
            this.q.notifyAll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void stop() {
        synchronized (this.q) {
            if (this.ceC.a(256) > 0 && this.ceA != null) {
                CyberLog.d("DuAudioRecorder", "stop in");
                this.ceA.shutdown();
                CyberLog.d("DuAudioRecorder", "stop out");
            }
            this.q.notifyAll();
        }
    }
}
