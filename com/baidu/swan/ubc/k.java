package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class k {
    private long acy;
    private JSONArray ewB;
    private int eww;
    private JSONObject ewx;
    private String ewy;
    private boolean ewz = false;
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
        this.eww = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int beG() {
        return this.eww;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject beI() {
        return this.ewx;
    }

    public long beN() {
        return this.acy;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String beO() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String beH() {
        return this.ewy;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void mk(int i) {
        this.eww = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void dw(long j) {
        this.acy = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void yo(String str) {
        this.mState = str;
    }

    public void yp(String str) {
        this.ewy = str;
    }

    public void beK() {
        if (d.beq().ye(this.mId)) {
            this.ewy = e.beu().aDb();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void iH(boolean z) {
        this.ewz = z;
    }

    public boolean beD() {
        return this.ewz;
    }

    public void yq(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.ewB = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray beP() {
        return this.ewB;
    }
}
