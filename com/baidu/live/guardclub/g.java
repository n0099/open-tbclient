package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.at;
/* loaded from: classes4.dex */
public class g {
    private static volatile g aSY;
    private at aEn;
    private SparseArray<String> aSZ = new SparseArray<>();
    private SparseArray<String> aTa = new SparseArray<>();
    private SparseArray<String> aTb = new SparseArray<>();
    private SparseArray<String> aTc = new SparseArray<>();

    private g() {
    }

    public static g CJ() {
        if (aSY == null) {
            synchronized (g.class) {
                if (aSY == null) {
                    aSY = new g();
                }
            }
        }
        return aSY;
    }

    public String CK() {
        if (CM() || this.aEn.aDy == null) {
            return null;
        }
        return this.aEn.aDy;
    }

    public String cB(int i) {
        String str = this.aSZ.get(i);
        if (TextUtils.isEmpty(str)) {
            if (CM() || this.aEn.aDC == null) {
                return null;
            }
            String optString = this.aEn.aDC.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aSZ.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cC(int i) {
        String str = this.aTa.get(i);
        if (TextUtils.isEmpty(str)) {
            if (CM() || this.aEn.aDA == null) {
                return null;
            }
            String optString = this.aEn.aDA.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aTa.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cD(int i) {
        String str = this.aTb.get(i);
        if (TextUtils.isEmpty(str)) {
            if (CM() || this.aEn.aDB == null) {
                return null;
            }
            String optString = this.aEn.aDB.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aTb.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cE(int i) {
        String str = this.aTc.get(i);
        if (TextUtils.isEmpty(str)) {
            if (CM() || this.aEn.aDD == null) {
                return null;
            }
            String optString = this.aEn.aDD.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aTc.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public at CL() {
        if (CM()) {
            return null;
        }
        return this.aEn;
    }

    private boolean CM() {
        if (this.aEn == null) {
            this.aEn = com.baidu.live.v.a.Hs().beo.aEn;
            if (this.aEn == null) {
                return true;
            }
        }
        return false;
    }
}
