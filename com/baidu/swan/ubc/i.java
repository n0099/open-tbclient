package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i {
    private String acu;
    private String eBk;
    private int eBl;
    private JSONObject eBm;
    private String eBn;
    private boolean eBo;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.eBo = false;
        this.acu = "";
        this.mId = str;
        this.eBk = str;
        this.eBl = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.eBm = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.eBo = false;
        this.acu = "";
        this.mId = str;
        this.eBk = str;
        this.eBl = -1;
        this.eBm = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.eBo = false;
        this.acu = "";
        this.mId = str2;
        this.eBk = str;
        this.eBl = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.eBm = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.eBo = false;
        this.acu = "";
        this.mId = str2;
        this.eBk = str;
        this.eBl = i;
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
                this.eBm = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String biz() {
        return this.eBk;
    }

    public int biA() {
        return this.eBl;
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

    public String biB() {
        return this.eBn;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject biC() {
        return this.eBm;
    }

    public String getFileName() {
        return this.acu;
    }

    public String biD() {
        return this.eBm != null ? this.eBm.optString("bizId") : "";
    }

    public void iL(boolean z) {
        this.eBo = z;
    }

    public boolean bix() {
        return this.eBo;
    }

    public void biE() {
        if (this.mId != null && this.mId.equals(this.eBk) && d.bik().zp(this.mId)) {
            this.eBn = e.bio().aGV();
        }
    }
}
