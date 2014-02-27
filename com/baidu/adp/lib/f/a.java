package com.baidu.adp.lib.f;

import android.database.Cursor;
import com.baidu.adp.lib.util.e;
import java.io.Closeable;
/* loaded from: classes.dex */
public final class a {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                e.b("adp_util_close", "error on close the Closeable.", th.getMessage());
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                e.b("adp_util_close", "error on close android.database.Cursor.", e.getMessage());
            }
        }
    }
}
