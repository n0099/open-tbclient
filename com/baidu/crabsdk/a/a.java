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
    static a amY = null;
    private long Z;
    private long aa;
    private long ab;
    private long amV;
    private StringBuilder amW = new StringBuilder();
    public ArrayList<String> amX = new ArrayList<>();

    private a() {
    }

    private String g() {
        Iterator<String> it = this.amX.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.baidu.crabsdk.c.a.v("===== stackEntry ===== \n" + next);
            this.amW.append(next);
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

    public static a uV() {
        if (amY == null) {
            synchronized (a.class) {
                if (amY == null) {
                    amY = new a();
                }
            }
        }
        return amY;
    }

    public final a a(long j, long j2, long j3, long j4) {
        this.amV = j2 - j;
        this.Z = j4 - j3;
        this.aa = j;
        this.ab = j2;
        return this;
    }

    public final Map<String, Object> uW() {
        HashMap hashMap = new HashMap();
        long j = this.aa;
        long j2 = this.ab;
        long j3 = this.amV;
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
        hashMap.put("errorTrace", this.amW.toString());
        hashMap.put("errorLine", g);
        hashMap.put("errorOriLine", g);
        this.amW.setLength(0);
        return hashMap;
    }
}
