package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static volatile d dpx;
    private int dpG;
    private int dpH;
    private int dpI;
    private Context mContext;
    private HashSet<String> dpy = new HashSet<>();
    private HashSet<String> dpz = new HashSet<>();
    private HashSet<String> dpA = new HashSet<>();
    private HashSet<String> dpB = new HashSet<>();
    private HashMap<String, String> dpC = new HashMap<>();
    private HashMap<String, String> dpD = new HashMap<>();
    private HashMap<String, h> dpE = new HashMap<>();
    private HashSet<String> dpF = new HashSet<>();

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aId() {
        if (dpx == null) {
            synchronized (d.class) {
                if (dpx == null) {
                    dpx = new d();
                }
            }
        }
        return dpx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dpG = 360000;
        u aIQ = u.aIQ();
        this.dpH = aIQ.getInt("ubc_data_expire_time", 259200000);
        this.dpI = aIQ.getInt("ubc_database_limit", 4000);
        cVar.aIa().a(this.dpy, this.dpB, this.dpz, this.dpA, this.dpC, this.dpD, this.dpE, this.dpF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ar(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.aIj())) {
                this.dpy.add(gVar.getId());
            } else {
                this.dpy.remove(gVar.getId());
            }
            if ("1".equals(gVar.aIk())) {
                this.dpz.add(gVar.getId());
            } else {
                this.dpz.remove(gVar.getId());
            }
            if ("1".equals(gVar.aIl())) {
                this.dpA.add(gVar.getId());
            } else {
                this.dpA.remove(gVar.getId());
            }
            if (gVar.aIm() >= 1 && gVar.aIm() <= 100) {
                this.dpC.put(gVar.getId(), String.valueOf(gVar.aIm()));
            } else {
                this.dpC.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.dpD.put(gVar.getId(), gVar.getCategory());
            } else {
                this.dpD.remove(gVar.getId());
            }
            if (gVar.aIo() != 0 && gVar.aIn() != 0) {
                h hVar = new h(gVar.getId(), gVar.aIo(), gVar.aIn());
                this.dpE.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.aIp(), "1")) {
                this.dpF.add(gVar.getId());
            } else {
                this.dpF.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aa(String str, int i) {
        if (this.dpy.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.dpB.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tE(String str) {
        if (e.aIh().akS()) {
            return true;
        }
        return this.dpz.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tF(String str) {
        return this.dpA.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tG(String str) {
        return this.dpD.containsKey(str) ? this.dpD.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIe() {
        return this.dpG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jr(int i) {
        if (i * 60000 >= this.dpG) {
            this.dpG = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIf() {
        return this.dpH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void js(int i) {
        if (i >= this.dpH) {
            this.dpH = i;
            u.aIQ().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIg() {
        return this.dpI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jt(int i) {
        if (i >= this.dpI) {
            this.dpI = i;
            u.aIQ().putInt("ubc_database_limit", i);
        }
    }

    public int tH(String str) {
        if (e.aIh().akT() || TextUtils.isEmpty(str) || !this.dpC.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.dpC.get(str));
    }

    public boolean tI(String str) {
        if (this.dpE == null || !this.dpE.containsKey(str)) {
            return false;
        }
        return this.dpE.get(str).aIq();
    }

    public boolean tJ(String str) {
        if (this.dpE == null || !this.dpE.containsKey(str)) {
            return false;
        }
        return this.dpE.get(str).aIr();
    }

    public String tK(String str) {
        return (TextUtils.isEmpty(str) || !this.dpF.contains(str)) ? "0" : "1";
    }
}
