package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static volatile d cEt;
    private int cEC;
    private int cED;
    private int cEE;
    private Context mContext;
    private HashSet<String> cEu = new HashSet<>();
    private HashSet<String> cEv = new HashSet<>();
    private HashSet<String> cEw = new HashSet<>();
    private HashSet<String> cEx = new HashSet<>();
    private HashMap<String, String> cEy = new HashMap<>();
    private HashMap<String, String> cEz = new HashMap<>();
    private HashMap<String, g> cEA = new HashMap<>();
    private HashSet<String> cEB = new HashSet<>();

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d avi() {
        if (cEt == null) {
            synchronized (d.class) {
                if (cEt == null) {
                    cEt = new d();
                }
            }
        }
        return cEt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.cEC = 360000;
        u avU = u.avU();
        this.cED = avU.getInt("ubc_data_expire_time", 259200000);
        this.cEE = avU.getInt("ubc_database_limit", 4000);
        cVar.avf().a(this.cEu, this.cEx, this.cEv, this.cEw, this.cEy, this.cEz, this.cEA, this.cEB);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void an(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.avm())) {
                this.cEu.add(fVar.getId());
            } else {
                this.cEu.remove(fVar.getId());
            }
            if ("1".equals(fVar.avn())) {
                this.cEv.add(fVar.getId());
            } else {
                this.cEv.remove(fVar.getId());
            }
            if ("1".equals(fVar.avo())) {
                this.cEw.add(fVar.getId());
            } else {
                this.cEw.remove(fVar.getId());
            }
            if (fVar.avp() >= 1 && fVar.avp() <= 100) {
                this.cEy.put(fVar.getId(), String.valueOf(fVar.avp()));
            } else {
                this.cEy.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.cEz.put(fVar.getId(), fVar.getCategory());
            } else {
                this.cEz.remove(fVar.getId());
            }
            if (fVar.avr() != 0 && fVar.avq() != 0) {
                g gVar = new g(fVar.getId(), fVar.avr(), fVar.avq());
                this.cEA.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.avs(), "1")) {
                this.cEB.add(fVar.getId());
            } else {
                this.cEB.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R(String str, int i) {
        if (this.cEu.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.cEx.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qP(String str) {
        if (s.avT().Zr()) {
            return true;
        }
        return this.cEv.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qQ(String str) {
        return this.cEw.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String qR(String str) {
        return this.cEz.containsKey(str) ? this.cEz.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avj() {
        return this.cEC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iR(int i) {
        if (i * 60000 >= this.cEC) {
            this.cEC = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avk() {
        return this.cED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iS(int i) {
        if (i >= this.cED) {
            this.cED = i;
            u.avU().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avl() {
        return this.cEE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iT(int i) {
        if (i >= this.cEE) {
            this.cEE = i;
            u.avU().putInt("ubc_database_limit", i);
        }
    }

    public int qS(String str) {
        if (s.avT().Zs() || TextUtils.isEmpty(str) || !this.cEy.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.cEy.get(str));
    }

    public boolean qT(String str) {
        if (this.cEA == null || !this.cEA.containsKey(str)) {
            return false;
        }
        return this.cEA.get(str).avt();
    }

    public boolean qU(String str) {
        if (this.cEA == null || !this.cEA.containsKey(str)) {
            return false;
        }
        return this.cEA.get(str).avu();
    }

    public String qV(String str) {
        return (TextUtils.isEmpty(str) || !this.cEB.contains(str)) ? "0" : "1";
    }
}
