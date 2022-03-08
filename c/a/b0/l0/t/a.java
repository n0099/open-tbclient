package c.a.b0.l0.t;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.b0.l.h;
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
    public long f1881b;

    /* renamed from: c  reason: collision with root package name */
    public long f1882c;

    /* renamed from: d  reason: collision with root package name */
    public long f1883d;

    /* renamed from: e  reason: collision with root package name */
    public long f1884e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f1885f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1886g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1887h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1888i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1889j;
    public boolean k;
    public PhoneStateListener l;
    public String m;
    public String n;

    /* renamed from: c.a.b0.l0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0075a extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f1890b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TelephonyManager f1891c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f1892d;

        public C0075a(a aVar, TelephonyManager telephonyManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, telephonyManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1892d = aVar;
            this.f1891c = telephonyManager;
            this.a = 0;
            this.f1890b = 0;
        }

        public final void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a = this.f1890b;
                this.f1890b = i2;
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (i2 == 0) {
                    c.a.b0.i.a.a("NadPSLogger", "监听到通话状态：IDLE");
                    a(i2);
                    if (this.a == 2) {
                        this.f1892d.f1882c = System.currentTimeMillis();
                        this.f1892d.h(this.f1891c, this);
                    }
                } else if (i2 == 1) {
                    c.a.b0.i.a.a("NadPSLogger", "监听到通话状态：RINGING");
                    a(i2);
                    this.f1892d.k = true;
                } else if (i2 != 2) {
                } else {
                    c.a.b0.i.a.a("NadPSLogger", "监听到通话状态：OFFHOOK");
                    a(i2);
                    if (this.a == 0) {
                        this.f1892d.f1881b = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TelephonyManager f1893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PhoneStateListener f1894f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f1895g;

        public b(a aVar, TelephonyManager telephonyManager, PhoneStateListener phoneStateListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, telephonyManager, phoneStateListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1895g = aVar;
            this.f1893e = telephonyManager;
            this.f1894f = phoneStateListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f1893e.getCallState() != 0) {
                    this.f1895g.i(this.f1893e, this.f1894f);
                    return;
                }
                this.f1893e.listen(this.f1894f, 0);
                this.f1895g.f1884e = System.currentTimeMillis();
                this.f1895g.l();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f1881b = 0L;
        this.f1882c = 0L;
        this.f1883d = 0L;
        this.f1884e = 0L;
        this.f1886g = new Handler(Looper.getMainLooper());
        this.f1887h = h.b().info().a("psl_switch", 1) == 1;
        this.f1888i = h.b().info().a("psl_time", 20);
        this.f1889j = false;
        this.k = false;
    }

    public final void h(@NonNull TelephonyManager telephonyManager, @NonNull PhoneStateListener phoneStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, telephonyManager, phoneStateListener) == null) {
            long j2 = this.f1881b;
            if (j2 != 0) {
                long j3 = this.f1882c;
                if (j3 != 0 && j3 > j2) {
                    this.f1886g.removeCallbacks(this.f1885f);
                    telephonyManager.listen(phoneStateListener, 0);
                    this.f1884e = System.currentTimeMillis();
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
            Runnable runnable = this.f1885f;
            if (runnable != null) {
                this.f1886g.removeCallbacks(runnable);
            } else {
                this.f1885f = new b(this, telephonyManager, phoneStateListener);
            }
            telephonyManager.listen(phoneStateListener, 32);
            this.f1886g.postDelayed(this.f1885f, TimeUnit.SECONDS.toMillis(this.f1888i));
        }
    }

    public final int j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            if (j2 <= 0) {
                return 0;
            }
            return (int) TimeUnit.MILLISECONDS.toSeconds(j2);
        }
        return invokeJ.intValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j2 = this.f1882c;
            if (j2 != 0) {
                long j3 = this.f1881b;
                if (j3 != 0 && j2 > j3) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f1889j) {
            return;
        }
        this.f1889j = true;
        if (TextUtils.isEmpty(this.m)) {
            return;
        }
        String str2 = k() ? "1" : "0";
        String str3 = "-1";
        if (k()) {
            str = "" + j(this.f1882c - this.f1881b);
        } else {
            str = "-1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        sb.append(this.f1888i);
        sb.append(",");
        sb.append(j(this.f1884e - this.f1883d));
        sb.append(",");
        if (k()) {
            str3 = "" + j(this.f1881b - this.a);
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
        c.a.b0.a0.a.b(k);
        c.a.b0.i.a.a("NadPSLogger", "==========结束监听并打点==========");
        c.a.b0.i.a.a("NadPSLogger", "log_type：" + ClogBuilder.LogType.PHONE_STATE_LISTEN.type);
        c.a.b0.i.a.a("NadPSLogger", "da_ext1 是否监听到主动呼出：" + str2);
        c.a.b0.i.a.a("NadPSLogger", "da_ext2 主动呼出时长：" + str);
        c.a.b0.i.a.a("NadPSLogger", "da_ext3 云控监听时长，实际监听时长，拨号前停留时长，期间有无呼入：" + sb2);
    }

    public void m(@NonNull Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, context, str, str2) == null) && this.f1887h) {
            this.f1881b = 0L;
            this.f1882c = 0L;
            this.f1883d = 0L;
            this.f1884e = 0L;
            this.a = 0L;
            this.a = System.currentTimeMillis();
            this.f1889j = false;
            this.k = false;
            this.m = str;
            this.n = str2;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            C0075a c0075a = new C0075a(this, telephonyManager);
            this.l = c0075a;
            i(telephonyManager, c0075a);
            this.f1883d = System.currentTimeMillis();
            c.a.b0.i.a.a("NadPSLogger", "==========开始监听==========");
        }
    }
}
