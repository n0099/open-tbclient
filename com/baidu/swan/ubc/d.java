package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bww;
    private int bwF;
    private int bwG;
    private int bwH;
    private Context mContext;
    private HashSet<String> bwx = new HashSet<>();
    private HashSet<String> bwy = new HashSet<>();
    private HashSet<String> bwz = new HashSet<>();
    private HashSet<String> bwA = new HashSet<>();
    private HashMap<String, String> bwB = new HashMap<>();
    private HashMap<String, String> bwC = new HashMap<>();
    private HashMap<String, g> bwD = new HashMap<>();
    private HashSet<String> bwE = new HashSet<>();

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d XG() {
        if (bww == null) {
            synchronized (d.class) {
                if (bww == null) {
                    bww = new d();
                }
            }
        }
        return bww;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bwF = 360000;
        u Ys = u.Ys();
        this.bwG = Ys.getInt("ubc_data_expire_time", 259200000);
        this.bwH = Ys.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.XD().a(this.bwx, this.bwA, this.bwy, this.bwz, this.bwB, this.bwC, this.bwD, this.bwE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.XK())) {
                this.bwx.add(fVar.getId());
            } else {
                this.bwx.remove(fVar.getId());
            }
            if ("1".equals(fVar.XL())) {
                this.bwy.add(fVar.getId());
            } else {
                this.bwy.remove(fVar.getId());
            }
            if ("1".equals(fVar.XM())) {
                this.bwz.add(fVar.getId());
            } else {
                this.bwz.remove(fVar.getId());
            }
            if (fVar.XN() >= 1 && fVar.XN() <= 100) {
                this.bwB.put(fVar.getId(), String.valueOf(fVar.XN()));
            } else {
                this.bwB.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.bwC.put(fVar.getId(), fVar.getCategory());
            } else {
                this.bwC.remove(fVar.getId());
            }
            if (fVar.XP() != 0 && fVar.XO() != 0) {
                g gVar = new g(fVar.getId(), fVar.XP(), fVar.XO());
                this.bwD.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.XQ(), "1")) {
                this.bwE.add(fVar.getId());
            } else {
                this.bwE.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bwx.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bwA.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kP(String str) {
        if (s.Yr().Ij()) {
            return true;
        }
        return this.bwy.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kQ(String str) {
        return this.bwz.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String kR(String str) {
        return this.bwC.containsKey(str) ? this.bwC.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XH() {
        return this.bwF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fW(int i) {
        if (i * 60000 >= this.bwF) {
            this.bwF = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XI() {
        return this.bwG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fX(int i) {
        if (i >= this.bwG) {
            this.bwG = i;
            u.Ys().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XJ() {
        return this.bwH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fY(int i) {
        if (i >= this.bwH) {
            this.bwH = i;
            u.Ys().putInt("ubc_database_limit", i);
        }
    }

    public int kS(String str) {
        if (TextUtils.isEmpty(str) || !this.bwB.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bwB.get(str));
    }

    public boolean kT(String str) {
        if (this.bwD == null || !this.bwD.containsKey(str)) {
            return false;
        }
        return this.bwD.get(str).XR();
    }

    public boolean kU(String str) {
        if (this.bwD == null || !this.bwD.containsKey(str)) {
            return false;
        }
        return this.bwD.get(str).XS();
    }

    public String kV(String str) {
        return (TextUtils.isEmpty(str) || !this.bwE.contains(str)) ? "0" : "1";
    }
}
