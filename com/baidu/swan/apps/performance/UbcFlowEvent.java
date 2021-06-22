package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.a.m0.a.k;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcFlowEvent {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f11132g = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final String f11133a;

    /* renamed from: b  reason: collision with root package name */
    public long f11134b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f11135c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f11136d = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;

    /* renamed from: e  reason: collision with root package name */
    public RecordType f11137e = RecordType.KEEP;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11138f = false;

    /* loaded from: classes3.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.f11133a = str;
    }

    public UbcFlowEvent a(boolean z) {
        this.f11138f = z;
        return this;
    }

    public boolean b() {
        return this.f11138f;
    }

    public RecordType c() {
        return this.f11137e;
    }

    public UbcFlowEvent d(RecordType recordType) {
        this.f11137e = recordType;
        return this;
    }

    public UbcFlowEvent e(String str) {
        this.f11136d = str;
        return this;
    }

    public String f() {
        return this.f11136d;
    }

    public long g() {
        return this.f11134b;
    }

    public UbcFlowEvent h(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f11134b = j;
        return this;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f11133a);
            jSONObject.put("value", this.f11135c);
            jSONObject.put("ts", this.f11134b);
        } catch (JSONException e2) {
            if (f11132g) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e2);
            }
        }
        return jSONObject;
    }

    public String j() {
        return this.f11135c;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(g());
        objArr[1] = this.f11133a;
        objArr[2] = b() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
