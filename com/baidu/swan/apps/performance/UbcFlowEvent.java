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
    private String dsG = "NA";
    private RecordType dsH = RecordType.KEEP;
    private boolean dsI = false;

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

    public UbcFlowEvent cE(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long aEi() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent qI(String str) {
        this.dsG = str;
        return this;
    }

    public String aEj() {
        return this.dsG;
    }

    public UbcFlowEvent gr(boolean z) {
        this.dsI = z;
        return this;
    }

    public boolean aEk() {
        return this.dsI;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.dsH = recordType;
        return this;
    }

    public RecordType aEl() {
        return this.dsH;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(aEi());
        objArr[1] = this.id;
        objArr[2] = aEk() ? "(justLocalRecord)" : "";
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
