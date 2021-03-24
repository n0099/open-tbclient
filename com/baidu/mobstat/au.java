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
    public static final au f9002a = new au();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f9003b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Character, Integer> f9004c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f9005d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Character, Integer> f9006e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f9007f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Character, Integer> f9008g = new HashMap<>();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f9010a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f9011b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f9012c = 2;
    }

    public static au a() {
        return f9002a;
    }

    public void b(int i) {
        if (i == a.f9010a) {
            this.f9004c.clear();
            this.f9003b.clear();
        } else if (i == a.f9012c) {
            this.f9008g.clear();
            this.f9007f.clear();
        } else {
            this.f9006e.clear();
            this.f9005d.clear();
        }
    }

    public String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == a.f9010a) {
            String str2 = this.f9003b.get(str);
            if (TextUtils.isEmpty(str2)) {
                a(str, this.f9004c, this.f9003b);
                return this.f9003b.get(str);
            }
            return str2;
        } else if (i == a.f9012c) {
            String str3 = this.f9007f.get(str);
            if (TextUtils.isEmpty(str3)) {
                a(str, this.f9008g, this.f9007f);
                return this.f9007f.get(str);
            }
            return str3;
        } else {
            String str4 = this.f9005d.get(str);
            if (TextUtils.isEmpty(str4)) {
                a(str, this.f9006e, this.f9005d);
                return this.f9005d.get(str);
            }
            return str4;
        }
    }

    public void b() {
        b(a.f9010a);
        b(a.f9012c);
        b(a.f9011b);
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
        if (i == a.f9010a) {
            hashMap = this.f9003b;
        } else if (i == a.f9012c) {
            hashMap = this.f9007f;
        } else {
            hashMap = this.f9005d;
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
