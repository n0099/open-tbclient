package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.ah;
/* loaded from: classes3.dex */
public class g {
    private static volatile g aqB;
    private ah adb;
    private SparseArray<String> aqC = new SparseArray<>();
    private SparseArray<String> aqD = new SparseArray<>();
    private SparseArray<String> aqE = new SparseArray<>();
    private SparseArray<String> aqF = new SparseArray<>();

    private g() {
    }

    public static g vM() {
        if (aqB == null) {
            synchronized (g.class) {
                if (aqB == null) {
                    aqB = new g();
                }
            }
        }
        return aqB;
    }

    public String vN() {
        if (vP() || this.adb.acn == null) {
            return null;
        }
        return this.adb.acn;
    }

    public String bR(int i) {
        String str = this.aqC.get(i);
        if (TextUtils.isEmpty(str)) {
            if (vP() || this.adb.acr == null) {
                return null;
            }
            String optString = this.adb.acr.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aqC.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String bS(int i) {
        String str = this.aqD.get(i);
        if (TextUtils.isEmpty(str)) {
            if (vP() || this.adb.acp == null) {
                return null;
            }
            String optString = this.adb.acp.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aqD.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String bT(int i) {
        String str = this.aqE.get(i);
        if (TextUtils.isEmpty(str)) {
            if (vP() || this.adb.acq == null) {
                return null;
            }
            String optString = this.adb.acq.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aqE.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String bU(int i) {
        String str = this.aqF.get(i);
        if (TextUtils.isEmpty(str)) {
            if (vP() || this.adb.acs == null) {
                return null;
            }
            String optString = this.adb.acs.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aqF.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public ah vO() {
        if (vP()) {
            return null;
        }
        return this.adb;
    }

    private boolean vP() {
        if (this.adb == null) {
            this.adb = com.baidu.live.v.a.zs().axR.adb;
            if (this.adb == null) {
                return true;
            }
        }
        return false;
    }
}
