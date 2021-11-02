package b.a.p0.a.r1.r;

import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class a implements b.a.p0.a.r1.r.c.a, b.a.p0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7756b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<c> f7757c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownTimer f7758d;

    /* renamed from: b.a.p0.a.r1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CountDownTimerC0359a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7759a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountDownTimerC0359a(a aVar, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7759a = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = b.a.p0.a.f1.f.a.f5062a;
                this.f7759a.c(true);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Iterator it = this.f7759a.f7757c.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    boolean z = ((long) (5000 - cVar.e())) >= j;
                    if (!cVar.g() && z) {
                        cVar.h(true);
                        b.a.p0.a.r1.r.c.a f2 = cVar.f();
                        if (b.a.p0.a.f1.f.a.f5062a) {
                            String str = "triggerFmp, timeout = " + cVar.e() + ", trigger = " + f2.getName();
                        }
                        f2.c(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f7760a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1331130989, "Lb/a/p0/a/r1/r/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1331130989, "Lb/a/p0/a/r1/r/a$b;");
                    return;
                }
            }
            f7760a = new a(null);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.a.r1.r.c.a f7761a;

        /* renamed from: b  reason: collision with root package name */
        public int f7762b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7763c;

        public /* synthetic */ c(a aVar, b.a.p0.a.r1.r.c.a aVar2, int i2, CountDownTimerC0359a countDownTimerC0359a) {
            this(aVar, aVar2, i2);
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7762b : invokeV.intValue;
        }

        @NonNull
        public final b.a.p0.a.r1.r.c.a f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7761a : (b.a.p0.a.r1.r.c.a) invokeV.objValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7763c : invokeV.booleanValue;
        }

        public final void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f7763c = z;
            }
        }

        public c(@NonNull a aVar, b.a.p0.a.r1.r.c.a aVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7763c = false;
            this.f7761a = aVar2;
            this.f7762b = i2;
        }
    }

    public /* synthetic */ a(CountDownTimerC0359a countDownTimerC0359a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f7760a : (a) invokeV.objValue;
    }

    @Override // b.a.p0.a.r1.r.c.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (b.a.p0.a.f1.f.a.f5062a) {
                String str2 = "triggerFcp, url = " + str;
            }
            Iterator<c> it = this.f7757c.iterator();
            while (it.hasNext()) {
                it.next().f().a(str);
            }
        }
    }

    @Override // b.a.p0.a.r1.r.c.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f7757c.isEmpty()) {
            return;
        }
        boolean z = b.a.p0.a.f1.f.a.f5062a;
        j();
        Iterator<c> it = this.f7757c.iterator();
        while (it.hasNext()) {
            it.next().f().b();
        }
        this.f7756b = false;
    }

    @Override // b.a.p0.a.r1.r.c.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f7756b) {
            return;
        }
        this.f7756b = true;
        j();
        if (this.f7757c.isEmpty()) {
            return;
        }
        if (b.a.p0.a.f1.f.a.f5062a) {
            String str = "triggerFmp, timeout = " + z;
        }
        Iterator<c> it = this.f7757c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!next.g()) {
                next.h(true);
                next.f().c(z);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_timeout", z);
        bundle.putString("app_id", d.g().getAppId());
        b.a.p0.a.v1.c.a e2 = b.a.p0.a.v1.c.a.e();
        b.a.p0.a.v1.c.c cVar = new b.a.p0.a.v1.c.c(23, bundle);
        cVar.f(true);
        e2.h(cVar);
    }

    @Override // b.a.p0.a.r1.r.c.a
    @UiThread
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f7756b = false;
            if (this.f7757c.isEmpty()) {
                return;
            }
            if (b.a.p0.a.f1.f.a.f5062a) {
                String str2 = "triggerLaunch, source = " + str;
            }
            Iterator<c> it = this.f7757c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                next.h(false);
                next.f().d(str);
            }
            j();
            i();
        }
    }

    public boolean g(b.a.p0.a.r1.r.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            Iterator<c> it = this.f7757c.iterator();
            while (it.hasNext()) {
                if (aVar.equals(it.next().f())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.r1.r.c.a
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanLaunchTriggerMgr" : (String) invokeV.objValue;
    }

    public void h(b.a.p0.a.r1.r.c.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i2) == null) || this.f7756b || aVar == null) {
            return;
        }
        if (i2 > 5000) {
            i2 = 5000;
        }
        if (g(aVar)) {
            return;
        }
        this.f7757c.add(new c(this, aVar, i2, null));
        if (b.a.p0.a.f1.f.a.f5062a) {
            String str = "register, task name = " + aVar.getName() + " ; timeout = " + i2;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f7758d.start();
            } catch (Throwable th) {
                if (b.a.p0.a.f1.f.a.f5062a) {
                    String str = "start timer exception = " + th.getMessage();
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.f7758d.cancel();
            } catch (Throwable th) {
                if (b.a.p0.a.f1.f.a.f5062a) {
                    String str = "stop timer exception = " + th.getMessage();
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7756b = false;
        this.f7757c = new CopyOnWriteArrayList<>();
        this.f7758d = new CountDownTimerC0359a(this, 5000L, 500L);
    }
}
