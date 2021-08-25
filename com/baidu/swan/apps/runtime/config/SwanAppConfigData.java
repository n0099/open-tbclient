package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a2.n.c;
import c.a.o0.a.v2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public class SwanAppConfigData {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final c.a.o0.a.a2.n.f<SwanAppConfigData> s;
    public static final c.a.o0.a.a2.n.e<SwanAppConfigData> t;
    public static final HashMap<String, Integer> u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f46438a;

    /* renamed from: b  reason: collision with root package name */
    public d f46439b;

    /* renamed from: c  reason: collision with root package name */
    public j f46440c;

    /* renamed from: d  reason: collision with root package name */
    public k f46441d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.a2.n.g f46442e;

    /* renamed from: f  reason: collision with root package name */
    public l f46443f;

    /* renamed from: g  reason: collision with root package name */
    public h f46444g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f46445h;

    /* renamed from: i  reason: collision with root package name */
    public f f46446i;

    /* renamed from: j  reason: collision with root package name */
    public f f46447j;
    public List<c.a.o0.n.h.h> k;
    public String l;
    public String m;
    public g n;
    public e o;
    @NonNull
    public List<String> p;
    public c q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class a extends c.a.o0.a.a2.n.f<SwanAppConfigData> {
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
        @Override // c.a.o0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull SwanAppConfigData swanAppConfigData, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppConfigData, dVar) == null) {
                dVar.writeBoolean(swanAppConfigData.f46438a);
                dVar.c(swanAppConfigData.f46439b, d.f46452c);
                dVar.c(swanAppConfigData.f46440c, j.f46473f);
                dVar.c(swanAppConfigData.f46441d, k.f46478b);
                dVar.c(swanAppConfigData.f46442e, c.a.o0.a.a2.n.g.s);
                dVar.c(swanAppConfigData.f46443f, l.f46481f);
                dVar.c(swanAppConfigData.f46444g, h.f46463b);
                dVar.c(swanAppConfigData.f46445h, c.a.f4566e);
                dVar.c(swanAppConfigData.f46446i, f.f46457b);
                dVar.c(swanAppConfigData.f46447j, f.f46457b);
                dVar.f(swanAppConfigData.l);
                dVar.c(swanAppConfigData.n, g.f46461c);
                dVar.c(swanAppConfigData.o, e.f46454b);
                dVar.g(swanAppConfigData.p);
                dVar.c(swanAppConfigData.q, c.f46449c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends c.a.o0.a.a2.n.e<SwanAppConfigData> {
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
        @Override // c.a.o0.a.a2.n.e
        /* renamed from: c */
        public SwanAppConfigData b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                SwanAppConfigData swanAppConfigData = new SwanAppConfigData(null);
                swanAppConfigData.f46438a = cVar.readBoolean();
                swanAppConfigData.f46439b = (d) cVar.o(d.f46451b);
                j jVar = (j) cVar.o(j.f46472e);
                swanAppConfigData.f46440c = jVar;
                if (jVar == null) {
                    swanAppConfigData.f46440c = j.e();
                }
                swanAppConfigData.f46441d = (k) cVar.o(k.f46479c);
                swanAppConfigData.f46442e = (c.a.o0.a.a2.n.g) cVar.o(c.a.o0.a.a2.n.g.t);
                swanAppConfigData.f46443f = (l) cVar.o(l.f46482g);
                swanAppConfigData.f46444g = (h) cVar.o(h.f46464c);
                swanAppConfigData.f46445h = (c.a) cVar.o(c.a.f4567f);
                swanAppConfigData.f46446i = (f) cVar.o(f.f46458c);
                swanAppConfigData.f46447j = (f) cVar.o(f.f46458c);
                String r = cVar.r();
                swanAppConfigData.l = r;
                if (!TextUtils.isEmpty(r)) {
                    swanAppConfigData.k = c.a.o0.a.t1.g.b.k(swanAppConfigData.l, false);
                }
                swanAppConfigData.n = (g) cVar.o(g.f46460b);
                swanAppConfigData.o = (e) cVar.o(e.f46455c);
                swanAppConfigData.p = cVar.t(Collections.emptyList());
                swanAppConfigData.q = (c) cVar.o(c.f46448b);
                return swanAppConfigData;
            }
            return (SwanAppConfigData) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<c> f46448b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<c> f46449c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f46450a;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.e<c> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public c b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    c cVar2 = new c();
                    cVar2.f46450a = cVar.readBoolean();
                    return cVar2;
                }
                return (c) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.f<c> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull c cVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, dVar) == null) {
                    dVar.writeBoolean(cVar.f46450a);
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
            f46448b = new a();
            f46449c = new b();
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
                cVar.f46450a = optJSONObject.optBoolean("enableStore");
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<d> f46451b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<d> f46452c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<String> f46453a;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.e<d> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public d b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    d dVar = new d();
                    dVar.f46453a = cVar.t(Collections.emptyList());
                    return dVar;
                }
                return (d) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.f<d> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull d dVar, @NonNull c.a.o0.a.b1.d dVar2) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, dVar2) == null) {
                    dVar2.g(dVar.f46453a);
                }
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
            f46451b = new a();
            f46452c = new b();
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

        public static d b(JSONObject jSONObject) {
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
                d dVar = new d();
                dVar.f46453a = new ArrayList(optJSONArray.length());
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    dVar.f46453a.add(optJSONArray.optString(i2));
                }
                return dVar;
            }
            return (d) invokeL.objValue;
        }

        public static d d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                boolean unused = SwanAppConfigData.r;
                d dVar = new d();
                dVar.f46453a = new ArrayList();
                return dVar;
            }
            return (d) invokeV.objValue;
        }

        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                List<String> list = this.f46453a;
                return list != null && list.contains(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<e> f46454b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<e> f46455c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Map<String, String>> f46456a;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.f<e> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.swan.apps.runtime.config.SwanAppConfigData$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C1736a extends c.a.o0.a.a2.n.f<Map<String, String>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C1736a(a aVar) {
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
                @Override // c.a.o0.a.a2.n.f
                /* renamed from: c */
                public void b(@NonNull Map<String, String> map, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull e eVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, dVar) == null) {
                    dVar.e(eVar.f46456a, new C1736a(this));
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.e<e> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* loaded from: classes6.dex */
            public class a extends c.a.o0.a.a2.n.e<Map<String, String>> {
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
                @Override // c.a.o0.a.a2.n.e
                /* renamed from: c */
                public Map<String, String> b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? cVar.v() : (Map) invokeL.objValue;
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public e b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, Map<String, String>> q = cVar.q(new a(this));
                    if (q == null) {
                        return e.d();
                    }
                    e eVar = new e();
                    eVar.f46456a = q;
                    return eVar;
                }
                return (e) invokeL.objValue;
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
            f46454b = new a();
            f46455c = new b();
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

        public static e c(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
                e d2 = d();
                if (jSONObject == null) {
                    return d2;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("permission");
                if (optJSONObject == null) {
                    return null;
                }
                d2.f46456a = new HashMap();
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
                    d2.f46456a.put(next, hashMap);
                }
                return d2;
            }
            return (e) invokeL.objValue;
        }

        public static e d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                e eVar = new e();
                eVar.f46456a = new HashMap();
                return eVar;
            }
            return (e) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<f> f46457b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<f> f46458c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<c.a.o0.a.t1.f.a> f46459a;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.f<f> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull f fVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, dVar) == null) {
                    dVar.d(fVar.f46459a, c.a.o0.a.t1.f.a.m);
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.e<f> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public f b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    List<c.a.o0.a.t1.f.a> p = cVar.p(c.a.o0.a.t1.f.a.l);
                    if (p == null) {
                        return null;
                    }
                    f fVar = new f();
                    fVar.f46459a = p;
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
            f46457b = new a();
            f46458c = new b();
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

        public static f c(JSONObject jSONObject, File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, file)) == null) ? e(jSONObject, "dynamicLib", 3, file) : (f) invokeLL.objValue;
        }

        public static f d(JSONObject jSONObject, File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, jSONObject, file)) == null) ? e(jSONObject, "plugins", 4, file) : (f) invokeLL.objValue;
        }

        public static f e(JSONObject jSONObject, String str, int i2, File file) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, str, i2, file)) == null) {
                f fVar = null;
                if (jSONObject != null && !TextUtils.isEmpty(str)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(str);
                    if (optJSONObject == null) {
                        return null;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    fVar = new f();
                    fVar.f46459a = new ArrayList();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        c.a.o0.a.t1.f.a aVar = new c.a.o0.a.t1.f.a(optJSONObject.optJSONObject(next), i2);
                        aVar.f8677e = next;
                        if (file != null && !TextUtils.isEmpty(aVar.f8682j)) {
                            aVar.f8682j = new File(file, aVar.f8682j).getAbsolutePath();
                        }
                        fVar.f46459a.add(aVar);
                    }
                }
                return fVar;
            }
            return (f) invokeLLIL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<g> f46460b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<g> f46461c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f46462a;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.e<g> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public g b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, String> v = cVar.v();
                    if (v == null) {
                        return g.d();
                    }
                    g gVar = new g();
                    gVar.f46462a = v;
                    return gVar;
                }
                return (g) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.f<g> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull g gVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                    dVar.h(gVar.f46462a);
                }
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
            f46460b = new a();
            f46461c = new b();
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

        public static g c(JSONObject jSONObject) {
            InterceptResult invokeL;
            JSONArray optJSONArray;
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
                g d2 = d();
                if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("path");
                            String optString2 = optJSONObject.optString("page");
                            if (!d2.f46462a.containsKey(optString)) {
                                d2.f46462a.put(optString, optString2);
                            }
                        }
                    }
                }
                return d2;
            }
            return (g) invokeL.objValue;
        }

        public static g d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                g gVar = new g();
                gVar.f46462a = new HashMap();
                return gVar;
            }
            return (g) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<h> f46463b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<h> f46464c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f46465a;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.f<h> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull h hVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, dVar) == null) {
                    dVar.writeBoolean(hVar.f46465a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.e<h> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public h b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    h hVar = new h();
                    hVar.f46465a = cVar.readBoolean();
                    return hVar;
                }
                return (h) invokeL.objValue;
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
            f46463b = new a();
            f46464c = new b();
        }

        public h() {
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

        public static h b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.f35930j);
                if (optJSONObject == null) {
                    return c();
                }
                c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
                String str = i2 != null ? i2.f4530f : "";
                h hVar = new h();
                hVar.f46465a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
                if (optJSONObject2 != null) {
                    c.a.o0.a.b2.a.c.u(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                    if (optJSONObject3 != null) {
                        c.a.o0.a.b2.a.c.s(str, optJSONObject3);
                    }
                }
                return hVar;
            }
            return (h) invokeL.objValue;
        }

        public static h c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                boolean unused = SwanAppConfigData.r;
                h hVar = new h();
                hVar.f46465a = true;
                return hVar;
            }
            return (h) invokeV.objValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                SwanAppConfigData s = c.a.o0.a.g1.f.V().s();
                if (s == null) {
                    return true;
                }
                h hVar = s.f46444g;
                c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
                boolean d2 = c.a.o0.a.v.a.d(i2 != null ? i2.N() : null);
                boolean d3 = c.a.o0.a.e0.f.e.e.d();
                boolean d4 = c.a.o0.a.h0.a.d();
                boolean G = c.a.o0.a.u1.a.a.G();
                boolean C = c.a.o0.a.u1.a.a.C();
                if (SwanAppConfigData.r) {
                    String str = "isDevelop: " + d2 + " isRemoteDebug: " + d3 + " isMobileDebug: " + d4 + " urlCheck: " + hVar.f46465a;
                }
                return (d2 || d3 || d4 || G || C) && !hVar.f46465a;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final String f46466d;

        /* renamed from: e  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<i> f46467e;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<i> f46468f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f46469a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f46470b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f46471c;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.e<i> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public i b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    i iVar = new i();
                    iVar.f46469a = cVar.r();
                    iVar.f46470b = cVar.t(Collections.emptyList());
                    iVar.f46471c = cVar.readBoolean();
                    return iVar;
                }
                return (i) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.f<i> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull i iVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, dVar) == null) {
                    dVar.f(iVar.f46469a);
                    dVar.g(iVar.f46470b);
                    dVar.writeBoolean(iVar.f46471c);
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
            f46466d = File.separator;
            f46467e = new a();
            f46468f = new b();
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
                    return;
                }
            }
            this.f46471c = false;
        }

        public static i c(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2, File file) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, map, map2, file)) == null) {
                if (jSONObject != null && map != null) {
                    i iVar = new i();
                    iVar.f46469a = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                    iVar.f46471c = jSONObject.optBoolean("independent");
                    JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        iVar.f46470b = new ArrayList();
                        for (int i2 = 0; i2 < length; i2++) {
                            String optString = optJSONArray.optString(i2);
                            iVar.f46470b.add(optString);
                            if (!TextUtils.isEmpty(iVar.f46469a) && !TextUtils.isEmpty(optString)) {
                                String str = (!iVar.f46469a.endsWith(f46466d) && !optString.startsWith(f46466d)) ? iVar.f46469a + f46466d + optString : iVar.f46469a + optString;
                                map.put(str, iVar.f46469a);
                                if (iVar.f46471c) {
                                    map2.put(str, iVar.f46469a);
                                }
                            }
                        }
                    }
                    return iVar;
                }
                return d();
            }
            return (i) invokeLLLL.objValue;
        }

        public static i d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                i iVar = new i();
                iVar.f46470b = new ArrayList();
                return iVar;
            }
            return (i) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            List<String> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.f46469a) || (list = this.f46470b) == null || list.size() <= 0) {
                    return null;
                }
                String str = this.f46470b.get(0);
                if (this.f46469a.endsWith(f46466d)) {
                    String str2 = this.f46469a;
                    this.f46469a = str2.substring(0, str2.length() - 1);
                }
                if (str.startsWith(f46466d)) {
                    str = str.substring(1);
                }
                return this.f46469a + f46466d + str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<j> f46472e;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<j> f46473f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<i> f46474a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, Boolean> f46475b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f46476c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f46477d;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.e<j> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public j b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    j jVar = new j();
                    List<i> p = cVar.p(i.f46467e);
                    jVar.f46474a = p;
                    if (p == null) {
                        jVar.f46474a = new ArrayList();
                    }
                    Map<String, Boolean> g2 = cVar.g();
                    jVar.f46475b = g2;
                    if (g2 == null) {
                        jVar.f46475b = new HashMap();
                    }
                    Map<String, String> v = cVar.v();
                    jVar.f46476c = v;
                    if (v == null) {
                        jVar.f46476c = new HashMap();
                    }
                    Map<String, String> v2 = cVar.v();
                    jVar.f46477d = v2;
                    if (v2 == null) {
                        jVar.f46477d = new HashMap();
                    }
                    return jVar;
                }
                return (j) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.f<j> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull j jVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, dVar) == null) {
                    dVar.d(jVar.f46474a, i.f46468f);
                    dVar.a(jVar.f46475b);
                    dVar.h(jVar.f46476c);
                    dVar.h(jVar.f46477d);
                }
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
            f46472e = new a();
            f46473f = new b();
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

        public static j c(JSONArray jSONArray, @Nullable File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, file)) == null) {
                if (jSONArray != null && jSONArray.length() > 0) {
                    j jVar = new j();
                    jVar.f46474a = new ArrayList();
                    jVar.f46476c = new HashMap();
                    jVar.f46475b = new HashMap();
                    jVar.f46477d = new HashMap();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            jVar.f46474a.add(i.c(optJSONObject, jVar.f46476c, jVar.f46477d, file));
                        }
                    }
                    return jVar;
                }
                return e();
            }
            return (j) invokeLL.objValue;
        }

        public static j d(JSONObject jSONObject, @Nullable File file) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, jSONObject, file)) == null) {
                if (jSONObject == null) {
                    return e();
                }
                return c(jSONObject.optJSONArray("subPackages"), file);
            }
            return (j) invokeLL.objValue;
        }

        public static j e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
                j jVar = new j();
                jVar.f46474a = new ArrayList();
                jVar.f46476c = new HashMap();
                jVar.f46475b = new HashMap();
                jVar.f46477d = new HashMap();
                return jVar;
            }
            return (j) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<k> f46478b;

        /* renamed from: c  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<k> f46479c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f46480a;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.f<k> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull k kVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar, dVar) == null) {
                    dVar.h(kVar.f46480a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.e<k> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public k b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, String> v = cVar.v();
                    if (v == null) {
                        return k.d();
                    }
                    k kVar = new k();
                    kVar.f46480a = v;
                    return kVar;
                }
                return (k) invokeL.objValue;
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
            f46478b = new a();
            f46479c = new b();
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
                }
            }
        }

        public static k c(JSONObject jSONObject, j jVar) {
            InterceptResult invokeLL;
            List<i> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, jVar)) == null) {
                if (jSONObject != null && jVar != null && (list = jVar.f46474a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return d();
                    }
                    k kVar = new k();
                    kVar.f46480a = new HashMap();
                    for (i iVar : jVar.f46474a) {
                        if (iVar != null && !TextUtils.isEmpty(iVar.f46469a)) {
                            Map<String, String> map = kVar.f46480a;
                            String str = iVar.f46469a;
                            map.put(str, optJSONObject.optString(str));
                        }
                    }
                    return kVar;
                }
                return d();
            }
            return (k) invokeLL.objValue;
        }

        public static k d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                k kVar = new k();
                kVar.f46480a = new HashMap();
                return kVar;
            }
            return (k) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<l> f46481f;

        /* renamed from: g  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<l> f46482g;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f46483a;

        /* renamed from: b  reason: collision with root package name */
        public int f46484b;

        /* renamed from: c  reason: collision with root package name */
        public int f46485c;

        /* renamed from: d  reason: collision with root package name */
        public int f46486d;

        /* renamed from: e  reason: collision with root package name */
        public List<m> f46487e;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.f<l> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull l lVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, dVar) == null) {
                    dVar.writeInt(lVar.f46483a);
                    dVar.writeInt(lVar.f46484b);
                    dVar.writeInt(lVar.f46485c);
                    dVar.writeInt(lVar.f46486d);
                    dVar.d(lVar.f46487e, m.f46488e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.e<l> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public l b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    l lVar = new l();
                    lVar.f46483a = cVar.readInt();
                    lVar.f46484b = cVar.readInt();
                    lVar.f46485c = cVar.readInt();
                    lVar.f46486d = cVar.readInt();
                    List<m> p = cVar.p(m.f46489f);
                    lVar.f46487e = p;
                    if (p == null) {
                        lVar.f46487e = new ArrayList();
                    }
                    return lVar;
                }
                return (l) invokeL.objValue;
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
            f46481f = new a();
            f46482g = new b();
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

        public static l b(JSONObject jSONObject) {
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
                l lVar = new l();
                lVar.f46483a = SwanAppConfigData.s(optJSONObject.optString("color", "#999999"));
                lVar.f46484b = SwanAppConfigData.s(optJSONObject.optString("selectedColor", "black"));
                lVar.f46485c = SwanAppConfigData.s(optJSONObject.optString("borderStyle", "black"));
                lVar.f46486d = SwanAppConfigData.s(optJSONObject.optString("backgroundColor", "white"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    if (length > 5) {
                        length = 5;
                    }
                    lVar.f46487e = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        lVar.f46487e.add(m.b(optJSONArray.optJSONObject(i2)));
                    }
                }
                return lVar;
            }
            return (l) invokeL.objValue;
        }

        public static l c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                boolean unused = SwanAppConfigData.r;
                l lVar = new l();
                lVar.f46487e = new ArrayList();
                return lVar;
            }
            return (l) invokeV.objValue;
        }

        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f46487e == null) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f46487e.size(); i2++) {
                    if (TextUtils.equals(this.f46487e.get(i2).f46490a, str)) {
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
                List<m> list = this.f46487e;
                return list != null && list.size() >= 2;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.f<m> f46488e;

        /* renamed from: f  reason: collision with root package name */
        public static final c.a.o0.a.a2.n.e<m> f46489f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f46490a;

        /* renamed from: b  reason: collision with root package name */
        public String f46491b;

        /* renamed from: c  reason: collision with root package name */
        public String f46492c;

        /* renamed from: d  reason: collision with root package name */
        public String f46493d;

        /* loaded from: classes6.dex */
        public static class a extends c.a.o0.a.a2.n.f<m> {
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
            @Override // c.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull m mVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, dVar) == null) {
                    dVar.f(mVar.f46490a);
                    dVar.f(mVar.f46491b);
                    dVar.f(mVar.f46492c);
                    dVar.f(mVar.f46493d);
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends c.a.o0.a.a2.n.e<m> {
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
            @Override // c.a.o0.a.a2.n.e
            /* renamed from: c */
            public m b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    m mVar = new m();
                    mVar.f46490a = cVar.r();
                    mVar.f46491b = cVar.r();
                    mVar.f46492c = cVar.r();
                    mVar.f46493d = cVar.r();
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
            f46488e = new a();
            f46489f = new b();
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

        public static m b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                m mVar = new m();
                mVar.f46490a = jSONObject.optString("pagePath");
                mVar.f46491b = jSONObject.optString("iconPath");
                mVar.f46492c = jSONObject.optString("selectedIconPath");
                mVar.f46493d = jSONObject.optString("text");
                return mVar;
            }
            return (m) invokeL.objValue;
        }

        public static m c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                boolean unused = SwanAppConfigData.r;
                return new m();
            }
            return (m) invokeV.objValue;
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
        r = c.a.o0.a.k.f7049a;
        s = new a();
        t = new b();
        HashMap<String, Integer> hashMap = new HashMap<>();
        u = hashMap;
        hashMap.put(SensorController.KEY_LIGHT, -1);
        u.put(SkinManager.SKIN_TYPE_STR_DARK, -16777216);
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
            swanAppConfigData.m = str;
            try {
                JSONObject jSONObject = new JSONObject(str);
                swanAppConfigData.f46447j = f.c(jSONObject, file);
                swanAppConfigData.f46446i = f.d(jSONObject, file);
                swanAppConfigData.l = jSONObject.optString("remote_debug_plugins");
                JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    swanAppConfigData.k = c.a.o0.a.t1.g.b.k(optJSONArray.toString(), false);
                }
                swanAppConfigData.f46438a = jSONObject.optBoolean("debug");
                swanAppConfigData.f46439b = d.b(jSONObject);
                j d2 = j.d(jSONObject, file);
                swanAppConfigData.f46440c = d2;
                swanAppConfigData.f46441d = k.c(jSONObject, d2);
                swanAppConfigData.f46442e = c.a.o0.a.a2.n.g.a(jSONObject);
                swanAppConfigData.f46443f = l.b(jSONObject);
                swanAppConfigData.f46444g = h.b(jSONObject);
                swanAppConfigData.f46445h = c.a.a(jSONObject);
                swanAppConfigData.n = g.c(jSONObject);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        String optString = optJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            swanAppConfigData.p.add(optString);
                        }
                    }
                }
                swanAppConfigData.o = e.c(jSONObject);
                swanAppConfigData.q = c.b(jSONObject);
                r(swanAppConfigData, jSONObject, file);
                return swanAppConfigData;
            } catch (JSONException unused) {
                boolean z = r;
                return null;
            }
        }
        return (SwanAppConfigData) invokeLL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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

    public static void r(@NonNull SwanAppConfigData swanAppConfigData, @NonNull JSONObject jSONObject, @NonNull File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, swanAppConfigData, jSONObject, file) == null) {
            File file2 = new File(file, c.a.o0.a.c1.a.m().a() + "_app.json");
            if (file2.exists()) {
                String D = c.a.o0.t.d.D(file2);
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(D);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.f46442e = c.a.o0.a.a2.n.g.a(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.f46443f = l.b(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.m = jSONObject.toString();
                } catch (JSONException e2) {
                    if (r) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return Color.parseColor(d(str));
            } catch (Exception unused) {
                if (r) {
                    String str2 = "parseColor failed: Unknown color " + str;
                }
                if (u.containsKey(str)) {
                    return u.get(str).intValue();
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final void b(f fVar, List<c.a.o0.a.t1.f.a> list) {
        List<c.a.o0.a.t1.f.a> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, list) == null) || fVar == null || list == null || (list2 = fVar.f46459a) == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k() ? this.f46439b.f46453a.get(0) : "" : (String) invokeV.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        List<i> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            j jVar = this.f46440c;
            if (jVar != null && (list = jVar.f46474a) != null) {
                for (i iVar : list) {
                    if (TextUtils.equals(iVar.f46469a, str)) {
                        return iVar.e();
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String b2 = c.a.o0.a.c2.f.p0.j.b(o0.f(str));
            if (!TextUtils.isEmpty(b2)) {
                if (c.a.o0.a.t1.b.a.e(b2)) {
                    return "dynamicLib";
                }
                if (p(b2)) {
                    return n(b2) ? "independent" : "subNormal";
                }
            }
            return FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        }
        return (String) invokeL.objValue;
    }

    public List<c.a.o0.a.t1.f.a> h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 == 3) {
                ArrayList arrayList = new ArrayList();
                b(this.f46447j, arrayList);
                return arrayList;
            } else if (i2 == 4) {
                ArrayList arrayList2 = new ArrayList();
                b(this.f46446i, arrayList2);
                return arrayList2;
            } else {
                return null;
            }
        }
        return (List) invokeI.objValue;
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            g gVar = this.n;
            if (gVar == null || gVar.f46462a == null) {
                return str;
            }
            String f2 = o0.f(str);
            String str2 = this.n.f46462a.get(f2);
            return TextUtils.isEmpty(str2) ? str : str.replaceFirst(f2, str2);
        }
        return (String) invokeL.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j jVar = this.f46440c;
            return (jVar == null || jVar.f46474a == null || jVar.f46477d == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d dVar = this.f46439b;
            return (dVar == null || (list = dVar.f46453a) == null || list.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j jVar = this.f46440c;
            return (jVar == null || jVar.f46474a == null || jVar.f46476c == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            l lVar = this.f46443f;
            return lVar != null && lVar.e();
        }
        return invokeV.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? j() && this.f46440c.f46477d.containsKey(str) : invokeL.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? (k() && this.f46439b.c(str)) || (l() && this.f46440c.f46476c.containsKey(str)) : invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? l() && this.f46440c.f46476c.containsKey(str) : invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            l lVar = this.f46443f;
            return lVar != null && lVar.d(str);
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
        this.p = new ArrayList(1);
    }
}
