package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.av;
/* loaded from: classes7.dex */
public class g {
    private static volatile g aYm;
    private av aJx;
    private SparseArray<String> aYn = new SparseArray<>();
    private SparseArray<String> aYo = new SparseArray<>();
    private SparseArray<String> aYp = new SparseArray<>();
    private SparseArray<String> aYq = new SparseArray<>();

    private g() {
    }

    public static g Im() {
        if (aYm == null) {
            synchronized (g.class) {
                if (aYm == null) {
                    aYm = new g();
                }
            }
        }
        return aYm;
    }

    public String In() {
        if (Ip() || this.aJx.aII == null) {
            return null;
        }
        return this.aJx.aII;
    }

    public String er(int i) {
        String str = this.aYn.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ip() || this.aJx.aIM == null) {
                return null;
            }
            String optString = this.aJx.aIM.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aYn.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String es(int i) {
        String str = this.aYo.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ip() || this.aJx.aIK == null) {
                return null;
            }
            String optString = this.aJx.aIK.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aYo.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String et(int i) {
        String str = this.aYp.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ip() || this.aJx.aIL == null) {
                return null;
            }
            String optString = this.aJx.aIL.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aYp.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eu(int i) {
        String str = this.aYq.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ip() || this.aJx.aIN == null) {
                return null;
            }
            String optString = this.aJx.aIN.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aYq.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public av Io() {
        if (Ip()) {
            return null;
        }
        return this.aJx;
    }

    private boolean Ip() {
        if (this.aJx == null) {
            this.aJx = com.baidu.live.w.a.Nk().bka.aJx;
            if (this.aJx == null) {
                return true;
            }
        }
        return false;
    }
}
