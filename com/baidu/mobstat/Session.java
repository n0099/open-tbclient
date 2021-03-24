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
    public volatile long f8842a = 0;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f8843b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f8844c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f8845d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f8846e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f8847f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f8848g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f8849h = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8850a;

        /* renamed from: b  reason: collision with root package name */
        public String f8851b;

        /* renamed from: c  reason: collision with root package name */
        public String f8852c;

        /* renamed from: d  reason: collision with root package name */
        public long f8853d;

        /* renamed from: e  reason: collision with root package name */
        public long f8854e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8855f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f8856g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8857h;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
            this.f8851b = str;
            this.f8852c = str2;
            this.f8850a = str3;
            this.f8853d = j;
            this.f8854e = j2;
            this.f8855f = z;
            this.f8856g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f8857h = z2;
        }

        public String a() {
            return this.f8851b;
        }

        public JSONObject e() {
            return this.f8856g;
        }

        public boolean f() {
            return this.f8855f;
        }

        public void a(a aVar) {
            this.f8850a = aVar.f8850a;
            this.f8851b = aVar.f8851b;
            this.f8852c = aVar.f8852c;
            this.f8853d = aVar.f8853d;
            this.f8854e = aVar.f8854e;
            this.f8855f = aVar.f8855f;
            this.f8856g = aVar.f8856g;
            this.f8857h = aVar.f8857h;
        }

        public String b() {
            return this.f8852c;
        }

        public long c() {
            return this.f8853d;
        }

        public long d() {
            return this.f8854e;
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
        if (!TextUtils.isEmpty(aVar2.f8850a) && !TextUtils.isEmpty(aVar.f8850a)) {
            if (aVar2.f8850a.equals(aVar.f8850a) && aVar2.f8855f != aVar.f8855f) {
                if (aVar2.f8855f) {
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
            if (!aVar.f8857h) {
                i = 0;
            }
            jSONObject.put("h5", i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
        a(this.f8848g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
    }

    public JSONObject constructJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8842a);
            jSONObject.put("e", this.f8843b);
            jSONObject.put("i", this.f8846e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8844c == 0 ? this.f8842a : this.f8844c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8845d == 0 ? this.f8843b : this.f8845d);
            jSONObject.put("pc", this.f8847f);
            if (this.f8849h != null && this.f8849h.length() != 0) {
                jSONObject.put(Config.LAUNCH, this.f8849h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f8848g.size(); i++) {
                jSONArray.put(getPVJson(this.f8848g.get(i), this.f8842a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8842a);
            jSONObject.put("e", this.f8843b);
            jSONObject.put("i", this.f8846e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8844c == 0 ? this.f8842a : this.f8844c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8845d == 0 ? this.f8843b : this.f8845d);
            jSONObject.put("pc", this.f8847f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long getStartTime() {
        return this.f8842a;
    }

    public boolean hasEnd() {
        return this.f8843b > 0;
    }

    public boolean hasStart() {
        return this.f8842a > 0;
    }

    public void reset() {
        this.f8842a = 0L;
        this.f8843b = 0L;
        this.f8844c = 0L;
        this.f8845d = 0L;
        this.f8847f = 0;
        this.f8848g.clear();
    }

    public void setEndTime(long j) {
        this.f8843b = j;
    }

    public void setInvokeType(int i) {
        this.f8847f = i;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.f8849h = jSONObject;
    }

    public void setStartTime(long j) {
        if (this.f8842a > 0) {
            return;
        }
        this.f8842a = j;
        this.f8846e = j;
    }

    public void setTrackEndTime(long j) {
        this.f8845d = j;
    }

    public void setTrackStartTime(long j) {
        if (this.f8844c > 0) {
            return;
        }
        this.f8844c = j;
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    public void addPageView(a aVar) {
        a(this.f8848g, aVar);
    }
}
