package com.baidu.android.pushservice.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f35186a;

    /* renamed from: b  reason: collision with root package name */
    public static String f35187b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1547e f35188c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f35189d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f35190e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f35191a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f35192b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f35193c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f35194d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f35195e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f35196f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f35197g;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132541913, "Lcom/baidu/android/pushservice/c/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132541913, "Lcom/baidu/android/pushservice/c/e$a;");
                    return;
                }
            }
            f35191a = new a("ackId", 0);
            f35192b = new a("type", 1);
            f35193c = new a("value", 2);
            f35194d = new a("timestamp", 3);
            f35195e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f35196f = aVar;
            f35197g = new a[]{f35191a, f35192b, f35193c, f35194d, f35195e, aVar};
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
        public static final b f35198a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f35199b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f35200c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f35201d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f35202e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f35203f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f35204g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f35205h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f35206i;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132541882, "Lcom/baidu/android/pushservice/c/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132541882, "Lcom/baidu/android/pushservice/c/e$b;");
                    return;
                }
            }
            f35198a = new b("connectionId", 0);
            f35199b = new b("startTime", 1);
            f35200c = new b("stopTime", 2);
            f35201d = new b("reason", 3);
            f35202e = new b("retryTime", 4);
            f35203f = new b("retryCount", 5);
            f35204g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f35205h = bVar;
            f35206i = new b[]{f35198a, f35199b, f35200c, f35201d, f35202e, f35203f, f35204g, bVar};
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
    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f35207a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f35208b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f35209c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f35210d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f35211e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f35212f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132541851, "Lcom/baidu/android/pushservice/c/e$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132541851, "Lcom/baidu/android/pushservice/c/e$c;");
                    return;
                }
            }
            f35207a = new c("crashId", 0);
            f35208b = new c("exception", 1);
            f35209c = new c("timestamp", 2);
            f35210d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f35211e = cVar;
            f35212f = new c[]{f35207a, f35208b, f35209c, f35210d, cVar};
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f35213a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f35214b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f35215c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f35216d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f35217e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f35218f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f35219g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f35220h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f35221i;
        public static final d j;
        public static final /* synthetic */ d[] k;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132541820, "Lcom/baidu/android/pushservice/c/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132541820, "Lcom/baidu/android/pushservice/c/e$d;");
                    return;
                }
            }
            f35213a = new d("dbId", 0);
            f35214b = new d("tableName", 1);
            f35215c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f35216d = new d("method", 3);
            f35217e = new d("action", 4);
            f35218f = new d("startTime", 5);
            f35219g = new d("endTime", 6);
            f35220h = new d("duration", 7);
            f35221i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            j = dVar;
            k = new d[]{f35213a, f35214b, f35215c, f35216d, f35217e, f35218f, f35219g, f35220h, f35221i, dVar};
        }

        public d(String str, int i2) {
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

    /* renamed from: com.baidu.android.pushservice.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1547e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f35222a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f35223b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f35224c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f35225d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f35226e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f35227f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132541789, "Lcom/baidu/android/pushservice/c/e$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132541789, "Lcom/baidu/android/pushservice/c/e$e;");
                    return;
                }
            }
            f35222a = "CREATE TABLE crash (" + c.f35207a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f35208b.name() + " TEXT, " + c.f35209c.name() + " LONG, " + c.f35210d.name() + " TEXT, " + c.f35211e.name() + " LONG NOT NULL );";
            f35223b = "CREATE TABLE db (" + d.f35213a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f35214b.name() + " TEXT, " + d.f35215c.name() + " TEXT, " + d.f35216d.name() + " TEXT, " + d.f35217e.name() + " TEXT, " + d.f35218f.name() + " LONG, " + d.f35219g.name() + " LONG, " + d.f35220h.name() + " LONG, " + d.f35221i.name() + " TEXT, " + d.j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f35198a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f35199b.name());
            sb.append(" LONG, ");
            sb.append(b.f35200c.name());
            sb.append(" LONG, ");
            sb.append(b.f35201d.name());
            sb.append(" TEXT, ");
            sb.append(b.f35202e.name());
            sb.append(" LONG, ");
            sb.append(b.f35203f.name());
            sb.append(" LONG, ");
            sb.append(b.f35204g.name());
            sb.append(" TEXT, ");
            sb.append(b.f35205h.name());
            sb.append(" LONG NOT NULL );");
            f35224c = sb.toString();
            f35225d = "CREATE TABLE request (" + f.f35228a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f35229b.name() + " TEXT, " + f.f35230c.name() + " TEXT, " + f.f35231d.name() + " LONG, " + f.f35232e.name() + " LONG, " + f.f35233f.name() + " LONG, " + f.f35234g.name() + " TEXT, " + f.f35235h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f35191a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f35192b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f35193c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f35194d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f35195e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f35196f.name());
            sb2.append(" LONG NOT NULL);");
            f35226e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1547e(Context context, String str, int i2) {
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
            this.f35227f = context;
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS connection");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS db");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(f35222a);
                    sQLiteDatabase.execSQL(f35223b);
                    sQLiteDatabase.execSQL(f35224c);
                    sQLiteDatabase.execSQL(f35225d);
                    sQLiteDatabase.execSQL(f35226e);
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
    /* loaded from: classes6.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f35228a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f35229b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f35230c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f35231d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f35232e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f35233f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f35234g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f35235h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f35236i;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132541758, "Lcom/baidu/android/pushservice/c/e$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2132541758, "Lcom/baidu/android/pushservice/c/e$f;");
                    return;
                }
            }
            f35228a = new f("id", 0);
            f35229b = new f("method", 1);
            f35230c = new f("requestId", 2);
            f35231d = new f("timestamp", 3);
            f35232e = new f("responseTime", 4);
            f35233f = new f("errorCode", 5);
            f35234g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f35235h = fVar;
            f35236i = new f[]{f35228a, f35229b, f35230c, f35231d, f35232e, f35233f, f35234g, fVar};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-677078652, "Lcom/baidu/android/pushservice/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-677078652, "Lcom/baidu/android/pushservice/c/e;");
                return;
            }
        }
        f35186a = new Object();
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35190e = context;
        f35188c = new C1547e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f35189d == null) {
                synchronized (f35186a) {
                    if (f35189d == null) {
                        f35189d = new e(context.getApplicationContext());
                    }
                }
            }
            return f35189d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f35188c == null) {
                f35188c = new C1547e(context, "push_track.db", 1);
            }
            try {
                return f35188c.getWritableDatabase();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (SQLiteDatabase) invokeL.objValue;
    }

    public List<com.baidu.android.pushservice.c.a.c> a() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                Cursor cursor2 = null;
                if (b2 == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    Cursor rawQuery = b2.rawQuery("select * from crash limit 1000", null);
                    while (rawQuery != null) {
                        try {
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
                            cVar.f35059a = rawQuery.getString(rawQuery.getColumnIndex(c.f35208b.name()));
                            cVar.f35060b = rawQuery.getLong(rawQuery.getColumnIndex(c.f35209c.name()));
                            cVar.f35061c = rawQuery.getString(rawQuery.getColumnIndex(c.f35210d.name()));
                            cVar.f35062d = rawQuery.getLong(rawQuery.getColumnIndex(c.f35211e.name()));
                            arrayList.add(cVar);
                        } catch (Exception unused) {
                            cursor = null;
                            cursor2 = rawQuery;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            b2.close();
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            cursor = null;
                            cursor2 = rawQuery;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            b2.close();
                            throw th;
                        }
                    }
                    cursor = b2.rawQuery("select count(*) from crash", null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst() && cursor.getInt(0) > 1000) {
                                b2.delete("crash", null, null);
                            }
                        } catch (Exception unused2) {
                            cursor2 = rawQuery;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            b2.close();
                            return arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = rawQuery;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            b2.close();
                            throw th;
                        }
                    }
                    if (rawQuery != null && !rawQuery.isClosed()) {
                        rawQuery.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception unused3) {
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                }
                b2.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public void a(com.baidu.android.pushservice.c.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f35192b.name(), aVar.f35030a);
                    contentValues.put(a.f35193c.name(), aVar.f35031b);
                    contentValues.put(a.f35194d.name(), Long.valueOf(aVar.f35032c));
                    contentValues.put(a.f35195e.name(), aVar.f35033d);
                    contentValues.put(a.f35196f.name(), Long.valueOf(aVar.f35034e));
                    b2.insert(IMTrackDatabase.AckEnum.TABLE_NAME, null, contentValues);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    b2.close();
                    throw th;
                }
                b2.close();
            }
        }
    }

    public void a(com.baidu.android.pushservice.c.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f35199b.name(), Long.valueOf(bVar.f35043a));
                    contentValues.put(b.f35200c.name(), Long.valueOf(bVar.f35044b));
                    contentValues.put(b.f35201d.name(), bVar.f35045c);
                    contentValues.put(b.f35202e.name(), Long.valueOf(bVar.f35046d));
                    contentValues.put(b.f35203f.name(), Long.valueOf(bVar.f35047e));
                    contentValues.put(b.f35204g.name(), bVar.f35048f);
                    contentValues.put(b.f35205h.name(), Long.valueOf(bVar.f35049g));
                    b2.insert("connection", null, contentValues);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    b2.close();
                    throw th;
                }
                b2.close();
            }
        }
    }

    public void a(com.baidu.android.pushservice.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f35208b.name(), cVar.f35059a);
                    contentValues.put(c.f35209c.name(), Long.valueOf(cVar.f35060b));
                    contentValues.put(c.f35210d.name(), cVar.f35061c);
                    contentValues.put(c.f35211e.name(), Long.valueOf(cVar.f35062d));
                    b2.insert("crash", null, contentValues);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    b2.close();
                    throw th;
                }
                b2.close();
            }
        }
    }

    public void a(com.baidu.android.pushservice.c.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f35214b.name(), dVar.f35072a);
                    contentValues.put(d.f35215c.name(), dVar.f35073b);
                    contentValues.put(d.f35216d.name(), dVar.f35074c);
                    contentValues.put(d.f35217e.name(), dVar.f35075d);
                    contentValues.put(d.f35218f.name(), Long.valueOf(dVar.f35076e));
                    contentValues.put(d.f35219g.name(), Long.valueOf(dVar.f35077f));
                    contentValues.put(d.f35220h.name(), Long.valueOf(dVar.f35078g));
                    contentValues.put(d.f35221i.name(), dVar.f35079h);
                    contentValues.put(d.j.name(), Long.valueOf(dVar.f35080i));
                    b2.insert(IMTrackDatabase.DbEnum.TABLE_NAME, null, contentValues);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    b2.close();
                    throw th;
                }
                b2.close();
            }
        }
    }

    public void a(com.baidu.android.pushservice.c.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f35229b.name(), eVar.f35081a);
                    contentValues.put(f.f35230c.name(), eVar.f35082b);
                    contentValues.put(f.f35231d.name(), Long.valueOf(eVar.f35083c));
                    contentValues.put(f.f35232e.name(), Long.valueOf(eVar.f35084d));
                    contentValues.put(f.f35233f.name(), Long.valueOf(eVar.f35085e));
                    contentValues.put(f.f35234g.name(), eVar.f35086f);
                    contentValues.put(f.f35235h.name(), Long.valueOf(eVar.f35087g));
                    b2.insert("request", null, contentValues);
                } catch (Exception unused) {
                }
                b2.close();
            }
        }
    }

    public List<com.baidu.android.pushservice.c.a.d> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                Cursor cursor = null;
                if (b2 == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = b2.rawQuery("select * from db limit 1000", null);
                    while (cursor != null) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        com.baidu.android.pushservice.c.a.d dVar = new com.baidu.android.pushservice.c.a.d();
                        dVar.f35072a = cursor.getString(cursor.getColumnIndex(d.f35214b.name()));
                        dVar.f35073b = cursor.getString(cursor.getColumnIndex(d.f35215c.name()));
                        dVar.f35074c = cursor.getString(cursor.getColumnIndex(d.f35216d.name()));
                        dVar.f35075d = cursor.getString(cursor.getColumnIndex(d.f35217e.name()));
                        dVar.f35076e = cursor.getLong(cursor.getColumnIndex(d.f35218f.name()));
                        dVar.f35077f = cursor.getLong(cursor.getColumnIndex(d.f35219g.name()));
                        dVar.f35078g = cursor.getLong(cursor.getColumnIndex(d.f35220h.name()));
                        dVar.f35079h = cursor.getString(cursor.getColumnIndex(d.f35221i.name()));
                        dVar.f35080i = cursor.getLong(cursor.getColumnIndex(d.j.name()));
                        arrayList.add(dVar);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    b2.close();
                    throw th;
                }
                b2.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public List<com.baidu.android.pushservice.c.a.b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                Cursor cursor = null;
                if (b2 == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = b2.rawQuery("select * from connection limit 1000", null);
                    while (cursor != null) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
                        bVar.f35043a = cursor.getLong(cursor.getColumnIndex(b.f35199b.name()));
                        bVar.f35044b = cursor.getLong(cursor.getColumnIndex(b.f35200c.name()));
                        bVar.f35045c = cursor.getString(cursor.getColumnIndex(b.f35201d.name()));
                        bVar.f35046d = cursor.getLong(cursor.getColumnIndex(b.f35202e.name()));
                        bVar.f35047e = cursor.getLong(cursor.getColumnIndex(b.f35203f.name()));
                        bVar.f35048f = cursor.getString(cursor.getColumnIndex(b.f35204g.name()));
                        bVar.f35049g = cursor.getLong(cursor.getColumnIndex(b.f35205h.name()));
                        arrayList.add(bVar);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    b2.close();
                    throw th;
                }
                b2.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public List<com.baidu.android.pushservice.c.a.e> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                Cursor cursor = null;
                if (b2 == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = b2.rawQuery("select * from request limit 1000", null);
                    while (cursor != null) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
                        eVar.f35081a = cursor.getString(cursor.getColumnIndex(f.f35229b.name()));
                        eVar.f35082b = cursor.getString(cursor.getColumnIndex(f.f35230c.name()));
                        eVar.f35083c = cursor.getLong(cursor.getColumnIndex(f.f35231d.name()));
                        eVar.f35084d = cursor.getLong(cursor.getColumnIndex(f.f35232e.name()));
                        eVar.f35085e = cursor.getLong(cursor.getColumnIndex(f.f35233f.name()));
                        eVar.f35086f = cursor.getString(cursor.getColumnIndex(f.f35234g.name()));
                        eVar.f35087g = cursor.getLong(cursor.getColumnIndex(f.f35235h.name()));
                        arrayList.add(eVar);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    b2.close();
                    throw th;
                }
                b2.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public List<com.baidu.android.pushservice.c.a.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                Cursor cursor = null;
                if (b2 == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = b2.rawQuery("select * from ack limit 1000", null);
                    while (cursor != null) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
                        aVar.f35030a = cursor.getString(cursor.getColumnIndex(a.f35192b.name()));
                        aVar.f35031b = cursor.getString(cursor.getColumnIndex(a.f35193c.name()));
                        aVar.f35032c = cursor.getLong(cursor.getColumnIndex(a.f35194d.name()));
                        aVar.f35033d = cursor.getString(cursor.getColumnIndex(a.f35195e.name()));
                        aVar.f35034e = cursor.getLong(cursor.getColumnIndex(a.f35196f.name()));
                        arrayList.add(aVar);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    b2.close();
                    throw th;
                }
                b2.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (f35186a) {
                SQLiteDatabase b2 = b(this.f35190e);
                if (b2 == null) {
                    return;
                }
                try {
                    b2.delete("crash", null, null);
                    b2.delete(IMTrackDatabase.DbEnum.TABLE_NAME, null, null);
                    b2.delete("connection", null, null);
                    b2.delete("request", null, null);
                    b2.delete(IMTrackDatabase.AckEnum.TABLE_NAME, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    b2.close();
                    throw th;
                }
                b2.close();
            }
        }
    }
}
