package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h {
    private String Vj;
    private String aDy;
    private int bpr;
    private JSONObject bps;
    private String bpt;
    private boolean bpu;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public h(String str, String str2, int i) {
        this.mContent = "";
        this.bpu = false;
        this.Vj = "";
        this.mId = str;
        this.aDy = str;
        this.bpr = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bps = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.bpu = false;
        this.Vj = "";
        this.mId = str;
        this.aDy = str;
        this.bpr = -1;
        this.bps = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public h(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.bpu = false;
        this.Vj = "";
        this.mId = str2;
        this.aDy = str;
        this.bpr = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bps = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.bpu = false;
        this.Vj = "";
        this.mId = str2;
        this.aDy = str;
        this.bpr = i;
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
                this.bps = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String Ta() {
        return this.aDy;
    }

    public int Tb() {
        return this.bpr;
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
        return this.bpt;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject Td() {
        return this.bps;
    }

    public String getFileName() {
        return this.Vj;
    }

    public String Te() {
        return this.bps != null ? this.bps.optString("bizId") : "";
    }

    public void cV(boolean z) {
        this.bpu = z;
    }

    public boolean SY() {
        return this.bpu;
    }

    public void Tf() {
        if (this.mId != null && this.mId.equals(this.aDy) && d.SU().jJ(this.mId)) {
            this.bpt = q.Tq().Fn();
        }
    }
}
