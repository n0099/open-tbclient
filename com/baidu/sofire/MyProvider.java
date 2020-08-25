package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sofire.i.h;
/* loaded from: classes20.dex */
public class MyProvider extends ContentProvider {
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
    public Bundle call(String str, String str2, Bundle bundle) {
        String callingPackage;
        try {
            if ((Build.VERSION.SDK_INT < 19 || (callingPackage = getCallingPackage()) == null || callingPackage.equals(getContext().getPackageName())) && !TextUtils.isEmpty(str)) {
                if ("joinActive".equals(str) || "triggerActive".equals(str)) {
                    a(str, bundle);
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("result_code", 1);
                    return bundle2;
                } else if (str.startsWith("sub_process_")) {
                    return com.baidu.sofire.mutiprocess.b.a(str, bundle);
                } else {
                    if ("getRemoteZid".equals(str)) {
                        String b = h.b(getContext());
                        Bundle bundle3 = new Bundle();
                        if (!TextUtils.isEmpty(b)) {
                            bundle3.putString("_zid", b);
                        }
                        return bundle3;
                    }
                    return com.baidu.sofire.core.d.a(getContext().getApplicationContext(), str, bundle);
                }
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return null;
        }
    }

    private static boolean a(String str, Bundle bundle) {
        try {
            new StringBuilder().append(str);
            b.a();
            MyProvider.class.getClassLoader().loadClass("com.baidu.sofire.active.Active").getMethod("touchActive", String.class, Bundle.class).invoke(null, str, bundle);
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
        return false;
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
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
