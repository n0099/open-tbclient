package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class h {
    private String EL;
    private String bCy;
    private int cAC;
    private JSONObject cAD;
    private String cAE;
    private boolean cAF;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public h(String str, String str2, int i) {
        this.mContent = "";
        this.cAF = false;
        this.EL = "";
        this.mId = str;
        this.bCy = str;
        this.cAC = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.cAD = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.cAF = false;
        this.EL = "";
        this.mId = str;
        this.bCy = str;
        this.cAC = -1;
        this.cAD = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public h(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.cAF = false;
        this.EL = "";
        this.mId = str2;
        this.bCy = str;
        this.cAC = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.cAD = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.cAF = false;
        this.EL = "";
        this.mId = str2;
        this.bCy = str;
        this.cAC = i;
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
                this.cAD = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String WL() {
        return this.bCy;
    }

    public int asM() {
        return this.cAC;
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

    public String asN() {
        return this.cAE;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject asO() {
        return this.cAD;
    }

    public String getFileName() {
        return this.EL;
    }

    public String asP() {
        return this.cAD != null ? this.cAD.optString("bizId") : "";
    }

    public void eS(boolean z) {
        this.cAF = z;
    }

    public boolean asK() {
        return this.cAF;
    }

    public void asQ() {
        if (this.mId != null && this.mId.equals(this.bCy) && d.asz().qy(this.mId)) {
            this.cAE = s.atk().WD();
        }
    }
}
