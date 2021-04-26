package com.baidu.crabsdk.a;

import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static int f4788g = 2000;

    /* renamed from: h  reason: collision with root package name */
    public static int f4789h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static a f4790i;

    /* renamed from: a  reason: collision with root package name */
    public long f4791a;

    /* renamed from: b  reason: collision with root package name */
    public long f4792b;

    /* renamed from: c  reason: collision with root package name */
    public long f4793c;

    /* renamed from: d  reason: collision with root package name */
    public long f4794d;

    /* renamed from: e  reason: collision with root package name */
    public StringBuilder f4795e = new StringBuilder();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f4796f = new ArrayList<>();

    public static a b() {
        if (f4790i == null) {
            synchronized (a.class) {
                if (f4790i == null) {
                    f4790i = new a();
                }
            }
        }
        return f4790i;
    }

    public static long e() {
        return f4788g * 0.6f;
    }

    public final a a(long j, long j2, long j3, long j4) {
        this.f4791a = j2 - j;
        this.f4792b = j4 - j3;
        this.f4793c = j;
        this.f4794d = j2;
        return this;
    }

    public final String c() {
        Iterator<String> it = this.f4796f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.baidu.crabsdk.c.a.c("===== stackEntry ===== \n" + next);
            this.f4795e.append(next);
            String[] split = next.split(Part.CRLF);
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

    public final Map<String, Object> d() {
        HashMap hashMap = new HashMap();
        long j = this.f4793c;
        long j2 = this.f4794d;
        long j3 = this.f4791a;
        long j4 = this.f4792b;
        String c2 = c();
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        hashMap.put("apiType", "BLOCK");
        hashMap.put("errorType", "BLOCK");
        hashMap.put("blockStartTime", Long.valueOf(j));
        hashMap.put("blockEndTime", Long.valueOf(j2));
        hashMap.put("blockCostTime", Long.valueOf(j3));
        hashMap.put("blockThreadTime", Long.valueOf(j4));
        hashMap.put("errorTrace", this.f4795e.toString());
        hashMap.put("errorLine", c2);
        hashMap.put("errorOriLine", c2);
        this.f4795e.setLength(0);
        return hashMap;
    }
}
