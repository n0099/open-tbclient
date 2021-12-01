package c.a.b0.g.f;

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
    public final c.a.b0.g.d.a f1530e;

    /* renamed from: f  reason: collision with root package name */
    public long f1531f;

    /* renamed from: g  reason: collision with root package name */
    public g f1532g;

    /* renamed from: h  reason: collision with root package name */
    public e f1533h;

    /* renamed from: i  reason: collision with root package name */
    public j f1534i;

    /* renamed from: c.a.b0.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0035a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f1535b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(817105801, "Lc/a/b0/g/f/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(817105801, "Lc/a/b0/g/f/a$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            f1535b = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1535b[AdDownloadStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1535b[AdDownloadStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1535b[AdDownloadStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1535b[AdDownloadStatus.COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1535b[AdDownloadStatus.INSTALLED.ordinal()] = 6;
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

    public a(@NonNull c.a.b0.g.d.a aVar) {
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
        this.f1531f = 0L;
        this.f1532g = null;
        this.f1530e = aVar;
        g();
    }

    @Override // c.a.b0.g.f.h
    public void b(@NonNull AdDownloadAction adDownloadAction, @NonNull c.a.b0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, aVar) == null) {
            switch (C0035a.a[adDownloadAction.ordinal()]) {
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
                    this.f1530e.f1501i = Math.max(aVar.f1501i, aVar.f1502j);
                    c.a.b0.g.e.a.f().j(this.f1530e);
                    j jVar = this.f1534i;
                    if (jVar != null) {
                        jVar.f(aVar, this.f1530e.f1501i);
                        break;
                    }
                    break;
                case 5:
                    t();
                    j jVar2 = this.f1534i;
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
                    j jVar3 = this.f1534i;
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (gVar = this.f1532g) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            gVar.a(this.f1530e.f1495c);
        } else {
            gVar.b(adDownloadCode);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.b0.g.a.a.b().a(this.f1530e);
            j jVar = this.f1534i;
            if (jVar != null) {
                jVar.d(this.f1530e);
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

    @Override // c.a.b0.g.f.h
    public c.a.b0.g.d.a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1530e : (c.a.b0.g.d.a) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!c.a.b0.g.i.a.f(this.f1530e.f1500h)) {
                c.a.b0.g.a.a.b().a(this.f1530e);
                this.f1530e.f();
            }
            AdAppStateManager.instance().register(this.f1530e);
            c.a.b0.g.i.a.c(this.f1530e.f1500h);
            j jVar = this.f1534i;
            if (jVar != null) {
                jVar.g(this.f1530e);
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.f1531f;
            this.f1531f = currentTimeMillis;
            return j2 > 0 && j2 < 1000;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            switch (C0035a.f1535b[this.f1530e.f1495c.ordinal()]) {
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
                    c.a.b0.g.a.a.c(AdDownloadAction.INSTALL_START, this.f1530e);
                    break;
                case 6:
                    if (c.a.b0.g.i.a.b(this.f1530e.f1496d)) {
                        c.a.b0.g.a.a.c(AdDownloadAction.OPEN, this.f1530e);
                        c.a.b0.g.i.a.e(this.f1530e);
                        break;
                    } else {
                        this.f1530e.f1495c = AdDownloadStatus.NONE;
                        r();
                        break;
                    }
            }
            if (TextUtils.isEmpty(this.f1530e.f1498f)) {
                return;
            }
            c.a.b0.d.c.b(this.f1530e.f1498f);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.b0.g.a.a.b().e(this.f1530e);
            t();
            j jVar = this.f1534i;
            if (jVar != null) {
                jVar.a(this.f1530e);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.b0.g.a.a.b().f(this.f1530e.d(), this);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.b0.g.a.a.b().i(this.f1530e.d(), this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.b0.g.a.a.b().g(this.f1530e);
            j jVar = this.f1534i;
            if (jVar != null) {
                jVar.e(this.f1530e);
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
            this.f1532g = gVar;
            if (i()) {
                e(AdDownloadCode.ERROR_FAST_CLICK);
                j jVar = this.f1534i;
                if (jVar != null) {
                    jVar.b(this.f1530e, AdDownloadCode.ERROR_FAST_CLICK);
                }
            } else if (this.f1530e.e()) {
                e(AdDownloadCode.ERROR_INVALID_DATA);
                j jVar2 = this.f1534i;
                if (jVar2 != null) {
                    jVar2.b(this.f1530e, AdDownloadCode.ERROR_INVALID_DATA);
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
            this.f1534i = jVar;
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.b0.g.a.a.b().h(this.f1530e);
            j jVar = this.f1534i;
            if (jVar != null) {
                jVar.c(this.f1530e);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f1533h == null && this.f1530e.a()) {
                this.f1533h = new e(this.f1530e);
            }
            e eVar = this.f1533h;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public final void t() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (eVar = this.f1533h) == null) {
            return;
        }
        eVar.c();
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f1530e.h(c.a.b0.g.b.a.a().query(this.f1530e.d()));
        }
    }
}
