package com.baidu.android.pushservice.m;

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
import com.baidu.android.pushservice.database.PushConfigData;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.message.LocalPushMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.w.m.l;
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
import com.heytap.mcssdk.PushService;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.net.RFC1522Codec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final b g;
        public static final /* synthetic */ b[] h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846280163, "Lcom/baidu/android/pushservice/m/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846280163, "Lcom/baidu/android/pushservice/m/d$b;");
                    return;
                }
            }
            a = new b("actionId", 0);
            b = new b("actionName", 1);
            c = new b(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            d = new b("pkgName", 3);
            e = new b(PushService.APP_VERSION_CODE, 4);
            f = new b(PushService.APP_VERSION_NAME, 5);
            b bVar = new b("status", 6);
            g = bVar;
            h = new b[]{a, b, c, d, e, f, bVar};
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

        public static b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (b) Enum.valueOf(b.class, str) : (b) invokeL.objValue;
        }

        public static b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (b[]) h.clone() : (b[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public static final c b;
        public static final /* synthetic */ c[] c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846280132, "Lcom/baidu/android/pushservice/m/d$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846280132, "Lcom/baidu/android/pushservice/m/d$c;");
                    return;
                }
            }
            a = new c("timeStamps", 0);
            c cVar = new c("clickData", 1);
            b = cVar;
            c = new c[]{a, cVar};
        }

        public c(String str, int i) {
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

        public static c valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
        }

        public static c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) c.clone() : (c[]) invokeV.objValue;
        }
    }

    /* renamed from: com.baidu.android.pushservice.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027d implements DatabaseErrorHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0027d() {
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

        public /* synthetic */ C0027d(a aVar) {
            this();
        }

        @TargetApi(16)
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
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
        public static final String a;
        public static final String b;
        public static final String c;
        public static final String d;
        public static final String e;
        public static final String f;
        public static final String g;
        public static final String h;
        public static final String i;
        public static final String j;
        public static final String k;
        public static final String l;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846280070, "Lcom/baidu/android/pushservice/m/d$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846280070, "Lcom/baidu/android/pushservice/m/d$e;");
                    return;
                }
            }
            a = "CREATE TABLE PushShareInfo (" + j.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + j.b.name() + " LONG NOT NULL DEFAULT ((0)), " + j.c.name() + " INTEGER DEFAULT ((0)), " + j.d.name() + " TEXT, " + j.e.name() + " TEXT, " + j.f.name() + " TEXT, " + j.g.name() + " TEXT, " + j.h.name() + " TEXT, " + j.i.name() + " TEXT, " + j.j.name() + " TEXT, " + j.k.name() + " TEXT, " + j.l.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE PushVerifInfo (");
            sb.append(k.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(k.b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(k.c.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(k.d.name());
            sb.append(" TEXT, ");
            sb.append(k.e.name());
            sb.append(" TEXT);");
            b = sb.toString();
            c = "CREATE TABLE PushMsgInfos (" + g.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.b.name() + "  TEXT, " + g.c.name() + "  INTEGER NOT NULL, " + g.d.name() + " LONG NOT NULL, " + g.f.name() + " TEXT, " + g.g.name() + "  TEXT, " + g.h.name() + "  LONG, " + g.i.name() + "  INTEGER, " + g.e.name() + " LONG NOT NULL, " + g.j.name() + "  INTEGER);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE PushDataInfo (");
            sb2.append(i.a.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(i.b.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(i.c.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(i.d.name());
            sb2.append("  LONG NOT NULL, ");
            sb2.append(i.e.name());
            sb2.append(" TEXT,");
            sb2.append(i.f.name());
            sb2.append(" LONG,");
            sb2.append(i.g.name());
            sb2.append(" INTEGER DEFAULT ((0)));");
            d = sb2.toString();
            e = "CREATE TABLE ClickMsgUploadInfo (" + c.a.name() + " LONG NOT NULL," + c.b.name() + " TEXT NOT NULL);";
            f = "CREATE TABLE PushAppStatus (" + b.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.b.name() + " TEXT NOT NULL, " + b.c.name() + " LONG NOT NULL, " + b.d.name() + " TEXT, " + b.e.name() + " INTEGER, " + b.f.name() + " TEXT, " + b.g.name() + " INTEGER);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb3.append(j.e.name());
            sb3.append(" TEXT");
            g = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb4.append(j.f.name());
            sb4.append(" TEXT");
            h = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE PushMsgInfos ADD COLUMN ");
            sb5.append(g.j.name());
            sb5.append(" INTEGER");
            i = sb5.toString();
            j = "CREATE TABLE LocalPushInfo (" + f.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.c.name() + " TEXT NOT NULL, " + f.b.name() + " TEXT NOT NULL, " + f.d.name() + " LONG NOT NULL DEFAULT ((0)), " + f.e.name() + " INTEGER, " + f.f.name() + " LONG NOT NULL DEFAULT ((0)), " + f.g.name() + " TEXT NOT NULL, " + f.h.name() + " TEXT NOT NULL, " + f.i.name() + " LONG NOT NULL DEFAULT ((0)), " + f.j.name() + " TEXT NOT NULL, " + f.k.name() + " BLOB);";
            StringBuilder sb6 = new StringBuilder();
            sb6.append("CREATE TABLE PushConfig (");
            sb6.append(h.a.name());
            sb6.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb6.append(h.b.name());
            sb6.append(" TEXT NOT NULL, ");
            sb6.append(h.c.name());
            sb6.append(" INTEGER DEFAULT ((1)), ");
            sb6.append(h.d.name());
            sb6.append(" INTEGER DEFAULT ((1800)), ");
            sb6.append(h.e.name());
            sb6.append(" INTEGER DEFAULT ((20)), ");
            sb6.append(h.f.name());
            sb6.append(" INTEGER DEFAULT ((0)), ");
            sb6.append(h.g.name());
            sb6.append(" LONG );");
            k = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("ALTER TABLE PushConfig ADD COLUMN ");
            sb7.append(h.g.name());
            sb7.append(" LONG ");
            l = sb7.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, String str, int i2, DatabaseErrorHandler databaseErrorHandler) {
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
        public e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
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

        public final void a(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(a);
                    sQLiteDatabase.execSQL(b);
                    sQLiteDatabase.execSQL(c);
                    sQLiteDatabase.execSQL(f);
                    sQLiteDatabase.execSQL(d);
                    sQLiteDatabase.execSQL(e);
                    sQLiteDatabase.execSQL(j);
                    sQLiteDatabase.execSQL(k);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i2, i3) == null) {
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
                            str4 = e;
                            sQLiteDatabase.execSQL(str4);
                            str3 = h;
                            sQLiteDatabase.execSQL(str3);
                            str2 = i;
                            sQLiteDatabase.execSQL(str2);
                            sQLiteDatabase.execSQL(j);
                            str = k;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 6) {
                            sQLiteDatabase.execSQL(d);
                            str3 = e;
                            sQLiteDatabase.execSQL(str3);
                            str2 = i;
                            sQLiteDatabase.execSQL(str2);
                            sQLiteDatabase.execSQL(j);
                            str = k;
                            sQLiteDatabase.execSQL(str);
                        } else {
                            if (i2 != 7) {
                                if (i2 != 8) {
                                    if (i2 != 9) {
                                        if (i2 != 10) {
                                            if (i2 == 11) {
                                                str = l;
                                                sQLiteDatabase.execSQL(str);
                                            }
                                            return;
                                        }
                                        str = k;
                                        sQLiteDatabase.execSQL(str);
                                    }
                                    str2 = "DROP TABLE IF EXISTS LocalPushInfo";
                                }
                                sQLiteDatabase.execSQL(j);
                                str = k;
                                sQLiteDatabase.execSQL(str);
                            }
                            sQLiteDatabase.execSQL(d);
                            str2 = e;
                            sQLiteDatabase.execSQL(str2);
                            sQLiteDatabase.execSQL(j);
                            str = k;
                            sQLiteDatabase.execSQL(str);
                        }
                    }
                    sQLiteDatabase.execSQL(d);
                    sQLiteDatabase.execSQL(e);
                    str4 = g;
                    sQLiteDatabase.execSQL(str4);
                    str3 = h;
                    sQLiteDatabase.execSQL(str3);
                    str2 = i;
                    sQLiteDatabase.execSQL(str2);
                    sQLiteDatabase.execSQL(j);
                    str = k;
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.execSQL(f);
                sQLiteDatabase.execSQL(d);
                sQLiteDatabase.execSQL(e);
                str4 = g;
                sQLiteDatabase.execSQL(str4);
                str3 = h;
                sQLiteDatabase.execSQL(str3);
                str2 = i;
                sQLiteDatabase.execSQL(str2);
                sQLiteDatabase.execSQL(j);
                str = k;
                sQLiteDatabase.execSQL(str);
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
        public static final f h;
        public static final f i;
        public static final f j;
        public static final f k;
        public static final /* synthetic */ f[] l;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846280039, "Lcom/baidu/android/pushservice/m/d$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846280039, "Lcom/baidu/android/pushservice/m/d$f;");
                    return;
                }
            }
            a = new f("pushInfoId", 0);
            b = new f(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 1);
            c = new f("msgId", 2);
            d = new f("notifyId", 3);
            e = new f("msgType", 4);
            f = new f("intervalTime", 5);
            g = new f("startTime", 6);
            h = new f("endTime", 7);
            i = new f("expireTime", 8);
            j = new f("msgBody", 9);
            f fVar = new f("signInfo", 10);
            k = fVar;
            l = new f[]{a, b, c, d, e, f, g, h, i, j, fVar};
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

        public static f valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (f) Enum.valueOf(f.class, str) : (f) invokeL.objValue;
        }

        public static f[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (f[]) l.clone() : (f[]) invokeV.objValue;
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
        public static final /* synthetic */ g[] k;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846280008, "Lcom/baidu/android/pushservice/m/d$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846280008, "Lcom/baidu/android/pushservice/m/d$g;");
                    return;
                }
            }
            a = new g("MsgInfoId", 0);
            b = new g(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 1);
            c = new g("msgType", 2);
            d = new g("msgId", 3);
            e = new g("arriveTime", 4);
            f = new g("secureInfo", 5);
            g = new g("msgBody", 6);
            h = new g("expireTime", 7);
            i = new g("ackRet", 8);
            g gVar = new g("notifyId", 9);
            j = gVar;
            k = new g[]{a, b, c, d, e, f, g, h, i, gVar};
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

        public static g valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (g) Enum.valueOf(g.class, str) : (g) invokeL.objValue;
        }

        public static g[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (g[]) k.clone() : (g[]) invokeV.objValue;
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
        public static final h f;
        public static final h g;
        public static final /* synthetic */ h[] h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846279977, "Lcom/baidu/android/pushservice/m/d$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846279977, "Lcom/baidu/android/pushservice/m/d$h;");
                    return;
                }
            }
            a = new h("configId", 0);
            b = new h("action", 1);
            c = new h("status", 2);
            d = new h("interval", 3);
            e = new h("powerLimit", 4);
            f = new h("foregroundStart", 5);
            h hVar = new h("lastFetchTime", 6);
            g = hVar;
            h = new h[]{a, b, c, d, e, f, hVar};
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

        public static h valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (h) Enum.valueOf(h.class, str) : (h) invokeL.objValue;
        }

        public static h[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) h.clone() : (h[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class i {
        public static /* synthetic */ Interceptable $ic;
        public static final i a;
        public static final i b;
        public static final i c;
        public static final i d;
        public static final i e;
        public static final i f;
        public static final i g;
        public static final /* synthetic */ i[] h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846279946, "Lcom/baidu/android/pushservice/m/d$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846279946, "Lcom/baidu/android/pushservice/m/d$i;");
                    return;
                }
            }
            a = new i("dataKey", 0);
            b = new i("dataSensitive", 1);
            c = new i("canUpload", 2);
            d = new i("timeInterval", 3);
            e = new i("dataValue", 4);
            f = new i("lastUpdateStamp", 5);
            i iVar = new i("bindCanUpload", 6);
            g = iVar;
            h = new i[]{a, b, c, d, e, f, iVar};
        }

        public i(String str, int i) {
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

        public static i valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (i) Enum.valueOf(i.class, str) : (i) invokeL.objValue;
        }

        public static i[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (i[]) h.clone() : (i[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class j {
        public static /* synthetic */ Interceptable $ic;
        public static final j a;
        public static final j b;
        public static final j c;
        public static final j d;
        public static final j e;
        public static final j f;
        public static final j g;
        public static final j h;
        public static final j i;
        public static final j j;
        public static final j k;
        public static final j l;
        public static final /* synthetic */ j[] m;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846279915, "Lcom/baidu/android/pushservice/m/d$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846279915, "Lcom/baidu/android/pushservice/m/d$j;");
                    return;
                }
            }
            a = new j("PushInfoId", 0);
            b = new j("PushPriority", 1);
            c = new j("PushVersion", 2);
            d = new j("PushChannelID", 3);
            e = new j("PushNewChannelID", 4);
            f = new j("PushChannelToken", 5);
            g = new j("PushCurPkgName", 6);
            h = new j("PushWebAppBindInfo", 7);
            i = new j("PushLightAppBindInfo", 8);
            j = new j("PushSDKClientBindInfo", 9);
            k = new j("PushClientsBindInfo", 10);
            j jVar = new j("PushSelfBindInfo", 11);
            l = jVar;
            m = new j[]{a, b, c, d, e, f, g, h, i, j, k, jVar};
        }

        public j(String str, int i2) {
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

        public static j valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (j) Enum.valueOf(j.class, str) : (j) invokeL.objValue;
        }

        public static j[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (j[]) m.clone() : (j[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class k {
        public static /* synthetic */ Interceptable $ic;
        public static final k a;
        public static final k b;
        public static final k c;
        public static final k d;
        public static final k e;
        public static final /* synthetic */ k[] f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1846279884, "Lcom/baidu/android/pushservice/m/d$k;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1846279884, "Lcom/baidu/android/pushservice/m/d$k;");
                    return;
                }
            }
            a = new k("verifId", 0);
            b = new k("msgId", 1);
            c = new k("md5Infos", 2);
            d = new k(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 3);
            k kVar = new k("time", 4);
            e = kVar;
            f = new k[]{a, b, c, d, kVar};
        }

        public k(String str, int i) {
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

        public static k valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (k) Enum.valueOf(k.class, str) : (k) invokeL.objValue;
        }

        public static k[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (k[]) f.clone() : (k[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676780773, "Lcom/baidu/android/pushservice/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676780773, "Lcom/baidu/android/pushservice/m/d;");
                return;
            }
        }
        b = new Object();
    }

    public static int a(Context context, com.baidu.android.pushservice.m.a aVar, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, aVar, Long.valueOf(j2)})) == null) {
            int i2 = 0;
            if (aVar == null) {
                return 0;
            }
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return 0;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.g.name(), Long.valueOf(j2));
                    i2 = d.update("PushConfig", contentValues, h.b.name() + " = ?", new String[]{String.valueOf(aVar.a())});
                } catch (Exception unused) {
                } catch (Throwable th) {
                    d.close();
                    throw th;
                }
                d.close();
                return i2;
            }
        }
        return invokeCommon.intValue;
    }

    public static synchronized long a(Context context, com.baidu.android.pushservice.m.c cVar) {
        InterceptResult invokeLL;
        Cursor cursor;
        Throwable th;
        long update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, cVar)) == null) {
            synchronized (d.class) {
                synchronized (b) {
                    SQLiteDatabase d = d(context);
                    long j2 = -1;
                    if (d == null) {
                        return -1L;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(j.b.name(), Long.valueOf(cVar.a));
                    contentValues.put(j.c.name(), Long.valueOf(cVar.b));
                    contentValues.put(j.d.name(), cVar.c);
                    contentValues.put(j.e.name(), cVar.d);
                    contentValues.put(j.g.name(), cVar.e);
                    contentValues.put(j.i.name(), cVar.g);
                    contentValues.put(j.h.name(), cVar.f);
                    contentValues.put(j.j.name(), cVar.h);
                    contentValues.put(j.k.name(), cVar.i);
                    contentValues.put(j.l.name(), cVar.j);
                    Cursor cursor2 = null;
                    try {
                        cursor = d.query("PushShareInfo", null, null, null, null, null, null);
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
                            d.close();
                            return j2;
                        } catch (Throwable th3) {
                            th = th3;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            update = d.update("PushShareInfo", contentValues, j.a.name() + "=1", null);
                            j2 = update;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            return j2;
                        }
                    }
                    update = d.insert("PushShareInfo", null, contentValues);
                    j2 = update;
                    if (cursor != null) {
                        cursor.close();
                    }
                    d.close();
                    return j2;
                }
            }
        }
        return invokeLL.longValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            return valueOf + " >= " + f.i.name();
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            String format = new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()));
            String str = " time(\"" + format + "\") >= time(" + f.g.name() + SmallTailInfo.EMOTION_SUFFIX;
            String str2 = " time(\"" + format + "\") <= time(" + f.h.name() + SmallTailInfo.EMOTION_SUFFIX;
            return "(" + ("(" + str + " and " + str2 + SmallTailInfo.EMOTION_SUFFIX) + " or " + ("( trim(" + f.g.name() + ") = ''  and " + str2 + SmallTailInfo.EMOTION_SUFFIX) + " or " + ("( trim(" + f.h.name() + ") = ''  and " + str + SmallTailInfo.EMOTION_SUFFIX) + " or " + ("( trim(" + f.g.name() + ") = ''  and  trim(" + f.h.name() + ") = '' )") + ") and " + ("(" + f.f.name() + " = 0 or " + f.f.name() + "<=" + e(context) + SmallTailInfo.EMOTION_SUFFIX) + " and " + (f.i.name() + " >= " + valueOf);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
        if (r12.isClosed() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                String str2 = null;
                if (d == null) {
                    return null;
                }
                try {
                    cursor = d.query("PushDataInfo", null, i.a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(i.g.name())) == 1) {
                                str2 = cursor.getString(cursor.getColumnIndex(i.e.name()));
                            }
                        } catch (Exception unused) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            d.close();
                            throw th;
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                d.close();
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r1.isClosed() == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, context, z)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (d == null) {
                    return null;
                }
                try {
                    cursor = d.query("PushShareInfo", new String[]{j.d.name(), j.e.name()}, null, null, null, null, null);
                } catch (Exception unused) {
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (cursor.moveToFirst()) {
                        str = cursor.getString(cursor.getColumnIndex((z ? j.e : j.d).name()));
                    }
                    if (cursor != null) {
                    }
                } catch (Exception unused2) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    d.close();
                    throw th;
                }
                d.close();
                return str;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static void a(Context context, LocalPushMsg localPushMsg) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, context, localPushMsg) == null) || localPushMsg == null) {
            return;
        }
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.b.name(), localPushMsg.a());
                contentValues.put(f.c.name(), localPushMsg.f());
                contentValues.put(f.d.name(), Integer.valueOf(localPushMsg.h()));
                contentValues.put(f.e.name(), Integer.valueOf(localPushMsg.g()));
                contentValues.put(f.f.name(), Long.valueOf(localPushMsg.d()));
                contentValues.put(f.g.name(), localPushMsg.j());
                contentValues.put(f.h.name(), localPushMsg.b());
                contentValues.put(f.i.name(), Long.valueOf(localPushMsg.c()));
                String b2 = BaiduAppSSOJni.b(context, localPushMsg.a(), localPushMsg.e());
                contentValues.put(f.k.name(), localPushMsg.i());
                contentValues.put(f.j.name(), b2);
                d.insert("LocalPushInfo", null, contentValues);
            } catch (Exception unused) {
            }
            d.close();
        }
    }

    public static void a(Context context, String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(i.a.name(), str);
                    contentValues.put(i.b.name(), Integer.valueOf(i2));
                    contentValues.put(i.d.name(), Long.valueOf(j2));
                    contentValues.put(i.c.name(), (Integer) 1);
                    if (d.update("PushDataInfo", contentValues, i.a.name() + " =? ", new String[]{String.valueOf(str)}) == 0) {
                        d.insertWithOnConflict("PushDataInfo", null, contentValues, 5);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    d.close();
                    throw th;
                }
                d.close();
            }
        }
    }

    public static void a(Context context, String str, int i2, long j2, byte[] bArr, byte[] bArr2, long j3, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j2), bArr, bArr2, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(g.b.name(), str);
                    contentValues.put(g.d.name(), Long.valueOf(j2));
                    contentValues.put(g.c.name(), Integer.valueOf(i2));
                    if (bArr != null && bArr.length > 0) {
                        contentValues.put(g.g.name(), BaiduAppSSOJni.b(context, str, bArr));
                        contentValues.put(g.f.name(), bArr2);
                        contentValues.put(g.h.name(), Long.valueOf(j3));
                    }
                    contentValues.put(g.e.name(), Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(g.i.name(), Integer.valueOf(i3));
                    contentValues.put(g.j.name(), Integer.valueOf(i4));
                    d.insert("PushMsgInfos", null, contentValues);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    d.close();
                    throw th;
                }
                d.close();
            }
        }
    }

    public static void a(Context context, String str, String str2, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, context, str, str2, l) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(i.e.name(), str2);
                    if (l != null) {
                        contentValues.put(i.f.name(), l);
                    }
                    d.update("PushDataInfo", contentValues, i.a.name() + " =? ", new String[]{String.valueOf(str)});
                } catch (Exception unused) {
                } catch (Throwable th) {
                    d.close();
                    throw th;
                }
                d.close();
            }
        }
    }

    public static void a(Context context, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, arrayList) == null) {
            synchronized (b) {
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
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                try {
                    d.execSQL("UPDATE PushDataInfo SET " + i.c.name() + "=0 WHERE " + i.a.name() + " NOT IN " + sb.toString());
                } catch (Exception unused) {
                }
                d.close();
            }
        }
    }

    public static void a(Context context, List<com.baidu.android.pushservice.m.a> list) {
        Cursor cursor;
        Cursor cursor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, list) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                d.beginTransaction();
                try {
                    Cursor cursor3 = null;
                    for (com.baidu.android.pushservice.m.a aVar : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(h.b.name(), aVar.a());
                            contentValues.put(h.c.name(), Integer.valueOf(aVar.f()));
                            contentValues.put(h.d.name(), Integer.valueOf(aVar.c()));
                            contentValues.put(h.e.name(), Integer.valueOf(aVar.e()));
                            contentValues.put(h.f.name(), Integer.valueOf(aVar.b()));
                            if (aVar.f() != 2) {
                                cursor3 = d.query("PushConfig", null, h.b.name() + " = ?", new String[]{String.valueOf(aVar.a())}, null, null, null);
                                if (cursor3 == null || cursor3.getCount() == 0) {
                                    d.insert("PushConfig", null, contentValues);
                                } else {
                                    d.update("PushConfig", contentValues, h.b.name() + " = ?", new String[]{String.valueOf(aVar.a())});
                                }
                            } else {
                                d.delete("PushConfig", h.b.name() + " = ?", new String[]{aVar.a()});
                            }
                        } catch (Exception unused) {
                            cursor2 = cursor3;
                            d.endTransaction();
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            d.close();
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursor3;
                            d.endTransaction();
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            throw th;
                        }
                    }
                    d.setTransactionSuccessful();
                    d.endTransaction();
                    if (cursor3 != null && !cursor3.isClosed()) {
                        cursor3.close();
                    }
                } catch (Exception unused2) {
                    cursor2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                d.close();
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, jSONArray) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                if (jSONArray != null) {
                    try {
                        if (jSONArray.length() > 0) {
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                ContentValues contentValues = new ContentValues();
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                long j2 = jSONObject.getLong("event_time");
                                contentValues.put(c.b.name(), jSONObject.toString());
                                contentValues.put(c.a.name(), Long.valueOf(j2));
                                d.insert("ClickMsgUploadInfo", null, contentValues);
                            }
                        }
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        d.close();
                        throw th;
                    }
                }
                d.close();
            }
        }
    }

    public static void a(Context context, String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, context, strArr) == null) || strArr == null) {
            return;
        }
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                for (String str : strArr) {
                    d.delete("LocalPushInfo", f.c.name() + " = ?", new String[]{str});
                }
            } catch (Exception unused) {
            }
            d.close();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, context, i2)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor = null;
                if (d == null) {
                    return false;
                }
                try {
                    cursor = d.query("PushMsgInfos", new String[]{g.j.name()}, g.j.name() + RFC1522Codec.PREFIX, new String[]{String.valueOf(i2)}, null, null, null);
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            return true;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return false;
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return false;
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    throw th;
                }
            }
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean a(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65552, null, context, j2)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor = null;
                if (d == null) {
                    return false;
                }
                try {
                    cursor = d.query("PushMsgInfos", new String[]{g.d.name()}, g.d.name() + " =? ", new String[]{String.valueOf(j2)}, null, null, null);
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            return true;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return false;
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return false;
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    throw th;
                }
            }
        }
        return invokeLJ.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
        if (r7.isClosed() == false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, com.baidu.android.pushservice.m.e eVar) {
        InterceptResult invokeLL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, eVar)) == null) {
            synchronized (d.class) {
                synchronized (b) {
                    SQLiteDatabase d = d(context);
                    if (d == null) {
                        return false;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(k.b.name(), eVar.a);
                    contentValues.put(k.c.name(), eVar.b);
                    contentValues.put(k.d.name(), eVar.c);
                    contentValues.put(k.e.name(), System.currentTimeMillis() + "");
                    Cursor cursor = null;
                    try {
                        j2 = d.insert("PushVerifInfo", null, contentValues);
                        try {
                            cursor = d.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                            if (cursor.moveToFirst() && cursor.getInt(0) > 200) {
                                d.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{eVar.a});
                            }
                            if (cursor != null) {
                            }
                        } catch (Exception unused) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            if (j2 != -1) {
                            }
                            return r2;
                        }
                    } catch (Exception unused2) {
                        j2 = -1;
                    }
                    d.close();
                    boolean z = j2 != -1;
                    return z;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d9, code lost:
        if (r10.isClosed() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e7, code lost:
        if (r10.isClosed() != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e9, code lost:
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, context, str, str2)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return false;
                }
                Cursor cursor = null;
                try {
                    cursor = d.query("PushDataInfo", null, i.a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    throw th;
                }
                if (cursor != null && cursor.moveToFirst()) {
                    int i2 = cursor.getInt(cursor.getColumnIndex(i.b.name()));
                    String string = cursor.getString(cursor.getColumnIndex(i.e.name()));
                    if (cursor.getInt(cursor.getColumnIndex(i.c.name())) != 1) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return false;
                    } else if (i2 == 1 && str2.equals(string)) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return false;
                    } else if (System.currentTimeMillis() - cursor.getLong(cursor.getColumnIndex(i.f.name())) <= cursor.getLong(cursor.getColumnIndex(i.d.name())) * 1000) {
                        if (cursor != null) {
                        }
                        d.close();
                        return false;
                    } else {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return true;
                    }
                }
                d.close();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static Object b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? b : invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
        if (r0 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65556, null, context, str, str2)) != null) {
            return (String) invokeLLL.objValue;
        }
        Cursor cursor2 = null;
        try {
            if (Utility.g(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
            } else {
                Uri parse = Uri.parse("content://" + str + ".bdpush/verif");
                String[] strArr = {k.c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(k.c.name());
                sb.append(RFC1522Codec.PREFIX);
                cursor = contentResolver.query(parse, strArr, sb.toString(), new String[]{str2}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str3 = cursor.getString(0);
                            cursor2 = cursor;
                        }
                    } catch (Throwable unused) {
                        if (cursor == null) {
                            return null;
                        }
                        str3 = null;
                        cursor2 = cursor;
                        try {
                            cursor2.close();
                        } catch (Exception unused2) {
                            return str3;
                        }
                    }
                }
                str3 = null;
                cursor2 = cursor;
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                try {
                    d.delete("ClickMsgUploadInfo", null, null);
                } catch (Exception unused) {
                }
                d.close();
            }
        }
    }

    public static void b(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, context, jSONArray) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    sb.append("'");
                    String str = "";
                    try {
                        str = jSONArray.get(i2).toString();
                    } catch (JSONException unused) {
                    }
                    sb.append(str);
                    sb.append("'");
                    if (i2 < jSONArray.length() - 1) {
                        sb.append(",");
                    }
                }
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(i.g.name(), (Integer) 0);
                    d.update("PushDataInfo", contentValues, null, null);
                    d.execSQL("UPDATE PushDataInfo SET " + i.g.name() + "=1 WHERE " + i.a.name() + " IN " + sb.toString());
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    d.close();
                    throw th;
                }
                d.close();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, null, context, i2)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor = null;
                if (d == null) {
                    return false;
                }
                int i3 = -1;
                try {
                    cursor = d.query("PushMsgInfos", null, g.j.name() + RFC1522Codec.PREFIX, new String[]{String.valueOf(i2)}, null, null, null);
                    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                        i3 = cursor.getInt(cursor.getColumnIndex(g.c.name()));
                    }
                    if (i3 != l.h.a() && i3 != l.d.a() && i3 != l.c.a() && i3 != l.j.a()) {
                        if (i3 != l.k.a()) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            return false;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return true;
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return false;
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    throw th;
                }
            }
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor = null;
                if (d == null) {
                    return false;
                }
                try {
                    cursor = d.query("LocalPushInfo", new String[]{f.c.name()}, f.c.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            return true;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return false;
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return false;
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    throw th;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a9, code lost:
        if (r11.isClosed() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b7, code lost:
        if (r11.isClosed() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b9, code lost:
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.android.pushservice.m.a c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, context, str)) == null) {
            com.baidu.android.pushservice.m.a aVar = new com.baidu.android.pushservice.m.a();
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return aVar;
                }
                Cursor cursor = null;
                try {
                    cursor = d.query("PushConfig", null, h.b.name() + " = ?", new String[]{String.valueOf(str)}, null, null, null, null);
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    throw th;
                }
                if (cursor != null && cursor.moveToFirst()) {
                    aVar.a(str);
                    aVar.d(cursor.getInt(cursor.getColumnIndex(h.c.name())));
                    aVar.b(cursor.getInt(cursor.getColumnIndex(h.d.name())));
                    aVar.c(cursor.getInt(cursor.getColumnIndex(h.e.name())));
                    aVar.a(cursor.getInt(cursor.getColumnIndex(h.f.name())));
                    aVar.a(cursor.getLong(cursor.getColumnIndex(h.g.name())));
                    if (cursor != null) {
                    }
                    d.close();
                    return aVar;
                }
                d.close();
                return aVar;
            }
        }
        return (com.baidu.android.pushservice.m.a) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
        if (r0 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65562, null, context, str, str2)) != null) {
            return (String) invokeLLL.objValue;
        }
        Cursor cursor2 = null;
        try {
            if (Utility.g(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
            } else {
                Uri parse = Uri.parse("content://" + str + ".bdpush/verif");
                String[] strArr = {k.c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(k.b.name());
                sb.append(RFC1522Codec.PREFIX);
                cursor = contentResolver.query(parse, strArr, sb.toString(), new String[]{str2}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str3 = cursor.getString(0);
                            cursor2 = cursor;
                        }
                    } catch (Throwable unused) {
                        if (cursor == null) {
                            return null;
                        }
                        str3 = null;
                        cursor2 = cursor;
                        try {
                            cursor2.close();
                        } catch (Exception unused2) {
                            return str3;
                        }
                    }
                }
                str3 = null;
                cursor2 = cursor;
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    public static JSONArray c(Context context) {
        InterceptResult invokeL;
        int a2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            JSONArray jSONArray = new JSONArray();
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return jSONArray;
                }
                Cursor cursor = null;
                try {
                    a2 = com.baidu.android.pushservice.a0.i.a(context, "click_data_size", 10) - 1;
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (a2 <= 0) {
                    d.close();
                    return jSONArray;
                }
                Cursor query = d.query(false, "ClickMsgUploadInfo", null, null, null, null, null, c.a.name() + " DESC ", String.valueOf(a2));
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            do {
                                String string = query.getString(query.getColumnIndex(c.b.name()));
                                j2 = query.getLong(query.getColumnIndex(c.a.name()));
                                jSONArray.put(new JSONObject(string));
                            } while (query.moveToNext());
                            if (d.delete("ClickMsgUploadInfo", c.a.name() + " >= " + String.valueOf(j2), null) == 0) {
                                jSONArray = new JSONArray();
                            }
                        }
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return jSONArray;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        throw th;
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
                d.close();
                return jSONArray;
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    public static SQLiteDatabase d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            e f2 = f(context);
            if (f2 == null) {
                return null;
            }
            try {
                return f2.getWritableDatabase();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (SQLiteDatabase) invokeL.objValue;
    }

    public static PushConfigData d(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, str)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                PushConfigData pushConfigData = null;
                if (d == null) {
                    return null;
                }
                try {
                    cursor = d.query("PushDataInfo", null, i.a.name() + " =? ", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                pushConfigData = new PushConfigData(cursor.getString(cursor.getColumnIndex(i.e.name())), cursor.getLong(cursor.getColumnIndex(i.d.name())));
                            }
                        } catch (Exception unused) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            return pushConfigData;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            d.close();
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
                d.close();
                return pushConfigData;
            }
        }
        return (PushConfigData) invokeLL.objValue;
    }

    public static synchronized void d(Context context, String str, String str2) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65566, null, context, str, str2) == null) {
            synchronized (d.class) {
                synchronized (b) {
                    SQLiteDatabase d = d(context);
                    if (d == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = d.query("PushShareInfo", null, null, null, null, null, null);
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
                            d.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(j.d.name(), str);
                            if (!TextUtils.isEmpty(str2)) {
                                contentValues.put(j.e.name(), str2);
                            }
                            d.update("PushShareInfo", contentValues, j.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            d.close();
                        }
                    }
                    com.baidu.android.pushservice.m.c cVar = new com.baidu.android.pushservice.m.c();
                    cVar.a = 0L;
                    cVar.b = 0L;
                    cVar.c = str;
                    cVar.d = str2;
                    cVar.e = null;
                    cVar.g = null;
                    cVar.f = null;
                    cVar.h = null;
                    cVar.i = null;
                    cVar.j = null;
                    a(context, cVar);
                    if (query != null) {
                        query.close();
                    }
                    d.close();
                }
            }
        }
    }

    public static long e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) ? (System.currentTimeMillis() / 1000) - com.baidu.android.pushservice.a0.i.a(context, "local_notify_msg_handle_last_time", 0L) : invokeL.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r11.isClosed() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, context, str)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                r9 = null;
                String str2 = null;
                if (d == null) {
                    return null;
                }
                try {
                    cursor = d.query("PushDataInfo", null, i.a.name() + " =? ", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                str2 = cursor.getString(cursor.getColumnIndex(i.e.name()));
                            }
                        } catch (Exception unused) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            d.close();
                            throw th;
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                d.close();
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b2, code lost:
        if (r8 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            if (a == null) {
                synchronized (b) {
                    if (a == null) {
                        File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                        SQLiteDatabase sQLiteDatabase = null;
                        a = Build.VERSION.SDK_INT >= 11 ? new e(context, str, 12, new C0027d(null)) : new e(context, str, (SQLiteDatabase.CursorFactory) null, 12);
                        try {
                            SQLiteDatabase sQLiteDatabase2 = a.getWritableDatabase();
                            try {
                                sQLiteDatabase2.delete("PushMsgInfos", g.e.name() + " < " + (System.currentTimeMillis() - 259200000), null);
                                sQLiteDatabase2.delete("LocalPushInfo", a(), null);
                            } catch (Throwable unused) {
                                sQLiteDatabase = sQLiteDatabase2;
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase2 = sQLiteDatabase;
                                    sQLiteDatabase2.close();
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
        return (e) invokeL.objValue;
    }

    public static synchronized void f(Context context, String str) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, context, str) == null) {
            synchronized (d.class) {
                synchronized (b) {
                    SQLiteDatabase d = d(context);
                    if (d == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = d.query("PushShareInfo", null, null, null, null, null, null);
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
                            d.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(j.f.name(), str);
                            d.update("PushShareInfo", contentValues, j.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            d.close();
                        }
                    }
                    com.baidu.android.pushservice.m.c cVar = new com.baidu.android.pushservice.m.c();
                    cVar.a = 0L;
                    cVar.b = 0L;
                    cVar.c = null;
                    cVar.d = null;
                    cVar.e = null;
                    cVar.g = null;
                    cVar.f = null;
                    cVar.h = null;
                    cVar.i = null;
                    cVar.j = null;
                    a(context, cVar);
                    if (query != null) {
                        query.close();
                    }
                    d.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (d == null) {
                    return null;
                }
                try {
                    cursor = d.query("PushShareInfo", new String[]{j.f.name()}, null, null, null, null, null);
                } catch (Exception unused) {
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(j.f.name())) : null;
                    if (cursor != null) {
                    }
                } catch (Exception unused2) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    d.close();
                    throw th;
                }
                d.close();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized void g(Context context, String str) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, null, context, str) == null) {
            synchronized (d.class) {
                synchronized (b) {
                    SQLiteDatabase d = d(context);
                    if (d == null || str == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = d.query("PushShareInfo", null, null, null, null, null, null);
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
                            d.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(j.k.name(), str);
                            d.update("PushShareInfo", contentValues, j.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            d.close();
                        }
                    }
                    com.baidu.android.pushservice.m.c cVar = new com.baidu.android.pushservice.m.c();
                    cVar.a = 0L;
                    cVar.b = 0L;
                    cVar.c = null;
                    cVar.d = null;
                    cVar.e = null;
                    cVar.g = null;
                    cVar.f = null;
                    cVar.h = null;
                    cVar.i = str;
                    cVar.j = null;
                    a(context, cVar);
                    if (query != null) {
                        query.close();
                    }
                    d.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (d == null) {
                    return null;
                }
                try {
                    cursor = d.query("PushShareInfo", new String[]{j.k.name()}, null, null, null, null, null);
                } catch (Exception unused) {
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(j.k.name())) : null;
                    if (cursor != null) {
                    }
                } catch (Exception unused2) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    d.close();
                    throw th;
                }
                d.close();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized void h(Context context, String str) {
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65574, null, context, str) == null) {
            synchronized (d.class) {
                synchronized (b) {
                    SQLiteDatabase d = d(context);
                    if (d == null || str == null) {
                        return;
                    }
                    Cursor cursor = null;
                    try {
                        query = d.query("PushShareInfo", null, null, null, null, null, null);
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
                            d.close();
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            d.close();
                            throw th;
                        }
                        if (query.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(j.l.name(), str);
                            d.update("PushShareInfo", contentValues, j.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            d.close();
                        }
                    }
                    com.baidu.android.pushservice.m.c cVar = new com.baidu.android.pushservice.m.c();
                    cVar.a = 0L;
                    cVar.b = 0L;
                    cVar.c = null;
                    cVar.d = null;
                    cVar.e = null;
                    cVar.g = null;
                    cVar.f = null;
                    cVar.h = null;
                    cVar.i = null;
                    cVar.j = str;
                    a(context, cVar);
                    if (query != null) {
                        query.close();
                    }
                    d.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (d == null) {
                    return null;
                }
                try {
                    cursor = d.query("PushShareInfo", new String[]{j.l.name()}, null, null, null, null, null);
                } catch (Exception unused) {
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(j.l.name())) : null;
                    if (cursor != null) {
                    }
                } catch (Exception unused2) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    d.close();
                    throw th;
                }
                d.close();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00d4, code lost:
        if (r11.isClosed() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<LocalPushMsg> j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (b) {
                SQLiteDatabase d = d(context);
                Cursor cursor = null;
                if (d == null) {
                    return null;
                }
                try {
                    cursor = d.query("LocalPushInfo", new String[0], a(context), null, null, null, null);
                    while (cursor != null) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        String string = cursor.getString(cursor.getColumnIndex(f.b.name()));
                        arrayList.add(new LocalPushMsg(string, cursor.getString(cursor.getColumnIndex(f.c.name())), cursor.getInt(cursor.getColumnIndex(f.d.name())), cursor.getInt(cursor.getColumnIndex(f.e.name())), cursor.getLong(cursor.getColumnIndex(f.f.name())), cursor.getString(cursor.getColumnIndex(f.g.name())), cursor.getString(cursor.getColumnIndex(f.h.name())), cursor.getLong(cursor.getColumnIndex(f.i.name())), BaiduAppSSOJni.a(context, string, cursor.getString(cursor.getColumnIndex(f.j.name()))), cursor.getBlob(cursor.getColumnIndex(f.k.name()))));
                    }
                    if (cursor != null) {
                    }
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    throw th;
                }
                d.close();
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }

    public static void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, context) == null) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                try {
                    d.delete("LocalPushInfo", null, null);
                } catch (Exception unused) {
                }
                d.close();
            }
        }
    }
}
