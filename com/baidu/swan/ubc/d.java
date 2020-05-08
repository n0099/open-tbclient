package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static volatile d ddJ;
    private HashSet<String> ddK = new HashSet<>();
    private HashSet<String> ddL = new HashSet<>();
    private HashSet<String> ddM = new HashSet<>();
    private HashSet<String> ddN = new HashSet<>();
    private HashMap<String, String> ddO = new HashMap<>();
    private HashMap<String, String> ddP = new HashMap<>();
    private HashMap<String, g> ddQ = new HashMap<>();
    private HashSet<String> ddR = new HashSet<>();
    private int ddS;
    private int ddT;
    private int ddU;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aDw() {
        if (ddJ == null) {
            synchronized (d.class) {
                if (ddJ == null) {
                    ddJ = new d();
                }
            }
        }
        return ddJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ddS = 360000;
        u aEi = u.aEi();
        this.ddT = aEi.getInt("ubc_data_expire_time", 259200000);
        this.ddU = aEi.getInt("ubc_database_limit", 4000);
        cVar.aDt().a(this.ddK, this.ddN, this.ddL, this.ddM, this.ddO, this.ddP, this.ddQ, this.ddR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aw(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.aDA())) {
                this.ddK.add(fVar.getId());
            } else {
                this.ddK.remove(fVar.getId());
            }
            if ("1".equals(fVar.aDB())) {
                this.ddL.add(fVar.getId());
            } else {
                this.ddL.remove(fVar.getId());
            }
            if ("1".equals(fVar.aDC())) {
                this.ddM.add(fVar.getId());
            } else {
                this.ddM.remove(fVar.getId());
            }
            if (fVar.aDD() >= 1 && fVar.aDD() <= 100) {
                this.ddO.put(fVar.getId(), String.valueOf(fVar.aDD()));
            } else {
                this.ddO.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.ddP.put(fVar.getId(), fVar.getCategory());
            } else {
                this.ddP.remove(fVar.getId());
            }
            if (fVar.aDF() != 0 && fVar.aDE() != 0) {
                g gVar = new g(fVar.getId(), fVar.aDF(), fVar.aDE());
                this.ddQ.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.aDG(), "1")) {
                this.ddR.add(fVar.getId());
            } else {
                this.ddR.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Z(String str, int i) {
        if (this.ddK.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.ddN.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sb(String str) {
        if (s.aEh().ahy()) {
            return true;
        }
        return this.ddL.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sc(String str) {
        return this.ddM.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String sd(String str) {
        return this.ddP.containsKey(str) ? this.ddP.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDx() {
        return this.ddS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iY(int i) {
        if (i * 60000 >= this.ddS) {
            this.ddS = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDy() {
        return this.ddT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iZ(int i) {
        if (i >= this.ddT) {
            this.ddT = i;
            u.aEi().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDz() {
        return this.ddU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ja(int i) {
        if (i >= this.ddU) {
            this.ddU = i;
            u.aEi().putInt("ubc_database_limit", i);
        }
    }

    public int se(String str) {
        if (s.aEh().ahz() || TextUtils.isEmpty(str) || !this.ddO.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ddO.get(str));
    }

    public boolean sf(String str) {
        if (this.ddQ == null || !this.ddQ.containsKey(str)) {
            return false;
        }
        return this.ddQ.get(str).aDH();
    }

    public boolean sg(String str) {
        if (this.ddQ == null || !this.ddQ.containsKey(str)) {
            return false;
        }
        return this.ddQ.get(str).aDI();
    }

    public String sh(String str) {
        return (TextUtils.isEmpty(str) || !this.ddR.contains(str)) ? "0" : "1";
    }
}
