package com.baidu.sofire.rp;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.sofire.b.g;
import com.baidu.sofire.e;
/* loaded from: classes.dex */
public final class a {
    public static String a(Context context) {
        String str;
        Throwable th;
        try {
            e eVar = new e(context);
            str = eVar.b.getString("rpiiem", "");
            try {
                if (TextUtils.isEmpty(str)) {
                    str = g.d(context);
                    if (!TextUtils.isEmpty(str)) {
                        eVar.d.putString("rpiiem", str);
                        eVar.d.commit();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.sofire.b.e.a(th);
                return str;
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
        return str;
    }

    public static String b(Context context) {
        String str;
        Throwable th;
        try {
            e eVar = new e(context);
            str = eVar.b.getString("rpandid", "");
            try {
                if (TextUtils.isEmpty(str)) {
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    str = TextUtils.isEmpty(string) ? "" : string;
                    if (!TextUtils.isEmpty(str)) {
                        eVar.d.putString("rpandid", str);
                        eVar.d.commit();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.sofire.b.e.a(th);
                return str;
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
        return str;
    }

    public static String c(Context context) {
        String str;
        Throwable th;
        try {
            e eVar = new e(context);
            str = eVar.b.getString("rpmacadd", "");
            try {
                if (TextUtils.isEmpty(str)) {
                    str = g.a();
                    if (!TextUtils.isEmpty(str)) {
                        eVar.d.putString("rpmacadd", str);
                        eVar.d.commit();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.sofire.b.e.a(th);
                return str;
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
        return str;
    }
}
