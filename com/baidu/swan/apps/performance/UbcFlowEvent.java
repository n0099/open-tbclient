package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.a.i0.a.k;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcFlowEvent {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f11087g = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public final String f11088a;

    /* renamed from: b  reason: collision with root package name */
    public long f11089b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f11090c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f11091d = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;

    /* renamed from: e  reason: collision with root package name */
    public RecordType f11092e = RecordType.KEEP;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11093f = false;

    /* loaded from: classes3.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.f11088a = str;
    }

    public UbcFlowEvent a(boolean z) {
        this.f11093f = z;
        return this;
    }

    public boolean b() {
        return this.f11093f;
    }

    public RecordType c() {
        return this.f11092e;
    }

    public UbcFlowEvent d(RecordType recordType) {
        this.f11092e = recordType;
        return this;
    }

    public UbcFlowEvent e(String str) {
        this.f11091d = str;
        return this;
    }

    public String f() {
        return this.f11091d;
    }

    public long g() {
        return this.f11089b;
    }

    public UbcFlowEvent h(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f11089b = j;
        return this;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f11088a);
            jSONObject.put("value", this.f11090c);
            jSONObject.put("ts", this.f11089b);
        } catch (JSONException e2) {
            if (f11087g) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e2);
            }
        }
        return jSONObject;
    }

    public String j() {
        return this.f11090c;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(g());
        objArr[1] = this.f11088a;
        objArr[2] = b() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
