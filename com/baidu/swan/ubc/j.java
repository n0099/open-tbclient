package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j {
    private long YE;
    private int ded;
    private JSONObject dee;
    private String def;
    private boolean deg = false;
    private JSONArray dei;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private boolean mIsSampled;
    private int mOption;
    private String mState;

    public j() {
    }

    public j(String str, int i, String str2, int i2, boolean z) {
        this.mId = str;
        this.ded = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int aDJ() {
        return this.ded;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject aDL() {
        return this.dee;
    }

    public long aDQ() {
        return this.YE;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aDR() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String aDK() {
        return this.def;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void jf(int i) {
        this.ded = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void bR(long j) {
        this.YE = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void sj(String str) {
        this.mState = str;
    }

    public void sk(String str) {
        this.def = str;
    }

    public void aDN() {
        if (d.aDw().sc(this.mId)) {
            this.def = s.aEh().ahx();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void gc(boolean z) {
        this.deg = z;
    }

    public boolean aDH() {
        return this.deg;
    }

    public void sl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dei = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray aDS() {
        return this.dei;
    }
}
