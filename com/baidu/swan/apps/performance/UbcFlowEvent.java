package com.baidu.swan.apps.performance;

import android.util.Log;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String cGO = "NA";
    private RecordType cGP = RecordType.KEEP;
    private boolean cGQ = false;

    /* loaded from: classes8.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent br(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long avW() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent pn(String str) {
        this.cGO = str;
        return this;
    }

    public String avX() {
        return this.cGO;
    }

    public UbcFlowEvent fb(boolean z) {
        this.cGQ = z;
        return this;
    }

    public boolean avY() {
        return this.cGQ;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.cGP = recordType;
        return this;
    }

    public RecordType avZ() {
        return this.cGP;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(avW());
        objArr[1] = this.id;
        objArr[2] = avY() ? "(justLocalRecord)" : "";
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
