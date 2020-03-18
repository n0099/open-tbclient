package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static volatile d cEE;
    private HashSet<String> cEF = new HashSet<>();
    private HashSet<String> cEG = new HashSet<>();
    private HashSet<String> cEH = new HashSet<>();
    private HashSet<String> cEI = new HashSet<>();
    private HashMap<String, String> cEJ = new HashMap<>();
    private HashMap<String, String> cEK = new HashMap<>();
    private HashMap<String, g> cEL = new HashMap<>();
    private HashSet<String> cEM = new HashSet<>();
    private int cEN;
    private int cEO;
    private int cEP;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d avl() {
        if (cEE == null) {
            synchronized (d.class) {
                if (cEE == null) {
                    cEE = new d();
                }
            }
        }
        return cEE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.cEN = 360000;
        u avX = u.avX();
        this.cEO = avX.getInt("ubc_data_expire_time", 259200000);
        this.cEP = avX.getInt("ubc_database_limit", 4000);
        cVar.avi().a(this.cEF, this.cEI, this.cEG, this.cEH, this.cEJ, this.cEK, this.cEL, this.cEM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void an(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.avp())) {
                this.cEF.add(fVar.getId());
            } else {
                this.cEF.remove(fVar.getId());
            }
            if ("1".equals(fVar.avq())) {
                this.cEG.add(fVar.getId());
            } else {
                this.cEG.remove(fVar.getId());
            }
            if ("1".equals(fVar.avr())) {
                this.cEH.add(fVar.getId());
            } else {
                this.cEH.remove(fVar.getId());
            }
            if (fVar.avs() >= 1 && fVar.avs() <= 100) {
                this.cEJ.put(fVar.getId(), String.valueOf(fVar.avs()));
            } else {
                this.cEJ.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.cEK.put(fVar.getId(), fVar.getCategory());
            } else {
                this.cEK.remove(fVar.getId());
            }
            if (fVar.avu() != 0 && fVar.avt() != 0) {
                g gVar = new g(fVar.getId(), fVar.avu(), fVar.avt());
                this.cEL.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.avv(), "1")) {
                this.cEM.add(fVar.getId());
            } else {
                this.cEM.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R(String str, int i) {
        if (this.cEF.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.cEI.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qO(String str) {
        if (s.avW().Zu()) {
            return true;
        }
        return this.cEG.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qP(String str) {
        return this.cEH.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String qQ(String str) {
        return this.cEK.containsKey(str) ? this.cEK.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avm() {
        return this.cEN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iR(int i) {
        if (i * 60000 >= this.cEN) {
            this.cEN = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avn() {
        return this.cEO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iS(int i) {
        if (i >= this.cEO) {
            this.cEO = i;
            u.avX().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avo() {
        return this.cEP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iT(int i) {
        if (i >= this.cEP) {
            this.cEP = i;
            u.avX().putInt("ubc_database_limit", i);
        }
    }

    public int qR(String str) {
        if (s.avW().Zv() || TextUtils.isEmpty(str) || !this.cEJ.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.cEJ.get(str));
    }

    public boolean qS(String str) {
        if (this.cEL == null || !this.cEL.containsKey(str)) {
            return false;
        }
        return this.cEL.get(str).avw();
    }

    public boolean qT(String str) {
        if (this.cEL == null || !this.cEL.containsKey(str)) {
            return false;
        }
        return this.cEL.get(str).avx();
    }

    public String qU(String str) {
        return (TextUtils.isEmpty(str) || !this.cEM.contains(str)) ? "0" : "1";
    }
}
