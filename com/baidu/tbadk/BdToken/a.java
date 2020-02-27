package com.baidu.tbadk.BdToken;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.TiebaDatabase;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final a awT() {
        return C0370a.cGt;
    }

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0370a {
        private static final a cGt = new a();
    }

    public synchronized long a(b bVar) {
        long j;
        Throwable th;
        SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
        openedDatabase.beginTransaction();
        try {
            j = a(openedDatabase, bVar);
            try {
                openedDatabase.setTransactionSuccessful();
                openedDatabase.endTransaction();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                openedDatabase.endTransaction();
                return j;
            }
        } catch (Throwable th3) {
            j = -1;
            th = th3;
        }
        return j;
    }

    public synchronized long b(b bVar) {
        long j;
        j = -1;
        if (bVar != null) {
            SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
            openedDatabase.beginTransaction();
            j = b(openedDatabase, bVar);
            openedDatabase.setTransactionSuccessful();
            openedDatabase.endTransaction();
        }
        return j;
    }

    public synchronized boolean c(b bVar) {
        boolean z = false;
        synchronized (this) {
            if (bVar != null) {
                SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
                openedDatabase.beginTransaction();
                int delete = openedDatabase.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.axh())});
                openedDatabase.setTransactionSuccessful();
                openedDatabase.endTransaction();
                z = delete >= 0;
            }
        }
        return z;
    }

    public synchronized List<b> awU() {
        LinkedList linkedList;
        SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
        openedDatabase.beginTransaction();
        linkedList = new LinkedList();
        Cursor rawQuery = openedDatabase.rawQuery("SELECT * FROM activity_mission_info", null);
        while (rawQuery.moveToNext()) {
            b t = t(rawQuery);
            if (t != null) {
                linkedList.add(t);
            }
        }
        openedDatabase.setTransactionSuccessful();
        com.baidu.adp.lib.util.n.close(rawQuery);
        openedDatabase.endTransaction();
        return linkedList;
    }

    private b t(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        b bVar = new b();
        bVar.setActivityId(cursor.getInt(cursor.getColumnIndex("activityid")));
        bVar.jd(cursor.getInt(cursor.getColumnIndex("missionid")));
        bVar.rv(cursor.getString(cursor.getColumnIndex("activitysource")));
        bVar.je(cursor.getInt(cursor.getColumnIndex("calltype")));
        bVar.jf(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
        bVar.rw(cursor.getString(cursor.getColumnIndex("browsetimepage")));
        bVar.bo(cursor.getLong(cursor.getColumnIndex("browsetime")));
        bVar.setThreadNum(cursor.getInt(cursor.getColumnIndex("threadnum")));
        bVar.jg(cursor.getInt(cursor.getColumnIndex("forumnum")));
        bVar.jh(cursor.getInt(cursor.getColumnIndex("cleartype")));
        bVar.bp(cursor.getLong(cursor.getColumnIndex("cleartime")));
        bVar.bq(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
        bVar.setTid(cursor.getLong(cursor.getColumnIndex("tid")));
        bVar.setFid(cursor.getLong(cursor.getColumnIndex("fid")));
        bVar.rx(cursor.getString(cursor.getColumnIndex("threadtext")));
        bVar.ry(cursor.getString(cursor.getColumnIndex("threadimg")));
        bVar.br(cursor.getInt(cursor.getColumnIndex("threadforum")));
        bVar.ji(cursor.getInt(cursor.getColumnIndex("totalLimit")));
        bVar.jj(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
        bVar.N(bVar.getTaskType(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
        bVar.setToken(cursor.getString(cursor.getColumnIndex("token")));
        return bVar;
    }

    private ContentValues d(b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityid", Integer.valueOf(bVar.getActivityId()));
        contentValues.put("missionid", Integer.valueOf(bVar.axh()));
        contentValues.put("activitysource", bVar.axi());
        contentValues.put("calltype", Integer.valueOf(bVar.axk()));
        contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(bVar.getTaskType()));
        contentValues.put("browsetimepage", bVar.axl());
        contentValues.put("browsetime", Long.valueOf(bVar.axn()));
        contentValues.put("threadnum", Integer.valueOf(bVar.getThreadNum()));
        contentValues.put("forumnum", Integer.valueOf(bVar.axo()));
        contentValues.put("cleartype", Integer.valueOf(bVar.axp()));
        contentValues.put("cleartime", Long.valueOf(bVar.axq()));
        contentValues.put("specificcleartime", Long.valueOf(bVar.axr()));
        contentValues.put("tid", Long.valueOf(bVar.getTid()));
        contentValues.put("fid", Long.valueOf(bVar.getFid()));
        contentValues.put("threadtext", bVar.axs());
        contentValues.put("threadimg", bVar.axt());
        contentValues.put("threadforum", Long.valueOf(bVar.axu()));
        contentValues.put("totalLimit", Integer.valueOf(bVar.axv()));
        contentValues.put("completedLimitCount", Integer.valueOf(bVar.getTag()));
        contentValues.put("token", bVar.getToken());
        contentValues.put("executingMissionList", bVar.awZ());
        return contentValues;
    }

    private long a(SQLiteDatabase sQLiteDatabase, b bVar) {
        try {
            return sQLiteDatabase.insert("activity_mission_info", null, d(bVar));
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    private long b(SQLiteDatabase sQLiteDatabase, b bVar) {
        try {
            return sQLiteDatabase.update("activity_mission_info", d(bVar), "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.axh())});
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public synchronized void ao(List<b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
            openedDatabase.beginTransaction();
            for (b bVar : list) {
                a(openedDatabase, bVar);
            }
            openedDatabase.setTransactionSuccessful();
            openedDatabase.endTransaction();
        }
    }

    public synchronized void ap(List<b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
            openedDatabase.beginTransaction();
            for (b bVar : list) {
                b(openedDatabase, bVar);
            }
            openedDatabase.setTransactionSuccessful();
            openedDatabase.endTransaction();
        }
    }
}
