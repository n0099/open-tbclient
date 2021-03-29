package com.baidu.sofire.rp;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.e;
import com.baidu.sofire.g.d;
import com.baidu.sofire.g.r;
/* loaded from: classes2.dex */
public final class a {
    public static String a(Context context) {
        e eVar;
        String o;
        String str = "";
        try {
            eVar = new e(context);
            if (!TextUtils.isEmpty(eVar.f11730b.getString("rpiiem", ""))) {
                eVar.f11732d.putString("rpiiem", "");
                eVar.f11732d.commit();
            }
            o = eVar.o();
        } catch (Throwable unused) {
        }
        try {
            if (TextUtils.isEmpty(o)) {
                o = r.h(context);
                if (!TextUtils.isEmpty(o)) {
                    if (TextUtils.isEmpty(o)) {
                        eVar.f11732d.putString("rpiiemn", "");
                        eVar.f11732d.commit();
                    } else {
                        eVar.f11732d.putString("rpiiemn", new String(Base64.encode(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), o.getBytes("UTF-8")), 10), "UTF-8"));
                        eVar.f11732d.commit();
                    }
                }
            }
            return o;
        } catch (Throwable unused2) {
            str = o;
            d.a();
            return str;
        }
    }

    public static String b(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.f11730b.getString("rpandid", "");
            if (TextUtils.isEmpty(str)) {
                str = r.i(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.f11732d.putString("rpandid", str);
                    eVar.f11732d.commit();
                }
            }
        } catch (Throwable unused) {
            d.a();
        }
        return str;
    }
}
