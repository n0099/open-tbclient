package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class i {
    private String aao;
    private String dLP;
    private int dLQ;
    private JSONObject dLR;
    private String dLS;
    private boolean dLT;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.dLT = false;
        this.aao = "";
        this.mId = str;
        this.dLP = str;
        this.dLQ = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dLR = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.dLT = false;
        this.aao = "";
        this.mId = str;
        this.dLP = str;
        this.dLQ = -1;
        this.dLR = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.dLT = false;
        this.aao = "";
        this.mId = str2;
        this.dLP = str;
        this.dLQ = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dLR = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.dLT = false;
        this.aao = "";
        this.mId = str2;
        this.dLP = str;
        this.dLQ = i;
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
                this.dLR = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String aWC() {
        return this.dLP;
    }

    public int aWD() {
        return this.dLQ;
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

    public String aWE() {
        return this.dLS;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aWF() {
        return this.dLR;
    }

    public String getFileName() {
        return this.aao;
    }

    public String aWG() {
        return this.dLR != null ? this.dLR.optString("bizId") : "";
    }

    public void hg(boolean z) {
        this.dLT = z;
    }

    public boolean aWA() {
        return this.dLT;
    }

    public void aWH() {
        if (this.mId != null && this.mId.equals(this.dLP) && d.aWn().xv(this.mId)) {
            this.dLS = e.aWr().avU();
        }
    }
}
