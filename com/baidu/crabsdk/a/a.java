package com.baidu.crabsdk.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {
    public static int U = 2000;
    public static int V = 1;
    static a aaQ = null;
    private long W;
    private long X;
    private long Y;
    private long Z;
    private StringBuilder aaO = new StringBuilder();
    public ArrayList<String> aaP = new ArrayList<>();

    private a() {
    }

    private String f() {
        Iterator<String> it = this.aaP.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.baidu.crabsdk.c.a.cx("===== stackEntry ===== \n" + next);
            this.aaO.append(next);
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

    public static long h() {
        return U * 0.6f;
    }

    public static a rJ() {
        if (aaQ == null) {
            synchronized (a.class) {
                if (aaQ == null) {
                    aaQ = new a();
                }
            }
        }
        return aaQ;
    }

    public final a a(long j, long j2, long j3, long j4) {
        this.W = j2 - j;
        this.X = j4 - j3;
        this.Y = j;
        this.Z = j2;
        return this;
    }

    public final Map<String, Object> g() {
        HashMap hashMap = new HashMap();
        long j = this.Y;
        long j2 = this.Z;
        long j3 = this.W;
        long j4 = this.X;
        String f = f();
        if (TextUtils.isEmpty(f)) {
            return null;
        }
        hashMap.put("apiType", "BLOCK");
        hashMap.put("errorType", "BLOCK");
        hashMap.put("blockStartTime", Long.valueOf(j));
        hashMap.put("blockEndTime", Long.valueOf(j2));
        hashMap.put("blockCostTime", Long.valueOf(j3));
        hashMap.put("blockThreadTime", Long.valueOf(j4));
        hashMap.put("errorTrace", this.aaO.toString());
        hashMap.put("errorLine", f);
        hashMap.put("errorOriLine", f);
        this.aaO.setLength(0);
        return hashMap;
    }
}
