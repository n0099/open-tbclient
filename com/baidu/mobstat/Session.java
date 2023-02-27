package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Session {
    public volatile long a = 0;
    public volatile long b = 0;
    public volatile long c = 0;
    public volatile long d = 0;
    public volatile long e = 0;
    public volatile int f = 0;
    public List<a> g = new ArrayList();
    public volatile JSONObject h = null;

    /* loaded from: classes2.dex */
    public static class a {
        public String a;
        public String b;
        public String c;
        public long d;
        public long e;
        public boolean f;
        public JSONObject g;
        public boolean h;
        public String i;

        public a(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2, String str4) {
            this.b = str;
            this.c = str2;
            this.a = str3;
            this.d = j;
            this.e = j2;
            this.f = z;
            this.i = str4;
            this.g = extraInfo != null ? extraInfo.dumpToJson() : new JSONObject();
            this.h = z2;
        }

        public void a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = aVar.h;
            this.i = aVar.i;
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

        public String g() {
            return this.i;
        }
    }

    public long getStartTime() {
        return this.a;
    }

    public long getTrackEndTime() {
        return this.d;
    }

    public long getTrackStartTime() {
        return this.c;
    }

    public boolean hasEnd() {
        if (this.b > 0) {
            return true;
        }
        return false;
    }

    public boolean hasStart() {
        if (this.a > 0) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.f = 0;
        this.g.clear();
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    private void a(List<a> list, a aVar) {
        try {
            if (!bu.a().e() || list == null || aVar == null) {
                return;
            }
            int size = list.size();
            if (size == 0) {
                list.add(aVar);
                return;
            }
            a aVar2 = list.get(size - 1);
            if (!TextUtils.isEmpty(aVar2.a) && !TextUtils.isEmpty(aVar.a)) {
                if (aVar2.a.equals(aVar.a) && aVar2.f != aVar.f) {
                    if (aVar2.f) {
                        aVar2.a(aVar);
                        return;
                    }
                    return;
                }
                list.add(aVar);
                return;
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    public static JSONObject getPVJson(a aVar, long j) {
        int i;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", aVar.a());
            jSONObject.put("d", aVar.c());
            long d = aVar.d() - j;
            if (d < 0) {
                d = 0;
            }
            jSONObject.put("ps", d);
            jSONObject.put("t", aVar.b());
            int i2 = 1;
            if (aVar.f()) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.put("at", i);
            JSONObject e = aVar.e();
            if (e != null && e.length() != 0) {
                jSONObject.put("ext", e);
            }
            if (!aVar.h) {
                i2 = 0;
            }
            jSONObject.put("h5", i2);
            jSONObject.put(Config.PY, aVar.g());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void addPageView(a aVar) {
        a(this.g, aVar);
    }

    public void setEndTime(long j) {
        this.b = j;
    }

    public void setInvokeType(int i) {
        this.f = i;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public void setStartTime(long j) {
        if (this.a > 0) {
            return;
        }
        this.a = j;
        this.e = j;
    }

    public void setTrackEndTime(long j) {
        this.d = j;
    }

    public void setTrackStartTime(long j) {
        if (this.c > 0) {
            return;
        }
        this.c = j;
    }

    public void addPageView(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo, boolean z2, String str4) {
        a(this.g, new a(str, str2, str3, j, j2, z, extraInfo, z2, str4));
    }

    public JSONObject constructJSONObject() {
        long j;
        long j2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.a);
            jSONObject.put("e", this.b);
            jSONObject.put("i", this.e);
            jSONObject.put("c", 1);
            if (this.c == 0) {
                j = this.a;
            } else {
                j = this.c;
            }
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, j);
            if (this.d == 0) {
                j2 = this.b;
            } else {
                j2 = this.d;
            }
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, j2);
            jSONObject.put("pc", this.f);
            if (this.h != null && this.h.length() != 0) {
                jSONObject.put("launch", this.h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.g.size(); i++) {
                jSONArray.put(getPVJson(this.g.get(i), this.a));
            }
            if (bu.a().e()) {
                jSONObject.put("p", jSONArray);
            }
            jSONObject.put(Config.PY, DataCore.instance().getSessionPy());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        long j;
        long j2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.a);
            jSONObject.put("e", this.b);
            jSONObject.put("i", this.e);
            jSONObject.put("c", 1);
            if (this.c == 0) {
                j = this.a;
            } else {
                j = this.c;
            }
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, j);
            if (this.d == 0) {
                j2 = this.b;
            } else {
                j2 = this.d;
            }
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, j2);
            jSONObject.put("pc", this.f);
            jSONObject.put(Config.PY, DataCore.instance().getSessionPy());
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
