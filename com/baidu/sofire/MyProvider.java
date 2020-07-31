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
            if (Build.VERSION.SDK_INT < 19 || (callingPackage = getCallingPackage()) == null || callingPackage.equals(getContext().getPackageName())) {
                if ("getRemoteZid".equals(str)) {
                    String b = com.baidu.sofire.i.g.b(getContext());
                    Bundle bundle2 = new Bundle();
                    if (!TextUtils.isEmpty(b)) {
                        bundle2.putString("_zid", b);
                    }
                    return bundle2;
                }
                return com.baidu.sofire.core.e.a(getContext().getApplicationContext(), str, bundle);
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
            return null;
        }
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
