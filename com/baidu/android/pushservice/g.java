package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f3156a;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3157d;

    /* renamed from: e  reason: collision with root package name */
    public static LocalServerSocket f3158e;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f3159g;
    public static boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f3160b;

    /* renamed from: c  reason: collision with root package name */
    public e f3161c;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f3162f;

    /* renamed from: h  reason: collision with root package name */
    public Context f3163h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f3164i;
    public boolean j;
    public PushServiceReceiver k;
    public boolean l;
    public Runnable n;
    public Runnable o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-840926954, "Lcom/baidu/android/pushservice/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-840926954, "Lcom/baidu/android/pushservice/g;");
                return;
            }
        }
        f3157d = new Object();
        f3159g = new Object();
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3162f = Boolean.FALSE;
        this.n = new Runnable(this) { // from class: com.baidu.android.pushservice.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f3166a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f3166a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f3166a.a(new Intent());
                }
            }
        };
        this.o = new Runnable(this) { // from class: com.baidu.android.pushservice.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f3167a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f3167a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (g.f3157d) {
                        if (this.f3167a.f3161c != null) {
                            this.f3167a.f3161c.b();
                        }
                    }
                }
            }
        };
        this.f3164i = new Handler(context.getMainLooper());
        this.f3163h = context.getApplicationContext();
        this.f3160b = TiebaStatic.MAX_COST_VALUE;
    }

    public static g a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f3156a == null) {
                synchronized (g.class) {
                    if (f3156a == null) {
                        f3156a = new g(context);
                    }
                }
            }
            return f3156a;
        }
        return (g) invokeL.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            if (f3156a != null) {
                f3156a.l();
            }
            com.baidu.android.pushservice.h.d.a().b();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.k == null) {
            this.k = new PushServiceReceiver();
            this.f3163h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.f3163h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.f3163h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.f3163h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.k == null) {
            return;
        }
        this.f3163h.getApplicationContext().unregisterReceiver(this.k);
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.baidu.android.pushservice.g.a.a("PushSDK", "destroy", this.f3163h);
            synchronized (f3159g) {
                try {
                    if (f3158e != null) {
                        f3158e.close();
                        f3158e = null;
                    }
                } catch (IOException unused) {
                }
                if (this.f3161c != null) {
                    synchronized (f3157d) {
                        if (this.f3161c != null) {
                            this.f3161c.c();
                            this.f3161c = null;
                        }
                    }
                }
                try {
                    com.baidu.android.pushservice.c.a.a();
                } catch (Exception unused2) {
                }
                if (this.j) {
                    k();
                }
                f3156a = null;
            }
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            synchronized (f3157d) {
                this.f3161c = e.a(this.f3163h);
            }
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() + this.f3160b;
            int i2 = ((int) (currentTimeMillis / 1000)) % 60;
            if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
                currentTimeMillis += ((long) (Math.random() * (this.f3160b - 20000))) + 15000;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                currentTimeMillis = System.currentTimeMillis() + 60000;
                this.f3160b = 60000;
            }
            long j = currentTimeMillis;
            AlarmManager alarmManager = (AlarmManager) this.f3163h.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                try {
                    alarmManager.setRepeating(0, j, this.f3160b, s());
                    m = false;
                } catch (Exception unused) {
                }
            }
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "tryConnect", (short) 98) { // from class: com.baidu.android.pushservice.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ g f3165a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Short.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f3165a = this;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || g.f3156a == null) {
                        return;
                    }
                    boolean a2 = com.baidu.android.pushservice.j.g.a(this.f3165a.f3163h);
                    com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect networkConnected :" + a2, this.f3165a.f3163h);
                    if (a2) {
                        if (this.f3165a.f3161c != null && !this.f3165a.f3161c.a()) {
                            if (k.a(this.f3165a.f3163h).e()) {
                                this.f3165a.r();
                            }
                        } else if (this.f3165a.f3161c == null || !this.f3165a.f3161c.a()) {
                        } else {
                            com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect heartbeat", this.f3165a.f3163h);
                            this.f3165a.q();
                        }
                    }
                }
            });
        }
    }

    private boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (f3158e == null) {
                try {
                    f3158e = new LocalServerSocket(m.h(this.f3163h));
                    return true;
                } catch (Exception unused) {
                    com.baidu.android.pushservice.g.a.a("PushSDK", "--- Socket Adress (" + m.h(this.f3163h) + ") in use --- @ " + this.f3163h.getPackageName(), this.f3163h);
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            boolean a2 = com.baidu.android.pushservice.j.g.a(this.f3163h);
            com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.f3163h);
            if (m.b(this.f3163h)) {
                d();
                return false;
            } else if (!a2) {
                e eVar = this.f3161c;
                if (eVar != null) {
                    eVar.a(true);
                }
                return true;
            } else {
                e eVar2 = this.f3161c;
                if (eVar2 != null) {
                    if (eVar2.a()) {
                        this.f3161c.d();
                        if (!this.l) {
                            this.l = true;
                            m.k(f());
                        }
                    } else if (k.a(this.f3163h).e()) {
                        r();
                    }
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (f3158e != null || p()) {
                this.f3164i.removeCallbacks(this.o);
                this.f3164i.post(this.o);
            }
        }
    }

    private PendingIntent s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? PendingIntent.getBroadcast(this.f3163h.getApplicationContext(), 0, f.a(this.f3163h), 134217728) : (PendingIntent) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || m) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat set : " + i2 + " millisecs", this.f3163h);
        if (i2 > 0) {
            this.f3160b = i2;
        }
        n();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d();
            this.f3162f = Boolean.TRUE;
            com.baidu.android.pushservice.j.i.c(this.f3163h, "key_push_has_start", "push_service_has_start");
            if (m.b(this.f3163h.getApplicationContext())) {
                com.baidu.android.pushservice.g.a.a("PushSDK", "onCreate shouldStopSelf", this.f3163h);
                return false;
            }
            synchronized (f3159g) {
                if (PushSocket.f3522a) {
                    if (p()) {
                        boolean p = m.p(this.f3163h);
                        this.j = p;
                        if (p) {
                            j();
                        }
                        h.b(this.f3163h);
                        Thread.setDefaultUncaughtExceptionHandler(new b(this.f3163h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                        m();
                        i.a(this.f3163h);
                        if (f3158e != null) {
                            this.f3164i.postDelayed(this.n, 500L);
                            o();
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            if (intent == null) {
                intent = new Intent();
                com.baidu.android.pushservice.g.a.c("PushSDK", "--- handleOnStart by null intent!", this.f3163h);
            }
            if (!com.baidu.android.pushservice.b.d.q(this.f3163h) || com.baidu.android.pushservice.b.d.c(this.f3163h)) {
                if (!this.f3162f.booleanValue()) {
                    a();
                }
                m = intent.getBooleanExtra("disable_alarm", false);
                synchronized (f3159g) {
                    this.f3164i.removeCallbacks(this.n);
                    if (f3158e == null) {
                        String action = intent.getAction();
                        if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                            return true;
                        }
                        return c().a(intent);
                    } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                        return q();
                    } else {
                        if (!"pushservice_quit".equals(intent.getStringExtra("method")) || f3158e == null) {
                            if (!"com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) || f3158e == null) {
                                if (c().a(intent)) {
                                    com.baidu.android.pushservice.g.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.f3163h);
                                    return true;
                                }
                                o();
                                return true;
                            }
                            return b(intent);
                        }
                        return false;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) {
            e eVar = this.f3161c;
            if (eVar == null || !eVar.a()) {
                return true;
            }
            int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
            String stringExtra = intent.getStringExtra("message_id");
            String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
            this.f3161c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
            return true;
        }
        return invokeL.booleanValue;
    }

    public i c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i.a(this.f3163h) : (i) invokeV.objValue;
    }

    public void d() {
        AlarmManager alarmManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alarmManager = (AlarmManager) this.f3163h.getSystemService(NotificationCompat.CATEGORY_ALARM)) == null) {
            return;
        }
        try {
            alarmManager.cancel(s());
            m = true;
        } catch (Exception unused) {
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? m : invokeV.booleanValue;
    }

    public Context f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3163h : (Context) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f3162f.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.j.i.c(this.f3163h, "key_push_has_start"));
        }
        return invokeV.booleanValue;
    }
}
