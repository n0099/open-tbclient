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
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.j0.b.c;
import c.a.p0.a.j0.b.d;
import c.a.p0.a.j0.c.b;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.database.cloudconfig.SwanAppConfTokenTable;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class SwanAppDbControl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45955a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f45956b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile SwanAppDbControl f45957c;

    /* renamed from: d  reason: collision with root package name */
    public static a f45958d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f45959e;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class SwanAppTable {
        public static final /* synthetic */ SwanAppTable[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TABLE_NAME = "ai_apps_aps_data";
        public static final SwanAppTable _id;
        public static final SwanAppTable app_category;
        public static final SwanAppTable app_download_url;
        public static final SwanAppTable app_id;
        public static final SwanAppTable app_key;
        public static final SwanAppTable app_open_url;
        public static final SwanAppTable app_zip_size;
        public static final SwanAppTable bear_info;
        public static final SwanAppTable create_time;
        public static final SwanAppTable description;
        public static final SwanAppTable error_code;
        public static final SwanAppTable error_detail;
        public static final SwanAppTable error_msg;
        public static final SwanAppTable force_fetch_meta_info;
        public static final SwanAppTable icon;
        public static final SwanAppTable icon_url;
        public static final SwanAppTable is_have_zip;
        public static final SwanAppTable max_age;
        public static final SwanAppTable max_swan_version;
        public static final SwanAppTable min_swan_version;
        public static final SwanAppTable name;
        public static final SwanAppTable orientation;
        public static final SwanAppTable pay_protected;
        public static final SwanAppTable pending_aps_errcode;
        public static final SwanAppTable quick_app_key;
        public static final SwanAppTable resume_date;
        public static final SwanAppTable service_category;
        public static final SwanAppTable sign;
        public static final SwanAppTable subject_info;
        public static final SwanAppTable target_swan_version;
        public static final SwanAppTable type;
        public static final SwanAppTable version;
        public static final SwanAppTable version_code;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-499004881, "Lcom/baidu/swan/apps/database/SwanAppDbControl$SwanAppTable;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-499004881, "Lcom/baidu/swan/apps/database/SwanAppDbControl$SwanAppTable;");
                    return;
                }
            }
            _id = new SwanAppTable("_id", 0);
            app_id = new SwanAppTable("app_id", 1);
            app_key = new SwanAppTable("app_key", 2);
            version = new SwanAppTable("version", 3);
            description = new SwanAppTable("description", 4);
            error_code = new SwanAppTable("error_code", 5);
            error_detail = new SwanAppTable("error_detail", 6);
            error_msg = new SwanAppTable("error_msg", 7);
            resume_date = new SwanAppTable("resume_date", 8);
            icon = new SwanAppTable("icon", 9);
            icon_url = new SwanAppTable("icon_url", 10);
            max_swan_version = new SwanAppTable("max_swan_version", 11);
            min_swan_version = new SwanAppTable("min_swan_version", 12);
            name = new SwanAppTable("name", 13);
            service_category = new SwanAppTable("service_category", 14);
            subject_info = new SwanAppTable("subject_info", 15);
            bear_info = new SwanAppTable(SwanAppBearInfo.BEAR_INFO, 16);
            sign = new SwanAppTable("sign", 17);
            type = new SwanAppTable("type", 18);
            is_have_zip = new SwanAppTable("is_have_zip", 19);
            app_open_url = new SwanAppTable("app_open_url", 20);
            app_download_url = new SwanAppTable("app_download_url", 21);
            target_swan_version = new SwanAppTable("target_swan_version", 22);
            app_zip_size = new SwanAppTable("app_zip_size", 23);
            pending_aps_errcode = new SwanAppTable("pending_aps_errcode", 24);
            version_code = new SwanAppTable("version_code", 25);
            app_category = new SwanAppTable("app_category", 26);
            orientation = new SwanAppTable("orientation", 27);
            max_age = new SwanAppTable("max_age", 28);
            create_time = new SwanAppTable("create_time", 29);
            force_fetch_meta_info = new SwanAppTable("force_fetch_meta_info", 30);
            pay_protected = new SwanAppTable("pay_protected", 31);
            SwanAppTable swanAppTable = new SwanAppTable("quick_app_key", 32);
            quick_app_key = swanAppTable;
            $VALUES = new SwanAppTable[]{_id, app_id, app_key, version, description, error_code, error_detail, error_msg, resume_date, icon, icon_url, max_swan_version, min_swan_version, name, service_category, subject_info, bear_info, sign, type, is_have_zip, app_open_url, app_download_url, target_swan_version, app_zip_size, pending_aps_errcode, version_code, app_category, orientation, max_age, create_time, force_fetch_meta_info, pay_protected, swanAppTable};
        }

        public SwanAppTable(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SwanAppTable valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SwanAppTable) Enum.valueOf(SwanAppTable.class, str) : (SwanAppTable) invokeL.objValue;
        }

        public static SwanAppTable[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SwanAppTable[]) $VALUES.clone() : (SwanAppTable[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, String str, int i2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final void a(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(SwanAppDbControl.d());
                } catch (Exception e2) {
                    e2.getStackTrace();
                }
            }
        }

        public final void b(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                List<ContentValues> a2 = c.a.p0.a.c1.a.v().a();
                long currentTimeMillis2 = System.currentTimeMillis();
                boolean z = false;
                if (SwanAppDbControl.f45955a) {
                    String str = "read old history cost" + (currentTimeMillis2 - currentTimeMillis) + "  count:" + (a2 == null ? 0 : a2.size());
                }
                if (a2 != null) {
                    try {
                        try {
                        } catch (Throwable th) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    if (a2.size() == 0) {
                        return;
                    }
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
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    if (SwanAppDbControl.f45955a) {
                        String str2 = "write new history cost" + (currentTimeMillis3 - currentTimeMillis2);
                        String str3 = "migrate history total cost" + (currentTimeMillis3 - currentTimeMillis);
                    }
                }
            }
        }

        public final void c(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            }
        }

        public final void d(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.version_code + " TEXT;");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void e(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_category + " INTEGER default 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.orientation + " INTEGER default 0;");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void f(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.max_age + " LONG default 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.create_time + " LONG default 0;");
                } catch (SQLException e2) {
                    if (SwanAppDbControl.f45955a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }

        public final void g(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_key + " TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.type + " INTEGER default 0;");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void h(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.icon_url + " TEXT;");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void i(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_open_url + " TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_download_url + " TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.target_swan_version + " TEXT;");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void j(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_zip_size + " LONG;");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void k(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pending_aps_errcode + " INTEGER;");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void l(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.bear_info + " TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.force_fetch_meta_info + " INTEGER default 0;");
                } catch (SQLException e2) {
                    if (SwanAppDbControl.f45955a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }

        public final void m(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, sQLiteDatabase) == null) {
                c.a(sQLiteDatabase);
            }
        }

        public final void n(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD sort_index INTEGER;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_name TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_icon TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD app_type INTEGER;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD frame_type INTEGER;");
                } catch (SQLException e2) {
                    if (SwanAppDbControl.f45955a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }

        public final void o(@NonNull SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, sQLiteDatabase) == null) {
                c.a.p0.a.j0.d.a.a(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, sQLiteDatabase) == null) {
                a(sQLiteDatabase);
                SwanAppConfTokenTable.a(sQLiteDatabase);
                c.a(sQLiteDatabase);
                c.a.p0.a.j0.c.c.a(sQLiteDatabase);
                c.a.p0.a.j0.d.a.a(sQLiteDatabase);
                d.a(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048592, this, sQLiteDatabase, i2, i3) == null) {
                if (SwanAppDbControl.f45955a) {
                    String str = "DB new version = " + i3 + "DB old version=" + i2;
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
                            if (!SwanAppDbControl.f45955a) {
                                break;
                            } else {
                                throw new IllegalStateException("SwanAppDB do not have this version");
                            }
                    }
                    i2++;
                }
            }
        }

        public final void p(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, sQLiteDatabase) == null) {
                c.a.p0.a.j0.c.c.a(sQLiteDatabase);
                c.a.p0.a.j0.c.c.b(sQLiteDatabase);
                b(sQLiteDatabase);
            }
        }

        public final void q(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.quick_app_key + " TEXT;");
                } catch (SQLException e2) {
                    if (SwanAppDbControl.f45955a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }

        public final void r(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, sQLiteDatabase) == null) {
                sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_swan_history");
            }
        }

        public final void s(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pay_protected + " INTEGER default " + SwanAppDbControl.f45959e + ";");
                } catch (SQLException e2) {
                    if (SwanAppDbControl.f45955a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }

        public final void t(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, sQLiteDatabase) == null) {
            }
        }

        public final void u(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD is_new_favor INTEGER DEFAULT 0;");
                } catch (SQLException e2) {
                    c.a.p0.a.e0.d.i("SwanAppDbControl", "updateSwanFavoriteTableV123 fail", e2);
                }
            }
        }

        public final void v(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD pay_protected INTEGER DEFAULT 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD pay_protected INTEGER DEFAULT 0;");
                } catch (SQLException e2) {
                    c.a.p0.a.e0.d.i("SwanAppDbControl", "updateSwanHistoryANDFavoriteTableV123 fail", e2);
                }
            }
        }

        public final void w(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_name TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_icon TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD frame_type INTEGER;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD sync_state INTEGER;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_type TEXT;");
                } catch (SQLException e2) {
                    if (SwanAppDbControl.f45955a) {
                        Log.getStackTraceString(e2);
                    }
                }
                b.t(sQLiteDatabase);
            }
        }

        public final void x(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_key TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD version_code TEXT;");
                } catch (SQLException e2) {
                    if (SwanAppDbControl.f45955a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-814783067, "Lcom/baidu/swan/apps/database/SwanAppDbControl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-814783067, "Lcom/baidu/swan/apps/database/SwanAppDbControl;");
                return;
            }
        }
        f45955a = k.f7085a;
        f45959e = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
        f45956b = 24;
    }

    public SwanAppDbControl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return "CREATE TABLE ai_apps_aps_data (" + SwanAppTable._id + " INTEGER PRIMARY KEY AUTOINCREMENT," + SwanAppTable.app_id + " TEXT UNIQUE," + SwanAppTable.app_key + " TEXT," + SwanAppTable.version + " TEXT," + SwanAppTable.description + " TEXT," + SwanAppTable.error_code + " INTEGER," + SwanAppTable.error_detail + " TEXT," + SwanAppTable.error_msg + " TEXT," + SwanAppTable.resume_date + " TEXT," + SwanAppTable.icon + " TEXT," + SwanAppTable.icon_url + " TEXT," + SwanAppTable.max_swan_version + " TEXT," + SwanAppTable.min_swan_version + " TEXT," + SwanAppTable.name + " TEXT," + SwanAppTable.service_category + " TEXT," + SwanAppTable.subject_info + " TEXT," + SwanAppTable.bear_info + " TEXT," + SwanAppTable.sign + " TEXT," + SwanAppTable.type + " INTEGER," + SwanAppTable.is_have_zip + " INTEGER," + SwanAppTable.app_open_url + " TEXT," + SwanAppTable.app_download_url + " TEXT," + SwanAppTable.target_swan_version + " TEXT," + SwanAppTable.app_zip_size + " LONG," + SwanAppTable.pending_aps_errcode + " INTEGER," + SwanAppTable.version_code + " TEXT," + SwanAppTable.app_category + " INTEGER," + SwanAppTable.orientation + " INTEGER," + SwanAppTable.max_age + " LONG," + SwanAppTable.create_time + " LONG," + SwanAppTable.force_fetch_meta_info + " INTEGER," + SwanAppTable.pay_protected + " INTEGER," + SwanAppTable.quick_app_key + " TEXT);";
        }
        return (String) invokeV.objValue;
    }

    public static SwanAppDbControl f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (f45957c == null) {
                synchronized (SwanAppDbControl.class) {
                    if (f45957c == null) {
                        Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                        f45958d = new a(context.getApplicationContext(), "ai_apps.db", f45956b);
                        f45957c = new SwanAppDbControl();
                    }
                }
            }
            return f45957c;
        }
        return (SwanAppDbControl) invokeL.objValue;
    }

    public int b(@Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, strArr)) == null) ? f45958d.getWritableDatabase().delete("ai_apps_favorites", str, strArr) : invokeLL.intValue;
    }

    public int c(@Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, strArr)) == null) ? f45958d.getWritableDatabase().delete("ai_apps_history", str, strArr) : invokeLL.intValue;
    }

    public SQLiteDatabase e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f45958d.getWritableDatabase() : (SQLiteDatabase) invokeV.objValue;
    }

    public final Cursor g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                SQLiteDatabase readableDatabase = f45958d.getReadableDatabase();
                return readableDatabase.rawQuery("select * from ai_apps_aps_data where " + SwanAppTable.app_id.name() + " = ? ", new String[]{str});
            } catch (SQLException e2) {
                if (f45955a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (Cursor) invokeL.objValue;
    }

    public SQLiteOpenHelper h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f45958d : (SQLiteOpenHelper) invokeV.objValue;
    }

    public long i(@Nullable ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, contentValues)) == null) ? f45958d.getWritableDatabase().insertWithOnConflict("ai_apps_favorites", null, contentValues, 5) : invokeL.longValue;
    }

    public long j(@Nullable ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, contentValues)) == null) ? f45958d.getWritableDatabase().insertWithOnConflict("ai_apps_history", null, contentValues, 5) : invokeL.longValue;
    }

    public Cursor k(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, strArr, str, strArr2, str2)) == null) {
            SQLiteDatabase writableDatabase = f45958d.getWritableDatabase();
            return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_favorites ON ai_apps_favorites.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
        }
        return (Cursor) invokeLLLL.objValue;
    }

    public Cursor l(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr, str, strArr2, str2)) == null) ? f45958d.getWritableDatabase().query("ai_apps_favorites", strArr, str, strArr2, null, null, str2) : (Cursor) invokeLLLL.objValue;
    }

    public Cursor m(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, strArr, str, strArr2, str2)) == null) {
            SQLiteDatabase writableDatabase = f45958d.getWritableDatabase();
            return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_history ON ai_apps_history.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
        }
        return (Cursor) invokeLLLL.objValue;
    }

    public Cursor n(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, strArr, str, strArr2, str2)) == null) ? f45958d.getWritableDatabase().query("ai_apps_history", strArr, str, strArr2, null, null, str2) : (Cursor) invokeLLLL.objValue;
    }

    public c.a.p0.a.j0.a o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            c.a.p0.a.j0.a aVar = new c.a.p0.a.j0.a();
            if (!TextUtils.isEmpty(str)) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = g(str);
                        if (cursor != null && cursor.moveToFirst()) {
                            s(cursor, aVar);
                        }
                    } catch (Exception e2) {
                        if (f45955a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    c.a.p0.t.d.d(cursor);
                }
            }
            return aVar;
        }
        return (c.a.p0.a.j0.a) invokeL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            f45957c = null;
            f45958d = null;
        }
    }

    public int q(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, contentValues, str, strArr)) == null) ? f45958d.getWritableDatabase().update("ai_apps_favorites", contentValues, str, strArr) : invokeLLL.intValue;
    }

    public int r(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, contentValues, str, strArr)) == null) ? f45958d.getWritableDatabase().update("ai_apps_history", contentValues, str, strArr) : invokeLLL.intValue;
    }

    public void s(Cursor cursor, c.a.p0.a.j0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, cursor, aVar) == null) || cursor == null || cursor.getCount() <= 0) {
            return;
        }
        if (f45955a) {
            String str = "updateQueryAPSFileList: cursor=" + cursor.toString() + ", swanAppDbInfo =" + aVar.toString();
        }
        if (f45955a) {
            String str2 = "updateQueryAPSFileList: cursor.getCount()=" + cursor.getCount();
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
        aVar.f6911a = cursor.getString(columnIndex);
        aVar.f6912b = cursor.getString(columnIndex2);
        aVar.f6913c = cursor.getString(columnIndex3);
        aVar.f6914d = cursor.getInt(columnIndex4);
        aVar.f6915e = cursor.getString(columnIndex5);
        aVar.f6916f = cursor.getString(columnIndex6);
        aVar.f6917g = cursor.getString(columnIndex7);
        aVar.f6918h = cursor.getString(columnIndex8);
        aVar.f6919i = cursor.getString(columnIndex9);
        aVar.f6920j = cursor.getString(columnIndex10);
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
