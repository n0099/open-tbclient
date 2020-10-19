package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class i {
    private String aaE;
    private String dXQ;
    private int dXR;
    private JSONObject dXS;
    private String dXT;
    private boolean dXU;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.dXU = false;
        this.aaE = "";
        this.mId = str;
        this.dXQ = str;
        this.dXR = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dXS = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.dXU = false;
        this.aaE = "";
        this.mId = str;
        this.dXQ = str;
        this.dXR = -1;
        this.dXS = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.dXU = false;
        this.aaE = "";
        this.mId = str2;
        this.dXQ = str;
        this.dXR = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dXS = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.dXU = false;
        this.aaE = "";
        this.mId = str2;
        this.dXQ = str;
        this.dXR = i;
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
                this.dXS = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String aZk() {
        return this.dXQ;
    }

    public int aZl() {
        return this.dXR;
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

    public String aZm() {
        return this.dXT;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aZn() {
        return this.dXS;
    }

    public String getFileName() {
        return this.aaE;
    }

    public String aZo() {
        return this.dXS != null ? this.dXS.optString("bizId") : "";
    }

    public void hC(boolean z) {
        this.dXU = z;
    }

    public boolean aZi() {
        return this.dXU;
    }

    public void aZp() {
        if (this.mId != null && this.mId.equals(this.dXQ) && d.aYV().yh(this.mId)) {
            this.dXT = e.aYZ().ayF();
        }
    }
}
