package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class k {
    private long acA;
    private int eBl;
    private JSONObject eBm;
    private String eBn;
    private boolean eBo = false;
    private JSONArray eBq;
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
        this.eBl = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int biz() {
        return this.eBl;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject biB() {
        return this.eBm;
    }

    public long biG() {
        return this.acA;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String biH() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String biA() {
        return this.eBn;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void nQ(int i) {
        this.eBl = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void dw(long j) {
        this.acA = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void zz(String str) {
        this.mState = str;
    }

    public void zA(String str) {
        this.eBn = str;
    }

    public void biD() {
        if (d.bij().zp(this.mId)) {
            this.eBn = e.bin().aGU();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void iL(boolean z) {
        this.eBo = z;
    }

    public boolean biw() {
        return this.eBo;
    }

    public void zB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.eBq = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray biI() {
        return this.eBq;
    }
}
