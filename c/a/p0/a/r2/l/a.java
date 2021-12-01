package c.a.p0.a.r2.l;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h2.c.j.b;
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
public class a extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> f7814f;

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>> f7815g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.r2.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0447a implements c.a.p0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r2.l.d.a f7817f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7818g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7819h;

        /* renamed from: c.a.p0.a.r2.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0448a implements c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0447a f7820e;

            public C0448a(C0447a c0447a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0447a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7820e = c0447a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.p0.a.e0.d.i("WifiApi", "connectWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f7880b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f7881c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f7881c.n());
                        } catch (JSONException e2) {
                            c.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f7880b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f7881c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    C0447a c0447a = this.f7820e;
                    c0447a.f7819h.d(c0447a.f7818g, jSONObject == null ? new c.a.p0.a.u.h.b(cVar.a, cVar.f7880b) : new c.a.p0.a.u.h.b(cVar.a, cVar.f7880b, jSONObject));
                }
            }
        }

        public C0447a(a aVar, Activity activity, c.a.p0.a.r2.l.d.a aVar2, String str) {
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
            this.f7819h = aVar;
            this.f7816e = activity;
            this.f7817f = aVar2;
            this.f7818g = str;
        }

        @Override // c.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.r2.l.c.d.s(this.f7816e).a(this.f7817f, new C0448a(this));
            }
        }

        @Override // c.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.p0.a.e0.d.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.f7819h.d(this.f7818g, new c.a.p0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> {
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
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f7881c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", cVar.f7881c);
            } catch (JSONException e2) {
                c.a.p0.a.e0.d.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.p0.a.g1.f.U().u(new c.a.p0.a.o0.d.c("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>> {
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
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f7881c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (c.a.p0.a.r2.l.d.b bVar : cVar.f7881c) {
                jSONArray.put(bVar);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e2) {
                c.a.p0.a.e0.d.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.p0.a.g1.f.U().u(new c.a.p0.a.o0.d.c("getWifiList", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7821e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7822f;

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
            this.f7822f = aVar;
            this.f7821e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.r2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.p0.a.e0.d.i("WifiApi", "startWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f7880b);
                }
                this.f7822f.d(this.f7821e, new c.a.p0.a.u.h.b(cVar.a, cVar.f7880b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7823e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7824f;

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
            this.f7824f = aVar;
            this.f7823e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.r2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.p0.a.e0.d.i("WifiApi", "stopWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f7880b);
                }
                this.f7824f.d(this.f7823e, new c.a.p0.a.u.h.b(cVar.a, cVar.f7880b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7825e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7826f;

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
            this.f7826f = aVar;
            this.f7825e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.h2.c.d.h(iVar)) {
                    this.f7826f.F(this.f7825e);
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.e0.d.i("WifiApi", "getWifiList: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.p0.a.h2.c.d.f(b2));
                this.f7826f.d(this.f7825e, new c.a.p0.a.u.h.b(b2, c.a.p0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.p0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7827e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7828f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7829g;

        /* renamed from: c.a.p0.a.r2.l.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0449a implements c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f7830e;

            public C0449a(g gVar) {
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
                this.f7830e = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.p0.a.r2.l.d.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.p0.a.e0.d.i("WifiApi", "getWifiList: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f7880b);
                    }
                    g gVar = this.f7830e;
                    gVar.f7829g.d(gVar.f7828f, new c.a.p0.a.u.h.b(cVar.a, cVar.f7880b));
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
            this.f7829g = aVar;
            this.f7827e = activity;
            this.f7828f = str;
        }

        @Override // c.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.r2.l.c.d.s(this.f7827e).c(new C0449a(this));
            }
        }

        @Override // c.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.p0.a.e0.d.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.f7829g.d(this.f7828f, new c.a.p0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7832f;

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
            this.f7832f = aVar;
            this.f7831e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.h2.c.d.h(iVar)) {
                    this.f7832f.E(this.f7831e);
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.p0.a.h2.c.d.f(b2));
                this.f7832f.d(this.f7831e, new c.a.p0.a.u.h.b(b2, c.a.p0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.p0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f7833e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7834f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7835g;

        /* renamed from: c.a.p0.a.r2.l.a$i$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0450a implements c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f7836e;

            public C0450a(i iVar) {
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
                this.f7836e = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f7880b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f7881c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f7881c.n());
                        } catch (JSONException e2) {
                            c.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f7880b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f7881c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    i iVar = this.f7836e;
                    iVar.f7835g.d(iVar.f7834f, jSONObject == null ? new c.a.p0.a.u.h.b(cVar.a, cVar.f7880b) : new c.a.p0.a.u.h.b(cVar.a, cVar.f7880b, jSONObject));
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
            this.f7835g = aVar;
            this.f7833e = activity;
            this.f7834f = str;
        }

        @Override // c.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.r2.l.c.d.s(this.f7833e).j(new C0450a(this));
            }
        }

        @Override // c.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.f7835g.d(this.f7834f, new c.a.p0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r2.l.d.a f7838f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7839g;

        public j(a aVar, String str, c.a.p0.a.r2.l.d.a aVar2) {
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
            this.f7839g = aVar;
            this.f7837e = str;
            this.f7838f = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.h2.c.d.h(iVar)) {
                    this.f7839g.D(this.f7837e, this.f7838f);
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.e0.d.i("WifiApi", "connectWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.p0.a.h2.c.d.f(b2));
                this.f7839g.d(this.f7837e, new c.a.p0.a.u.h.b(b2, c.a.p0.a.h2.c.d.f(b2)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1429378133, "Lc/a/p0/a/r2/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1429378133, "Lc/a/p0/a/r2/l/a;");
                return;
            }
        }
        f7814f = new b();
        f7815g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.u.c.b bVar) {
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
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public c.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
            if (a0 == null) {
                c.a.p0.a.e0.d.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new c.a.p0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.p0.a.e0.d.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new c.a.p0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
                c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.p0.a.e0.d.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new c.a.p0.a.u.h.b(201, "callback is null");
                    }
                    c.a.p0.a.r2.l.d.a a = c.a.p0.a.r2.l.d.a.a(jSONObject);
                    if (TextUtils.isEmpty(a.a)) {
                        c.a.p0.a.e0.d.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new c.a.p0.a.u.h.b(12008, "invalid ssid");
                    } else if (a0.m0()) {
                        c.a.p0.a.e0.d.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new c.a.p0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new j(this, optString, a));
                        return c.a.p0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
            if (a0 == null) {
                c.a.p0.a.e0.d.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new c.a.p0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.p0.a.e0.d.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new c.a.p0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
                c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.p0.a.e0.d.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new c.a.p0.a.u.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.p0.a.e0.d.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new c.a.p0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new h(this, optString));
                        return c.a.p0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
            if (a0 == null) {
                c.a.p0.a.e0.d.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new c.a.p0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.p0.a.e0.d.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new c.a.p0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
                c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.p0.a.e0.d.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new c.a.p0.a.u.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.p0.a.e0.d.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new c.a.p0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new f(this, optString));
                        return c.a.p0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void D(String str, c.a.p0.a.r2.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            SwanAppActivity x = c.a.p0.a.d2.d.J().x();
            c.a.p0.a.v1.e.g(x, new String[]{s.f56842g, s.f56843h}, 0, new C0447a(this, x, aVar, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity x = c.a.p0.a.d2.d.J().x();
            c.a.p0.a.v1.e.g(x, new String[]{s.f56842g, s.f56843h}, 0, new i(this, x, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity x = c.a.p0.a.d2.d.J().x();
            c.a.p0.a.v1.e.g(x, new String[]{s.f56842g, s.f56843h}, 0, new g(this, x, str));
        }
    }

    public c.a.p0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
            if (a0 == null) {
                c.a.p0.a.e0.d.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new c.a.p0.a.u.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.p0.a.e0.d.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new c.a.p0.a.u.h.b(1001, "swan activity is null");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.e0.d.c("WifiApi", "startWifi: 201 : callback is null");
                    return new c.a.p0.a.u.h.b(201, "callback is null");
                }
                c.a.p0.a.r2.l.c.d s2 = c.a.p0.a.r2.l.c.d.s(x);
                if (s2.n(f7814f) && s2.d(f7815g)) {
                    s2.p(new d(this, optString));
                    return c.a.p0.a.u.h.b.f();
                }
                c.a.p0.a.e0.d.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new c.a.p0.a.u.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
            if (a0 == null) {
                c.a.p0.a.e0.d.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new c.a.p0.a.u.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.p0.a.e0.d.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new c.a.p0.a.u.h.b(1001, "swan activity is null");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.e0.d.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new c.a.p0.a.u.h.b(201, "callback is null");
                }
                c.a.p0.a.r2.l.c.d s2 = c.a.p0.a.r2.l.c.d.s(x);
                if (s2.r(f7814f) && s2.b(f7815g)) {
                    s2.q(new e(this, optString));
                    return c.a.p0.a.u.h.b.f();
                }
                c.a.p0.a.e0.d.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new c.a.p0.a.u.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
