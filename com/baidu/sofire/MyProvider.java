package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.sofire.b.r;
/* loaded from: classes.dex */
public class MyProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        b.a("ActiveProvider onCreate");
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        b.a("js call init() ");
        try {
            if ("p".equals(str)) {
                a(getContext(), str2);
                return null;
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        return com.baidu.sofire.core.e.a(getContext().getApplicationContext(), str, str2, bundle);
    }

    private static void a(final Context context, final String str) {
        r.a().a(new Runnable() { // from class: com.baidu.sofire.MyProvider.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.a("PPP(provider) now to active " + str);
                    Intent intent = new Intent();
                    intent.putExtra("t", "p");
                    intent.putExtra("c", str);
                    a.a(context, intent);
                } catch (Throwable th) {
                    com.baidu.sofire.b.e.a(th);
                }
            }
        });
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
