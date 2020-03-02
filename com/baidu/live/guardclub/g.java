package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.ah;
/* loaded from: classes3.dex */
public class g {
    private static volatile g aqq;
    private ah acR;
    private SparseArray<String> aqr = new SparseArray<>();
    private SparseArray<String> aqs = new SparseArray<>();
    private SparseArray<String> aqt = new SparseArray<>();
    private SparseArray<String> aqu = new SparseArray<>();

    private g() {
    }

    public static g vH() {
        if (aqq == null) {
            synchronized (g.class) {
                if (aqq == null) {
                    aqq = new g();
                }
            }
        }
        return aqq;
    }

    public String vI() {
        if (vK() || this.acR.acb == null) {
            return null;
        }
        return this.acR.acb;
    }

    public String bR(int i) {
        String str = this.aqr.get(i);
        if (TextUtils.isEmpty(str)) {
            if (vK() || this.acR.acf == null) {
                return null;
            }
            String optString = this.acR.acf.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aqr.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String bS(int i) {
        String str = this.aqs.get(i);
        if (TextUtils.isEmpty(str)) {
            if (vK() || this.acR.acd == null) {
                return null;
            }
            String optString = this.acR.acd.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aqs.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String bT(int i) {
        String str = this.aqt.get(i);
        if (TextUtils.isEmpty(str)) {
            if (vK() || this.acR.ace == null) {
                return null;
            }
            String optString = this.acR.ace.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aqt.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String bU(int i) {
        String str = this.aqu.get(i);
        if (TextUtils.isEmpty(str)) {
            if (vK() || this.acR.acg == null) {
                return null;
            }
            String optString = this.acR.acg.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aqu.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public ah vJ() {
        if (vK()) {
            return null;
        }
        return this.acR;
    }

    private boolean vK() {
        if (this.acR == null) {
            this.acR = com.baidu.live.v.a.zl().axC.acR;
            if (this.acR == null) {
                return true;
            }
        }
        return false;
    }
}
