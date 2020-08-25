package com.baidu.android.util.io;

import android.database.Cursor;
import android.support.annotation.Nullable;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class Closeables {
    private static final String TAG = "Closeables";

    private Closeables() {
    }

    public static void closeSafely(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(@Nullable Closeable closeable, boolean z) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (z) {
                    Log.d(TAG, "IOException thrown while closing Closeable.", e);
                    return;
                }
                throw e;
            }
        }
    }

    public static void closeSafely(Cursor cursor) {
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
}
