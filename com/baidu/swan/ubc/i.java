package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {
    private long Vo;
    private long aEt;
    private int bpr;
    private JSONObject bps;
    private String bpt;
    private boolean bpu = false;
    private JSONArray bpw;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public i() {
    }

    public i(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bpr = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int Tb() {
        return this.bpr;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject Td() {
        return this.bps;
    }

    public long Tg() {
        return this.Vo;
    }

    public long getEndTime() {
        return this.aEt;
    }

    public String getState() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String Tc() {
        return this.bpt;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void fp(int i) {
        this.bpr = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void X(long j) {
        this.Vo = j;
    }

    public void setEndTime(long j) {
        this.aEt = j;
    }

    public void jP(String str) {
        this.mState = str;
    }

    public void jQ(String str) {
        this.bpt = str;
    }

    public void Tf() {
        if (d.SU().jJ(this.mId)) {
            this.bpt = q.Tq().Fn();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void cV(boolean z) {
        this.bpu = z;
    }

    public boolean SY() {
        return this.bpu;
    }

    public void jR(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bpw = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray Th() {
        return this.bpw;
    }
}
