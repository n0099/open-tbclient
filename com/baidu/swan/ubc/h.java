package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class h {
    private String Fk;
    private String bHq;
    private int cEM;
    private JSONObject cEN;
    private String cEO;
    private boolean cEP;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public h(String str, String str2, int i) {
        this.mContent = "";
        this.cEP = false;
        this.Fk = "";
        this.mId = str;
        this.bHq = str;
        this.cEM = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.cEN = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.cEP = false;
        this.Fk = "";
        this.mId = str;
        this.bHq = str;
        this.cEM = -1;
        this.cEN = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public h(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.cEP = false;
        this.Fk = "";
        this.mId = str2;
        this.bHq = str;
        this.cEM = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.cEN = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.cEP = false;
        this.Fk = "";
        this.mId = str2;
        this.bHq = str;
        this.cEM = i;
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
                this.cEN = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String Zy() {
        return this.bHq;
    }

    public int avv() {
        return this.cEM;
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

    public String avw() {
        return this.cEO;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject avx() {
        return this.cEN;
    }

    public String getFileName() {
        return this.Fk;
    }

    public String avy() {
        return this.cEN != null ? this.cEN.optString("bizId") : "";
    }

    public void fe(boolean z) {
        this.cEP = z;
    }

    public boolean avt() {
        return this.cEP;
    }

    public void avz() {
        if (this.mId != null && this.mId.equals(this.bHq) && d.avi().qQ(this.mId)) {
            this.cEO = s.avT().Zq();
        }
    }
}
