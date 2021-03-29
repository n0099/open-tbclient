package com.baidu.swan.apps.performance;

import android.util.Log;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import d.b.g0.a.k;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UbcFlowEvent {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f12403g = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public final String f12404a;

    /* renamed from: b  reason: collision with root package name */
    public long f12405b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f12406c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f12407d = "NA";

    /* renamed from: e  reason: collision with root package name */
    public RecordType f12408e = RecordType.KEEP;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12409f = false;

    /* loaded from: classes2.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.f12404a = str;
    }

    public UbcFlowEvent a(boolean z) {
        this.f12409f = z;
        return this;
    }

    public boolean b() {
        return this.f12409f;
    }

    public RecordType c() {
        return this.f12408e;
    }

    public UbcFlowEvent d(RecordType recordType) {
        this.f12408e = recordType;
        return this;
    }

    public UbcFlowEvent e(String str) {
        this.f12407d = str;
        return this;
    }

    public String f() {
        return this.f12407d;
    }

    public long g() {
        return this.f12405b;
    }

    public UbcFlowEvent h(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f12405b = j;
        return this;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f12404a);
            jSONObject.put("value", this.f12406c);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f12405b);
        } catch (JSONException e2) {
            if (f12403g) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e2);
            }
        }
        return jSONObject;
    }

    public String j() {
        return this.f12406c;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(g());
        objArr[1] = this.f12404a;
        objArr[2] = b() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
