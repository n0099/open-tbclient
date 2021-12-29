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
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f32812b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.c.c$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f32813b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f32814c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f32815d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f32816e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f32817f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f32818g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ a[] f32819h;
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
            f32813b = new a("actionName", 1);
            f32814c = new a(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f32815d = new a("pkgName", 3);
            f32816e = new a(PushManager.APP_VERSION_CODE, 4);
            f32817f = new a(PushManager.APP_VERSION_NAME, 5);
            a aVar = new a("status", 6);
            f32818g = aVar;
            f32819h = new a[]{a, f32813b, f32814c, f32815d, f32816e, f32817f, aVar};
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
    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f32820b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ b[] f32821c;
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
            f32820b = bVar;
            f32821c = new b[]{a, bVar};
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
    /* loaded from: classes9.dex */
    public static class C1706c implements DatabaseErrorHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1706c() {
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

        public /* synthetic */ C1706c(AnonymousClass1 anonymousClass1) {
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

    /* loaded from: classes9.dex */
    public static class d extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f32822b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f32823c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f32824d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f32825e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f32826f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f32827g;

        /* renamed from: h  reason: collision with root package name */
        public static final String f32828h;

        /* renamed from: i  reason: collision with root package name */
        public static final String f32829i;
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
            a = "CREATE TABLE PushShareInfo (" + g.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.f32847b.name() + " LONG NOT NULL DEFAULT ((0)), " + g.f32848c.name() + " INTEGER DEFAULT ((0)), " + g.f32849d.name() + " TEXT, " + g.f32850e.name() + " TEXT, " + g.f32851f.name() + " TEXT, " + g.f32852g.name() + " TEXT, " + g.f32853h.name() + " TEXT, " + g.f32854i.name() + " TEXT, " + g.f32855j.name() + " TEXT, " + g.f32856k.name() + " TEXT, " + g.l.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE PushVerifInfo (");
            sb.append(h.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(h.f32857b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f32858c.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f32859d.name());
            sb.append(" TEXT, ");
            sb.append(h.f32860e.name());
            sb.append(" TEXT);");
            f32822b = sb.toString();
            f32823c = "CREATE TABLE PushMsgInfos (" + e.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.f32830b.name() + "  TEXT, " + e.f32831c.name() + "  INTEGER NOT NULL, " + e.f32832d.name() + " LONG NOT NULL, " + e.f32834f.name() + " TEXT, " + e.f32835g.name() + "  TEXT, " + e.f32836h.name() + "  LONG, " + e.f32837i.name() + "  INTEGER, " + e.f32833e.name() + " LONG NOT NULL, " + e.f32838j.name() + "  INTEGER);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE PushDataInfo (");
            sb2.append(f.a.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(f.f32840b.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f32841c.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f32842d.name());
            sb2.append("  LONG NOT NULL, ");
            sb2.append(f.f32843e.name());
            sb2.append(" TEXT,");
            sb2.append(f.f32844f.name());
            sb2.append(" LONG,");
            sb2.append(f.f32845g.name());
            sb2.append(" INTEGER DEFAULT ((0)));");
            f32824d = sb2.toString();
            f32825e = "CREATE TABLE ClickMsgUploadInfo (" + b.a.name() + " LONG NOT NULL," + b.f32820b.name() + " TEXT NOT NULL);";
            f32826f = "CREATE TABLE PushAppStatus (" + a.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.f32813b.name() + " TEXT NOT NULL, " + a.f32814c.name() + " LONG NOT NULL, " + a.f32815d.name() + " TEXT, " + a.f32816e.name() + " INTEGER, " + a.f32817f.name() + " TEXT, " + a.f32818g.name() + " INTEGER);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb3.append(g.f32850e.name());
            sb3.append(" TEXT");
            f32827g = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb4.append(g.f32851f.name());
            sb4.append(" TEXT");
            f32828h = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE PushMsgInfos ADD COLUMN ");
            sb5.append(e.f32838j.name());
            sb5.append(" INTEGER");
            f32829i = sb5.toString();
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
                    sQLiteDatabase.execSQL(f32822b);
                    sQLiteDatabase.execSQL(f32823c);
                    sQLiteDatabase.execSQL(f32826f);
                    sQLiteDatabase.execSQL(f32824d);
                    sQLiteDatabase.execSQL(f32825e);
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
                    sQLiteDatabase.execSQL(f32823c);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            sQLiteDatabase.execSQL(f32824d);
                            str3 = f32825e;
                            sQLiteDatabase.execSQL(str3);
                            str2 = f32828h;
                            sQLiteDatabase.execSQL(str2);
                            str = f32829i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 6) {
                            sQLiteDatabase.execSQL(f32824d);
                            str2 = f32825e;
                            sQLiteDatabase.execSQL(str2);
                            str = f32829i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 7) {
                            sQLiteDatabase.execSQL(f32824d);
                            str = f32825e;
                            sQLiteDatabase.execSQL(str);
                        } else {
                            return;
                        }
                    }
                    sQLiteDatabase.execSQL(f32824d);
                    sQLiteDatabase.execSQL(f32825e);
                    str3 = f32827g;
                    sQLiteDatabase.execSQL(str3);
                    str2 = f32828h;
                    sQLiteDatabase.execSQL(str2);
                    str = f32829i;
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.execSQL(f32826f);
                sQLiteDatabase.execSQL(f32824d);
                sQLiteDatabase.execSQL(f32825e);
                str3 = f32827g;
                sQLiteDatabase.execSQL(str3);
                str2 = f32828h;
                sQLiteDatabase.execSQL(str2);
                str = f32829i;
                sQLiteDatabase.execSQL(str);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f32830b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f32831c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f32832d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f32833e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f32834f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f32835g;

        /* renamed from: h  reason: collision with root package name */
        public static final e f32836h;

        /* renamed from: i  reason: collision with root package name */
        public static final e f32837i;

        /* renamed from: j  reason: collision with root package name */
        public static final e f32838j;

        /* renamed from: k  reason: collision with root package name */
        public static final /* synthetic */ e[] f32839k;
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
            f32830b = new e(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 1);
            f32831c = new e("msgType", 2);
            f32832d = new e("msgId", 3);
            f32833e = new e("arriveTime", 4);
            f32834f = new e("secureInfo", 5);
            f32835g = new e("msgBody", 6);
            f32836h = new e("expireTime", 7);
            f32837i = new e("ackRet", 8);
            e eVar = new e(MiPushMessage.KEY_NOTIFY_ID, 9);
            f32838j = eVar;
            f32839k = new e[]{a, f32830b, f32831c, f32832d, f32833e, f32834f, f32835g, f32836h, f32837i, eVar};
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
    /* loaded from: classes9.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f32840b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f32841c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f32842d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f32843e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f32844f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f32845g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ f[] f32846h;
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
            f32840b = new f("dataSensitive", 1);
            f32841c = new f("canUpload", 2);
            f32842d = new f("timeInterval", 3);
            f32843e = new f("dataValue", 4);
            f32844f = new f("lastUpdateStamp", 5);
            f fVar = new f("bindCanUpload", 6);
            f32845g = fVar;
            f32846h = new f[]{a, f32840b, f32841c, f32842d, f32843e, f32844f, fVar};
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
    /* loaded from: classes9.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f32847b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f32848c;

        /* renamed from: d  reason: collision with root package name */
        public static final g f32849d;

        /* renamed from: e  reason: collision with root package name */
        public static final g f32850e;

        /* renamed from: f  reason: collision with root package name */
        public static final g f32851f;

        /* renamed from: g  reason: collision with root package name */
        public static final g f32852g;

        /* renamed from: h  reason: collision with root package name */
        public static final g f32853h;

        /* renamed from: i  reason: collision with root package name */
        public static final g f32854i;

        /* renamed from: j  reason: collision with root package name */
        public static final g f32855j;

        /* renamed from: k  reason: collision with root package name */
        public static final g f32856k;
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
            f32847b = new g("PushPriority", 1);
            f32848c = new g("PushVersion", 2);
            f32849d = new g("PushChannelID", 3);
            f32850e = new g("PushNewChannelID", 4);
            f32851f = new g("PushChannelToken", 5);
            f32852g = new g("PushCurPkgName", 6);
            f32853h = new g("PushWebAppBindInfo", 7);
            f32854i = new g("PushLightAppBindInfo", 8);
            f32855j = new g("PushSDKClientBindInfo", 9);
            f32856k = new g("PushClientsBindInfo", 10);
            g gVar = new g("PushSelfBindInfo", 11);
            l = gVar;
            m = new g[]{a, f32847b, f32848c, f32849d, f32850e, f32851f, f32852g, f32853h, f32854i, f32855j, f32856k, gVar};
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
    /* loaded from: classes9.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;
        public static final h a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f32857b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f32858c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f32859d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f32860e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f32861f;
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
            f32857b = new h("msgId", 1);
            f32858c = new h("md5Infos", 2);
            f32859d = new h(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 3);
            h hVar = new h("time", 4);
            f32860e = hVar;
            f32861f = new h[]{a, f32857b, f32858c, f32859d, hVar};
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
        f32812b = new Object();
    }

    public static synchronized long a(Context context, com.baidu.android.pushservice.c.b bVar) {
        InterceptResult invokeLL;
        Cursor cursor;
        Throwable th;
        long update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, bVar)) == null) {
            synchronized (c.class) {
                synchronized (f32812b) {
                    SQLiteDatabase a2 = a(context);
                    long j2 = -1;
                    if (a2 == null) {
                        return -1L;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(g.f32847b.name(), Long.valueOf(bVar.a));
                    contentValues.put(g.f32848c.name(), Long.valueOf(bVar.f32803b));
                    contentValues.put(g.f32849d.name(), bVar.f32804c);
                    contentValues.put(g.f32850e.name(), bVar.f32805d);
                    contentValues.put(g.f32852g.name(), bVar.f32806e);
                    contentValues.put(g.f32854i.name(), bVar.f32808g);
                    contentValues.put(g.f32853h.name(), bVar.f32807f);
                    contentValues.put(g.f32855j.name(), bVar.f32809h);
                    contentValues.put(g.f32856k.name(), bVar.f32810i);
                    contentValues.put(g.l.name(), bVar.f32811j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f32812b : invokeV.objValue;
    }

    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z)) == null) {
            synchronized (f32812b) {
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
                    cursor = a2.query("PushShareInfo", new String[]{g.f32849d.name(), g.f32850e.name()}, null, null, null, null, null);
                    try {
                        if (cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndex((z ? g.f32850e : g.f32849d).name()));
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
                synchronized (f32812b) {
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
                            contentValues.put(g.f32847b.name(), Long.valueOf(j2));
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = j2;
                    bVar.f32803b = 0L;
                    bVar.f32804c = null;
                    bVar.f32805d = null;
                    bVar.f32806e = null;
                    bVar.f32808g = null;
                    bVar.f32807f = null;
                    bVar.f32809h = null;
                    bVar.f32810i = null;
                    bVar.f32811j = null;
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
                synchronized (f32812b) {
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
                            contentValues.put(g.f32851f.name(), str);
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.f32803b = 0L;
                    bVar.f32804c = null;
                    bVar.f32805d = null;
                    bVar.f32806e = null;
                    bVar.f32808g = null;
                    bVar.f32807f = null;
                    bVar.f32809h = null;
                    bVar.f32810i = null;
                    bVar.f32811j = null;
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
            synchronized (f32812b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.a.name(), str);
                    contentValues.put(f.f32840b.name(), Integer.valueOf(i2));
                    contentValues.put(f.f32842d.name(), Long.valueOf(j2));
                    contentValues.put(f.f32841c.name(), (Integer) 1);
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
            synchronized (f32812b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.f32830b.name(), str);
                    contentValues.put(e.f32832d.name(), Long.valueOf(j2));
                    contentValues.put(e.f32831c.name(), Integer.valueOf(i2));
                    if (bArr != null && bArr.length > 0) {
                        contentValues.put(e.f32835g.name(), BaiduAppSSOJni.a(context, str, bArr));
                        contentValues.put(e.f32834f.name(), bArr2);
                        contentValues.put(e.f32836h.name(), Long.valueOf(j3));
                    }
                    contentValues.put(e.f32833e.name(), Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(e.f32837i.name(), Integer.valueOf(i3));
                    contentValues.put(e.f32838j.name(), Integer.valueOf(i4));
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
                synchronized (f32812b) {
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
                            contentValues.put(g.f32849d.name(), str);
                            if (!TextUtils.isEmpty(str2)) {
                                contentValues.put(g.f32850e.name(), str2);
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
                    bVar.f32803b = 0L;
                    bVar.f32804c = str;
                    bVar.f32805d = str2;
                    bVar.f32806e = null;
                    bVar.f32808g = null;
                    bVar.f32807f = null;
                    bVar.f32809h = null;
                    bVar.f32810i = null;
                    bVar.f32811j = null;
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
            synchronized (f32812b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f32843e.name(), str2);
                    if (l != null) {
                        contentValues.put(f.f32844f.name(), l);
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
            synchronized (f32812b) {
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
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f32841c.name() + "=0 WHERE " + f.a.name() + " NOT IN " + sb.toString());
                } catch (Exception unused) {
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, jSONArray) == null) {
            synchronized (f32812b) {
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
                                contentValues.put(b.f32820b.name(), jSONObject.toString());
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
            synchronized (f32812b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.f32838j.name()}, e.f32838j.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
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
                synchronized (f32812b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return false;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.f32857b.name(), fVar.a);
                    contentValues.put(h.f32858c.name(), fVar.f32908b);
                    contentValues.put(h.f32859d.name(), fVar.f32909c);
                    contentValues.put(h.f32860e.name(), System.currentTimeMillis() + "");
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
            synchronized (f32812b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return 0;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f32848c.name()}, null, null, null, null, null);
                    r9 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(g.f32848c.name())) : 0;
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
                String[] strArr = {h.f32858c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f32857b.name());
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
                synchronized (f32812b) {
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
                            contentValues.put(g.f32848c.name(), Long.valueOf(j2));
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.f32803b = j2;
                    bVar.f32804c = null;
                    bVar.f32805d = null;
                    bVar.f32806e = null;
                    bVar.f32808g = null;
                    bVar.f32807f = null;
                    bVar.f32809h = null;
                    bVar.f32810i = null;
                    bVar.f32811j = null;
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
                synchronized (f32812b) {
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
                            contentValues.put(g.f32856k.name(), str);
                            a2.update("PushShareInfo", contentValues, g.a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.a = 0L;
                    bVar.f32803b = 0L;
                    bVar.f32804c = null;
                    bVar.f32805d = null;
                    bVar.f32806e = null;
                    bVar.f32808g = null;
                    bVar.f32807f = null;
                    bVar.f32809h = null;
                    bVar.f32810i = str;
                    bVar.f32811j = null;
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
            synchronized (f32812b) {
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
                    contentValues.put(f.f32845g.name(), (Integer) 0);
                    a2.update("PushDataInfo", contentValues, null, null);
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f32845g.name() + "=1 WHERE " + f.a.name() + " IN " + sb.toString());
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
            synchronized (f32812b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                int i3 = -1;
                try {
                    cursor = a2.query("PushMsgInfos", null, e.f32838j.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
                    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                        i3 = cursor.getInt(cursor.getColumnIndex(e.f32831c.name()));
                    }
                    if (i3 != k.f33346g.b() && i3 != k.f33342c.b() && i3 != k.f33341b.b()) {
                        if (i3 != k.f33348i.b()) {
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
            synchronized (f32812b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f32851f.name()}, null, null, null, null, null);
                    try {
                        str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.f32851f.name())) : null;
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
                String[] strArr = {h.f32858c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f32858c.name());
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
                synchronized (f32812b) {
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
                    bVar.f32803b = 0L;
                    bVar.f32804c = null;
                    bVar.f32805d = null;
                    bVar.f32806e = null;
                    bVar.f32808g = null;
                    bVar.f32807f = null;
                    bVar.f32809h = null;
                    bVar.f32810i = null;
                    bVar.f32811j = str;
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
            synchronized (f32812b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.f32832d.name()}, e.f32832d.name() + " =? ", new String[]{String.valueOf(j2)}, null, null, null);
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
            synchronized (f32812b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f32856k.name()}, null, null, null, null, null);
                    try {
                        str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.f32856k.name())) : null;
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
            synchronized (f32812b) {
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
                            if (cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(f.f32845g.name())) == 1) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.f32843e.name()));
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
            synchronized (f32812b) {
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
                    int i2 = cursor.getInt(cursor.getColumnIndex(f.f32840b.name()));
                    String string = cursor.getString(cursor.getColumnIndex(f.f32843e.name()));
                    if (cursor.getInt(cursor.getColumnIndex(f.f32841c.name())) != 1) {
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
                    } else if (System.currentTimeMillis() - cursor.getLong(cursor.getColumnIndex(f.f32844f.name())) > cursor.getLong(cursor.getColumnIndex(f.f32842d.name())) * 1000) {
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
            synchronized (f32812b) {
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
            synchronized (f32812b) {
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
                                str2 = cursor.getString(cursor.getColumnIndex(f.f32843e.name()));
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
            synchronized (f32812b) {
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
                                String string = query.getString(query.getColumnIndex(b.f32820b.name()));
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
            synchronized (f32812b) {
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
                synchronized (f32812b) {
                    if (a == null) {
                        File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                        SQLiteDatabase sQLiteDatabase = null;
                        if (Build.VERSION.SDK_INT >= 11) {
                            a = new d(context, str, 8, new C1706c(null));
                        } else {
                            a = new d(context, str, (SQLiteDatabase.CursorFactory) null, 8);
                        }
                        try {
                            SQLiteDatabase writableDatabase = a.getWritableDatabase();
                            try {
                                writableDatabase.delete("PushMsgInfos", e.f32833e.name() + " < " + (System.currentTimeMillis() - 259200000), null);
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
