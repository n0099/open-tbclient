package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class k {
    private long aat;
    private int dLQ;
    private JSONObject dLR;
    private String dLS;
    private boolean dLT = false;
    private JSONArray dLV;
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
        this.dLQ = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int aWD() {
        return this.dLQ;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject aWF() {
        return this.dLR;
    }

    public long aWK() {
        return this.aat;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aWL() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String aWE() {
        return this.dLS;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void mv(int i) {
        this.dLQ = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void cr(long j) {
        this.aat = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void xF(String str) {
        this.mState = str;
    }

    public void xG(String str) {
        this.dLS = str;
    }

    public void aWH() {
        if (d.aWn().xv(this.mId)) {
            this.dLS = e.aWr().avU();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void hg(boolean z) {
        this.dLT = z;
    }

    public boolean aWA() {
        return this.dLT;
    }

    public void xH(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dLV = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray aWM() {
        return this.dLV;
    }
}
