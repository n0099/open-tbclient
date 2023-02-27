package com.baidu.searchbox.cloudcommand.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CloudCommandDao {
    public static CloudCommandDao mInstance;
    public SQLiteDatabase mDB = CommandDatabaseHelper.getDatabase();

    public static synchronized CloudCommandDao getInstance() {
        CloudCommandDao cloudCommandDao;
        synchronized (CloudCommandDao.class) {
            if (mInstance == null) {
                mInstance = new CloudCommandDao();
            }
            cloudCommandDao = mInstance;
        }
        return cloudCommandDao;
    }

    public boolean addCommand(String str, String str2, int i, String str3, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", str);
        contentValues.put("msgId", str2);
        contentValues.put(CloudCommandTable.DISPATCHED, Integer.valueOf(i));
        contentValues.put("version", str3);
        contentValues.put("timestamp", Long.valueOf(j));
        if (this.mDB.insert(CloudCommandTable.TABLE_NAME, null, contentValues) != -1) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0070, code lost:
        if (r1 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0072, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0075, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0067, code lost:
        if (r1 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<CloudCommandBean> queryAll() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDB.query(CloudCommandTable.TABLE_NAME, null, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    CloudCommandBean cloudCommandBean = new CloudCommandBean();
                    cloudCommandBean.setType(cursor.getString(cursor.getColumnIndex("type")));
                    cloudCommandBean.setMsgId(cursor.getString(cursor.getColumnIndex("msgId")));
                    cloudCommandBean.setDispatched(cursor.getInt(cursor.getColumnIndex(CloudCommandTable.DISPATCHED)));
                    cloudCommandBean.setVersion(cursor.getString(cursor.getColumnIndex("version")));
                    cloudCommandBean.setTimeStamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
                    arrayList.add(cloudCommandBean);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008a, code lost:
        if (r1 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x008c, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008f, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0081, code lost:
        if (r1 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<CloudCommandBean> queryDispatched(String str, int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabase = this.mDB;
                cursor = sQLiteDatabase.query(CloudCommandTable.TABLE_NAME, null, "msgId =? and dispatched =?", new String[]{str, i + ""}, null, null, null);
                while (cursor.moveToNext()) {
                    CloudCommandBean cloudCommandBean = new CloudCommandBean();
                    cloudCommandBean.setType(cursor.getString(cursor.getColumnIndex("type")));
                    cloudCommandBean.setMsgId(cursor.getString(cursor.getColumnIndex("msgId")));
                    cloudCommandBean.setDispatched(cursor.getInt(cursor.getColumnIndex(CloudCommandTable.DISPATCHED)));
                    cloudCommandBean.setVersion(cursor.getString(cursor.getColumnIndex("version")));
                    cloudCommandBean.setTimeStamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
                    arrayList.add(cloudCommandBean);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
