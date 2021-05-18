package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    public static final au f8695a = new au();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f8696b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Character, Integer> f8697c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f8698d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Character, Integer> f8699e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f8700f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Character, Integer> f8701g = new HashMap<>();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f8703a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f8704b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f8705c = 2;
    }

    public static au a() {
        return f8695a;
    }

    public void b(int i2) {
        if (i2 == a.f8703a) {
            this.f8697c.clear();
            this.f8696b.clear();
        } else if (i2 == a.f8705c) {
            this.f8701g.clear();
            this.f8700f.clear();
        } else {
            this.f8699e.clear();
            this.f8698d.clear();
        }
    }

    public String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 == a.f8703a) {
            String str2 = this.f8696b.get(str);
            if (TextUtils.isEmpty(str2)) {
                a(str, this.f8697c, this.f8696b);
                return this.f8696b.get(str);
            }
            return str2;
        } else if (i2 == a.f8705c) {
            String str3 = this.f8700f.get(str);
            if (TextUtils.isEmpty(str3)) {
                a(str, this.f8701g, this.f8700f);
                return this.f8700f.get(str);
            }
            return str3;
        } else {
            String str4 = this.f8698d.get(str);
            if (TextUtils.isEmpty(str4)) {
                a(str, this.f8699e, this.f8698d);
                return this.f8698d.get(str);
            }
            return str4;
        }
    }

    public void b() {
        b(a.f8703a);
        b(a.f8705c);
        b(a.f8704b);
    }

    private void a(String str, HashMap<Character, Integer> hashMap, HashMap<String, String> hashMap2) {
        char lowerCase = Character.toLowerCase(str.charAt(0));
        Integer num = hashMap.get(Character.valueOf(lowerCase));
        int intValue = num != null ? num.intValue() + 1 : 0;
        hashMap.put(Character.valueOf(lowerCase), Integer.valueOf(intValue));
        hashMap2.put(str, Character.toString(lowerCase) + intValue);
    }

    public JSONObject a(int i2) {
        HashMap<String, String> hashMap;
        if (i2 == a.f8703a) {
            hashMap = this.f8696b;
        } else if (i2 == a.f8705c) {
            hashMap = this.f8700f;
        } else {
            hashMap = this.f8698d;
        }
        JSONObject jSONObject = new JSONObject();
        if (hashMap == null) {
            return jSONObject;
        }
        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
        try {
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.baidu.mobstat.au.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    return entry.getValue().compareTo(entry2.getValue());
                }
            });
        } catch (Exception unused) {
        }
        for (Map.Entry entry : arrayList) {
            try {
                jSONObject.put((String) entry.getValue(), (String) entry.getKey());
            } catch (Exception unused2) {
            }
        }
        return jSONObject;
    }
}
