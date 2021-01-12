package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i {
    private String acr;
    private String ewv;
    private int eww;
    private JSONObject ewx;
    private String ewy;
    private boolean ewz;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.ewz = false;
        this.acr = "";
        this.mId = str;
        this.ewv = str;
        this.eww = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.ewx = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.ewz = false;
        this.acr = "";
        this.mId = str;
        this.ewv = str;
        this.eww = -1;
        this.ewx = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.ewz = false;
        this.acr = "";
        this.mId = str2;
        this.ewv = str;
        this.eww = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.ewx = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.ewz = false;
        this.acr = "";
        this.mId = str2;
        this.ewv = str;
        this.eww = i;
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
                this.ewx = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String beF() {
        return this.ewv;
    }

    public int beG() {
        return this.eww;
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

    public String beH() {
        return this.ewy;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject beI() {
        return this.ewx;
    }

    public String getFileName() {
        return this.acr;
    }

    public String beJ() {
        return this.ewx != null ? this.ewx.optString("bizId") : "";
    }

    public void iH(boolean z) {
        this.ewz = z;
    }

    public boolean beD() {
        return this.ewz;
    }

    public void beK() {
        if (this.mId != null && this.mId.equals(this.ewv) && d.beq().ye(this.mId)) {
            this.ewy = e.beu().aDb();
        }
    }
}
