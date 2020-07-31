package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class i {
    private String Zo;
    private JSONObject dAA;
    private String dAB;
    private boolean dAC;
    private String dAy;
    private int dAz;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.dAC = false;
        this.Zo = "";
        this.mId = str;
        this.dAy = str;
        this.dAz = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dAA = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.dAC = false;
        this.Zo = "";
        this.mId = str;
        this.dAy = str;
        this.dAz = -1;
        this.dAA = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.dAC = false;
        this.Zo = "";
        this.mId = str2;
        this.dAy = str;
        this.dAz = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dAA = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.dAC = false;
        this.Zo = "";
        this.mId = str2;
        this.dAy = str;
        this.dAz = i;
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
                this.dAA = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String aNq() {
        return this.dAy;
    }

    public int aNr() {
        return this.dAz;
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

    public String aNs() {
        return this.dAB;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aNt() {
        return this.dAA;
    }

    public String getFileName() {
        return this.Zo;
    }

    public String aNu() {
        return this.dAA != null ? this.dAA.optString("bizId") : "";
    }

    public void gN(boolean z) {
        this.dAC = z;
    }

    public boolean aNo() {
        return this.dAC;
    }

    public void aNv() {
        if (this.mId != null && this.mId.equals(this.dAy) && d.aNb().uQ(this.mId)) {
            this.dAB = e.aNf().anq();
        }
    }
}
