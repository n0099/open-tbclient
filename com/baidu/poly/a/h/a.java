package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    private static Long bHM = 0L;
    private static Long bHN = 0L;

    public static final void E() {
        Long l = bHN;
        if (l != null) {
            if (l == null) {
                q.ekp();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = bHN;
                    if (l2 == null) {
                        q.ekp();
                    }
                    jSONObject.put("3", l2.longValue());
                    jSONObject.put("4", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").ah(jSONObject));
                bHN = 0L;
            }
        }
    }

    public static final void F() {
        Long l = bHM;
        if (l != null) {
            if (l == null) {
                q.ekp();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = bHM;
                    if (l2 == null) {
                        q.ekp();
                    }
                    jSONObject.put("1", l2.longValue());
                    jSONObject.put("2", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").ah(jSONObject));
                bHM = 0L;
            }
        }
    }

    public static final void a(Long l) {
        bHM = l;
    }

    public static final void c(Long l) {
        bHN = l;
    }

    public static final void i(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 1);
        } catch (Exception e) {
        }
        d.a(new b(str).ah(jSONObject));
    }

    public static final void j(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 0);
        } catch (Exception e) {
        }
        d.a(new b(str).ah(jSONObject));
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
        d.a(new b(str).ah(jSONObject));
    }
}
