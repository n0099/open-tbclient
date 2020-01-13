package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class j {
    private long EW;
    private long bDL;
    private int cAN;
    private JSONObject cAO;
    private String cAP;
    private boolean cAQ = false;
    private JSONArray cAS;
    private String mCategory;
    private String mContent;
    private String mId;
    private boolean mIsSampled;
    private int mOption;
    private String mState;

    public j() {
    }

    public j(String str, int i, String str2, int i2, boolean z) {
        this.mId = str;
        this.cAN = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int atf() {
        return this.cAN;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject ath() {
        return this.cAO;
    }

    public long atm() {
        return this.EW;
    }

    public long getEndTime() {
        return this.bDL;
    }

    public String atn() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String atg() {
        return this.cAP;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void iH(int i) {
        this.cAN = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void bi(long j) {
        this.EW = j;
    }

    public void setEndTime(long j) {
        this.bDL = j;
    }

    public void qI(String str) {
        this.mState = str;
    }

    public void qJ(String str) {
        this.cAP = str;
    }

    public void atj() {
        if (d.asS().qB(this.mId)) {
            this.cAP = s.atD().Xa();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void eX(boolean z) {
        this.cAQ = z;
    }

    public boolean atd() {
        return this.cAQ;
    }

    public void qK(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cAS = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray ato() {
        return this.cAS;
    }

    public boolean atl() {
        return this.mIsSampled;
    }
}
