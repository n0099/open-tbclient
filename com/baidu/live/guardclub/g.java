package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.ak;
/* loaded from: classes3.dex */
public class g {
    private static volatile g aJq;
    private SparseArray<String> aJr = new SparseArray<>();
    private SparseArray<String> aJs = new SparseArray<>();
    private SparseArray<String> aJt = new SparseArray<>();
    private SparseArray<String> aJu = new SparseArray<>();
    private ak avz;

    private g() {
    }

    public static g Ar() {
        if (aJq == null) {
            synchronized (g.class) {
                if (aJq == null) {
                    aJq = new g();
                }
            }
        }
        return aJq;
    }

    public String As() {
        if (Au() || this.avz.auO == null) {
            return null;
        }
        return this.avz.auO;
    }

    public String cg(int i) {
        String str = this.aJr.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Au() || this.avz.auS == null) {
                return null;
            }
            String optString = this.avz.auS.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aJr.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ch(int i) {
        String str = this.aJs.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Au() || this.avz.auQ == null) {
                return null;
            }
            String optString = this.avz.auQ.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aJs.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String ci(int i) {
        String str = this.aJt.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Au() || this.avz.auR == null) {
                return null;
            }
            String optString = this.avz.auR.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aJt.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String cj(int i) {
        String str = this.aJu.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Au() || this.avz.auT == null) {
                return null;
            }
            String optString = this.avz.auT.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aJu.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public ak At() {
        if (Au()) {
            return null;
        }
        return this.avz;
    }

    private boolean Au() {
        if (this.avz == null) {
            this.avz = com.baidu.live.v.a.En().aRB.avz;
            if (this.avz == null) {
                return true;
            }
        }
        return false;
    }
}
