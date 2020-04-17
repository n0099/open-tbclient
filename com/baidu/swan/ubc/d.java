package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static volatile d ddE;
    private HashSet<String> ddF = new HashSet<>();
    private HashSet<String> ddG = new HashSet<>();
    private HashSet<String> ddH = new HashSet<>();
    private HashSet<String> ddI = new HashSet<>();
    private HashMap<String, String> ddJ = new HashMap<>();
    private HashMap<String, String> ddK = new HashMap<>();
    private HashMap<String, g> ddL = new HashMap<>();
    private HashSet<String> ddM = new HashSet<>();
    private int ddN;
    private int ddO;
    private int ddP;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aDw() {
        if (ddE == null) {
            synchronized (d.class) {
                if (ddE == null) {
                    ddE = new d();
                }
            }
        }
        return ddE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ddN = 360000;
        u aEi = u.aEi();
        this.ddO = aEi.getInt("ubc_data_expire_time", 259200000);
        this.ddP = aEi.getInt("ubc_database_limit", 4000);
        cVar.aDt().a(this.ddF, this.ddI, this.ddG, this.ddH, this.ddJ, this.ddK, this.ddL, this.ddM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aw(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.aDA())) {
                this.ddF.add(fVar.getId());
            } else {
                this.ddF.remove(fVar.getId());
            }
            if ("1".equals(fVar.aDB())) {
                this.ddG.add(fVar.getId());
            } else {
                this.ddG.remove(fVar.getId());
            }
            if ("1".equals(fVar.aDC())) {
                this.ddH.add(fVar.getId());
            } else {
                this.ddH.remove(fVar.getId());
            }
            if (fVar.aDD() >= 1 && fVar.aDD() <= 100) {
                this.ddJ.put(fVar.getId(), String.valueOf(fVar.aDD()));
            } else {
                this.ddJ.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.ddK.put(fVar.getId(), fVar.getCategory());
            } else {
                this.ddK.remove(fVar.getId());
            }
            if (fVar.aDF() != 0 && fVar.aDE() != 0) {
                g gVar = new g(fVar.getId(), fVar.aDF(), fVar.aDE());
                this.ddL.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.aDG(), "1")) {
                this.ddM.add(fVar.getId());
            } else {
                this.ddM.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Z(String str, int i) {
        if (this.ddF.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.ddI.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sb(String str) {
        if (s.aEh().ahz()) {
            return true;
        }
        return this.ddG.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sc(String str) {
        return this.ddH.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String sd(String str) {
        return this.ddK.containsKey(str) ? this.ddK.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDx() {
        return this.ddN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iY(int i) {
        if (i * 60000 >= this.ddN) {
            this.ddN = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDy() {
        return this.ddO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iZ(int i) {
        if (i >= this.ddO) {
            this.ddO = i;
            u.aEi().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDz() {
        return this.ddP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ja(int i) {
        if (i >= this.ddP) {
            this.ddP = i;
            u.aEi().putInt("ubc_database_limit", i);
        }
    }

    public int se(String str) {
        if (s.aEh().ahA() || TextUtils.isEmpty(str) || !this.ddJ.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ddJ.get(str));
    }

    public boolean sf(String str) {
        if (this.ddL == null || !this.ddL.containsKey(str)) {
            return false;
        }
        return this.ddL.get(str).aDH();
    }

    public boolean sg(String str) {
        if (this.ddL == null || !this.ddL.containsKey(str)) {
            return false;
        }
        return this.ddL.get(str).aDI();
    }

    public String sh(String str) {
        return (TextUtils.isEmpty(str) || !this.ddM.contains(str)) ? "0" : "1";
    }
}
