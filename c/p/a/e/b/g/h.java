package c.p.a.e.b.g;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String p = "h";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f35135a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadInfo f35136b;

    /* renamed from: c  reason: collision with root package name */
    public final k f35137c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f35138d;

    /* renamed from: e  reason: collision with root package name */
    public c.p.a.e.b.n.a f35139e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<c.p.a.e.b.f.c> f35140f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<c.p.a.e.b.f.c> f35141g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<c.p.a.e.b.f.c> f35142h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35143i;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f35144j;
    public final AtomicLong k;
    public boolean l;
    public int m;
    public long n;
    public z o;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f35145e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35145e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35145e.f35137c.i(this.f35145e.f35136b.getId());
                this.f35145e.c(1, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.p.a.e.b.f.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f35146a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35146a = hVar;
        }

        @Override // c.p.a.e.b.f.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35146a.C();
            }
        }

        @Override // c.p.a.e.b.f.l
        public void a(BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseException) == null) {
                String str = h.p;
                StringBuilder sb = new StringBuilder();
                sb.append("saveFileAsTargetName onFailed : ");
                sb.append(baseException != null ? baseException.getErrorMessage() : "");
                c.p.a.e.b.c.a.g(str, sb.toString());
                this.f35146a.g(baseException);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1473478569, "Lc/p/a/e/b/g/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1473478569, "Lc/p/a/e/b/g/h;");
        }
    }

    public h(c.p.a.e.b.n.a aVar, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35143i = false;
        this.f35144j = 0L;
        this.k = new AtomicLong();
        this.l = false;
        this.f35139e = aVar;
        A();
        this.f35138d = handler;
        this.f35137c = e.M0();
        DownloadInfo J = aVar.J();
        if (J != null) {
            this.f35135a = c.p.a.e.b.j.a.d(J.getId()).l("fix_start_with_file_exist_update_error");
        } else {
            this.f35135a = false;
        }
    }

    public final void A() {
        c.p.a.e.b.n.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f35139e) == null) {
            return;
        }
        this.f35136b = aVar.J();
        this.f35140f = this.f35139e.M(com.ss.android.socialbase.downloader.constants.f.f75840a);
        this.f35142h = this.f35139e.M(com.ss.android.socialbase.downloader.constants.f.f75842c);
        this.f35141g = this.f35139e.M(com.ss.android.socialbase.downloader.constants.f.f75841b);
        this.f35139e.E();
        this.o = this.f35139e.R();
    }

    public final void B() {
        ExecutorService A0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (A0 = e.A0()) == null) {
            return;
        }
        A0.execute(new a(this));
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                c.p.a.e.b.c.a.g(p, "saveFileAsTargetName onSuccess");
                try {
                    D();
                    this.f35136b.setFirstSuccess(false);
                    this.f35136b.setSuccessByCache(false);
                    c(-3, null);
                    this.f35137c.c(this.f35136b.getId(), this.f35136b.getTotalBytes());
                    this.f35137c.d(this.f35136b.getId());
                    this.f35137c.m(this.f35136b.getId());
                } catch (BaseException e2) {
                    g(e2);
                }
            } catch (Throwable th) {
                g(new BaseException(1008, c.p.a.e.b.l.f.a0(th, "onCompleted")));
            }
        }
    }

    public final void D() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            List<c.p.a.e.b.f.r> H = this.f35139e.H();
            if (H.isEmpty()) {
                return;
            }
            DownloadInfo downloadInfo = this.f35136b;
            c(11, null);
            this.f35137c.a(downloadInfo);
            for (c.p.a.e.b.f.r rVar : H) {
                try {
                    if (rVar.b(downloadInfo)) {
                        rVar.a(downloadInfo);
                        this.f35137c.a(downloadInfo);
                    }
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    throw new BaseException((int) RevenueServerConst.GetBannerConfigRequest, th);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f35136b.canSkipStatusHandler()) {
            return;
        }
        this.f35136b.setStatus(1);
        B();
    }

    public final void c(int i2, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, baseException) == null) {
            d(i2, baseException, true);
        }
    }

    public final void d(int i2, BaseException baseException, boolean z) {
        SparseArray<c.p.a.e.b.f.c> sparseArray;
        SparseArray<c.p.a.e.b.f.c> sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), baseException, Boolean.valueOf(z)}) == null) {
            int status = this.f35136b.getStatus();
            if (status == -3 && i2 == 4) {
                return;
            }
            A();
            if (i2 != 4 && c.p.a.e.b.d.a.e(i2)) {
                this.f35136b.updateRealDownloadTime(false);
                if (c.p.a.e.b.d.a.f(i2)) {
                    this.f35136b.updateDownloadTime();
                }
            }
            if (!this.f35136b.isAddListenerToSameTask()) {
                c.p.a.e.b.e.a.i(this.f35139e, baseException, i2);
            }
            if (i2 == 6) {
                this.f35136b.setStatus(2);
            } else if (i2 == -6) {
                this.f35136b.setStatus(-3);
            } else {
                this.f35136b.setStatus(i2);
            }
            if (status == -3 || status == -1) {
                if (this.f35136b.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.f75846c) {
                    this.f35136b.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.f75847d);
                }
                if (this.f35136b.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.f75828d) {
                    this.f35136b.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f75829e);
                }
                if (this.f35136b.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.f75833c) {
                    this.f35136b.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.f75834d);
                }
            }
            c.p.a.e.b.l.c.a(i2, this.f35141g, true, this.f35136b, baseException);
            if (i2 == -4) {
                return;
            }
            if (z && this.f35138d != null && (((sparseArray = this.f35140f) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f35142h) != null && sparseArray2.size() > 0 && (this.f35136b.canShowNotification() || this.f35136b.isAutoInstallWithoutNotification())))) {
                this.f35138d.obtainMessage(i2, this.f35136b.getId(), this.f35139e.P(), baseException).sendToTarget();
                return;
            }
            c.p.a.e.b.m.a c2 = e.c();
            if (c2 != null) {
                c2.e(this.f35136b.getId(), this.f35139e.P(), i2);
            }
        }
    }

    public void e(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            this.f35136b.setTotalBytes(j2);
            this.f35136b.seteTag(str);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f35136b.getName())) {
                this.f35136b.setName(str2);
            }
            try {
                this.f35137c.a(this.f35136b.getId(), j2, str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c(3, null);
            this.n = this.f35136b.getMinByteIntervalForPostToMainThread(j2);
            this.m = this.f35136b.getMinProgressTimeMsInterval();
            this.f35143i = true;
            c.p.a.e.b.m.q.d().y();
        }
    }

    public void g(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseException) == null) {
            this.f35136b.setFirstDownload(false);
            o(baseException);
        }
    }

    public void h(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, baseException, z) == null) {
            this.f35136b.setFirstDownload(false);
            this.k.set(0L);
            p(baseException, z);
        }
    }

    public void i(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048586, this, bVar, baseException, z) == null) {
            this.f35136b.setFirstDownload(false);
            this.k.set(0L);
            this.f35137c.h(this.f35136b.getId());
            d(z ? 10 : 9, baseException, true);
        }
    }

    public void j(String str) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            String str2 = p;
            c.p.a.e.b.c.a.g(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f35136b.getName());
            if (this.f35135a) {
                c.p.a.e.b.l.f.y(this.f35136b, str);
                D();
                this.f35136b.setSuccessByCache(true);
                c(-3, null);
                this.f35137c.a(this.f35136b);
                return;
            }
            this.f35137c.a(this.f35136b);
            c.p.a.e.b.l.f.y(this.f35136b, str);
            this.f35136b.setSuccessByCache(true);
            D();
            c(-3, null);
        }
    }

    public boolean k(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j2)) == null) {
            this.k.addAndGet(j2);
            this.f35136b.increaseCurBytes(j2);
            long uptimeMillis = SystemClock.uptimeMillis();
            return l(uptimeMillis, q(uptimeMillis));
        }
        return invokeJ.booleanValue;
    }

    public final boolean l(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            if (this.f35136b.getCurBytes() == this.f35136b.getTotalBytes()) {
                try {
                    this.f35137c.a(this.f35136b.getId(), this.f35136b.getCurBytes());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return false;
            }
            if (this.f35143i) {
                this.f35143i = false;
                this.f35136b.setStatus(4);
            }
            if (this.f35136b.isNeedPostProgress() && z) {
                z2 = true;
            }
            d(4, null, z2);
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.f35136b.canSkipStatusHandler()) {
                this.f35136b.changeSkipStatus();
                return;
            }
            this.f35137c.g(this.f35136b.getId());
            if (this.f35136b.isFirstDownload()) {
                c(6, null);
            }
            c(2, null);
        }
    }

    public final void o(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, baseException) == null) {
            String str = "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable());
            if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
                try {
                    this.f35137c.f(this.f35136b.getId());
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    try {
                        this.f35137c.b(this.f35136b.getId(), this.f35136b.getCurBytes());
                    } catch (SQLiteException unused) {
                        this.f35137c.f(this.f35136b.getId());
                    }
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            }
            BaseException r = r(baseException);
            this.f35136b.setFailedException(r);
            c(r instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, r);
            if (c.p.a.e.b.j.a.d(this.f35136b.getId()).b("retry_schedule", 0) > 0) {
                c.p.a.e.b.m.q.d().k(this.f35136b);
            }
        }
    }

    public final void p(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, baseException, z) == null) {
            this.f35137c.h(this.f35136b.getId());
            c(z ? 7 : 5, baseException);
        }
    }

    public final boolean q(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j2)) == null) {
            boolean z = true;
            if (!this.l) {
                this.l = true;
                return true;
            }
            long j3 = j2 - this.f35144j;
            if (this.k.get() < this.n && j3 < this.m) {
                z = false;
            }
            if (z) {
                this.f35144j = j2;
                this.k.set(0L);
            }
            return z;
        }
        return invokeJ.booleanValue;
    }

    public final BaseException r(BaseException baseException) {
        InterceptResult invokeL;
        Context n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, baseException)) == null) {
            if (c.p.a.e.b.j.a.d(this.f35136b.getId()).b("download_failed_check_net", 1) != 1 || !c.p.a.e.b.l.f.Y0(baseException) || (n = e.n()) == null || c.p.a.e.b.l.f.r0(n)) {
                return baseException;
            }
            return new BaseException(this.f35136b.isOnlyWifi() ? 1013 : SDKLogTypeConstants.TYPE_LP_LOAD_URL, baseException.getErrorMessage());
        }
        return (BaseException) invokeL.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c(-4, null);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f35136b.setStatus(-2);
            try {
                this.f35137c.d(this.f35136b.getId(), this.f35136b.getCurBytes());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            c(-2, null);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f35136b.setStatus(-7);
            try {
                this.f35137c.j(this.f35136b.getId());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            c(-7, null);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f35136b.setFirstDownload(false);
            if (!this.f35136b.isIgnoreDataVerify() && this.f35136b.getCurBytes() != this.f35136b.getTotalBytes()) {
                c.p.a.e.b.c.a.g(p, this.f35136b.getErrorBytesLog());
                g(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.f35136b.getByteInvalidRetryStatus()));
            } else if (this.f35136b.getCurBytes() <= 0) {
                c.p.a.e.b.c.a.g(p, this.f35136b.getErrorBytesLog());
                g(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.f35136b.getByteInvalidRetryStatus()));
            } else if (!this.f35136b.isIgnoreDataVerify() && this.f35136b.getTotalBytes() <= 0) {
                c.p.a.e.b.c.a.g(p, this.f35136b.getErrorBytesLog());
                g(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f35136b.getByteInvalidRetryStatus()));
            } else {
                String str = p;
                c.p.a.e.b.c.a.g(str, "" + this.f35136b.getName() + " onCompleted start save file as target name");
                z zVar = this.o;
                c.p.a.e.b.n.a aVar = this.f35139e;
                if (aVar != null) {
                    zVar = aVar.R();
                }
                c.p.a.e.b.l.f.x(this.f35136b, zVar, new b(this));
            }
        }
    }

    public void x() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f35135a) {
                D();
                c.p.a.e.b.c.a.g(p, "onCompleteForFileExist");
                this.f35136b.setSuccessByCache(true);
                c(-3, null);
                this.f35137c.c(this.f35136b.getId(), this.f35136b.getTotalBytes());
                this.f35137c.d(this.f35136b.getId());
                this.f35137c.a(this.f35136b);
                this.f35137c.m(this.f35136b.getId());
                return;
            }
            D();
            c.p.a.e.b.c.a.g(p, "onCompleteForFileExist");
            this.f35136b.setSuccessByCache(true);
            c(-3, null);
            this.f35137c.c(this.f35136b.getId(), this.f35136b.getTotalBytes());
            this.f35137c.d(this.f35136b.getId());
            this.f35137c.m(this.f35136b.getId());
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f35136b.setStatus(8);
            this.f35136b.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f75826b);
            c.p.a.e.b.m.a c2 = e.c();
            if (c2 != null) {
                c2.e(this.f35136b.getId(), this.f35139e.P(), 8);
            }
        }
    }
}
