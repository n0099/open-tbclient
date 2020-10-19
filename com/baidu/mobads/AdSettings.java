package com.baidu.mobads;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdSettings {
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;

    /* renamed from: a  reason: collision with root package name */
    private static HashSet<String> f2288a = new HashSet<>();
    private static JSONArray b = new JSONArray();
    private static String j = b.HTTP_PROTOCOL_TYPE.a() + "";
    private static HashSet<String> k = new HashSet<>();
    private static JSONArray l = new JSONArray();
    private static JSONObject m = new JSONObject();

    public static void setSupportHttps(boolean z) {
        if (z) {
            j = b.HTTPS_PROTOCOL_TYPE.a() + "";
        } else {
            j = b.HTTP_PROTOCOL_TYPE.a() + "";
        }
    }

    public static String getSupportHttps() {
        return j;
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public enum b {
        UNKNOWN_PROTOCOL_TYPE(0),
        HTTP_PROTOCOL_TYPE(1),
        HTTPS_PROTOCOL_TYPE(2);
        
        private int d;

        b(int i) {
            this.d = i;
        }

        public String a() {
            return this.d + "";
        }
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public enum d {
        MALE(0),
        FEMALE(1);
        
        private int c;

        d(int i) {
            this.c = i;
        }

        public int a() {
            return this.c;
        }
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public enum a {
        PRIMARY(0),
        JUNIOR(1),
        SENIOR(2),
        SPECIALTY(3),
        BACHELOR(4),
        MASTER(5),
        DOCTOR(6);
        
        private int h;

        a(int i2) {
            this.h = i2;
        }

        public int a() {
            return this.h;
        }
    }

    @Deprecated
    /* loaded from: classes7.dex */
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
        
        private int n;

        c(int i) {
            this.n = i;
        }

        public int a() {
            return this.n;
        }
    }

    public static JSONObject getAttr() {
        JSONObject jSONObject = new JSONObject();
        Iterator<String> it = f2288a.iterator();
        b = new JSONArray();
        while (it.hasNext()) {
            b.put(it.next());
        }
        try {
            jSONObject.putOpt("KEY", b);
            jSONObject.putOpt("RPT", j);
        } catch (Exception e2) {
        }
        return jSONObject;
    }

    @Deprecated
    public static void setKey(String[] strArr) {
        for (String str : strArr) {
            f2288a.add(str);
        }
    }

    @Deprecated
    public static void setKey(List<String> list) {
        f2288a.addAll(list);
    }

    @Deprecated
    public static void setSex(d dVar) {
        if (dVar != null) {
            c = dVar.a() + "";
        }
    }

    @Deprecated
    public static void setBirthday(Calendar calendar) {
        if (calendar != null) {
            int i2 = calendar.get(1);
            int i3 = calendar.get(2) + 1;
            int i4 = calendar.get(5);
            d = i2 + "";
            if (i3 > 0 && i3 < 10) {
                d += "0" + i3;
            } else {
                d += i3;
            }
            if (i4 > 0 && i4 < 10) {
                d += "0" + i4;
            } else {
                d += i4;
            }
        }
    }

    @Deprecated
    public static void setCity(String str) {
        e = str;
    }

    @Deprecated
    public static void setZip(String str) {
        f = str;
    }

    @Deprecated
    public static void setJob(String str) {
        g = str;
    }

    @Deprecated
    public static void setEducation(a aVar) {
        if (aVar != null) {
            h = aVar.a() + "";
        }
    }

    @Deprecated
    public static void setSalary(c cVar) {
        if (cVar != null) {
            i = cVar.a() + "";
        }
    }

    @Deprecated
    public static void setHob(String[] strArr) {
        for (String str : strArr) {
            k.add(str);
        }
    }

    @Deprecated
    public static void setHob(List<String> list) {
        k.addAll(list);
    }

    @Deprecated
    public static void setUserAttr(String str, String str2) {
        try {
            m.put(str, str2);
        } catch (JSONException e2) {
        }
    }
}
