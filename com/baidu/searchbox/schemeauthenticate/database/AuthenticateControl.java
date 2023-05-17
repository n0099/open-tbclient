package com.baidu.searchbox.schemeauthenticate.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.schemeauthenticate.database.BaseDBControl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public final class AuthenticateControl extends BaseDBControl {
    public static final boolean DEBUG = AppConfig.isDebug();
    @SuppressLint({"StaticFieldLeak"})
    public static volatile AuthenticateControl sInstance = null;
    public static final String TAG = AuthenticateControl.class.getSimpleName();

    /* loaded from: classes4.dex */
    public static class AuthenticateItem {
        public long expireTime;
        public String schemeList;
        public String signKey;
        public String type;
        public String url;
    }

    public static String getCreateMsgTableSql() {
        return "CREATE TABLE scheme_auth_table (id INTEGER PRIMARY KEY  AUTOINCREMENT,url TEXT,scheme_list TEXT,expire_time INTEGER,type TEXT,update_time LONG,sign_key TEXT UNIQUE  );";
    }

    /* loaded from: classes4.dex */
    public class TableColumn {
        public static final String COLUMN_EXPIRE_TIME = "expire_time";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SCHEME_LIST = "scheme_list";
        public static final String COLUMN_SIGN_KEY = "sign_key";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_UPDATE_TIME = "update_time";
        public static final String COLUMN_URL = "url";
        public static final String TABLE_NAME = "scheme_auth_table";

        public TableColumn() {
        }
    }

    public AuthenticateControl(Context context, Executor executor, SQLiteOpenHelper sQLiteOpenHelper) {
        super(context, executor, sQLiteOpenHelper);
    }

    public static AuthenticateControl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AuthenticateControl.class) {
                if (sInstance == null) {
                    Context applicationContext = context.getApplicationContext();
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                    sInstance = new AuthenticateControl(applicationContext, newSingleThreadExecutor, BaseDBControl.DbOpenHelper.getInstance(applicationContext, BaseDBControl.DB_NAME, BaseDBControl.DB_VERSION, newSingleThreadExecutor));
                }
            }
        }
        return sInstance;
    }

    public boolean clearExpireItem(final long j) {
        if (DEBUG) {
            String str = TAG;
            Log.i(str, "clearExpireItem currentTime:" + j);
        }
        return runTransactionSyncWithReturn(new SQLiteTransaction() { // from class: com.baidu.searchbox.schemeauthenticate.database.AuthenticateControl.2
            @Override // com.baidu.searchbox.schemeauthenticate.database.SQLiteTransaction
            public boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                if (sQLiteDatabase.delete(TableColumn.TABLE_NAME, "expire_time < ? ", new String[]{String.valueOf(j)}) > 0) {
                    return true;
                }
                return false;
            }
        });
    }

    public boolean insertInfo(final AuthenticateItem authenticateItem) {
        return runTransactionSyncWithReturn(new SQLiteTransaction() { // from class: com.baidu.searchbox.schemeauthenticate.database.AuthenticateControl.1
            @Override // com.baidu.searchbox.schemeauthenticate.database.SQLiteTransaction
            public boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("url", authenticateItem.url);
                contentValues.put("expire_time", Long.valueOf(authenticateItem.expireTime));
                contentValues.put("scheme_list", authenticateItem.schemeList);
                contentValues.put("type", authenticateItem.type);
                contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put(TableColumn.COLUMN_SIGN_KEY, authenticateItem.signKey);
                if (sQLiteDatabase.insertWithOnConflict(TableColumn.TABLE_NAME, null, contentValues, 5) > 0) {
                    return true;
                }
                return false;
            }
        });
    }

    public List<AuthenticateItem> getAuthenticateItemList(long j) {
        SQLiteDatabase readableDatabase = this.mOpenHelper.getReadableDatabase();
        String[] strArr = {"scheme_list", "url", "type", "expire_time", TableColumn.COLUMN_SIGN_KEY};
        String[] strArr2 = {String.valueOf(j)};
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = readableDatabase.query(TableColumn.TABLE_NAME, strArr, "expire_time > ?  ", strArr2, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("scheme_list");
                    int columnIndex2 = cursor.getColumnIndex("url");
                    int columnIndex3 = cursor.getColumnIndex("type");
                    int columnIndex4 = cursor.getColumnIndex("expire_time");
                    int columnIndex5 = cursor.getColumnIndex(TableColumn.COLUMN_SIGN_KEY);
                    do {
                        String string = cursor.getString(columnIndex2);
                        String string2 = cursor.getString(columnIndex);
                        String string3 = cursor.getString(columnIndex3);
                        long j2 = cursor.getLong(columnIndex4);
                        String string4 = cursor.getString(columnIndex5);
                        AuthenticateItem authenticateItem = new AuthenticateItem();
                        authenticateItem.schemeList = string2;
                        authenticateItem.expireTime = j2;
                        authenticateItem.type = string3;
                        authenticateItem.url = string;
                        authenticateItem.signKey = string4;
                        arrayList.add(authenticateItem);
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                if (DEBUG) {
                    String str = TAG;
                    Log.e(str, "getAuthenticateItemList e:" + e);
                }
            }
            return arrayList;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }
}
