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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static e f2794a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f2795b;

    /* renamed from: c  reason: collision with root package name */
    public static int f2796c = 200;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.android.pushservice.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class EnumC0032a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC0032a f2803a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC0032a f2804b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC0032a f2805c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC0032a f2806d;

        /* renamed from: e  reason: collision with root package name */
        public static final EnumC0032a f2807e;

        /* renamed from: f  reason: collision with root package name */
        public static final EnumC0032a f2808f;

        /* renamed from: g  reason: collision with root package name */
        public static final EnumC0032a f2809g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ EnumC0032a[] f2810h;
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
            f2803a = new EnumC0032a("alarmMsgInfoId", 0);
            f2804b = new EnumC0032a("msgId", 1);
            f2805c = new EnumC0032a("sendtime", 2);
            f2806d = new EnumC0032a("showtime", 3);
            f2807e = new EnumC0032a("expiretime", 4);
            f2808f = new EnumC0032a("msgEnable", 5);
            EnumC0032a enumC0032a = new EnumC0032a("isAlarm", 6);
            f2809g = enumC0032a;
            f2810h = new EnumC0032a[]{f2803a, f2804b, f2805c, f2806d, f2807e, f2808f, enumC0032a};
        }

        public EnumC0032a(String str, int i2) {
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
    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f2818a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f2819b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f2820c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f2821d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f2822e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f2823f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f2824g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f2825h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f2826i;
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
            f2818a = new b("appInfoId", 0);
            f2819b = new b("appid", 1);
            f2820c = new b("appType", 2);
            f2821d = new b("packageName", 3);
            f2822e = new b("appName", 4);
            f2823f = new b("cFrom", 5);
            f2824g = new b(PushManager.APP_VERSION_CODE, 6);
            f2825h = new b(PushManager.APP_VERSION_NAME, 7);
            b bVar = new b("intergratedPushVersion", 8);
            f2826i = bVar;
            j = new b[]{f2818a, f2819b, f2820c, f2821d, f2822e, f2823f, f2824g, f2825h, bVar};
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
    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f2831a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f2832b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f2833c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f2834d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f2835e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f2836f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f2837g;

        /* renamed from: h  reason: collision with root package name */
        public static final c f2838h;

        /* renamed from: i  reason: collision with root package name */
        public static final c f2839i;
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
            f2831a = new c("actionId", 0);
            f2832b = new c("actionName", 1);
            f2833c = new c(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f2834d = new c("networkStatus", 3);
            f2835e = new c("msgType", 4);
            f2836f = new c("msgId", 5);
            f2837g = new c("msgLen", 6);
            f2838h = new c("errorMsg", 7);
            f2839i = new c("requestId", 8);
            j = new c("stableHeartInterval", 9);
            k = new c("errorCode", 10);
            l = new c("appid", 11);
            m = new c("channel", 12);
            n = new c("openByPackageName", 13);
            c cVar = new c("packageName", 14);
            o = cVar;
            p = new c[]{f2831a, f2832b, f2833c, f2834d, f2835e, f2836f, f2837g, f2838h, f2839i, j, k, l, m, n, cVar};
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static class e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f2856a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f2857b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f2858c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2859d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2860e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f2861f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f2862g;
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
            f2856a = "CREATE TABLE StatisticsInfo (" + i.f2882a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.f2883b.name() + " TEXT NOT NULL, " + i.f2884c.name() + " TEXT NOT NULL, " + i.f2885d.name() + " TEXT, " + i.f2886e.name() + " TEXT NOT NULL, " + i.f2887f.name() + " TEXT NOT NULL, " + i.f2888g.name() + " TEXT NOT NULL, " + i.f2889h.name() + " TEXT);";
            f2857b = "CREATE TABLE PushBehavior (" + c.f2831a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f2832b.name() + " TEXT NOT NULL, " + c.f2833c.name() + " LONG NOT NULL, " + c.f2834d.name() + " TEXT, " + c.f2835e.name() + " INTEGER, " + c.f2836f.name() + " TEXT, " + c.f2837g.name() + " INTEGER, " + c.f2838h.name() + " TEXT, " + c.f2839i.name() + " TEXT, " + c.j.name() + " INTEGER, " + c.k.name() + " INTEGER, " + c.l.name() + " TEXT, " + c.m.name() + " TEXT, " + c.o.name() + " TEXT, " + c.n.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE MsgArriveApp (");
            sb.append(g.f2872a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(g.f2873b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(g.f2874c.name());
            sb.append(" LONG NOT NULL);");
            f2858c = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE AlarmMsgInfo (");
            sb2.append(EnumC0032a.f2803a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(EnumC0032a.f2804b.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(EnumC0032a.f2805c.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0032a.f2806d.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0032a.f2807e.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0032a.f2808f.name());
            sb2.append(" INTEGER, ");
            sb2.append(EnumC0032a.f2809g.name());
            sb2.append(" INTEGER);");
            f2859d = sb2.toString();
            f2860e = "CREATE TABLE AppInfo (" + b.f2818a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.f2819b.name() + " TEXT, " + b.f2820c.name() + " INTEGER, " + b.f2821d.name() + " TEXT UNIQUE, " + b.f2822e.name() + " TEXT, " + b.f2823f.name() + " TEXT, " + b.f2824g.name() + " TEXT, " + b.f2825h.name() + " TEXT, " + b.f2826i.name() + " TEXT);";
            f2861f = "CREATE TABLE FileDownloadingInfo (" + f.f2863a.name() + " TEXT, " + f.f2864b.name() + " TEXT PRIMARY KEY, " + f.f2867e.name() + " TEXT NOT NULL, " + f.f2865c.name() + " TEXT, " + f.f2866d.name() + " TEXT, " + f.f2868f.name() + " TEXT NOT NULL, " + f.f2869g.name() + " INTEGER NOT NULL, " + f.f2870h.name() + " INTEGER NOT NULL, " + f.f2871i.name() + " INTEGER NOT NULL," + f.j.name() + " INTEGER NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE NoDisturb (");
            sb3.append(h.f2876a.name());
            sb3.append(" TEXT NOT NULL, ");
            sb3.append(h.f2877b.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f2878c.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f2879d.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f2880e.name());
            sb3.append(" INTEGER);");
            f2862g = sb3.toString();
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
                    sQLiteDatabase.execSQL(f2856a);
                    sQLiteDatabase.execSQL(f2857b);
                    sQLiteDatabase.execSQL(f2858c);
                    sQLiteDatabase.execSQL(f2859d);
                    sQLiteDatabase.execSQL(f2860e);
                    sQLiteDatabase.execSQL(f2861f);
                    sQLiteDatabase.execSQL(f2862g);
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
    /* loaded from: classes.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f2863a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f2864b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f2865c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f2866d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f2867e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f2868f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f2869g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f2870h;

        /* renamed from: i  reason: collision with root package name */
        public static final f f2871i;
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
            f2863a = new f("belongTo", 0);
            f2864b = new f(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, 1);
            f2865c = new f("title", 2);
            f2866d = new f("description", 3);
            f2867e = new f("savePath", 4);
            f2868f = new f("fileName", 5);
            f2869g = new f("downloadBytes", 6);
            f2870h = new f("totalBytes", 7);
            f2871i = new f("downloadStatus", 8);
            f fVar = new f(PmsConstant.Statistic.Key.REV_TIMESTAMP, 9);
            j = fVar;
            k = new f[]{f2863a, f2864b, f2865c, f2866d, f2867e, f2868f, f2869g, f2870h, f2871i, fVar};
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
    /* loaded from: classes.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f2872a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f2873b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f2874c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ g[] f2875d;
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
            f2872a = new g("MsgInfoId", 0);
            f2873b = new g("msgId", 1);
            g gVar = new g(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f2874c = gVar;
            f2875d = new g[]{f2872a, f2873b, gVar};
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
    /* loaded from: classes.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final h f2876a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f2877b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f2878c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f2879d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f2880e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f2881f;
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
            f2876a = new h(PushClientConstants.TAG_PKG_NAME, 0);
            f2877b = new h("startHour", 1);
            f2878c = new h("startMinute", 2);
            f2879d = new h("endHour", 3);
            h hVar = new h("endMinute", 4);
            f2880e = hVar;
            f2881f = new h[]{f2876a, f2877b, f2878c, f2879d, hVar};
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
    /* loaded from: classes.dex */
    public static final class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final i f2882a;

        /* renamed from: b  reason: collision with root package name */
        public static final i f2883b;

        /* renamed from: c  reason: collision with root package name */
        public static final i f2884c;

        /* renamed from: d  reason: collision with root package name */
        public static final i f2885d;

        /* renamed from: e  reason: collision with root package name */
        public static final i f2886e;

        /* renamed from: f  reason: collision with root package name */
        public static final i f2887f;

        /* renamed from: g  reason: collision with root package name */
        public static final i f2888g;

        /* renamed from: h  reason: collision with root package name */
        public static final i f2889h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ i[] f2890i;
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
            f2882a = new i("info_id", 0);
            f2883b = new i("packageName", 1);
            f2884c = new i("open_type", 2);
            f2885d = new i("msgid", 3);
            f2886e = new i("app_open_time", 4);
            f2887f = new i("app_close_time", 5);
            f2888g = new i("use_duration", 6);
            i iVar = new i("extra", 7);
            f2889h = iVar;
            f2890i = new i[]{f2882a, f2883b, f2884c, f2885d, f2886e, f2887f, f2888g, iVar};
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
        f2795b = new Object();
    }

    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            synchronized (f2795b) {
                long j = -1;
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return -1L;
                }
                Cursor cursor = null;
                try {
                    Cursor query = a2.query("NoDisturb", new String[]{h.f2876a.name()}, h.f2876a.name() + "= ?", new String[]{str}, null, null, null);
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(h.f2876a.name(), str);
                        contentValues.put(h.f2877b.name(), Integer.valueOf(i2));
                        contentValues.put(h.f2878c.name(), Integer.valueOf(i3));
                        contentValues.put(h.f2879d.name(), Integer.valueOf(i4));
                        contentValues.put(h.f2880e.name(), Integer.valueOf(i5));
                        if (query == null || !query.moveToNext()) {
                            j = a2.insert("NoDisturb", null, contentValues);
                        } else {
                            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                                update = a2.delete("NoDisturb", h.f2876a.name() + "= ?", new String[]{str});
                            } else {
                                update = a2.update("NoDisturb", contentValues, h.f2876a.name() + "= ?", new String[]{str});
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
            synchronized (f2795b) {
                try {
                    if (f2794a != null) {
                        f2794a.close();
                        f2794a = null;
                    }
                } catch (Exception unused) {
                    f2794a = null;
                }
            }
        }
    }

    public static void a(String str, Context context) {
        File parentFile;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65540, null, str, context) == null) || (parentFile = context.getDatabasePath("pushstat_8.0.0.db").getParentFile()) == null || !parentFile.isDirectory() || (listFiles = parentFile.listFiles(new FileFilter(str) { // from class: com.baidu.android.pushservice.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f2797a;

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
                this.f2797a = str;
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
                    return name.contains("pushstat") && !name.contains(this.f2797a);
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
            synchronized (f2795b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return true;
                }
                Cursor cursor2 = null;
                try {
                    contentValues = new ContentValues();
                    contentValues.clear();
                    contentValues.put(g.f2873b.name(), str);
                    contentValues.put(g.f2874c.name(), Long.valueOf(System.currentTimeMillis()));
                    String str2 = g.f2873b.name() + " =? ";
                    query = a2.query("MsgArriveApp", new String[]{g.f2873b.name()}, str2, new String[]{str}, null, null, null);
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
                    if (cursor.getInt(0) > f2796c) {
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
            synchronized (f2795b) {
                if (f2794a == null) {
                    String path = context.getDatabasePath("pushstat_8.0.0.db").getPath();
                    a("pushstat_8.0.0.db", context);
                    if (Build.VERSION.SDK_INT >= 11) {
                        f2794a = new e(context, path, 2, new d());
                    } else {
                        f2794a = new e(context, path, 2);
                    }
                }
            }
            return f2794a;
        }
        return (e) invokeL.objValue;
    }

    public static int[] b(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            synchronized (f2795b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("NoDisturb", null, h.f2876a.name() + "= ?", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                int i2 = cursor.getInt(cursor.getColumnIndex(h.f2877b.name()));
                                int i3 = cursor.getInt(cursor.getColumnIndex(h.f2878c.name()));
                                int i4 = cursor.getInt(cursor.getColumnIndex(h.f2879d.name()));
                                int i5 = cursor.getInt(cursor.getColumnIndex(h.f2880e.name()));
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
