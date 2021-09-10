package c.a.p0.a.n0.k;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h;
import c.a.p0.a.h0.m.c;
import c.a.p0.a.h0.m.j;
import c.a.p0.a.k;
import c.a.p0.a.n0.k.d;
import c.a.p0.a.v2.j0;
import c.a.p0.a.v2.q0;
import c.a.p0.n.h.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f extends j implements c.a.p0.n.k.a.a, c.a.p0.n.j.k.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static int r;
    public static final PMSDownloadType s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f7553g;

    /* renamed from: h  reason: collision with root package name */
    public i.j<? super i> f7554h;

    /* renamed from: i  reason: collision with root package name */
    public i.j<i> f7555i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.n.o.f f7556j;
    public final c.a.p0.n.i.m.g k;
    public c.a.p0.n.f.c<i> l;
    public final Map<String, c.a.p0.a.n0.k.e> m;
    public final Map<String, c.a.p0.n.l.a> n;
    public final c.a.p0.a.n0.k.d o;
    public final c.a.p0.n.j.c<JSONArray> p;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.n.j.c<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f7557a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7557a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.j.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.f7557a.m.isEmpty()) {
                return;
            }
            for (c.a.p0.a.n0.k.e eVar : this.f7557a.m.values()) {
                if (eVar != null && eVar.r(this.f7557a)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<c.a.p0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7558e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7558e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                if (f.q) {
                    String unused = this.f7558e.f7553g;
                    String str = "onCallback: SoUpdating=" + eVar;
                }
                if (eVar != null) {
                    this.f7558e.o.c(eVar.k(), eVar.o());
                }
                this.f7558e.Y(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.v2.e1.b<c.a.p0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7559e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7559e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            this.f7559e.o.d(eVar.k(), eVar.m());
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0228c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f7560a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f7561b;

        public d(f fVar, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7561b = fVar;
            this.f7560a = iVar;
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f7561b.f7556j.k(this.f7560a);
                if (this.f7561b.f7554h != null) {
                    this.f7561b.f7554h.onNext(this.f7560a);
                    this.f7561b.f7554h.onCompleted();
                }
            }
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f7561b.f7556j.j(this.f7560a);
                if (this.f7561b.f7554h != null) {
                    this.f7561b.f7554h.onError(new PkgDownloadError(this.f7560a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7562e;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7562e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i.j<? super i> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f7562e.f7554h = jVar;
            }
        }
    }

    /* renamed from: c.a.p0.a.n0.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0314f extends i.j<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7563e;

        public C0314f(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7563e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.e
        /* renamed from: b */
        public void onNext(i iVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) && f.q) {
                String unused = this.f7563e.f7553g;
                String str = "PkgDlSubscriber 单个包下载、业务层处理完成：" + iVar.toString();
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (f.q) {
                    String unused = this.f7563e.f7553g;
                }
                this.f7563e.d0(null);
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (f.q) {
                    String unused = this.f7563e.f7553g;
                    String str = "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString();
                }
                this.f7563e.d0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ C0314f(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes.dex */
    public class g extends c.a.p0.n.f.b<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7564e;

        public g(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7564e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.c
        /* renamed from: l */
        public String d(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iVar)) == null) {
                String g2 = c.a.p0.a.n0.k.c.f7530d.g(iVar);
                if (f.q) {
                    String unused = this.f7564e.f7553g;
                    String str = "SoDlCallback getDownloadPath: so=" + iVar.f11885g + " path=" + g2;
                }
                return g2;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f7564e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: o */
        public void e(i iVar, c.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar, aVar) == null) {
                super.e(iVar, aVar);
                if (f.q) {
                    String unused = this.f7564e.f7553g;
                    String str = "SoDlCallback onDownloadError: so=" + iVar.f11885g + " err=" + aVar;
                }
                this.f7564e.f7556j.j(iVar);
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f11875a);
                aVar2.c("so包下载失败");
                aVar2.e(aVar.toString());
                if (this.f7564e.f7554h != null) {
                    this.f7564e.f7554h.onError(new PkgDownloadError(iVar, aVar2));
                }
                c.a.p0.a.h0.m.c.c().a(iVar, f.s, aVar2);
                c.a.p0.t.d.j(iVar.f11879a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: p */
        public void i(i iVar) {
            c.a.p0.n.l.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
                super.i(iVar);
                if (f.q) {
                    String unused = this.f7564e.f7553g;
                    String str = "SoDlCallback onDownloadFinish: so=" + iVar;
                }
                String str2 = iVar.p;
                if (TextUtils.isEmpty(str2) && (aVar = (c.a.p0.n.l.a) this.f7564e.n.get(iVar.f11885g)) != null) {
                    str2 = aVar.f12058a;
                }
                c.a.p0.a.n0.k.e Z = this.f7564e.Z(str2);
                if (Z != null) {
                    boolean a2 = j0.a(new File(iVar.f11879a), iVar.m);
                    if (f.q) {
                        String unused2 = this.f7564e.f7553g;
                        String str3 = "SoDlCallback onDownloadFinish: bundle=" + iVar.f11885g + " checkSign=" + a2;
                    }
                    boolean z = true;
                    z = (f.q && !q0.G() && c.a.p0.a.u1.a.a.j() == 1) ? false : false;
                    if (a2 || z) {
                        c.a.p0.n.g.a.h().l(iVar);
                        if (f.q) {
                            String unused3 = this.f7564e.f7553g;
                            String str4 = "SoDlCallback onDownloadFinish: updating=" + Z + " libName=" + str2;
                        }
                    }
                    Z.q();
                }
                this.f7564e.f7556j.k(iVar);
                if (this.f7564e.f7554h != null) {
                    this.f7564e.f7554h.onNext(iVar);
                    this.f7564e.f7554h.onCompleted();
                }
                c.a.p0.a.h0.m.c.c().b(iVar, f.s);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: q */
        public void a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
                super.a(iVar);
                c.a.p0.n.l.a aVar = (c.a.p0.n.l.a) this.f7564e.n.get(iVar.f11885g);
                c.a.p0.a.n0.k.e Z = this.f7564e.Z(aVar == null ? null : aVar.f12058a);
                if (Z != null) {
                    Z.x(new d.b(iVar.f11880b, iVar.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: r */
        public void c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, iVar) == null) {
                super.c(iVar);
                if (f.q) {
                    String unused = this.f7564e.f7553g;
                    String str = "SoDlCallback onDownloadStart: so=" + iVar.f11885g;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: s */
        public void f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
                super.f(iVar);
                if (f.q) {
                    String unused = this.f7564e.f7553g;
                    String str = "SoDlCallback onDownloading: so=" + iVar.f11885g;
                }
                this.f7564e.e0(iVar);
            }
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2117042767, "Lc/a/p0/a/n0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2117042767, "Lc/a/p0/a/n0/k/f;");
                return;
            }
        }
        q = k.f7077a;
        r = 0;
        s = PMSDownloadType.SO_LIB;
    }

    public f(c.a.p0.n.i.m.g gVar, c.a.p0.a.n0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7553g = "SwanSoUpdater";
        this.m = new HashMap();
        this.n = new HashMap();
        this.p = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7553g);
        int i4 = r;
        r = i4 + 1;
        sb.append(i4);
        this.f7553g = sb.toString();
        if (q) {
            String str = "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception());
        }
        this.k = gVar;
        this.o = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                c.a.p0.a.n0.k.a a2 = c.a.p0.a.n0.k.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    c.a.p0.a.n0.k.e t = c.a.p0.a.n0.k.c.f7530d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.m.put(e2, t);
                    this.n.putAll(c.a.p0.n.l.a.b(e2));
                }
            }
        }
        if (q) {
            String str2 = "SoNodeHandler() start mUpdatings=" + this.m.size();
        }
        if (this.m.isEmpty()) {
            d0(null);
        }
    }

    @Override // c.a.p0.n.f.g
    public void B(c.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (q) {
                String str = "onFetchError: " + aVar.toString();
            }
            d0(new Exception("failed by fetch error = " + aVar));
        }
    }

    @Override // c.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            boolean z = q;
        }
    }

    @Override // c.a.p0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            boolean z = q;
            d0(null);
        }
    }

    @Override // c.a.p0.n.f.g
    public void F(c.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            if (q) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(fVar == null ? 0 : fVar.l());
                sb.toString();
            }
            super.F(fVar);
            if (fVar == null) {
                return;
            }
            this.f7556j = fVar;
            if (fVar.i()) {
                return;
            }
            b0();
        }
    }

    public final void Y(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (q) {
                String str = "finishWithUpdatingCheck: updatings=" + this.m.size() + " e=" + exc;
            }
            for (c.a.p0.a.n0.k.e eVar : this.m.values()) {
                if (!eVar.n()) {
                    if (q) {
                        String str2 = "finishWithUpdatingCheck: return by wait for=" + eVar;
                        return;
                    }
                    return;
                }
            }
            c0(exc);
        }
    }

    public final c.a.p0.a.n0.k.e Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            c.a.p0.a.n0.k.e eVar = this.m.get(str);
            if (eVar == null || !eVar.r(this)) {
                return null;
            }
            return eVar;
        }
        return (c.a.p0.a.n0.k.e) invokeL.objValue;
    }

    public final i.j<i> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f7555i == null) {
                this.f7555i = new C0314f(this, null);
            }
            return this.f7555i;
        }
        return (i.j) invokeV.objValue;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f7556j.e()) {
                arrayList.add(i.d.b(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            i.d.l(arrayList).z(a0());
        }
    }

    public final void c0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (q) {
                String str = "notifyFinalCallback: e=" + Log.getStackTraceString(exc);
            }
            c.a.p0.a.n0.k.d dVar = this.o;
            if (dVar != null) {
                dVar.b(exc);
            }
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (q) {
                String str = "notifyPmsFinish: updatings=" + this.m.size() + " e=" + exc;
            }
            for (c.a.p0.a.n0.k.e eVar : this.m.values()) {
                if (eVar != null && eVar.r(this) && !eVar.n() && !eVar.s()) {
                    if (q) {
                        String str2 = "notifyPmsFinish: try install updating=" + eVar;
                    }
                    eVar.q();
                }
            }
            Y(exc);
        }
    }

    public final void e0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
            c.a.p0.a.h0.m.c.c().d(iVar, new d(this, iVar));
        }
    }

    public final void f0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iVar) == null) {
            if (q) {
                String str = "SoNodeHandler updateBestSo start so=" + iVar;
            }
            if (iVar == null) {
                boolean z = q;
                return;
            }
            c.a.p0.n.l.a aVar = this.n.get(iVar.f11885g);
            if (aVar == null) {
                if (q) {
                    String str2 = "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.f11885g;
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(iVar.p)) {
                iVar.p = aVar.f12058a;
            }
            c.a.p0.a.n0.k.e Z = Z(iVar.p);
            if (Z == null) {
                if (q) {
                    String str3 = "SoNodeHandler updateBestSo end by no updating lib=" + iVar.p;
                    return;
                }
                return;
            }
            if (iVar.q == null) {
                iVar.q = aVar.f12060c;
            }
            if (!AbiType.currentAbi().compat(iVar.q)) {
                boolean z2 = q;
                return;
            }
            i l = Z.l();
            i j2 = Z.j();
            long max = Math.max(j2 != null ? j2.f11887i : 0L, l == null ? 0L : l.f11887i);
            long j3 = iVar.f11887i;
            if (j3 < max) {
                if (q) {
                    String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.f11887i));
                }
            } else if (j3 > max) {
                if (q) {
                    String str4 = "SoNodeHandler updateBestSo end by update bestVer=" + iVar.f11887i;
                }
                Z.w(this, iVar);
            } else {
                if (j2 == null || !j2.q.compat(iVar.q)) {
                    if (q) {
                        String str5 = "SoNodeHandler updateBestSo end by update abi update=" + iVar.q;
                    }
                    Z.w(this, iVar);
                }
                boolean z3 = q;
            }
        }
    }

    @Override // c.a.p0.n.k.a.a
    public c.a.p0.n.j.c<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : (c.a.p0.n.j.c) invokeV.objValue;
    }

    @Override // c.a.p0.n.k.a.a
    @Nullable
    public c.a.p0.n.i.m.g getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (c.a.p0.n.i.m.g) invokeV.objValue;
    }

    @Override // c.a.p0.n.j.k.c
    public void handle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.p0.n.j.k.a aVar = new c.a.p0.n.j.k.a();
            c.a.p0.n.o.f fVar = new c.a.p0.n.o.f();
            boolean z = q;
            boolean z2 = true;
            if ((q && !q0.G() && c.a.p0.a.u1.a.a.j() == 1) ? false : false) {
                String i2 = c.a.p0.a.u1.a.a.i();
                if (!TextUtils.isEmpty(i2)) {
                    try {
                        i iVar = (i) c.a.p0.n.o.e.i(new JSONObject(i2), new i());
                        iVar.f11885g = "so_zeus_armeabi";
                        f0(iVar);
                        c.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_success)).F();
                    } catch (JSONException e2) {
                        c.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_error)).F();
                        e2.printStackTrace();
                    }
                }
            }
            for (c.a.p0.a.n0.k.e eVar : this.m.values()) {
                if (eVar.r(this)) {
                    f0(eVar.l());
                    i j2 = eVar.j();
                    if (eVar.p() && j2 != null) {
                        if (q) {
                            String str = "SoNodeHandler handle for bestSo=" + j2;
                        }
                        c.a.p0.n.j.k.b.b(j2, fVar);
                        if (aVar.f12051d == null) {
                            aVar.f12051d = new ArrayList();
                        }
                        aVar.f12051d.add(j2);
                    } else {
                        boolean z3 = q;
                        eVar.q();
                    }
                }
            }
            if (q) {
                String str2 = "SoNodeHandler handle soSet.pkgSize()=" + fVar.l();
            }
            if (fVar.l() == 0) {
                boolean z4 = q;
                E();
                return;
            }
            boolean z5 = q;
            F(fVar);
            c.a.p0.n.i.i.a.e(aVar, this);
        }
    }

    @Override // c.a.p0.n.j.k.c
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (q) {
                String str = "SoNodeHandler parseData start data=" + jSONObject;
            }
            if (jSONObject != null) {
                f0((i) c.a.p0.n.o.e.i(jSONObject, new i()));
            }
        }
    }

    @Override // c.a.p0.n.k.a.a
    public c.a.p0.n.f.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (c.a.p0.n.f.g) invokeV.objValue;
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.j.k.c v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.v(str) : (c.a.p0.n.j.k.c) invokeL.objValue;
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.f.c<i> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.l == null) {
                this.l = new g(this, null);
            }
            return this.l;
        }
        return (c.a.p0.n.f.c) invokeV.objValue;
    }
}
