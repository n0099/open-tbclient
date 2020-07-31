package com.baidu.helios.common.b.a;

import android.database.Cursor;
import java.io.Closeable;
import java.util.zip.ZipFile;
/* loaded from: classes12.dex */
public class c {
    public static boolean a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
                return true;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public static boolean b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return true;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public static boolean c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return true;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public static boolean b(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
                return true;
            } catch (Throwable th) {
            }
        }
        return false;
    }
}
