package com.baidu.swan.apps.database.favorite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ay2;
import com.baidu.tieba.xi2;
/* loaded from: classes4.dex */
public class SwanAppFavoriteProvider extends ContentProvider {
    public volatile xi2 a;

    public final xi2 a() {
        if (this.a == null) {
            synchronized (SwanAppFavoriteProvider.class) {
                if (this.a == null) {
                    this.a = new xi2();
                }
            }
        }
        return this.a;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        ay2.a().b(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return a().delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return a().getType(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return a().insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return a().query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return a().update(uri, contentValues, str, strArr);
    }
}
