package com.baidu.searchbox.aideviceperformance.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.baidu.searchbox.aideviceperformance.data.DBItemModel;
import com.baidu.searchbox.aideviceperformance.data.DBTableConfig;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LaunchTimeSQLiteOpenHelper extends DataBaseOpenHelper {
    public static final boolean DEBUG = Config.isDebug();
    public static String TAG = "LaunchTimeSQLiteOpenHelper";
    public static LaunchTimeSQLiteOpenHelper instance;

    @Override // com.baidu.searchbox.aideviceperformance.data.DataBaseOpenHelper
    public String getBatchDeleteSqlStr() {
        return "delete from app_launch_time where event_time in ( select event_time from app_launch_time order by event_time limit 50)";
    }

    @Override // com.baidu.searchbox.aideviceperformance.data.DataBaseOpenHelper
    public int getRestrictionNum() {
        return 150;
    }

    public void deleteAll() {
        deleteAll("app_launch_time");
    }

    @Override // com.baidu.searchbox.aideviceperformance.data.DataBaseOpenHelper
    public Boolean isEnableCountRestriction() {
        return Boolean.TRUE;
    }

    public List<DBItemModel.LaunchTimeItemModel> queryAll() {
        return query(null);
    }

    public LaunchTimeSQLiteOpenHelper(Context context) {
        super(context, DBTableConfig.LaunchTimeDBTable.DB_NAME, 1);
    }

    public static LaunchTimeSQLiteOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new LaunchTimeSQLiteOpenHelper(context);
        }
        return instance;
    }

    public void insert(ContentValues contentValues) {
        insert("app_launch_time", contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL(DBTableConfig.LaunchTimeDBTable.CREATE_TABLE_SQL);
        }
    }

    public void delete(DBItemModel.LaunchTimeItemModel launchTimeItemModel) {
        if (DEBUG) {
            String str = TAG;
            Log.d(str, "delete item: " + launchTimeItemModel.launchTime + " " + launchTimeItemModel.timeStamp);
        }
        delete("app_launch_time", "app_launch_time=? AND event_time=?", new String[]{String.valueOf(launchTimeItemModel.launchTime), String.valueOf(launchTimeItemModel.timeStamp)});
    }

    public void insert(DBItemModel.LaunchTimeItemModel launchTimeItemModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_launch_time", Long.valueOf(launchTimeItemModel.launchTime));
        contentValues.put("event_time", Long.valueOf(launchTimeItemModel.timeStamp));
        if (DEBUG) {
            String str = TAG;
            Log.d(str, "insert item launchTime: " + launchTimeItemModel.launchTime + " timeStamp: " + launchTimeItemModel.timeStamp);
        }
        insert(contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<DBItemModel.LaunchTimeItemModel> query(DBItemModel.LaunchTimeItemModel launchTimeItemModel) {
        Cursor cursor;
        Cursor query;
        ArrayList arrayList;
        Cursor cursor2 = null;
        try {
            try {
                if (launchTimeItemModel == null) {
                    query = query("app_launch_time", null, null, null, null, null, null);
                } else {
                    query = query("app_launch_time", "app_launch_time=" + launchTimeItemModel.launchTime + " AND event_time=" + launchTimeItemModel.timeStamp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                arrayList = new ArrayList();
            } catch (Exception e2) {
                cursor = query;
                e = e2;
                try {
                    if (DEBUG) {
                        Log.w(TAG, "", e);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                cursor2 = query;
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        if (query != null) {
            while (query.moveToNext()) {
                arrayList.add(new DBItemModel.LaunchTimeItemModel(query.getLong(query.getColumnIndex("app_launch_time")), query.getLong(query.getColumnIndex("event_time"))));
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            return arrayList;
        }
        if (query != null) {
            query.close();
        }
        return null;
    }

    public List<DBItemModel.LaunchTimeItemModel> queryLast(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = query("app_launch_time", null, null, null, null, null, "ROWID DESC", String.valueOf(i));
                } catch (Exception e) {
                    if (DEBUG) {
                        Log.w(TAG, "", e);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(new DBItemModel.LaunchTimeItemModel(cursor.getLong(cursor.getColumnIndex("app_launch_time")), cursor.getLong(cursor.getColumnIndex("event_time"))));
                }
                return arrayList;
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void update(DBItemModel.LaunchTimeItemModel launchTimeItemModel, DBItemModel.LaunchTimeItemModel launchTimeItemModel2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_launch_time", Long.valueOf(launchTimeItemModel2.launchTime));
        contentValues.put("event_time", Long.valueOf(launchTimeItemModel2.timeStamp));
        if (DEBUG) {
            String str = TAG;
            Log.d(str, "update origin item: " + launchTimeItemModel.launchTime + " " + launchTimeItemModel.timeStamp + " change item : " + launchTimeItemModel2.launchTime + " " + launchTimeItemModel2.timeStamp);
        }
        update("app_launch_time", contentValues, "app_launch_time=? AND event_time=?", new String[]{String.valueOf(launchTimeItemModel.launchTime), String.valueOf(launchTimeItemModel.timeStamp)});
    }
}
