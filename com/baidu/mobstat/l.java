package com.baidu.mobstat;

import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class l extends ContextWrapper {
    public l() {
        super(null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if ("mounted".equals(bo.a())) {
            String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/system";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str2 + File.separator + str);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e2) {
                    bb.c().b(e2);
                }
            }
            if (file2.exists()) {
                return file2;
            }
            return null;
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        File databasePath = getDatabasePath(str);
        if (databasePath != null && databasePath.canWrite()) {
            return SQLiteDatabase.openOrCreateDatabase(databasePath, (SQLiteDatabase.CursorFactory) null);
        }
        throw new RuntimeException("db path is null or path can not be write");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        File databasePath = getDatabasePath(str);
        if (databasePath != null && databasePath.canWrite()) {
            return SQLiteDatabase.openOrCreateDatabase(databasePath, (SQLiteDatabase.CursorFactory) null);
        }
        throw new RuntimeException("db path is null or path can not be write");
    }
}
