package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.baidu.sofire.g.t;
/* loaded from: classes3.dex */
public class THProvider extends ContentProvider {
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
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, final String str2) {
        b.a();
        try {
            if ("p".equals(str)) {
                final String callingPackage = Build.VERSION.SDK_INT >= 19 ? getCallingPackage() : "";
                final Context context = getContext();
                t.a(context).a(new Runnable() { // from class: com.baidu.sofire.THProvider.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            new StringBuilder().append(str2);
                            b.a();
                            Intent intent = new Intent();
                            intent.putExtra("t", "p");
                            intent.putExtra("c", str2);
                            if (callingPackage == null) {
                                intent.putExtra("source", "");
                            } else {
                                intent.putExtra("source", callingPackage);
                            }
                            new StringBuilder("THPR sou====").append(callingPackage);
                            b.a();
                            a.a(context, intent);
                        } catch (Throwable unused) {
                            com.baidu.sofire.g.d.a();
                        }
                    }
                });
                return null;
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
