package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private long Ta;
    private long aGl;
    private int bvC;
    private JSONObject bvD;
    private String bvE;
    private boolean bvF = false;
    private JSONArray bvI;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public j() {
    }

    public j(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bvC = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int WV() {
        return this.bvC;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject WX() {
        return this.bvD;
    }

    public long Xb() {
        return this.Ta;
    }

    public long getEndTime() {
        return this.aGl;
    }

    public String getState() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String WW() {
        return this.bvE;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void fY(int i) {
        this.bvC = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void ah(long j) {
        this.Ta = j;
    }

    public void setEndTime(long j) {
        this.aGl = j;
    }

    public void kN(String str) {
        this.mState = str;
    }

    public void kO(String str) {
        this.bvE = str;
    }

    public void WZ() {
        if (d.WI().kG(this.mId)) {
            this.bvE = s.Xr().Hs();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void dm(boolean z) {
        this.bvF = z;
    }

    public boolean WS() {
        return this.bvF;
    }

    public void kP(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bvI = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray Xc() {
        return this.bvI;
    }
}
