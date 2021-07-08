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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static e f2797a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f2798b;

    /* renamed from: c  reason: collision with root package name */
    public static int f2799c = 200;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.android.pushservice.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class EnumC0032a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC0032a f2806a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC0032a f2807b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC0032a f2808c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC0032a f2809d;

        /* renamed from: e  reason: collision with root package name */
        public static final EnumC0032a f2810e;

        /* renamed from: f  reason: collision with root package name */
        public static final EnumC0032a f2811f;

        /* renamed from: g  reason: collision with root package name */
        public static final EnumC0032a f2812g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ EnumC0032a[] f2813h;
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
            f2806a = new EnumC0032a("alarmMsgInfoId", 0);
            f2807b = new EnumC0032a("msgId", 1);
            f2808c = new EnumC0032a("sendtime", 2);
            f2809d = new EnumC0032a("showtime", 3);
            f2810e = new EnumC0032a("expiretime", 4);
            f2811f = new EnumC0032a("msgEnable", 5);
            EnumC0032a enumC0032a = new EnumC0032a("isAlarm", 6);
            f2812g = enumC0032a;
            f2813h = new EnumC0032a[]{f2806a, f2807b, f2808c, f2809d, f2810e, f2811f, enumC0032a};
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
        public static final b f2821a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f2822b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f2823c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f2824d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f2825e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f2826f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f2827g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f2828h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f2829i;
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
            f2821a = new b("appInfoId", 0);
            f2822b = new b("appid", 1);
            f2823c = new b("appType", 2);
            f2824d = new b("packageName", 3);
            f2825e = new b("appName", 4);
            f2826f = new b("cFrom", 5);
            f2827g = new b(PushManager.APP_VERSION_CODE, 6);
            f2828h = new b(PushManager.APP_VERSION_NAME, 7);
            b bVar = new b("intergratedPushVersion", 8);
            f2829i = bVar;
            j = new b[]{f2821a, f2822b, f2823c, f2824d, f2825e, f2826f, f2827g, f2828h, bVar};
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
        public static final c f2834a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f2835b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f2836c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f2837d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f2838e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f2839f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f2840g;

        /* renamed from: h  reason: collision with root package name */
        public static final c f2841h;

        /* renamed from: i  reason: collision with root package name */
        public static final c f2842i;
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
            f2834a = new c("actionId", 0);
            f2835b = new c("actionName", 1);
            f2836c = new c(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f2837d = new c("networkStatus", 3);
            f2838e = new c("msgType", 4);
            f2839f = new c("msgId", 5);
            f2840g = new c("msgLen", 6);
            f2841h = new c("errorMsg", 7);
            f2842i = new c("requestId", 8);
            j = new c("stableHeartInterval", 9);
            k = new c("errorCode", 10);
            l = new c("appid", 11);
            m = new c("channel", 12);
            n = new c("openByPackageName", 13);
            c cVar = new c("packageName", 14);
            o = cVar;
            p = new c[]{f2834a, f2835b, f2836c, f2837d, f2838e, f2839f, f2840g, f2841h, f2842i, j, k, l, m, n, cVar};
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
        public static final String f2859a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f2860b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f2861c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2862d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2863e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f2864f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f2865g;
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
            f2859a = "CREATE TABLE StatisticsInfo (" + i.f2885a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.f2886b.name() + " TEXT NOT NULL, " + i.f2887c.name() + " TEXT NOT NULL, " + i.f2888d.name() + " TEXT, " + i.f2889e.name() + " TEXT NOT NULL, " + i.f2890f.name() + " TEXT NOT NULL, " + i.f2891g.name() + " TEXT NOT NULL, " + i.f2892h.name() + " TEXT);";
            f2860b = "CREATE TABLE PushBehavior (" + c.f2834a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f2835b.name() + " TEXT NOT NULL, " + c.f2836c.name() + " LONG NOT NULL, " + c.f2837d.name() + " TEXT, " + c.f2838e.name() + " INTEGER, " + c.f2839f.name() + " TEXT, " + c.f2840g.name() + " INTEGER, " + c.f2841h.name() + " TEXT, " + c.f2842i.name() + " TEXT, " + c.j.name() + " INTEGER, " + c.k.name() + " INTEGER, " + c.l.name() + " TEXT, " + c.m.name() + " TEXT, " + c.o.name() + " TEXT, " + c.n.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE MsgArriveApp (");
            sb.append(g.f2875a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(g.f2876b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(g.f2877c.name());
            sb.append(" LONG NOT NULL);");
            f2861c = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE AlarmMsgInfo (");
            sb2.append(EnumC0032a.f2806a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(EnumC0032a.f2807b.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(EnumC0032a.f2808c.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0032a.f2809d.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0032a.f2810e.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0032a.f2811f.name());
            sb2.append(" INTEGER, ");
            sb2.append(EnumC0032a.f2812g.name());
            sb2.append(" INTEGER);");
            f2862d = sb2.toString();
            f2863e = "CREATE TABLE AppInfo (" + b.f2821a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.f2822b.name() + " TEXT, " + b.f2823c.name() + " INTEGER, " + b.f2824d.name() + " TEXT UNIQUE, " + b.f2825e.name() + " TEXT, " + b.f2826f.name() + " TEXT, " + b.f2827g.name() + " TEXT, " + b.f2828h.name() + " TEXT, " + b.f2829i.name() + " TEXT);";
            f2864f = "CREATE TABLE FileDownloadingInfo (" + f.f2866a.name() + " TEXT, " + f.f2867b.name() + " TEXT PRIMARY KEY, " + f.f2870e.name() + " TEXT NOT NULL, " + f.f2868c.name() + " TEXT, " + f.f2869d.name() + " TEXT, " + f.f2871f.name() + " TEXT NOT NULL, " + f.f2872g.name() + " INTEGER NOT NULL, " + f.f2873h.name() + " INTEGER NOT NULL, " + f.f2874i.name() + " INTEGER NOT NULL," + f.j.name() + " INTEGER NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE NoDisturb (");
            sb3.append(h.f2879a.name());
            sb3.append(" TEXT NOT NULL, ");
            sb3.append(h.f2880b.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f2881c.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f2882d.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f2883e.name());
            sb3.append(" INTEGER);");
            f2865g = sb3.toString();
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
                    sQLiteDatabase.execSQL(f2859a);
                    sQLiteDatabase.execSQL(f2860b);
                    sQLiteDatabase.execSQL(f2861c);
                    sQLiteDatabase.execSQL(f2862d);
                    sQLiteDatabase.execSQL(f2863e);
                    sQLiteDatabase.execSQL(f2864f);
                    sQLiteDatabase.execSQL(f2865g);
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
        public static final f f2866a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f2867b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f2868c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f2869d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f2870e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f2871f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f2872g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f2873h;

        /* renamed from: i  reason: collision with root package name */
        public static final f f2874i;
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
            f2866a = new f("belongTo", 0);
            f2867b = new f(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, 1);
            f2868c = new f("title", 2);
            f2869d = new f("description", 3);
            f2870e = new f("savePath", 4);
            f2871f = new f("fileName", 5);
            f2872g = new f("downloadBytes", 6);
            f2873h = new f("totalBytes", 7);
            f2874i = new f("downloadStatus", 8);
            f fVar = new f(PmsConstant.Statistic.Key.REV_TIMESTAMP, 9);
            j = fVar;
            k = new f[]{f2866a, f2867b, f2868c, f2869d, f2870e, f2871f, f2872g, f2873h, f2874i, fVar};
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
        public static final g f2875a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f2876b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f2877c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ g[] f2878d;
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
            f2875a = new g("MsgInfoId", 0);
            f2876b = new g("msgId", 1);
            g gVar = new g(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f2877c = gVar;
            f2878d = new g[]{f2875a, f2876b, gVar};
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
        public static final h f2879a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f2880b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f2881c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f2882d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f2883e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f2884f;
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
            f2879a = new h(PushClientConstants.TAG_PKG_NAME, 0);
            f2880b = new h("startHour", 1);
            f2881c = new h("startMinute", 2);
            f2882d = new h("endHour", 3);
            h hVar = new h("endMinute", 4);
            f2883e = hVar;
            f2884f = new h[]{f2879a, f2880b, f2881c, f2882d, hVar};
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
        public static final i f2885a;

        /* renamed from: b  reason: collision with root package name */
        public static final i f2886b;

        /* renamed from: c  reason: collision with root package name */
        public static final i f2887c;

        /* renamed from: d  reason: collision with root package name */
        public static final i f2888d;

        /* renamed from: e  reason: collision with root package name */
        public static final i f2889e;

        /* renamed from: f  reason: collision with root package name */
        public static final i f2890f;

        /* renamed from: g  reason: collision with root package name */
        public static final i f2891g;

        /* renamed from: h  reason: collision with root package name */
        public static final i f2892h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ i[] f2893i;
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
            f2885a = new i("info_id", 0);
            f2886b = new i("packageName", 1);
            f2887c = new i("open_type", 2);
            f2888d = new i("msgid", 3);
            f2889e = new i("app_open_time", 4);
            f2890f = new i("app_close_time", 5);
            f2891g = new i("use_duration", 6);
            i iVar = new i("extra", 7);
            f2892h = iVar;
            f2893i = new i[]{f2885a, f2886b, f2887c, f2888d, f2889e, f2890f, f2891g, iVar};
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
        f2798b = new Object();
    }

    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            synchronized (f2798b) {
                long j = -1;
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return -1L;
                }
                Cursor cursor = null;
                try {
                    Cursor query = a2.query("NoDisturb", new String[]{h.f2879a.name()}, h.f2879a.name() + "= ?", new String[]{str}, null, null, null);
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(h.f2879a.name(), str);
                        contentValues.put(h.f2880b.name(), Integer.valueOf(i2));
                        contentValues.put(h.f2881c.name(), Integer.valueOf(i3));
                        contentValues.put(h.f2882d.name(), Integer.valueOf(i4));
                        contentValues.put(h.f2883e.name(), Integer.valueOf(i5));
                        if (query == null || !query.moveToNext()) {
                            j = a2.insert("NoDisturb", null, contentValues);
                        } else {
                            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                                update = a2.delete("NoDisturb", h.f2879a.name() + "= ?", new String[]{str});
                            } else {
                                update = a2.update("NoDisturb", contentValues, h.f2879a.name() + "= ?", new String[]{str});
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
            synchronized (f2798b) {
                try {
                    if (f2797a != null) {
                        f2797a.close();
                        f2797a = null;
                    }
                } catch (Exception unused) {
                    f2797a = null;
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
            public final /* synthetic */ String f2800a;

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
                this.f2800a = str;
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
                    return name.contains("pushstat") && !name.contains(this.f2800a);
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
            synchronized (f2798b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return true;
                }
                Cursor cursor2 = null;
                try {
                    contentValues = new ContentValues();
                    contentValues.clear();
                    contentValues.put(g.f2876b.name(), str);
                    contentValues.put(g.f2877c.name(), Long.valueOf(System.currentTimeMillis()));
                    String str2 = g.f2876b.name() + " =? ";
                    query = a2.query("MsgArriveApp", new String[]{g.f2876b.name()}, str2, new String[]{str}, null, null, null);
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
                    if (cursor.getInt(0) > f2799c) {
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
            synchronized (f2798b) {
                if (f2797a == null) {
                    String path = context.getDatabasePath("pushstat_8.0.0.db").getPath();
                    a("pushstat_8.0.0.db", context);
                    if (Build.VERSION.SDK_INT >= 11) {
                        f2797a = new e(context, path, 2, new d());
                    } else {
                        f2797a = new e(context, path, 2);
                    }
                }
            }
            return f2797a;
        }
        return (e) invokeL.objValue;
    }

    public static int[] b(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            synchronized (f2798b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("NoDisturb", null, h.f2879a.name() + "= ?", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                int i2 = cursor.getInt(cursor.getColumnIndex(h.f2880b.name()));
                                int i3 = cursor.getInt(cursor.getColumnIndex(h.f2881c.name()));
                                int i4 = cursor.getInt(cursor.getColumnIndex(h.f2882d.name()));
                                int i5 = cursor.getInt(cursor.getColumnIndex(h.f2883e.name()));
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
