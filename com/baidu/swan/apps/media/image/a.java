package com.baidu.swan.apps.media.image;

import android.database.Cursor;
/* loaded from: classes25.dex */
public final class a {
    public static void closeSafely(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
