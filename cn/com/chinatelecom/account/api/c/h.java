package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f986a = {"android.permission.READ_PHONE_STATE"};

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (a(context, f986a)) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private static boolean a(Context context, String[] strArr) {
        if (context == null || strArr == null || strArr.length <= 0) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            if (-1 == packageManager.checkPermission(strArr[i], context.getPackageName())) {
                arrayList.add(strArr[i]);
            }
        }
        return !arrayList.isEmpty();
    }
}
