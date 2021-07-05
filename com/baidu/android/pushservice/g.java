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
import com.kwai.video.player.NativeErrorCode;
import java.io.IOException;
@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f3127a;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3128d;

    /* renamed from: e  reason: collision with root package name */
    public static LocalServerSocket f3129e;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f3130g;
    public static boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f3131b;

    /* renamed from: c  reason: collision with root package name */
    public e f3132c;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f3133f;

    /* renamed from: h  reason: collision with root package name */
    public Context f3134h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f3135i;
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
        f3128d = new Object();
        f3130g = new Object();
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
        this.f3133f = Boolean.FALSE;
        this.n = new Runnable(this) { // from class: com.baidu.android.pushservice.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f3137a;

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
                this.f3137a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f3137a.a(new Intent());
                }
            }
        };
        this.o = new Runnable(this) { // from class: com.baidu.android.pushservice.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f3138a;

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
                this.f3138a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (g.f3128d) {
                        if (this.f3138a.f3132c != null) {
                            this.f3138a.f3132c.b();
                        }
                    }
                }
            }
        };
        this.f3135i = new Handler(context.getMainLooper());
        this.f3134h = context.getApplicationContext();
        this.f3131b = TiebaStatic.MAX_COST_VALUE;
    }

    public static g a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f3127a == null) {
                synchronized (g.class) {
                    if (f3127a == null) {
                        f3127a = new g(context);
                    }
                }
            }
            return f3127a;
        }
        return (g) invokeL.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            if (f3127a != null) {
                f3127a.l();
            }
            com.baidu.android.pushservice.h.d.a().b();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.k == null) {
            this.k = new PushServiceReceiver();
            this.f3134h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.f3134h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.f3134h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.f3134h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.k == null) {
            return;
        }
        this.f3134h.getApplicationContext().unregisterReceiver(this.k);
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.baidu.android.pushservice.g.a.a("PushSDK", "destroy", this.f3134h);
            synchronized (f3130g) {
                try {
                    if (f3129e != null) {
                        f3129e.close();
                        f3129e = null;
                    }
                } catch (IOException unused) {
                }
                if (this.f3132c != null) {
                    synchronized (f3128d) {
                        if (this.f3132c != null) {
                            this.f3132c.c();
                            this.f3132c = null;
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
                f3127a = null;
            }
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            synchronized (f3128d) {
                this.f3132c = e.a(this.f3134h);
            }
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() + this.f3131b;
            int i2 = ((int) (currentTimeMillis / 1000)) % 60;
            if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
                currentTimeMillis += ((long) (Math.random() * (this.f3131b + NativeErrorCode.EKS_UNKNOWN_ERROR_BASE))) + 15000;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                currentTimeMillis = System.currentTimeMillis() + 60000;
                this.f3131b = 60000;
            }
            long j = currentTimeMillis;
            AlarmManager alarmManager = (AlarmManager) this.f3134h.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                try {
                    alarmManager.setRepeating(0, j, this.f3131b, s());
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
                public final /* synthetic */ g f3136a;

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
                    this.f3136a = this;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || g.f3127a == null) {
                        return;
                    }
                    boolean a2 = com.baidu.android.pushservice.j.g.a(this.f3136a.f3134h);
                    com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect networkConnected :" + a2, this.f3136a.f3134h);
                    if (a2) {
                        if (this.f3136a.f3132c != null && !this.f3136a.f3132c.a()) {
                            if (k.a(this.f3136a.f3134h).e()) {
                                this.f3136a.r();
                            }
                        } else if (this.f3136a.f3132c == null || !this.f3136a.f3132c.a()) {
                        } else {
                            com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect heartbeat", this.f3136a.f3134h);
                            this.f3136a.q();
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
            if (f3129e == null) {
                try {
                    f3129e = new LocalServerSocket(m.h(this.f3134h));
                    return true;
                } catch (Exception unused) {
                    com.baidu.android.pushservice.g.a.a("PushSDK", "--- Socket Adress (" + m.h(this.f3134h) + ") in use --- @ " + this.f3134h.getPackageName(), this.f3134h);
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
            boolean a2 = com.baidu.android.pushservice.j.g.a(this.f3134h);
            com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.f3134h);
            if (m.b(this.f3134h)) {
                d();
                return false;
            } else if (!a2) {
                e eVar = this.f3132c;
                if (eVar != null) {
                    eVar.a(true);
                }
                return true;
            } else {
                e eVar2 = this.f3132c;
                if (eVar2 != null) {
                    if (eVar2.a()) {
                        this.f3132c.d();
                        if (!this.l) {
                            this.l = true;
                            m.k(f());
                        }
                    } else if (k.a(this.f3134h).e()) {
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
            if (f3129e != null || p()) {
                this.f3135i.removeCallbacks(this.o);
                this.f3135i.post(this.o);
            }
        }
    }

    private PendingIntent s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? PendingIntent.getBroadcast(this.f3134h.getApplicationContext(), 0, f.a(this.f3134h), 134217728) : (PendingIntent) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || m) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat set : " + i2 + " millisecs", this.f3134h);
        if (i2 > 0) {
            this.f3131b = i2;
        }
        n();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d();
            this.f3133f = Boolean.TRUE;
            com.baidu.android.pushservice.j.i.c(this.f3134h, "key_push_has_start", "push_service_has_start");
            if (m.b(this.f3134h.getApplicationContext())) {
                com.baidu.android.pushservice.g.a.a("PushSDK", "onCreate shouldStopSelf", this.f3134h);
                return false;
            }
            synchronized (f3130g) {
                if (PushSocket.f3493a) {
                    if (p()) {
                        boolean p = m.p(this.f3134h);
                        this.j = p;
                        if (p) {
                            j();
                        }
                        h.b(this.f3134h);
                        Thread.setDefaultUncaughtExceptionHandler(new b(this.f3134h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                        m();
                        i.a(this.f3134h);
                        if (f3129e != null) {
                            this.f3135i.postDelayed(this.n, 500L);
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
                com.baidu.android.pushservice.g.a.c("PushSDK", "--- handleOnStart by null intent!", this.f3134h);
            }
            if (!com.baidu.android.pushservice.b.d.q(this.f3134h) || com.baidu.android.pushservice.b.d.c(this.f3134h)) {
                if (!this.f3133f.booleanValue()) {
                    a();
                }
                m = intent.getBooleanExtra("disable_alarm", false);
                synchronized (f3130g) {
                    this.f3135i.removeCallbacks(this.n);
                    if (f3129e == null) {
                        String action = intent.getAction();
                        if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                            return true;
                        }
                        return c().a(intent);
                    } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                        return q();
                    } else {
                        if (!"pushservice_quit".equals(intent.getStringExtra("method")) || f3129e == null) {
                            if (!"com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) || f3129e == null) {
                                if (c().a(intent)) {
                                    com.baidu.android.pushservice.g.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.f3134h);
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
            e eVar = this.f3132c;
            if (eVar == null || !eVar.a()) {
                return true;
            }
            int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
            String stringExtra = intent.getStringExtra("message_id");
            String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
            this.f3132c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
            return true;
        }
        return invokeL.booleanValue;
    }

    public i c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i.a(this.f3134h) : (i) invokeV.objValue;
    }

    public void d() {
        AlarmManager alarmManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alarmManager = (AlarmManager) this.f3134h.getSystemService(NotificationCompat.CATEGORY_ALARM)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3134h : (Context) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f3133f.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.j.i.c(this.f3134h, "key_push_has_start"));
        }
        return invokeV.booleanValue;
    }
}
