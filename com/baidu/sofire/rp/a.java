package com.baidu.sofire.rp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.b.g;
import com.baidu.sofire.e;
/* loaded from: classes2.dex */
public final class a {
    public static String a(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.b.getString("rpiiem", "");
            if (TextUtils.isEmpty(str)) {
                str = g.d(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.d.putString("rpiiem", str);
                    eVar.d.commit();
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        return str;
    }

    public static String b(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.b.getString("rpandid", "");
            if (TextUtils.isEmpty(str)) {
                str = g.e(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.d.putString("rpandid", str);
                    eVar.d.commit();
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        return str;
    }

    public static String c(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.b.getString("rpmacadd", "");
            if (TextUtils.isEmpty(str)) {
                str = g.a();
                if (!TextUtils.isEmpty(str)) {
                    eVar.d.putString("rpmacadd", str);
                    eVar.d.commit();
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        return str;
    }
}
