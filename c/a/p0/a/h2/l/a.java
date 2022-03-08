package c.a.p0.a.h2.l;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.x1.c.j.b;
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
public class a extends c.a.p0.a.k.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> f5633f;

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>> f5634g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.h2.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0317a implements c.a.p0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5635e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h2.l.d.a f5636f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5637g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5638h;

        /* renamed from: c.a.p0.a.h2.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0318a implements c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0317a f5639e;

            public C0318a(C0317a c0317a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0317a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5639e = c0317a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.p0.a.u.d.i("WifiApi", "connectWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f5699b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f5700c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f5700c.n());
                        } catch (JSONException e2) {
                            c.a.p0.a.u.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f5699b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f5700c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    C0317a c0317a = this.f5639e;
                    c0317a.f5638h.d(c0317a.f5637g, jSONObject == null ? new c.a.p0.a.k.h.b(cVar.a, cVar.f5699b) : new c.a.p0.a.k.h.b(cVar.a, cVar.f5699b, jSONObject));
                }
            }
        }

        public C0317a(a aVar, Activity activity, c.a.p0.a.h2.l.d.a aVar2, String str) {
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
            this.f5638h = aVar;
            this.f5635e = activity;
            this.f5636f = aVar2;
            this.f5637g = str;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.h2.l.c.d.s(this.f5635e).a(this.f5636f, new C0318a(this));
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.p0.a.u.d.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.f5638h.d(this.f5637g, new c.a.p0.a.k.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> {
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
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f5700c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", cVar.f5700c);
            } catch (JSONException e2) {
                c.a.p0.a.u.d.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.p0.a.w0.f.U().u(new c.a.p0.a.e0.d.c("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>> {
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
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f5700c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (c.a.p0.a.h2.l.d.b bVar : cVar.f5700c) {
                jSONArray.put(bVar);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e2) {
                c.a.p0.a.u.d.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.p0.a.w0.f.U().u(new c.a.p0.a.e0.d.c("getWifiList", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5640e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5641f;

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
            this.f5641f = aVar;
            this.f5640e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.p0.a.u.d.i("WifiApi", "startWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f5699b);
                }
                this.f5641f.d(this.f5640e, new c.a.p0.a.k.h.b(cVar.a, cVar.f5699b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5643f;

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
            this.f5643f = aVar;
            this.f5642e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.p0.a.u.d.i("WifiApi", "stopWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f5699b);
                }
                this.f5643f.d(this.f5642e, new c.a.p0.a.k.h.b(cVar.a, cVar.f5699b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5645f;

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
            this.f5645f = aVar;
            this.f5644e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.f5645f.F(this.f5644e);
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.u.d.i("WifiApi", "getWifiList: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.p0.a.x1.c.d.f(b2));
                this.f5645f.d(this.f5644e, new c.a.p0.a.k.h.b(b2, c.a.p0.a.x1.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.p0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5647f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5648g;

        /* renamed from: c.a.p0.a.h2.l.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0319a implements c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f5649e;

            public C0319a(g gVar) {
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
                this.f5649e = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.p0.a.h2.l.d.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.p0.a.u.d.i("WifiApi", "getWifiList: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f5699b);
                    }
                    g gVar = this.f5649e;
                    gVar.f5648g.d(gVar.f5647f, new c.a.p0.a.k.h.b(cVar.a, cVar.f5699b));
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
            this.f5648g = aVar;
            this.f5646e = activity;
            this.f5647f = str;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.h2.l.c.d.s(this.f5646e).c(new C0319a(this));
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.p0.a.u.d.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.f5648g.d(this.f5647f, new c.a.p0.a.k.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5650e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5651f;

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
            this.f5651f = aVar;
            this.f5650e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.f5651f.E(this.f5650e);
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.u.d.i("WifiApi", "getConnectedWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.p0.a.x1.c.d.f(b2));
                this.f5651f.d(this.f5650e, new c.a.p0.a.k.h.b(b2, c.a.p0.a.x1.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.p0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5653f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5654g;

        /* renamed from: c.a.p0.a.h2.l.a$i$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0320a implements c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f5655e;

            public C0320a(i iVar) {
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
                this.f5655e = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.p0.a.u.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f5699b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f5700c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f5700c.n());
                        } catch (JSONException e2) {
                            c.a.p0.a.u.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f5699b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f5700c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    i iVar = this.f5655e;
                    iVar.f5654g.d(iVar.f5653f, jSONObject == null ? new c.a.p0.a.k.h.b(cVar.a, cVar.f5699b) : new c.a.p0.a.k.h.b(cVar.a, cVar.f5699b, jSONObject));
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
            this.f5654g = aVar;
            this.f5652e = activity;
            this.f5653f = str;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.h2.l.c.d.s(this.f5652e).j(new C0320a(this));
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.p0.a.u.d.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.f5654g.d(this.f5653f, new c.a.p0.a.k.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5656e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h2.l.d.a f5657f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5658g;

        public j(a aVar, String str, c.a.p0.a.h2.l.d.a aVar2) {
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
            this.f5658g = aVar;
            this.f5656e = str;
            this.f5657f = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.f5658g.D(this.f5656e, this.f5657f);
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.u.d.i("WifiApi", "connectWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.p0.a.x1.c.d.f(b2));
                this.f5658g.d(this.f5656e, new c.a.p0.a.k.h.b(b2, c.a.p0.a.x1.c.d.f(b2)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1144275915, "Lc/a/p0/a/h2/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1144275915, "Lc/a/p0/a/h2/l/a;");
                return;
            }
        }
        f5633f = new b();
        f5634g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.k.c.b bVar) {
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
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public c.a.p0.a.k.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                c.a.p0.a.u.d.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.p0.a.u.d.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new c.a.p0.a.k.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
                c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
                if (bVar.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.p0.a.u.d.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new c.a.p0.a.k.h.b(201, "callback is null");
                    }
                    c.a.p0.a.h2.l.d.a a = c.a.p0.a.h2.l.d.a.a(jSONObject);
                    if (TextUtils.isEmpty(a.a)) {
                        c.a.p0.a.u.d.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new c.a.p0.a.k.h.b(12008, "invalid ssid");
                    } else if (a0.m0()) {
                        c.a.p0.a.u.d.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new c.a.p0.a.k.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new j(this, optString, a));
                        return c.a.p0.a.k.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public c.a.p0.a.k.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                c.a.p0.a.u.d.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.p0.a.u.d.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new c.a.p0.a.k.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
                c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.p0.a.u.d.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new c.a.p0.a.k.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.p0.a.u.d.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new c.a.p0.a.k.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new h(this, optString));
                        return c.a.p0.a.k.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public c.a.p0.a.k.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                c.a.p0.a.u.d.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.p0.a.u.d.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new c.a.p0.a.k.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
                c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.p0.a.u.d.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new c.a.p0.a.k.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.p0.a.u.d.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new c.a.p0.a.k.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new f(this, optString));
                        return c.a.p0.a.k.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public final void D(String str, c.a.p0.a.h2.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            SwanAppActivity x = c.a.p0.a.t1.d.J().x();
            c.a.p0.a.l1.e.g(x, new String[]{s.f53808g, s.f53809h}, 0, new C0317a(this, x, aVar, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity x = c.a.p0.a.t1.d.J().x();
            c.a.p0.a.l1.e.g(x, new String[]{s.f53808g, s.f53809h}, 0, new i(this, x, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity x = c.a.p0.a.t1.d.J().x();
            c.a.p0.a.l1.e.g(x, new String[]{s.f53808g, s.f53809h}, 0, new g(this, x, str));
        }
    }

    public c.a.p0.a.k.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                c.a.p0.a.u.d.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.p0.a.u.d.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new c.a.p0.a.k.h.b(1001, "swan activity is null");
            }
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.u.d.c("WifiApi", "startWifi: 201 : callback is null");
                    return new c.a.p0.a.k.h.b(201, "callback is null");
                }
                c.a.p0.a.h2.l.c.d s2 = c.a.p0.a.h2.l.c.d.s(x);
                if (s2.n(f5633f) && s2.d(f5634g)) {
                    s2.p(new d(this, optString));
                    return c.a.p0.a.k.h.b.f();
                }
                c.a.p0.a.u.d.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new c.a.p0.a.k.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public c.a.p0.a.k.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                c.a.p0.a.u.d.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.p0.a.u.d.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new c.a.p0.a.k.h.b(1001, "swan activity is null");
            }
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.u.d.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new c.a.p0.a.k.h.b(201, "callback is null");
                }
                c.a.p0.a.h2.l.c.d s2 = c.a.p0.a.h2.l.c.d.s(x);
                if (s2.r(f5633f) && s2.b(f5634g)) {
                    s2.q(new e(this, optString));
                    return c.a.p0.a.k.h.b.f();
                }
                c.a.p0.a.u.d.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new c.a.p0.a.k.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
