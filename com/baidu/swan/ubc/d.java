package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private static volatile d cAi;
    private HashSet<String> cAj = new HashSet<>();
    private HashSet<String> cAk = new HashSet<>();
    private HashSet<String> cAl = new HashSet<>();
    private HashSet<String> cAm = new HashSet<>();
    private HashMap<String, String> cAn = new HashMap<>();
    private HashMap<String, String> cAo = new HashMap<>();
    private HashMap<String, g> cAp = new HashMap<>();
    private HashSet<String> cAq = new HashSet<>();
    private int cAr;
    private int cAs;
    private int cAt;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d asz() {
        if (cAi == null) {
            synchronized (d.class) {
                if (cAi == null) {
                    cAi = new d();
                }
            }
        }
        return cAi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.cAr = 360000;
        u atl = u.atl();
        this.cAs = atl.getInt("ubc_data_expire_time", 259200000);
        this.cAt = atl.getInt("ubc_database_limit", 4000);
        cVar.asw().a(this.cAj, this.cAm, this.cAk, this.cAl, this.cAn, this.cAo, this.cAp, this.cAq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ao(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.asD())) {
                this.cAj.add(fVar.getId());
            } else {
                this.cAj.remove(fVar.getId());
            }
            if ("1".equals(fVar.asE())) {
                this.cAk.add(fVar.getId());
            } else {
                this.cAk.remove(fVar.getId());
            }
            if ("1".equals(fVar.asF())) {
                this.cAl.add(fVar.getId());
            } else {
                this.cAl.remove(fVar.getId());
            }
            if (fVar.asG() >= 1 && fVar.asG() <= 100) {
                this.cAn.put(fVar.getId(), String.valueOf(fVar.asG()));
            } else {
                this.cAn.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.cAo.put(fVar.getId(), fVar.getCategory());
            } else {
                this.cAo.remove(fVar.getId());
            }
            if (fVar.asI() != 0 && fVar.asH() != 0) {
                g gVar = new g(fVar.getId(), fVar.asI(), fVar.asH());
                this.cAp.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.asJ(), "1")) {
                this.cAq.add(fVar.getId());
            } else {
                this.cAq.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T(String str, int i) {
        if (this.cAj.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.cAm.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qx(String str) {
        if (s.atk().WE()) {
            return true;
        }
        return this.cAk.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qy(String str) {
        return this.cAl.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String qz(String str) {
        return this.cAo.containsKey(str) ? this.cAo.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int asA() {
        return this.cAr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iA(int i) {
        if (i * 60000 >= this.cAr) {
            this.cAr = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int asB() {
        return this.cAs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iB(int i) {
        if (i >= this.cAs) {
            this.cAs = i;
            u.atl().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int asC() {
        return this.cAt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iC(int i) {
        if (i >= this.cAt) {
            this.cAt = i;
            u.atl().putInt("ubc_database_limit", i);
        }
    }

    public int qA(String str) {
        if (s.atk().WF() || TextUtils.isEmpty(str) || !this.cAn.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.cAn.get(str));
    }

    public boolean qB(String str) {
        if (this.cAp == null || !this.cAp.containsKey(str)) {
            return false;
        }
        return this.cAp.get(str).asK();
    }

    public boolean qC(String str) {
        if (this.cAp == null || !this.cAp.containsKey(str)) {
            return false;
        }
        return this.cAp.get(str).asL();
    }

    public String qD(String str) {
        return (TextUtils.isEmpty(str) || !this.cAq.contains(str)) ? "0" : "1";
    }
}
