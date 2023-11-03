package com.baidu.swan.apps.database.favorite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.fd2;
import com.baidu.tieba.is2;
/* loaded from: classes4.dex */
public class SwanAppFavoriteProvider extends ContentProvider {
    public volatile fd2 a;

    public final fd2 a() {
        if (this.a == null) {
            synchronized (SwanAppFavoriteProvider.class) {
                if (this.a == null) {
                    this.a = new fd2();
                }
            }
        }
        return this.a;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        is2.a().b(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return a().a(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return a().c(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return a().d(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return a().f(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return a().g(uri, contentValues, str, strArr);
    }
}
