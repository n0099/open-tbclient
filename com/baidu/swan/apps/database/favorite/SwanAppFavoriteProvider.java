package com.baidu.swan.apps.database.favorite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes8.dex */
public class SwanAppFavoriteProvider extends ContentProvider {
    private volatile b coH;

    private b alb() {
        if (this.coH == null) {
            synchronized (SwanAppFavoriteProvider.class) {
                if (this.coH == null) {
                    this.coH = new b();
                }
            }
        }
        return this.coH;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return alb().query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return alb().getType(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return alb().insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return alb().delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return alb().update(uri, contentValues, str, strArr);
    }
}
