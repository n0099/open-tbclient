package c.a.a0.j.f;

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
    public final c.a.a0.j.d.a a;

    /* renamed from: b  reason: collision with root package name */
    public long f1273b;

    /* renamed from: c  reason: collision with root package name */
    public g f1274c;

    /* renamed from: d  reason: collision with root package name */
    public e f1275d;

    /* renamed from: e  reason: collision with root package name */
    public j f1276e;

    /* renamed from: c.a.a0.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0033a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f1277b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-747446427, "Lc/a/a0/j/f/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-747446427, "Lc/a/a0/j/f/a$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            f1277b = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1277b[AdDownloadStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1277b[AdDownloadStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1277b[AdDownloadStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1277b[AdDownloadStatus.COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1277b[AdDownloadStatus.INSTALLED.ordinal()] = 6;
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

    public a(@NonNull c.a.a0.j.d.a aVar) {
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
        this.f1273b = 0L;
        this.f1274c = null;
        this.a = aVar;
        h();
    }

    @Override // c.a.a0.j.f.h
    public void c(@NonNull AdDownloadAction adDownloadAction, @NonNull c.a.a0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, aVar) == null) {
            switch (C0033a.a[adDownloadAction.ordinal()]) {
                case 1:
                    t();
                    break;
                case 2:
                    u();
                    break;
                case 3:
                    t();
                    break;
                case 4:
                    this.a.i = Math.max(aVar.i, aVar.j);
                    c.a.a0.j.e.a.f().j(this.a);
                    j jVar = this.f1276e;
                    if (jVar != null) {
                        jVar.f(aVar, this.a.i);
                        break;
                    }
                    break;
                case 5:
                    u();
                    j jVar2 = this.f1276e;
                    if (jVar2 != null) {
                        jVar2.h(aVar);
                        break;
                    }
                    break;
                case 6:
                    u();
                    break;
                case 7:
                    u();
                    f(AdDownloadCode.ERROR_OTHERS);
                    j jVar3 = this.f1276e;
                    if (jVar3 != null) {
                        jVar3.b(aVar, AdDownloadCode.ERROR_OTHERS);
                        return;
                    }
                    return;
            }
            f(AdDownloadCode.SUCCESS);
        }
    }

    public final void f(AdDownloadCode adDownloadCode) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (gVar = this.f1274c) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            gVar.a(this.a.f1246c);
        } else {
            gVar.b(adDownloadCode);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.a0.j.a.a.b().a(this.a);
            j jVar = this.f1276e;
            if (jVar != null) {
                jVar.d(this.a);
            }
        }
    }

    @Override // c.a.a0.j.f.h
    public c.a.a0.j.d.a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (c.a.a0.j.d.a) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            v();
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!c.a.a0.j.i.a.f(this.a.f1251h)) {
                c.a.a0.j.a.a.b().a(this.a);
                this.a.f();
            }
            AdAppStateManager.instance().register(this.a);
            c.a.a0.j.i.a.c(this.a.f1251h);
            j jVar = this.f1276e;
            if (jVar != null) {
                jVar.g(this.a);
            }
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.f1273b;
            this.f1273b = currentTimeMillis;
            return j > 0 && j < 1000;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            switch (C0033a.f1277b[this.a.f1246c.ordinal()]) {
                case 1:
                case 2:
                    s();
                    break;
                case 3:
                    l();
                    break;
                case 4:
                    o();
                    break;
                case 5:
                    i();
                    c.a.a0.j.a.a.c(AdDownloadAction.INSTALL_START, this.a);
                    break;
                case 6:
                    if (c.a.a0.j.i.a.b(this.a.f1247d)) {
                        c.a.a0.j.a.a.c(AdDownloadAction.OPEN, this.a);
                        c.a.a0.j.i.a.e(this.a);
                        break;
                    } else {
                        this.a.f1246c = AdDownloadStatus.NONE;
                        s();
                        break;
                    }
            }
            if (TextUtils.isEmpty(this.a.f1249f)) {
                return;
            }
            c.a.a0.g.c.b(this.a.f1249f);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.a0.j.a.a.b().e(this.a);
            u();
            j jVar = this.f1276e;
            if (jVar != null) {
                jVar.a(this.a);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.a0.j.a.a.b().f(this.a.d(), this);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.a0.j.a.a.b().i(this.a.d(), this);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.a0.j.a.a.b().g(this.a);
            j jVar = this.f1276e;
            if (jVar != null) {
                jVar.e(this.a);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            q(null);
        }
    }

    public void q(@Nullable g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f1274c = gVar;
            if (j()) {
                f(AdDownloadCode.ERROR_FAST_CLICK);
                j jVar = this.f1276e;
                if (jVar != null) {
                    jVar.b(this.a, AdDownloadCode.ERROR_FAST_CLICK);
                }
            } else if (this.a.e()) {
                f(AdDownloadCode.ERROR_INVALID_DATA);
                j jVar2 = this.f1276e;
                if (jVar2 != null) {
                    jVar2.b(this.a, AdDownloadCode.ERROR_INVALID_DATA);
                }
            } else {
                k();
                f(AdDownloadCode.SUCCESS);
            }
        }
    }

    public void r(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
            this.f1276e = jVar;
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.a0.j.a.a.b().h(this.a);
            j jVar = this.f1276e;
            if (jVar != null) {
                jVar.c(this.a);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f1275d == null && this.a.a()) {
                this.f1275d = new e(this.a);
            }
            e eVar = this.f1275d;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public final void u() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (eVar = this.f1275d) == null) {
            return;
        }
        eVar.c();
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.h(c.a.a0.j.b.a.a().query(this.a.d()));
        }
    }
}
