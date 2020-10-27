package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String ddv = "NA";
    private RecordType ddw = RecordType.KEEP;
    private boolean ddx = false;

    /* loaded from: classes10.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent bC(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long aBk() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent qM(String str) {
        this.ddv = str;
        return this;
    }

    public String aBl() {
        return this.ddv;
    }

    public UbcFlowEvent fJ(boolean z) {
        this.ddx = z;
        return this;
    }

    public boolean aBm() {
        return this.ddx;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.ddw = recordType;
        return this;
    }

    public RecordType aBn() {
        return this.ddw;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(aBk());
        objArr[1] = this.id;
        objArr[2] = aBm() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("value", this.mValue);
            jSONObject.put("ts", this.mTime);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e);
            }
        }
        return jSONObject;
    }
}
