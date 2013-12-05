package com.baidu.adp.lib.h;

import android.database.Cursor;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.cache.u;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    /* JADX WARN: Type inference failed for: r4v12, types: [T, java.lang.String] */
    public static List<t<String>> a(s<String> sVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = b(sVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                t tVar = new t();
                tVar.f437a = cursor.getString(cursor.getColumnIndex("m_key"));
                tVar.c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                tVar.d = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                tVar.b = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(tVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    e.a(i.class, "listAllTextItemsInDBCache", th);
                    Collections.sort(linkedList, new k());
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.f.a.a(cursor);
                }
            }
        }
        com.baidu.adp.lib.f.a.a(cursor);
        Collections.sort(linkedList, new k());
        return linkedList;
    }

    private static Cursor b(s<?> sVar) {
        if (sVar != null && (sVar instanceof u)) {
            u uVar = (u) sVar;
            if (uVar.b() instanceof o) {
                com.baidu.adp.lib.cache.c b = ((o) uVar.b()).b();
                return b.b(b.d().a(), uVar.a());
            }
            return null;
        }
        return null;
    }
}
