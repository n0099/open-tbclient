package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static volatile d cEr;
    private int cEA;
    private int cEB;
    private int cEC;
    private HashSet<String> cEs = new HashSet<>();
    private HashSet<String> cEt = new HashSet<>();
    private HashSet<String> cEu = new HashSet<>();
    private HashSet<String> cEv = new HashSet<>();
    private HashMap<String, String> cEw = new HashMap<>();
    private HashMap<String, String> cEx = new HashMap<>();
    private HashMap<String, g> cEy = new HashMap<>();
    private HashSet<String> cEz = new HashSet<>();
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d avg() {
        if (cEr == null) {
            synchronized (d.class) {
                if (cEr == null) {
                    cEr = new d();
                }
            }
        }
        return cEr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.cEA = 360000;
        u avS = u.avS();
        this.cEB = avS.getInt("ubc_data_expire_time", 259200000);
        this.cEC = avS.getInt("ubc_database_limit", 4000);
        cVar.avd().a(this.cEs, this.cEv, this.cEt, this.cEu, this.cEw, this.cEx, this.cEy, this.cEz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void an(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.avk())) {
                this.cEs.add(fVar.getId());
            } else {
                this.cEs.remove(fVar.getId());
            }
            if ("1".equals(fVar.avl())) {
                this.cEt.add(fVar.getId());
            } else {
                this.cEt.remove(fVar.getId());
            }
            if ("1".equals(fVar.avm())) {
                this.cEu.add(fVar.getId());
            } else {
                this.cEu.remove(fVar.getId());
            }
            if (fVar.avn() >= 1 && fVar.avn() <= 100) {
                this.cEw.put(fVar.getId(), String.valueOf(fVar.avn()));
            } else {
                this.cEw.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.cEx.put(fVar.getId(), fVar.getCategory());
            } else {
                this.cEx.remove(fVar.getId());
            }
            if (fVar.avp() != 0 && fVar.avo() != 0) {
                g gVar = new g(fVar.getId(), fVar.avp(), fVar.avo());
                this.cEy.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.avq(), "1")) {
                this.cEz.add(fVar.getId());
            } else {
                this.cEz.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R(String str, int i) {
        if (this.cEs.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.cEv.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qP(String str) {
        if (s.avR().Zp()) {
            return true;
        }
        return this.cEt.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qQ(String str) {
        return this.cEu.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String qR(String str) {
        return this.cEx.containsKey(str) ? this.cEx.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avh() {
        return this.cEA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iR(int i) {
        if (i * 60000 >= this.cEA) {
            this.cEA = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avi() {
        return this.cEB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iS(int i) {
        if (i >= this.cEB) {
            this.cEB = i;
            u.avS().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avj() {
        return this.cEC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iT(int i) {
        if (i >= this.cEC) {
            this.cEC = i;
            u.avS().putInt("ubc_database_limit", i);
        }
    }

    public int qS(String str) {
        if (s.avR().Zq() || TextUtils.isEmpty(str) || !this.cEw.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.cEw.get(str));
    }

    public boolean qT(String str) {
        if (this.cEy == null || !this.cEy.containsKey(str)) {
            return false;
        }
        return this.cEy.get(str).avr();
    }

    public boolean qU(String str) {
        if (this.cEy == null || !this.cEy.containsKey(str)) {
            return false;
        }
        return this.cEy.get(str).avs();
    }

    public String qV(String str) {
        return (TextUtils.isEmpty(str) || !this.cEz.contains(str)) ? "0" : "1";
    }
}
