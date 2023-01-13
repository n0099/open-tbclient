package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.a22;
import com.baidu.tieba.b53;
import com.baidu.tieba.b83;
import com.baidu.tieba.bi3;
import com.baidu.tieba.d03;
import com.baidu.tieba.f03;
import com.baidu.tieba.gp2;
import com.baidu.tieba.h03;
import com.baidu.tieba.i03;
import com.baidu.tieba.j43;
import com.baidu.tieba.kd4;
import com.baidu.tieba.lw1;
import com.baidu.tieba.nk4;
import com.baidu.tieba.on2;
import com.baidu.tieba.pn2;
import com.baidu.tieba.qn2;
import com.baidu.tieba.qz2;
import com.baidu.tieba.tk1;
import com.baidu.tieba.u43;
import com.baidu.tieba.w22;
import com.baidu.tieba.w43;
import com.baidu.tieba.wp2;
import com.baidu.tieba.x43;
import com.baidu.tieba.y43;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yy.hiidostatis.defs.controller.SensorController;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppConfigData {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public static final x43<SwanAppConfigData> w;
    public static final w43<SwanAppConfigData> x;
    public static final HashMap<String, Integer> y;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public e b;
    public l c;
    public m d;
    public y43 e;
    public n f;
    public j g;
    public u43.a h;
    public g i;
    public g j;
    public d k;
    public List<kd4> l;
    public String m;
    public String n;
    public i o;
    public f p;
    @NonNull
    public List<String> q;
    public c r;
    public p s;
    public h t;
    public boolean u;

    /* loaded from: classes3.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static final x43<f> b;
        public static final w43<f> c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, Map<String, String>> a;

        /* loaded from: classes3.dex */
        public static class a extends x43<f> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.swan.apps.runtime.config.SwanAppConfigData$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0200a extends x43<Map<String, String>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C0200a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
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
                @Override // com.baidu.tieba.x43
                /* renamed from: b */
                public void a(@NonNull Map<String, String> map, @NonNull pn2 pn2Var) throws Exception {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, pn2Var) == null) {
                        pn2Var.h(map);
                    }
                }
            }

            public a() {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull f fVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, pn2Var) == null) {
                    pn2Var.e(fVar.a, new C0200a(this));
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends w43<f> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* loaded from: classes3.dex */
            public class a extends w43<Map<String, String>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
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
                @Override // com.baidu.tieba.w43
                /* renamed from: b */
                public Map<String, String> a(@NonNull on2 on2Var) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                        return on2Var.l();
                    }
                    return (Map) invokeL.objValue;
                }
            }

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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public f a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    Map<String, Map<String, String>> f = on2Var.f(new a(this));
                    if (f == null) {
                        return f.b();
                    }
                    f fVar = new f();
                    fVar.a = f;
                    return fVar;
                }
                return (f) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927578, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927578, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$f;");
                    return;
                }
            }
            b = new a();
            c = new b();
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static /* synthetic */ f b() {
            return d();
        }

        public static f d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                f fVar = new f();
                fVar.a = new HashMap();
                return fVar;
            }
            return (f) invokeV.objValue;
        }

        public static f c(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
                f d = d();
                if (jSONObject == null) {
                    return d;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
                if (optJSONObject == null) {
                    return null;
                }
                d.a = new HashMap();
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                    HashMap hashMap = new HashMap();
                    if (optJSONObject2 != null) {
                        Iterator<String> keys2 = optJSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            hashMap.put(next2, optJSONObject2.optString(next2));
                        }
                    }
                    d.a.put(next, hashMap);
                }
                return d;
            }
            return (f) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final w43<c> b;
        public static final x43<c> c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* loaded from: classes3.dex */
        public static class a extends w43<c> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public c a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    c cVar = new c();
                    cVar.a = on2Var.readBoolean();
                    return cVar;
                }
                return (c) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends x43<c> {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull c cVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, pn2Var) == null) {
                    pn2Var.writeBoolean(cVar.a);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927671, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927671, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$c;");
                    return;
                }
            }
            b = new a();
            c = new b();
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static c b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                c cVar = new c();
                if (jSONObject == null) {
                    return cVar;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("cookie");
                if (optJSONObject == null) {
                    return cVar;
                }
                cVar.a = optJSONObject.optBoolean("enableStore");
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final x43<d> b;
        public static final w43<d> c;
        public transient /* synthetic */ FieldHolder $fh;
        public List<d03> a;

        /* loaded from: classes3.dex */
        public static class a extends x43<d> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull d dVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, pn2Var) == null) {
                    pn2Var.d(dVar.a, d03.l);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends w43<d> {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public d a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    List<d03> e = on2Var.e(d03.k);
                    if (e == null) {
                        return null;
                    }
                    d dVar = new d();
                    dVar.a = e;
                    return dVar;
                }
                return (d) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927640, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927640, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$d;");
                    return;
                }
            }
            b = new a();
            c = new b();
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static d a(JSONObject jSONObject, File file) {
            InterceptResult invokeLL;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, file)) == null) {
                if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("dependencies")) == null) {
                    return null;
                }
                Iterator<String> keys = optJSONObject.keys();
                d dVar = new d();
                dVar.a = new ArrayList();
                while (keys.hasNext()) {
                    String next = keys.next();
                    d03 d03Var = new d03(optJSONObject.optJSONObject(next), next);
                    if (file != null && !TextUtils.isEmpty(d03Var.e)) {
                        d03Var.e = new File(file, d03Var.e).getAbsolutePath();
                    }
                    dVar.a.add(d03Var);
                }
                return dVar;
            }
            return (d) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static final w43<e> b;
        public static final x43<e> c;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;

        /* loaded from: classes3.dex */
        public static class a extends w43<e> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public e a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    e eVar = new e();
                    eVar.a = on2Var.k(Collections.emptyList());
                    return eVar;
                }
                return (e) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends x43<e> {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull e eVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, pn2Var) == null) {
                    pn2Var.g(eVar.a);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927609, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927609, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$e;");
                    return;
                }
            }
            b = new a();
            c = new b();
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static e d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (SwanAppConfigData.v) {
                    Log.w("SwanAppConfigData", "PageConfig createNullObject()");
                }
                e eVar = new e();
                eVar.a = new ArrayList();
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                List<String> list = this.a;
                if (list != null && list.contains(str)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public static e b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return d();
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                if (optJSONArray == null) {
                    return d();
                }
                e eVar = new e();
                eVar.a = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    eVar.a.add(optJSONArray.optString(i));
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public static final x43<g> b;
        public static final w43<g> c;
        public transient /* synthetic */ FieldHolder $fh;
        public List<f03> a;

        /* loaded from: classes3.dex */
        public static class a extends x43<g> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull g gVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, pn2Var) == null) {
                    pn2Var.d(gVar.a, f03.i);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends w43<g> {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public g a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    List<f03> e = on2Var.e(f03.h);
                    if (e == null) {
                        return null;
                    }
                    g gVar = new g();
                    gVar.a = e;
                    return gVar;
                }
                return (g) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927547, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927547, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$g;");
                    return;
                }
            }
            b = new a();
            c = new b();
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static g c(JSONObject jSONObject, File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, file)) == null) {
                return e(jSONObject, "dynamicLib", 3, file);
            }
            return (g) invokeLL.objValue;
        }

        public static g d(JSONObject jSONObject, File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, file)) == null) {
                return e(jSONObject, "plugins", 4, file);
            }
            return (g) invokeLL.objValue;
        }

        public static g e(JSONObject jSONObject, String str, int i, File file) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65542, null, jSONObject, str, i, file)) == null) {
                g gVar = null;
                if (jSONObject != null && !TextUtils.isEmpty(str)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(str);
                    if (optJSONObject == null) {
                        return null;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    gVar = new g();
                    gVar.a = new ArrayList();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        f03 f03Var = new f03(optJSONObject.optJSONObject(next), i);
                        f03Var.g = next;
                        if (file != null && !TextUtils.isEmpty(f03Var.e)) {
                            f03Var.e = new File(file, f03Var.e).getAbsolutePath();
                        }
                        gVar.a.add(f03Var);
                    }
                }
                return gVar;
            }
            return (g) invokeLLIL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public static final w43<h> c;
        public static final x43<h> d;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final String b;

        /* loaded from: classes3.dex */
        public static class a extends w43<h> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public h a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    return new h(on2Var.readBoolean(), on2Var.g());
                }
                return (h) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends x43<h> {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull h hVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, pn2Var) == null) {
                    pn2Var.writeBoolean(hVar.a);
                    pn2Var.f(hVar.b);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927516, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927516, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$h;");
                    return;
                }
            }
            c = new a();
            d = new b();
        }

        public h(boolean z, @Nullable String str) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = z;
            if (!TextUtils.equals(str, "click") && !TextUtils.equals(str, "show")) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.b = z2 ? str : "click";
        }

        public static h a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject != null && jSONObject.has(PrefetchEvent.MODULE)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(PrefetchEvent.MODULE);
                    if (optJSONObject != null && optJSONObject.has(SapiOptions.KEY_CACHE_ENABLED)) {
                        boolean equals = TextUtils.equals("true", optJSONObject.optString(SapiOptions.KEY_CACHE_ENABLED));
                        String optString = optJSONObject.optString("trigger");
                        if (SwanAppConfigData.v) {
                            Log.d("SwanAppConfigData", "prefetch is on from app.json - " + optJSONObject);
                            Log.d("SwanAppConfigData", "prefetch trigger from app.json - " + optString);
                        }
                        return new h(equals, optString);
                    }
                    return new h(false, null);
                }
                return new h(false, null);
            }
            return (h) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public static final w43<i> b;
        public static final x43<i> c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> a;

        /* loaded from: classes3.dex */
        public static class a extends w43<i> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public i a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    Map<String, String> l = on2Var.l();
                    if (l == null) {
                        return i.a();
                    }
                    i iVar = new i();
                    iVar.a = l;
                    return iVar;
                }
                return (i) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends x43<i> {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull i iVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, pn2Var) == null) {
                    pn2Var.h(iVar.a);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927485, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927485, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$i;");
                    return;
                }
            }
            b = new a();
            c = new b();
        }

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static /* synthetic */ i a() {
            return d();
        }

        public static i d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                i iVar = new i();
                iVar.a = new HashMap();
                return iVar;
            }
            return (i) invokeV.objValue;
        }

        public static i c(JSONObject jSONObject) {
            InterceptResult invokeL;
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
                i d = d();
                if (jSONObject == null) {
                    return d;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("routes");
                if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("path");
                            String optString2 = optJSONObject.optString("page");
                            if (!d.a.containsKey(optString)) {
                                d.a.put(optString, optString2);
                            }
                        }
                    }
                }
                return d;
            }
            return (i) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public static final x43<j> b;
        public static final w43<j> c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* loaded from: classes3.dex */
        public static class a extends x43<j> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull j jVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, pn2Var) == null) {
                    pn2Var.writeBoolean(jVar.a);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends w43<j> {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public j a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    j jVar = new j();
                    jVar.a = on2Var.readBoolean();
                    return jVar;
                }
                return (j) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927454, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927454, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$j;");
                    return;
                }
            }
            b = new a();
            c = new b();
        }

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static j c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (SwanAppConfigData.v) {
                    Log.w("SwanAppConfigData", "SettingConfig createNullObject()");
                }
                j jVar = new j();
                jVar.a = true;
                return jVar;
            }
            return (j) invokeV.objValue;
        }

        public static j b(JSONObject jSONObject) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.s);
                if (optJSONObject == null) {
                    return c();
                }
                j43 M = j43.M();
                if (M == null) {
                    str = "";
                } else {
                    str = M.b;
                }
                j jVar = new j();
                jVar.a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
                if (optJSONObject2 != null) {
                    b53.u(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                    if (optJSONObject3 != null) {
                        b53.s(str, optJSONObject3);
                    }
                }
                return jVar;
            }
            return (j) invokeL.objValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                SwanAppConfigData s = wp2.U().s();
                if (s == null) {
                    return true;
                }
                j jVar = s.g;
                j43 M = j43.M();
                gp2.a aVar = null;
                if (M != null) {
                    aVar = M.Y();
                }
                boolean d = lw1.d(aVar);
                boolean d2 = a22.d();
                boolean d3 = w22.d();
                boolean H = i03.H();
                boolean D = i03.D();
                if (SwanAppConfigData.v) {
                    Log.d("SwanAppConfigData", "isDevelop: " + d + " isRemoteDebug: " + d2 + " isMobileDebug: " + d3 + " urlCheck: " + jVar.a);
                }
                if ((d || d2 || d3 || H || D) && !jVar.a) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public static final String d;
        public static final w43<k> e;
        public static final x43<k> f;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public List<String> b;
        public boolean c;

        /* loaded from: classes3.dex */
        public static class a extends w43<k> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public k a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    k kVar = new k();
                    kVar.a = on2Var.g();
                    kVar.b = on2Var.k(Collections.emptyList());
                    kVar.c = on2Var.readBoolean();
                    return kVar;
                }
                return (k) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends x43<k> {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull k kVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar, pn2Var) == null) {
                    pn2Var.f(kVar.a);
                    pn2Var.g(kVar.b);
                    pn2Var.writeBoolean(kVar.c);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927423, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$k;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927423, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$k;");
                    return;
                }
            }
            d = File.separator;
            e = new a();
            f = new b();
        }

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = false;
        }

        public static k d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                k kVar = new k();
                kVar.b = new ArrayList();
                return kVar;
            }
            return (k) invokeV.objValue;
        }

        public static k c(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2, File file) {
            InterceptResult invokeLLLL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, map, map2, file)) == null) {
                if (jSONObject != null && map != null) {
                    k kVar = new k();
                    kVar.a = jSONObject.optString("root");
                    kVar.c = jSONObject.optBoolean("independent");
                    JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        kVar.b = new ArrayList();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray.optString(i);
                            kVar.b.add(optString);
                            if (!TextUtils.isEmpty(kVar.a) && !TextUtils.isEmpty(optString)) {
                                if (!kVar.a.endsWith(d) && !optString.startsWith(d)) {
                                    str = kVar.a + d + optString;
                                } else {
                                    str = kVar.a + optString;
                                }
                                map.put(str, kVar.a);
                                if (kVar.c) {
                                    map2.put(str, kVar.a);
                                }
                            }
                        }
                    }
                    return kVar;
                }
                return d();
            }
            return (k) invokeLLLL.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            List<String> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.a) && (list = this.b) != null && list.size() > 0) {
                    String str = this.b.get(0);
                    if (this.a.endsWith(d)) {
                        String str2 = this.a;
                        this.a = str2.substring(0, str2.length() - 1);
                    }
                    if (str.startsWith(d)) {
                        str = str.substring(1);
                    }
                    return this.a + d + str;
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final w43<l> e;
        public static final x43<l> f;
        public transient /* synthetic */ FieldHolder $fh;
        public List<k> a;
        public Map<String, Boolean> b;
        public Map<String, String> c;
        public Map<String, String> d;

        /* loaded from: classes3.dex */
        public static class a extends w43<l> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public l a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    l lVar = new l();
                    List<k> e = on2Var.e(k.e);
                    lVar.a = e;
                    if (e == null) {
                        lVar.a = new ArrayList();
                    }
                    Map<String, Boolean> a = on2Var.a();
                    lVar.b = a;
                    if (a == null) {
                        lVar.b = new HashMap();
                    }
                    Map<String, String> l = on2Var.l();
                    lVar.c = l;
                    if (l == null) {
                        lVar.c = new HashMap();
                    }
                    Map<String, String> l2 = on2Var.l();
                    lVar.d = l2;
                    if (l2 == null) {
                        lVar.d = new HashMap();
                    }
                    return lVar;
                }
                return (l) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends x43<l> {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull l lVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, pn2Var) == null) {
                    pn2Var.d(lVar.a, k.f);
                    pn2Var.a(lVar.b);
                    pn2Var.h(lVar.c);
                    pn2Var.h(lVar.d);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927392, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927392, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$l;");
                    return;
                }
            }
            e = new a();
            f = new b();
        }

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static /* synthetic */ l a() {
            return e();
        }

        public static l d(JSONObject jSONObject, @Nullable File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, file)) == null) {
                if (jSONObject == null) {
                    return e();
                }
                return c(jSONObject.optJSONArray("subPackages"), file);
            }
            return (l) invokeLL.objValue;
        }

        public static l c(JSONArray jSONArray, @Nullable File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, file)) == null) {
                if (jSONArray != null && jSONArray.length() > 0) {
                    l lVar = new l();
                    lVar.a = new ArrayList();
                    lVar.c = new HashMap();
                    lVar.b = new HashMap();
                    lVar.d = new HashMap();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            lVar.a.add(k.c(optJSONObject, lVar.c, lVar.d, file));
                        }
                    }
                    return lVar;
                }
                return e();
            }
            return (l) invokeLL.objValue;
        }

        public static l e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                l lVar = new l();
                lVar.a = new ArrayList();
                lVar.c = new HashMap();
                lVar.b = new HashMap();
                lVar.d = new HashMap();
                return lVar;
            }
            return (l) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public static final x43<m> b;
        public static final w43<m> c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> a;

        /* loaded from: classes3.dex */
        public static class a extends x43<m> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull m mVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, pn2Var) == null) {
                    pn2Var.h(mVar.a);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends w43<m> {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public m a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    Map<String, String> l = on2Var.l();
                    if (l == null) {
                        return m.a();
                    }
                    m mVar = new m();
                    mVar.a = l;
                    return mVar;
                }
                return (m) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927361, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$m;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927361, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$m;");
                    return;
                }
            }
            b = new a();
            c = new b();
        }

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static /* synthetic */ m a() {
            return d();
        }

        public static m d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                m mVar = new m();
                mVar.a = new HashMap();
                return mVar;
            }
            return (m) invokeV.objValue;
        }

        public static m c(JSONObject jSONObject, l lVar) {
            InterceptResult invokeLL;
            List<k> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, lVar)) == null) {
                if (jSONObject != null && lVar != null && (list = lVar.a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return d();
                    }
                    m mVar = new m();
                    mVar.a = new HashMap();
                    for (k kVar : lVar.a) {
                        if (kVar != null && !TextUtils.isEmpty(kVar.a)) {
                            Map<String, String> map = mVar.a;
                            String str = kVar.a;
                            map.put(str, optJSONObject.optString(str));
                        }
                    }
                    return mVar;
                }
                return d();
            }
            return (m) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class n {
        public static /* synthetic */ Interceptable $ic;
        public static final x43<n> f;
        public static final w43<n> g;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public List<o> e;

        /* loaded from: classes3.dex */
        public static class a extends x43<n> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull n nVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar, pn2Var) == null) {
                    pn2Var.writeInt(nVar.a);
                    pn2Var.writeInt(nVar.b);
                    pn2Var.writeInt(nVar.c);
                    pn2Var.writeInt(nVar.d);
                    pn2Var.d(nVar.e, o.e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends w43<n> {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public n a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    n nVar = new n();
                    nVar.a = on2Var.readInt();
                    nVar.b = on2Var.readInt();
                    nVar.c = on2Var.readInt();
                    nVar.d = on2Var.readInt();
                    List<o> e = on2Var.e(o.f);
                    nVar.e = e;
                    if (e == null) {
                        nVar.e = new ArrayList();
                    }
                    return nVar;
                }
                return (n) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927330, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$n;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927330, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$n;");
                    return;
                }
            }
            f = new a();
            g = new b();
        }

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static n c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (SwanAppConfigData.v) {
                    Log.w("SwanAppConfigData", "TabBarConfig createNullObject() ");
                }
                n nVar = new n();
                nVar.e = new ArrayList();
                return nVar;
            }
            return (n) invokeV.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<o> list = this.e;
                if (list != null && list.size() >= 2) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static n b(JSONObject jSONObject) {
            InterceptResult invokeL;
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
                if (optJSONObject == null) {
                    return c();
                }
                n nVar = new n();
                nVar.a = SwanAppConfigData.t(optJSONObject.optString("color", "#999999"));
                nVar.b = SwanAppConfigData.t(optJSONObject.optString("selectedColor", "black"));
                nVar.c = SwanAppConfigData.t(optJSONObject.optString("borderStyle", "black"));
                nVar.d = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "white"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    if (length > 5) {
                        length = 5;
                    }
                    nVar.e = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        nVar.e.add(o.b(optJSONArray.optJSONObject(i)));
                    }
                }
                return nVar;
            }
            return (n) invokeL.objValue;
        }

        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.e == null) {
                    return false;
                }
                for (int i = 0; i < this.e.size(); i++) {
                    if (TextUtils.equals(this.e.get(i).a, str)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class o {
        public static /* synthetic */ Interceptable $ic;
        public static final x43<o> e;
        public static final w43<o> f;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;

        /* loaded from: classes3.dex */
        public static class a extends x43<o> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull o oVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar, pn2Var) == null) {
                    pn2Var.f(oVar.a);
                    pn2Var.f(oVar.b);
                    pn2Var.f(oVar.c);
                    pn2Var.f(oVar.d);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends w43<o> {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public o a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    o oVar = new o();
                    oVar.a = on2Var.g();
                    oVar.b = on2Var.g();
                    oVar.c = on2Var.g();
                    oVar.d = on2Var.g();
                    return oVar;
                }
                return (o) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927299, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$o;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927299, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$o;");
                    return;
                }
            }
            e = new a();
            f = new b();
        }

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static o c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (SwanAppConfigData.v) {
                    Log.w("SwanAppConfigData", "TabItem createNullObject() ");
                }
                return new o();
            }
            return (o) invokeV.objValue;
        }

        public static o b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                o oVar = new o();
                oVar.a = jSONObject.optString("pagePath");
                oVar.b = jSONObject.optString("iconPath");
                oVar.c = jSONObject.optString("selectedIconPath");
                oVar.d = jSONObject.optString("text");
                return oVar;
            }
            return (o) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;
        public static final w43<p> b;
        public static final x43<p> c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* loaded from: classes3.dex */
        public static class a extends w43<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // com.baidu.tieba.w43
            /* renamed from: b */
            public p a(@NonNull on2 on2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                    p pVar = new p();
                    pVar.a = on2Var.readBoolean();
                    return pVar;
                }
                return (p) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends x43<p> {
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
            @Override // com.baidu.tieba.x43
            /* renamed from: b */
            public void a(@NonNull p pVar, @NonNull pn2 pn2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar, pn2Var) == null) {
                    pn2Var.writeBoolean(pVar.a);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92927268, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$p;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-92927268, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$p;");
                    return;
                }
            }
            b = new a();
            c = new b();
        }

        public p() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static p b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                p pVar = new p();
                if (jSONObject == null) {
                    return pVar;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("userAgentWritable");
                if (optJSONObject == null) {
                    return pVar;
                }
                pVar.a = optJSONObject.optBoolean("request");
                return pVar;
            }
            return (p) invokeL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class RequiredBackgroundModeItem {
        public static final /* synthetic */ RequiredBackgroundModeItem[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RequiredBackgroundModeItem AUDIO;
        public transient /* synthetic */ FieldHolder $fh;
        public String mMode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1702167577, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$RequiredBackgroundModeItem;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1702167577, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData$RequiredBackgroundModeItem;");
                    return;
                }
            }
            RequiredBackgroundModeItem requiredBackgroundModeItem = new RequiredBackgroundModeItem(HlsPlaylistParser.TYPE_AUDIO, 0, "audio");
            AUDIO = requiredBackgroundModeItem;
            $VALUES = new RequiredBackgroundModeItem[]{requiredBackgroundModeItem};
        }

        public RequiredBackgroundModeItem(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mMode = str2;
        }

        @Nullable
        public static RequiredBackgroundModeItem find(String str) {
            InterceptResult invokeL;
            RequiredBackgroundModeItem[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (str != null) {
                    for (RequiredBackgroundModeItem requiredBackgroundModeItem : values()) {
                        if (str.equals(requiredBackgroundModeItem.mMode)) {
                            return requiredBackgroundModeItem;
                        }
                    }
                    return null;
                }
                return null;
            }
            return (RequiredBackgroundModeItem) invokeL.objValue;
        }

        public static RequiredBackgroundModeItem valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (RequiredBackgroundModeItem) Enum.valueOf(RequiredBackgroundModeItem.class, str);
            }
            return (RequiredBackgroundModeItem) invokeL.objValue;
        }

        public static RequiredBackgroundModeItem[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (RequiredBackgroundModeItem[]) $VALUES.clone();
            }
            return (RequiredBackgroundModeItem[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends x43<SwanAppConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
        @Override // com.baidu.tieba.x43
        /* renamed from: b */
        public void a(@NonNull SwanAppConfigData swanAppConfigData, @NonNull pn2 pn2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppConfigData, pn2Var) == null) {
                pn2Var.writeBoolean(swanAppConfigData.a);
                pn2Var.c(swanAppConfigData.b, e.c);
                pn2Var.c(swanAppConfigData.c, l.f);
                pn2Var.c(swanAppConfigData.d, m.b);
                pn2Var.c(swanAppConfigData.e, y43.u);
                pn2Var.c(swanAppConfigData.f, n.f);
                pn2Var.c(swanAppConfigData.g, j.b);
                pn2Var.c(swanAppConfigData.h, u43.a.e);
                pn2Var.c(swanAppConfigData.i, g.b);
                pn2Var.c(swanAppConfigData.j, g.b);
                pn2Var.c(swanAppConfigData.k, d.b);
                pn2Var.f(swanAppConfigData.m);
                pn2Var.c(swanAppConfigData.o, i.c);
                pn2Var.c(swanAppConfigData.p, f.b);
                pn2Var.g(swanAppConfigData.q);
                pn2Var.c(swanAppConfigData.r, c.c);
                pn2Var.c(swanAppConfigData.s, p.c);
                pn2Var.c(swanAppConfigData.t, h.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends w43<SwanAppConfigData> {
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
        @Override // com.baidu.tieba.w43
        /* renamed from: b */
        public SwanAppConfigData a(@NonNull on2 on2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                SwanAppConfigData swanAppConfigData = new SwanAppConfigData(null);
                swanAppConfigData.a = on2Var.readBoolean();
                swanAppConfigData.b = (e) on2Var.d(e.b);
                l lVar = (l) on2Var.d(l.e);
                swanAppConfigData.c = lVar;
                if (lVar == null) {
                    swanAppConfigData.c = l.a();
                }
                swanAppConfigData.d = (m) on2Var.d(m.c);
                swanAppConfigData.e = (y43) on2Var.d(y43.v);
                swanAppConfigData.f = (n) on2Var.d(n.g);
                swanAppConfigData.g = (j) on2Var.d(j.c);
                swanAppConfigData.h = (u43.a) on2Var.d(u43.a.f);
                swanAppConfigData.i = (g) on2Var.d(g.c);
                swanAppConfigData.j = (g) on2Var.d(g.c);
                swanAppConfigData.k = (d) on2Var.d(d.c);
                String g = on2Var.g();
                swanAppConfigData.m = g;
                if (!TextUtils.isEmpty(g)) {
                    swanAppConfigData.l = h03.k(swanAppConfigData.m, false);
                }
                swanAppConfigData.o = (i) on2Var.d(i.b);
                swanAppConfigData.p = (f) on2Var.d(f.c);
                swanAppConfigData.q = on2Var.k(Collections.emptyList());
                swanAppConfigData.r = (c) on2Var.d(c.b);
                swanAppConfigData.s = (p) on2Var.d(p.b);
                swanAppConfigData.t = (h) on2Var.d(h.c);
                return swanAppConfigData;
            }
            return (SwanAppConfigData) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1153168024, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1153168024, "Lcom/baidu/swan/apps/runtime/config/SwanAppConfigData;");
                return;
            }
        }
        v = tk1.a;
        w = new a();
        x = new b();
        HashMap<String, Integer> hashMap = new HashMap<>();
        y = hashMap;
        hashMap.put(SensorController.KEY_LIGHT, -1);
        y.put("dark", -16777216);
    }

    public SwanAppConfigData() {
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
        this.q = new ArrayList(1);
    }

    public List<d03> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            d dVar = this.k;
            if (dVar != null && dVar.a.size() > 0) {
                arrayList.addAll(this.k.a);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (l()) {
                return this.b.a.get(0);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            l lVar = this.c;
            if (lVar != null && lVar.a != null && lVar.d != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e eVar = this.b;
            if (eVar != null && (list = eVar.a) != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            l lVar = this.c;
            if (lVar != null && lVar.a != null && lVar.c != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n nVar = this.f;
            if (nVar != null && nVar.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ SwanAppConfigData(a aVar) {
        this();
    }

    public List<f03> i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 == 3) {
                ArrayList arrayList = new ArrayList();
                b(this.j, arrayList);
                return arrayList;
            } else if (i2 == 4) {
                ArrayList arrayList2 = new ArrayList();
                b(this.i, arrayList2);
                return arrayList2;
            } else {
                return null;
            }
        }
        return (List) invokeI.objValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (k() && this.c.d.containsKey(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (m() && this.c.c.containsKey(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            n nVar = this.f;
            if (nVar != null && nVar.d(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static SwanAppConfigData c(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, file)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
            swanAppConfigData.n = str;
            try {
                JSONObject jSONObject = new JSONObject(str);
                swanAppConfigData.j = g.c(jSONObject, file);
                swanAppConfigData.i = g.d(jSONObject, file);
                swanAppConfigData.k = d.a(jSONObject, file);
                swanAppConfigData.m = jSONObject.optString("remote_debug_plugins");
                JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    swanAppConfigData.l = h03.k(optJSONArray.toString(), false);
                }
                swanAppConfigData.a = jSONObject.optBoolean("debug");
                swanAppConfigData.b = e.b(jSONObject);
                l d2 = l.d(jSONObject, file);
                swanAppConfigData.c = d2;
                swanAppConfigData.d = m.c(jSONObject, d2);
                swanAppConfigData.e = y43.a(jSONObject);
                swanAppConfigData.f = n.b(jSONObject);
                swanAppConfigData.g = j.b(jSONObject);
                swanAppConfigData.h = u43.a.a(jSONObject);
                swanAppConfigData.o = i.c(jSONObject);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        String optString = optJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            swanAppConfigData.q.add(optString);
                        }
                    }
                }
                swanAppConfigData.p = f.c(jSONObject);
                swanAppConfigData.r = c.b(jSONObject);
                swanAppConfigData.s = p.b(jSONObject);
                swanAppConfigData.t = h.a(jSONObject);
                swanAppConfigData.u = jSONObject.optBoolean("hasNAViewPages");
                s(swanAppConfigData, jSONObject, file);
                return swanAppConfigData;
            } catch (JSONException e2) {
                if (v) {
                    Log.e("SwanAppConfigData", "buildConfigData json error: ", e2);
                }
                return null;
            }
        }
        return (SwanAppConfigData) invokeLL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() == 4 && str.charAt(0) == '#') {
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(0));
                for (int i2 = 1; i2 < 4; i2++) {
                    char charAt = str.charAt(i2);
                    sb.append(charAt);
                    sb.append(charAt);
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static int t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return Color.parseColor(d(str));
            } catch (Exception unused) {
                if (v) {
                    Log.e("SwanAppConfigData", "parseColor failed: Unknown color " + str);
                }
                if (!y.containsKey(str)) {
                    return -1;
                }
                return y.get(str).intValue();
            }
        }
        return invokeL.intValue;
    }

    public static void s(@NonNull SwanAppConfigData swanAppConfigData, @NonNull JSONObject jSONObject, @NonNull File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, swanAppConfigData, jSONObject, file) == null) {
            File file2 = new File(file, qn2.n().a() + "_app.json");
            if (!file2.exists()) {
                return;
            }
            String E = nk4.E(file2);
            if (TextUtils.isEmpty(E)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(E);
                JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    swanAppConfigData.e = y43.a(jSONObject2);
                    jSONObject.put("window", optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    swanAppConfigData.f = n.b(jSONObject2);
                    jSONObject.put("tabBar", optJSONObject2);
                }
                swanAppConfigData.n = jSONObject.toString();
            } catch (JSONException e2) {
                if (v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void b(g gVar, List<f03> list) {
        List<f03> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, gVar, list) == null) && gVar != null && list != null && (list2 = gVar.a) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    public String g(String str) {
        InterceptResult invokeL;
        List<k> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            l lVar = this.c;
            if (lVar != null && (list = lVar.a) != null) {
                for (k kVar : list) {
                    if (TextUtils.equals(kVar.a, str)) {
                        return kVar.e();
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String b2 = b83.b(bi3.f(str));
            if (!TextUtils.isEmpty(b2)) {
                if (qz2.k(b2)) {
                    return "dynamicLib";
                }
                if (q(b2)) {
                    if (o(b2)) {
                        return "independent";
                    }
                    return "subNormal";
                }
            }
            return "main";
        }
        return (String) invokeL.objValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            i iVar = this.o;
            if (iVar != null && iVar.a != null) {
                String f2 = bi3.f(str);
                String str2 = this.o.a.get(f2);
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                return str.replaceFirst(f2, str2);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if ((l() && this.b.c(str)) || (m() && this.c.c.containsKey(str))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
