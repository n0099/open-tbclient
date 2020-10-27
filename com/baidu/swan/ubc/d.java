package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private static volatile d efM;
    private HashSet<String> efN = new HashSet<>();
    private HashSet<String> efO = new HashSet<>();
    private HashSet<String> efP = new HashSet<>();
    private HashSet<String> efQ = new HashSet<>();
    private HashMap<String, String> efR = new HashMap<>();
    private HashMap<String, String> efS = new HashMap<>();
    private HashMap<String, h> efT = new HashMap<>();
    private HashSet<String> efU = new HashSet<>();
    private int efV;
    private int efW;
    private int efX;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d baO() {
        if (efM == null) {
            synchronized (d.class) {
                if (efM == null) {
                    efM = new d();
                }
            }
        }
        return efM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.efV = 360000;
        u bbA = u.bbA();
        this.efW = bbA.getInt("ubc_data_expire_time", 259200000);
        this.efX = bbA.getInt("ubc_database_limit", 4000);
        cVar.baL().a(this.efN, this.efQ, this.efO, this.efP, this.efR, this.efS, this.efT, this.efU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aS(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.baU())) {
                this.efN.add(gVar.getId());
            } else {
                this.efN.remove(gVar.getId());
            }
            if ("1".equals(gVar.baV())) {
                this.efO.add(gVar.getId());
            } else {
                this.efO.remove(gVar.getId());
            }
            if ("1".equals(gVar.baW())) {
                this.efP.add(gVar.getId());
            } else {
                this.efP.remove(gVar.getId());
            }
            if (gVar.baX() >= 1 && gVar.baX() <= 100) {
                this.efR.put(gVar.getId(), String.valueOf(gVar.baX()));
            } else {
                this.efR.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.efS.put(gVar.getId(), gVar.getCategory());
            } else {
                this.efS.remove(gVar.getId());
            }
            if (gVar.baZ() != 0 && gVar.baY() != 0) {
                h hVar = new h(gVar.getId(), gVar.baZ(), gVar.baY());
                this.efT.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.bba(), "1")) {
                this.efU.add(gVar.getId());
            } else {
                this.efU.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ae(String str, int i) {
        if (this.efN.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.efQ.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yz(String str) {
        if (e.baS().aAA()) {
            return true;
        }
        return this.efO.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yA(String str) {
        return this.efP.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yB(String str) {
        return this.efS.containsKey(str) ? this.efS.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int baP() {
        return this.efV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mW(int i) {
        if (i * 60000 >= this.efV) {
            this.efV = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int baQ() {
        return this.efW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mX(int i) {
        if (i >= this.efW) {
            this.efW = i;
            u.bbA().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int baR() {
        return this.efX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mY(int i) {
        if (i >= this.efX) {
            this.efX = i;
            u.bbA().putInt("ubc_database_limit", i);
        }
    }

    public int yC(String str) {
        if (e.baS().aAB() || TextUtils.isEmpty(str) || !this.efR.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.efR.get(str));
    }

    public boolean yD(String str) {
        if (this.efT == null || !this.efT.containsKey(str)) {
            return false;
        }
        return this.efT.get(str).bbb();
    }

    public boolean yE(String str) {
        if (this.efT == null || !this.efT.containsKey(str)) {
            return false;
        }
        return this.efT.get(str).bbc();
    }

    public String yF(String str) {
        return (TextUtils.isEmpty(str) || !this.efU.contains(str)) ? "0" : "1";
    }
}
