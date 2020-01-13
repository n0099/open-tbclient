package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class h {
    private String ER;
    private String bDj;
    private int cAN;
    private JSONObject cAO;
    private String cAP;
    private boolean cAQ;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public h(String str, String str2, int i) {
        this.mContent = "";
        this.cAQ = false;
        this.ER = "";
        this.mId = str;
        this.bDj = str;
        this.cAN = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.cAO = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.cAQ = false;
        this.ER = "";
        this.mId = str;
        this.bDj = str;
        this.cAN = -1;
        this.cAO = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public h(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.cAQ = false;
        this.ER = "";
        this.mId = str2;
        this.bDj = str;
        this.cAN = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.cAO = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.cAQ = false;
        this.ER = "";
        this.mId = str2;
        this.bDj = str;
        this.cAN = i;
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
                this.cAO = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String Xi() {
        return this.bDj;
    }

    public int atf() {
        return this.cAN;
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

    public String atg() {
        return this.cAP;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject ath() {
        return this.cAO;
    }

    public String getFileName() {
        return this.ER;
    }

    public String ati() {
        return this.cAO != null ? this.cAO.optString("bizId") : "";
    }

    public void eX(boolean z) {
        this.cAQ = z;
    }

    public boolean atd() {
        return this.cAQ;
    }

    public void atj() {
        if (this.mId != null && this.mId.equals(this.bDj) && d.asS().qB(this.mId)) {
            this.cAP = s.atD().Xa();
        }
    }
}
