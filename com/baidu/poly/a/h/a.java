package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class a {
    private static Long cpA = 0L;
    private static Long cpB = 0L;

    public static final void E() {
        Long l = cpB;
        if (l != null) {
            if (l == null) {
                p.eLc();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = cpB;
                    if (l2 == null) {
                        p.eLc();
                    }
                    jSONObject.put("3", l2.longValue());
                    jSONObject.put("4", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").aB(jSONObject));
                cpB = 0L;
            }
        }
    }

    public static final void F() {
        Long l = cpA;
        if (l != null) {
            if (l == null) {
                p.eLc();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = cpA;
                    if (l2 == null) {
                        p.eLc();
                    }
                    jSONObject.put("1", l2.longValue());
                    jSONObject.put("2", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").aB(jSONObject));
                cpA = 0L;
            }
        }
    }

    public static final void a(Long l) {
        cpA = l;
    }

    public static final void d(Long l) {
        cpB = l;
    }

    public static final void i(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 1);
        } catch (Exception e) {
        }
        d.a(new b(str).aB(jSONObject));
    }

    public static final void j(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 0);
        } catch (Exception e) {
        }
        d.a(new b(str).aB(jSONObject));
    }

    public static final void a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(BaseJsonData.TAG_ERRNO, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(BaseJsonData.TAG_ERRMSG, str3);
            }
        } catch (Exception e) {
        }
        d.a(new b(str).aB(jSONObject));
    }
}
