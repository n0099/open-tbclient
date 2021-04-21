package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.b.h0.a.k;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UbcFlowEvent {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f12072g = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public final String f12073a;

    /* renamed from: b  reason: collision with root package name */
    public long f12074b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f12075c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f12076d = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;

    /* renamed from: e  reason: collision with root package name */
    public RecordType f12077e = RecordType.KEEP;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12078f = false;

    /* loaded from: classes2.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.f12073a = str;
    }

    public UbcFlowEvent a(boolean z) {
        this.f12078f = z;
        return this;
    }

    public boolean b() {
        return this.f12078f;
    }

    public RecordType c() {
        return this.f12077e;
    }

    public UbcFlowEvent d(RecordType recordType) {
        this.f12077e = recordType;
        return this;
    }

    public UbcFlowEvent e(String str) {
        this.f12076d = str;
        return this;
    }

    public String f() {
        return this.f12076d;
    }

    public long g() {
        return this.f12074b;
    }

    public UbcFlowEvent h(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f12074b = j;
        return this;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f12073a);
            jSONObject.put("value", this.f12075c);
            jSONObject.put("ts", this.f12074b);
        } catch (JSONException e2) {
            if (f12072g) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e2);
            }
        }
        return jSONObject;
    }

    public String j() {
        return this.f12075c;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(g());
        objArr[1] = this.f12073a;
        objArr[2] = b() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
