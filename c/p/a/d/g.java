package c.p.a.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a.a.c.n;
import c.p.a.a.a.c.v;
import c.p.a.d.b.c;
import c.p.a.d.c;
import c.p.a.e.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile g f34709f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f34710a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.p.a.d.b.h> f34711b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, c.p.a.d.b.h> f34712c;

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f34713d;

    /* renamed from: e  reason: collision with root package name */
    public long f34714e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.d f34715e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.b f34716f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.c f34717g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f34718h;

        public a(g gVar, c.p.a.a.a.d.d dVar, c.p.a.a.a.d.b bVar, c.p.a.a.a.d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, dVar, bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34718h = gVar;
            this.f34715e = dVar;
            this.f34716f = bVar;
            this.f34717g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f34718h.f34713d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof c.p.a.a.a.d.a.a) {
                        ((c.p.a.a.a.d.a.a) next).a(this.f34715e, this.f34716f, this.f34717g);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof c.p.a.a.a.d.a.a) {
                            ((c.p.a.a.a.d.a.a) softReference.get()).a(this.f34715e, this.f34716f, this.f34717g);
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
        public final /* synthetic */ DownloadInfo f34719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseException f34720f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f34721g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f34722h;

        public b(g gVar, DownloadInfo downloadInfo, BaseException baseException, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, downloadInfo, baseException, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34722h = gVar;
            this.f34719e = downloadInfo;
            this.f34720f = baseException;
            this.f34721g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f34722h.f34713d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof c.p.a.a.a.d.a.a) {
                        ((c.p.a.a.a.d.a.a) next).a(this.f34719e, this.f34720f, this.f34721g);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof c.p.a.a.a.d.a.a) {
                            ((c.p.a.a.a.d.a.a) softReference.get()).a(this.f34719e, this.f34720f, this.f34721g);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f34723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f34724f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f34725g;

        public c(g gVar, DownloadInfo downloadInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, downloadInfo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34725g = gVar;
            this.f34723e = downloadInfo;
            this.f34724f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f34725g.f34713d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof c.p.a.a.a.d.a.a) {
                        ((c.p.a.a.a.d.a.a) next).a(this.f34723e, this.f34724f);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof c.p.a.a.a.d.a.a) {
                            ((c.p.a.a.a.d.a.a) softReference.get()).a(this.f34723e, this.f34724f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f34726e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f34727f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f34728g;

        public d(g gVar, DownloadInfo downloadInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, downloadInfo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34728g = gVar;
            this.f34726e = downloadInfo;
            this.f34727f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f34728g.f34713d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof c.p.a.a.a.d.a.a) {
                        ((c.p.a.a.a.d.a.a) next).b(this.f34726e, this.f34727f);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof c.p.a.a.a.d.a.a) {
                            ((c.p.a.a.a.d.a.a) softReference.get()).b(this.f34726e, this.f34727f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f34729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f34730f;

        public e(g gVar, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34730f = gVar;
            this.f34729e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f34730f.f34713d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof c.p.a.a.a.d.a.a) {
                        ((c.p.a.a.a.d.a.a) next).a(this.f34729e);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof c.p.a.a.a.d.a.a) {
                            ((c.p.a.a.a.d.a.a) softReference.get()).a(this.f34729e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements c.p.a.d.i.a.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.k f34731a;

            public a(f fVar, d.k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34731a = kVar;
            }

            @Override // c.p.a.d.i.a.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f34731a.a();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements c.p.a.d.i.a.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f34732a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.p.a.d.i.a.a f34733b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ f f34734c;

            public b(f fVar, DownloadInfo downloadInfo, c.p.a.d.i.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, downloadInfo, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34734c = fVar;
                this.f34732a = downloadInfo;
                this.f34733b = aVar;
            }

            @Override // c.p.a.d.i.a.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f34734c.d(this.f34732a, this.f34733b);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements c.p.a.d.i.a.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.p.a.d.i.a.a f34735a;

            public c(f fVar, c.p.a.d.i.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34735a = aVar;
            }

            @Override // c.p.a.d.i.a.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f34735a.a();
                }
            }
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.p.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, downloadInfo, kVar) == null) {
                c(downloadInfo, new a(this, kVar));
            }
        }

        public void c(DownloadInfo downloadInfo, @NonNull c.p.a.d.i.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, aVar) == null) {
                c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                if (c2 != null && c.l.a(c2)) {
                    TTDelegateActivity.a(c2, new b(this, downloadInfo, aVar));
                } else {
                    d(downloadInfo, aVar);
                }
            }
        }

        public final void d(DownloadInfo downloadInfo, @NonNull c.p.a.d.i.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, aVar) == null) {
                c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                boolean c3 = c.i.c(c2);
                boolean e2 = c.i.e(c2);
                if (c3 && e2) {
                    c.f.a(c2, new c(this, aVar));
                } else {
                    aVar.a();
                }
            }
        }
    }

    /* renamed from: c.p.a.d.g$g  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1539g implements d.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1539g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.p.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            c.p.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, downloadInfo, kVar) == null) {
                if (downloadInfo != null && (c2 = c.g.e().c(downloadInfo)) != null) {
                    downloadInfo.setLinkMode(c2.L());
                }
                if (kVar != null) {
                    kVar.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static volatile h f34736b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d.l> f34737a;

        /* loaded from: classes4.dex */
        public class a implements d.k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f34738a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f34739b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d.k f34740c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ h f34741d;

            public a(h hVar, int i2, DownloadInfo downloadInfo, d.k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Integer.valueOf(i2), downloadInfo, kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34741d = hVar;
                this.f34738a = i2;
                this.f34739b = downloadInfo;
                this.f34740c = kVar;
            }

            @Override // c.p.a.e.a.d.k
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f34741d.d(this.f34739b, this.f34738a + 1, this.f34740c);
                }
            }
        }

        public h() {
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
            ArrayList arrayList = new ArrayList();
            this.f34737a = arrayList;
            arrayList.add(new C1539g());
            this.f34737a.add(new f());
        }

        public static h b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f34736b == null) {
                    synchronized (h.class) {
                        if (f34736b == null) {
                            f34736b = new h();
                        }
                    }
                }
                return f34736b;
            }
            return (h) invokeV.objValue;
        }

        @Override // c.p.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, downloadInfo, kVar) == null) {
                if (downloadInfo != null && this.f34737a.size() != 0) {
                    d(downloadInfo, 0, kVar);
                } else if (kVar != null) {
                    kVar.a();
                }
            }
        }

        public final void d(DownloadInfo downloadInfo, int i2, d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, i2, kVar) == null) {
                if (i2 != this.f34737a.size() && i2 >= 0) {
                    this.f34737a.get(i2).a(downloadInfo, new a(this, i2, downloadInfo, kVar));
                } else {
                    kVar.a();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1242608860, "Lc/p/a/d/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1242608860, "Lc/p/a/d/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34711b = new CopyOnWriteArrayList();
        this.f34712c = new ConcurrentHashMap();
        this.f34713d = new CopyOnWriteArrayList<>();
        this.f34710a = new Handler(Looper.getMainLooper());
    }

    public static g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f34709f == null) {
                synchronized (g.class) {
                    if (f34709f == null) {
                        f34709f = new g();
                    }
                }
            }
            return f34709f;
        }
        return (g) invokeV.objValue;
    }

    public c.p.a.d.b.g a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map<String, c.p.a.d.b.h> map = this.f34712c;
            if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
                c.p.a.d.b.h hVar = this.f34712c.get(str);
                if (hVar instanceof c.p.a.d.b.g) {
                    return (c.p.a.d.b.g) hVar;
                }
            }
            return null;
        }
        return (c.p.a.d.b.g) invokeL.objValue;
    }

    public void d(Context context, int i2, c.p.a.a.a.d.e eVar, c.p.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, eVar, dVar) == null) || dVar == null || TextUtils.isEmpty(dVar.a())) {
            return;
        }
        c.p.a.d.b.h hVar = this.f34712c.get(dVar.a());
        if (hVar != null) {
            hVar.b(context).f(i2, eVar).c(dVar).a();
        } else if (!this.f34711b.isEmpty()) {
            o(context, i2, eVar, dVar);
        } else {
            r(context, i2, eVar, dVar);
        }
    }

    public void e(c.p.a.a.a.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        if (c.p.a.e.b.j.a.r().q("fix_listener_oom", false)) {
            this.f34713d.add(new SoftReference(aVar));
        } else {
            this.f34713d.add(aVar);
        }
    }

    public void f(c.p.a.a.a.d.d dVar, @Nullable c.p.a.a.a.d.b bVar, @Nullable c.p.a.a.a.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, dVar, bVar, cVar) == null) {
            this.f34710a.post(new a(this, dVar, bVar, cVar));
        }
    }

    public void g(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
            this.f34710a.post(new e(this, downloadInfo));
        }
    }

    public void h(DownloadInfo downloadInfo, BaseException baseException, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, downloadInfo, baseException, str) == null) {
            this.f34710a.post(new b(this, downloadInfo, baseException, str));
        }
    }

    public void i(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, downloadInfo, str) == null) {
            this.f34710a.post(new c(this, downloadInfo, str));
        }
    }

    public void j(String str, int i2) {
        c.p.a.d.b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || TextUtils.isEmpty(str) || (hVar = this.f34712c.get(str)) == null) {
            return;
        }
        if (hVar.a(i2)) {
            this.f34711b.add(hVar);
            this.f34712c.remove(str);
        }
        q();
    }

    public void k(String str, long j2, int i2, c.p.a.a.a.d.c cVar, c.p.a.a.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), cVar, bVar}) == null) {
            l(str, j2, i2, cVar, bVar, null, null);
        }
    }

    public void l(String str, long j2, int i2, c.p.a.a.a.d.c cVar, c.p.a.a.a.d.b bVar, v vVar, n nVar) {
        c.p.a.d.b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), cVar, bVar, vVar, nVar}) == null) || TextUtils.isEmpty(str) || (hVar = this.f34712c.get(str)) == null) {
            return;
        }
        hVar.a(j2).b(cVar).a(bVar).d(vVar).e(nVar).b(i2);
    }

    public void m(String str, boolean z) {
        c.p.a.d.b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) || TextUtils.isEmpty(str) || (hVar = this.f34712c.get(str)) == null) {
            return;
        }
        hVar.a(z);
    }

    public Handler n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34710a : (Handler) invokeV.objValue;
    }

    public final synchronized void o(Context context, int i2, c.p.a.a.a.d.e eVar, c.p.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048588, this, context, i2, eVar, dVar) == null) {
            synchronized (this) {
                if (this.f34711b.size() <= 0) {
                    r(context, i2, eVar, dVar);
                } else {
                    c.p.a.d.b.h remove = this.f34711b.remove(0);
                    remove.b(context).f(i2, eVar).c(dVar).a();
                    this.f34712c.put(dVar.a(), remove);
                }
            }
        }
    }

    public void p(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, downloadInfo, str) == null) {
            this.f34710a.post(new d(this, downloadInfo, str));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f34714e < 300000) {
                return;
            }
            this.f34714e = currentTimeMillis;
            if (this.f34711b.isEmpty()) {
                return;
            }
            s();
        }
    }

    public final void r(Context context, int i2, c.p.a.a.a.d.e eVar, c.p.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048591, this, context, i2, eVar, dVar) == null) || dVar == null) {
            return;
        }
        c.p.a.d.b.g gVar = new c.p.a.d.b.g();
        gVar.b(context);
        gVar.f(i2, eVar);
        gVar.c(dVar);
        gVar.a();
        this.f34712c.put(dVar.a(), gVar);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (c.p.a.d.b.h hVar : this.f34711b) {
                if (!hVar.b() && currentTimeMillis - hVar.d() > 300000) {
                    hVar.h();
                    arrayList.add(hVar);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f34711b.removeAll(arrayList);
        }
    }
}
