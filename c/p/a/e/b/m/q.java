package c.p.a.e.b.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.a.a;
import c.p.a.e.b.g.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q implements Handler.Callback, a.b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q l;
    public static e m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f35127e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f35128f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<d> f35129g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f35130h;

    /* renamed from: i  reason: collision with root package name */
    public long f35131i;

    /* renamed from: j  reason: collision with root package name */
    public int f35132j;
    public ConnectivityManager k;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f35133e;

        /* renamed from: c.p.a.e.b.m.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1548a extends ConnectivityManager.NetworkCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35134a;

            public C1548a(a aVar) {
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
                this.f35134a = aVar;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, network) == null) {
                    c.p.a.e.b.c.a.g("RetryScheduler", "network onAvailable: ");
                    this.f35134a.f35133e.g(1, true);
                }
            }
        }

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35133e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f35133e.f35127e == null || Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    this.f35133e.k = (ConnectivityManager) this.f35133e.f35127e.getApplicationContext().getSystemService("connectivity");
                    this.f35133e.k.registerNetworkCallback(new NetworkRequest.Builder().build(), new C1548a(this));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f35135e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f35136f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q f35137g;

        public b(q qVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35137g = qVar;
            this.f35135e = i2;
            this.f35136f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int A;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f35137g.f35132j > 0 && (A = this.f35137g.A()) != 0) {
                        c.p.a.e.b.c.a.i("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + this.f35137g.f35132j);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<d> arrayList = new ArrayList();
                        synchronized (this.f35137g.f35129g) {
                            for (int i2 = 0; i2 < this.f35137g.f35129g.size(); i2++) {
                                d dVar = (d) this.f35137g.f35129g.valueAt(i2);
                                if (dVar != null && dVar.d(currentTimeMillis, this.f35135e, A, this.f35136f)) {
                                    if (this.f35136f) {
                                        dVar.i();
                                    }
                                    arrayList.add(dVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            for (d dVar2 : arrayList) {
                                this.f35137g.f(dVar2.f35140a, A, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f35138e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q f35139f;

        public c(q qVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35139f = qVar;
            this.f35138e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f35139f.f(this.f35138e, this.f35139f.A(), true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f35140a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35141b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35142c;

        /* renamed from: d  reason: collision with root package name */
        public final int f35143d;

        /* renamed from: e  reason: collision with root package name */
        public final int f35144e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f35145f;

        /* renamed from: g  reason: collision with root package name */
        public final int[] f35146g;

        /* renamed from: h  reason: collision with root package name */
        public int f35147h;

        /* renamed from: i  reason: collision with root package name */
        public int f35148i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f35149j;
        public long k;
        public boolean l;

        public d(int i2, int i3, int i4, int i5, int i6, boolean z, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            i5 = i5 < 3000 ? 3000 : i5;
            i6 = i6 < 5000 ? 5000 : i6;
            this.f35140a = i2;
            this.f35141b = i3;
            this.f35142c = i4;
            this.f35143d = i5;
            this.f35144e = i6;
            this.f35145f = z;
            this.f35146g = iArr;
            this.f35147h = i5;
        }

        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    this.f35147h += this.f35144e;
                }
            }
        }

        public synchronized void c(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                synchronized (this) {
                    this.k = j2;
                }
            }
        }

        public boolean d(long j2, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                if (!this.l) {
                    c.p.a.e.b.c.a.i("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                    return false;
                } else if (this.f35141b >= i2 && this.f35148i < this.f35142c) {
                    if (!this.f35149j || i3 == 2) {
                        return z || j2 - this.k >= ((long) this.f35143d);
                    }
                    return false;
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        public synchronized void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.f35148i++;
                }
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f35147h = this.f35143d;
            }
        }

        public int j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35147h : invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(DownloadInfo downloadInfo, long j2, boolean z, int i2);
    }

    public q() {
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
        this.f35128f = new Handler(Looper.getMainLooper(), this);
        this.f35129g = new SparseArray<>();
        this.f35132j = 0;
        this.f35127e = c.p.a.e.b.g.e.n();
        z();
        this.f35130h = c.p.a.e.b.l.f.p0();
        c.p.a.e.b.a.a.c().f(this);
    }

    public static q d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (l == null) {
                synchronized (q.class) {
                    if (l == null) {
                        l = new q();
                    }
                }
            }
            return l;
        }
        return (q) invokeV.objValue;
    }

    public static void h(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar) == null) {
            m = eVar;
        }
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.k == null) {
                    this.k = (ConnectivityManager) this.f35127e.getApplicationContext().getSystemService("connectivity");
                }
                NetworkInfo activeNetworkInfo = this.k.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    return activeNetworkInfo.getType() == 1 ? 2 : 1;
                }
            } catch (Exception unused) {
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.p.a.e.b.a.a.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g(3, false);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            c.p.a.e.b.g.e.A0().execute(new c(this, i2));
        }
    }

    public final void f(int i2, int i3, boolean z) {
        Context context;
        r n;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || (context = this.f35127e) == null) {
            return;
        }
        synchronized (this.f35129g) {
            d dVar = this.f35129g.get(i2);
            if (dVar == null) {
                return;
            }
            boolean z3 = true;
            if (dVar.l) {
                dVar.l = false;
                int i4 = this.f35132j - 1;
                this.f35132j = i4;
                if (i4 < 0) {
                    this.f35132j = 0;
                }
            }
            c.p.a.e.b.c.a.i("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + dVar.f35148i + ", mWaitingRetryTasksCount = " + this.f35132j);
            DownloadInfo f2 = c.p.a.e.b.g.a.H(context).f(i2);
            if (f2 == null) {
                t(i2);
                return;
            }
            c.p.a.e.b.c.a.k("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i2);
            int realStatus = f2.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && f2.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (n = c.p.a.e.b.g.a.H(c.p.a.e.b.g.e.n()).n()) != null) {
                        n.a(f2, 4, 3);
                    }
                    c.p.a.e.b.g.m L0 = c.p.a.e.b.g.e.L0();
                    if (L0 != null) {
                        L0.a(Collections.singletonList(f2), 3);
                    }
                    t(i2);
                    return;
                } else if (realStatus != -1) {
                    return;
                } else {
                    if (i3 != 0) {
                        z2 = true;
                    } else if (!dVar.f35145f) {
                        return;
                    } else {
                        z2 = false;
                    }
                    BaseException failedException = f2.getFailedException();
                    if (z2 && c.p.a.e.b.l.f.V0(failedException)) {
                        z2 = n(f2, failedException);
                    }
                    dVar.f();
                    if (z2) {
                        c.p.a.e.b.c.a.i("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + dVar.f35140a);
                        dVar.c(System.currentTimeMillis());
                        if (z) {
                            dVar.b();
                        }
                        f2.setRetryScheduleCount(dVar.f35148i);
                        if (f2.getStatus() == -1) {
                            c.p.a.e.b.g.a.H(context).y(f2.getId());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        dVar.b();
                    }
                    if (!f2.isOnlyWifi() && !f2.isPauseReserveOnWifi()) {
                        z3 = false;
                    }
                    l(f2, z3, i3);
                    return;
                }
            }
            t(i2);
        }
    }

    public final void g(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f35132j <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.f35131i < 10000) {
                    return;
                }
            }
            this.f35131i = currentTimeMillis;
            c.p.a.e.b.c.a.i("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + PreferencesUtil.RIGHT_MOUNT);
            if (z) {
                this.f35128f.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i2;
            obtain.arg2 = z ? 1 : 0;
            this.f35128f.sendMessageDelayed(obtain, 2000L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            if (message.what == 0) {
                r(message.arg1, message.arg2 == 1);
            } else {
                c.p.a.e.b.c.a.i("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
                e(message.what);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void k(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadInfo) == null) || downloadInfo == null || TextUtils.isEmpty(c.p.a.e.b.d.c.f34864a) || !c.p.a.e.b.d.c.f34864a.equals(downloadInfo.getMimeType())) {
            return;
        }
        l(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), A());
    }

    public final void l(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{downloadInfo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (failedException = downloadInfo.getFailedException()) == null) {
            return;
        }
        d q = q(downloadInfo.getId());
        if (q.f35148i > q.f35142c) {
            c.p.a.e.b.c.a.j("RetryScheduler", "tryStartScheduleRetry, id = " + q.f35140a + ", mRetryCount = " + q.f35148i + ", maxCount = " + q.f35142c);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!c.p.a.e.b.l.f.V0(failedException) && !c.p.a.e.b.l.f.Y0(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!m(q, errorCode)) {
                return;
            }
            c.p.a.e.b.c.a.i("RetryScheduler", "allow error code, id = " + q.f35140a + ", error code = " + errorCode);
        }
        q.f35149j = z;
        synchronized (this.f35129g) {
            if (!q.l) {
                q.l = true;
                this.f35132j++;
            }
        }
        int j2 = q.j();
        c.p.a.e.b.c.a.i("RetryScheduler", "tryStartScheduleRetry: id = " + q.f35140a + ", delayTimeMills = " + j2 + ", mWaitingRetryTasks = " + this.f35132j);
        if (!q.f35145f) {
            if (z) {
                return;
            }
            this.f35128f.removeMessages(downloadInfo.getId());
            this.f35128f.sendEmptyMessageDelayed(downloadInfo.getId(), j2);
            return;
        }
        if (i2 == 0) {
            q.i();
        }
        e eVar = m;
        if (eVar != null) {
            eVar.a(downloadInfo, j2, z, i2);
        }
        if (this.f35130h) {
            q.c(System.currentTimeMillis());
            q.f();
            q.b();
        }
    }

    public final boolean m(d dVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, dVar, i2)) == null) {
            int[] iArr = dVar.f35146g;
            if (iArr != null && iArr.length != 0) {
                for (int i3 : iArr) {
                    if (i3 == i2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final boolean n(DownloadInfo downloadInfo, BaseException baseException) {
        InterceptResult invokeLL;
        long j2;
        long totalBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, downloadInfo, baseException)) == null) {
            try {
                j2 = c.p.a.e.b.l.f.y0(downloadInfo.getTempPath());
            } catch (BaseException e2) {
                e2.printStackTrace();
                j2 = 0;
            }
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                totalBytes = ((com.ss.android.socialbase.downloader.exception.d) baseException).b();
            } else {
                totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
            }
            if (j2 < totalBytes) {
                c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(downloadInfo.getId());
                if (d2.b("space_fill_part_download", 0) == 1) {
                    if (j2 > 0) {
                        int b2 = d2.b("space_fill_min_keep_mb", 100);
                        if (b2 > 0) {
                            long j3 = j2 - (b2 * 1048576);
                            c.p.a.e.b.c.a.i("RetryScheduler", "retry schedule: available = " + c.p.a.e.b.l.f.a(j2) + "MB, minKeep = " + b2 + "MB, canDownload = " + c.p.a.e.b.l.f.a(j3) + "MB");
                            if (j3 <= 0) {
                                c.p.a.e.b.c.a.j("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                                return false;
                            }
                        }
                    } else if (d2.b("download_when_space_negative", 0) != 1) {
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final int[] o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String[] split = str.split(",");
                if (split.length <= 0) {
                    return null;
                }
                int[] iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.parseInt(split[i2]);
                }
                return iArr;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (int[]) invokeL.objValue;
    }

    public final d q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            d dVar = this.f35129g.get(i2);
            if (dVar == null) {
                synchronized (this.f35129g) {
                    dVar = this.f35129g.get(i2);
                    if (dVar == null) {
                        dVar = v(i2);
                    }
                    this.f35129g.put(i2, dVar);
                }
            }
            return dVar;
        }
        return (d) invokeI.objValue;
    }

    public final void r(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            c.p.a.e.b.g.e.A0().execute(new b(this, i2, z));
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            synchronized (this.f35129g) {
                this.f35129g.remove(i2);
            }
        }
    }

    public final d v(int i2) {
        InterceptResult invokeI;
        int[] iArr;
        int i3;
        int i4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(i2);
            boolean z2 = false;
            int b2 = d2.b("retry_schedule", 0);
            JSONObject u = d2.u("retry_schedule_config");
            int i5 = 60;
            if (u != null) {
                int optInt = u.optInt("max_count", 60);
                int optInt2 = u.optInt("interval_sec", 60);
                int optInt3 = u.optInt("interval_sec_acceleration", 60);
                if (Build.VERSION.SDK_INT >= 21 && m != null && u.optInt("use_job_scheduler", 0) == 1) {
                    z2 = true;
                }
                iArr = o(u.optString("allow_error_code"));
                i3 = optInt3;
                z = z2;
                i4 = optInt;
                i5 = optInt2;
            } else {
                iArr = null;
                i3 = 60;
                i4 = 60;
                z = false;
            }
            return new d(i2, b2, i4, i5 * 1000, i3 * 1000, z, iArr);
        }
        return (d) invokeI.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            g(2, true);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            g(5, false);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && c.p.a.e.b.j.a.r().b("use_network_callback", 0) == 1) {
            c.p.a.e.b.g.e.A0().execute(new a(this));
        }
    }

    @Override // c.p.a.e.b.a.a.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            g(4, false);
        }
    }
}
