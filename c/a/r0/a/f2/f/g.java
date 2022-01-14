package c.a.r0.a.f2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.z2.o0;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.u0;
import c.a.r0.q.j.m.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.r0.a.k0.a f5929c;

    /* renamed from: d  reason: collision with root package name */
    public static final c.a.r0.a.z2.g1.e<List<f.b>, List<String>> f5930d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f5931e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5932f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5933g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f5934h;

        public a(g gVar, JSONArray jSONArray, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, jSONArray, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5934h = gVar;
            this.f5931e = jSONArray;
            this.f5932f = unitedSchemeEntity;
            this.f5933g = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5934h.r(this.f5931e, this.f5932f, this.f5933g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5935e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5936f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f5937g;

        public b(g gVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5937g = gVar;
            this.f5935e = jSONObject;
            this.f5936f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5937g.v(this.f5935e, this.f5936f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5939f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f5940g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5941h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f5942i;

        public c(g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, unitedSchemeEntity, callbackHandler, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5942i = gVar;
            this.f5938e = unitedSchemeEntity;
            this.f5939f = callbackHandler;
            this.f5940g = jSONArray;
            this.f5941h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f5942i.t(iVar, this.f5938e, this.f5939f, this.f5940g, this.f5941h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f5943e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5944f;

        /* loaded from: classes.dex */
        public class a implements c.a.r0.q.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // c.a.r0.q.f.c
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                }
            }

            @Override // c.a.r0.q.f.c
            public void onResult(@Nullable Map<String, String> map) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) || map == null) {
                    return;
                }
                for (f.b bVar : this.a.f5943e) {
                    String b2 = bVar.b();
                    String str = map.get(b2);
                    if (!TextUtils.equals(b2, str)) {
                        bVar.f(str);
                    }
                }
                d dVar = this.a;
                c.a.r0.a.h0.c.a.b.a(dVar.f5943e, dVar.f5944f, null);
            }
        }

        public d(g gVar, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5943e = list;
            this.f5944f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.r0.q.k.j.b.e().g(!q0.G())) {
                    c.a.r0.a.h0.c.a.b.a(this.f5943e, this.f5944f, null);
                } else if (PMSConstants.a(c.a.r0.q.c.b())) {
                    c.a.r0.q.b.e((List) g.f5930d.a(this.f5943e), g.f5929c.c(), new a(this));
                } else {
                    c.a.r0.a.e0.d.c("DownloadPackagesAction", "STOP :: Not Support BDTLS");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements c.a.r0.a.z2.g1.e<List<f.b>, List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.e
        /* renamed from: b */
        public List<String> a(List<f.b> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                if (list == null) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (f.b bVar : list) {
                    arrayList.add(bVar.b());
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f5945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5946f;

        public f(g gVar, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5945e = list;
            this.f5946f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<String> h2 = c.a.r0.a.h0.m.s.a.h(this.f5945e);
                if (h2.isEmpty()) {
                    return;
                }
                c.a.r0.q.j.m.c cVar = new c.a.r0.q.j.m.c((Collection<String>) h2, (c.a.r0.q.p.b) u0.b());
                cVar.e(this.f5946f);
                cVar.d("1");
                c.a.r0.a.h0.m.d dVar = new c.a.r0.a.h0.m.d();
                dVar.M(5);
                c.a.r0.q.b.f(cVar, dVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-372744569, "Lc/a/r0/a/f2/f/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-372744569, "Lc/a/r0/a/f2/f/g;");
                return;
            }
        }
        f5930d = new e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/downloadPackages");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.r0.a.e0.d.i("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
                return false;
            } else if (!c.a.r0.a.h0.c.a.b.c(a2.optString("netconf", "0"))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
                return false;
            } else {
                JSONArray optJSONArray = a2.optJSONArray("pageList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    c.a.r0.a.z2.q.k(new a(this, optJSONArray, unitedSchemeEntity, callbackHandler), "DownloadPackagesAction");
                    return true;
                }
                JSONArray optJSONArray2 = a2.optJSONArray("appKeys");
                JSONObject optJSONObject = a2.optJSONObject("appList");
                if ((optJSONArray2 == null || optJSONArray2.length() == 0) && optJSONObject == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "appKeys must not empty");
                    return false;
                }
                String s = s(callbackHandler);
                if (!w(callbackHandler)) {
                    if (optJSONArray2 != null) {
                        u(optJSONArray2, s, false);
                    }
                    if (optJSONObject != null) {
                        c.a.r0.a.z2.q.j(new b(this, optJSONObject, s), "handlePreDownloadByCommand");
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                } else if (eVar == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                    return false;
                } else {
                    eVar.d0().g(context, "mapp_pre_download", new c(this, unitedSchemeEntity, callbackHandler, optJSONArray2, s));
                }
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONObject o(@NonNull JSONArray jSONArray, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, i2, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    try {
                        String optString = optJSONObject.optString("appKey");
                        if (!TextUtils.isEmpty(optString)) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                            JSONArray jSONArray2 = new JSONArray();
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    jSONArray2.put(p(optJSONArray.optString(i4), i2, str));
                                }
                            }
                            jSONObject.put(optString, jSONArray2);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    public final JSONObject p(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pageUrl", str);
                jSONObject.put("status", String.valueOf(i2));
                jSONObject.put("message", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    public final JSONObject q(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            return p(str, z ? 0 : 402, z ? "success" : "over single max limit");
        }
        return (JSONObject) invokeLZ.objValue;
    }

    @WorkerThread
    public final void r(@NonNull JSONArray jSONArray, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, jSONArray, unitedSchemeEntity, callbackHandler) == null) {
            JSONArray jSONArray2 = jSONArray;
            String a2 = c.a.r0.a.v.a.a(c.a.r0.a.d2.d.J().getAppId());
            if (TextUtils.isEmpty(a2)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(202, "runtime parameter error"));
                return;
            }
            c.a.r0.a.k0.a aVar = f5929c;
            if (aVar == null || !aVar.d(a2)) {
                f5929c = new c.a.r0.a.k0.a(a2, c.a.r0.q.k.i.t.a.a(a2));
            }
            if (f5929c.e()) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(o(jSONArray2, 402, "over max limit"), 402, "over max limit"));
            } else if (!f5929c.b()) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(o(jSONArray2, 402, "over time interval limit"), 402, "over time interval limit"));
            } else {
                JSONObject jSONObject = new JSONObject();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray2.optJSONObject(i3);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("appKey");
                        if (!TextUtils.isEmpty(optString)) {
                            f.b bVar = new f.b(optString);
                            JSONArray optJSONArray = optJSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                            JSONArray jSONArray3 = new JSONArray();
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                ArraySet arraySet = new ArraySet();
                                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    String f2 = o0.f(optJSONArray.optString(i4));
                                    if (!TextUtils.isEmpty(f2)) {
                                        if (f2.startsWith("/")) {
                                            f2 = f2.substring(1);
                                        }
                                        i2++;
                                        boolean a3 = f5929c.a(i2);
                                        if (a3) {
                                            arraySet.add(f2);
                                        }
                                        jSONArray3.put(q(optJSONArray.optString(i4), a3));
                                    }
                                }
                                bVar.l((String[]) arraySet.toArray(new String[0]));
                            }
                            if (jSONArray3.length() == 0) {
                                i2++;
                                boolean a4 = f5929c.a(i2);
                                jSONArray3.put(q("", a4));
                                if (a4) {
                                    arrayList.add(bVar);
                                }
                            } else if (!bVar.k()) {
                                arrayList.add(bVar);
                            }
                            int i5 = i2;
                            try {
                                jSONObject.put(optString, jSONArray3);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            i2 = i5;
                        }
                    }
                    i3++;
                    jSONArray2 = jSONArray;
                }
                if (arrayList.isEmpty()) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001, "over max limit"));
                    return;
                }
                x(s(callbackHandler), arrayList);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success"));
            }
        }
    }

    @NonNull
    public final String s(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, callbackHandler)) == null) ? y(callbackHandler) ? "10" : "2" : (String) invokeL.objValue;
    }

    public final void t(c.a.r0.a.h2.c.i<b.e> iVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, iVar, unitedSchemeEntity, callbackHandler, jSONArray, str) == null) {
            if (!c.a.r0.a.h2.c.d.h(iVar)) {
                c.a.r0.a.h2.c.d.p(iVar, callbackHandler, unitedSchemeEntity);
                return;
            }
            u(jSONArray, str, true);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void u(@Nullable JSONArray jSONArray, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048583, this, jSONArray, str, z) == null) || jSONArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optString(i2));
        }
        c.a.r0.a.z2.q.k(new f(this, arrayList, str), "小程序端能力-批量下载");
    }

    @AnyThread
    public final void v(@NonNull JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    f.b bVar = new f.b(next);
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("commands")) != null && optJSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            String optString = optJSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString)) {
                                try {
                                    Uri parse = Uri.parse(optString);
                                    if (parse != null) {
                                        arrayList2.add(o0.n(next, parse, false));
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            bVar.l((String[]) arrayList2.toArray(new String[arrayList2.size()]));
                        }
                    }
                    arrayList.add(bVar);
                }
            }
            c.a.r0.a.h0.c.a.b.a(arrayList, str, null);
        }
    }

    public final boolean w(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, callbackHandler)) == null) ? y(callbackHandler) : invokeL.booleanValue;
    }

    @WorkerThread
    public final void x(String str, List<f.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, list) == null) {
            d dVar = new d(this, list, str);
            long currentTimeMillis = System.currentTimeMillis() - Math.max(c.a.r0.a.u1.i.a, c.a.r0.a.u1.l.d.a());
            if (currentTimeMillis < 3000) {
                c.a.r0.a.z2.q.e(dVar, "DownloadPackagesAction", 3000 - currentTimeMillis, TimeUnit.MILLISECONDS);
            } else {
                dVar.run();
            }
        }
    }

    public final boolean y(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, callbackHandler)) == null) {
            if (callbackHandler instanceof TypedCallbackHandler) {
                int invokeSourceType = ((TypedCallbackHandler) callbackHandler).getInvokeSourceType();
                return invokeSourceType == 0 || invokeSourceType == 1;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
