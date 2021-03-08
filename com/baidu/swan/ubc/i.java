package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class i {
    private String adH;
    private String eAf;
    private int eAg;
    private JSONObject eAh;
    private String eAi;
    private boolean eAj;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.eAj = false;
        this.adH = "";
        this.mId = str;
        this.eAf = str;
        this.eAg = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.eAh = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.eAj = false;
        this.adH = "";
        this.mId = str;
        this.eAf = str;
        this.eAg = -1;
        this.eAh = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.eAj = false;
        this.adH = "";
        this.mId = str2;
        this.eAf = str;
        this.eAg = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.eAh = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.eAj = false;
        this.adH = "";
        this.mId = str2;
        this.eAf = str;
        this.eAg = i;
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
                this.eAh = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String beU() {
        return this.eAf;
    }

    public int beV() {
        return this.eAg;
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

    public String beW() {
        return this.eAi;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject beX() {
        return this.eAh;
    }

    public String getFileName() {
        return this.adH;
    }

    public String beY() {
        return this.eAh != null ? this.eAh.optString("bizId") : "";
    }

    public void iJ(boolean z) {
        this.eAj = z;
    }

    public boolean beS() {
        return this.eAj;
    }

    public void beZ() {
        if (this.mId != null && this.mId.equals(this.eAf) && d.beF().yE(this.mId)) {
            this.eAi = e.beJ().aDA();
        }
    }
}
