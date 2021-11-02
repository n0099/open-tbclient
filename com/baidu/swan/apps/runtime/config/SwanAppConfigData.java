package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.n.c;
import b.a.p0.a.v2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes8.dex */
public class SwanAppConfigData {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final b.a.p0.a.a2.n.f<SwanAppConfigData> s;
    public static final b.a.p0.a.a2.n.e<SwanAppConfigData> t;
    public static final HashMap<String, Integer> u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f44228a;

    /* renamed from: b  reason: collision with root package name */
    public d f44229b;

    /* renamed from: c  reason: collision with root package name */
    public j f44230c;

    /* renamed from: d  reason: collision with root package name */
    public k f44231d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.a2.n.g f44232e;

    /* renamed from: f  reason: collision with root package name */
    public l f44233f;

    /* renamed from: g  reason: collision with root package name */
    public h f44234g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f44235h;

    /* renamed from: i  reason: collision with root package name */
    public f f44236i;
    public f j;
    public List<b.a.p0.n.h.h> k;
    public String l;
    public String m;
    public g n;
    public e o;
    @NonNull
    public List<String> p;
    public c q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class a extends b.a.p0.a.a2.n.f<SwanAppConfigData> {
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
        @Override // b.a.p0.a.a2.n.f
        /* renamed from: b */
        public void a(@NonNull SwanAppConfigData swanAppConfigData, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppConfigData, dVar) == null) {
                dVar.writeBoolean(swanAppConfigData.f44228a);
                dVar.c(swanAppConfigData.f44229b, d.f44241c);
                dVar.c(swanAppConfigData.f44230c, j.f44262f);
                dVar.c(swanAppConfigData.f44231d, k.f44267b);
                dVar.c(swanAppConfigData.f44232e, b.a.p0.a.a2.n.g.s);
                dVar.c(swanAppConfigData.f44233f, l.f44270f);
                dVar.c(swanAppConfigData.f44234g, h.f44252b);
                dVar.c(swanAppConfigData.f44235h, c.a.f3995e);
                dVar.c(swanAppConfigData.f44236i, f.f44246b);
                dVar.c(swanAppConfigData.j, f.f44246b);
                dVar.f(swanAppConfigData.l);
                dVar.c(swanAppConfigData.n, g.f44250c);
                dVar.c(swanAppConfigData.o, e.f44243b);
                dVar.g(swanAppConfigData.p);
                dVar.c(swanAppConfigData.q, c.f44238c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends b.a.p0.a.a2.n.e<SwanAppConfigData> {
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
        @Override // b.a.p0.a.a2.n.e
        /* renamed from: b */
        public SwanAppConfigData a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                SwanAppConfigData swanAppConfigData = new SwanAppConfigData(null);
                swanAppConfigData.f44228a = cVar.readBoolean();
                swanAppConfigData.f44229b = (d) cVar.d(d.f44240b);
                j jVar = (j) cVar.d(j.f44261e);
                swanAppConfigData.f44230c = jVar;
                if (jVar == null) {
                    swanAppConfigData.f44230c = j.e();
                }
                swanAppConfigData.f44231d = (k) cVar.d(k.f44268c);
                swanAppConfigData.f44232e = (b.a.p0.a.a2.n.g) cVar.d(b.a.p0.a.a2.n.g.t);
                swanAppConfigData.f44233f = (l) cVar.d(l.f44271g);
                swanAppConfigData.f44234g = (h) cVar.d(h.f44253c);
                swanAppConfigData.f44235h = (c.a) cVar.d(c.a.f3996f);
                swanAppConfigData.f44236i = (f) cVar.d(f.f44247c);
                swanAppConfigData.j = (f) cVar.d(f.f44247c);
                String g2 = cVar.g();
                swanAppConfigData.l = g2;
                if (!TextUtils.isEmpty(g2)) {
                    swanAppConfigData.k = b.a.p0.a.t1.g.b.k(swanAppConfigData.l, false);
                }
                swanAppConfigData.n = (g) cVar.d(g.f44249b);
                swanAppConfigData.o = (e) cVar.d(e.f44244c);
                swanAppConfigData.p = cVar.k(Collections.emptyList());
                swanAppConfigData.q = (c) cVar.d(c.f44237b);
                return swanAppConfigData;
            }
            return (SwanAppConfigData) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<c> f44237b;

        /* renamed from: c  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<c> f44238c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f44239a;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.e<c> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public c a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    c cVar2 = new c();
                    cVar2.f44239a = cVar.readBoolean();
                    return cVar2;
                }
                return (c) invokeL.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.f<c> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull c cVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, dVar) == null) {
                    dVar.writeBoolean(cVar.f44239a);
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
            f44237b = new a();
            f44238c = new b();
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
                cVar.f44239a = optJSONObject.optBoolean("enableStore");
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<d> f44240b;

        /* renamed from: c  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<d> f44241c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<String> f44242a;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.e<d> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public d a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    d dVar = new d();
                    dVar.f44242a = cVar.k(Collections.emptyList());
                    return dVar;
                }
                return (d) invokeL.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.f<d> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull d dVar, @NonNull b.a.p0.a.b1.d dVar2) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, dVar2) == null) {
                    dVar2.g(dVar.f44242a);
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
            f44240b = new a();
            f44241c = new b();
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
                dVar.f44242a = new ArrayList(optJSONArray.length());
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    dVar.f44242a.add(optJSONArray.optString(i2));
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
                dVar.f44242a = new ArrayList();
                return dVar;
            }
            return (d) invokeV.objValue;
        }

        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                List<String> list = this.f44242a;
                return list != null && list.contains(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<e> f44243b;

        /* renamed from: c  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<e> f44244c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Map<String, String>> f44245a;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.f<e> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.swan.apps.runtime.config.SwanAppConfigData$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C1699a extends b.a.p0.a.a2.n.f<Map<String, String>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C1699a(a aVar) {
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
                @Override // b.a.p0.a.a2.n.f
                /* renamed from: b */
                public void a(@NonNull Map<String, String> map, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull e eVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, dVar) == null) {
                    dVar.e(eVar.f44245a, new C1699a(this));
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.e<e> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* loaded from: classes8.dex */
            public class a extends b.a.p0.a.a2.n.e<Map<String, String>> {
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
                @Override // b.a.p0.a.a2.n.e
                /* renamed from: b */
                public Map<String, String> a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public e a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, Map<String, String>> f2 = cVar.f(new a(this));
                    if (f2 == null) {
                        return e.d();
                    }
                    e eVar = new e();
                    eVar.f44245a = f2;
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
            f44243b = new a();
            f44244c = new b();
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
                d2.f44245a = new HashMap();
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
                    d2.f44245a.put(next, hashMap);
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
                eVar.f44245a = new HashMap();
                return eVar;
            }
            return (e) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<f> f44246b;

        /* renamed from: c  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<f> f44247c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<b.a.p0.a.t1.f.a> f44248a;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.f<f> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull f fVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, dVar) == null) {
                    dVar.d(fVar.f44248a, b.a.p0.a.t1.f.a.m);
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.e<f> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public f a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    List<b.a.p0.a.t1.f.a> e2 = cVar.e(b.a.p0.a.t1.f.a.l);
                    if (e2 == null) {
                        return null;
                    }
                    f fVar = new f();
                    fVar.f44248a = e2;
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
            f44246b = new a();
            f44247c = new b();
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
                    fVar.f44248a = new ArrayList();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        b.a.p0.a.t1.f.a aVar = new b.a.p0.a.t1.f.a(optJSONObject.optJSONObject(next), i2);
                        aVar.f7979e = next;
                        if (file != null && !TextUtils.isEmpty(aVar.j)) {
                            aVar.j = new File(file, aVar.j).getAbsolutePath();
                        }
                        fVar.f44248a.add(aVar);
                    }
                }
                return fVar;
            }
            return (f) invokeLLIL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<g> f44249b;

        /* renamed from: c  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<g> f44250c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f44251a;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.e<g> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public g a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, String> l = cVar.l();
                    if (l == null) {
                        return g.d();
                    }
                    g gVar = new g();
                    gVar.f44251a = l;
                    return gVar;
                }
                return (g) invokeL.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.f<g> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull g gVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                    dVar.h(gVar.f44251a);
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
            f44249b = new a();
            f44250c = new b();
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
                            if (!d2.f44251a.containsKey(optString)) {
                                d2.f44251a.put(optString, optString2);
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
                gVar.f44251a = new HashMap();
                return gVar;
            }
            return (g) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<h> f44252b;

        /* renamed from: c  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<h> f44253c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f44254a;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.f<h> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull h hVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, dVar) == null) {
                    dVar.writeBoolean(hVar.f44254a);
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.e<h> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public h a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    h hVar = new h();
                    hVar.f44254a = cVar.readBoolean();
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
            f44252b = new a();
            f44253c = new b();
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
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.s);
                if (optJSONObject == null) {
                    return c();
                }
                b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
                String str = i2 != null ? i2.f3961f : "";
                h hVar = new h();
                hVar.f44254a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
                if (optJSONObject2 != null) {
                    b.a.p0.a.b2.a.c.u(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                    if (optJSONObject3 != null) {
                        b.a.p0.a.b2.a.c.s(str, optJSONObject3);
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
                hVar.f44254a = true;
                return hVar;
            }
            return (h) invokeV.objValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                SwanAppConfigData r = b.a.p0.a.g1.f.T().r();
                if (r == null) {
                    return true;
                }
                h hVar = r.f44234g;
                b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
                boolean d2 = b.a.p0.a.v.a.d(i2 != null ? i2.M() : null);
                boolean d3 = b.a.p0.a.e0.f.e.e.d();
                boolean d4 = b.a.p0.a.h0.a.d();
                boolean G = b.a.p0.a.u1.a.a.G();
                boolean C = b.a.p0.a.u1.a.a.C();
                if (SwanAppConfigData.r) {
                    String str = "isDevelop: " + d2 + " isRemoteDebug: " + d3 + " isMobileDebug: " + d4 + " urlCheck: " + hVar.f44254a;
                }
                return (d2 || d3 || d4 || G || C) && !hVar.f44254a;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final String f44255d;

        /* renamed from: e  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<i> f44256e;

        /* renamed from: f  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<i> f44257f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f44258a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f44259b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f44260c;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.e<i> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public i a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    i iVar = new i();
                    iVar.f44258a = cVar.g();
                    iVar.f44259b = cVar.k(Collections.emptyList());
                    iVar.f44260c = cVar.readBoolean();
                    return iVar;
                }
                return (i) invokeL.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.f<i> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull i iVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, dVar) == null) {
                    dVar.f(iVar.f44258a);
                    dVar.g(iVar.f44259b);
                    dVar.writeBoolean(iVar.f44260c);
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
            f44255d = File.separator;
            f44256e = new a();
            f44257f = new b();
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
            this.f44260c = false;
        }

        public static i c(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2, File file) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, map, map2, file)) == null) {
                if (jSONObject != null && map != null) {
                    i iVar = new i();
                    iVar.f44258a = jSONObject.optString("root");
                    iVar.f44260c = jSONObject.optBoolean("independent");
                    JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        iVar.f44259b = new ArrayList();
                        for (int i2 = 0; i2 < length; i2++) {
                            String optString = optJSONArray.optString(i2);
                            iVar.f44259b.add(optString);
                            if (!TextUtils.isEmpty(iVar.f44258a) && !TextUtils.isEmpty(optString)) {
                                String str = (!iVar.f44258a.endsWith(f44255d) && !optString.startsWith(f44255d)) ? iVar.f44258a + f44255d + optString : iVar.f44258a + optString;
                                map.put(str, iVar.f44258a);
                                if (iVar.f44260c) {
                                    map2.put(str, iVar.f44258a);
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
                iVar.f44259b = new ArrayList();
                return iVar;
            }
            return (i) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            List<String> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.f44258a) || (list = this.f44259b) == null || list.size() <= 0) {
                    return null;
                }
                String str = this.f44259b.get(0);
                if (this.f44258a.endsWith(f44255d)) {
                    String str2 = this.f44258a;
                    this.f44258a = str2.substring(0, str2.length() - 1);
                }
                if (str.startsWith(f44255d)) {
                    str = str.substring(1);
                }
                return this.f44258a + f44255d + str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<j> f44261e;

        /* renamed from: f  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<j> f44262f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<i> f44263a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, Boolean> f44264b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f44265c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f44266d;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.e<j> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public j a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    j jVar = new j();
                    List<i> e2 = cVar.e(i.f44256e);
                    jVar.f44263a = e2;
                    if (e2 == null) {
                        jVar.f44263a = new ArrayList();
                    }
                    Map<String, Boolean> a2 = cVar.a();
                    jVar.f44264b = a2;
                    if (a2 == null) {
                        jVar.f44264b = new HashMap();
                    }
                    Map<String, String> l = cVar.l();
                    jVar.f44265c = l;
                    if (l == null) {
                        jVar.f44265c = new HashMap();
                    }
                    Map<String, String> l2 = cVar.l();
                    jVar.f44266d = l2;
                    if (l2 == null) {
                        jVar.f44266d = new HashMap();
                    }
                    return jVar;
                }
                return (j) invokeL.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.f<j> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull j jVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, dVar) == null) {
                    dVar.d(jVar.f44263a, i.f44257f);
                    dVar.a(jVar.f44264b);
                    dVar.h(jVar.f44265c);
                    dVar.h(jVar.f44266d);
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
            f44261e = new a();
            f44262f = new b();
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
                    jVar.f44263a = new ArrayList();
                    jVar.f44265c = new HashMap();
                    jVar.f44264b = new HashMap();
                    jVar.f44266d = new HashMap();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            jVar.f44263a.add(i.c(optJSONObject, jVar.f44265c, jVar.f44266d, file));
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
                jVar.f44263a = new ArrayList();
                jVar.f44265c = new HashMap();
                jVar.f44264b = new HashMap();
                jVar.f44266d = new HashMap();
                return jVar;
            }
            return (j) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<k> f44267b;

        /* renamed from: c  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<k> f44268c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f44269a;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.f<k> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull k kVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar, dVar) == null) {
                    dVar.h(kVar.f44269a);
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.e<k> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public k a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    Map<String, String> l = cVar.l();
                    if (l == null) {
                        return k.d();
                    }
                    k kVar = new k();
                    kVar.f44269a = l;
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
            f44267b = new a();
            f44268c = new b();
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
                if (jSONObject != null && jVar != null && (list = jVar.f44263a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return d();
                    }
                    k kVar = new k();
                    kVar.f44269a = new HashMap();
                    for (i iVar : jVar.f44263a) {
                        if (iVar != null && !TextUtils.isEmpty(iVar.f44258a)) {
                            Map<String, String> map = kVar.f44269a;
                            String str = iVar.f44258a;
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
                kVar.f44269a = new HashMap();
                return kVar;
            }
            return (k) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<l> f44270f;

        /* renamed from: g  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<l> f44271g;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f44272a;

        /* renamed from: b  reason: collision with root package name */
        public int f44273b;

        /* renamed from: c  reason: collision with root package name */
        public int f44274c;

        /* renamed from: d  reason: collision with root package name */
        public int f44275d;

        /* renamed from: e  reason: collision with root package name */
        public List<m> f44276e;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.f<l> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull l lVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, dVar) == null) {
                    dVar.writeInt(lVar.f44272a);
                    dVar.writeInt(lVar.f44273b);
                    dVar.writeInt(lVar.f44274c);
                    dVar.writeInt(lVar.f44275d);
                    dVar.d(lVar.f44276e, m.f44277e);
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.e<l> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public l a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    l lVar = new l();
                    lVar.f44272a = cVar.readInt();
                    lVar.f44273b = cVar.readInt();
                    lVar.f44274c = cVar.readInt();
                    lVar.f44275d = cVar.readInt();
                    List<m> e2 = cVar.e(m.f44278f);
                    lVar.f44276e = e2;
                    if (e2 == null) {
                        lVar.f44276e = new ArrayList();
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
            f44270f = new a();
            f44271g = new b();
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
                lVar.f44272a = SwanAppConfigData.s(optJSONObject.optString("color", "#999999"));
                lVar.f44273b = SwanAppConfigData.s(optJSONObject.optString("selectedColor", "black"));
                lVar.f44274c = SwanAppConfigData.s(optJSONObject.optString("borderStyle", "black"));
                lVar.f44275d = SwanAppConfigData.s(optJSONObject.optString("backgroundColor", "white"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    if (length > 5) {
                        length = 5;
                    }
                    lVar.f44276e = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        lVar.f44276e.add(m.b(optJSONArray.optJSONObject(i2)));
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
                lVar.f44276e = new ArrayList();
                return lVar;
            }
            return (l) invokeV.objValue;
        }

        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f44276e == null) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f44276e.size(); i2++) {
                    if (TextUtils.equals(this.f44276e.get(i2).f44279a, str)) {
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
                List<m> list = this.f44276e;
                return list != null && list.size() >= 2;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.f<m> f44277e;

        /* renamed from: f  reason: collision with root package name */
        public static final b.a.p0.a.a2.n.e<m> f44278f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f44279a;

        /* renamed from: b  reason: collision with root package name */
        public String f44280b;

        /* renamed from: c  reason: collision with root package name */
        public String f44281c;

        /* renamed from: d  reason: collision with root package name */
        public String f44282d;

        /* loaded from: classes8.dex */
        public static class a extends b.a.p0.a.a2.n.f<m> {
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
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull m mVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, dVar) == null) {
                    dVar.f(mVar.f44279a);
                    dVar.f(mVar.f44280b);
                    dVar.f(mVar.f44281c);
                    dVar.f(mVar.f44282d);
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends b.a.p0.a.a2.n.e<m> {
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
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public m a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    m mVar = new m();
                    mVar.f44279a = cVar.g();
                    mVar.f44280b = cVar.g();
                    mVar.f44281c = cVar.g();
                    mVar.f44282d = cVar.g();
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
            f44277e = new a();
            f44278f = new b();
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
                mVar.f44279a = jSONObject.optString("pagePath");
                mVar.f44280b = jSONObject.optString("iconPath");
                mVar.f44281c = jSONObject.optString("selectedIconPath");
                mVar.f44282d = jSONObject.optString("text");
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
        r = b.a.p0.a.k.f6397a;
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
                swanAppConfigData.f44236i = f.d(jSONObject, file);
                swanAppConfigData.l = jSONObject.optString("remote_debug_plugins");
                JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    swanAppConfigData.k = b.a.p0.a.t1.g.b.k(optJSONArray.toString(), false);
                }
                swanAppConfigData.f44228a = jSONObject.optBoolean("debug");
                swanAppConfigData.f44229b = d.b(jSONObject);
                j d2 = j.d(jSONObject, file);
                swanAppConfigData.f44230c = d2;
                swanAppConfigData.f44231d = k.c(jSONObject, d2);
                swanAppConfigData.f44232e = b.a.p0.a.a2.n.g.a(jSONObject);
                swanAppConfigData.f44233f = l.b(jSONObject);
                swanAppConfigData.f44234g = h.b(jSONObject);
                swanAppConfigData.f44235h = c.a.a(jSONObject);
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
            File file2 = new File(file, b.a.p0.a.c1.a.m().a() + "_app.json");
            if (file2.exists()) {
                String D = b.a.p0.t.d.D(file2);
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(D);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.f44232e = b.a.p0.a.a2.n.g.a(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.f44233f = l.b(jSONObject2);
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

    public final void b(f fVar, List<b.a.p0.a.t1.f.a> list) {
        List<b.a.p0.a.t1.f.a> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, list) == null) || fVar == null || list == null || (list2 = fVar.f44248a) == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k() ? this.f44229b.f44242a.get(0) : "" : (String) invokeV.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        List<i> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            j jVar = this.f44230c;
            if (jVar != null && (list = jVar.f44263a) != null) {
                for (i iVar : list) {
                    if (TextUtils.equals(iVar.f44258a, str)) {
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
            String b2 = b.a.p0.a.c2.f.p0.j.b(o0.f(str));
            if (!TextUtils.isEmpty(b2)) {
                if (b.a.p0.a.t1.b.a.e(b2)) {
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

    public List<b.a.p0.a.t1.f.a> h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 == 3) {
                ArrayList arrayList = new ArrayList();
                b(this.j, arrayList);
                return arrayList;
            } else if (i2 == 4) {
                ArrayList arrayList2 = new ArrayList();
                b(this.f44236i, arrayList2);
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
            if (gVar == null || gVar.f44251a == null) {
                return str;
            }
            String f2 = o0.f(str);
            String str2 = this.n.f44251a.get(f2);
            return TextUtils.isEmpty(str2) ? str : str.replaceFirst(f2, str2);
        }
        return (String) invokeL.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j jVar = this.f44230c;
            return (jVar == null || jVar.f44263a == null || jVar.f44266d == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d dVar = this.f44229b;
            return (dVar == null || (list = dVar.f44242a) == null || list.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j jVar = this.f44230c;
            return (jVar == null || jVar.f44263a == null || jVar.f44265c == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            l lVar = this.f44233f;
            return lVar != null && lVar.e();
        }
        return invokeV.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? j() && this.f44230c.f44266d.containsKey(str) : invokeL.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? (k() && this.f44229b.c(str)) || (l() && this.f44230c.f44265c.containsKey(str)) : invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? l() && this.f44230c.f44265c.containsKey(str) : invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            l lVar = this.f44233f;
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
