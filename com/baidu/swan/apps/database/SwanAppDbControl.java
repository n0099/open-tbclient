package com.baidu.swan.apps.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.database.cloudconfig.SwanAppConfTokenTable;
import com.baidu.swan.apps.database.favorite.c;
import com.baidu.swan.apps.database.subpackage.SubPackageTable;
import com.tencent.connect.common.Constants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class SwanAppDbControl {
    private static volatile SwanAppDbControl aOh;
    private static b aOi;
    private static Executor aOj;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int DB_VERSION = 15;

    /* loaded from: classes2.dex */
    public enum SwanAppTable {
        _id,
        app_id,
        app_key,
        version,
        description,
        error_code,
        error_detail,
        error_msg,
        resume_date,
        icon,
        icon_url,
        max_swan_version,
        min_swan_version,
        name,
        service_category,
        subject_info,
        bear_info,
        sign,
        type,
        is_have_zip,
        app_open_url,
        app_download_url,
        target_swan_version,
        app_zip_size,
        pending_aps_errcode,
        version_code,
        app_category,
        orientation,
        max_age,
        create_time,
        force_fetch_meta_info;
        
        public static final String TABLE_NAME = "ai_apps_aps_data";
    }

    public static SwanAppDbControl aZ(Context context) {
        if (aOh == null) {
            synchronized (SwanAppDbControl.class) {
                if (aOh == null) {
                    aOj = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                    aOi = new b(context.getApplicationContext(), "ai_apps.db", DB_VERSION);
                    aOh = new SwanAppDbControl();
                }
            }
        }
        return aOh;
    }

    /* loaded from: classes2.dex */
    public static final class b extends SQLiteOpenHelper {
        public b(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            d(sQLiteDatabase);
            SwanAppConfTokenTable.u(sQLiteDatabase);
            SubPackageTable.y(sQLiteDatabase);
            c.v(sQLiteDatabase);
            com.baidu.swan.apps.database.a.c.w(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (SwanAppDbControl.DEBUG) {
                Log.i("SwanAppDbControl", "DB new version = " + i2 + "DB old version=" + i);
            }
            while (i < i2) {
                switch (i) {
                    case 1:
                        e(sQLiteDatabase);
                        break;
                    case 2:
                        f(sQLiteDatabase);
                        SwanAppConfTokenTable.u(sQLiteDatabase);
                        break;
                    case 3:
                        g(sQLiteDatabase);
                        break;
                    case 4:
                        h(sQLiteDatabase);
                        break;
                    case 5:
                        i(sQLiteDatabase);
                        break;
                    case 6:
                        j(sQLiteDatabase);
                        break;
                    case 7:
                        k(sQLiteDatabase);
                        break;
                    case 8:
                        l(sQLiteDatabase);
                        break;
                    case 9:
                        m(sQLiteDatabase);
                        break;
                    case 10:
                        n(sQLiteDatabase);
                        break;
                    case 11:
                        o(sQLiteDatabase);
                        break;
                    case 12:
                        p(sQLiteDatabase);
                        break;
                    case 13:
                        q(sQLiteDatabase);
                        break;
                    case 14:
                        r(sQLiteDatabase);
                        break;
                    case 15:
                        break;
                    default:
                        if (!SwanAppDbControl.DEBUG) {
                            break;
                        } else {
                            throw new IllegalStateException("SwanAppDB do not have this version");
                        }
                }
                i++;
            }
        }

        private void d(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(SwanAppDbControl.Hp());
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        private void e(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_key + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.type + " INTEGER default 0;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void f(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.icon_url + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void g(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_open_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_download_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.target_swan_version + " TEXT;");
                SubPackageTable.y(sQLiteDatabase);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void h(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_zip_size + " LONG;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_app_sub_package_data ADD " + SubPackageTable.Table.version + " TEXT;");
                s(sQLiteDatabase);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void i(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pending_aps_errcode + " INTEGER;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void j(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_app_sub_package_data ADD " + SubPackageTable.Table.aps_package_name + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void k(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.version_code + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void l(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_category + " INTEGER default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.orientation + " INTEGER default 0;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void m(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.max_age + " LONG default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.create_time + " LONG default 0;");
            } catch (SQLException e) {
                if (SwanAppDbControl.DEBUG) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        private void n(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.bear_info + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.force_fetch_meta_info + " INTEGER default 0;");
            } catch (SQLException e) {
                if (SwanAppDbControl.DEBUG) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        private void o(SQLiteDatabase sQLiteDatabase) {
            c.v(sQLiteDatabase);
        }

        private void p(SQLiteDatabase sQLiteDatabase) {
            com.baidu.swan.apps.database.a.c.w(sQLiteDatabase);
            com.baidu.swan.apps.database.a.c.x(sQLiteDatabase);
            t(sQLiteDatabase);
        }

        private void q(SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            try {
                cursor = sQLiteDatabase.query(SubPackageTable.Table.TABLE_NAME, new String[]{SubPackageTable.Table.aps_package_name.name()}, null, null, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                                int columnIndex = cursor.getColumnIndex(SubPackageTable.Table.aps_package_name.name());
                                do {
                                    String string = cursor.getString(columnIndex);
                                    eK(string);
                                    if (SwanAppDbControl.DEBUG) {
                                        Log.i("SwanAppDbControl", "清除APS中小程序分包信息：" + string);
                                    }
                                } while (cursor.moveToNext());
                            }
                        } catch (SQLException e) {
                            e = e;
                            if (SwanAppDbControl.DEBUG) {
                                Log.e("SwanAppDbControl", e.getMessage());
                            }
                            com.baidu.swan.c.a.b(cursor);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.swan.c.a.b(cursor);
                        throw th;
                    }
                }
                com.baidu.swan.c.a.b(cursor);
            } catch (SQLException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                com.baidu.swan.c.a.b(cursor);
                throw th;
            }
        }

        private void r(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_swan_history");
        }

        private void eK(String str) {
            com.baidu.a.a.c.a.F(Constants.VIA_REPORT_TYPE_QQFAVORITES, str);
            com.baidu.a.a.c.a.F("51", str);
        }

        private void s(SQLiteDatabase sQLiteDatabase) {
            String str = "SELECT " + SwanAppTable.app_id + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + SwanAppTable.version + " FROM " + SwanAppTable.TABLE_NAME + " ORDER BY " + SwanAppTable.app_id;
            if (SwanAppDbControl.DEBUG) {
                Log.i("SwanAppDbControl", "swanAppSql:" + str);
            }
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.rawQuery(str, new String[0]);
                if (cursor != null) {
                    a(sQLiteDatabase, cursor);
                }
            } catch (Exception e) {
                if (SwanAppDbControl.DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                com.baidu.swan.c.a.b(cursor);
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
            if (cursor != null && sQLiteDatabase != null) {
                String str = SubPackageTable.Table.app_id + "=?";
                ContentValues contentValues = new ContentValues();
                int columnIndex = cursor.getColumnIndex(SwanAppTable.app_id.name());
                int columnIndex2 = cursor.getColumnIndex(SwanAppTable.version.name());
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(columnIndex);
                        String string2 = cursor.getString(columnIndex2);
                        if (SwanAppDbControl.DEBUG) {
                            Log.i("SwanAppDbControl", "fillSubPackageTableVersion：" + string + ":" + string2);
                        }
                        contentValues.put(SubPackageTable.Table.version.toString(), string2);
                        sQLiteDatabase.update(SubPackageTable.Table.TABLE_NAME, contentValues, str, new String[]{string});
                    } while (cursor.moveToNext());
                }
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
        private void t(SQLiteDatabase sQLiteDatabase) {
            boolean z = false;
            long currentTimeMillis = System.currentTimeMillis();
            List<ContentValues> BC = com.baidu.swan.apps.u.a.JD().BC();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (SwanAppDbControl.DEBUG) {
                Log.d("SwanAppDbControl", "read old history cost" + (currentTimeMillis2 - currentTimeMillis) + "  count:" + (BC == null ? 0 : BC.size()));
            }
            if (BC != null) {
                try {
                    if (BC.size() != 0) {
                        try {
                            sQLiteDatabase.beginTransaction();
                            Iterator<ContentValues> it = BC.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = true;
                                    break;
                                } else if (sQLiteDatabase.insertWithOnConflict("ai_apps_history", null, it.next(), 5) < 0) {
                                    break;
                                }
                            }
                            if (z) {
                                sQLiteDatabase.setTransactionSuccessful();
                            }
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (SwanAppDbControl.DEBUG) {
                            Log.d("SwanAppDbControl", "write new history cost" + (currentTimeMillis3 - currentTimeMillis2));
                            Log.d("SwanAppDbControl", "migrate history total cost" + (currentTimeMillis3 - currentTimeMillis));
                        }
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public SQLiteOpenHelper Ho() {
        return aOi;
    }

    public boolean d(final com.baidu.swan.apps.database.a aVar, boolean z) {
        a aVar2 = new a() { // from class: com.baidu.swan.apps.database.SwanAppDbControl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.apps.database.SwanAppDbControl.a
            protected boolean b(SQLiteDatabase sQLiteDatabase) {
                long insert;
                try {
                    insert = sQLiteDatabase.insert(SwanAppTable.TABLE_NAME, null, SwanAppDbControl.this.d(aVar));
                    if (SwanAppDbControl.DEBUG) {
                        Log.d("SwanAppDbControl", "addAPSFile: insert id is " + insert);
                    }
                } catch (Exception e) {
                    if (SwanAppDbControl.DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (insert != -1) {
                    return true;
                }
                return false;
            }
        };
        if (z) {
            return a(aVar2);
        }
        b(aVar2);
        return true;
    }

    public boolean e(final com.baidu.swan.apps.database.a aVar, boolean z) {
        a aVar2 = new a() { // from class: com.baidu.swan.apps.database.SwanAppDbControl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.apps.database.SwanAppDbControl.a
            protected boolean b(SQLiteDatabase sQLiteDatabase) {
                try {
                    if (sQLiteDatabase.update(SwanAppTable.TABLE_NAME, SwanAppDbControl.this.d(aVar), SwanAppTable.app_id.name() + " =? ", new String[]{aVar.appId}) > 0) {
                        return true;
                    }
                } catch (Exception e) {
                    if (SwanAppDbControl.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        };
        if (z) {
            return a(aVar2);
        }
        b(aVar2);
        return true;
    }

    public boolean j(final boolean z, boolean z2) {
        a aVar = new a() { // from class: com.baidu.swan.apps.database.SwanAppDbControl.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.apps.database.SwanAppDbControl.a
            protected boolean b(SQLiteDatabase sQLiteDatabase) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(z ? 1 : 0));
                try {
                    if (sQLiteDatabase.update(SwanAppTable.TABLE_NAME, contentValues, null, null) > 0) {
                        return true;
                    }
                } catch (Exception e) {
                    if (SwanAppDbControl.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        };
        if (z2) {
            return a(aVar);
        }
        b(aVar);
        return true;
    }

    public void c(com.baidu.swan.apps.database.a aVar) {
        if (!e(aVar, true)) {
            d(aVar, true);
        }
    }

    public boolean r(final String str, boolean z) {
        a aVar = new a() { // from class: com.baidu.swan.apps.database.SwanAppDbControl.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.apps.database.SwanAppDbControl.a
            protected boolean b(SQLiteDatabase sQLiteDatabase) {
                try {
                    if (sQLiteDatabase.delete(SwanAppTable.TABLE_NAME, SwanAppTable.app_id.name() + " =? ", new String[]{str}) > 0) {
                        return true;
                    }
                } catch (Exception e) {
                    if (SwanAppDbControl.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        };
        if (z) {
            return a(aVar);
        }
        b(aVar);
        return true;
    }

    public com.baidu.swan.apps.database.a eI(String str) {
        com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = eJ(str);
                if (cursor != null && cursor.moveToFirst()) {
                    a(cursor, aVar);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                com.baidu.swan.c.a.b(cursor);
            }
        }
        return aVar;
    }

    @WorkerThread
    @NonNull
    public Map<String, Long> S(long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            cursor = aOi.getReadableDatabase().query(SwanAppTable.TABLE_NAME, new String[]{SwanAppTable.app_id.name(), SwanAppTable.create_time.name()}, System.currentTimeMillis() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + SwanAppTable.create_time + ">" + j, null, null, null, SwanAppTable.create_time + " DESC");
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                String string = cursor.getString(cursor.getColumnIndex(SwanAppTable.app_id.name()));
                                long j2 = cursor.getLong(cursor.getColumnIndex(SwanAppTable.create_time.name()));
                                if (string != null) {
                                    linkedHashMap.put(string, Long.valueOf(j2));
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (SQLException e) {
                        e = e;
                        com.baidu.swan.apps.console.c.e("SwanAppDbControl", "querySwanAppIds4PkgClean Error", e);
                        com.baidu.swan.c.a.b(cursor);
                        return linkedHashMap;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    com.baidu.swan.c.a.b(cursor2);
                    throw th;
                }
            }
            com.baidu.swan.c.a.b(cursor);
        } catch (SQLException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.c.a.b(cursor2);
            throw th;
        }
        return linkedHashMap;
    }

    public void a(Cursor cursor, com.baidu.swan.apps.database.a aVar) {
        if (cursor != null && cursor.getCount() > 0) {
            if (DEBUG) {
                Log.d("SwanAppDbControl", "updateQueryAPSFileList: cursor=" + cursor.toString() + ", swanAppDbInfo =" + aVar.toString());
            }
            if (DEBUG) {
                Log.d("SwanAppDbControl", "updateQueryAPSFileList: cursor.getCount()=" + cursor.getCount());
            }
            int columnIndex = cursor.getColumnIndex(SwanAppTable.app_id.name());
            int columnIndex2 = cursor.getColumnIndex(SwanAppTable.app_key.name());
            int columnIndex3 = cursor.getColumnIndex(SwanAppTable.description.name());
            int columnIndex4 = cursor.getColumnIndex(SwanAppTable.error_code.name());
            int columnIndex5 = cursor.getColumnIndex(SwanAppTable.error_detail.name());
            int columnIndex6 = cursor.getColumnIndex(SwanAppTable.error_msg.name());
            int columnIndex7 = cursor.getColumnIndex(SwanAppTable.resume_date.name());
            int columnIndex8 = cursor.getColumnIndex(SwanAppTable.icon.name());
            int columnIndex9 = cursor.getColumnIndex(SwanAppTable.icon_url.name());
            int columnIndex10 = cursor.getColumnIndex(SwanAppTable.max_swan_version.name());
            int columnIndex11 = cursor.getColumnIndex(SwanAppTable.min_swan_version.name());
            int columnIndex12 = cursor.getColumnIndex(SwanAppTable.name.name());
            int columnIndex13 = cursor.getColumnIndex(SwanAppTable.service_category.name());
            int columnIndex14 = cursor.getColumnIndex(SwanAppTable.subject_info.name());
            int columnIndex15 = cursor.getColumnIndex(SwanAppTable.bear_info.name());
            int columnIndex16 = cursor.getColumnIndex(SwanAppTable.sign.name());
            int columnIndex17 = cursor.getColumnIndex(SwanAppTable.type.name());
            int columnIndex18 = cursor.getColumnIndex(SwanAppTable.is_have_zip.name());
            int columnIndex19 = cursor.getColumnIndex(SwanAppTable.version.name());
            int columnIndex20 = cursor.getColumnIndex(SwanAppTable.app_open_url.name());
            int columnIndex21 = cursor.getColumnIndex(SwanAppTable.app_download_url.name());
            int columnIndex22 = cursor.getColumnIndex(SwanAppTable.target_swan_version.name());
            int columnIndex23 = cursor.getColumnIndex(SwanAppTable.app_zip_size.name());
            int columnIndex24 = cursor.getColumnIndex(SwanAppTable.pending_aps_errcode.name());
            int columnIndex25 = cursor.getColumnIndex(SwanAppTable.version_code.name());
            int columnIndex26 = cursor.getColumnIndex(SwanAppTable.app_category.name());
            int columnIndex27 = cursor.getColumnIndex(SwanAppTable.orientation.name());
            int columnIndex28 = cursor.getColumnIndex(SwanAppTable.force_fetch_meta_info.name());
            int columnIndex29 = cursor.getColumnIndex(SwanAppTable.max_age.name());
            int columnIndex30 = cursor.getColumnIndex(SwanAppTable.create_time.name());
            if (!TextUtils.isEmpty(cursor.getString(columnIndex))) {
                aVar.appId = cursor.getString(columnIndex);
                aVar.appKey = cursor.getString(columnIndex2);
                aVar.description = cursor.getString(columnIndex3);
                aVar.errorCode = cursor.getInt(columnIndex4);
                aVar.errorDetail = cursor.getString(columnIndex5);
                aVar.errorMsg = cursor.getString(columnIndex6);
                aVar.aOo = cursor.getString(columnIndex7);
                aVar.icon = cursor.getString(columnIndex8);
                aVar.iconUrl = cursor.getString(columnIndex9);
                aVar.aOp = cursor.getString(columnIndex10);
                aVar.aOq = cursor.getString(columnIndex11);
                aVar.name = cursor.getString(columnIndex12);
                aVar.aOr = cursor.getString(columnIndex13);
                aVar.aOs = cursor.getString(columnIndex14);
                aVar.aOt = cursor.getString(columnIndex15);
                aVar.sign = cursor.getString(columnIndex16);
                aVar.type = cursor.getInt(columnIndex17);
                aVar.aOu = cursor.getInt(columnIndex18);
                aVar.version = cursor.getString(columnIndex19);
                aVar.aOv = cursor.getString(columnIndex20);
                aVar.aOw = cursor.getString(columnIndex21);
                aVar.aOx = cursor.getString(columnIndex22);
                aVar.aOy = cursor.getLong(columnIndex23);
                aVar.aOz = cursor.getInt(columnIndex24);
                aVar.aOA = cursor.getString(columnIndex25);
                aVar.category = cursor.getInt(columnIndex26);
                aVar.orientation = cursor.getInt(columnIndex27);
                aVar.aOB = cursor.getLong(columnIndex29);
                aVar.createTime = cursor.getLong(columnIndex30);
                aVar.aOC = cursor.getInt(columnIndex28) != 0;
            }
        }
    }

    private Cursor eJ(String str) {
        try {
            return aOi.getReadableDatabase().rawQuery("select * from ai_apps_aps_data where " + SwanAppTable.app_id.name() + " = ? ", new String[]{str});
        } catch (SQLException e) {
            if (!DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public static String Hp() {
        return "CREATE TABLE ai_apps_aps_data (" + SwanAppTable._id + " INTEGER PRIMARY KEY AUTOINCREMENT," + SwanAppTable.app_id + " TEXT UNIQUE," + SwanAppTable.app_key + " TEXT," + SwanAppTable.version + " TEXT," + SwanAppTable.description + " TEXT," + SwanAppTable.error_code + " INTEGER," + SwanAppTable.error_detail + " TEXT," + SwanAppTable.error_msg + " TEXT," + SwanAppTable.resume_date + " TEXT," + SwanAppTable.icon + " TEXT," + SwanAppTable.icon_url + " TEXT," + SwanAppTable.max_swan_version + " TEXT," + SwanAppTable.min_swan_version + " TEXT," + SwanAppTable.name + " TEXT," + SwanAppTable.service_category + " TEXT," + SwanAppTable.subject_info + " TEXT," + SwanAppTable.bear_info + " TEXT," + SwanAppTable.sign + " TEXT," + SwanAppTable.type + " INTEGER," + SwanAppTable.is_have_zip + " INTEGER," + SwanAppTable.app_open_url + " TEXT," + SwanAppTable.app_download_url + " TEXT," + SwanAppTable.target_swan_version + " TEXT," + SwanAppTable.app_zip_size + " LONG," + SwanAppTable.pending_aps_errcode + " INTEGER," + SwanAppTable.version_code + " TEXT," + SwanAppTable.app_category + " INTEGER," + SwanAppTable.orientation + " INTEGER," + SwanAppTable.max_age + " LONG," + SwanAppTable.create_time + " LONG" + SwanAppTable.orientation + " INTEGER," + SwanAppTable.force_fetch_meta_info + " INTEGER);";
    }

    public boolean a(a aVar) {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = aOi.getWritableDatabase();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            aVar.c(sQLiteDatabase);
            return aVar.Hr();
        }
        return false;
    }

    public void b(final a aVar) {
        aOj.execute(new Runnable() { // from class: com.baidu.swan.apps.database.SwanAppDbControl.5
            @Override // java.lang.Runnable
            public void run() {
                aVar.c(SwanAppDbControl.aOi.getWritableDatabase());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContentValues d(com.baidu.swan.apps.database.a aVar) {
        ContentValues contentValues = new ContentValues();
        if (aVar.appId != null) {
            contentValues.put(SwanAppTable.app_id.name(), aVar.appId);
        }
        if (aVar.appKey != null) {
            contentValues.put(SwanAppTable.app_key.name(), aVar.appKey);
        }
        if (aVar.description != null) {
            contentValues.put(SwanAppTable.description.name(), aVar.description);
        }
        if (aVar.errorCode >= 0) {
            contentValues.put(SwanAppTable.error_code.name(), Integer.valueOf(aVar.errorCode));
        }
        if (aVar.errorDetail != null) {
            contentValues.put(SwanAppTable.error_detail.name(), aVar.errorDetail);
        }
        if (aVar.errorMsg != null) {
            contentValues.put(SwanAppTable.error_msg.name(), aVar.errorMsg);
        }
        if (aVar.aOo != null) {
            contentValues.put(SwanAppTable.resume_date.name(), aVar.aOo);
        }
        if (aVar.icon != null) {
            contentValues.put(SwanAppTable.icon.name(), aVar.icon);
        }
        if (aVar.iconUrl != null) {
            contentValues.put(SwanAppTable.icon_url.name(), aVar.iconUrl);
        }
        if (aVar.aOp != null) {
            contentValues.put(SwanAppTable.max_swan_version.name(), aVar.aOp);
        }
        if (aVar.aOq != null) {
            contentValues.put(SwanAppTable.min_swan_version.name(), aVar.aOq);
        }
        if (aVar.name != null) {
            contentValues.put(SwanAppTable.name.name(), aVar.name);
        }
        if (aVar.aOr != null) {
            contentValues.put(SwanAppTable.service_category.name(), aVar.aOr);
        }
        if (aVar.aOs != null) {
            contentValues.put(SwanAppTable.subject_info.name(), aVar.aOs);
        }
        if (aVar.aOt != null) {
            contentValues.put(SwanAppTable.bear_info.name(), aVar.aOt);
        }
        if (aVar.sign != null) {
            contentValues.put(SwanAppTable.sign.name(), aVar.sign);
        }
        if (aVar.aOu < 2) {
            contentValues.put(SwanAppTable.is_have_zip.name(), Integer.valueOf(aVar.aOu));
        }
        if (aVar.version != null) {
            contentValues.put(SwanAppTable.version.name(), aVar.version);
        }
        if (aVar.type >= 0) {
            contentValues.put(SwanAppTable.type.name(), Integer.valueOf(aVar.type));
        }
        if (aVar.aOv != null) {
            contentValues.put(SwanAppTable.app_open_url.name(), aVar.aOv);
        }
        if (aVar.aOw != null) {
            contentValues.put(SwanAppTable.app_download_url.name(), aVar.aOw);
        }
        if (aVar.aOx != null) {
            contentValues.put(SwanAppTable.target_swan_version.name(), aVar.aOx);
        }
        if (aVar.category >= 0) {
            contentValues.put(SwanAppTable.app_category.name(), Integer.valueOf(aVar.category));
        }
        if (aVar.category >= 0) {
            contentValues.put(SwanAppTable.orientation.name(), Integer.valueOf(aVar.orientation));
        }
        contentValues.put(SwanAppTable.app_zip_size.name(), Long.valueOf(aVar.aOy));
        contentValues.put(SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(aVar.aOz));
        if (aVar.aOA != null) {
            contentValues.put(SwanAppTable.version_code.name(), aVar.aOA);
        }
        contentValues.put(SwanAppTable.max_age.name(), Long.valueOf(aVar.aOB));
        contentValues.put(SwanAppTable.create_time.name(), Long.valueOf(aVar.createTime));
        contentValues.put(SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(aVar.aOC ? 1 : 0));
        return contentValues;
    }

    public Cursor a(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return aOi.getWritableDatabase().query("ai_apps_favorites", strArr, str, strArr2, null, null, str2);
    }

    public Cursor b(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return aOi.getWritableDatabase().query("ai_apps_aps_data INNER JOIN ai_apps_favorites ON ai_apps_favorites.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
    }

    public long b(@Nullable ContentValues contentValues) {
        return aOi.getWritableDatabase().insertWithOnConflict("ai_apps_favorites", null, contentValues, 5);
    }

    public int b(@Nullable String str, @Nullable String[] strArr) {
        return aOi.getWritableDatabase().delete("ai_apps_favorites", str, strArr);
    }

    public int a(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return aOi.getWritableDatabase().update("ai_apps_favorites", contentValues, str, strArr);
    }

    public Cursor c(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return aOi.getWritableDatabase().query("ai_apps_history", strArr, str, strArr2, null, null, str2);
    }

    public Cursor d(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return aOi.getWritableDatabase().query("ai_apps_aps_data INNER JOIN ai_apps_history ON ai_apps_history.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
    }

    public long c(@Nullable ContentValues contentValues) {
        return aOi.getWritableDatabase().insertWithOnConflict("ai_apps_history", null, contentValues, 5);
    }

    public int c(@Nullable String str, @Nullable String[] strArr) {
        return aOi.getWritableDatabase().delete("ai_apps_history", str, strArr);
    }

    public int b(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return aOi.getWritableDatabase().update("ai_apps_history", contentValues, str, strArr);
    }

    /* loaded from: classes2.dex */
    public abstract class a {
        private boolean mIsSuccess = false;

        protected abstract boolean b(SQLiteDatabase sQLiteDatabase);

        public a() {
        }

        public void c(SQLiteDatabase sQLiteDatabase) {
            this.mIsSuccess = false;
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    if (b(sQLiteDatabase)) {
                        sQLiteDatabase.setTransactionSuccessful();
                        this.mIsSuccess = true;
                    }
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        if (SwanAppDbControl.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    if (SwanAppDbControl.DEBUG) {
                        e2.printStackTrace();
                    }
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        if (SwanAppDbControl.DEBUG) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    if (SwanAppDbControl.DEBUG) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }

        protected boolean Hr() {
            return this.mIsSuccess;
        }
    }
}
