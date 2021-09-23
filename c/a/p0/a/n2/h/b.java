package c.a.p0.a.n2.h;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import androidx.annotation.UiThread;
import c.a.p0.a.g1.g;
import c.a.p0.a.h;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.w;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7721a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f7722b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f7723c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f7724d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f7725e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f7726f;

    /* renamed from: g  reason: collision with root package name */
    public static long f7727g;

    /* renamed from: h  reason: collision with root package name */
    public static long f7728h;

    /* renamed from: i  reason: collision with root package name */
    public static SwanAppAlertDialog f7729i;

    /* renamed from: j  reason: collision with root package name */
    public static ActivityManager f7730j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f7731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f7732f;

        public a(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7731e = j2;
            this.f7732f = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.p(this.f7731e, this.f7732f);
            }
        }
    }

    /* renamed from: c.a.p0.a.n2.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnClickListenerC0327b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7733e;

        public DialogInterface$OnClickListenerC0327b(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7733e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.h("memory_alert_exit", null);
                SwanAppAlertDialog unused = b.f7729i = null;
                this.f7733e.moveTaskToBack(true);
                c.a.p0.a.a2.d.g().r().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.h("memory_alert_continue", null);
                dialogInterface.dismiss();
                SwanAppAlertDialog unused = b.f7729i = null;
                c.a.p0.a.n2.h.a.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (b.f7729i != null && b.f7729i.isShowing()) {
                    b.f7729i.dismiss();
                }
                SwanAppAlertDialog unused = b.f7729i = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements c.a.p0.a.v2.e1.b<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
                boolean z = !c.a.p0.a.r1.m.c.a(hybridUbcFlow);
                if (b.f7721a) {
                    String str = "startUpSuccess:" + z;
                }
                if (z) {
                    b.f7725e.set(true);
                    long unused = b.f7726f = System.currentTimeMillis();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2120755724, "Lc/a/p0/a/n2/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2120755724, "Lc/a/p0/a/n2/h/b;");
                return;
            }
        }
        f7721a = k.f7085a;
        f7722b = TimeUnit.SECONDS.toMillis(c.a.p0.a.r1.l.b.f());
        f7723c = TimeUnit.SECONDS.toMillis(c.a.p0.a.r1.l.b.e());
        f7724d = TimeUnit.SECONDS.toMillis(c.a.p0.a.r1.l.b.i());
        f7725e = new AtomicBoolean(false);
        f7726f = 0L;
        f7727g = 0L;
        f7728h = 0L;
    }

    public static void g(JSONObject jSONObject) {
        ActivityManager j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, jSONObject) == null) || (j2 = j()) == null) {
            return;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        j2.getMemoryInfo(memoryInfo);
        w.f(jSONObject, "memory_total", i(memoryInfo.totalMem));
        w.f(jSONObject, "memory_used", i(memoryInfo.totalMem - memoryInfo.availMem));
    }

    public static void h(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, jSONObject) == null) {
            c.a.p0.a.j2.p.e eVar = new c.a.p0.a.j2.p.e();
            eVar.f7071a = "swan";
            eVar.f7072b = str;
            eVar.f7076f = c.a.p0.a.a2.d.g().getAppId();
            eVar.e(jSONObject);
            eVar.a("start_timestamp", Long.valueOf(f7726f));
            eVar.a("event_timestamp", Long.valueOf(System.currentTimeMillis()));
            eVar.a("launchid", c.a.p0.a.a2.d.g().r().L().V());
            c.a.p0.a.j2.k.u("1619", eVar);
        }
    }

    public static String i(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j2)) == null) {
            return new DecimalFormat("#.##").format(j2 / 1.073741824E9d) + "GB";
        }
        return (String) invokeJ.objValue;
    }

    public static ActivityManager j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f7730j == null) {
                f7730j = (ActivityManager) c.a.p0.a.a2.d.g().getSystemService("activity");
            }
            return f7730j;
        }
        return (ActivityManager) invokeV.objValue;
    }

    public static long k() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            ActivityManager j3 = j();
            if (j3 != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                j3.getMemoryInfo(memoryInfo);
                long j4 = memoryInfo.totalMem;
                j2 = ((j4 - memoryInfo.availMem) * 100) / j4;
            } else {
                j2 = 0;
            }
            if (f7721a) {
                String str = "usedMemoryRatio:" + j2;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public static boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) ? i2 == 15 : invokeI.booleanValue;
    }

    public static void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65549, null, i2) == null) && c.a.p0.a.r1.l.b.o() && f7725e.get() && l(i2) && g.a().b()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - f7727g;
            long j3 = currentTimeMillis - f7728h;
            if (j2 < f7724d) {
                if (f7721a) {
                    String str = "ReceiveInterval:" + j2 + ",FilterInterval:" + f7724d;
                    return;
                }
                return;
            }
            boolean z = j2 < f7722b && j3 > f7723c && k() > ((long) c.a.p0.a.r1.l.b.g());
            if (f7721a) {
                String str2 = "SwanApp:" + c.a.p0.a.a2.d.g().getAppId() + ",LowMemoryNeedRemind:" + z + ",getMemoryWarningInterval:" + f7722b + ",getMemoryWarningAlterInterval:" + f7723c;
                String str3 = "ReceiveInterval:" + j2 + ",AlterInterval:" + j3 + ",UsedMemoryRatioLimit:" + c.a.p0.a.r1.l.b.g();
            }
            f7727g = currentTimeMillis;
            if (z) {
                f7728h = currentTimeMillis;
                q0.b0(new a(j2, j3));
            }
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            o();
            f7728h = 0L;
            f7730j = null;
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            f7725e.set(false);
            f7726f = 0L;
            f7727g = 0L;
            c.a.p0.a.n2.h.a.c();
            q0.b0(new d());
        }
    }

    @UiThread
    public static void p(long j2, long j3) {
        SwanAppActivity x;
        SwanAppAlertDialog swanAppAlertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (x = c.a.p0.a.a2.d.g().r().x()) == null) {
            return;
        }
        SwanAppAlertDialog swanAppAlertDialog2 = f7729i;
        if (swanAppAlertDialog2 != null && swanAppAlertDialog2.isShowing()) {
            f7729i.dismiss();
            f7729i = null;
        }
        boolean z = !c.a.p0.a.r1.l.b.n();
        if (z && f7729i == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(x);
            aVar.n(new c.a.p0.a.w2.h.a());
            aVar.J(c.a.p0.a.c1.a.H().a());
            aVar.a();
            aVar.m(false);
            aVar.f(true);
            aVar.v(h.swanapp_low_memory_tip);
            aVar.B(h.swanapp_low_memory_button_continue, new c());
            aVar.O(h.swanapp_low_memory_button_exit, new DialogInterface$OnClickListenerC0327b(x));
            f7729i = aVar.c();
        }
        if (z && (swanAppAlertDialog = f7729i) != null) {
            swanAppAlertDialog.show();
        }
        JSONObject jSONObject = new JSONObject();
        w.f(jSONObject, "receive_warning_interval", Long.valueOf(j2));
        w.f(jSONObject, "alter_interval", Long.valueOf(j3));
        g(jSONObject);
        h("memory_alert_show", jSONObject);
        if (z) {
            return;
        }
        c.a.p0.a.n2.h.a.a();
    }
}
