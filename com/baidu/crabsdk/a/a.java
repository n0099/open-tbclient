package com.baidu.crabsdk.a;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.SystemInfoUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {
    private long RI;
    private StringBuilder RJ = new StringBuilder();
    public ArrayList<String> RK = new ArrayList<>();
    private long V;
    private long W;
    private long X;
    public static int T = 2000;
    public static int U = 1;
    static a RL = null;

    private a() {
    }

    private String f() {
        Iterator<String> it = this.RK.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.baidu.crabsdk.c.a.cg("===== stackEntry ===== \n" + next);
            this.RJ.append(next);
            String[] split = next.split(SystemInfoUtil.LINE_END);
            if (split != null && split.length > 0) {
                for (String str : split) {
                    if (str != null && str.length() > 0 && Character.isLetter(str.charAt(0)) && !str.startsWith("com.baidu.crabsdk") && !str.startsWith("com.android") && !str.startsWith("java") && !str.startsWith(HttpConstants.OS_TYPE_VALUE) && !str.startsWith("libcore") && !str.startsWith("dalvik.system") && !str.startsWith("sun") && !str.startsWith("com.google.android") && !str.startsWith("Reflection")) {
                        return str;
                    }
                }
                continue;
            }
        }
        return "";
    }

    public static long h() {
        return T * 0.6f;
    }

    public static a oV() {
        if (RL == null) {
            synchronized (a.class) {
                if (RL == null) {
                    RL = new a();
                }
            }
        }
        return RL;
    }

    public final a a(long j, long j2, long j3, long j4) {
        this.V = j2 - j;
        this.W = j4 - j3;
        this.X = j;
        this.RI = j2;
        return this;
    }

    public final Map<String, Object> g() {
        HashMap hashMap = new HashMap();
        long j = this.X;
        long j2 = this.RI;
        long j3 = this.V;
        long j4 = this.W;
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
        hashMap.put("errorTrace", this.RJ.toString());
        hashMap.put("errorLine", f);
        hashMap.put("errorOriLine", f);
        this.RJ.setLength(0);
        return hashMap;
    }
}
