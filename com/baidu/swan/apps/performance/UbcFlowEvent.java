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
    private String djr = "NA";
    private RecordType djs = RecordType.KEEP;
    private boolean djt = false;

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

    public UbcFlowEvent bY(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long aDK() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent ra(String str) {
        this.djr = str;
        return this;
    }

    public String aDL() {
        return this.djr;
    }

    public UbcFlowEvent fS(boolean z) {
        this.djt = z;
        return this;
    }

    public boolean aDM() {
        return this.djt;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.djs = recordType;
        return this;
    }

    public RecordType aDN() {
        return this.djs;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(aDK());
        objArr[1] = this.id;
        objArr[2] = aDM() ? "(justLocalRecord)" : "";
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
