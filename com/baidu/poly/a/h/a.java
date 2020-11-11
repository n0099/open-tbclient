package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {
    private static Long ccD = 0L;
    private static Long ccE = 0L;

    public static final void E() {
        Long l = ccE;
        if (l != null) {
            if (l == null) {
                q.eBP();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = ccE;
                    if (l2 == null) {
                        q.eBP();
                    }
                    jSONObject.put("3", l2.longValue());
                    jSONObject.put("4", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").at(jSONObject));
                ccE = 0L;
            }
        }
    }

    public static final void F() {
        Long l = ccD;
        if (l != null) {
            if (l == null) {
                q.eBP();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = ccD;
                    if (l2 == null) {
                        q.eBP();
                    }
                    jSONObject.put("1", l2.longValue());
                    jSONObject.put("2", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").at(jSONObject));
                ccD = 0L;
            }
        }
    }

    public static final void a(Long l) {
        ccD = l;
    }

    public static final void d(Long l) {
        ccE = l;
    }

    public static final void i(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 1);
        } catch (Exception e) {
        }
        d.a(new b(str).at(jSONObject));
    }

    public static final void j(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 0);
        } catch (Exception e) {
        }
        d.a(new b(str).at(jSONObject));
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
        d.a(new b(str).at(jSONObject));
    }
}
