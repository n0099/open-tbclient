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
    public static e f36807a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f36808b;

    /* renamed from: c  reason: collision with root package name */
    public static int f36809c = 200;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.android.pushservice.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class EnumC1582a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC1582a f36816a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1582a f36817b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1582a f36818c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC1582a f36819d;

        /* renamed from: e  reason: collision with root package name */
        public static final EnumC1582a f36820e;

        /* renamed from: f  reason: collision with root package name */
        public static final EnumC1582a f36821f;

        /* renamed from: g  reason: collision with root package name */
        public static final EnumC1582a f36822g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ EnumC1582a[] f36823h;
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
            f36816a = new EnumC1582a("alarmMsgInfoId", 0);
            f36817b = new EnumC1582a("msgId", 1);
            f36818c = new EnumC1582a("sendtime", 2);
            f36819d = new EnumC1582a("showtime", 3);
            f36820e = new EnumC1582a("expiretime", 4);
            f36821f = new EnumC1582a("msgEnable", 5);
            EnumC1582a enumC1582a = new EnumC1582a("isAlarm", 6);
            f36822g = enumC1582a;
            f36823h = new EnumC1582a[]{f36816a, f36817b, f36818c, f36819d, f36820e, f36821f, enumC1582a};
        }

        public EnumC1582a(String str, int i2) {
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
        public static final b f36831a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f36832b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f36833c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f36834d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f36835e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f36836f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f36837g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f36838h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f36839i;

        /* renamed from: j  reason: collision with root package name */
        public static final /* synthetic */ b[] f36840j;
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
            f36831a = new b("appInfoId", 0);
            f36832b = new b("appid", 1);
            f36833c = new b("appType", 2);
            f36834d = new b("packageName", 3);
            f36835e = new b("appName", 4);
            f36836f = new b("cFrom", 5);
            f36837g = new b(PushManager.APP_VERSION_CODE, 6);
            f36838h = new b(PushManager.APP_VERSION_NAME, 7);
            b bVar = new b("intergratedPushVersion", 8);
            f36839i = bVar;
            f36840j = new b[]{f36831a, f36832b, f36833c, f36834d, f36835e, f36836f, f36837g, f36838h, bVar};
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
        public static final c f36845a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f36846b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f36847c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f36848d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f36849e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f36850f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f36851g;

        /* renamed from: h  reason: collision with root package name */
        public static final c f36852h;

        /* renamed from: i  reason: collision with root package name */
        public static final c f36853i;

        /* renamed from: j  reason: collision with root package name */
        public static final c f36854j;
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
            f36845a = new c("actionId", 0);
            f36846b = new c("actionName", 1);
            f36847c = new c(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f36848d = new c("networkStatus", 3);
            f36849e = new c("msgType", 4);
            f36850f = new c("msgId", 5);
            f36851g = new c("msgLen", 6);
            f36852h = new c("errorMsg", 7);
            f36853i = new c("requestId", 8);
            f36854j = new c("stableHeartInterval", 9);
            k = new c("errorCode", 10);
            l = new c("appid", 11);
            m = new c("channel", 12);
            n = new c("openByPackageName", 13);
            c cVar = new c("packageName", 14);
            o = cVar;
            p = new c[]{f36845a, f36846b, f36847c, f36848d, f36849e, f36850f, f36851g, f36852h, f36853i, f36854j, k, l, m, n, cVar};
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
        public static final String f36871a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f36872b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f36873c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f36874d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f36875e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f36876f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f36877g;
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
            f36871a = "CREATE TABLE StatisticsInfo (" + i.f36898a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.f36899b.name() + " TEXT NOT NULL, " + i.f36900c.name() + " TEXT NOT NULL, " + i.f36901d.name() + " TEXT, " + i.f36902e.name() + " TEXT NOT NULL, " + i.f36903f.name() + " TEXT NOT NULL, " + i.f36904g.name() + " TEXT NOT NULL, " + i.f36905h.name() + " TEXT);";
            f36872b = "CREATE TABLE PushBehavior (" + c.f36845a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f36846b.name() + " TEXT NOT NULL, " + c.f36847c.name() + " LONG NOT NULL, " + c.f36848d.name() + " TEXT, " + c.f36849e.name() + " INTEGER, " + c.f36850f.name() + " TEXT, " + c.f36851g.name() + " INTEGER, " + c.f36852h.name() + " TEXT, " + c.f36853i.name() + " TEXT, " + c.f36854j.name() + " INTEGER, " + c.k.name() + " INTEGER, " + c.l.name() + " TEXT, " + c.m.name() + " TEXT, " + c.o.name() + " TEXT, " + c.n.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE MsgArriveApp (");
            sb.append(g.f36888a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(g.f36889b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(g.f36890c.name());
            sb.append(" LONG NOT NULL);");
            f36873c = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE AlarmMsgInfo (");
            sb2.append(EnumC1582a.f36816a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(EnumC1582a.f36817b.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(EnumC1582a.f36818c.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1582a.f36819d.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1582a.f36820e.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1582a.f36821f.name());
            sb2.append(" INTEGER, ");
            sb2.append(EnumC1582a.f36822g.name());
            sb2.append(" INTEGER);");
            f36874d = sb2.toString();
            f36875e = "CREATE TABLE AppInfo (" + b.f36831a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.f36832b.name() + " TEXT, " + b.f36833c.name() + " INTEGER, " + b.f36834d.name() + " TEXT UNIQUE, " + b.f36835e.name() + " TEXT, " + b.f36836f.name() + " TEXT, " + b.f36837g.name() + " TEXT, " + b.f36838h.name() + " TEXT, " + b.f36839i.name() + " TEXT);";
            f36876f = "CREATE TABLE FileDownloadingInfo (" + f.f36878a.name() + " TEXT, " + f.f36879b.name() + " TEXT PRIMARY KEY, " + f.f36882e.name() + " TEXT NOT NULL, " + f.f36880c.name() + " TEXT, " + f.f36881d.name() + " TEXT, " + f.f36883f.name() + " TEXT NOT NULL, " + f.f36884g.name() + " INTEGER NOT NULL, " + f.f36885h.name() + " INTEGER NOT NULL, " + f.f36886i.name() + " INTEGER NOT NULL," + f.f36887j.name() + " INTEGER NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE NoDisturb (");
            sb3.append(h.f36892a.name());
            sb3.append(" TEXT NOT NULL, ");
            sb3.append(h.f36893b.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f36894c.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f36895d.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f36896e.name());
            sb3.append(" INTEGER);");
            f36877g = sb3.toString();
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
                    sQLiteDatabase.execSQL(f36871a);
                    sQLiteDatabase.execSQL(f36872b);
                    sQLiteDatabase.execSQL(f36873c);
                    sQLiteDatabase.execSQL(f36874d);
                    sQLiteDatabase.execSQL(f36875e);
                    sQLiteDatabase.execSQL(f36876f);
                    sQLiteDatabase.execSQL(f36877g);
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
        public static final f f36878a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f36879b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f36880c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f36881d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f36882e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f36883f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f36884g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f36885h;

        /* renamed from: i  reason: collision with root package name */
        public static final f f36886i;

        /* renamed from: j  reason: collision with root package name */
        public static final f f36887j;
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
            f36878a = new f("belongTo", 0);
            f36879b = new f(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, 1);
            f36880c = new f("title", 2);
            f36881d = new f("description", 3);
            f36882e = new f("savePath", 4);
            f36883f = new f("fileName", 5);
            f36884g = new f("downloadBytes", 6);
            f36885h = new f("totalBytes", 7);
            f36886i = new f("downloadStatus", 8);
            f fVar = new f(PmsConstant.Statistic.Key.REV_TIMESTAMP, 9);
            f36887j = fVar;
            k = new f[]{f36878a, f36879b, f36880c, f36881d, f36882e, f36883f, f36884g, f36885h, f36886i, fVar};
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
        public static final g f36888a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f36889b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f36890c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ g[] f36891d;
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
            f36888a = new g("MsgInfoId", 0);
            f36889b = new g("msgId", 1);
            g gVar = new g(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f36890c = gVar;
            f36891d = new g[]{f36888a, f36889b, gVar};
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
        public static final h f36892a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f36893b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f36894c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f36895d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f36896e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f36897f;
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
            f36892a = new h(PushClientConstants.TAG_PKG_NAME, 0);
            f36893b = new h("startHour", 1);
            f36894c = new h("startMinute", 2);
            f36895d = new h("endHour", 3);
            h hVar = new h("endMinute", 4);
            f36896e = hVar;
            f36897f = new h[]{f36892a, f36893b, f36894c, f36895d, hVar};
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
        public static final i f36898a;

        /* renamed from: b  reason: collision with root package name */
        public static final i f36899b;

        /* renamed from: c  reason: collision with root package name */
        public static final i f36900c;

        /* renamed from: d  reason: collision with root package name */
        public static final i f36901d;

        /* renamed from: e  reason: collision with root package name */
        public static final i f36902e;

        /* renamed from: f  reason: collision with root package name */
        public static final i f36903f;

        /* renamed from: g  reason: collision with root package name */
        public static final i f36904g;

        /* renamed from: h  reason: collision with root package name */
        public static final i f36905h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ i[] f36906i;
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
            f36898a = new i("info_id", 0);
            f36899b = new i("packageName", 1);
            f36900c = new i("open_type", 2);
            f36901d = new i("msgid", 3);
            f36902e = new i("app_open_time", 4);
            f36903f = new i("app_close_time", 5);
            f36904g = new i("use_duration", 6);
            i iVar = new i("extra", 7);
            f36905h = iVar;
            f36906i = new i[]{f36898a, f36899b, f36900c, f36901d, f36902e, f36903f, f36904g, iVar};
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
        f36808b = new Object();
    }

    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            synchronized (f36808b) {
                long j2 = -1;
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return -1L;
                }
                Cursor cursor = null;
                try {
                    Cursor query = a2.query("NoDisturb", new String[]{h.f36892a.name()}, h.f36892a.name() + "= ?", new String[]{str}, null, null, null);
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(h.f36892a.name(), str);
                        contentValues.put(h.f36893b.name(), Integer.valueOf(i2));
                        contentValues.put(h.f36894c.name(), Integer.valueOf(i3));
                        contentValues.put(h.f36895d.name(), Integer.valueOf(i4));
                        contentValues.put(h.f36896e.name(), Integer.valueOf(i5));
                        if (query == null || !query.moveToNext()) {
                            j2 = a2.insert("NoDisturb", null, contentValues);
                        } else {
                            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                                update = a2.delete("NoDisturb", h.f36892a.name() + "= ?", new String[]{str});
                            } else {
                                update = a2.update("NoDisturb", contentValues, h.f36892a.name() + "= ?", new String[]{str});
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
            synchronized (f36808b) {
                try {
                    if (f36807a != null) {
                        f36807a.close();
                        f36807a = null;
                    }
                } catch (Exception unused) {
                    f36807a = null;
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
            public final /* synthetic */ String f36810a;

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
                this.f36810a = str;
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
                    return name.contains("pushstat") && !name.contains(this.f36810a);
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
            synchronized (f36808b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return true;
                }
                Cursor cursor2 = null;
                try {
                    contentValues = new ContentValues();
                    contentValues.clear();
                    contentValues.put(g.f36889b.name(), str);
                    contentValues.put(g.f36890c.name(), Long.valueOf(System.currentTimeMillis()));
                    String str2 = g.f36889b.name() + " =? ";
                    query = a2.query("MsgArriveApp", new String[]{g.f36889b.name()}, str2, new String[]{str}, null, null, null);
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
                    if (cursor.getInt(0) > f36809c) {
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
            synchronized (f36808b) {
                if (f36807a == null) {
                    String path = context.getDatabasePath("pushstat_8.0.0.db").getPath();
                    a("pushstat_8.0.0.db", context);
                    if (Build.VERSION.SDK_INT >= 11) {
                        f36807a = new e(context, path, 2, new d());
                    } else {
                        f36807a = new e(context, path, 2);
                    }
                }
            }
            return f36807a;
        }
        return (e) invokeL.objValue;
    }

    public static int[] b(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            synchronized (f36808b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("NoDisturb", null, h.f36892a.name() + "= ?", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                int i2 = cursor.getInt(cursor.getColumnIndex(h.f36893b.name()));
                                int i3 = cursor.getInt(cursor.getColumnIndex(h.f36894c.name()));
                                int i4 = cursor.getInt(cursor.getColumnIndex(h.f36895d.name()));
                                int i5 = cursor.getInt(cursor.getColumnIndex(h.f36896e.name()));
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
