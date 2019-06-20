package com.baidu.tbadk.BdToken;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final a XG() {
        return C0232a.bwF;
    }

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0232a {
        private static final a bwF = new a();
    }

    public synchronized long a(b bVar) {
        long j;
        Throwable th;
        SQLiteDatabase eT = TiebaDatabase.getInstance().getMainDBDatabaseManager().eT();
        eT.beginTransaction();
        try {
            j = a(eT, bVar);
            try {
                eT.setTransactionSuccessful();
                eT.endTransaction();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                eT.endTransaction();
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
            SQLiteDatabase eT = TiebaDatabase.getInstance().getMainDBDatabaseManager().eT();
            eT.beginTransaction();
            j = b(eT, bVar);
            eT.setTransactionSuccessful();
            eT.endTransaction();
        }
        return j;
    }

    public synchronized boolean c(b bVar) {
        boolean z = false;
        synchronized (this) {
            if (bVar != null) {
                SQLiteDatabase eT = TiebaDatabase.getInstance().getMainDBDatabaseManager().eT();
                eT.beginTransaction();
                int delete = eT.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.XU())});
                eT.setTransactionSuccessful();
                eT.endTransaction();
                z = delete >= 0;
            }
        }
        return z;
    }

    public synchronized List<b> XH() {
        LinkedList linkedList;
        SQLiteDatabase eT = TiebaDatabase.getInstance().getMainDBDatabaseManager().eT();
        eT.beginTransaction();
        linkedList = new LinkedList();
        Cursor rawQuery = eT.rawQuery("SELECT * FROM activity_mission_info", null);
        while (rawQuery.moveToNext()) {
            b r = r(rawQuery);
            if (r != null) {
                linkedList.add(r);
            }
        }
        eT.setTransactionSuccessful();
        com.baidu.adp.lib.util.n.e(rawQuery);
        eT.endTransaction();
        return linkedList;
    }

    private b r(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        b bVar = new b();
        bVar.setActivityId(cursor.getInt(cursor.getColumnIndex("activityid")));
        bVar.gc(cursor.getInt(cursor.getColumnIndex("missionid")));
        bVar.ld(cursor.getString(cursor.getColumnIndex("activitysource")));
        bVar.gd(cursor.getInt(cursor.getColumnIndex("calltype")));
        bVar.ge(cursor.getInt(cursor.getColumnIndex("tasktype")));
        bVar.le(cursor.getString(cursor.getColumnIndex("browsetimepage")));
        bVar.aj(cursor.getLong(cursor.getColumnIndex("browsetime")));
        bVar.setThreadNum(cursor.getInt(cursor.getColumnIndex("threadnum")));
        bVar.gf(cursor.getInt(cursor.getColumnIndex("forumnum")));
        bVar.gg(cursor.getInt(cursor.getColumnIndex("cleartype")));
        bVar.ak(cursor.getLong(cursor.getColumnIndex("cleartime")));
        bVar.al(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
        bVar.setTid(cursor.getLong(cursor.getColumnIndex("tid")));
        bVar.setFid(cursor.getLong(cursor.getColumnIndex("fid")));
        bVar.lf(cursor.getString(cursor.getColumnIndex("threadtext")));
        bVar.lg(cursor.getString(cursor.getColumnIndex("threadimg")));
        bVar.am(cursor.getInt(cursor.getColumnIndex("threadforum")));
        bVar.gh(cursor.getInt(cursor.getColumnIndex("totalLimit")));
        bVar.gi(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
        bVar.y(bVar.getTaskType(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
        return bVar;
    }

    private ContentValues d(b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityid", Integer.valueOf(bVar.getActivityId()));
        contentValues.put("missionid", Integer.valueOf(bVar.XU()));
        contentValues.put("activitysource", bVar.XV());
        contentValues.put("calltype", Integer.valueOf(bVar.XX()));
        contentValues.put("tasktype", Integer.valueOf(bVar.getTaskType()));
        contentValues.put("browsetimepage", bVar.XY());
        contentValues.put("browsetime", Long.valueOf(bVar.Ya()));
        contentValues.put("threadnum", Integer.valueOf(bVar.getThreadNum()));
        contentValues.put("forumnum", Integer.valueOf(bVar.Yb()));
        contentValues.put("cleartype", Integer.valueOf(bVar.Yc()));
        contentValues.put("cleartime", Long.valueOf(bVar.Yd()));
        contentValues.put("specificcleartime", Long.valueOf(bVar.Ye()));
        contentValues.put("tid", Long.valueOf(bVar.getTid()));
        contentValues.put("fid", Long.valueOf(bVar.getFid()));
        contentValues.put("threadtext", bVar.Yf());
        contentValues.put("threadimg", bVar.Yg());
        contentValues.put("threadforum", Long.valueOf(bVar.Yh()));
        contentValues.put("totalLimit", Integer.valueOf(bVar.Yi()));
        contentValues.put("completedLimitCount", Integer.valueOf(bVar.getTag()));
        contentValues.put("executingMissionList", bVar.XM());
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
            return sQLiteDatabase.update("activity_mission_info", d(bVar), "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.XU())});
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public synchronized void K(List<b> list) {
        if (!v.aa(list)) {
            SQLiteDatabase eT = TiebaDatabase.getInstance().getMainDBDatabaseManager().eT();
            eT.beginTransaction();
            for (b bVar : list) {
                a(eT, bVar);
            }
            eT.setTransactionSuccessful();
            eT.endTransaction();
        }
    }

    public synchronized void L(List<b> list) {
        if (!v.aa(list)) {
            SQLiteDatabase eT = TiebaDatabase.getInstance().getMainDBDatabaseManager().eT();
            eT.beginTransaction();
            for (b bVar : list) {
                b(eT, bVar);
            }
            eT.setTransactionSuccessful();
            eT.endTransaction();
        }
    }
}
