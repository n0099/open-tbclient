package c.a.c0.g.f;

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
    public final c.a.c0.g.d.a f1548e;

    /* renamed from: f  reason: collision with root package name */
    public long f1549f;

    /* renamed from: g  reason: collision with root package name */
    public g f1550g;

    /* renamed from: h  reason: collision with root package name */
    public e f1551h;

    /* renamed from: i  reason: collision with root package name */
    public j f1552i;

    /* renamed from: c.a.c0.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0037a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f1553b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-979845558, "Lc/a/c0/g/f/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-979845558, "Lc/a/c0/g/f/a$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            f1553b = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1553b[AdDownloadStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1553b[AdDownloadStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1553b[AdDownloadStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1553b[AdDownloadStatus.COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1553b[AdDownloadStatus.INSTALLED.ordinal()] = 6;
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

    public a(@NonNull c.a.c0.g.d.a aVar) {
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
        this.f1549f = 0L;
        this.f1550g = null;
        this.f1548e = aVar;
        g();
    }

    @Override // c.a.c0.g.f.h
    public void b(@NonNull AdDownloadAction adDownloadAction, @NonNull c.a.c0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, aVar) == null) {
            switch (C0037a.a[adDownloadAction.ordinal()]) {
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
                    this.f1548e.f1519i = Math.max(aVar.f1519i, aVar.f1520j);
                    c.a.c0.g.e.a.f().j(this.f1548e);
                    j jVar = this.f1552i;
                    if (jVar != null) {
                        jVar.f(aVar, this.f1548e.f1519i);
                        break;
                    }
                    break;
                case 5:
                    t();
                    j jVar2 = this.f1552i;
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
                    j jVar3 = this.f1552i;
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (gVar = this.f1550g) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            gVar.a(this.f1548e.f1513c);
        } else {
            gVar.b(adDownloadCode);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.c0.g.a.a.b().a(this.f1548e);
            j jVar = this.f1552i;
            if (jVar != null) {
                jVar.d(this.f1548e);
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

    @Override // c.a.c0.g.f.h
    public c.a.c0.g.d.a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1548e : (c.a.c0.g.d.a) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!c.a.c0.g.i.a.f(this.f1548e.f1518h)) {
                c.a.c0.g.a.a.b().a(this.f1548e);
                this.f1548e.f();
            }
            AdAppStateManager.instance().register(this.f1548e);
            c.a.c0.g.i.a.c(this.f1548e.f1518h);
            j jVar = this.f1552i;
            if (jVar != null) {
                jVar.g(this.f1548e);
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.f1549f;
            this.f1549f = currentTimeMillis;
            return j2 > 0 && j2 < 1000;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            switch (C0037a.f1553b[this.f1548e.f1513c.ordinal()]) {
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
                    c.a.c0.g.a.a.c(AdDownloadAction.INSTALL_START, this.f1548e);
                    break;
                case 6:
                    if (c.a.c0.g.i.a.b(this.f1548e.f1514d)) {
                        c.a.c0.g.a.a.c(AdDownloadAction.OPEN, this.f1548e);
                        c.a.c0.g.i.a.e(this.f1548e);
                        break;
                    } else {
                        this.f1548e.f1513c = AdDownloadStatus.NONE;
                        r();
                        break;
                    }
            }
            if (TextUtils.isEmpty(this.f1548e.f1516f)) {
                return;
            }
            c.a.c0.d.c.b(this.f1548e.f1516f);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.c0.g.a.a.b().e(this.f1548e);
            t();
            j jVar = this.f1552i;
            if (jVar != null) {
                jVar.a(this.f1548e);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.c0.g.a.a.b().f(this.f1548e.d(), this);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.c0.g.a.a.b().i(this.f1548e.d(), this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.c0.g.a.a.b().g(this.f1548e);
            j jVar = this.f1552i;
            if (jVar != null) {
                jVar.e(this.f1548e);
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
            this.f1550g = gVar;
            if (i()) {
                e(AdDownloadCode.ERROR_FAST_CLICK);
                j jVar = this.f1552i;
                if (jVar != null) {
                    jVar.b(this.f1548e, AdDownloadCode.ERROR_FAST_CLICK);
                }
            } else if (this.f1548e.e()) {
                e(AdDownloadCode.ERROR_INVALID_DATA);
                j jVar2 = this.f1552i;
                if (jVar2 != null) {
                    jVar2.b(this.f1548e, AdDownloadCode.ERROR_INVALID_DATA);
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
            this.f1552i = jVar;
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.c0.g.a.a.b().h(this.f1548e);
            j jVar = this.f1552i;
            if (jVar != null) {
                jVar.c(this.f1548e);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f1551h == null && this.f1548e.a()) {
                this.f1551h = new e(this.f1548e);
            }
            e eVar = this.f1551h;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public final void t() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (eVar = this.f1551h) == null) {
            return;
        }
        eVar.c();
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f1548e.h(c.a.c0.g.b.a.a().query(this.f1548e.d()));
        }
    }
}
