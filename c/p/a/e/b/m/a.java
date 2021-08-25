package c.p.a.e.b.m;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.w;
import c.p.a.e.b.f.z;
import c.p.a.e.b.g.r;
import c.p.a.e.b.k.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
/* loaded from: classes4.dex */
public abstract class a implements h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<c.p.a.e.b.n.a> f35177a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<c.p.a.e.b.n.a> f35178b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<c.p.a.e.b.n.a> f35179c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<c.p.a.e.b.n.a> f35180d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<c.p.a.e.b.n.a> f35181e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<SparseArray<c.p.a.e.b.n.a>> f35182f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.h<Integer, c.p.a.e.b.n.a> f35183g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<Long> f35184h;

    /* renamed from: i  reason: collision with root package name */
    public final LinkedBlockingDeque<c.p.a.e.b.n.a> f35185i;

    /* renamed from: j  reason: collision with root package name */
    public final c.p.a.e.b.g.k f35186j;
    public final c.p.a.e.b.k.h k;

    /* renamed from: c.p.a.e.b.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1550a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f35187e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f35188f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SparseArray f35189g;

        public RunnableC1550a(a aVar, SparseArray sparseArray, DownloadInfo downloadInfo, SparseArray sparseArray2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray, downloadInfo, sparseArray2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35187e = sparseArray;
            this.f35188f = downloadInfo;
            this.f35189g = sparseArray2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SparseArray sparseArray2 = this.f35187e;
                if (sparseArray2 != null) {
                    synchronized (sparseArray2) {
                        for (int i2 = 0; i2 < this.f35187e.size(); i2++) {
                            c.p.a.e.b.f.c cVar = (c.p.a.e.b.f.c) this.f35187e.get(this.f35187e.keyAt(i2));
                            if (cVar != null) {
                                cVar.e(this.f35188f);
                            }
                        }
                    }
                }
                DownloadInfo downloadInfo = this.f35188f;
                if (downloadInfo == null || !downloadInfo.canShowNotification() || (sparseArray = this.f35189g) == null) {
                    return;
                }
                synchronized (sparseArray) {
                    for (int i3 = 0; i3 < this.f35189g.size(); i3++) {
                        c.p.a.e.b.f.c cVar2 = (c.p.a.e.b.f.c) this.f35189g.get(this.f35189g.keyAt(i3));
                        if (cVar2 != null) {
                            cVar2.e(this.f35188f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f35190e;

        public b(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35190e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.p.a.e.b.p.b.a().m(this.f35190e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f35191e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f35192f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f35193g;

        public c(a aVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35193g = aVar;
            this.f35191e = i2;
            this.f35192f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.p.a.e.b.n.a T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f35193g.D(this.f35191e) == null && (T = this.f35193g.T(this.f35191e)) != null) {
                    DownloadInfo J = T.J();
                    SparseArray<c.p.a.e.b.f.c> M = T.M(com.ss.android.socialbase.downloader.constants.f.f75661b);
                    if (M != null) {
                        synchronized (M) {
                            for (int i2 = 0; i2 < M.size(); i2++) {
                                c.p.a.e.b.f.c cVar = M.get(M.keyAt(i2));
                                if (cVar != null) {
                                    cVar.e(J);
                                }
                            }
                        }
                    }
                }
                this.f35193g.H(this.f35191e, this.f35192f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f35194e;

        public d(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35194e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.p.a.e.b.p.b.a().m(this.f35194e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f35195e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f35196f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f35197g;

        public e(a aVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35197g = aVar;
            this.f35195e = i2;
            this.f35196f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35197g.D(this.f35195e);
                this.f35197g.I(this.f35195e, this.f35196f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.p.a.e.b.f.c f35198e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f35199f;

        public f(a aVar, c.p.a.e.b.f.c cVar, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35198e = cVar;
            this.f35199f = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35198e == null) {
                return;
            }
            if (this.f35199f.getStatus() == -3) {
                this.f35198e.f(this.f35199f);
            } else if (this.f35199f.getStatus() == -1) {
                this.f35198e.h(this.f35199f, new BaseException(1000, "try add listener for failed task"));
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
        this.f35177a = new SparseArray<>();
        this.f35178b = new SparseArray<>();
        this.f35179c = new SparseArray<>();
        this.f35180d = new SparseArray<>();
        this.f35181e = new SparseArray<>();
        this.f35182f = new SparseArray<>();
        this.f35183g = new com.ss.android.socialbase.downloader.i.h<>();
        this.f35184h = new SparseArray<>();
        this.f35185i = new LinkedBlockingDeque<>();
        this.k = new c.p.a.e.b.k.h(Looper.getMainLooper(), this);
        this.f35186j = c.p.a.e.b.g.e.M0();
    }

    public final void A(c.p.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            int P = aVar.P();
            if (P == 0 && aVar.Z()) {
                P = aVar.f();
            }
            if (P == 0) {
                return;
            }
            SparseArray<c.p.a.e.b.n.a> sparseArray = this.f35182f.get(aVar.I());
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.f35182f.put(aVar.I(), sparseArray);
            }
            c.p.a.e.b.c.a.g("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + aVar.I() + " listener hasCode:" + P);
            sparseArray.put(P, aVar);
        }
    }

    public synchronized void B(List<String> list) {
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (c.p.a.e.b.l.f.g0(c.p.a.e.b.g.e.n())) {
                    for (int i2 = 0; i2 < this.f35177a.size(); i2++) {
                        c.p.a.e.b.n.a aVar = this.f35177a.get(this.f35177a.keyAt(i2));
                        if (aVar != null && (J = aVar.J()) != null && J.getMimeType() != null && list.contains(J.getMimeType()) && C(J)) {
                            J.setAutoResumed(true);
                            J.setShowNotificationForNetworkResumed(true);
                            o(aVar);
                            J.setDownloadFromReserveWifi(true);
                            r n = c.p.a.e.b.g.a.H(c.p.a.e.b.g.e.n()).n();
                            if (n != null) {
                                n.a(J, 5, 2);
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean C(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
            if (downloadInfo != null && downloadInfo.statusInPause()) {
                return downloadInfo.isPauseReserveOnWifi();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract c.p.a.e.b.k.c D(int i2);

    public void E(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            DownloadInfo b2 = this.f35186j.b(i2);
            if (b2 != null) {
                n(b2);
            }
            this.k.post(new d(this, i2));
            c.p.a.e.b.g.e.W(new e(this, i2, z), false);
        }
    }

    public final void F(c.p.a.e.b.n.a aVar) {
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null || (J = aVar.J()) == null) {
            return;
        }
        try {
            if (this.f35185i.isEmpty()) {
                p(aVar, true);
                this.f35185i.put(aVar);
            } else if (J.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.f35185i.getFirst().I() == aVar.I() && r(aVar.I())) {
                    return;
                }
                Iterator<c.p.a.e.b.n.a> it = this.f35185i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c.p.a.e.b.n.a next = it.next();
                    if (next != null && next.I() == aVar.I()) {
                        it.remove();
                        break;
                    }
                }
                this.f35185i.put(aVar);
                new c.p.a.e.b.g.h(aVar, this.k).b();
            } else {
                c.p.a.e.b.n.a first = this.f35185i.getFirst();
                if (first.I() == aVar.I() && r(aVar.I())) {
                    return;
                }
                J(first.I());
                p(aVar, true);
                if (first.I() != aVar.I()) {
                    this.f35185i.putFirst(aVar);
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    public synchronized DownloadInfo G(int i2) {
        InterceptResult invokeI;
        DownloadInfo b2;
        c.p.a.e.b.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            synchronized (this) {
                b2 = this.f35186j.b(i2);
                if (b2 == null && (aVar = this.f35177a.get(i2)) != null) {
                    b2 = aVar.J();
                }
            }
            return b2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    public final synchronized void H(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                c.p.a.e.b.c.a.g("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i2 + " deleteTargetFile=" + z);
                DownloadInfo b2 = this.f35186j.b(i2);
                if (b2 != null) {
                    if (z) {
                        c.p.a.e.b.l.f.w(b2);
                    } else {
                        c.p.a.e.b.l.f.n0(b2.getTempPath(), b2.getTempName());
                    }
                    b2.erase();
                }
                try {
                    this.f35186j.f(i2);
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
                e(i2, 0, -4);
                if (this.f35179c.get(i2) != null) {
                    this.f35179c.remove(i2);
                }
                if (this.f35178b.get(i2) != null) {
                    this.f35178b.remove(i2);
                }
                this.f35183g.remove(Integer.valueOf(i2));
                c.p.a.e.b.j.a.p(i2);
            }
        }
    }

    public final void I(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            try {
                DownloadInfo b2 = this.f35186j.b(i2);
                if (b2 != null) {
                    c.p.a.e.b.l.f.z(b2, z);
                    b2.erase();
                }
                try {
                    this.f35186j.d(i2);
                    this.f35186j.a(b2);
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
                if (this.f35179c.get(i2) != null) {
                    this.f35179c.remove(i2);
                }
                if (this.f35178b.get(i2) != null) {
                    this.f35178b.remove(i2);
                }
                this.f35183g.remove(Integer.valueOf(i2));
                c.p.a.e.b.j.a.p(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized boolean J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            synchronized (this) {
                c.p.a.e.b.c.a.g("AbsDownloadEngine", "pause id=" + i2);
                DownloadInfo b2 = this.f35186j.b(i2);
                if (b2 == null || b2.getStatus() != 11) {
                    synchronized (this.f35177a) {
                        v(i2);
                    }
                    if (b2 == null) {
                        c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
                        if (aVar != null) {
                            new c.p.a.e.b.g.h(aVar, this.k).u();
                            return true;
                        }
                    } else {
                        n(b2);
                        if (b2.getStatus() == 1) {
                            c.p.a.e.b.n.a aVar2 = this.f35177a.get(i2);
                            if (aVar2 != null) {
                                new c.p.a.e.b.g.h(aVar2, this.k).u();
                                return true;
                            }
                        } else if (c.p.a.e.b.d.a.b(b2.getStatus())) {
                            b2.setStatus(-2);
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
                if (aVar != null) {
                    DownloadInfo J = aVar.J();
                    if (J != null) {
                        J.setDownloadFromReserveWifi(false);
                    }
                    o(aVar);
                } else {
                    L(i2);
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35179c.get(i2);
                if (aVar == null) {
                    aVar = this.f35180d.get(i2);
                }
                if (aVar != null) {
                    DownloadInfo J = aVar.J();
                    if (J != null) {
                        J.setDownloadFromReserveWifi(false);
                    }
                    o(aVar);
                    return true;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized c.p.a.e.b.f.j M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
                if (aVar != null) {
                    return aVar.S();
                }
                c.p.a.e.b.n.a aVar2 = this.f35178b.get(i2);
                if (aVar2 != null) {
                    return aVar2.S();
                }
                c.p.a.e.b.n.a aVar3 = this.f35179c.get(i2);
                if (aVar3 != null) {
                    return aVar3.S();
                }
                c.p.a.e.b.n.a aVar4 = this.f35180d.get(i2);
                if (aVar4 != null) {
                    return aVar4.S();
                }
                c.p.a.e.b.n.a aVar5 = this.f35181e.get(i2);
                if (aVar5 != null) {
                    return aVar5.S();
                }
                return null;
            }
        }
        return (c.p.a.e.b.f.j) invokeI.objValue;
    }

    public synchronized c.p.a.e.b.f.e N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
                if (aVar != null) {
                    return aVar.T();
                }
                c.p.a.e.b.n.a aVar2 = this.f35178b.get(i2);
                if (aVar2 != null) {
                    return aVar2.T();
                }
                c.p.a.e.b.n.a aVar3 = this.f35179c.get(i2);
                if (aVar3 != null) {
                    return aVar3.T();
                }
                c.p.a.e.b.n.a aVar4 = this.f35180d.get(i2);
                if (aVar4 != null) {
                    return aVar4.T();
                }
                c.p.a.e.b.n.a aVar5 = this.f35181e.get(i2);
                if (aVar5 != null) {
                    return aVar5.T();
                }
                return null;
            }
        }
        return (c.p.a.e.b.f.e) invokeI.objValue;
    }

    public synchronized w O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
                if (aVar != null) {
                    return aVar.N();
                }
                c.p.a.e.b.n.a aVar2 = this.f35178b.get(i2);
                if (aVar2 != null) {
                    return aVar2.N();
                }
                c.p.a.e.b.n.a aVar3 = this.f35179c.get(i2);
                if (aVar3 != null) {
                    return aVar3.N();
                }
                c.p.a.e.b.n.a aVar4 = this.f35180d.get(i2);
                if (aVar4 != null) {
                    return aVar4.N();
                }
                c.p.a.e.b.n.a aVar5 = this.f35181e.get(i2);
                if (aVar5 != null) {
                    return aVar5.N();
                }
                return null;
            }
        }
        return (w) invokeI.objValue;
    }

    public synchronized boolean P(int i2) {
        InterceptResult invokeI;
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35180d.get(i2);
                if (aVar != null && (J = aVar.J()) != null) {
                    if (J.canStartRetryDelayTask()) {
                        p(aVar, false);
                    }
                    return true;
                }
                DownloadInfo b2 = this.f35186j.b(i2);
                if (b2 != null && b2.canStartRetryDelayTask()) {
                    p(new c.p.a.e.b.n.a(b2), false);
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean Q(int i2) {
        InterceptResult invokeI;
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35181e.get(i2);
                if (aVar == null || (J = aVar.J()) == null) {
                    return false;
                }
                if (J.canReStartAsyncTask()) {
                    o(aVar);
                }
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized void R(int i2) {
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
                if (aVar != null && (J = aVar.J()) != null) {
                    J.setForceIgnoreRecommendSize(true);
                    o(aVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r4.f35179c.get(r5) != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean S(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            synchronized (this) {
                if (i2 != 0) {
                    if (this.f35177a.get(i2) == null) {
                    }
                    z = true;
                }
                z = false;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public final c.p.a.e.b.n.a T(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
            if (aVar == null) {
                c.p.a.e.b.n.a aVar2 = this.f35179c.get(i2);
                if (aVar2 == null) {
                    c.p.a.e.b.n.a aVar3 = this.f35178b.get(i2);
                    if (aVar3 == null) {
                        c.p.a.e.b.n.a aVar4 = this.f35180d.get(i2);
                        return aVar4 == null ? this.f35181e.get(i2) : aVar4;
                    }
                    return aVar3;
                }
                return aVar2;
            }
            return aVar;
        }
        return (c.p.a.e.b.n.a) invokeI.objValue;
    }

    public final void U(int i2) {
        c.p.a.e.b.n.a first;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || this.f35185i.isEmpty()) {
            return;
        }
        c.p.a.e.b.n.a first2 = this.f35185i.getFirst();
        if (first2 != null && first2.I() == i2) {
            this.f35185i.poll();
        }
        if (this.f35185i.isEmpty() || (first = this.f35185i.getFirst()) == null) {
            return;
        }
        p(first, true);
    }

    public abstract List<Integer> b();

    public synchronized List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                List<DownloadInfo> a2 = this.f35186j.a(str);
                if (a2 == null || a2.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    int size = this.f35177a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.p.a.e.b.n.a valueAt = this.f35177a.valueAt(i2);
                        if (valueAt != null && valueAt.J() != null && str.equals(valueAt.J().getUrl())) {
                            arrayList.add(valueAt.J());
                        }
                    }
                    return arrayList;
                }
                return a2;
            }
        }
        return (List) invokeL.objValue;
    }

    public final void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            c.p.a.e.b.c.a.g("AbsDownloadEngine", "removeTask id: " + i2 + " listener hasCode: " + i3);
            if (i3 == 0) {
                this.f35177a.remove(i2);
                this.f35182f.remove(i2);
                return;
            }
            SparseArray<c.p.a.e.b.n.a> sparseArray = this.f35182f.get(i2);
            if (sparseArray != null) {
                sparseArray.remove(i3);
                c.p.a.e.b.c.a.g("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
                if (sparseArray.size() == 0) {
                    this.f35177a.remove(i2);
                    this.f35182f.remove(i2);
                    return;
                }
                return;
            }
            this.f35177a.remove(i2);
        }
    }

    public synchronized void e(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048601, this, i2, i3, i4) == null) {
            synchronized (this) {
                if (i4 != -7) {
                    if (i4 == -6) {
                        this.f35178b.put(i2, this.f35177a.get(i2));
                        d(i2, i3);
                    } else if (i4 == -4) {
                        d(i2, i3);
                        U(i2);
                    } else if (i4 == -3) {
                        this.f35178b.put(i2, this.f35177a.get(i2));
                        d(i2, i3);
                        U(i2);
                    } else if (i4 != -1) {
                        if (i4 == 7) {
                            c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
                            if (aVar != null) {
                                if (this.f35180d.get(i2) == null) {
                                    this.f35180d.put(i2, aVar);
                                }
                                d(i2, i3);
                            }
                            U(i2);
                        } else if (i4 == 8) {
                            c.p.a.e.b.n.a aVar2 = this.f35177a.get(i2);
                            if (aVar2 != null && this.f35181e.get(i2) == null) {
                                this.f35181e.put(i2, aVar2);
                            }
                            U(i2);
                        }
                    }
                }
                c.p.a.e.b.n.a aVar3 = this.f35177a.get(i2);
                if (aVar3 != null) {
                    if (this.f35179c.get(i2) == null) {
                        this.f35179c.put(i2, aVar3);
                    }
                    d(i2, i3);
                }
                U(i2);
            }
        }
    }

    public synchronized void f(int i2, int i3, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, fVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a T = T(i2);
                if (T == null) {
                    T = this.f35183g.get(Integer.valueOf(i2));
                }
                if (T != null) {
                    T.z0(i3, cVar, fVar, z);
                }
            }
        }
    }

    public synchronized void g(int i2, int i3, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        DownloadInfo b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a T = T(i2);
                if (T != null) {
                    T.c(i3, cVar, fVar, z);
                    DownloadInfo J = T.J();
                    if (z2 && J != null && !r(i2) && (fVar == com.ss.android.socialbase.downloader.constants.f.f75660a || fVar == com.ss.android.socialbase.downloader.constants.f.f75662c)) {
                        boolean z3 = true;
                        if (fVar == com.ss.android.socialbase.downloader.constants.f.f75662c && !J.canShowNotification()) {
                            z3 = false;
                        }
                        if (z3) {
                            this.k.post(new f(this, cVar, J));
                        }
                    }
                } else if (c.p.a.e.b.l.a.a(32768) && (b2 = this.f35186j.b(i2)) != null && b2.getStatus() != -3) {
                    c.p.a.e.b.n.a aVar = this.f35183g.get(Integer.valueOf(i2));
                    if (aVar == null) {
                        aVar = new c.p.a.e.b.n.a(b2);
                        this.f35183g.put(Integer.valueOf(i2), aVar);
                    }
                    aVar.c(i3, cVar, fVar, z);
                }
            }
        }
    }

    public abstract void h(int i2, long j2);

    public synchronized void i(int i2, c.p.a.e.b.f.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i2, eVar) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
                if (aVar != null) {
                    aVar.J0(eVar);
                }
            }
        }
    }

    public final void j(int i2, BaseException baseException, c.p.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048606, this, i2, baseException, aVar) == null) || aVar == null) {
            return;
        }
        DownloadInfo J = aVar.J();
        SparseArray<c.p.a.e.b.f.c> M = aVar.M(com.ss.android.socialbase.downloader.constants.f.f75660a);
        SparseArray<c.p.a.e.b.f.c> M2 = aVar.M(com.ss.android.socialbase.downloader.constants.f.f75662c);
        boolean z = aVar.j() || J.isAutoInstallWithoutNotification();
        c.p.a.e.b.l.c.a(i2, M, true, J, baseException);
        c.p.a.e.b.l.c.a(i2, M2, z, J, baseException);
    }

    public abstract void k(int i2, c.p.a.e.b.n.a aVar);

    public abstract void l(c.p.a.e.b.k.c cVar);

    public final void n(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        try {
            if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.g.f75664a) {
                downloadInfo.setStatus(5);
                downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.f75664a);
                c.p.a.e.b.c.a.g("AbsDownloadEngine", "cancelAlarm");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void o(c.p.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, aVar) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return;
                }
                DownloadInfo J = aVar.J();
                if (J == null) {
                    return;
                }
                J.setDownloadFromReserveWifi(false);
                if (J.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
                    F(aVar);
                } else {
                    p(aVar, true);
                }
            }
        }
    }

    public final void p(c.p.a.e.b.n.a aVar, boolean z) {
        DownloadInfo J;
        int i2;
        DownloadInfo J2;
        c.p.a.e.b.n.a remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048611, this, aVar, z) == null) || aVar == null || (J = aVar.J()) == null) {
            return;
        }
        if (J.isEntityInvalid()) {
            z R = aVar.R();
            c.p.a.e.b.e.a.e(R, J, new BaseException(1003, "downloadInfo is Invalid, url is " + J.getUrl() + " name is " + J.getName() + " savePath is " + J.getSavePath()), J.getStatus());
            return;
        }
        boolean z2 = false;
        if (c.p.a.e.b.j.a.d(J.getId()).b("no_net_opt", 0) == 1 && !c.p.a.e.b.l.f.r0(c.p.a.e.b.g.e.n()) && !J.isFirstDownload()) {
            new c.p.a.e.b.g.h(aVar, this.k).g(new BaseException((int) SDKLogTypeConstants.TYPE_LP_LOAD_URL, "network_not_available"));
            return;
        }
        int id = J.getId();
        if (z) {
            n(J);
        }
        if (this.f35179c.get(id) != null) {
            this.f35179c.remove(id);
        }
        if (this.f35178b.get(id) != null) {
            this.f35178b.remove(id);
        }
        if (this.f35180d.get(id) != null) {
            this.f35180d.remove(id);
        }
        if (this.f35181e.get(id) != null) {
            this.f35181e.remove(id);
        }
        if (r(id) && !J.canReStartAsyncTask()) {
            c.p.a.e.b.c.a.g("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            aVar.d();
            c.p.a.e.b.e.a.e(aVar.R(), J, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), J.getStatus());
            return;
        }
        c.p.a.e.b.c.a.g("AbsDownloadEngine", "no downloading task :" + id);
        if (J.canReStartAsyncTask()) {
            J.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f75647c);
        }
        if (c.p.a.e.b.l.a.a(32768) && (remove = this.f35183g.remove(Integer.valueOf(id))) != null) {
            aVar.m(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        c.p.a.e.b.n.a aVar2 = this.f35177a.get(id);
        if (aVar2 == null || (J2 = aVar2.J()) == null) {
            i2 = 0;
        } else {
            i2 = J2.getStatus();
            if (c.p.a.e.b.d.a.b(i2)) {
                z2 = true;
            }
        }
        c.p.a.e.b.c.a.g("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + i2);
        if (z2) {
            aVar.d();
            return;
        }
        A(aVar);
        this.f35177a.put(id, aVar);
        this.f35184h.put(id, Long.valueOf(uptimeMillis));
        k(id, aVar);
    }

    public synchronized void q(List<String> list) {
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, list) == null) {
            synchronized (this) {
                try {
                    boolean g0 = c.p.a.e.b.l.a.a(1048576) ? c.p.a.e.b.l.f.g0(c.p.a.e.b.g.e.n()) : true;
                    for (int i2 = 0; i2 < this.f35179c.size(); i2++) {
                        c.p.a.e.b.n.a aVar = this.f35179c.get(this.f35179c.keyAt(i2));
                        if (aVar != null && (J = aVar.J()) != null && J.getMimeType() != null && list.contains(J.getMimeType()) && (!J.isOnlyWifi() || g0)) {
                            J.setAutoResumed(true);
                            J.setShowNotificationForNetworkResumed(true);
                            o(aVar);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public abstract boolean r(int i2);

    public synchronized boolean s(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                c.p.a.e.b.n.a aVar = this.f35177a.get(i2);
                if (aVar == null && c.p.a.e.b.l.a.a(65536)) {
                    aVar = T(i2);
                }
                if (aVar != null) {
                    if (!c.p.a.e.b.j.a.d(i2).q("fix_on_cancel_call_twice", true)) {
                        new c.p.a.e.b.g.h(aVar, this.k).s();
                    }
                    this.k.post(new RunnableC1550a(this, aVar.M(com.ss.android.socialbase.downloader.constants.f.f75660a), aVar.J(), aVar.M(com.ss.android.socialbase.downloader.constants.f.f75662c)));
                }
                DownloadInfo b2 = this.f35186j.b(i2);
                if (c.p.a.e.b.l.a.a(65536)) {
                    if (b2 != null) {
                        b2.setStatus(-4);
                    }
                } else if (b2 != null && c.p.a.e.b.d.a.b(b2.getStatus())) {
                    b2.setStatus(-4);
                }
                y(i2, z);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public List<DownloadInfo> t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Integer num : b()) {
                DownloadInfo G = G(num.intValue());
                if (G != null && str.equals(G.getMimeType())) {
                    arrayList.add(G);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void u() {
        List<Integer> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (b2 = b()) == null) {
            return;
        }
        for (Integer num : b2) {
            J(num.intValue());
        }
    }

    public abstract void v(int i2);

    public synchronized void w(int i2, int i3, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, fVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                g(i2, i3, cVar, fVar, z, true);
            }
        }
    }

    public void x(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            DownloadInfo b2 = this.f35186j.b(i2);
            if (b2 != null) {
                b2.setThrottleNetSpeed(j2);
            }
            h(i2, j2);
        }
    }

    public void y(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            DownloadInfo b2 = this.f35186j.b(i2);
            if (b2 != null) {
                n(b2);
            }
            this.k.post(new b(this, i2));
            c.p.a.e.b.g.e.W(new c(this, i2, z), false);
        }
    }

    @Override // c.p.a.e.b.k.h.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, message) == null) {
            int i2 = message.arg1;
            int i3 = message.arg2;
            c.p.a.e.b.c.a.g("AbsDownloadEngine", "handleMsg id: " + i2 + " listener hasCode: " + i3);
            Object obj = message.obj;
            c.p.a.e.b.n.a aVar = null;
            BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
            synchronized (this) {
                if (i3 == 0) {
                    aVar = this.f35177a.get(i2);
                } else {
                    SparseArray<c.p.a.e.b.n.a> sparseArray = this.f35182f.get(i2);
                    if (sparseArray != null) {
                        aVar = sparseArray.get(i3);
                    }
                }
                if (aVar == null) {
                    return;
                }
                j(message.what, baseException, aVar);
                e(i2, i3, message.what);
            }
        }
    }
}
