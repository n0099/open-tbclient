package com.baidu.pass.face.platform.a;

import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static final String a = "a";
    public static HashMap<String, Object> b = new HashMap<>();
    public static ArrayList<Integer> c = new ArrayList<>();
    public static HashMap<String, Integer> d = new HashMap<>();

    public static void a() {
    }

    public static void a(String str) {
        HashMap<String, Integer> hashMap = d;
        if (hashMap != null && !hashMap.containsKey(str)) {
            d.put(str, 1);
            return;
        }
        HashMap<String, Integer> hashMap2 = d;
        if (hashMap2 == null || !hashMap2.containsKey(str)) {
            return;
        }
        d.put(str, Integer.valueOf(d.get(str).intValue() + 1));
    }

    public static void a(String str, Object obj) {
        HashMap<String, Object> hashMap = b;
        if (hashMap == null || hashMap.containsKey(str)) {
            return;
        }
        b.put(str, obj);
    }

    public static void b() {
        b = new HashMap<>();
        c = new ArrayList<>();
        d = new HashMap<>();
    }

    public static void b(String str, Object obj) {
        HashMap<String, Object> hashMap = b;
        if (hashMap != null) {
            hashMap.put(str, obj);
        }
    }
}
