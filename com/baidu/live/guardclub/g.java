package com.baidu.live.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.bg;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private static volatile g bju;
    private bg aQL;
    private SparseArray<String> bjv = new SparseArray<>();
    private SparseArray<String> bjw = new SparseArray<>();
    private SparseArray<String> bjx = new SparseArray<>();
    private SparseArray<String> bjy = new SparseArray<>();
    private JSONObject bjz;

    public void H(JSONObject jSONObject) {
        this.bjz = jSONObject;
    }

    private g() {
    }

    public static g LZ() {
        if (bju == null) {
            synchronized (g.class) {
                if (bju == null) {
                    bju = new g();
                }
            }
        }
        return bju;
    }

    public String Ma() {
        if (Mc() || this.aQL.aQb == null) {
            return null;
        }
        return this.aQL.aQb;
    }

    public String eT(int i) {
        String str = this.bjv.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Mc() || this.aQL.aQf == null) {
                return null;
            }
            String optString = this.aQL.aQf.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bjv.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eU(int i) {
        String str = this.bjw.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Mc() || this.aQL.aQd == null) {
                return null;
            }
            String optString = this.aQL.aQd.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bjw.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eV(int i) {
        String str = this.bjx.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Mc() || this.aQL.aQe == null) {
                return null;
            }
            String optString = this.aQL.aQe.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bjx.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String eW(int i) {
        String str = this.bjy.get(i);
        if (TextUtils.isEmpty(str)) {
            if (Mc() || this.aQL.aQg == null) {
                return null;
            }
            String optString = this.aQL.aQg.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.bjy.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public bg Mb() {
        if (Mc()) {
            return null;
        }
        return this.aQL;
    }

    private boolean Mc() {
        if (this.aQL == null) {
            this.aQL = com.baidu.live.ae.a.RB().bxq.aQL;
            if (this.aQL == null) {
                return true;
            }
        }
        return false;
    }

    public int hU(String str) {
        if (this.bjz == null) {
            return -1;
        }
        return this.bjz.optInt(str);
    }
}
