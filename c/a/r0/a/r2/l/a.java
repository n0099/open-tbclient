package c.a.r0.a.r2.l;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h2.c.j.b;
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
public class a extends c.a.r0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> f8858f;

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>> f8859g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.r2.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0531a implements c.a.r0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f8860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r2.l.d.a f8861f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8862g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8863h;

        /* renamed from: c.a.r0.a.r2.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0532a implements c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0531a f8864e;

            public C0532a(C0531a c0531a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0531a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8864e = c0531a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.r0.a.e0.d.i("WifiApi", "connectWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8924b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f8925c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f8925c.n());
                        } catch (JSONException e2) {
                            c.a.r0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8924b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8925c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    C0531a c0531a = this.f8864e;
                    c0531a.f8863h.d(c0531a.f8862g, jSONObject == null ? new c.a.r0.a.u.h.b(cVar.a, cVar.f8924b) : new c.a.r0.a.u.h.b(cVar.a, cVar.f8924b, jSONObject));
                }
            }
        }

        public C0531a(a aVar, Activity activity, c.a.r0.a.r2.l.d.a aVar2, String str) {
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
            this.f8863h = aVar;
            this.f8860e = activity;
            this.f8861f = aVar2;
            this.f8862g = str;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.r0.a.r2.l.c.d.s(this.f8860e).a(this.f8861f, new C0532a(this));
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.r0.a.e0.d.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.f8863h.d(this.f8862g, new c.a.r0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> {
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
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f8925c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", cVar.f8925c);
            } catch (JSONException e2) {
                c.a.r0.a.e0.d.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.r0.a.g1.f.U().u(new c.a.r0.a.o0.d.c("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>> {
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
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a != 0 || cVar.f8925c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (c.a.r0.a.r2.l.d.b bVar : cVar.f8925c) {
                jSONArray.put(bVar);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e2) {
                c.a.r0.a.e0.d.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            c.a.r0.a.g1.f.U().u(new c.a.r0.a.o0.d.c("getWifiList", hashMap));
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8866f;

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
            this.f8866f = aVar;
            this.f8865e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.r2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.r0.a.e0.d.i("WifiApi", "startWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8924b);
                }
                this.f8866f.d(this.f8865e, new c.a.r0.a.u.h.b(cVar.a, cVar.f8924b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8867e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8868f;

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
            this.f8868f = aVar;
            this.f8867e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.r2.l.d.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (cVar.a != 0) {
                    c.a.r0.a.e0.d.i("WifiApi", "stopWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8924b);
                }
                this.f8868f.d(this.f8867e, new c.a.r0.a.u.h.b(cVar.a, cVar.f8924b));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8869e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8870f;

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
            this.f8870f = aVar;
            this.f8869e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.f8870f.F(this.f8869e);
                    return;
                }
                int b2 = iVar.b();
                c.a.r0.a.e0.d.i("WifiApi", "getWifiList: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.r0.a.h2.c.d.f(b2));
                this.f8870f.d(this.f8869e, new c.a.r0.a.u.h.b(b2, c.a.r0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.r0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f8871e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8872f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8873g;

        /* renamed from: c.a.r0.a.r2.l.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0533a implements c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f8874e;

            public C0533a(g gVar) {
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
                this.f8874e = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.r0.a.r2.l.d.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.r0.a.e0.d.i("WifiApi", "getWifiList: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8924b);
                    }
                    g gVar = this.f8874e;
                    gVar.f8873g.d(gVar.f8872f, new c.a.r0.a.u.h.b(cVar.a, cVar.f8924b));
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
            this.f8873g = aVar;
            this.f8871e = activity;
            this.f8872f = str;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.r0.a.r2.l.c.d.s(this.f8871e).c(new C0533a(this));
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.r0.a.e0.d.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.f8873g.d(this.f8872f, new c.a.r0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8876f;

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
            this.f8876f = aVar;
            this.f8875e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.f8876f.E(this.f8875e);
                    return;
                }
                int b2 = iVar.b();
                c.a.r0.a.e0.d.i("WifiApi", "getConnectedWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.r0.a.h2.c.d.f(b2));
                this.f8876f.d(this.f8875e, new c.a.r0.a.u.h.b(b2, c.a.r0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.r0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f8877e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8878f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8879g;

        /* renamed from: c.a.r0.a.r2.l.a$i$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0534a implements c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f8880e;

            public C0534a(i iVar) {
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
                this.f8880e = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    if (cVar.a != 0) {
                        c.a.r0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8924b);
                    }
                    JSONObject jSONObject = null;
                    if (cVar.f8925c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cVar.f8925c.n());
                        } catch (JSONException e2) {
                            c.a.r0.a.e0.d.i("WifiApi", "getConnectedWifi: " + cVar.a + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8924b + ZeusCrashHandler.NAME_SEPERATOR + cVar.f8925c + StringUtils.LF + Log.getStackTraceString(e2));
                        }
                    }
                    i iVar = this.f8880e;
                    iVar.f8879g.d(iVar.f8878f, jSONObject == null ? new c.a.r0.a.u.h.b(cVar.a, cVar.f8924b) : new c.a.r0.a.u.h.b(cVar.a, cVar.f8924b, jSONObject));
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
            this.f8879g = aVar;
            this.f8877e = activity;
            this.f8878f = str;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.r0.a.r2.l.c.d.s(this.f8877e).j(new C0534a(this));
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.r0.a.e0.d.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.f8879g.d(this.f8878f, new c.a.r0.a.u.h.b(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8881e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r2.l.d.a f8882f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8883g;

        public j(a aVar, String str, c.a.r0.a.r2.l.d.a aVar2) {
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
            this.f8883g = aVar;
            this.f8881e = str;
            this.f8882f = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.f8883g.D(this.f8881e, this.f8882f);
                    return;
                }
                int b2 = iVar.b();
                c.a.r0.a.e0.d.i("WifiApi", "connectWifi: " + b2 + ZeusCrashHandler.NAME_SEPERATOR + c.a.r0.a.h2.c.d.f(b2));
                this.f8883g.d(this.f8881e, new c.a.r0.a.u.h.b(b2, c.a.r0.a.h2.c.d.f(b2)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1687543571, "Lc/a/r0/a/r2/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1687543571, "Lc/a/r0/a/r2/l/a;");
                return;
            }
        }
        f8858f = new b();
        f8859g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.r0.a.u.c.b bVar) {
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
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public c.a.r0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                c.a.r0.a.e0.d.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.r0.a.e0.d.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new c.a.r0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
                c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.r0.a.e0.d.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new c.a.r0.a.u.h.b(201, "callback is null");
                    }
                    c.a.r0.a.r2.l.d.a a = c.a.r0.a.r2.l.d.a.a(jSONObject);
                    if (TextUtils.isEmpty(a.a)) {
                        c.a.r0.a.e0.d.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new c.a.r0.a.u.h.b(12008, "invalid ssid");
                    } else if (a0.m0()) {
                        c.a.r0.a.e0.d.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new c.a.r0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new j(this, optString, a));
                        return c.a.r0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public c.a.r0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                c.a.r0.a.e0.d.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.r0.a.e0.d.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new c.a.r0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
                c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.r0.a.e0.d.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new c.a.r0.a.u.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.r0.a.e0.d.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new c.a.r0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new h(this, optString));
                        return c.a.r0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public c.a.r0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                c.a.r0.a.e0.d.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.r0.a.e0.d.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new c.a.r0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
                c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        c.a.r0.a.e0.d.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new c.a.r0.a.u.h.b(201, "callback is null");
                    } else if (a0.m0()) {
                        c.a.r0.a.e0.d.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new c.a.r0.a.u.h.b(12011, "app is invisible");
                    } else {
                        a0.d0().g(getContext(), "mapp_location", new f(this, optString));
                        return c.a.r0.a.u.h.b.f();
                    }
                }
                return bVar;
            }
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public final void D(String str, c.a.r0.a.r2.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            SwanAppActivity x = c.a.r0.a.d2.d.J().x();
            c.a.r0.a.v1.e.g(x, new String[]{s.f57423g, s.f57424h}, 0, new C0531a(this, x, aVar, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity x = c.a.r0.a.d2.d.J().x();
            c.a.r0.a.v1.e.g(x, new String[]{s.f57423g, s.f57424h}, 0, new i(this, x, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity x = c.a.r0.a.d2.d.J().x();
            c.a.r0.a.v1.e.g(x, new String[]{s.f57423g, s.f57424h}, 0, new g(this, x, str));
        }
    }

    public c.a.r0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                c.a.r0.a.e0.d.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.r0.a.e0.d.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new c.a.r0.a.u.h.b(1001, "swan activity is null");
            }
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.r0.a.e0.d.c("WifiApi", "startWifi: 201 : callback is null");
                    return new c.a.r0.a.u.h.b(201, "callback is null");
                }
                c.a.r0.a.r2.l.c.d s2 = c.a.r0.a.r2.l.c.d.s(x);
                if (s2.n(f8858f) && s2.d(f8859g)) {
                    s2.p(new d(this, optString));
                    return c.a.r0.a.u.h.b.f();
                }
                c.a.r0.a.e0.d.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new c.a.r0.a.u.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public c.a.r0.a.u.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                c.a.r0.a.e0.d.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.r0.a.e0.d.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new c.a.r0.a.u.h.b(1001, "swan activity is null");
            }
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.r0.a.e0.d.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new c.a.r0.a.u.h.b(201, "callback is null");
                }
                c.a.r0.a.r2.l.c.d s2 = c.a.r0.a.r2.l.c.d.s(x);
                if (s2.r(f8858f) && s2.b(f8859g)) {
                    s2.q(new e(this, optString));
                    return c.a.r0.a.u.h.b.f();
                }
                c.a.r0.a.e0.d.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new c.a.r0.a.u.h.b(12010, "unknown failed");
            }
            return bVar;
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
