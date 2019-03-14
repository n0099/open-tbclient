package com.baidu.swan.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {
    private long Vn;
    private long aEp;
    private int bpn;
    private JSONObject bpo;
    private String bpp;
    private boolean bpq = false;
    private JSONArray bps;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public i() {
    }

    public i(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bpn = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int Td() {
        return this.bpn;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject Tf() {
        return this.bpo;
    }

    public long Ti() {
        return this.Vn;
    }

    public long getEndTime() {
        return this.aEp;
    }

    public String getState() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String Te() {
        return this.bpp;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void fq(int i) {
        this.bpn = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void X(long j) {
        this.Vn = j;
    }

    public void setEndTime(long j) {
        this.aEp = j;
    }

    public void jO(String str) {
        this.mState = str;
    }

    public void jP(String str) {
        this.bpp = str;
    }

    public void Th() {
        if (d.SW().jI(this.mId)) {
            this.bpp = q.Ts().Fp();
        }
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void cV(boolean z) {
        this.bpq = z;
    }

    public boolean Ta() {
        return this.bpq;
    }

    public void jQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bps = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray Tj() {
        return this.bps;
    }
}
