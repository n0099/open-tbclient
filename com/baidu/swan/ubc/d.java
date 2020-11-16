package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes16.dex */
public class d {
    private static volatile d ejX;
    private HashSet<String> ejY = new HashSet<>();
    private HashSet<String> ejZ = new HashSet<>();
    private HashSet<String> eka = new HashSet<>();
    private HashSet<String> ekb = new HashSet<>();
    private HashMap<String, String> ekc = new HashMap<>();
    private HashMap<String, String> ekd = new HashMap<>();
    private HashMap<String, h> eke = new HashMap<>();
    private HashSet<String> ekf = new HashSet<>();
    private int ekg;
    private int ekh;
    private int eki;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d bcH() {
        if (ejX == null) {
            synchronized (d.class) {
                if (ejX == null) {
                    ejX = new d();
                }
            }
        }
        return ejX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ekg = 360000;
        u bdt = u.bdt();
        this.ekh = bdt.getInt("ubc_data_expire_time", 259200000);
        this.eki = bdt.getInt("ubc_database_limit", 4000);
        cVar.bcE().a(this.ejY, this.ekb, this.ejZ, this.eka, this.ekc, this.ekd, this.eke, this.ekf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.bcN())) {
                this.ejY.add(gVar.getId());
            } else {
                this.ejY.remove(gVar.getId());
            }
            if ("1".equals(gVar.bcO())) {
                this.ejZ.add(gVar.getId());
            } else {
                this.ejZ.remove(gVar.getId());
            }
            if ("1".equals(gVar.bcP())) {
                this.eka.add(gVar.getId());
            } else {
                this.eka.remove(gVar.getId());
            }
            if (gVar.bcQ() >= 1 && gVar.bcQ() <= 100) {
                this.ekc.put(gVar.getId(), String.valueOf(gVar.bcQ()));
            } else {
                this.ekc.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.ekd.put(gVar.getId(), gVar.getCategory());
            } else {
                this.ekd.remove(gVar.getId());
            }
            if (gVar.bcS() != 0 && gVar.bcR() != 0) {
                h hVar = new h(gVar.getId(), gVar.bcS(), gVar.bcR());
                this.eke.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.bcT(), "1")) {
                this.ekf.add(gVar.getId());
            } else {
                this.ekf.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ag(String str, int i) {
        if (this.ejY.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.ekb.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yI(String str) {
        if (e.bcL().aCs()) {
            return true;
        }
        return this.ejZ.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yJ(String str) {
        return this.eka.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yK(String str) {
        return this.ekd.containsKey(str) ? this.ekd.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bcI() {
        return this.ekg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nc(int i) {
        if (i * 60000 >= this.ekg) {
            this.ekg = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bcJ() {
        return this.ekh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nd(int i) {
        if (i >= this.ekh) {
            this.ekh = i;
            u.bdt().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bcK() {
        return this.eki;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ne(int i) {
        if (i >= this.eki) {
            this.eki = i;
            u.bdt().putInt("ubc_database_limit", i);
        }
    }

    public int yL(String str) {
        if (e.bcL().aCt() || TextUtils.isEmpty(str) || !this.ekc.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ekc.get(str));
    }

    public boolean yM(String str) {
        if (this.eke == null || !this.eke.containsKey(str)) {
            return false;
        }
        return this.eke.get(str).bcU();
    }

    public boolean yN(String str) {
        if (this.eke == null || !this.eke.containsKey(str)) {
            return false;
        }
        return this.eke.get(str).bcV();
    }

    public String yO(String str) {
        return (TextUtils.isEmpty(str) || !this.ekf.contains(str)) ? "0" : "1";
    }
}
