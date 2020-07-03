package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class k {
    private long Zy;
    private int duK;
    private JSONObject duL;
    private String duM;
    private boolean duN = false;
    private JSONArray duP;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private boolean mIsSampled;
    private int mOption;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2, boolean z) {
        this.mId = str;
        this.duK = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int aJz() {
        return this.duK;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject aJB() {
        return this.duL;
    }

    public long aJG() {
        return this.Zy;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aJH() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String aJA() {
        return this.duM;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void jL(int i) {
        this.duK = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void bR(long j) {
        this.Zy = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void tX(String str) {
        this.mState = str;
    }

    public void tY(String str) {
        this.duM = str;
    }

    public void aJD() {
        if (d.aJj().tN(this.mId)) {
            this.duM = e.aJn().alX();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void gs(boolean z) {
        this.duN = z;
    }

    public boolean aJw() {
        return this.duN;
    }

    public void tZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.duP = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray aJI() {
        return this.duP;
    }
}
