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
    public static final boolean f7713a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f7714b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f7715c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f7716d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f7717e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f7718f;

    /* renamed from: g  reason: collision with root package name */
    public static long f7719g;

    /* renamed from: h  reason: collision with root package name */
    public static long f7720h;

    /* renamed from: i  reason: collision with root package name */
    public static SwanAppAlertDialog f7721i;

    /* renamed from: j  reason: collision with root package name */
    public static ActivityManager f7722j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f7723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f7724f;

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
            this.f7723e = j2;
            this.f7724f = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.p(this.f7723e, this.f7724f);
            }
        }
    }

    /* renamed from: c.a.p0.a.n2.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnClickListenerC0327b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7725e;

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
            this.f7725e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.h("memory_alert_exit", null);
                SwanAppAlertDialog unused = b.f7721i = null;
                this.f7725e.moveTaskToBack(true);
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
                SwanAppAlertDialog unused = b.f7721i = null;
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
                if (b.f7721i != null && b.f7721i.isShowing()) {
                    b.f7721i.dismiss();
                }
                SwanAppAlertDialog unused = b.f7721i = null;
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
                if (b.f7713a) {
                    String str = "startUpSuccess:" + z;
                }
                if (z) {
                    b.f7717e.set(true);
                    long unused = b.f7718f = System.currentTimeMillis();
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
        f7713a = k.f7077a;
        f7714b = TimeUnit.SECONDS.toMillis(c.a.p0.a.r1.l.b.f());
        f7715c = TimeUnit.SECONDS.toMillis(c.a.p0.a.r1.l.b.e());
        f7716d = TimeUnit.SECONDS.toMillis(c.a.p0.a.r1.l.b.i());
        f7717e = new AtomicBoolean(false);
        f7718f = 0L;
        f7719g = 0L;
        f7720h = 0L;
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
            eVar.f7063a = "swan";
            eVar.f7064b = str;
            eVar.f7068f = c.a.p0.a.a2.d.g().getAppId();
            eVar.e(jSONObject);
            eVar.a("start_timestamp", Long.valueOf(f7718f));
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
            if (f7722j == null) {
                f7722j = (ActivityManager) c.a.p0.a.a2.d.g().getSystemService("activity");
            }
            return f7722j;
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
            if (f7713a) {
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
        if ((interceptable == null || interceptable.invokeI(65549, null, i2) == null) && c.a.p0.a.r1.l.b.o() && f7717e.get() && l(i2) && g.a().b()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - f7719g;
            long j3 = currentTimeMillis - f7720h;
            if (j2 < f7716d) {
                if (f7713a) {
                    String str = "ReceiveInterval:" + j2 + ",FilterInterval:" + f7716d;
                    return;
                }
                return;
            }
            boolean z = j2 < f7714b && j3 > f7715c && k() > ((long) c.a.p0.a.r1.l.b.g());
            if (f7713a) {
                String str2 = "SwanApp:" + c.a.p0.a.a2.d.g().getAppId() + ",LowMemoryNeedRemind:" + z + ",getMemoryWarningInterval:" + f7714b + ",getMemoryWarningAlterInterval:" + f7715c;
                String str3 = "ReceiveInterval:" + j2 + ",AlterInterval:" + j3 + ",UsedMemoryRatioLimit:" + c.a.p0.a.r1.l.b.g();
            }
            f7719g = currentTimeMillis;
            if (z) {
                f7720h = currentTimeMillis;
                q0.b0(new a(j2, j3));
            }
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            o();
            f7720h = 0L;
            f7722j = null;
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            f7717e.set(false);
            f7718f = 0L;
            f7719g = 0L;
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
        SwanAppAlertDialog swanAppAlertDialog2 = f7721i;
        if (swanAppAlertDialog2 != null && swanAppAlertDialog2.isShowing()) {
            f7721i.dismiss();
            f7721i = null;
        }
        boolean z = !c.a.p0.a.r1.l.b.n();
        if (z && f7721i == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(x);
            aVar.n(new c.a.p0.a.w2.h.a());
            aVar.J(c.a.p0.a.c1.a.H().a());
            aVar.a();
            aVar.m(false);
            aVar.f(true);
            aVar.v(h.swanapp_low_memory_tip);
            aVar.B(h.swanapp_low_memory_button_continue, new c());
            aVar.O(h.swanapp_low_memory_button_exit, new DialogInterface$OnClickListenerC0327b(x));
            f7721i = aVar.c();
        }
        if (z && (swanAppAlertDialog = f7721i) != null) {
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
