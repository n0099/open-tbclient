package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h {
    private String Vi;
    private String aDx;
    private int bpq;
    private JSONObject bpr;
    private String bps;
    private boolean bpt;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public h(String str, String str2, int i) {
        this.mContent = "";
        this.bpt = false;
        this.Vi = "";
        this.mId = str;
        this.aDx = str;
        this.bpq = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bpr = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.bpt = false;
        this.Vi = "";
        this.mId = str;
        this.aDx = str;
        this.bpq = -1;
        this.bpr = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public h(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.bpt = false;
        this.Vi = "";
        this.mId = str2;
        this.aDx = str;
        this.bpq = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bpr = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.bpt = false;
        this.Vi = "";
        this.mId = str2;
        this.aDx = str;
        this.bpq = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            if (j > 0) {
                this.mTime = j;
            } else {
                this.mTime = System.currentTimeMillis();
            }
        }
        if (!TextUtils.isEmpty(this.mContent)) {
            try {
                this.bpr = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String Ta() {
        return this.aDx;
    }

    public int Tb() {
        return this.bpq;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTime() {
        return this.mTime;
    }

    public int getOption() {
        return this.mOption;
    }

    public String Tc() {
        return this.bps;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject Td() {
        return this.bpr;
    }

    public String getFileName() {
        return this.Vi;
    }

    public String Te() {
        return this.bpr != null ? this.bpr.optString("bizId") : "";
    }

    public void cV(boolean z) {
        this.bpt = z;
    }

    public boolean SY() {
        return this.bpt;
    }

    public void Tf() {
        if (this.mId != null && this.mId.equals(this.aDx) && d.SU().jJ(this.mId)) {
            this.bps = q.Tq().Fn();
        }
    }
}
