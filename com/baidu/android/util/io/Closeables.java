package com.baidu.android.util.io;

import android.database.Cursor;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes.dex */
public final class Closeables {
    public static final String TAG = "Closeables";

    public static void close(@Nullable Closeable closeable, boolean z) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            if (z) {
                Log.d(TAG, "IOException thrown while closing Closeable.", e2);
                return;
            }
            throw e2;
        }
    }

    public static void closeSafely(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void closeSafely(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
