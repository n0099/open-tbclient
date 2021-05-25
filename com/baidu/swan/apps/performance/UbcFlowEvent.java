package com.baidu.swan.apps.performance;

import android.util.Log;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.a.l0.a.k;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcFlowEvent {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f10988g = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public final String f10989a;

    /* renamed from: b  reason: collision with root package name */
    public long f10990b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f10991c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f10992d = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;

    /* renamed from: e  reason: collision with root package name */
    public RecordType f10993e = RecordType.KEEP;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10994f = false;

    /* loaded from: classes3.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.f10989a = str;
    }

    public UbcFlowEvent a(boolean z) {
        this.f10994f = z;
        return this;
    }

    public boolean b() {
        return this.f10994f;
    }

    public RecordType c() {
        return this.f10993e;
    }

    public UbcFlowEvent d(RecordType recordType) {
        this.f10993e = recordType;
        return this;
    }

    public UbcFlowEvent e(String str) {
        this.f10992d = str;
        return this;
    }

    public String f() {
        return this.f10992d;
    }

    public long g() {
        return this.f10990b;
    }

    public UbcFlowEvent h(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f10990b = j;
        return this;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f10989a);
            jSONObject.put("value", this.f10991c);
            jSONObject.put("ts", this.f10990b);
        } catch (JSONException e2) {
            if (f10988g) {
                Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e2);
            }
        }
        return jSONObject;
    }

    public String j() {
        return this.f10991c;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(g());
        objArr[1] = this.f10989a;
        objArr[2] = b() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
