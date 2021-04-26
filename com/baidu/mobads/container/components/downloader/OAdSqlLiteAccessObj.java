package com.baidu.mobads.container.components.downloader;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.mobads.container.util.ProcessUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class OAdSqlLiteAccessObj {
    public static final String TAG = "OAdSqlLiteAccessObj";
    public OAdSqlLiteHelper mDBHelper;
    public String processName;

    public OAdSqlLiteAccessObj(Context context) {
        this.mDBHelper = new OAdSqlLiteHelper(context);
        this.processName = ProcessUtils.getInstance().getCurrentProcessName(context);
    }

    public void closeDb() {
        try {
            this.mDBHelper.close();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(TAG, e2.getMessage());
        }
    }

    public void delete(OAdSqlLiteDownloadingInfo oAdSqlLiteDownloadingInfo) {
        try {
            SQLiteDatabase readableDatabase = this.mDBHelper.getReadableDatabase();
            readableDatabase.delete(OAdSqlLiteHelper.TABLE_NAME, "url=? and local_file=? and process_name=?", new String[]{oAdSqlLiteDownloadingInfo.getURL(), oAdSqlLiteDownloadingInfo.getDownloadedFilePath(), this.processName});
            readableDatabase.close();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(TAG, e2.getMessage());
        }
    }

    public boolean isHasInfors(String str, String str2) {
        Cursor rawQuery = this.mDBHelper.getReadableDatabase().rawQuery("select count(*)  from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.processName});
        rawQuery.moveToFirst();
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        return i2 > 0;
    }

    public List<OAdSqlLiteDownloadingInfo> query(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 1;
        int i4 = 2;
        Cursor rawQuery = this.mDBHelper.getReadableDatabase().rawQuery("select thread_id, url, local_file, start_pos, end_pos,compelete_size from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.processName});
        while (rawQuery.moveToNext()) {
            arrayList.add(new OAdSqlLiteDownloadingInfo(rawQuery.getInt(i2), rawQuery.getString(i3), rawQuery.getString(i4), rawQuery.getInt(3), rawQuery.getInt(4), rawQuery.getInt(5)));
            i2 = 0;
            i3 = 1;
            i4 = 2;
        }
        rawQuery.close();
        return arrayList;
    }

    public void saveInfos(List<OAdSqlLiteDownloadingInfo> list) {
        SQLiteDatabase writableDatabase = this.mDBHelper.getWritableDatabase();
        for (OAdSqlLiteDownloadingInfo oAdSqlLiteDownloadingInfo : list) {
            try {
                writableDatabase.execSQL("insert into download_info(thread_id,url,local_file,start_pos,end_pos,compelete_size,process_name) values (?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(oAdSqlLiteDownloadingInfo.getThreadId()), oAdSqlLiteDownloadingInfo.getURL(), oAdSqlLiteDownloadingInfo.getDownloadedFilePath(), Long.valueOf(oAdSqlLiteDownloadingInfo.getStartPos()), Long.valueOf(oAdSqlLiteDownloadingInfo.getEndPos()), Long.valueOf(oAdSqlLiteDownloadingInfo.getDownloadedContentLength()), this.processName});
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(TAG, e2.getMessage());
            }
        }
    }

    public void updataInfos(List<OAdSqlLiteDownloadingInfo> list) {
        SQLiteDatabase readableDatabase = this.mDBHelper.getReadableDatabase();
        for (OAdSqlLiteDownloadingInfo oAdSqlLiteDownloadingInfo : list) {
            try {
                readableDatabase.execSQL("update download_info set compelete_size=? where thread_id=? and url=? and local_file=? and process_name=?", new Object[]{Long.valueOf(oAdSqlLiteDownloadingInfo.getDownloadedContentLength()), Integer.valueOf(oAdSqlLiteDownloadingInfo.getThreadId()), oAdSqlLiteDownloadingInfo.getURL(), oAdSqlLiteDownloadingInfo.getDownloadedFilePath(), this.processName});
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(TAG, e2.getMessage());
            }
        }
    }
}
