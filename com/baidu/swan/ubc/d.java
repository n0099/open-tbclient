package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private static volatile d evV;
    private HashSet<String> evW = new HashSet<>();
    private HashSet<String> evX = new HashSet<>();
    private HashSet<String> evY = new HashSet<>();
    private HashSet<String> evZ = new HashSet<>();
    private HashMap<String, String> ewa = new HashMap<>();
    private HashMap<String, String> ewb = new HashMap<>();
    private HashMap<String, h> ewc = new HashMap<>();
    private HashSet<String> ewd = new HashSet<>();
    private int ewe;
    private int ewf;
    private int ewg;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d beq() {
        if (evV == null) {
            synchronized (d.class) {
                if (evV == null) {
                    evV = new d();
                }
            }
        }
        return evV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ewe = 360000;
        u bfc = u.bfc();
        this.ewf = bfc.getInt("ubc_data_expire_time", 259200000);
        this.ewg = bfc.getInt("ubc_database_limit", 4000);
        cVar.ben().a(this.evW, this.evZ, this.evX, this.evY, this.ewa, this.ewb, this.ewc, this.ewd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bj(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.bew())) {
                this.evW.add(gVar.getId());
            } else {
                this.evW.remove(gVar.getId());
            }
            if ("1".equals(gVar.bex())) {
                this.evX.add(gVar.getId());
            } else {
                this.evX.remove(gVar.getId());
            }
            if ("1".equals(gVar.bey())) {
                this.evY.add(gVar.getId());
            } else {
                this.evY.remove(gVar.getId());
            }
            if (gVar.bez() >= 1 && gVar.bez() <= 100) {
                this.ewa.put(gVar.getId(), String.valueOf(gVar.bez()));
            } else {
                this.ewa.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.ewb.put(gVar.getId(), gVar.getCategory());
            } else {
                this.ewb.remove(gVar.getId());
            }
            if (gVar.beB() != 0 && gVar.beA() != 0) {
                h hVar = new h(gVar.getId(), gVar.beB(), gVar.beA());
                this.ewc.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.beC(), "1")) {
                this.ewd.add(gVar.getId());
            } else {
                this.ewd.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aj(String str, int i) {
        if (this.evW.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.evZ.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yd(String str) {
        if (e.beu().aDc()) {
            return true;
        }
        return this.evX.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ye(String str) {
        return this.evY.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yf(String str) {
        return this.ewb.containsKey(str) ? this.ewb.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ber() {
        return this.ewe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void md(int i) {
        if (i * 60000 >= this.ewe) {
            this.ewe = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bes() {
        return this.ewf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void me(int i) {
        if (i >= this.ewf) {
            this.ewf = i;
            u.bfc().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bet() {
        return this.ewg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mf(int i) {
        if (i >= this.ewg) {
            this.ewg = i;
            u.bfc().putInt("ubc_database_limit", i);
        }
    }

    public int yg(String str) {
        if (e.beu().aDd() || TextUtils.isEmpty(str) || !this.ewa.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ewa.get(str));
    }

    public boolean yh(String str) {
        if (this.ewc == null || !this.ewc.containsKey(str)) {
            return false;
        }
        return this.ewc.get(str).beD();
    }

    public boolean yi(String str) {
        if (this.ewc == null || !this.ewc.containsKey(str)) {
            return false;
        }
        return this.ewc.get(str).beE();
    }

    public String yj(String str) {
        return (TextUtils.isEmpty(str) || !this.ewd.contains(str)) ? "0" : "1";
    }
}
