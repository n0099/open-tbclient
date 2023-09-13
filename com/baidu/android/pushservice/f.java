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
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.searchbox.dns.stratege.DnsStrategy;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
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
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f k;
    public static final Object l;
    public static LocalServerSocket m;
    public static final Object n;
    public static boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public d c;
    public Boolean d;
    public Context e;
    public Handler f;
    public boolean g;
    public PushSystemNotifyReceiver h;
    public boolean i;
    public Runnable j;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int c;
        public final /* synthetic */ f d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, String str, short s, int i) {
            super(str, s);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, Short.valueOf(s), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fVar;
            this.c = i;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f.k != null && com.baidu.android.pushservice.a0.g.d(this.d.e)) {
                if (this.d.c != null && !this.d.c.f()) {
                    if (j.a(this.d.e).e()) {
                        this.d.c(this.c);
                    }
                } else if (this.d.c == null || !this.d.c.f()) {
                } else {
                    com.baidu.android.pushservice.u.a.a("PushSDK", "tryConnect heartbeat", this.d.e);
                    this.d.a(this.c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(new Intent());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ f b;

        public c(f fVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (f.l) {
                    if (this.b.c != null) {
                        this.b.c.a(this.a);
                    }
                }
            }
        }
    }

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
        l = new Object();
        n = new Object();
    }

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.d = Boolean.FALSE;
        this.j = new b(this);
        this.f = new Handler(context.getMainLooper());
        this.e = context.getApplicationContext();
        this.a = DnsStrategy.Factory.PRE_FETCH_INTERVAL;
    }

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (k == null) {
                synchronized (f.class) {
                    if (k == null) {
                        k = new f(context);
                    }
                }
            }
            return k;
        }
        return (f) invokeL.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            if (k != null) {
                k.e();
            }
            com.baidu.android.pushservice.z.e.a().b();
        }
    }

    public void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (com.baidu.android.pushservice.a0.i.a(this.e.getApplicationContext(), "key_push_launch_task_level", 0) == 1) {
                c();
                return;
            }
            this.b = z;
            AlarmManager alarmManager = (AlarmManager) this.e.getSystemService(NotificationCompat.CATEGORY_ALARM);
            try {
                long j = i * 1000;
                long currentTimeMillis = System.currentTimeMillis() + j;
                if (alarmManager != null) {
                    alarmManager.cancel(f());
                    if (z) {
                        alarmManager.setRepeating(0, currentTimeMillis, j, f());
                    }
                    o = false;
                }
            } catch (Exception unused) {
            }
        }
    }

    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            boolean d = com.baidu.android.pushservice.a0.g.d(this.e);
            com.baidu.android.pushservice.u.a.a("PushSDK", "heartbeat networkConnected :" + d, this.e);
            if (Utility.C(this.e)) {
                c();
                return false;
            } else if (!d) {
                d dVar = this.c;
                if (dVar != null) {
                    dVar.a(true);
                }
                return true;
            } else {
                d dVar2 = this.c;
                if (dVar2 != null) {
                    if (dVar2.f()) {
                        this.c.g(i);
                        if (!this.i) {
                            this.i = true;
                            Utility.Y(g());
                        }
                    } else if (j.a(this.e).e()) {
                        c(i);
                    }
                }
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            if (intent == null) {
                intent = new Intent();
                com.baidu.android.pushservice.u.a.c("PushSDK", "--- handleOnStart by null intent!", this.e);
            }
            if (!com.baidu.android.pushservice.l.d.r(this.e) || com.baidu.android.pushservice.l.d.q(this.e)) {
                int intExtra = intent.getIntExtra("push_start_source", 0);
                if (!this.d.booleanValue()) {
                    b(intExtra);
                }
                o = intent.getBooleanExtra("disable_alarm", false);
                synchronized (n) {
                    this.f.removeCallbacks(this.j);
                    if (m == null) {
                        String action = intent.getAction();
                        if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                            return true;
                        }
                        return h().c(intent);
                    } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                        return a(intExtra);
                    } else {
                        if (!"pushservice_quit".equals(intent.getStringExtra("method")) || m == null) {
                            if (!"com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) || m == null) {
                                if (h().c(intent)) {
                                    com.baidu.android.pushservice.u.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.e);
                                    return true;
                                }
                                e(intExtra);
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

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            c();
            this.d = Boolean.TRUE;
            com.baidu.android.pushservice.a0.i.a(this.e, "key_push_has_start", "push_service_has_start");
            if (Utility.C(this.e.getApplicationContext())) {
                com.baidu.android.pushservice.u.a.a("PushSDK", "onCreate shouldStopSelf", this.e);
                return false;
            }
            synchronized (n) {
                if (PushSocket.b) {
                    if (m()) {
                        boolean E = Utility.E(this.e);
                        this.g = E;
                        if (E) {
                            l();
                        }
                        g.d(this.e);
                        Thread.setDefaultUncaughtExceptionHandler(new com.baidu.android.pushservice.b(this.e.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                        k();
                        h.a(this.e);
                        if (m != null) {
                            this.f.postDelayed(this.j, 500L);
                            e(i);
                        }
                        com.baidu.android.pushservice.v.c.a().c(this.e);
                        com.baidu.android.pushservice.v.c.a().g(this.e);
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, intent)) == null) {
            d dVar = this.c;
            if (dVar == null || !dVar.f()) {
                return true;
            }
            int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
            String stringExtra = intent.getStringExtra("message_id");
            String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
            this.c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        AlarmManager alarmManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alarmManager = (AlarmManager) this.e.getSystemService(NotificationCompat.CATEGORY_ALARM)) == null) {
            return;
        }
        try {
            alarmManager.cancel(f());
            o = true;
        } catch (Exception unused) {
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (m != null || m()) {
                c cVar = new c(this, i);
                this.f.removeCallbacks(cVar);
                this.f.post(cVar);
            }
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || o) {
            return;
        }
        com.baidu.android.pushservice.u.a.a("PushSDK", "heartbeat set : " + i + " millisecs", this.e);
        if (i > 0) {
            this.a = i;
        }
        n();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.baidu.android.pushservice.u.a.a("PushSDK", "destroy", this.e);
            synchronized (n) {
                try {
                    if (m != null) {
                        m.close();
                        m = null;
                    }
                } catch (IOException unused) {
                }
                if (this.c != null) {
                    synchronized (l) {
                        if (this.c != null) {
                            this.c.i();
                            this.c = null;
                        }
                    }
                }
                try {
                    com.baidu.android.pushservice.m.b.a();
                } catch (Exception unused2) {
                }
                if (this.g) {
                    o();
                }
                k = null;
            }
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            com.baidu.android.pushservice.z.e.a().a(new a(this, "tryConnect", (short) 98, i));
        }
    }

    public final PendingIntent f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? PendingIntent.getBroadcast(this.e.getApplicationContext(), 0, e.j(this.e), Utility.a((int) SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION)) : (PendingIntent) invokeV.objValue;
    }

    public Context g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e : (Context) invokeV.objValue;
    }

    public h h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? h.a(this.e) : (h) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.a0.i.a(this.e, "key_push_has_start"));
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? o : invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (l) {
                this.c = d.a(this.e);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.h == null) {
                this.h = new PushSystemNotifyReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
                intentFilter.addAction("android.intent.action.INSTALL_PACKAGE");
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_CHECKING");
                intentFilter.addAction("android.intent.action.MEDIA_EJECT");
                intentFilter.addAction("com.oppo.intent.action.KEY_LOCK_MODE");
                intentFilter.addAction("com.oplus.intent.action.KEY_LOCK_MODE");
                intentFilter.addAction("com.xiaomi.push.service_started");
                intentFilter.addAction("android.intent.action.TIME_SET");
                intentFilter.addAction("miui.intent.action.LOCATION_CHANGED");
                intentFilter.addAction("android.app.action.NEXT_ALARM_CLOCK_CHANGED");
                intentFilter.addAction("android.intent.category.DEFAULT");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                intentFilter.addAction(ShortcutManagerCompat.ACTION_INSTALL_SHORTCUT);
                intentFilter.addAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
                intentFilter.addAction("android.appwidget.action.APPWIDGET_UPDATE");
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
                intentFilter.addAction("com.insdio.aqicn.airwidget.intent.action.CLICK");
                intentFilter.addAction("android.intent.action.ANALOG_AUDIO_DOCK_PLUG");
                intentFilter.addAction("android.appwidget.action.APPWIDGET_PICK");
                intentFilter.addAction("com.android.systemui.fsgesture");
                intentFilter.addAction("vivo.intent.action.STATUS_BAR_STATE_CHANGED");
                intentFilter.addAction("com.huawei.systemmanager.action.REQUEST_TRIM_ALL");
                intentFilter.addAction("com.huawei.systemmanager.action.REQUEST_ONEKEYCLEAN");
                this.e.getApplicationContext().registerReceiver(this.h, intentFilter);
            }
            com.baidu.android.pushservice.v.c.a().e(this.e);
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (m == null) {
                try {
                    m = new LocalServerSocket(Utility.w(this.e));
                    return true;
                } catch (Exception unused) {
                    com.baidu.android.pushservice.u.a.a("PushSDK", "--- Socket Adress (" + Utility.w(this.e) + ") in use --- @ " + this.e.getPackageName(), this.e);
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || com.baidu.android.pushservice.a0.i.a(this.e.getApplicationContext(), "key_push_launch_task_level", 0) == 1) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.a;
        int i2 = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
            currentTimeMillis += ((long) (Math.random() * (this.a - 20000))) + 15000;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (!this.b || com.baidu.android.pushservice.y.c.b(this.e) <= 0) {
                currentTimeMillis = System.currentTimeMillis() + 60000;
                i = 60000;
            } else {
                currentTimeMillis = System.currentTimeMillis() + (com.baidu.android.pushservice.y.c.b(this.e) * 1000);
                i = com.baidu.android.pushservice.y.c.b(this.e) * 1000;
            }
            this.a = i;
        }
        long j = currentTimeMillis;
        AlarmManager alarmManager = (AlarmManager) this.e.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.setRepeating(0, j, this.a, f());
                o = false;
            } catch (Exception unused) {
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.h != null) {
                try {
                    this.e.getApplicationContext().unregisterReceiver(this.h);
                    this.h = null;
                } catch (IllegalArgumentException unused) {
                }
            }
            com.baidu.android.pushservice.v.c.a().f(this.e);
        }
    }
}
