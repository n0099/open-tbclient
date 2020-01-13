package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private static volatile d cAt;
    private int cAC;
    private int cAD;
    private int cAE;
    private Context mContext;
    private HashSet<String> cAu = new HashSet<>();
    private HashSet<String> cAv = new HashSet<>();
    private HashSet<String> cAw = new HashSet<>();
    private HashSet<String> cAx = new HashSet<>();
    private HashMap<String, String> cAy = new HashMap<>();
    private HashMap<String, String> cAz = new HashMap<>();
    private HashMap<String, g> cAA = new HashMap<>();
    private HashSet<String> cAB = new HashSet<>();

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d asS() {
        if (cAt == null) {
            synchronized (d.class) {
                if (cAt == null) {
                    cAt = new d();
                }
            }
        }
        return cAt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.cAC = 360000;
        u atE = u.atE();
        this.cAD = atE.getInt("ubc_data_expire_time", 259200000);
        this.cAE = atE.getInt("ubc_database_limit", 4000);
        cVar.asP().a(this.cAu, this.cAx, this.cAv, this.cAw, this.cAy, this.cAz, this.cAA, this.cAB);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void an(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.asW())) {
                this.cAu.add(fVar.getId());
            } else {
                this.cAu.remove(fVar.getId());
            }
            if ("1".equals(fVar.asX())) {
                this.cAv.add(fVar.getId());
            } else {
                this.cAv.remove(fVar.getId());
            }
            if ("1".equals(fVar.asY())) {
                this.cAw.add(fVar.getId());
            } else {
                this.cAw.remove(fVar.getId());
            }
            if (fVar.asZ() >= 1 && fVar.asZ() <= 100) {
                this.cAy.put(fVar.getId(), String.valueOf(fVar.asZ()));
            } else {
                this.cAy.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.cAz.put(fVar.getId(), fVar.getCategory());
            } else {
                this.cAz.remove(fVar.getId());
            }
            if (fVar.atb() != 0 && fVar.ata() != 0) {
                g gVar = new g(fVar.getId(), fVar.atb(), fVar.ata());
                this.cAA.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.atc(), "1")) {
                this.cAB.add(fVar.getId());
            } else {
                this.cAB.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T(String str, int i) {
        if (this.cAu.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.cAx.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qA(String str) {
        if (s.atD().Xb()) {
            return true;
        }
        return this.cAv.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qB(String str) {
        return this.cAw.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String qC(String str) {
        return this.cAz.containsKey(str) ? this.cAz.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int asT() {
        return this.cAC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iA(int i) {
        if (i * 60000 >= this.cAC) {
            this.cAC = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int asU() {
        return this.cAD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iB(int i) {
        if (i >= this.cAD) {
            this.cAD = i;
            u.atE().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int asV() {
        return this.cAE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iC(int i) {
        if (i >= this.cAE) {
            this.cAE = i;
            u.atE().putInt("ubc_database_limit", i);
        }
    }

    public int qD(String str) {
        if (s.atD().Xc() || TextUtils.isEmpty(str) || !this.cAy.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.cAy.get(str));
    }

    public boolean qE(String str) {
        if (this.cAA == null || !this.cAA.containsKey(str)) {
            return false;
        }
        return this.cAA.get(str).atd();
    }

    public boolean qF(String str) {
        if (this.cAA == null || !this.cAA.containsKey(str)) {
            return false;
        }
        return this.cAA.get(str).ate();
    }

    public String qG(String str) {
        return (TextUtils.isEmpty(str) || !this.cAB.contains(str)) ? "0" : "1";
    }
}
