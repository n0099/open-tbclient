package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.bf;
/* loaded from: classes4.dex */
public class g {
    private static volatile g bgR;
    private bf aPw;
    private SparseArray<String> bgS = new SparseArray<>();
    private SparseArray<String> bgT = new SparseArray<>();
    private SparseArray<String> bgU = new SparseArray<>();
    private SparseArray<String> bgV = new SparseArray<>();

    private g() {
    }

    public static g KF() {
        if (bgR == null) {
            synchronized (g.class) {
                if (bgR == null) {
                    bgR = new g();
                }
            }
        }
        return bgR;
    }

    public String KG() {
        if (KI() || this.aPw.aON == null) {
            return null;
        }
        return this.aPw.aON;
    }

    public String eB(int i) {
        String str = this.bgS.get(i);
        if (TextUtils.isEmpty(str)) {
            if (KI() || this.aPw.aOR == null) {
                return null;
            }
            String optString = this.aPw.aOR.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bgS.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eC(int i) {
        String str = this.bgT.get(i);
        if (TextUtils.isEmpty(str)) {
            if (KI() || this.aPw.aOP == null) {
                return null;
            }
            String optString = this.aPw.aOP.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bgT.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eD(int i) {
        String str = this.bgU.get(i);
        if (TextUtils.isEmpty(str)) {
            if (KI() || this.aPw.aOQ == null) {
                return null;
            }
            String optString = this.aPw.aOQ.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bgU.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eE(int i) {
        String str = this.bgV.get(i);
        if (TextUtils.isEmpty(str)) {
            if (KI() || this.aPw.aOS == null) {
                return null;
            }
            String optString = this.aPw.aOS.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bgV.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public bf KH() {
        if (KI()) {
            return null;
        }
        return this.aPw;
    }

    private boolean KI() {
        if (this.aPw == null) {
            this.aPw = com.baidu.live.aa.a.PQ().btT.aPw;
            if (this.aPw == null) {
                return true;
            }
        }
        return false;
    }
}
