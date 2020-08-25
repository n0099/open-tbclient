package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class i {
    private String ZT;
    private String dJH;
    private int dJI;
    private JSONObject dJJ;
    private String dJK;
    private boolean dJL;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.dJL = false;
        this.ZT = "";
        this.mId = str;
        this.dJH = str;
        this.dJI = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dJJ = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.dJL = false;
        this.ZT = "";
        this.mId = str;
        this.dJH = str;
        this.dJI = -1;
        this.dJJ = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.dJL = false;
        this.ZT = "";
        this.mId = str2;
        this.dJH = str;
        this.dJI = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dJJ = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.dJL = false;
        this.ZT = "";
        this.mId = str2;
        this.dJH = str;
        this.dJI = i;
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
                this.dJJ = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String aVQ() {
        return this.dJH;
    }

    public int aVR() {
        return this.dJI;
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

    public String aVS() {
        return this.dJK;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aVT() {
        return this.dJJ;
    }

    public String getFileName() {
        return this.ZT;
    }

    public String aVU() {
        return this.dJJ != null ? this.dJJ.optString("bizId") : "";
    }

    public void hh(boolean z) {
        this.dJL = z;
    }

    public boolean aVO() {
        return this.dJL;
    }

    public void aVV() {
        if (this.mId != null && this.mId.equals(this.dJH) && d.aVB().xb(this.mId)) {
            this.dJK = e.aVF().avl();
        }
    }
}
