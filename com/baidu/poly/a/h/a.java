package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public final class a {
    private static Long cht = 0L;
    private static Long chu = 0L;

    public static final void E() {
        Long l = chu;
        if (l != null) {
            if (l == null) {
                p.eDZ();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = chu;
                    if (l2 == null) {
                        p.eDZ();
                    }
                    jSONObject.put("3", l2.longValue());
                    jSONObject.put("4", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").ap(jSONObject));
                chu = 0L;
            }
        }
    }

    public static final void F() {
        Long l = cht;
        if (l != null) {
            if (l == null) {
                p.eDZ();
            }
            if (l.longValue() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Long l2 = cht;
                    if (l2 == null) {
                        p.eDZ();
                    }
                    jSONObject.put("1", l2.longValue());
                    jSONObject.put("2", System.currentTimeMillis());
                } catch (Exception e) {
                }
                d.a(new b("1000").ap(jSONObject));
                cht = 0L;
            }
        }
    }

    public static final void a(Long l) {
        cht = l;
    }

    public static final void d(Long l) {
        chu = l;
    }

    public static final void i(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 1);
        } catch (Exception e) {
        }
        d.a(new b(str).ap(jSONObject));
    }

    public static final void j(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionCode", 0);
        } catch (Exception e) {
        }
        d.a(new b(str).ap(jSONObject));
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
        d.a(new b(str).ap(jSONObject));
    }
}
