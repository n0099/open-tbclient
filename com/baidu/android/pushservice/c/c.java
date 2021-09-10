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
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f37036a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f37037b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.c.c$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f37038a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f37039b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f37040c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f37041d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f37042e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f37043f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f37044g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ a[] f37045h;
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
            f37038a = new a("actionId", 0);
            f37039b = new a("actionName", 1);
            f37040c = new a(PmsConstant.Statistic.Key.REV_TIMESTAMP, 2);
            f37041d = new a(PushClientConstants.TAG_PKG_NAME, 3);
            f37042e = new a(PushManager.APP_VERSION_CODE, 4);
            f37043f = new a(PushManager.APP_VERSION_NAME, 5);
            a aVar = new a("status", 6);
            f37044g = aVar;
            f37045h = new a[]{f37038a, f37039b, f37040c, f37041d, f37042e, f37043f, aVar};
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
    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f37046a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f37047b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ b[] f37048c;
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
            f37046a = new b("timeStamps", 0);
            b bVar = new b("clickData", 1);
            f37047b = bVar;
            f37048c = new b[]{f37046a, bVar};
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
    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class d extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f37049a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f37050b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f37051c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f37052d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f37053e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f37054f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f37055g;

        /* renamed from: h  reason: collision with root package name */
        public static final String f37056h;

        /* renamed from: i  reason: collision with root package name */
        public static final String f37057i;
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
            f37049a = "CREATE TABLE PushShareInfo (" + g.f37076a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.f37077b.name() + " LONG NOT NULL DEFAULT ((0)), " + g.f37078c.name() + " INTEGER DEFAULT ((0)), " + g.f37079d.name() + " TEXT, " + g.f37080e.name() + " TEXT, " + g.f37081f.name() + " TEXT, " + g.f37082g.name() + " TEXT, " + g.f37083h.name() + " TEXT, " + g.f37084i.name() + " TEXT, " + g.f37085j.name() + " TEXT, " + g.k.name() + " TEXT, " + g.l.name() + " TEXT);";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE PushVerifInfo (");
            sb.append(h.f37086a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(h.f37087b.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f37088c.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.f37089d.name());
            sb.append(" TEXT, ");
            sb.append(h.f37090e.name());
            sb.append(" TEXT);");
            f37050b = sb.toString();
            f37051c = "CREATE TABLE PushMsgInfos (" + e.f37058a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.f37059b.name() + "  TEXT, " + e.f37060c.name() + "  INTEGER NOT NULL, " + e.f37061d.name() + " LONG NOT NULL, " + e.f37063f.name() + " TEXT, " + e.f37064g.name() + "  TEXT, " + e.f37065h.name() + "  LONG, " + e.f37066i.name() + "  INTEGER, " + e.f37062e.name() + " LONG NOT NULL, " + e.f37067j.name() + "  INTEGER);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE PushDataInfo (");
            sb2.append(f.f37068a.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(f.f37069b.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f37070c.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.f37071d.name());
            sb2.append("  LONG NOT NULL, ");
            sb2.append(f.f37072e.name());
            sb2.append(" TEXT,");
            sb2.append(f.f37073f.name());
            sb2.append(" LONG,");
            sb2.append(f.f37074g.name());
            sb2.append(" INTEGER DEFAULT ((0)));");
            f37052d = sb2.toString();
            f37053e = "CREATE TABLE ClickMsgUploadInfo (" + b.f37046a.name() + " LONG NOT NULL," + b.f37047b.name() + " TEXT NOT NULL);";
            f37054f = "CREATE TABLE PushAppStatus (" + a.f37038a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.f37039b.name() + " TEXT NOT NULL, " + a.f37040c.name() + " LONG NOT NULL, " + a.f37041d.name() + " TEXT, " + a.f37042e.name() + " INTEGER, " + a.f37043f.name() + " TEXT, " + a.f37044g.name() + " INTEGER);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb3.append(g.f37080e.name());
            sb3.append(" TEXT");
            f37055g = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb4.append(g.f37081f.name());
            sb4.append(" TEXT");
            f37056h = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE PushMsgInfos ADD COLUMN ");
            sb5.append(e.f37067j.name());
            sb5.append(" INTEGER");
            f37057i = sb5.toString();
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
                    sQLiteDatabase.execSQL(f37049a);
                    sQLiteDatabase.execSQL(f37050b);
                    sQLiteDatabase.execSQL(f37051c);
                    sQLiteDatabase.execSQL(f37054f);
                    sQLiteDatabase.execSQL(f37052d);
                    sQLiteDatabase.execSQL(f37053e);
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
                    sQLiteDatabase.execSQL(f37051c);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            sQLiteDatabase.execSQL(f37052d);
                            str3 = f37053e;
                            sQLiteDatabase.execSQL(str3);
                            str2 = f37056h;
                            sQLiteDatabase.execSQL(str2);
                            str = f37057i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 6) {
                            sQLiteDatabase.execSQL(f37052d);
                            str2 = f37053e;
                            sQLiteDatabase.execSQL(str2);
                            str = f37057i;
                            sQLiteDatabase.execSQL(str);
                        } else if (i2 == 7) {
                            sQLiteDatabase.execSQL(f37052d);
                            str = f37053e;
                            sQLiteDatabase.execSQL(str);
                        } else {
                            return;
                        }
                    }
                    sQLiteDatabase.execSQL(f37052d);
                    sQLiteDatabase.execSQL(f37053e);
                    str3 = f37055g;
                    sQLiteDatabase.execSQL(str3);
                    str2 = f37056h;
                    sQLiteDatabase.execSQL(str2);
                    str = f37057i;
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.execSQL(f37054f);
                sQLiteDatabase.execSQL(f37052d);
                sQLiteDatabase.execSQL(f37053e);
                str3 = f37055g;
                sQLiteDatabase.execSQL(str3);
                str2 = f37056h;
                sQLiteDatabase.execSQL(str2);
                str = f37057i;
                sQLiteDatabase.execSQL(str);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f37058a;

        /* renamed from: b  reason: collision with root package name */
        public static final e f37059b;

        /* renamed from: c  reason: collision with root package name */
        public static final e f37060c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f37061d;

        /* renamed from: e  reason: collision with root package name */
        public static final e f37062e;

        /* renamed from: f  reason: collision with root package name */
        public static final e f37063f;

        /* renamed from: g  reason: collision with root package name */
        public static final e f37064g;

        /* renamed from: h  reason: collision with root package name */
        public static final e f37065h;

        /* renamed from: i  reason: collision with root package name */
        public static final e f37066i;

        /* renamed from: j  reason: collision with root package name */
        public static final e f37067j;
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
            f37058a = new e("MsgInfoId", 0);
            f37059b = new e(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 1);
            f37060c = new e("msgType", 2);
            f37061d = new e("msgId", 3);
            f37062e = new e("arriveTime", 4);
            f37063f = new e("secureInfo", 5);
            f37064g = new e("msgBody", 6);
            f37065h = new e("expireTime", 7);
            f37066i = new e("ackRet", 8);
            e eVar = new e(MiPushMessage.KEY_NOTIFY_ID, 9);
            f37067j = eVar;
            k = new e[]{f37058a, f37059b, f37060c, f37061d, f37062e, f37063f, f37064g, f37065h, f37066i, eVar};
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
    /* loaded from: classes4.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f37068a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f37069b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f37070c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f37071d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f37072e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f37073f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f37074g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ f[] f37075h;
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
            f37068a = new f("dataKey", 0);
            f37069b = new f("dataSensitive", 1);
            f37070c = new f("canUpload", 2);
            f37071d = new f("timeInterval", 3);
            f37072e = new f("dataValue", 4);
            f37073f = new f("lastUpdateStamp", 5);
            f fVar = new f("bindCanUpload", 6);
            f37074g = fVar;
            f37075h = new f[]{f37068a, f37069b, f37070c, f37071d, f37072e, f37073f, fVar};
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
        public static final g f37076a;

        /* renamed from: b  reason: collision with root package name */
        public static final g f37077b;

        /* renamed from: c  reason: collision with root package name */
        public static final g f37078c;

        /* renamed from: d  reason: collision with root package name */
        public static final g f37079d;

        /* renamed from: e  reason: collision with root package name */
        public static final g f37080e;

        /* renamed from: f  reason: collision with root package name */
        public static final g f37081f;

        /* renamed from: g  reason: collision with root package name */
        public static final g f37082g;

        /* renamed from: h  reason: collision with root package name */
        public static final g f37083h;

        /* renamed from: i  reason: collision with root package name */
        public static final g f37084i;

        /* renamed from: j  reason: collision with root package name */
        public static final g f37085j;
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
            f37076a = new g("PushInfoId", 0);
            f37077b = new g("PushPriority", 1);
            f37078c = new g("PushVersion", 2);
            f37079d = new g("PushChannelID", 3);
            f37080e = new g("PushNewChannelID", 4);
            f37081f = new g("PushChannelToken", 5);
            f37082g = new g("PushCurPkgName", 6);
            f37083h = new g("PushWebAppBindInfo", 7);
            f37084i = new g("PushLightAppBindInfo", 8);
            f37085j = new g("PushSDKClientBindInfo", 9);
            k = new g("PushClientsBindInfo", 10);
            g gVar = new g("PushSelfBindInfo", 11);
            l = gVar;
            m = new g[]{f37076a, f37077b, f37078c, f37079d, f37080e, f37081f, f37082g, f37083h, f37084i, f37085j, k, gVar};
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
        public static final h f37086a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f37087b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f37088c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f37089d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f37090e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ h[] f37091f;
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
            f37086a = new h("verifId", 0);
            f37087b = new h("msgId", 1);
            f37088c = new h("md5Infos", 2);
            f37089d = new h(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, 3);
            h hVar = new h("time", 4);
            f37090e = hVar;
            f37091f = new h[]{f37086a, f37087b, f37088c, f37089d, hVar};
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
        f37037b = new Object();
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
            java.lang.Object r3 = com.baidu.android.pushservice.c.c.f37037b     // Catch: java.lang.Throwable -> L133
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
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f37077b     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            long r5 = r1.f37026a     // Catch: java.lang.Throwable -> L130
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f37078c     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            long r5 = r1.f37027b     // Catch: java.lang.Throwable -> L130
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f37079d     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f37028c     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f37080e     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f37029d     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f37082g     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f37030e     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f37084i     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f37032g     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f37083h     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f37031f     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.f37085j     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f37033h     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.k     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f37034i     // Catch: java.lang.Throwable -> L130
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L130
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.l     // Catch: java.lang.Throwable -> L130
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L130
            java.lang.String r5 = r1.f37035j     // Catch: java.lang.Throwable -> L130
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
            com.baidu.android.pushservice.c.c$g r6 = com.baidu.android.pushservice.c.c.g.f37076a     // Catch: java.lang.Throwable -> L106 java.lang.Exception -> L11f
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f37037b : invokeV.objValue;
    }

    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z)) == null) {
            synchronized (f37037b) {
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
                    cursor = a2.query("PushShareInfo", new String[]{g.f37079d.name(), g.f37080e.name()}, null, null, null, null, null);
                    try {
                        if (cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndex((z ? g.f37080e : g.f37079d).name()));
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
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, context, j2) == null) {
            synchronized (c.class) {
                synchronized (f37037b) {
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
                            contentValues.put(g.f37077b.name(), Long.valueOf(j2));
                            a2.update("PushShareInfo", contentValues, g.f37076a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f37026a = j2;
                    bVar.f37027b = 0L;
                    bVar.f37028c = null;
                    bVar.f37029d = null;
                    bVar.f37030e = null;
                    bVar.f37032g = null;
                    bVar.f37031f = null;
                    bVar.f37033h = null;
                    bVar.f37034i = null;
                    bVar.f37035j = null;
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
                synchronized (f37037b) {
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
                            contentValues.put(g.f37081f.name(), str);
                            a2.update("PushShareInfo", contentValues, g.f37076a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f37026a = 0L;
                    bVar.f37027b = 0L;
                    bVar.f37028c = null;
                    bVar.f37029d = null;
                    bVar.f37030e = null;
                    bVar.f37032g = null;
                    bVar.f37031f = null;
                    bVar.f37033h = null;
                    bVar.f37034i = null;
                    bVar.f37035j = null;
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
            synchronized (f37037b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f37068a.name(), str);
                    contentValues.put(f.f37069b.name(), Integer.valueOf(i2));
                    contentValues.put(f.f37071d.name(), Long.valueOf(j2));
                    contentValues.put(f.f37070c.name(), (Integer) 1);
                    if (a2.update("PushDataInfo", contentValues, f.f37068a.name() + " =? ", new String[]{String.valueOf(str)}) == 0) {
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
            synchronized (f37037b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.f37059b.name(), str);
                    contentValues.put(e.f37061d.name(), Long.valueOf(j2));
                    contentValues.put(e.f37060c.name(), Integer.valueOf(i2));
                    if (bArr != null && bArr.length > 0) {
                        contentValues.put(e.f37064g.name(), BaiduAppSSOJni.a(context, str, bArr));
                        contentValues.put(e.f37063f.name(), bArr2);
                        contentValues.put(e.f37065h.name(), Long.valueOf(j3));
                    }
                    contentValues.put(e.f37062e.name(), Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(e.f37066i.name(), Integer.valueOf(i3));
                    contentValues.put(e.f37067j.name(), Integer.valueOf(i4));
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
                synchronized (f37037b) {
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
                            contentValues.put(g.f37079d.name(), str);
                            if (!TextUtils.isEmpty(str2)) {
                                contentValues.put(g.f37080e.name(), str2);
                            }
                            a2.update("PushShareInfo", contentValues, g.f37076a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f37026a = 0L;
                    bVar.f37027b = 0L;
                    bVar.f37028c = str;
                    bVar.f37029d = str2;
                    bVar.f37030e = null;
                    bVar.f37032g = null;
                    bVar.f37031f = null;
                    bVar.f37033h = null;
                    bVar.f37034i = null;
                    bVar.f37035j = null;
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
            synchronized (f37037b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f37072e.name(), str2);
                    if (l != null) {
                        contentValues.put(f.f37073f.name(), l);
                    }
                    a2.update("PushDataInfo", contentValues, f.f37068a.name() + " =? ", new String[]{String.valueOf(str)});
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
            synchronized (f37037b) {
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
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f37070c.name() + "=0 WHERE " + f.f37068a.name() + " NOT IN " + sb.toString());
                } catch (Exception unused) {
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, jSONArray) == null) {
            synchronized (f37037b) {
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
                                contentValues.put(b.f37047b.name(), jSONObject.toString());
                                contentValues.put(b.f37046a.name(), Long.valueOf(j2));
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
            synchronized (f37037b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.f37067j.name()}, e.f37067j.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
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
                synchronized (f37037b) {
                    SQLiteDatabase a2 = a(context);
                    if (a2 == null) {
                        return false;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.f37087b.name(), fVar.f37144a);
                    contentValues.put(h.f37088c.name(), fVar.f37145b);
                    contentValues.put(h.f37089d.name(), fVar.f37146c);
                    contentValues.put(h.f37090e.name(), System.currentTimeMillis() + "");
                    Cursor cursor = null;
                    try {
                        j2 = a2.insert("PushVerifInfo", null, contentValues);
                        try {
                            cursor = a2.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                            if (cursor.moveToFirst() && cursor.getInt(0) > 200) {
                                a2.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{fVar.f37144a});
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
            synchronized (f37037b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return 0;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f37078c.name()}, null, null, null, null, null);
                    r9 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(g.f37078c.name())) : 0;
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
                String[] strArr = {h.f37088c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f37087b.name());
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
                synchronized (f37037b) {
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
                            contentValues.put(g.f37078c.name(), Long.valueOf(j2));
                            a2.update("PushShareInfo", contentValues, g.f37076a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f37026a = 0L;
                    bVar.f37027b = j2;
                    bVar.f37028c = null;
                    bVar.f37029d = null;
                    bVar.f37030e = null;
                    bVar.f37032g = null;
                    bVar.f37031f = null;
                    bVar.f37033h = null;
                    bVar.f37034i = null;
                    bVar.f37035j = null;
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
                synchronized (f37037b) {
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
                            a2.update("PushShareInfo", contentValues, g.f37076a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f37026a = 0L;
                    bVar.f37027b = 0L;
                    bVar.f37028c = null;
                    bVar.f37029d = null;
                    bVar.f37030e = null;
                    bVar.f37032g = null;
                    bVar.f37031f = null;
                    bVar.f37033h = null;
                    bVar.f37034i = str;
                    bVar.f37035j = null;
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
            synchronized (f37037b) {
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
                    contentValues.put(f.f37074g.name(), (Integer) 0);
                    a2.update("PushDataInfo", contentValues, null, null);
                    a2.execSQL("UPDATE PushDataInfo SET " + f.f37074g.name() + "=1 WHERE " + f.f37068a.name() + " IN " + sb.toString());
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
            synchronized (f37037b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                int i3 = -1;
                try {
                    cursor = a2.query("PushMsgInfos", null, e.f37067j.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
                    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                        i3 = cursor.getInt(cursor.getColumnIndex(e.f37060c.name()));
                    }
                    if (i3 != l.f37698g.b() && i3 != l.f37694c.b() && i3 != l.f37693b.b()) {
                        if (i3 != l.f37701j.b()) {
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
            synchronized (f37037b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor2 = null;
                r9 = null;
                r9 = null;
                String str = null;
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", new String[]{g.f37081f.name()}, null, null, null, null, null);
                    try {
                        str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.f37081f.name())) : null;
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
                String[] strArr = {h.f37088c.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.f37088c.name());
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
                synchronized (f37037b) {
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
                            a2.update("PushShareInfo", contentValues, g.f37076a.name() + "=1", null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f37026a = 0L;
                    bVar.f37027b = 0L;
                    bVar.f37028c = null;
                    bVar.f37029d = null;
                    bVar.f37030e = null;
                    bVar.f37032g = null;
                    bVar.f37031f = null;
                    bVar.f37033h = null;
                    bVar.f37034i = null;
                    bVar.f37035j = str;
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
            synchronized (f37037b) {
                SQLiteDatabase a2 = a(context);
                Cursor cursor = null;
                if (a2 == null) {
                    return false;
                }
                try {
                    cursor = a2.query("PushMsgInfos", new String[]{e.f37061d.name()}, e.f37061d.name() + " =? ", new String[]{String.valueOf(j2)}, null, null, null);
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
            synchronized (f37037b) {
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
            synchronized (f37037b) {
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
                    cursor = a2.query("PushDataInfo", null, f.f37068a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(f.f37074g.name())) == 1) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.f37072e.name()));
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
            synchronized (f37037b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return false;
                }
                Cursor cursor = null;
                try {
                    cursor = a2.query("PushDataInfo", null, f.f37068a.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    int i2 = cursor.getInt(cursor.getColumnIndex(f.f37069b.name()));
                    String string = cursor.getString(cursor.getColumnIndex(f.f37072e.name()));
                    if (cursor.getInt(cursor.getColumnIndex(f.f37070c.name())) != 1) {
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
                    } else if (System.currentTimeMillis() - cursor.getLong(cursor.getColumnIndex(f.f37073f.name())) > cursor.getLong(cursor.getColumnIndex(f.f37071d.name())) * 1000) {
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
            synchronized (f37037b) {
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
            synchronized (f37037b) {
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
                    cursor = a2.query("PushDataInfo", null, f.f37068a.name() + " =? ", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                str2 = cursor.getString(cursor.getColumnIndex(f.f37072e.name()));
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
            synchronized (f37037b) {
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
                Cursor query = a2.query(false, "ClickMsgUploadInfo", null, null, null, null, null, b.f37046a.name() + " DESC ", String.valueOf(b2));
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            do {
                                String string = query.getString(query.getColumnIndex(b.f37047b.name()));
                                j2 = query.getLong(query.getColumnIndex(b.f37046a.name()));
                                jSONArray.put(new JSONObject(string));
                            } while (query.moveToNext());
                            if (a2.delete("ClickMsgUploadInfo", b.f37046a.name() + " >= " + String.valueOf(j2), null) == 0) {
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
            synchronized (f37037b) {
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
            if (f37036a == null) {
                synchronized (f37037b) {
                    if (f37036a == null) {
                        File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                        SQLiteDatabase sQLiteDatabase = null;
                        if (Build.VERSION.SDK_INT >= 11) {
                            f37036a = new d(context, str, 8, new C1583c(null));
                        } else {
                            f37036a = new d(context, str, (SQLiteDatabase.CursorFactory) null, 8);
                        }
                        try {
                            SQLiteDatabase writableDatabase = f37036a.getWritableDatabase();
                            try {
                                writableDatabase.delete("PushMsgInfos", e.f37062e.name() + " < " + (System.currentTimeMillis() - 259200000), null);
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                }
                            } catch (Throwable unused) {
                                sQLiteDatabase = writableDatabase;
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                return f37036a;
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            return f37036a;
        }
        return (d) invokeL.objValue;
    }
}
