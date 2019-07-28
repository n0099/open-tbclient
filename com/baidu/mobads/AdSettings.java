package com.baidu.mobads;

import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdSettings {
    private static HashSet<String> agi = new HashSet<>();
    private static JSONArray b = new JSONArray();
    private static String j = b.HTTP_PROTOCOL_TYPE.a() + "";
    private static HashSet<String> agj = new HashSet<>();
    private static JSONArray agk = new JSONArray();
    private static JSONObject m = new JSONObject();

    public static String uo() {
        return j;
    }

    @Deprecated
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
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

    public static JSONObject up() {
        JSONObject jSONObject = new JSONObject();
        Iterator<String> it = agi.iterator();
        b = new JSONArray();
        while (it.hasNext()) {
            b.put(it.next());
        }
        try {
            jSONObject.putOpt("KEY", b);
            jSONObject.putOpt("RPT", j);
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
