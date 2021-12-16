package c.a.q0.a.r2.l;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.h2.c.j.b;
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
import com.kuaishou.weapon.un.s;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final c.a.q0.a.z2.g1.c<c.a.q0.a.r2.l.d.c<c.a.q0.a.r2.l.d.b>> f8123f;

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.q0.a.z2.g1.c<c.a.q0.a.r2.l.d.c<List<c.a.q0.a.r2.l.d.b>>> f8124g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.a.r2.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0481a implements c.a.q0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f8125e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r2.l.d.a f8126f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8127g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8128h;

        /* renamed from: c.a.q0.a.r2.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0482a implements c.a.q0.a.z2.g1.c<c.a.q0.a.r2.l.d.c<c.a.q0.a.r2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0481a f8129e;

            public C0482a(C0481a c0481a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0481a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8129e = c0481a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.q0.a.r2.l.d.c<c.a.q0.a.r2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.q0.a.e0.d.i("WifiApi", "connectWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8189b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f8190c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f8190c.n());
                        } catch (JSONException e2) {
                            c.a.q0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8189b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8190c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    C0481a c0481a = this.f8129e;
                    c0481a.f8128h.d(c0481a.f8127g, jSONObject == null ? new c.a.q0.a.u.h.b(cVar.a, cVar.f8189b) : new c.a.q0.a.u.h.b(cVar.a, cVar.f8189b, jSONObject));
                }
            }
        }

        public C0481a(a aVar, Activity activity, c.a.q0.a.r2.l.d.a aVar2, String str) {
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
            this.f8128h = aVar;
            this.f8125e = activity;
            this.f8126f = aVar2;
            this.f8127g = str;
        }

        @Override // c.a.q0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.q0.a.r2.l.c.d.s(this.f8125e).a(this.f8126f, new C0482a(this));
            }
        }

        @Override // c.a.q0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.q0.a.e0.d.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.f8128h.d(this.f8127g, new c.a.q0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.q0.a.z2.g1.c<c.a.q0.a.r2.l.d.c<c.a.q0.a.r2.l.d.b>> {
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
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.r2.l.d.c<c.a.q0.a.r2.l.d.b> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f8190c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", cVar.f8190c);
            } catch (JSONException e2) {
                c.a.q0.a.e0.d.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.q0.a.g1.f.U().u(new c.a.q0.a.o0.d.c("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.q0.a.z2.g1.c<c.a.q0.a.r2.l.d.c<List<c.a.q0.a.r2.l.d.b>>> {
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
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.r2.l.d.c<List<c.a.q0.a.r2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f8190c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (c.a.q0.a.r2.l.d.b bVar : cVar.f8190c) {
                jSONArray.put(bVar);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e2) {
                c.a.q0.a.e0.d.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.q0.a.g1.f.U().u(new c.a.q0.a.o0.d.c("getWifiList", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.q0.a.z2.g1.c<c.a.q0.a.r2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8130e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8131f;

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
            this.f8131f = aVar;
            this.f8130e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.r2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.q0.a.e0.d.i("WifiApi", "startWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8189b);
                }
                this.f8131f.d(this.f8130e, new c.a.q0.a.u.h.b(cVar.a, cVar.f8189b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.q0.a.z2.g1.c<c.a.q0.a.r2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8132e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8133f;

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
            this.f8133f = aVar;
            this.f8132e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.r2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.q0.a.e0.d.i("WifiApi", "stopWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8189b);
                }
                this.f8133f.d(this.f8132e, new c.a.q0.a.u.h.b(cVar.a, cVar.f8189b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8135f;

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
            this.f8135f = aVar;
            this.f8134e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.q0.a.h2.c.d.h(iVar)) {
                    this.f8135f.F(this.f8134e);
                    return;
                }
                int b2 = iVar.b();
                c.a.q0.a.e0.d.i("WifiApi", "getWifiList: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.q0.a.h2.c.d.f(b2));
                this.f8135f.d(this.f8134e, new c.a.q0.a.u.h.b(b2, c.a.q0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.q0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f8136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8137f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8138g;

        /* renamed from: c.a.q0.a.r2.l.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0483a implements c.a.q0.a.z2.g1.c<c.a.q0.a.r2.l.d.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f8139e;

            public C0483a(g gVar) {
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
                this.f8139e = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.q0.a.r2.l.d.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.q0.a.e0.d.i("WifiApi", "getWifiList: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8189b);
                    }
                    g gVar = this.f8139e;
                    gVar.f8138g.d(gVar.f8137f, new c.a.q0.a.u.h.b(cVar.a, cVar.f8189b));
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
            this.f8138g = aVar;
            this.f8136e = activity;
            this.f8137f = str;
        }

        @Override // c.a.q0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.q0.a.r2.l.c.d.s(this.f8136e).c(new C0483a(this));
            }
        }

        @Override // c.a.q0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.q0.a.e0.d.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.f8138g.d(this.f8137f, new c.a.q0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8140e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8141f;

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
            this.f8141f = aVar;
            this.f8140e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.q0.a.h2.c.d.h(iVar)) {
                    this.f8141f.E(this.f8140e);
                    return;
                }
                int b2 = iVar.b();
                c.a.q0.a.e0.d.i("WifiApi", "getConnectedWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.q0.a.h2.c.d.f(b2));
                this.f8141f.d(this.f8140e, new c.a.q0.a.u.h.b(b2, c.a.q0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.q0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f8142e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8143f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8144g;

        /* renamed from: c.a.q0.a.r2.l.a$i$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0484a implements c.a.q0.a.z2.g1.c<c.a.q0.a.r2.l.d.c<c.a.q0.a.r2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f8145e;

            public C0484a(i iVar) {
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
                this.f8145e = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.q0.a.r2.l.d.c<c.a.q0.a.r2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.q0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8189b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f8190c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f8190c.n());
                        } catch (JSONException e2) {
                            c.a.q0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8189b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8190c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    i iVar = this.f8145e;
                    iVar.f8144g.d(iVar.f8143f, jSONObject == null ? new c.a.q0.a.u.h.b(cVar.a, cVar.f8189b) : new c.a.q0.a.u.h.b(cVar.a, cVar.f8189b, jSONObject));
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
            this.f8144g = aVar;
            this.f8142e = activity;
            this.f8143f = str;
        }

        @Override // c.a.q0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.q0.a.r2.l.c.d.s(this.f8142e).j(new C0484a(this));
            }
        }

        @Override // c.a.q0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.q0.a.e0.d.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.f8144g.d(this.f8143f, new c.a.q0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8146e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r2.l.d.a f8147f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8148g;

        public j(a aVar, String str, c.a.q0.a.r2.l.d.a aVar2) {
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
            this.f8148g = aVar;
            this.f8146e = str;
            this.f8147f = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.q0.a.h2.c.d.h(iVar)) {
                    this.f8148g.D(this.f8146e, this.f8147f);
                    return;
                }
                int b2 = iVar.b();
                c.a.q0.a.e0.d.i("WifiApi", "connectWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.q0.a.h2.c.d.f(b2));
                this.f8148g.d(this.f8146e, new c.a.q0.a.u.h.b(b2, c.a.q0.a.h2.c.d.f(b2)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1558460852, "Lc/a/q0/a/r2/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1558460852, "Lc/a/q0/a/r2/l/a;");
                return;
            }
        }
        f8123f = new b();
        f8124g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.q0.a.u.c.b bVar) {
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
                super((c.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public c.a.q0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            if (a0 == null) {
                c.a.q0.a.e0.d.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new c.a.q0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.q0.a.e0.d.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new c.a.q0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.q0.a.u.h.b, JSONObject> s = s(str);
                c.a.q0.a.u.h.b bVar = (c.a.q0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.q0.a.e0.d.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new c.a.q0.a.u.h.b(201, "callback is null");
                    }
                    c.a.q0.a.r2.l.d.a a = c.a.q0.a.r2.l.d.a.a(jSONObject);
                    if (TextUtils.isEmpty(a.a)) {
                        c.a.q0.a.e0.d.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new c.a.q0.a.u.h.b(12008, "invalid ssid");
                    } else if (a0.m0()) {
                        c.a.q0.a.e0.d.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new c.a.q0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new j(this, optString, a));
                        return c.a.q0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.q0.a.u.h.b) invokeL.objValue;
    }

    public c.a.q0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            if (a0 == null) {
                c.a.q0.a.e0.d.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new c.a.q0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.q0.a.e0.d.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new c.a.q0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.q0.a.u.h.b, JSONObject> s = s(str);
                c.a.q0.a.u.h.b bVar = (c.a.q0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.q0.a.e0.d.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new c.a.q0.a.u.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.q0.a.e0.d.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new c.a.q0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new h(this, optString));
                        return c.a.q0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.q0.a.u.h.b) invokeL.objValue;
    }

    public c.a.q0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            if (a0 == null) {
                c.a.q0.a.e0.d.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new c.a.q0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.q0.a.e0.d.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new c.a.q0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.q0.a.u.h.b, JSONObject> s = s(str);
                c.a.q0.a.u.h.b bVar = (c.a.q0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.q0.a.e0.d.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new c.a.q0.a.u.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.q0.a.e0.d.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new c.a.q0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new f(this, optString));
                        return c.a.q0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final void D(String str, c.a.q0.a.r2.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            SwanAppActivity x = c.a.q0.a.d2.d.J().x();
            c.a.q0.a.v1.e.g(x, new String[]{s.f57423g, s.f57424h}, 0, new C0481a(this, x, aVar, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity x = c.a.q0.a.d2.d.J().x();
            c.a.q0.a.v1.e.g(x, new String[]{s.f57423g, s.f57424h}, 0, new i(this, x, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity x = c.a.q0.a.d2.d.J().x();
            c.a.q0.a.v1.e.g(x, new String[]{s.f57423g, s.f57424h}, 0, new g(this, x, str));
        }
    }

    public c.a.q0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            if (a0 == null) {
                c.a.q0.a.e0.d.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new c.a.q0.a.u.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.q0.a.e0.d.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new c.a.q0.a.u.h.b(1001, "swan activity is null");
            }
            Pair<c.a.q0.a.u.h.b, JSONObject> s = s(str);
            c.a.q0.a.u.h.b bVar = (c.a.q0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.q0.a.e0.d.c("WifiApi", "startWifi: 201 : callback is null");
                    return new c.a.q0.a.u.h.b(201, "callback is null");
                }
                c.a.q0.a.r2.l.c.d s2 = c.a.q0.a.r2.l.c.d.s(x);
                if (s2.n(f8123f) && s2.d(f8124g)) {
                    s2.p(new d(this, optString));
                    return c.a.q0.a.u.h.b.f();
                }
                c.a.q0.a.e0.d.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new c.a.q0.a.u.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.q0.a.u.h.b) invokeL.objValue;
    }

    public c.a.q0.a.u.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            if (a0 == null) {
                c.a.q0.a.e0.d.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new c.a.q0.a.u.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.q0.a.e0.d.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new c.a.q0.a.u.h.b(1001, "swan activity is null");
            }
            Pair<c.a.q0.a.u.h.b, JSONObject> s = s(str);
            c.a.q0.a.u.h.b bVar = (c.a.q0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.q0.a.e0.d.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new c.a.q0.a.u.h.b(201, "callback is null");
                }
                c.a.q0.a.r2.l.c.d s2 = c.a.q0.a.r2.l.c.d.s(x);
                if (s2.r(f8123f) && s2.b(f8124g)) {
                    s2.q(new e(this, optString));
                    return c.a.q0.a.u.h.b.f();
                }
                c.a.q0.a.e0.d.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new c.a.q0.a.u.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.q0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.q0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // c.a.q0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
