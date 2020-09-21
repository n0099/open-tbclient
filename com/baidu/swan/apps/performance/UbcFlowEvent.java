package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String cIS = "NA";
    private RecordType cIT = RecordType.KEEP;
    private boolean cIU = false;

    /* loaded from: classes3.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent bs(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long awF() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent pH(String str) {
        this.cIS = str;
        return this;
    }

    public String awG() {
        return this.cIS;
    }

    public UbcFlowEvent fa(boolean z) {
        this.cIU = z;
        return this;
    }

    public boolean awH() {
        return this.cIU;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.cIT = recordType;
        return this;
    }

    public RecordType awI() {
        return this.cIT;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(awF());
        objArr[1] = this.id;
        objArr[2] = awH() ? "(justLocalRecord)" : "";
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
