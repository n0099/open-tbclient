package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    private static Long cnX = 0L;
    private static Long cnY = 0L;

    public static final void E() {
        Long l = cnY;
        if (l != null) {
            if (l == null) {
                p.eLu();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = cnY;
                    if (l2 == null) {
                        p.eLu();
                    }
                    jSONObject.put("3", l2.longValue());
                    jSONObject.put("4", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").az(jSONObject));
                cnY = 0L;
            }
        }
    }

    public static final void F() {
        Long l = cnX;
        if (l != null) {
            if (l == null) {
                p.eLu();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = cnX;
                    if (l2 == null) {
                        p.eLu();
                    }
                    jSONObject.put("1", l2.longValue());
                    jSONObject.put("2", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").az(jSONObject));
                cnX = 0L;
            }
        }
    }

    public static final void a(Long l) {
        cnX = l;
    }

    public static final void d(Long l) {
        cnY = l;
    }

    public static final void i(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 1);
        } catch (Exception e) {
        }
        d.a(new b(str).az(jSONObject));
    }

    public static final void j(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 0);
        } catch (Exception e) {
        }
        d.a(new b(str).az(jSONObject));
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
        d.a(new b(str).az(jSONObject));
    }
}
