package b.a.p0.a.n0.k;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h;
import b.a.p0.a.h0.m.c;
import b.a.p0.a.h0.m.j;
import b.a.p0.a.k;
import b.a.p0.a.n0.k.d;
import b.a.p0.a.v2.j0;
import b.a.p0.a.v2.q0;
import b.a.p0.n.h.i;
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
import h.d;
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
public final class f extends j implements b.a.p0.n.k.a.a, b.a.p0.n.j.k.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static int r;
    public static final PMSDownloadType s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f6865g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super i> f6866h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<i> f6867i;
    public b.a.p0.n.o.f j;
    public final b.a.p0.n.i.m.g k;
    public b.a.p0.n.f.c<i> l;
    public final Map<String, b.a.p0.a.n0.k.e> m;
    public final Map<String, b.a.p0.n.l.a> n;
    public final b.a.p0.a.n0.k.d o;
    public final b.a.p0.n.j.c<JSONArray> p;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.n.j.c<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f6868a;

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
            this.f6868a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.j.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.f6868a.m.isEmpty()) {
                return;
            }
            for (b.a.p0.a.n0.k.e eVar : this.f6868a.m.values()) {
                if (eVar != null && eVar.r(this.f6868a)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<b.a.p0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6869e;

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
            this.f6869e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                if (f.q) {
                    String unused = this.f6869e.f6865g;
                    String str = "onCallback: SoUpdating=" + eVar;
                }
                if (eVar != null) {
                    this.f6869e.o.c(eVar.k(), eVar.o());
                }
                this.f6869e.Y(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.v2.e1.b<b.a.p0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6870e;

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
            this.f6870e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            this.f6870e.o.d(eVar.k(), eVar.m());
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0223c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f6871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f6872b;

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
            this.f6872b = fVar;
            this.f6871a = iVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f6872b.j.k(this.f6871a);
                if (this.f6872b.f6866h != null) {
                    this.f6872b.f6866h.onNext(this.f6871a);
                    this.f6872b.f6866h.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6872b.j.j(this.f6871a);
                if (this.f6872b.f6866h != null) {
                    this.f6872b.f6866h.onError(new PkgDownloadError(this.f6871a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6873e;

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
            this.f6873e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super i> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6873e.f6866h = jVar;
            }
        }
    }

    /* renamed from: b.a.p0.a.n0.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0309f extends h.j<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f6874i;

        public C0309f(f fVar) {
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
            this.f6874i = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: g */
        public void onNext(i iVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) && f.q) {
                String unused = this.f6874i.f6865g;
                String str = "PkgDlSubscriber 单个包下载、业务层处理完成：" + iVar.toString();
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (f.q) {
                    String unused = this.f6874i.f6865g;
                }
                this.f6874i.d0(null);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (f.q) {
                    String unused = this.f6874i.f6865g;
                    String str = "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString();
                }
                this.f6874i.d0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ C0309f(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes.dex */
    public class g extends b.a.p0.n.f.b<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6875e;

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
            this.f6875e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.c
        /* renamed from: l */
        public String d(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iVar)) == null) {
                String g2 = b.a.p0.a.n0.k.c.f6843d.g(iVar);
                if (f.q) {
                    String unused = this.f6875e.f6865g;
                    String str = "SoDlCallback getDownloadPath: so=" + iVar.f11076g + " path=" + g2;
                }
                return g2;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f6875e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: o */
        public void e(i iVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar, aVar) == null) {
                super.e(iVar, aVar);
                if (f.q) {
                    String unused = this.f6875e.f6865g;
                    String str = "SoDlCallback onDownloadError: so=" + iVar.f11076g + " err=" + aVar;
                }
                this.f6875e.j.j(iVar);
                b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f11066a);
                aVar2.c("so包下载失败");
                aVar2.e(aVar.toString());
                if (this.f6875e.f6866h != null) {
                    this.f6875e.f6866h.onError(new PkgDownloadError(iVar, aVar2));
                }
                b.a.p0.a.h0.m.c.c().a(iVar, f.s, aVar2);
                b.a.p0.t.d.j(iVar.f11070a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: p */
        public void i(i iVar) {
            b.a.p0.n.l.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
                super.i(iVar);
                if (f.q) {
                    String unused = this.f6875e.f6865g;
                    String str = "SoDlCallback onDownloadFinish: so=" + iVar;
                }
                String str2 = iVar.p;
                if (TextUtils.isEmpty(str2) && (aVar = (b.a.p0.n.l.a) this.f6875e.n.get(iVar.f11076g)) != null) {
                    str2 = aVar.f11246a;
                }
                b.a.p0.a.n0.k.e Z = this.f6875e.Z(str2);
                if (Z != null) {
                    boolean a2 = j0.a(new File(iVar.f11070a), iVar.m);
                    if (f.q) {
                        String unused2 = this.f6875e.f6865g;
                        String str3 = "SoDlCallback onDownloadFinish: bundle=" + iVar.f11076g + " checkSign=" + a2;
                    }
                    boolean z = true;
                    z = (f.q && !q0.G() && b.a.p0.a.u1.a.a.j() == 1) ? false : false;
                    if (a2 || z) {
                        b.a.p0.n.g.a.h().l(iVar);
                        if (f.q) {
                            String unused3 = this.f6875e.f6865g;
                            String str4 = "SoDlCallback onDownloadFinish: updating=" + Z + " libName=" + str2;
                        }
                    }
                    Z.q();
                }
                this.f6875e.j.k(iVar);
                if (this.f6875e.f6866h != null) {
                    this.f6875e.f6866h.onNext(iVar);
                    this.f6875e.f6866h.onCompleted();
                }
                b.a.p0.a.h0.m.c.c().b(iVar, f.s);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
                super.a(iVar);
                b.a.p0.n.l.a aVar = (b.a.p0.n.l.a) this.f6875e.n.get(iVar.f11076g);
                b.a.p0.a.n0.k.e Z = this.f6875e.Z(aVar == null ? null : aVar.f11246a);
                if (Z != null) {
                    Z.x(new d.b(iVar.f11071b, iVar.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: r */
        public void c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, iVar) == null) {
                super.c(iVar);
                if (f.q) {
                    String unused = this.f6875e.f6865g;
                    String str = "SoDlCallback onDownloadStart: so=" + iVar.f11076g;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: s */
        public void f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
                super.f(iVar);
                if (f.q) {
                    String unused = this.f6875e.f6865g;
                    String str = "SoDlCallback onDownloading: so=" + iVar.f11076g;
                }
                this.f6875e.e0(iVar);
            }
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667390352, "Lb/a/p0/a/n0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1667390352, "Lb/a/p0/a/n0/k/f;");
                return;
            }
        }
        q = k.f6397a;
        r = 0;
        s = PMSDownloadType.SO_LIB;
    }

    public f(b.a.p0.n.i.m.g gVar, b.a.p0.a.n0.k.d dVar) {
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
        this.f6865g = "SwanSoUpdater";
        this.m = new HashMap();
        this.n = new HashMap();
        this.p = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6865g);
        int i4 = r;
        r = i4 + 1;
        sb.append(i4);
        this.f6865g = sb.toString();
        if (q) {
            String str = "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception());
        }
        this.k = gVar;
        this.o = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                b.a.p0.a.n0.k.a a2 = b.a.p0.a.n0.k.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    b.a.p0.a.n0.k.e t = b.a.p0.a.n0.k.c.f6843d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.m.put(e2, t);
                    this.n.putAll(b.a.p0.n.l.a.b(e2));
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

    @Override // b.a.p0.n.f.g
    public void B(b.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (q) {
                String str = "onFetchError: " + aVar.toString();
            }
            d0(new Exception("failed by fetch error = " + aVar));
        }
    }

    @Override // b.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            boolean z = q;
        }
    }

    @Override // b.a.p0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            boolean z = q;
            d0(null);
        }
    }

    @Override // b.a.p0.n.f.g
    public void F(b.a.p0.n.o.f fVar) {
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
            this.j = fVar;
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
            for (b.a.p0.a.n0.k.e eVar : this.m.values()) {
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

    public final b.a.p0.a.n0.k.e Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            b.a.p0.a.n0.k.e eVar = this.m.get(str);
            if (eVar == null || !eVar.r(this)) {
                return null;
            }
            return eVar;
        }
        return (b.a.p0.a.n0.k.e) invokeL.objValue;
    }

    public final h.j<i> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f6867i == null) {
                this.f6867i = new C0309f(this, null);
            }
            return this.f6867i;
        }
        return (h.j) invokeV.objValue;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.j.e()) {
                arrayList.add(h.d.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.d.i(arrayList).u(a0());
        }
    }

    public final void c0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (q) {
                String str = "notifyFinalCallback: e=" + Log.getStackTraceString(exc);
            }
            b.a.p0.a.n0.k.d dVar = this.o;
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
            for (b.a.p0.a.n0.k.e eVar : this.m.values()) {
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
            b.a.p0.a.h0.m.c.c().d(iVar, new d(this, iVar));
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
            b.a.p0.n.l.a aVar = this.n.get(iVar.f11076g);
            if (aVar == null) {
                if (q) {
                    String str2 = "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.f11076g;
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(iVar.p)) {
                iVar.p = aVar.f11246a;
            }
            b.a.p0.a.n0.k.e Z = Z(iVar.p);
            if (Z == null) {
                if (q) {
                    String str3 = "SoNodeHandler updateBestSo end by no updating lib=" + iVar.p;
                    return;
                }
                return;
            }
            if (iVar.q == null) {
                iVar.q = aVar.f11248c;
            }
            if (!AbiType.currentAbi().compat(iVar.q)) {
                boolean z2 = q;
                return;
            }
            i l = Z.l();
            i j = Z.j();
            long max = Math.max(j != null ? j.f11078i : 0L, l == null ? 0L : l.f11078i);
            long j2 = iVar.f11078i;
            if (j2 < max) {
                if (q) {
                    String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.f11078i));
                }
            } else if (j2 > max) {
                if (q) {
                    String str4 = "SoNodeHandler updateBestSo end by update bestVer=" + iVar.f11078i;
                }
                Z.w(this, iVar);
            } else {
                if (j == null || !j.q.compat(iVar.q)) {
                    if (q) {
                        String str5 = "SoNodeHandler updateBestSo end by update abi update=" + iVar.q;
                    }
                    Z.w(this, iVar);
                }
                boolean z3 = q;
            }
        }
    }

    @Override // b.a.p0.n.k.a.a
    public b.a.p0.n.j.c<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : (b.a.p0.n.j.c) invokeV.objValue;
    }

    @Override // b.a.p0.n.k.a.a
    @Nullable
    public b.a.p0.n.i.m.g getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (b.a.p0.n.i.m.g) invokeV.objValue;
    }

    @Override // b.a.p0.n.j.k.c
    public void handle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b.a.p0.n.j.k.a aVar = new b.a.p0.n.j.k.a();
            b.a.p0.n.o.f fVar = new b.a.p0.n.o.f();
            boolean z = q;
            boolean z2 = true;
            if ((q && !q0.G() && b.a.p0.a.u1.a.a.j() == 1) ? false : false) {
                String i2 = b.a.p0.a.u1.a.a.i();
                if (!TextUtils.isEmpty(i2)) {
                    try {
                        i iVar = (i) b.a.p0.n.o.e.i(new JSONObject(i2), new i());
                        iVar.f11076g = "so_zeus_armeabi";
                        f0(iVar);
                        b.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_success)).F();
                    } catch (JSONException e2) {
                        b.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_error)).F();
                        e2.printStackTrace();
                    }
                }
            }
            for (b.a.p0.a.n0.k.e eVar : this.m.values()) {
                if (eVar.r(this)) {
                    f0(eVar.l());
                    i j = eVar.j();
                    if (eVar.p() && j != null) {
                        if (q) {
                            String str = "SoNodeHandler handle for bestSo=" + j;
                        }
                        b.a.p0.n.j.k.b.b(j, fVar);
                        if (aVar.f11239d == null) {
                            aVar.f11239d = new ArrayList();
                        }
                        aVar.f11239d.add(j);
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
            b.a.p0.n.i.i.a.e(aVar, this);
        }
    }

    @Override // b.a.p0.n.j.k.c
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (q) {
                String str = "SoNodeHandler parseData start data=" + jSONObject;
            }
            if (jSONObject != null) {
                f0((i) b.a.p0.n.o.e.i(jSONObject, new i()));
            }
        }
    }

    @Override // b.a.p0.n.k.a.a
    public b.a.p0.n.f.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (b.a.p0.n.f.g) invokeV.objValue;
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.j.k.c v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.v(str) : (b.a.p0.n.j.k.c) invokeL.objValue;
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.c<i> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.l == null) {
                this.l = new g(this, null);
            }
            return this.l;
        }
        return (b.a.p0.n.f.c) invokeV.objValue;
    }
}
