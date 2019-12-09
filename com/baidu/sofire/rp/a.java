package com.baidu.sofire.rp;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.e;
import com.baidu.sofire.i.d;
import com.baidu.sofire.i.g;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
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
                str = g.e(context);
                if (!TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str)) {
                        eVar.d.putString("rpiiemn", "");
                        eVar.d.commit();
                    } else {
                        eVar.d.putString("rpiiemn", new String(Base64.encode(com.baidu.sofire.i.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes(HTTP.UTF_8)), 10), HTTP.UTF_8));
                        eVar.d.commit();
                    }
                }
            }
        } catch (Throwable th) {
            d.a();
        }
        return str;
    }

    public static String b(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.b.getString("rpandid", "");
            if (TextUtils.isEmpty(str)) {
                str = g.f(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.d.putString("rpandid", str);
                    eVar.d.commit();
                }
            }
        } catch (Throwable th) {
            d.a();
        }
        return str;
    }
}
