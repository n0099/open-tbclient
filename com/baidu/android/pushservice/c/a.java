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
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static e a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f31705b;

    /* renamed from: c  reason: collision with root package name */
    public static int f31706c = 200;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.android.pushservice.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class EnumC1722a {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC1722a a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1722a f31711b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1722a f31712c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC1722a f31713d;

        /* renamed from: e  reason: collision with root package name */
        public static final EnumC1722a f31714e;

        /* renamed from: f  reason: collision with root package name */
        public static final EnumC1722a f31715f;

        /* renamed from: g  reason: collision with root package name */
        public static final EnumC1722a f31716g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ EnumC1722a[] f31717h;
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
            a = new EnumC1722a("alarmMsgInfoId", 0);
            f31711b = new EnumC1722a("msgId", 1);
            f31712c = new EnumC1722a("sendtime", 2);
            f31713d = new EnumC1722a("showtime", 3);
            f31714e = new EnumC1722a("expiretime", 4);
            f31715f = new EnumC1722a("msgEnable", 5);
            EnumC1722a enumC1722a = new EnumC1722a("isAlarm", 6);
            f31716g = enumC1722a;
            f31717h = new EnumC1722a[]{a, f31711b, f31712c, f31713d, f31714e, f31715f, enumC1722a};
        }

        public EnumC1722a(String str, int i2) {
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
    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f31724b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f31725c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f31726d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f31727e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f31728f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f31729g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f31730h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f31731i;

        /* renamed from: j  reason: collision with root package name */
        public static final /* synthetic */ b[] f31732j;
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
            a = new b("appInfoId", 0);
            f31724b = new b("appid", 1);
            f31725c = new b("appType", 2);
            f31726d = new b("packageName", 3);
            f31727e = new b("appName", 4);
            f31728f = new b("cFrom", 5);
            f31729g = new b(PushManager.APP_VERSION_CODE, 6);
            f31730h = new b(PushManager.APP_VERSION_NAME, 7);
            b bVar = new b("intergratedPushVersion", 8);
            f31731i = bVar;
            f31732j = new b[]{a, f31724b, f31725c, f31726d, f31727e, f31728f, f31729g, f31730h, bVar};
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
    /* loaded from: classes10.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f31736b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f31737c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f31738d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f31739e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f31740f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f31741g;

        /* renamed from: h  reason: collision with root package name */
        public static final c f31742h;

        /* renamed from: i  reason: collision with root package name */
        public static final c f31743i;

        /* renamed from: j  reason: collision with root package name */
        public static final c f31744j;
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
            a = new c("actionId", 0);
            f31736b = new c("actionName", 1);
            f31737c = new c(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f31738d = new c("networkStatus", 3);
            f31739e = new c("msgType", 4);
            f31740f = new c("msgId", 5);
            f31741g = new c("msgLen", 6);
            f31742h = new c("errorMsg", 7);
            f31743i = new c("requestId", 8);
            f31744j = new c("stableHeartInterval", 9);
            k = new c("errorCode", 10);
            l = new c("appid", 11);
            m = new c("channel", 12);
            n = new c("openByPackageName", 13);
            c cVar = new c("packageName", 14);
            o = cVar;
            p = new c[]{a, f31736b, f31737c, f31738d, f31739e, f31740f, f31741g, f31742h, f31743i, f31744j, k, l, m, n, cVar};
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static class e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f31759b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f31760c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f31761d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f31762e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f31763f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f31764g;
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
            a = "CREATE TABLE StatisticsInfo (" + i.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.f31782b.name() + " TEXT NOT NULL, " + i.f31783c.name() + " TEXT NOT NULL, " + i.f31784d.name() + " TEXT, " + i.f31785e.name() + " TEXT NOT NULL, " + i.f31786f.name() + " TEXT NOT NULL, " + i.f31787g.name() + " TEXT NOT NULL, " + i.f31788h.name() + " TEXT);";
            f31759b = "CREATE TABLE PushBehavior (" + c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f31736b.name() + " TEXT NOT NULL, " + c.f31737c.name() + " LONG NOT NULL, " + c.f31738d.name() + " TEXT, " + c.f31739e.name() + " INTEGER, " + c.f31740f.name() + " TEXT, " + c.f31741g.name() + " INTEGER, " + c.f31742h.name() + " TEXT, " + c.f31743i.name() + " TEXT, " + c.f31744j.name() + " INTEGER, " + c.k.name() + " INTEGER, " + c.l.name() + " TEXT, " + c.m.name() + " TEXT, " + c.o.name() + " TEXT, " + c.n.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE MsgArriveApp (");
            sb.append(g.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(g.f31774b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(g.f31775c.name());
            sb.append(" LONG NOT NULL);");
            f31760c = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE AlarmMsgInfo (");
            sb2.append(EnumC1722a.a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(EnumC1722a.f31711b.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(EnumC1722a.f31712c.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1722a.f31713d.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1722a.f31714e.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC1722a.f31715f.name());
            sb2.append(" INTEGER, ");
            sb2.append(EnumC1722a.f31716g.name());
            sb2.append(" INTEGER);");
            f31761d = sb2.toString();
            f31762e = "CREATE TABLE AppInfo (" + b.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.f31724b.name() + " TEXT, " + b.f31725c.name() + " INTEGER, " + b.f31726d.name() + " TEXT UNIQUE, " + b.f31727e.name() + " TEXT, " + b.f31728f.name() + " TEXT, " + b.f31729g.name() + " TEXT, " + b.f31730h.name() + " TEXT, " + b.f31731i.name() + " TEXT);";
            f31763f = "CREATE TABLE FileDownloadingInfo (" + f.a.name() + " TEXT, " + f.f31765b.name() + " TEXT PRIMARY KEY, " + f.f31768e.name() + " TEXT NOT NULL, " + f.f31766c.name() + " TEXT, " + f.f31767d.name() + " TEXT, " + f.f31769f.name() + " TEXT NOT NULL, " + f.f31770g.name() + " INTEGER NOT NULL, " + f.f31771h.name() + " INTEGER NOT NULL, " + f.f31772i.name() + " INTEGER NOT NULL," + f.f31773j.name() + " INTEGER NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE NoDisturb (");
            sb3.append(h.a.name());
            sb3.append(" TEXT NOT NULL, ");
            sb3.append(h.f31777b.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f31778c.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f31779d.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.f31780e.name());
            sb3.append(" INTEGER);");
            f31764g = sb3.toString();
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
                    sQLiteDatabase.execSQL(a);
                    sQLiteDatabase.execSQL(f31759b);
                    sQLiteDatabase.execSQL(f31760c);
                    sQLiteDatabase.execSQL(f31761d);
                    sQLiteDatabase.execSQL(f31762e);
                    sQLiteDatabase.execSQL(f31763f);
                    sQLiteDatabase.execSQL(f31764g);
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
    /* loaded from: classes10.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f31765b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f31766c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f31767d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f31768e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f31769f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f31770g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f31771h;

        /* renamed from: i  reason: collision with root package name */
        public static final f f31772i;

        /* renamed from: j  reason: collision with root package name */
        public static final f f31773j;
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
            a = new f("belongTo", 0);
            f31765b = new f(TTDownloadField.TT_DOWNLOAD_URL, 1);
            f31766c = new f("title", 2);
            f31767d = new f("description", 3);
            f31768e = new f("savePath", 4);
            f31769f = new f("fileName", 5);
            f31770g = new f("downloadBytes", 6);
            f31771h = new f("totalBytes", 7);
            f31772i = new f("downloadStatus", 8);
            f fVar = new f(PmsConstant.Statistic.Key.REV_TIMESTAMP, 9);
            f31773j = fVar;
            k = new f[]{a, f31765b, f31766c, f31767d, f31768e, f31769f, f31770g, f31771h, f31772i, fVar};
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
    /* loaded from: classes10.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f31774b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f31775c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ g[] f31776d;
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
            a = new g("MsgInfoId", 0);
            f31774b = new g("msgId", 1);
            g gVar = new g(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f31775c = gVar;
            f31776d = new g[]{a, f31774b, gVar};
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
    /* loaded from: classes10.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;
        public static final h a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f31777b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f31778c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f31779d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f31780e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f31781f;
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
            a = new h("pkgName", 0);
            f31777b = new h("startHour", 1);
            f31778c = new h("startMinute", 2);
            f31779d = new h("endHour", 3);
            h hVar = new h("endMinute", 4);
            f31780e = hVar;
            f31781f = new h[]{a, f31777b, f31778c, f31779d, hVar};
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
    /* loaded from: classes10.dex */
    public static final class i {
        public static /* synthetic */ Interceptable $ic;
        public static final i a;

        /* renamed from: b  reason: collision with root package name */
        public static final i f31782b;

        /* renamed from: c  reason: collision with root package name */
        public static final i f31783c;

        /* renamed from: d  reason: collision with root package name */
        public static final i f31784d;

        /* renamed from: e  reason: collision with root package name */
        public static final i f31785e;

        /* renamed from: f  reason: collision with root package name */
        public static final i f31786f;

        /* renamed from: g  reason: collision with root package name */
        public static final i f31787g;

        /* renamed from: h  reason: collision with root package name */
        public static final i f31788h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ i[] f31789i;
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
            a = new i("info_id", 0);
            f31782b = new i("packageName", 1);
            f31783c = new i("open_type", 2);
            f31784d = new i("msgid", 3);
            f31785e = new i("app_open_time", 4);
            f31786f = new i("app_close_time", 5);
            f31787g = new i("use_duration", 6);
            i iVar = new i("extra", 7);
            f31788h = iVar;
            f31789i = new i[]{a, f31782b, f31783c, f31784d, f31785e, f31786f, f31787g, iVar};
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
        f31705b = new Object();
    }

    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            synchronized (f31705b) {
                long j2 = -1;
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return -1L;
                }
                Cursor cursor = null;
                try {
                    Cursor query = a2.query("NoDisturb", new String[]{h.a.name()}, h.a.name() + "= ?", new String[]{str}, null, null, null);
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(h.a.name(), str);
                        contentValues.put(h.f31777b.name(), Integer.valueOf(i2));
                        contentValues.put(h.f31778c.name(), Integer.valueOf(i3));
                        contentValues.put(h.f31779d.name(), Integer.valueOf(i4));
                        contentValues.put(h.f31780e.name(), Integer.valueOf(i5));
                        if (query == null || !query.moveToNext()) {
                            j2 = a2.insert("NoDisturb", null, contentValues);
                        } else {
                            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                                update = a2.delete("NoDisturb", h.a.name() + "= ?", new String[]{str});
                            } else {
                                update = a2.update("NoDisturb", contentValues, h.a.name() + "= ?", new String[]{str});
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
            synchronized (f31705b) {
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
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context) == null) || (parentFile = context.getDatabasePath("pushstat_8.1.9.db").getParentFile()) == null || !parentFile.isDirectory() || (listFiles = parentFile.listFiles(new FileFilter(str) { // from class: com.baidu.android.pushservice.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

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
                this.a = str;
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
                    return name.contains("pushstat") && !name.contains(this.a);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            synchronized (f31705b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return true;
                }
                Cursor cursor2 = null;
                try {
                    contentValues = new ContentValues();
                    contentValues.clear();
                    contentValues.put(g.f31774b.name(), str);
                    contentValues.put(g.f31775c.name(), Long.valueOf(System.currentTimeMillis()));
                    String str2 = g.f31774b.name() + " =? ";
                    query = a2.query("MsgArriveApp", new String[]{g.f31774b.name()}, str2, new String[]{str}, null, null, null);
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
                    if (cursor.getInt(0) > f31706c) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            synchronized (f31705b) {
                if (a == null) {
                    String path = context.getDatabasePath("pushstat_8.1.9.db").getPath();
                    a("pushstat_8.1.9.db", context);
                    if (Build.VERSION.SDK_INT >= 11) {
                        a = new e(context, path, 2, new d());
                    } else {
                        a = new e(context, path, 2);
                    }
                }
            }
            return a;
        }
        return (e) invokeL.objValue;
    }

    public static int[] b(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            synchronized (f31705b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("NoDisturb", null, h.a.name() + "= ?", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                int i2 = cursor.getInt(cursor.getColumnIndex(h.f31777b.name()));
                                int i3 = cursor.getInt(cursor.getColumnIndex(h.f31778c.name()));
                                int i4 = cursor.getInt(cursor.getColumnIndex(h.f31779d.name()));
                                int i5 = cursor.getInt(cursor.getColumnIndex(h.f31780e.name()));
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
