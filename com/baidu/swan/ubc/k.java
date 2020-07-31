package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class k {
    private long Zt;
    private JSONObject dAA;
    private String dAB;
    private boolean dAC = false;
    private JSONArray dAE;
    private int dAz;
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
        this.dAz = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int aNr() {
        return this.dAz;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject aNt() {
        return this.dAA;
    }

    public long aNy() {
        return this.Zt;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aNz() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String aNs() {
        return this.dAB;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void ke(int i) {
        this.dAz = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void cg(long j) {
        this.Zt = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void va(String str) {
        this.mState = str;
    }

    public void vb(String str) {
        this.dAB = str;
    }

    public void aNv() {
        if (d.aNb().uQ(this.mId)) {
            this.dAB = e.aNf().anq();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void gN(boolean z) {
        this.dAC = z;
    }

    public boolean aNo() {
        return this.dAC;
    }

    public void vc(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dAE = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray aNA() {
        return this.dAE;
    }
}
