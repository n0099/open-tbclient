package com.baidu.adp.lib.util;

import android.database.Cursor;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=4] */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.String] */
    public static List<com.baidu.adp.lib.cache.v<String>> b(com.baidu.adp.lib.cache.t<String> tVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = d(tVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                com.baidu.adp.lib.cache.v vVar = new com.baidu.adp.lib.cache.v();
                vVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                vVar.fN = cursor.getLong(cursor.getColumnIndex("saveTime"));
                vVar.fy = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                vVar.value = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(vVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    com.baidu.adp.lib.g.a.a(cursor);
                    Collections.sort(linkedList, new t(null));
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                }
            }
        }
        Collections.sort(linkedList, new t(null));
        return linkedList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [109=4] */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, byte[]] */
    public static List<com.baidu.adp.lib.cache.v<byte[]>> c(com.baidu.adp.lib.cache.t<byte[]> tVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = d(tVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                com.baidu.adp.lib.cache.v vVar = new com.baidu.adp.lib.cache.v();
                vVar.key = cursor.getString(cursor.getColumnIndex("m_key"));
                vVar.fN = cursor.getLong(cursor.getColumnIndex("saveTime"));
                vVar.fy = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                vVar.value = cursor.getBlob(cursor.getColumnIndex("m_value"));
                linkedList.add(vVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    com.baidu.adp.lib.g.a.a(cursor);
                    Collections.sort(linkedList, new t(null));
                    return linkedList;
                } finally {
                    com.baidu.adp.lib.g.a.a(cursor);
                }
            }
        }
        Collections.sort(linkedList, new t(null));
        return linkedList;
    }

    private static Cursor d(com.baidu.adp.lib.cache.t<?> tVar) {
        if (tVar != null && (tVar instanceof com.baidu.adp.lib.cache.w)) {
            com.baidu.adp.lib.cache.w wVar = (com.baidu.adp.lib.cache.w) tVar;
            if (wVar.cu() instanceof com.baidu.adp.lib.cache.p) {
                com.baidu.adp.lib.cache.c cq = ((com.baidu.adp.lib.cache.p) wVar.cu()).cq();
                return cq.c(cq.ch().P(), wVar.ct());
            }
            return null;
        }
        return null;
    }
}
