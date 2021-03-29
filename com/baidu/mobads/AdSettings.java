package com.baidu.mobads;

import com.baidu.mobads.constants.XAdSDKProxyVersion;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdSettings {

    /* renamed from: c  reason: collision with root package name */
    public static String f8069c;

    /* renamed from: d  reason: collision with root package name */
    public static String f8070d;

    /* renamed from: e  reason: collision with root package name */
    public static String f8071e;

    /* renamed from: f  reason: collision with root package name */
    public static String f8072f;

    /* renamed from: g  reason: collision with root package name */
    public static String f8073g;

    /* renamed from: h  reason: collision with root package name */
    public static String f8074h;
    public static String i;

    /* renamed from: a  reason: collision with root package name */
    public static HashSet<String> f8067a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    public static JSONArray f8068b = new JSONArray();
    public static String j = b.HTTPS_PROTOCOL_TYPE.a() + "";
    public static HashSet<String> k = new HashSet<>();
    public static JSONArray l = new JSONArray();
    public static JSONObject m = new JSONObject();

    @Deprecated
    /* loaded from: classes2.dex */
    public enum a {
        PRIMARY(0),
        JUNIOR(1),
        SENIOR(2),
        SPECIALTY(3),
        BACHELOR(4),
        MASTER(5),
        DOCTOR(6);
        

        /* renamed from: h  reason: collision with root package name */
        public int f8082h;

        a(int i2) {
            this.f8082h = i2;
        }

        public int a() {
            return this.f8082h;
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public enum b {
        UNKNOWN_PROTOCOL_TYPE(0),
        HTTP_PROTOCOL_TYPE(1),
        HTTPS_PROTOCOL_TYPE(2);
        

        /* renamed from: d  reason: collision with root package name */
        public int f8087d;

        b(int i) {
            this.f8087d = i;
        }

        public String a() {
            return this.f8087d + "";
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public enum c {
        F0T1k(0),
        F1kT2k(1),
        F2kT3k(2),
        F3kT4k(3),
        F4kT5k(4),
        F5kT6k(5),
        F6kT7k(6),
        F7kT8k(7),
        F8kT9k(8),
        F9kT10k(9),
        F10kT15k(10),
        F15kT20k(11),
        F20(12);
        
        public int n;

        c(int i) {
            this.n = i;
        }

        public int a() {
            return this.n;
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public enum d {
        MALE(0),
        FEMALE(1);
        

        /* renamed from: c  reason: collision with root package name */
        public int f8099c;

        d(int i) {
            this.f8099c = i;
        }

        public int a() {
            return this.f8099c;
        }
    }

    public static JSONObject getAttr() {
        JSONObject jSONObject = new JSONObject();
        Iterator<String> it = f8067a.iterator();
        f8068b = new JSONArray();
        while (it.hasNext()) {
            f8068b.put(it.next());
        }
        try {
            jSONObject.putOpt("KEY", f8068b);
            jSONObject.putOpt("RPT", j);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static Double getSDKVersion() {
        return Double.valueOf(XAdSDKProxyVersion.getVersion());
    }

    public static String getSupportHttps() {
        return j;
    }

    @Deprecated
    public static void setBirthday(Calendar calendar) {
        if (calendar == null) {
            return;
        }
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        f8070d = i2 + "";
        if (i3 > 0 && i3 < 10) {
            f8070d += "0" + i3;
        } else {
            f8070d += i3;
        }
        if (i4 > 0 && i4 < 10) {
            f8070d += "0" + i4;
            return;
        }
        f8070d += i4;
    }

    @Deprecated
    public static void setCity(String str) {
        f8071e = str;
    }

    @Deprecated
    public static void setEducation(a aVar) {
        if (aVar == null) {
            return;
        }
        f8074h = aVar.a() + "";
    }

    @Deprecated
    public static void setHob(String[] strArr) {
        for (String str : strArr) {
            k.add(str);
        }
    }

    @Deprecated
    public static void setJob(String str) {
        f8073g = str;
    }

    @Deprecated
    public static void setKey(String[] strArr) {
        for (String str : strArr) {
            f8067a.add(str);
        }
    }

    @Deprecated
    public static void setSalary(c cVar) {
        if (cVar == null) {
            return;
        }
        i = cVar.a() + "";
    }

    @Deprecated
    public static void setSex(d dVar) {
        if (dVar == null) {
            return;
        }
        f8069c = dVar.a() + "";
    }

    public static void setSupportHttps(boolean z) {
        if (z) {
            j = b.HTTPS_PROTOCOL_TYPE.a() + "";
            return;
        }
        j = b.HTTP_PROTOCOL_TYPE.a() + "";
    }

    @Deprecated
    public static void setUserAttr(String str, String str2) {
        try {
            m.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    @Deprecated
    public static void setZip(String str) {
        f8072f = str;
    }

    @Deprecated
    public static void setHob(List<String> list) {
        k.addAll(list);
    }

    @Deprecated
    public static void setKey(List<String> list) {
        f8067a.addAll(list);
    }
}
