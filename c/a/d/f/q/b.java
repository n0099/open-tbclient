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
    public static Object p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f3126e;

    /* renamed from: f  reason: collision with root package name */
    public AudioTrack f3127f;

    /* renamed from: g  reason: collision with root package name */
    public String f3128g;

    /* renamed from: h  reason: collision with root package name */
    public final short[] f3129h;

    /* renamed from: i  reason: collision with root package name */
    public Amrnb f3130i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f3131j;
    public int k;
    public final Handler l;
    public final Runnable m;
    public int n;
    public final Runnable o;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3132e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3132e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f3132e.f3127f == null) {
                return;
            }
            try {
                if (this.f3132e.f3127f.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException unused) {
            }
            int g2 = this.f3132e.g() + 0;
            if (g2 != this.f3132e.k) {
                this.f3132e.k = g2;
                Message obtainMessage = this.f3132e.f3131j.obtainMessage(6);
                obtainMessage.arg1 = this.f3132e.k;
                this.f3132e.f3131j.sendMessage(obtainMessage);
            }
            this.f3132e.l.postDelayed(this.f3132e.m, 100L);
        }
    }

    /* renamed from: c.a.d.f.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0123b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3133e;

        public RunnableC0123b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3133e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3133e.i();
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
        p = new Object();
    }

    public b(Handler handler, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3126e = 0;
        this.f3129h = new short[]{12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
        this.k = 0;
        this.l = new Handler();
        this.m = new a(this);
        this.n = 0;
        this.o = new RunnableC0123b(this);
        this.n = i2;
        this.f3131j = handler;
        try {
            Amrnb amrnb = new Amrnb();
            this.f3130i = amrnb;
            if (amrnb != null || this.f3131j == null) {
                return;
            }
            this.f3131j.sendMessage(this.f3131j.obtainMessage(2));
        } catch (Exception unused) {
            Handler handler2 = this.f3131j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(2));
            }
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AudioTrack audioTrack = this.f3127f;
            if (audioTrack == null) {
                return 0;
            }
            try {
                int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                if (this.f3127f == null) {
                    return 0;
                }
                int sampleRate = this.f3127f.getSampleRate();
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
                this.f3127f = new AudioTrack(h.f3134b, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
            } catch (IllegalArgumentException e2) {
                this.f3127f = null;
                BdLog.e(e2.getMessage());
            }
            this.f3126e = 1;
        }
    }

    public void i() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.f3131j;
            if (handler != null) {
                handler.removeCallbacks(this.o);
            }
            synchronized (p) {
                if (this.f3127f != null) {
                    try {
                        i2 = this.f3127f.getPlaybackHeadPosition();
                        try {
                            this.f3127f.stop();
                            this.f3127f.release();
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        i2 = 0;
                    }
                    this.n = 0;
                    this.f3127f = null;
                } else {
                    i2 = 0;
                }
                if (this.l != null) {
                    this.l.removeCallbacks(this.m);
                }
                if (this.f3131j != null) {
                    Message obtainMessage = this.f3131j.obtainMessage(0);
                    obtainMessage.arg1 = i2;
                    this.f3131j.sendMessage(obtainMessage);
                }
            }
            this.f3126e = 0;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f3128g = str;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.n = i2;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f3126e = 3;
            i();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012d  */
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
            if (this.f3130i == null) {
                Handler handler = this.f3131j;
                if (handler != null) {
                    handler.sendMessage(handler.obtainMessage(2));
                    return;
                }
                return;
            }
            boolean z = true;
            if (this.f3128g == null) {
                Handler handler2 = this.f3131j;
                if (handler2 != null) {
                    handler2.sendMessage(handler2.obtainMessage(1));
                    return;
                }
                return;
            }
            File file = new File(this.f3128g);
            if (!file.exists()) {
                Handler handler3 = this.f3131j;
                if (handler3 != null) {
                    handler3.sendMessage(handler3.obtainMessage(1));
                    return;
                }
                return;
            }
            FileInputStream fileInputStream2 = null;
            h();
            AudioTrack audioTrack = this.f3127f;
            if (audioTrack != null && audioTrack.getState() != 0) {
                if (this.n > 0) {
                    this.f3127f.reloadStaticData();
                    this.f3127f.setPlaybackHeadPosition(this.n);
                }
                boolean z2 = false;
                try {
                    this.f3127f.play();
                    this.f3126e = 2;
                    this.l.post(this.m);
                    fileInputStream = new FileInputStream(file);
                    try {
                        bool = Boolean.TRUE;
                        bArr = new byte[32];
                        decoderInit = this.f3130i.decoderInit();
                        sArr = new short[160];
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                }
                try {
                    while (this.f3126e == 2) {
                        if (bool.booleanValue()) {
                            if (fileInputStream.read(bArr, 0, 6) != 6 || bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82 || bArr[5] != 10) {
                                break;
                            }
                            bool = Boolean.FALSE;
                        }
                        if (fileInputStream.read(bArr, 0, 1) > 0) {
                            short s = this.f3129h[(bArr[0] >> 3) & 15];
                            if (fileInputStream.read(bArr, 1, s) == s) {
                                synchronized (p) {
                                    if (this.f3127f != null && this.f3127f.getPlayState() == 3) {
                                        this.f3130i.decoderDecode(decoderInit, bArr, sArr);
                                        this.f3127f.write(sArr, 0, 160);
                                    }
                                }
                            }
                        }
                    }
                    fileInputStream.close();
                    this.f3130i.decoderDeinit(decoderInit);
                } catch (Exception unused3) {
                    z2 = z;
                    fileInputStream2 = fileInputStream;
                    Handler handler4 = this.f3131j;
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
                    this.f3126e = 3;
                    if (!z) {
                    }
                }
                z = false;
                this.f3126e = 3;
                if (!z) {
                    this.f3131j.postDelayed(this.o, 500L);
                    return;
                } else {
                    i();
                    return;
                }
            }
            Handler handler5 = this.f3131j;
            if (handler5 != null) {
                handler5.sendMessage(handler5.obtainMessage(3));
            }
        }
    }
}
