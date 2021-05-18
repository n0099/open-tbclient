package com.baidu.media.recorder;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.media.duplayer.Keep;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class DuAudioRecorder extends CyberAudioRecorder {
    public static ArrayList<String> u;

    /* renamed from: a  reason: collision with root package name */
    public CyberAudioRecorder.OnPreparedListener f8114a;

    /* renamed from: b  reason: collision with root package name */
    public CyberAudioRecorder.OnCompletionListener f8115b;

    /* renamed from: c  reason: collision with root package name */
    public CyberAudioRecorder.OnErrorListener f8116c;

    /* renamed from: d  reason: collision with root package name */
    public CyberAudioRecorder.OnInfoListener f8117d;

    /* renamed from: e  reason: collision with root package name */
    public CyberAudioRecorder.OnEncBufferCallbackListener f8118e;

    /* renamed from: f  reason: collision with root package name */
    public ByteBuffer f8119f;

    /* renamed from: g  reason: collision with root package name */
    public long f8120g;

    /* renamed from: h  reason: collision with root package name */
    public long f8121h;

    /* renamed from: i  reason: collision with root package name */
    public long f8122i;
    public int j;
    public int k;
    public int l;
    public int m;
    @Keep
    public b mEventHandler;
    @Keep
    public long mNativeContext;
    public int n;
    public ExecutorService o = null;
    public AudioRecord p = null;
    public final Object q = new Object();
    public d.a.w.d.a r = new d.a.w.d.a();
    public Map<String, String> s = new HashMap();
    public Map<String, Long> t = new HashMap();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DuAudioRecorder.this.l();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<DuAudioRecorder> f8124a;

        public b(DuAudioRecorder duAudioRecorder, Looper looper) {
            super(looper);
            this.f8124a = new WeakReference<>(duAudioRecorder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DuAudioRecorder duAudioRecorder = this.f8124a.get();
            if (duAudioRecorder == null || duAudioRecorder.mNativeContext == 0) {
                return;
            }
            int i2 = message.what;
            if (i2 == -1) {
                synchronized (DuAudioRecorder.this.q) {
                    DuAudioRecorder.this.r.b(2);
                    DuAudioRecorder.this.q.notifyAll();
                }
                if (DuAudioRecorder.this.f8116c != null) {
                    DuAudioRecorder.this.f8116c.onError(message.arg1, message.arg2, message.obj);
                }
            } else if (i2 == 0) {
                if (DuAudioRecorder.this.f8117d != null) {
                    DuAudioRecorder.this.f8117d.onInfo(message.arg1, message.arg2, message.obj);
                }
            } else if (i2 == 1) {
                DuAudioRecorder.this.nativeStart();
                synchronized (DuAudioRecorder.this.q) {
                    DuAudioRecorder.this.r.b(32);
                    DuAudioRecorder.this.q.notifyAll();
                }
                if (DuAudioRecorder.this.f8114a != null) {
                    DuAudioRecorder.this.f8114a.onPrepared();
                }
            } else if (i2 == 2) {
                if (DuAudioRecorder.this.f8115b != null) {
                    DuAudioRecorder.this.f8115b.onCompletion();
                }
            } else if (i2 == 3 && DuAudioRecorder.this.f8118e != null) {
                DuAudioRecorder.this.f8118e.onFrameRecorded(DuAudioRecorder.this.f8119f, message.arg2, (message.arg1 == 1 ? Boolean.TRUE : Boolean.FALSE).booleanValue());
                DuAudioRecorder.this.f8119f.rewind();
                DuAudioRecorder.this.nativeHandledMsgCallback();
            }
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        u = arrayList;
        arrayList.add("mp3");
        u.add("aac");
    }

    public DuAudioRecorder() {
        b bVar = null;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            bVar = new b(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                bVar = new b(this, mainLooper);
            }
        }
        this.mEventHandler = bVar;
        nativeSetup(new WeakReference(this));
        this.r.b(8);
        j();
    }

    private native int nativeEncodePCM(byte[] bArr, int i2, int i3);

    public static native int nativeGetBytesPerSample(int i2);

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
    public static int postEventFromNative(Object obj, int i2, int i3, int i4, Object obj2) {
        DuAudioRecorder duAudioRecorder;
        if (obj == null || (duAudioRecorder = (DuAudioRecorder) ((WeakReference) obj).get()) == null) {
            return -1;
        }
        if (duAudioRecorder.mEventHandler != null) {
            synchronized (duAudioRecorder.q) {
                if (duAudioRecorder.r.a() == 4) {
                    duAudioRecorder.mEventHandler.removeCallbacksAndMessages(null);
                    duAudioRecorder.nativeHandledMsgCallback();
                } else {
                    duAudioRecorder.mEventHandler.sendMessage(duAudioRecorder.mEventHandler.obtainMessage(i2, i3, i4, obj2));
                }
            }
            return 0;
        }
        return 0;
    }

    public final int a(int i2, int i3, Object obj) {
        b bVar = this.mEventHandler;
        if (bVar != null) {
            this.mEventHandler.sendMessage(bVar.obtainMessage(-1, i2, i3, obj));
            return 1;
        }
        return 0;
    }

    public final int b(byte[] bArr, int i2, int i3) {
        long j = this.f8121h;
        if (j > 0) {
            int nativeEncodePCM = nativeEncodePCM(bArr, i2, (int) Math.min(j, i3));
            this.f8121h -= nativeEncodePCM;
            return nativeEncodePCM;
        } else if (j == 0) {
            stop();
            return 0;
        } else {
            return nativeEncodePCM(bArr, i2, i3);
        }
    }

    public final void c() {
        Map<String, String> map = this.s;
        if (map != null) {
            for (String str : map.keySet()) {
                nativeSetParameter(str, this.s.get(str));
            }
        }
        Map<String, Long> map2 = this.t;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                long longValue = this.t.get(str2).longValue();
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case -2122425275:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_ENC_CALLBACK_MAX_SIZE)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -270843446:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_IN_CHANNEL_NB)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 72508987:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_IN_SAMPLE_RATE)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 354717054:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_IN_AUDIO_SOURCE)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 949632340:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_ENC_MAX_DURATION)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1803443154:
                        if (str2.equals(CyberAudioRecorder.KEY_INT_IN_SAMPLE_FORMAT)) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    this.f8120g = longValue;
                } else if (c2 == 1) {
                    this.f8122i = longValue * 1024;
                } else if (c2 == 2) {
                    this.m = (int) longValue;
                } else if (c2 == 3) {
                    this.k = (int) longValue;
                } else if (c2 == 4) {
                    this.j = (int) longValue;
                } else if (c2 != 5) {
                    nativeSetParameter(str2, longValue);
                } else {
                    this.l = (int) longValue;
                }
            }
        }
    }

    public final void f() {
        int i2;
        int i3 = this.l;
        if (i3 == 1) {
            i2 = 16;
        } else if (i3 != 2) {
            throw new IllegalArgumentException("KEY_INT_IN_CHANNEL_NB only support 1 or 2");
        } else {
            i2 = 12;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(this.j, i2, this.k);
        this.n = minBufferSize;
        if (minBufferSize < 0) {
            throw new IllegalArgumentException("AudioRecord.getMinBufferSize error");
        }
        AudioRecord audioRecord = new AudioRecord(this.m, this.j, i2, this.k, this.n);
        this.p = audioRecord;
        this.l = audioRecord.getChannelCount();
        this.k = this.p.getAudioFormat();
        this.j = this.p.getSampleRate();
        nativeSetParameter(CyberAudioRecorder.KEY_INT_IN_CHANNEL_NB, this.l);
        nativeSetParameter(CyberAudioRecorder.KEY_INT_IN_SAMPLE_FORMAT, this.k);
        nativeSetParameter(CyberAudioRecorder.KEY_INT_IN_SAMPLE_RATE, this.j);
        long j = this.f8120g;
        if (j > 0) {
            long nativeGetBytesPerSample = j * this.l * this.j * nativeGetBytesPerSample(this.k);
            this.f8121h = nativeGetBytesPerSample;
            if (nativeGetBytesPerSample == 0) {
                CyberLog.w("DuAudioRecorder", "KEY_INT_ENC_MAX_DURATION Invalidation");
                this.f8121h = -1L;
            }
        }
        long j2 = this.f8122i;
        if (j2 > 0) {
            ByteBuffer order = ByteBuffer.allocateDirect((int) j2).order(ByteOrder.nativeOrder());
            this.f8119f = order;
            nativeSetEncCallbackCacheBuffer(order);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public ArrayList<String> getSupportEncoder() {
        return u;
    }

    public final void h() {
        AudioRecord audioRecord = this.p;
        if (audioRecord != null) {
            audioRecord.release();
            this.p = null;
        }
        j();
    }

    public final void j() {
        this.f8119f = null;
        this.f8120g = 0L;
        this.f8121h = -1L;
        this.j = SwanAudioPlayer.DEFAULT_SAMPLE_RATE;
        this.k = 1;
        this.l = 1;
        this.m = 0;
        this.n = 0;
    }

    public final void l() {
        String str;
        String str2;
        int read;
        CyberLog.d("DuAudioRecorder", "doRecord in");
        try {
            c();
            f();
            nativePrepare();
            byte[] bArr = new byte[this.n];
            while (true) {
                if (this.r.a() != 64) {
                    synchronized (this.q) {
                        int a2 = this.r.a();
                        if (a2 == 256 || a2 == 4) {
                            break;
                        } else if (a2 != 64) {
                            try {
                                this.q.wait();
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } else if (this.p.getRecordingState() == 3 && (read = this.p.read(bArr, 0, this.n)) > 0) {
                    b(bArr, 0, read);
                }
            }
            nativeStop();
            h();
            str = "DuAudioRecorder";
            str2 = "doRecord out";
        } catch (IllegalArgumentException e3) {
            b bVar = this.mEventHandler;
            if (bVar != null) {
                this.mEventHandler.sendMessage(bVar.obtainMessage(-1, -1, -1, e3.toString()));
            }
            h();
            str = "DuAudioRecorder";
            str2 = "doRecord error";
        }
        CyberLog.d(str, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void pause() {
        synchronized (this.q) {
            int b2 = this.r.b(128);
            if (b2 > 0) {
                this.p.stop();
            } else if (b2 < 0) {
                CyberLog.d("DuAudioRecorder", "pause() called on an error status:" + this.r.a());
                a(-1, -1, "pause() called on an error status:" + this.r.a());
            }
            CyberLog.d("DuAudioRecorder", "pause:" + this.r.a() + "ret:" + b2);
            this.q.notifyAll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void prepare() {
        CyberLog.d("DuAudioRecorder", "prepare in");
        synchronized (this.q) {
            if (this.r.b(16) > 0) {
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                this.o = newSingleThreadExecutor;
                newSingleThreadExecutor.submit(new a());
            } else {
                CyberLog.d("DuAudioRecorder", "prepare() called on an error status:" + this.r.a());
                a(-1, -1, "prepare() called on an error status:" + this.r.a());
            }
        }
        CyberLog.d("DuAudioRecorder", "prepare out");
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void release() {
        CyberLog.d("DuAudioRecorder", "release in");
        synchronized (this.q) {
            this.r.b(4);
            this.q.notifyAll();
        }
        this.mEventHandler.removeCallbacksAndMessages(null);
        nativeHandledMsgCallback();
        ExecutorService executorService = this.o;
        if (executorService != null) {
            try {
                if (!executorService.isShutdown()) {
                    this.o.shutdown();
                }
                this.o.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
                this.o = null;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        nativeRelease();
        CyberLog.d("DuAudioRecorder", "release out");
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnCompletionListener(CyberAudioRecorder.OnCompletionListener onCompletionListener) {
        this.f8115b = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnEncBufferListener(CyberAudioRecorder.OnEncBufferCallbackListener onEncBufferCallbackListener) {
        this.f8118e = onEncBufferCallbackListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnErrorListener(CyberAudioRecorder.OnErrorListener onErrorListener) {
        this.f8116c = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnInfoListener(CyberAudioRecorder.OnInfoListener onInfoListener) {
        this.f8117d = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnPreparedListener(CyberAudioRecorder.OnPreparedListener onPreparedListener) {
        this.f8114a = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setParameter(String str, long j) {
        this.t.put(str, Long.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setParameter(String str, String str2) {
        this.s.put(str, str2);
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void start() {
        synchronized (this.q) {
            int b2 = this.r.b(64);
            if (b2 > 0) {
                this.p.startRecording();
            } else if (b2 < 0) {
                CyberLog.d("DuAudioRecorder", "start() called on an error status:" + this.r.a());
                a(-1, -1, "start() called on an error status:" + this.r.a());
            }
            CyberLog.d("DuAudioRecorder", "start:" + this.r.a() + "ret:" + b2);
            this.q.notifyAll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void stop() {
        synchronized (this.q) {
            if (this.r.b(256) > 0 && this.o != null) {
                CyberLog.d("DuAudioRecorder", "stop in");
                this.o.shutdown();
                CyberLog.d("DuAudioRecorder", "stop out");
            }
            this.q.notifyAll();
        }
    }
}
