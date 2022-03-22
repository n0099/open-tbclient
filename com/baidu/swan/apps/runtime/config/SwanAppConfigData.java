package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.o0;
import c.a.n0.a.t1.n.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
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
/* loaded from: classes4.dex */
public class SwanAppConfigData {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public static final c.a.n0.a.t1.n.f<SwanAppConfigData> w;
    public static final c.a.n0.a.t1.n.e<SwanAppConfigData> x;
    public static final HashMap<String, Integer> y;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public e f29236b;

    /* renamed from: c  reason: collision with root package name */
    public l f29237c;

    /* renamed from: d  reason: collision with root package name */
    public m f29238d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.a.t1.n.g f29239e;

    /* renamed from: f  reason: collision with root package name */
    public n f29240f;

    /* renamed from: g  reason: collision with root package name */
    public j f29241g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f29242h;
    public g i;
    public g j;
    public d k;
    public List<c.a.n0.q.h.i> l;
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (RequiredBackgroundModeItem) Enum.valueOf(RequiredBackgroundModeItem.class, str) : (RequiredBackgroundModeItem) invokeL.objValue;
        }

        public static RequiredBackgroundModeItem[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (RequiredBackgroundModeItem[]) $VALUES.clone() : (RequiredBackgroundModeItem[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends c.a.n0.a.t1.n.f<SwanAppConfigData> {
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
        @Override // c.a.n0.a.t1.n.f
        /* renamed from: b */
        public void a(@NonNull SwanAppConfigData swanAppConfigData, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppConfigData, dVar) == null) {
                dVar.writeBoolean(swanAppConfigData.a);
                dVar.c(swanAppConfigData.f29236b, e.f29248c);
                dVar.c(swanAppConfigData.f29237c, l.f29266f);
                dVar.c(swanAppConfigData.f29238d, m.f29270b);
                dVar.c(swanAppConfigData.f29239e, c.a.n0.a.t1.n.g.u);
                dVar.c(swanAppConfigData.f29240f, n.f29272f);
                dVar.c(swanAppConfigData.f29241g, j.f29258b);
                dVar.c(swanAppConfigData.f29242h, c.a.f6373e);
                dVar.c(swanAppConfigData.i, g.f29251b);
                dVar.c(swanAppConfigData.j, g.f29251b);
                dVar.c(swanAppConfigData.k, d.f29245b);
                dVar.f(swanAppConfigData.m);
                dVar.c(swanAppConfigData.o, i.f29257c);
                dVar.c(swanAppConfigData.p, f.f29249b);
                dVar.g(swanAppConfigData.q);
                dVar.c(swanAppConfigData.r, c.f29244c);
                dVar.c(swanAppConfigData.s, p.f29284c);
                dVar.c(swanAppConfigData.t, h.f29254d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends c.a.n0.a.t1.n.e<SwanAppConfigData> {
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
        @Override // c.a.n0.a.t1.n.e
        /* renamed from: b */
        public SwanAppConfigData a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                SwanAppConfigData swanAppConfigData = new SwanAppConfigData(null);
                swanAppConfigData.a = cVar.readBoolean();
                swanAppConfigData.f29236b = (e) cVar.d(e.f29247b);
                l lVar = (l) cVar.d(l.f29265e);
                swanAppConfigData.f29237c = lVar;
                if (lVar == null) {
                    swanAppConfigData.f29237c = l.e();
                }
                swanAppConfigData.f29238d = (m) cVar.d(m.f29271c);
                swanAppConfigData.f29239e = (c.a.n0.a.t1.n.g) cVar.d(c.a.n0.a.t1.n.g.v);
                swanAppConfigData.f29240f = (n) cVar.d(n.f29273g);
                swanAppConfigData.f29241g = (j) cVar.d(j.f29259c);
                swanAppConfigData.f29242h = (c.a) cVar.d(c.a.f6374f);
                swanAppConfigData.i = (g) cVar.d(g.f29252c);
                swanAppConfigData.j = (g) cVar.d(g.f29252c);
                swanAppConfigData.k = (d) cVar.d(d.f29246c);
                String g2 = cVar.g();
                swanAppConfigData.m = g2;
                if (!TextUtils.isEmpty(g2)) {
                    swanAppConfigData.l = c.a.n0.a.m1.h.b.k(swanAppConfigData.m, false);
                }
                swanAppConfigData.o = (i) cVar.d(i.f29256b);
                swanAppConfigData.p = (f) cVar.d(f.f29250c);
                swanAppConfigData.q = cVar.k(Collections.emptyList());
                swanAppConfigData.r = (c) cVar.d(c.f29243b);
                swanAppConfigData.s = (p) cVar.d(p.f29283b);
                swanAppConfigData.t = (h) cVar.d(h.f29253c);
                return swanAppConfigData;
            }
            return (SwanAppConfigData) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<c> f29243b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<c> f29244c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.e<c> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public c a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    c cVar2 = new c();
                    cVar2.a = cVar.readBoolean();
                    return cVar2;
                }
                return (c) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.f<c> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull c cVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, dVar) == null) {
                    dVar.writeBoolean(cVar.a);
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
            f29243b = new a();
            f29244c = new b();
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
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                c cVar = new c();
                if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("cookie")) == null) {
                    return cVar;
                }
                cVar.a = optJSONObject.optBoolean("enableStore");
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<d> f29245b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<d> f29246c;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c.a.n0.a.m1.g.a> a;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.f<d> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull d dVar, @NonNull c.a.n0.a.r0.d dVar2) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, dVar2) == null) {
                    dVar2.d(dVar.a, c.a.n0.a.m1.g.a.l);
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.e<d> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public d a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    List<c.a.n0.a.m1.g.a> e2 = cVar.e(c.a.n0.a.m1.g.a.k);
                    if (e2 == null) {
                        return null;
                    }
                    d dVar = new d();
                    dVar.a = e2;
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
            f29245b = new a();
            f29246c = new b();
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
                    c.a.n0.a.m1.g.a aVar = new c.a.n0.a.m1.g.a(optJSONObject.optJSONObject(next), next);
                    if (file != null && !TextUtils.isEmpty(aVar.f5478e)) {
                        aVar.f5478e = new File(file, aVar.f5478e).getAbsolutePath();
                    }
                    dVar.a.add(aVar);
                }
                return dVar;
            }
            return (d) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<e> f29247b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<e> f29248c;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.e<e> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public e a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    e eVar = new e();
                    eVar.a = cVar.k(Collections.emptyList());
                    return eVar;
                }
                return (e) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.f<e> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull e eVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, dVar) == null) {
                    dVar.g(eVar.a);
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
            f29247b = new a();
            f29248c = new b();
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
                return list != null && list.contains(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<f> f29249b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<f> f29250c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, Map<String, String>> a;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.f<f> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.swan.apps.runtime.config.SwanAppConfigData$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C1823a extends c.a.n0.a.t1.n.f<Map<String, String>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C1823a(a aVar) {
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
                @Override // c.a.n0.a.t1.n.f
                /* renamed from: b */
                public void a(@NonNull Map<String, String> map, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, dVar) == null) {
                        dVar.h(map);
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull f fVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, dVar) == null) {
                    dVar.e(fVar.a, new C1823a(this));
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.e<f> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* loaded from: classes4.dex */
            public class a extends c.a.n0.a.t1.n.e<Map<String, String>> {
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
                @Override // c.a.n0.a.t1.n.e
                /* renamed from: b */
                public Map<String, String> a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? cVar.l() : (Map) invokeL.objValue;
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public f a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, Map<String, String>> f2 = cVar.f(new a(this));
                    if (f2 == null) {
                        return f.d();
                    }
                    f fVar = new f();
                    fVar.a = f2;
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
            f29249b = new a();
            f29250c = new b();
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

        public static f c(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
                f d2 = d();
                if (jSONObject == null) {
                    return d2;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
                if (optJSONObject == null) {
                    return null;
                }
                d2.a = new HashMap();
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
                    d2.a.put(next, hashMap);
                }
                return d2;
            }
            return (f) invokeL.objValue;
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
    }

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<g> f29251b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<g> f29252c;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c.a.n0.a.m1.g.c> a;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.f<g> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull g gVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                    dVar.d(gVar.a, c.a.n0.a.m1.g.c.i);
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.e<g> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public g a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    List<c.a.n0.a.m1.g.c> e2 = cVar.e(c.a.n0.a.m1.g.c.f5480h);
                    if (e2 == null) {
                        return null;
                    }
                    g gVar = new g();
                    gVar.a = e2;
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
            f29251b = new a();
            f29252c = new b();
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, file)) == null) ? e(jSONObject, "dynamicLib", 3, file) : (g) invokeLL.objValue;
        }

        public static g d(JSONObject jSONObject, File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, file)) == null) ? e(jSONObject, "plugins", 4, file) : (g) invokeLL.objValue;
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
                        c.a.n0.a.m1.g.c cVar = new c.a.n0.a.m1.g.c(optJSONObject.optJSONObject(next), i);
                        cVar.f5481g = next;
                        if (file != null && !TextUtils.isEmpty(cVar.f5478e)) {
                            cVar.f5478e = new File(file, cVar.f5478e).getAbsolutePath();
                        }
                        gVar.a.add(cVar);
                    }
                }
                return gVar;
            }
            return (g) invokeLLIL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<h> f29253c;

        /* renamed from: d  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<h> f29254d;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29255b;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.e<h> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public h a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? new h(cVar.readBoolean(), cVar.g()) : (h) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.f<h> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull h hVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, dVar) == null) {
                    dVar.writeBoolean(hVar.a);
                    dVar.f(hVar.f29255b);
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
            f29253c = new a();
            f29254d = new b();
        }

        public h(boolean z, @Nullable String str) {
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
            this.f29255b = TextUtils.equals(str, "click") || TextUtils.equals(str, "show") ? str : "click";
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

    /* loaded from: classes4.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<i> f29256b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<i> f29257c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> a;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.e<i> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public i a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, String> l = cVar.l();
                    if (l == null) {
                        return i.d();
                    }
                    i iVar = new i();
                    iVar.a = l;
                    return iVar;
                }
                return (i) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.f<i> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull i iVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, dVar) == null) {
                    dVar.h(iVar.a);
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
            f29256b = new a();
            f29257c = new b();
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

        public static i c(JSONObject jSONObject) {
            InterceptResult invokeL;
            JSONArray optJSONArray;
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
                i d2 = d();
                if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("path");
                            String optString2 = optJSONObject.optString("page");
                            if (!d2.a.containsKey(optString)) {
                                d2.a.put(optString, optString2);
                            }
                        }
                    }
                }
                return d2;
            }
            return (i) invokeL.objValue;
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
    }

    /* loaded from: classes4.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<j> f29258b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<j> f29259c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.f<j> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull j jVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, dVar) == null) {
                    dVar.writeBoolean(jVar.a);
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.e<j> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public j a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    j jVar = new j();
                    jVar.a = cVar.readBoolean();
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
            f29258b = new a();
            f29259c = new b();
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

        public static j b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("setting");
                if (optJSONObject == null) {
                    return c();
                }
                c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
                String str = L != null ? L.f6344b : "";
                j jVar = new j();
                jVar.a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
                if (optJSONObject2 != null) {
                    c.a.n0.a.u1.a.c.u(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                    if (optJSONObject3 != null) {
                        c.a.n0.a.u1.a.c.s(str, optJSONObject3);
                    }
                }
                return jVar;
            }
            return (j) invokeL.objValue;
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

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                SwanAppConfigData s = c.a.n0.a.w0.f.U().s();
                if (s == null) {
                    return true;
                }
                j jVar = s.f29241g;
                c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
                boolean d2 = c.a.n0.a.l.a.d(L != null ? L.X() : null);
                boolean d3 = c.a.n0.a.u.f.e.e.d();
                boolean d4 = c.a.n0.a.x.a.d();
                boolean H = c.a.n0.a.n1.a.a.H();
                boolean D = c.a.n0.a.n1.a.a.D();
                if (SwanAppConfigData.v) {
                    Log.d("SwanAppConfigData", "isDevelop: " + d2 + " isRemoteDebug: " + d3 + " isMobileDebug: " + d4 + " urlCheck: " + jVar.a);
                }
                return (d2 || d3 || d4 || H || D) && !jVar.a;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final String f29260d;

        /* renamed from: e  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<k> f29261e;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<k> f29262f;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f29263b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29264c;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.e<k> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public k a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    k kVar = new k();
                    kVar.a = cVar.g();
                    kVar.f29263b = cVar.k(Collections.emptyList());
                    kVar.f29264c = cVar.readBoolean();
                    return kVar;
                }
                return (k) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.f<k> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull k kVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar, dVar) == null) {
                    dVar.f(kVar.a);
                    dVar.g(kVar.f29263b);
                    dVar.writeBoolean(kVar.f29264c);
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
            f29260d = File.separator;
            f29261e = new a();
            f29262f = new b();
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
            this.f29264c = false;
        }

        public static k c(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2, File file) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, map, map2, file)) == null) {
                if (jSONObject != null && map != null) {
                    k kVar = new k();
                    kVar.a = jSONObject.optString("root");
                    kVar.f29264c = jSONObject.optBoolean("independent");
                    JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        kVar.f29263b = new ArrayList();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray.optString(i);
                            kVar.f29263b.add(optString);
                            if (!TextUtils.isEmpty(kVar.a) && !TextUtils.isEmpty(optString)) {
                                String str = (!kVar.a.endsWith(f29260d) && !optString.startsWith(f29260d)) ? kVar.a + f29260d + optString : kVar.a + optString;
                                map.put(str, kVar.a);
                                if (kVar.f29264c) {
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

        public static k d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                k kVar = new k();
                kVar.f29263b = new ArrayList();
                return kVar;
            }
            return (k) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            List<String> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.a) || (list = this.f29263b) == null || list.size() <= 0) {
                    return null;
                }
                String str = this.f29263b.get(0);
                if (this.a.endsWith(f29260d)) {
                    String str2 = this.a;
                    this.a = str2.substring(0, str2.length() - 1);
                }
                if (str.startsWith(f29260d)) {
                    str = str.substring(1);
                }
                return this.a + f29260d + str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<l> f29265e;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<l> f29266f;
        public transient /* synthetic */ FieldHolder $fh;
        public List<k> a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, Boolean> f29267b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f29268c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f29269d;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.e<l> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public l a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    l lVar = new l();
                    List<k> e2 = cVar.e(k.f29261e);
                    lVar.a = e2;
                    if (e2 == null) {
                        lVar.a = new ArrayList();
                    }
                    Map<String, Boolean> a = cVar.a();
                    lVar.f29267b = a;
                    if (a == null) {
                        lVar.f29267b = new HashMap();
                    }
                    Map<String, String> l = cVar.l();
                    lVar.f29268c = l;
                    if (l == null) {
                        lVar.f29268c = new HashMap();
                    }
                    Map<String, String> l2 = cVar.l();
                    lVar.f29269d = l2;
                    if (l2 == null) {
                        lVar.f29269d = new HashMap();
                    }
                    return lVar;
                }
                return (l) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.f<l> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull l lVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, dVar) == null) {
                    dVar.d(lVar.a, k.f29262f);
                    dVar.a(lVar.f29267b);
                    dVar.h(lVar.f29268c);
                    dVar.h(lVar.f29269d);
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
            f29265e = new a();
            f29266f = new b();
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

        public static l c(JSONArray jSONArray, @Nullable File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, file)) == null) {
                if (jSONArray != null && jSONArray.length() > 0) {
                    l lVar = new l();
                    lVar.a = new ArrayList();
                    lVar.f29268c = new HashMap();
                    lVar.f29267b = new HashMap();
                    lVar.f29269d = new HashMap();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            lVar.a.add(k.c(optJSONObject, lVar.f29268c, lVar.f29269d, file));
                        }
                    }
                    return lVar;
                }
                return e();
            }
            return (l) invokeLL.objValue;
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

        public static l e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                l lVar = new l();
                lVar.a = new ArrayList();
                lVar.f29268c = new HashMap();
                lVar.f29267b = new HashMap();
                lVar.f29269d = new HashMap();
                return lVar;
            }
            return (l) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<m> f29270b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<m> f29271c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> a;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.f<m> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull m mVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, dVar) == null) {
                    dVar.h(mVar.a);
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.e<m> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public m a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, String> l = cVar.l();
                    if (l == null) {
                        return m.d();
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
            f29270b = new a();
            f29271c = new b();
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
    }

    /* loaded from: classes4.dex */
    public static class n {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<n> f29272f;

        /* renamed from: g  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<n> f29273g;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f29274b;

        /* renamed from: c  reason: collision with root package name */
        public int f29275c;

        /* renamed from: d  reason: collision with root package name */
        public int f29276d;

        /* renamed from: e  reason: collision with root package name */
        public List<o> f29277e;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.f<n> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull n nVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar, dVar) == null) {
                    dVar.writeInt(nVar.a);
                    dVar.writeInt(nVar.f29274b);
                    dVar.writeInt(nVar.f29275c);
                    dVar.writeInt(nVar.f29276d);
                    dVar.d(nVar.f29277e, o.f29278e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.e<n> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public n a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    n nVar = new n();
                    nVar.a = cVar.readInt();
                    nVar.f29274b = cVar.readInt();
                    nVar.f29275c = cVar.readInt();
                    nVar.f29276d = cVar.readInt();
                    List<o> e2 = cVar.e(o.f29279f);
                    nVar.f29277e = e2;
                    if (e2 == null) {
                        nVar.f29277e = new ArrayList();
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
            f29272f = new a();
            f29273g = new b();
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
                nVar.f29274b = SwanAppConfigData.t(optJSONObject.optString("selectedColor", "black"));
                nVar.f29275c = SwanAppConfigData.t(optJSONObject.optString("borderStyle", "black"));
                nVar.f29276d = SwanAppConfigData.t(optJSONObject.optString("backgroundColor", "white"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    if (length > 5) {
                        length = 5;
                    }
                    nVar.f29277e = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        nVar.f29277e.add(o.b(optJSONArray.optJSONObject(i)));
                    }
                }
                return nVar;
            }
            return (n) invokeL.objValue;
        }

        public static n c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (SwanAppConfigData.v) {
                    Log.w("SwanAppConfigData", "TabBarConfig createNullObject() ");
                }
                n nVar = new n();
                nVar.f29277e = new ArrayList();
                return nVar;
            }
            return (n) invokeV.objValue;
        }

        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f29277e == null) {
                    return false;
                }
                for (int i = 0; i < this.f29277e.size(); i++) {
                    if (TextUtils.equals(this.f29277e.get(i).a, str)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<o> list = this.f29277e;
                return list != null && list.size() >= 2;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class o {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<o> f29278e;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<o> f29279f;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f29280b;

        /* renamed from: c  reason: collision with root package name */
        public String f29281c;

        /* renamed from: d  reason: collision with root package name */
        public String f29282d;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.f<o> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull o oVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar, dVar) == null) {
                    dVar.f(oVar.a);
                    dVar.f(oVar.f29280b);
                    dVar.f(oVar.f29281c);
                    dVar.f(oVar.f29282d);
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.e<o> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public o a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    o oVar = new o();
                    oVar.a = cVar.g();
                    oVar.f29280b = cVar.g();
                    oVar.f29281c = cVar.g();
                    oVar.f29282d = cVar.g();
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
            f29278e = new a();
            f29279f = new b();
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

        public static o b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                o oVar = new o();
                oVar.a = jSONObject.optString("pagePath");
                oVar.f29280b = jSONObject.optString("iconPath");
                oVar.f29281c = jSONObject.optString("selectedIconPath");
                oVar.f29282d = jSONObject.optString("text");
                return oVar;
            }
            return (o) invokeL.objValue;
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
    }

    /* loaded from: classes4.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.e<p> f29283b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.n0.a.t1.n.f<p> f29284c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* loaded from: classes4.dex */
        public static class a extends c.a.n0.a.t1.n.e<p> {
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
            @Override // c.a.n0.a.t1.n.e
            /* renamed from: b */
            public p a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    p pVar = new p();
                    pVar.a = cVar.readBoolean();
                    return pVar;
                }
                return (p) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends c.a.n0.a.t1.n.f<p> {
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
            @Override // c.a.n0.a.t1.n.f
            /* renamed from: b */
            public void a(@NonNull p pVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar, dVar) == null) {
                    dVar.writeBoolean(pVar.a);
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
            f29283b = new a();
            f29284c = new b();
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
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                p pVar = new p();
                if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("userAgentWritable")) == null) {
                    return pVar;
                }
                pVar.a = optJSONObject.optBoolean("request");
                return pVar;
            }
            return (p) invokeL.objValue;
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
        v = c.a.n0.a.a.a;
        w = new a();
        x = new b();
        HashMap<String, Integer> hashMap = new HashMap<>();
        y = hashMap;
        hashMap.put(SensorController.KEY_LIGHT, -1);
        y.put(SkinManager.SKIN_TYPE_STR_DARK, -16777216);
    }

    public /* synthetic */ SwanAppConfigData(a aVar) {
        this();
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
                    swanAppConfigData.l = c.a.n0.a.m1.h.b.k(optJSONArray.toString(), false);
                }
                swanAppConfigData.a = jSONObject.optBoolean("debug");
                swanAppConfigData.f29236b = e.b(jSONObject);
                l d2 = l.d(jSONObject, file);
                swanAppConfigData.f29237c = d2;
                swanAppConfigData.f29238d = m.c(jSONObject, d2);
                swanAppConfigData.f29239e = c.a.n0.a.t1.n.g.a(jSONObject);
                swanAppConfigData.f29240f = n.b(jSONObject);
                swanAppConfigData.f29241g = j.b(jSONObject);
                swanAppConfigData.f29242h = c.a.a(jSONObject);
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

    public static void s(@NonNull SwanAppConfigData swanAppConfigData, @NonNull JSONObject jSONObject, @NonNull File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, swanAppConfigData, jSONObject, file) == null) {
            File file2 = new File(file, c.a.n0.a.s0.a.n().a() + "_app.json");
            if (file2.exists()) {
                String E = c.a.n0.w.d.E(file2);
                if (TextUtils.isEmpty(E)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(E);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.f29239e = c.a.n0.a.t1.n.g.a(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.f29240f = n.b(jSONObject2);
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
                if (y.containsKey(str)) {
                    return y.get(str).intValue();
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final void b(g gVar, List<c.a.n0.a.m1.g.c> list) {
        List<c.a.n0.a.m1.g.c> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, list) == null) || gVar == null || list == null || (list2 = gVar.a) == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public List<c.a.n0.a.m1.g.a> e() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? l() ? this.f29236b.a.get(0) : "" : (String) invokeV.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        List<k> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            l lVar = this.f29237c;
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
            String b2 = c.a.n0.a.v1.f.o0.j.b(o0.f(str));
            if (!TextUtils.isEmpty(b2)) {
                if (c.a.n0.a.m1.c.a.k(b2)) {
                    return "dynamicLib";
                }
                if (q(b2)) {
                    return o(b2) ? "independent" : "subNormal";
                }
            }
            return "main";
        }
        return (String) invokeL.objValue;
    }

    public List<c.a.n0.a.m1.g.c> i(int i2) {
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

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            i iVar = this.o;
            if (iVar == null || iVar.a == null) {
                return str;
            }
            String f2 = o0.f(str);
            String str2 = this.o.a.get(f2);
            return TextUtils.isEmpty(str2) ? str : str.replaceFirst(f2, str2);
        }
        return (String) invokeL.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            l lVar = this.f29237c;
            return (lVar == null || lVar.a == null || lVar.f29269d == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e eVar = this.f29236b;
            return (eVar == null || (list = eVar.a) == null || list.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            l lVar = this.f29237c;
            return (lVar == null || lVar.a == null || lVar.f29268c == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n nVar = this.f29240f;
            return nVar != null && nVar.e();
        }
        return invokeV.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? k() && this.f29237c.f29269d.containsKey(str) : invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? (l() && this.f29236b.c(str)) || (m() && this.f29237c.f29268c.containsKey(str)) : invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? m() && this.f29237c.f29268c.containsKey(str) : invokeL.booleanValue;
    }

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            n nVar = this.f29240f;
            return nVar != null && nVar.d(str);
        }
        return invokeL.booleanValue;
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
}
