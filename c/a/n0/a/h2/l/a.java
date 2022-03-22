package c.a.n0.a.h2.l;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.x1.c.j.b;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.n0.a.k.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> f4766f;

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>> f4767g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.h2.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0305a implements c.a.n0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h2.l.d.a f4768b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4769c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4770d;

        /* renamed from: c.a.n0.a.h2.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0306a implements c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C0305a a;

            public C0306a(C0305a c0305a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0305a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c0305a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.n0.a.u.d.i("WifiApi", "connectWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f4814b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f4815c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f4815c.n());
                        } catch (JSONException e2) {
                            c.a.n0.a.u.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f4814b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f4815c + "\n" + Log.getStackTraceString(e2));
                        }
                    }
                    C0305a c0305a = this.a;
                    c0305a.f4770d.d(c0305a.f4769c, jSONObject == null ? new c.a.n0.a.k.h.b(cVar.a, cVar.f4814b) : new c.a.n0.a.k.h.b(cVar.a, cVar.f4814b, jSONObject));
                }
            }
        }

        public C0305a(a aVar, Activity activity, c.a.n0.a.h2.l.d.a aVar2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, aVar2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4770d = aVar;
            this.a = activity;
            this.f4768b = aVar2;
            this.f4769c = str;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.n0.a.h2.l.c.d.s(this.a).a(this.f4768b, new C0306a(this));
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                c.a.n0.a.u.d.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.f4770d.d(this.f4769c, new c.a.n0.a.k.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f4815c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", cVar.f4815c);
            } catch (JSONException e2) {
                c.a.n0.a.u.d.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.n0.a.w0.f.U().u(new c.a.n0.a.e0.d.c("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f4815c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (c.a.n0.a.h2.l.d.b bVar : cVar.f4815c) {
                jSONArray.put(bVar);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e2) {
                c.a.n0.a.u.d.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.n0.a.w0.f.U().u(new c.a.n0.a.e0.d.c("getWifiList", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4771b;

        public d(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4771b = aVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.h2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.n0.a.u.d.i("WifiApi", "startWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f4814b);
                }
                this.f4771b.d(this.a, new c.a.n0.a.k.h.b(cVar.a, cVar.f4814b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4772b;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4772b = aVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.h2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.n0.a.u.d.i("WifiApi", "stopWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f4814b);
                }
                this.f4772b.d(this.a, new c.a.n0.a.k.h.b(cVar.a, cVar.f4814b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4773b;

        public f(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4773b = aVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f4773b.F(this.a);
                    return;
                }
                int b2 = iVar.b();
                c.a.n0.a.u.d.i("WifiApi", "getWifiList: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.n0.a.x1.c.d.f(b2));
                this.f4773b.d(this.a, new c.a.n0.a.k.h.b(b2, c.a.n0.a.x1.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.n0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4774b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4775c;

        /* renamed from: c.a.n0.a.h2.l.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0307a implements c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public C0307a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.n0.a.h2.l.d.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.n0.a.u.d.i("WifiApi", "getWifiList: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f4814b);
                    }
                    g gVar = this.a;
                    gVar.f4775c.d(gVar.f4774b, new c.a.n0.a.k.h.b(cVar.a, cVar.f4814b));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4775c = aVar;
            this.a = activity;
            this.f4774b = str;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.n0.a.h2.l.c.d.s(this.a).c(new C0307a(this));
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                c.a.n0.a.u.d.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.f4775c.d(this.f4774b, new c.a.n0.a.k.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4776b;

        public h(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4776b = aVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f4776b.E(this.a);
                    return;
                }
                int b2 = iVar.b();
                c.a.n0.a.u.d.i("WifiApi", "getConnectedWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.n0.a.x1.c.d.f(b2));
                this.f4776b.d(this.a, new c.a.n0.a.k.h.b(b2, c.a.n0.a.x1.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.n0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4777b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4778c;

        /* renamed from: c.a.n0.a.h2.l.a$i$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0308a implements c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public C0308a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.n0.a.u.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f4814b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f4815c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f4815c.n());
                        } catch (JSONException e2) {
                            c.a.n0.a.u.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f4814b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f4815c + "\n" + Log.getStackTraceString(e2));
                        }
                    }
                    i iVar = this.a;
                    iVar.f4778c.d(iVar.f4777b, jSONObject == null ? new c.a.n0.a.k.h.b(cVar.a, cVar.f4814b) : new c.a.n0.a.k.h.b(cVar.a, cVar.f4814b, jSONObject));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4778c = aVar;
            this.a = activity;
            this.f4777b = str;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.n0.a.h2.l.c.d.s(this.a).j(new C0308a(this));
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                c.a.n0.a.u.d.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.f4778c.d(this.f4777b, new c.a.n0.a.k.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h2.l.d.a f4779b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4780c;

        public j(a aVar, String str, c.a.n0.a.h2.l.d.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4780c = aVar;
            this.a = str;
            this.f4779b = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f4780c.D(this.a, this.f4779b);
                    return;
                }
                int b2 = iVar.b();
                c.a.n0.a.u.d.i("WifiApi", "connectWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.n0.a.x1.c.d.f(b2));
                this.f4780c.d(this.a, new c.a.n0.a.k.h.b(b2, c.a.n0.a.x1.c.d.f(b2)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(886110477, "Lc/a/n0/a/h2/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(886110477, "Lc/a/n0/a/h2/l/a;");
                return;
            }
        }
        f4766f = new b();
        f4767g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.n0.a.k.c.b bVar) {
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
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public c.a.n0.a.k.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.u.d.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.n0.a.u.d.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new c.a.n0.a.k.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
                c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
                if (bVar.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.n0.a.u.d.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new c.a.n0.a.k.h.b(201, "callback is null");
                    }
                    c.a.n0.a.h2.l.d.a a = c.a.n0.a.h2.l.d.a.a(jSONObject);
                    if (TextUtils.isEmpty(a.a)) {
                        c.a.n0.a.u.d.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new c.a.n0.a.k.h.b(12008, "invalid ssid");
                    } else if (a0.m0()) {
                        c.a.n0.a.u.d.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new c.a.n0.a.k.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new j(this, optString, a));
                        return c.a.n0.a.k.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.u.d.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.n0.a.u.d.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new c.a.n0.a.k.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
                c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.n0.a.u.d.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new c.a.n0.a.k.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.n0.a.u.d.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new c.a.n0.a.k.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new h(this, optString));
                        return c.a.n0.a.k.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.u.d.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.n0.a.u.d.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new c.a.n0.a.k.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
                c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.n0.a.u.d.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new c.a.n0.a.k.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.n0.a.u.d.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new c.a.n0.a.k.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new f(this, optString));
                        return c.a.n0.a.k.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public final void D(String str, c.a.n0.a.h2.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            SwanAppActivity x = c.a.n0.a.t1.d.J().x();
            c.a.n0.a.l1.e.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new C0305a(this, x, aVar, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity x = c.a.n0.a.t1.d.J().x();
            c.a.n0.a.l1.e.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new i(this, x, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity x = c.a.n0.a.t1.d.J().x();
            c.a.n0.a.l1.e.g(x, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new g(this, x, str));
        }
    }

    public c.a.n0.a.k.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.u.d.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.n0.a.u.d.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new c.a.n0.a.k.h.b(1001, "swan activity is null");
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.u.d.c("WifiApi", "startWifi: 201 : callback is null");
                    return new c.a.n0.a.k.h.b(201, "callback is null");
                }
                c.a.n0.a.h2.l.c.d s2 = c.a.n0.a.h2.l.c.d.s(x);
                if (s2.n(f4766f) && s2.d(f4767g)) {
                    s2.p(new d(this, optString));
                    return c.a.n0.a.k.h.b.f();
                }
                c.a.n0.a.u.d.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new c.a.n0.a.k.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.u.d.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.n0.a.u.d.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new c.a.n0.a.k.h.b(1001, "swan activity is null");
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.u.d.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new c.a.n0.a.k.h.b(201, "callback is null");
                }
                c.a.n0.a.h2.l.c.d s2 = c.a.n0.a.h2.l.c.d.s(x);
                if (s2.r(f4766f) && s2.b(f4767g)) {
                    s2.q(new e(this, optString));
                    return c.a.n0.a.k.h.b.f();
                }
                c.a.n0.a.u.d.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new c.a.n0.a.k.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
