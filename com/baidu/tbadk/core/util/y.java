package com.baidu.tbadk.core.util;

import android.database.Cursor;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class y {
    /* JADX WARN: Removed duplicated region for block: B:38:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<String> a() {
        Cursor cursor;
        Exception e;
        ArrayList<String> arrayList;
        Cursor cursor2 = null;
        try {
            try {
                cursor = new DatabaseManager().a("select * from frs_image_forums", (String[]) null);
                if (cursor == null) {
                    return null;
                }
                try {
                    arrayList = new ArrayList<>();
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(cursor.getString(0));
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.adp.lib.util.f.b("DatabaseManager", "getAllFrsImageForums", e.getMessage());
                            TiebaStatic.a(e, "DatabaseManager.getAllFrsImageForums", new Object[0]);
                            if (cursor == null) {
                                return arrayList;
                            }
                            try {
                                cursor.close();
                                return arrayList;
                            } catch (Exception e3) {
                                TiebaStatic.a(e3, "DatabaseManager.getAllFrsImageForums close cursor", new Object[0]);
                                e3.printStackTrace();
                                return arrayList;
                            }
                        }
                    }
                    cursor.close();
                    return arrayList;
                } catch (Exception e4) {
                    arrayList = null;
                    e = e4;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        cursor2.close();
                    } catch (Exception e5) {
                        TiebaStatic.a(e5, "DatabaseManager.getAllFrsImageForums close cursor", new Object[0]);
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            cursor = null;
            e = e6;
            arrayList = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }
}
