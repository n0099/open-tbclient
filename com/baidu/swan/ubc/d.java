package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static volatile d duj;
    private HashSet<String> duk = new HashSet<>();
    private HashSet<String> dul = new HashSet<>();
    private HashSet<String> dum = new HashSet<>();
    private HashSet<String> dun = new HashSet<>();
    private HashMap<String, String> duo = new HashMap<>();
    private HashMap<String, String> dup = new HashMap<>();
    private HashMap<String, h> duq = new HashMap<>();
    private HashSet<String> dur = new HashSet<>();
    private int dus;
    private int dut;
    private int duu;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aJj() {
        if (duj == null) {
            synchronized (d.class) {
                if (duj == null) {
                    duj = new d();
                }
            }
        }
        return duj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dus = 360000;
        u aJW = u.aJW();
        this.dut = aJW.getInt("ubc_data_expire_time", 259200000);
        this.duu = aJW.getInt("ubc_database_limit", 4000);
        cVar.aJg().a(this.duk, this.dun, this.dul, this.dum, this.duo, this.dup, this.duq, this.dur);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.aJp())) {
                this.duk.add(gVar.getId());
            } else {
                this.duk.remove(gVar.getId());
            }
            if ("1".equals(gVar.aJq())) {
                this.dul.add(gVar.getId());
            } else {
                this.dul.remove(gVar.getId());
            }
            if ("1".equals(gVar.aJr())) {
                this.dum.add(gVar.getId());
            } else {
                this.dum.remove(gVar.getId());
            }
            if (gVar.aJs() >= 1 && gVar.aJs() <= 100) {
                this.duo.put(gVar.getId(), String.valueOf(gVar.aJs()));
            } else {
                this.duo.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.dup.put(gVar.getId(), gVar.getCategory());
            } else {
                this.dup.remove(gVar.getId());
            }
            if (gVar.aJu() != 0 && gVar.aJt() != 0) {
                h hVar = new h(gVar.getId(), gVar.aJu(), gVar.aJt());
                this.duq.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.aJv(), "1")) {
                this.dur.add(gVar.getId());
            } else {
                this.dur.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aa(String str, int i) {
        if (this.duk.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.dun.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tM(String str) {
        if (e.aJn().alY()) {
            return true;
        }
        return this.dul.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tN(String str) {
        return this.dum.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tO(String str) {
        return this.dup.containsKey(str) ? this.dup.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aJk() {
        return this.dus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jE(int i) {
        if (i * 60000 >= this.dus) {
            this.dus = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aJl() {
        return this.dut;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jF(int i) {
        if (i >= this.dut) {
            this.dut = i;
            u.aJW().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aJm() {
        return this.duu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jG(int i) {
        if (i >= this.duu) {
            this.duu = i;
            u.aJW().putInt("ubc_database_limit", i);
        }
    }

    public int tP(String str) {
        if (e.aJn().alZ() || TextUtils.isEmpty(str) || !this.duo.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.duo.get(str));
    }

    public boolean tQ(String str) {
        if (this.duq == null || !this.duq.containsKey(str)) {
            return false;
        }
        return this.duq.get(str).aJw();
    }

    public boolean tR(String str) {
        if (this.duq == null || !this.duq.containsKey(str)) {
            return false;
        }
        return this.duq.get(str).aJx();
    }

    public String tS(String str) {
        return (TextUtils.isEmpty(str) || !this.dur.contains(str)) ? "0" : "1";
    }
}
