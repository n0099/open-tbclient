package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.bd;
/* loaded from: classes4.dex */
public class g {
    private static volatile g bfx;
    private bd aOz;
    private SparseArray<String> bfy = new SparseArray<>();
    private SparseArray<String> bfz = new SparseArray<>();
    private SparseArray<String> bfA = new SparseArray<>();
    private SparseArray<String> bfB = new SparseArray<>();

    private g() {
    }

    public static g Kf() {
        if (bfx == null) {
            synchronized (g.class) {
                if (bfx == null) {
                    bfx = new g();
                }
            }
        }
        return bfx;
    }

    public String Kg() {
        if (Ki() || this.aOz.aNK == null) {
            return null;
        }
        return this.aOz.aNK;
    }

    public String eB(int i) {
        String str = this.bfy.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ki() || this.aOz.aNO == null) {
                return null;
            }
            String optString = this.aOz.aNO.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bfy.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eC(int i) {
        String str = this.bfz.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ki() || this.aOz.aNM == null) {
                return null;
            }
            String optString = this.aOz.aNM.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bfz.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eD(int i) {
        String str = this.bfA.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ki() || this.aOz.aNN == null) {
                return null;
            }
            String optString = this.aOz.aNN.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bfA.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eE(int i) {
        String str = this.bfB.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ki() || this.aOz.aNP == null) {
                return null;
            }
            String optString = this.aOz.aNP.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bfB.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public bd Kh() {
        if (Ki()) {
            return null;
        }
        return this.aOz;
    }

    private boolean Ki() {
        if (this.aOz == null) {
            this.aOz = com.baidu.live.z.a.Pq().bsy.aOz;
            if (this.aOz == null) {
                return true;
            }
        }
        return false;
    }
}
