package com.baidu.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arrender.f;
import com.baidu.ar.c;
import com.baidu.ar.c.g;
import com.baidu.ar.f.l;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
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
/* loaded from: classes3.dex */
public class b {
    private c.a A;
    private f B;
    private a b;
    private DefaultParams c;
    private com.baidu.ar.mdl.b d;
    private com.baidu.ar.lua.b e;
    private com.baidu.ar.arrender.c f;
    private g g;
    private com.baidu.ar.imu.c h;
    private ARProxyManager l;
    private List<Integer> m;
    private Context mContext;
    private com.baidu.ar.lua.c n;
    private List<String> o;
    private LuaMsgListener p;
    private List<String> q;
    private LuaMsgListener r;
    private com.baidu.ar.a.b u;
    private com.baidu.ar.filter.a w;
    private ConcurrentHashMap<String, String> i = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> j = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, com.baidu.ar.c> k = new ConcurrentHashMap<>();
    private List<String> s = new ArrayList();
    private final List<String> t = new CopyOnWriteArrayList();
    private boolean v = true;
    private ARPEngine.e C = new ARPEngine.e() { // from class: com.baidu.ar.b.1
        @Override // com.baidu.ar.arplay.core.engine.ARPEngine.e
        public void a(long j) {
            if (b.this.k.isEmpty()) {
                return;
            }
            for (com.baidu.ar.c cVar : b.this.k.values()) {
                cVar.a(j);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1001:
                        C0055b c0055b = (C0055b) message.obj;
                        b.this.a(c0055b.mClassName, c0055b.G, c0055b.H, c0055b.I, c0055b.J, c0055b.K);
                        break;
                    case 1002:
                        c cVar = (c) message.obj;
                        b.this.a(cVar.mClassName, cVar.J, cVar.K);
                        break;
                }
            } catch (Exception e) {
                com.baidu.ar.f.b.b("AbilityManager", "handleMessage Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0055b {
        List<String> G;
        boolean H;
        HashMap<String, Object> I;
        String J;
        com.baidu.ar.c.e K;
        String mClassName;

        C0055b(String str, String str2, boolean z, HashMap<String, Object> hashMap) {
            this.mClassName = str;
            this.G = new ArrayList();
            this.G.add(str2);
            this.H = z;
            this.I = hashMap;
        }

        C0055b(String str, HashMap<String, Object> hashMap, String str2, com.baidu.ar.c.e eVar) {
            this.mClassName = str;
            this.J = str2;
            this.I = hashMap;
            this.K = eVar;
        }

        C0055b(String str, List<String> list, boolean z, HashMap<String, Object> hashMap) {
            this.mClassName = str;
            this.G = list;
            this.H = z;
            this.I = hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c {
        String J;
        com.baidu.ar.c.e K;
        String mClassName;

        c(String str) {
            this.mClassName = str;
        }

        c(String str, String str2, com.baidu.ar.c.e eVar) {
            this.mClassName = str;
            this.J = str2;
            this.K = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, DefaultParams defaultParams, com.baidu.ar.a.b bVar, com.baidu.ar.filter.a aVar) {
        this.mContext = context;
        this.b = new a(context.getMainLooper());
        this.c = defaultParams;
        setMdlModelPath(this.c.getMdlAlgoModelPath());
        this.l = new ARProxyManager();
        this.u = bVar;
        this.w = aVar;
        j();
        this.t.add("ability_common_filter");
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, HashMap<String, Object> hashMap) {
        switch (i) {
            case 301:
                if (this.k == null || !this.t.contains("ability_image_track")) {
                    startAbility("ability_imu", hashMap);
                    return;
                }
                return;
            case 302:
            default:
                return;
            case 303:
                if (this.k == null || !this.t.contains("ability_image_track")) {
                    stopAbility("ability_imu");
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, com.baidu.ar.c.e eVar) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.ar.f.b.b("AbilityManager", "destroyAbility error!!! arClassName is empty!!!");
            return;
        }
        com.baidu.ar.c cVar = this.k.get(str);
        if (cVar == null) {
            com.baidu.ar.f.b.b("AbilityManager", "destroyAbility error!!! As arClassName = " + str + " not active!!!");
            return;
        }
        if (TextUtils.isEmpty(str2) || eVar == null) {
            cVar.o();
        } else {
            cVar.c(str2, eVar);
        }
        if (cVar.p()) {
            if (this.l != null && this.l.b(str)) {
                this.l.d(str);
            }
            this.k.remove(str);
            cVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<String> list, boolean z, HashMap<String, Object> hashMap, String str2, com.baidu.ar.c.e eVar) {
        if (!com.baidu.ar.ability.a.l(str)) {
            com.baidu.ar.f.b.b("AbilityManager", "checkARTypeAuth error!!!");
            return;
        }
        com.baidu.ar.c cVar = this.k.get(str);
        if (cVar != null) {
            com.baidu.ar.f.b.c("AbilityManager", "createARAbility arClassName = " + str + " ARAbility exist!!!");
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
                com.baidu.ar.f.b.b("AbilityManager", "createARAbility createARAbility error!!!");
                return;
            }
            if (list != null) {
                cVar.b(list);
            }
            if (!TextUtils.isEmpty(this.c.getFaceAlgoModelPath())) {
                cVar.setFaceModelPath(this.c.getFaceAlgoModelPath());
            }
            cVar.setMdlConfigParams(this.d);
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
        com.baidu.ar.f.b.c("AbilityManager", "operateAbilityById id = " + a2 + " && open = " + z2);
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
        com.baidu.ar.libloader.b.a(ARType.FACE, null, null, new a.InterfaceC0061a() { // from class: com.baidu.ar.b.2
            @Override // com.baidu.ar.libloader.a.InterfaceC0061a
            public void a(ARType aRType, String str, String str2) {
                b.this.t.addAll(b.this.s);
                String str3 = (String) b.this.i.get("ability_face_filter");
                if (TextUtils.isEmpty(str3) || b.this.b == null) {
                    return;
                }
                if (b.this.k.get(str3) == null) {
                    b.this.b.sendMessage(b.this.b.obtainMessage(1001, new C0055b(str3, (List<String>) list, true, (HashMap<String, Object>) null)));
                    return;
                }
                ((com.baidu.ar.c) b.this.k.get(str3)).o();
                ((com.baidu.ar.c) b.this.k.get(str3)).b(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME);
        com.baidu.ar.f.b.c("AbilityManager", "operateAbilityByEvent eventName = " + str);
        if (!"ability_operation".equals(str)) {
            String str2 = com.baidu.ar.ability.b.bt.get(str);
            if (!TextUtils.isEmpty(str2)) {
                startAbility(str2, hashMap);
                return;
            }
            String str3 = com.baidu.ar.ability.b.bu.get(str);
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
            if (TextUtils.isEmpty(str) || !com.baidu.ar.ability.b.bs.contains(str)) {
                return;
            }
            com.baidu.ar.f.b.c("AbilityManager", "operateFilterState abilityName = " + str);
            String str2 = (String) hashMap.get("ability_action");
            if ("open".equals(str2) && "close".equals(str2)) {
                boolean equals = "open".equals(str2);
                if (this.w != null) {
                    if ("ability_makeup_filter".equals(str)) {
                        this.w.a(FilterNode.makeupFilter, equals);
                    } else if ("ability_face_filter".equals(str)) {
                        this.w.a(FilterNode.faceFilter, equals);
                    } else if ("ability_beauty_filter".equals(str)) {
                        this.w.a(FilterNode.skinFilter, equals);
                    } else if ("ability_lut_filter".equals(str)) {
                        this.w.a(FilterNode.lutFilter, equals);
                    }
                    this.w.dg();
                }
            }
        }
    }

    private com.baidu.ar.c e(String str) {
        com.baidu.ar.c cVar = (com.baidu.ar.c) l.aN(str);
        if (cVar == null) {
            com.baidu.ar.f.b.b("AbilityManager", "createARAbility error!!!");
            return null;
        }
        this.k.put(str, cVar);
        cVar.a(this.mContext, this.g, this.f, this.w);
        cVar.a(this.e);
        cVar.a(this.h);
        cVar.a(this.A);
        if (this.u != null) {
            cVar.a(this.u.P());
        }
        if (this.l == null || !this.l.b(str)) {
            return cVar;
        }
        this.l.a(cVar, str);
        return cVar;
    }

    private void f(String str) {
        if (this.t.contains(str)) {
            com.baidu.ar.f.b.c("AbilityManager", "enableAbility() abilityName " + str + " has enabled!!!");
            return;
        }
        this.t.add(str);
        if ((str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) && this.c.isUseMakeupFilter()) {
            this.t.add("ability_makeup_filter");
        }
    }

    private void g(String str) {
        com.baidu.ar.c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.i != null) {
            String str2 = this.i.get(str);
            if (!TextUtils.isEmpty(str2) && this.k != null && (cVar = this.k.get(str2)) != null) {
                cVar.h(str);
            }
        }
        if (!this.t.contains(str)) {
            com.baidu.ar.f.b.c("AbilityManager", "disableAbility() abilityName " + str + " has disabled!!!");
            return;
        }
        if (str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) {
            this.t.remove("ability_makeup_filter");
        }
        this.t.remove(str);
    }

    private void h() {
        if (this.e == null) {
            return;
        }
        this.m = Arrays.asList(301, 303);
        this.n = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.b.3
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                b.this.a(i, hashMap);
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return b.this.m;
            }
        };
        this.e.c(this.n);
        this.o = Arrays.asList("id");
        this.p = new LuaMsgListener() { // from class: com.baidu.ar.b.4
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return b.this.o;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                b.this.a(hashMap);
            }
        };
        this.e.dJ().addLuaMsgListener(this.p);
        this.q = Arrays.asList(LuaMessageHelper.KEY_EVENT_NAME);
        this.r = new LuaMsgListener() { // from class: com.baidu.ar.b.5
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return b.this.q;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                b.this.b(hashMap);
                b.this.c(hashMap);
            }
        };
        this.e.dJ().addLuaMsgListener(this.r);
    }

    private void i() {
        if (this.e != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("ability_name", this.t);
            this.e.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    private void j() {
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = getClass().getClassLoader();
        for (Map.Entry<String, String> entry : com.baidu.ar.ability.b.br.entrySet()) {
            if (l.a(entry.getValue(), classLoader)) {
                this.i.put(entry.getKey(), entry.getValue());
            }
        }
        this.j.putAll(com.baidu.ar.ability.b.bw);
        com.baidu.ar.f.b.i("AbilityManager", "initSupportedARClasses mSupportedARClasses = " + this.i.values());
        com.baidu.ar.f.b.c("AbilityManager", "initSupportedARClasses time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void k() {
        this.A = new c.a() { // from class: com.baidu.ar.b.6
            @Override // com.baidu.ar.c.a
            public boolean a(String str, com.baidu.ar.c.e eVar) {
                if (b.this.j != null && b.this.j.containsKey(str)) {
                    String str2 = (String) b.this.j.get(str);
                    if (!TextUtils.isEmpty(str2) && b.this.b != null) {
                        b.this.b.sendMessage(b.this.b.obtainMessage(1002, new c(str2, str, eVar)));
                        return true;
                    }
                }
                return false;
            }

            @Override // com.baidu.ar.c.a
            public boolean a(String str, com.baidu.ar.c.e eVar, HashMap<String, Object> hashMap) {
                if (b.this.j != null && b.this.j.containsKey(str)) {
                    String str2 = (String) b.this.j.get(str);
                    if (!TextUtils.isEmpty(str2) && b.this.b != null) {
                        b.this.b.sendMessage(b.this.b.obtainMessage(1001, new C0055b(str2, hashMap, str, eVar)));
                        return true;
                    }
                }
                return false;
            }
        };
    }

    private void l() {
        this.B = new f() { // from class: com.baidu.ar.b.7
            @Override // com.baidu.ar.arrender.f
            public void a(boolean z) {
                for (com.baidu.ar.c cVar : b.this.k.values()) {
                    cVar.a(z);
                }
            }
        };
        this.f.setCameraSwitchListener(this.B);
    }

    private List<String> m() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.s) {
            String str2 = this.i.get(str);
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ARType aRType, String str) {
        boolean z;
        switch (aRType) {
            case IMU:
                g();
                z = false;
                break;
            case FACE:
                if (TextUtils.isEmpty(str) || com.baidu.ar.ability.a.m("ability_face_model")) {
                    if (this.c.isUseFaceFilter()) {
                        f("ability_face_model");
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                } else {
                    return;
                }
            default:
                g();
                z = true;
                break;
        }
        if (this.w != null) {
            if (this.c.isUseBeautyFilter() || aRType == ARType.FACE) {
                this.w.a((FilterParam) FilterParam.SkinFilter.whiten, true);
            } else {
                this.w.a((FilterParam) FilterParam.SkinFilter.whiten, false);
            }
        }
        String str2 = com.baidu.ar.ability.b.bv.get(aRType);
        if (TextUtils.isEmpty(str2) || this.t.contains(str2)) {
            return;
        }
        String str3 = this.i.get(str2);
        if (!z || TextUtils.isEmpty(str3) || this.b == null) {
            return;
        }
        this.t.add(str2);
        this.b.sendMessage(this.b.obtainMessage(1001, new C0055b(str3, str2, false, (HashMap<String, Object>) null)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.ar.lua.b bVar, com.baidu.ar.arrender.c cVar) {
        this.e = bVar;
        this.f = cVar;
        this.f.a(this.C);
        this.f.c(this.t);
        l();
        this.g = new g(cVar);
        this.h = com.baidu.ar.a.a();
        try {
            if (this.h != null) {
                this.h.setContext(this.mContext);
            }
            h();
        } catch (Exception e) {
            com.baidu.ar.f.b.b("AbilityManager", "setup exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, List<String> list, String str2) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || !l.a(str, getClass().getClassLoader())) {
            return false;
        }
        for (String str3 : list) {
            this.i.put(str3, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.j.put(str2, str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        if (!this.t.contains(str)) {
            com.baidu.ar.f.b.b("AbilityManager", "adjustAbility abilityType = " + str + " not start!!!");
            return false;
        }
        com.baidu.ar.c cVar = this.k.get(this.i.get(str));
        if (cVar != null) {
            cVar.adjust(hashMap);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void e() {
        if (this.c != null) {
            this.s.clear();
            this.t.clear();
            this.t.add("ability_common_filter");
            if (this.c.isUseFaceFilter() && com.baidu.ar.ability.a.n("ability_face_filter")) {
                this.s.add("ability_face_filter");
                if (this.w != null) {
                    this.w.a((FilterParam) FilterParam.SkinFilter.whiten, true);
                    this.w.a(FilterNode.faceFilter, true);
                }
                if (this.v) {
                    this.v = false;
                    StatisticApi.onEventDebounce(StatisticConstants.EVENT_FILTER_ADJUST, 200L, "");
                    StatisticApi.onEventDebounce(StatisticConstants.EVENT_BEAUTIFY_ADJUST, 200L, "");
                }
            }
            if (this.c.isUseMakeupFilter()) {
                if (com.baidu.ar.ability.a.n("ability_makeup_filter")) {
                    this.s.add("ability_makeup_filter");
                }
                if (this.w != null) {
                    this.w.a(FilterNode.makeupFilter, true);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.s.contains("ability_face_filter")) {
                arrayList.add("ability_face_filter");
            }
            if (this.s.contains("ability_makeup_filter")) {
                arrayList.add("ability_makeup_filter");
            }
            if (arrayList.size() > 0) {
                a(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.l != null) {
            this.l.d();
        }
        ArrayList<String> arrayList = new ArrayList();
        List<String> m = m();
        for (String str : this.t) {
            String str2 = !TextUtils.isEmpty(str) ? this.i.get(str) : null;
            if (!TextUtils.isEmpty(str2) && !m.contains(str2) && !arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        e();
        if (this.b != null) {
            for (String str3 : arrayList) {
                this.b.sendMessage(this.b.obtainMessage(1002, new c(str3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.w != null) {
            this.w.a(FilterNode.faceFilter, false);
            this.w.a(FilterNode.makeupFilter, false);
        }
        if (this.l != null) {
            this.l.d();
        }
        for (String str : this.t) {
            g(str);
        }
        this.t.clear();
        this.t.add("ability_common_filter");
        if (this.b != null) {
            for (Map.Entry<String, com.baidu.ar.c> entry : this.k.entrySet()) {
                this.b.sendMessage(this.b.obtainMessage(1002, new c(entry.getKey())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ARProxyManager getARProxyManager() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getActiveAbilities() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getSupportedAbilities() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.i.entrySet()) {
            arrayList.add(entry.getKey());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAbilityActive(String str) {
        return this.t.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAbilitySupported(String str) {
        return this.i.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCaseCreate(String str) {
        if (this.k.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.k.values()) {
            com.baidu.ar.f.b.c("AbilityManager", "onCaseCreate casePath = " + str);
            cVar.onCaseCreate(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCaseDestroy() {
        if (this.k.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.k.values()) {
            cVar.onCaseDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.k.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.k.values()) {
            cVar.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void release() {
        if (this.l != null) {
            this.l.release();
            this.l = null;
        }
        for (com.baidu.ar.c cVar : this.k.values()) {
            cVar.release();
        }
        this.k.clear();
        this.i.clear();
        if (this.e != null && this.e.dJ() != null) {
            this.e.d(this.n);
            this.e.dJ().removeLuaMsgListener(this.p);
            this.e.dJ().removeLuaMsgListener(this.r);
            this.e = null;
            this.n = null;
            this.p = null;
            this.r = null;
        }
        this.m = null;
        this.o = null;
        this.q = null;
        if (this.h != null) {
            this.h.destroy();
            this.h = null;
        }
        if (this.g != null) {
            this.g.release();
            this.g = null;
        }
        this.mContext = null;
        this.c = null;
        this.d = null;
        this.C = null;
        this.f = null;
        if (this.u != null) {
            this.u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        if (this.k.isEmpty()) {
            return;
        }
        for (com.baidu.ar.c cVar : this.k.values()) {
            cVar.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMdlModelPath(String str) {
        if (this.d == null) {
            this.d = new com.baidu.ar.mdl.b();
        }
        this.d.a(str, this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        if (!com.baidu.ar.ability.a.m(str)) {
            com.baidu.ar.f.b.b("AbilityManager", "startAbility abilityType = " + str + " is no authorization!!!");
            return false;
        } else if (this.t.contains(str)) {
            com.baidu.ar.f.b.b("AbilityManager", "startAbility abilityType = " + str + " is exist!!!");
            return false;
        } else {
            String str2 = this.i.get(str);
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            f(str);
            if (this.b != null) {
                this.b.sendMessage(this.b.obtainMessage(1001, new C0055b(str2, str, false, hashMap)));
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean stopAbility(String str) {
        g(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : this.t) {
            String str3 = this.i.get(str2);
            if (!TextUtils.isEmpty(str3) && !arrayList.contains(str3)) {
                arrayList.add(str3);
            }
        }
        String str4 = this.i.get(str);
        if (arrayList.contains(str4) || this.b == null) {
            return false;
        }
        this.b.sendMessage(this.b.obtainMessage(1002, new c(str4)));
        return true;
    }
}
