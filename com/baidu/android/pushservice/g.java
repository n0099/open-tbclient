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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f37044a;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f37045d;

    /* renamed from: e  reason: collision with root package name */
    public static LocalServerSocket f37046e;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f37047g;
    public static boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f37048b;

    /* renamed from: c  reason: collision with root package name */
    public e f37049c;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f37050f;

    /* renamed from: h  reason: collision with root package name */
    public Context f37051h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f37052i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37053j;
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
        f37045d = new Object();
        f37047g = new Object();
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
        this.f37050f = Boolean.FALSE;
        this.n = new Runnable(this) { // from class: com.baidu.android.pushservice.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f37055a;

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
                this.f37055a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f37055a.a(new Intent());
                }
            }
        };
        this.o = new Runnable(this) { // from class: com.baidu.android.pushservice.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f37056a;

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
                this.f37056a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (g.f37045d) {
                        if (this.f37056a.f37049c != null) {
                            this.f37056a.f37049c.b();
                        }
                    }
                }
            }
        };
        this.f37052i = new Handler(context.getMainLooper());
        this.f37051h = context.getApplicationContext();
        this.f37048b = TiebaStatic.MAX_COST_VALUE;
    }

    public static g a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f37044a == null) {
                synchronized (g.class) {
                    if (f37044a == null) {
                        f37044a = new g(context);
                    }
                }
            }
            return f37044a;
        }
        return (g) invokeL.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            if (f37044a != null) {
                f37044a.l();
            }
            com.baidu.android.pushservice.h.d.a().b();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.k == null) {
            this.k = new PushServiceReceiver();
            this.f37051h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.f37051h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.f37051h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.f37051h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.k == null) {
            return;
        }
        this.f37051h.getApplicationContext().unregisterReceiver(this.k);
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.baidu.android.pushservice.g.a.a("PushSDK", "destroy", this.f37051h);
            synchronized (f37047g) {
                try {
                    if (f37046e != null) {
                        f37046e.close();
                        f37046e = null;
                    }
                } catch (IOException unused) {
                }
                if (this.f37049c != null) {
                    synchronized (f37045d) {
                        if (this.f37049c != null) {
                            this.f37049c.c();
                            this.f37049c = null;
                        }
                    }
                }
                try {
                    com.baidu.android.pushservice.c.a.a();
                } catch (Exception unused2) {
                }
                if (this.f37053j) {
                    k();
                }
                f37044a = null;
            }
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            synchronized (f37045d) {
                this.f37049c = e.a(this.f37051h);
            }
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() + this.f37048b;
            int i2 = ((int) (currentTimeMillis / 1000)) % 60;
            if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
                currentTimeMillis += ((long) (Math.random() * (this.f37048b - 20000))) + 15000;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                currentTimeMillis = System.currentTimeMillis() + 60000;
                this.f37048b = 60000;
            }
            long j2 = currentTimeMillis;
            AlarmManager alarmManager = (AlarmManager) this.f37051h.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                try {
                    alarmManager.setRepeating(0, j2, this.f37048b, s());
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
                public final /* synthetic */ g f37054a;

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
                    this.f37054a = this;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || g.f37044a == null) {
                        return;
                    }
                    boolean a2 = com.baidu.android.pushservice.j.g.a(this.f37054a.f37051h);
                    com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect networkConnected :" + a2, this.f37054a.f37051h);
                    if (a2) {
                        if (this.f37054a.f37049c != null && !this.f37054a.f37049c.a()) {
                            if (k.a(this.f37054a.f37051h).e()) {
                                this.f37054a.r();
                            }
                        } else if (this.f37054a.f37049c == null || !this.f37054a.f37049c.a()) {
                        } else {
                            com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect heartbeat", this.f37054a.f37051h);
                            this.f37054a.q();
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
            if (f37046e == null) {
                try {
                    f37046e = new LocalServerSocket(m.h(this.f37051h));
                    return true;
                } catch (Exception unused) {
                    com.baidu.android.pushservice.g.a.a("PushSDK", "--- Socket Adress (" + m.h(this.f37051h) + ") in use --- @ " + this.f37051h.getPackageName(), this.f37051h);
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
            boolean a2 = com.baidu.android.pushservice.j.g.a(this.f37051h);
            com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.f37051h);
            if (m.b(this.f37051h)) {
                d();
                return false;
            } else if (!a2) {
                e eVar = this.f37049c;
                if (eVar != null) {
                    eVar.a(true);
                }
                return true;
            } else {
                e eVar2 = this.f37049c;
                if (eVar2 != null) {
                    if (eVar2.a()) {
                        this.f37049c.d();
                        if (!this.l) {
                            this.l = true;
                            m.k(f());
                        }
                    } else if (k.a(this.f37051h).e()) {
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
            if (f37046e != null || p()) {
                this.f37052i.removeCallbacks(this.o);
                this.f37052i.post(this.o);
            }
        }
    }

    private PendingIntent s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? PendingIntent.getBroadcast(this.f37051h.getApplicationContext(), 0, f.a(this.f37051h), 134217728) : (PendingIntent) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || m) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat set : " + i2 + " millisecs", this.f37051h);
        if (i2 > 0) {
            this.f37048b = i2;
        }
        n();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d();
            this.f37050f = Boolean.TRUE;
            com.baidu.android.pushservice.j.i.c(this.f37051h, "key_push_has_start", "push_service_has_start");
            if (m.b(this.f37051h.getApplicationContext())) {
                com.baidu.android.pushservice.g.a.a("PushSDK", "onCreate shouldStopSelf", this.f37051h);
                return false;
            }
            synchronized (f37047g) {
                if (PushSocket.f37424a) {
                    if (p()) {
                        boolean p = m.p(this.f37051h);
                        this.f37053j = p;
                        if (p) {
                            j();
                        }
                        h.b(this.f37051h);
                        Thread.setDefaultUncaughtExceptionHandler(new b(this.f37051h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                        m();
                        i.a(this.f37051h);
                        if (f37046e != null) {
                            this.f37052i.postDelayed(this.n, 500L);
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
                com.baidu.android.pushservice.g.a.c("PushSDK", "--- handleOnStart by null intent!", this.f37051h);
            }
            if (!com.baidu.android.pushservice.b.d.q(this.f37051h) || com.baidu.android.pushservice.b.d.c(this.f37051h)) {
                if (!this.f37050f.booleanValue()) {
                    a();
                }
                m = intent.getBooleanExtra("disable_alarm", false);
                synchronized (f37047g) {
                    this.f37052i.removeCallbacks(this.n);
                    if (f37046e == null) {
                        String action = intent.getAction();
                        if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                            return true;
                        }
                        return c().a(intent);
                    } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                        return q();
                    } else {
                        if (!"pushservice_quit".equals(intent.getStringExtra("method")) || f37046e == null) {
                            if (!"com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) || f37046e == null) {
                                if (c().a(intent)) {
                                    com.baidu.android.pushservice.g.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.f37051h);
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
            e eVar = this.f37049c;
            if (eVar == null || !eVar.a()) {
                return true;
            }
            int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
            String stringExtra = intent.getStringExtra("message_id");
            String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
            this.f37049c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
            return true;
        }
        return invokeL.booleanValue;
    }

    public i c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i.a(this.f37051h) : (i) invokeV.objValue;
    }

    public void d() {
        AlarmManager alarmManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alarmManager = (AlarmManager) this.f37051h.getSystemService(NotificationCompat.CATEGORY_ALARM)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37051h : (Context) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f37050f.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.j.i.c(this.f37051h, "key_push_has_start"));
        }
        return invokeV.booleanValue;
    }
}
