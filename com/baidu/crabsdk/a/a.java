package com.baidu.crabsdk.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public final class a {
    public static int W = 2000;
    public static int X = 1;
    static a amu = null;
    private long Z;
    private long aa;
    private long ab;
    private long amr;
    private StringBuilder ams = new StringBuilder();
    public ArrayList<String> amt = new ArrayList<>();

    private a() {
    }

    private String g() {
        Iterator<String> it = this.amt.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.baidu.crabsdk.c.a.v("===== stackEntry ===== \n" + next);
            this.ams.append(next);
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

    public static a uH() {
        if (amu == null) {
            synchronized (a.class) {
                if (amu == null) {
                    amu = new a();
                }
            }
        }
        return amu;
    }

    public final a a(long j, long j2, long j3, long j4) {
        this.amr = j2 - j;
        this.Z = j4 - j3;
        this.aa = j;
        this.ab = j2;
        return this;
    }

    public final Map<String, Object> uI() {
        HashMap hashMap = new HashMap();
        long j = this.aa;
        long j2 = this.ab;
        long j3 = this.amr;
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
        hashMap.put("errorTrace", this.ams.toString());
        hashMap.put("errorLine", g);
        hashMap.put("errorOriLine", g);
        this.ams.setLength(0);
        return hashMap;
    }
}
