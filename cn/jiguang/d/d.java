package cn.jiguang.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import cn.jiguang.g.i;
/* loaded from: classes3.dex */
public final class d {
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: Throwable -> 0x0023, TRY_ENTER, TryCatch #1 {Throwable -> 0x0023, blocks: (B:3:0x0001, B:4:0x0006, B:7:0x000c, B:9:0x0019, B:12:0x0025, B:18:0x003e, B:19:0x0045, B:22:0x0050, B:23:0x005d), top: B:28:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle c(Context context, int i, Bundle bundle) {
        Bundle bundle2;
        String c;
        ApplicationInfo applicationInfo;
        try {
            Bundle bundle3 = new Bundle();
            switch (i) {
                case 4096:
                    if (bundle != null) {
                        String c2 = a.c(bundle, "arg1");
                        Context X = a.X(context);
                        if (X == null) {
                            cn.jiguang.e.c.d("JCoreInterface", "context is null, setOptionChannel do not work");
                            return null;
                        }
                        cn.jiguang.d.a.a.c(X, c2);
                        if (c2 == null) {
                            try {
                                applicationInfo = X.getPackageManager().getApplicationInfo(X.getPackageName(), 128);
                            } catch (Throwable th) {
                            }
                            if (applicationInfo != null) {
                                bundle2 = applicationInfo.metaData;
                                if (bundle2 != null) {
                                    c = a.c(bundle2, "JPUSH_CHANNEL");
                                    cn.jiguang.d.a.a.a(X, i.c(c));
                                    return null;
                                }
                            }
                            bundle2 = null;
                            if (bundle2 != null) {
                            }
                        }
                        c = c2;
                        cn.jiguang.d.a.a.a(X, i.c(c));
                        return null;
                    }
                    return null;
                case 4097:
                    bundle3.putString("arg1", cn.jiguang.d.a.a.b(context, null));
                    return bundle3;
                case 4098:
                    bundle3.putBoolean("arg1", a.c(context));
                    return bundle3;
                case 36864:
                default:
                    return null;
            }
        } catch (Throwable th2) {
            return null;
        }
    }
}
