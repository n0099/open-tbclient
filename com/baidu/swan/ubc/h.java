package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h {
    private String CE;
    private String aZL;
    private boolean bPA;
    private int bPx;
    private JSONObject bPy;
    private String bPz;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public h(String str, String str2, int i) {
        this.mContent = "";
        this.bPA = false;
        this.CE = "";
        this.mId = str;
        this.aZL = str;
        this.bPx = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bPy = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.bPA = false;
        this.CE = "";
        this.mId = str;
        this.aZL = str;
        this.bPx = -1;
        this.bPy = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public h(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.bPA = false;
        this.CE = "";
        this.mId = str2;
        this.aZL = str;
        this.bPx = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bPy = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.bPA = false;
        this.CE = "";
        this.mId = str2;
        this.aZL = str;
        this.bPx = i;
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
                this.bPy = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String acI() {
        return this.aZL;
    }

    public int acJ() {
        return this.bPx;
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

    public String acK() {
        return this.bPz;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject acL() {
        return this.bPy;
    }

    public String getFileName() {
        return this.CE;
    }

    public String acM() {
        return this.bPy != null ? this.bPy.optString("bizId") : "";
    }

    public void dI(boolean z) {
        this.bPA = z;
    }

    public boolean acG() {
        return this.bPA;
    }

    public void acN() {
        if (this.mId != null && this.mId.equals(this.aZL) && d.acv().ls(this.mId)) {
            this.bPz = s.adh().Nc();
        }
    }
}
