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
    public volatile long f8843a = 0;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f8844b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f8845c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f8846d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f8847e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f8848f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f8849g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f8850h = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8851a;

        /* renamed from: b  reason: collision with root package name */
        public String f8852b;

        /* renamed from: c  reason: collision with root package name */
        public String f8853c;

        /* renamed from: d  reason: collision with root package name */
        public long f8854d;

        /* renamed from: e  reason: collision with root package name */
        public long f8855e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8856f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f8857g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8858h;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
            this.f8852b = str;
            this.f8853c = str2;
            this.f8851a = str3;
            this.f8854d = j;
            this.f8855e = j2;
            this.f8856f = z;
            this.f8857g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f8858h = z2;
        }

        public String a() {
            return this.f8852b;
        }

        public JSONObject e() {
            return this.f8857g;
        }

        public boolean f() {
            return this.f8856f;
        }

        public void a(a aVar) {
            this.f8851a = aVar.f8851a;
            this.f8852b = aVar.f8852b;
            this.f8853c = aVar.f8853c;
            this.f8854d = aVar.f8854d;
            this.f8855e = aVar.f8855e;
            this.f8856f = aVar.f8856f;
            this.f8857g = aVar.f8857g;
            this.f8858h = aVar.f8858h;
        }

        public String b() {
            return this.f8853c;
        }

        public long c() {
            return this.f8854d;
        }

        public long d() {
            return this.f8855e;
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
        if (!TextUtils.isEmpty(aVar2.f8851a) && !TextUtils.isEmpty(aVar.f8851a)) {
            if (aVar2.f8851a.equals(aVar.f8851a) && aVar2.f8856f != aVar.f8856f) {
                if (aVar2.f8856f) {
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
            int i = 1;
            jSONObject.put("at", aVar.f() ? 1 : 0);
            JSONObject e2 = aVar.e();
            if (e2 != null && e2.length() != 0) {
                jSONObject.put("ext", e2);
            }
            if (!aVar.f8858h) {
                i = 0;
            }
            jSONObject.put("h5", i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
        a(this.f8849g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
    }

    public JSONObject constructJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8843a);
            jSONObject.put("e", this.f8844b);
            jSONObject.put("i", this.f8847e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8845c == 0 ? this.f8843a : this.f8845c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8846d == 0 ? this.f8844b : this.f8846d);
            jSONObject.put("pc", this.f8848f);
            if (this.f8850h != null && this.f8850h.length() != 0) {
                jSONObject.put(Config.LAUNCH, this.f8850h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f8849g.size(); i++) {
                jSONArray.put(getPVJson(this.f8849g.get(i), this.f8843a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8843a);
            jSONObject.put("e", this.f8844b);
            jSONObject.put("i", this.f8847e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8845c == 0 ? this.f8843a : this.f8845c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8846d == 0 ? this.f8844b : this.f8846d);
            jSONObject.put("pc", this.f8848f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long getStartTime() {
        return this.f8843a;
    }

    public boolean hasEnd() {
        return this.f8844b > 0;
    }

    public boolean hasStart() {
        return this.f8843a > 0;
    }

    public void reset() {
        this.f8843a = 0L;
        this.f8844b = 0L;
        this.f8845c = 0L;
        this.f8846d = 0L;
        this.f8848f = 0;
        this.f8849g.clear();
    }

    public void setEndTime(long j) {
        this.f8844b = j;
    }

    public void setInvokeType(int i) {
        this.f8848f = i;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.f8850h = jSONObject;
    }

    public void setStartTime(long j) {
        if (this.f8843a > 0) {
            return;
        }
        this.f8843a = j;
        this.f8847e = j;
    }

    public void setTrackEndTime(long j) {
        this.f8846d = j;
    }

    public void setTrackStartTime(long j) {
        if (this.f8845c > 0) {
            return;
        }
        this.f8845c = j;
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    public void addPageView(a aVar) {
        a(this.f8849g, aVar);
    }
}
