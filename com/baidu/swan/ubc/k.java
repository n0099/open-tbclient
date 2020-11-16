package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class k {
    private long aaP;
    private String ekA;
    private boolean ekB = false;
    private JSONArray ekD;
    private int eky;
    private JSONObject ekz;
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
        this.eky = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int bcX() {
        return this.eky;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject bcZ() {
        return this.ekz;
    }

    public long bde() {
        return this.aaP;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bdf() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String bcY() {
        return this.ekA;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void nj(int i) {
        this.eky = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void cX(long j) {
        this.aaP = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void yT(String str) {
        this.mState = str;
    }

    public void yU(String str) {
        this.ekA = str;
    }

    public void bdb() {
        if (d.bcH().yJ(this.mId)) {
            this.ekA = e.bcL().aCr();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void ib(boolean z) {
        this.ekB = z;
    }

    public boolean bcU() {
        return this.ekB;
    }

    public void yV(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.ekD = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bdg() {
        return this.ekD;
    }
}
