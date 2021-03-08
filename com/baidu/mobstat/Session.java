package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class Session {

    /* renamed from: a  reason: collision with root package name */
    private volatile long f2563a = 0;
    private volatile long b = 0;
    private volatile long c = 0;
    private volatile long d = 0;
    private volatile long e = 0;
    private volatile int f = 0;
    private List<a> g = new ArrayList();
    private volatile JSONObject h = null;

    public void reset() {
        this.f2563a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.f = 0;
        this.g.clear();
    }

    public void setTrackStartTime(long j) {
        if (this.c <= 0) {
            this.c = j;
        }
    }

    public void setTrackEndTime(long j) {
        this.d = j;
    }

    public void setInvokeType(int i) {
        this.f = i;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
        a(this.g, new a(str, str2, str3, j, j2, z, extraInfo, z2));
    }

    public void addPageView(a aVar) {
        a(this.g, aVar);
    }

    private void a(List<a> list, a aVar) {
        if (list != null && aVar != null) {
            int size = list.size();
            if (size == 0) {
                list.add(aVar);
                return;
            }
            a aVar2 = list.get(size - 1);
            if (TextUtils.isEmpty(aVar2.f2564a) || TextUtils.isEmpty(aVar.f2564a)) {
                list.add(aVar);
            } else if (!aVar2.f2564a.equals(aVar.f2564a) || aVar2.f == aVar.f) {
                list.add(aVar);
            } else if (aVar2.f) {
                aVar2.a(aVar);
            }
        }
    }

    public void setStartTime(long j) {
        if (this.f2563a <= 0) {
            this.f2563a = j;
            this.e = j;
        }
    }

    public long getStartTime() {
        return this.f2563a;
    }

    public boolean hasStart() {
        return this.f2563a > 0;
    }

    public boolean hasEnd() {
        return this.b > 0;
    }

    public void setEndTime(long j) {
        this.b = j;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public JSONObject constructJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f2563a);
            jSONObject.put("e", this.b);
            jSONObject.put("i", this.e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.c == 0 ? this.f2563a : this.c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.d == 0 ? this.b : this.d);
            jSONObject.put("pc", this.f);
            if (this.h != null && this.h.length() != 0) {
                jSONObject.put(Config.LAUNCH, this.h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.g.size(); i++) {
                jSONArray.put(getPVJson(this.g.get(i), this.f2563a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f2563a);
            jSONObject.put("e", this.b);
            jSONObject.put("i", this.e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.c == 0 ? this.f2563a : this.c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.d == 0 ? this.b : this.d);
            jSONObject.put("pc", this.f);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    public static JSONObject getPVJson(a aVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", aVar.a());
            jSONObject.put("d", aVar.c());
            long d = aVar.d() - j;
            jSONObject.put("ps", d >= 0 ? d : 0L);
            jSONObject.put("t", aVar.b());
            jSONObject.put("at", aVar.f() ? 1 : 0);
            JSONObject e = aVar.e();
            if (e != null && e.length() != 0) {
                jSONObject.put("ext", e);
            }
            jSONObject.put("h5", aVar.h ? 1 : 0);
        } catch (JSONException e2) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f2564a;
        private String b;
        private String c;
        private long d;
        private long e;
        private boolean f;
        private JSONObject g;
        private boolean h;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2) {
            this.b = str;
            this.c = str2;
            this.f2564a = str3;
            this.d = j;
            this.e = j2;
            this.f = z;
            this.g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.h = z2;
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }

        public long c() {
            return this.d;
        }

        public long d() {
            return this.e;
        }

        public JSONObject e() {
            return this.g;
        }

        public boolean f() {
            return this.f;
        }

        public void a(a aVar) {
            this.f2564a = aVar.f2564a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = aVar.h;
        }
    }
}
