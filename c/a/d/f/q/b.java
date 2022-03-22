package c.a.d.f.q;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.Amrnb;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static Object l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;

    /* renamed from: b  reason: collision with root package name */
    public AudioTrack f2359b;

    /* renamed from: c  reason: collision with root package name */
    public String f2360c;

    /* renamed from: d  reason: collision with root package name */
    public final short[] f2361d;

    /* renamed from: e  reason: collision with root package name */
    public Amrnb f2362e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f2363f;

    /* renamed from: g  reason: collision with root package name */
    public int f2364g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f2365h;
    public final Runnable i;
    public int j;
    public final Runnable k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f2359b == null) {
                return;
            }
            try {
                if (this.a.f2359b.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException unused) {
            }
            int g2 = this.a.g() + 0;
            if (g2 != this.a.f2364g) {
                this.a.f2364g = g2;
                Message obtainMessage = this.a.f2363f.obtainMessage(6);
                obtainMessage.arg1 = this.a.f2364g;
                this.a.f2363f.sendMessage(obtainMessage);
            }
            this.a.f2365h.postDelayed(this.a.i, 100L);
        }
    }

    /* renamed from: c.a.d.f.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0101b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public RunnableC0101b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502459407, "Lc/a/d/f/q/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502459407, "Lc/a/d/f/q/b;");
                return;
            }
        }
        l = new Object();
    }

    public b(Handler handler, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f2361d = new short[]{12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
        this.f2364g = 0;
        this.f2365h = new Handler();
        this.i = new a(this);
        this.j = 0;
        this.k = new RunnableC0101b(this);
        this.j = i;
        this.f2363f = handler;
        try {
            Amrnb amrnb = new Amrnb();
            this.f2362e = amrnb;
            if (amrnb != null || this.f2363f == null) {
                return;
            }
            this.f2363f.sendMessage(this.f2363f.obtainMessage(2));
        } catch (Exception unused) {
            Handler handler2 = this.f2363f;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(2));
            }
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AudioTrack audioTrack = this.f2359b;
            if (audioTrack == null) {
                return 0;
            }
            try {
                int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                if (this.f2359b == null) {
                    return 0;
                }
                int sampleRate = this.f2359b.getSampleRate();
                if (sampleRate == 0) {
                    return 0;
                }
                return (int) (((playbackHeadPosition * 1.0f) / (sampleRate * 1.0f)) * 1000.0f);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                this.f2359b = new AudioTrack(h.f2366b, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
            } catch (IllegalArgumentException e2) {
                this.f2359b = null;
                BdLog.e(e2.getMessage());
            }
            this.a = 1;
        }
    }

    public void i() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.f2363f;
            if (handler != null) {
                handler.removeCallbacks(this.k);
            }
            synchronized (l) {
                if (this.f2359b != null) {
                    try {
                        i = this.f2359b.getPlaybackHeadPosition();
                        try {
                            this.f2359b.stop();
                            this.f2359b.release();
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        i = 0;
                    }
                    this.j = 0;
                    this.f2359b = null;
                } else {
                    i = 0;
                }
                if (this.f2365h != null) {
                    this.f2365h.removeCallbacks(this.i);
                }
                if (this.f2363f != null) {
                    Message obtainMessage = this.f2363f.obtainMessage(0);
                    obtainMessage.arg1 = i;
                    this.f2363f.sendMessage(obtainMessage);
                }
            }
            this.a = 0;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f2360c = str;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.j = i;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = 3;
            i();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        FileInputStream fileInputStream;
        Boolean bool;
        byte[] bArr;
        long decoderInit;
        short[] sArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Process.setThreadPriority(-19);
            if (this.f2362e == null) {
                Handler handler = this.f2363f;
                if (handler != null) {
                    handler.sendMessage(handler.obtainMessage(2));
                    return;
                }
                return;
            }
            boolean z = true;
            if (this.f2360c == null) {
                Handler handler2 = this.f2363f;
                if (handler2 != null) {
                    handler2.sendMessage(handler2.obtainMessage(1));
                    return;
                }
                return;
            }
            File file = new File(this.f2360c);
            if (!file.exists()) {
                Handler handler3 = this.f2363f;
                if (handler3 != null) {
                    handler3.sendMessage(handler3.obtainMessage(1));
                    return;
                }
                return;
            }
            FileInputStream fileInputStream2 = null;
            h();
            AudioTrack audioTrack = this.f2359b;
            if (audioTrack != null && audioTrack.getState() != 0) {
                if (this.j > 0) {
                    this.f2359b.reloadStaticData();
                    this.f2359b.setPlaybackHeadPosition(this.j);
                }
                boolean z2 = false;
                try {
                    this.f2359b.play();
                    this.a = 2;
                    this.f2365h.post(this.i);
                    fileInputStream = new FileInputStream(file);
                    try {
                        bool = Boolean.TRUE;
                        bArr = new byte[32];
                        decoderInit = this.f2362e.decoderInit();
                        sArr = new short[160];
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                }
                try {
                    while (this.a == 2) {
                        if (bool.booleanValue()) {
                            if (fileInputStream.read(bArr, 0, 6) != 6 || bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82 || bArr[5] != 10) {
                                break;
                            }
                            bool = Boolean.FALSE;
                        }
                        if (fileInputStream.read(bArr, 0, 1) > 0) {
                            short s = this.f2361d[(bArr[0] >> 3) & 15];
                            if (fileInputStream.read(bArr, 1, s) == s) {
                                synchronized (l) {
                                    if (this.f2359b != null && this.f2359b.getPlayState() == 3) {
                                        this.f2362e.decoderDecode(decoderInit, bArr, sArr);
                                        this.f2359b.write(sArr, 0, 160);
                                    }
                                }
                            }
                        }
                    }
                    fileInputStream.close();
                    this.f2362e.decoderDeinit(decoderInit);
                } catch (Exception unused3) {
                    z2 = z;
                    fileInputStream2 = fileInputStream;
                    Handler handler4 = this.f2363f;
                    if (handler4 != null) {
                        handler4.sendMessage(handler4.obtainMessage(5));
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    z = z2;
                    this.a = 3;
                    if (!z) {
                    }
                }
                z = false;
                this.a = 3;
                if (!z) {
                    Handler handler5 = this.f2363f;
                    if (handler5 != null) {
                        handler5.postDelayed(this.k, 500L);
                        return;
                    }
                    return;
                }
                i();
                return;
            }
            Handler handler6 = this.f2363f;
            if (handler6 != null) {
                handler6.sendMessage(handler6.obtainMessage(3));
            }
        }
    }
}
