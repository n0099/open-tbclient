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
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static e f36978a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f36979b;

    /* renamed from: c  reason: collision with root package name */
    public static int f36980c = 200;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.android.pushservice.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class EnumC1588a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC1588a f36987a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1588a f36988b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1588a f36989c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC1588a f36990d;

        /* renamed from: e  reason: collision with root package name */
        public static final EnumC1588a f36991e;

        /* renamed from: f  reason: collision with root package name */
        public static final EnumC1588a f36992f;

        /* renamed from: g  reason: collision with root package name */
        public static final EnumC1588a f36993g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ EnumC1588a[] f36994h;
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
            f36987a = new EnumC1588a("alarmMsgInfoId", 0);
            f36988b = new EnumC1588a("msgId", 1);
            f36989c = new EnumC1588a("sendtime", 2);
            f36990d = new EnumC1588a("showtime", 3);
            f36991e = new EnumC1588a("expiretime", 4);
            f36992f = new EnumC1588a("msgEnable", 5);
            EnumC1588a enumC1588a = new EnumC1588a("isAlarm", 6);
            f36993g = enumC1588a;
            f36994h = new EnumC1588a[]{f36987a, f36988b, f36989c, f36990d, f36991e, f36992f, enumC1588a};
        }

        public EnumC1588a(String str, int i2) {
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
    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f37002a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f37003b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f37004c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f37005d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f37006e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f37007f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f37008g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f37009h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f37010i;

        /* renamed from: j  reason: collision with root package name */
        public static final /* synthetic */ b[] f37011j;
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
            f37002a = new b("appInfoId", 0);
            f37003b = new b("appid", 1);
            f37004c = new b("appType", 2);
            f37005d = new b("packageName", 3);
            f37006e = new b("appName", 4);
            f37007f = new b("cFrom", 5);
            f37008g = new b(PushManager.APP_VERSION_CODE, 6);
            f37009h = new b(PushManager.APP_VERSION_NAME, 7);
            b bVar = new b("intergratedPushVersion", 8);
            f37010i = bVar;
            f37011j = new b[]{f37002a, f37003b, f37004c, f37005d, f37006e, f37007f, f37008g, f37009h, bVar};
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
    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f37016a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f37017b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f37018c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f37019d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f37020e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f37021f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f37022g;

        /* renamed from: h  reason: collision with root package name */
        public static final c f37023h;

        /* renamed from: i  reason: collision with root package name */
        public static final c f37024i;

        /* renamed from: j  reason: collision with root package name */
        public static final c f37025j;
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
            f37016a = new c("actionId", 0);
            f37017b = new c("actionName", 1);
            f37018c = new c(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f37019d = new c("networkStatus", 3);
            f37020e = new c("msgType", 4);
            f37021f = new c("msgId", 5);
            f37022g = new c("msgLen", 6);
            f37023h = new c("errorMsg", 7);
            f37024i = new c("requestId", 8);
            f37025j = new c("stableHeartInterval", 9);
            k = new c("errorCode", 10);
            l = new c("appid", 11);
            m = new c("channel", 12);
            n = new c("openByPackageName", 13);
            c cVar = new c("packageName", 14);
            o = cVar;
            p = new c[]{f37016a, f37017b, f37018c, f37019d, f37020e, f37021f, f37022g, f37023h, f37024i, f37025j, k, l, m, n, cVar};
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f37042a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f37043b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f37044c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f37045d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f37046e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f37047f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f37048g;
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
            f37042a = "CREATE TABLE StatisticsInfo (" + i.f37069a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.f37070b.name() + " TEXT NOT NULL, " + i.f37071c.name() + " TEXT NOT NULL, " + i.f37072d.name() + " TEXT, " + i.f37073e.name() + " TEXT NOT NULL, " + i.f37074f.name() + " TEXT NOT NULL, " + i.f37075g.name() + " TEXT NOT NULL, " + i.f37076h.name() + " TEXT);";
            f37043b = "CREATE TABLE PushBehavior (" + c.f37016a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f37017b.name() + " TEXT NOT NULL, " + c.f37018c.name() + " LONG NOT NULL, " + c.f37019d.name() + " TEXT, " + c.f37020e.name() + " INTEGER, " + c.f37021f.name() + " TEXT, " + c.f37022g.name() + " INTEGER, " + c.f37023h.name() + " TEXT, " + c.f37024i.name() + " TEXT, " + c.f37025j.name() + " INTEGER, " + c.k.name() + " INTEGER, " + c.l.name() + " TEXT, " + c.m.name() + " TEXT, " + c.o.name() + " TEXT, " + c.n.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE MsgArriveApp (");
            sb.append(g.f37059a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(g.f37060b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(g.f37061c.name());
            sb.append(" LONG NOT NULL);");
            f37044c = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE AlarmMsgInfo (");
            sb2.append(EnumC1588a.f36987a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(EnumC1588a.f36988b.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(EnumC1588a.f36989c.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1588a.f36990d.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1588a.f36991e.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1588a.f36992f.name());
            sb2.append(" INTEGER, ");
            sb2.append(EnumC1588a.f36993g.name());
            sb2.append(" INTEGER);");
            f37045d = sb2.toString();
            f37046e = "CREATE TABLE AppInfo (" + b.f37002a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.f37003b.name() + " TEXT, " + b.f37004c.name() + " INTEGER, " + b.f37005d.name() + " TEXT UNIQUE, " + b.f37006e.name() + " TEXT, " + b.f37007f.name() + " TEXT, " + b.f37008g.name() + " TEXT, " + b.f37009h.name() + " TEXT, " + b.f37010i.name() + " TEXT);";
            f37047f = "CREATE TABLE FileDownloadingInfo (" + f.f37049a.name() + " TEXT, " + f.f37050b.name() + " TEXT PRIMARY KEY, " + f.f37053e.name() + " TEXT NOT NULL, " + f.f37051c.name() + " TEXT, " + f.f37052d.name() + " TEXT, " + f.f37054f.name() + " TEXT NOT NULL, " + f.f37055g.name() + " INTEGER NOT NULL, " + f.f37056h.name() + " INTEGER NOT NULL, " + f.f37057i.name() + " INTEGER NOT NULL," + f.f37058j.name() + " INTEGER NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE NoDisturb (");
            sb3.append(h.f37063a.name());
            sb3.append(" TEXT NOT NULL, ");
            sb3.append(h.f37064b.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f37065c.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f37066d.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f37067e.name());
            sb3.append(" INTEGER);");
            f37048g = sb3.toString();
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
                    sQLiteDatabase.execSQL(f37042a);
                    sQLiteDatabase.execSQL(f37043b);
                    sQLiteDatabase.execSQL(f37044c);
                    sQLiteDatabase.execSQL(f37045d);
                    sQLiteDatabase.execSQL(f37046e);
                    sQLiteDatabase.execSQL(f37047f);
                    sQLiteDatabase.execSQL(f37048g);
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
    /* loaded from: classes4.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f37049a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f37050b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f37051c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f37052d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f37053e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f37054f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f37055g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f37056h;

        /* renamed from: i  reason: collision with root package name */
        public static final f f37057i;

        /* renamed from: j  reason: collision with root package name */
        public static final f f37058j;
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
            f37049a = new f("belongTo", 0);
            f37050b = new f(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, 1);
            f37051c = new f("title", 2);
            f37052d = new f("description", 3);
            f37053e = new f("savePath", 4);
            f37054f = new f("fileName", 5);
            f37055g = new f("downloadBytes", 6);
            f37056h = new f("totalBytes", 7);
            f37057i = new f("downloadStatus", 8);
            f fVar = new f(PmsConstant.Statistic.Key.REV_TIMESTAMP, 9);
            f37058j = fVar;
            k = new f[]{f37049a, f37050b, f37051c, f37052d, f37053e, f37054f, f37055g, f37056h, f37057i, fVar};
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
    /* loaded from: classes4.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f37059a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f37060b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f37061c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ g[] f37062d;
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
            f37059a = new g("MsgInfoId", 0);
            f37060b = new g("msgId", 1);
            g gVar = new g(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f37061c = gVar;
            f37062d = new g[]{f37059a, f37060b, gVar};
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
    /* loaded from: classes4.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final h f37063a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f37064b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f37065c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f37066d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f37067e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f37068f;
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
            f37063a = new h(PushClientConstants.TAG_PKG_NAME, 0);
            f37064b = new h("startHour", 1);
            f37065c = new h("startMinute", 2);
            f37066d = new h("endHour", 3);
            h hVar = new h("endMinute", 4);
            f37067e = hVar;
            f37068f = new h[]{f37063a, f37064b, f37065c, f37066d, hVar};
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
    /* loaded from: classes4.dex */
    public static final class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final i f37069a;

        /* renamed from: b  reason: collision with root package name */
        public static final i f37070b;

        /* renamed from: c  reason: collision with root package name */
        public static final i f37071c;

        /* renamed from: d  reason: collision with root package name */
        public static final i f37072d;

        /* renamed from: e  reason: collision with root package name */
        public static final i f37073e;

        /* renamed from: f  reason: collision with root package name */
        public static final i f37074f;

        /* renamed from: g  reason: collision with root package name */
        public static final i f37075g;

        /* renamed from: h  reason: collision with root package name */
        public static final i f37076h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ i[] f37077i;
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
            f37069a = new i("info_id", 0);
            f37070b = new i("packageName", 1);
            f37071c = new i("open_type", 2);
            f37072d = new i("msgid", 3);
            f37073e = new i("app_open_time", 4);
            f37074f = new i("app_close_time", 5);
            f37075g = new i("use_duration", 6);
            i iVar = new i("extra", 7);
            f37076h = iVar;
            f37077i = new i[]{f37069a, f37070b, f37071c, f37072d, f37073e, f37074f, f37075g, iVar};
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
        f36979b = new Object();
    }

    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            synchronized (f36979b) {
                long j2 = -1;
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return -1L;
                }
                Cursor cursor = null;
                try {
                    Cursor query = a2.query("NoDisturb", new String[]{h.f37063a.name()}, h.f37063a.name() + "= ?", new String[]{str}, null, null, null);
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(h.f37063a.name(), str);
                        contentValues.put(h.f37064b.name(), Integer.valueOf(i2));
                        contentValues.put(h.f37065c.name(), Integer.valueOf(i3));
                        contentValues.put(h.f37066d.name(), Integer.valueOf(i4));
                        contentValues.put(h.f37067e.name(), Integer.valueOf(i5));
                        if (query == null || !query.moveToNext()) {
                            j2 = a2.insert("NoDisturb", null, contentValues);
                        } else {
                            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                                update = a2.delete("NoDisturb", h.f37063a.name() + "= ?", new String[]{str});
                            } else {
                                update = a2.update("NoDisturb", contentValues, h.f37063a.name() + "= ?", new String[]{str});
                            }
                            j2 = update;
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
                        return j2;
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
                return j2;
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
            synchronized (f36979b) {
                try {
                    if (f36978a != null) {
                        f36978a.close();
                        f36978a = null;
                    }
                } catch (Exception unused) {
                    f36978a = null;
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
            public final /* synthetic */ String f36981a;

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
                this.f36981a = str;
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
                    return name.contains("pushstat") && !name.contains(this.f36981a);
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
            synchronized (f36979b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return true;
                }
                Cursor cursor2 = null;
                try {
                    contentValues = new ContentValues();
                    contentValues.clear();
                    contentValues.put(g.f37060b.name(), str);
                    contentValues.put(g.f37061c.name(), Long.valueOf(System.currentTimeMillis()));
                    String str2 = g.f37060b.name() + " =? ";
                    query = a2.query("MsgArriveApp", new String[]{g.f37060b.name()}, str2, new String[]{str}, null, null, null);
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
                    if (cursor.getInt(0) > f36980c) {
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
            synchronized (f36979b) {
                if (f36978a == null) {
                    String path = context.getDatabasePath("pushstat_8.0.0.db").getPath();
                    a("pushstat_8.0.0.db", context);
                    if (Build.VERSION.SDK_INT >= 11) {
                        f36978a = new e(context, path, 2, new d());
                    } else {
                        f36978a = new e(context, path, 2);
                    }
                }
            }
            return f36978a;
        }
        return (e) invokeL.objValue;
    }

    public static int[] b(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            synchronized (f36979b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("NoDisturb", null, h.f37063a.name() + "= ?", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                int i2 = cursor.getInt(cursor.getColumnIndex(h.f37064b.name()));
                                int i3 = cursor.getInt(cursor.getColumnIndex(h.f37065c.name()));
                                int i4 = cursor.getInt(cursor.getColumnIndex(h.f37066d.name()));
                                int i5 = cursor.getInt(cursor.getColumnIndex(h.f37067e.name()));
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
