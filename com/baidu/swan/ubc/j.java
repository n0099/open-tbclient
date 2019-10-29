package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private long CJ;
    private boolean bPA = false;
    private JSONArray bPD;
    private int bPx;
    private JSONObject bPy;
    private String bPz;
    private long baF;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public j() {
    }

    public j(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bPx = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int acJ() {
        return this.bPx;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject acL() {
        return this.bPy;
    }

    public long acP() {
        return this.CJ;
    }

    public long getEndTime() {
        return this.baF;
    }

    public String acQ() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String acK() {
        return this.bPz;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void gY(int i) {
        this.bPx = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void aB(long j) {
        this.CJ = j;
    }

    public void setEndTime(long j) {
        this.baF = j;
    }

    public void lz(String str) {
        this.mState = str;
    }

    public void lA(String str) {
        this.bPz = str;
    }

    public void acN() {
        if (d.acv().ls(this.mId)) {
            this.bPz = s.adh().Nc();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void dI(boolean z) {
        this.bPA = z;
    }

    public boolean acG() {
        return this.bPA;
    }

    public void lB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bPD = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray acR() {
        return this.bPD;
    }
}
