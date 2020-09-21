package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes14.dex */
public class d {
    private static volatile d dLp;
    private int dLA;
    private HashSet<String> dLq = new HashSet<>();
    private HashSet<String> dLr = new HashSet<>();
    private HashSet<String> dLs = new HashSet<>();
    private HashSet<String> dLt = new HashSet<>();
    private HashMap<String, String> dLu = new HashMap<>();
    private HashMap<String, String> dLv = new HashMap<>();
    private HashMap<String, h> dLw = new HashMap<>();
    private HashSet<String> dLx = new HashSet<>();
    private int dLy;
    private int dLz;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aWn() {
        if (dLp == null) {
            synchronized (d.class) {
                if (dLp == null) {
                    dLp = new d();
                }
            }
        }
        return dLp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dLy = 360000;
        u aWZ = u.aWZ();
        this.dLz = aWZ.getInt("ubc_data_expire_time", 259200000);
        this.dLA = aWZ.getInt("ubc_database_limit", 4000);
        cVar.aWk().a(this.dLq, this.dLt, this.dLr, this.dLs, this.dLu, this.dLv, this.dLw, this.dLx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aF(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.aWt())) {
                this.dLq.add(gVar.getId());
            } else {
                this.dLq.remove(gVar.getId());
            }
            if ("1".equals(gVar.aWu())) {
                this.dLr.add(gVar.getId());
            } else {
                this.dLr.remove(gVar.getId());
            }
            if ("1".equals(gVar.aWv())) {
                this.dLs.add(gVar.getId());
            } else {
                this.dLs.remove(gVar.getId());
            }
            if (gVar.aWw() >= 1 && gVar.aWw() <= 100) {
                this.dLu.put(gVar.getId(), String.valueOf(gVar.aWw()));
            } else {
                this.dLu.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.dLv.put(gVar.getId(), gVar.getCategory());
            } else {
                this.dLv.remove(gVar.getId());
            }
            if (gVar.aWy() != 0 && gVar.aWx() != 0) {
                h hVar = new h(gVar.getId(), gVar.aWy(), gVar.aWx());
                this.dLw.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.aWz(), "1")) {
                this.dLx.add(gVar.getId());
            } else {
                this.dLx.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ad(String str, int i) {
        if (this.dLq.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.dLt.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xu(String str) {
        if (e.aWr().avV()) {
            return true;
        }
        return this.dLr.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xv(String str) {
        return this.dLs.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xw(String str) {
        return this.dLv.containsKey(str) ? this.dLv.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aWo() {
        return this.dLy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mo(int i) {
        if (i * 60000 >= this.dLy) {
            this.dLy = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aWp() {
        return this.dLz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mp(int i) {
        if (i >= this.dLz) {
            this.dLz = i;
            u.aWZ().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aWq() {
        return this.dLA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mq(int i) {
        if (i >= this.dLA) {
            this.dLA = i;
            u.aWZ().putInt("ubc_database_limit", i);
        }
    }

    public int xx(String str) {
        if (e.aWr().avW() || TextUtils.isEmpty(str) || !this.dLu.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.dLu.get(str));
    }

    public boolean xy(String str) {
        if (this.dLw == null || !this.dLw.containsKey(str)) {
            return false;
        }
        return this.dLw.get(str).aWA();
    }

    public boolean xz(String str) {
        if (this.dLw == null || !this.dLw.containsKey(str)) {
            return false;
        }
        return this.dLw.get(str).aWB();
    }

    public String xA(String str) {
        return (TextUtils.isEmpty(str) || !this.dLx.contains(str)) ? "0" : "1";
    }
}
