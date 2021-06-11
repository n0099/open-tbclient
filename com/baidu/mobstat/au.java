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
    public static final au f8657a = new au();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f8658b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Character, Integer> f8659c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f8660d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Character, Integer> f8661e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f8662f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Character, Integer> f8663g = new HashMap<>();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f8665a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f8666b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f8667c = 2;
    }

    public static au a() {
        return f8657a;
    }

    public void b(int i2) {
        if (i2 == a.f8665a) {
            this.f8659c.clear();
            this.f8658b.clear();
        } else if (i2 == a.f8667c) {
            this.f8663g.clear();
            this.f8662f.clear();
        } else {
            this.f8661e.clear();
            this.f8660d.clear();
        }
    }

    public String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 == a.f8665a) {
            String str2 = this.f8658b.get(str);
            if (TextUtils.isEmpty(str2)) {
                a(str, this.f8659c, this.f8658b);
                return this.f8658b.get(str);
            }
            return str2;
        } else if (i2 == a.f8667c) {
            String str3 = this.f8662f.get(str);
            if (TextUtils.isEmpty(str3)) {
                a(str, this.f8663g, this.f8662f);
                return this.f8662f.get(str);
            }
            return str3;
        } else {
            String str4 = this.f8660d.get(str);
            if (TextUtils.isEmpty(str4)) {
                a(str, this.f8661e, this.f8660d);
                return this.f8660d.get(str);
            }
            return str4;
        }
    }

    public void b() {
        b(a.f8665a);
        b(a.f8667c);
        b(a.f8666b);
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
        if (i2 == a.f8665a) {
            hashMap = this.f8658b;
        } else if (i2 == a.f8667c) {
            hashMap = this.f8662f;
        } else {
            hashMap = this.f8660d;
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
