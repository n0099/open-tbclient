package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes14.dex */
public class d {
    private static volatile d ezF;
    private HashSet<String> ezG = new HashSet<>();
    private HashSet<String> ezH = new HashSet<>();
    private HashSet<String> ezI = new HashSet<>();
    private HashSet<String> ezJ = new HashSet<>();
    private HashMap<String, String> ezK = new HashMap<>();
    private HashMap<String, String> ezL = new HashMap<>();
    private HashMap<String, h> ezM = new HashMap<>();
    private HashSet<String> ezN = new HashSet<>();
    private int ezO;
    private int ezP;
    private int ezQ;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d beF() {
        if (ezF == null) {
            synchronized (d.class) {
                if (ezF == null) {
                    ezF = new d();
                }
            }
        }
        return ezF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ezO = 360000;
        u bfr = u.bfr();
        this.ezP = bfr.getInt("ubc_data_expire_time", 259200000);
        this.ezQ = bfr.getInt("ubc_database_limit", 4000);
        cVar.beC().a(this.ezG, this.ezJ, this.ezH, this.ezI, this.ezK, this.ezL, this.ezM, this.ezN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void be(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.beL())) {
                this.ezG.add(gVar.getId());
            } else {
                this.ezG.remove(gVar.getId());
            }
            if ("1".equals(gVar.beM())) {
                this.ezH.add(gVar.getId());
            } else {
                this.ezH.remove(gVar.getId());
            }
            if ("1".equals(gVar.beN())) {
                this.ezI.add(gVar.getId());
            } else {
                this.ezI.remove(gVar.getId());
            }
            if (gVar.beO() >= 1 && gVar.beO() <= 100) {
                this.ezK.put(gVar.getId(), String.valueOf(gVar.beO()));
            } else {
                this.ezK.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.ezL.put(gVar.getId(), gVar.getCategory());
            } else {
                this.ezL.remove(gVar.getId());
            }
            if (gVar.beQ() != 0 && gVar.beP() != 0) {
                h hVar = new h(gVar.getId(), gVar.beQ(), gVar.beP());
                this.ezM.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.beR(), "1")) {
                this.ezN.add(gVar.getId());
            } else {
                this.ezN.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean am(String str, int i) {
        if (this.ezG.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.ezJ.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yD(String str) {
        if (e.beJ().aDB()) {
            return true;
        }
        return this.ezH.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yE(String str) {
        return this.ezI.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yF(String str) {
        return this.ezL.containsKey(str) ? this.ezL.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beG() {
        return this.ezO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mh(int i) {
        if (i * 60000 >= this.ezO) {
            this.ezO = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beH() {
        return this.ezP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mi(int i) {
        if (i >= this.ezP) {
            this.ezP = i;
            u.bfr().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beI() {
        return this.ezQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mj(int i) {
        if (i >= this.ezQ) {
            this.ezQ = i;
            u.bfr().putInt("ubc_database_limit", i);
        }
    }

    public int yG(String str) {
        if (e.beJ().aDC() || TextUtils.isEmpty(str) || !this.ezK.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ezK.get(str));
    }

    public boolean yH(String str) {
        if (this.ezM == null || !this.ezM.containsKey(str)) {
            return false;
        }
        return this.ezM.get(str).beS();
    }

    public boolean yI(String str) {
        if (this.ezM == null || !this.ezM.containsKey(str)) {
            return false;
        }
        return this.ezM.get(str).beT();
    }

    public String yJ(String str) {
        return (TextUtils.isEmpty(str) || !this.ezN.contains(str)) ? "0" : "1";
    }
}
