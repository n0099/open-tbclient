package com.baidu.tbadk.BdToken;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.TiebaDatabase;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final a adv() {
        return C0275a.bQA;
    }

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0275a {
        private static final a bQA = new a();
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
                int delete = openedDatabase.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.adJ())});
                openedDatabase.setTransactionSuccessful();
                openedDatabase.endTransaction();
                z = delete >= 0;
            }
        }
        return z;
    }

    public synchronized List<b> adw() {
        LinkedList linkedList;
        SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
        openedDatabase.beginTransaction();
        linkedList = new LinkedList();
        Cursor rawQuery = openedDatabase.rawQuery("SELECT * FROM activity_mission_info", null);
        while (rawQuery.moveToNext()) {
            b q = q(rawQuery);
            if (q != null) {
                linkedList.add(q);
            }
        }
        openedDatabase.setTransactionSuccessful();
        com.baidu.adp.lib.util.n.close(rawQuery);
        openedDatabase.endTransaction();
        return linkedList;
    }

    private b q(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        b bVar = new b();
        bVar.setActivityId(cursor.getInt(cursor.getColumnIndex("activityid")));
        bVar.hc(cursor.getInt(cursor.getColumnIndex("missionid")));
        bVar.lQ(cursor.getString(cursor.getColumnIndex("activitysource")));
        bVar.hd(cursor.getInt(cursor.getColumnIndex("calltype")));
        bVar.he(cursor.getInt(cursor.getColumnIndex("tasktype")));
        bVar.lR(cursor.getString(cursor.getColumnIndex("browsetimepage")));
        bVar.aD(cursor.getLong(cursor.getColumnIndex("browsetime")));
        bVar.setThreadNum(cursor.getInt(cursor.getColumnIndex("threadnum")));
        bVar.hf(cursor.getInt(cursor.getColumnIndex("forumnum")));
        bVar.hg(cursor.getInt(cursor.getColumnIndex("cleartype")));
        bVar.aE(cursor.getLong(cursor.getColumnIndex("cleartime")));
        bVar.aF(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
        bVar.setTid(cursor.getLong(cursor.getColumnIndex("tid")));
        bVar.setFid(cursor.getLong(cursor.getColumnIndex("fid")));
        bVar.lS(cursor.getString(cursor.getColumnIndex("threadtext")));
        bVar.lT(cursor.getString(cursor.getColumnIndex("threadimg")));
        bVar.aG(cursor.getInt(cursor.getColumnIndex("threadforum")));
        bVar.hh(cursor.getInt(cursor.getColumnIndex("totalLimit")));
        bVar.hi(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
        bVar.C(bVar.getTaskType(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
        return bVar;
    }

    private ContentValues d(b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityid", Integer.valueOf(bVar.getActivityId()));
        contentValues.put("missionid", Integer.valueOf(bVar.adJ()));
        contentValues.put("activitysource", bVar.adK());
        contentValues.put("calltype", Integer.valueOf(bVar.adM()));
        contentValues.put("tasktype", Integer.valueOf(bVar.getTaskType()));
        contentValues.put("browsetimepage", bVar.adN());
        contentValues.put("browsetime", Long.valueOf(bVar.adP()));
        contentValues.put("threadnum", Integer.valueOf(bVar.getThreadNum()));
        contentValues.put("forumnum", Integer.valueOf(bVar.adQ()));
        contentValues.put("cleartype", Integer.valueOf(bVar.adR()));
        contentValues.put("cleartime", Long.valueOf(bVar.adS()));
        contentValues.put("specificcleartime", Long.valueOf(bVar.adT()));
        contentValues.put("tid", Long.valueOf(bVar.getTid()));
        contentValues.put("fid", Long.valueOf(bVar.getFid()));
        contentValues.put("threadtext", bVar.adU());
        contentValues.put("threadimg", bVar.adV());
        contentValues.put("threadforum", Long.valueOf(bVar.adW()));
        contentValues.put("totalLimit", Integer.valueOf(bVar.adX()));
        contentValues.put("completedLimitCount", Integer.valueOf(bVar.getTag()));
        contentValues.put("executingMissionList", bVar.adB());
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
            return sQLiteDatabase.update("activity_mission_info", d(bVar), "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.adJ())});
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public synchronized void aj(List<b> list) {
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

    public synchronized void ak(List<b> list) {
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
