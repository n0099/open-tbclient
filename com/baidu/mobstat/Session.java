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
    public volatile long f8417a = 0;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f8418b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f8419c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f8420d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f8421e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f8422f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f8423g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f8424h = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8425a;

        /* renamed from: b  reason: collision with root package name */
        public String f8426b;

        /* renamed from: c  reason: collision with root package name */
        public String f8427c;

        /* renamed from: d  reason: collision with root package name */
        public long f8428d;

        /* renamed from: e  reason: collision with root package name */
        public long f8429e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8430f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f8431g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8432h;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
            this.f8426b = str;
            this.f8427c = str2;
            this.f8425a = str3;
            this.f8428d = j;
            this.f8429e = j2;
            this.f8430f = z;
            this.f8431g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f8432h = z2;
        }

        public String a() {
            return this.f8426b;
        }

        public JSONObject e() {
            return this.f8431g;
        }

        public boolean f() {
            return this.f8430f;
        }

        public void a(a aVar) {
            this.f8425a = aVar.f8425a;
            this.f8426b = aVar.f8426b;
            this.f8427c = aVar.f8427c;
            this.f8428d = aVar.f8428d;
            this.f8429e = aVar.f8429e;
            this.f8430f = aVar.f8430f;
            this.f8431g = aVar.f8431g;
            this.f8432h = aVar.f8432h;
        }

        public String b() {
            return this.f8427c;
        }

        public long c() {
            return this.f8428d;
        }

        public long d() {
            return this.f8429e;
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
        if (!TextUtils.isEmpty(aVar2.f8425a) && !TextUtils.isEmpty(aVar.f8425a)) {
            if (aVar2.f8425a.equals(aVar.f8425a) && aVar2.f8430f != aVar.f8430f) {
                if (aVar2.f8430f) {
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
            if (!aVar.f8432h) {
                i = 0;
            }
            jSONObject.put("h5", i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
        a(this.f8423g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
    }

    public JSONObject constructJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8417a);
            jSONObject.put("e", this.f8418b);
            jSONObject.put("i", this.f8421e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8419c == 0 ? this.f8417a : this.f8419c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8420d == 0 ? this.f8418b : this.f8420d);
            jSONObject.put("pc", this.f8422f);
            if (this.f8424h != null && this.f8424h.length() != 0) {
                jSONObject.put(Config.LAUNCH, this.f8424h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f8423g.size(); i++) {
                jSONArray.put(getPVJson(this.f8423g.get(i), this.f8417a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8417a);
            jSONObject.put("e", this.f8418b);
            jSONObject.put("i", this.f8421e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8419c == 0 ? this.f8417a : this.f8419c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8420d == 0 ? this.f8418b : this.f8420d);
            jSONObject.put("pc", this.f8422f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long getStartTime() {
        return this.f8417a;
    }

    public boolean hasEnd() {
        return this.f8418b > 0;
    }

    public boolean hasStart() {
        return this.f8417a > 0;
    }

    public void reset() {
        this.f8417a = 0L;
        this.f8418b = 0L;
        this.f8419c = 0L;
        this.f8420d = 0L;
        this.f8422f = 0;
        this.f8423g.clear();
    }

    public void setEndTime(long j) {
        this.f8418b = j;
    }

    public void setInvokeType(int i) {
        this.f8422f = i;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.f8424h = jSONObject;
    }

    public void setStartTime(long j) {
        if (this.f8417a > 0) {
            return;
        }
        this.f8417a = j;
        this.f8421e = j;
    }

    public void setTrackEndTime(long j) {
        this.f8420d = j;
    }

    public void setTrackStartTime(long j) {
        if (this.f8419c > 0) {
            return;
        }
        this.f8419c = j;
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    public void addPageView(a aVar) {
        a(this.f8423g, aVar);
    }
}
