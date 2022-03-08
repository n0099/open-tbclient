package com.baidu.android.pushservice.c;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.i.i;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.message.a.k;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f30408b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.c.c$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f30409b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f30410c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f30411d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f30412e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f30413f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f30414g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ a[] f30415h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132601495, "Lcom/baidu/android/pushservice/c/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132601495, "Lcom/baidu/android/pushservice/c/c$a;");
                    return;
                }
            }
            a = new a("actionId", 0);
            f30409b = new a("actionName", 1);
            f30410c = new a(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f30411d = new a("pkgName", 3);
            f30412e = new a(PushManager.APP_VERSION_CODE, 4);
            f30413f = new a(PushManager.APP_VERSION_NAME, 5);
            a aVar = new a("status", 6);
            f30414g = aVar;
            f30415h = new a[]{a, f30409b, f30410c, f30411d, f30412e, f30413f, aVar};
        }

        public a(String str, int i2) {
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
    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f30416b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ b[] f30417c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132601464, "Lcom/baidu/android/pushservice/c/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132601464, "Lcom/baidu/android/pushservice/c/c$b;");
                    return;
                }
            }
            a = new b("timeStamps", 0);
            b bVar = new b("clickData", 1);
            f30416b = bVar;
            f30417c = new b[]{a, bVar};
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

    /* renamed from: com.baidu.android.pushservice.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1709c implements DatabaseErrorHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1709c() {
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

        public /* synthetic */ C1709c(AnonymousClass1 anonymousClass1) {
            this();
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

    /* loaded from: classes3.dex */
    public static class d extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f30418b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f30419c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f30420d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f30421e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f30422f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f30423g;

        /* renamed from: h  reason: collision with root package name */
        public static final String f30424h;

        /* renamed from: i  reason: collision with root package name */
        public static final String f30425i;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132601402, "Lcom/baidu/android/pushservice/c/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132601402, "Lcom/baidu/android/pushservice/c/c$d;");
                    return;
                }
            }
            a = "CREATE TABLE PushShareInfo (" + g.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.f30442b.name() + " LONG NOT NULL DEFAULT ((0)), " + g.f30443c.name() + " INTEGER DEFAULT ((0)), " + g.f30444d.name() + " TEXT, " + g.f30445e.name() + " TEXT, " + g.f30446f.name() + " TEXT, " + g.f30447g.name() + " TEXT, " + g.f30448h.name() + " TEXT, " + g.f30449i.name() + " TEXT, " + g.f30450j.name() + " TEXT, " + g.k.name() + " TEXT, " + g.l.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE PushVerifInfo (");
            sb.append(h.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(h.f30451b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f30452c.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f30453d.name());
            sb.append(" TEXT, ");
            sb.append(h.f30454e.name());
            sb.append(" TEXT);");
            f30418b = sb.toString();
            f30419c = "CREATE TABLE PushMsgInfos (" + e.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.f30426b.name() + "  TEXT, " + e.f30427c.name() + "  INTEGER NOT NULL, " + e.f30428d.name() + " LONG NOT NULL, " + e.f30430f.name() + " TEXT, " + e.f30431g.name() + "  TEXT, " + e.f30432h.name() + "  LONG, " + e.f30433i.name() + "  INTEGER, " + e.f30429e.name() + " LONG NOT NULL, " + e.f30434j.name() + "  INTEGER);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE PushDataInfo (");
            sb2.append(f.a.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(f.f30435b.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f30436c.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f30437d.name());
            sb2.append("  LONG NOT NULL, ");
            sb2.append(f.f30438e.name());
            sb2.append(" TEXT,");
            sb2.append(f.f30439f.name());
            sb2.append(" LONG,");
            sb2.append(f.f30440g.name());
            sb2.append(" INTEGER DEFAULT ((0)));");
            f30420d = sb2.toString();
            f30421e = "CREATE TABLE ClickMsgUploadInfo (" + b.a.name() + " LONG NOT NULL," + b.f30416b.name() + " TEXT NOT NULL);";
            f30422f = "CREATE TABLE PushAppStatus (" + a.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.f30409b.name() + " TEXT NOT NULL, " + a.f30410c.name() + " LONG NOT NULL, " + a.f30411d.name() + " TEXT, " + a.f30412e.name() + " INTEGER, " + a.f30413f.name() + " TEXT, " + a.f30414g.name() + " INTEGER);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb3.append(g.f30445e.name());
            sb3.append(" TEXT");
            f30423g = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb4.append(g.f30446f.name());
            sb4.append(" TEXT");
            f30424h = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE PushMsgInfos ADD COLUMN ");
            sb5.append(e.f30434j.name());
            sb5.append(" INTEGER");
            f30425i = sb5.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, String str, int i2, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i2, databaseErrorHandler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i2), databaseErrorHandler};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (DatabaseErrorHandler) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
            super(context, str, cursorFactory, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, cursorFactory, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
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
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushShareInfo");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushVerifyInfo");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushMsgInfo");
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
                    sQLiteDatabase.execSQL(f30418b);
                    sQLiteDatabase.execSQL(f30419c);
                    sQLiteDatabase.execSQL(f30422f);
                    sQLiteDatabase.execSQL(f30420d);
                    sQLiteDatabase.execSQL(f30421e);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                if (i2 <= 1) {
                    a(sQLiteDatabase);
                    onCreate(sQLiteDatabase);
                    return;
                }
                if (i2 == 2) {
                    sQLiteDatabase.execSQL(f30419c);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            sQLiteDatabase.execSQL(f30420d);
                            str3 = f30421e;
                            sQLiteDatabase.execSQL(str3);
                            str2 = f30424h;
                            sQLiteDatabase.execSQL(str2);
                            str = f30425i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 6) {
                            sQLiteDatabase.execSQL(f30420d);
                            str2 = f30421e;
                            sQLiteDatabase.execSQL(str2);
                            str = f30425i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 7) {
                            sQLiteDatabase.execSQL(f30420d);
                            str = f30421e;
                            sQLiteDatabase.execSQL(str);
                        } else {
                            return;
                        }
                    }
                    sQLiteDatabase.execSQL(f30420d);
                    sQLiteDatabase.execSQL(f30421e);
                    str3 = f30423g;
                    sQLiteDatabase.execSQL(str3);
                    str2 = f30424h;
                    sQLiteDatabase.execSQL(str2);
                    str = f30425i;
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.execSQL(f30422f);
                sQLiteDatabase.execSQL(f30420d);
                sQLiteDatabase.execSQL(f30421e);
                str3 = f30423g;
                sQLiteDatabase.execSQL(str3);
                str2 = f30424h;
                sQLiteDatabase.execSQL(str2);
                str = f30425i;
                sQLiteDatabase.execSQL(str);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f30426b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f30427c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f30428d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f30429e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f30430f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f30431g;

        /* renamed from: h  reason: collision with root package name */
        public static final e f30432h;

        /* renamed from: i  reason: collision with root package name */
        public static final e f30433i;

        /* renamed from: j  reason: collision with root package name */
        public static final e f30434j;
        public static final /* synthetic */ e[] k;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132601371, "Lcom/baidu/android/pushservice/c/c$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132601371, "Lcom/baidu/android/pushservice/c/c$e;");
                    return;
                }
            }
            a = new e("MsgInfoId", 0);
            f30426b = new e(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 1);
            f30427c = new e("msgType", 2);
            f30428d = new e("msgId", 3);
            f30429e = new e("arriveTime", 4);
            f30430f = new e("secureInfo", 5);
            f30431g = new e("msgBody", 6);
            f30432h = new e("expireTime", 7);
            f30433i = new e("ackRet", 8);
            e eVar = new e(MiPushMessage.KEY_NOTIFY_ID, 9);
            f30434j = eVar;
            k = new e[]{a, f30426b, f30427c, f30428d, f30429e, f30430f, f30431g, f30432h, f30433i, eVar};
        }

        public e(String str, int i2) {
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
    /* loaded from: classes3.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f30435b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f30436c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f30437d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f30438e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f30439f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f30440g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ f[] f30441h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132601340, "Lcom/baidu/android/pushservice/c/c$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132601340, "Lcom/baidu/android/pushservice/c/c$f;");
                    return;
                }
            }
            a = new f("dataKey", 0);
            f30435b = new f("dataSensitive", 1);
            f30436c = new f("canUpload", 2);
            f30437d = new f("timeInterval", 3);
            f30438e = new f("dataValue", 4);
            f30439f = new f("lastUpdateStamp", 5);
            f fVar = new f("bindCanUpload", 6);
            f30440g = fVar;
            f30441h = new f[]{a, f30435b, f30436c, f30437d, f30438e, f30439f, fVar};
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
    /* loaded from: classes3.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f30442b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f30443c;

        /* renamed from: d  reason: collision with root package name */
        public static final g f30444d;

        /* renamed from: e  reason: collision with root package name */
        public static final g f30445e;

        /* renamed from: f  reason: collision with root package name */
        public static final g f30446f;

        /* renamed from: g  reason: collision with root package name */
        public static final g f30447g;

        /* renamed from: h  reason: collision with root package name */
        public static final g f30448h;

        /* renamed from: i  reason: collision with root package name */
        public static final g f30449i;

        /* renamed from: j  reason: collision with root package name */
        public static final g f30450j;
        public static final g k;
        public static final g l;
        public static final /* synthetic */ g[] m;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132601309, "Lcom/baidu/android/pushservice/c/c$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132601309, "Lcom/baidu/android/pushservice/c/c$g;");
                    return;
                }
            }
            a = new g("PushInfoId", 0);
            f30442b = new g("PushPriority", 1);
            f30443c = new g("PushVersion", 2);
            f30444d = new g("PushChannelID", 3);
            f30445e = new g("PushNewChannelID", 4);
            f30446f = new g("PushChannelToken", 5);
            f30447g = new g("PushCurPkgName", 6);
            f30448h = new g("PushWebAppBindInfo", 7);
            f30449i = new g("PushLightAppBindInfo", 8);
            f30450j = new g("PushSDKClientBindInfo", 9);
            k = new g("PushClientsBindInfo", 10);
            g gVar = new g("PushSelfBindInfo", 11);
            l = gVar;
            m = new g[]{a, f30442b, f30443c, f30444d, f30445e, f30446f, f30447g, f30448h, f30449i, f30450j, k, gVar};
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
    /* loaded from: classes3.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;
        public static final h a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f30451b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f30452c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f30453d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f30454e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f30455f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132601278, "Lcom/baidu/android/pushservice/c/c$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132601278, "Lcom/baidu/android/pushservice/c/c$h;");
                    return;
                }
            }
            a = new h("verifId", 0);
            f30451b = new h("msgId", 1);
            f30452c = new h("md5Infos", 2);
            f30453d = new h(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 3);
            h hVar = new h("time", 4);
            f30454e = hVar;
            f30455f = new h[]{a, f30451b, f30452c, f30453d, hVar};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-677078714, "Lcom/baidu/android/pushservice/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-677078714, "Lcom/baidu/android/pushservice/c/c;");
                return;
            }
        }
        f30408b = new Object();
    }

    public static synchronized long a(Context context, com.baidu.android.pushservice.c.b bVar) {
        InterceptResult invokeLL;
        Cursor cursor;
        Throwable th;
        long update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, bVar)) == null) {
            synchronized (c.class) {
                synchronized (f30408b) {
                    SQLiteDatabase a2 = a(context);
                    long j2 = -1;
                    if (a2 == null) {
                        return -1L;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(g.f30442b.name(), Long.valueOf(bVar.a));
                    contentValues.put(g.f30443c.name(), Long.valueOf(bVar.f30399b));
                    contentValues.put(g.f30444d.name(), bVar.f30400c);
                    contentValues.put(g.f30445e.name(), bVar.f30401d);
                    contentValues.put(g.f30447g.name(), bVar.f30402e);
                    contentValues.put(g.f30449i.name(), bVar.f30404g);
                    contentValues.put(g.f30448h.name(), bVar.f30403f);
                    contentValues.put(g.f30450j.name(), bVar.f30405h);
                    contentValues.put(g.k.name(), bVar.f30406i);
                    contentValues.put(g.l.name(), bVar.f30407j);
                    Cursor cursor2 = null;
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception unused) {
                    } catch (Throwable th2) {
                        cursor = null;
                        th = th2;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception unused2) {
                            cursor2 = cursor;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            return j2;
                        } catch (Throwable th3) {
                            th = th3;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            update = a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            j2 = update;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return j2;
                        }
                    }
                    update = a2.insert("PushShareInfo", null, contentValues);
                    j2 = update;
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                    return j2;
                }
            }
        }
        return invokeLL.longValue;
    }

    public static SQLiteDatabase a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            d h2 = h(context);
            if (h2 == null) {
                return null;
            }
            try {
                return h2.getWritableDatabase();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (SQLiteDatabase) invokeL.objValue;
    }

    public static Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f30408b : invokeV.objValue;
    }

    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f30444d.name(), g.f30445e.name()}, null, null, null, null, null);
                    try {
                        if (cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndex((z ? g.f30445e : g.f30444d).name()));
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        a2.close();
                        throw th;
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                a2.close();
                return str;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static synchronized void a(Context context, long j2) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65541, null, context, j2) == null) {
            synchronized (c.class) {
                synchronized (f30408b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (query != null) {
                        try {
                        } catch (Exception unused2) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(g.f30442b.name(), Long.valueOf(j2));
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = j2;
                    bVar.f30399b = 0L;
                    bVar.f30400c = null;
                    bVar.f30401d = null;
                    bVar.f30402e = null;
                    bVar.f30404g = null;
                    bVar.f30403f = null;
                    bVar.f30405h = null;
                    bVar.f30406i = null;
                    bVar.f30407j = null;
                    a(context, bVar);
                    if (query != null) {
                        query.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static synchronized void a(Context context, String str) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            synchronized (c.class) {
                synchronized (f30408b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (query != null) {
                        try {
                        } catch (Exception unused2) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(g.f30446f.name(), str);
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.f30399b = 0L;
                    bVar.f30400c = null;
                    bVar.f30401d = null;
                    bVar.f30402e = null;
                    bVar.f30404g = null;
                    bVar.f30403f = null;
                    bVar.f30405h = null;
                    bVar.f30406i = null;
                    bVar.f30407j = null;
                    a(context, bVar);
                    if (query != null) {
                        query.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static void a(Context context, String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.a.name(), str);
                    contentValues.put(f.f30435b.name(), Integer.valueOf(i2));
                    contentValues.put(f.f30437d.name(), Long.valueOf(j2));
                    contentValues.put(f.f30436c.name(), (Integer) 1);
                    if (a2.update("PushDataInfo", contentValues, f.a.name() + " =? ", new String[]{String.valueOf(str)}) == 0) {
                        a2.insertWithOnConflict("PushDataInfo", null, contentValues, 5);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, String str, int i2, long j2, byte[] bArr, byte[] bArr2, long j3, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j2), bArr, bArr2, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.f30426b.name(), str);
                    contentValues.put(e.f30428d.name(), Long.valueOf(j2));
                    contentValues.put(e.f30427c.name(), Integer.valueOf(i2));
                    if (bArr != null && bArr.length > 0) {
                        contentValues.put(e.f30431g.name(), BaiduAppSSOJni.a(context, str, bArr));
                        contentValues.put(e.f30430f.name(), bArr2);
                        contentValues.put(e.f30432h.name(), Long.valueOf(j3));
                    }
                    contentValues.put(e.f30429e.name(), Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(e.f30433i.name(), Integer.valueOf(i3));
                    contentValues.put(e.f30434j.name(), Integer.valueOf(i4));
                    a2.insert("PushMsgInfos", null, contentValues);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
                a2.close();
            }
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, str, str2) == null) {
            synchronized (c.class) {
                synchronized (f30408b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (query != null) {
                        try {
                        } catch (Exception unused2) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(g.f30444d.name(), str);
                            if (!TextUtils.isEmpty(str2)) {
                                contentValues.put(g.f30445e.name(), str2);
                            }
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.f30399b = 0L;
                    bVar.f30400c = str;
                    bVar.f30401d = str2;
                    bVar.f30402e = null;
                    bVar.f30404g = null;
                    bVar.f30403f = null;
                    bVar.f30405h = null;
                    bVar.f30406i = null;
                    bVar.f30407j = null;
                    a(context, bVar);
                    if (query != null) {
                        query.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, context, str, str2, l) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f30438e.name(), str2);
                    if (l != null) {
                        contentValues.put(f.f30439f.name(), l);
                    }
                    a2.update("PushDataInfo", contentValues, f.a.name() + " =? ", new String[]{String.valueOf(str)});
                } catch (Exception unused) {
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, arrayList) == null) {
            synchronized (f30408b) {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    sb.append("'");
                    sb.append(arrayList.get(i2));
                    sb.append("'");
                    if (i2 < arrayList.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f30436c.name() + "=0 WHERE " + f.a.name() + " NOT IN " + sb.toString());
                } catch (Exception unused) {
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, jSONArray) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                if (jSONArray != null) {
                    try {
                        if (jSONArray.length() > 0) {
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                ContentValues contentValues = new ContentValues();
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                long j2 = jSONObject.getLong("event_time");
                                contentValues.put(b.f30416b.name(), jSONObject.toString());
                                contentValues.put(b.a.name(), Long.valueOf(j2));
                                a2.insert("ClickMsgUploadInfo", null, contentValues);
                            }
                        }
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        a2.close();
                        throw th;
                    }
                }
                a2.close();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, context, i2)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.f30434j.name()}, e.f30434j.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return true;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return false;
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return false;
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
            }
        }
        return invokeLI.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, com.baidu.android.pushservice.c.f fVar) {
        InterceptResult invokeLL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, fVar)) == null) {
            synchronized (c.class) {
                synchronized (f30408b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return false;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.f30451b.name(), fVar.a);
                    contentValues.put(h.f30452c.name(), fVar.f30501b);
                    contentValues.put(h.f30453d.name(), fVar.f30502c);
                    contentValues.put(h.f30454e.name(), System.currentTimeMillis() + "");
                    Cursor cursor = null;
                    try {
                        j2 = a2.insert("PushVerifInfo", null, contentValues);
                        try {
                            cursor = a2.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                            if (cursor.moveToFirst() && cursor.getInt(0) > 200) {
                                a2.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{fVar.a});
                            }
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                        } catch (Exception unused) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            if (j2 != -1) {
                            }
                            return r2;
                        }
                    } catch (Exception unused2) {
                        j2 = -1;
                    }
                    a2.close();
                    boolean z = j2 != -1;
                    return z;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return 0;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f30443c.name()}, null, null, null, null, null);
                    r9 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(g.f30443c.name())) : 0;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
                a2.close();
                return r9;
            }
        }
        return invokeL.intValue;
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65552, null, context, str, str2)) != null) {
            return (String) invokeLLL.objValue;
        }
        Cursor cursor2 = null;
        try {
            if (m.g(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
            } else {
                Uri parse = Uri.parse("content://" + str + ".bdpush/verif");
                String[] strArr = {h.f30452c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f30451b.name());
                sb.append("=?");
                cursor = contentResolver.query(parse, strArr, sb.toString(), new String[]{str2}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str3 = cursor.getString(0);
                            cursor2 = cursor;
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return null;
                            } catch (Exception unused2) {
                                return null;
                            }
                        }
                        return null;
                    }
                }
                str3 = null;
                cursor2 = cursor;
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception unused3) {
                }
            }
            return str3;
        } catch (Throwable unused4) {
            cursor = null;
        }
    }

    public static synchronized void b(Context context, long j2) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65553, null, context, j2) == null) {
            synchronized (c.class) {
                synchronized (f30408b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (query != null) {
                        try {
                        } catch (Exception unused2) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(g.f30443c.name(), Long.valueOf(j2));
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.f30399b = j2;
                    bVar.f30400c = null;
                    bVar.f30401d = null;
                    bVar.f30402e = null;
                    bVar.f30404g = null;
                    bVar.f30403f = null;
                    bVar.f30405h = null;
                    bVar.f30406i = null;
                    bVar.f30407j = null;
                    a(context, bVar);
                    if (query != null) {
                        query.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static synchronized void b(Context context, String str) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) {
            synchronized (c.class) {
                synchronized (f30408b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null || str == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (query != null) {
                        try {
                        } catch (Exception unused2) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(g.k.name(), str);
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.f30399b = 0L;
                    bVar.f30400c = null;
                    bVar.f30401d = null;
                    bVar.f30402e = null;
                    bVar.f30404g = null;
                    bVar.f30403f = null;
                    bVar.f30405h = null;
                    bVar.f30406i = str;
                    bVar.f30407j = null;
                    a(context, bVar);
                    if (query != null) {
                        query.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static void b(Context context, JSONArray jSONArray) {
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, context, jSONArray) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    sb.append("'");
                    try {
                        obj = jSONArray.get(i2).toString();
                    } catch (JSONException unused) {
                    }
                    sb.append(obj);
                    sb.append("'");
                    if (i2 < jSONArray.length() - 1) {
                        sb.append(",");
                    }
                }
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f30440g.name(), (Integer) 0);
                    a2.update("PushDataInfo", contentValues, null, null);
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f30440g.name() + "=1 WHERE " + f.a.name() + " IN " + sb.toString());
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
                a2.close();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, context, i2)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                int i3 = -1;
                try {
                    cursor = a2.query("PushMsgInfos", null, e.f30434j.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
                    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                        i3 = cursor.getInt(cursor.getColumnIndex(e.f30427c.name()));
                    }
                    if (i3 != k.f30925g.b() && i3 != k.f30921c.b() && i3 != k.f30920b.b()) {
                        if (i3 != k.f30927i.b()) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return false;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return true;
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return false;
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
            }
        }
        return invokeLI.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f30446f.name()}, null, null, null, null, null);
                    try {
                        str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.f30446f.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        a2.close();
                        throw th;
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                a2.close();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65558, null, context, str, str2)) != null) {
            return (String) invokeLLL.objValue;
        }
        Cursor cursor2 = null;
        try {
            if (m.g(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
            } else {
                Uri parse = Uri.parse("content://" + str + ".bdpush/verif");
                String[] strArr = {h.f30452c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f30452c.name());
                sb.append("=?");
                cursor = contentResolver.query(parse, strArr, sb.toString(), new String[]{str2}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str3 = cursor.getString(0);
                            cursor2 = cursor;
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return null;
                            } catch (Exception unused2) {
                                return null;
                            }
                        }
                        return null;
                    }
                }
                str3 = null;
                cursor2 = cursor;
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception unused3) {
                }
            }
            return str3;
        } catch (Throwable unused4) {
            cursor = null;
        }
    }

    public static synchronized void c(Context context, String str) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, str) == null) {
            synchronized (c.class) {
                synchronized (f30408b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null || str == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (query != null) {
                        try {
                        } catch (Exception unused2) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(g.l.name(), str);
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.f30399b = 0L;
                    bVar.f30400c = null;
                    bVar.f30401d = null;
                    bVar.f30402e = null;
                    bVar.f30404g = null;
                    bVar.f30403f = null;
                    bVar.f30405h = null;
                    bVar.f30406i = null;
                    bVar.f30407j = str;
                    a(context, bVar);
                    if (query != null) {
                        query.close();
                    }
                    a2.close();
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean c(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65560, null, context, j2)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.f30428d.name()}, e.f30428d.name() + " =? ", new String[]{String.valueOf(j2)}, null, null, null);
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return true;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return false;
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return false;
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
            }
        }
        return invokeLJ.booleanValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.k.name()}, null, null, null, null, null);
                    try {
                        str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.k.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        a2.close();
                        throw th;
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                a2.close();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, str)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                String str2 = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushDataInfo", null, f.a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(f.f30440g.name())) == 1) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.f30438e.name()));
                            }
                        } catch (Exception unused) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            throw th;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                a2.close();
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e8, code lost:
        if (r10.isClosed() != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ea, code lost:
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, context, str, str2)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return false;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushDataInfo", null, f.a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    int i2 = cursor.getInt(cursor.getColumnIndex(f.f30435b.name()));
                    String string = cursor.getString(cursor.getColumnIndex(f.f30438e.name()));
                    if (cursor.getInt(cursor.getColumnIndex(f.f30436c.name())) != 1) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return false;
                    } else if (i2 == 1 && str2.equals(string)) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return false;
                    } else if (System.currentTimeMillis() - cursor.getLong(cursor.getColumnIndex(f.f30439f.name())) > cursor.getLong(cursor.getColumnIndex(f.f30437d.name())) * 1000) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return true;
                    } else {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return false;
                    }
                }
                a2.close();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.l.name()}, null, null, null, null, null);
                    try {
                        str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.l.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        a2.close();
                        throw th;
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                a2.close();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, str)) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                String str2 = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushDataInfo", null, f.a.name() + " =? ", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.f30438e.name()));
                            }
                        } catch (Exception unused) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            throw th;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                a2.close();
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static JSONArray f(Context context) {
        InterceptResult invokeL;
        int b2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            JSONArray jSONArray = new JSONArray();
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return jSONArray;
                }
                Cursor cursor = null;
                try {
                    b2 = i.b(context, "click_data_size", 10) - 1;
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (b2 <= 0) {
                    a2.close();
                    return jSONArray;
                }
                Cursor query = a2.query(false, "ClickMsgUploadInfo", null, null, null, null, null, b.a.name() + " DESC ", String.valueOf(b2));
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            do {
                                String string = query.getString(query.getColumnIndex(b.f30416b.name()));
                                j2 = query.getLong(query.getColumnIndex(b.a.name()));
                                jSONArray.put(new JSONObject(string));
                            } while (query.moveToNext());
                            if (a2.delete("ClickMsgUploadInfo", b.a.name() + " >= " + String.valueOf(j2), null) == 0) {
                                jSONArray = new JSONArray();
                            }
                        }
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return jSONArray;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
                a2.close();
                return jSONArray;
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    public static void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, context) == null) {
            synchronized (f30408b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    a2.delete("ClickMsgUploadInfo", null, null);
                } catch (Exception unused) {
                }
                a2.close();
            }
        }
    }

    public static d h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (a == null) {
                synchronized (f30408b) {
                    if (a == null) {
                        File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                        SQLiteDatabase sQLiteDatabase = null;
                        if (Build.VERSION.SDK_INT >= 11) {
                            a = new d(context, str, 8, new C1709c(null));
                        } else {
                            a = new d(context, str, (SQLiteDatabase.CursorFactory) null, 8);
                        }
                        try {
                            SQLiteDatabase writableDatabase = a.getWritableDatabase();
                            try {
                                writableDatabase.delete("PushMsgInfos", e.f30429e.name() + " < " + (System.currentTimeMillis() - 259200000), null);
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                }
                            } catch (Throwable unused) {
                                sQLiteDatabase = writableDatabase;
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                return a;
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            return a;
        }
        return (d) invokeL.objValue;
    }
}
