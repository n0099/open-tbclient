package com.baidu.searchbox.pms.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class PmsContentProvider extends ContentProvider {
    public static volatile PmsContentProviderImpl sProvider;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    public static PmsContentProviderImpl getProvider() {
        if (sProvider == null) {
            synchronized (PmsContentProvider.class) {
                if (sProvider == null) {
                    sProvider = new PmsContentProviderImpl(AppRuntime.getAppContext());
                }
            }
        }
        return sProvider;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return getProvider().delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        getProvider();
        return PmsContentProviderImpl.getType(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return getProvider().insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return getProvider().query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return getProvider().update(uri, contentValues, str, strArr);
    }
}
