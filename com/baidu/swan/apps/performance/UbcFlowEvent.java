package com.baidu.swan.apps.performance;

import android.util.Log;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import d.b.g0.a.k;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcFlowEvent {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f12402g = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public final String f12403a;

    /* renamed from: b  reason: collision with root package name */
    public long f12404b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f12405c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f12406d = "NA";

    /* renamed from: e  reason: collision with root package name */
    public RecordType f12407e = RecordType.KEEP;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12408f = false;

    /* loaded from: classes3.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.f12403a = str;
    }

    public UbcFlowEvent a(boolean z) {
        this.f12408f = z;
        return this;
    }

    public boolean b() {
        return this.f12408f;
    }

    public RecordType c() {
        return this.f12407e;
    }

    public UbcFlowEvent d(RecordType recordType) {
        this.f12407e = recordType;
        return this;
    }

    public UbcFlowEvent e(String str) {
        this.f12406d = str;
        return this;
    }

    public String f() {
        return this.f12406d;
    }

    public long g() {
        return this.f12404b;
    }

    public UbcFlowEvent h(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f12404b = j;
        return this;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f12403a);
            jSONObject.put("value", this.f12405c);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f12404b);
        } catch (JSONException e2) {
            if (f12402g) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e2);
            }
        }
        return jSONObject;
    }

    public String j() {
        return this.f12405c;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(g());
        objArr[1] = this.f12403a;
        objArr[2] = b() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
