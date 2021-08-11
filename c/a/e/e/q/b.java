package c.a.e.e.q;

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
    public volatile int f2539e;

    /* renamed from: f  reason: collision with root package name */
    public AudioTrack f2540f;

    /* renamed from: g  reason: collision with root package name */
    public String f2541g;

    /* renamed from: h  reason: collision with root package name */
    public final short[] f2542h;

    /* renamed from: i  reason: collision with root package name */
    public Amrnb f2543i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f2544j;
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
        public final /* synthetic */ b f2545e;

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
            this.f2545e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f2545e.f2540f == null) {
                return;
            }
            try {
                if (this.f2545e.f2540f.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException unused) {
            }
            int g2 = this.f2545e.g() + 0;
            if (g2 != this.f2545e.k) {
                this.f2545e.k = g2;
                Message obtainMessage = this.f2545e.f2544j.obtainMessage(6);
                obtainMessage.arg1 = this.f2545e.k;
                this.f2545e.f2544j.sendMessage(obtainMessage);
            }
            this.f2545e.l.postDelayed(this.f2545e.m, 100L);
        }
    }

    /* renamed from: c.a.e.e.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0050b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f2546e;

        public RunnableC0050b(b bVar) {
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
            this.f2546e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2546e.i();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1211721777, "Lc/a/e/e/q/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1211721777, "Lc/a/e/e/q/b;");
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
        this.f2539e = 0;
        this.f2542h = new short[]{12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
        this.k = 0;
        this.l = new Handler();
        this.m = new a(this);
        this.n = 0;
        this.o = new RunnableC0050b(this);
        this.n = i2;
        this.f2544j = handler;
        try {
            Amrnb amrnb = new Amrnb();
            this.f2543i = amrnb;
            if (amrnb != null || this.f2544j == null) {
                return;
            }
            this.f2544j.sendMessage(this.f2544j.obtainMessage(2));
        } catch (Exception unused) {
            Handler handler2 = this.f2544j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(2));
            }
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AudioTrack audioTrack = this.f2540f;
            if (audioTrack == null) {
                return 0;
            }
            try {
                int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                if (this.f2540f == null) {
                    return 0;
                }
                int sampleRate = this.f2540f.getSampleRate();
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
                this.f2540f = new AudioTrack(h.f2549b, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
            } catch (IllegalArgumentException e2) {
                this.f2540f = null;
                BdLog.e(e2.getMessage());
            }
            this.f2539e = 1;
        }
    }

    public void i() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.f2544j;
            if (handler != null) {
                handler.removeCallbacks(this.o);
            }
            synchronized (p) {
                if (this.f2540f != null) {
                    try {
                        i2 = this.f2540f.getPlaybackHeadPosition();
                        try {
                            this.f2540f.stop();
                            this.f2540f.release();
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        i2 = 0;
                    }
                    this.n = 0;
                    this.f2540f = null;
                } else {
                    i2 = 0;
                }
                if (this.l != null) {
                    this.l.removeCallbacks(this.m);
                }
                if (this.f2544j != null) {
                    Message obtainMessage = this.f2544j.obtainMessage(0);
                    obtainMessage.arg1 = i2;
                    this.f2544j.sendMessage(obtainMessage);
                }
            }
            this.f2539e = 0;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f2541g = str;
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
            this.f2539e = 3;
            i();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Process.setThreadPriority(-19);
            if (this.f2543i == null) {
                Handler handler = this.f2544j;
                if (handler != null) {
                    handler.sendMessage(handler.obtainMessage(2));
                    return;
                }
                return;
            }
            boolean z = true;
            if (this.f2541g == null) {
                Handler handler2 = this.f2544j;
                if (handler2 != null) {
                    handler2.sendMessage(handler2.obtainMessage(1));
                    return;
                }
                return;
            }
            File file = new File(this.f2541g);
            if (!file.exists()) {
                Handler handler3 = this.f2544j;
                if (handler3 != null) {
                    handler3.sendMessage(handler3.obtainMessage(1));
                    return;
                }
                return;
            }
            FileInputStream fileInputStream = null;
            h();
            AudioTrack audioTrack = this.f2540f;
            if (audioTrack != null && audioTrack.getState() != 0) {
                if (this.n > 0) {
                    this.f2540f.reloadStaticData();
                    this.f2540f.setPlaybackHeadPosition(this.n);
                }
                boolean z2 = false;
                try {
                    this.f2540f.play();
                    this.f2539e = 2;
                    this.l.post(this.m);
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        Boolean bool = Boolean.TRUE;
                        byte[] bArr = new byte[32];
                        this.f2543i.decoderInit();
                        short[] sArr = new short[160];
                        try {
                            while (this.f2539e == 2) {
                                if (bool.booleanValue()) {
                                    if (fileInputStream2.read(bArr, 0, 6) != 6 || bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82 || bArr[5] != 10) {
                                        break;
                                    }
                                    bool = Boolean.FALSE;
                                }
                                if (fileInputStream2.read(bArr, 0, 1) > 0) {
                                    short s = this.f2542h[(bArr[0] >> 3) & 15];
                                    if (fileInputStream2.read(bArr, 1, s) == s) {
                                        synchronized (p) {
                                            if (this.f2540f != null && this.f2540f.getPlayState() == 3) {
                                                this.f2543i.decoderDecode(bArr, sArr);
                                                this.f2540f.write(sArr, 0, 160);
                                            }
                                        }
                                    }
                                }
                            }
                            fileInputStream2.close();
                            this.f2543i.decoderDeinit();
                        } catch (Exception unused) {
                            z2 = z;
                            fileInputStream = fileInputStream2;
                            Handler handler4 = this.f2544j;
                            if (handler4 != null) {
                                handler4.sendMessage(handler4.obtainMessage(5));
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e2) {
                                    BdLog.e(e2.getMessage());
                                }
                            }
                            z = z2;
                            this.f2539e = 3;
                            if (!z) {
                            }
                        }
                        z = false;
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                }
                this.f2539e = 3;
                if (!z) {
                    this.f2544j.postDelayed(this.o, 500L);
                    return;
                } else {
                    i();
                    return;
                }
            }
            Handler handler5 = this.f2544j;
            if (handler5 != null) {
                handler5.sendMessage(handler5.obtainMessage(3));
            }
        }
    }
}
