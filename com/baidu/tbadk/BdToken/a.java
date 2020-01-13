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
    public static final a auF() {
        return C0360a.cCv;
    }

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0360a {
        private static final a cCv = new a();
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
                int delete = openedDatabase.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.auT())});
                openedDatabase.setTransactionSuccessful();
                openedDatabase.endTransaction();
                z = delete >= 0;
            }
        }
        return z;
    }

    public synchronized List<b> auG() {
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
        bVar.iM(cursor.getInt(cursor.getColumnIndex("missionid")));
        bVar.rg(cursor.getString(cursor.getColumnIndex("activitysource")));
        bVar.iN(cursor.getInt(cursor.getColumnIndex("calltype")));
        bVar.iO(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
        bVar.rh(cursor.getString(cursor.getColumnIndex("browsetimepage")));
        bVar.bk(cursor.getLong(cursor.getColumnIndex("browsetime")));
        bVar.setThreadNum(cursor.getInt(cursor.getColumnIndex("threadnum")));
        bVar.iP(cursor.getInt(cursor.getColumnIndex("forumnum")));
        bVar.iQ(cursor.getInt(cursor.getColumnIndex("cleartype")));
        bVar.bl(cursor.getLong(cursor.getColumnIndex("cleartime")));
        bVar.bm(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
        bVar.setTid(cursor.getLong(cursor.getColumnIndex("tid")));
        bVar.setFid(cursor.getLong(cursor.getColumnIndex("fid")));
        bVar.ri(cursor.getString(cursor.getColumnIndex("threadtext")));
        bVar.rj(cursor.getString(cursor.getColumnIndex("threadimg")));
        bVar.bn(cursor.getInt(cursor.getColumnIndex("threadforum")));
        bVar.iR(cursor.getInt(cursor.getColumnIndex("totalLimit")));
        bVar.iS(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
        bVar.L(bVar.getTaskType(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
        bVar.setToken(cursor.getString(cursor.getColumnIndex("token")));
        return bVar;
    }

    private ContentValues d(b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityid", Integer.valueOf(bVar.getActivityId()));
        contentValues.put("missionid", Integer.valueOf(bVar.auT()));
        contentValues.put("activitysource", bVar.auU());
        contentValues.put("calltype", Integer.valueOf(bVar.auW()));
        contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(bVar.getTaskType()));
        contentValues.put("browsetimepage", bVar.auX());
        contentValues.put("browsetime", Long.valueOf(bVar.auZ()));
        contentValues.put("threadnum", Integer.valueOf(bVar.getThreadNum()));
        contentValues.put("forumnum", Integer.valueOf(bVar.ava()));
        contentValues.put("cleartype", Integer.valueOf(bVar.avb()));
        contentValues.put("cleartime", Long.valueOf(bVar.avc()));
        contentValues.put("specificcleartime", Long.valueOf(bVar.avd()));
        contentValues.put("tid", Long.valueOf(bVar.getTid()));
        contentValues.put("fid", Long.valueOf(bVar.getFid()));
        contentValues.put("threadtext", bVar.ave());
        contentValues.put("threadimg", bVar.avf());
        contentValues.put("threadforum", Long.valueOf(bVar.avg()));
        contentValues.put("totalLimit", Integer.valueOf(bVar.avh()));
        contentValues.put("completedLimitCount", Integer.valueOf(bVar.getTag()));
        contentValues.put("token", bVar.getToken());
        contentValues.put("executingMissionList", bVar.auL());
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
            return sQLiteDatabase.update("activity_mission_info", d(bVar), "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.auT())});
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
