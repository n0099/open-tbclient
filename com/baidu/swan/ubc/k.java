package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class k {
    private long adM;
    private int eAg;
    private JSONObject eAh;
    private String eAi;
    private boolean eAj = false;
    private JSONArray eAl;
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
        this.eAg = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int beV() {
        return this.eAg;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject beX() {
        return this.eAh;
    }

    public long bfc() {
        return this.adM;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bfd() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String beW() {
        return this.eAi;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void mo(int i) {
        this.eAg = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void dC(long j) {
        this.adM = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void yO(String str) {
        this.mState = str;
    }

    public void yP(String str) {
        this.eAi = str;
    }

    public void beZ() {
        if (d.beF().yE(this.mId)) {
            this.eAi = e.beJ().aDA();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void iJ(boolean z) {
        this.eAj = z;
    }

    public boolean beS() {
        return this.eAj;
    }

    public void yQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.eAl = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bfe() {
        return this.eAl;
    }
}
