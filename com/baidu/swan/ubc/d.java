package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private static volatile d dXq;
    private int dXA;
    private int dXB;
    private HashSet<String> dXr = new HashSet<>();
    private HashSet<String> dXs = new HashSet<>();
    private HashSet<String> dXt = new HashSet<>();
    private HashSet<String> dXu = new HashSet<>();
    private HashMap<String, String> dXv = new HashMap<>();
    private HashMap<String, String> dXw = new HashMap<>();
    private HashMap<String, h> dXx = new HashMap<>();
    private HashSet<String> dXy = new HashSet<>();
    private int dXz;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aYV() {
        if (dXq == null) {
            synchronized (d.class) {
                if (dXq == null) {
                    dXq = new d();
                }
            }
        }
        return dXq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dXz = 360000;
        u aZH = u.aZH();
        this.dXA = aZH.getInt("ubc_data_expire_time", 259200000);
        this.dXB = aZH.getInt("ubc_database_limit", 4000);
        cVar.aYS().a(this.dXr, this.dXu, this.dXs, this.dXt, this.dXv, this.dXw, this.dXx, this.dXy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aI(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.aZb())) {
                this.dXr.add(gVar.getId());
            } else {
                this.dXr.remove(gVar.getId());
            }
            if ("1".equals(gVar.aZc())) {
                this.dXs.add(gVar.getId());
            } else {
                this.dXs.remove(gVar.getId());
            }
            if ("1".equals(gVar.aZd())) {
                this.dXt.add(gVar.getId());
            } else {
                this.dXt.remove(gVar.getId());
            }
            if (gVar.aZe() >= 1 && gVar.aZe() <= 100) {
                this.dXv.put(gVar.getId(), String.valueOf(gVar.aZe()));
            } else {
                this.dXv.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.dXw.put(gVar.getId(), gVar.getCategory());
            } else {
                this.dXw.remove(gVar.getId());
            }
            if (gVar.aZg() != 0 && gVar.aZf() != 0) {
                h hVar = new h(gVar.getId(), gVar.aZg(), gVar.aZf());
                this.dXx.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.aZh(), "1")) {
                this.dXy.add(gVar.getId());
            } else {
                this.dXy.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ae(String str, int i) {
        if (this.dXr.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.dXu.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yg(String str) {
        if (e.aYZ().ayG()) {
            return true;
        }
        return this.dXs.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yh(String str) {
        return this.dXt.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yi(String str) {
        return this.dXw.containsKey(str) ? this.dXw.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aYW() {
        return this.dXz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mL(int i) {
        if (i * 60000 >= this.dXz) {
            this.dXz = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aYX() {
        return this.dXA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mM(int i) {
        if (i >= this.dXA) {
            this.dXA = i;
            u.aZH().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aYY() {
        return this.dXB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mN(int i) {
        if (i >= this.dXB) {
            this.dXB = i;
            u.aZH().putInt("ubc_database_limit", i);
        }
    }

    public int yj(String str) {
        if (e.aYZ().ayH() || TextUtils.isEmpty(str) || !this.dXv.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.dXv.get(str));
    }

    public boolean yk(String str) {
        if (this.dXx == null || !this.dXx.containsKey(str)) {
            return false;
        }
        return this.dXx.get(str).aZi();
    }

    public boolean yl(String str) {
        if (this.dXx == null || !this.dXx.containsKey(str)) {
            return false;
        }
        return this.dXx.get(str).aZj();
    }

    public String ym(String str) {
        return (TextUtils.isEmpty(str) || !this.dXy.contains(str)) ? "0" : "1";
    }
}
