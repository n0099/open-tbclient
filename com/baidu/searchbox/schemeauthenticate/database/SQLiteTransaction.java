package com.baidu.searchbox.schemeauthenticate.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes4.dex */
public abstract class SQLiteTransaction {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "SQLiteTransaction";
    public boolean mTransactionSuccess = false;

    public abstract boolean performTransaction(SQLiteDatabase sQLiteDatabase);

    public boolean isTransactionSuccess() {
        return this.mTransactionSuccess;
    }

    public void run(SQLiteDatabase sQLiteDatabase) {
        this.mTransactionSuccess = false;
        sQLiteDatabase.beginTransaction();
        try {
            try {
                if (performTransaction(sQLiteDatabase)) {
                    sQLiteDatabase.setTransactionSuccessful();
                    this.mTransactionSuccess = true;
                }
            } catch (RuntimeException e) {
                if (!DEBUG) {
                    Log.e(TAG, "SQLiteTransaction.run()", e);
                } else {
                    throw e;
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
