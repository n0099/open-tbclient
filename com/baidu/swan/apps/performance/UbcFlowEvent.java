package com.baidu.swan.apps.performance;

import android.util.Log;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String doS = "NA";
    private RecordType doT = RecordType.KEEP;
    private boolean doU = false;

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

    public UbcFlowEvent cy(long j) {
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

    public UbcFlowEvent qj(String str) {
        this.doS = str;
        return this;
    }

    public String aDL() {
        return this.doS;
    }

    public UbcFlowEvent gp(boolean z) {
        this.doU = z;
        return this;
    }

    public boolean aDM() {
        return this.doU;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.doT = recordType;
        return this;
    }

    public RecordType aDN() {
        return this.doT;
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
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.mTime);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e);
            }
        }
        return jSONObject;
    }
}
