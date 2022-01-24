package c.a.r0.e.a;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.e.a.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.cpu.booster.utils.CpuType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f10427d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f10428e;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.r0.e.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10429b;

    /* renamed from: c  reason: collision with root package name */
    public Timer f10430c;

    /* renamed from: c.a.r0.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0688a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10431e;

        public C0688a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10431e = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10431e.i();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1498111265, "Lc/a/r0/e/a/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1498111265, "Lc/a/r0/e/a/a$b;");
                    return;
                }
            }
            int[] iArr = new int[CpuType.values().length];
            a = iArr;
            try {
                iArr[CpuType.Mtk.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CpuType.QualComm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CpuType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-564686755, "Lc/a/r0/e/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-564686755, "Lc/a/r0/e/a/a;");
        }
    }

    public a(Context context) {
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
        this.a = new ArrayList();
        long currentTimeMillis = f10428e ? System.currentTimeMillis() : 0L;
        a(context.getApplicationContext());
        if (f10428e) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "collect booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            f10428e = z;
        }
    }

    public static a d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f10427d == null) {
                synchronized (a.class) {
                    if (f10427d == null) {
                        f10427d = new a(context);
                    }
                }
            }
            return f10427d;
        }
        return (a) invokeL.objValue;
    }

    public static void e(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            boolean z = f10428e;
            d(context);
        }
    }

    public final void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (c.a.r0.e.a.h.b.a()) {
                this.a.add(new c.a.r0.e.a.c.a(context));
                this.a.add(new c(context));
            } else if (c.a.r0.e.a.h.b.b()) {
                this.a.add(new c.a.r0.e.a.f.a(context));
            }
            int i2 = b.a[c.a.r0.e.a.h.a.h().ordinal()];
            if (i2 == 1) {
                this.a.add(new c.a.r0.e.a.e.a(context));
            } else if (i2 != 2) {
            } else {
                this.a.add(new c.a.r0.e.a.g.a(context));
            }
        }
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < 0) {
                return 200;
            }
            return Math.min(i2, 5000);
        }
        return invokeI.intValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && f10428e) {
            int e2 = c.a.r0.e.a.h.a.e();
            StringBuilder sb = new StringBuilder(" \n\n");
            sb.append("CPU Support Freq Info:\n");
            for (int i2 = 0; i2 < e2; i2++) {
                c.a.r0.e.a.d.a a = c.a.r0.e.a.h.a.a(i2);
                sb.append("CPU");
                sb.append(a.f10437e);
                sb.append(":");
                sb.append("min-");
                sb.append(a.f10438f / 1000);
                sb.append("mHz, max-");
                sb.append(a.f10439g / 1000);
                sb.append("mHz\n");
            }
            sb.append("\n\n");
            sb.append("CPU Current Freq:\n");
            for (int i3 = 0; i3 < e2; i3++) {
                sb.append("CPU");
                sb.append(i3);
                sb.append(":");
                sb.append(c.a.r0.e.a.h.a.j(i3) / 1000);
                sb.append("mHz");
                sb.append(StringUtils.LF);
            }
            if (f10428e) {
                sb.toString();
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                h(3000);
            }
        }
    }

    public synchronized void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            synchronized (this) {
                if (this.f10429b) {
                    if (f10428e) {
                        String str = "start fail -> isEnabled - true, already start - " + this.f10429b;
                    }
                    return;
                }
                boolean z = f10428e;
                this.f10429b = true;
                int c2 = c(i2);
                long currentTimeMillis = f10428e ? System.currentTimeMillis() : 0L;
                for (c.a.r0.e.a.b bVar : this.a) {
                    bVar.b(c2);
                }
                if (this.f10430c == null) {
                    Timer timer = new Timer();
                    this.f10430c = timer;
                    timer.schedule(new C0688a(this), c2);
                }
                if (f10428e) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str2 = "start booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                    f();
                }
            }
        }
    }

    public synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.f10429b) {
                    boolean z = f10428e;
                    long currentTimeMillis = f10428e ? System.currentTimeMillis() : 0L;
                    for (c.a.r0.e.a.b bVar : this.a) {
                        bVar.a();
                    }
                    this.f10429b = false;
                    if (this.f10430c != null) {
                        this.f10430c.cancel();
                        this.f10430c = null;
                    }
                    if (f10428e) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String str = "stop booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                    }
                }
            }
        }
    }
}
