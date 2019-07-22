package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private long Ts;
    private long aGT;
    private int bws;
    private JSONObject bwt;
    private String bwu;
    private boolean bwv = false;
    private JSONArray bwy;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public j() {
    }

    public j(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bws = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int XQ() {
        return this.bws;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject XS() {
        return this.bwt;
    }

    public long getBeginTime() {
        return this.Ts;
    }

    public long getEndTime() {
        return this.aGT;
    }

    public String XW() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String XR() {
        return this.bwu;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void gc(int i) {
        this.bws = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void ai(long j) {
        this.Ts = j;
    }

    public void setEndTime(long j) {
        this.aGT = j;
    }

    public void kV(String str) {
        this.mState = str;
    }

    public void kW(String str) {
        this.bwu = str;
    }

    public void XU() {
        if (d.XC().kO(this.mId)) {
            this.bwu = s.Yn().Ie();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void dr(boolean z) {
        this.bwv = z;
    }

    public boolean XN() {
        return this.bwv;
    }

    public void kX(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bwy = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray XX() {
        return this.bwy;
    }
}
