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
    public static final au f8595a = new au();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f8596b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Character, Integer> f8597c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f8598d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Character, Integer> f8599e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f8600f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Character, Integer> f8601g = new HashMap<>();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f8603a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f8604b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f8605c = 2;
    }

    public static au a() {
        return f8595a;
    }

    public void b(int i2) {
        if (i2 == a.f8603a) {
            this.f8597c.clear();
            this.f8596b.clear();
        } else if (i2 == a.f8605c) {
            this.f8601g.clear();
            this.f8600f.clear();
        } else {
            this.f8599e.clear();
            this.f8598d.clear();
        }
    }

    public String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 == a.f8603a) {
            String str2 = this.f8596b.get(str);
            if (TextUtils.isEmpty(str2)) {
                a(str, this.f8597c, this.f8596b);
                return this.f8596b.get(str);
            }
            return str2;
        } else if (i2 == a.f8605c) {
            String str3 = this.f8600f.get(str);
            if (TextUtils.isEmpty(str3)) {
                a(str, this.f8601g, this.f8600f);
                return this.f8600f.get(str);
            }
            return str3;
        } else {
            String str4 = this.f8598d.get(str);
            if (TextUtils.isEmpty(str4)) {
                a(str, this.f8599e, this.f8598d);
                return this.f8598d.get(str);
            }
            return str4;
        }
    }

    public void b() {
        b(a.f8603a);
        b(a.f8605c);
        b(a.f8604b);
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
        if (i2 == a.f8603a) {
            hashMap = this.f8596b;
        } else if (i2 == a.f8605c) {
            hashMap = this.f8600f;
        } else {
            hashMap = this.f8598d;
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
