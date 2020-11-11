package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private static volatile d elE;
    private HashSet<String> elF = new HashSet<>();
    private HashSet<String> elG = new HashSet<>();
    private HashSet<String> elH = new HashSet<>();
    private HashSet<String> elI = new HashSet<>();
    private HashMap<String, String> elJ = new HashMap<>();
    private HashMap<String, String> elK = new HashMap<>();
    private HashMap<String, h> elL = new HashMap<>();
    private HashSet<String> elM = new HashSet<>();
    private int elN;
    private int elO;
    private int elP;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d bdo() {
        if (elE == null) {
            synchronized (d.class) {
                if (elE == null) {
                    elE = new d();
                }
            }
        }
        return elE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.elN = 360000;
        u bea = u.bea();
        this.elO = bea.getInt("ubc_data_expire_time", 259200000);
        this.elP = bea.getInt("ubc_database_limit", 4000);
        cVar.bdl().a(this.elF, this.elI, this.elG, this.elH, this.elJ, this.elK, this.elL, this.elM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.bdu())) {
                this.elF.add(gVar.getId());
            } else {
                this.elF.remove(gVar.getId());
            }
            if ("1".equals(gVar.bdv())) {
                this.elG.add(gVar.getId());
            } else {
                this.elG.remove(gVar.getId());
            }
            if ("1".equals(gVar.bdw())) {
                this.elH.add(gVar.getId());
            } else {
                this.elH.remove(gVar.getId());
            }
            if (gVar.bdx() >= 1 && gVar.bdx() <= 100) {
                this.elJ.put(gVar.getId(), String.valueOf(gVar.bdx()));
            } else {
                this.elJ.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.elK.put(gVar.getId(), gVar.getCategory());
            } else {
                this.elK.remove(gVar.getId());
            }
            if (gVar.bdz() != 0 && gVar.bdy() != 0) {
                h hVar = new h(gVar.getId(), gVar.bdz(), gVar.bdy());
                this.elL.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.bdA(), "1")) {
                this.elM.add(gVar.getId());
            } else {
                this.elM.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ag(String str, int i) {
        if (this.elF.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.elI.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yN(String str) {
        if (e.bds().aDa()) {
            return true;
        }
        return this.elG.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yO(String str) {
        return this.elH.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yP(String str) {
        return this.elK.containsKey(str) ? this.elK.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bdp() {
        return this.elN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ng(int i) {
        if (i * 60000 >= this.elN) {
            this.elN = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bdq() {
        return this.elO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nh(int i) {
        if (i >= this.elO) {
            this.elO = i;
            u.bea().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bdr() {
        return this.elP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ni(int i) {
        if (i >= this.elP) {
            this.elP = i;
            u.bea().putInt("ubc_database_limit", i);
        }
    }

    public int yQ(String str) {
        if (e.bds().aDb() || TextUtils.isEmpty(str) || !this.elJ.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.elJ.get(str));
    }

    public boolean yR(String str) {
        if (this.elL == null || !this.elL.containsKey(str)) {
            return false;
        }
        return this.elL.get(str).bdB();
    }

    public boolean yS(String str) {
        if (this.elL == null || !this.elL.containsKey(str)) {
            return false;
        }
        return this.elL.get(str).bdC();
    }

    public String yT(String str) {
        return (TextUtils.isEmpty(str) || !this.elM.contains(str)) ? "0" : "1";
    }
}
