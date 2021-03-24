package com.baidu.swan.pms.database.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.l.f;
import d.b.g0.l.i.e.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PMSDBProviderProxy extends ContentProvider {
    public static final String TAG = "PMSDBProviderProxy";
    public volatile b mProvider;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, SGET]}, finally: {[INVOKE, SGET, INVOKE, IF] complete} */
    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(@NonNull ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        SQLiteDatabase writableDatabase = getProvider().b().getWritableDatabase();
        try {
            try {
                if (f.f48888a) {
                    Log.e(TAG, "applyBatch beginTransaction");
                }
                writableDatabase.beginTransaction();
                ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
                for (ContentProviderResult contentProviderResult : applyBatch) {
                    if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                        writableDatabase.endTransaction();
                        if (f.f48888a) {
                            Log.e(TAG, "applyBatch endTransaction");
                        }
                        return applyBatch;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                if (f.f48888a) {
                    Log.e(TAG, "applyBatch endTransaction");
                }
                return applyBatch;
            } catch (Exception e2) {
                if (f.f48888a) {
                    Log.e(TAG, "applyBatch Exception:" + e2.getMessage());
                }
                writableDatabase.endTransaction();
                if (f.f48888a) {
                    Log.e(TAG, "applyBatch endTransaction");
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            if (f.f48888a) {
                Log.e(TAG, "applyBatch endTransaction");
            }
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return getProvider().a(uri, str, strArr);
    }

    public b getProvider() {
        if (this.mProvider == null) {
            synchronized (b.class) {
                if (this.mProvider == null) {
                    this.mProvider = new b(getContext());
                }
            }
        }
        return this.mProvider;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return getProvider().d(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return getProvider().e(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
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
