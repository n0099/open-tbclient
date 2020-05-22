package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class i {
    private String YO;
    private String dpX;
    private int dpY;
    private JSONObject dpZ;
    private String dqa;
    private boolean dqb;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.dqb = false;
        this.YO = "";
        this.mId = str;
        this.dpX = str;
        this.dpY = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dpZ = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.dqb = false;
        this.YO = "";
        this.mId = str;
        this.dpX = str;
        this.dpY = -1;
        this.dpZ = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.dqb = false;
        this.YO = "";
        this.mId = str2;
        this.dpX = str;
        this.dpY = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.dpZ = new JSONObject(this.mContent);
        } catch (JSONException e) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.dqb = false;
        this.YO = "";
        this.mId = str2;
        this.dpX = str;
        this.dpY = i;
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
                this.dpZ = new JSONObject(this.mContent);
            } catch (JSONException e) {
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String aIs() {
        return this.dpX;
    }

    public int aIt() {
        return this.dpY;
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

    public String aIu() {
        return this.dqa;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aIv() {
        return this.dpZ;
    }

    public String getFileName() {
        return this.YO;
    }

    public String aIw() {
        return this.dpZ != null ? this.dpZ.optString("bizId") : "";
    }

    public void gn(boolean z) {
        this.dqb = z;
    }

    public boolean aIq() {
        return this.dqb;
    }

    public void aIx() {
        if (this.mId != null && this.mId.equals(this.dpX) && d.aId().tF(this.mId)) {
            this.dqa = e.aIh().akR();
        }
    }
}
