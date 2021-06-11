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
    public volatile long f8492a = 0;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f8493b = 0;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f8494c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f8495d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f8496e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f8497f = 0;

    /* renamed from: g  reason: collision with root package name */
    public List<a> f8498g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public volatile JSONObject f8499h = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8500a;

        /* renamed from: b  reason: collision with root package name */
        public String f8501b;

        /* renamed from: c  reason: collision with root package name */
        public String f8502c;

        /* renamed from: d  reason: collision with root package name */
        public long f8503d;

        /* renamed from: e  reason: collision with root package name */
        public long f8504e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8505f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f8506g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8507h;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
            this.f8501b = str;
            this.f8502c = str2;
            this.f8500a = str3;
            this.f8503d = j;
            this.f8504e = j2;
            this.f8505f = z;
            this.f8506g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.f8507h = z2;
        }

        public String a() {
            return this.f8501b;
        }

        public JSONObject e() {
            return this.f8506g;
        }

        public boolean f() {
            return this.f8505f;
        }

        public void a(a aVar) {
            this.f8500a = aVar.f8500a;
            this.f8501b = aVar.f8501b;
            this.f8502c = aVar.f8502c;
            this.f8503d = aVar.f8503d;
            this.f8504e = aVar.f8504e;
            this.f8505f = aVar.f8505f;
            this.f8506g = aVar.f8506g;
            this.f8507h = aVar.f8507h;
        }

        public String b() {
            return this.f8502c;
        }

        public long c() {
            return this.f8503d;
        }

        public long d() {
            return this.f8504e;
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
        if (!TextUtils.isEmpty(aVar2.f8500a) && !TextUtils.isEmpty(aVar.f8500a)) {
            if (aVar2.f8500a.equals(aVar.f8500a) && aVar2.f8505f != aVar.f8505f) {
                if (aVar2.f8505f) {
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
            if (!aVar.f8507h) {
                i2 = 0;
            }
            jSONObject.put("h5", i2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
        a(this.f8498g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
    }

    public JSONObject constructJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8492a);
            jSONObject.put("e", this.f8493b);
            jSONObject.put("i", this.f8496e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8494c == 0 ? this.f8492a : this.f8494c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8495d == 0 ? this.f8493b : this.f8495d);
            jSONObject.put("pc", this.f8497f);
            if (this.f8499h != null && this.f8499h.length() != 0) {
                jSONObject.put("launch", this.f8499h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f8498g.size(); i2++) {
                jSONArray.put(getPVJson(this.f8498g.get(i2), this.f8492a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f8492a);
            jSONObject.put("e", this.f8493b);
            jSONObject.put("i", this.f8496e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f8494c == 0 ? this.f8492a : this.f8494c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f8495d == 0 ? this.f8493b : this.f8495d);
            jSONObject.put("pc", this.f8497f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long getStartTime() {
        return this.f8492a;
    }

    public boolean hasEnd() {
        return this.f8493b > 0;
    }

    public boolean hasStart() {
        return this.f8492a > 0;
    }

    public void reset() {
        this.f8492a = 0L;
        this.f8493b = 0L;
        this.f8494c = 0L;
        this.f8495d = 0L;
        this.f8497f = 0;
        this.f8498g.clear();
    }

    public void setEndTime(long j) {
        this.f8493b = j;
    }

    public void setInvokeType(int i2) {
        this.f8497f = i2;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.f8499h = jSONObject;
    }

    public void setStartTime(long j) {
        if (this.f8492a > 0) {
            return;
        }
        this.f8492a = j;
        this.f8496e = j;
    }

    public void setTrackEndTime(long j) {
        this.f8495d = j;
    }

    public void setTrackStartTime(long j) {
        if (this.f8494c > 0) {
            return;
        }
        this.f8494c = j;
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    public void addPageView(a aVar) {
        a(this.f8498g, aVar);
    }
}
