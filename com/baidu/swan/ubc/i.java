package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class i {
    private String Zt;
    private String duJ;
    private int duK;
    private JSONObject duL;
    private String duM;
    private boolean duN;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.duN = false;
        this.Zt = "";
        this.mId = str;
        this.duJ = str;
        this.duK = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.duL = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.duN = false;
        this.Zt = "";
        this.mId = str;
        this.duJ = str;
        this.duK = -1;
        this.duL = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.duN = false;
        this.Zt = "";
        this.mId = str2;
        this.duJ = str;
        this.duK = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.duL = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.duN = false;
        this.Zt = "";
        this.mId = str2;
        this.duJ = str;
        this.duK = i;
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
                this.duL = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String aJy() {
        return this.duJ;
    }

    public int aJz() {
        return this.duK;
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

    public String aJA() {
        return this.duM;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aJB() {
        return this.duL;
    }

    public String getFileName() {
        return this.Zt;
    }

    public String aJC() {
        return this.duL != null ? this.duL.optString("bizId") : "";
    }

    public void gs(boolean z) {
        this.duN = z;
    }

    public boolean aJw() {
        return this.duN;
    }

    public void aJD() {
        if (this.mId != null && this.mId.equals(this.duJ) && d.aJj().tN(this.mId)) {
            this.duM = e.aJn().alX();
        }
    }
}
