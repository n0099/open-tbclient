package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bPd;
    private HashSet<String> bPe = new HashSet<>();
    private HashSet<String> bPf = new HashSet<>();
    private HashSet<String> bPg = new HashSet<>();
    private HashSet<String> bPh = new HashSet<>();
    private HashMap<String, String> bPi = new HashMap<>();
    private HashMap<String, String> bPj = new HashMap<>();
    private HashMap<String, g> bPk = new HashMap<>();
    private HashSet<String> bPl = new HashSet<>();
    private int bPm;
    private int bPn;
    private int bPo;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d acv() {
        if (bPd == null) {
            synchronized (d.class) {
                if (bPd == null) {
                    bPd = new d();
                }
            }
        }
        return bPd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bPm = 360000;
        u adi = u.adi();
        this.bPn = adi.getInt("ubc_data_expire_time", 259200000);
        this.bPo = adi.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.acs().a(this.bPe, this.bPh, this.bPf, this.bPg, this.bPi, this.bPj, this.bPk, this.bPl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.acz())) {
                this.bPe.add(fVar.getId());
            } else {
                this.bPe.remove(fVar.getId());
            }
            if ("1".equals(fVar.acA())) {
                this.bPf.add(fVar.getId());
            } else {
                this.bPf.remove(fVar.getId());
            }
            if ("1".equals(fVar.acB())) {
                this.bPg.add(fVar.getId());
            } else {
                this.bPg.remove(fVar.getId());
            }
            if (fVar.acC() >= 1 && fVar.acC() <= 100) {
                this.bPi.put(fVar.getId(), String.valueOf(fVar.acC()));
            } else {
                this.bPi.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.bPj.put(fVar.getId(), fVar.getCategory());
            } else {
                this.bPj.remove(fVar.getId());
            }
            if (fVar.acE() != 0 && fVar.acD() != 0) {
                g gVar = new g(fVar.getId(), fVar.acE(), fVar.acD());
                this.bPk.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.acF(), "1")) {
                this.bPl.add(fVar.getId());
            } else {
                this.bPl.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bPe.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bPh.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean lr(String str) {
        if (s.adh().Nd()) {
            return true;
        }
        return this.bPf.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ls(String str) {
        return this.bPg.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lt(String str) {
        return this.bPj.containsKey(str) ? this.bPj.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acw() {
        return this.bPm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gR(int i) {
        if (i * 60000 >= this.bPm) {
            this.bPm = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acx() {
        return this.bPn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gS(int i) {
        if (i >= this.bPn) {
            this.bPn = i;
            u.adi().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acy() {
        return this.bPo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gT(int i) {
        if (i >= this.bPo) {
            this.bPo = i;
            u.adi().putInt("ubc_database_limit", i);
        }
    }

    public int lu(String str) {
        if (TextUtils.isEmpty(str) || !this.bPi.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bPi.get(str));
    }

    public boolean lv(String str) {
        if (this.bPk == null || !this.bPk.containsKey(str)) {
            return false;
        }
        return this.bPk.get(str).acG();
    }

    public boolean lw(String str) {
        if (this.bPk == null || !this.bPk.containsKey(str)) {
            return false;
        }
        return this.bPk.get(str).acH();
    }

    public String lx(String str) {
        return (TextUtils.isEmpty(str) || !this.bPl.contains(str)) ? "0" : "1";
    }
}
