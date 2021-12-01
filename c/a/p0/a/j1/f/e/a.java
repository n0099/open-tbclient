package c.a.p0.a.j1.f.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.n.f;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a r;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord a;

    /* renamed from: b  reason: collision with root package name */
    public String f6610b;

    /* renamed from: c  reason: collision with root package name */
    public int f6611c;

    /* renamed from: d  reason: collision with root package name */
    public int f6612d;

    /* renamed from: e  reason: collision with root package name */
    public Context f6613e;

    /* renamed from: f  reason: collision with root package name */
    public String f6614f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f6615g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a.j1.f.d.b f6616h;

    /* renamed from: i  reason: collision with root package name */
    public long f6617i;

    /* renamed from: j  reason: collision with root package name */
    public long f6618j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.p0.a.j1.f.a f6619k;
    public c.a.p0.a.j1.f.b l;
    public boolean m;
    public TelephonyManager n;
    public c.a.p0.a.j1.f.d.a o;
    public boolean p;

    /* renamed from: c.a.p0.a.j1.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0352a implements c.a.p0.a.j1.f.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0352a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.a.j1.f.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a.q;
                c.a.p0.a.e0.d.i("recorder", "time out");
                this.a.F();
                this.a.z();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements i.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6620e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6620e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        public void call(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool.booleanValue()) {
                return;
            }
            this.f6620e.f();
            c.a.p0.a.e0.d.c("recorder", "record error");
            this.f6620e.z();
        }
    }

    /* loaded from: classes.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6621e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6621e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.f
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(this.f6621e.C()) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.j1.f.d.b f6622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6623f;

        public d(a aVar, c.a.p0.a.j1.f.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6623f = aVar;
            this.f6622e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.j1.f.d.b bVar = this.f6622e;
                if (bVar != null) {
                    bVar.a();
                }
                this.f6623f.G();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6624e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6624e = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f6624e.f6616h != null) {
                    this.f6624e.f6616h.a();
                }
                this.f6624e.G();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1096889634, "Lc/a/p0/a/j1/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1096889634, "Lc/a/p0/a/j1/f/e/a;");
                return;
            }
        }
        q = k.a;
    }

    public a() {
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
        this.f6612d = -1;
        this.f6619k = new c.a.p0.a.j1.f.a();
        this.p = false;
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (r == null) {
                synchronized (a.class) {
                    if (r == null) {
                        r = new a();
                    }
                }
            }
            return r;
        }
        return (a) invokeV.objValue;
    }

    public static void r(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, null, z) == null) || r == null) {
            return;
        }
        r.s(z);
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || r == null) {
            return;
        }
        r.z();
        r.H();
        r.o();
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            x();
            r = null;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = q;
            D(false);
            B();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = q;
            c.a.p0.a.e0.d.i("recorder", "resume timer");
            c.a.p0.a.j1.f.d.b bVar = this.f6616h;
            if (bVar != null) {
                if (this.f6618j <= 0) {
                    bVar.a();
                    return;
                }
                Timer timer = new Timer();
                this.f6615g = timer;
                timer.schedule(new e(this), this.f6618j);
                this.f6617i = System.currentTimeMillis();
            }
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] bArr = new byte[this.f6611c];
            c.a.p0.a.j1.f.a aVar = this.f6619k;
            c.a.p0.a.j1.f.f.a aVar2 = new c.a.p0.a.j1.f.f.a(aVar.f6581b, aVar.f6582c, aVar.f6583d, aVar.f6584e);
            if (this.a == null) {
                return false;
            }
            return v(bArr, aVar2);
        }
        return invokeV.booleanValue;
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.f6613e == null) {
                f();
                c.a.p0.a.e0.d.c("recorder", "start error, context is null");
                z();
            } else if (this.f6612d != -1 && !TextUtils.isEmpty(this.f6610b)) {
                if (z) {
                    String str = null;
                    int i2 = this.f6612d;
                    if (i2 == 1) {
                        str = "start fail: recorder is recording";
                    } else if (i2 != 0 && i2 != 3) {
                        str = "start fail: recorder is paused";
                    }
                    if (str != null) {
                        g(2003, str);
                        c.a.p0.a.e0.d.c("recorder", str);
                        return;
                    }
                }
                boolean z2 = q;
                try {
                    this.a.startRecording();
                    if (this.a.getRecordingState() != 3) {
                        f();
                        c.a.p0.a.e0.d.c("recorder", "start error, no real permission");
                        z();
                        return;
                    }
                    if (z) {
                        E(new C0352a(this));
                        e(c.a.p0.a.j1.f.b.f6588d, "recorderStart");
                    } else {
                        e(c.a.p0.a.j1.f.b.f6590f, "recorderResume");
                    }
                    i.d.f("").y(Schedulers.io()).h(new c(this)).k(i.l.b.a.b()).w(new b(this));
                } catch (IllegalStateException e2) {
                    f();
                    c.a.p0.a.e0.d.d("recorder", "can't start", e2);
                    z();
                }
            } else {
                f();
                c.a.p0.a.e0.d.c("recorder", "start error, wrong state");
                z();
            }
        }
    }

    public void E(c.a.p0.a.j1.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            if (q) {
                String str = "start timer:" + this.f6619k.a;
            }
            c.a.p0.a.e0.d.i("recorder", "start timer, totalTime:" + this.f6619k.a);
            this.f6616h = bVar;
            Timer timer = new Timer();
            this.f6615g = timer;
            timer.schedule(new d(this, bVar), this.f6619k.a);
            this.f6617i = System.currentTimeMillis();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = q;
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                f();
                c.a.p0.a.e0.d.c("recorder", "none audioRecord");
                z();
                return;
            }
            try {
                audioRecord.stop();
                G();
                this.f6612d = 3;
                h();
                H();
            } catch (IllegalStateException e2) {
                f();
                c.a.p0.a.e0.d.d("recorder", "stop error", e2);
                z();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            boolean z = q;
            c.a.p0.a.e0.d.i("recorder", "stop timer");
            this.f6616h = null;
            Timer timer = this.f6615g;
            if (timer != null) {
                timer.cancel();
                this.f6615g = null;
            }
        }
    }

    public final void H() {
        TelephonyManager telephonyManager;
        c.a.p0.a.j1.f.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (telephonyManager = this.n) == null || (aVar = this.o) == null) {
            return;
        }
        telephonyManager.listen(aVar, 0);
        this.n = null;
        this.o = null;
    }

    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            if (q) {
                String str3 = "dispatchCallback: " + str + " " + str2;
            }
            if (this.l != null && !TextUtils.isEmpty(str)) {
                this.l.b(str);
                return;
            }
            c.a.p0.a.g1.f.U().u(new c.a.p0.a.o0.d.c(str2));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g(2002, "error execute");
        }
    }

    public final void g(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            if (this.l != null && !TextUtils.isEmpty(c.a.p0.a.j1.f.b.f6592h)) {
                this.l.d(i2, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i2);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                c.a.p0.a.g1.f.U().u(new c.a.p0.a.o0.d.c("recorderError", hashMap));
            } catch (JSONException e2) {
                c.a.p0.a.e0.d.d("recorder", "json error", e2);
                z();
            }
        }
    }

    public final void h() {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String J = c.a.p0.a.o2.b.J(this.f6610b, this.f6614f);
            long j3 = -1;
            if (TextUtils.isEmpty(this.f6610b)) {
                j2 = -1;
            } else {
                j3 = c.a.p0.w.d.u(this.f6610b);
                j2 = new File(this.f6610b).length();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(J)) {
                    jSONObject.put("tempFilePath", J);
                }
                if (j3 >= 0) {
                    jSONObject.put("duration", j3);
                }
                if (j2 >= 0) {
                    jSONObject.put("fileSize", j2);
                }
                if (this.l != null && !TextUtils.isEmpty(c.a.p0.a.j1.f.b.f6591g)) {
                    this.l.c(c.a.p0.a.j1.f.b.f6591g, jSONObject);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                c.a.p0.a.g1.f.U().u(new c.a.p0.a.o0.d.c("recorderStop", hashMap));
            } catch (JSONException e2) {
                f();
                c.a.p0.a.e0.d.d("recorder", "json error", e2);
                z();
            }
        }
    }

    public c.a.p0.a.j1.f.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (c.a.p0.a.j1.f.b) invokeV.objValue;
    }

    public c.a.p0.a.j1.f.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f6619k : (c.a.p0.a.j1.f.a) invokeV.objValue;
    }

    public void l(String str, c.a.p0.a.j1.f.a aVar, Context context, c.a.p0.a.j1.f.b bVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048590, this, str, aVar, context, bVar, str2) == null) {
            int i2 = this.f6612d;
            if (i2 != -1 && i2 != 3) {
                c.a.p0.a.e0.d.c("recorder", "wrong state, can't init");
                return;
            }
            this.f6619k = aVar;
            m(str);
            this.l = bVar;
            int minBufferSize = AudioRecord.getMinBufferSize(aVar.f6583d, aVar.f6582c, 2);
            this.f6611c = minBufferSize;
            if (minBufferSize <= 0) {
                f();
                c.a.p0.a.e0.d.c("recorder", "wrong buffer size");
                z();
                return;
            }
            this.a = new AudioRecord(aVar.f6585f, aVar.f6583d, aVar.f6582c == 1 ? 16 : 12, 2, this.f6611c);
            this.f6612d = 0;
            this.f6613e = context;
            this.f6614f = str2;
            w();
        }
    }

    public final void m(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (TextUtils.equals(this.f6619k.f6581b, "mp3")) {
                str2 = EmotionResourceProvider.EMOTION_SOUND_SUFFIX;
            } else {
                str2 = TextUtils.equals(this.f6619k.f6581b, "pcm") ? ".pcm" : ".aac";
            }
            this.f6610b = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i2 = this.f6612d;
            if (i2 == 0 || i2 == 1) {
                if (!this.p) {
                    this.p = true;
                    e(c.a.p0.a.j1.f.b.f6593i, "recorderInterruptionBegin");
                }
                t();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.p) {
            this.p = false;
            e(c.a.p0.a.j1.f.b.f6594j, "recorderInterruptionEnd");
        }
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
                if (this.f6612d != 1) {
                    str2 = "pause fail: recorder is not recording";
                }
                str2 = null;
            } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
                if (this.f6612d != 2) {
                    str2 = "resume fail: recorder is not paused";
                }
                str2 = null;
            } else {
                if (TextUtils.equals(str, "/swanAPI/recorder/stop") && (i2 = this.f6612d) != 2 && i2 != 1) {
                    str2 = "stop fail: recorder is not started";
                }
                str2 = null;
            }
            if (str2 != null) {
                g(2003, str2);
                c.a.p0.a.e0.d.c("recorder", str2);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (this.m) {
                return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (z && this.f6612d == 1) {
                t();
            }
            this.m = z;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            boolean z = q;
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                f();
                c.a.p0.a.e0.d.c("recorder", "none audio record");
                z();
                return;
            }
            try {
                audioRecord.stop();
                this.f6612d = 2;
                u();
                e(c.a.p0.a.j1.f.b.f6589e, "recorderPause");
            } catch (IllegalStateException e2) {
                f();
                c.a.p0.a.e0.d.d("recorder", "pause error", e2);
                z();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (q) {
                r0 = "pause timer, lastTime:" + this.f6618j;
            }
            c.a.p0.a.e0.d.i("recorder", "pause timer, lastTime:" + this.f6618j);
            Timer timer = this.f6615g;
            if (timer != null) {
                timer.cancel();
                this.f6615g = null;
            }
            this.f6618j = this.f6619k.a - (System.currentTimeMillis() - this.f6617i);
        }
    }

    public final boolean v(byte[] bArr, c.a.p0.a.j1.f.f.a aVar) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, bArr, aVar)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File file = new File(this.f6610b);
                    if (this.f6612d == 0) {
                        if (file.exists()) {
                            file.delete();
                        }
                        c.a.p0.w.d.h(file);
                    }
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f6612d = 1;
                while (this.f6612d == 1) {
                    if (this.a.read(bArr, 0, this.f6611c) >= 0) {
                        byte[] f2 = TextUtils.equals(this.f6619k.f6581b, "pcm") ? bArr : aVar.f(bArr);
                        if (f2 != null && f2.length > 0) {
                            fileOutputStream.write(f2);
                        }
                    }
                }
                c.a.p0.w.d.d(fileOutputStream);
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                c.a.p0.a.e0.d.d("recorder", "save record error", e);
                if (this.f6612d == 1) {
                    this.f6612d = 3;
                }
                c.a.p0.w.d.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                c.a.p0.w.d.d(fileOutputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void w() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (context = this.f6613e) == null) {
            return;
        }
        this.n = (TelephonyManager) context.getSystemService("phone");
        c.a.p0.a.j1.f.d.a aVar = new c.a.p0.a.j1.f.d.a();
        this.o = aVar;
        this.n.listen(aVar, 32);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            G();
            this.f6613e = null;
            this.f6612d = -1;
            AudioRecord audioRecord = this.a;
            if (audioRecord != null) {
                audioRecord.release();
                this.a = null;
            }
        }
    }
}
