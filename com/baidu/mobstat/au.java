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
    public static final au f9003a = new au();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f9004b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Character, Integer> f9005c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f9006d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Character, Integer> f9007e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f9008f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Character, Integer> f9009g = new HashMap<>();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f9011a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f9012b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f9013c = 2;
    }

    public static au a() {
        return f9003a;
    }

    public void b(int i) {
        if (i == a.f9011a) {
            this.f9005c.clear();
            this.f9004b.clear();
        } else if (i == a.f9013c) {
            this.f9009g.clear();
            this.f9008f.clear();
        } else {
            this.f9007e.clear();
            this.f9006d.clear();
        }
    }

    public String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == a.f9011a) {
            String str2 = this.f9004b.get(str);
            if (TextUtils.isEmpty(str2)) {
                a(str, this.f9005c, this.f9004b);
                return this.f9004b.get(str);
            }
            return str2;
        } else if (i == a.f9013c) {
            String str3 = this.f9008f.get(str);
            if (TextUtils.isEmpty(str3)) {
                a(str, this.f9009g, this.f9008f);
                return this.f9008f.get(str);
            }
            return str3;
        } else {
            String str4 = this.f9006d.get(str);
            if (TextUtils.isEmpty(str4)) {
                a(str, this.f9007e, this.f9006d);
                return this.f9006d.get(str);
            }
            return str4;
        }
    }

    public void b() {
        b(a.f9011a);
        b(a.f9013c);
        b(a.f9012b);
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
        if (i == a.f9011a) {
            hashMap = this.f9004b;
        } else if (i == a.f9013c) {
            hashMap = this.f9008f;
        } else {
            hashMap = this.f9006d;
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
