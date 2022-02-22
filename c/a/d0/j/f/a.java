package c.a.d0.j.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.d0.j.d.a f2831e;

    /* renamed from: f  reason: collision with root package name */
    public long f2832f;

    /* renamed from: g  reason: collision with root package name */
    public g f2833g;

    /* renamed from: h  reason: collision with root package name */
    public e f2834h;

    /* renamed from: i  reason: collision with root package name */
    public j f2835i;

    /* renamed from: c.a.d0.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0089a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f2836b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1843333208, "Lc/a/d0/j/f/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1843333208, "Lc/a/d0/j/f/a$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            f2836b = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2836b[AdDownloadStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2836b[AdDownloadStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2836b[AdDownloadStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2836b[AdDownloadStatus.COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2836b[AdDownloadStatus.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[AdDownloadAction.values().length];
            a = iArr2;
            try {
                iArr2[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[AdDownloadAction.PROGRESS_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[AdDownloadAction.COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[AdDownloadAction.FAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public a(@NonNull c.a.d0.j.d.a aVar) {
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
        this.f2832f = 0L;
        this.f2833g = null;
        this.f2831e = aVar;
        g();
    }

    @Override // c.a.d0.j.f.h
    public void b(@NonNull AdDownloadAction adDownloadAction, @NonNull c.a.d0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, aVar) == null) {
            switch (C0089a.a[adDownloadAction.ordinal()]) {
                case 1:
                    s();
                    break;
                case 2:
                    t();
                    break;
                case 3:
                    s();
                    break;
                case 4:
                    this.f2831e.f2804i = Math.max(aVar.f2804i, aVar.f2805j);
                    c.a.d0.j.e.a.f().j(this.f2831e);
                    j jVar = this.f2835i;
                    if (jVar != null) {
                        jVar.f(aVar, this.f2831e.f2804i);
                        break;
                    }
                    break;
                case 5:
                    t();
                    j jVar2 = this.f2835i;
                    if (jVar2 != null) {
                        jVar2.h(aVar);
                        break;
                    }
                    break;
                case 6:
                    t();
                    break;
                case 7:
                    t();
                    e(AdDownloadCode.ERROR_OTHERS);
                    j jVar3 = this.f2835i;
                    if (jVar3 != null) {
                        jVar3.b(aVar, AdDownloadCode.ERROR_OTHERS);
                        return;
                    }
                    return;
            }
            e(AdDownloadCode.SUCCESS);
        }
    }

    public final void e(AdDownloadCode adDownloadCode) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (gVar = this.f2833g) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            gVar.a(this.f2831e.f2798c);
        } else {
            gVar.b(adDownloadCode);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.d0.j.a.a.b().a(this.f2831e);
            j jVar = this.f2835i;
            if (jVar != null) {
                jVar.d(this.f2831e);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u();
            l();
        }
    }

    @Override // c.a.d0.j.f.h
    public c.a.d0.j.d.a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2831e : (c.a.d0.j.d.a) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!c.a.d0.j.i.a.f(this.f2831e.f2803h)) {
                c.a.d0.j.a.a.b().a(this.f2831e);
                this.f2831e.f();
            }
            AdAppStateManager.instance().register(this.f2831e);
            c.a.d0.j.i.a.c(this.f2831e.f2803h);
            j jVar = this.f2835i;
            if (jVar != null) {
                jVar.g(this.f2831e);
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.f2832f;
            this.f2832f = currentTimeMillis;
            return j2 > 0 && j2 < 1000;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            switch (C0089a.f2836b[this.f2831e.f2798c.ordinal()]) {
                case 1:
                case 2:
                    r();
                    break;
                case 3:
                    k();
                    break;
                case 4:
                    n();
                    break;
                case 5:
                    h();
                    c.a.d0.j.a.a.c(AdDownloadAction.INSTALL_START, this.f2831e);
                    break;
                case 6:
                    if (c.a.d0.j.i.a.b(this.f2831e.f2799d)) {
                        c.a.d0.j.a.a.c(AdDownloadAction.OPEN, this.f2831e);
                        c.a.d0.j.i.a.e(this.f2831e);
                        break;
                    } else {
                        this.f2831e.f2798c = AdDownloadStatus.NONE;
                        r();
                        break;
                    }
            }
            if (TextUtils.isEmpty(this.f2831e.f2801f)) {
                return;
            }
            c.a.d0.f.d.b(this.f2831e.f2801f);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.d0.j.a.a.b().e(this.f2831e);
            t();
            j jVar = this.f2835i;
            if (jVar != null) {
                jVar.a(this.f2831e);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.d0.j.a.a.b().f(this.f2831e.d(), this);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.d0.j.a.a.b().i(this.f2831e.d(), this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.d0.j.a.a.b().g(this.f2831e);
            j jVar = this.f2835i;
            if (jVar != null) {
                jVar.e(this.f2831e);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p(null);
        }
    }

    public void p(@Nullable g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f2833g = gVar;
            if (i()) {
                e(AdDownloadCode.ERROR_FAST_CLICK);
                j jVar = this.f2835i;
                if (jVar != null) {
                    jVar.b(this.f2831e, AdDownloadCode.ERROR_FAST_CLICK);
                }
            } else if (this.f2831e.e()) {
                e(AdDownloadCode.ERROR_INVALID_DATA);
                j jVar2 = this.f2835i;
                if (jVar2 != null) {
                    jVar2.b(this.f2831e, AdDownloadCode.ERROR_INVALID_DATA);
                }
            } else {
                j();
                e(AdDownloadCode.SUCCESS);
            }
        }
    }

    public void q(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
            this.f2835i = jVar;
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.d0.j.a.a.b().h(this.f2831e);
            j jVar = this.f2835i;
            if (jVar != null) {
                jVar.c(this.f2831e);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f2834h == null && this.f2831e.a()) {
                this.f2834h = new e(this.f2831e);
            }
            e eVar = this.f2834h;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public final void t() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (eVar = this.f2834h) == null) {
            return;
        }
        eVar.c();
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f2831e.h(c.a.d0.j.b.a.a().query(this.f2831e.d()));
        }
    }
}
