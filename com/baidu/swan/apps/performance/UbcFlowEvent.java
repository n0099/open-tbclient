package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.a.h0.a.k;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcFlowEvent {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f11914g = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public final String f11915a;

    /* renamed from: b  reason: collision with root package name */
    public long f11916b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f11917c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f11918d = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;

    /* renamed from: e  reason: collision with root package name */
    public RecordType f11919e = RecordType.KEEP;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11920f = false;

    /* loaded from: classes3.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.f11915a = str;
    }

    public UbcFlowEvent a(boolean z) {
        this.f11920f = z;
        return this;
    }

    public boolean b() {
        return this.f11920f;
    }

    public RecordType c() {
        return this.f11919e;
    }

    public UbcFlowEvent d(RecordType recordType) {
        this.f11919e = recordType;
        return this;
    }

    public UbcFlowEvent e(String str) {
        this.f11918d = str;
        return this;
    }

    public String f() {
        return this.f11918d;
    }

    public long g() {
        return this.f11916b;
    }

    public UbcFlowEvent h(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f11916b = j;
        return this;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f11915a);
            jSONObject.put("value", this.f11917c);
            jSONObject.put("ts", this.f11916b);
        } catch (JSONException e2) {
            if (f11914g) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e2);
            }
        }
        return jSONObject;
    }

    public String j() {
        return this.f11917c;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(g());
        objArr[1] = this.f11915a;
        objArr[2] = b() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
