package b.a.p0.a.r2.l;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> f8209f;

    /* renamed from: g  reason: collision with root package name */
    public static final b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>> f8210g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.r2.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0391a implements b.a.p0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f8211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r2.l.d.a f8212f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8213g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8214h;

        /* renamed from: b.a.p0.a.r2.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0392a implements b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0391a f8215e;

            public C0392a(C0391a c0391a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0391a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8215e = c0391a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.f8284a != 0) {
                        b.a.p0.a.e0.d.i("WifiApi", "connectWifi: " + cVar.f8284a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8285b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f8286c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f8286c.n());
                        } catch (JSONException e2) {
                            b.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.f8284a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8285b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8286c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    C0391a c0391a = this.f8215e;
                    c0391a.f8214h.d(c0391a.f8213g, jSONObject == null ? new b.a.p0.a.u.h.b(cVar.f8284a, cVar.f8285b) : new b.a.p0.a.u.h.b(cVar.f8284a, cVar.f8285b, jSONObject));
                }
            }
        }

        public C0391a(a aVar, Activity activity, b.a.p0.a.r2.l.d.a aVar2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, aVar2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8214h = aVar;
            this.f8211e = activity;
            this.f8212f = aVar2;
            this.f8213g = str;
        }

        @Override // b.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.r2.l.c.d.s(this.f8211e).a(this.f8212f, new C0392a(this));
            }
        }

        @Override // b.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                b.a.p0.a.e0.d.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.f8214h.d(this.f8213g, new b.a.p0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.f8284a != 0 || cVar.f8286c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", cVar.f8286c);
            } catch (JSONException e2) {
                b.a.p0.a.e0.d.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            b.a.p0.a.g1.f.U().u(new b.a.p0.a.o0.d.c("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public static class c implements b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.f8284a != 0 || cVar.f8286c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (b.a.p0.a.r2.l.d.b bVar : cVar.f8286c) {
                jSONArray.put(bVar);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e2) {
                b.a.p0.a.e0.d.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            b.a.p0.a.g1.f.U().u(new b.a.p0.a.o0.d.c("getWifiList", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8216e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8217f;

        public d(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8217f = aVar;
            this.f8216e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.r2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.f8284a != 0) {
                    b.a.p0.a.e0.d.i("WifiApi", "startWifi: " + cVar.f8284a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8285b);
                }
                this.f8217f.d(this.f8216e, new b.a.p0.a.u.h.b(cVar.f8284a, cVar.f8285b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8218e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8219f;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8219f = aVar;
            this.f8218e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.r2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.f8284a != 0) {
                    b.a.p0.a.e0.d.i("WifiApi", "stopWifi: " + cVar.f8284a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8285b);
                }
                this.f8219f.d(this.f8218e, new b.a.p0.a.u.h.b(cVar.f8284a, cVar.f8285b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8221f;

        public f(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8221f = aVar;
            this.f8220e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    this.f8221f.F(this.f8220e);
                    return;
                }
                int b2 = iVar.b();
                b.a.p0.a.e0.d.i("WifiApi", "getWifiList: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + b.a.p0.a.h2.c.d.f(b2));
                this.f8221f.d(this.f8220e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f8222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8223f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8224g;

        /* renamed from: b.a.p0.a.r2.l.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0393a implements b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f8225e;

            public C0393a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8225e = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(b.a.p0.a.r2.l.d.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.f8284a != 0) {
                        b.a.p0.a.e0.d.i("WifiApi", "getWifiList: " + cVar.f8284a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8285b);
                    }
                    g gVar = this.f8225e;
                    gVar.f8224g.d(gVar.f8223f, new b.a.p0.a.u.h.b(cVar.f8284a, cVar.f8285b));
                }
            }
        }

        public g(a aVar, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8224g = aVar;
            this.f8222e = activity;
            this.f8223f = str;
        }

        @Override // b.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.r2.l.c.d.s(this.f8222e).c(new C0393a(this));
            }
        }

        @Override // b.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                b.a.p0.a.e0.d.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.f8224g.d(this.f8223f, new b.a.p0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8226e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8227f;

        public h(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8227f = aVar;
            this.f8226e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    this.f8227f.E(this.f8226e);
                    return;
                }
                int b2 = iVar.b();
                b.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + b.a.p0.a.h2.c.d.f(b2));
                this.f8227f.d(this.f8226e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.a.p0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f8228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8229f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8230g;

        /* renamed from: b.a.p0.a.r2.l.a$i$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0394a implements b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f8231e;

            public C0394a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8231e = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.f8284a != 0) {
                        b.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.f8284a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8285b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f8286c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f8286c.n());
                        } catch (JSONException e2) {
                            b.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.f8284a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8285b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8286c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    i iVar = this.f8231e;
                    iVar.f8230g.d(iVar.f8229f, jSONObject == null ? new b.a.p0.a.u.h.b(cVar.f8284a, cVar.f8285b) : new b.a.p0.a.u.h.b(cVar.f8284a, cVar.f8285b, jSONObject));
                }
            }
        }

        public i(a aVar, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8230g = aVar;
            this.f8228e = activity;
            this.f8229f = str;
        }

        @Override // b.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.r2.l.c.d.s(this.f8228e).j(new C0394a(this));
            }
        }

        @Override // b.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                b.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.f8230g.d(this.f8229f, new b.a.p0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8232e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r2.l.d.a f8233f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8234g;

        public j(a aVar, String str, b.a.p0.a.r2.l.d.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8234g = aVar;
            this.f8232e = str;
            this.f8233f = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    this.f8234g.D(this.f8232e, this.f8233f);
                    return;
                }
                int b2 = iVar.b();
                b.a.p0.a.e0.d.i("WifiApi", "connectWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + b.a.p0.a.h2.c.d.f(b2));
                this.f8234g.d(this.f8232e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.h2.c.d.f(b2)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1939912310, "Lb/a/p0/a/r2/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1939912310, "Lb/a/p0/a/r2/l/a;");
                return;
            }
        }
        f8209f = new b();
        f8210g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public b.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                b.a.p0.a.e0.d.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                b.a.p0.a.e0.d.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new b.a.p0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
                b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        b.a.p0.a.e0.d.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new b.a.p0.a.u.h.b(201, "callback is null");
                    }
                    b.a.p0.a.r2.l.d.a a2 = b.a.p0.a.r2.l.d.a.a(jSONObject);
                    if (TextUtils.isEmpty(a2.f8274a)) {
                        b.a.p0.a.e0.d.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new b.a.p0.a.u.h.b(12008, "invalid ssid");
                    } else if (a0.m0()) {
                        b.a.p0.a.e0.d.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new b.a.p0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return b.a.p0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                b.a.p0.a.e0.d.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                b.a.p0.a.e0.d.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new b.a.p0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
                b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        b.a.p0.a.e0.d.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new b.a.p0.a.u.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        b.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new b.a.p0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new h(this, optString));
                        return b.a.p0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                b.a.p0.a.e0.d.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                b.a.p0.a.e0.d.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new b.a.p0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
                b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        b.a.p0.a.e0.d.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new b.a.p0.a.u.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        b.a.p0.a.e0.d.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new b.a.p0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new f(this, optString));
                        return b.a.p0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void D(String str, b.a.p0.a.r2.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            SwanAppActivity x = b.a.p0.a.d2.d.J().x();
            b.a.p0.a.v1.e.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new C0391a(this, x, aVar, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity x = b.a.p0.a.d2.d.J().x();
            b.a.p0.a.v1.e.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new i(this, x, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity x = b.a.p0.a.d2.d.J().x();
            b.a.p0.a.v1.e.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new g(this, x, str));
        }
    }

    public b.a.p0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                b.a.p0.a.e0.d.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                b.a.p0.a.e0.d.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new b.a.p0.a.u.h.b(1001, "swan activity is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.e0.d.c("WifiApi", "startWifi: 201 : callback is null");
                    return new b.a.p0.a.u.h.b(201, "callback is null");
                }
                b.a.p0.a.r2.l.c.d s2 = b.a.p0.a.r2.l.c.d.s(x);
                if (s2.n(f8209f) && s2.d(f8210g)) {
                    s2.p(new d(this, optString));
                    return b.a.p0.a.u.h.b.f();
                }
                b.a.p0.a.e0.d.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new b.a.p0.a.u.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                b.a.p0.a.e0.d.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                b.a.p0.a.e0.d.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new b.a.p0.a.u.h.b(1001, "swan activity is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.e0.d.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new b.a.p0.a.u.h.b(201, "callback is null");
                }
                b.a.p0.a.r2.l.c.d s2 = b.a.p0.a.r2.l.c.d.s(x);
                if (s2.r(f8209f) && s2.b(f8210g)) {
                    s2.q(new e(this, optString));
                    return b.a.p0.a.u.h.b.f();
                }
                b.a.p0.a.e0.d.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new b.a.p0.a.u.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
