package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class k {
    private long aaK;
    private int ego;
    private JSONObject egp;
    private String egq;
    private boolean egr = false;
    private JSONArray egt;
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
        this.ego = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int bbe() {
        return this.ego;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject bbg() {
        return this.egp;
    }

    public long bbl() {
        return this.aaK;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bbm() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String bbf() {
        return this.egq;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void nd(int i) {
        this.ego = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void cB(long j) {
        this.aaK = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void yK(String str) {
        this.mState = str;
    }

    public void yL(String str) {
        this.egq = str;
    }

    public void bbi() {
        if (d.baO().yA(this.mId)) {
            this.egq = e.baS().aAz();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void hP(boolean z) {
        this.egr = z;
    }

    public boolean bbb() {
        return this.egr;
    }

    public void yM(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.egt = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bbn() {
        return this.egt;
    }
}
