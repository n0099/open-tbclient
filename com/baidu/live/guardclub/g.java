package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.ba;
/* loaded from: classes4.dex */
public class g {
    private static volatile g bef;
    private ba aNU;
    private SparseArray<String> beh = new SparseArray<>();
    private SparseArray<String> bei = new SparseArray<>();
    private SparseArray<String> bej = new SparseArray<>();
    private SparseArray<String> bek = new SparseArray<>();

    private g() {
    }

    public static g JM() {
        if (bef == null) {
            synchronized (g.class) {
                if (bef == null) {
                    bef = new g();
                }
            }
        }
        return bef;
    }

    public String JN() {
        if (JP() || this.aNU.aNf == null) {
            return null;
        }
        return this.aNU.aNf;
    }

    public String eA(int i) {
        String str = this.beh.get(i);
        if (TextUtils.isEmpty(str)) {
            if (JP() || this.aNU.aNj == null) {
                return null;
            }
            String optString = this.aNU.aNj.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.beh.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eB(int i) {
        String str = this.bei.get(i);
        if (TextUtils.isEmpty(str)) {
            if (JP() || this.aNU.aNh == null) {
                return null;
            }
            String optString = this.aNU.aNh.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bei.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eC(int i) {
        String str = this.bej.get(i);
        if (TextUtils.isEmpty(str)) {
            if (JP() || this.aNU.aNi == null) {
                return null;
            }
            String optString = this.aNU.aNi.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bej.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eD(int i) {
        String str = this.bek.get(i);
        if (TextUtils.isEmpty(str)) {
            if (JP() || this.aNU.aNk == null) {
                return null;
            }
            String optString = this.aNU.aNk.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bek.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public ba JO() {
        if (JP()) {
            return null;
        }
        return this.aNU;
    }

    private boolean JP() {
        if (this.aNU == null) {
            this.aNU = com.baidu.live.x.a.OS().bqJ.aNU;
            if (this.aNU == null) {
                return true;
            }
        }
        return false;
    }
}
