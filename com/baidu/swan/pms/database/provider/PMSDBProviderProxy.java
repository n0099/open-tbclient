package com.baidu.swan.pms.database.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.jo4;
import com.baidu.tieba.yj4;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PMSDBProviderProxy extends ContentProvider {
    public static final jo4 b = jo4.c();
    public volatile yj4 a;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    public yj4 a() {
        if (this.a == null) {
            synchronized (yj4.class) {
                if (this.a == null) {
                    this.a = new yj4(getContext());
                }
            }
        }
        return this.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        r2.setTransactionSuccessful();
     */
    @Override // android.content.ContentProvider
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ContentProviderResult[] applyBatch(@NonNull ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase writableDatabase = a().a().getWritableDatabase();
        try {
            try {
                b.i("PMSDBProviderProxy", "#applyBatch beginTransaction");
                writableDatabase.beginTransaction();
                ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
                int length = applyBatch.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        ContentProviderResult contentProviderResult = applyBatch[i];
                        if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                return applyBatch;
            } catch (Exception e) {
                b.g("PMSDBProviderProxy", "#applyBatch error", e);
                writableDatabase.endTransaction();
                b.i("PMSDBProviderProxy", "#applyBatch endTransaction");
                return new ContentProviderResult[0];
            }
        } finally {
            writableDatabase.endTransaction();
            b.i("PMSDBProviderProxy", "#applyBatch endTransaction");
        }
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
