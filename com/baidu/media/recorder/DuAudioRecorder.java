package com.baidu.media.recorder;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.media.duplayer.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class DuAudioRecorder extends CyberAudioRecorder {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<String> u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CyberAudioRecorder.OnPreparedListener f42544a;

    /* renamed from: b  reason: collision with root package name */
    public CyberAudioRecorder.OnCompletionListener f42545b;

    /* renamed from: c  reason: collision with root package name */
    public CyberAudioRecorder.OnErrorListener f42546c;

    /* renamed from: d  reason: collision with root package name */
    public CyberAudioRecorder.OnInfoListener f42547d;

    /* renamed from: e  reason: collision with root package name */
    public CyberAudioRecorder.OnEncBufferCallbackListener f42548e;

    /* renamed from: f  reason: collision with root package name */
    public ByteBuffer f42549f;

    /* renamed from: g  reason: collision with root package name */
    public long f42550g;

    /* renamed from: h  reason: collision with root package name */
    public long f42551h;

    /* renamed from: i  reason: collision with root package name */
    public long f42552i;

    /* renamed from: j  reason: collision with root package name */
    public int f42553j;
    public int k;
    public int l;
    public int m;
    @Keep
    public b mEventHandler;
    @Keep
    public long mNativeContext;
    public int n;
    public ExecutorService o;
    public AudioRecord p;
    public final Object q;
    public c.a.z.e.a r;
    public Map<String, String> s;
    public Map<String, Long> t;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DuAudioRecorder f42554e;

        public a(DuAudioRecorder duAudioRecorder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duAudioRecorder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42554e = duAudioRecorder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42554e.l();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<DuAudioRecorder> f42555a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DuAudioRecorder f42556b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DuAudioRecorder duAudioRecorder, DuAudioRecorder duAudioRecorder2, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duAudioRecorder, duAudioRecorder2, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42556b = duAudioRecorder;
            this.f42555a = new WeakReference<>(duAudioRecorder2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DuAudioRecorder duAudioRecorder;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (duAudioRecorder = this.f42555a.get()) == null || duAudioRecorder.mNativeContext == 0) {
                return;
            }
            int i2 = message.what;
            if (i2 == -1) {
                synchronized (this.f42556b.q) {
                    this.f42556b.r.b(2);
                    this.f42556b.q.notifyAll();
                }
                if (this.f42556b.f42546c != null) {
                    this.f42556b.f42546c.onError(message.arg1, message.arg2, message.obj);
                }
            } else if (i2 == 0) {
                if (this.f42556b.f42547d != null) {
                    this.f42556b.f42547d.onInfo(message.arg1, message.arg2, message.obj);
                }
            } else if (i2 == 1) {
                this.f42556b.nativeStart();
                synchronized (this.f42556b.q) {
                    this.f42556b.r.b(32);
                    this.f42556b.q.notifyAll();
                }
                if (this.f42556b.f42544a != null) {
                    this.f42556b.f42544a.onPrepared();
                }
            } else if (i2 == 2) {
                if (this.f42556b.f42545b != null) {
                    this.f42556b.f42545b.onCompletion();
                }
            } else if (i2 == 3 && this.f42556b.f42548e != null) {
                this.f42556b.f42548e.onFrameRecorded(this.f42556b.f42549f, message.arg2, (message.arg1 == 1 ? Boolean.TRUE : Boolean.FALSE).booleanValue());
                this.f42556b.f42549f.rewind();
                this.f42556b.nativeHandledMsgCallback();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(37360912, "Lcom/baidu/media/recorder/DuAudioRecorder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(37360912, "Lcom/baidu/media/recorder/DuAudioRecorder;");
                return;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        u = arrayList;
        arrayList.add("mp3");
        u.add("aac");
    }

    public DuAudioRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b bVar = null;
        this.o = null;
        this.p = null;
        this.q = new Object();
        this.r = new c.a.z.e.a();
        this.s = new HashMap();
        this.t = new HashMap();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            bVar = new b(this, this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                bVar = new b(this, this, mainLooper);
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

    private native void nativeSetParameter(String str, long j2);

    private native void nativeSetParameter(String str, String str2);

    private native void nativeSetup(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStart();

    private native void nativeStop();

    @Keep
    public static int postEventFromNative(Object obj, int i2, int i3, int i4, Object obj2) {
        InterceptResult invokeCommon;
        DuAudioRecorder duAudioRecorder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{obj, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj2})) == null) {
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
        return invokeCommon.intValue;
    }

    public final int a(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
            b bVar = this.mEventHandler;
            if (bVar != null) {
                this.mEventHandler.sendMessage(bVar.obtainMessage(-1, i2, i3, obj));
                return 1;
            }
            return 0;
        }
        return invokeIIL.intValue;
    }

    public final int b(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3)) == null) {
            long j2 = this.f42551h;
            if (j2 > 0) {
                int nativeEncodePCM = nativeEncodePCM(bArr, i2, (int) Math.min(j2, i3));
                this.f42551h -= nativeEncodePCM;
                return nativeEncodePCM;
            } else if (j2 == 0) {
                stop();
                return 0;
            } else {
                return nativeEncodePCM(bArr, i2, i3);
            }
        }
        return invokeLII.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
                        this.f42550g = longValue;
                    } else if (c2 == 1) {
                        this.f42552i = longValue * 1024;
                    } else if (c2 == 2) {
                        this.m = (int) longValue;
                    } else if (c2 == 3) {
                        this.k = (int) longValue;
                    } else if (c2 == 4) {
                        this.f42553j = (int) longValue;
                    } else if (c2 != 5) {
                        nativeSetParameter(str2, longValue);
                    } else {
                        this.l = (int) longValue;
                    }
                }
            }
        }
    }

    public final void f() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i3 = this.l;
            if (i3 == 1) {
                i2 = 16;
            } else if (i3 != 2) {
                throw new IllegalArgumentException("KEY_INT_IN_CHANNEL_NB only support 1 or 2");
            } else {
                i2 = 12;
            }
            int minBufferSize = AudioRecord.getMinBufferSize(this.f42553j, i2, this.k);
            this.n = minBufferSize;
            if (minBufferSize < 0) {
                throw new IllegalArgumentException("AudioRecord.getMinBufferSize error");
            }
            AudioRecord audioRecord = new AudioRecord(this.m, this.f42553j, i2, this.k, this.n);
            this.p = audioRecord;
            this.l = audioRecord.getChannelCount();
            this.k = this.p.getAudioFormat();
            this.f42553j = this.p.getSampleRate();
            nativeSetParameter(CyberAudioRecorder.KEY_INT_IN_CHANNEL_NB, this.l);
            nativeSetParameter(CyberAudioRecorder.KEY_INT_IN_SAMPLE_FORMAT, this.k);
            nativeSetParameter(CyberAudioRecorder.KEY_INT_IN_SAMPLE_RATE, this.f42553j);
            long j2 = this.f42550g;
            if (j2 > 0) {
                long nativeGetBytesPerSample = j2 * this.l * this.f42553j * nativeGetBytesPerSample(this.k);
                this.f42551h = nativeGetBytesPerSample;
                if (nativeGetBytesPerSample == 0) {
                    CyberLog.w("DuAudioRecorder", "KEY_INT_ENC_MAX_DURATION Invalidation");
                    this.f42551h = -1L;
                }
            }
            long j3 = this.f42552i;
            if (j3 > 0) {
                ByteBuffer order = ByteBuffer.allocateDirect((int) j3).order(ByteOrder.nativeOrder());
                this.f42549f = order;
                nativeSetEncCallbackCacheBuffer(order);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public ArrayList<String> getSupportEncoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? u : (ArrayList) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AudioRecord audioRecord = this.p;
            if (audioRecord != null) {
                audioRecord.release();
                this.p = null;
            }
            j();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f42549f = null;
            this.f42550g = 0L;
            this.f42551h = -1L;
            this.f42553j = 44100;
            this.k = 1;
            this.l = 1;
            this.m = 0;
            this.n = 0;
        }
    }

    public final void l() {
        String str;
        String str2;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            CyberLog.d("DuAudioRecorder", "prepare in");
            synchronized (this.q) {
                if (this.r.b(16) > 0) {
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    this.o = newSingleThreadExecutor;
                    newSingleThreadExecutor.submit(new a(this));
                } else {
                    CyberLog.d("DuAudioRecorder", "prepare() called on an error status:" + this.r.a());
                    a(-1, -1, "prepare() called on an error status:" + this.r.a());
                }
            }
            CyberLog.d("DuAudioRecorder", "prepare out");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnCompletionListener(CyberAudioRecorder.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onCompletionListener) == null) {
            this.f42545b = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnEncBufferListener(CyberAudioRecorder.OnEncBufferCallbackListener onEncBufferCallbackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onEncBufferCallbackListener) == null) {
            this.f42548e = onEncBufferCallbackListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnErrorListener(CyberAudioRecorder.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onErrorListener) == null) {
            this.f42546c = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnInfoListener(CyberAudioRecorder.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onInfoListener) == null) {
            this.f42547d = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setOnPreparedListener(CyberAudioRecorder.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onPreparedListener) == null) {
            this.f42544a = onPreparedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setParameter(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048592, this, str, j2) == null) {
            this.t.put(str, Long.valueOf(j2));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void setParameter(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            this.s.put(str, str2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
    }

    @Override // com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
}
