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
    public static List<o.b<String>> b(com.baidu.adp.lib.cache.o<String> oVar) {
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
                o.b bVar = new o.b();
                bVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                bVar.tv = cursor.getLong(cursor.getColumnIndex("saveTime"));
                bVar.te = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                bVar.sl = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(bVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    com.baidu.adp.lib.g.a.b(cursor);
                    Collections.sort(linkedList, new a(null));
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                }
            }
        }
        Collections.sort(linkedList, new a(null));
        return linkedList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [109=4] */
    /* JADX WARN: Type inference failed for: r4v11, types: [byte[], T] */
    public static List<o.b<byte[]>> c(com.baidu.adp.lib.cache.o<byte[]> oVar) {
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
                o.b bVar = new o.b();
                bVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                bVar.tv = cursor.getLong(cursor.getColumnIndex("saveTime"));
                bVar.te = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                bVar.sl = cursor.getBlob(cursor.getColumnIndex("m_value"));
                linkedList.add(bVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    com.baidu.adp.lib.g.a.b(cursor);
                    Collections.sort(linkedList, new a(null));
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.g.a.b(cursor);
                }
            }
        }
        Collections.sort(linkedList, new a(null));
        return linkedList;
    }

    private static Cursor d(com.baidu.adp.lib.cache.o<?> oVar) {
        if (oVar != null && (oVar instanceof o.c)) {
            o.c cVar = (o.c) oVar;
            if (cVar.go() instanceof com.baidu.adp.lib.cache.k) {
                com.baidu.adp.lib.cache.c gk = ((com.baidu.adp.lib.cache.k) cVar.go()).gk();
                return gk.d(gk.ga().dL(), cVar.gn());
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes.dex */
    private static class a implements Comparator<o.b<?>> {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(o.b<?> bVar, o.b<?> bVar2) {
            if (bVar.tv == bVar2.tv) {
                return 0;
            }
            return bVar.tv > bVar2.tv ? -1 : 1;
        }
    }
}
