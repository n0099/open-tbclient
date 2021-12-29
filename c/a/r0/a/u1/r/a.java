package c.a.r0.a.u1.r;

import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.d;
import c.a.r0.a.n2.n;
import c.a.r0.a.u1.l.e;
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
public class a implements c.a.r0.a.u1.r.c.a, c.a.r0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9647c;

    /* renamed from: d  reason: collision with root package name */
    public CopyOnWriteArrayList<c> f9648d;

    /* renamed from: e  reason: collision with root package name */
    public CountDownTimer f9649e;

    /* renamed from: c.a.r0.a.u1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CountDownTimerC0592a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountDownTimerC0592a(a aVar, long j2, long j3) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2), Long.valueOf(j3)};
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
            this.a = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.r0.a.f1.f.a.a;
                this.a.d(true);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                Iterator it = this.a.f9648d.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    boolean z = ((long) (5000 - cVar.e())) >= j2;
                    if (!cVar.g() && z) {
                        cVar.h(true);
                        c.a.r0.a.u1.r.c.a f2 = cVar.f();
                        if (c.a.r0.a.f1.f.a.a) {
                            String str = "triggerFmp, timeout = " + cVar.e() + ", trigger = " + f2.getName();
                        }
                        f2.d(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-171749389, "Lc/a/r0/a/u1/r/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-171749389, "Lc/a/r0/a/u1/r/a$b;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.r0.a.u1.r.c.a a;

        /* renamed from: b  reason: collision with root package name */
        public int f9650b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9651c;

        public /* synthetic */ c(a aVar, c.a.r0.a.u1.r.c.a aVar2, int i2, CountDownTimerC0592a countDownTimerC0592a) {
            this(aVar, aVar2, i2);
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f9650b : invokeV.intValue;
        }

        @NonNull
        public final c.a.r0.a.u1.r.c.a f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.a.r0.a.u1.r.c.a) invokeV.objValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9651c : invokeV.booleanValue;
        }

        public final void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f9651c = z;
            }
        }

        public c(@NonNull a aVar, c.a.r0.a.u1.r.c.a aVar2, int i2) {
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
            this.f9651c = false;
            this.a = aVar2;
            this.f9650b = i2;
        }
    }

    public /* synthetic */ a(CountDownTimerC0592a countDownTimerC0592a) {
        this();
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    @Override // c.a.r0.a.u1.r.c.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (c.a.r0.a.f1.f.a.a) {
                String str2 = "triggerFcp, url = " + str;
            }
            Iterator<c> it = this.f9648d.iterator();
            while (it.hasNext()) {
                it.next().f().a(str);
            }
        }
    }

    @Override // c.a.r0.a.u1.r.c.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9648d.isEmpty()) {
            return;
        }
        boolean z = c.a.r0.a.f1.f.a.a;
        k();
        Iterator<c> it = this.f9648d.iterator();
        while (it.hasNext()) {
            it.next().f().b();
        }
        this.f9647c = false;
    }

    @Override // c.a.r0.a.u1.r.c.a
    public void c(@NonNull Runnable runnable, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
        }
    }

    @Override // c.a.r0.a.u1.r.c.a
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f9647c) {
            return;
        }
        this.f9647c = true;
        k();
        if (this.f9648d.isEmpty()) {
            return;
        }
        if (c.a.r0.a.f1.f.a.a) {
            String str = "triggerFmp, timeout = " + z;
        }
        Iterator<c> it = this.f9648d.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!next.g()) {
                next.h(true);
                next.f().d(z);
            }
        }
        n.p();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_timeout", z);
        bundle.putString("app_id", d.J().getAppId());
        c.a.r0.a.y1.c.a e2 = c.a.r0.a.y1.c.a.e();
        c.a.r0.a.y1.c.c cVar = new c.a.r0.a.y1.c.c(23, bundle);
        cVar.f(true);
        e2.h(cVar);
    }

    @Override // c.a.r0.a.u1.r.c.a
    @UiThread
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (e.k()) {
                n.a0(e.j());
            }
            this.f9647c = false;
            if (this.f9648d.isEmpty()) {
                return;
            }
            if (c.a.r0.a.f1.f.a.a) {
                String str2 = "triggerLaunch, source = " + str;
            }
            Iterator<c> it = this.f9648d.iterator();
            while (it.hasNext()) {
                c next = it.next();
                next.h(false);
                next.f().e(str);
            }
            k();
            j();
        }
    }

    @Override // c.a.r0.a.u1.r.c.a
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanLaunchTriggerMgr" : (String) invokeV.objValue;
    }

    public boolean h(c.a.r0.a.u1.r.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            Iterator<c> it = this.f9648d.iterator();
            while (it.hasNext()) {
                if (aVar.equals(it.next().f())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(c.a.r0.a.u1.r.c.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, aVar, i2) == null) || this.f9647c || aVar == null) {
            return;
        }
        if (i2 > 5000) {
            i2 = 5000;
        }
        if (h(aVar)) {
            return;
        }
        this.f9648d.add(new c(this, aVar, i2, null));
        if (c.a.r0.a.f1.f.a.a) {
            String str = "register, task name = " + aVar.getName() + " ; timeout = " + i2;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.f9649e.start();
            } catch (Throwable th) {
                if (c.a.r0.a.f1.f.a.a) {
                    String str = "start timer exception = " + th.getMessage();
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.f9649e.cancel();
            } catch (Throwable th) {
                if (c.a.r0.a.f1.f.a.a) {
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
        this.f9647c = false;
        this.f9648d = new CopyOnWriteArrayList<>();
        this.f9649e = new CountDownTimerC0592a(this, 5000L, 500L);
    }
}
