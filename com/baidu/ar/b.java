package com.baidu.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.g;
import com.baidu.ar.c;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.h.n;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public com.baidu.ar.filter.a B;
    public c.a C;
    public g D;
    public Looper b;
    public a c;
    public DefaultParams d;
    public com.baidu.ar.mdl.b e;
    public com.baidu.ar.lua.b f;
    public com.baidu.ar.arrender.c g;
    public com.baidu.ar.d.g h;
    public com.baidu.ar.imu.c i;
    public ConcurrentHashMap<String, String> j;
    public ConcurrentHashMap<String, String> k;
    public ConcurrentHashMap<String, com.baidu.ar.c> l;
    public ARProxyManager m;
    public Context mContext;
    public List<Integer> n;
    public com.baidu.ar.lua.c o;
    public List<String> p;
    public LuaMsgListener q;
    public List<String> r;
    public LuaMsgListener s;
    public List<String> t;
    public final List<String> u;
    public List<String> v;
    public com.baidu.ar.a.b w;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.F = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    switch (message.what) {
                        case 1001:
                            c cVar = (c) message.obj;
                            this.F.a(cVar.mClassName, cVar.H, cVar.I, cVar.G, cVar.J, cVar.K);
                            return;
                        case 1002:
                            C0051b c0051b = (C0051b) message.obj;
                            this.F.a(c0051b.mClassName, c0051b.G);
                            return;
                        case 1003:
                            d dVar = (d) message.obj;
                            this.F.a(dVar.mClassName, dVar.J, dVar.K);
                            return;
                        default:
                            return;
                    }
                } catch (Exception e) {
                    com.baidu.ar.h.b.b("AbilityManager", "handleMessage Exception: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.baidu.ar.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0051b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b F;
        public HashMap<String, Object> G;
        public String mClassName;

        public C0051b(b bVar, String str, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.F = bVar;
            this.mClassName = str;
            this.G = hashMap;
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b F;
        public HashMap<String, Object> G;
        public List<String> H;
        public boolean I;
        public String J;
        public com.baidu.ar.d.e K;
        public String mClassName;

        public c(b bVar, String str, String str2, boolean z, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, Boolean.valueOf(z), hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.F = bVar;
            this.mClassName = str;
            ArrayList arrayList = new ArrayList();
            this.H = arrayList;
            arrayList.add(str2);
            this.I = z;
            this.G = hashMap;
        }

        public c(b bVar, String str, HashMap<String, Object> hashMap, String str2, com.baidu.ar.d.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, hashMap, str2, eVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.F = bVar;
            this.mClassName = str;
            this.J = str2;
            this.G = hashMap;
            this.K = eVar;
        }

        public c(b bVar, String str, List<String> list, boolean z, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, list, Boolean.valueOf(z), hashMap};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.F = bVar;
            this.mClassName = str;
            this.H = list;
            this.I = z;
            this.G = hashMap;
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b F;
        public String J;
        public com.baidu.ar.d.e K;
        public String mClassName;

        public d(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.F = bVar;
            this.mClassName = str;
        }

        public d(b bVar, String str, String str2, com.baidu.ar.d.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, eVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.F = bVar;
            this.mClassName = str;
            this.J = str2;
            this.K = eVar;
        }
    }

    public b(Context context, Looper looper, DefaultParams defaultParams, com.baidu.ar.a.b bVar, com.baidu.ar.filter.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, looper, defaultParams, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new ConcurrentHashMap<>();
        this.k = new ConcurrentHashMap<>();
        this.l = new ConcurrentHashMap<>();
        this.t = new ArrayList();
        this.u = new CopyOnWriteArrayList();
        this.v = new ArrayList();
        this.A = true;
        this.mContext = context;
        this.b = looper;
        this.c = new a(this, looper);
        this.d = defaultParams;
        setMdlModelPath(defaultParams.getMdlAlgoModelPath());
        this.m = new ARProxyManager();
        this.w = bVar;
        this.B = aVar;
        j();
        this.u.add("ability_common_filter");
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i, hashMap) == null) {
            if (i == 301) {
                if (this.l == null || !this.u.contains("ability_image_track")) {
                    startAbility("ability_imu", hashMap);
                }
            } else if (i != 303) {
            } else {
                if (this.l == null || !this.u.contains("ability_image_track")) {
                    stopAbility("ability_imu");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, com.baidu.ar.d.e eVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, str, str2, eVar) == null) {
            if (TextUtils.isEmpty(str)) {
                str3 = "destroyAbility error!!! arClassName is empty!!!";
            } else {
                com.baidu.ar.c cVar = this.l.get(str);
                if (cVar != null) {
                    if (TextUtils.isEmpty(str2) || eVar == null) {
                        cVar.o();
                    } else {
                        cVar.c(str2, eVar);
                    }
                    if (cVar.p()) {
                        ARProxyManager aRProxyManager = this.m;
                        if (aRProxyManager != null && aRProxyManager.b(str)) {
                            this.m.d(str);
                        }
                        this.l.remove(str);
                        cVar.release();
                        return;
                    }
                    return;
                }
                str3 = "destroyAbility error!!! As arClassName = " + str + " not active!!!";
            }
            com.baidu.ar.h.b.b("AbilityManager", str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, HashMap<String, Object> hashMap) {
        com.baidu.ar.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, str, hashMap) == null) || (cVar = this.l.get(str)) == null) {
            return;
        }
        cVar.adjust(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<String> list, boolean z, HashMap<String, Object> hashMap, String str2, com.baidu.ar.d.e eVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{str, list, Boolean.valueOf(z), hashMap, str2, eVar}) == null) {
            if (com.baidu.ar.ability.a.o(str)) {
                com.baidu.ar.c cVar = this.l.get(str);
                if (cVar != null) {
                    com.baidu.ar.h.b.c("AbilityManager", "createARAbility arClassName = " + str + " ARAbility exist!!!");
                    if (list != null) {
                        if (z) {
                            cVar.o();
                        }
                        cVar.b(list);
                    }
                    cVar.adjust(hashMap);
                } else {
                    cVar = e(str);
                    if (cVar == null) {
                        str3 = "createARAbility createARAbility error!!!";
                    } else {
                        if (list != null) {
                            cVar.b(list);
                        }
                        if (!TextUtils.isEmpty(this.d.getFaceAlgoModelPath())) {
                            cVar.setFaceModelPath(this.d.getFaceAlgoModelPath());
                        }
                        cVar.setMdlConfigParams(this.e);
                        cVar.setup(hashMap);
                    }
                }
                if (TextUtils.isEmpty(str2) || eVar == null) {
                    return;
                }
                cVar.b(str2, eVar);
                return;
            }
            str3 = "checkARTypeAuth error!!!";
            com.baidu.ar.h.b.b("AbilityManager", str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (r0 == 3006) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65547, this, hashMap) != null) {
            return;
        }
        int a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
        boolean z = false;
        boolean z2 = com.baidu.ar.arplay.c.c.a(hashMap.get("open"), -1) == 1;
        com.baidu.ar.h.b.c("AbilityManager", "operateAbilityById id = " + a2 + " && open = " + z2);
        String str = null;
        if (a2 == 5001) {
            str = "ability_gesture";
        } else if (a2 != 5011) {
            if (a2 == 3005) {
                str = "ability_logo_recognition";
                z = true;
            }
            if (str == null) {
                if (z) {
                    startAbility(str, hashMap);
                    return;
                } else {
                    stopAbility(str);
                    return;
                }
            }
            return;
        } else {
            str = "ability_image_segmentation";
        }
        z = z2;
        if (str == null) {
        }
    }

    private void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, list) == null) {
            com.baidu.ar.libloader.a.prepareCaseRes(ARType.FACE, null, null, new ILibLoader.a(this, list) { // from class: com.baidu.ar.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List E;
                public final /* synthetic */ b F;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.F = this;
                    this.E = list;
                }

                @Override // com.baidu.ar.libloader.ILibLoader.a
                public void a(ARType aRType, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, aRType, str, str2) == null) {
                        this.F.u.addAll(this.F.t);
                        String str3 = (String) this.F.j.get("ability_face_filter");
                        if (TextUtils.isEmpty(str3) || this.F.c == null) {
                            return;
                        }
                        if (this.F.l.get(str3) == null) {
                            this.F.c.sendMessage(this.F.c.obtainMessage(1001, new c(this.F, str3, (List<String>) this.E, true, (HashMap<String, Object>) null)));
                            return;
                        }
                        ((com.baidu.ar.c) this.F.l.get(str3)).o();
                        ((com.baidu.ar.c) this.F.l.get(str3)).b(this.E);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, hashMap) == null) {
            String str = (String) hashMap.get("event_name");
            com.baidu.ar.h.b.c("AbilityManager", "operateAbilityByEvent eventName = " + str);
            if (!"ability_operation".equals(str)) {
                String str2 = com.baidu.ar.ability.b.bz.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    startAbility(str2, hashMap);
                    return;
                }
                String str3 = com.baidu.ar.ability.b.bA.get(str);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                stopAbility(str3);
                return;
            }
            String str4 = (String) hashMap.get("ability_name");
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            String str5 = (String) hashMap.get("ability_action");
            if ("open".equals(str5)) {
                startAbility(str4, hashMap);
            } else if ("close".equals(str5)) {
                stopAbility(str4);
            } else if ("adjust".equals(str5)) {
                adjustAbility(str4, hashMap);
            } else if ("query".equals(str5)) {
                i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(HashMap<String, Object> hashMap) {
        com.baidu.ar.filter.a aVar;
        FilterNode filterNode;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, hashMap) == null) && "ability_operation".equals((String) hashMap.get("event_name"))) {
            String str = (String) hashMap.get("ability_name");
            if (TextUtils.isEmpty(str) || !com.baidu.ar.ability.b.by.contains(str)) {
                return;
            }
            com.baidu.ar.h.b.c("AbilityManager", "operateFilterState abilityName = " + str);
            String str2 = (String) hashMap.get("ability_action");
            if ("open".equals(str2) && "close".equals(str2)) {
                boolean equals = "open".equals(str2);
                if (this.B != null) {
                    if ("ability_makeup_filter".equals(str)) {
                        aVar = this.B;
                        filterNode = FilterNode.makeupFilter;
                    } else if ("ability_face_filter".equals(str)) {
                        aVar = this.B;
                        filterNode = FilterNode.faceFilter;
                    } else if (!"ability_beauty_filter".equals(str)) {
                        if ("ability_lut_filter".equals(str)) {
                            aVar = this.B;
                            filterNode = FilterNode.lutFilter;
                        }
                        this.B.eF();
                    } else {
                        aVar = this.B;
                        filterNode = FilterNode.skinFilter;
                    }
                    aVar.a(filterNode, equals);
                    this.B.eF();
                }
            }
        }
    }

    private com.baidu.ar.c e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, str)) == null) {
            com.baidu.ar.c cVar = (com.baidu.ar.c) n.aV(str);
            if (cVar == null) {
                com.baidu.ar.h.b.b("AbilityManager", "createARAbility error!!!");
                return null;
            }
            this.l.put(str, cVar);
            cVar.a(this.mContext, this.b);
            cVar.a(this.h, this.g, this.B);
            cVar.a(this.f);
            cVar.a(this.i);
            cVar.a(this.C);
            com.baidu.ar.a.b bVar = this.w;
            if (bVar != null) {
                cVar.a(bVar.af());
            }
            ARProxyManager aRProxyManager = this.m;
            if (aRProxyManager != null && aRProxyManager.b(str)) {
                this.m.a(cVar, str);
            }
            return cVar;
        }
        return (com.baidu.ar.c) invokeL.objValue;
    }

    private void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            if (this.u.contains(str)) {
                com.baidu.ar.h.b.c("AbilityManager", "enableAbility() abilityName " + str + " has enabled!!!");
                return;
            }
            this.u.add(str);
            if ((str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) && this.d.isUseMakeupFilter()) {
                this.u.add("ability_makeup_filter");
            }
        }
    }

    private void g(String str) {
        ConcurrentHashMap<String, com.baidu.ar.c> concurrentHashMap;
        com.baidu.ar.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap2 = this.j;
        if (concurrentHashMap2 != null) {
            String str2 = concurrentHashMap2.get(str);
            if (!TextUtils.isEmpty(str2) && (concurrentHashMap = this.l) != null && (cVar = concurrentHashMap.get(str2)) != null) {
                cVar.j(str);
            }
        }
        if (this.u.contains(str)) {
            if (str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) {
                this.u.remove("ability_makeup_filter");
            }
            this.u.remove(str);
            return;
        }
        com.baidu.ar.h.b.c("AbilityManager", "disableAbility() abilityName " + str + " has disabled!!!");
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || this.f == null) {
            return;
        }
        this.n = Arrays.asList(301, 303);
        com.baidu.ar.lua.c cVar = new com.baidu.ar.lua.c(this) { // from class: com.baidu.ar.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b F;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.F = this;
            }

            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i, i2, hashMap) == null) {
                    this.F.a(i, hashMap);
                }
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.F.n : (List) invokeV.objValue;
            }
        };
        this.o = cVar;
        this.f.c(cVar);
        this.p = Arrays.asList("id");
        this.q = new LuaMsgListener(this) { // from class: com.baidu.ar.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b F;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.F = this;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.F.p : (List) invokeV.objValue;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                    this.F.a(hashMap);
                }
            }
        };
        this.f.fk().addLuaMsgListener(this.q);
        this.r = Arrays.asList("event_name");
        this.s = new LuaMsgListener(this) { // from class: com.baidu.ar.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b F;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.F = this;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.F.r : (List) invokeV.objValue;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                    this.F.b(hashMap);
                    this.F.c(hashMap);
                }
            }
        };
        this.f.fk().addLuaMsgListener(this.s);
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || this.f == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ability_name", this.u);
        this.f.b(1902, hashMap);
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ClassLoader classLoader = b.class.getClassLoader();
            for (Map.Entry<String, String> entry : com.baidu.ar.ability.b.bx.entrySet()) {
                if (n.a(entry.getValue(), classLoader)) {
                    this.j.put(entry.getKey(), entry.getValue());
                }
            }
            this.k.putAll(com.baidu.ar.ability.b.bC);
            com.baidu.ar.h.b.k("AbilityManager", "initSupportedARClasses mSupportedARClasses = " + this.j.values());
            com.baidu.ar.h.b.c("AbilityManager", "initSupportedARClasses time cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.C = new c.a(this) { // from class: com.baidu.ar.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b F;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.F = this;
                }

                @Override // com.baidu.ar.c.a
                public boolean a(String str, com.baidu.ar.d.e eVar) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, eVar)) == null) {
                        if (this.F.k == null || !this.F.k.containsKey(str)) {
                            return false;
                        }
                        String str2 = (String) this.F.k.get(str);
                        if (TextUtils.isEmpty(str2) || this.F.c == null) {
                            return false;
                        }
                        this.F.c.sendMessage(this.F.c.obtainMessage(1003, new d(this.F, str2, str, eVar)));
                        return true;
                    }
                    return invokeLL.booleanValue;
                }

                @Override // com.baidu.ar.c.a
                public boolean a(String str, com.baidu.ar.d.e eVar, HashMap<String, Object> hashMap) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, eVar, hashMap)) == null) {
                        if (this.F.k == null || !this.F.k.containsKey(str)) {
                            return false;
                        }
                        String str2 = (String) this.F.k.get(str);
                        if (TextUtils.isEmpty(str2) || this.F.c == null) {
                            return false;
                        }
                        this.F.c.sendMessage(this.F.c.obtainMessage(1001, new c(this.F, str2, hashMap, str, eVar)));
                        return true;
                    }
                    return invokeLLL.booleanValue;
                }
            };
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            g gVar = new g(this) { // from class: com.baidu.ar.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b F;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.F = this;
                }

                @Override // com.baidu.ar.arrender.g
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        for (com.baidu.ar.c cVar : this.F.l.values()) {
                            cVar.a(z);
                        }
                    }
                }
            };
            this.D = gVar;
            this.g.setCameraSwitchListener(gVar);
        }
    }

    private List<String> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.t) {
                String str2 = this.j.get(str);
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(ARType aRType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aRType) == null) {
            if (aRType != ARType.FACE) {
                g();
            } else if (!com.baidu.ar.ability.a.p("ability_face_model")) {
                return;
            } else {
                if (this.d.isUseFaceFilter()) {
                    f("ability_face_model");
                }
            }
            this.B.a(FilterParam.SkinFilter.whiten, aRType == ARType.FACE || this.d.isUseBeautyFilter());
            String str = com.baidu.ar.ability.b.bB.get(aRType);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str2 = this.j.get(str);
            if (!TextUtils.isEmpty(str2) && this.l.get(str2) != null) {
                this.l.get(str2).i(str);
            }
            if (this.u.contains(str) || aRType == ARType.IMU || TextUtils.isEmpty(str2) || this.c == null) {
                return;
            }
            this.u.add(str);
            c cVar = new c(this, str2, str, false, (HashMap<String, Object>) null);
            a aVar = this.c;
            aVar.sendMessage(aVar.obtainMessage(1001, cVar));
        }
    }

    public void a(com.baidu.ar.lua.b bVar, com.baidu.ar.arrender.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, cVar) == null) {
            this.f = bVar;
            this.g = cVar;
            cVar.d(this.u);
            l();
            this.h = new com.baidu.ar.d.g(cVar, this.b);
            com.baidu.ar.imu.c a2 = com.baidu.ar.a.a();
            this.i = a2;
            if (a2 != null) {
                try {
                    a2.setContext(this.mContext);
                } catch (Exception e) {
                    com.baidu.ar.h.b.b("AbilityManager", "setup exception: " + e.getMessage());
                    e.printStackTrace();
                    return;
                }
            }
            h();
        }
    }

    public boolean a(String str, HashMap<String, Object> hashMap, boolean z) {
        InterceptResult invokeLLZ;
        StringBuilder sb;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, hashMap, z)) == null) {
            if (com.baidu.ar.ability.a.p(str)) {
                if (z && !this.v.contains(str)) {
                    this.v.add(str);
                }
                if (!this.u.contains(str)) {
                    String str3 = this.j.get(str);
                    if (!TextUtils.isEmpty(str3)) {
                        f(str);
                        if (this.c != null) {
                            c cVar = new c(this, str3, str, false, hashMap);
                            a aVar = this.c;
                            aVar.sendMessage(aVar.obtainMessage(1001, cVar));
                            return true;
                        }
                    }
                    return false;
                }
                sb = new StringBuilder();
                sb.append("startAbility abilityType = ");
                sb.append(str);
                str2 = " is exist!!!";
            } else {
                sb = new StringBuilder();
                sb.append("startAbility abilityType = ");
                sb.append(str);
                str2 = " is no authorization!!!";
            }
            sb.append(str2);
            com.baidu.ar.h.b.b("AbilityManager", sb.toString());
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public boolean a(String str, List<String> list, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, list, str2)) == null) {
            if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || !n.a(str, b.class.getClassLoader())) {
                return false;
            }
            for (String str3 : list) {
                this.j.put(str3, str);
            }
            if (TextUtils.isEmpty(str2)) {
                return true;
            }
            this.k.put(str2, str);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean a(String str, boolean z) {
        InterceptResult invokeLZ;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            if (z && this.v.contains(str)) {
                this.v.remove(str);
            }
            g(str);
            ArrayList arrayList = new ArrayList();
            for (String str2 : this.u) {
                String str3 = this.j.get(str2);
                if (!TextUtils.isEmpty(str3) && !arrayList.contains(str3)) {
                    arrayList.add(str3);
                }
            }
            String str4 = this.j.get(str);
            if (arrayList.contains(str4) || (aVar = this.c) == null) {
                return false;
            }
            aVar.sendMessage(aVar.obtainMessage(1003, new d(this, str4)));
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            if (this.u.contains(str)) {
                if (this.c != null) {
                    C0051b c0051b = new C0051b(this, this.j.get(str), hashMap);
                    a aVar = this.c;
                    aVar.sendMessage(aVar.obtainMessage(1002, c0051b));
                    return true;
                }
                return false;
            }
            com.baidu.ar.h.b.b("AbilityManager", "adjustAbility abilityType = " + str + " not start!!!");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.d == null) {
            return;
        }
        this.t.clear();
        this.u.clear();
        this.u.add("ability_common_filter");
        List<String> list = this.v;
        if (list != null && list.size() > 0) {
            this.u.addAll(this.v);
        }
        if (this.d.isUseFaceFilter() && com.baidu.ar.ability.a.q("ability_face_filter")) {
            this.t.add("ability_face_filter");
            com.baidu.ar.filter.a aVar = this.B;
            if (aVar != null) {
                aVar.a((FilterParam) FilterParam.SkinFilter.whiten, true);
                this.B.a(FilterNode.faceFilter, true);
            }
            if (this.A) {
                this.A = false;
                StatisticApi.onEventDebounce(StatisticConstants.EVENT_FILTER_ADJUST, 200L, "");
                StatisticApi.onEventDebounce(StatisticConstants.EVENT_BEAUTIFY_ADJUST, 200L, "");
            }
        }
        if (this.d.isUseMakeupFilter()) {
            if (com.baidu.ar.ability.a.q("ability_makeup_filter")) {
                this.t.add("ability_makeup_filter");
            }
            com.baidu.ar.filter.a aVar2 = this.B;
            if (aVar2 != null) {
                aVar2.a(FilterNode.makeupFilter, true);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.t.contains("ability_face_filter")) {
            arrayList.add("ability_face_filter");
        }
        if (this.t.contains("ability_makeup_filter")) {
            arrayList.add("ability_makeup_filter");
        }
        if (arrayList.size() > 0) {
            a(arrayList);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ARProxyManager aRProxyManager = this.m;
            if (aRProxyManager != null) {
                aRProxyManager.d();
            }
            ArrayList<String> arrayList = new ArrayList();
            List<String> m = m();
            for (String str : this.u) {
                String str2 = TextUtils.isEmpty(str) ? null : this.j.get(str);
                if (!TextUtils.isEmpty(str2) && !m.contains(str2) && !arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            e();
            if (this.c != null) {
                for (String str3 : arrayList) {
                    a aVar = this.c;
                    aVar.sendMessage(aVar.obtainMessage(1003, new d(this, str3)));
                }
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.baidu.ar.filter.a aVar = this.B;
            if (aVar != null) {
                aVar.a(FilterNode.faceFilter, false);
                this.B.a(FilterNode.makeupFilter, false);
            }
            ARProxyManager aRProxyManager = this.m;
            if (aRProxyManager != null) {
                aRProxyManager.d();
            }
            for (String str : this.u) {
                g(str);
            }
            this.u.clear();
            this.u.add("ability_common_filter");
            List<String> list = this.v;
            if (list != null && list.size() > 0) {
                this.u.addAll(this.v);
            }
            if (this.c != null) {
                for (Map.Entry<String, com.baidu.ar.c> entry : this.l.entrySet()) {
                    if (!h(entry.getKey())) {
                        a aVar2 = this.c;
                        aVar2.sendMessage(aVar2.obtainMessage(1003, new d(this, entry.getKey())));
                    }
                }
            }
        }
    }

    public ARProxyManager getARProxyManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (ARProxyManager) invokeV.objValue;
    }

    public List<String> getActiveAbilities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.u : (List) invokeV.objValue;
    }

    public List<String> getSupportedAbilities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                arrayList.add(entry.getKey());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (list = this.v) == null) {
                return false;
            }
            for (String str2 : list) {
                if (str.equals(this.j.get(str2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isAbilityActive(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? this.u.contains(str) : invokeL.booleanValue;
    }

    public boolean isAbilitySupported(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.j.get(str) != null : invokeL.booleanValue;
    }

    public void onCaseCreate(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || this.l.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.l.values()) {
            com.baidu.ar.h.b.c("AbilityManager", "onCaseCreate casePath = " + str);
            cVar.onCaseCreate(str);
        }
    }

    public void onCaseDestroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.l.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.l.values()) {
            cVar.onCaseDestroy();
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.l.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.l.values()) {
            cVar.pause();
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ARProxyManager aRProxyManager = this.m;
            if (aRProxyManager != null) {
                aRProxyManager.release();
                this.m = null;
            }
            for (com.baidu.ar.c cVar : this.l.values()) {
                cVar.release();
            }
            this.l.clear();
            this.j.clear();
            com.baidu.ar.lua.b bVar = this.f;
            if (bVar != null && bVar.fk() != null) {
                this.f.d(this.o);
                this.f.fk().removeLuaMsgListener(this.q);
                this.f.fk().removeLuaMsgListener(this.s);
                this.f = null;
                this.o = null;
                this.q = null;
                this.s = null;
            }
            this.n = null;
            this.p = null;
            this.r = null;
            com.baidu.ar.imu.c cVar2 = this.i;
            if (cVar2 != null) {
                cVar2.destroy();
                this.i = null;
            }
            com.baidu.ar.d.g gVar = this.h;
            if (gVar != null) {
                gVar.release();
                this.h = null;
            }
            List<String> list = this.v;
            if (list != null) {
                list.clear();
                this.v = null;
            }
            this.mContext = null;
            this.b = null;
            this.d = null;
            this.e = null;
            this.B = null;
            this.g = null;
            if (this.w != null) {
                this.w = null;
            }
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.l.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.l.values()) {
            cVar.resume();
        }
    }

    public void setMdlModelPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (this.e == null) {
                this.e = new com.baidu.ar.mdl.b();
            }
            this.e.a(str, this.mContext);
        }
    }

    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, hashMap)) == null) ? a(str, hashMap, false) : invokeLL.booleanValue;
    }

    public boolean stopAbility(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? a(str, false) : invokeL.booleanValue;
    }
}
