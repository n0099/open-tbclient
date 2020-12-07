package com.baidu.sofire.rp;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.e;
import com.baidu.sofire.i.h;
/* loaded from: classes8.dex */
public final class a {
    public static String a(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            if (!TextUtils.isEmpty(eVar.b.getString("rpiiem", ""))) {
                eVar.d.putString("rpiiem", "");
                eVar.d.commit();
            }
            str = eVar.o();
            if (TextUtils.isEmpty(str)) {
                str = h.e(context);
                if (!TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str)) {
                        eVar.d.putString("rpiiemn", "");
                        eVar.d.commit();
                    } else {
                        eVar.d.putString("rpiiemn", new String(Base64.encode(com.baidu.sofire.i.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
                        eVar.d.commit();
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
        return str;
    }

    public static String b(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.b.getString("rpandid", "");
            if (TextUtils.isEmpty(str)) {
                str = h.f(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.d.putString("rpandid", str);
                    eVar.d.commit();
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
        return str;
    }
}
