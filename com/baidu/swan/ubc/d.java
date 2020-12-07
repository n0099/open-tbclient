package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes17.dex */
public class d {
    private static volatile d eqZ;
    private HashSet<String> era = new HashSet<>();
    private HashSet<String> erb = new HashSet<>();
    private HashSet<String> erc = new HashSet<>();
    private HashSet<String> erd = new HashSet<>();
    private HashMap<String, String> ere = new HashMap<>();
    private HashMap<String, String> erf = new HashMap<>();
    private HashMap<String, h> erg = new HashMap<>();
    private HashSet<String> erh = new HashSet<>();
    private int eri;
    private int erj;
    private int erk;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d bfM() {
        if (eqZ == null) {
            synchronized (d.class) {
                if (eqZ == null) {
                    eqZ = new d();
                }
            }
        }
        return eqZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.eri = 360000;
        u bgy = u.bgy();
        this.erj = bgy.getInt("ubc_data_expire_time", 259200000);
        this.erk = bgy.getInt("ubc_database_limit", 4000);
        cVar.bfJ().a(this.era, this.erd, this.erb, this.erc, this.ere, this.erf, this.erg, this.erh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.bfS())) {
                this.era.add(gVar.getId());
            } else {
                this.era.remove(gVar.getId());
            }
            if ("1".equals(gVar.bfT())) {
                this.erb.add(gVar.getId());
            } else {
                this.erb.remove(gVar.getId());
            }
            if ("1".equals(gVar.bfU())) {
                this.erc.add(gVar.getId());
            } else {
                this.erc.remove(gVar.getId());
            }
            if (gVar.bfV() >= 1 && gVar.bfV() <= 100) {
                this.ere.put(gVar.getId(), String.valueOf(gVar.bfV()));
            } else {
                this.ere.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.erf.put(gVar.getId(), gVar.getCategory());
            } else {
                this.erf.remove(gVar.getId());
            }
            if (gVar.bfX() != 0 && gVar.bfW() != 0) {
                h hVar = new h(gVar.getId(), gVar.bfX(), gVar.bfW());
                this.erg.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.bfY(), "1")) {
                this.erh.add(gVar.getId());
            } else {
                this.erh.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ah(String str, int i) {
        if (this.era.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.erd.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zp(String str) {
        if (e.bfQ().aFB()) {
            return true;
        }
        return this.erb.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zq(String str) {
        return this.erc.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zr(String str) {
        return this.erf.containsKey(str) ? this.erf.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bfN() {
        return this.eri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nA(int i) {
        if (i * 60000 >= this.eri) {
            this.eri = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bfO() {
        return this.erj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nB(int i) {
        if (i >= this.erj) {
            this.erj = i;
            u.bgy().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bfP() {
        return this.erk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nC(int i) {
        if (i >= this.erk) {
            this.erk = i;
            u.bgy().putInt("ubc_database_limit", i);
        }
    }

    public int zs(String str) {
        if (e.bfQ().aFC() || TextUtils.isEmpty(str) || !this.ere.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ere.get(str));
    }

    public boolean zt(String str) {
        if (this.erg == null || !this.erg.containsKey(str)) {
            return false;
        }
        return this.erg.get(str).bfZ();
    }

    public boolean zu(String str) {
        if (this.erg == null || !this.erg.containsKey(str)) {
            return false;
        }
        return this.erg.get(str).bga();
    }

    public String zv(String str) {
        return (TextUtils.isEmpty(str) || !this.erh.contains(str)) ? "0" : "1";
    }
}
