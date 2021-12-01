package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n.c;
import c.a.p0.a.z2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
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
import com.yy.hiidostatis.defs.controller.SensorController;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes9.dex */
public class SwanAppConfigData {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public static final c.a.p0.a.d2.n.f<SwanAppConfigData> w;
    public static final c.a.p0.a.d2.n.e<SwanAppConfigData> x;
    public static final HashMap<String, Integer> y;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public e f40058b;

    /* renamed from: c  reason: collision with root package name */
    public l f40059c;

    /* renamed from: d  reason: collision with root package name */
    public m f40060d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.d2.n.g f40061e;

    /* renamed from: f  reason: collision with root package name */
    public n f40062f;

    /* renamed from: g  reason: collision with root package name */
    public j f40063g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f40064h;

    /* renamed from: i  reason: collision with root package name */
    public g f40065i;

    /* renamed from: j  reason: collision with root package name */
    public g f40066j;

    /* renamed from: k  reason: collision with root package name */
    public d f40067k;
    public List<c.a.p0.q.i.i> l;
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
    /* loaded from: classes9.dex */
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
            RequiredBackgroundModeItem requiredBackgroundModeItem = new RequiredBackgroundModeItem("AUDIO", 0, MediaStreamTrack.AUDIO_TRACK_KIND);
            AUDIO = requiredBackgroundModeItem;
            $VALUES = new RequiredBackgroundModeItem[]{requiredBackgroundModeItem};
        }

        public RequiredBackgroundModeItem(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes9.dex */
    public static class a extends c.a.p0.a.d2.n.f<SwanAppConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
        @Override // c.a.p0.a.d2.n.f
        /* renamed from: b */
        public void a(@NonNull SwanAppConfigData swanAppConfigData, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppConfigData, dVar) == null) {
                dVar.writeBoolean(swanAppConfigData.a);
                dVar.c(swanAppConfigData.f40058b, e.f40073c);
                dVar.c(swanAppConfigData.f40059c, l.f40091f);
                dVar.c(swanAppConfigData.f40060d, m.f40095b);
                dVar.c(swanAppConfigData.f40061e, c.a.p0.a.d2.n.g.u);
                dVar.c(swanAppConfigData.f40062f, n.f40097f);
                dVar.c(swanAppConfigData.f40063g, j.f40083b);
                dVar.c(swanAppConfigData.f40064h, c.a.f4648e);
                dVar.c(swanAppConfigData.f40065i, g.f40076b);
                dVar.c(swanAppConfigData.f40066j, g.f40076b);
                dVar.c(swanAppConfigData.f40067k, d.f40070b);
                dVar.f(swanAppConfigData.m);
                dVar.c(swanAppConfigData.o, i.f40082c);
                dVar.c(swanAppConfigData.p, f.f40074b);
                dVar.g(swanAppConfigData.q);
                dVar.c(swanAppConfigData.r, c.f40069c);
                dVar.c(swanAppConfigData.s, p.f40109c);
                dVar.c(swanAppConfigData.t, h.f40079d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends c.a.p0.a.d2.n.e<SwanAppConfigData> {
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
        @Override // c.a.p0.a.d2.n.e
        /* renamed from: b */
        public SwanAppConfigData a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                SwanAppConfigData swanAppConfigData = new SwanAppConfigData(null);
                swanAppConfigData.a = cVar.readBoolean();
                swanAppConfigData.f40058b = (e) cVar.d(e.f40072b);
                l lVar = (l) cVar.d(l.f40090e);
                swanAppConfigData.f40059c = lVar;
                if (lVar == null) {
                    swanAppConfigData.f40059c = l.e();
                }
                swanAppConfigData.f40060d = (m) cVar.d(m.f40096c);
                swanAppConfigData.f40061e = (c.a.p0.a.d2.n.g) cVar.d(c.a.p0.a.d2.n.g.v);
                swanAppConfigData.f40062f = (n) cVar.d(n.f40098g);
                swanAppConfigData.f40063g = (j) cVar.d(j.f40084c);
                swanAppConfigData.f40064h = (c.a) cVar.d(c.a.f4649f);
                swanAppConfigData.f40065i = (g) cVar.d(g.f40077c);
                swanAppConfigData.f40066j = (g) cVar.d(g.f40077c);
                swanAppConfigData.f40067k = (d) cVar.d(d.f40071c);
                String g2 = cVar.g();
                swanAppConfigData.m = g2;
                if (!TextUtils.isEmpty(g2)) {
                    swanAppConfigData.l = c.a.p0.a.w1.h.b.k(swanAppConfigData.m, false);
                }
                swanAppConfigData.o = (i) cVar.d(i.f40081b);
                swanAppConfigData.p = (f) cVar.d(f.f40075c);
                swanAppConfigData.q = cVar.k(Collections.emptyList());
                swanAppConfigData.r = (c) cVar.d(c.f40068b);
                swanAppConfigData.s = (p) cVar.d(p.f40108b);
                swanAppConfigData.t = (h) cVar.d(h.f40078c);
                return swanAppConfigData;
            }
            return (SwanAppConfigData) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<c> f40068b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<c> f40069c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.e<c> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public c a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
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

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.f<c> {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull c cVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
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
            f40068b = new a();
            f40069c = new b();
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

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<d> f40070b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<d> f40071c;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c.a.p0.a.w1.g.a> a;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.f<d> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull d dVar, @NonNull c.a.p0.a.b1.d dVar2) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, dVar2) == null) {
                    dVar2.d(dVar.a, c.a.p0.a.w1.g.a.p);
                }
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.e<d> {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public d a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    List<c.a.p0.a.w1.g.a> e2 = cVar.e(c.a.p0.a.w1.g.a.o);
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
            f40070b = new a();
            f40071c = new b();
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    c.a.p0.a.w1.g.a aVar = new c.a.p0.a.w1.g.a(optJSONObject.optJSONObject(next), next);
                    if (file != null && !TextUtils.isEmpty(aVar.f8717i)) {
                        aVar.f8717i = new File(file, aVar.f8717i).getAbsolutePath();
                    }
                    dVar.a.add(aVar);
                }
                return dVar;
            }
            return (d) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<e> f40072b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<e> f40073c;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.e<e> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public e a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
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

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.f<e> {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull e eVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
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
            f40072b = new a();
            f40073c = new b();
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    eVar.a.add(optJSONArray.optString(i2));
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        public static e d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                boolean unused = SwanAppConfigData.v;
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

    /* loaded from: classes9.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<f> f40074b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<f> f40075c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, Map<String, String>> a;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.f<f> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.swan.apps.runtime.config.SwanAppConfigData$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1805a extends c.a.p0.a.d2.n.f<Map<String, String>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C1805a(a aVar) {
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
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // c.a.p0.a.d2.n.f
                /* renamed from: b */
                public void a(@NonNull Map<String, String> map, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull f fVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, dVar) == null) {
                    dVar.e(fVar.a, new C1805a(this));
                }
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.e<f> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* loaded from: classes9.dex */
            public class a extends c.a.p0.a.d2.n.e<Map<String, String>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
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
                @Override // c.a.p0.a.d2.n.e
                /* renamed from: b */
                public Map<String, String> a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public f a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
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
            f40074b = new a();
            f40075c = new b();
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                JSONObject optJSONObject = jSONObject.optJSONObject("permission");
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

    /* loaded from: classes9.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<g> f40076b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<g> f40077c;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c.a.p0.a.w1.g.c> a;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.f<g> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull g gVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                    dVar.d(gVar.a, c.a.p0.a.w1.g.c.m);
                }
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.e<g> {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public g a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    List<c.a.p0.a.w1.g.c> e2 = cVar.e(c.a.p0.a.w1.g.c.l);
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
            f40076b = new a();
            f40077c = new b();
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, file)) == null) ? e(jSONObject, FlutterActivityAndFragmentDelegate.PLUGINS_RESTORATION_BUNDLE_KEY, 4, file) : (g) invokeLL.objValue;
        }

        public static g e(JSONObject jSONObject, String str, int i2, File file) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65542, null, jSONObject, str, i2, file)) == null) {
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
                        c.a.p0.a.w1.g.c cVar = new c.a.p0.a.w1.g.c(optJSONObject.optJSONObject(next), i2);
                        cVar.f8719k = next;
                        if (file != null && !TextUtils.isEmpty(cVar.f8717i)) {
                            cVar.f8717i = new File(file, cVar.f8717i).getAbsolutePath();
                        }
                        gVar.a.add(cVar);
                    }
                }
                return gVar;
            }
            return (g) invokeLLIL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<h> f40078c;

        /* renamed from: d  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<h> f40079d;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final String f40080b;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.e<h> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public h a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? new h(cVar.readBoolean(), cVar.g()) : (h) invokeL.objValue;
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.f<h> {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull h hVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, dVar) == null) {
                    dVar.writeBoolean(hVar.a);
                    dVar.f(hVar.f40080b);
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
            f40078c = new a();
            f40079d = new b();
        }

        public h(boolean z, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.f40080b = TextUtils.equals(str, "click") || TextUtils.equals(str, "show") ? str : "click";
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
                            String str = "prefetch is on from app.json - " + optJSONObject;
                            String str2 = "prefetch trigger from app.json - " + optString;
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

    /* loaded from: classes9.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<i> f40081b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<i> f40082c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> a;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.e<i> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public i a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
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

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.f<i> {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull i iVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
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
            f40081b = new a();
            f40082c = new b();
        }

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
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

    /* loaded from: classes9.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<j> f40083b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<j> f40084c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.f<j> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull j jVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, dVar) == null) {
                    dVar.writeBoolean(jVar.a);
                }
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.e<j> {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public j a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
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
            f40083b = new a();
            f40084c = new b();
        }

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.s);
                if (optJSONObject == null) {
                    return c();
                }
                c.a.p0.a.d2.e L = c.a.p0.a.d2.e.L();
                String str = L != null ? L.f4616f : "";
                j jVar = new j();
                jVar.a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
                if (optJSONObject2 != null) {
                    c.a.p0.a.e2.a.c.u(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                    if (optJSONObject3 != null) {
                        c.a.p0.a.e2.a.c.s(str, optJSONObject3);
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
                boolean unused = SwanAppConfigData.v;
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
                SwanAppConfigData r = c.a.p0.a.g1.f.U().r();
                if (r == null) {
                    return true;
                }
                j jVar = r.f40063g;
                c.a.p0.a.d2.e L = c.a.p0.a.d2.e.L();
                boolean d2 = c.a.p0.a.v.a.d(L != null ? L.X() : null);
                boolean d3 = c.a.p0.a.e0.f.e.e.d();
                boolean d4 = c.a.p0.a.h0.a.d();
                boolean H = c.a.p0.a.x1.a.a.H();
                boolean D = c.a.p0.a.x1.a.a.D();
                if (SwanAppConfigData.v) {
                    String str = "isDevelop: " + d2 + " isRemoteDebug: " + d3 + " isMobileDebug: " + d4 + " urlCheck: " + jVar.a;
                }
                return (d2 || d3 || d4 || H || D) && !jVar.a;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final String f40085d;

        /* renamed from: e  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<k> f40086e;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<k> f40087f;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f40088b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40089c;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.e<k> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public k a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    k kVar = new k();
                    kVar.a = cVar.g();
                    kVar.f40088b = cVar.k(Collections.emptyList());
                    kVar.f40089c = cVar.readBoolean();
                    return kVar;
                }
                return (k) invokeL.objValue;
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.f<k> {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull k kVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar, dVar) == null) {
                    dVar.f(kVar.a);
                    dVar.g(kVar.f40088b);
                    dVar.writeBoolean(kVar.f40089c);
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
            f40085d = File.separator;
            f40086e = new a();
            f40087f = new b();
        }

        public k() {
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
            this.f40089c = false;
        }

        public static k c(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2, File file) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, map, map2, file)) == null) {
                if (jSONObject != null && map != null) {
                    k kVar = new k();
                    kVar.a = jSONObject.optString("root");
                    kVar.f40089c = jSONObject.optBoolean("independent");
                    JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        kVar.f40088b = new ArrayList();
                        for (int i2 = 0; i2 < length; i2++) {
                            String optString = optJSONArray.optString(i2);
                            kVar.f40088b.add(optString);
                            if (!TextUtils.isEmpty(kVar.a) && !TextUtils.isEmpty(optString)) {
                                String str = (!kVar.a.endsWith(f40085d) && !optString.startsWith(f40085d)) ? kVar.a + f40085d + optString : kVar.a + optString;
                                map.put(str, kVar.a);
                                if (kVar.f40089c) {
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
                kVar.f40088b = new ArrayList();
                return kVar;
            }
            return (k) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            List<String> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.a) || (list = this.f40088b) == null || list.size() <= 0) {
                    return null;
                }
                String str = this.f40088b.get(0);
                if (this.a.endsWith(f40085d)) {
                    String str2 = this.a;
                    this.a = str2.substring(0, str2.length() - 1);
                }
                if (str.startsWith(f40085d)) {
                    str = str.substring(1);
                }
                return this.a + f40085d + str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<l> f40090e;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<l> f40091f;
        public transient /* synthetic */ FieldHolder $fh;
        public List<k> a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, Boolean> f40092b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f40093c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f40094d;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.e<l> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public l a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    l lVar = new l();
                    List<k> e2 = cVar.e(k.f40086e);
                    lVar.a = e2;
                    if (e2 == null) {
                        lVar.a = new ArrayList();
                    }
                    Map<String, Boolean> a = cVar.a();
                    lVar.f40092b = a;
                    if (a == null) {
                        lVar.f40092b = new HashMap();
                    }
                    Map<String, String> l = cVar.l();
                    lVar.f40093c = l;
                    if (l == null) {
                        lVar.f40093c = new HashMap();
                    }
                    Map<String, String> l2 = cVar.l();
                    lVar.f40094d = l2;
                    if (l2 == null) {
                        lVar.f40094d = new HashMap();
                    }
                    return lVar;
                }
                return (l) invokeL.objValue;
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.f<l> {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull l lVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, dVar) == null) {
                    dVar.d(lVar.a, k.f40087f);
                    dVar.a(lVar.f40092b);
                    dVar.h(lVar.f40093c);
                    dVar.h(lVar.f40094d);
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
            f40090e = new a();
            f40091f = new b();
        }

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    lVar.f40093c = new HashMap();
                    lVar.f40092b = new HashMap();
                    lVar.f40094d = new HashMap();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            lVar.a.add(k.c(optJSONObject, lVar.f40093c, lVar.f40094d, file));
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
                lVar.f40093c = new HashMap();
                lVar.f40092b = new HashMap();
                lVar.f40094d = new HashMap();
                return lVar;
            }
            return (l) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<m> f40095b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<m> f40096c;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> a;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.f<m> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull m mVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, dVar) == null) {
                    dVar.h(mVar.a);
                }
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.e<m> {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public m a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
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
            f40095b = new a();
            f40096c = new b();
        }

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes9.dex */
    public static class n {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<n> f40097f;

        /* renamed from: g  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<n> f40098g;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f40099b;

        /* renamed from: c  reason: collision with root package name */
        public int f40100c;

        /* renamed from: d  reason: collision with root package name */
        public int f40101d;

        /* renamed from: e  reason: collision with root package name */
        public List<o> f40102e;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.f<n> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull n nVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar, dVar) == null) {
                    dVar.writeInt(nVar.a);
                    dVar.writeInt(nVar.f40099b);
                    dVar.writeInt(nVar.f40100c);
                    dVar.writeInt(nVar.f40101d);
                    dVar.d(nVar.f40102e, o.f40103e);
                }
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.e<n> {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public n a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    n nVar = new n();
                    nVar.a = cVar.readInt();
                    nVar.f40099b = cVar.readInt();
                    nVar.f40100c = cVar.readInt();
                    nVar.f40101d = cVar.readInt();
                    List<o> e2 = cVar.e(o.f40104f);
                    nVar.f40102e = e2;
                    if (e2 == null) {
                        nVar.f40102e = new ArrayList();
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
            f40097f = new a();
            f40098g = new b();
        }

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                nVar.f40099b = SwanAppConfigData.t(optJSONObject.optString("selectedColor", "black"));
                nVar.f40100c = SwanAppConfigData.t(optJSONObject.optString("borderStyle", "black"));
                nVar.f40101d = SwanAppConfigData.t(optJSONObject.optString("backgroundColor", "white"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    if (length > 5) {
                        length = 5;
                    }
                    nVar.f40102e = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        nVar.f40102e.add(o.b(optJSONArray.optJSONObject(i2)));
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
                boolean unused = SwanAppConfigData.v;
                n nVar = new n();
                nVar.f40102e = new ArrayList();
                return nVar;
            }
            return (n) invokeV.objValue;
        }

        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f40102e == null) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f40102e.size(); i2++) {
                    if (TextUtils.equals(this.f40102e.get(i2).a, str)) {
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
                List<o> list = this.f40102e;
                return list != null && list.size() >= 2;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class o {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<o> f40103e;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<o> f40104f;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f40105b;

        /* renamed from: c  reason: collision with root package name */
        public String f40106c;

        /* renamed from: d  reason: collision with root package name */
        public String f40107d;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.f<o> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull o oVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar, dVar) == null) {
                    dVar.f(oVar.a);
                    dVar.f(oVar.f40105b);
                    dVar.f(oVar.f40106c);
                    dVar.f(oVar.f40107d);
                }
            }
        }

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.e<o> {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public o a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    o oVar = new o();
                    oVar.a = cVar.g();
                    oVar.f40105b = cVar.g();
                    oVar.f40106c = cVar.g();
                    oVar.f40107d = cVar.g();
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
            f40103e = new a();
            f40104f = new b();
        }

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                oVar.f40105b = jSONObject.optString("iconPath");
                oVar.f40106c = jSONObject.optString("selectedIconPath");
                oVar.f40107d = jSONObject.optString("text");
                return oVar;
            }
            return (o) invokeL.objValue;
        }

        public static o c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                boolean unused = SwanAppConfigData.v;
                return new o();
            }
            return (o) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.e<p> f40108b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.p0.a.d2.n.f<p> f40109c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* loaded from: classes9.dex */
        public static class a extends c.a.p0.a.d2.n.e<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
            @Override // c.a.p0.a.d2.n.e
            /* renamed from: b */
            public p a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
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

        /* loaded from: classes9.dex */
        public static class b extends c.a.p0.a.d2.n.f<p> {
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
            @Override // c.a.p0.a.d2.n.f
            /* renamed from: b */
            public void a(@NonNull p pVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
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
            f40108b = new a();
            f40109c = new b();
        }

        public p() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        v = c.a.p0.a.k.a;
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
                swanAppConfigData.f40066j = g.c(jSONObject, file);
                swanAppConfigData.f40065i = g.d(jSONObject, file);
                swanAppConfigData.f40067k = d.a(jSONObject, file);
                swanAppConfigData.m = jSONObject.optString("remote_debug_plugins");
                JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    swanAppConfigData.l = c.a.p0.a.w1.h.b.k(optJSONArray.toString(), false);
                }
                swanAppConfigData.a = jSONObject.optBoolean("debug");
                swanAppConfigData.f40058b = e.b(jSONObject);
                l d2 = l.d(jSONObject, file);
                swanAppConfigData.f40059c = d2;
                swanAppConfigData.f40060d = m.c(jSONObject, d2);
                swanAppConfigData.f40061e = c.a.p0.a.d2.n.g.a(jSONObject);
                swanAppConfigData.f40062f = n.b(jSONObject);
                swanAppConfigData.f40063g = j.b(jSONObject);
                swanAppConfigData.f40064h = c.a.a(jSONObject);
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
            } catch (JSONException unused) {
                boolean z = v;
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
            File file2 = new File(file, c.a.p0.a.c1.a.n().a() + "_app.json");
            if (file2.exists()) {
                String E = c.a.p0.w.d.E(file2);
                if (TextUtils.isEmpty(E)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(E);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.f40061e = c.a.p0.a.d2.n.g.a(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.f40062f = n.b(jSONObject2);
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
                    String str2 = "parseColor failed: Unknown color " + str;
                }
                if (y.containsKey(str)) {
                    return y.get(str).intValue();
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final void b(g gVar, List<c.a.p0.a.w1.g.c> list) {
        List<c.a.p0.a.w1.g.c> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, list) == null) || gVar == null || list == null || (list2 = gVar.a) == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public List<c.a.p0.a.w1.g.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            d dVar = this.f40067k;
            if (dVar != null && dVar.a.size() > 0) {
                arrayList.addAll(this.f40067k.a);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? l() ? this.f40058b.a.get(0) : "" : (String) invokeV.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        List<k> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            l lVar = this.f40059c;
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
            String b2 = c.a.p0.a.f2.f.o0.j.b(o0.f(str));
            if (!TextUtils.isEmpty(b2)) {
                if (c.a.p0.a.w1.c.a.k(b2)) {
                    return "dynamicLib";
                }
                if (q(b2)) {
                    return o(b2) ? "independent" : "subNormal";
                }
            }
            return FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        }
        return (String) invokeL.objValue;
    }

    public List<c.a.p0.a.w1.g.c> i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 == 3) {
                ArrayList arrayList = new ArrayList();
                b(this.f40066j, arrayList);
                return arrayList;
            } else if (i2 == 4) {
                ArrayList arrayList2 = new ArrayList();
                b(this.f40065i, arrayList2);
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
            l lVar = this.f40059c;
            return (lVar == null || lVar.a == null || lVar.f40094d == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e eVar = this.f40058b;
            return (eVar == null || (list = eVar.a) == null || list.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            l lVar = this.f40059c;
            return (lVar == null || lVar.a == null || lVar.f40093c == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n nVar = this.f40062f;
            return nVar != null && nVar.e();
        }
        return invokeV.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? k() && this.f40059c.f40094d.containsKey(str) : invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? (l() && this.f40058b.c(str)) || (m() && this.f40059c.f40093c.containsKey(str)) : invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? m() && this.f40059c.f40093c.containsKey(str) : invokeL.booleanValue;
    }

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            n nVar = this.f40062f;
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
