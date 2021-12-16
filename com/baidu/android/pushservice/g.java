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
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g a;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f32852d;

    /* renamed from: e  reason: collision with root package name */
    public static LocalServerSocket f32853e;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f32854g;
    public static boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f32855b;

    /* renamed from: c  reason: collision with root package name */
    public e f32856c;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f32857f;

    /* renamed from: h  reason: collision with root package name */
    public Context f32858h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f32859i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f32860j;

    /* renamed from: k  reason: collision with root package name */
    public PushServiceReceiver f32861k;
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
        f32852d = new Object();
        f32854g = new Object();
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
        this.f32857f = Boolean.FALSE;
        this.n = new Runnable(this) { // from class: com.baidu.android.pushservice.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.a(new Intent());
                }
            }
        };
        this.o = new Runnable(this) { // from class: com.baidu.android.pushservice.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (g.f32852d) {
                        if (this.a.f32856c != null) {
                            this.a.f32856c.b();
                        }
                    }
                }
            }
        };
        this.f32859i = new Handler(context.getMainLooper());
        this.f32858h = context.getApplicationContext();
        this.f32855b = TiebaStatic.MAX_COST_VALUE;
    }

    public static g a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (a == null) {
                synchronized (g.class) {
                    if (a == null) {
                        a = new g(context);
                    }
                }
            }
            return a;
        }
        return (g) invokeL.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            if (a != null) {
                a.l();
            }
            com.baidu.android.pushservice.h.d.a().b();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.f32861k == null) {
            this.f32861k = new PushServiceReceiver();
            this.f32858h.getApplicationContext().registerReceiver(this.f32861k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.f32858h.getApplicationContext().registerReceiver(this.f32861k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.f32858h.getApplicationContext().registerReceiver(this.f32861k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.f32858h.getApplicationContext().registerReceiver(this.f32861k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.f32861k == null) {
            return;
        }
        this.f32858h.getApplicationContext().unregisterReceiver(this.f32861k);
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.baidu.android.pushservice.g.a.a("PushSDK", "destroy", this.f32858h);
            synchronized (f32854g) {
                try {
                    if (f32853e != null) {
                        f32853e.close();
                        f32853e = null;
                    }
                } catch (IOException unused) {
                }
                if (this.f32856c != null) {
                    synchronized (f32852d) {
                        if (this.f32856c != null) {
                            this.f32856c.c();
                            this.f32856c = null;
                        }
                    }
                }
                try {
                    com.baidu.android.pushservice.c.a.a();
                } catch (Exception unused2) {
                }
                if (this.f32860j) {
                    k();
                }
                a = null;
            }
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            synchronized (f32852d) {
                this.f32856c = e.a(this.f32858h);
            }
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() + this.f32855b;
            int i2 = ((int) (currentTimeMillis / 1000)) % 60;
            if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
                currentTimeMillis += ((long) (Math.random() * (this.f32855b - 20000))) + 15000;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                currentTimeMillis = System.currentTimeMillis() + 60000;
                this.f32855b = 60000;
            }
            long j2 = currentTimeMillis;
            AlarmManager alarmManager = (AlarmManager) this.f32858h.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                try {
                    alarmManager.setRepeating(0, j2, this.f32855b, s());
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
                public final /* synthetic */ g a;

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
                    this.a = this;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || g.a == null) {
                        return;
                    }
                    boolean a2 = com.baidu.android.pushservice.j.g.a(this.a.f32858h);
                    com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect networkConnected :" + a2, this.a.f32858h);
                    if (a2) {
                        if (this.a.f32856c != null && !this.a.f32856c.a()) {
                            if (k.a(this.a.f32858h).e()) {
                                this.a.r();
                            }
                        } else if (this.a.f32856c == null || !this.a.f32856c.a()) {
                        } else {
                            com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect heartbeat", this.a.f32858h);
                            this.a.q();
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
            if (f32853e == null) {
                try {
                    f32853e = new LocalServerSocket(m.h(this.f32858h));
                    return true;
                } catch (Exception unused) {
                    com.baidu.android.pushservice.g.a.a("PushSDK", "--- Socket Adress (" + m.h(this.f32858h) + ") in use --- @ " + this.f32858h.getPackageName(), this.f32858h);
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
            boolean a2 = com.baidu.android.pushservice.j.g.a(this.f32858h);
            com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.f32858h);
            if (m.b(this.f32858h)) {
                d();
                return false;
            } else if (!a2) {
                e eVar = this.f32856c;
                if (eVar != null) {
                    eVar.a(true);
                }
                return true;
            } else {
                e eVar2 = this.f32856c;
                if (eVar2 != null) {
                    if (eVar2.a()) {
                        this.f32856c.d();
                        if (!this.l) {
                            this.l = true;
                            m.k(f());
                        }
                    } else if (k.a(this.f32858h).e()) {
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
            if (f32853e != null || p()) {
                this.f32859i.removeCallbacks(this.o);
                this.f32859i.post(this.o);
            }
        }
    }

    private PendingIntent s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? PendingIntent.getBroadcast(this.f32858h.getApplicationContext(), 0, f.a(this.f32858h), 134217728) : (PendingIntent) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || m) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat set : " + i2 + " millisecs", this.f32858h);
        if (i2 > 0) {
            this.f32855b = i2;
        }
        n();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d();
            this.f32857f = Boolean.TRUE;
            com.baidu.android.pushservice.j.i.c(this.f32858h, "key_push_has_start", "push_service_has_start");
            if (m.b(this.f32858h.getApplicationContext())) {
                com.baidu.android.pushservice.g.a.a("PushSDK", "onCreate shouldStopSelf", this.f32858h);
                return false;
            }
            synchronized (f32854g) {
                if (PushSocket.a) {
                    if (p()) {
                        boolean p = m.p(this.f32858h);
                        this.f32860j = p;
                        if (p) {
                            j();
                        }
                        h.b(this.f32858h);
                        Thread.setDefaultUncaughtExceptionHandler(new b(this.f32858h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                        m();
                        i.a(this.f32858h);
                        if (f32853e != null) {
                            this.f32859i.postDelayed(this.n, 500L);
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
                com.baidu.android.pushservice.g.a.c("PushSDK", "--- handleOnStart by null intent!", this.f32858h);
            }
            if (!com.baidu.android.pushservice.b.d.q(this.f32858h) || com.baidu.android.pushservice.b.d.c(this.f32858h)) {
                if (!this.f32857f.booleanValue()) {
                    a();
                }
                m = intent.getBooleanExtra("disable_alarm", false);
                synchronized (f32854g) {
                    this.f32859i.removeCallbacks(this.n);
                    if (f32853e == null) {
                        String action = intent.getAction();
                        if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                            return true;
                        }
                        return c().a(intent);
                    } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                        return q();
                    } else {
                        if (!"pushservice_quit".equals(intent.getStringExtra("method")) || f32853e == null) {
                            if (!"com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) || f32853e == null) {
                                if (c().a(intent)) {
                                    com.baidu.android.pushservice.g.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.f32858h);
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
            e eVar = this.f32856c;
            if (eVar == null || !eVar.a()) {
                return true;
            }
            int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
            String stringExtra = intent.getStringExtra("message_id");
            String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
            this.f32856c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
            return true;
        }
        return invokeL.booleanValue;
    }

    public i c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i.a(this.f32858h) : (i) invokeV.objValue;
    }

    public void d() {
        AlarmManager alarmManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alarmManager = (AlarmManager) this.f32858h.getSystemService(NotificationCompat.CATEGORY_ALARM)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f32858h : (Context) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f32857f.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.j.i.c(this.f32858h, "key_push_has_start"));
        }
        return invokeV.booleanValue;
    }
}
