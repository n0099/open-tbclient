package c.a.n0.e.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.e.a.c.c;
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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f8165d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f8166e;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.n0.e.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8167b;

    /* renamed from: c  reason: collision with root package name */
    public Timer f8168c;

    /* renamed from: c.a.n0.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0636a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0636a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i();
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1394726875, "Lc/a/n0/e/a/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1394726875, "Lc/a/n0/e/a/a$b;");
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1924803495, "Lc/a/n0/e/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1924803495, "Lc/a/n0/e/a/a;");
        }
    }

    public a(Context context) {
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
        this.a = new ArrayList();
        long currentTimeMillis = f8166e ? System.currentTimeMillis() : 0L;
        a(context.getApplicationContext());
        if (f8166e) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("CPU-Booster", "collect booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            f8166e = z;
        }
    }

    public static a d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f8165d == null) {
                synchronized (a.class) {
                    if (f8165d == null) {
                        f8165d = new a(context);
                    }
                }
            }
            return f8165d;
        }
        return (a) invokeL.objValue;
    }

    public static void e(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (f8166e) {
                Log.d("CPU-Booster", "cpu-booster preInit");
            }
            d(context);
        }
    }

    public final void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (c.a.n0.e.a.h.b.a()) {
                this.a.add(new c.a.n0.e.a.c.a(context));
                this.a.add(new c(context));
            } else if (c.a.n0.e.a.h.b.b()) {
                this.a.add(new c.a.n0.e.a.f.a(context));
            }
            int i = b.a[c.a.n0.e.a.h.a.h().ordinal()];
            if (i == 1) {
                this.a.add(new c.a.n0.e.a.e.a(context));
            } else if (i != 2) {
            } else {
                this.a.add(new c.a.n0.e.a.g.a(context));
            }
        }
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0) {
                return 200;
            }
            return Math.min(i, 5000);
        }
        return invokeI.intValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && f8166e) {
            int e2 = c.a.n0.e.a.h.a.e();
            StringBuilder sb = new StringBuilder(" \n\n");
            sb.append("CPU Support Freq Info:\n");
            for (int i = 0; i < e2; i++) {
                c.a.n0.e.a.d.a a = c.a.n0.e.a.h.a.a(i);
                sb.append("CPU");
                sb.append(a.a);
                sb.append(":");
                sb.append("min-");
                sb.append(a.f8174b / 1000);
                sb.append("mHz, max-");
                sb.append(a.f8175c / 1000);
                sb.append("mHz\n");
            }
            sb.append("\n\n");
            sb.append("CPU Current Freq:\n");
            for (int i2 = 0; i2 < e2; i2++) {
                sb.append("CPU");
                sb.append(i2);
                sb.append(":");
                sb.append(c.a.n0.e.a.h.a.j(i2) / 1000);
                sb.append("mHz");
                sb.append("\n");
            }
            if (f8166e) {
                Log.d("CPU-Booster", sb.toString());
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

    public synchronized void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            synchronized (this) {
                if (this.f8167b) {
                    if (f8166e) {
                        Log.d("CPU-Booster", "start fail -> isEnabled - true, already start - " + this.f8167b);
                    }
                    return;
                }
                if (f8166e) {
                    Log.d("CPU-Booster", "startBooster");
                }
                this.f8167b = true;
                int c2 = c(i);
                long currentTimeMillis = f8166e ? System.currentTimeMillis() : 0L;
                for (c.a.n0.e.a.b bVar : this.a) {
                    bVar.b(c2);
                }
                if (this.f8168c == null) {
                    Timer timer = new Timer();
                    this.f8168c = timer;
                    timer.schedule(new C0636a(this), c2);
                }
                if (f8166e) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("CPU-Booster", "start booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    f();
                }
            }
        }
    }

    public synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.f8167b) {
                    if (f8166e) {
                        Log.d("CPU-Booster", "stopBooster");
                    }
                    long currentTimeMillis = f8166e ? System.currentTimeMillis() : 0L;
                    for (c.a.n0.e.a.b bVar : this.a) {
                        bVar.a();
                    }
                    this.f8167b = false;
                    if (this.f8168c != null) {
                        this.f8168c.cancel();
                        this.f8168c = null;
                    }
                    if (f8166e) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Log.d("CPU-Booster", "stop booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    }
                }
            }
        }
    }
}
