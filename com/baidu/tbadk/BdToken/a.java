package com.baidu.tbadk.BdToken;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final a va() {
        return C0151a.ajv;
    }

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0151a {
        private static final a ajv = new a();
    }

    public synchronized boolean a(b bVar) {
        SQLiteDatabase ge = TiebaDatabase.getInstance().getMainDBDatabaseManager().ge();
        ge.beginTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityid", Integer.valueOf(bVar.getActivityId()));
        contentValues.put("missionid", Integer.valueOf(bVar.vh()));
        contentValues.put("activitysource", bVar.vi());
        contentValues.put("calltype", Integer.valueOf(bVar.vj()));
        contentValues.put("tasktype", Integer.valueOf(bVar.getTaskType()));
        contentValues.put("browsetimepage", bVar.vk());
        contentValues.put("browsetime", Long.valueOf(bVar.vm()));
        contentValues.put("threadnum", Integer.valueOf(bVar.getThreadNum()));
        contentValues.put("forumnum", Integer.valueOf(bVar.vn()));
        contentValues.put("cleartype", Integer.valueOf(bVar.vo()));
        contentValues.put("cleartime", Long.valueOf(bVar.vp()));
        contentValues.put("specificcleartime", Long.valueOf(bVar.vq()));
        contentValues.put("tid", Long.valueOf(bVar.getTid()));
        contentValues.put(ImageViewerConfig.FORUM_ID, Long.valueOf(bVar.getFid()));
        contentValues.put("threadtext", bVar.vr());
        contentValues.put("threadimg", bVar.vs());
        contentValues.put("threadforum", Long.valueOf(bVar.vt()));
        ge.insert("activity_mission_info", null, contentValues);
        ge.setTransactionSuccessful();
        ge.endTransaction();
        return true;
    }

    public synchronized boolean v(int i, int i2) {
        SQLiteDatabase ge = TiebaDatabase.getInstance().getMainDBDatabaseManager().ge();
        ge.beginTransaction();
        ge.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(i), String.valueOf(i2)});
        ge.setTransactionSuccessful();
        ge.endTransaction();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [207=4] */
    public synchronized List<b> vb() {
        LinkedList linkedList;
        Cursor cursor;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase ge = mainDBDatabaseManager.ge();
        ge.beginTransaction();
        linkedList = new LinkedList();
        try {
            cursor = ge.rawQuery("SELECT * FROM activity_mission_info", null);
            while (cursor.moveToNext()) {
                try {
                    b bVar = new b();
                    bVar.setActivityId(cursor.getInt(cursor.getColumnIndex("activityid")));
                    bVar.bS(cursor.getInt(cursor.getColumnIndex("missionid")));
                    bVar.dw(cursor.getString(cursor.getColumnIndex("activitysource")));
                    bVar.bT(cursor.getInt(cursor.getColumnIndex("calltype")));
                    bVar.bU(cursor.getInt(cursor.getColumnIndex("tasktype")));
                    bVar.dx(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                    bVar.w(cursor.getLong(cursor.getColumnIndex("browsetime")));
                    bVar.setThreadNum(cursor.getInt(cursor.getColumnIndex("threadnum")));
                    bVar.bV(cursor.getInt(cursor.getColumnIndex("forumnum")));
                    bVar.bW(cursor.getInt(cursor.getColumnIndex("cleartype")));
                    bVar.x(cursor.getLong(cursor.getColumnIndex("cleartime")));
                    bVar.y(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                    bVar.setTid(cursor.getLong(cursor.getColumnIndex("tid")));
                    bVar.setFid(cursor.getLong(cursor.getColumnIndex(ImageViewerConfig.FORUM_ID)));
                    bVar.dy(cursor.getString(cursor.getColumnIndex("threadtext")));
                    bVar.dz(cursor.getString(cursor.getColumnIndex("threadimg")));
                    bVar.z(cursor.getInt(cursor.getColumnIndex("threadforum")));
                    linkedList.add(bVar);
                } catch (Throwable th) {
                    th = th;
                    mainDBDatabaseManager.a(th, "EmotionsDBManager.getAllActivityMissionInfo");
                    com.baidu.adp.lib.util.n.e(cursor);
                    ge.endTransaction();
                    linkedList = null;
                    return linkedList;
                }
            }
            ge.setTransactionSuccessful();
            com.baidu.adp.lib.util.n.e(cursor);
            ge.endTransaction();
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return linkedList;
    }
}
