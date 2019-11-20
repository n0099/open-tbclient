package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h {
    private String Ce;
    private String aZt;
    private int bOG;
    private JSONObject bOH;
    private String bOI;
    private boolean bOJ;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public h(String str, String str2, int i) {
        this.mContent = "";
        this.bOJ = false;
        this.Ce = "";
        this.mId = str;
        this.aZt = str;
        this.bOG = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bOH = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.bOJ = false;
        this.Ce = "";
        this.mId = str;
        this.aZt = str;
        this.bOG = -1;
        this.bOH = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public h(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.bOJ = false;
        this.Ce = "";
        this.mId = str2;
        this.aZt = str;
        this.bOG = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bOH = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.bOJ = false;
        this.Ce = "";
        this.mId = str2;
        this.aZt = str;
        this.bOG = i;
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
                this.bOH = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String acG() {
        return this.aZt;
    }

    public int acH() {
        return this.bOG;
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

    public String acI() {
        return this.bOI;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject acJ() {
        return this.bOH;
    }

    public String getFileName() {
        return this.Ce;
    }

    public String acK() {
        return this.bOH != null ? this.bOH.optString("bizId") : "";
    }

    public void dI(boolean z) {
        this.bOJ = z;
    }

    public boolean acE() {
        return this.bOJ;
    }

    public void acL() {
        if (this.mId != null && this.mId.equals(this.aZt) && d.act().ls(this.mId)) {
            this.bOI = s.adf().Nd();
        }
    }
}
