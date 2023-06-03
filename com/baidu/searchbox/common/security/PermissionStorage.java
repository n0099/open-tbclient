package com.baidu.searchbox.common.security;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class PermissionStorage {
    public static final String DB_NAME = "searchbox_permission.db";
    public static final int DB_VERSION = 1;
    public static final boolean DEBUG = SecurityConfig.DEBUG;
    public static final String TAG = "PermissionStorage";
    public static volatile PermissionStorage sInstance;
    public DbOpenHelper mOpenHelper = new DbOpenHelper(AppRuntime.getAppContext(), DB_NAME, 1);

    /* loaded from: classes3.dex */
    public static final class DbOpenHelper extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public DbOpenHelper(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(PermissionStorage.getCreatePermissionTableSQL());
        }
    }

    public static PermissionStorage getInstance() {
        if (sInstance == null) {
            synchronized (PermissionStorage.class) {
                if (sInstance == null) {
                    sInstance = new PermissionStorage();
                }
            }
        }
        return sInstance;
    }

    /* loaded from: classes3.dex */
    public static class PermissionItem {
        public static final String ITEM_EXT_0 = "ext0";
        public static final String ITEM_EXT_1 = "ext1";
        public static final String ITEM_EXT_2 = "ext2";
        public static final String ITEM_EXT_3 = "ext3";
        public static final String ITEM_EXT_4 = "ext4";
        public static final String ITEM_EXT_5 = "ext5";
        public static final String ITEM_EXT_6 = "ext6";
        public static final String ITEM_HOST = "host";
        public static final String ITEM_ID = "_id";
        public static final String ITEM_MODE = "mode";
        public static final String ITEM_OP = "op";
        public static final String ITEM_TS = "ts";
        public static final String ITEM_TYPE = "type";
        public static final String TABLE_NAME = "permissions";
        public String host;
        public long id;
        public int mode;
        public int op;
        public long ts;
        public int type;

        public static PermissionItem createFromCursor(Cursor cursor) throws SQLiteException {
            PermissionItem permissionItem = new PermissionItem();
            if (cursor == null) {
                return permissionItem;
            }
            int columnIndex = cursor.getColumnIndex("host");
            if (columnIndex >= 0) {
                permissionItem.host = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("_id");
            if (columnIndex2 >= 0) {
                permissionItem.id = cursor.getLong(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("type");
            if (columnIndex3 >= 0) {
                permissionItem.type = cursor.getInt(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("mode");
            if (columnIndex4 >= 0) {
                permissionItem.mode = cursor.getInt(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("op");
            if (columnIndex5 >= 0) {
                permissionItem.op = cursor.getInt(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("ts");
            if (columnIndex6 >= 0) {
                permissionItem.ts = cursor.getLong(columnIndex6);
            }
            return permissionItem;
        }
    }

    public static String getCreatePermissionTableSQL() {
        return "CREATE TABLE permissions (_id INTEGER PRIMARY KEY AUTOINCREMENT,op INTEGER DEFAULT 0,mode INTEGER DEFAULT 0,ts INTEGER DEFAULT 0,type INTEGER DEFAULT 0,host TEXT," + PermissionItem.ITEM_EXT_0 + " TEXT," + PermissionItem.ITEM_EXT_1 + " TEXT," + PermissionItem.ITEM_EXT_2 + " TEXT," + PermissionItem.ITEM_EXT_3 + " TEXT," + PermissionItem.ITEM_EXT_4 + " TEXT," + PermissionItem.ITEM_EXT_5 + " TEXT," + PermissionItem.ITEM_EXT_6 + " TEXT);";
    }

    public PermissionItem queryPermissionItemByOpAndHost(int i, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = this.mOpenHelper.getReadableDatabase().rawQuery("SELECT * FROM permissions WHERE op=? AND host =?", new String[]{String.valueOf(i), str});
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        PermissionItem createFromCursor = PermissionItem.createFromCursor(cursor);
                        Closeables.closeSafely(cursor);
                        return createFromCursor;
                    }
                } catch (SQLiteException unused) {
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    Closeables.closeSafely(cursor2);
                    throw th;
                }
            }
        } catch (SQLiteException unused2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
        Closeables.closeSafely(cursor);
        return null;
    }

    public void updateOrInsertPermissionItem(PermissionItem permissionItem) {
        try {
            SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("mode", Integer.valueOf(permissionItem.mode));
            contentValues.put("ts", Long.valueOf(permissionItem.ts));
            if (writableDatabase.update("permissions", contentValues, "op=? AND host =?", new String[]{String.valueOf(permissionItem.op), permissionItem.host}) == 0) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("op", Integer.valueOf(permissionItem.op));
                contentValues2.put("host", permissionItem.host);
                contentValues2.put("mode", Integer.valueOf(permissionItem.mode));
                contentValues2.put("ts", Long.valueOf(permissionItem.ts));
                writableDatabase.insert("permissions", null, contentValues2);
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "[up] ", e);
            }
        }
    }
}
