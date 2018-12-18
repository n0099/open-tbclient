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

    public synchronized List<b> vb() {
        LinkedList linkedList;
        SQLiteDatabase ge = TiebaDatabase.getInstance().getMainDBDatabaseManager().ge();
        ge.beginTransaction();
        linkedList = new LinkedList();
        Cursor rawQuery = ge.rawQuery("SELECT * FROM activity_mission_info", null);
        while (rawQuery.moveToNext()) {
            b bVar = new b();
            bVar.setActivityId(rawQuery.getInt(rawQuery.getColumnIndex("activityid")));
            bVar.bS(rawQuery.getInt(rawQuery.getColumnIndex("missionid")));
            bVar.dw(rawQuery.getString(rawQuery.getColumnIndex("activitysource")));
            bVar.bT(rawQuery.getInt(rawQuery.getColumnIndex("calltype")));
            bVar.bU(rawQuery.getInt(rawQuery.getColumnIndex("tasktype")));
            bVar.dx(rawQuery.getString(rawQuery.getColumnIndex("browsetimepage")));
            bVar.w(rawQuery.getLong(rawQuery.getColumnIndex("browsetime")));
            bVar.setThreadNum(rawQuery.getInt(rawQuery.getColumnIndex("threadnum")));
            bVar.bV(rawQuery.getInt(rawQuery.getColumnIndex("forumnum")));
            bVar.bW(rawQuery.getInt(rawQuery.getColumnIndex("cleartype")));
            bVar.x(rawQuery.getLong(rawQuery.getColumnIndex("cleartime")));
            bVar.y(rawQuery.getLong(rawQuery.getColumnIndex("specificcleartime")));
            bVar.setTid(rawQuery.getLong(rawQuery.getColumnIndex("tid")));
            bVar.setFid(rawQuery.getLong(rawQuery.getColumnIndex(ImageViewerConfig.FORUM_ID)));
            bVar.dy(rawQuery.getString(rawQuery.getColumnIndex("threadtext")));
            bVar.dz(rawQuery.getString(rawQuery.getColumnIndex("threadimg")));
            bVar.z(rawQuery.getInt(rawQuery.getColumnIndex("threadforum")));
            linkedList.add(bVar);
        }
        ge.setTransactionSuccessful();
        com.baidu.adp.lib.util.n.e(rawQuery);
        ge.endTransaction();
        return linkedList;
    }
}
