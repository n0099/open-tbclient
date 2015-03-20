package com.baidu.adp.lib.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/* loaded from: classes.dex */
public class v {
    public static void d(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void b(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void b(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void i(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            try {
                sQLiteStatement.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
