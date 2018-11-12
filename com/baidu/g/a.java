package com.baidu.g;

import android.database.Cursor;
import java.io.Closeable;
/* loaded from: classes2.dex */
public final class a {
    public static void h(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
