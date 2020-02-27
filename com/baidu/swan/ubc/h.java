package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class h {
    private String Fk;
    private String bHp;
    private int cEL;
    private JSONObject cEM;
    private String cEN;
    private boolean cEO;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public h(String str, String str2, int i) {
        this.mContent = "";
        this.cEO = false;
        this.Fk = "";
        this.mId = str;
        this.bHp = str;
        this.cEL = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.cEM = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.cEO = false;
        this.Fk = "";
        this.mId = str;
        this.bHp = str;
        this.cEL = -1;
        this.cEM = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public h(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.cEO = false;
        this.Fk = "";
        this.mId = str2;
        this.bHp = str;
        this.cEL = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.cEM = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.cEO = false;
        this.Fk = "";
        this.mId = str2;
        this.bHp = str;
        this.cEL = i;
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
                this.cEM = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String Zw() {
        return this.bHp;
    }

    public int avt() {
        return this.cEL;
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

    public String avu() {
        return this.cEN;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject avv() {
        return this.cEM;
    }

    public String getFileName() {
        return this.Fk;
    }

    public String avw() {
        return this.cEM != null ? this.cEM.optString("bizId") : "";
    }

    public void fe(boolean z) {
        this.cEO = z;
    }

    public boolean avr() {
        return this.cEO;
    }

    public void avx() {
        if (this.mId != null && this.mId.equals(this.bHp) && d.avg().qQ(this.mId)) {
            this.cEN = s.avR().Zo();
        }
    }
}
