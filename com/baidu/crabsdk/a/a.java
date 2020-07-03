package com.baidu.crabsdk.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public final class a {
    public static int W = 2000;
    public static int X = 1;
    static a alw = null;
    private long Y;
    private long Z;
    private long als;
    private long alt;
    private StringBuilder alu = new StringBuilder();
    public ArrayList<String> alv = new ArrayList<>();

    private a() {
    }

    private String g() {
        Iterator<String> it = this.alv.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.baidu.crabsdk.c.a.v("===== stackEntry ===== \n" + next);
            this.alu.append(next);
            String[] split = next.split("\r\n");
            if (split != null && split.length > 0) {
                for (String str : split) {
                    if (str != null && str.length() > 0 && Character.isLetter(str.charAt(0)) && !str.startsWith("com.baidu.crabsdk") && !str.startsWith("com.android") && !str.startsWith("java") && !str.startsWith("android") && !str.startsWith("libcore") && !str.startsWith("dalvik.system") && !str.startsWith("sun") && !str.startsWith("com.google.android") && !str.startsWith("Reflection")) {
                        return str;
                    }
                }
                continue;
            }
        }
        return "";
    }

    public static long i() {
        return W * 0.6f;
    }

    public static a sX() {
        if (alw == null) {
            synchronized (a.class) {
                if (alw == null) {
                    alw = new a();
                }
            }
        }
        return alw;
    }

    public final a a(long j, long j2, long j3, long j4) {
        this.Y = j2 - j;
        this.Z = j4 - j3;
        this.als = j;
        this.alt = j2;
        return this;
    }

    public final Map<String, Object> sY() {
        HashMap hashMap = new HashMap();
        long j = this.als;
        long j2 = this.alt;
        long j3 = this.Y;
        long j4 = this.Z;
        String g = g();
        if (TextUtils.isEmpty(g)) {
            return null;
        }
        hashMap.put("apiType", "BLOCK");
        hashMap.put("errorType", "BLOCK");
        hashMap.put("blockStartTime", Long.valueOf(j));
        hashMap.put("blockEndTime", Long.valueOf(j2));
        hashMap.put("blockCostTime", Long.valueOf(j3));
        hashMap.put("blockThreadTime", Long.valueOf(j4));
        hashMap.put("errorTrace", this.alu.toString());
        hashMap.put("errorLine", g);
        hashMap.put("errorOriLine", g);
        this.alu.setLength(0);
        return hashMap;
    }
}
