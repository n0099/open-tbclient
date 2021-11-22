package b.a.p0.e.a;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.e.a.c.c;
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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f10196d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f10197e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<b.a.p0.e.a.b> f10198a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10199b;

    /* renamed from: c  reason: collision with root package name */
    public Timer f10200c;

    /* renamed from: b.a.p0.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0530a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10201e;

        public C0530a(a aVar) {
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
            this.f10201e = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10201e.i();
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10202a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(588239644, "Lb/a/p0/e/a/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(588239644, "Lb/a/p0/e/a/a$b;");
                    return;
                }
            }
            int[] iArr = new int[CpuType.values().length];
            f10202a = iArr;
            try {
                iArr[CpuType.Mtk.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10202a[CpuType.QualComm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10202a[CpuType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-951342118, "Lb/a/p0/e/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-951342118, "Lb/a/p0/e/a/a;");
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
        this.f10198a = new ArrayList();
        long currentTimeMillis = f10197e ? System.currentTimeMillis() : 0L;
        a(context.getApplicationContext());
        if (f10197e) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "collect booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            f10197e = z;
        }
    }

    public static a d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f10196d == null) {
                synchronized (a.class) {
                    if (f10196d == null) {
                        f10196d = new a(context);
                    }
                }
            }
            return f10196d;
        }
        return (a) invokeL.objValue;
    }

    public static void e(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            boolean z = f10197e;
            d(context);
        }
    }

    public final void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (b.a.p0.e.a.h.b.a()) {
                this.f10198a.add(new b.a.p0.e.a.c.a(context));
                this.f10198a.add(new c(context));
            } else if (b.a.p0.e.a.h.b.b()) {
                this.f10198a.add(new b.a.p0.e.a.f.a(context));
            }
            int i2 = b.f10202a[b.a.p0.e.a.h.a.h().ordinal()];
            if (i2 == 1) {
                this.f10198a.add(new b.a.p0.e.a.e.a(context));
            } else if (i2 != 2) {
            } else {
                this.f10198a.add(new b.a.p0.e.a.g.a(context));
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && f10197e) {
            int e2 = b.a.p0.e.a.h.a.e();
            StringBuilder sb = new StringBuilder(" \n\n");
            sb.append("CPU Support Freq Info:\n");
            for (int i2 = 0; i2 < e2; i2++) {
                b.a.p0.e.a.d.a a2 = b.a.p0.e.a.h.a.a(i2);
                sb.append("CPU");
                sb.append(a2.f10212e);
                sb.append(":");
                sb.append("min-");
                sb.append(a2.f10213f / 1000);
                sb.append("mHz, max-");
                sb.append(a2.f10214g / 1000);
                sb.append("mHz\n");
            }
            sb.append("\n\n");
            sb.append("CPU Current Freq:\n");
            for (int i3 = 0; i3 < e2; i3++) {
                sb.append("CPU");
                sb.append(i3);
                sb.append(":");
                sb.append(b.a.p0.e.a.h.a.j(i3) / 1000);
                sb.append("mHz");
                sb.append(StringUtils.LF);
            }
            if (f10197e) {
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
                if (this.f10199b) {
                    if (f10197e) {
                        String str = "start fail -> isEnabled - true, already start - " + this.f10199b;
                    }
                    return;
                }
                boolean z = f10197e;
                this.f10199b = true;
                int c2 = c(i2);
                long currentTimeMillis = f10197e ? System.currentTimeMillis() : 0L;
                for (b.a.p0.e.a.b bVar : this.f10198a) {
                    bVar.b(c2);
                }
                if (this.f10200c == null) {
                    Timer timer = new Timer();
                    this.f10200c = timer;
                    timer.schedule(new C0530a(this), c2);
                }
                if (f10197e) {
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
                if (this.f10199b) {
                    boolean z = f10197e;
                    long currentTimeMillis = f10197e ? System.currentTimeMillis() : 0L;
                    for (b.a.p0.e.a.b bVar : this.f10198a) {
                        bVar.a();
                    }
                    this.f10199b = false;
                    if (this.f10200c != null) {
                        this.f10200c.cancel();
                        this.f10200c = null;
                    }
                    if (f10197e) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String str = "stop booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                    }
                }
            }
        }
    }
}
