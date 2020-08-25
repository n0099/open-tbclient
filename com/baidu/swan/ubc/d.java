package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private static volatile d dJh;
    private HashSet<String> dJi = new HashSet<>();
    private HashSet<String> dJj = new HashSet<>();
    private HashSet<String> dJk = new HashSet<>();
    private HashSet<String> dJl = new HashSet<>();
    private HashMap<String, String> dJm = new HashMap<>();
    private HashMap<String, String> dJn = new HashMap<>();
    private HashMap<String, h> dJo = new HashMap<>();
    private HashSet<String> dJp = new HashSet<>();
    private int dJq;
    private int dJr;
    private int dJs;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aVB() {
        if (dJh == null) {
            synchronized (d.class) {
                if (dJh == null) {
                    dJh = new d();
                }
            }
        }
        return dJh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dJq = 360000;
        u aWn = u.aWn();
        this.dJr = aWn.getInt("ubc_data_expire_time", 259200000);
        this.dJs = aWn.getInt("ubc_database_limit", 4000);
        cVar.aVy().a(this.dJi, this.dJl, this.dJj, this.dJk, this.dJm, this.dJn, this.dJo, this.dJp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aB(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.aVH())) {
                this.dJi.add(gVar.getId());
            } else {
                this.dJi.remove(gVar.getId());
            }
            if ("1".equals(gVar.aVI())) {
                this.dJj.add(gVar.getId());
            } else {
                this.dJj.remove(gVar.getId());
            }
            if ("1".equals(gVar.aVJ())) {
                this.dJk.add(gVar.getId());
            } else {
                this.dJk.remove(gVar.getId());
            }
            if (gVar.aVK() >= 1 && gVar.aVK() <= 100) {
                this.dJm.put(gVar.getId(), String.valueOf(gVar.aVK()));
            } else {
                this.dJm.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.dJn.put(gVar.getId(), gVar.getCategory());
            } else {
                this.dJn.remove(gVar.getId());
            }
            if (gVar.aVM() != 0 && gVar.aVL() != 0) {
                h hVar = new h(gVar.getId(), gVar.aVM(), gVar.aVL());
                this.dJo.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.aVN(), "1")) {
                this.dJp.add(gVar.getId());
            } else {
                this.dJp.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ad(String str, int i) {
        if (this.dJi.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.dJl.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xa(String str) {
        if (e.aVF().avm()) {
            return true;
        }
        return this.dJj.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xb(String str) {
        return this.dJk.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xc(String str) {
        return this.dJn.containsKey(str) ? this.dJn.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVC() {
        return this.dJq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void md(int i) {
        if (i * 60000 >= this.dJq) {
            this.dJq = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVD() {
        return this.dJr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void me(int i) {
        if (i >= this.dJr) {
            this.dJr = i;
            u.aWn().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVE() {
        return this.dJs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mf(int i) {
        if (i >= this.dJs) {
            this.dJs = i;
            u.aWn().putInt("ubc_database_limit", i);
        }
    }

    public int xd(String str) {
        if (e.aVF().avn() || TextUtils.isEmpty(str) || !this.dJm.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.dJm.get(str));
    }

    public boolean xe(String str) {
        if (this.dJo == null || !this.dJo.containsKey(str)) {
            return false;
        }
        return this.dJo.get(str).aVO();
    }

    public boolean xf(String str) {
        if (this.dJo == null || !this.dJo.containsKey(str)) {
            return false;
        }
        return this.dJo.get(str).aVP();
    }

    public String xg(String str) {
        return (TextUtils.isEmpty(str) || !this.dJp.contains(str)) ? "0" : "1";
    }
}
