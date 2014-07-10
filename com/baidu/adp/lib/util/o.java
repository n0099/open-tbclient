package com.baidu.adp.lib.util;

import android.database.Cursor;
import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.cache.u;
import com.baidu.adp.lib.cache.v;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=4] */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.String] */
    public static List<u<String>> a(s<String> sVar) {
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
                u uVar = new u();
                uVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                uVar.c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                uVar.d = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                uVar.b = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(uVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    com.baidu.adp.lib.f.a.a(cursor);
                    Collections.sort(linkedList, new p(null));
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.f.a.a(cursor);
                }
            }
        }
        Collections.sort(linkedList, new p(null));
        return linkedList;
    }

    private static Cursor b(s<?> sVar) {
        if (sVar != null && (sVar instanceof v)) {
            v vVar = (v) sVar;
            if (vVar.b() instanceof com.baidu.adp.lib.cache.o) {
                com.baidu.adp.lib.cache.c b = ((com.baidu.adp.lib.cache.o) vVar.b()).b();
                return b.b(b.d().a(), vVar.a());
            }
            return null;
        }
        return null;
    }
}
