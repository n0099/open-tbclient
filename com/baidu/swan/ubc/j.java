package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class j {
    private long ER;
    private long bDa;
    private int cAC;
    private JSONObject cAD;
    private String cAE;
    private boolean cAF = false;
    private JSONArray cAH;
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
        this.cAC = i;
        this.mContent = str2;
        this.mOption = i2;
        this.mIsSampled = z;
    }

    public String getId() {
        return this.mId;
    }

    public int asM() {
        return this.cAC;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject asO() {
        return this.cAD;
    }

    public long asT() {
        return this.ER;
    }

    public long getEndTime() {
        return this.bDa;
    }

    public String asU() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String asN() {
        return this.cAE;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void iH(int i) {
        this.cAC = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void bf(long j) {
        this.ER = j;
    }

    public void setEndTime(long j) {
        this.bDa = j;
    }

    public void qF(String str) {
        this.mState = str;
    }

    public void qG(String str) {
        this.cAE = str;
    }

    public void asQ() {
        if (d.asz().qy(this.mId)) {
            this.cAE = s.atk().WD();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void eS(boolean z) {
        this.cAF = z;
    }

    public boolean asK() {
        return this.cAF;
    }

    public void qH(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cAH = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray asV() {
        return this.cAH;
    }

    public boolean asS() {
        return this.mIsSampled;
    }
}
