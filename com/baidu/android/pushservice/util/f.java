package com.baidu.android.pushservice.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
class f extends ContextWrapper {
    public f(Context context) {
        super(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "pushservice/database" + File.separator + str;
        if (!str2.endsWith(".db")) {
            str2 = str2 + ".db";
        }
        File file = new File(str2);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
    }
}
