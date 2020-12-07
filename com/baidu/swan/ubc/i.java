package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class i {
    private String abH;
    private String erA;
    private int erB;
    private JSONObject erC;
    private String erD;
    private boolean erE;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.erE = false;
        this.abH = "";
        this.mId = str;
        this.erA = str;
        this.erB = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.erC = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.erE = false;
        this.abH = "";
        this.mId = str;
        this.erA = str;
        this.erB = -1;
        this.erC = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.erE = false;
        this.abH = "";
        this.mId = str2;
        this.erA = str;
        this.erB = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.erC = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.erE = false;
        this.abH = "";
        this.mId = str2;
        this.erA = str;
        this.erB = i;
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
                this.erC = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String bgb() {
        return this.erA;
    }

    public int bgc() {
        return this.erB;
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

    public String bgd() {
        return this.erD;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject bge() {
        return this.erC;
    }

    public String getFileName() {
        return this.abH;
    }

    public String bgf() {
        return this.erC != null ? this.erC.optString("bizId") : "";
    }

    public void iq(boolean z) {
        this.erE = z;
    }

    public boolean bfZ() {
        return this.erE;
    }

    public void bgg() {
        if (this.mId != null && this.mId.equals(this.erA) && d.bfM().zq(this.mId)) {
            this.erD = e.bfQ().aFA();
        }
    }
}
