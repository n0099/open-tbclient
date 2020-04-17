package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.ak;
/* loaded from: classes3.dex */
public class g {
    private static volatile g aJk;
    private SparseArray<String> aJl = new SparseArray<>();
    private SparseArray<String> aJm = new SparseArray<>();
    private SparseArray<String> aJn = new SparseArray<>();
    private SparseArray<String> aJo = new SparseArray<>();
    private ak avt;

    private g() {
    }

    public static g As() {
        if (aJk == null) {
            synchronized (g.class) {
                if (aJk == null) {
                    aJk = new g();
                }
            }
        }
        return aJk;
    }

    public String At() {
        if (Av() || this.avt.auI == null) {
            return null;
        }
        return this.avt.auI;
    }

    public String cg(int i) {
        String str = this.aJl.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Av() || this.avt.auM == null) {
                return null;
            }
            String optString = this.avt.auM.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aJl.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ch(int i) {
        String str = this.aJm.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Av() || this.avt.auK == null) {
                return null;
            }
            String optString = this.avt.auK.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aJm.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ci(int i) {
        String str = this.aJn.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Av() || this.avt.auL == null) {
                return null;
            }
            String optString = this.avt.auL.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aJn.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cj(int i) {
        String str = this.aJo.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Av() || this.avt.auN == null) {
                return null;
            }
            String optString = this.avt.auN.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aJo.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public ak Au() {
        if (Av()) {
            return null;
        }
        return this.avt;
    }

    private boolean Av() {
        if (this.avt == null) {
            this.avt = com.baidu.live.v.a.Eo().aRw.avt;
            if (this.avt == null) {
                return true;
            }
        }
        return false;
    }
}
