package com.baidu.android.pushservice.c;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.vivo.push.PushClientConstants;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static e f35026a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f35027b;

    /* renamed from: c  reason: collision with root package name */
    public static int f35028c = 200;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.android.pushservice.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class EnumC1545a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC1545a f35035a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1545a f35036b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1545a f35037c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC1545a f35038d;

        /* renamed from: e  reason: collision with root package name */
        public static final EnumC1545a f35039e;

        /* renamed from: f  reason: collision with root package name */
        public static final EnumC1545a f35040f;

        /* renamed from: g  reason: collision with root package name */
        public static final EnumC1545a f35041g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ EnumC1545a[] f35042h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132661077, "Lcom/baidu/android/pushservice/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132661077, "Lcom/baidu/android/pushservice/c/a$a;");
                    return;
                }
            }
            f35035a = new EnumC1545a("alarmMsgInfoId", 0);
            f35036b = new EnumC1545a("msgId", 1);
            f35037c = new EnumC1545a("sendtime", 2);
            f35038d = new EnumC1545a("showtime", 3);
            f35039e = new EnumC1545a("expiretime", 4);
            f35040f = new EnumC1545a("msgEnable", 5);
            EnumC1545a enumC1545a = new EnumC1545a("isAlarm", 6);
            f35041g = enumC1545a;
            f35042h = new EnumC1545a[]{f35035a, f35036b, f35037c, f35038d, f35039e, f35040f, enumC1545a};
        }

        public EnumC1545a(String str, int i2) {
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f35050a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f35051b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f35052c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f35053d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f35054e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f35055f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f35056g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f35057h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f35058i;
        public static final /* synthetic */ b[] j;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132661046, "Lcom/baidu/android/pushservice/c/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132661046, "Lcom/baidu/android/pushservice/c/a$b;");
                    return;
                }
            }
            f35050a = new b("appInfoId", 0);
            f35051b = new b("appid", 1);
            f35052c = new b("appType", 2);
            f35053d = new b("packageName", 3);
            f35054e = new b("appName", 4);
            f35055f = new b("cFrom", 5);
            f35056g = new b(PushManager.APP_VERSION_CODE, 6);
            f35057h = new b(PushManager.APP_VERSION_NAME, 7);
            b bVar = new b("intergratedPushVersion", 8);
            f35058i = bVar;
            j = new b[]{f35050a, f35051b, f35052c, f35053d, f35054e, f35055f, f35056g, f35057h, bVar};
        }

        public b(String str, int i2) {
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f35063a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f35064b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f35065c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f35066d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f35067e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f35068f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f35069g;

        /* renamed from: h  reason: collision with root package name */
        public static final c f35070h;

        /* renamed from: i  reason: collision with root package name */
        public static final c f35071i;
        public static final c j;
        public static final c k;
        public static final c l;
        public static final c m;
        public static final c n;
        public static final c o;
        public static final /* synthetic */ c[] p;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132661015, "Lcom/baidu/android/pushservice/c/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132661015, "Lcom/baidu/android/pushservice/c/a$c;");
                    return;
                }
            }
            f35063a = new c("actionId", 0);
            f35064b = new c("actionName", 1);
            f35065c = new c(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f35066d = new c("networkStatus", 3);
            f35067e = new c("msgType", 4);
            f35068f = new c("msgId", 5);
            f35069g = new c("msgLen", 6);
            f35070h = new c("errorMsg", 7);
            f35071i = new c("requestId", 8);
            j = new c("stableHeartInterval", 9);
            k = new c("errorCode", 10);
            l = new c("appid", 11);
            m = new c("channel", 12);
            n = new c("openByPackageName", 13);
            c cVar = new c("packageName", 14);
            o = cVar;
            p = new c[]{f35063a, f35064b, f35065c, f35066d, f35067e, f35068f, f35069g, f35070h, f35071i, j, k, l, m, n, cVar};
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
    }

    /* loaded from: classes6.dex */
    public static class d implements DatabaseErrorHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @TargetApi(16)
        private void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65538, this, str) == null) && !str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
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

    /* loaded from: classes6.dex */
    public static class e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f35088a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f35089b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f35090c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f35091d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f35092e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f35093f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f35094g;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132660953, "Lcom/baidu/android/pushservice/c/a$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132660953, "Lcom/baidu/android/pushservice/c/a$e;");
                    return;
                }
            }
            f35088a = "CREATE TABLE StatisticsInfo (" + i.f35114a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.f35115b.name() + " TEXT NOT NULL, " + i.f35116c.name() + " TEXT NOT NULL, " + i.f35117d.name() + " TEXT, " + i.f35118e.name() + " TEXT NOT NULL, " + i.f35119f.name() + " TEXT NOT NULL, " + i.f35120g.name() + " TEXT NOT NULL, " + i.f35121h.name() + " TEXT);";
            f35089b = "CREATE TABLE PushBehavior (" + c.f35063a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f35064b.name() + " TEXT NOT NULL, " + c.f35065c.name() + " LONG NOT NULL, " + c.f35066d.name() + " TEXT, " + c.f35067e.name() + " INTEGER, " + c.f35068f.name() + " TEXT, " + c.f35069g.name() + " INTEGER, " + c.f35070h.name() + " TEXT, " + c.f35071i.name() + " TEXT, " + c.j.name() + " INTEGER, " + c.k.name() + " INTEGER, " + c.l.name() + " TEXT, " + c.m.name() + " TEXT, " + c.o.name() + " TEXT, " + c.n.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE MsgArriveApp (");
            sb.append(g.f35104a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(g.f35105b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(g.f35106c.name());
            sb.append(" LONG NOT NULL);");
            f35090c = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE AlarmMsgInfo (");
            sb2.append(EnumC1545a.f35035a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(EnumC1545a.f35036b.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(EnumC1545a.f35037c.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1545a.f35038d.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1545a.f35039e.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1545a.f35040f.name());
            sb2.append(" INTEGER, ");
            sb2.append(EnumC1545a.f35041g.name());
            sb2.append(" INTEGER);");
            f35091d = sb2.toString();
            f35092e = "CREATE TABLE AppInfo (" + b.f35050a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.f35051b.name() + " TEXT, " + b.f35052c.name() + " INTEGER, " + b.f35053d.name() + " TEXT UNIQUE, " + b.f35054e.name() + " TEXT, " + b.f35055f.name() + " TEXT, " + b.f35056g.name() + " TEXT, " + b.f35057h.name() + " TEXT, " + b.f35058i.name() + " TEXT);";
            f35093f = "CREATE TABLE FileDownloadingInfo (" + f.f35095a.name() + " TEXT, " + f.f35096b.name() + " TEXT PRIMARY KEY, " + f.f35099e.name() + " TEXT NOT NULL, " + f.f35097c.name() + " TEXT, " + f.f35098d.name() + " TEXT, " + f.f35100f.name() + " TEXT NOT NULL, " + f.f35101g.name() + " INTEGER NOT NULL, " + f.f35102h.name() + " INTEGER NOT NULL, " + f.f35103i.name() + " INTEGER NOT NULL," + f.j.name() + " INTEGER NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE NoDisturb (");
            sb3.append(h.f35108a.name());
            sb3.append(" TEXT NOT NULL, ");
            sb3.append(h.f35109b.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f35110c.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f35111d.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f35112e.name());
            sb3.append(" INTEGER);");
            f35094g = sb3.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, String str, int i2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, String str, int i2, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i2, databaseErrorHandler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i2), databaseErrorHandler};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (DatabaseErrorHandler) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, sQLiteDatabase) == null) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(f35088a);
                    sQLiteDatabase.execSQL(f35089b);
                    sQLiteDatabase.execSQL(f35090c);
                    sQLiteDatabase.execSQL(f35091d);
                    sQLiteDatabase.execSQL(f35092e);
                    sQLiteDatabase.execSQL(f35093f);
                    sQLiteDatabase.execSQL(f35094g);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f35095a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f35096b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f35097c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f35098d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f35099e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f35100f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f35101g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f35102h;

        /* renamed from: i  reason: collision with root package name */
        public static final f f35103i;
        public static final f j;
        public static final /* synthetic */ f[] k;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132660922, "Lcom/baidu/android/pushservice/c/a$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132660922, "Lcom/baidu/android/pushservice/c/a$f;");
                    return;
                }
            }
            f35095a = new f("belongTo", 0);
            f35096b = new f("downloadUrl", 1);
            f35097c = new f("title", 2);
            f35098d = new f("description", 3);
            f35099e = new f("savePath", 4);
            f35100f = new f("fileName", 5);
            f35101g = new f("downloadBytes", 6);
            f35102h = new f("totalBytes", 7);
            f35103i = new f("downloadStatus", 8);
            f fVar = new f(PmsConstant.Statistic.Key.REV_TIMESTAMP, 9);
            j = fVar;
            k = new f[]{f35095a, f35096b, f35097c, f35098d, f35099e, f35100f, f35101g, f35102h, f35103i, fVar};
        }

        public f(String str, int i2) {
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f35104a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f35105b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f35106c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ g[] f35107d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132660891, "Lcom/baidu/android/pushservice/c/a$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132660891, "Lcom/baidu/android/pushservice/c/a$g;");
                    return;
                }
            }
            f35104a = new g("MsgInfoId", 0);
            f35105b = new g("msgId", 1);
            g gVar = new g(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f35106c = gVar;
            f35107d = new g[]{f35104a, f35105b, gVar};
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final h f35108a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f35109b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f35110c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f35111d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f35112e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f35113f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132660860, "Lcom/baidu/android/pushservice/c/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132660860, "Lcom/baidu/android/pushservice/c/a$h;");
                    return;
                }
            }
            f35108a = new h(PushClientConstants.TAG_PKG_NAME, 0);
            f35109b = new h("startHour", 1);
            f35110c = new h("startMinute", 2);
            f35111d = new h("endHour", 3);
            h hVar = new h("endMinute", 4);
            f35112e = hVar;
            f35113f = new h[]{f35108a, f35109b, f35110c, f35111d, hVar};
        }

        public h(String str, int i2) {
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final i f35114a;

        /* renamed from: b  reason: collision with root package name */
        public static final i f35115b;

        /* renamed from: c  reason: collision with root package name */
        public static final i f35116c;

        /* renamed from: d  reason: collision with root package name */
        public static final i f35117d;

        /* renamed from: e  reason: collision with root package name */
        public static final i f35118e;

        /* renamed from: f  reason: collision with root package name */
        public static final i f35119f;

        /* renamed from: g  reason: collision with root package name */
        public static final i f35120g;

        /* renamed from: h  reason: collision with root package name */
        public static final i f35121h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ i[] f35122i;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132660829, "Lcom/baidu/android/pushservice/c/a$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132660829, "Lcom/baidu/android/pushservice/c/a$i;");
                    return;
                }
            }
            f35114a = new i("info_id", 0);
            f35115b = new i("packageName", 1);
            f35116c = new i("open_type", 2);
            f35117d = new i("msgid", 3);
            f35118e = new i("app_open_time", 4);
            f35119f = new i("app_close_time", 5);
            f35120g = new i("use_duration", 6);
            i iVar = new i("extra", 7);
            f35121h = iVar;
            f35122i = new i[]{f35114a, f35115b, f35116c, f35117d, f35118e, f35119f, f35120g, iVar};
        }

        public i(String str, int i2) {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-677078776, "Lcom/baidu/android/pushservice/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-677078776, "Lcom/baidu/android/pushservice/c/a;");
                return;
            }
        }
        f35027b = new Object();
    }

    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            synchronized (f35027b) {
                long j = -1;
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return -1L;
                }
                Cursor cursor = null;
                try {
                    Cursor query = a2.query("NoDisturb", new String[]{h.f35108a.name()}, h.f35108a.name() + "= ?", new String[]{str}, null, null, null);
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(h.f35108a.name(), str);
                        contentValues.put(h.f35109b.name(), Integer.valueOf(i2));
                        contentValues.put(h.f35110c.name(), Integer.valueOf(i3));
                        contentValues.put(h.f35111d.name(), Integer.valueOf(i4));
                        contentValues.put(h.f35112e.name(), Integer.valueOf(i5));
                        if (query == null || !query.moveToNext()) {
                            j = a2.insert("NoDisturb", null, contentValues);
                        } else {
                            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                                update = a2.delete("NoDisturb", h.f35108a.name() + "= ?", new String[]{str});
                            } else {
                                update = a2.update("NoDisturb", contentValues, h.f35108a.name() + "= ?", new String[]{str});
                            }
                            j = update;
                        }
                        if (query != null) {
                            query.close();
                        }
                        if (query != null) {
                            query.close();
                        }
                    } catch (Exception unused) {
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.close();
                        return j;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
                a2.close();
                return j;
            }
        }
        return invokeCommon.longValue;
    }

    public static SQLiteDatabase a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            e b2 = b(context);
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
            synchronized (f35027b) {
                try {
                    if (f35026a != null) {
                        f35026a.close();
                        f35026a = null;
                    }
                } catch (Exception unused) {
                    f35026a = null;
                }
            }
        }
    }

    public static void a(String str, Context context) {
        File parentFile;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context) == null) || (parentFile = context.getDatabasePath("pushstat_8.0.0.db").getParentFile()) == null || !parentFile.isDirectory() || (listFiles = parentFile.listFiles(new FileFilter(str) { // from class: com.baidu.android.pushservice.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f35029a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35029a = str;
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                    if (file == null) {
                        return false;
                    }
                    String name = file.getName();
                    return name.contains("pushstat") && !name.contains(this.f35029a);
                }
                return invokeL.booleanValue;
            }
        })) == null) {
            return;
        }
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        ContentValues contentValues;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
            synchronized (f35027b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return true;
                }
                Cursor cursor2 = null;
                try {
                    contentValues = new ContentValues();
                    contentValues.clear();
                    contentValues.put(g.f35105b.name(), str);
                    contentValues.put(g.f35106c.name(), Long.valueOf(System.currentTimeMillis()));
                    String str2 = g.f35105b.name() + " =? ";
                    query = a2.query("MsgArriveApp", new String[]{g.f35105b.name()}, str2, new String[]{str}, null, null, null);
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
                    if (cursor.getInt(0) > f35028c) {
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

    public static e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (f35027b) {
                if (f35026a == null) {
                    String path = context.getDatabasePath("pushstat_8.0.0.db").getPath();
                    a("pushstat_8.0.0.db", context);
                    if (Build.VERSION.SDK_INT >= 11) {
                        f35026a = new e(context, path, 2, new d());
                    } else {
                        f35026a = new e(context, path, 2);
                    }
                }
            }
            return f35026a;
        }
        return (e) invokeL.objValue;
    }

    public static int[] b(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            synchronized (f35027b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("NoDisturb", null, h.f35108a.name() + "= ?", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                int i2 = cursor.getInt(cursor.getColumnIndex(h.f35109b.name()));
                                int i3 = cursor.getInt(cursor.getColumnIndex(h.f35110c.name()));
                                int i4 = cursor.getInt(cursor.getColumnIndex(h.f35111d.name()));
                                int i5 = cursor.getInt(cursor.getColumnIndex(h.f35112e.name()));
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
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                a2.close();
                return null;
            }
        }
        return (int[]) invokeLL.objValue;
    }
}
