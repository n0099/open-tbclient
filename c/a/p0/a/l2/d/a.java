package c.a.p0.a.l2.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.p0.a.a1.e;
import c.a.p0.a.e0.d;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class a extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7290f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f7291e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(399085015, "Lc/a/p0/a/l2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(399085015, "Lc/a/p0/a/l2/d/a;");
                return;
            }
        }
        f7290f = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, String str) {
        super(context.getApplicationContext(), h(str), (SQLiteDatabase.CursorFactory) null, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7291e = str;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "CREATE TABLE cookies (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,value TEXT,domain TEXT,path TEXT,expires INTEGER,secure INTEGER,ext TEXT);" : (String) invokeV.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String o = e.o(str);
            File file = new File(o);
            if (!file.exists() && !file.mkdirs()) {
                d.h("SwanCookieDBHelper", "mkdirs fail: " + o);
            }
            return o + File.separator + "smCookie.db";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        InterceptResult invokeV;
        SQLiteDatabase sQLiteDatabase;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                try {
                    sQLiteDatabase = super.getReadableDatabase();
                } catch (Exception e3) {
                    sQLiteDatabase = null;
                    e2 = e3;
                }
                try {
                    String databaseName = getDatabaseName();
                    if (!new File(databaseName).exists()) {
                        d.h("SwanCookieDBHelper", "getReadableDatabase file is not exit: " + databaseName);
                        return null;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    d.h("SwanCookieDBHelper", "getRead fail mAppId =" + this.f7291e + ";" + Log.getStackTraceString(e2));
                    if (f7290f) {
                        throw new RuntimeException(e2);
                    }
                    return sQLiteDatabase;
                }
                return sQLiteDatabase;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        InterceptResult invokeV;
        SQLiteDatabase sQLiteDatabase;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (Exception e3) {
                    sQLiteDatabase = null;
                    e2 = e3;
                }
                try {
                    String databaseName = getDatabaseName();
                    if (!new File(databaseName).exists()) {
                        d.h("SwanCookieDBHelper", "getWritableDatabase file is not exit: " + databaseName);
                        return null;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    d.h("SwanCookieDBHelper", "getWrite fail mAppId =" + this.f7291e + ";" + Log.getStackTraceString(e2));
                    if (f7290f) {
                        throw new RuntimeException(e2);
                    }
                    return sQLiteDatabase;
                }
                return sQLiteDatabase;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            boolean z = f7290f;
            try {
                sQLiteDatabase.execSQL(g());
            } catch (Exception e2) {
                d.h("SwanCookieDBHelper", "createTableSql fail:" + Log.getStackTraceString(e2));
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) && f7290f) {
            String str = "oldVersion = " + i2 + ";newVersion=" + i3;
        }
    }
}
