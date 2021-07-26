package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
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
import d.a.o0.a.a2.n.c;
import d.a.o0.a.v2.o0;
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
/* loaded from: classes3.dex */
public class SwanAppConfigData {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final d.a.o0.a.a2.n.f<SwanAppConfigData> s;
    public static final d.a.o0.a.a2.n.e<SwanAppConfigData> t;
    public static final HashMap<String, Integer> u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f11499a;

    /* renamed from: b  reason: collision with root package name */
    public d f11500b;

    /* renamed from: c  reason: collision with root package name */
    public j f11501c;

    /* renamed from: d  reason: collision with root package name */
    public k f11502d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a.a2.n.g f11503e;

    /* renamed from: f  reason: collision with root package name */
    public l f11504f;

    /* renamed from: g  reason: collision with root package name */
    public h f11505g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f11506h;

    /* renamed from: i  reason: collision with root package name */
    public f f11507i;
    public f j;
    public List<d.a.o0.n.h.h> k;
    public String l;
    public String m;
    public g n;
    public e o;
    @NonNull
    public List<String> p;
    public c q;

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

    /* loaded from: classes3.dex */
    public static class a extends d.a.o0.a.a2.n.f<SwanAppConfigData> {
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
        @Override // d.a.o0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull SwanAppConfigData swanAppConfigData, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppConfigData, dVar) == null) {
                dVar.writeBoolean(swanAppConfigData.f11499a);
                dVar.c(swanAppConfigData.f11500b, d.f11512c);
                dVar.c(swanAppConfigData.f11501c, j.f11533f);
                dVar.c(swanAppConfigData.f11502d, k.f11538b);
                dVar.c(swanAppConfigData.f11503e, d.a.o0.a.a2.n.g.s);
                dVar.c(swanAppConfigData.f11504f, l.f11541f);
                dVar.c(swanAppConfigData.f11505g, h.f11523b);
                dVar.c(swanAppConfigData.f11506h, c.a.f43919e);
                dVar.c(swanAppConfigData.f11507i, f.f11517b);
                dVar.c(swanAppConfigData.j, f.f11517b);
                dVar.f(swanAppConfigData.l);
                dVar.c(swanAppConfigData.n, g.f11521c);
                dVar.c(swanAppConfigData.o, e.f11514b);
                dVar.g(swanAppConfigData.p);
                dVar.c(swanAppConfigData.q, c.f11509c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.a.o0.a.a2.n.e<SwanAppConfigData> {
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
        @Override // d.a.o0.a.a2.n.e
        /* renamed from: c */
        public SwanAppConfigData b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                SwanAppConfigData swanAppConfigData = new SwanAppConfigData(null);
                swanAppConfigData.f11499a = cVar.readBoolean();
                swanAppConfigData.f11500b = (d) cVar.o(d.f11511b);
                j jVar = (j) cVar.o(j.f11532e);
                swanAppConfigData.f11501c = jVar;
                if (jVar == null) {
                    swanAppConfigData.f11501c = j.e();
                }
                swanAppConfigData.f11502d = (k) cVar.o(k.f11539c);
                swanAppConfigData.f11503e = (d.a.o0.a.a2.n.g) cVar.o(d.a.o0.a.a2.n.g.t);
                swanAppConfigData.f11504f = (l) cVar.o(l.f11542g);
                swanAppConfigData.f11505g = (h) cVar.o(h.f11524c);
                swanAppConfigData.f11506h = (c.a) cVar.o(c.a.f43920f);
                swanAppConfigData.f11507i = (f) cVar.o(f.f11518c);
                swanAppConfigData.j = (f) cVar.o(f.f11518c);
                String r = cVar.r();
                swanAppConfigData.l = r;
                if (!TextUtils.isEmpty(r)) {
                    swanAppConfigData.k = d.a.o0.a.t1.g.b.k(swanAppConfigData.l, false);
                }
                swanAppConfigData.n = (g) cVar.o(g.f11520b);
                swanAppConfigData.o = (e) cVar.o(e.f11515c);
                swanAppConfigData.p = cVar.t(Collections.emptyList());
                swanAppConfigData.q = (c) cVar.o(c.f11508b);
                return swanAppConfigData;
            }
            return (SwanAppConfigData) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<c> f11508b;

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<c> f11509c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f11510a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.e<c> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public c b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    c cVar2 = new c();
                    cVar2.f11510a = cVar.readBoolean();
                    return cVar2;
                }
                return (c) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.f<c> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull c cVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, dVar) == null) {
                    dVar.writeBoolean(cVar.f11510a);
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
            f11508b = new a();
            f11509c = new b();
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
                cVar.f11510a = optJSONObject.optBoolean("enableStore");
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<d> f11511b;

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<d> f11512c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<String> f11513a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.e<d> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public d b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    d dVar = new d();
                    dVar.f11513a = cVar.t(Collections.emptyList());
                    return dVar;
                }
                return (d) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.f<d> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull d dVar, @NonNull d.a.o0.a.b1.d dVar2) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, dVar2) == null) {
                    dVar2.g(dVar.f11513a);
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
            f11511b = new a();
            f11512c = new b();
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
                dVar.f11513a = new ArrayList(optJSONArray.length());
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    dVar.f11513a.add(optJSONArray.optString(i2));
                }
                return dVar;
            }
            return (d) invokeL.objValue;
        }

        public static d d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (SwanAppConfigData.r) {
                    Log.w("SwanAppConfigData", "PageConfig createNullObject()");
                }
                d dVar = new d();
                dVar.f11513a = new ArrayList();
                return dVar;
            }
            return (d) invokeV.objValue;
        }

        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                List<String> list = this.f11513a;
                return list != null && list.contains(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<e> f11514b;

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<e> f11515c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Map<String, String>> f11516a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.f<e> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.swan.apps.runtime.config.SwanAppConfigData$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0180a extends d.a.o0.a.a2.n.f<Map<String, String>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C0180a(a aVar) {
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
                @Override // d.a.o0.a.a2.n.f
                /* renamed from: c */
                public void b(@NonNull Map<String, String> map, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull e eVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, dVar) == null) {
                    dVar.e(eVar.f11516a, new C0180a(this));
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.e<e> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* loaded from: classes3.dex */
            public class a extends d.a.o0.a.a2.n.e<Map<String, String>> {
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
                @Override // d.a.o0.a.a2.n.e
                /* renamed from: c */
                public Map<String, String> b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public e b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, Map<String, String>> q = cVar.q(new a(this));
                    if (q == null) {
                        return e.d();
                    }
                    e eVar = new e();
                    eVar.f11516a = q;
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
            f11514b = new a();
            f11515c = new b();
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
                d2.f11516a = new HashMap();
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
                    d2.f11516a.put(next, hashMap);
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
                eVar.f11516a = new HashMap();
                return eVar;
            }
            return (e) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<f> f11517b;

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<f> f11518c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d.a.o0.a.t1.f.a> f11519a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.f<f> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull f fVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, dVar) == null) {
                    dVar.d(fVar.f11519a, d.a.o0.a.t1.f.a.m);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.e<f> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public f b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    List<d.a.o0.a.t1.f.a> p = cVar.p(d.a.o0.a.t1.f.a.l);
                    if (p == null) {
                        return null;
                    }
                    f fVar = new f();
                    fVar.f11519a = p;
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
            f11517b = new a();
            f11518c = new b();
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
                    fVar.f11519a = new ArrayList();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        d.a.o0.a.t1.f.a aVar = new d.a.o0.a.t1.f.a(optJSONObject.optJSONObject(next), i2);
                        aVar.f47921e = next;
                        if (file != null && !TextUtils.isEmpty(aVar.j)) {
                            aVar.j = new File(file, aVar.j).getAbsolutePath();
                        }
                        fVar.f11519a.add(aVar);
                    }
                }
                return fVar;
            }
            return (f) invokeLLIL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<g> f11520b;

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<g> f11521c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f11522a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.e<g> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public g b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, String> v = cVar.v();
                    if (v == null) {
                        return g.d();
                    }
                    g gVar = new g();
                    gVar.f11522a = v;
                    return gVar;
                }
                return (g) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.f<g> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull g gVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                    dVar.h(gVar.f11522a);
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
            f11520b = new a();
            f11521c = new b();
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
                            if (!d2.f11522a.containsKey(optString)) {
                                d2.f11522a.put(optString, optString2);
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
                gVar.f11522a = new HashMap();
                return gVar;
            }
            return (g) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<h> f11523b;

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<h> f11524c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f11525a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.f<h> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull h hVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, dVar) == null) {
                    dVar.writeBoolean(hVar.f11525a);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.e<h> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public h b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    h hVar = new h();
                    hVar.f11525a = cVar.readBoolean();
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
            f11523b = new a();
            f11524c = new b();
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
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
                if (optJSONObject == null) {
                    return c();
                }
                d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
                String str = i2 != null ? i2.f43885f : "";
                h hVar = new h();
                hVar.f11525a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
                if (optJSONObject2 != null) {
                    d.a.o0.a.b2.a.c.u(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                    if (optJSONObject3 != null) {
                        d.a.o0.a.b2.a.c.s(str, optJSONObject3);
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
                if (SwanAppConfigData.r) {
                    Log.w("SwanAppConfigData", "SettingConfig createNullObject()");
                }
                h hVar = new h();
                hVar.f11525a = true;
                return hVar;
            }
            return (h) invokeV.objValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                SwanAppConfigData s = d.a.o0.a.g1.f.V().s();
                if (s == null) {
                    return true;
                }
                h hVar = s.f11505g;
                d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
                boolean d2 = d.a.o0.a.v.a.d(i2 != null ? i2.N() : null);
                boolean d3 = d.a.o0.a.e0.f.e.e.d();
                boolean d4 = d.a.o0.a.h0.a.d();
                boolean G = d.a.o0.a.u1.a.a.G();
                boolean C = d.a.o0.a.u1.a.a.C();
                if (SwanAppConfigData.r) {
                    Log.d("SwanAppConfigData", "isDevelop: " + d2 + " isRemoteDebug: " + d3 + " isMobileDebug: " + d4 + " urlCheck: " + hVar.f11525a);
                }
                return (d2 || d3 || d4 || G || C) && !hVar.f11525a;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final String f11526d;

        /* renamed from: e  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<i> f11527e;

        /* renamed from: f  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<i> f11528f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f11529a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f11530b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11531c;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.e<i> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public i b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    i iVar = new i();
                    iVar.f11529a = cVar.r();
                    iVar.f11530b = cVar.t(Collections.emptyList());
                    iVar.f11531c = cVar.readBoolean();
                    return iVar;
                }
                return (i) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.f<i> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull i iVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, dVar) == null) {
                    dVar.f(iVar.f11529a);
                    dVar.g(iVar.f11530b);
                    dVar.writeBoolean(iVar.f11531c);
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
            f11526d = File.separator;
            f11527e = new a();
            f11528f = new b();
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
            this.f11531c = false;
        }

        public static i c(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2, File file) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, map, map2, file)) == null) {
                if (jSONObject != null && map != null) {
                    i iVar = new i();
                    iVar.f11529a = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                    iVar.f11531c = jSONObject.optBoolean("independent");
                    JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        iVar.f11530b = new ArrayList();
                        for (int i2 = 0; i2 < length; i2++) {
                            String optString = optJSONArray.optString(i2);
                            iVar.f11530b.add(optString);
                            if (!TextUtils.isEmpty(iVar.f11529a) && !TextUtils.isEmpty(optString)) {
                                String str = (!iVar.f11529a.endsWith(f11526d) && !optString.startsWith(f11526d)) ? iVar.f11529a + f11526d + optString : iVar.f11529a + optString;
                                map.put(str, iVar.f11529a);
                                if (iVar.f11531c) {
                                    map2.put(str, iVar.f11529a);
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
                iVar.f11530b = new ArrayList();
                return iVar;
            }
            return (i) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            List<String> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.f11529a) || (list = this.f11530b) == null || list.size() <= 0) {
                    return null;
                }
                String str = this.f11530b.get(0);
                if (this.f11529a.endsWith(f11526d)) {
                    String str2 = this.f11529a;
                    this.f11529a = str2.substring(0, str2.length() - 1);
                }
                if (str.startsWith(f11526d)) {
                    str = str.substring(1);
                }
                return this.f11529a + f11526d + str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<j> f11532e;

        /* renamed from: f  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<j> f11533f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<i> f11534a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, Boolean> f11535b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f11536c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f11537d;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.e<j> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public j b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    j jVar = new j();
                    List<i> p = cVar.p(i.f11527e);
                    jVar.f11534a = p;
                    if (p == null) {
                        jVar.f11534a = new ArrayList();
                    }
                    Map<String, Boolean> g2 = cVar.g();
                    jVar.f11535b = g2;
                    if (g2 == null) {
                        jVar.f11535b = new HashMap();
                    }
                    Map<String, String> v = cVar.v();
                    jVar.f11536c = v;
                    if (v == null) {
                        jVar.f11536c = new HashMap();
                    }
                    Map<String, String> v2 = cVar.v();
                    jVar.f11537d = v2;
                    if (v2 == null) {
                        jVar.f11537d = new HashMap();
                    }
                    return jVar;
                }
                return (j) invokeL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.f<j> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull j jVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, dVar) == null) {
                    dVar.d(jVar.f11534a, i.f11528f);
                    dVar.a(jVar.f11535b);
                    dVar.h(jVar.f11536c);
                    dVar.h(jVar.f11537d);
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
            f11532e = new a();
            f11533f = new b();
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
                    jVar.f11534a = new ArrayList();
                    jVar.f11536c = new HashMap();
                    jVar.f11535b = new HashMap();
                    jVar.f11537d = new HashMap();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            jVar.f11534a.add(i.c(optJSONObject, jVar.f11536c, jVar.f11537d, file));
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
                jVar.f11534a = new ArrayList();
                jVar.f11536c = new HashMap();
                jVar.f11535b = new HashMap();
                jVar.f11537d = new HashMap();
                return jVar;
            }
            return (j) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<k> f11538b;

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<k> f11539c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f11540a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.f<k> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull k kVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar, dVar) == null) {
                    dVar.h(kVar.f11540a);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.e<k> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public k b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, String> v = cVar.v();
                    if (v == null) {
                        return k.d();
                    }
                    k kVar = new k();
                    kVar.f11540a = v;
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
            f11538b = new a();
            f11539c = new b();
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
                if (jSONObject != null && jVar != null && (list = jVar.f11534a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return d();
                    }
                    k kVar = new k();
                    kVar.f11540a = new HashMap();
                    for (i iVar : jVar.f11534a) {
                        if (iVar != null && !TextUtils.isEmpty(iVar.f11529a)) {
                            Map<String, String> map = kVar.f11540a;
                            String str = iVar.f11529a;
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
                kVar.f11540a = new HashMap();
                return kVar;
            }
            return (k) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<l> f11541f;

        /* renamed from: g  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<l> f11542g;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f11543a;

        /* renamed from: b  reason: collision with root package name */
        public int f11544b;

        /* renamed from: c  reason: collision with root package name */
        public int f11545c;

        /* renamed from: d  reason: collision with root package name */
        public int f11546d;

        /* renamed from: e  reason: collision with root package name */
        public List<m> f11547e;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.f<l> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull l lVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, dVar) == null) {
                    dVar.writeInt(lVar.f11543a);
                    dVar.writeInt(lVar.f11544b);
                    dVar.writeInt(lVar.f11545c);
                    dVar.writeInt(lVar.f11546d);
                    dVar.d(lVar.f11547e, m.f11548e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.e<l> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public l b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    l lVar = new l();
                    lVar.f11543a = cVar.readInt();
                    lVar.f11544b = cVar.readInt();
                    lVar.f11545c = cVar.readInt();
                    lVar.f11546d = cVar.readInt();
                    List<m> p = cVar.p(m.f11549f);
                    lVar.f11547e = p;
                    if (p == null) {
                        lVar.f11547e = new ArrayList();
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
            f11541f = new a();
            f11542g = new b();
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
                lVar.f11543a = SwanAppConfigData.s(optJSONObject.optString("color", "#999999"));
                lVar.f11544b = SwanAppConfigData.s(optJSONObject.optString("selectedColor", "black"));
                lVar.f11545c = SwanAppConfigData.s(optJSONObject.optString("borderStyle", "black"));
                lVar.f11546d = SwanAppConfigData.s(optJSONObject.optString("backgroundColor", "white"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    if (length > 5) {
                        length = 5;
                    }
                    lVar.f11547e = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        lVar.f11547e.add(m.b(optJSONArray.optJSONObject(i2)));
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
                if (SwanAppConfigData.r) {
                    Log.w("SwanAppConfigData", "TabBarConfig createNullObject() ");
                }
                l lVar = new l();
                lVar.f11547e = new ArrayList();
                return lVar;
            }
            return (l) invokeV.objValue;
        }

        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f11547e == null) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f11547e.size(); i2++) {
                    if (TextUtils.equals(this.f11547e.get(i2).f11550a, str)) {
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
                List<m> list = this.f11547e;
                return list != null && list.size() >= 2;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.f<m> f11548e;

        /* renamed from: f  reason: collision with root package name */
        public static final d.a.o0.a.a2.n.e<m> f11549f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f11550a;

        /* renamed from: b  reason: collision with root package name */
        public String f11551b;

        /* renamed from: c  reason: collision with root package name */
        public String f11552c;

        /* renamed from: d  reason: collision with root package name */
        public String f11553d;

        /* loaded from: classes3.dex */
        public static class a extends d.a.o0.a.a2.n.f<m> {
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
            @Override // d.a.o0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull m mVar, @NonNull d.a.o0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, dVar) == null) {
                    dVar.f(mVar.f11550a);
                    dVar.f(mVar.f11551b);
                    dVar.f(mVar.f11552c);
                    dVar.f(mVar.f11553d);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.o0.a.a2.n.e<m> {
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
            @Override // d.a.o0.a.a2.n.e
            /* renamed from: c */
            public m b(@NonNull d.a.o0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    m mVar = new m();
                    mVar.f11550a = cVar.r();
                    mVar.f11551b = cVar.r();
                    mVar.f11552c = cVar.r();
                    mVar.f11553d = cVar.r();
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
            f11548e = new a();
            f11549f = new b();
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
                mVar.f11550a = jSONObject.optString("pagePath");
                mVar.f11551b = jSONObject.optString("iconPath");
                mVar.f11552c = jSONObject.optString("selectedIconPath");
                mVar.f11553d = jSONObject.optString("text");
                return mVar;
            }
            return (m) invokeL.objValue;
        }

        public static m c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (SwanAppConfigData.r) {
                    Log.w("SwanAppConfigData", "TabItem createNullObject() ");
                }
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
        r = d.a.o0.a.k.f46335a;
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
                swanAppConfigData.j = f.c(jSONObject, file);
                swanAppConfigData.f11507i = f.d(jSONObject, file);
                swanAppConfigData.l = jSONObject.optString("remote_debug_plugins");
                JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    swanAppConfigData.k = d.a.o0.a.t1.g.b.k(optJSONArray.toString(), false);
                }
                swanAppConfigData.f11499a = jSONObject.optBoolean("debug");
                swanAppConfigData.f11500b = d.b(jSONObject);
                j d2 = j.d(jSONObject, file);
                swanAppConfigData.f11501c = d2;
                swanAppConfigData.f11502d = k.c(jSONObject, d2);
                swanAppConfigData.f11503e = d.a.o0.a.a2.n.g.a(jSONObject);
                swanAppConfigData.f11504f = l.b(jSONObject);
                swanAppConfigData.f11505g = h.b(jSONObject);
                swanAppConfigData.f11506h = c.a.a(jSONObject);
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
            } catch (JSONException e2) {
                if (r) {
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
            File file2 = new File(file, d.a.o0.a.c1.a.m().a() + "_app.json");
            if (file2.exists()) {
                String D = d.a.o0.t.d.D(file2);
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(D);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.f11503e = d.a.o0.a.a2.n.g.a(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.f11504f = l.b(jSONObject2);
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
                    Log.e("SwanAppConfigData", "parseColor failed: Unknown color " + str);
                }
                if (u.containsKey(str)) {
                    return u.get(str).intValue();
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final void b(f fVar, List<d.a.o0.a.t1.f.a> list) {
        List<d.a.o0.a.t1.f.a> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, list) == null) || fVar == null || list == null || (list2 = fVar.f11519a) == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k() ? this.f11500b.f11513a.get(0) : "" : (String) invokeV.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        List<i> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            j jVar = this.f11501c;
            if (jVar != null && (list = jVar.f11534a) != null) {
                for (i iVar : list) {
                    if (TextUtils.equals(iVar.f11529a, str)) {
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
            String b2 = d.a.o0.a.c2.f.p0.j.b(o0.f(str));
            if (!TextUtils.isEmpty(b2)) {
                if (d.a.o0.a.t1.b.a.e(b2)) {
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

    public List<d.a.o0.a.t1.f.a> h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 == 3) {
                ArrayList arrayList = new ArrayList();
                b(this.j, arrayList);
                return arrayList;
            } else if (i2 == 4) {
                ArrayList arrayList2 = new ArrayList();
                b(this.f11507i, arrayList2);
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
            if (gVar == null || gVar.f11522a == null) {
                return str;
            }
            String f2 = o0.f(str);
            String str2 = this.n.f11522a.get(f2);
            return TextUtils.isEmpty(str2) ? str : str.replaceFirst(f2, str2);
        }
        return (String) invokeL.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j jVar = this.f11501c;
            return (jVar == null || jVar.f11534a == null || jVar.f11537d == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d dVar = this.f11500b;
            return (dVar == null || (list = dVar.f11513a) == null || list.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j jVar = this.f11501c;
            return (jVar == null || jVar.f11534a == null || jVar.f11536c == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            l lVar = this.f11504f;
            return lVar != null && lVar.e();
        }
        return invokeV.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? j() && this.f11501c.f11537d.containsKey(str) : invokeL.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? (k() && this.f11500b.c(str)) || (l() && this.f11501c.f11536c.containsKey(str)) : invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? l() && this.f11501c.f11536c.containsKey(str) : invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            l lVar = this.f11504f;
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
