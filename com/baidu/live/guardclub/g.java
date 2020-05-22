package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.ao;
/* loaded from: classes3.dex */
public class g {
    private static volatile g aOZ;
    private ao aAH;
    private SparseArray<String> aPa = new SparseArray<>();
    private SparseArray<String> aPb = new SparseArray<>();
    private SparseArray<String> aPc = new SparseArray<>();
    private SparseArray<String> aPd = new SparseArray<>();

    private g() {
    }

    public static g BH() {
        if (aOZ == null) {
            synchronized (g.class) {
                if (aOZ == null) {
                    aOZ = new g();
                }
            }
        }
        return aOZ;
    }

    public String BI() {
        if (BK() || this.aAH.azS == null) {
            return null;
        }
        return this.aAH.azS;
    }

    public String cn(int i) {
        String str = this.aPa.get(i);
        if (TextUtils.isEmpty(str)) {
            if (BK() || this.aAH.azW == null) {
                return null;
            }
            String optString = this.aAH.azW.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aPa.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String co(int i) {
        String str = this.aPb.get(i);
        if (TextUtils.isEmpty(str)) {
            if (BK() || this.aAH.azU == null) {
                return null;
            }
            String optString = this.aAH.azU.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aPb.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cp(int i) {
        String str = this.aPc.get(i);
        if (TextUtils.isEmpty(str)) {
            if (BK() || this.aAH.azV == null) {
                return null;
            }
            String optString = this.aAH.azV.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aPc.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cq(int i) {
        String str = this.aPd.get(i);
        if (TextUtils.isEmpty(str)) {
            if (BK() || this.aAH.azX == null) {
                return null;
            }
            String optString = this.aAH.azX.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aPd.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public ao BJ() {
        if (BK()) {
            return null;
        }
        return this.aAH;
    }

    private boolean BK() {
        if (this.aAH == null) {
            this.aAH = com.baidu.live.v.a.Ge().aYP.aAH;
            if (this.aAH == null) {
                return true;
            }
        }
        return false;
    }
}
