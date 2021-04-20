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
    public static final au f8577a = new au();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f8578b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Character, Integer> f8579c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f8580d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Character, Integer> f8581e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f8582f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Character, Integer> f8583g = new HashMap<>();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f8585a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f8586b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f8587c = 2;
    }

    public static au a() {
        return f8577a;
    }

    public void b(int i) {
        if (i == a.f8585a) {
            this.f8579c.clear();
            this.f8578b.clear();
        } else if (i == a.f8587c) {
            this.f8583g.clear();
            this.f8582f.clear();
        } else {
            this.f8581e.clear();
            this.f8580d.clear();
        }
    }

    public String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == a.f8585a) {
            String str2 = this.f8578b.get(str);
            if (TextUtils.isEmpty(str2)) {
                a(str, this.f8579c, this.f8578b);
                return this.f8578b.get(str);
            }
            return str2;
        } else if (i == a.f8587c) {
            String str3 = this.f8582f.get(str);
            if (TextUtils.isEmpty(str3)) {
                a(str, this.f8583g, this.f8582f);
                return this.f8582f.get(str);
            }
            return str3;
        } else {
            String str4 = this.f8580d.get(str);
            if (TextUtils.isEmpty(str4)) {
                a(str, this.f8581e, this.f8580d);
                return this.f8580d.get(str);
            }
            return str4;
        }
    }

    public void b() {
        b(a.f8585a);
        b(a.f8587c);
        b(a.f8586b);
    }

    private void a(String str, HashMap<Character, Integer> hashMap, HashMap<String, String> hashMap2) {
        char lowerCase = Character.toLowerCase(str.charAt(0));
        Integer num = hashMap.get(Character.valueOf(lowerCase));
        int intValue = num != null ? num.intValue() + 1 : 0;
        hashMap.put(Character.valueOf(lowerCase), Integer.valueOf(intValue));
        hashMap2.put(str, Character.toString(lowerCase) + intValue);
    }

    public JSONObject a(int i) {
        HashMap<String, String> hashMap;
        if (i == a.f8585a) {
            hashMap = this.f8578b;
        } else if (i == a.f8587c) {
            hashMap = this.f8582f;
        } else {
            hashMap = this.f8580d;
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
