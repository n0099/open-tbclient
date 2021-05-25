package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Session {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f8430a = 0;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f8431b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f8432c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f8433d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f8434e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f8435f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f8436g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f8437h = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8438a;

        /* renamed from: b  reason: collision with root package name */
        public String f8439b;

        /* renamed from: c  reason: collision with root package name */
        public String f8440c;

        /* renamed from: d  reason: collision with root package name */
        public long f8441d;

        /* renamed from: e  reason: collision with root package name */
        public long f8442e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8443f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f8444g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8445h;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
            this.f8439b = str;
            this.f8440c = str2;
            this.f8438a = str3;
            this.f8441d = j;
            this.f8442e = j2;
            this.f8443f = z;
            this.f8444g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f8445h = z2;
        }

        public String a() {
            return this.f8439b;
        }

        public JSONObject e() {
            return this.f8444g;
        }

        public boolean f() {
            return this.f8443f;
        }

        public void a(a aVar) {
            this.f8438a = aVar.f8438a;
            this.f8439b = aVar.f8439b;
            this.f8440c = aVar.f8440c;
            this.f8441d = aVar.f8441d;
            this.f8442e = aVar.f8442e;
            this.f8443f = aVar.f8443f;
            this.f8444g = aVar.f8444g;
            this.f8445h = aVar.f8445h;
        }

        public String b() {
            return this.f8440c;
        }

        public long c() {
            return this.f8441d;
        }

        public long d() {
            return this.f8442e;
        }
    }

    private void a(List<a> list, a aVar) {
        if (list == null || aVar == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(aVar);
            return;
        }
        a aVar2 = list.get(size - 1);
        if (!TextUtils.isEmpty(aVar2.f8438a) && !TextUtils.isEmpty(aVar.f8438a)) {
            if (aVar2.f8438a.equals(aVar.f8438a) && aVar2.f8443f != aVar.f8443f) {
                if (aVar2.f8443f) {
                    aVar2.a(aVar);
                    return;
                }
                return;
            }
            list.add(aVar);
            return;
        }
        list.add(aVar);
    }

    public static JSONObject getPVJson(a aVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", aVar.a());
            jSONObject.put("d", aVar.c());
            long d2 = aVar.d() - j;
            if (d2 < 0) {
                d2 = 0;
            }
            jSONObject.put("ps", d2);
            jSONObject.put("t", aVar.b());
            int i2 = 1;
            jSONObject.put("at", aVar.f() ? 1 : 0);
            JSONObject e2 = aVar.e();
            if (e2 != null && e2.length() != 0) {
                jSONObject.put("ext", e2);
            }
            if (!aVar.f8445h) {
                i2 = 0;
            }
            jSONObject.put("h5", i2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
        a(this.f8436g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
    }

    public JSONObject constructJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8430a);
            jSONObject.put("e", this.f8431b);
            jSONObject.put("i", this.f8434e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8432c == 0 ? this.f8430a : this.f8432c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8433d == 0 ? this.f8431b : this.f8433d);
            jSONObject.put("pc", this.f8435f);
            if (this.f8437h != null && this.f8437h.length() != 0) {
                jSONObject.put("launch", this.f8437h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f8436g.size(); i2++) {
                jSONArray.put(getPVJson(this.f8436g.get(i2), this.f8430a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8430a);
            jSONObject.put("e", this.f8431b);
            jSONObject.put("i", this.f8434e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8432c == 0 ? this.f8430a : this.f8432c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8433d == 0 ? this.f8431b : this.f8433d);
            jSONObject.put("pc", this.f8435f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long getStartTime() {
        return this.f8430a;
    }

    public boolean hasEnd() {
        return this.f8431b > 0;
    }

    public boolean hasStart() {
        return this.f8430a > 0;
    }

    public void reset() {
        this.f8430a = 0L;
        this.f8431b = 0L;
        this.f8432c = 0L;
        this.f8433d = 0L;
        this.f8435f = 0;
        this.f8436g.clear();
    }

    public void setEndTime(long j) {
        this.f8431b = j;
    }

    public void setInvokeType(int i2) {
        this.f8435f = i2;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.f8437h = jSONObject;
    }

    public void setStartTime(long j) {
        if (this.f8430a > 0) {
            return;
        }
        this.f8430a = j;
        this.f8434e = j;
    }

    public void setTrackEndTime(long j) {
        this.f8433d = j;
    }

    public void setTrackStartTime(long j) {
        if (this.f8432c > 0) {
            return;
        }
        this.f8432c = j;
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    public void addPageView(a aVar) {
        a(this.f8436g, aVar);
    }
}
