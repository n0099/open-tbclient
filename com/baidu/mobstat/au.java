package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private static final au f3747a = new au();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, String> f3748b = new HashMap<>();
    private HashMap<Character, Integer> c = new HashMap<>();
    private HashMap<String, String> d = new HashMap<>();
    private HashMap<Character, Integer> e = new HashMap<>();
    private HashMap<String, String> f = new HashMap<>();
    private HashMap<Character, Integer> g = new HashMap<>();

    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f3750a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f3751b = 1;
        public static int c = 2;
    }

    public static au a() {
        return f3747a;
    }

    public String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == a.f3750a) {
            String str2 = this.f3748b.get(str);
            if (TextUtils.isEmpty(str2)) {
                a(str, this.c, this.f3748b);
                return this.f3748b.get(str);
            }
            return str2;
        } else if (i == a.c) {
            String str3 = this.f.get(str);
            if (TextUtils.isEmpty(str3)) {
                a(str, this.g, this.f);
                return this.f.get(str);
            }
            return str3;
        } else {
            String str4 = this.d.get(str);
            if (TextUtils.isEmpty(str4)) {
                a(str, this.e, this.d);
                return this.d.get(str);
            }
            return str4;
        }
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
        if (i == a.f3750a) {
            hashMap = this.f3748b;
        } else if (i == a.c) {
            hashMap = this.f;
        } else {
            hashMap = this.d;
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
        } catch (Exception e) {
        }
        for (Map.Entry entry : arrayList) {
            try {
                jSONObject.put((String) entry.getValue(), (String) entry.getKey());
            } catch (Exception e2) {
            }
        }
        return jSONObject;
    }

    public void b(int i) {
        if (i == a.f3750a) {
            this.c.clear();
            this.f3748b.clear();
        } else if (i == a.c) {
            this.g.clear();
            this.f.clear();
        } else {
            this.e.clear();
            this.d.clear();
        }
    }

    public void b() {
        b(a.f3750a);
        b(a.c);
        b(a.f3751b);
    }
}
