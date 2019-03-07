package cn.jiguang.d.i;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public final class c {
    private static Boolean a;

    public static d a(Context context, int i, int i2, cn.jiguang.d.d.a aVar, HashMap<String, String> hashMap) {
        if (aVar == null || context == null) {
            return null;
        }
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(aVar.a, aVar.b);
        intent.setComponent(componentName);
        if (Build.VERSION.SDK_INT >= 12) {
            intent.setFlags(32);
        }
        Bundle i3 = i(hashMap);
        if (i3 != null) {
            intent.putExtras(i3);
        }
        d dVar = new d();
        dVar.a(componentName);
        if ((i2 & 2) != 0) {
            try {
                b bVar = new b(context, i == 1);
                if (context.getApplicationContext().bindService(intent, bVar, 1)) {
                    b.a.put(aVar.a + aVar.b, new WeakReference<>(bVar));
                    if (i == 2) {
                        dVar.a(2, true);
                    }
                } else {
                    dVar.a(2, false);
                }
            } catch (Throwable th) {
                dVar.a(2, false);
            }
        }
        if ((i2 & 1) != 0) {
            try {
                if (context.startService(intent) != null) {
                    dVar.a(1, true);
                } else {
                    dVar.a(1, false);
                }
            } catch (Throwable th2) {
                dVar.a(1, false);
            }
        }
        if ((i2 & 4) != 0) {
            try {
                if (!TextUtils.isEmpty(aVar.d)) {
                    ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
                    String str = aVar.d;
                    if (!str.startsWith("content://")) {
                        str = "content://" + str;
                    }
                    String b = b(hashMap);
                    if (!TextUtils.isEmpty(b)) {
                        str = str + b;
                    }
                    contentResolver.query(Uri.parse(str), null, null, null, null);
                    dVar.a(4, true);
                }
            } catch (Throwable th3) {
                dVar.a(4, false);
            }
        }
        return dVar;
    }

    public static boolean a(Context context) {
        if (a != null) {
            return a.booleanValue();
        }
        if (context != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("cn.jpush.android.WAKED_NOT_REPORT");
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                    a = true;
                } else {
                    a = false;
                }
                return a.booleanValue();
            } catch (Throwable th) {
                return true;
            }
        }
        return true;
    }

    private static String b(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        for (String str : hashMap.keySet()) {
            builder.appendQueryParameter(str, hashMap.get(str));
        }
        return builder.toString();
    }

    private static Bundle i(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putString(str, hashMap.get(str));
        }
        return bundle;
    }
}
