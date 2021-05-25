package com.baidu.swan.apps.database.favorite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.g1.k.d;
import d.a.l0.a.j0.b.b;
/* loaded from: classes2.dex */
public class SwanAppFavoriteProvider extends ContentProvider {
    public volatile b mProvider;

    private b getProvider() {
        if (this.mProvider == null) {
            synchronized (SwanAppFavoriteProvider.class) {
                if (this.mProvider == null) {
                    this.mProvider = new b();
                }
            }
        }
        return this.mProvider;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return getProvider().a(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return getProvider().c(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return getProvider().d(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        d.a().b(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return getProvider().f(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return getProvider().g(uri, contentValues, str, strArr);
    }
}
