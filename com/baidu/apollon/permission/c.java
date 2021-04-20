package com.baidu.apollon.permission;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3741a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3742b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3743c = -2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface a {
    }

    public static int a(@NonNull Context context, @NonNull String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a2 = com.baidu.apollon.permission.a.a(str);
        if (a2 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return com.baidu.apollon.permission.a.a(context, a2, str2) != 0 ? -2 : 0;
    }

    public static int b(@NonNull Context context, @NonNull String str) {
        return a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int a(@NonNull Context context, @NonNull String str, String str2) {
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }
}
