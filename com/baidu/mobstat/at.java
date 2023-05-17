package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class at {
    public static final at a = new at();
    public HashMap<String, String> b = new HashMap<>();
    public HashMap<Character, Integer> c = new HashMap<>();
    public HashMap<String, String> d = new HashMap<>();
    public HashMap<Character, Integer> e = new HashMap<>();
    public HashMap<String, String> f = new HashMap<>();
    public HashMap<Character, Integer> g = new HashMap<>();

    /* loaded from: classes3.dex */
    public static class a {
        public static int a = 0;
        public static int b = 1;
        public static int c = 2;
    }

    public static at a() {
        return a;
    }

    public void b() {
        b(a.a);
        b(a.c);
        b(a.b);
    }

    private void a(String str, HashMap<Character, Integer> hashMap, HashMap<String, String> hashMap2) {
        int i = 0;
        char lowerCase = Character.toLowerCase(str.charAt(0));
        Integer num = hashMap.get(Character.valueOf(lowerCase));
        if (num != null) {
            i = num.intValue() + 1;
        }
        hashMap.put(Character.valueOf(lowerCase), Integer.valueOf(i));
        hashMap2.put(str, Character.toString(lowerCase) + i);
    }

    public String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == a.a) {
            String str2 = this.b.get(str);
            if (TextUtils.isEmpty(str2)) {
                a(str, this.c, this.b);
                return this.b.get(str);
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

    public JSONObject a(int i) {
        HashMap<String, String> hashMap;
        if (i == a.a) {
            hashMap = this.b;
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
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.baidu.mobstat.at.1
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

    public void b(int i) {
        if (i == a.a) {
            this.c.clear();
            this.b.clear();
        } else if (i == a.c) {
            this.g.clear();
            this.f.clear();
        } else {
            this.e.clear();
            this.d.clear();
        }
    }
}
