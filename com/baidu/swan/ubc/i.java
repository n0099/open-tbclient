package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class i {
    private String aaF;
    private String eme;
    private int emf;
    private JSONObject emg;
    private String emh;
    private boolean emi;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.emi = false;
        this.aaF = "";
        this.mId = str;
        this.eme = str;
        this.emf = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.emg = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.emi = false;
        this.aaF = "";
        this.mId = str;
        this.eme = str;
        this.emf = -1;
        this.emg = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.emi = false;
        this.aaF = "";
        this.mId = str2;
        this.eme = str;
        this.emf = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.emg = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.emi = false;
        this.aaF = "";
        this.mId = str2;
        this.eme = str;
        this.emf = i;
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
                this.emg = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String bdD() {
        return this.eme;
    }

    public int bdE() {
        return this.emf;
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

    public String bdF() {
        return this.emh;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject bdG() {
        return this.emg;
    }

    public String getFileName() {
        return this.aaF;
    }

    public String bdH() {
        return this.emg != null ? this.emg.optString("bizId") : "";
    }

    public void hY(boolean z) {
        this.emi = z;
    }

    public boolean bdB() {
        return this.emi;
    }

    public void bdI() {
        if (this.mId != null && this.mId.equals(this.eme) && d.bdo().yO(this.mId)) {
            this.emh = e.bds().aCZ();
        }
    }
}
