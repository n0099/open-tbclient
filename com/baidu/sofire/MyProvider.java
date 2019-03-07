package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.b.r;
/* loaded from: classes.dex */
public class MyProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        b.a();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, final String str2) {
        b.a();
        try {
            if ("p".equals(str)) {
                final Context context = getContext();
                r.a().a(new Runnable() { // from class: com.baidu.sofire.MyProvider.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            new StringBuilder("PPP(provider) now to active ").append(str2);
                            b.a();
                            Intent intent = new Intent();
                            intent.putExtra(Info.kBaiduTimeKey, "p");
                            intent.putExtra("c", str2);
                            a.a(context, intent);
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a();
                        }
                    }
                });
                return null;
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        return com.baidu.sofire.core.e.a(getContext().getApplicationContext(), str, bundle);
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
