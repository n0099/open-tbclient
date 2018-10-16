package com.baidu.b.a.d;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.b.a.h.b;
/* loaded from: classes2.dex */
public abstract class a {
    private boolean mIsSuccess = false;

    protected abstract boolean performTransaction(SQLiteDatabase sQLiteDatabase);

    public void run(SQLiteDatabase sQLiteDatabase) {
        this.mIsSuccess = false;
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (performTransaction(sQLiteDatabase)) {
                    sQLiteDatabase.setTransactionSuccessful();
                    this.mIsSuccess = true;
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                    if (b.isDebug()) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                if (b.isDebug()) {
                    e2.printStackTrace();
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    if (b.isDebug()) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e4) {
                if (b.isDebug()) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public boolean isTransactionSuccess() {
        return this.mIsSuccess;
    }
}
