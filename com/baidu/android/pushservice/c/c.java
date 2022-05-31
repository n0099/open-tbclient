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
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d a;
    public static final Object b;
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
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final /* synthetic */ a[] h;
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
            b = new a("actionName", 1);
            c = new a(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            d = new a("pkgName", 3);
            e = new a(PushManager.APP_VERSION_CODE, 4);
            f = new a(PushManager.APP_VERSION_NAME, 5);
            a aVar = new a("status", 6);
            g = aVar;
            h = new a[]{a, b, c, d, e, f, aVar};
        }

        public a(String str, int i) {
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final b b;
        public static final /* synthetic */ b[] c;
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
            b = bVar;
            c = new b[]{a, bVar};
        }

        public b(String str, int i) {
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
    }

    /* renamed from: com.baidu.android.pushservice.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016c implements DatabaseErrorHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0016c() {
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

        public /* synthetic */ C0016c(AnonymousClass1 anonymousClass1) {
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
        public static final String a;
        public static final String b;
        public static final String c;
        public static final String d;
        public static final String e;
        public static final String f;
        public static final String g;
        public static final String h;
        public static final String i;
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
            a = "CREATE TABLE PushShareInfo (" + g.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.b.name() + " LONG NOT NULL DEFAULT ((0)), " + g.c.name() + " INTEGER DEFAULT ((0)), " + g.d.name() + " TEXT, " + g.e.name() + " TEXT, " + g.f.name() + " TEXT, " + g.g.name() + " TEXT, " + g.h.name() + " TEXT, " + g.i.name() + " TEXT, " + g.j.name() + " TEXT, " + g.k.name() + " TEXT, " + g.l.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE PushVerifInfo (");
            sb.append(h.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(h.b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.c.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.d.name());
            sb.append(" TEXT, ");
            sb.append(h.e.name());
            sb.append(" TEXT);");
            b = sb.toString();
            c = "CREATE TABLE PushMsgInfos (" + e.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.b.name() + "  TEXT, " + e.c.name() + "  INTEGER NOT NULL, " + e.d.name() + " LONG NOT NULL, " + e.f.name() + " TEXT, " + e.g.name() + "  TEXT, " + e.h.name() + "  LONG, " + e.i.name() + "  INTEGER, " + e.e.name() + " LONG NOT NULL, " + e.j.name() + "  INTEGER);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE PushDataInfo (");
            sb2.append(f.a.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(f.b.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.c.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.d.name());
            sb2.append("  LONG NOT NULL, ");
            sb2.append(f.e.name());
            sb2.append(" TEXT,");
            sb2.append(f.f.name());
            sb2.append(" LONG,");
            sb2.append(f.g.name());
            sb2.append(" INTEGER DEFAULT ((0)));");
            d = sb2.toString();
            e = "CREATE TABLE ClickMsgUploadInfo (" + b.a.name() + " LONG NOT NULL," + b.b.name() + " TEXT NOT NULL);";
            f = "CREATE TABLE PushAppStatus (" + a.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.b.name() + " TEXT NOT NULL, " + a.c.name() + " LONG NOT NULL, " + a.d.name() + " TEXT, " + a.e.name() + " INTEGER, " + a.f.name() + " TEXT, " + a.g.name() + " INTEGER);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb3.append(g.e.name());
            sb3.append(" TEXT");
            g = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb4.append(g.f.name());
            sb4.append(" TEXT");
            h = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE PushMsgInfos ADD COLUMN ");
            sb5.append(e.j.name());
            sb5.append(" INTEGER");
            i = sb5.toString();
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
                    sQLiteDatabase.execSQL(b);
                    sQLiteDatabase.execSQL(c);
                    sQLiteDatabase.execSQL(f);
                    sQLiteDatabase.execSQL(d);
                    sQLiteDatabase.execSQL(e);
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
                    sQLiteDatabase.execSQL(c);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            sQLiteDatabase.execSQL(d);
                            str3 = e;
                            sQLiteDatabase.execSQL(str3);
                            str2 = h;
                            sQLiteDatabase.execSQL(str2);
                            str = i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 6) {
                            sQLiteDatabase.execSQL(d);
                            str2 = e;
                            sQLiteDatabase.execSQL(str2);
                            str = i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 7) {
                            sQLiteDatabase.execSQL(d);
                            str = e;
                            sQLiteDatabase.execSQL(str);
                        } else {
                            return;
                        }
                    }
                    sQLiteDatabase.execSQL(d);
                    sQLiteDatabase.execSQL(e);
                    str3 = g;
                    sQLiteDatabase.execSQL(str3);
                    str2 = h;
                    sQLiteDatabase.execSQL(str2);
                    str = i;
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.execSQL(f);
                sQLiteDatabase.execSQL(d);
                sQLiteDatabase.execSQL(e);
                str3 = g;
                sQLiteDatabase.execSQL(str3);
                str2 = h;
                sQLiteDatabase.execSQL(str2);
                str = i;
                sQLiteDatabase.execSQL(str);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;
        public static final e b;
        public static final e c;
        public static final e d;
        public static final e e;
        public static final e f;
        public static final e g;
        public static final e h;
        public static final e i;
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
            a = new e("MsgInfoId", 0);
            b = new e(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 1);
            c = new e("msgType", 2);
            d = new e("msgId", 3);
            e = new e("arriveTime", 4);
            f = new e("secureInfo", 5);
            g = new e("msgBody", 6);
            h = new e("expireTime", 7);
            i = new e("ackRet", 8);
            e eVar = new e(MiPushMessage.KEY_NOTIFY_ID, 9);
            j = eVar;
            k = new e[]{a, b, c, d, e, f, g, h, i, eVar};
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
        public static final f a;
        public static final f b;
        public static final f c;
        public static final f d;
        public static final f e;
        public static final f f;
        public static final f g;
        public static final /* synthetic */ f[] h;
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
            b = new f("dataSensitive", 1);
            c = new f("canUpload", 2);
            d = new f("timeInterval", 3);
            e = new f("dataValue", 4);
            f = new f("lastUpdateStamp", 5);
            f fVar = new f("bindCanUpload", 6);
            g = fVar;
            h = new f[]{a, b, c, d, e, f, fVar};
        }

        public f(String str, int i) {
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
            b = new g("PushPriority", 1);
            c = new g("PushVersion", 2);
            d = new g("PushChannelID", 3);
            e = new g("PushNewChannelID", 4);
            f = new g("PushChannelToken", 5);
            g = new g("PushCurPkgName", 6);
            h = new g("PushWebAppBindInfo", 7);
            i = new g("PushLightAppBindInfo", 8);
            j = new g("PushSDKClientBindInfo", 9);
            k = new g("PushClientsBindInfo", 10);
            g gVar = new g("PushSelfBindInfo", 11);
            l = gVar;
            m = new g[]{a, b, c, d, e, f, g, h, i, j, k, gVar};
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
        public static final h a;
        public static final h b;
        public static final h c;
        public static final h d;
        public static final h e;
        public static final /* synthetic */ h[] f;
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
            b = new h("msgId", 1);
            c = new h("md5Infos", 2);
            d = new h(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 3);
            h hVar = new h("time", 4);
            e = hVar;
            f = new h[]{a, b, c, d, hVar};
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
        b = new Object();
    }

    public static synchronized long a(Context context, com.baidu.android.pushservice.c.b bVar) {
        InterceptResult invokeLL;
        Cursor cursor;
        Throwable th;
        long update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, bVar)) == null) {
            synchronized (c.class) {
                synchronized (b) {
                    SQLiteDatabase a2 = a(context);
                    long j = -1;
                    if (a2 == null) {
                        return -1L;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(g.b.name(), Long.valueOf(bVar.a));
                    contentValues.put(g.c.name(), Long.valueOf(bVar.b));
                    contentValues.put(g.d.name(), bVar.c);
                    contentValues.put(g.e.name(), bVar.d);
                    contentValues.put(g.g.name(), bVar.e);
                    contentValues.put(g.i.name(), bVar.g);
                    contentValues.put(g.h.name(), bVar.f);
                    contentValues.put(g.j.name(), bVar.h);
                    contentValues.put(g.k.name(), bVar.i);
                    contentValues.put(g.l.name(), bVar.j);
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
                            return j;
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
                            j = update;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return j;
                        }
                    }
                    update = a2.insert("PushShareInfo", null, contentValues);
                    j = update;
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                    return j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : invokeV.objValue;
    }

    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z)) == null) {
            synchronized (b) {
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
                    cursor = a2.query("PushShareInfo", new String[]{g.d.name(), g.e.name()}, null, null, null, null, null);
                    try {
                        if (cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndex((z ? g.e : g.d).name()));
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
        if (interceptable == null || interceptable.invokeLJ(65541, null, context, j) == null) {
            synchronized (c.class) {
                synchronized (b) {
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
                            contentValues.put(g.b.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = j;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
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
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            synchronized (c.class) {
                synchronized (b) {
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
                            contentValues.put(g.f.name(), str);
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
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

    public static void a(Context context, String str, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.a.name(), str);
                    contentValues.put(f.b.name(), Integer.valueOf(i));
                    contentValues.put(f.d.name(), Long.valueOf(j));
                    contentValues.put(f.c.name(), (Integer) 1);
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

    public static void a(Context context, String str, int i, long j, byte[] bArr, byte[] bArr2, long j2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, Integer.valueOf(i), Long.valueOf(j), bArr, bArr2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.b.name(), str);
                    contentValues.put(e.d.name(), Long.valueOf(j));
                    contentValues.put(e.c.name(), Integer.valueOf(i));
                    if (bArr != null && bArr.length > 0) {
                        contentValues.put(e.g.name(), BaiduAppSSOJni.a(context, str, bArr));
                        contentValues.put(e.f.name(), bArr2);
                        contentValues.put(e.h.name(), Long.valueOf(j2));
                    }
                    contentValues.put(e.e.name(), Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(e.i.name(), Integer.valueOf(i2));
                    contentValues.put(e.j.name(), Integer.valueOf(i3));
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
                synchronized (b) {
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
                            contentValues.put(g.d.name(), str);
                            if (!TextUtils.isEmpty(str2)) {
                                contentValues.put(g.e.name(), str2);
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
                    bVar.b = 0L;
                    bVar.c = str;
                    bVar.d = str2;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
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
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.e.name(), str2);
                    if (l != null) {
                        contentValues.put(f.f.name(), l);
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
            synchronized (b) {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("'");
                    sb.append(arrayList.get(i));
                    sb.append("'");
                    if (i < arrayList.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    a2.execSQL("UPDATE PushDataInfo SET " + f.c.name() + "=0 WHERE " + f.a.name() + " NOT IN " + sb.toString());
                } catch (Exception unused) {
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, jSONArray) == null) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                if (jSONArray != null) {
                    try {
                        if (jSONArray.length() > 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                ContentValues contentValues = new ContentValues();
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                long j = jSONObject.getLong("event_time");
                                contentValues.put(b.b.name(), jSONObject.toString());
                                contentValues.put(b.a.name(), Long.valueOf(j));
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
    public static boolean a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, context, i)) == null) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.j.name()}, e.j.name() + "=?", new String[]{String.valueOf(i)}, null, null, null);
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
                synchronized (b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return false;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.b.name(), fVar.a);
                    contentValues.put(h.c.name(), fVar.b);
                    contentValues.put(h.d.name(), fVar.c);
                    contentValues.put(h.e.name(), System.currentTimeMillis() + "");
                    Cursor cursor = null;
                    try {
                        j = a2.insert("PushVerifInfo", null, contentValues);
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
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return 0;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.c.name()}, null, null, null, null, null);
                    r9 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(g.c.name())) : 0;
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
                String[] strArr = {h.c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.b.name());
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
                synchronized (b) {
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
                            contentValues.put(g.c.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.b = j;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
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
                synchronized (b) {
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
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = str;
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
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i = 0; i < jSONArray.length(); i++) {
                    sb.append("'");
                    try {
                        obj = jSONArray.get(i).toString();
                    } catch (JSONException unused) {
                    }
                    sb.append(obj);
                    sb.append("'");
                    if (i < jSONArray.length() - 1) {
                        sb.append(",");
                    }
                }
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.g.name(), (Integer) 0);
                    a2.update("PushDataInfo", contentValues, null, null);
                    a2.execSQL("UPDATE PushDataInfo SET " + f.g.name() + "=1 WHERE " + f.a.name() + " IN " + sb.toString());
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
    public static boolean b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, context, i)) == null) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                int i2 = -1;
                try {
                    cursor = a2.query("PushMsgInfos", null, e.j.name() + "=?", new String[]{String.valueOf(i)}, null, null, null);
                    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                        i2 = cursor.getInt(cursor.getColumnIndex(e.c.name()));
                    }
                    if (i2 != k.g.b() && i2 != k.c.b() && i2 != k.b.b()) {
                        if (i2 != k.i.b()) {
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
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f.name()}, null, null, null, null, null);
                    try {
                        str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.f.name())) : null;
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
                String[] strArr = {h.c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.c.name());
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
                synchronized (b) {
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
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
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
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.d.name()}, e.d.name() + " =? ", new String[]{String.valueOf(j)}, null, null, null);
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
            synchronized (b) {
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
            synchronized (b) {
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
                            if (cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(f.g.name())) == 1) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.e.name()));
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
            synchronized (b) {
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
                    int i = cursor.getInt(cursor.getColumnIndex(f.b.name()));
                    String string = cursor.getString(cursor.getColumnIndex(f.e.name()));
                    if (cursor.getInt(cursor.getColumnIndex(f.c.name())) != 1) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return false;
                    } else if (i == 1 && str2.equals(string)) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return false;
                    } else if (System.currentTimeMillis() - cursor.getLong(cursor.getColumnIndex(f.f.name())) > cursor.getLong(cursor.getColumnIndex(f.d.name())) * 1000) {
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
            synchronized (b) {
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
            synchronized (b) {
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
                                str2 = cursor.getString(cursor.getColumnIndex(f.e.name()));
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
            synchronized (b) {
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
                                String string = query.getString(query.getColumnIndex(b.b.name()));
                                j = query.getLong(query.getColumnIndex(b.a.name()));
                                jSONArray.put(new JSONObject(string));
                            } while (query.moveToNext());
                            if (a2.delete("ClickMsgUploadInfo", b.a.name() + " >= " + String.valueOf(j), null) == 0) {
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
            synchronized (b) {
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
                synchronized (b) {
                    if (a == null) {
                        File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                        SQLiteDatabase sQLiteDatabase = null;
                        if (Build.VERSION.SDK_INT >= 11) {
                            a = new d(context, str, 8, new C0016c(null));
                        } else {
                            a = new d(context, str, (SQLiteDatabase.CursorFactory) null, 8);
                        }
                        try {
                            SQLiteDatabase writableDatabase = a.getWritableDatabase();
                            try {
                                writableDatabase.delete("PushMsgInfos", e.e.name() + " < " + (System.currentTimeMillis() - 259200000), null);
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
