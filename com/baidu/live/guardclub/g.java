package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.ba;
/* loaded from: classes4.dex */
public class g {
    private static volatile g baL;
    private ba aKP;
    private SparseArray<String> baM = new SparseArray<>();
    private SparseArray<String> baN = new SparseArray<>();
    private SparseArray<String> baO = new SparseArray<>();
    private SparseArray<String> baP = new SparseArray<>();

    private g() {
    }

    public static g IP() {
        if (baL == null) {
            synchronized (g.class) {
                if (baL == null) {
                    baL = new g();
                }
            }
        }
        return baL;
    }

    public String IQ() {
        if (IS() || this.aKP.aKa == null) {
            return null;
        }
        return this.aKP.aKa;
    }

    public String ev(int i) {
        String str = this.baM.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IS() || this.aKP.aKe == null) {
                return null;
            }
            String optString = this.aKP.aKe.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.baM.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ew(int i) {
        String str = this.baN.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IS() || this.aKP.aKc == null) {
                return null;
            }
            String optString = this.aKP.aKc.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.baN.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ex(int i) {
        String str = this.baO.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IS() || this.aKP.aKd == null) {
                return null;
            }
            String optString = this.aKP.aKd.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.baO.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ey(int i) {
        String str = this.baP.get(i);
        if (TextUtils.isEmpty(str)) {
            if (IS() || this.aKP.aKf == null) {
                return null;
            }
            String optString = this.aKP.aKf.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.baP.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public ba IR() {
        if (IS()) {
            return null;
        }
        return this.aKP;
    }

    private boolean IS() {
        if (this.aKP == null) {
            this.aKP = com.baidu.live.x.a.NN().bmW.aKP;
            if (this.aKP == null) {
                return true;
            }
        }
        return false;
    }
}
