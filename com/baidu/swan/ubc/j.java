package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j {
    private long Fp;
    private int cEY;
    private JSONObject cEZ;
    private String cFa;
    private boolean cFb = false;
    private JSONArray cFd;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private boolean mIsSampled;
    private int mOption;
    private String mState;

    public j() {
    }

    public j(String str, int i, String str2, int i2, boolean z) {
        this.mId = str;
        this.cEY = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int avy() {
        return this.cEY;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject avA() {
        return this.cEZ;
    }

    public long avF() {
        return this.Fp;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String avG() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String avz() {
        return this.cFa;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void iY(int i) {
        this.cEY = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void bm(long j) {
        this.Fp = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void qW(String str) {
        this.mState = str;
    }

    public void qX(String str) {
        this.cFa = str;
    }

    public void avC() {
        if (d.avl().qP(this.mId)) {
            this.cFa = s.avW().Zt();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void ff(boolean z) {
        this.cFb = z;
    }

    public boolean avw() {
        return this.cFb;
    }

    public void qY(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cFd = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray avH() {
        return this.cFd;
    }

    public boolean avE() {
        return this.mIsSampled;
    }
}
