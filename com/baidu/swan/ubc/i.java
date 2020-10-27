package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class i {
    private String aaF;
    private String egn;
    private int ego;
    private JSONObject egp;
    private String egq;
    private boolean egr;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.egr = false;
        this.aaF = "";
        this.mId = str;
        this.egn = str;
        this.ego = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.egp = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.egr = false;
        this.aaF = "";
        this.mId = str;
        this.egn = str;
        this.ego = -1;
        this.egp = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.egr = false;
        this.aaF = "";
        this.mId = str2;
        this.egn = str;
        this.ego = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.egp = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.egr = false;
        this.aaF = "";
        this.mId = str2;
        this.egn = str;
        this.ego = i;
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
                this.egp = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String bbd() {
        return this.egn;
    }

    public int bbe() {
        return this.ego;
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

    public String bbf() {
        return this.egq;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject bbg() {
        return this.egp;
    }

    public String getFileName() {
        return this.aaF;
    }

    public String bbh() {
        return this.egp != null ? this.egp.optString("bizId") : "";
    }

    public void hP(boolean z) {
        this.egr = z;
    }

    public boolean bbb() {
        return this.egr;
    }

    public void bbi() {
        if (this.mId != null && this.mId.equals(this.egn) && d.baO().yA(this.mId)) {
            this.egq = e.baS().aAz();
        }
    }
}
