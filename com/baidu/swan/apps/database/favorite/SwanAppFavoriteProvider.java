package com.baidu.swan.apps.database.favorite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class SwanAppFavoriteProvider extends ContentProvider {
    private volatile b dbv;

    private b awK() {
        if (this.dbv == null) {
            synchronized (SwanAppFavoriteProvider.class) {
                if (this.dbv == null) {
                    this.dbv = new b();
                }
            }
        }
        return this.dbv;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return awK().query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return awK().getType(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return awK().insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return awK().delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return awK().update(uri, contentValues, str, strArr);
    }
}
