package com.baidu.tbadk.core.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class l {
    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                com.baidu.adp.lib.util.f.b("CloseUtil", "error on close the inputstream.", e.getMessage());
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                com.baidu.adp.lib.util.f.b("CloseUtil", "error on close the Closeable.", th.getMessage());
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                com.baidu.adp.lib.util.f.b("CloseUtil", "error on close the outputstream.", e.getMessage());
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                TiebaStatic.a(e, "close cursor", new Object[0]);
                com.baidu.adp.lib.util.f.b("CloseUtil", "error on close android.database.Cursor.", e.getMessage());
            }
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                TiebaStatic.a(e, "close db", new Object[0]);
                com.baidu.adp.lib.util.f.b("CloseUtil", "error on close android.database.SQLiteDatabase.", e.getMessage());
            }
        }
    }

    public static void a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            try {
                sQLiteStatement.close();
            } catch (Exception e) {
                TiebaStatic.a(e, "close SQLiteStatement", new Object[0]);
                com.baidu.adp.lib.util.f.b("CloseUtil", "error on close android.database.SQLiteDatabase.", e.getMessage());
            }
        }
    }
}
