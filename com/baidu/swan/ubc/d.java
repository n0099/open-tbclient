package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bOm;
    private HashSet<String> bOn = new HashSet<>();
    private HashSet<String> bOo = new HashSet<>();
    private HashSet<String> bOp = new HashSet<>();
    private HashSet<String> bOq = new HashSet<>();
    private HashMap<String, String> bOr = new HashMap<>();
    private HashMap<String, String> bOs = new HashMap<>();
    private HashMap<String, g> bOt = new HashMap<>();
    private HashSet<String> bOu = new HashSet<>();
    private int bOv;
    private int bOw;
    private int bOx;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d act() {
        if (bOm == null) {
            synchronized (d.class) {
                if (bOm == null) {
                    bOm = new d();
                }
            }
        }
        return bOm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bOv = 360000;
        u adg = u.adg();
        this.bOw = adg.getInt("ubc_data_expire_time", 259200000);
        this.bOx = adg.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.acq().a(this.bOn, this.bOq, this.bOo, this.bOp, this.bOr, this.bOs, this.bOt, this.bOu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.acx())) {
                this.bOn.add(fVar.getId());
            } else {
                this.bOn.remove(fVar.getId());
            }
            if ("1".equals(fVar.acy())) {
                this.bOo.add(fVar.getId());
            } else {
                this.bOo.remove(fVar.getId());
            }
            if ("1".equals(fVar.acz())) {
                this.bOp.add(fVar.getId());
            } else {
                this.bOp.remove(fVar.getId());
            }
            if (fVar.acA() >= 1 && fVar.acA() <= 100) {
                this.bOr.put(fVar.getId(), String.valueOf(fVar.acA()));
            } else {
                this.bOr.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.bOs.put(fVar.getId(), fVar.getCategory());
            } else {
                this.bOs.remove(fVar.getId());
            }
            if (fVar.acC() != 0 && fVar.acB() != 0) {
                g gVar = new g(fVar.getId(), fVar.acC(), fVar.acB());
                this.bOt.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.acD(), "1")) {
                this.bOu.add(fVar.getId());
            } else {
                this.bOu.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bOn.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bOq.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean lr(String str) {
        if (s.adf().Ne()) {
            return true;
        }
        return this.bOo.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ls(String str) {
        return this.bOp.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lt(String str) {
        return this.bOs.containsKey(str) ? this.bOs.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acu() {
        return this.bOv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gQ(int i) {
        if (i * 60000 >= this.bOv) {
            this.bOv = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acv() {
        return this.bOw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gR(int i) {
        if (i >= this.bOw) {
            this.bOw = i;
            u.adg().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acw() {
        return this.bOx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gS(int i) {
        if (i >= this.bOx) {
            this.bOx = i;
            u.adg().putInt("ubc_database_limit", i);
        }
    }

    public int lu(String str) {
        if (TextUtils.isEmpty(str) || !this.bOr.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bOr.get(str));
    }

    public boolean lv(String str) {
        if (this.bOt == null || !this.bOt.containsKey(str)) {
            return false;
        }
        return this.bOt.get(str).acE();
    }

    public boolean lw(String str) {
        if (this.bOt == null || !this.bOt.containsKey(str)) {
            return false;
        }
        return this.bOt.get(str).acF();
    }

    public String lx(String str) {
        return (TextUtils.isEmpty(str) || !this.bOu.contains(str)) ? "0" : "1";
    }
}
