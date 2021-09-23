package c.p.a.e.b.m;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.g.e;
import c.p.a.e.b.g.t;
import c.p.a.e.b.k.h;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class d implements c.p.a.e.b.g.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final k f35332e;

    /* renamed from: f  reason: collision with root package name */
    public t f35333f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f35334g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f35335h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f35336i;

    /* renamed from: j  reason: collision with root package name */
    public c.p.a.e.b.k.h f35337j;

    /* loaded from: classes4.dex */
    public class a implements h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f35338a;

        /* renamed from: c.p.a.e.b.m.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1550a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f35339e;

            public RunnableC1550a(a aVar) {
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
                this.f35339e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f35339e.f35338a.n();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35338a = dVar;
        }

        @Override // c.p.a.e.b.k.h.a
        public void a(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                c.p.a.e.b.g.e.A0().execute(new RunnableC1550a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f35340a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35340a = dVar;
        }

        @Override // c.p.a.e.b.g.e.d.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35340a.f35333f = new com.ss.android.socialbase.downloader.b.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.p.a.e.b.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f35341a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SparseArray f35342b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f35343c;

        public c(d dVar, SparseArray sparseArray, SparseArray sparseArray2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, sparseArray, sparseArray2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35343c = dVar;
            this.f35341a = sparseArray;
            this.f35342b = sparseArray2;
        }

        @Override // c.p.a.e.b.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f35343c.f35332e) {
                    SparseArray<DownloadInfo> a2 = this.f35343c.f35332e.a();
                    if (this.f35341a != null) {
                        for (int i2 = 0; i2 < this.f35341a.size(); i2++) {
                            int keyAt = this.f35341a.keyAt(i2);
                            if (keyAt != 0) {
                                a2.put(keyAt, (DownloadInfo) this.f35341a.get(keyAt));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f2 = this.f35343c.f35332e.f();
                    if (this.f35342b != null) {
                        for (int i3 = 0; i3 < this.f35342b.size(); i3++) {
                            int keyAt2 = this.f35342b.keyAt(i3);
                            if (keyAt2 != 0) {
                                f2.put(keyAt2, (List) this.f35342b.get(keyAt2));
                            }
                        }
                    }
                }
                this.f35343c.o();
                this.f35343c.m();
                c.p.a.e.b.g.e.D(com.ss.android.socialbase.downloader.constants.d.f76157c);
            }
        }
    }

    public d() {
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
        this.f35336i = new a(this);
        this.f35337j = null;
        this.f35332e = new k();
        if (c.p.a.e.b.j.a.r().l("fix_sigbus_downloader_db")) {
            if (!c.p.a.e.b.l.f.F() && c.p.a.e.b.g.e.s()) {
                this.f35333f = c.p.a.e.b.g.e.t().a(new b(this));
            } else {
                this.f35333f = new com.ss.android.socialbase.downloader.b.e();
            }
        } else {
            this.f35333f = new com.ss.android.socialbase.downloader.b.e();
        }
        this.f35334g = false;
        this.f35337j = new c.p.a.e.b.k.h(Looper.getMainLooper(), this.f35336i);
        l();
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this.f35332e.b(i2) : (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? this.f35332e.c(str) : (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f35334g : invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.f35334g) {
                return true;
            }
            synchronized (this) {
                if (!this.f35334g) {
                    c.p.a.e.b.c.a.j("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                    try {
                        wait(5000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    c.p.a.e.b.c.a.j("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
                }
            }
            return this.f35334g;
        }
        return invokeV.booleanValue;
    }

    public k f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f35332e : (k) invokeV.objValue;
    }

    public final void h(DownloadInfo downloadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048608, this, downloadInfo, z) == null) || downloadInfo == null) {
            return;
        }
        if (!c.p.a.e.b.l.f.e0()) {
            this.f35333f.a(downloadInfo);
        } else if (z) {
            c.p.a.e.b.g.n a2 = l.a(true);
            if (a2 != null) {
                a2.c(downloadInfo);
            } else {
                this.f35333f.a(downloadInfo);
            }
        }
    }

    public final void j(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, downloadInfo) == null) {
            h(downloadInfo, true);
        }
    }

    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f35333f : (t) invokeV.objValue;
    }

    public void l() {
        List<com.ss.android.socialbase.downloader.model.b> list;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            c.p.a.e.b.g.e.D(com.ss.android.socialbase.downloader.constants.d.f76156b);
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2 = new SparseArray<>();
            synchronized (this.f35332e) {
                SparseArray<DownloadInfo> a2 = this.f35332e.a();
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    int keyAt = a2.keyAt(i2);
                    if (keyAt != 0 && (downloadInfo = a2.get(keyAt)) != null) {
                        sparseArray.put(keyAt, downloadInfo);
                    }
                }
                SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f2 = this.f35332e.f();
                for (int i3 = 0; i3 < f2.size(); i3++) {
                    int keyAt2 = f2.keyAt(i3);
                    if (keyAt2 != 0 && (list = f2.get(keyAt2)) != null) {
                        sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                    }
                }
            }
            this.f35333f.a(sparseArray, sparseArray2, new c(this, sparseArray, sparseArray2));
        }
    }

    public void m() {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (c.p.a.e.b.j.a.r().l("task_resume_delay")) {
                j2 = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
            } else {
                j2 = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
            }
            this.f35337j.sendMessageDelayed(this.f35337j.obtainMessage(1), j2);
        }
    }

    public void n() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.f35334g) {
            if (this.f35335h) {
                c.p.a.e.b.c.a.g("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f35335h = true;
            if (c.p.a.e.b.l.f.F()) {
                c.p.a.e.b.g.m L0 = c.p.a.e.b.g.e.L0();
                if (L0 != null) {
                    list = L0.a();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> a2 = this.f35332e.a();
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        int keyAt = a2.keyAt(i2);
                        if (keyAt != 0 && (downloadInfo2 = a2.get(keyAt)) != null) {
                            sparseArray.put(keyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    int keyAt2 = sparseArray.keyAt(i3);
                    if (keyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                            c.p.a.e.b.e.a.d(c.p.a.e.b.g.e.t0(), downloadInfo, null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (c.p.a.e.b.j.a.d(downloadInfo.getId()).m("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (L0 == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                L0.a(arrayList, 1);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            synchronized (this) {
                this.f35334g = true;
                notifyAll();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f35332e.a(str) : (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.f35332e.b(str) : (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? this.f35332e.c(i2) : (List) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? this.f35332e.d(str) : (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (c.p.a.e.b.l.f.e0()) {
                c.p.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.p(i2);
                } else {
                    this.f35333f.f(i2);
                }
            } else {
                this.f35333f.f(i2);
            }
            return this.f35332e.f(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            DownloadInfo g2 = this.f35332e.g(i2);
            j(g2);
            return g2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            DownloadInfo i3 = this.f35332e.i(i2);
            j(i3);
            return i3;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            DownloadInfo j2 = this.f35332e.j(i2);
            j(j2);
            return j2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            synchronized (this.f35332e) {
                this.f35332e.a(bVar);
            }
            if (c.p.a.e.b.l.f.e0()) {
                c.p.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(bVar);
                    return;
                } else {
                    this.f35333f.a(bVar);
                    return;
                }
            }
            this.f35333f.a(bVar);
        }
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f35332e.b() : (List) invokeV.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                this.f35332e.c();
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (c.p.a.e.b.l.f.e0()) {
                c.p.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.g();
                    return;
                } else {
                    this.f35333f.c();
                    return;
                }
            }
            this.f35333f.c();
        }
    }

    @Override // c.p.a.e.b.g.k
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f35332e.d(i2);
            if (c.p.a.e.b.l.f.e0()) {
                c.p.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.o(i2);
                    return;
                } else {
                    this.f35333f.d(i2);
                    return;
                }
            }
            this.f35333f.d(i2);
        }
    }

    @Override // c.p.a.e.b.g.k
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            if (c.p.a.e.b.l.f.e0()) {
                c.p.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(bVar);
                    return;
                } else {
                    this.f35333f.a(bVar);
                    return;
                }
            }
            this.f35333f.a(bVar);
        }
    }

    @Override // c.p.a.e.b.g.k
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.f35332e.m(i2);
            this.f35333f.m(i2);
        }
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            DownloadInfo h2 = this.f35332e.h(i2);
            j(h2);
            return h2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo b(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo b2 = this.f35332e.b(i2, j2);
            b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
            return b2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo d(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo d2 = this.f35332e.d(i2, j2);
            b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
            return d2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo c(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo c2 = this.f35332e.c(i2, j2);
            b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
            return c2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f35332e.a(downloadInfo);
    }

    @Override // c.p.a.e.b.g.k
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            try {
                if (c.p.a.e.b.l.f.e0()) {
                    c.p.a.e.b.g.n a2 = l.a(true);
                    if (a2 != null) {
                        a2.n(i2);
                    } else {
                        this.f35333f.e(i2);
                    }
                } else {
                    this.f35333f.e(i2);
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            return this.f35332e.e(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public void a(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            this.f35332e.a(i2, i3, j2);
            if (c.p.a.e.b.l.f.e0()) {
                c.p.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(i2, i3, j2);
                    return;
                } else {
                    this.f35333f.a(i2, i3, j2);
                    return;
                }
            }
            this.f35333f.a(i2, i3, j2);
        }
    }

    @Override // c.p.a.e.b.g.k
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, list) == null) {
            try {
                a(this.f35332e.b(i2));
                if (list == null) {
                    list = this.f35332e.c(i2);
                }
                if (c.p.a.e.b.l.f.e0()) {
                    c.p.a.e.b.g.n a2 = l.a(true);
                    if (a2 != null) {
                        a2.b(i2, list);
                        return;
                    } else {
                        this.f35333f.b(i2, list);
                        return;
                    }
                }
                this.f35333f.b(i2, list);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public void a(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            if (c.p.a.e.b.l.f.e0()) {
                c.p.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(i2, i3, i4, j2);
                    return;
                } else {
                    this.f35333f.a(i2, i3, i4, j2);
                    return;
                }
            }
            this.f35333f.a(i2, i3, i4, j2);
        }
    }

    @Override // c.p.a.e.b.g.k
    public Map<Long, c.p.a.e.b.i.i> l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            Map<Long, c.p.a.e.b.i.i> l = this.f35332e.l(i2);
            if (l == null || l.isEmpty()) {
                Map<Long, c.p.a.e.b.i.i> l2 = this.f35333f.l(i2);
                this.f35332e.a(i2, l2);
                return l2;
            }
            return l;
        }
        return (Map) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            if (c.p.a.e.b.l.f.e0()) {
                c.p.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(i2, i3, i4, i5);
                    return;
                } else {
                    this.f35333f.a(i2, i3, i4, i5);
                    return;
                }
            }
            this.f35333f.a(i2, i3, i4, i5);
        }
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            DownloadInfo a2 = this.f35332e.a(i2, i3);
            j(a2);
            return a2;
        }
        return (DownloadInfo) invokeII.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return false;
            }
            boolean a2 = this.f35332e.a(downloadInfo);
            j(downloadInfo);
            return a2;
        }
        return invokeL.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2})) == null) {
            DownloadInfo a2 = this.f35332e.a(i2, j2, str, str2);
            j(a2);
            return a2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo a(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo a2 = this.f35332e.a(i2, j2);
            h(a2, false);
            return a2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public List<c.p.a.e.b.i.i> n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            List<c.p.a.e.b.i.i> n = this.f35332e.n(i2);
            return (n == null || n.size() == 0) ? this.f35333f.n(i2) : n;
        }
        return (List) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i2, list) == null) || list == null || list.size() == 0) {
            return;
        }
        this.f35332e.a(i2, list);
        if (c.p.a.e.b.l.f.p0()) {
            this.f35333f.b(i2, list);
        }
    }

    @Override // c.p.a.e.b.g.k
    public boolean a(int i2, Map<Long, c.p.a.e.b.i.i> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, map)) == null) {
            this.f35332e.a(i2, map);
            this.f35333f.a(i2, map);
            return false;
        }
        return invokeIL.booleanValue;
    }
}
