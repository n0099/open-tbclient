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
import com.baidu.android.pushservice.i.m;
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
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f a;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f32946d;

    /* renamed from: e  reason: collision with root package name */
    public static LocalServerSocket f32947e;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f32948g;
    public static boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f32949b;

    /* renamed from: c  reason: collision with root package name */
    public d f32950c;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f32951f;

    /* renamed from: h  reason: collision with root package name */
    public Context f32952h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f32953i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f32954j;

    /* renamed from: k  reason: collision with root package name */
    public PushSystemNotifyReceiver f32955k;
    public boolean l;
    public Runnable n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-840926985, "Lcom/baidu/android/pushservice/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-840926985, "Lcom/baidu/android/pushservice/f;");
                return;
            }
        }
        f32946d = new Object();
        f32948g = new Object();
    }

    public f(Context context) {
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
        this.f32951f = Boolean.FALSE;
        this.n = new Runnable(this) { // from class: com.baidu.android.pushservice.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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
        this.f32953i = new Handler(context.getMainLooper());
        this.f32952h = context.getApplicationContext();
        this.f32949b = TiebaStatic.MAX_COST_VALUE;
    }

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (a == null) {
                synchronized (f.class) {
                    if (a == null) {
                        a = new f(context);
                    }
                }
            }
            return a;
        }
        return (f) invokeL.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            if (a != null) {
                a.k();
            }
            com.baidu.android.pushservice.g.e.a().b();
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            com.baidu.android.pushservice.g.e.a().a(new com.baidu.android.pushservice.g.c(this, "tryConnect", (short) 98, i2) { // from class: com.baidu.android.pushservice.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f32956b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Short.valueOf(r10), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32956b = this;
                    this.a = i2;
                }

                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && f.a != null && com.baidu.android.pushservice.i.g.a(this.f32956b.f32952h)) {
                        if (this.f32956b.f32950c != null && !this.f32956b.f32950c.a()) {
                            if (j.a(this.f32956b.f32952h).e()) {
                                this.f32956b.e(this.a);
                            }
                        } else if (this.f32956b.f32950c == null || !this.f32956b.f32950c.a()) {
                        } else {
                            com.baidu.android.pushservice.f.a.a("PushSDK", "tryConnect heartbeat", this.f32956b.f32952h);
                            this.f32956b.d(this.a);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) {
            boolean a2 = com.baidu.android.pushservice.i.g.a(this.f32952h);
            com.baidu.android.pushservice.f.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.f32952h);
            if (m.b(this.f32952h)) {
                c();
                return false;
            } else if (!a2) {
                d dVar = this.f32950c;
                if (dVar != null) {
                    dVar.a(true);
                }
                return true;
            } else {
                d dVar2 = this.f32950c;
                if (dVar2 != null) {
                    if (dVar2.a()) {
                        this.f32950c.c();
                        if (!this.l) {
                            this.l = true;
                            m.k(e());
                        }
                    } else if (j.a(this.f32952h).e()) {
                        e(i2);
                    }
                }
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i2) == null) {
            if (f32947e != null || n()) {
                Runnable runnable = new Runnable(this, i2) { // from class: com.baidu.android.pushservice.f.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ f f32957b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f32957b = this;
                        this.a = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (f.f32946d) {
                                if (this.f32957b.f32950c != null) {
                                    this.f32957b.f32950c.a(this.a);
                                }
                            }
                        }
                    }
                };
                this.f32953i.removeCallbacks(runnable);
                this.f32953i.post(runnable);
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.f32955k == null) {
            this.f32955k = new PushSystemNotifyReceiver();
            this.f32952h.getApplicationContext().registerReceiver(this.f32955k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.f32952h.getApplicationContext().registerReceiver(this.f32955k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.f32952h.getApplicationContext().registerReceiver(this.f32955k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.f32952h.getApplicationContext().registerReceiver(this.f32955k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.f32955k == null) {
            return;
        }
        this.f32952h.getApplicationContext().unregisterReceiver(this.f32955k);
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            com.baidu.android.pushservice.f.a.a("PushSDK", "destroy", this.f32952h);
            synchronized (f32948g) {
                try {
                    if (f32947e != null) {
                        f32947e.close();
                        f32947e = null;
                    }
                } catch (IOException unused) {
                }
                if (this.f32950c != null) {
                    synchronized (f32946d) {
                        if (this.f32950c != null) {
                            this.f32950c.b();
                            this.f32950c = null;
                        }
                    }
                }
                try {
                    com.baidu.android.pushservice.c.a.a();
                } catch (Exception unused2) {
                }
                if (this.f32954j) {
                    j();
                }
                a = null;
            }
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            synchronized (f32946d) {
                this.f32950c = d.a(this.f32952h);
            }
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || com.baidu.android.pushservice.i.i.b(this.f32952h.getApplicationContext(), "key_push_launch_task_level", 0) == 1) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.f32949b;
        int i2 = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
            currentTimeMillis += ((long) (Math.random() * (this.f32949b - 20000))) + 15000;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            currentTimeMillis = System.currentTimeMillis() + 60000;
            this.f32949b = 60000;
        }
        long j2 = currentTimeMillis;
        AlarmManager alarmManager = (AlarmManager) this.f32952h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.setRepeating(0, j2, this.f32949b, o());
                m = false;
            } catch (Exception unused) {
            }
        }
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (f32947e == null) {
                try {
                    f32947e = new LocalServerSocket(m.h(this.f32952h));
                    return true;
                } catch (Exception unused) {
                    com.baidu.android.pushservice.f.a.a("PushSDK", "--- Socket Adress (" + m.h(this.f32952h) + ") in use --- @ " + this.f32952h.getPackageName(), this.f32952h);
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private PendingIntent o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? PendingIntent.getBroadcast(this.f32952h.getApplicationContext(), 0, e.a(this.f32952h), 134217728) : (PendingIntent) invokeV.objValue;
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            c();
            this.f32951f = Boolean.TRUE;
            com.baidu.android.pushservice.i.i.c(this.f32952h, "key_push_has_start", "push_service_has_start");
            if (m.b(this.f32952h.getApplicationContext())) {
                com.baidu.android.pushservice.f.a.a("PushSDK", "onCreate shouldStopSelf", this.f32952h);
                return false;
            }
            synchronized (f32948g) {
                if (PushSocket.a) {
                    if (n()) {
                        boolean p = m.p(this.f32952h);
                        this.f32954j = p;
                        if (p) {
                            i();
                        }
                        g.b(this.f32952h);
                        Thread.setDefaultUncaughtExceptionHandler(new b(this.f32952h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                        l();
                        h.a(this.f32952h);
                        if (f32947e != null) {
                            this.f32953i.postDelayed(this.n, 500L);
                            c(i2);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            if (intent == null) {
                intent = new Intent();
                com.baidu.android.pushservice.f.a.c("PushSDK", "--- handleOnStart by null intent!", this.f32952h);
            }
            if (!com.baidu.android.pushservice.b.d.q(this.f32952h) || com.baidu.android.pushservice.b.d.c(this.f32952h)) {
                int intExtra = intent.getIntExtra("push_start_source", 0);
                if (!this.f32951f.booleanValue()) {
                    a(intExtra);
                }
                m = intent.getBooleanExtra("disable_alarm", false);
                synchronized (f32948g) {
                    this.f32953i.removeCallbacks(this.n);
                    if (f32947e == null) {
                        String action = intent.getAction();
                        if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                            return true;
                        }
                        return b().a(intent);
                    } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                        return d(intExtra);
                    } else {
                        if (!"pushservice_quit".equals(intent.getStringExtra("method")) || f32947e == null) {
                            if (!"com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) || f32947e == null) {
                                if (b().a(intent)) {
                                    com.baidu.android.pushservice.f.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.f32952h);
                                    return true;
                                }
                                c(intExtra);
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

    public h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? h.a(this.f32952h) : (h) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || m) {
            return;
        }
        com.baidu.android.pushservice.f.a.a("PushSDK", "heartbeat set : " + i2 + " millisecs", this.f32952h);
        if (i2 > 0) {
            this.f32949b = i2;
        }
        m();
    }

    public boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, intent)) == null) {
            d dVar = this.f32950c;
            if (dVar == null || !dVar.a()) {
                return true;
            }
            int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
            String stringExtra = intent.getStringExtra("message_id");
            String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
            this.f32950c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        AlarmManager alarmManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alarmManager = (AlarmManager) this.f32952h.getSystemService(NotificationCompat.CATEGORY_ALARM)) == null) {
            return;
        }
        try {
            alarmManager.cancel(o());
            m = true;
        } catch (Exception unused) {
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? m : invokeV.booleanValue;
    }

    public Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f32952h : (Context) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f32951f.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.i.i.c(this.f32952h, "key_push_has_start"));
        }
        return invokeV.booleanValue;
    }
}
