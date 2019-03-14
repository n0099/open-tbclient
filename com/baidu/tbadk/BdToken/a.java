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
    public static final a TF() {
        return C0218a.bqk;
    }

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0218a {
        private static final a bqk = new a();
    }

    public synchronized boolean a(b bVar) {
        SQLiteDatabase ga = TiebaDatabase.getInstance().getMainDBDatabaseManager().ga();
        ga.beginTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityid", Integer.valueOf(bVar.getActivityId()));
        contentValues.put("missionid", Integer.valueOf(bVar.TM()));
        contentValues.put("activitysource", bVar.TN());
        contentValues.put("calltype", Integer.valueOf(bVar.TO()));
        contentValues.put("tasktype", Integer.valueOf(bVar.getTaskType()));
        contentValues.put("browsetimepage", bVar.TP());
        contentValues.put("browsetime", Long.valueOf(bVar.TR()));
        contentValues.put("threadnum", Integer.valueOf(bVar.getThreadNum()));
        contentValues.put("forumnum", Integer.valueOf(bVar.TS()));
        contentValues.put("cleartype", Integer.valueOf(bVar.TT()));
        contentValues.put("cleartime", Long.valueOf(bVar.TU()));
        contentValues.put("specificcleartime", Long.valueOf(bVar.TV()));
        contentValues.put("tid", Long.valueOf(bVar.getTid()));
        contentValues.put(ImageViewerConfig.FORUM_ID, Long.valueOf(bVar.getFid()));
        contentValues.put("threadtext", bVar.TW());
        contentValues.put("threadimg", bVar.TX());
        contentValues.put("threadforum", Long.valueOf(bVar.TY()));
        ga.insert("activity_mission_info", null, contentValues);
        ga.setTransactionSuccessful();
        ga.endTransaction();
        return true;
    }

    public synchronized boolean Q(int i, int i2) {
        SQLiteDatabase ga = TiebaDatabase.getInstance().getMainDBDatabaseManager().ga();
        ga.beginTransaction();
        ga.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(i), String.valueOf(i2)});
        ga.setTransactionSuccessful();
        ga.endTransaction();
        return true;
    }

    public synchronized List<b> TG() {
        LinkedList linkedList;
        SQLiteDatabase ga = TiebaDatabase.getInstance().getMainDBDatabaseManager().ga();
        ga.beginTransaction();
        linkedList = new LinkedList();
        Cursor rawQuery = ga.rawQuery("SELECT * FROM activity_mission_info", null);
        while (rawQuery.moveToNext()) {
            b bVar = new b();
            bVar.setActivityId(rawQuery.getInt(rawQuery.getColumnIndex("activityid")));
            bVar.fu(rawQuery.getInt(rawQuery.getColumnIndex("missionid")));
            bVar.kd(rawQuery.getString(rawQuery.getColumnIndex("activitysource")));
            bVar.fv(rawQuery.getInt(rawQuery.getColumnIndex("calltype")));
            bVar.fw(rawQuery.getInt(rawQuery.getColumnIndex("tasktype")));
            bVar.ke(rawQuery.getString(rawQuery.getColumnIndex("browsetimepage")));
            bVar.Y(rawQuery.getLong(rawQuery.getColumnIndex("browsetime")));
            bVar.setThreadNum(rawQuery.getInt(rawQuery.getColumnIndex("threadnum")));
            bVar.fx(rawQuery.getInt(rawQuery.getColumnIndex("forumnum")));
            bVar.fy(rawQuery.getInt(rawQuery.getColumnIndex("cleartype")));
            bVar.Z(rawQuery.getLong(rawQuery.getColumnIndex("cleartime")));
            bVar.aa(rawQuery.getLong(rawQuery.getColumnIndex("specificcleartime")));
            bVar.setTid(rawQuery.getLong(rawQuery.getColumnIndex("tid")));
            bVar.setFid(rawQuery.getLong(rawQuery.getColumnIndex(ImageViewerConfig.FORUM_ID)));
            bVar.kf(rawQuery.getString(rawQuery.getColumnIndex("threadtext")));
            bVar.kg(rawQuery.getString(rawQuery.getColumnIndex("threadimg")));
            bVar.ab(rawQuery.getInt(rawQuery.getColumnIndex("threadforum")));
            linkedList.add(bVar);
        }
        ga.setTransactionSuccessful();
        com.baidu.adp.lib.util.n.e(rawQuery);
        ga.endTransaction();
        return linkedList;
    }
}
