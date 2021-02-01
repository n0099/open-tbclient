package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes15.dex */
public class d {
    private static volatile d eyc;
    private HashSet<String> eyd = new HashSet<>();
    private HashSet<String> eyf = new HashSet<>();
    private HashSet<String> eyg = new HashSet<>();
    private HashSet<String> eyh = new HashSet<>();
    private HashMap<String, String> eyi = new HashMap<>();
    private HashMap<String, String> eyj = new HashMap<>();
    private HashMap<String, h> eyk = new HashMap<>();
    private HashSet<String> eyl = new HashSet<>();
    private int eyn;
    private int eyo;
    private int eyp;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d beD() {
        if (eyc == null) {
            synchronized (d.class) {
                if (eyc == null) {
                    eyc = new d();
                }
            }
        }
        return eyc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.eyn = 360000;
        u bfp = u.bfp();
        this.eyo = bfp.getInt("ubc_data_expire_time", 259200000);
        this.eyp = bfp.getInt("ubc_database_limit", 4000);
        cVar.beA().a(this.eyd, this.eyh, this.eyf, this.eyg, this.eyi, this.eyj, this.eyk, this.eyl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void be(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.beJ())) {
                this.eyd.add(gVar.getId());
            } else {
                this.eyd.remove(gVar.getId());
            }
            if ("1".equals(gVar.beK())) {
                this.eyf.add(gVar.getId());
            } else {
                this.eyf.remove(gVar.getId());
            }
            if ("1".equals(gVar.beL())) {
                this.eyg.add(gVar.getId());
            } else {
                this.eyg.remove(gVar.getId());
            }
            if (gVar.beM() >= 1 && gVar.beM() <= 100) {
                this.eyi.put(gVar.getId(), String.valueOf(gVar.beM()));
            } else {
                this.eyi.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.eyj.put(gVar.getId(), gVar.getCategory());
            } else {
                this.eyj.remove(gVar.getId());
            }
            if (gVar.beO() != 0 && gVar.beN() != 0) {
                h hVar = new h(gVar.getId(), gVar.beO(), gVar.beN());
                this.eyk.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.beP(), "1")) {
                this.eyl.add(gVar.getId());
            } else {
                this.eyl.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean al(String str, int i) {
        if (this.eyd.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.eyh.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yw(String str) {
        if (e.beH().aDy()) {
            return true;
        }
        return this.eyf.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yx(String str) {
        return this.eyg.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yy(String str) {
        return this.eyj.containsKey(str) ? this.eyj.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beE() {
        return this.eyn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mg(int i) {
        if (i * 60000 >= this.eyn) {
            this.eyn = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beF() {
        return this.eyo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mh(int i) {
        if (i >= this.eyo) {
            this.eyo = i;
            u.bfp().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beG() {
        return this.eyp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mi(int i) {
        if (i >= this.eyp) {
            this.eyp = i;
            u.bfp().putInt("ubc_database_limit", i);
        }
    }

    public int yz(String str) {
        if (e.beH().aDz() || TextUtils.isEmpty(str) || !this.eyi.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.eyi.get(str));
    }

    public boolean yA(String str) {
        if (this.eyk == null || !this.eyk.containsKey(str)) {
            return false;
        }
        return this.eyk.get(str).beQ();
    }

    public boolean yB(String str) {
        if (this.eyk == null || !this.eyk.containsKey(str)) {
            return false;
        }
        return this.eyk.get(str).beR();
    }

    public String yC(String str) {
        return (TextUtils.isEmpty(str) || !this.eyl.contains(str)) ? "0" : "1";
    }
}
