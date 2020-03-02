package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static volatile d cEs;
    private int cEB;
    private int cEC;
    private int cED;
    private Context mContext;
    private HashSet<String> cEt = new HashSet<>();
    private HashSet<String> cEu = new HashSet<>();
    private HashSet<String> cEv = new HashSet<>();
    private HashSet<String> cEw = new HashSet<>();
    private HashMap<String, String> cEx = new HashMap<>();
    private HashMap<String, String> cEy = new HashMap<>();
    private HashMap<String, g> cEz = new HashMap<>();
    private HashSet<String> cEA = new HashSet<>();

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d avi() {
        if (cEs == null) {
            synchronized (d.class) {
                if (cEs == null) {
                    cEs = new d();
                }
            }
        }
        return cEs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.cEB = 360000;
        u avU = u.avU();
        this.cEC = avU.getInt("ubc_data_expire_time", 259200000);
        this.cED = avU.getInt("ubc_database_limit", 4000);
        cVar.avf().a(this.cEt, this.cEw, this.cEu, this.cEv, this.cEx, this.cEy, this.cEz, this.cEA);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void an(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.avm())) {
                this.cEt.add(fVar.getId());
            } else {
                this.cEt.remove(fVar.getId());
            }
            if ("1".equals(fVar.avn())) {
                this.cEu.add(fVar.getId());
            } else {
                this.cEu.remove(fVar.getId());
            }
            if ("1".equals(fVar.avo())) {
                this.cEv.add(fVar.getId());
            } else {
                this.cEv.remove(fVar.getId());
            }
            if (fVar.avp() >= 1 && fVar.avp() <= 100) {
                this.cEx.put(fVar.getId(), String.valueOf(fVar.avp()));
            } else {
                this.cEx.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.cEy.put(fVar.getId(), fVar.getCategory());
            } else {
                this.cEy.remove(fVar.getId());
            }
            if (fVar.avr() != 0 && fVar.avq() != 0) {
                g gVar = new g(fVar.getId(), fVar.avr(), fVar.avq());
                this.cEz.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.avs(), "1")) {
                this.cEA.add(fVar.getId());
            } else {
                this.cEA.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R(String str, int i) {
        if (this.cEt.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.cEw.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qP(String str) {
        if (s.avT().Zr()) {
            return true;
        }
        return this.cEu.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qQ(String str) {
        return this.cEv.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String qR(String str) {
        return this.cEy.containsKey(str) ? this.cEy.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avj() {
        return this.cEB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iR(int i) {
        if (i * 60000 >= this.cEB) {
            this.cEB = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avk() {
        return this.cEC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iS(int i) {
        if (i >= this.cEC) {
            this.cEC = i;
            u.avU().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avl() {
        return this.cED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iT(int i) {
        if (i >= this.cED) {
            this.cED = i;
            u.avU().putInt("ubc_database_limit", i);
        }
    }

    public int qS(String str) {
        if (s.avT().Zs() || TextUtils.isEmpty(str) || !this.cEx.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.cEx.get(str));
    }

    public boolean qT(String str) {
        if (this.cEz == null || !this.cEz.containsKey(str)) {
            return false;
        }
        return this.cEz.get(str).avt();
    }

    public boolean qU(String str) {
        if (this.cEz == null || !this.cEz.containsKey(str)) {
            return false;
        }
        return this.cEz.get(str).avu();
    }

    public String qV(String str) {
        return (TextUtils.isEmpty(str) || !this.cEA.contains(str)) ? "0" : "1";
    }
}
