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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.database.cloudconfig.SwanAppConfTokenTable;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.tieba.bb2;
import com.baidu.tieba.e12;
import com.baidu.tieba.eb2;
import com.baidu.tieba.fb2;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.hb2;
import com.baidu.tieba.ib2;
import com.baidu.tieba.ik4;
import com.baidu.tieba.jb2;
import com.baidu.tieba.ln2;
import com.baidu.tieba.ok1;
import com.baidu.tieba.sh2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class SwanAppDbControl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final int b;
    public static volatile SwanAppDbControl c;
    public static a d;
    public static final int e;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            app_key = new SwanAppTable(GameGuideConfigInfo.KEY_APP_KEY, 2);
            version = new SwanAppTable("version", 3);
            description = new SwanAppTable("description", 4);
            error_code = new SwanAppTable("error_code", 5);
            error_detail = new SwanAppTable("error_detail", 6);
            error_msg = new SwanAppTable(GameCodeGetResponseMsg.PARAM_ERROR_MSG, 7);
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

        public SwanAppTable(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SwanAppTable) Enum.valueOf(SwanAppTable.class, str);
            }
            return (SwanAppTable) invokeL.objValue;
        }

        public static SwanAppTable[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SwanAppTable[]) $VALUES.clone();
            }
            return (SwanAppTable[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public final void c(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sQLiteDatabase) == null) {
            }
        }

        public final void w(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, sQLiteDatabase) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final void A(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD app_key TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD version_code TEXT;");
                } catch (SQLException e) {
                    if (SwanAppDbControl.a) {
                        Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                    }
                }
            }
        }

        public final void a(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(SwanAppDbControl.d());
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }

        public final void d(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.version_code + " TEXT;");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void h(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.icon_url + " TEXT;");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void j(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_zip_size + " LONG;");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void k(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pending_aps_errcode + " INTEGER;");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void m(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, sQLiteDatabase) == null) {
                eb2.a(sQLiteDatabase);
            }
        }

        public final void o(@NonNull SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, sQLiteDatabase) == null) {
                jb2.a(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, sQLiteDatabase) == null) {
                a(sQLiteDatabase);
                SwanAppConfTokenTable.a(sQLiteDatabase);
                eb2.a(sQLiteDatabase);
                ib2.a(sQLiteDatabase);
                jb2.a(sQLiteDatabase);
                fb2.a(sQLiteDatabase);
            }
        }

        public final void p(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, sQLiteDatabase) == null) {
                ib2.a(sQLiteDatabase);
                ib2.b(sQLiteDatabase);
                b(sQLiteDatabase);
            }
        }

        public final void s(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, sQLiteDatabase) == null) {
                sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_swan_history");
            }
        }

        public final void x(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD is_new_favor INTEGER DEFAULT 0;");
                } catch (SQLException e) {
                    e12.l("SwanAppDbControl", "updateSwanFavoriteTableV123 fail", e);
                }
            }
        }

        public final void y(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_favorites ADD pay_protected INTEGER DEFAULT 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_history ADD pay_protected INTEGER DEFAULT 0;");
                } catch (SQLException e) {
                    e12.l("SwanAppDbControl", "updateSwanHistoryANDFavoriteTableV123 fail", e);
                }
            }
        }

        public final void b(SQLiteDatabase sQLiteDatabase) {
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                List<ContentValues> a = ln2.x().a();
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
                if (a != null && a.size() != 0) {
                    try {
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
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_category + " INTEGER default 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.orientation + " INTEGER default 0;");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void f(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.max_age + " LONG default 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.create_time + " LONG default 0;");
                } catch (SQLException e) {
                    if (SwanAppDbControl.a) {
                        Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                    }
                }
            }
        }

        public final void g(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_key + " TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.type + " INTEGER default 0;");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void i(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_open_url + " TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.app_download_url + " TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.target_swan_version + " TEXT;");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void l(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.bear_info + " TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.force_fetch_meta_info + " INTEGER default 0;");
                } catch (SQLException e) {
                    if (SwanAppDbControl.a) {
                        Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                    }
                }
            }
        }

        public final void n(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, sQLiteDatabase) == null) {
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
        }

        public final void r(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.quick_app_key + " TEXT;");
                } catch (SQLException e) {
                    if (SwanAppDbControl.a) {
                        Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                    }
                }
            }
        }

        public final void v(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + SwanAppTable.pay_protected + " INTEGER default " + SwanAppDbControl.e + ParamableElem.DIVIDE_PARAM);
                } catch (SQLException e) {
                    if (SwanAppDbControl.a) {
                        Log.e("SwanAppDbControl", Log.getStackTraceString(e));
                    }
                }
            }
        }

        public final void z(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, sQLiteDatabase) == null) {
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
                hb2.v(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @SuppressLint({"BDThrowableCheck"})
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048593, this, sQLiteDatabase, i, i2) == null) {
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
                            l(sQLiteDatabase);
                            break;
                        case 11:
                            m(sQLiteDatabase);
                            break;
                        case 12:
                            p(sQLiteDatabase);
                            break;
                        case 13:
                            w(sQLiteDatabase);
                            break;
                        case 14:
                            s(sQLiteDatabase);
                            break;
                        case 15:
                            v(sQLiteDatabase);
                            break;
                        case 16:
                            n(sQLiteDatabase);
                            break;
                        case 17:
                            o(sQLiteDatabase);
                            break;
                        case 18:
                            fb2.a(sQLiteDatabase);
                            break;
                        case 19:
                            r(sQLiteDatabase);
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
        a = ok1.a;
        e = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
        b = 24;
    }

    public SwanAppDbControl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public SQLiteDatabase e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return d.getWritableDatabase();
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public SQLiteOpenHelper h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return d;
        }
        return (SQLiteOpenHelper) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c = null;
            d = null;
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
            if (c == null) {
                synchronized (SwanAppDbControl.class) {
                    if (c == null) {
                        Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                        d = new a(context.getApplicationContext(), "ai_apps.db", b);
                        c = new SwanAppDbControl();
                    }
                }
            }
            return c;
        }
        return (SwanAppDbControl) invokeL.objValue;
    }

    public bb2 o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            bb2 bb2Var = new bb2();
            if (!TextUtils.isEmpty(str)) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = g(str);
                        if (cursor != null && cursor.moveToFirst()) {
                            s(cursor, bb2Var);
                        }
                    } catch (Exception e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    ik4.d(cursor);
                }
            }
            return bb2Var;
        }
        return (bb2) invokeL.objValue;
    }

    public int b(@Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, strArr)) == null) {
            return d.getWritableDatabase().delete("ai_apps_favorites", str, strArr);
        }
        return invokeLL.intValue;
    }

    public int c(@Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, strArr)) == null) {
            return d.getWritableDatabase().delete("ai_apps_history", str, strArr);
        }
        return invokeLL.intValue;
    }

    public final Cursor g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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
        return (Cursor) invokeL.objValue;
    }

    public long i(@Nullable ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, contentValues)) == null) {
            return d.getWritableDatabase().insertWithOnConflict("ai_apps_favorites", null, contentValues, 5);
        }
        return invokeL.longValue;
    }

    public long j(@Nullable ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, contentValues)) == null) {
            return d.getWritableDatabase().insertWithOnConflict("ai_apps_history", null, contentValues, 5);
        }
        return invokeL.longValue;
    }

    public Cursor k(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, strArr, str, strArr2, str2)) == null) {
            SQLiteDatabase writableDatabase = d.getWritableDatabase();
            return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_favorites ON ai_apps_favorites.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, str, strArr2, null, null, str2);
        }
        return (Cursor) invokeLLLL.objValue;
    }

    public Cursor m(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, strArr, str, strArr2, str2)) == null) {
            SQLiteDatabase writableDatabase = d.getWritableDatabase();
            return writableDatabase.query("ai_apps_aps_data INNER JOIN ai_apps_history ON ai_apps_history.app_id = ai_apps_aps_data." + SwanAppTable.app_id, strArr, sh2.a(str), strArr2, null, null, str2);
        }
        return (Cursor) invokeLLLL.objValue;
    }

    public Cursor l(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr, str, strArr2, str2)) == null) {
            return d.getWritableDatabase().query("ai_apps_favorites", strArr, str, strArr2, null, null, str2);
        }
        return (Cursor) invokeLLLL.objValue;
    }

    public Cursor n(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, strArr, str, strArr2, str2)) == null) {
            return d.getWritableDatabase().query("ai_apps_history", strArr, sh2.a(str), strArr2, null, null, str2);
        }
        return (Cursor) invokeLLLL.objValue;
    }

    public int q(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, contentValues, str, strArr)) == null) {
            return d.getWritableDatabase().update("ai_apps_favorites", contentValues, str, strArr);
        }
        return invokeLLL.intValue;
    }

    public int r(@Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, contentValues, str, strArr)) == null) {
            return d.getWritableDatabase().update("ai_apps_history", contentValues, str, strArr);
        }
        return invokeLLL.intValue;
    }

    public void s(Cursor cursor, bb2 bb2Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, cursor, bb2Var) == null) && cursor != null && cursor.getCount() > 0) {
            if (a) {
                Log.d("SwanAppDbControl", "updateQueryAPSFileList: cursor=" + cursor.toString() + ", swanAppDbInfo =" + bb2Var.toString());
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
            bb2Var.a = cursor.getString(columnIndex);
            bb2Var.b = cursor.getString(columnIndex2);
            bb2Var.c = cursor.getString(columnIndex3);
            bb2Var.d = cursor.getInt(columnIndex4);
            bb2Var.e = cursor.getString(columnIndex5);
            bb2Var.f = cursor.getString(columnIndex6);
            bb2Var.g = cursor.getString(columnIndex7);
            bb2Var.h = cursor.getString(columnIndex8);
            bb2Var.i = cursor.getString(columnIndex9);
            bb2Var.j = cursor.getString(columnIndex10);
            bb2Var.k = cursor.getString(columnIndex11);
            bb2Var.l = cursor.getString(columnIndex12);
            bb2Var.m = cursor.getString(columnIndex13);
            bb2Var.n = cursor.getString(columnIndex14);
            bb2Var.o = cursor.getString(columnIndex15);
            bb2Var.p = cursor.getString(columnIndex16);
            bb2Var.r = cursor.getInt(columnIndex17);
            bb2Var.s = cursor.getInt(columnIndex18);
            bb2Var.q = cursor.getString(columnIndex19);
            bb2Var.t = cursor.getString(columnIndex20);
            bb2Var.u = cursor.getString(columnIndex21);
            bb2Var.v = cursor.getString(columnIndex22);
            bb2Var.w = cursor.getLong(columnIndex23);
            bb2Var.x = cursor.getInt(columnIndex24);
            bb2Var.A = cursor.getString(columnIndex25);
            bb2Var.y = cursor.getInt(columnIndex26);
            bb2Var.z = cursor.getInt(columnIndex27);
            bb2Var.B = cursor.getLong(columnIndex29);
            bb2Var.C = cursor.getLong(columnIndex30);
            if (cursor.getInt(columnIndex28) != 0) {
                z = true;
            } else {
                z = false;
            }
            bb2Var.D = z;
            bb2Var.E = cursor.getInt(columnIndex31);
            bb2Var.F = cursor.getString(columnIndex32);
        }
    }
}
