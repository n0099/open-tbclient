package com.baidu.swan.apps.database.favorite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes11.dex */
public class SwanAppFavoriteProvider extends ContentProvider {
    private volatile b cgy;

    private b adn() {
        if (this.cgy == null) {
            synchronized (SwanAppFavoriteProvider.class) {
                if (this.cgy == null) {
                    this.cgy = new b();
                }
            }
        }
        return this.cgy;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return adn().query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return adn().getType(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return adn().insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return adn().delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return adn().update(uri, contentValues, str, strArr);
    }
}
