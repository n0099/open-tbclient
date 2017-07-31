package com.baidu.adp.lib.util;

import android.database.Cursor;
import com.baidu.adp.lib.cache.l;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.String] */
    public static List<l.c<String>> b(com.baidu.adp.lib.cache.l<String> lVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = d(lVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                l.c cVar = new l.c();
                cVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                cVar.vt = cursor.getLong(cursor.getColumnIndex("saveTime"));
                cVar.ve = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                cVar.um = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(cVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    Collections.sort(linkedList, new a());
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                }
            }
        }
        com.baidu.adp.lib.g.a.e(cursor);
        Collections.sort(linkedList, new a());
        return linkedList;
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [T, byte[]] */
    public static List<l.c<byte[]>> c(com.baidu.adp.lib.cache.l<byte[]> lVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = d(lVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                l.c cVar = new l.c();
                cVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                cVar.vt = cursor.getLong(cursor.getColumnIndex("saveTime"));
                cVar.ve = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                cVar.um = cursor.getBlob(cursor.getColumnIndex("m_value"));
                linkedList.add(cVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    Collections.sort(linkedList, new a());
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.g.a.e(cursor);
                }
            }
        }
        com.baidu.adp.lib.g.a.e(cursor);
        Collections.sort(linkedList, new a());
        return linkedList;
    }

    private static Cursor d(com.baidu.adp.lib.cache.l<?> lVar) {
        if (lVar != null && (lVar instanceof l.d)) {
            l.d dVar = (l.d) lVar;
            if (dVar.eT() instanceof com.baidu.adp.lib.cache.j) {
                com.baidu.adp.lib.cache.c eP = ((com.baidu.adp.lib.cache.j) dVar.eT()).eP();
                return eP.d(eP.eH().cs(), dVar.eS());
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Comparator<l.c<?>> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(l.c<?> cVar, l.c<?> cVar2) {
            if (cVar.vt == cVar2.vt) {
                return 0;
            }
            return cVar.vt > cVar2.vt ? -1 : 1;
        }
    }
}
