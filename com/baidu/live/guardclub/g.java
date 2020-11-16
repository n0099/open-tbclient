package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.bf;
/* loaded from: classes4.dex */
public class g {
    private static volatile g bfe;
    private bf aNL;
    private SparseArray<String> bff = new SparseArray<>();
    private SparseArray<String> bfg = new SparseArray<>();
    private SparseArray<String> bfh = new SparseArray<>();
    private SparseArray<String> bfi = new SparseArray<>();

    private g() {
    }

    public static g JW() {
        if (bfe == null) {
            synchronized (g.class) {
                if (bfe == null) {
                    bfe = new g();
                }
            }
        }
        return bfe;
    }

    public String JX() {
        if (JZ() || this.aNL.aNc == null) {
            return null;
        }
        return this.aNL.aNc;
    }

    public String ex(int i) {
        String str = this.bff.get(i);
        if (TextUtils.isEmpty(str)) {
            if (JZ() || this.aNL.aNg == null) {
                return null;
            }
            String optString = this.aNL.aNg.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bff.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ey(int i) {
        String str = this.bfg.get(i);
        if (TextUtils.isEmpty(str)) {
            if (JZ() || this.aNL.aNe == null) {
                return null;
            }
            String optString = this.aNL.aNe.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bfg.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ez(int i) {
        String str = this.bfh.get(i);
        if (TextUtils.isEmpty(str)) {
            if (JZ() || this.aNL.aNf == null) {
                return null;
            }
            String optString = this.aNL.aNf.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bfh.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eA(int i) {
        String str = this.bfi.get(i);
        if (TextUtils.isEmpty(str)) {
            if (JZ() || this.aNL.aNh == null) {
                return null;
            }
            String optString = this.aNL.aNh.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bfi.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public bf JY() {
        if (JZ()) {
            return null;
        }
        return this.aNL;
    }

    private boolean JZ() {
        if (this.aNL == null) {
            this.aNL = com.baidu.live.aa.a.Ph().bsh.aNL;
            if (this.aNL == null) {
                return true;
            }
        }
        return false;
    }
}
