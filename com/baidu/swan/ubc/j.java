package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j {
    private long Fp;
    private int cEL;
    private JSONObject cEM;
    private String cEN;
    private boolean cEO = false;
    private JSONArray cEQ;
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
        this.cEL = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int avt() {
        return this.cEL;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject avv() {
        return this.cEM;
    }

    public long avA() {
        return this.Fp;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String avB() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String avu() {
        return this.cEN;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void iY(int i) {
        this.cEL = i;
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
        this.cEN = str;
    }

    public void avx() {
        if (d.avg().qQ(this.mId)) {
            this.cEN = s.avR().Zo();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void fe(boolean z) {
        this.cEO = z;
    }

    public boolean avr() {
        return this.cEO;
    }

    public void qZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cEQ = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray avC() {
        return this.cEQ;
    }

    public boolean avz() {
        return this.mIsSampled;
    }
}
