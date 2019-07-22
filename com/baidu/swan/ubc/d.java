package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bvY;
    private HashSet<String> bvZ = new HashSet<>();
    private HashSet<String> bwa = new HashSet<>();
    private HashSet<String> bwb = new HashSet<>();
    private HashSet<String> bwc = new HashSet<>();
    private HashMap<String, String> bwd = new HashMap<>();
    private HashMap<String, String> bwe = new HashMap<>();
    private HashMap<String, g> bwf = new HashMap<>();
    private HashSet<String> bwg = new HashSet<>();
    private int bwh;
    private int bwi;
    private int bwj;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d XC() {
        if (bvY == null) {
            synchronized (d.class) {
                if (bvY == null) {
                    bvY = new d();
                }
            }
        }
        return bvY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bwh = 360000;
        u Yo = u.Yo();
        this.bwi = Yo.getInt("ubc_data_expire_time", 259200000);
        this.bwj = Yo.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.Xz().a(this.bvZ, this.bwc, this.bwa, this.bwb, this.bwd, this.bwe, this.bwf, this.bwg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(List<f> list) {
        for (f fVar : list) {
            if ("0".equals(fVar.XG())) {
                this.bvZ.add(fVar.getId());
            } else {
                this.bvZ.remove(fVar.getId());
            }
            if ("1".equals(fVar.XH())) {
                this.bwa.add(fVar.getId());
            } else {
                this.bwa.remove(fVar.getId());
            }
            if ("1".equals(fVar.XI())) {
                this.bwb.add(fVar.getId());
            } else {
                this.bwb.remove(fVar.getId());
            }
            if (fVar.XJ() >= 1 && fVar.XJ() <= 100) {
                this.bwd.put(fVar.getId(), String.valueOf(fVar.XJ()));
            } else {
                this.bwd.remove(fVar.getId());
            }
            if (!TextUtils.isEmpty(fVar.getCategory())) {
                this.bwe.put(fVar.getId(), fVar.getCategory());
            } else {
                this.bwe.remove(fVar.getId());
            }
            if (fVar.XL() != 0 && fVar.XK() != 0) {
                g gVar = new g(fVar.getId(), fVar.XL(), fVar.XK());
                this.bwf.put(gVar.getId(), gVar);
            }
            if (TextUtils.equals(fVar.XM(), "1")) {
                this.bwg.add(fVar.getId());
            } else {
                this.bwg.remove(fVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bvZ.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bwc.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kN(String str) {
        if (s.Yn().If()) {
            return true;
        }
        return this.bwa.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kO(String str) {
        return this.bwb.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String kP(String str) {
        return this.bwe.containsKey(str) ? this.bwe.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XD() {
        return this.bwh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fV(int i) {
        if (i * 60000 >= this.bwh) {
            this.bwh = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XE() {
        return this.bwi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fW(int i) {
        if (i >= this.bwi) {
            this.bwi = i;
            u.Yo().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XF() {
        return this.bwj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fX(int i) {
        if (i >= this.bwj) {
            this.bwj = i;
            u.Yo().putInt("ubc_database_limit", i);
        }
    }

    public int kQ(String str) {
        if (TextUtils.isEmpty(str) || !this.bwd.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bwd.get(str));
    }

    public boolean kR(String str) {
        if (this.bwf == null || !this.bwf.containsKey(str)) {
            return false;
        }
        return this.bwf.get(str).XN();
    }

    public boolean kS(String str) {
        if (this.bwf == null || !this.bwf.containsKey(str)) {
            return false;
        }
        return this.bwf.get(str).XO();
    }

    public String kT(String str) {
        return (TextUtils.isEmpty(str) || !this.bwg.contains(str)) ? "0" : "1";
    }
}
