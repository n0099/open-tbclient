package c.a.p0.n.g.d;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements a<PMSAppInfo> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f11869a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(773090134, "Lc/a/p0/n/g/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(773090134, "Lc/a/p0/n/g/d/b;");
                return;
            }
        }
        f11869a = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
    }

    public b() {
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

    @Override // c.a.p0.n.g.d.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL(b());
        }
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "CREATE TABLE " + c() + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT UNIQUE,app_key TEXT NOT NULL,app_sign LONG DEFAULT 0,version_code INTEGER DEFAULT 0,version_name TEXT,description TEXT,app_status INTEGER,status_detail TEXT,status_desc TEXT,resume_date TEXT,icon_url TEXT,app_name TEXT NOT NULL,service_category TEXT,subject_info TEXT,type INTEGER,pkg_size LONG,pending_err_code INTEGER,app_category INTEGER,orientation INTEGER,max_age LONG,create_time LONG,webview_domains TEXT,web_action TEXT,domains TEXT," + SwanAppBearInfo.BEAR_INFO + " TEXT,server_ext TEXT,pay_protected INTEGER,customer_service INTEGER,global_notice INTEGER,global_private INTEGER,pa_number TEXT,brand TEXT,last_launch_time LONG DEFAULT 0,launch_count INTEGER DEFAULT 0,install_src INTEGER DEFAULT 0,web_url TEXT,quick_app_key TEXT,cs_protocol_version INTEGER DEFAULT 0);";
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "swan_app" : (String) invokeV.objValue;
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD customer_service INTEGER default " + PMSConstants.PayProtected.NO_PAY_PROTECTED.type + ";");
                sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD global_notice INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ";");
                sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD global_private INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ";");
                StringBuilder sb = new StringBuilder();
                sb.append("ALTER TABLE ");
                sb.append(c());
                sb.append(" ADD ");
                sb.append("pa_number");
                sb.append(" TEXT;");
                sQLiteDatabase.execSQL(sb.toString());
            } catch (SQLException unused) {
            }
        }
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD brand TEXT;");
            } catch (SQLException unused) {
            }
        }
    }

    public final void f(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            try {
                String c2 = c();
                sQLiteDatabase.execSQL("ALTER TABLE " + c2 + " ADD last_launch_time LONG DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE " + c2 + " ADD launch_count INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE " + c2 + " ADD install_src INTEGER DEFAULT 0;");
            } catch (SQLException unused) {
            }
        }
    }

    public final void g(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD web_url TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD quick_app_key TEXT;");
            } catch (SQLException unused) {
            }
        }
    }

    public final void h(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD cs_protocol_version INTEGER DEFAULT 0;");
            } catch (SQLException unused) {
            }
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD pay_protected INTEGER default " + f11869a + ";");
            } catch (SQLException unused) {
            }
        }
    }

    @Override // c.a.p0.n.g.d.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, sQLiteDatabase, i2, i3) == null) {
            while (i2 < i3) {
                if (i2 == 1) {
                    i(sQLiteDatabase);
                } else if (i2 != 4) {
                    switch (i2) {
                        case 6:
                            e(sQLiteDatabase);
                            continue;
                        case 7:
                            f(sQLiteDatabase);
                            continue;
                        case 8:
                            g(sQLiteDatabase);
                            continue;
                        case 9:
                            h(sQLiteDatabase);
                            continue;
                    }
                } else {
                    d(sQLiteDatabase);
                }
                i2++;
            }
        }
    }
}
