package com.baidu.b.a.h;

import android.database.Cursor;
/* loaded from: classes2.dex */
public final class d {
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
}
