package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private long Vm;
    private long aEo;
    private int bpm;
    private JSONObject bpn;
    private String bpo;
    private boolean bpp = false;
    private JSONArray bpr;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public j() {
    }

    public j(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bpm = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int Td() {
        return this.bpm;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject Tf() {
        return this.bpn;
    }

    public long Ti() {
        return this.Vm;
    }

    public long getEndTime() {
        return this.aEo;
    }

    public String getState() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String Te() {
        return this.bpo;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void fq(int i) {
        this.bpm = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void X(long j) {
        this.Vm = j;
    }

    public void setEndTime(long j) {
        this.aEo = j;
    }

    public void jO(String str) {
        this.mState = str;
    }

    public void jP(String str) {
        this.bpo = str;
    }

    public void Th() {
        if (d.SW().jI(this.mId)) {
            this.bpo = r.Ts().Fp();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void cV(boolean z) {
        this.bpp = z;
    }

    public boolean Ta() {
        return this.bpp;
    }

    public void jQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bpr = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray Tj() {
        return this.bpr;
    }
}
