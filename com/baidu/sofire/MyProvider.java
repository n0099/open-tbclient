package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.sofire.b.t;
/* loaded from: classes.dex */
public class MyProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, final String str2) {
        try {
            if ("p".equals(str)) {
                final Context context = getContext();
                t a = t.a();
                a.a.execute(new Runnable() { // from class: com.baidu.sofire.MyProvider.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            new StringBuilder("PPP(provider) now to active ").append(str2);
                            Intent intent = new Intent();
                            intent.putExtra("t", "p");
                            intent.putExtra("c", str2);
                            a.a(context, intent);
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a(th);
                        }
                    }
                });
                return null;
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
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
