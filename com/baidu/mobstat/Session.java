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
    public volatile long f8718a = 0;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f8719b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f8720c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f8721d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f8722e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f8723f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f8724g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f8725h = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8726a;

        /* renamed from: b  reason: collision with root package name */
        public String f8727b;

        /* renamed from: c  reason: collision with root package name */
        public String f8728c;

        /* renamed from: d  reason: collision with root package name */
        public long f8729d;

        /* renamed from: e  reason: collision with root package name */
        public long f8730e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8731f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f8732g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8733h;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
            this.f8727b = str;
            this.f8728c = str2;
            this.f8726a = str3;
            this.f8729d = j;
            this.f8730e = j2;
            this.f8731f = z;
            this.f8732g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f8733h = z2;
        }

        public String a() {
            return this.f8727b;
        }

        public JSONObject e() {
            return this.f8732g;
        }

        public boolean f() {
            return this.f8731f;
        }

        public void a(a aVar) {
            this.f8726a = aVar.f8726a;
            this.f8727b = aVar.f8727b;
            this.f8728c = aVar.f8728c;
            this.f8729d = aVar.f8729d;
            this.f8730e = aVar.f8730e;
            this.f8731f = aVar.f8731f;
            this.f8732g = aVar.f8732g;
            this.f8733h = aVar.f8733h;
        }

        public String b() {
            return this.f8728c;
        }

        public long c() {
            return this.f8729d;
        }

        public long d() {
            return this.f8730e;
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
        if (!TextUtils.isEmpty(aVar2.f8726a) && !TextUtils.isEmpty(aVar.f8726a)) {
            if (aVar2.f8726a.equals(aVar.f8726a) && aVar2.f8731f != aVar.f8731f) {
                if (aVar2.f8731f) {
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
            if (!aVar.f8733h) {
                i2 = 0;
            }
            jSONObject.put("h5", i2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
        a(this.f8724g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
    }

    public JSONObject constructJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8718a);
            jSONObject.put("e", this.f8719b);
            jSONObject.put("i", this.f8722e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8720c == 0 ? this.f8718a : this.f8720c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8721d == 0 ? this.f8719b : this.f8721d);
            jSONObject.put("pc", this.f8723f);
            if (this.f8725h != null && this.f8725h.length() != 0) {
                jSONObject.put("launch", this.f8725h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f8724g.size(); i2++) {
                jSONArray.put(getPVJson(this.f8724g.get(i2), this.f8718a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8718a);
            jSONObject.put("e", this.f8719b);
            jSONObject.put("i", this.f8722e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8720c == 0 ? this.f8718a : this.f8720c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8721d == 0 ? this.f8719b : this.f8721d);
            jSONObject.put("pc", this.f8723f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long getStartTime() {
        return this.f8718a;
    }

    public boolean hasEnd() {
        return this.f8719b > 0;
    }

    public boolean hasStart() {
        return this.f8718a > 0;
    }

    public void reset() {
        this.f8718a = 0L;
        this.f8719b = 0L;
        this.f8720c = 0L;
        this.f8721d = 0L;
        this.f8723f = 0;
        this.f8724g.clear();
    }

    public void setEndTime(long j) {
        this.f8719b = j;
    }

    public void setInvokeType(int i2) {
        this.f8723f = i2;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.f8725h = jSONObject;
    }

    public void setStartTime(long j) {
        if (this.f8718a > 0) {
            return;
        }
        this.f8718a = j;
        this.f8722e = j;
    }

    public void setTrackEndTime(long j) {
        this.f8721d = j;
    }

    public void setTrackStartTime(long j) {
        if (this.f8720c > 0) {
            return;
        }
        this.f8720c = j;
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    public void addPageView(a aVar) {
        a(this.f8724g, aVar);
    }
}
