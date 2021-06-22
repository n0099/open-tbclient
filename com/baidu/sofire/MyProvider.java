package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class MyProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10153a = false;

    public static boolean a() {
        return f10153a;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle a2;
        String callingPackage;
        try {
            if ((Build.VERSION.SDK_INT < 19 || (callingPackage = getCallingPackage()) == null || callingPackage.equals(getContext().getPackageName())) && !TextUtils.isEmpty(str)) {
                if ("setAgreePolicy".equals(str)) {
                    com.baidu.sofire.core.d.b(getContext(), bundle.getBoolean("_agree_policy", true));
                    a2 = new Bundle();
                    a2.putBoolean("handle_flag", true);
                } else if ("CallPreferences".equals(str)) {
                    a2 = com.baidu.sofire.h.a.a(getContext()).a(bundle);
                    if (a2 == null) {
                        a2 = new Bundle();
                    }
                    a2.putBoolean("handle_flag", true);
                } else if (str.startsWith("sub_process_")) {
                    a2 = com.baidu.sofire.mutiprocess.b.a(str, bundle);
                    if (a2 == null) {
                        a2 = new Bundle();
                    }
                    a2.putBoolean("handle_flag", true);
                } else if ("getRemoteZid".equals(str)) {
                    String b2 = com.baidu.sofire.utility.e.b(getContext());
                    new Bundle();
                    Bundle bundle2 = new Bundle();
                    if (!TextUtils.isEmpty(b2)) {
                        bundle2.putString("_zid", b2);
                    }
                    bundle2.putBoolean("handle_flag", true);
                    a2 = bundle2;
                } else {
                    a2 = com.baidu.sofire.core.d.a(getContext().getApplicationContext(), str, bundle);
                }
                if (a2 != null) {
                    a2.putString("server_version", "3.5.8.6");
                }
                return a2;
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
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
        f10153a = true;
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
