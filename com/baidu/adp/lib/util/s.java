package com.baidu.adp.lib.util;

import android.database.Cursor;
import com.baidu.adp.lib.cache.o;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=4] */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.String] */
    public static List<o.c<String>> b(com.baidu.adp.lib.cache.o<String> oVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = d(oVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                o.c cVar = new o.c();
                cVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                cVar.my = cursor.getLong(cursor.getColumnIndex("saveTime"));
                cVar.mi = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                cVar.lp = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(cVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    com.baidu.adp.lib.h.a.a(cursor);
                    Collections.sort(linkedList, new a(null));
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                }
            }
        }
        Collections.sort(linkedList, new a(null));
        return linkedList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [109=4] */
    /* JADX WARN: Type inference failed for: r4v11, types: [byte[], T] */
    public static List<o.c<byte[]>> c(com.baidu.adp.lib.cache.o<byte[]> oVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = d(oVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                o.c cVar = new o.c();
                cVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                cVar.my = cursor.getLong(cursor.getColumnIndex("saveTime"));
                cVar.mi = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                cVar.lp = cursor.getBlob(cursor.getColumnIndex("m_value"));
                linkedList.add(cVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    com.baidu.adp.lib.h.a.a(cursor);
                    Collections.sort(linkedList, new a(null));
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.h.a.a(cursor);
                }
            }
        }
        Collections.sort(linkedList, new a(null));
        return linkedList;
    }

    private static Cursor d(com.baidu.adp.lib.cache.o<?> oVar) {
        if (oVar != null && (oVar instanceof o.d)) {
            o.d dVar = (o.d) oVar;
            if (dVar.dE() instanceof com.baidu.adp.lib.cache.k) {
                com.baidu.adp.lib.cache.c dA = ((com.baidu.adp.lib.cache.k) dVar.dE()).dA();
                return dA.d(dA.ds().aZ(), dVar.dD());
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes.dex */
    private static class a implements Comparator<o.c<?>> {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(o.c<?> cVar, o.c<?> cVar2) {
            if (cVar.my == cVar2.my) {
                return 0;
            }
            return cVar.my > cVar2.my ? -1 : 1;
        }
    }
}
