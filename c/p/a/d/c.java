package c.p.a.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a.a.c.s;
import c.p.a.a.a.f.c;
import c.p.a.b.a.a.a;
import c.p.a.b.a.a.b;
import c.p.a.d.b.c;
import c.p.a.d.e;
import c.p.a.d.f;
import c.p.a.d.h;
import c.p.a.e.b.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements c.p.a.b.a.d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f34761b = "c";

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f34762c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.p.a.d.h f34763a;

    /* loaded from: classes4.dex */
    public class a implements f.d.b<Dialog> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34764a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f34765b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f34766c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.d f34767d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.c f34768e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.b f34769f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.e f34770g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f34771h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f34772i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f34773j;

        public a(c cVar, Context context, String str, boolean z, c.p.a.a.a.d.d dVar, c.p.a.a.a.d.c cVar2, c.p.a.a.a.d.b bVar, c.p.a.a.a.d.e eVar, int i2, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, str, Boolean.valueOf(z), dVar, cVar2, bVar, eVar, Integer.valueOf(i2), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34773j = cVar;
            this.f34764a = context;
            this.f34765b = str;
            this.f34766c = z;
            this.f34767d = dVar;
            this.f34768e = cVar2;
            this.f34769f = bVar;
            this.f34770g = eVar;
            this.f34771h = i2;
            this.f34772i = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.p.a.d.f.d.b
        /* renamed from: a */
        public Dialog b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34773j.k(this.f34764a, this.f34765b, this.f34766c, this.f34767d, this.f34768e, this.f34769f, this.f34770g, this.f34771h, this.f34772i) : (Dialog) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.InterfaceC1520c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.d f34774a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.c f34775b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.b f34776c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f34777d;

        public b(c cVar, c.p.a.a.a.d.d dVar, c.p.a.a.a.d.c cVar2, c.p.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, cVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34777d = cVar;
            this.f34774a = dVar;
            this.f34775b = cVar2;
            this.f34776c = bVar;
        }

        @Override // c.p.a.a.a.f.c.InterfaceC1520c
        public void a(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f34777d.f34763a.h(this.f34774a.a(), this.f34774a.d(), 2, this.f34775b, this.f34776c);
                e.c.a().l("landing_download_dialog_confirm", this.f34774a, this.f34775b, this.f34776c);
                dialogInterface.dismiss();
            }
        }

        @Override // c.p.a.a.a.f.c.InterfaceC1520c
        public void b(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                e.c.a().l("landing_download_dialog_cancel", this.f34774a, this.f34775b, this.f34776c);
                dialogInterface.dismiss();
            }
        }

        @Override // c.p.a.a.a.f.c.InterfaceC1520c
        public void c(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                e.c.a().l("landing_download_dialog_cancel", this.f34774a, this.f34775b, this.f34776c);
            }
        }
    }

    /* renamed from: c.p.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1532c implements f.d.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34778a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Uri f34779b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.d f34780c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.c f34781d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.b f34782e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f34783f;

        public C1532c(c cVar, Context context, Uri uri, c.p.a.a.a.d.d dVar, c.p.a.a.a.d.c cVar2, c.p.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, uri, dVar, cVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34783f = cVar;
            this.f34778a = context;
            this.f34779b = uri;
            this.f34780c = dVar;
            this.f34781d = cVar2;
            this.f34782e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.p.a.d.f.d.b
        /* renamed from: a */
        public Boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(this.f34783f.n(this.f34778a, this.f34779b, this.f34780c, this.f34781d, this.f34782e)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static class a implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONObject f34784a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.a f34785b;

            public a(JSONObject jSONObject, c.p.a.b.a.c.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jSONObject, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34784a = jSONObject;
                this.f34785b = aVar;
            }

            @Override // c.p.a.d.c.g
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    e.c.a().w(z ? "deeplink_success" : "deeplink_failed", this.f34784a, this.f34785b);
                    if (z) {
                        c.p.a.d.b.l.G().a(c.p.a.d.b.l.a(), this.f34785b.u(), this.f34785b.w(), this.f34785b.v(), this.f34785b.e(), 0);
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONObject f34786a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.a f34787b;

            public b(JSONObject jSONObject, c.p.a.b.a.c.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jSONObject, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34786a = jSONObject;
                this.f34787b = aVar;
            }

            @Override // c.p.a.d.c.g
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    e.c.a().w(z ? "deeplink_success" : "deeplink_failed", this.f34786a, this.f34787b);
                    if (z) {
                        c.p.a.d.b.l.G().a(c.p.a.d.b.l.a(), this.f34787b.u(), this.f34787b.w(), this.f34787b.v(), this.f34787b.e(), 0);
                    }
                }
            }
        }

        /* renamed from: c.p.a.d.c$d$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1533c implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f34788a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.f f34789b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ JSONObject f34790c;

            public C1533c(String str, c.f fVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, fVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34788a = str;
                this.f34789b = fVar;
                this.f34790c = jSONObject;
            }

            @Override // c.p.a.d.c.g
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (!z && !"open_market".equals(this.f34788a)) {
                        Context a2 = c.p.a.d.b.l.a();
                        d.b(h.o.a(a2, Uri.parse("market://details?id=" + this.f34789b.e())), this.f34789b, false);
                    }
                    e.c.a().r(z ? "market_delay_success" : "market_delay_failed", this.f34790c, this.f34789b);
                    if (z) {
                        s G = c.p.a.d.b.l.G();
                        Context a3 = c.p.a.d.b.l.a();
                        c.f fVar = this.f34789b;
                        c.p.a.a.a.d.d dVar = fVar.f34649b;
                        G.a(a3, dVar, fVar.f34651d, fVar.f34650c, dVar.v(), 2);
                    }
                }
            }
        }

        public static void a(@NonNull c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
                String f2 = bVar.f();
                JSONObject jSONObject = new JSONObject();
                h.l.a(jSONObject, bVar);
                h.r.q(jSONObject, "applink_source", "notify_click_by_sdk");
                e.c.a().w("applink_click", jSONObject, bVar);
                c.h f3 = h.o.f(f2, bVar);
                if (f3.a() == 2) {
                    if (!TextUtils.isEmpty(f2)) {
                        k("notify_by_url", f3, jSONObject, bVar);
                    }
                    f3 = h.o.d(c.p.a.d.b.l.a(), bVar.e(), bVar);
                }
                int a2 = f3.a();
                if (a2 == 1) {
                    l("notify_by_url", jSONObject, bVar);
                } else if (a2 == 3) {
                    d("notify_by_package", jSONObject, bVar);
                } else if (a2 != 4) {
                    f.e.b().g("AppLinkClickNotification default");
                } else {
                    c("notify_by_package", f3, jSONObject, bVar);
                }
            }
        }

        public static void b(c.h hVar, c.f fVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(65537, null, hVar, fVar, z) == null) {
                String m = h.r.m(hVar.c(), "open_market");
                JSONObject jSONObject = new JSONObject();
                h.r.q(jSONObject, "ttdownloader_type", UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
                int a2 = hVar.a();
                if (a2 == 5) {
                    e(m, jSONObject, fVar, z);
                } else if (a2 != 6) {
                } else {
                    h.r.q(jSONObject, "error_code", Integer.valueOf(hVar.b()));
                    h.r.q(jSONObject, "download_scene", Integer.valueOf(fVar.t()));
                    e.c.a().w("market_open_failed", jSONObject, fVar);
                }
            }
        }

        public static void c(String str, @NonNull c.h hVar, @NonNull JSONObject jSONObject, @NonNull c.p.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65538, null, str, hVar, jSONObject, aVar) == null) {
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "error_code", Integer.valueOf(hVar.b()));
                h.r.q(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
                e.c.a().w("deeplink_app_open_fail", jSONObject, aVar);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void d(String str, @NonNull JSONObject jSONObject, @NonNull c.p.a.b.a.c.a aVar) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, str, jSONObject, aVar) == null) {
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
                e.c.a().w("deeplink_app_open", jSONObject, aVar);
                switch (str.hashCode()) {
                    case -1282070764:
                        if (str.equals("notify_by_package")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -441514770:
                        if (str.equals("auto_by_package")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -185950114:
                        if (str.equals("by_package")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 368401333:
                        if (str.equals("dialog_by_package")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
                    if ((c.p.a.d.b.l.v().optInt("check_applink_mode") & 1) != 0) {
                        h.r.q(jSONObject, "check_applink_result_by_sdk", 1);
                        h.d().e(new a(jSONObject, aVar));
                        return;
                    }
                    c.p.a.d.b.l.o().b(c.p.a.d.b.l.a(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), str);
                }
            }
        }

        public static void e(String str, @Nullable JSONObject jSONObject, c.f fVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, jSONObject, fVar, Boolean.valueOf(z)}) == null) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception e2) {
                        f.e.b().a(e2, "onMarketSuccess");
                        return;
                    }
                }
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "download_scene", Integer.valueOf(fVar.t()));
                if (z) {
                    e.c.a().w("market_open_success", jSONObject, fVar);
                }
                if ((c.p.a.d.b.l.v().optInt("check_applink_mode") & 4) != 0) {
                    h.d().g(new C1533c(str, fVar, jSONObject));
                } else {
                    c.p.a.d.b.l.o().b(c.p.a.d.b.l.a(), fVar.f34649b, fVar.f34651d, fVar.f34650c, fVar.f34649b.v(), str);
                }
                c.p.a.b.a.c.b bVar = new c.p.a.b.a.c.b(fVar.f34649b, fVar.f34650c, fVar.f34651d);
                bVar.x0(2);
                bVar.C0(System.currentTimeMillis());
                bVar.J0(4);
                bVar.N0(2);
                c.g.e().j(bVar);
            }
        }

        public static boolean f(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j2)) == null) ? c.g.e().u(j2) == null : invokeJ.booleanValue;
        }

        public static boolean g(@NonNull c.f fVar) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fVar)) == null) {
                c.p.a.a.a.f.b x = fVar.f34649b.x();
                String d2 = x == null ? null : x.d();
                JSONObject jSONObject = new JSONObject();
                h.l.a(jSONObject, fVar);
                h.r.q(jSONObject, "applink_source", "click_by_sdk");
                e.c.a().w("applink_click", jSONObject, fVar);
                c.h f2 = h.o.f(d2, fVar);
                if (f2.a() == 2) {
                    if (!TextUtils.isEmpty(d2)) {
                        k("by_url", f2, jSONObject, fVar);
                    }
                    f2 = h.o.d(c.p.a.d.b.l.a(), fVar.f34649b.v(), fVar);
                }
                boolean z2 = false;
                if (f(fVar.f34648a) && c.p.a.d.b.l.v().optInt("link_ad_click_event") == 1) {
                    c.p.a.a.a.d.d dVar = fVar.f34649b;
                    if (dVar instanceof c.p.a.b.a.a.c) {
                        ((c.p.a.b.a.a.c) dVar).b(4);
                    }
                    e.c.a().c(fVar.f34648a, 0);
                    z = true;
                } else {
                    z = false;
                }
                int a2 = f2.a();
                if (a2 == 1) {
                    l("by_url", jSONObject, fVar);
                } else if (a2 == 3) {
                    d("by_package", jSONObject, fVar);
                } else {
                    if (a2 != 4) {
                        f.e.b().g("AppLinkClick default");
                    } else {
                        c("by_package", f2, jSONObject, fVar);
                    }
                    if (z2 && !z && ((e.C1539e.a().c() && !e.C1539e.a().d(fVar.f34648a, fVar.f34649b.u())) || e.C1539e.a().f())) {
                        e.c.a().c(fVar.f34648a, 2);
                    }
                    return z2;
                }
                z2 = true;
                if (z2) {
                    e.c.a().c(fVar.f34648a, 2);
                }
                return z2;
            }
            return invokeL.booleanValue;
        }

        public static boolean h(@NonNull c.f fVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, fVar, i2)) == null) {
                JSONObject jSONObject = new JSONObject();
                h.r.q(jSONObject, "download_scene", Integer.valueOf(fVar.t()));
                e.c.a().w("market_click_open", jSONObject, fVar);
                c.h b2 = h.o.b(c.p.a.d.b.l.a(), fVar, fVar.f34649b.v());
                String m = h.r.m(b2.c(), "open_market");
                int a2 = b2.a();
                if (a2 == 5) {
                    e(m, jSONObject, fVar, true);
                } else if (a2 == 6) {
                    h.r.q(jSONObject, "error_code", Integer.valueOf(b2.b()));
                    h.r.q(jSONObject, "download_scene", Integer.valueOf(fVar.t()));
                    e.c.a().w("market_open_failed", jSONObject, fVar);
                    return false;
                } else if (a2 != 7) {
                    return false;
                }
                e.c.a().c(fVar.f34648a, i2);
                return true;
            }
            return invokeLI.booleanValue;
        }

        public static boolean i(String str, @NonNull c.p.a.b.a.c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, bVar)) == null) {
                if (c.p.a.d.b.j.h(bVar.L())) {
                    if (TextUtils.isEmpty(bVar.f()) && TextUtils.isEmpty(str)) {
                        return false;
                    }
                    c.p.a.e.b.p.b.a().m(bVar.s());
                    JSONObject jSONObject = new JSONObject();
                    h.l.a(jSONObject, bVar);
                    h.r.q(jSONObject, "applink_source", "auto_click");
                    e.c.a().v("applink_click", bVar);
                    c.h e2 = h.o.e(bVar, bVar.f(), bVar.e());
                    int a2 = e2.a();
                    if (a2 == 1) {
                        l("auto_by_url", jSONObject, bVar);
                        return true;
                    } else if (a2 == 2) {
                        k("auto_by_url", e2, jSONObject, bVar);
                        return false;
                    } else if (a2 == 3) {
                        d("auto_by_package", jSONObject, bVar);
                        return true;
                    } else if (a2 != 4) {
                        return false;
                    } else {
                        c("auto_by_package", e2, jSONObject, bVar);
                        return false;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public static void j(c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65545, null, bVar) == null) || bVar == null) {
                return;
            }
            String f2 = c.p.a.e.b.j.a.r().m("app_link_opt") == 1 ? bVar.f() : null;
            JSONObject jSONObject = new JSONObject();
            h.l.a(jSONObject, bVar);
            h.r.q(jSONObject, "applink_source", "dialog_click_by_sdk");
            e.c.a().w("applink_click", jSONObject, bVar);
            c.h f3 = h.o.f(f2, bVar);
            if (f3.a() == 2) {
                if (!TextUtils.isEmpty(f2)) {
                    k("dialog_by_url", f3, jSONObject, bVar);
                }
                f3 = h.o.d(c.p.a.d.b.l.a(), bVar.e(), bVar);
            }
            int a2 = f3.a();
            if (a2 == 1) {
                l("dialog_by_url", jSONObject, bVar);
            } else if (a2 == 3) {
                d("dialog_by_package", jSONObject, bVar);
            } else if (a2 != 4) {
                f.e.b().g("AppLinkClickDialog default");
            } else {
                c("dialog_by_package", f3, jSONObject, bVar);
            }
        }

        public static void k(String str, @NonNull c.h hVar, @NonNull JSONObject jSONObject, @NonNull c.p.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65546, null, str, hVar, jSONObject, aVar) == null) {
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "error_code", Integer.valueOf(hVar.b()));
                h.r.q(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
                e.c.a().w("deeplink_url_open_fail", jSONObject, aVar);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void l(String str, @NonNull JSONObject jSONObject, @NonNull c.p.a.b.a.c.a aVar) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65547, null, str, jSONObject, aVar) == null) {
                h.r.q(jSONObject, "applink_source", str);
                h.r.q(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
                e.c.a().w("deeplink_url_open", jSONObject, aVar);
                switch (str.hashCode()) {
                    case -1721882089:
                        if (str.equals("auto_by_url")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1374618233:
                        if (str.equals("by_url")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -129544387:
                        if (str.equals("notify_by_url")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 829750366:
                        if (str.equals("dialog_by_url")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
                    if ((c.p.a.d.b.l.v().optInt("check_applink_mode") & 1) != 0) {
                        h.r.q(jSONObject, "check_applink_result_by_sdk", 1);
                        h.d().e(new b(jSONObject, aVar));
                        return;
                    }
                    c.p.a.d.b.l.o().b(c.p.a.d.b.l.a(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.b f34791e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f34792f;

            /* renamed from: c.p.a.d.c$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C1534a implements k {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34793a;

                public C1534a(a aVar) {
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
                    this.f34793a = aVar;
                }

                @Override // c.p.a.d.c.k
                public void a(boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                        this.f34793a.f34792f.a(z);
                    }
                }
            }

            public a(e eVar, c.p.a.b.a.c.b bVar, j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bVar, jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34791e = bVar;
                this.f34792f = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (l.a(this.f34791e)) {
                        this.f34792f.a(false);
                    } else if (!i.c(this.f34791e)) {
                        this.f34792f.a(false);
                    } else {
                        i.b(this.f34791e, new C1534a(this));
                    }
                }
            }
        }

        public e() {
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

        public void a(@NonNull c.p.a.b.a.c.b bVar, @NonNull j jVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bVar, jVar, i2) == null) {
                c.p.a.d.e.a().c(new a(this, bVar, jVar), i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.b f34794e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.p.a.d.i.a.a f34795f;

            public a(c.p.a.b.a.c.b bVar, c.p.a.d.i.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34794e = bVar;
                this.f34795f = aVar;
            }

            @Override // c.p.a.e.b.a.a.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.p.a.e.b.c.a.g("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                    c.p.a.e.b.a.a.c().i(this);
                    if (h.r.C(this.f34794e)) {
                        return;
                    }
                    this.f34794e.b1(true);
                    e.c.a().m("install_delay_invoke", this.f34794e);
                    this.f34795f.a();
                }
            }

            @Override // c.p.a.e.b.a.a.b
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        }

        public static void a(c.p.a.b.a.c.b bVar, @NonNull c.p.a.d.i.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, bVar, aVar) == null) {
                boolean k = c.p.a.e.b.a.a.c().k();
                if (!k && Build.VERSION.SDK_INT >= 29) {
                    h.r.A();
                }
                boolean k2 = c.p.a.e.b.a.a.c().k();
                if (!k && k2 && bVar != null) {
                    bVar.Z0(true);
                }
                aVar.a();
                c.p.a.e.b.c.a.g("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + k2);
                if (k2) {
                    return;
                }
                c.p.a.e.b.a.a.c().f(new a(bVar, aVar));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public class h implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f34796e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f34797e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f34798f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ h f34799g;

            public a(h hVar, long j2, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Long.valueOf(j2), gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34799g = hVar;
                this.f34797e = j2;
                this.f34798f = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (c.p.a.e.b.a.a.c().m() && System.currentTimeMillis() - this.f34799g.f34796e > this.f34797e) {
                        this.f34798f.a(false);
                    } else {
                        this.f34798f.a(true);
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static h f34800a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1097167846, "Lc/p/a/d/c$h$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1097167846, "Lc/p/a/d/c$h$b;");
                        return;
                    }
                }
                f34800a = new h(null);
            }
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        public static h d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f34800a : (h) invokeV.objValue;
        }

        @Override // c.p.a.e.b.a.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34796e = System.currentTimeMillis();
            }
        }

        @Override // c.p.a.e.b.a.a.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
                f(gVar, 5000L);
            }
        }

        public void f(g gVar, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(1048579, this, gVar, j2) == null) || gVar == null) {
                return;
            }
            c.p.a.d.e.a().c(new a(this, j2, gVar), j2);
        }

        public void g(g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) || gVar == null) {
                return;
            }
            int optInt = c.p.a.d.b.l.v().optInt("check_an_result_delay", 1200);
            f(gVar, optInt > 0 ? optInt : 1200);
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
            this.f34796e = 0L;
            c.p.a.e.b.a.a.c().f(this);
        }
    }

    /* loaded from: classes4.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.b f34801e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f34802f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f34803g;

            /* renamed from: c.p.a.d.c$i$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC1535a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f34804e;

                public RunnableC1535a(a aVar) {
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
                    this.f34804e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        boolean F = h.r.F(this.f34804e.f34801e.e());
                        long h2 = i.h(this.f34804e.f34801e);
                        if (!F || h2 >= System.currentTimeMillis() - this.f34804e.f34802f) {
                            long k = i.k(this.f34804e.f34801e);
                            long currentTimeMillis = System.currentTimeMillis();
                            a aVar = this.f34804e;
                            if (currentTimeMillis - aVar.f34802f > k) {
                                e.c.a().m("deeplink_delay_timeout", this.f34804e.f34801e);
                                return;
                            }
                            aVar.f34801e.Z0(true);
                            e.c.a().m("deeplink_delay_invoke", this.f34804e.f34801e);
                            this.f34804e.f34803g.a(true);
                            c.p.a.b.a.c.b bVar = this.f34804e.f34801e;
                            i.d(bVar, i.m(bVar));
                        }
                    }
                }
            }

            public a(c.p.a.b.a.c.b bVar, long j2, k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j2), kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34801e = bVar;
                this.f34802f = j2;
                this.f34803g = kVar;
            }

            @Override // c.p.a.e.b.a.a.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.p.a.e.b.a.a.c().i(this);
                    c.p.a.d.e.a().b(new RunnableC1535a(this));
                }
            }

            @Override // c.p.a.e.b.a.a.b
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.b f34805e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f34806f;

            public b(c.p.a.b.a.c.b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34805e = bVar;
                this.f34806f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = 1;
                    if (h.r.F(this.f34805e.e())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!this.f34805e.c0()) {
                                i2 = 2;
                            }
                            jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        e.c.a().r("deeplink_success_2", jSONObject, this.f34805e);
                        return;
                    }
                    i.d(this.f34805e, this.f34806f - 1);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-146344125, "Lc/p/a/d/c$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-146344125, "Lc/p/a/d/c$i;");
                    return;
                }
            }
            new Handler(Looper.getMainLooper());
        }

        public static void b(c.p.a.b.a.c.b bVar, @NonNull k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, bVar, kVar) == null) {
                boolean k = c.p.a.e.b.a.a.c().k();
                if (!k && Build.VERSION.SDK_INT >= 29) {
                    h.r.A();
                }
                boolean k2 = c.p.a.e.b.a.a.c().k();
                boolean z = !k && k2;
                if (bVar != null) {
                    bVar.Z0(z);
                }
                kVar.a(z);
                if (bVar == null) {
                    return;
                }
                d(bVar, m(bVar));
                if (k2) {
                    return;
                }
                c.p.a.e.b.a.a.c().f(new a(bVar, System.currentTimeMillis(), kVar));
            }
        }

        public static boolean c(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) ? h.k.c(bVar).m("app_link_opt_switch") == 1 : invokeL.booleanValue;
        }

        public static void d(@NonNull c.p.a.b.a.c.b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, i2) == null) || i2 <= 0) {
                return;
            }
            c.p.a.d.e.a().c(new b(bVar, i2), l(bVar) * 1000);
        }

        public static boolean e(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar)) == null) ? h.k.c(bVar).m("app_link_opt_install_switch") == 1 : invokeL.booleanValue;
        }

        public static boolean f(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar)) == null) ? h.k.c(bVar).m("app_link_opt_invoke_switch") == 1 : invokeL.booleanValue;
        }

        public static boolean g(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bVar)) == null) ? h.k.c(bVar).m("app_link_opt_dialog_switch") == 1 : invokeL.booleanValue;
        }

        public static long h(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bVar)) == null) {
                if (bVar == null) {
                    return 3000L;
                }
                return h.k.c(bVar).b("app_link_opt_back_time_limit", 3) * 1000;
            }
            return invokeL.longValue;
        }

        public static long k(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bVar)) == null) ? h.k.c(bVar).c("app_link_check_timeout", 300000L) : invokeL.longValue;
        }

        public static int l(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bVar)) == null) ? h.k.c(bVar).b("app_link_check_delay", 1) : invokeL.intValue;
        }

        public static int m(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bVar)) == null) ? h.k.c(bVar).b("app_link_check_count", 10) : invokeL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface k {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(@NonNull c.p.a.b.a.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) ? c.p.a.e.a.h.e.h() && Build.VERSION.SDK_INT < 29 && c.p.a.d.b.l.x() != null && c.p.a.d.b.l.x().a() && h.k.c(aVar).m("invoke_app_form_background_switch") == 1 && aVar.q() : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1242608984, "Lc/p/a/d/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1242608984, "Lc/p/a/d/c;");
        }
    }

    public c() {
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
        this.f34763a = c.p.a.d.h.b(c.p.a.d.b.l.a());
    }

    public static c.p.a.a.a.d.b e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            a.C1521a c1521a = new a.C1521a();
            c1521a.a(0);
            c1521a.c(true);
            c1521a.g(false);
            c1521a.h(false);
            if (z) {
                c1521a.e(2);
            } else {
                c1521a.e(0);
            }
            return c1521a.d();
        }
        return (c.p.a.a.a.d.b) invokeZ.objValue;
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f34762c == null) {
                synchronized (c.class) {
                    if (f34762c == null) {
                        f34762c = new c();
                    }
                }
            }
            return f34762c;
        }
        return (c) invokeV.objValue;
    }

    public static c.p.a.a.a.d.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? e(false) : (c.p.a.a.a.d.b) invokeV.objValue;
    }

    public static c.p.a.a.a.d.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            b.a aVar = new b.a();
            aVar.b("landing_h5_download_ad_button");
            aVar.e("landing_h5_download_ad_button");
            aVar.g("click_start_detail");
            aVar.i("click_pause_detail");
            aVar.j("click_continue_detail");
            aVar.k("click_install_detail");
            aVar.l("click_open_detail");
            aVar.m("storage_deny_detail");
            aVar.a(1);
            aVar.c(false);
            aVar.f(true);
            aVar.h(false);
            return aVar.d();
        }
        return (c.p.a.a.a.d.c) invokeV.objValue;
    }

    @Override // c.p.a.b.a.d
    public Dialog a(Context context, String str, boolean z, @NonNull c.p.a.a.a.d.d dVar, c.p.a.a.a.d.c cVar, c.p.a.a.a.d.b bVar, c.p.a.a.a.d.e eVar, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, Boolean.valueOf(z), dVar, cVar, bVar, eVar, Integer.valueOf(i2)})) == null) ? d(context, str, z, dVar, cVar, bVar, eVar, i2, false) : (Dialog) invokeCommon.objValue;
    }

    @Override // c.p.a.b.a.d
    public boolean b(Context context, long j2, String str, c.p.a.a.a.d.e eVar, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j2), str, eVar, Integer.valueOf(i2)})) == null) {
            c.p.a.b.a.c.b u = c.g.e().u(j2);
            if (u != null) {
                this.f34763a.e(context, i2, eVar, u.h0());
                return true;
            }
            c.p.a.a.a.d.d a2 = c.g.e().a(j2);
            if (a2 != null) {
                this.f34763a.e(context, i2, eVar, a2);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.p.a.b.a.d
    public boolean c(Context context, Uri uri, c.p.a.a.a.d.d dVar, c.p.a.a.a.d.c cVar, c.p.a.a.a.d.b bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, uri, dVar, cVar, bVar)) == null) ? ((Boolean) f.d.a(new C1532c(this, context, uri, dVar, cVar, bVar))).booleanValue() : invokeLLLLL.booleanValue;
    }

    public Dialog d(Context context, String str, boolean z, @NonNull c.p.a.a.a.d.d dVar, c.p.a.a.a.d.c cVar, c.p.a.a.a.d.b bVar, c.p.a.a.a.d.e eVar, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, Boolean.valueOf(z), dVar, cVar, bVar, eVar, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) ? (Dialog) f.d.a(new a(this, context, str, z, dVar, cVar, bVar, eVar, i2, z2)) : (Dialog) invokeCommon.objValue;
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            c.p.a.a.a.d.d a2 = c.g.e().a(j2);
            c.p.a.b.a.c.b u = c.g.e().u(j2);
            if (a2 == null && u != null) {
                a2 = u.h0();
            }
            if (a2 == null) {
                return;
            }
            c.p.a.a.a.d.c n = c.g.e().n(j2);
            c.p.a.a.a.d.b s = c.g.e().s(j2);
            if (n instanceof c.p.a.a.a.d.h) {
                n = null;
            }
            if (s instanceof c.p.a.a.a.d.g) {
                s = null;
            }
            if (u == null) {
                if (n == null) {
                    n = o();
                }
                if (s == null) {
                    s = l();
                }
            } else {
                if (n == null) {
                    b.a aVar = new b.a();
                    aVar.b(u.j());
                    aVar.n(u.i());
                    aVar.h(u.m());
                    aVar.c(false);
                    aVar.g("click_start_detail");
                    aVar.i("click_pause_detail");
                    aVar.j("click_continue_detail");
                    aVar.k("click_install_detail");
                    aVar.m("storage_deny_detail");
                    n = aVar.d();
                }
                if (s == null) {
                    s = u.j0();
                }
            }
            c.p.a.a.a.d.c cVar = n;
            cVar.a(1);
            this.f34763a.h(a2.a(), j2, 2, cVar, s);
        }
    }

    public void i(long j2, c.p.a.a.a.d.c cVar, c.p.a.a.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), cVar, bVar}) == null) {
            c.p.a.a.a.d.d a2 = c.g.e().a(j2);
            c.p.a.b.a.c.b u = c.g.e().u(j2);
            if (a2 == null && u != null) {
                a2 = u.h0();
            }
            if (a2 == null) {
                return;
            }
            if (cVar != null && bVar != null && !(cVar instanceof c.p.a.a.a.d.h) && !(bVar instanceof c.p.a.a.a.d.g)) {
                cVar.a(1);
                this.f34763a.h(a2.a(), j2, 2, cVar, bVar);
                return;
            }
            h(j2);
        }
    }

    public Dialog k(Context context, String str, boolean z, c.p.a.a.a.d.d dVar, c.p.a.a.a.d.c cVar, c.p.a.a.a.d.b bVar, c.p.a.a.a.d.e eVar, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), dVar, cVar, bVar, eVar, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            if (m(dVar.d())) {
                if (z2) {
                    i(dVar.d(), cVar, bVar);
                } else {
                    h(dVar.d());
                }
                return null;
            } else if (context == null || TextUtils.isEmpty(dVar.a())) {
                return null;
            } else {
                this.f34763a.e(context, i2, eVar, dVar);
                boolean z3 = true;
                c.p.a.a.a.d.c cVar2 = (c.p.a.a.a.d.c) h.r.k(cVar, o());
                c.p.a.a.a.d.b bVar2 = (c.p.a.a.a.d.b) h.r.k(bVar, l());
                cVar2.a(1);
                boolean z4 = (c.p.a.d.b.l.v().optInt("disable_lp_dialog", 0) == 1) | z;
                if (!bVar2.e() || !c.p.a.d.b.e.a.a().e(dVar)) {
                    z3 = z4;
                }
                if (z3) {
                    this.f34763a.h(dVar.a(), dVar.d(), 2, cVar2, bVar2);
                    return null;
                }
                String str2 = f34761b;
                h.q.b(str2, "tryStartDownload show dialog appName:" + dVar.a(), null);
                c.p.a.a.a.c.k p = c.p.a.d.b.l.p();
                c.b bVar3 = new c.b(context);
                bVar3.e(dVar.h());
                bVar3.h("确认要下载此应用吗？");
                bVar3.j("确认");
                bVar3.l("取消");
                bVar3.d(new b(this, dVar, cVar2, bVar2));
                bVar3.b(0);
                Dialog b2 = p.b(bVar3.g());
                e.c.a().l("landing_download_dialog_show", dVar, cVar2, bVar2);
                return b2;
            }
        }
        return (Dialog) invokeCommon.objValue;
    }

    public boolean m(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) ? (c.g.e().a(j2) == null && c.g.e().u(j2) == null) ? false : true : invokeJ.booleanValue;
    }

    public final boolean n(Context context, Uri uri, c.p.a.a.a.d.d dVar, c.p.a.a.a.d.c cVar, c.p.a.a.a.d.b bVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, uri, dVar, cVar, bVar)) == null) {
            c.p.a.a.a.d.b bVar2 = bVar;
            if (c.p.a.a.a.g.a.a(uri) && c.p.a.d.b.l.v().optInt("disable_market") != 1) {
                Context a2 = context == null ? c.p.a.d.b.l.a() : context;
                String b2 = c.p.a.a.a.g.a.b(uri);
                if (dVar == null) {
                    return h.o.c(a2, b2).a() == 5;
                }
                if (!TextUtils.isEmpty(b2) && (dVar instanceof c.p.a.b.a.a.c)) {
                    ((c.p.a.b.a.a.c) dVar).e(b2);
                }
                if (bVar2 != null) {
                    bVar2.a(2);
                } else if ((dVar instanceof c.p.a.b.a.a.c) && TextUtils.isEmpty(dVar.a())) {
                    ((c.p.a.b.a.a.c) dVar).f(uri.toString());
                    bVar2 = e(true);
                } else if (dVar.a().startsWith("market")) {
                    bVar2 = e(true);
                } else {
                    bVar2 = l();
                }
                c.f fVar = new c.f(dVar.d(), dVar, (c.p.a.a.a.d.c) h.r.k(cVar, o()), bVar2);
                c.g.e().i(fVar.f34649b);
                c.g.e().h(fVar.f34648a, fVar.f34650c);
                c.g.e().g(fVar.f34648a, fVar.f34651d);
                if (h.r.v(dVar) && c.p.a.e.b.j.a.r().m("app_link_opt") == 1 && d.g(fVar)) {
                    return true;
                }
                JSONObject jSONObject = new JSONObject();
                h.r.q(jSONObject, "market_url", uri.toString());
                h.r.q(jSONObject, "download_scene", 1);
                e.c.a().w("market_click_open", jSONObject, fVar);
                c.h b3 = h.o.b(a2, fVar, b2);
                String m = h.r.m(b3.c(), "open_market");
                if (b3.a() == 5) {
                    d.e(m, jSONObject, fVar, true);
                    return true;
                } else if (b3.a() == 6) {
                    h.r.q(jSONObject, "error_code", Integer.valueOf(b3.b()));
                    e.c.a().w("market_open_failed", jSONObject, fVar);
                    return false;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }
}
