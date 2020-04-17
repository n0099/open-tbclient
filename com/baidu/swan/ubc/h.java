package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class h {
    private String Yw;
    private String cgl;
    private int ddY;
    private JSONObject ddZ;
    private String dea;
    private boolean deb;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public h(String str, String str2, int i) {
        this.mContent = "";
        this.deb = false;
        this.Yw = "";
        this.mId = str;
        this.cgl = str;
        this.ddY = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.ddZ = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.deb = false;
        this.Yw = "";
        this.mId = str;
        this.cgl = str;
        this.ddY = -1;
        this.ddZ = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public h(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.deb = false;
        this.Yw = "";
        this.mId = str2;
        this.cgl = str;
        this.ddY = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.ddZ = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public h(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.deb = false;
        this.Yw = "";
        this.mId = str2;
        this.cgl = str;
        this.ddY = i;
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
                this.ddZ = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String ahG() {
        return this.cgl;
    }

    public int aDJ() {
        return this.ddY;
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

    public String aDK() {
        return this.dea;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aDL() {
        return this.ddZ;
    }

    public String getFileName() {
        return this.Yw;
    }

    public String aDM() {
        return this.ddZ != null ? this.ddZ.optString("bizId") : "";
    }

    public void gc(boolean z) {
        this.deb = z;
    }

    public boolean aDH() {
        return this.deb;
    }

    public void aDN() {
        if (this.mId != null && this.mId.equals(this.cgl) && d.aDw().sc(this.mId)) {
            this.dea = s.aEh().ahy();
        }
    }
}
