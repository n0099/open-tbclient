package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j {
    private long Fp;
    private int cEN;
    private JSONObject cEO;
    private String cEP;
    private boolean cEQ = false;
    private JSONArray cES;
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
        this.cEN = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int avv() {
        return this.cEN;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject avx() {
        return this.cEO;
    }

    public long avC() {
        return this.Fp;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String avD() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String avw() {
        return this.cEP;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void iY(int i) {
        this.cEN = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void bm(long j) {
        this.Fp = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void qX(String str) {
        this.mState = str;
    }

    public void qY(String str) {
        this.cEP = str;
    }

    public void avz() {
        if (d.avi().qQ(this.mId)) {
            this.cEP = s.avT().Zq();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void fe(boolean z) {
        this.cEQ = z;
    }

    public boolean avt() {
        return this.cEQ;
    }

    public void qZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cES = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray avE() {
        return this.cES;
    }

    public boolean avB() {
        return this.mIsSampled;
    }
}
