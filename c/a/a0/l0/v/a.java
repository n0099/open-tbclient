package c.a.a0.l0.v;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.a0.l.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f1511b;

    /* renamed from: c  reason: collision with root package name */
    public long f1512c;

    /* renamed from: d  reason: collision with root package name */
    public long f1513d;

    /* renamed from: e  reason: collision with root package name */
    public long f1514e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f1515f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1516g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1517h;
    public final int i;
    public boolean j;
    public boolean k;
    public PhoneStateListener l;
    public String m;
    public String n;

    /* renamed from: c.a.a0.l0.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0065a extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f1518b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TelephonyManager f1519c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f1520d;

        public C0065a(a aVar, TelephonyManager telephonyManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, telephonyManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1520d = aVar;
            this.f1519c = telephonyManager;
            this.a = 0;
            this.f1518b = 0;
        }

        public final void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = this.f1518b;
                this.f1518b = i;
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (i == 0) {
                    c.a.a0.i.a.a("NadPSLogger", "监听到通话状态：IDLE");
                    a(i);
                    if (this.a == 2) {
                        this.f1520d.f1512c = System.currentTimeMillis();
                        this.f1520d.h(this.f1519c, this);
                    }
                } else if (i == 1) {
                    c.a.a0.i.a.a("NadPSLogger", "监听到通话状态：RINGING");
                    a(i);
                    this.f1520d.k = true;
                } else if (i != 2) {
                } else {
                    c.a.a0.i.a.a("NadPSLogger", "监听到通话状态：OFFHOOK");
                    a(i);
                    if (this.a == 0) {
                        this.f1520d.f1511b = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TelephonyManager a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PhoneStateListener f1521b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f1522c;

        public b(a aVar, TelephonyManager telephonyManager, PhoneStateListener phoneStateListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, telephonyManager, phoneStateListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1522c = aVar;
            this.a = telephonyManager;
            this.f1521b = phoneStateListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.getCallState() != 0) {
                    this.f1522c.i(this.a, this.f1521b);
                    return;
                }
                this.a.listen(this.f1521b, 0);
                this.f1522c.f1514e = System.currentTimeMillis();
                this.f1522c.l();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f1511b = 0L;
        this.f1512c = 0L;
        this.f1513d = 0L;
        this.f1514e = 0L;
        this.f1516g = new Handler(Looper.getMainLooper());
        this.f1517h = h.b().a().a("psl_switch", 1) == 1;
        this.i = h.b().a().a("psl_time", 20);
        this.j = false;
        this.k = false;
    }

    public final void h(@NonNull TelephonyManager telephonyManager, @NonNull PhoneStateListener phoneStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, telephonyManager, phoneStateListener) == null) {
            long j = this.f1511b;
            if (j != 0) {
                long j2 = this.f1512c;
                if (j2 != 0 && j2 > j) {
                    this.f1516g.removeCallbacks(this.f1515f);
                    telephonyManager.listen(phoneStateListener, 0);
                    this.f1514e = System.currentTimeMillis();
                    l();
                    return;
                }
            }
            i(telephonyManager, phoneStateListener);
        }
    }

    public final void i(@NonNull TelephonyManager telephonyManager, @NonNull PhoneStateListener phoneStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, telephonyManager, phoneStateListener) == null) {
            Runnable runnable = this.f1515f;
            if (runnable != null) {
                this.f1516g.removeCallbacks(runnable);
            } else {
                this.f1515f = new b(this, telephonyManager, phoneStateListener);
            }
            telephonyManager.listen(phoneStateListener, 32);
            this.f1516g.postDelayed(this.f1515f, TimeUnit.SECONDS.toMillis(this.i));
        }
    }

    public final int j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (j <= 0) {
                return 0;
            }
            return (int) TimeUnit.MILLISECONDS.toSeconds(j);
        }
        return invokeJ.intValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = this.f1512c;
            if (j != 0) {
                long j2 = this.f1511b;
                if (j2 != 0 && j > j2) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.j) {
            return;
        }
        this.j = true;
        if (TextUtils.isEmpty(this.m)) {
            return;
        }
        String str2 = k() ? "1" : "0";
        String str3 = "-1";
        if (k()) {
            str = "" + j(this.f1512c - this.f1511b);
        } else {
            str = "-1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        sb.append(this.i);
        sb.append(",");
        sb.append(j(this.f1514e - this.f1513d));
        sb.append(",");
        if (k()) {
            str3 = "" + j(this.f1511b - this.a);
        }
        sb.append(str3);
        sb.append(",");
        sb.append(this.k ? "1" : "0");
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        String sb2 = sb.toString();
        ClogBuilder k = new ClogBuilder().s(ClogBuilder.LogType.PHONE_STATE_LISTEN).n(this.m).i(str2).j(str).k(sb2);
        if (!TextUtils.isEmpty(this.n)) {
            k.l(this.n);
        } else {
            k.l("");
        }
        c.a.a0.a0.a.b(k);
        c.a.a0.i.a.a("NadPSLogger", "==========结束监听并打点==========");
        c.a.a0.i.a.a("NadPSLogger", "log_type：" + ClogBuilder.LogType.PHONE_STATE_LISTEN.type);
        c.a.a0.i.a.a("NadPSLogger", "da_ext1 是否监听到主动呼出：" + str2);
        c.a.a0.i.a.a("NadPSLogger", "da_ext2 主动呼出时长：" + str);
        c.a.a0.i.a.a("NadPSLogger", "da_ext3 云控监听时长，实际监听时长，拨号前停留时长，期间有无呼入：" + sb2);
    }

    public void m(@NonNull Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, context, str, str2) == null) && this.f1517h) {
            this.f1511b = 0L;
            this.f1512c = 0L;
            this.f1513d = 0L;
            this.f1514e = 0L;
            this.a = 0L;
            this.a = System.currentTimeMillis();
            this.j = false;
            this.k = false;
            this.m = str;
            this.n = str2;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            C0065a c0065a = new C0065a(this, telephonyManager);
            this.l = c0065a;
            i(telephonyManager, c0065a);
            this.f1513d = System.currentTimeMillis();
            c.a.a0.i.a.a("NadPSLogger", "==========开始监听==========");
        }
    }
}
