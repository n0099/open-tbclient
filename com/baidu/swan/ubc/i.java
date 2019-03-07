package com.baidu.swan.ubc;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {
    private static final boolean DEBUG = g.DEBUG;
    private String Vh;
    private String aDt;
    private int bpm;
    private JSONObject bpn;
    private String bpo;
    private boolean bpp;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public i(String str, String str2, int i) {
        this.mContent = "";
        this.bpp = false;
        this.Vh = "";
        this.mId = str;
        this.aDt = str;
        this.bpm = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bpn = new JSONObject(this.mContent);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("EventData", "content is not a JSONObject", e);
            }
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.bpp = false;
        this.Vh = "";
        this.mId = str;
        this.aDt = str;
        this.bpm = -1;
        this.bpn = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.bpp = false;
        this.Vh = "";
        this.mId = str2;
        this.aDt = str;
        this.bpm = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
        try {
            this.bpn = new JSONObject(this.mContent);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("EventData", "content is not a JSONObject", e);
            }
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.bpp = false;
        this.Vh = "";
        this.mId = str2;
        this.aDt = str;
        this.bpm = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            if (j > 0) {
                this.mTime = j;
            } else {
                this.mTime = System.currentTimeMillis();
            }
        }
        if (!TextUtils.isEmpty(this.mContent)) {
            try {
                this.bpn = new JSONObject(this.mContent);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("EventData", "content is not a JSONObject", e);
                }
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String Tc() {
        return this.aDt;
    }

    public int Td() {
        return this.bpm;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTime() {
        return this.mTime;
    }

    public int getOption() {
        return this.mOption;
    }

    public String Te() {
        return this.bpo;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject Tf() {
        return this.bpn;
    }

    public String getFileName() {
        return this.Vh;
    }

    public String Tg() {
        return this.bpn != null ? this.bpn.optString("bizId") : "";
    }

    public void cV(boolean z) {
        this.bpp = z;
    }

    public boolean Ta() {
        return this.bpp;
    }

    public void Th() {
        if (this.mId != null && this.mId.equals(this.aDt) && d.SW().jI(this.mId)) {
            this.bpo = r.Ts().Fp();
        }
    }
}
