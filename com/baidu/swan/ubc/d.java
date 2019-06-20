package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bvi;
    private HashSet<String> bvj = new HashSet<>();
    private HashSet<String> bvk = new HashSet<>();
    private HashSet<String> bvl = new HashSet<>();
    private HashSet<String> bvm = new HashSet<>();
    private HashMap<String, String> bvn = new HashMap<>();
    private HashMap<String, String> bvo = new HashMap<>();
    private HashMap<String, g> bvp = new HashMap<>();
    private HashSet<String> bvq = new HashSet<>();
    private int bvr;
    private int bvs;
    private int bvt;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d WI() {
        if (bvi == null) {
            synchronized (d.class) {
                if (bvi == null) {
                    bvi = new d();
                }
            }
        }
        return bvi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bvr = 360000;
        u Xs = u.Xs();
        this.bvs = Xs.getInt("ubc_data_expire_time", 259200000);
        this.bvt = Xs.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.WF().a(this.bvj, this.bvm, this.bvk, this.bvl, this.bvn, this.bvo, this.bvp, this.bvq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.WM())) {
                this.bvj.add(fVar.getId());
            } else {
                this.bvj.remove(fVar.getId());
            }
            if ("1".equals(fVar.WN())) {
                this.bvk.add(fVar.getId());
            } else {
                this.bvk.remove(fVar.getId());
            }
            if ("1".equals(fVar.WO())) {
                this.bvl.add(fVar.getId());
            } else {
                this.bvl.remove(fVar.getId());
            }
            if (fVar.WP() >= 1 && fVar.WP() <= 100) {
                this.bvn.put(fVar.getId(), String.valueOf(fVar.WP()));
            } else {
                this.bvn.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.bvo.put(fVar.getId(), fVar.getCategory());
            } else {
                this.bvo.remove(fVar.getId());
            }
            if (fVar.WR() != 0 && fVar.WQ() != 0) {
                g gVar = new g(fVar.getId(), fVar.WR(), fVar.WQ());
                this.bvp.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.getIdType(), "1")) {
                this.bvq.add(fVar.getId());
            } else {
                this.bvq.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bvj.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bvm.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kF(String str) {
        if (s.Xr().Ht()) {
            return true;
        }
        return this.bvk.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kG(String str) {
        return this.bvl.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String kH(String str) {
        return this.bvo.containsKey(str) ? this.bvo.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int WJ() {
        return this.bvr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fR(int i) {
        if (i * 60000 >= this.bvr) {
            this.bvr = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int WK() {
        return this.bvs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fS(int i) {
        if (i >= this.bvs) {
            this.bvs = i;
            u.Xs().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int WL() {
        return this.bvt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fT(int i) {
        if (i >= this.bvt) {
            this.bvt = i;
            u.Xs().putInt("ubc_database_limit", i);
        }
    }

    public int kI(String str) {
        if (TextUtils.isEmpty(str) || !this.bvn.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bvn.get(str));
    }

    public boolean kJ(String str) {
        if (this.bvp == null || !this.bvp.containsKey(str)) {
            return false;
        }
        return this.bvp.get(str).WS();
    }

    public boolean kK(String str) {
        if (this.bvp == null || !this.bvp.containsKey(str)) {
            return false;
        }
        return this.bvp.get(str).WT();
    }

    public String kL(String str) {
        return (TextUtils.isEmpty(str) || !this.bvq.contains(str)) ? "0" : "1";
    }
}
