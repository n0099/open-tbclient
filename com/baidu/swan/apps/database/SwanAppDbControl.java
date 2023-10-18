package com.baidu.swan.apps.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.database.cloudconfig.SwanAppConfTokenTable;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.tieba.am1;
import com.baidu.tieba.dj2;
import com.baidu.tieba.mc2;
import com.baidu.tieba.p22;
import com.baidu.tieba.pc2;
import com.baidu.tieba.qc2;
import com.baidu.tieba.sc2;
import com.baidu.tieba.sl4;
import com.baidu.tieba.tc2;
import com.baidu.tieba.uc2;
import com.baidu.tieba.wo2;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class SwanAppDbControl {
    public static volatile SwanAppDbControl c;
    public static a d;
    public static Executor e;
    public static final boolean a = am1.a;
    public static final int f = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
    public static final int b = 24;

    /* loaded from: classes4.dex */
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
        pay_protected,
        quick_app_key;
        
        public static final String TABLE_NAME = "ai_apps_aps_data";
    }

    /* loaded from: classes4.dex */
    public static final class a extends SQLiteOpenHelper {
        public final void c(SQLiteDatabase sQLiteDatabase) {
        }

        public final void w(SQLiteDatabase sQLiteDatabase) {
        }

        public a(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        public final void A(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_key TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD version_code TEXT;");
            } catch (SQLException e) {
                if (SwanAppDbControl.a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        public final void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(SwanAppDbControl.d());
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        public final void d(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.version_code + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public final void h(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.icon_url + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public final void j(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_zip_size + " LONG;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public final void k(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pending_aps_errcode + " INTEGER;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            a(sQLiteDatabase);
            SwanAppConfTokenTable.a(sQLiteDatabase);
            pc2.a(sQLiteDatabase);
            tc2.a(sQLiteDatabase);
            uc2.a(sQLiteDatabase);
            qc2.a(sQLiteDatabase);
        }

        public final void p(SQLiteDatabase sQLiteDatabase) {
            pc2.a(sQLiteDatabase);
        }

        public final void q(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD sort_index INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_name TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_icon TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_type INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD frame_type INTEGER;");
            } catch (SQLException e) {
                if (SwanAppDbControl.a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        public final void r(@NonNull SQLiteDatabase sQLiteDatabase) {
            uc2.a(sQLiteDatabase);
        }

        public final void s(SQLiteDatabase sQLiteDatabase) {
            tc2.a(sQLiteDatabase);
            tc2.b(sQLiteDatabase);
            b(sQLiteDatabase);
        }

        public final void t(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.quick_app_key + " TEXT;");
            } catch (SQLException e) {
                if (SwanAppDbControl.a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        public final void u(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_swan_history");
        }

        public final void x(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD is_new_favor INTEGER DEFAULT 0;");
            } catch (SQLException e) {
                p22.l("SwanAppDbControl", "updateSwanFavoriteTableV123 fail", e);
            }
        }

        public final void y(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD pay_protected INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD pay_protected INTEGER DEFAULT 0;");
            } catch (SQLException e) {
                p22.l("SwanAppDbControl", "updateSwanHistoryANDFavoriteTableV123 fail", e);
            }
        }

        public final void z(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_name TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_icon TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD frame_type INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD sync_state INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_type TEXT;");
            } catch (SQLException e) {
                if (SwanAppDbControl.a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
            sc2.v(sQLiteDatabase);
        }

        public final void b(SQLiteDatabase sQLiteDatabase) {
            int size;
            long currentTimeMillis = System.currentTimeMillis();
            List<ContentValues> a = wo2.x().a();
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean z = false;
            if (SwanAppDbControl.a) {
                if (a == null) {
                    size = 0;
                } else {
                    size = a.size();
                }
                Log.d("SwanAppDbControl", "read old history cost" + (currentTimeMillis2 - currentTimeMillis) + "  count:" + size);
            }
            if (a != null) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (a.size() != 0) {
                    try {
                        try {
                            sQLiteDatabase.beginTransaction();
                            Iterator<ContentValues> it = a.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (sQLiteDatabase.insertWithOnConflict("ai_apps_history", null, it.next(), 5) < 0) {
                                        break;
                                    }
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                sQLiteDatabase.setTransactionSuccessful();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (SwanAppDbControl.a) {
                            Log.d("SwanAppDbControl", "write new history cost" + (currentTimeMillis3 - currentTimeMillis2));
                            Log.d("SwanAppDbControl", "migrate history total cost" + (currentTimeMillis3 - currentTimeMillis));
                        }
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
        }

        public final void e(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_category + " INTEGER default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.orientation + " INTEGER default 0;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public final void f(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.max_age + " LONG default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.create_time + " LONG default 0;");
            } catch (SQLException e) {
                if (SwanAppDbControl.a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        public final void g(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_key + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.type + " INTEGER default 0;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public final void o(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.bear_info + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.force_fetch_meta_info + " INTEGER default 0;");
            } catch (SQLException e) {
                if (SwanAppDbControl.a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        public final void v(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pay_protected + " INTEGER default " + SwanAppDbControl.f + ParamableElem.DIVIDE_PARAM);
            } catch (SQLException e) {
                if (SwanAppDbControl.a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                }
            }
        }

        public final void i(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_open_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_download_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.target_swan_version + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @SuppressLint({"BDThrowableCheck"})
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (SwanAppDbControl.a) {
                Log.i("SwanAppDbControl", "DB new version = " + i2 + "DB old version=" + i);
            }
            while (i < i2) {
                switch (i) {
                    case 1:
                        g(sQLiteDatabase);
                        break;
                    case 2:
                        h(sQLiteDatabase);
                        SwanAppConfTokenTable.a(sQLiteDatabase);
                        break;
                    case 3:
                        i(sQLiteDatabase);
                        break;
                    case 4:
                        j(sQLiteDatabase);
                        break;
                    case 5:
                        k(sQLiteDatabase);
                        break;
                    case 6:
                        c(sQLiteDatabase);
                        break;
                    case 7:
                        d(sQLiteDatabase);
                        break;
                    case 8:
                        e(sQLiteDatabase);
                        break;
                    case 9:
                        f(sQLiteDatabase);
                        break;
                    case 10:
                        o(sQLiteDatabase);
                        break;
                    case 11:
                        p(sQLiteDatabase);
                        break;
                    case 12:
                        s(sQLiteDatabase);
                        break;
                    case 13:
                        w(sQLiteDatabase);
                        break;
                    case 14:
                        u(sQLiteDatabase);
                        break;
                    case 15:
                        v(sQLiteDatabase);
                        break;
                    case 16:
                        q(sQLiteDatabase);
                        break;
                    case 17:
                        r(sQLiteDatabase);
                        break;
                    case 18:
                        qc2.a(sQLiteDatabase);
                        break;
                    case 19:
                        t(sQLiteDatabase);
                        break;
                    case 20:
                        z(sQLiteDatabase);
                        break;
                    case 21:
                        y(sQLiteDatabase);
                        break;
                    case 22:
                        x(sQLiteDatabase);
                        break;
                    case 23:
                        A(sQLiteDatabase);
                        break;
                    case 24:
                        break;
                    default:
                        if (!SwanAppDbControl.a) {
                            break;
                        } else {
                            throw new IllegalStateException("SwanAppDB do not have this version");
                        }
                }
                i++;
            }
        }
    }

    public SQLiteDatabase e() {
        return d.getWritableDatabase();
    }

    public SQLiteOpenHelper h() {
        return d;
    }

    public void p() {
        c = null;
        d = null;
    }

    public static String d() {
        return "CREATE TABLE ai_apps_aps_data (" + SwanAppTable._id + " INTEGER PRIMARY KEY AUTOINCREMENT," + SwanAppTable.app_id + " TEXT UNIQUE," + SwanAppTable.app_key + " TEXT," + SwanAppTable.version + " TEXT," + SwanAppTable.description + " TEXT," + SwanAppTable.error_code + " INTEGER," + SwanAppTable.error_detail + " TEXT," + SwanAppTable.error_msg + " TEXT," + SwanAppTable.resume_date + " TEXT," + SwanAppTable.icon + " TEXT," + SwanAppTable.icon_url + " TEXT," + SwanAppTable.max_swan_version + " TEXT," + SwanAppTable.min_swan_version + " TEXT," + SwanAppTable.name + " TEXT," + SwanAppTable.service_category + " TEXT," + SwanAppTable.subject_info + " TEXT," + SwanAppTable.bear_info + " TEXT," + SwanAppTable.sign + " TEXT," + SwanAppTable.type + " INTEGER," + SwanAppTable.is_have_zip + " INTEGER," + SwanAppTable.app_open_url + " TEXT," + SwanAppTable.app_download_url + " TEXT," + SwanAppTable.target_swan_version + " TEXT," + SwanAppTable.app_zip_size + " LONG," + SwanAppTable.pending_aps_errcode + " INTEGER," + SwanAppTable.version_code + " TEXT," + SwanAppTable.app_category + " INTEGER," + SwanAppTable.orientation + " INTEGER," + SwanAppTable.max_age + " LONG," + SwanAppTable.create_time + " LONG," + SwanAppTable.force_fetch_meta_info + " INTEGER," + SwanAppTable.pay_protected + " INTEGER," + SwanAppTable.quick_app_key + " TEXT);";
    }

    public static SwanAppDbControl f(Context context) {
        if (c == null) {
            synchronized (SwanAppDbControl.class) {
                if (c == null) {
                    e = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                    d = new a(context.getApplicationContext(), "ai_apps.db", b);
                    c = new SwanAppDbControl();
                }
            }
        }
        return c;
    }

    public final Cursor g(String str) {
        try {
            SQLiteDatabase readableDatabase = d.getReadableDatabase();
            return readableDatabase.rawQuery("select * from ai_apps_aps_data where " + SwanAppTable.app_id.name() + " = ? ", new String[]{str});
        } catch (SQLException e2) {
            if (a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public int b(@Nullable String str, @Nullable String[] strArr) {
        return d.getWritableDatabase().delete("ai_apps_favorites", str, strArr);
    }

    public int c(@Nullable String str, @Nullable String[] strArr) {
        return d.getWritableDatabase().delete("ai_apps_history", str, strArr);
    }

    public long i(@Nullable ContentValues contentValues) {
        return d.getWritableDatabase().insertWithOnConflict("ai_apps_favorites", null, contentValues, 5);
    }

    public long j(@Nullable ContentValues contentValues) {
        return d.getWritableDatabase().insertWithOnConflict("ai_apps_history", null, contentValues, 5);
    }

    public mc2 o(String str) {
        mc2 mc2Var = new mc2();
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                try {
                    cursor = g(str);
                    if (cursor != null && cursor.moveToFirst()) {
                        s(cursor, mc2Var);
                    }
                } catch (Exception e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                sl4.d(cursor);
            }
        }
        return mc2Var;
    }

    public Cursor k(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        SQLiteDatabase writableDatabase = d.getWritableDatabase();
        return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_favorites ON ai_apps_favorites.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
    }

    public Cursor l(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return d.getWritableDatabase().query("ai_apps_favorites", strArr, str, strArr2, null, null, str2);
    }

    public Cursor m(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        SQLiteDatabase writableDatabase = d.getWritableDatabase();
        return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_history ON ai_apps_history.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, dj2.a(str), strArr2, null, null, str2);
    }

    public Cursor n(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return d.getWritableDatabase().query("ai_apps_history", strArr, dj2.a(str), strArr2, null, null, str2);
    }

    public int q(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return d.getWritableDatabase().update("ai_apps_favorites", contentValues, str, strArr);
    }

    public int r(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return d.getWritableDatabase().update("ai_apps_history", contentValues, str, strArr);
    }

    public void s(Cursor cursor, mc2 mc2Var) {
        boolean z;
        if (cursor != null && cursor.getCount() > 0) {
            if (a) {
                Log.d("SwanAppDbControl", "updateQueryAPSFileList: cursor=" + cursor.toString() + ", swanAppDbInfo =" + mc2Var.toString());
            }
            if (a) {
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
            int columnIndex32 = cursor.getColumnIndex(SwanAppTable.quick_app_key.name());
            if (TextUtils.isEmpty(cursor.getString(columnIndex))) {
                return;
            }
            mc2Var.a = cursor.getString(columnIndex);
            mc2Var.b = cursor.getString(columnIndex2);
            mc2Var.c = cursor.getString(columnIndex3);
            mc2Var.d = cursor.getInt(columnIndex4);
            mc2Var.e = cursor.getString(columnIndex5);
            mc2Var.f = cursor.getString(columnIndex6);
            mc2Var.g = cursor.getString(columnIndex7);
            mc2Var.h = cursor.getString(columnIndex8);
            mc2Var.i = cursor.getString(columnIndex9);
            mc2Var.j = cursor.getString(columnIndex10);
            mc2Var.k = cursor.getString(columnIndex11);
            mc2Var.l = cursor.getString(columnIndex12);
            mc2Var.m = cursor.getString(columnIndex13);
            mc2Var.n = cursor.getString(columnIndex14);
            mc2Var.o = cursor.getString(columnIndex15);
            mc2Var.p = cursor.getString(columnIndex16);
            mc2Var.r = cursor.getInt(columnIndex17);
            mc2Var.s = cursor.getInt(columnIndex18);
            mc2Var.q = cursor.getString(columnIndex19);
            mc2Var.t = cursor.getString(columnIndex20);
            mc2Var.u = cursor.getString(columnIndex21);
            mc2Var.v = cursor.getString(columnIndex22);
            mc2Var.w = cursor.getLong(columnIndex23);
            mc2Var.x = cursor.getInt(columnIndex24);
            mc2Var.A = cursor.getString(columnIndex25);
            mc2Var.y = cursor.getInt(columnIndex26);
            mc2Var.z = cursor.getInt(columnIndex27);
            mc2Var.B = cursor.getLong(columnIndex29);
            mc2Var.C = cursor.getLong(columnIndex30);
            if (cursor.getInt(columnIndex28) != 0) {
                z = true;
            } else {
                z = false;
            }
            mc2Var.D = z;
            mc2Var.E = cursor.getInt(columnIndex31);
            mc2Var.F = cursor.getString(columnIndex32);
        }
    }
}
