package com.baidu.swan.apps.performance;

import android.util.Log;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String cyW = "NA";
    private RecordType cyX = RecordType.KEEP;
    private boolean cyY = false;

    /* loaded from: classes7.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent bm(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long aob() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent np(String str) {
        this.cyW = str;
        return this;
    }

    public String aoc() {
        return this.cyW;
    }

    public UbcFlowEvent eI(boolean z) {
        this.cyY = z;
        return this;
    }

    public boolean aod() {
        return this.cyY;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.cyX = recordType;
        return this;
    }

    public RecordType aoe() {
        return this.cyX;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(aob());
        objArr[1] = this.id;
        objArr[2] = aod() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("value", this.mValue);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.mTime);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e);
            }
        }
        return jSONObject;
    }
}
