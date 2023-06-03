package com.baidu.android.pushservice.m;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.PushService;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static f a = null;
    public static final Object b;
    public static int c = 200;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                if (file == null) {
                    return false;
                }
                String name = file.getName();
                return name.contains("pushstat") && !name.contains(this.a);
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.android.pushservice.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class EnumC0029b {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC0029b a;
        public static final EnumC0029b b;
        public static final EnumC0029b c;
        public static final EnumC0029b d;
        public static final EnumC0029b e;
        public static final EnumC0029b f;
        public static final EnumC0029b g;
        public static final /* synthetic */ EnumC0029b[] h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846339745, "Lcom/baidu/android/pushservice/m/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846339745, "Lcom/baidu/android/pushservice/m/b$b;");
                    return;
                }
            }
            a = new EnumC0029b("alarmMsgInfoId", 0);
            b = new EnumC0029b("msgId", 1);
            c = new EnumC0029b("sendtime", 2);
            d = new EnumC0029b("showtime", 3);
            e = new EnumC0029b("expiretime", 4);
            f = new EnumC0029b("msgEnable", 5);
            EnumC0029b enumC0029b = new EnumC0029b("isAlarm", 6);
            g = enumC0029b;
            h = new EnumC0029b[]{a, b, c, d, e, f, enumC0029b};
        }

        public EnumC0029b(String str, int i) {
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

        public static EnumC0029b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC0029b) Enum.valueOf(EnumC0029b.class, str) : (EnumC0029b) invokeL.objValue;
        }

        public static EnumC0029b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC0029b[]) h.clone() : (EnumC0029b[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public static final c b;
        public static final c c;
        public static final c d;
        public static final c e;
        public static final c f;
        public static final c g;
        public static final c h;
        public static final c i;
        public static final /* synthetic */ c[] j;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846339714, "Lcom/baidu/android/pushservice/m/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846339714, "Lcom/baidu/android/pushservice/m/b$c;");
                    return;
                }
            }
            a = new c("appInfoId", 0);
            b = new c("appid", 1);
            c = new c("appType", 2);
            d = new c("packageName", 3);
            e = new c("appName", 4);
            f = new c("cFrom", 5);
            g = new c(PushService.APP_VERSION_CODE, 6);
            h = new c(PushService.APP_VERSION_NAME, 7);
            c cVar = new c("intergratedPushVersion", 8);
            i = cVar;
            j = new c[]{a, b, c, d, e, f, g, h, cVar};
        }

        public c(String str, int i2) {
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

        public static c valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
        }

        public static c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) j.clone() : (c[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        public static final d e;
        public static final d f;
        public static final d g;
        public static final d h;
        public static final d i;
        public static final d j;
        public static final d k;
        public static final d l;
        public static final d m;
        public static final d n;
        public static final d o;
        public static final /* synthetic */ d[] p;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846339683, "Lcom/baidu/android/pushservice/m/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846339683, "Lcom/baidu/android/pushservice/m/b$d;");
                    return;
                }
            }
            a = new d("actionId", 0);
            b = new d("actionName", 1);
            c = new d(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            d = new d("networkStatus", 3);
            e = new d("msgType", 4);
            f = new d("msgId", 5);
            g = new d("msgLen", 6);
            h = new d("errorMsg", 7);
            i = new d("requestId", 8);
            j = new d("stableHeartInterval", 9);
            k = new d("errorCode", 10);
            l = new d("appid", 11);
            m = new d("channel", 12);
            n = new d("openByPackageName", 13);
            d dVar = new d("packageName", 14);
            o = dVar;
            p = new d[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, dVar};
        }

        public d(String str, int i2) {
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

        public static d valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (d) Enum.valueOf(d.class, str) : (d) invokeL.objValue;
        }

        public static d[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (d[]) p.clone() : (d[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class e implements DatabaseErrorHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        @TargetApi(16)
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                try {
                    if (Build.VERSION.SDK_INT > 18) {
                        SQLiteDatabase.deleteDatabase(new File(str));
                    } else {
                        new File(str).delete();
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
                if (!sQLiteDatabase.isOpen()) {
                    a(sQLiteDatabase.getPath());
                    return;
                }
                List<Pair<String, String>> list = null;
                try {
                    try {
                        list = sQLiteDatabase.getAttachedDbs();
                    } catch (SQLiteException unused) {
                    }
                    try {
                        sQLiteDatabase.close();
                    } catch (SQLiteException unused2) {
                    }
                } finally {
                    if (list != null) {
                        for (Pair<String, String> next : list) {
                            a((String) next.second);
                        }
                    } else {
                        a(sQLiteDatabase.getPath());
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;
        public static final String b;
        public static final String c;
        public static final String d;
        public static final String e;
        public static final String f;
        public static final String g;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846339621, "Lcom/baidu/android/pushservice/m/b$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846339621, "Lcom/baidu/android/pushservice/m/b$f;");
                    return;
                }
            }
            a = "CREATE TABLE StatisticsInfo (" + j.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + j.b.name() + " TEXT NOT NULL, " + j.c.name() + " TEXT NOT NULL, " + j.d.name() + " TEXT, " + j.e.name() + " TEXT NOT NULL, " + j.f.name() + " TEXT NOT NULL, " + j.g.name() + " TEXT NOT NULL, " + j.h.name() + " TEXT);";
            b = "CREATE TABLE PushBehavior (" + d.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.b.name() + " TEXT NOT NULL, " + d.c.name() + " LONG NOT NULL, " + d.d.name() + " TEXT, " + d.e.name() + " INTEGER, " + d.f.name() + " TEXT, " + d.g.name() + " INTEGER, " + d.h.name() + " TEXT, " + d.i.name() + " TEXT, " + d.j.name() + " INTEGER, " + d.k.name() + " INTEGER, " + d.l.name() + " TEXT, " + d.m.name() + " TEXT, " + d.o.name() + " TEXT, " + d.n.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE MsgArriveApp (");
            sb.append(h.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(h.b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.c.name());
            sb.append(" LONG NOT NULL);");
            c = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE AlarmMsgInfo (");
            sb2.append(EnumC0029b.a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(EnumC0029b.b.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(EnumC0029b.c.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0029b.d.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0029b.e.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0029b.f.name());
            sb2.append(" INTEGER, ");
            sb2.append(EnumC0029b.g.name());
            sb2.append(" INTEGER);");
            d = sb2.toString();
            e = "CREATE TABLE AppInfo (" + c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.b.name() + " TEXT, " + c.c.name() + " INTEGER, " + c.d.name() + " TEXT UNIQUE, " + c.e.name() + " TEXT, " + c.f.name() + " TEXT, " + c.g.name() + " TEXT, " + c.h.name() + " TEXT, " + c.i.name() + " TEXT);";
            f = "CREATE TABLE FileDownloadingInfo (" + g.a.name() + " TEXT, " + g.b.name() + " TEXT PRIMARY KEY, " + g.e.name() + " TEXT NOT NULL, " + g.c.name() + " TEXT, " + g.d.name() + " TEXT, " + g.f.name() + " TEXT NOT NULL, " + g.g.name() + " INTEGER NOT NULL, " + g.h.name() + " INTEGER NOT NULL, " + g.i.name() + " INTEGER NOT NULL," + g.j.name() + " INTEGER NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE NoDisturb (");
            sb3.append(i.a.name());
            sb3.append(" TEXT NOT NULL, ");
            sb3.append(i.b.name());
            sb3.append(" INTEGER, ");
            sb3.append(i.c.name());
            sb3.append(" INTEGER, ");
            sb3.append(i.d.name());
            sb3.append(" INTEGER, ");
            sb3.append(i.e.name());
            sb3.append(" INTEGER);");
            g = sb3.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i)};
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i), databaseErrorHandler};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (DatabaseErrorHandler) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public final void a(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS StatisticsInfo");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS FileDownloadingInfo");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushBehavior");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AlarmMsgInfo");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS NoDisturb");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MsgArriveApp");
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(a);
                    sQLiteDatabase.execSQL(b);
                    sQLiteDatabase.execSQL(c);
                    sQLiteDatabase.execSQL(d);
                    sQLiteDatabase.execSQL(e);
                    sQLiteDatabase.execSQL(f);
                    sQLiteDatabase.execSQL(g);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i, i2) == null) {
                a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;
        public static final g b;
        public static final g c;
        public static final g d;
        public static final g e;
        public static final g f;
        public static final g g;
        public static final g h;
        public static final g i;
        public static final g j;
        public static final /* synthetic */ g[] k;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846339590, "Lcom/baidu/android/pushservice/m/b$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846339590, "Lcom/baidu/android/pushservice/m/b$g;");
                    return;
                }
            }
            a = new g("belongTo", 0);
            b = new g(TTDownloadField.TT_DOWNLOAD_URL, 1);
            c = new g("title", 2);
            d = new g("description", 3);
            e = new g("savePath", 4);
            f = new g("fileName", 5);
            g = new g("downloadBytes", 6);
            h = new g("totalBytes", 7);
            i = new g("downloadStatus", 8);
            g gVar = new g(PmsConstant.Statistic.Key.REV_TIMESTAMP, 9);
            j = gVar;
            k = new g[]{a, b, c, d, e, f, g, h, i, gVar};
        }

        public g(String str, int i2) {
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

        public static g valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (g) Enum.valueOf(g.class, str) : (g) invokeL.objValue;
        }

        public static g[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (g[]) k.clone() : (g[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;
        public static final h a;
        public static final h b;
        public static final h c;
        public static final /* synthetic */ h[] d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846339559, "Lcom/baidu/android/pushservice/m/b$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846339559, "Lcom/baidu/android/pushservice/m/b$h;");
                    return;
                }
            }
            a = new h("MsgInfoId", 0);
            b = new h("msgId", 1);
            h hVar = new h(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            c = hVar;
            d = new h[]{a, b, hVar};
        }

        public h(String str, int i) {
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

        public static h valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (h) Enum.valueOf(h.class, str) : (h) invokeL.objValue;
        }

        public static h[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) d.clone() : (h[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class i {
        public static /* synthetic */ Interceptable $ic;
        public static final i a;
        public static final i b;
        public static final i c;
        public static final i d;
        public static final i e;
        public static final /* synthetic */ i[] f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846339528, "Lcom/baidu/android/pushservice/m/b$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846339528, "Lcom/baidu/android/pushservice/m/b$i;");
                    return;
                }
            }
            a = new i("pkgName", 0);
            b = new i("startHour", 1);
            c = new i("startMinute", 2);
            d = new i("endHour", 3);
            i iVar = new i("endMinute", 4);
            e = iVar;
            f = new i[]{a, b, c, d, iVar};
        }

        public i(String str, int i) {
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

        public static i valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (i) Enum.valueOf(i.class, str) : (i) invokeL.objValue;
        }

        public static i[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (i[]) f.clone() : (i[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class j {
        public static /* synthetic */ Interceptable $ic;
        public static final j a;
        public static final j b;
        public static final j c;
        public static final j d;
        public static final j e;
        public static final j f;
        public static final j g;
        public static final j h;
        public static final /* synthetic */ j[] i;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846339497, "Lcom/baidu/android/pushservice/m/b$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846339497, "Lcom/baidu/android/pushservice/m/b$j;");
                    return;
                }
            }
            a = new j("info_id", 0);
            b = new j("packageName", 1);
            c = new j("open_type", 2);
            d = new j("msgid", 3);
            e = new j("app_open_time", 4);
            f = new j("app_close_time", 5);
            g = new j("use_duration", 6);
            j jVar = new j("extra", 7);
            h = jVar;
            i = new j[]{a, b, c, d, e, f, g, jVar};
        }

        public j(String str, int i2) {
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

        public static j valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (j) Enum.valueOf(j.class, str) : (j) invokeL.objValue;
        }

        public static j[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (j[]) i.clone() : (j[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676780835, "Lcom/baidu/android/pushservice/m/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676780835, "Lcom/baidu/android/pushservice/m/b;");
                return;
            }
        }
        b = new Object();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00eb, code lost:
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        long insert;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) != null) {
            return invokeCommon.longValue;
        }
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            long j2 = -1;
            if (a2 == null) {
                return -1L;
            }
            Cursor cursor = null;
            try {
                Cursor cursor2 = a2.query("NoDisturb", new String[]{i.a.name()}, i.a.name() + "= ?", new String[]{str}, null, null, null);
                try {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(i.a.name(), str);
                        contentValues.put(i.b.name(), Integer.valueOf(i2));
                        contentValues.put(i.c.name(), Integer.valueOf(i3));
                        contentValues.put(i.d.name(), Integer.valueOf(i4));
                        contentValues.put(i.e.name(), Integer.valueOf(i5));
                        if (cursor2 == null || !cursor2.moveToNext()) {
                            insert = a2.insert("NoDisturb", null, contentValues);
                        } else {
                            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                                update = a2.delete("NoDisturb", i.a.name() + "= ?", new String[]{str});
                            } else {
                                update = a2.update("NoDisturb", contentValues, i.a.name() + "= ?", new String[]{str});
                            }
                            insert = update;
                        }
                        j2 = insert;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception unused) {
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                a2.close();
                                return j2;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                } catch (Exception unused2) {
                    cursor = cursor2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    a2.close();
                    return j2;
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static SQLiteDatabase a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            f b2 = b(context);
            if (b2 == null) {
                return null;
            }
            try {
                return b2.getWritableDatabase();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (SQLiteDatabase) invokeL.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (b) {
                try {
                    if (a != null) {
                        a.close();
                        a = null;
                    }
                } catch (Exception unused) {
                    a = null;
                }
            }
        }
    }

    public static void a(String str, Context context) {
        File parentFile;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context) == null) || (parentFile = context.getDatabasePath("pushstat_8.3.18.db").getParentFile()) == null || !parentFile.isDirectory() || (listFiles = parentFile.listFiles(new a(str))) == null) {
            return;
        }
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a8, code lost:
        if (r13 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] a(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65541, null, context, str)) != null) {
            return (int[]) invokeLL.objValue;
        }
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor2 = null;
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("NoDisturb", null, i.a.name() + "= ?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            int i2 = cursor.getInt(cursor.getColumnIndex(i.b.name()));
                            int i3 = cursor.getInt(cursor.getColumnIndex(i.c.name()));
                            int i4 = cursor.getInt(cursor.getColumnIndex(i.d.name()));
                            int i5 = cursor.getInt(cursor.getColumnIndex(i.e.name()));
                            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                                int[] iArr = new int[0];
                                if (cursor != null) {
                                    cursor.close();
                                }
                                a2.close();
                                return iArr;
                            }
                            int[] iArr2 = {i2, i3, i4, i5};
                            if (cursor != null) {
                                cursor.close();
                            }
                            a2.close();
                            return iArr2;
                        }
                    } catch (Exception unused) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.close();
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        a2.close();
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static f b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            synchronized (b) {
                if (a == null) {
                    String path = context.getDatabasePath("pushstat_8.3.18.db").getPath();
                    a("pushstat_8.3.18.db", context);
                    a = Build.VERSION.SDK_INT >= 11 ? new f(context, path, 2, new e(null)) : new f(context, path, 2);
                }
            }
            return a;
        }
        return (f) invokeL.objValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        ContentValues contentValues;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return true;
                }
                Cursor cursor2 = null;
                try {
                    contentValues = new ContentValues();
                    contentValues.clear();
                    contentValues.put(h.b.name(), str);
                    contentValues.put(h.c.name(), Long.valueOf(System.currentTimeMillis()));
                    String str2 = h.b.name() + " =? ";
                    query = a2.query("MsgArriveApp", new String[]{h.b.name()}, str2, new String[]{str}, null, null, null);
                    if (query != null) {
                        try {
                            if (query.getCount() > 0) {
                                a2.update("MsgArriveApp", contentValues, str2, new String[]{str});
                                if (query != null && !query.isClosed()) {
                                    query.close();
                                }
                                a2.close();
                                return false;
                            }
                        } catch (Exception unused) {
                            cursor = null;
                            cursor2 = query;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            a2.close();
                            return true;
                        } catch (Throwable th) {
                            th = th;
                            cursor = null;
                            cursor2 = query;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            a2.close();
                            throw th;
                        }
                    }
                    cursor = a2.rawQuery("SELECT COUNT(*) FROM MsgArriveApp;", null);
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                try {
                    cursor.moveToFirst();
                    if (cursor.getInt(0) > c) {
                        a2.delete("MsgArriveApp", null, null);
                    }
                    a2.insert("MsgArriveApp", null, contentValues);
                    if (query != null && !query.isClosed()) {
                        query.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return true;
                } catch (Exception unused3) {
                    cursor2 = query;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
            }
        }
        return invokeLL.booleanValue;
    }
}
