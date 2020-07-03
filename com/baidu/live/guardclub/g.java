package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.as;
/* loaded from: classes3.dex */
public class g {
    private static volatile g aRF;
    private as aCS;
    private SparseArray<String> aRG = new SparseArray<>();
    private SparseArray<String> aRH = new SparseArray<>();
    private SparseArray<String> aRI = new SparseArray<>();
    private SparseArray<String> aRJ = new SparseArray<>();

    private g() {
    }

    public static g Ch() {
        if (aRF == null) {
            synchronized (g.class) {
                if (aRF == null) {
                    aRF = new g();
                }
            }
        }
        return aRF;
    }

    public String Ci() {
        if (Ck() || this.aCS.aCd == null) {
            return null;
        }
        return this.aCS.aCd;
    }

    public String cv(int i) {
        String str = this.aRG.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ck() || this.aCS.aCh == null) {
                return null;
            }
            String optString = this.aCS.aCh.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aRG.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cw(int i) {
        String str = this.aRH.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ck() || this.aCS.aCf == null) {
                return null;
            }
            String optString = this.aCS.aCf.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aRH.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cx(int i) {
        String str = this.aRI.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ck() || this.aCS.aCg == null) {
                return null;
            }
            String optString = this.aCS.aCg.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aRI.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cy(int i) {
        String str = this.aRJ.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ck() || this.aCS.aCi == null) {
                return null;
            }
            String optString = this.aCS.aCi.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aRJ.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public as Cj() {
        if (Ck()) {
            return null;
        }
        return this.aCS;
    }

    private boolean Ck() {
        if (this.aCS == null) {
            this.aCS = com.baidu.live.v.a.Hm().bdV.aCS;
            if (this.aCS == null) {
                return true;
            }
        }
        return false;
    }
}
