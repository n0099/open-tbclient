package com.baidu.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arrender.f;
import com.baidu.ar.c;
import com.baidu.ar.d.g;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.g.n;
import com.baidu.ar.libloader.a;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class b {
    private com.baidu.ar.filter.a A;
    private c.a B;
    private f C;
    private Looper b;
    private a c;
    private DefaultParams d;
    private com.baidu.ar.mdl.b e;
    private com.baidu.ar.lua.b f;
    private com.baidu.ar.arrender.c g;
    private g h;
    private com.baidu.ar.imu.c i;
    private ARProxyManager m;
    private Context mContext;
    private List<Integer> n;
    private com.baidu.ar.lua.c o;
    private List<String> p;
    private LuaMsgListener q;
    private List<String> r;
    private LuaMsgListener s;
    private com.baidu.ar.a.b v;
    private ConcurrentHashMap<String, String> j = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> k = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, com.baidu.ar.c> l = new ConcurrentHashMap<>();
    private List<String> t = new ArrayList();
    private final List<String> u = new CopyOnWriteArrayList();
    private boolean w = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1001:
                        c cVar = (c) message.obj;
                        b.this.a(cVar.mClassName, cVar.G, cVar.H, cVar.F, cVar.I, cVar.J);
                        break;
                    case 1002:
                        C0077b c0077b = (C0077b) message.obj;
                        b.this.a(c0077b.mClassName, c0077b.F);
                        break;
                    case 1003:
                        d dVar = (d) message.obj;
                        b.this.a(dVar.mClassName, dVar.I, dVar.J);
                        break;
                }
            } catch (Exception e) {
                com.baidu.ar.g.b.b("AbilityManager", "handleMessage Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0077b {
        HashMap<String, Object> F;
        String mClassName;

        C0077b(String str, HashMap<String, Object> hashMap) {
            this.mClassName = str;
            this.F = hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c {
        HashMap<String, Object> F;
        List<String> G;
        boolean H;
        String I;
        com.baidu.ar.d.e J;
        String mClassName;

        c(String str, String str2, boolean z, HashMap<String, Object> hashMap) {
            this.mClassName = str;
            this.G = new ArrayList();
            this.G.add(str2);
            this.H = z;
            this.F = hashMap;
        }

        c(String str, HashMap<String, Object> hashMap, String str2, com.baidu.ar.d.e eVar) {
            this.mClassName = str;
            this.I = str2;
            this.F = hashMap;
            this.J = eVar;
        }

        c(String str, List<String> list, boolean z, HashMap<String, Object> hashMap) {
            this.mClassName = str;
            this.G = list;
            this.H = z;
            this.F = hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d {
        String I;
        com.baidu.ar.d.e J;
        String mClassName;

        d(String str) {
            this.mClassName = str;
        }

        d(String str, String str2, com.baidu.ar.d.e eVar) {
            this.mClassName = str;
            this.I = str2;
            this.J = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Looper looper, DefaultParams defaultParams, com.baidu.ar.a.b bVar, com.baidu.ar.filter.a aVar) {
        this.mContext = context;
        this.b = looper;
        this.c = new a(looper);
        this.d = defaultParams;
        setMdlModelPath(this.d.getMdlAlgoModelPath());
        this.m = new ARProxyManager();
        this.v = bVar;
        this.A = aVar;
        j();
        this.u.add("ability_common_filter");
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, HashMap<String, Object> hashMap) {
        switch (i) {
            case 301:
                if (this.l == null || !this.u.contains("ability_image_track")) {
                    startAbility("ability_imu", hashMap);
                    return;
                }
                return;
            case 302:
            default:
                return;
            case 303:
                if (this.l == null || !this.u.contains("ability_image_track")) {
                    stopAbility("ability_imu");
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, com.baidu.ar.d.e eVar) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.ar.g.b.b("AbilityManager", "destroyAbility error!!! arClassName is empty!!!");
            return;
        }
        com.baidu.ar.c cVar = this.l.get(str);
        if (cVar == null) {
            com.baidu.ar.g.b.b("AbilityManager", "destroyAbility error!!! As arClassName = " + str + " not active!!!");
            return;
        }
        if (TextUtils.isEmpty(str2) || eVar == null) {
            cVar.o();
        } else {
            cVar.c(str2, eVar);
        }
        if (cVar.p()) {
            if (this.m != null && this.m.b(str)) {
                this.m.d(str);
            }
            this.l.remove(str);
            cVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, HashMap<String, Object> hashMap) {
        com.baidu.ar.c cVar = this.l.get(str);
        if (cVar != null) {
            cVar.adjust(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<String> list, boolean z, HashMap<String, Object> hashMap, String str2, com.baidu.ar.d.e eVar) {
        if (!com.baidu.ar.ability.a.m(str)) {
            com.baidu.ar.g.b.b("AbilityManager", "checkARTypeAuth error!!!");
            return;
        }
        com.baidu.ar.c cVar = this.l.get(str);
        if (cVar != null) {
            com.baidu.ar.g.b.c("AbilityManager", "createARAbility arClassName = " + str + " ARAbility exist!!!");
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
                com.baidu.ar.g.b.b("AbilityManager", "createARAbility createARAbility error!!!");
                return;
            }
            if (list != null) {
                cVar.b(list);
            }
            if (!TextUtils.isEmpty(this.d.getFaceAlgoModelPath())) {
                cVar.setFaceModelPath(this.d.getFaceAlgoModelPath());
            }
            cVar.setMdlConfigParams(this.e);
            cVar.setup(hashMap);
        }
        if (TextUtils.isEmpty(str2) || eVar == null) {
            return;
        }
        cVar.b(str2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, Object> hashMap) {
        String str;
        boolean z = true;
        int a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
        boolean z2 = com.baidu.ar.arplay.c.c.a(hashMap.get("open"), -1) == 1;
        com.baidu.ar.g.b.c("AbilityManager", "operateAbilityById id = " + a2 + " && open = " + z2);
        if (a2 == 5001) {
            z = z2;
            str = "ability_gesture";
        } else if (a2 == 5011) {
            z = z2;
            str = "ability_image_segmentation";
        } else if (a2 == 3005) {
            str = "ability_logo_recognition";
        } else if (a2 == 3006) {
            str = null;
            z = false;
        } else {
            z = z2;
            str = null;
        }
        if (str != null) {
            if (z) {
                startAbility(str, hashMap);
            } else {
                stopAbility(str);
            }
        }
    }

    private void a(final List<String> list) {
        com.baidu.ar.libloader.b.a(ARType.FACE, null, null, new a.InterfaceC0083a() { // from class: com.baidu.ar.b.1
            @Override // com.baidu.ar.libloader.a.InterfaceC0083a
            public void a(ARType aRType, String str, String str2) {
                b.this.u.addAll(b.this.t);
                String str3 = (String) b.this.j.get("ability_face_filter");
                if (TextUtils.isEmpty(str3) || b.this.c == null) {
                    return;
                }
                if (b.this.l.get(str3) == null) {
                    b.this.c.sendMessage(b.this.c.obtainMessage(1001, new c(str3, (List<String>) list, true, (HashMap<String, Object>) null)));
                    return;
                }
                ((com.baidu.ar.c) b.this.l.get(str3)).o();
                ((com.baidu.ar.c) b.this.l.get(str3)).b(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME);
        com.baidu.ar.g.b.c("AbilityManager", "operateAbilityByEvent eventName = " + str);
        if (!"ability_operation".equals(str)) {
            String str2 = com.baidu.ar.ability.b.bw.get(str);
            if (!TextUtils.isEmpty(str2)) {
                startAbility(str2, hashMap);
                return;
            }
            String str3 = com.baidu.ar.ability.b.bx.get(str);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c(HashMap<String, Object> hashMap) {
        if ("ability_operation".equals((String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME))) {
            String str = (String) hashMap.get("ability_name");
            if (TextUtils.isEmpty(str) || !com.baidu.ar.ability.b.bv.contains(str)) {
                return;
            }
            com.baidu.ar.g.b.c("AbilityManager", "operateFilterState abilityName = " + str);
            String str2 = (String) hashMap.get("ability_action");
            if ("open".equals(str2) && "close".equals(str2)) {
                boolean equals = "open".equals(str2);
                if (this.A != null) {
                    if ("ability_makeup_filter".equals(str)) {
                        this.A.a(FilterNode.makeupFilter, equals);
                    } else if ("ability_face_filter".equals(str)) {
                        this.A.a(FilterNode.faceFilter, equals);
                    } else if ("ability_beauty_filter".equals(str)) {
                        this.A.a(FilterNode.skinFilter, equals);
                    } else if ("ability_lut_filter".equals(str)) {
                        this.A.a(FilterNode.lutFilter, equals);
                    }
                    this.A.eG();
                }
            }
        }
    }

    private com.baidu.ar.c e(String str) {
        com.baidu.ar.c cVar = (com.baidu.ar.c) n.aS(str);
        if (cVar == null) {
            com.baidu.ar.g.b.b("AbilityManager", "createARAbility error!!!");
            return null;
        }
        this.l.put(str, cVar);
        cVar.a(this.mContext, this.b);
        cVar.a(this.h, this.g, this.A);
        cVar.a(this.f);
        cVar.a(this.i);
        cVar.a(this.B);
        if (this.v != null) {
            cVar.a(this.v.ad());
        }
        if (this.m == null || !this.m.b(str)) {
            return cVar;
        }
        this.m.a(cVar, str);
        return cVar;
    }

    private void f(String str) {
        if (this.u.contains(str)) {
            com.baidu.ar.g.b.c("AbilityManager", "enableAbility() abilityName " + str + " has enabled!!!");
            return;
        }
        this.u.add(str);
        if ((str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) && this.d.isUseMakeupFilter()) {
            this.u.add("ability_makeup_filter");
        }
    }

    private void g(String str) {
        com.baidu.ar.c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.j != null) {
            String str2 = this.j.get(str);
            if (!TextUtils.isEmpty(str2) && this.l != null && (cVar = this.l.get(str2)) != null) {
                cVar.i(str);
            }
        }
        if (!this.u.contains(str)) {
            com.baidu.ar.g.b.c("AbilityManager", "disableAbility() abilityName " + str + " has disabled!!!");
            return;
        }
        if (str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) {
            this.u.remove("ability_makeup_filter");
        }
        this.u.remove(str);
    }

    private void h() {
        if (this.f == null) {
            return;
        }
        this.n = Arrays.asList(301, 303);
        this.o = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.b.2
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                b.this.a(i, hashMap);
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return b.this.n;
            }
        };
        this.f.c(this.o);
        this.p = Arrays.asList("id");
        this.q = new LuaMsgListener() { // from class: com.baidu.ar.b.3
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return b.this.p;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                b.this.a(hashMap);
            }
        };
        this.f.fl().addLuaMsgListener(this.q);
        this.r = Arrays.asList(LuaMessageHelper.KEY_EVENT_NAME);
        this.s = new LuaMsgListener() { // from class: com.baidu.ar.b.4
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return b.this.r;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                b.this.b(hashMap);
                b.this.c(hashMap);
            }
        };
        this.f.fl().addLuaMsgListener(this.s);
    }

    private void i() {
        if (this.f != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("ability_name", this.u);
            this.f.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    private void j() {
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = getClass().getClassLoader();
        for (Map.Entry<String, String> entry : com.baidu.ar.ability.b.bu.entrySet()) {
            if (n.a(entry.getValue(), classLoader)) {
                this.j.put(entry.getKey(), entry.getValue());
            }
        }
        this.k.putAll(com.baidu.ar.ability.b.bz);
        com.baidu.ar.g.b.k("AbilityManager", "initSupportedARClasses mSupportedARClasses = " + this.j.values());
        com.baidu.ar.g.b.c("AbilityManager", "initSupportedARClasses time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void k() {
        this.B = new c.a() { // from class: com.baidu.ar.b.5
            @Override // com.baidu.ar.c.a
            public boolean a(String str, com.baidu.ar.d.e eVar) {
                if (b.this.k != null && b.this.k.containsKey(str)) {
                    String str2 = (String) b.this.k.get(str);
                    if (!TextUtils.isEmpty(str2) && b.this.c != null) {
                        b.this.c.sendMessage(b.this.c.obtainMessage(1003, new d(str2, str, eVar)));
                        return true;
                    }
                }
                return false;
            }

            @Override // com.baidu.ar.c.a
            public boolean a(String str, com.baidu.ar.d.e eVar, HashMap<String, Object> hashMap) {
                if (b.this.k != null && b.this.k.containsKey(str)) {
                    String str2 = (String) b.this.k.get(str);
                    if (!TextUtils.isEmpty(str2) && b.this.c != null) {
                        b.this.c.sendMessage(b.this.c.obtainMessage(1001, new c(str2, hashMap, str, eVar)));
                        return true;
                    }
                }
                return false;
            }
        };
    }

    private void l() {
        this.C = new f() { // from class: com.baidu.ar.b.6
            @Override // com.baidu.ar.arrender.f
            public void a(boolean z) {
                for (com.baidu.ar.c cVar : b.this.l.values()) {
                    cVar.a(z);
                }
            }
        };
        this.g.setCameraSwitchListener(this.C);
    }

    private List<String> m() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.t) {
            String str2 = this.j.get(str);
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ARType aRType) {
        if (aRType != ARType.FACE) {
            g();
        } else if (!com.baidu.ar.ability.a.n("ability_face_model")) {
            return;
        } else {
            if (this.d.isUseFaceFilter()) {
                f("ability_face_model");
            }
        }
        this.A.a(FilterParam.SkinFilter.whiten, aRType == ARType.FACE || this.d.isUseBeautyFilter());
        String str = com.baidu.ar.ability.b.by.get(aRType);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.j.get(str);
        if (!TextUtils.isEmpty(str2) && this.l.get(str2) != null) {
            this.l.get(str2).h(str);
        }
        if (this.u.contains(str) || aRType == ARType.IMU || TextUtils.isEmpty(str2) || this.c == null) {
            return;
        }
        this.u.add(str);
        this.c.sendMessage(this.c.obtainMessage(1001, new c(str2, str, false, (HashMap<String, Object>) null)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.ar.lua.b bVar, com.baidu.ar.arrender.c cVar) {
        this.f = bVar;
        this.g = cVar;
        this.g.d(this.u);
        l();
        this.h = new g(cVar, this.b);
        this.i = com.baidu.ar.a.a();
        try {
            if (this.i != null) {
                this.i.setContext(this.mContext);
            }
            h();
        } catch (Exception e) {
            com.baidu.ar.g.b.b("AbilityManager", "setup exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, List<String> list, String str2) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || !n.a(str, getClass().getClassLoader())) {
            return false;
        }
        for (String str3 : list) {
            this.j.put(str3, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.k.put(str2, str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        if (!this.u.contains(str)) {
            com.baidu.ar.g.b.b("AbilityManager", "adjustAbility abilityType = " + str + " not start!!!");
            return false;
        } else if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1002, new C0077b(this.j.get(str), hashMap)));
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.d == null) {
            return;
        }
        this.t.clear();
        this.u.clear();
        this.u.add("ability_common_filter");
        if (this.d.isUseFaceFilter() && com.baidu.ar.ability.a.o("ability_face_filter")) {
            this.t.add("ability_face_filter");
            if (this.A != null) {
                this.A.a((FilterParam) FilterParam.SkinFilter.whiten, true);
                this.A.a(FilterNode.faceFilter, true);
            }
            if (this.w) {
                this.w = false;
                StatisticApi.onEventDebounce(StatisticConstants.EVENT_FILTER_ADJUST, 200L, "");
                StatisticApi.onEventDebounce(StatisticConstants.EVENT_BEAUTIFY_ADJUST, 200L, "");
            }
        }
        if (this.d.isUseMakeupFilter()) {
            if (com.baidu.ar.ability.a.o("ability_makeup_filter")) {
                this.t.add("ability_makeup_filter");
            }
            if (this.A != null) {
                this.A.a(FilterNode.makeupFilter, true);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.m != null) {
            this.m.d();
        }
        ArrayList<String> arrayList = new ArrayList();
        List<String> m = m();
        for (String str : this.u) {
            String str2 = !TextUtils.isEmpty(str) ? this.j.get(str) : null;
            if (!TextUtils.isEmpty(str2) && !m.contains(str2) && !arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        e();
        if (this.c != null) {
            for (String str3 : arrayList) {
                this.c.sendMessage(this.c.obtainMessage(1003, new d(str3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.A != null) {
            this.A.a(FilterNode.faceFilter, false);
            this.A.a(FilterNode.makeupFilter, false);
        }
        if (this.m != null) {
            this.m.d();
        }
        for (String str : this.u) {
            g(str);
        }
        this.u.clear();
        this.u.add("ability_common_filter");
        if (this.c != null) {
            for (Map.Entry<String, com.baidu.ar.c> entry : this.l.entrySet()) {
                this.c.sendMessage(this.c.obtainMessage(1003, new d(entry.getKey())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ARProxyManager getARProxyManager() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getActiveAbilities() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getSupportedAbilities() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.j.entrySet()) {
            arrayList.add(entry.getKey());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAbilityActive(String str) {
        return this.u.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAbilitySupported(String str) {
        return this.j.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCaseCreate(String str) {
        if (this.l.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.l.values()) {
            com.baidu.ar.g.b.c("AbilityManager", "onCaseCreate casePath = " + str);
            cVar.onCaseCreate(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCaseDestroy() {
        if (this.l.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.l.values()) {
            cVar.onCaseDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.l.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.l.values()) {
            cVar.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (this.m != null) {
            this.m.release();
            this.m = null;
        }
        for (com.baidu.ar.c cVar : this.l.values()) {
            cVar.release();
        }
        this.l.clear();
        this.j.clear();
        if (this.f != null && this.f.fl() != null) {
            this.f.d(this.o);
            this.f.fl().removeLuaMsgListener(this.q);
            this.f.fl().removeLuaMsgListener(this.s);
            this.f = null;
            this.o = null;
            this.q = null;
            this.s = null;
        }
        this.n = null;
        this.p = null;
        this.r = null;
        if (this.i != null) {
            this.i.destroy();
            this.i = null;
        }
        if (this.h != null) {
            this.h.release();
            this.h = null;
        }
        this.mContext = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.A = null;
        this.g = null;
        if (this.v != null) {
            this.v = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        if (this.l.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.l.values()) {
            cVar.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMdlModelPath(String str) {
        if (this.e == null) {
            this.e = new com.baidu.ar.mdl.b();
        }
        this.e.a(str, this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        if (!com.baidu.ar.ability.a.n(str)) {
            com.baidu.ar.g.b.b("AbilityManager", "startAbility abilityType = " + str + " is no authorization!!!");
            return false;
        } else if (this.u.contains(str)) {
            com.baidu.ar.g.b.b("AbilityManager", "startAbility abilityType = " + str + " is exist!!!");
            return false;
        } else {
            String str2 = this.j.get(str);
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            f(str);
            if (this.c != null) {
                this.c.sendMessage(this.c.obtainMessage(1001, new c(str2, str, false, hashMap)));
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean stopAbility(String str) {
        g(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : this.u) {
            String str3 = this.j.get(str2);
            if (!TextUtils.isEmpty(str3) && !arrayList.contains(str3)) {
                arrayList.add(str3);
            }
        }
        String str4 = this.j.get(str);
        if (arrayList.contains(str4) || this.c == null) {
            return false;
        }
        this.c.sendMessage(this.c.obtainMessage(1003, new d(str4)));
        return true;
    }
}
