package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class k {
    private long abM;
    private int erB;
    private JSONObject erC;
    private String erD;
    private boolean erE = false;
    private JSONArray erG;
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
        this.erB = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int bgc() {
        return this.erB;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject bge() {
        return this.erC;
    }

    public long bgj() {
        return this.abM;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bgk() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String bgd() {
        return this.erD;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void nH(int i) {
        this.erB = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void dw(long j) {
        this.abM = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void zA(String str) {
        this.mState = str;
    }

    public void zB(String str) {
        this.erD = str;
    }

    public void bgg() {
        if (d.bfM().zq(this.mId)) {
            this.erD = e.bfQ().aFA();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void iq(boolean z) {
        this.erE = z;
    }

    public boolean bfZ() {
        return this.erE;
    }

    public void zC(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.erG = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bgl() {
        return this.erG;
    }
}
