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
import com.baidu.android.pushservice.j.i;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.message.a.l;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f35961a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f35962b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.c.c$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f35963a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f35964b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f35965c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f35966d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f35967e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f35968f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f35969g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ a[] f35970h;
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
            f35963a = new a("actionId", 0);
            f35964b = new a("actionName", 1);
            f35965c = new a(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f35966d = new a("pkgName", 3);
            f35967e = new a(PushManager.APP_VERSION_CODE, 4);
            f35968f = new a(PushManager.APP_VERSION_NAME, 5);
            a aVar = new a("status", 6);
            f35969g = aVar;
            f35970h = new a[]{f35963a, f35964b, f35965c, f35966d, f35967e, f35968f, aVar};
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
    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f35971a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f35972b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ b[] f35973c;
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
            f35971a = new b("timeStamps", 0);
            b bVar = new b("clickData", 1);
            f35972b = bVar;
            f35973c = new b[]{f35971a, bVar};
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
    /* loaded from: classes6.dex */
    public static class C1583c implements DatabaseErrorHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1583c() {
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

        public /* synthetic */ C1583c(AnonymousClass1 anonymousClass1) {
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

    /* loaded from: classes6.dex */
    public static class d extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f35974a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f35975b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f35976c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f35977d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f35978e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f35979f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f35980g;

        /* renamed from: h  reason: collision with root package name */
        public static final String f35981h;

        /* renamed from: i  reason: collision with root package name */
        public static final String f35982i;
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
            f35974a = "CREATE TABLE PushShareInfo (" + g.f36000a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.f36001b.name() + " LONG NOT NULL DEFAULT ((0)), " + g.f36002c.name() + " INTEGER DEFAULT ((0)), " + g.f36003d.name() + " TEXT, " + g.f36004e.name() + " TEXT, " + g.f36005f.name() + " TEXT, " + g.f36006g.name() + " TEXT, " + g.f36007h.name() + " TEXT, " + g.f36008i.name() + " TEXT, " + g.j.name() + " TEXT, " + g.k.name() + " TEXT, " + g.l.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE PushVerifInfo (");
            sb.append(h.f36009a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(h.f36010b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f36011c.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f36012d.name());
            sb.append(" TEXT, ");
            sb.append(h.f36013e.name());
            sb.append(" TEXT);");
            f35975b = sb.toString();
            f35976c = "CREATE TABLE PushMsgInfos (" + e.f35983a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.f35984b.name() + "  TEXT, " + e.f35985c.name() + "  INTEGER NOT NULL, " + e.f35986d.name() + " LONG NOT NULL, " + e.f35988f.name() + " TEXT, " + e.f35989g.name() + "  TEXT, " + e.f35990h.name() + "  LONG, " + e.f35991i.name() + "  INTEGER, " + e.f35987e.name() + " LONG NOT NULL, " + e.j.name() + "  INTEGER);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE PushDataInfo (");
            sb2.append(f.f35992a.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(f.f35993b.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f35994c.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f35995d.name());
            sb2.append("  LONG NOT NULL, ");
            sb2.append(f.f35996e.name());
            sb2.append(" TEXT,");
            sb2.append(f.f35997f.name());
            sb2.append(" LONG,");
            sb2.append(f.f35998g.name());
            sb2.append(" INTEGER DEFAULT ((0)));");
            f35977d = sb2.toString();
            f35978e = "CREATE TABLE ClickMsgUploadInfo (" + b.f35971a.name() + " LONG NOT NULL," + b.f35972b.name() + " TEXT NOT NULL);";
            f35979f = "CREATE TABLE PushAppStatus (" + a.f35963a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.f35964b.name() + " TEXT NOT NULL, " + a.f35965c.name() + " LONG NOT NULL, " + a.f35966d.name() + " TEXT, " + a.f35967e.name() + " INTEGER, " + a.f35968f.name() + " TEXT, " + a.f35969g.name() + " INTEGER);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb3.append(g.f36004e.name());
            sb3.append(" TEXT");
            f35980g = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb4.append(g.f36005f.name());
            sb4.append(" TEXT");
            f35981h = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE PushMsgInfos ADD COLUMN ");
            sb5.append(e.j.name());
            sb5.append(" INTEGER");
            f35982i = sb5.toString();
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
                    sQLiteDatabase.execSQL(f35974a);
                    sQLiteDatabase.execSQL(f35975b);
                    sQLiteDatabase.execSQL(f35976c);
                    sQLiteDatabase.execSQL(f35979f);
                    sQLiteDatabase.execSQL(f35977d);
                    sQLiteDatabase.execSQL(f35978e);
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
                    sQLiteDatabase.execSQL(f35976c);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            sQLiteDatabase.execSQL(f35977d);
                            str3 = f35978e;
                            sQLiteDatabase.execSQL(str3);
                            str2 = f35981h;
                            sQLiteDatabase.execSQL(str2);
                            str = f35982i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 6) {
                            sQLiteDatabase.execSQL(f35977d);
                            str2 = f35978e;
                            sQLiteDatabase.execSQL(str2);
                            str = f35982i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 7) {
                            sQLiteDatabase.execSQL(f35977d);
                            str = f35978e;
                            sQLiteDatabase.execSQL(str);
                        } else {
                            return;
                        }
                    }
                    sQLiteDatabase.execSQL(f35977d);
                    sQLiteDatabase.execSQL(f35978e);
                    str3 = f35980g;
                    sQLiteDatabase.execSQL(str3);
                    str2 = f35981h;
                    sQLiteDatabase.execSQL(str2);
                    str = f35982i;
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.execSQL(f35979f);
                sQLiteDatabase.execSQL(f35977d);
                sQLiteDatabase.execSQL(f35978e);
                str3 = f35980g;
                sQLiteDatabase.execSQL(str3);
                str2 = f35981h;
                sQLiteDatabase.execSQL(str2);
                str = f35982i;
                sQLiteDatabase.execSQL(str);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f35983a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f35984b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f35985c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f35986d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f35987e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f35988f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f35989g;

        /* renamed from: h  reason: collision with root package name */
        public static final e f35990h;

        /* renamed from: i  reason: collision with root package name */
        public static final e f35991i;
        public static final e j;
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
            f35983a = new e("MsgInfoId", 0);
            f35984b = new e(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 1);
            f35985c = new e("msgType", 2);
            f35986d = new e("msgId", 3);
            f35987e = new e("arriveTime", 4);
            f35988f = new e("secureInfo", 5);
            f35989g = new e("msgBody", 6);
            f35990h = new e("expireTime", 7);
            f35991i = new e("ackRet", 8);
            e eVar = new e(MiPushMessage.KEY_NOTIFY_ID, 9);
            j = eVar;
            k = new e[]{f35983a, f35984b, f35985c, f35986d, f35987e, f35988f, f35989g, f35990h, f35991i, eVar};
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
    /* loaded from: classes6.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f35992a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f35993b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f35994c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f35995d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f35996e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f35997f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f35998g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ f[] f35999h;
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
            f35992a = new f("dataKey", 0);
            f35993b = new f("dataSensitive", 1);
            f35994c = new f("canUpload", 2);
            f35995d = new f("timeInterval", 3);
            f35996e = new f("dataValue", 4);
            f35997f = new f("lastUpdateStamp", 5);
            f fVar = new f("bindCanUpload", 6);
            f35998g = fVar;
            f35999h = new f[]{f35992a, f35993b, f35994c, f35995d, f35996e, f35997f, fVar};
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
        public static final g f36000a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f36001b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f36002c;

        /* renamed from: d  reason: collision with root package name */
        public static final g f36003d;

        /* renamed from: e  reason: collision with root package name */
        public static final g f36004e;

        /* renamed from: f  reason: collision with root package name */
        public static final g f36005f;

        /* renamed from: g  reason: collision with root package name */
        public static final g f36006g;

        /* renamed from: h  reason: collision with root package name */
        public static final g f36007h;

        /* renamed from: i  reason: collision with root package name */
        public static final g f36008i;
        public static final g j;
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
            f36000a = new g("PushInfoId", 0);
            f36001b = new g("PushPriority", 1);
            f36002c = new g("PushVersion", 2);
            f36003d = new g("PushChannelID", 3);
            f36004e = new g("PushNewChannelID", 4);
            f36005f = new g("PushChannelToken", 5);
            f36006g = new g("PushCurPkgName", 6);
            f36007h = new g("PushWebAppBindInfo", 7);
            f36008i = new g("PushLightAppBindInfo", 8);
            j = new g("PushSDKClientBindInfo", 9);
            k = new g("PushClientsBindInfo", 10);
            g gVar = new g("PushSelfBindInfo", 11);
            l = gVar;
            m = new g[]{f36000a, f36001b, f36002c, f36003d, f36004e, f36005f, f36006g, f36007h, f36008i, j, k, gVar};
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
        public static final h f36009a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f36010b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f36011c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f36012d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f36013e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f36014f;
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
            f36009a = new h("verifId", 0);
            f36010b = new h("msgId", 1);
            f36011c = new h("md5Infos", 2);
            f36012d = new h(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 3);
            h hVar = new h("time", 4);
            f36013e = hVar;
            f36014f = new h[]{f36009a, f36010b, f36011c, f36012d, hVar};
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
        f35962b = new Object();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:39:0x010e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized long a(android.content.Context r17, com.baidu.android.pushservice.c.b r18) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.android.pushservice.c.c.$ic
            if (r0 != 0) goto L137
        L4:
            r0 = r17
            r1 = r18
            java.lang.Class<com.baidu.android.pushservice.c.c> r2 = com.baidu.android.pushservice.c.c.class
            monitor-enter(r2)
            java.lang.Object r3 = com.baidu.android.pushservice.c.c.f35962b     // Catch: java.lang.Throwable -> L134
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L134
            android.database.sqlite.SQLiteDatabase r12 = a(r17)     // Catch: java.lang.Throwable -> L131
            r13 = -1
            if (r12 != 0) goto L19
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L131
            monitor-exit(r2)
            return r13
        L19:
            android.content.ContentValues r15 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L131
            r15.<init>()     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f36001b     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            long r5 = r1.f35952a     // Catch: java.lang.Throwable -> L131
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f36002c     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            long r5 = r1.f35953b     // Catch: java.lang.Throwable -> L131
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f36003d     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            java.lang.String r5 = r1.f35954c     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f36004e     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            java.lang.String r5 = r1.f35955d     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f36006g     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            java.lang.String r5 = r1.f35956e     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f36008i     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            java.lang.String r5 = r1.f35958g     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f36007h     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            java.lang.String r5 = r1.f35957f     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.j     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            java.lang.String r5 = r1.f35959h     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.k     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            java.lang.String r5 = r1.f35960i     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.l     // Catch: java.lang.Throwable -> L131
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L131
            java.lang.String r5 = r1.j     // Catch: java.lang.Throwable -> L131
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L131
            r11 = 0
            java.lang.String r5 = "PushShareInfo"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r16 = 0
            r4 = r12
            r13 = r11
            r11 = r16
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L109 java.lang.Exception -> L10c
            if (r11 == 0) goto Ld2
            int r4 = r11.getCount()     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            if (r4 == 0) goto Ld2
            java.lang.String r4 = "PushShareInfo"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            r5.<init>()     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            com.baidu.android.pushservice.c.c$g r6 = com.baidu.android.pushservice.c.c.g.f36000a     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            r5.append(r6)     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            java.lang.String r6 = "=1"
            r5.append(r6)     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            int r4 = r12.update(r4, r15, r5, r13)     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            long r13 = (long) r4
            java.lang.String r4 = "pushadvertiseinfo:  update into database"
        Lce:
            com.baidu.android.pushservice.j.m.a(r4, r0)     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L122
            goto Ldb
        Ld2:
            java.lang.String r4 = "PushShareInfo"
            long r13 = r12.insert(r4, r13, r15)     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L120
            java.lang.String r4 = "pushadvertiseinfo:  insert into database"
            goto Lce
        Ldb:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L122
            r4.<init>()     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L122
            java.lang.String r5 = "updatePushInfo pushinfo:  insert into database,  clientinfo = "
            r4.append(r5)     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L122
            org.json.JSONObject r1 = r18.a()     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L122
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L122
            r4.append(r1)     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L122
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L122
            com.baidu.android.pushservice.j.m.a(r1, r0)     // Catch: java.lang.Throwable -> L107 java.lang.Exception -> L122
            if (r11 == 0) goto L103
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L131
            if (r0 != 0) goto L103
            r11.close()     // Catch: java.lang.Throwable -> L131
        L103:
            r12.close()     // Catch: java.lang.Throwable -> L131
            goto L12e
        L107:
            r0 = move-exception
            goto L110
        L109:
            r0 = move-exception
            r11 = r13
            goto L110
        L10c:
            r11 = r13
            goto L120
        L10e:
            r0 = move-exception
            r13 = r11
        L110:
            if (r11 == 0) goto L11b
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L131
            if (r1 != 0) goto L11b
            r11.close()     // Catch: java.lang.Throwable -> L131
        L11b:
            r12.close()     // Catch: java.lang.Throwable -> L131
            throw r0     // Catch: java.lang.Throwable -> L131
        L11f:
            r13 = r11
        L120:
            r13 = -1
        L122:
            if (r11 == 0) goto L103
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L131
            if (r0 != 0) goto L103
            r11.close()     // Catch: java.lang.Throwable -> L131
            goto L103
        L12e:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L131
            monitor-exit(r2)
            return r13
        L131:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L131
            throw r0     // Catch: java.lang.Throwable -> L134
        L134:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L137:
            r14 = r0
            r15 = 65537(0x10001, float:9.1837E-41)
            r16 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r14.invokeLL(r15, r16, r17, r18)
            if (r0 == 0) goto L4
            long r1 = r0.longValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.c.a(android.content.Context, com.baidu.android.pushservice.c.b):long");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f35962b : invokeV.objValue;
    }

    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z)) == null) {
            synchronized (f35962b) {
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
                    cursor = a2.query("PushShareInfo", new String[]{g.f36003d.name(), g.f36004e.name()}, null, null, null, null, null);
                    try {
                        if (cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndex((z ? g.f36004e : g.f36003d).name()));
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

    public static synchronized void a(Context context, long j) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, context, j) == null) {
            synchronized (c.class) {
                synchronized (f35962b) {
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
                            contentValues.put(g.f36001b.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, g.f36000a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f35952a = j;
                    bVar.f35953b = 0L;
                    bVar.f35954c = null;
                    bVar.f35955d = null;
                    bVar.f35956e = null;
                    bVar.f35958g = null;
                    bVar.f35957f = null;
                    bVar.f35959h = null;
                    bVar.f35960i = null;
                    bVar.j = null;
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
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str) == null) {
            synchronized (c.class) {
                synchronized (f35962b) {
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
                            contentValues.put(g.f36005f.name(), str);
                            a2.update("PushShareInfo", contentValues, g.f36000a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f35952a = 0L;
                    bVar.f35953b = 0L;
                    bVar.f35954c = null;
                    bVar.f35955d = null;
                    bVar.f35956e = null;
                    bVar.f35958g = null;
                    bVar.f35957f = null;
                    bVar.f35959h = null;
                    bVar.f35960i = null;
                    bVar.j = null;
                    a(context, bVar);
                    if (query != null) {
                        query.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static void a(Context context, String str, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f35992a.name(), str);
                    contentValues.put(f.f35993b.name(), Integer.valueOf(i2));
                    contentValues.put(f.f35995d.name(), Long.valueOf(j));
                    contentValues.put(f.f35994c.name(), (Integer) 1);
                    if (a2.update("PushDataInfo", contentValues, f.f35992a.name() + " =? ", new String[]{String.valueOf(str)}) == 0) {
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

    public static void a(Context context, String str, int i2, long j, byte[] bArr, byte[] bArr2, long j2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j), bArr, bArr2, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.f35984b.name(), str);
                    contentValues.put(e.f35986d.name(), Long.valueOf(j));
                    contentValues.put(e.f35985c.name(), Integer.valueOf(i2));
                    if (bArr != null && bArr.length > 0) {
                        contentValues.put(e.f35989g.name(), BaiduAppSSOJni.a(context, str, bArr));
                        contentValues.put(e.f35988f.name(), bArr2);
                        contentValues.put(e.f35990h.name(), Long.valueOf(j2));
                    }
                    contentValues.put(e.f35987e.name(), Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(e.f35991i.name(), Integer.valueOf(i3));
                    contentValues.put(e.j.name(), Integer.valueOf(i4));
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
                synchronized (f35962b) {
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
                            contentValues.put(g.f36003d.name(), str);
                            if (!TextUtils.isEmpty(str2)) {
                                contentValues.put(g.f36004e.name(), str2);
                            }
                            a2.update("PushShareInfo", contentValues, g.f36000a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f35952a = 0L;
                    bVar.f35953b = 0L;
                    bVar.f35954c = str;
                    bVar.f35955d = str2;
                    bVar.f35956e = null;
                    bVar.f35958g = null;
                    bVar.f35957f = null;
                    bVar.f35959h = null;
                    bVar.f35960i = null;
                    bVar.j = null;
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
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f35996e.name(), str2);
                    if (l != null) {
                        contentValues.put(f.f35997f.name(), l);
                    }
                    a2.update("PushDataInfo", contentValues, f.f35992a.name() + " =? ", new String[]{String.valueOf(str)});
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
            synchronized (f35962b) {
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
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f35994c.name() + "=0 WHERE " + f.f35992a.name() + " NOT IN " + sb.toString());
                } catch (Exception unused) {
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, jSONArray) == null) {
            synchronized (f35962b) {
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
                                long j = jSONObject.getLong("event_time");
                                contentValues.put(b.f35972b.name(), jSONObject.toString());
                                contentValues.put(b.f35971a.name(), Long.valueOf(j));
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
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.j.name()}, e.j.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
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
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, fVar)) == null) {
            synchronized (c.class) {
                synchronized (f35962b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return false;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.f36010b.name(), fVar.f36066a);
                    contentValues.put(h.f36011c.name(), fVar.f36067b);
                    contentValues.put(h.f36012d.name(), fVar.f36068c);
                    contentValues.put(h.f36013e.name(), System.currentTimeMillis() + "");
                    Cursor cursor = null;
                    try {
                        j = a2.insert("PushVerifInfo", null, contentValues);
                        try {
                            cursor = a2.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                            if (cursor.moveToFirst() && cursor.getInt(0) > 200) {
                                a2.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{fVar.f36066a});
                            }
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                        } catch (Exception unused) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            if (j != -1) {
                            }
                            return r2;
                        }
                    } catch (Exception unused2) {
                        j = -1;
                    }
                    a2.close();
                    boolean z = j != -1;
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
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return 0;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f36002c.name()}, null, null, null, null, null);
                    r9 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(g.f36002c.name())) : 0;
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
                String[] strArr = {h.f36011c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f36010b.name());
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

    public static synchronized void b(Context context, long j) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65553, null, context, j) == null) {
            synchronized (c.class) {
                synchronized (f35962b) {
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
                            contentValues.put(g.f36002c.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, g.f36000a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f35952a = 0L;
                    bVar.f35953b = j;
                    bVar.f35954c = null;
                    bVar.f35955d = null;
                    bVar.f35956e = null;
                    bVar.f35958g = null;
                    bVar.f35957f = null;
                    bVar.f35959h = null;
                    bVar.f35960i = null;
                    bVar.j = null;
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
                synchronized (f35962b) {
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
                            a2.update("PushShareInfo", contentValues, g.f36000a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f35952a = 0L;
                    bVar.f35953b = 0L;
                    bVar.f35954c = null;
                    bVar.f35955d = null;
                    bVar.f35956e = null;
                    bVar.f35958g = null;
                    bVar.f35957f = null;
                    bVar.f35959h = null;
                    bVar.f35960i = str;
                    bVar.j = null;
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
            synchronized (f35962b) {
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
                    contentValues.put(f.f35998g.name(), (Integer) 0);
                    a2.update("PushDataInfo", contentValues, null, null);
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f35998g.name() + "=1 WHERE " + f.f35992a.name() + " IN " + sb.toString());
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
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                int i3 = -1;
                try {
                    cursor = a2.query("PushMsgInfos", null, e.j.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
                    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                        i3 = cursor.getInt(cursor.getColumnIndex(e.f35985c.name()));
                    }
                    if (i3 != l.f36603g.b() && i3 != l.f36599c.b() && i3 != l.f36598b.b()) {
                        if (i3 != l.j.b()) {
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
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f36005f.name()}, null, null, null, null, null);
                    try {
                        str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.f36005f.name())) : null;
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
                String[] strArr = {h.f36011c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f36011c.name());
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
                synchronized (f35962b) {
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
                            a2.update("PushShareInfo", contentValues, g.f36000a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f35952a = 0L;
                    bVar.f35953b = 0L;
                    bVar.f35954c = null;
                    bVar.f35955d = null;
                    bVar.f35956e = null;
                    bVar.f35958g = null;
                    bVar.f35957f = null;
                    bVar.f35959h = null;
                    bVar.f35960i = null;
                    bVar.j = str;
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
    public static boolean c(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65560, null, context, j)) == null) {
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.f35986d.name()}, e.f35986d.name() + " =? ", new String[]{String.valueOf(j)}, null, null, null);
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
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r10 = null;
                r10 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.k.name()}, null, null, null, null, null);
                    try {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.k.name())) : null;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            m.a("PushInfoDataBase*BBind*" + com.baidu.android.pushservice.g.a.a(e), context);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        a2.close();
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    a2.close();
                    throw th;
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
            synchronized (f35962b) {
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
                    cursor = a2.query("PushDataInfo", null, f.f35992a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(f.f35998g.name())) == 1) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.f35996e.name()));
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
            synchronized (f35962b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return false;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushDataInfo", null, f.f35992a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    int i2 = cursor.getInt(cursor.getColumnIndex(f.f35993b.name()));
                    String string = cursor.getString(cursor.getColumnIndex(f.f35996e.name()));
                    if (cursor.getInt(cursor.getColumnIndex(f.f35994c.name())) != 1) {
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
                    } else if (System.currentTimeMillis() - cursor.getLong(cursor.getColumnIndex(f.f35997f.name())) > cursor.getLong(cursor.getColumnIndex(f.f35995d.name())) * 1000) {
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
            synchronized (f35962b) {
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
            synchronized (f35962b) {
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
                    cursor = a2.query("PushDataInfo", null, f.f35992a.name() + " =? ", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.f35996e.name()));
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
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            JSONArray jSONArray = new JSONArray();
            synchronized (f35962b) {
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
                Cursor query = a2.query(false, "ClickMsgUploadInfo", null, null, null, null, null, b.f35971a.name() + " DESC ", String.valueOf(b2));
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            do {
                                String string = query.getString(query.getColumnIndex(b.f35972b.name()));
                                j = query.getLong(query.getColumnIndex(b.f35971a.name()));
                                jSONArray.put(new JSONObject(string));
                            } while (query.moveToNext());
                            if (a2.delete("ClickMsgUploadInfo", b.f35971a.name() + " >= " + String.valueOf(j), null) == 0) {
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
            synchronized (f35962b) {
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
            if (f35961a == null) {
                synchronized (f35962b) {
                    if (f35961a == null) {
                        File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                        SQLiteDatabase sQLiteDatabase = null;
                        if (Build.VERSION.SDK_INT >= 11) {
                            f35961a = new d(context, str, 8, new C1583c(null));
                        } else {
                            f35961a = new d(context, str, (SQLiteDatabase.CursorFactory) null, 8);
                        }
                        try {
                            SQLiteDatabase writableDatabase = f35961a.getWritableDatabase();
                            try {
                                writableDatabase.delete("PushMsgInfos", e.f35987e.name() + " < " + (System.currentTimeMillis() - 259200000), null);
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                }
                            } catch (Throwable unused) {
                                sQLiteDatabase = writableDatabase;
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                return f35961a;
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            return f35961a;
        }
        return (d) invokeL.objValue;
    }
}
