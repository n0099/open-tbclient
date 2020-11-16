package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class i {
    private String aaK;
    private String ekA;
    private boolean ekB;
    private String ekx;
    private int eky;
    private JSONObject ekz;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.ekB = false;
        this.aaK = "";
        this.mId = str;
        this.ekx = str;
        this.eky = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.ekz = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.ekB = false;
        this.aaK = "";
        this.mId = str;
        this.ekx = str;
        this.eky = -1;
        this.ekz = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.ekB = false;
        this.aaK = "";
        this.mId = str2;
        this.ekx = str;
        this.eky = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.ekz = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.ekB = false;
        this.aaK = "";
        this.mId = str2;
        this.ekx = str;
        this.eky = i;
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
                this.ekz = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String bcW() {
        return this.ekx;
    }

    public int bcX() {
        return this.eky;
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

    public String bcY() {
        return this.ekA;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject bcZ() {
        return this.ekz;
    }

    public String getFileName() {
        return this.aaK;
    }

    public String bda() {
        return this.ekz != null ? this.ekz.optString("bizId") : "";
    }

    public void ib(boolean z) {
        this.ekB = z;
    }

    public boolean bcU() {
        return this.ekB;
    }

    public void bdb() {
        if (this.mId != null && this.mId.equals(this.ekx) && d.bcH().yJ(this.mId)) {
            this.ekA = e.bcL().aCr();
        }
    }
}
