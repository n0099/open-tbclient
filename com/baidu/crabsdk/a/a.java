package com.baidu.crabsdk.a;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.searchbox.ng.ai.apps.statistic.search.AiAppsSearchFlowUBC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public final class a {
    public static int U = 2000;
    public static int V = 1;
    static a Xh = null;
    private long W;
    private long X;
    private long Xe;
    private StringBuilder Xf = new StringBuilder();
    public ArrayList<String> Xg = new ArrayList<>();
    private long Z;

    private a() {
    }

    private String f() {
        Iterator<String> it = this.Xg.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.baidu.crabsdk.c.a.cI("===== stackEntry ===== \n" + next);
            this.Xf.append(next);
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
        return U * 0.6f;
    }

    public static a rg() {
        if (Xh == null) {
            synchronized (a.class) {
                if (Xh == null) {
                    Xh = new a();
                }
            }
        }
        return Xh;
    }

    public final a a(long j, long j2, long j3, long j4) {
        this.W = j2 - j;
        this.X = j4 - j3;
        this.Xe = j;
        this.Z = j2;
        return this;
    }

    public final Map<String, Object> g() {
        HashMap hashMap = new HashMap();
        long j = this.Xe;
        long j2 = this.Z;
        long j3 = this.W;
        long j4 = this.X;
        String f = f();
        if (TextUtils.isEmpty(f)) {
            return null;
        }
        hashMap.put("apiType", "BLOCK");
        hashMap.put(AiAppsSearchFlowUBC.FE_DATA_ERRTYPE, "BLOCK");
        hashMap.put("blockStartTime", Long.valueOf(j));
        hashMap.put("blockEndTime", Long.valueOf(j2));
        hashMap.put("blockCostTime", Long.valueOf(j3));
        hashMap.put("blockThreadTime", Long.valueOf(j4));
        hashMap.put("errorTrace", this.Xf.toString());
        hashMap.put("errorLine", f);
        hashMap.put("errorOriLine", f);
        this.Xf.setLength(0);
        return hashMap;
    }
}
