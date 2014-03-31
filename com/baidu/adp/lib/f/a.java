package com.baidu.adp.lib.f;

import android.database.Cursor;
import com.baidu.adp.lib.util.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public final class a {
    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                f.b("adp_util_close", "error on close the inputstream.", e.getMessage());
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                f.b("adp_util_close", "error on close the Closeable.", th.getMessage());
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                f.b("adp_util_close", "error on close the outputstream.", e.getMessage());
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                f.b("adp_util_close", "error on close android.database.Cursor.", e.getMessage());
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                f.b("adp_util_close", "error on close HttpURLConnection.", e.getMessage());
            }
        }
    }
}
