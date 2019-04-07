package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {
    private long Vn;
    private long aEs;
    private int bpq;
    private JSONObject bpr;
    private String bps;
    private boolean bpt = false;
    private JSONArray bpv;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public i() {
    }

    public i(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bpq = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int Tb() {
        return this.bpq;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject Td() {
        return this.bpr;
    }

    public long Tg() {
        return this.Vn;
    }

    public long getEndTime() {
        return this.aEs;
    }

    public String getState() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String Tc() {
        return this.bps;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void fp(int i) {
        this.bpq = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void X(long j) {
        this.Vn = j;
    }

    public void setEndTime(long j) {
        this.aEs = j;
    }

    public void jP(String str) {
        this.mState = str;
    }

    public void jQ(String str) {
        this.bps = str;
    }

    public void Tf() {
        if (d.SU().jJ(this.mId)) {
            this.bps = q.Tq().Fn();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void cV(boolean z) {
        this.bpt = z;
    }

    public boolean SY() {
        return this.bpt;
    }

    public void jR(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bpv = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray Th() {
        return this.bpv;
    }
}
