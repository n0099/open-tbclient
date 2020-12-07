package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String doJ = "NA";
    private RecordType doK = RecordType.KEEP;
    private boolean doL = false;

    /* loaded from: classes25.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent cx(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long aGk() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent rB(String str) {
        this.doJ = str;
        return this;
    }

    public String aGl() {
        return this.doJ;
    }

    public UbcFlowEvent gk(boolean z) {
        this.doL = z;
        return this;
    }

    public boolean aGm() {
        return this.doL;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.doK = recordType;
        return this;
    }

    public RecordType aGn() {
        return this.doK;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(aGk());
        objArr[1] = this.id;
        objArr[2] = aGm() ? "(justLocalRecord)" : "";
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
