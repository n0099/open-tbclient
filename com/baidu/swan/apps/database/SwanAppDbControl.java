package com.baidu.swan.apps.database;

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
import d.a.i0.a.j0.b.c;
import d.a.i0.a.j0.b.d;
import d.a.i0.a.j0.c.b;
import d.a.i0.a.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class SwanAppDbControl {

    /* renamed from: c  reason: collision with root package name */
    public static volatile SwanAppDbControl f10862c;

    /* renamed from: d  reason: collision with root package name */
    public static a f10863d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10860a = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public static final int f10864e = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;

    /* renamed from: b  reason: collision with root package name */
    public static final int f10861b = 24;

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
        force_fetch_meta_info,
        pay_protected,
        quick_app_key;
        
        public static final String TABLE_NAME = "ai_apps_aps_data";
    }

    /* loaded from: classes2.dex */
    public static final class a extends SQLiteOpenHelper {
        public a(Context context, String str, int i2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        }

        public final void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(SwanAppDbControl.d());
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }

        public final void b(SQLiteDatabase sQLiteDatabase) {
            long currentTimeMillis = System.currentTimeMillis();
            List<ContentValues> a2 = d.a.i0.a.c1.a.v().a();
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean z = false;
            if (SwanAppDbControl.f10860a) {
                int size = a2 == null ? 0 : a2.size();
                Log.d("SwanAppDbControl", "read old history cost" + (currentTimeMillis2 - currentTimeMillis) + "  count:" + size);
            }
            if (a2 != null) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (a2.size() == 0) {
                    return;
                }
                try {
                    try {
                        sQLiteDatabase.beginTransaction();
                        Iterator<ContentValues> it = a2.iterator();
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
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    if (SwanAppDbControl.f10860a) {
                        Log.d("SwanAppDbControl", "write new history cost" + (currentTimeMillis3 - currentTimeMillis2));
                        Log.d("SwanAppDbControl", "migrate history total cost" + (currentTimeMillis3 - currentTimeMillis));
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

        public final void c(SQLiteDatabase sQLiteDatabase) {
        }

        public final void d(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.version_code + " TEXT;");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        public final void e(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_category + " INTEGER default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.orientation + " INTEGER default 0;");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        public final void f(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.max_age + " LONG default 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.create_time + " LONG default 0;");
            } catch (SQLException e2) {
                if (SwanAppDbControl.f10860a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
        }

        public final void g(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_key + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.type + " INTEGER default 0;");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        public final void h(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.icon_url + " TEXT;");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        public final void i(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_open_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_download_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.target_swan_version + " TEXT;");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        public final void j(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_zip_size + " LONG;");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        public final void k(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pending_aps_errcode + " INTEGER;");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        public final void l(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.bear_info + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.force_fetch_meta_info + " INTEGER default 0;");
            } catch (SQLException e2) {
                if (SwanAppDbControl.f10860a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
        }

        public final void m(SQLiteDatabase sQLiteDatabase) {
            c.a(sQLiteDatabase);
        }

        public final void n(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD sort_index INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_name TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_icon TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_type INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD frame_type INTEGER;");
            } catch (SQLException e2) {
                if (SwanAppDbControl.f10860a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
        }

        public final void o(@NonNull SQLiteDatabase sQLiteDatabase) {
            d.a.i0.a.j0.d.a.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            a(sQLiteDatabase);
            SwanAppConfTokenTable.a(sQLiteDatabase);
            c.a(sQLiteDatabase);
            d.a.i0.a.j0.c.c.a(sQLiteDatabase);
            d.a.i0.a.j0.d.a.a(sQLiteDatabase);
            d.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (SwanAppDbControl.f10860a) {
                Log.i("SwanAppDbControl", "DB new version = " + i3 + "DB old version=" + i2);
            }
            while (i2 < i3) {
                switch (i2) {
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
                        l(sQLiteDatabase);
                        break;
                    case 11:
                        m(sQLiteDatabase);
                        break;
                    case 12:
                        p(sQLiteDatabase);
                        break;
                    case 13:
                        t(sQLiteDatabase);
                        break;
                    case 14:
                        r(sQLiteDatabase);
                        break;
                    case 15:
                        s(sQLiteDatabase);
                        break;
                    case 16:
                        n(sQLiteDatabase);
                        break;
                    case 17:
                        o(sQLiteDatabase);
                        break;
                    case 18:
                        d.a(sQLiteDatabase);
                        break;
                    case 19:
                        q(sQLiteDatabase);
                        break;
                    case 20:
                        w(sQLiteDatabase);
                        break;
                    case 21:
                        v(sQLiteDatabase);
                        break;
                    case 22:
                        u(sQLiteDatabase);
                        break;
                    case 23:
                        x(sQLiteDatabase);
                        break;
                    case 24:
                        break;
                    default:
                        if (!SwanAppDbControl.f10860a) {
                            break;
                        } else {
                            throw new IllegalStateException("SwanAppDB do not have this version");
                        }
                }
                i2++;
            }
        }

        public final void p(SQLiteDatabase sQLiteDatabase) {
            d.a.i0.a.j0.c.c.a(sQLiteDatabase);
            d.a.i0.a.j0.c.c.b(sQLiteDatabase);
            b(sQLiteDatabase);
        }

        public final void q(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.quick_app_key + " TEXT;");
            } catch (SQLException e2) {
                if (SwanAppDbControl.f10860a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
        }

        public final void r(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_swan_history");
        }

        public final void s(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pay_protected + " INTEGER default " + SwanAppDbControl.f10864e + ";");
            } catch (SQLException e2) {
                if (SwanAppDbControl.f10860a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
        }

        public final void t(SQLiteDatabase sQLiteDatabase) {
        }

        public final void u(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD is_new_favor INTEGER DEFAULT 0;");
            } catch (SQLException e2) {
                d.a.i0.a.e0.d.i("SwanAppDbControl", "updateSwanFavoriteTableV123 fail", e2);
            }
        }

        public final void v(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD pay_protected INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD pay_protected INTEGER DEFAULT 0;");
            } catch (SQLException e2) {
                d.a.i0.a.e0.d.i("SwanAppDbControl", "updateSwanHistoryANDFavoriteTableV123 fail", e2);
            }
        }

        public final void w(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_name TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_icon TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD frame_type INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD sync_state INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_type TEXT;");
            } catch (SQLException e2) {
                if (SwanAppDbControl.f10860a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
            b.t(sQLiteDatabase);
        }

        public final void x(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_key TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD version_code TEXT;");
            } catch (SQLException e2) {
                if (SwanAppDbControl.f10860a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
        }
    }

    public static String d() {
        return "CREATE TABLE ai_apps_aps_data (" + SwanAppTable._id + " INTEGER PRIMARY KEY AUTOINCREMENT," + SwanAppTable.app_id + " TEXT UNIQUE," + SwanAppTable.app_key + " TEXT," + SwanAppTable.version + " TEXT," + SwanAppTable.description + " TEXT," + SwanAppTable.error_code + " INTEGER," + SwanAppTable.error_detail + " TEXT," + SwanAppTable.error_msg + " TEXT," + SwanAppTable.resume_date + " TEXT," + SwanAppTable.icon + " TEXT," + SwanAppTable.icon_url + " TEXT," + SwanAppTable.max_swan_version + " TEXT," + SwanAppTable.min_swan_version + " TEXT," + SwanAppTable.name + " TEXT," + SwanAppTable.service_category + " TEXT," + SwanAppTable.subject_info + " TEXT," + SwanAppTable.bear_info + " TEXT," + SwanAppTable.sign + " TEXT," + SwanAppTable.type + " INTEGER," + SwanAppTable.is_have_zip + " INTEGER," + SwanAppTable.app_open_url + " TEXT," + SwanAppTable.app_download_url + " TEXT," + SwanAppTable.target_swan_version + " TEXT," + SwanAppTable.app_zip_size + " LONG," + SwanAppTable.pending_aps_errcode + " INTEGER," + SwanAppTable.version_code + " TEXT," + SwanAppTable.app_category + " INTEGER," + SwanAppTable.orientation + " INTEGER," + SwanAppTable.max_age + " LONG," + SwanAppTable.create_time + " LONG," + SwanAppTable.force_fetch_meta_info + " INTEGER," + SwanAppTable.pay_protected + " INTEGER," + SwanAppTable.quick_app_key + " TEXT);";
    }

    public static SwanAppDbControl f(Context context) {
        if (f10862c == null) {
            synchronized (SwanAppDbControl.class) {
                if (f10862c == null) {
                    Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                    f10863d = new a(context.getApplicationContext(), "ai_apps.db", f10861b);
                    f10862c = new SwanAppDbControl();
                }
            }
        }
        return f10862c;
    }

    public int b(@Nullable String str, @Nullable String[] strArr) {
        return f10863d.getWritableDatabase().delete("ai_apps_favorites", str, strArr);
    }

    public int c(@Nullable String str, @Nullable String[] strArr) {
        return f10863d.getWritableDatabase().delete("ai_apps_history", str, strArr);
    }

    public SQLiteDatabase e() {
        return f10863d.getWritableDatabase();
    }

    public final Cursor g(String str) {
        try {
            SQLiteDatabase readableDatabase = f10863d.getReadableDatabase();
            return readableDatabase.rawQuery("select * from ai_apps_aps_data where " + SwanAppTable.app_id.name() + " = ? ", new String[]{str});
        } catch (SQLException e2) {
            if (f10860a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public SQLiteOpenHelper h() {
        return f10863d;
    }

    public long i(@Nullable ContentValues contentValues) {
        return f10863d.getWritableDatabase().insertWithOnConflict("ai_apps_favorites", null, contentValues, 5);
    }

    public long j(@Nullable ContentValues contentValues) {
        return f10863d.getWritableDatabase().insertWithOnConflict("ai_apps_history", null, contentValues, 5);
    }

    public Cursor k(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        SQLiteDatabase writableDatabase = f10863d.getWritableDatabase();
        return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_favorites ON ai_apps_favorites.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
    }

    public Cursor l(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return f10863d.getWritableDatabase().query("ai_apps_favorites", strArr, str, strArr2, null, null, str2);
    }

    public Cursor m(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        SQLiteDatabase writableDatabase = f10863d.getWritableDatabase();
        return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_history ON ai_apps_history.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
    }

    public Cursor n(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return f10863d.getWritableDatabase().query("ai_apps_history", strArr, str, strArr2, null, null, str2);
    }

    public d.a.i0.a.j0.a o(String str) {
        d.a.i0.a.j0.a aVar = new d.a.i0.a.j0.a();
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                try {
                    cursor = g(str);
                    if (cursor != null && cursor.moveToFirst()) {
                        s(cursor, aVar);
                    }
                } catch (Exception e2) {
                    if (f10860a) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                d.a.i0.t.d.d(cursor);
            }
        }
        return aVar;
    }

    public void p() {
        f10862c = null;
        f10863d = null;
    }

    public int q(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return f10863d.getWritableDatabase().update("ai_apps_favorites", contentValues, str, strArr);
    }

    public int r(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return f10863d.getWritableDatabase().update("ai_apps_history", contentValues, str, strArr);
    }

    public void s(Cursor cursor, d.a.i0.a.j0.a aVar) {
        if (cursor == null || cursor.getCount() <= 0) {
            return;
        }
        if (f10860a) {
            Log.d("SwanAppDbControl", "updateQueryAPSFileList: cursor=" + cursor.toString() + ", swanAppDbInfo =" + aVar.toString());
        }
        if (f10860a) {
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
        aVar.f42855a = cursor.getString(columnIndex);
        aVar.f42856b = cursor.getString(columnIndex2);
        aVar.f42857c = cursor.getString(columnIndex3);
        aVar.f42858d = cursor.getInt(columnIndex4);
        aVar.f42859e = cursor.getString(columnIndex5);
        aVar.f42860f = cursor.getString(columnIndex6);
        aVar.f42861g = cursor.getString(columnIndex7);
        aVar.f42862h = cursor.getString(columnIndex8);
        aVar.f42863i = cursor.getString(columnIndex9);
        aVar.j = cursor.getString(columnIndex10);
        aVar.k = cursor.getString(columnIndex11);
        aVar.l = cursor.getString(columnIndex12);
        aVar.m = cursor.getString(columnIndex13);
        aVar.n = cursor.getString(columnIndex14);
        aVar.o = cursor.getString(columnIndex15);
        aVar.p = cursor.getString(columnIndex16);
        aVar.r = cursor.getInt(columnIndex17);
        aVar.s = cursor.getInt(columnIndex18);
        aVar.q = cursor.getString(columnIndex19);
        aVar.t = cursor.getString(columnIndex20);
        aVar.u = cursor.getString(columnIndex21);
        aVar.v = cursor.getString(columnIndex22);
        aVar.w = cursor.getLong(columnIndex23);
        aVar.x = cursor.getInt(columnIndex24);
        aVar.A = cursor.getString(columnIndex25);
        aVar.y = cursor.getInt(columnIndex26);
        aVar.z = cursor.getInt(columnIndex27);
        aVar.B = cursor.getLong(columnIndex29);
        aVar.C = cursor.getLong(columnIndex30);
        aVar.D = cursor.getInt(columnIndex28) != 0;
        aVar.E = cursor.getInt(columnIndex31);
        aVar.F = cursor.getString(columnIndex32);
    }
}
