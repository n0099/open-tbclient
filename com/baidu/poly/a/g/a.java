package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static Long buX = 0L;
    private static Long buY = 0L;

    public static final void a(Long l) {
        buX = l;
    }

    public static final void c(Long l) {
        buY = l;
    }

    public static final void h(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 1);
        } catch (Exception e) {
        }
        d.a(new b(str).U(jSONObject));
    }

    public static final void i(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 0);
        } catch (Exception e) {
        }
        d.a(new b(str).U(jSONObject));
    }

    public static final void u() {
        Long l = buY;
        if (l != null) {
            if (l == null) {
                q.dLM();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = buY;
                    if (l2 == null) {
                        q.dLM();
                    }
                    jSONObject.put("3", l2.longValue());
                    jSONObject.put("4", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").U(jSONObject));
                buY = 0L;
            }
        }
    }

    public static final void w() {
        Long l = buX;
        if (l != null) {
            if (l == null) {
                q.dLM();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = buX;
                    if (l2 == null) {
                        q.dLM();
                    }
                    jSONObject.put("1", l2.longValue());
                    jSONObject.put("2", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").U(jSONObject));
                buX = 0L;
            }
        }
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
        d.a(new b(str).U(jSONObject));
    }
}
