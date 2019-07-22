package com.baidu.tbadk.BdToken;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.TiebaDatabase;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final a YC() {
        return C0229a.bxw;
    }

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0229a {
        private static final a bxw = new a();
    }

    public synchronized long a(b bVar) {
        long j;
        Throwable th;
        SQLiteDatabase fa = TiebaDatabase.getInstance().getMainDBDatabaseManager().fa();
        fa.beginTransaction();
        try {
            j = a(fa, bVar);
            try {
                fa.setTransactionSuccessful();
                fa.endTransaction();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                fa.endTransaction();
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
            SQLiteDatabase fa = TiebaDatabase.getInstance().getMainDBDatabaseManager().fa();
            fa.beginTransaction();
            j = b(fa, bVar);
            fa.setTransactionSuccessful();
            fa.endTransaction();
        }
        return j;
    }

    public synchronized boolean c(b bVar) {
        boolean z = false;
        synchronized (this) {
            if (bVar != null) {
                SQLiteDatabase fa = TiebaDatabase.getInstance().getMainDBDatabaseManager().fa();
                fa.beginTransaction();
                int delete = fa.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.YQ())});
                fa.setTransactionSuccessful();
                fa.endTransaction();
                z = delete >= 0;
            }
        }
        return z;
    }

    public synchronized List<b> YD() {
        LinkedList linkedList;
        SQLiteDatabase fa = TiebaDatabase.getInstance().getMainDBDatabaseManager().fa();
        fa.beginTransaction();
        linkedList = new LinkedList();
        Cursor rawQuery = fa.rawQuery("SELECT * FROM activity_mission_info", null);
        while (rawQuery.moveToNext()) {
            b r = r(rawQuery);
            if (r != null) {
                linkedList.add(r);
            }
        }
        fa.setTransactionSuccessful();
        com.baidu.adp.lib.util.n.e(rawQuery);
        fa.endTransaction();
        return linkedList;
    }

    private b r(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        b bVar = new b();
        bVar.setActivityId(cursor.getInt(cursor.getColumnIndex("activityid")));
        bVar.gg(cursor.getInt(cursor.getColumnIndex("missionid")));
        bVar.ll(cursor.getString(cursor.getColumnIndex("activitysource")));
        bVar.gh(cursor.getInt(cursor.getColumnIndex("calltype")));
        bVar.gi(cursor.getInt(cursor.getColumnIndex("tasktype")));
        bVar.lm(cursor.getString(cursor.getColumnIndex("browsetimepage")));
        bVar.ak(cursor.getLong(cursor.getColumnIndex("browsetime")));
        bVar.setThreadNum(cursor.getInt(cursor.getColumnIndex("threadnum")));
        bVar.gj(cursor.getInt(cursor.getColumnIndex("forumnum")));
        bVar.gk(cursor.getInt(cursor.getColumnIndex("cleartype")));
        bVar.al(cursor.getLong(cursor.getColumnIndex("cleartime")));
        bVar.am(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
        bVar.setTid(cursor.getLong(cursor.getColumnIndex("tid")));
        bVar.setFid(cursor.getLong(cursor.getColumnIndex("fid")));
        bVar.ln(cursor.getString(cursor.getColumnIndex("threadtext")));
        bVar.lo(cursor.getString(cursor.getColumnIndex("threadimg")));
        bVar.an(cursor.getInt(cursor.getColumnIndex("threadforum")));
        bVar.gl(cursor.getInt(cursor.getColumnIndex("totalLimit")));
        bVar.gm(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
        bVar.y(bVar.getTaskType(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
        return bVar;
    }

    private ContentValues d(b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityid", Integer.valueOf(bVar.getActivityId()));
        contentValues.put("missionid", Integer.valueOf(bVar.YQ()));
        contentValues.put("activitysource", bVar.YR());
        contentValues.put("calltype", Integer.valueOf(bVar.YT()));
        contentValues.put("tasktype", Integer.valueOf(bVar.getTaskType()));
        contentValues.put("browsetimepage", bVar.YU());
        contentValues.put("browsetime", Long.valueOf(bVar.YW()));
        contentValues.put("threadnum", Integer.valueOf(bVar.getThreadNum()));
        contentValues.put("forumnum", Integer.valueOf(bVar.YX()));
        contentValues.put("cleartype", Integer.valueOf(bVar.YY()));
        contentValues.put("cleartime", Long.valueOf(bVar.YZ()));
        contentValues.put("specificcleartime", Long.valueOf(bVar.Za()));
        contentValues.put("tid", Long.valueOf(bVar.getTid()));
        contentValues.put("fid", Long.valueOf(bVar.getFid()));
        contentValues.put("threadtext", bVar.Zb());
        contentValues.put("threadimg", bVar.Zc());
        contentValues.put("threadforum", Long.valueOf(bVar.Zd()));
        contentValues.put("totalLimit", Integer.valueOf(bVar.Ze()));
        contentValues.put("completedLimitCount", Integer.valueOf(bVar.getTag()));
        contentValues.put("executingMissionList", bVar.YI());
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
            return sQLiteDatabase.update("activity_mission_info", d(bVar), "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.getActivityId()), String.valueOf(bVar.YQ())});
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public synchronized void K(List<b> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            SQLiteDatabase fa = TiebaDatabase.getInstance().getMainDBDatabaseManager().fa();
            fa.beginTransaction();
            for (b bVar : list) {
                a(fa, bVar);
            }
            fa.setTransactionSuccessful();
            fa.endTransaction();
        }
    }

    public synchronized void L(List<b> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            SQLiteDatabase fa = TiebaDatabase.getInstance().getMainDBDatabaseManager().fa();
            fa.beginTransaction();
            for (b bVar : list) {
                b(fa, bVar);
            }
            fa.setTransactionSuccessful();
            fa.endTransaction();
        }
    }
}
