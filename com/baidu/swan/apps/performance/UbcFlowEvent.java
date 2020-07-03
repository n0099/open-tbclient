package com.baidu.swan.apps.performance;

import android.util.Log;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String cwH = "NA";
    private RecordType cwI = RecordType.KEEP;
    private boolean cwJ = false;

    /* loaded from: classes11.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent bg(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long amH() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent mN(String str) {
        this.cwH = str;
        return this;
    }

    public String amI() {
        return this.cwH;
    }

    public UbcFlowEvent ez(boolean z) {
        this.cwJ = z;
        return this;
    }

    public boolean amJ() {
        return this.cwJ;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.cwI = recordType;
        return this;
    }

    public RecordType amK() {
        return this.cwI;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(amH());
        objArr[1] = this.id;
        objArr[2] = amJ() ? "(justLocalRecord)" : "";
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
