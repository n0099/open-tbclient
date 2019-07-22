package com.baidu.swan.pms.database.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.pms.e;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PMSDBProviderProxy extends ContentProvider {
    private volatile b bsF;

    public b Wl() {
        if (this.bsF == null) {
            synchronized (b.class) {
                if (this.bsF == null) {
                    this.bsF = new b(getContext());
                }
            }
        }
        return this.bsF;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return Wl().getType(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return Wl().query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return Wl().insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return Wl().delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return Wl().update(uri, contentValues, str, strArr);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, SGET]}, finally: {[INVOKE, SGET, CONST_STR, CONST_STR, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4, 106=4, 107=4] */
    @Override // android.content.ContentProvider
    @NonNull
    public ContentProviderResult[] applyBatch(@NonNull ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        SQLiteDatabase writableDatabase = Wl().Cp().getWritableDatabase();
        try {
            try {
                if (e.DEBUG) {
                    Log.e("PMSDBProviderProxy", "applyBatch beginTransaction");
                }
                writableDatabase.beginTransaction();
                ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
                for (ContentProviderResult contentProviderResult : applyBatch) {
                    if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                        writableDatabase.endTransaction();
                        if (e.DEBUG) {
                            Log.e("PMSDBProviderProxy", "applyBatch endTransaction");
                            return applyBatch;
                        }
                        return applyBatch;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                if (e.DEBUG) {
                    Log.e("PMSDBProviderProxy", "applyBatch endTransaction");
                    return applyBatch;
                }
                return applyBatch;
            } catch (Exception e) {
                if (e.DEBUG) {
                    Log.e("PMSDBProviderProxy", "applyBatch Exception:" + e.getMessage());
                }
                writableDatabase.endTransaction();
                if (e.DEBUG) {
                    Log.e("PMSDBProviderProxy", "applyBatch endTransaction");
                }
                return null;
            }
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            if (e.DEBUG) {
                Log.e("PMSDBProviderProxy", "applyBatch endTransaction");
            }
            throw th;
        }
    }
}
