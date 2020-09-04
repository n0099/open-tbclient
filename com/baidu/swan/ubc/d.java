package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private static volatile d dJl;
    private HashSet<String> dJm = new HashSet<>();
    private HashSet<String> dJn = new HashSet<>();
    private HashSet<String> dJo = new HashSet<>();
    private HashSet<String> dJp = new HashSet<>();
    private HashMap<String, String> dJq = new HashMap<>();
    private HashMap<String, String> dJr = new HashMap<>();
    private HashMap<String, h> dJs = new HashMap<>();
    private HashSet<String> dJt = new HashSet<>();
    private int dJu;
    private int dJv;
    private int dJw;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aVB() {
        if (dJl == null) {
            synchronized (d.class) {
                if (dJl == null) {
                    dJl = new d();
                }
            }
        }
        return dJl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dJu = 360000;
        u aWn = u.aWn();
        this.dJv = aWn.getInt("ubc_data_expire_time", 259200000);
        this.dJw = aWn.getInt("ubc_database_limit", 4000);
        cVar.aVy().a(this.dJm, this.dJp, this.dJn, this.dJo, this.dJq, this.dJr, this.dJs, this.dJt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aB(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.aVH())) {
                this.dJm.add(gVar.getId());
            } else {
                this.dJm.remove(gVar.getId());
            }
            if ("1".equals(gVar.aVI())) {
                this.dJn.add(gVar.getId());
            } else {
                this.dJn.remove(gVar.getId());
            }
            if ("1".equals(gVar.aVJ())) {
                this.dJo.add(gVar.getId());
            } else {
                this.dJo.remove(gVar.getId());
            }
            if (gVar.aVK() >= 1 && gVar.aVK() <= 100) {
                this.dJq.put(gVar.getId(), String.valueOf(gVar.aVK()));
            } else {
                this.dJq.remove(gVar.getId());
            }
            if (!TextUtils.isEmpty(gVar.getCategory())) {
                this.dJr.put(gVar.getId(), gVar.getCategory());
            } else {
                this.dJr.remove(gVar.getId());
            }
            if (gVar.aVM() != 0 && gVar.aVL() != 0) {
                h hVar = new h(gVar.getId(), gVar.aVM(), gVar.aVL());
                this.dJs.put(hVar.getId(), hVar);
            }
            if (TextUtils.equals(gVar.aVN(), "1")) {
                this.dJt.add(gVar.getId());
            } else {
                this.dJt.remove(gVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ad(String str, int i) {
        if (this.dJm.contains(str)) {
            return false;
        }
        if ((i & 16) != 0 || (i & 32) != 0) {
            return this.dJp.contains(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xb(String str) {
        if (e.aVF().avm()) {
            return true;
        }
        return this.dJn.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xc(String str) {
        return this.dJo.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xd(String str) {
        return this.dJr.containsKey(str) ? this.dJr.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVC() {
        return this.dJu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void md(int i) {
        if (i * 60000 >= this.dJu) {
            this.dJu = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVD() {
        return this.dJv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void me(int i) {
        if (i >= this.dJv) {
            this.dJv = i;
            u.aWn().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVE() {
        return this.dJw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mf(int i) {
        if (i >= this.dJw) {
            this.dJw = i;
            u.aWn().putInt("ubc_database_limit", i);
        }
    }

    public int xe(String str) {
        if (e.aVF().avn() || TextUtils.isEmpty(str) || !this.dJq.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.dJq.get(str));
    }

    public boolean xf(String str) {
        if (this.dJs == null || !this.dJs.containsKey(str)) {
            return false;
        }
        return this.dJs.get(str).aVO();
    }

    public boolean xg(String str) {
        if (this.dJs == null || !this.dJs.containsKey(str)) {
            return false;
        }
        return this.dJs.get(str).aVP();
    }

    public String xh(String str) {
        return (TextUtils.isEmpty(str) || !this.dJt.contains(str)) ? "0" : "1";
    }
}
