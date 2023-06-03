package com.baidu.searchbox.download.component;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileNotFoundException;
/* loaded from: classes3.dex */
public class DownloadProviderProxy extends ContentProvider {
    public volatile DownloadProvider mProvider;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    public DownloadProvider getProvider() {
        if (this.mProvider == null) {
            synchronized (DownloadProviderProxy.class) {
                if (this.mProvider == null) {
                    this.mProvider = new DownloadProvider(getContext());
                }
            }
        }
        return this.mProvider;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return getProvider().delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return getProvider().getType(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return getProvider().insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        return getProvider().openFile(uri, str);
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
