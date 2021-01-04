package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private static volatile d eAK;
    private HashSet<String> eAL = new HashSet<>();
    private HashSet<String> eAM = new HashSet<>();
    private HashSet<String> eAN = new HashSet<>();
    private HashSet<String> eAO = new HashSet<>();
    private HashMap<String, String> eAP = new HashMap<>();
    private HashMap<String, String> eAQ = new HashMap<>();
    private HashMap<String, h> eAR = new HashMap<>();
    private HashSet<String> eAS = new HashSet<>();
    private int eAT;
    private int eAU;
    private int eAV;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d bij() {
        if (eAK == null) {
            synchronized (d.class) {
                if (eAK == null) {
                    eAK = new d();
                }
            }
        }
        return eAK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.eAT = 360000;
        u biV = u.biV();
        this.eAU = biV.getInt("ubc_data_expire_time", 259200000);
        this.eAV = biV.getInt("ubc_database_limit", 4000);
        cVar.big().a(this.eAL, this.eAO, this.eAM, this.eAN, this.eAP, this.eAQ, this.eAR, this.eAS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bj(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.bip())) {
                this.eAL.add(gVar.getId());
            } else {
                this.eAL.remove(gVar.getId());
            }
            if ("1".equals(gVar.biq())) {
                this.eAM.add(gVar.getId());
            } else {
                this.eAM.remove(gVar.getId());
            }
            if ("1".equals(gVar.bir())) {
                this.eAN.add(gVar.getId());
            } else {
                this.eAN.remove(gVar.getId());
            }
            if (gVar.bis() >= 1 && gVar.bis() <= 100) {
                this.eAP.put(gVar.getId(), String.valueOf(gVar.bis()));
            } else {
                this.eAP.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.eAQ.put(gVar.getId(), gVar.getCategory());
            } else {
                this.eAQ.remove(gVar.getId());
            }
            if (gVar.biu() != 0 && gVar.bit() != 0) {
                h hVar = new h(gVar.getId(), gVar.biu(), gVar.bit());
                this.eAR.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.biv(), "1")) {
                this.eAS.add(gVar.getId());
            } else {
                this.eAS.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aj(String str, int i) {
        if (this.eAL.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.eAO.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zo(String str) {
        if (e.bin().aGV()) {
            return true;
        }
        return this.eAM.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zp(String str) {
        return this.eAN.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zq(String str) {
        return this.eAQ.containsKey(str) ? this.eAQ.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bik() {
        return this.eAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nJ(int i) {
        if (i * 60000 >= this.eAT) {
            this.eAT = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bil() {
        return this.eAU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nK(int i) {
        if (i >= this.eAU) {
            this.eAU = i;
            u.biV().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bim() {
        return this.eAV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nL(int i) {
        if (i >= this.eAV) {
            this.eAV = i;
            u.biV().putInt("ubc_database_limit", i);
        }
    }

    public int zr(String str) {
        if (e.bin().aGW() || TextUtils.isEmpty(str) || !this.eAP.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.eAP.get(str));
    }

    public boolean zs(String str) {
        if (this.eAR == null || !this.eAR.containsKey(str)) {
            return false;
        }
        return this.eAR.get(str).biw();
    }

    public boolean zt(String str) {
        if (this.eAR == null || !this.eAR.containsKey(str)) {
            return false;
        }
        return this.eAR.get(str).bix();
    }

    public String zu(String str) {
        return (TextUtils.isEmpty(str) || !this.eAS.contains(str)) ? "0" : "1";
    }
}
