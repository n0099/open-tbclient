package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.av;
/* loaded from: classes7.dex */
public class g {
    private static volatile g aYo;
    private av aJz;
    private SparseArray<String> aYp = new SparseArray<>();
    private SparseArray<String> aYq = new SparseArray<>();
    private SparseArray<String> aYr = new SparseArray<>();
    private SparseArray<String> aYs = new SparseArray<>();

    private g() {
    }

    public static g Im() {
        if (aYo == null) {
            synchronized (g.class) {
                if (aYo == null) {
                    aYo = new g();
                }
            }
        }
        return aYo;
    }

    public String In() {
        if (Ip() || this.aJz.aIK == null) {
            return null;
        }
        return this.aJz.aIK;
    }

    public String er(int i) {
        String str = this.aYp.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ip() || this.aJz.aIO == null) {
                return null;
            }
            String optString = this.aJz.aIO.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aYp.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String es(int i) {
        String str = this.aYq.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ip() || this.aJz.aIM == null) {
                return null;
            }
            String optString = this.aJz.aIM.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aYq.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String et(int i) {
        String str = this.aYr.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ip() || this.aJz.aIN == null) {
                return null;
            }
            String optString = this.aJz.aIN.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aYr.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eu(int i) {
        String str = this.aYs.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Ip() || this.aJz.aIP == null) {
                return null;
            }
            String optString = this.aJz.aIP.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.aYs.put(i, optString);
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
        return this.aJz;
    }

    private boolean Ip() {
        if (this.aJz == null) {
            this.aJz = com.baidu.live.w.a.Nk().bkd.aJz;
            if (this.aJz == null) {
                return true;
            }
        }
        return false;
    }
}
