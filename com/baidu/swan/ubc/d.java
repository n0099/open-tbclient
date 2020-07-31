package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private static volatile d dzY;
    private int dAh;
    private int dAi;
    private int dAj;
    private Context mContext;
    private HashSet<String> dzZ = new HashSet<>();
    private HashSet<String> dAa = new HashSet<>();
    private HashSet<String> dAb = new HashSet<>();
    private HashSet<String> dAc = new HashSet<>();
    private HashMap<String, String> dAd = new HashMap<>();
    private HashMap<String, String> dAe = new HashMap<>();
    private HashMap<String, h> dAf = new HashMap<>();
    private HashSet<String> dAg = new HashSet<>();

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aNb() {
        if (dzY == null) {
            synchronized (d.class) {
                if (dzY == null) {
                    dzY = new d();
                }
            }
        }
        return dzY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dAh = 360000;
        u aNN = u.aNN();
        this.dAi = aNN.getInt("ubc_data_expire_time", 259200000);
        this.dAj = aNN.getInt("ubc_database_limit", 4000);
        cVar.aMY().a(this.dzZ, this.dAc, this.dAa, this.dAb, this.dAd, this.dAe, this.dAf, this.dAg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aB(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.aNh())) {
                this.dzZ.add(gVar.getId());
            } else {
                this.dzZ.remove(gVar.getId());
            }
            if ("1".equals(gVar.aNi())) {
                this.dAa.add(gVar.getId());
            } else {
                this.dAa.remove(gVar.getId());
            }
            if ("1".equals(gVar.aNj())) {
                this.dAb.add(gVar.getId());
            } else {
                this.dAb.remove(gVar.getId());
            }
            if (gVar.aNk() >= 1 && gVar.aNk() <= 100) {
                this.dAd.put(gVar.getId(), String.valueOf(gVar.aNk()));
            } else {
                this.dAd.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.dAe.put(gVar.getId(), gVar.getCategory());
            } else {
                this.dAe.remove(gVar.getId());
            }
            if (gVar.aNm() != 0 && gVar.aNl() != 0) {
                h hVar = new h(gVar.getId(), gVar.aNm(), gVar.aNl());
                this.dAf.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.aNn(), "1")) {
                this.dAg.add(gVar.getId());
            } else {
                this.dAg.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ab(String str, int i) {
        if (this.dzZ.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.dAc.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uP(String str) {
        if (e.aNf().anr()) {
            return true;
        }
        return this.dAa.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uQ(String str) {
        return this.dAb.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String uR(String str) {
        return this.dAe.containsKey(str) ? this.dAe.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aNc() {
        return this.dAh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jX(int i) {
        if (i * 60000 >= this.dAh) {
            this.dAh = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aNd() {
        return this.dAi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jY(int i) {
        if (i >= this.dAi) {
            this.dAi = i;
            u.aNN().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aNe() {
        return this.dAj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jZ(int i) {
        if (i >= this.dAj) {
            this.dAj = i;
            u.aNN().putInt("ubc_database_limit", i);
        }
    }

    public int uS(String str) {
        if (e.aNf().ans() || TextUtils.isEmpty(str) || !this.dAd.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.dAd.get(str));
    }

    public boolean uT(String str) {
        if (this.dAf == null || !this.dAf.containsKey(str)) {
            return false;
        }
        return this.dAf.get(str).aNo();
    }

    public boolean uU(String str) {
        if (this.dAf == null || !this.dAf.containsKey(str)) {
            return false;
        }
        return this.dAf.get(str).aNp();
    }

    public String uV(String str) {
        return (TextUtils.isEmpty(str) || !this.dAg.contains(str)) ? "0" : "1";
    }
}
