package com.baidu.apollon.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.apollon.NoProguard;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PermissionManager implements NoProguard {
    public static final int REQUEST_CODE_CALL_PHONE = 2;
    public static final int REQUEST_CODE_READ_CONTRACT = 3;
    public static final int REQUEST_CODE_READ_SMS = 1;
    public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 4;

    /* renamed from: a  reason: collision with root package name */
    public static final int f3700a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f3701b;

    @TargetApi(23)
    public static boolean checkCallingOrSelfPermission(Activity activity, String[] strArr, int i) {
        if (activity == null || strArr == null || Build.VERSION.SDK_INT < 23) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (!checkCallingPermission(activity, strArr[i2])) {
                arrayList.add(strArr[i2]);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (com.baidu.apollon.permission.c.a(r4, r5) == 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (com.baidu.apollon.permission.c.a(r4, r5) == 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkCallingPermission(Context context, String str) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 23) {
            if (getTargetSdkVersion(context) >= 23) {
                if (context.checkSelfPermission(str) == 0) {
                    z = true;
                }
                return z;
            }
        }
        return z;
    }

    public static int getTargetSdkVersion(Context context) {
        if (f3701b == 0) {
            try {
                f3701b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return f3701b;
    }
}
