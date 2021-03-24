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
import com.baidu.swan.pms.PMSConstants$PayProtected;
import d.b.g0.a.g0.c.c;
import d.b.g0.a.g0.c.d;
import d.b.g0.a.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class SwanAppDbControl {

    /* renamed from: c  reason: collision with root package name */
    public static volatile SwanAppDbControl f12200c;

    /* renamed from: d  reason: collision with root package name */
    public static a f12201d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f12198a = k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12202e = PMSConstants$PayProtected.NO_PAY_PROTECTED.type;

    /* renamed from: b  reason: collision with root package name */
    public static final int f12199b = 20;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static final class a extends SQLiteOpenHelper {
        public a(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
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
            List<ContentValues> a2 = d.b.g0.a.w0.a.r().a();
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean z = false;
            if (SwanAppDbControl.f12198a) {
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
                    if (SwanAppDbControl.f12198a) {
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
                if (SwanAppDbControl.f12198a) {
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
                if (SwanAppDbControl.f12198a) {
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
                if (SwanAppDbControl.f12198a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
        }

        public final void o(@NonNull SQLiteDatabase sQLiteDatabase) {
            d.b.g0.a.g0.e.a.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            a(sQLiteDatabase);
            SwanAppConfTokenTable.a(sQLiteDatabase);
            c.a(sQLiteDatabase);
            d.b.g0.a.g0.d.c.a(sQLiteDatabase);
            d.b.g0.a.g0.e.a.a(sQLiteDatabase);
            d.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (SwanAppDbControl.f12198a) {
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
                        break;
                    default:
                        if (!SwanAppDbControl.f12198a) {
                            break;
                        } else {
                            throw new IllegalStateException("SwanAppDB do not have this version");
                        }
                }
                i++;
            }
        }

        public final void p(SQLiteDatabase sQLiteDatabase) {
            d.b.g0.a.g0.d.c.a(sQLiteDatabase);
            d.b.g0.a.g0.d.c.b(sQLiteDatabase);
            b(sQLiteDatabase);
        }

        public final void q(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.quick_app_key + " TEXT;");
            } catch (SQLException e2) {
                if (SwanAppDbControl.f12198a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
        }

        public final void r(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_swan_history");
        }

        public final void s(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pay_protected + " INTEGER default " + SwanAppDbControl.f12202e + ";");
            } catch (SQLException e2) {
                if (SwanAppDbControl.f12198a) {
                    Log.e("SwanAppDbControl", Log.getStackTraceString(e2));
                }
            }
        }

        public final void t(SQLiteDatabase sQLiteDatabase) {
        }
    }

    public static String d() {
        return "CREATE TABLE ai_apps_aps_data (" + SwanAppTable._id + " INTEGER PRIMARY KEY AUTOINCREMENT," + SwanAppTable.app_id + " TEXT UNIQUE," + SwanAppTable.app_key + " TEXT," + SwanAppTable.version + " TEXT," + SwanAppTable.description + " TEXT," + SwanAppTable.error_code + " INTEGER," + SwanAppTable.error_detail + " TEXT," + SwanAppTable.error_msg + " TEXT," + SwanAppTable.resume_date + " TEXT," + SwanAppTable.icon + " TEXT," + SwanAppTable.icon_url + " TEXT," + SwanAppTable.max_swan_version + " TEXT," + SwanAppTable.min_swan_version + " TEXT," + SwanAppTable.name + " TEXT," + SwanAppTable.service_category + " TEXT," + SwanAppTable.subject_info + " TEXT," + SwanAppTable.bear_info + " TEXT," + SwanAppTable.sign + " TEXT," + SwanAppTable.type + " INTEGER," + SwanAppTable.is_have_zip + " INTEGER," + SwanAppTable.app_open_url + " TEXT," + SwanAppTable.app_download_url + " TEXT," + SwanAppTable.target_swan_version + " TEXT," + SwanAppTable.app_zip_size + " LONG," + SwanAppTable.pending_aps_errcode + " INTEGER," + SwanAppTable.version_code + " TEXT," + SwanAppTable.app_category + " INTEGER," + SwanAppTable.orientation + " INTEGER," + SwanAppTable.max_age + " LONG," + SwanAppTable.create_time + " LONG," + SwanAppTable.force_fetch_meta_info + " INTEGER," + SwanAppTable.pay_protected + " INTEGER," + SwanAppTable.quick_app_key + " TEXT);";
    }

    public static SwanAppDbControl f(Context context) {
        if (f12200c == null) {
            synchronized (SwanAppDbControl.class) {
                if (f12200c == null) {
                    Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                    f12201d = new a(context.getApplicationContext(), "ai_apps.db", f12199b);
                    f12200c = new SwanAppDbControl();
                }
            }
        }
        return f12200c;
    }

    public int b(@Nullable String str, @Nullable String[] strArr) {
        return f12201d.getWritableDatabase().delete("ai_apps_favorites", str, strArr);
    }

    public int c(@Nullable String str, @Nullable String[] strArr) {
        return f12201d.getWritableDatabase().delete("ai_apps_history", str, strArr);
    }

    public SQLiteDatabase e() {
        return f12201d.getWritableDatabase();
    }

    public final Cursor g(String str) {
        try {
            SQLiteDatabase readableDatabase = f12201d.getReadableDatabase();
            return readableDatabase.rawQuery("select * from ai_apps_aps_data where " + SwanAppTable.app_id.name() + " = ? ", new String[]{str});
        } catch (SQLException e2) {
            if (f12198a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public SQLiteOpenHelper h() {
        return f12201d;
    }

    public long i(@Nullable ContentValues contentValues) {
        return f12201d.getWritableDatabase().insertWithOnConflict("ai_apps_favorites", null, contentValues, 5);
    }

    public long j(@Nullable ContentValues contentValues) {
        return f12201d.getWritableDatabase().insertWithOnConflict("ai_apps_history", null, contentValues, 5);
    }

    public Cursor k(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        SQLiteDatabase writableDatabase = f12201d.getWritableDatabase();
        return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_favorites ON ai_apps_favorites.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
    }

    public Cursor l(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return f12201d.getWritableDatabase().query("ai_apps_favorites", strArr, str, strArr2, null, null, str2);
    }

    public Cursor m(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        SQLiteDatabase writableDatabase = f12201d.getWritableDatabase();
        return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_history ON ai_apps_history.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
    }

    public Cursor n(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return f12201d.getWritableDatabase().query("ai_apps_history", strArr, str, strArr2, null, null, str2);
    }

    public d.b.g0.a.g0.a o(String str) {
        d.b.g0.a.g0.a aVar = new d.b.g0.a.g0.a();
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                try {
                    cursor = g(str);
                    if (cursor != null && cursor.moveToFirst()) {
                        s(cursor, aVar);
                    }
                } catch (Exception e2) {
                    if (f12198a) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                d.b.g0.p.d.a(cursor);
            }
        }
        return aVar;
    }

    public void p() {
        f12200c = null;
        f12201d = null;
    }

    public int q(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return f12201d.getWritableDatabase().update("ai_apps_favorites", contentValues, str, strArr);
    }

    public int r(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return f12201d.getWritableDatabase().update("ai_apps_history", contentValues, str, strArr);
    }

    public void s(Cursor cursor, d.b.g0.a.g0.a aVar) {
        if (cursor == null || cursor.getCount() <= 0) {
            return;
        }
        if (f12198a) {
            Log.d("SwanAppDbControl", "updateQueryAPSFileList: cursor=" + cursor.toString() + ", swanAppDbInfo =" + aVar.toString());
        }
        if (f12198a) {
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
        aVar.f44470a = cursor.getString(columnIndex);
        aVar.f44471b = cursor.getString(columnIndex2);
        aVar.f44472c = cursor.getString(columnIndex3);
        aVar.f44473d = cursor.getInt(columnIndex4);
        aVar.f44474e = cursor.getString(columnIndex5);
        aVar.f44475f = cursor.getString(columnIndex6);
        aVar.f44476g = cursor.getString(columnIndex7);
        aVar.f44477h = cursor.getString(columnIndex8);
        aVar.i = cursor.getString(columnIndex9);
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
