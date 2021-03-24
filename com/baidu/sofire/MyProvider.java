package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class MyProvider extends ContentProvider {
    public static boolean a(String str, Bundle bundle) {
        try {
            new StringBuilder().append(str);
            b.a();
            MyProvider.class.getClassLoader().loadClass("com.baidu.sofire.active.Active").getMethod("touchActive", String.class, Bundle.class).invoke(null, str, bundle);
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        String callingPackage;
        try {
            if ((Build.VERSION.SDK_INT < 19 || (callingPackage = getCallingPackage()) == null || callingPackage.equals(getContext().getPackageName())) && !TextUtils.isEmpty(str)) {
                if ("setAgreePolicy".equals(str)) {
                    com.baidu.sofire.core.d.b(getContext(), bundle.getBoolean("_agree_policy", true));
                    return null;
                }
                if (!"joinActive".equals(str) && !"triggerActive".equals(str) && !"triggerBgActive".equals(str)) {
                    if (str.startsWith("sub_process_")) {
                        return com.baidu.sofire.mutiprocess.b.a(str, bundle);
                    }
                    if ("getRemoteZid".equals(str)) {
                        String b2 = com.baidu.sofire.g.f.b(getContext());
                        Bundle bundle2 = new Bundle();
                        if (!TextUtils.isEmpty(b2)) {
                            bundle2.putString("_zid", b2);
                        }
                        return bundle2;
                    }
                    return com.baidu.sofire.core.d.a(getContext().getApplicationContext(), str, bundle);
                }
                a(str, bundle);
                Bundle bundle3 = new Bundle();
                bundle3.putInt("result_code", 1);
                return bundle3;
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        b.a();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
