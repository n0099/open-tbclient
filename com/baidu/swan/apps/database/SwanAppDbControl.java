package com.baidu.swan.apps.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.swan.apps.database.cloudconfig.SwanAppConfTokenTable;
import com.baidu.swan.apps.database.favorite.c;
import com.baidu.swan.e.d;
import com.baidu.swan.pms.PMSConstants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public class SwanAppDbControl {
    private static Executor bvR;
    private static volatile SwanAppDbControl cbk;
    private static a cbl;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final int cbm = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
    private static final int DB_VERSION = 18;

    /* loaded from: classes11.dex */
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
        force_fetch_meta_info,
        pay_protected;
        
        public static final String TABLE_NAME = "ai_apps_aps_data";
    }

    public static SwanAppDbControl bN(Context context) {
        if (cbk == null) {
            synchronized (SwanAppDbControl.class) {
                if (cbk == null) {
                    bvR = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                    cbl = new a(context.getApplicationContext(), "ai_apps.db", DB_VERSION);
                    cbk = new SwanAppDbControl();
                }
            }
        }
        return cbk;
    }

    /* loaded from: classes11.dex */
    public static final class a extends SQLiteOpenHelper {
        public a(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            b(sQLiteDatabase);
            SwanAppConfTokenTable.u(sQLiteDatabase);
            c.v(sQLiteDatabase);
            com.baidu.swan.apps.database.a.c.w(sQLiteDatabase);
            com.baidu.swan.apps.database.subscribe.a.y(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (SwanAppDbControl.DEBUG) {
                Log.i("SwanAppDbControl", "DB new version = " + i2 + "DB old version=" + i);
            }
            while (i < i2) {
                switch (i) {
                    case 1:
                        c(sQLiteDatabase);
                        break;
                    case 2:
                        d(sQLiteDatabase);
                        SwanAppConfTokenTable.u(sQLiteDatabase);
                        break;
                    case 3:
                        e(sQLiteDatabase);
                        break;
                    case 4:
                        f(sQLiteDatabase);
                        break;
                    case 5:
                        g(sQLiteDatabase);
                        break;
                    case 6:
                        h(sQLiteDatabase);
                        break;
                    case 7:
                        i(sQLiteDatabase);
                        break;
                    case 8:
                        j(sQLiteDatabase);
                        break;
                    case 9:
                        k(sQLiteDatabase);
                        break;
                    case 10:
                        l(sQLiteDatabase);
                        break;
                    case 11:
                        m(sQLiteDatabase);
                        break;
                    case 12:
                        n(sQLiteDatabase);
                        break;
                    case 13:
                        o(sQLiteDatabase);
                        break;
                    case 14:
                        p(sQLiteDatabase);
                        break;
                    case 15:
                        q(sQLiteDatabase);
                        break;
                    case 16:
                        r(sQLiteDatabase);
                        break;
                    case 17:
                        s(sQLiteDatabase);
                        break;
                    case 18:
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

        private void b(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(SwanAppDbControl.abR());
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        private void c(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_key + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.type + " INTEGER default 0;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void d(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.icon_url + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void e(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_open_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_download_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.target_swan_version + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void f(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_zip_size + " LONG;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void g(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pending_aps_errcode + " INTEGER;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void h(SQLiteDatabase sQLiteDatabase) {
        }

        private void i(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.version_code + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void j(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_category + " INTEGER default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.orientation + " INTEGER default 0;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void k(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.max_age + " LONG default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.create_time + " LONG default 0;");
            } catch (SQLException e) {
                if (SwanAppDbControl.DEBUG) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        private void l(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.bear_info + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.force_fetch_meta_info + " INTEGER default 0;");
            } catch (SQLException e) {
                if (SwanAppDbControl.DEBUG) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        private void m(SQLiteDatabase sQLiteDatabase) {
            c.v(sQLiteDatabase);
        }

        private void n(SQLiteDatabase sQLiteDatabase) {
            com.baidu.swan.apps.database.a.c.w(sQLiteDatabase);
            com.baidu.swan.apps.database.a.c.x(sQLiteDatabase);
            t(sQLiteDatabase);
        }

        private void o(SQLiteDatabase sQLiteDatabase) {
        }

        private void p(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_swan_history");
        }

        private void q(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pay_protected + " INTEGER default " + SwanAppDbControl.cbm + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            } catch (SQLException e) {
                if (SwanAppDbControl.DEBUG) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        private void r(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD sort_index INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_name TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_icon TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_type INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD frame_type INTEGER;");
            } catch (SQLException e) {
                if (SwanAppDbControl.DEBUG) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        private void s(@NonNull SQLiteDatabase sQLiteDatabase) {
            com.baidu.swan.apps.database.subscribe.a.y(sQLiteDatabase);
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
        private void t(SQLiteDatabase sQLiteDatabase) {
            boolean z = false;
            long currentTimeMillis = System.currentTimeMillis();
            List<ContentValues> Sg = com.baidu.swan.apps.u.a.afl().Sg();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (SwanAppDbControl.DEBUG) {
                Log.d("SwanAppDbControl", "read old history cost" + (currentTimeMillis2 - currentTimeMillis) + "  count:" + (Sg == null ? 0 : Sg.size()));
            }
            if (Sg != null) {
                try {
                    if (Sg.size() != 0) {
                        try {
                            sQLiteDatabase.beginTransaction();
                            Iterator<ContentValues> it = Sg.iterator();
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

    public SQLiteOpenHelper abQ() {
        return cbl;
    }

    public com.baidu.swan.apps.database.a jQ(String str) {
        com.baidu.swan.apps.database.a aVar = new com.baidu.swan.apps.database.a();
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = jR(str);
                if (cursor != null && cursor.moveToFirst()) {
                    a(cursor, aVar);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                d.closeSafely(cursor);
            }
        }
        return aVar;
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
            int columnIndex31 = cursor.getColumnIndex(SwanAppTable.pay_protected.name());
            if (!TextUtils.isEmpty(cursor.getString(columnIndex))) {
                aVar.appId = cursor.getString(columnIndex);
                aVar.appKey = cursor.getString(columnIndex2);
                aVar.description = cursor.getString(columnIndex3);
                aVar.errorCode = cursor.getInt(columnIndex4);
                aVar.errorDetail = cursor.getString(columnIndex5);
                aVar.errorMsg = cursor.getString(columnIndex6);
                aVar.resumeDate = cursor.getString(columnIndex7);
                aVar.icon = cursor.getString(columnIndex8);
                aVar.iconUrl = cursor.getString(columnIndex9);
                aVar.cbn = cursor.getString(columnIndex10);
                aVar.cbo = cursor.getString(columnIndex11);
                aVar.name = cursor.getString(columnIndex12);
                aVar.serviceCategory = cursor.getString(columnIndex13);
                aVar.subjectInfo = cursor.getString(columnIndex14);
                aVar.bearInfo = cursor.getString(columnIndex15);
                aVar.sign = cursor.getString(columnIndex16);
                aVar.type = cursor.getInt(columnIndex17);
                aVar.cbp = cursor.getInt(columnIndex18);
                aVar.version = cursor.getString(columnIndex19);
                aVar.cbq = cursor.getString(columnIndex20);
                aVar.cbr = cursor.getString(columnIndex21);
                aVar.cbs = cursor.getString(columnIndex22);
                aVar.cbt = cursor.getLong(columnIndex23);
                aVar.cbu = cursor.getInt(columnIndex24);
                aVar.cbv = cursor.getString(columnIndex25);
                aVar.category = cursor.getInt(columnIndex26);
                aVar.orientation = cursor.getInt(columnIndex27);
                aVar.maxAge = cursor.getLong(columnIndex29);
                aVar.createTime = cursor.getLong(columnIndex30);
                aVar.cbw = cursor.getInt(columnIndex28) != 0;
                aVar.payProtected = cursor.getInt(columnIndex31);
            }
        }
    }

    private Cursor jR(String str) {
        try {
            return cbl.getReadableDatabase().rawQuery("select * from ai_apps_aps_data where " + SwanAppTable.app_id.name() + " = ? ", new String[]{str});
        } catch (SQLException e) {
            if (!DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public static String abR() {
        return "CREATE TABLE ai_apps_aps_data (" + SwanAppTable._id + " INTEGER PRIMARY KEY AUTOINCREMENT," + SwanAppTable.app_id + " TEXT UNIQUE," + SwanAppTable.app_key + " TEXT," + SwanAppTable.version + " TEXT," + SwanAppTable.description + " TEXT," + SwanAppTable.error_code + " INTEGER," + SwanAppTable.error_detail + " TEXT," + SwanAppTable.error_msg + " TEXT," + SwanAppTable.resume_date + " TEXT," + SwanAppTable.icon + " TEXT," + SwanAppTable.icon_url + " TEXT," + SwanAppTable.max_swan_version + " TEXT," + SwanAppTable.min_swan_version + " TEXT," + SwanAppTable.name + " TEXT," + SwanAppTable.service_category + " TEXT," + SwanAppTable.subject_info + " TEXT," + SwanAppTable.bear_info + " TEXT," + SwanAppTable.sign + " TEXT," + SwanAppTable.type + " INTEGER," + SwanAppTable.is_have_zip + " INTEGER," + SwanAppTable.app_open_url + " TEXT," + SwanAppTable.app_download_url + " TEXT," + SwanAppTable.target_swan_version + " TEXT," + SwanAppTable.app_zip_size + " LONG," + SwanAppTable.pending_aps_errcode + " INTEGER," + SwanAppTable.version_code + " TEXT," + SwanAppTable.app_category + " INTEGER," + SwanAppTable.orientation + " INTEGER," + SwanAppTable.max_age + " LONG," + SwanAppTable.create_time + " LONG," + SwanAppTable.force_fetch_meta_info + " INTEGER," + SwanAppTable.pay_protected + " INTEGER);";
    }

    public Cursor a(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return cbl.getWritableDatabase().query("ai_apps_favorites", strArr, str, strArr2, null, null, str2);
    }

    public Cursor b(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return cbl.getWritableDatabase().query("ai_apps_aps_data INNER JOIN ai_apps_favorites ON ai_apps_favorites.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
    }

    public long b(@Nullable ContentValues contentValues) {
        return cbl.getWritableDatabase().insertWithOnConflict("ai_apps_favorites", null, contentValues, 5);
    }

    public int b(@Nullable String str, @Nullable String[] strArr) {
        return cbl.getWritableDatabase().delete("ai_apps_favorites", str, strArr);
    }

    public int a(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return cbl.getWritableDatabase().update("ai_apps_favorites", contentValues, str, strArr);
    }

    public Cursor c(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return cbl.getWritableDatabase().query("ai_apps_history", strArr, str, strArr2, null, null, str2);
    }

    public Cursor d(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return cbl.getWritableDatabase().query("ai_apps_aps_data INNER JOIN ai_apps_history ON ai_apps_history.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
    }

    public long c(@Nullable ContentValues contentValues) {
        return cbl.getWritableDatabase().insertWithOnConflict("ai_apps_history", null, contentValues, 5);
    }

    public int c(@Nullable String str, @Nullable String[] strArr) {
        return cbl.getWritableDatabase().delete("ai_apps_history", str, strArr);
    }

    public int b(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return cbl.getWritableDatabase().update("ai_apps_history", contentValues, str, strArr);
    }

    public void release() {
        cbk = null;
        cbl = null;
        bvR = null;
    }
}
