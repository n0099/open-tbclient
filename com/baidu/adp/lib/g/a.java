package com.baidu.adp.lib.g;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    public static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
