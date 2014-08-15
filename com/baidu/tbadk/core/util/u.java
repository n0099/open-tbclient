package com.baidu.tbadk.core.util;

import android.database.Cursor;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    public static ArrayList<String> a() {
        Cursor cursor = null;
        com.baidu.adp.base.a.c b = com.baidu.tbadk.j.a().b();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            cursor = b.a("select * from frs_image_forums", (String[]) null);
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));
            }
        } catch (Exception e) {
            b.a(e, "getAllFrsImageForums");
        } finally {
            com.baidu.adp.lib.e.a.a(cursor);
        }
        return arrayList;
    }

    public static void a(String str) {
        com.baidu.adp.base.a.c b = com.baidu.tbadk.j.a().b();
        if (str != null && b != null) {
            b.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
            b.a("Insert into frs_image_forums(forum_name) values(?)", new Object[]{str});
        }
    }

    public static void b(String str) {
        com.baidu.adp.base.a.c b = com.baidu.tbadk.j.a().b();
        if (str != null && b != null) {
            b.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
        }
    }
}
