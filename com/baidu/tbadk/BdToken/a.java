package com.baidu.tbadk.BdToken;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static final a aXO() {
        return C0531a.dNo;
    }

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0531a {
        private static final a dNo = new a();
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
                int delete = openedDatabase.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.aYc())});
                openedDatabase.setTransactionSuccessful();
                openedDatabase.endTransaction();
                z = delete >= 0;
            }
        }
        return z;
    }

    public synchronized List<b> aXP() {
        LinkedList linkedList;
        SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
        openedDatabase.beginTransaction();
        linkedList = new LinkedList();
        Cursor rawQuery = openedDatabase.rawQuery("SELECT * FROM activity_mission_info", null);
        while (rawQuery.moveToNext()) {
            b w = w(rawQuery);
            if (w != null) {
                linkedList.add(w);
            }
        }
        openedDatabase.setTransactionSuccessful();
        com.baidu.adp.lib.util.n.close(rawQuery);
        openedDatabase.endTransaction();
        return linkedList;
    }

    private b w(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        b bVar = new b();
        bVar.setActivityId(cursor.getInt(cursor.getColumnIndex("activityid")));
        bVar.mw(cursor.getInt(cursor.getColumnIndex("missionid")));
        bVar.xI(cursor.getString(cursor.getColumnIndex("activitysource")));
        bVar.mx(cursor.getInt(cursor.getColumnIndex("calltype")));
        bVar.my(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
        bVar.xJ(cursor.getString(cursor.getColumnIndex("browsetimepage")));
        bVar.cs(cursor.getLong(cursor.getColumnIndex("browsetime")));
        bVar.setThreadNum(cursor.getInt(cursor.getColumnIndex("threadnum")));
        bVar.mz(cursor.getInt(cursor.getColumnIndex("forumnum")));
        bVar.mA(cursor.getInt(cursor.getColumnIndex("cleartype")));
        bVar.ct(cursor.getLong(cursor.getColumnIndex("cleartime")));
        bVar.cu(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
        bVar.setTid(cursor.getLong(cursor.getColumnIndex("tid")));
        bVar.setFid(cursor.getLong(cursor.getColumnIndex("fid")));
        bVar.xK(cursor.getString(cursor.getColumnIndex("threadtext")));
        bVar.xL(cursor.getString(cursor.getColumnIndex("threadimg")));
        bVar.cv(cursor.getInt(cursor.getColumnIndex("threadforum")));
        bVar.mB(cursor.getInt(cursor.getColumnIndex("totalLimit")));
        bVar.mC(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
        bVar.aj(bVar.getTaskType(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
        bVar.setToken(cursor.getString(cursor.getColumnIndex("token")));
        return bVar;
    }

    private ContentValues d(b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityid", Integer.valueOf(bVar.getActivityId()));
        contentValues.put("missionid", Integer.valueOf(bVar.aYc()));
        contentValues.put("activitysource", bVar.aYd());
        contentValues.put("calltype", Integer.valueOf(bVar.aYf()));
        contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(bVar.getTaskType()));
        contentValues.put("browsetimepage", bVar.aYg());
        contentValues.put("browsetime", Long.valueOf(bVar.aYi()));
        contentValues.put("threadnum", Integer.valueOf(bVar.getThreadNum()));
        contentValues.put("forumnum", Integer.valueOf(bVar.aYj()));
        contentValues.put("cleartype", Integer.valueOf(bVar.aYk()));
        contentValues.put("cleartime", Long.valueOf(bVar.aYl()));
        contentValues.put("specificcleartime", Long.valueOf(bVar.aYm()));
        contentValues.put("tid", Long.valueOf(bVar.getTid()));
        contentValues.put("fid", Long.valueOf(bVar.getFid()));
        contentValues.put("threadtext", bVar.aYn());
        contentValues.put("threadimg", bVar.aYo());
        contentValues.put("threadforum", Long.valueOf(bVar.aYp()));
        contentValues.put("totalLimit", Integer.valueOf(bVar.aYq()));
        contentValues.put("completedLimitCount", Integer.valueOf(bVar.getTag()));
        contentValues.put("token", bVar.getToken());
        contentValues.put("executingMissionList", bVar.aXU());
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
            return sQLiteDatabase.update("activity_mission_info", d(bVar), "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.aYc())});
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public synchronized void aC(List<b> list) {
        if (!y.isEmpty(list)) {
            SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
            openedDatabase.beginTransaction();
            for (b bVar : list) {
                a(openedDatabase, bVar);
            }
            openedDatabase.setTransactionSuccessful();
            openedDatabase.endTransaction();
        }
    }

    public synchronized void aD(List<b> list) {
        if (!y.isEmpty(list)) {
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
