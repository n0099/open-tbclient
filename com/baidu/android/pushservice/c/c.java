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
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f2900a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f2901b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.c.c$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f2902a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f2903b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f2904c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f2905d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f2906e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f2907f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f2908g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ a[] f2909h;
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
            f2902a = new a("actionId", 0);
            f2903b = new a("actionName", 1);
            f2904c = new a(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f2905d = new a(PushClientConstants.TAG_PKG_NAME, 3);
            f2906e = new a(PushManager.APP_VERSION_CODE, 4);
            f2907f = new a(PushManager.APP_VERSION_NAME, 5);
            a aVar = new a("status", 6);
            f2908g = aVar;
            f2909h = new a[]{f2902a, f2903b, f2904c, f2905d, f2906e, f2907f, aVar};
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
    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f2910a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f2911b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ b[] f2912c;
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
            f2910a = new b("timeStamps", 0);
            b bVar = new b("clickData", 1);
            f2911b = bVar;
            f2912c = new b[]{f2910a, bVar};
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
    /* loaded from: classes.dex */
    public static class C0033c implements DatabaseErrorHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0033c() {
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

        public /* synthetic */ C0033c(AnonymousClass1 anonymousClass1) {
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

    /* loaded from: classes.dex */
    public static class d extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f2913a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f2914b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f2915c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2916d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2917e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f2918f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f2919g;

        /* renamed from: h  reason: collision with root package name */
        public static final String f2920h;

        /* renamed from: i  reason: collision with root package name */
        public static final String f2921i;
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
            f2913a = "CREATE TABLE PushShareInfo (" + g.f2939a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.f2940b.name() + " LONG NOT NULL DEFAULT ((0)), " + g.f2941c.name() + " INTEGER DEFAULT ((0)), " + g.f2942d.name() + " TEXT, " + g.f2943e.name() + " TEXT, " + g.f2944f.name() + " TEXT, " + g.f2945g.name() + " TEXT, " + g.f2946h.name() + " TEXT, " + g.f2947i.name() + " TEXT, " + g.j.name() + " TEXT, " + g.k.name() + " TEXT, " + g.l.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE PushVerifInfo (");
            sb.append(h.f2948a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(h.f2949b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f2950c.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f2951d.name());
            sb.append(" TEXT, ");
            sb.append(h.f2952e.name());
            sb.append(" TEXT);");
            f2914b = sb.toString();
            f2915c = "CREATE TABLE PushMsgInfos (" + e.f2922a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.f2923b.name() + "  TEXT, " + e.f2924c.name() + "  INTEGER NOT NULL, " + e.f2925d.name() + " LONG NOT NULL, " + e.f2927f.name() + " TEXT, " + e.f2928g.name() + "  TEXT, " + e.f2929h.name() + "  LONG, " + e.f2930i.name() + "  INTEGER, " + e.f2926e.name() + " LONG NOT NULL, " + e.j.name() + "  INTEGER);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE PushDataInfo (");
            sb2.append(f.f2931a.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(f.f2932b.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f2933c.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f2934d.name());
            sb2.append("  LONG NOT NULL, ");
            sb2.append(f.f2935e.name());
            sb2.append(" TEXT,");
            sb2.append(f.f2936f.name());
            sb2.append(" LONG,");
            sb2.append(f.f2937g.name());
            sb2.append(" INTEGER DEFAULT ((0)));");
            f2916d = sb2.toString();
            f2917e = "CREATE TABLE ClickMsgUploadInfo (" + b.f2910a.name() + " LONG NOT NULL," + b.f2911b.name() + " TEXT NOT NULL);";
            f2918f = "CREATE TABLE PushAppStatus (" + a.f2902a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.f2903b.name() + " TEXT NOT NULL, " + a.f2904c.name() + " LONG NOT NULL, " + a.f2905d.name() + " TEXT, " + a.f2906e.name() + " INTEGER, " + a.f2907f.name() + " TEXT, " + a.f2908g.name() + " INTEGER);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb3.append(g.f2943e.name());
            sb3.append(" TEXT");
            f2919g = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb4.append(g.f2944f.name());
            sb4.append(" TEXT");
            f2920h = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE PushMsgInfos ADD COLUMN ");
            sb5.append(e.j.name());
            sb5.append(" INTEGER");
            f2921i = sb5.toString();
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
                    sQLiteDatabase.execSQL(f2913a);
                    sQLiteDatabase.execSQL(f2914b);
                    sQLiteDatabase.execSQL(f2915c);
                    sQLiteDatabase.execSQL(f2918f);
                    sQLiteDatabase.execSQL(f2916d);
                    sQLiteDatabase.execSQL(f2917e);
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
                    sQLiteDatabase.execSQL(f2915c);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            sQLiteDatabase.execSQL(f2916d);
                            str3 = f2917e;
                            sQLiteDatabase.execSQL(str3);
                            str2 = f2920h;
                            sQLiteDatabase.execSQL(str2);
                            str = f2921i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 6) {
                            sQLiteDatabase.execSQL(f2916d);
                            str2 = f2917e;
                            sQLiteDatabase.execSQL(str2);
                            str = f2921i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 7) {
                            sQLiteDatabase.execSQL(f2916d);
                            str = f2917e;
                            sQLiteDatabase.execSQL(str);
                        } else {
                            return;
                        }
                    }
                    sQLiteDatabase.execSQL(f2916d);
                    sQLiteDatabase.execSQL(f2917e);
                    str3 = f2919g;
                    sQLiteDatabase.execSQL(str3);
                    str2 = f2920h;
                    sQLiteDatabase.execSQL(str2);
                    str = f2921i;
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.execSQL(f2918f);
                sQLiteDatabase.execSQL(f2916d);
                sQLiteDatabase.execSQL(f2917e);
                str3 = f2919g;
                sQLiteDatabase.execSQL(str3);
                str2 = f2920h;
                sQLiteDatabase.execSQL(str2);
                str = f2921i;
                sQLiteDatabase.execSQL(str);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f2922a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f2923b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f2924c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f2925d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f2926e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f2927f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f2928g;

        /* renamed from: h  reason: collision with root package name */
        public static final e f2929h;

        /* renamed from: i  reason: collision with root package name */
        public static final e f2930i;
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
            f2922a = new e("MsgInfoId", 0);
            f2923b = new e(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 1);
            f2924c = new e("msgType", 2);
            f2925d = new e("msgId", 3);
            f2926e = new e("arriveTime", 4);
            f2927f = new e("secureInfo", 5);
            f2928g = new e("msgBody", 6);
            f2929h = new e("expireTime", 7);
            f2930i = new e("ackRet", 8);
            e eVar = new e(MiPushMessage.KEY_NOTIFY_ID, 9);
            j = eVar;
            k = new e[]{f2922a, f2923b, f2924c, f2925d, f2926e, f2927f, f2928g, f2929h, f2930i, eVar};
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
    /* loaded from: classes.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f2931a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f2932b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f2933c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f2934d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f2935e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f2936f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f2937g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ f[] f2938h;
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
            f2931a = new f("dataKey", 0);
            f2932b = new f("dataSensitive", 1);
            f2933c = new f("canUpload", 2);
            f2934d = new f("timeInterval", 3);
            f2935e = new f("dataValue", 4);
            f2936f = new f("lastUpdateStamp", 5);
            f fVar = new f("bindCanUpload", 6);
            f2937g = fVar;
            f2938h = new f[]{f2931a, f2932b, f2933c, f2934d, f2935e, f2936f, fVar};
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
        public static final g f2939a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f2940b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f2941c;

        /* renamed from: d  reason: collision with root package name */
        public static final g f2942d;

        /* renamed from: e  reason: collision with root package name */
        public static final g f2943e;

        /* renamed from: f  reason: collision with root package name */
        public static final g f2944f;

        /* renamed from: g  reason: collision with root package name */
        public static final g f2945g;

        /* renamed from: h  reason: collision with root package name */
        public static final g f2946h;

        /* renamed from: i  reason: collision with root package name */
        public static final g f2947i;
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
            f2939a = new g("PushInfoId", 0);
            f2940b = new g("PushPriority", 1);
            f2941c = new g("PushVersion", 2);
            f2942d = new g("PushChannelID", 3);
            f2943e = new g("PushNewChannelID", 4);
            f2944f = new g("PushChannelToken", 5);
            f2945g = new g("PushCurPkgName", 6);
            f2946h = new g("PushWebAppBindInfo", 7);
            f2947i = new g("PushLightAppBindInfo", 8);
            j = new g("PushSDKClientBindInfo", 9);
            k = new g("PushClientsBindInfo", 10);
            g gVar = new g("PushSelfBindInfo", 11);
            l = gVar;
            m = new g[]{f2939a, f2940b, f2941c, f2942d, f2943e, f2944f, f2945g, f2946h, f2947i, j, k, gVar};
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
        public static final h f2948a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f2949b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f2950c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f2951d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f2952e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f2953f;
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
            f2948a = new h("verifId", 0);
            f2949b = new h("msgId", 1);
            f2950c = new h("md5Infos", 2);
            f2951d = new h(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 3);
            h hVar = new h("time", 4);
            f2952e = hVar;
            f2953f = new h[]{f2948a, f2949b, f2950c, f2951d, hVar};
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
        f2901b = new Object();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:39:0x010d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized long a(android.content.Context r17, com.baidu.android.pushservice.c.b r18) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.android.pushservice.c.c.$ic
            if (r0 != 0) goto L136
        L4:
            r0 = r17
            r1 = r18
            java.lang.Class<com.baidu.android.pushservice.c.c> r2 = com.baidu.android.pushservice.c.c.class
            monitor-enter(r2)
            java.lang.Object r3 = com.baidu.android.pushservice.c.c.f2901b     // Catch: java.lang.Throwable -> L133
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L133
            android.database.sqlite.SQLiteDatabase r12 = a(r17)     // Catch: java.lang.Throwable -> L130
            r13 = -1
            if (r12 != 0) goto L19
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L130
            monitor-exit(r2)
            return r13
        L19:
            android.content.ContentValues r15 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L130
            r15.<init>()     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f2940b     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            long r5 = r1.f2891a     // Catch: java.lang.Throwable -> L130
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f2941c     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            long r5 = r1.f2892b     // Catch: java.lang.Throwable -> L130
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f2942d     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f2893c     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f2943e     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f2894d     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f2945g     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f2895e     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f2947i     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f2897g     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f2946h     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f2896f     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.j     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f2898h     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.k     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f2899i     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.l     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.j     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
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
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L108 java.lang.Exception -> L10b
            if (r11 == 0) goto Ld2
            int r4 = r11.getCount()     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            if (r4 == 0) goto Ld2
            java.lang.String r4 = "PushShareInfo"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            r5.<init>()     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            com.baidu.android.pushservice.c.c$g r6 = com.baidu.android.pushservice.c.c.g.f2939a     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            r5.append(r6)     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            java.lang.String r6 = "=1"
            r5.append(r6)     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            int r4 = r12.update(r4, r15, r5, r13)     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            long r13 = (long) r4
            java.lang.String r4 = "pushadvertiseinfo:  update into database"
        Lce:
            com.baidu.android.pushservice.j.m.a(r4, r0)     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L121
            goto Ldb
        Ld2:
            java.lang.String r4 = "PushShareInfo"
            long r13 = r12.insert(r4, r13, r15)     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
            java.lang.String r4 = "pushadvertiseinfo:  insert into database"
            goto Lce
        Ldb:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L121
            r4.<init>()     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L121
            java.lang.String r5 = "updatePushInfo pushinfo:  insert into database,  clientinfo = "
            r4.append(r5)     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L121
            org.json.JSONObject r1 = r18.a()     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L121
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L121
            r4.append(r1)     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L121
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L121
            com.baidu.android.pushservice.j.m.a(r1, r0)     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L121
            if (r11 == 0) goto L102
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L130
            if (r0 != 0) goto L102
            r11.close()     // Catch: java.lang.Throwable -> L130
        L102:
            r12.close()     // Catch: java.lang.Throwable -> L130
            goto L12d
        L106:
            r0 = move-exception
            goto L10f
        L108:
            r0 = move-exception
            r11 = r13
            goto L10f
        L10b:
            r11 = r13
            goto L11f
        L10d:
            r0 = move-exception
            r13 = r11
        L10f:
            if (r11 == 0) goto L11a
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L130
            if (r1 != 0) goto L11a
            r11.close()     // Catch: java.lang.Throwable -> L130
        L11a:
            r12.close()     // Catch: java.lang.Throwable -> L130
            throw r0     // Catch: java.lang.Throwable -> L130
        L11e:
            r13 = r11
        L11f:
            r13 = -1
        L121:
            if (r11 == 0) goto L102
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L130
            if (r0 != 0) goto L102
            r11.close()     // Catch: java.lang.Throwable -> L130
            goto L102
        L12d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L130
            monitor-exit(r2)
            return r13
        L130:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L130
            throw r0     // Catch: java.lang.Throwable -> L133
        L133:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L136:
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f2901b : invokeV.objValue;
    }

    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65540, null, context, z)) == null) {
            synchronized (f2901b) {
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
                    cursor = a2.query("PushShareInfo", new String[]{g.f2942d.name(), g.f2943e.name()}, null, null, null, null, null);
                    try {
                        if (cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndex((z ? g.f2943e : g.f2942d).name()));
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
                synchronized (f2901b) {
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
                            contentValues.put(g.f2940b.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, g.f2939a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f2891a = j;
                    bVar.f2892b = 0L;
                    bVar.f2893c = null;
                    bVar.f2894d = null;
                    bVar.f2895e = null;
                    bVar.f2897g = null;
                    bVar.f2896f = null;
                    bVar.f2898h = null;
                    bVar.f2899i = null;
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
                synchronized (f2901b) {
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
                            contentValues.put(g.f2944f.name(), str);
                            a2.update("PushShareInfo", contentValues, g.f2939a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f2891a = 0L;
                    bVar.f2892b = 0L;
                    bVar.f2893c = null;
                    bVar.f2894d = null;
                    bVar.f2895e = null;
                    bVar.f2897g = null;
                    bVar.f2896f = null;
                    bVar.f2898h = null;
                    bVar.f2899i = null;
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
            synchronized (f2901b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f2931a.name(), str);
                    contentValues.put(f.f2932b.name(), Integer.valueOf(i2));
                    contentValues.put(f.f2934d.name(), Long.valueOf(j));
                    contentValues.put(f.f2933c.name(), (Integer) 1);
                    if (a2.update("PushDataInfo", contentValues, f.f2931a.name() + " =? ", new String[]{String.valueOf(str)}) == 0) {
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
            synchronized (f2901b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.f2923b.name(), str);
                    contentValues.put(e.f2925d.name(), Long.valueOf(j));
                    contentValues.put(e.f2924c.name(), Integer.valueOf(i2));
                    if (bArr != null && bArr.length > 0) {
                        contentValues.put(e.f2928g.name(), BaiduAppSSOJni.a(context, str, bArr));
                        contentValues.put(e.f2927f.name(), bArr2);
                        contentValues.put(e.f2929h.name(), Long.valueOf(j2));
                    }
                    contentValues.put(e.f2926e.name(), Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(e.f2930i.name(), Integer.valueOf(i3));
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
                synchronized (f2901b) {
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
                            contentValues.put(g.f2942d.name(), str);
                            if (!TextUtils.isEmpty(str2)) {
                                contentValues.put(g.f2943e.name(), str2);
                            }
                            a2.update("PushShareInfo", contentValues, g.f2939a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f2891a = 0L;
                    bVar.f2892b = 0L;
                    bVar.f2893c = str;
                    bVar.f2894d = str2;
                    bVar.f2895e = null;
                    bVar.f2897g = null;
                    bVar.f2896f = null;
                    bVar.f2898h = null;
                    bVar.f2899i = null;
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
            synchronized (f2901b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f2935e.name(), str2);
                    if (l != null) {
                        contentValues.put(f.f2936f.name(), l);
                    }
                    a2.update("PushDataInfo", contentValues, f.f2931a.name() + " =? ", new String[]{String.valueOf(str)});
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
            synchronized (f2901b) {
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
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f2933c.name() + "=0 WHERE " + f.f2931a.name() + " NOT IN " + sb.toString());
                } catch (Exception unused) {
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, jSONArray) == null) {
            synchronized (f2901b) {
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
                                contentValues.put(b.f2911b.name(), jSONObject.toString());
                                contentValues.put(b.f2910a.name(), Long.valueOf(j));
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
            synchronized (f2901b) {
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
                synchronized (f2901b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return false;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.f2949b.name(), fVar.f3005a);
                    contentValues.put(h.f2950c.name(), fVar.f3006b);
                    contentValues.put(h.f2951d.name(), fVar.f3007c);
                    contentValues.put(h.f2952e.name(), System.currentTimeMillis() + "");
                    Cursor cursor = null;
                    try {
                        j = a2.insert("PushVerifInfo", null, contentValues);
                        try {
                            cursor = a2.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                            if (cursor.moveToFirst() && cursor.getInt(0) > 200) {
                                a2.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{fVar.f3005a});
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
            synchronized (f2901b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return 0;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f2941c.name()}, null, null, null, null, null);
                    r9 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(g.f2941c.name())) : 0;
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
                String[] strArr = {h.f2950c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f2949b.name());
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
                synchronized (f2901b) {
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
                            contentValues.put(g.f2941c.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, g.f2939a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f2891a = 0L;
                    bVar.f2892b = j;
                    bVar.f2893c = null;
                    bVar.f2894d = null;
                    bVar.f2895e = null;
                    bVar.f2897g = null;
                    bVar.f2896f = null;
                    bVar.f2898h = null;
                    bVar.f2899i = null;
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
                synchronized (f2901b) {
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
                            a2.update("PushShareInfo", contentValues, g.f2939a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f2891a = 0L;
                    bVar.f2892b = 0L;
                    bVar.f2893c = null;
                    bVar.f2894d = null;
                    bVar.f2895e = null;
                    bVar.f2897g = null;
                    bVar.f2896f = null;
                    bVar.f2898h = null;
                    bVar.f2899i = str;
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
            synchronized (f2901b) {
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
                    contentValues.put(f.f2937g.name(), (Integer) 0);
                    a2.update("PushDataInfo", contentValues, null, null);
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f2937g.name() + "=1 WHERE " + f.f2931a.name() + " IN " + sb.toString());
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
            synchronized (f2901b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                int i3 = -1;
                try {
                    cursor = a2.query("PushMsgInfos", null, e.j.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
                    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                        i3 = cursor.getInt(cursor.getColumnIndex(e.f2924c.name()));
                    }
                    if (i3 != l.f3542g.b() && i3 != l.f3538c.b() && i3 != l.f3537b.b()) {
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
            synchronized (f2901b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f2944f.name()}, null, null, null, null, null);
                    try {
                        str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.f2944f.name())) : null;
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
                String[] strArr = {h.f2950c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f2950c.name());
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
                synchronized (f2901b) {
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
                            a2.update("PushShareInfo", contentValues, g.f2939a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f2891a = 0L;
                    bVar.f2892b = 0L;
                    bVar.f2893c = null;
                    bVar.f2894d = null;
                    bVar.f2895e = null;
                    bVar.f2897g = null;
                    bVar.f2896f = null;
                    bVar.f2898h = null;
                    bVar.f2899i = null;
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
            synchronized (f2901b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.f2925d.name()}, e.f2925d.name() + " =? ", new String[]{String.valueOf(j)}, null, null, null);
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
            synchronized (f2901b) {
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
            synchronized (f2901b) {
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
                    cursor = a2.query("PushDataInfo", null, f.f2931a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(f.f2937g.name())) == 1) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.f2935e.name()));
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
            synchronized (f2901b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return false;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushDataInfo", null, f.f2931a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    int i2 = cursor.getInt(cursor.getColumnIndex(f.f2932b.name()));
                    String string = cursor.getString(cursor.getColumnIndex(f.f2935e.name()));
                    if (cursor.getInt(cursor.getColumnIndex(f.f2933c.name())) != 1) {
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
                    } else if (System.currentTimeMillis() - cursor.getLong(cursor.getColumnIndex(f.f2936f.name())) > cursor.getLong(cursor.getColumnIndex(f.f2934d.name())) * 1000) {
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
            synchronized (f2901b) {
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
            synchronized (f2901b) {
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
                    cursor = a2.query("PushDataInfo", null, f.f2931a.name() + " =? ", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.f2935e.name()));
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
            synchronized (f2901b) {
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
                Cursor query = a2.query(false, "ClickMsgUploadInfo", null, null, null, null, null, b.f2910a.name() + " DESC ", String.valueOf(b2));
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            do {
                                String string = query.getString(query.getColumnIndex(b.f2911b.name()));
                                j = query.getLong(query.getColumnIndex(b.f2910a.name()));
                                jSONArray.put(new JSONObject(string));
                            } while (query.moveToNext());
                            if (a2.delete("ClickMsgUploadInfo", b.f2910a.name() + " >= " + String.valueOf(j), null) == 0) {
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
            synchronized (f2901b) {
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
            if (f2900a == null) {
                synchronized (f2901b) {
                    if (f2900a == null) {
                        File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                        SQLiteDatabase sQLiteDatabase = null;
                        if (Build.VERSION.SDK_INT >= 11) {
                            f2900a = new d(context, str, 8, new C0033c(null));
                        } else {
                            f2900a = new d(context, str, (SQLiteDatabase.CursorFactory) null, 8);
                        }
                        try {
                            SQLiteDatabase writableDatabase = f2900a.getWritableDatabase();
                            try {
                                writableDatabase.delete("PushMsgInfos", e.f2926e.name() + " < " + (System.currentTimeMillis() - 259200000), null);
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                }
                            } catch (Throwable unused) {
                                sQLiteDatabase = writableDatabase;
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                return f2900a;
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            return f2900a;
        }
        return (d) invokeL.objValue;
    }
}
