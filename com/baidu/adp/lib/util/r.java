package com.baidu.adp.lib.util;

import android.database.Cursor;
import com.baidu.adp.lib.cache.l;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.String] */
    public static List<l.b<String>> b(com.baidu.adp.lib.cache.l<String> lVar) {
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
                l.b bVar = new l.b();
                bVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                bVar.lastSaveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                bVar.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                bVar.value = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(bVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    Collections.sort(linkedList, new a());
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.f.a.close(cursor);
                }
            }
        }
        com.baidu.adp.lib.f.a.close(cursor);
        Collections.sort(linkedList, new a());
        return linkedList;
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [byte[], T] */
    public static List<l.b<byte[]>> c(com.baidu.adp.lib.cache.l<byte[]> lVar) {
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
                l.b bVar = new l.b();
                bVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                bVar.lastSaveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                bVar.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                bVar.value = cursor.getBlob(cursor.getColumnIndex("m_value"));
                linkedList.add(bVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    Collections.sort(linkedList, new a());
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.f.a.close(cursor);
                }
            }
        }
        com.baidu.adp.lib.f.a.close(cursor);
        Collections.sort(linkedList, new a());
        return linkedList;
    }

    private static Cursor d(com.baidu.adp.lib.cache.l<?> lVar) {
        if (lVar != null && (lVar instanceof l.c)) {
            l.c cVar = (l.c) lVar;
            if (cVar.fB() instanceof com.baidu.adp.lib.cache.j) {
                com.baidu.adp.lib.cache.c fy = ((com.baidu.adp.lib.cache.j) cVar.fB()).fy();
                return fy.queryAllForNameSpace(fy.fv().getOpenedDatabase(), cVar.getNameSpace());
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Comparator<l.b<?>> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(l.b<?> bVar, l.b<?> bVar2) {
            if (bVar.lastSaveTime == bVar2.lastSaveTime) {
                return 0;
            }
            return bVar.lastSaveTime > bVar2.lastSaveTime ? -1 : 1;
        }
    }
}
