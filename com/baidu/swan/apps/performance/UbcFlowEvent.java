package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.tieba.qr1;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UbcFlowEvent {
    public static final boolean g = qr1.a;
    public final String a;
    public long b = System.currentTimeMillis();
    public String c = "";
    public String d = "NA";
    public RecordType e = RecordType.KEEP;
    public boolean f = false;

    /* loaded from: classes4.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public boolean b() {
        return this.f;
    }

    public RecordType c() {
        return this.e;
    }

    public String f() {
        return this.d;
    }

    public long g() {
        return this.b;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.a);
            jSONObject.put("value", this.c);
            jSONObject.put("ts", this.b);
        } catch (JSONException e) {
            if (g) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e);
            }
        }
        return jSONObject;
    }

    public String j() {
        return this.c;
    }

    public UbcFlowEvent(String str) {
        this.a = str;
    }

    public UbcFlowEvent a(boolean z) {
        this.f = z;
        return this;
    }

    public UbcFlowEvent d(RecordType recordType) {
        this.e = recordType;
        return this;
    }

    public UbcFlowEvent e(String str) {
        this.d = str;
        return this;
    }

    public UbcFlowEvent h(long j) {
        if (j < 0) {
            j = 0;
        }
        this.b = j;
        return this;
    }

    public String toString() {
        String str;
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(g());
        objArr[1] = this.a;
        if (b()) {
            str = "(justLocalRecord)";
        } else {
            str = "";
        }
        objArr[2] = str;
        objArr[3] = this.e.name();
        return String.format(locale, "Event at %d id = %s %s %s", objArr);
    }
}
