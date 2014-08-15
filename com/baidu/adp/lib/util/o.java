package com.baidu.adp.lib.util;

import android.database.Cursor;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.cache.v;
import com.baidu.adp.lib.cache.w;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=4] */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.String] */
    public static List<v<String>> a(t<String> tVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = b(tVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                v vVar = new v();
                vVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                vVar.c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                vVar.d = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                vVar.b = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(vVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    com.baidu.adp.lib.e.a.a(cursor);
                    Collections.sort(linkedList, new p(null));
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.e.a.a(cursor);
                }
            }
        }
        Collections.sort(linkedList, new p(null));
        return linkedList;
    }

    private static Cursor b(t<?> tVar) {
        if (tVar != null && (tVar instanceof w)) {
            w wVar = (w) tVar;
            if (wVar.b() instanceof com.baidu.adp.lib.cache.p) {
                com.baidu.adp.lib.cache.c b = ((com.baidu.adp.lib.cache.p) wVar.b()).b();
                return b.b(b.d().a(), wVar.a());
            }
            return null;
        }
        return null;
    }
}
