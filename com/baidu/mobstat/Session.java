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
    public volatile long f8530a = 0;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f8531b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f8532c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f8533d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f8534e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f8535f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f8536g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f8537h = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8538a;

        /* renamed from: b  reason: collision with root package name */
        public String f8539b;

        /* renamed from: c  reason: collision with root package name */
        public String f8540c;

        /* renamed from: d  reason: collision with root package name */
        public long f8541d;

        /* renamed from: e  reason: collision with root package name */
        public long f8542e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8543f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f8544g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8545h;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
            this.f8539b = str;
            this.f8540c = str2;
            this.f8538a = str3;
            this.f8541d = j;
            this.f8542e = j2;
            this.f8543f = z;
            this.f8544g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f8545h = z2;
        }

        public String a() {
            return this.f8539b;
        }

        public JSONObject e() {
            return this.f8544g;
        }

        public boolean f() {
            return this.f8543f;
        }

        public void a(a aVar) {
            this.f8538a = aVar.f8538a;
            this.f8539b = aVar.f8539b;
            this.f8540c = aVar.f8540c;
            this.f8541d = aVar.f8541d;
            this.f8542e = aVar.f8542e;
            this.f8543f = aVar.f8543f;
            this.f8544g = aVar.f8544g;
            this.f8545h = aVar.f8545h;
        }

        public String b() {
            return this.f8540c;
        }

        public long c() {
            return this.f8541d;
        }

        public long d() {
            return this.f8542e;
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
        if (!TextUtils.isEmpty(aVar2.f8538a) && !TextUtils.isEmpty(aVar.f8538a)) {
            if (aVar2.f8538a.equals(aVar.f8538a) && aVar2.f8543f != aVar.f8543f) {
                if (aVar2.f8543f) {
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
            if (!aVar.f8545h) {
                i2 = 0;
            }
            jSONObject.put("h5", i2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
        a(this.f8536g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
    }

    public JSONObject constructJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8530a);
            jSONObject.put("e", this.f8531b);
            jSONObject.put("i", this.f8534e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8532c == 0 ? this.f8530a : this.f8532c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8533d == 0 ? this.f8531b : this.f8533d);
            jSONObject.put("pc", this.f8535f);
            if (this.f8537h != null && this.f8537h.length() != 0) {
                jSONObject.put("launch", this.f8537h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f8536g.size(); i2++) {
                jSONArray.put(getPVJson(this.f8536g.get(i2), this.f8530a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8530a);
            jSONObject.put("e", this.f8531b);
            jSONObject.put("i", this.f8534e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8532c == 0 ? this.f8530a : this.f8532c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8533d == 0 ? this.f8531b : this.f8533d);
            jSONObject.put("pc", this.f8535f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long getStartTime() {
        return this.f8530a;
    }

    public boolean hasEnd() {
        return this.f8531b > 0;
    }

    public boolean hasStart() {
        return this.f8530a > 0;
    }

    public void reset() {
        this.f8530a = 0L;
        this.f8531b = 0L;
        this.f8532c = 0L;
        this.f8533d = 0L;
        this.f8535f = 0;
        this.f8536g.clear();
    }

    public void setEndTime(long j) {
        this.f8531b = j;
    }

    public void setInvokeType(int i2) {
        this.f8535f = i2;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.f8537h = jSONObject;
    }

    public void setStartTime(long j) {
        if (this.f8530a > 0) {
            return;
        }
        this.f8530a = j;
        this.f8534e = j;
    }

    public void setTrackEndTime(long j) {
        this.f8533d = j;
    }

    public void setTrackStartTime(long j) {
        if (this.f8532c > 0) {
            return;
        }
        this.f8532c = j;
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    public void addPageView(a aVar) {
        a(this.f8536g, aVar);
    }
}
