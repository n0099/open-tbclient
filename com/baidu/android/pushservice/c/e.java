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
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2983a;

    /* renamed from: b  reason: collision with root package name */
    public static String f2984b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C0034e f2985c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f2986d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f2987e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f2988a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f2989b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f2990c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f2991d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f2992e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f2993f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f2994g;
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
            f2988a = new a("ackId", 0);
            f2989b = new a("type", 1);
            f2990c = new a("value", 2);
            f2991d = new a("timestamp", 3);
            f2992e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f2993f = aVar;
            f2994g = new a[]{f2988a, f2989b, f2990c, f2991d, f2992e, aVar};
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
        public static final b f2995a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f2996b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f2997c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f2998d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f2999e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f3000f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f3001g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f3002h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f3003i;
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
            f2995a = new b("connectionId", 0);
            f2996b = new b("startTime", 1);
            f2997c = new b("stopTime", 2);
            f2998d = new b("reason", 3);
            f2999e = new b("retryTime", 4);
            f3000f = new b("retryCount", 5);
            f3001g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f3002h = bVar;
            f3003i = new b[]{f2995a, f2996b, f2997c, f2998d, f2999e, f3000f, f3001g, bVar};
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
        public static final c f3004a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f3005b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f3006c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f3007d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f3008e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f3009f;
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
            f3004a = new c("crashId", 0);
            f3005b = new c("exception", 1);
            f3006c = new c("timestamp", 2);
            f3007d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f3008e = cVar;
            f3009f = new c[]{f3004a, f3005b, f3006c, f3007d, cVar};
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
    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f3010a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f3011b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f3012c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f3013d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f3014e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f3015f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f3016g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f3017h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f3018i;
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
            f3010a = new d("dbId", 0);
            f3011b = new d("tableName", 1);
            f3012c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f3013d = new d("method", 3);
            f3014e = new d("action", 4);
            f3015f = new d("startTime", 5);
            f3016g = new d("endTime", 6);
            f3017h = new d("duration", 7);
            f3018i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            j = dVar;
            k = new d[]{f3010a, f3011b, f3012c, f3013d, f3014e, f3015f, f3016g, f3017h, f3018i, dVar};
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
    /* loaded from: classes.dex */
    public static class C0034e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f3019a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f3020b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f3021c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f3022d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f3023e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f3024f;

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
            f3019a = "CREATE TABLE crash (" + c.f3004a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f3005b.name() + " TEXT, " + c.f3006c.name() + " LONG, " + c.f3007d.name() + " TEXT, " + c.f3008e.name() + " LONG NOT NULL );";
            f3020b = "CREATE TABLE db (" + d.f3010a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f3011b.name() + " TEXT, " + d.f3012c.name() + " TEXT, " + d.f3013d.name() + " TEXT, " + d.f3014e.name() + " TEXT, " + d.f3015f.name() + " LONG, " + d.f3016g.name() + " LONG, " + d.f3017h.name() + " LONG, " + d.f3018i.name() + " TEXT, " + d.j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f2995a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f2996b.name());
            sb.append(" LONG, ");
            sb.append(b.f2997c.name());
            sb.append(" LONG, ");
            sb.append(b.f2998d.name());
            sb.append(" TEXT, ");
            sb.append(b.f2999e.name());
            sb.append(" LONG, ");
            sb.append(b.f3000f.name());
            sb.append(" LONG, ");
            sb.append(b.f3001g.name());
            sb.append(" TEXT, ");
            sb.append(b.f3002h.name());
            sb.append(" LONG NOT NULL );");
            f3021c = sb.toString();
            f3022d = "CREATE TABLE request (" + f.f3025a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f3026b.name() + " TEXT, " + f.f3027c.name() + " TEXT, " + f.f3028d.name() + " LONG, " + f.f3029e.name() + " LONG, " + f.f3030f.name() + " LONG, " + f.f3031g.name() + " TEXT, " + f.f3032h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f2988a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f2989b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f2990c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f2991d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f2992e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f2993f.name());
            sb2.append(" LONG NOT NULL);");
            f3023e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0034e(Context context, String str, int i2) {
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
            this.f3024f = context;
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
                    sQLiteDatabase.execSQL(f3019a);
                    sQLiteDatabase.execSQL(f3020b);
                    sQLiteDatabase.execSQL(f3021c);
                    sQLiteDatabase.execSQL(f3022d);
                    sQLiteDatabase.execSQL(f3023e);
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
        public static final f f3025a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f3026b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f3027c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f3028d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f3029e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f3030f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f3031g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f3032h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f3033i;
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
            f3025a = new f("id", 0);
            f3026b = new f("method", 1);
            f3027c = new f("requestId", 2);
            f3028d = new f("timestamp", 3);
            f3029e = new f("responseTime", 4);
            f3030f = new f("errorCode", 5);
            f3031g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f3032h = fVar;
            f3033i = new f[]{f3025a, f3026b, f3027c, f3028d, f3029e, f3030f, f3031g, fVar};
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
        f2983a = new Object();
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
        this.f2987e = context;
        f2985c = new C0034e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f2986d == null) {
                synchronized (f2983a) {
                    if (f2986d == null) {
                        f2986d = new e(context.getApplicationContext());
                    }
                }
            }
            return f2986d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f2985c == null) {
                f2985c = new C0034e(context, "push_track.db", 1);
            }
            try {
                return f2985c.getWritableDatabase();
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
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
                            cVar.f2856a = rawQuery.getString(rawQuery.getColumnIndex(c.f3005b.name()));
                            cVar.f2857b = rawQuery.getLong(rawQuery.getColumnIndex(c.f3006c.name()));
                            cVar.f2858c = rawQuery.getString(rawQuery.getColumnIndex(c.f3007d.name()));
                            cVar.f2859d = rawQuery.getLong(rawQuery.getColumnIndex(c.f3008e.name()));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f2989b.name(), aVar.f2827a);
                    contentValues.put(a.f2990c.name(), aVar.f2828b);
                    contentValues.put(a.f2991d.name(), Long.valueOf(aVar.f2829c));
                    contentValues.put(a.f2992e.name(), aVar.f2830d);
                    contentValues.put(a.f2993f.name(), Long.valueOf(aVar.f2831e));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f2996b.name(), Long.valueOf(bVar.f2840a));
                    contentValues.put(b.f2997c.name(), Long.valueOf(bVar.f2841b));
                    contentValues.put(b.f2998d.name(), bVar.f2842c);
                    contentValues.put(b.f2999e.name(), Long.valueOf(bVar.f2843d));
                    contentValues.put(b.f3000f.name(), Long.valueOf(bVar.f2844e));
                    contentValues.put(b.f3001g.name(), bVar.f2845f);
                    contentValues.put(b.f3002h.name(), Long.valueOf(bVar.f2846g));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f3005b.name(), cVar.f2856a);
                    contentValues.put(c.f3006c.name(), Long.valueOf(cVar.f2857b));
                    contentValues.put(c.f3007d.name(), cVar.f2858c);
                    contentValues.put(c.f3008e.name(), Long.valueOf(cVar.f2859d));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f3011b.name(), dVar.f2869a);
                    contentValues.put(d.f3012c.name(), dVar.f2870b);
                    contentValues.put(d.f3013d.name(), dVar.f2871c);
                    contentValues.put(d.f3014e.name(), dVar.f2872d);
                    contentValues.put(d.f3015f.name(), Long.valueOf(dVar.f2873e));
                    contentValues.put(d.f3016g.name(), Long.valueOf(dVar.f2874f));
                    contentValues.put(d.f3017h.name(), Long.valueOf(dVar.f2875g));
                    contentValues.put(d.f3018i.name(), dVar.f2876h);
                    contentValues.put(d.j.name(), Long.valueOf(dVar.f2877i));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f3026b.name(), eVar.f2878a);
                    contentValues.put(f.f3027c.name(), eVar.f2879b);
                    contentValues.put(f.f3028d.name(), Long.valueOf(eVar.f2880c));
                    contentValues.put(f.f3029e.name(), Long.valueOf(eVar.f2881d));
                    contentValues.put(f.f3030f.name(), Long.valueOf(eVar.f2882e));
                    contentValues.put(f.f3031g.name(), eVar.f2883f);
                    contentValues.put(f.f3032h.name(), Long.valueOf(eVar.f2884g));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
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
                        dVar.f2869a = cursor.getString(cursor.getColumnIndex(d.f3011b.name()));
                        dVar.f2870b = cursor.getString(cursor.getColumnIndex(d.f3012c.name()));
                        dVar.f2871c = cursor.getString(cursor.getColumnIndex(d.f3013d.name()));
                        dVar.f2872d = cursor.getString(cursor.getColumnIndex(d.f3014e.name()));
                        dVar.f2873e = cursor.getLong(cursor.getColumnIndex(d.f3015f.name()));
                        dVar.f2874f = cursor.getLong(cursor.getColumnIndex(d.f3016g.name()));
                        dVar.f2875g = cursor.getLong(cursor.getColumnIndex(d.f3017h.name()));
                        dVar.f2876h = cursor.getString(cursor.getColumnIndex(d.f3018i.name()));
                        dVar.f2877i = cursor.getLong(cursor.getColumnIndex(d.j.name()));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
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
                        bVar.f2840a = cursor.getLong(cursor.getColumnIndex(b.f2996b.name()));
                        bVar.f2841b = cursor.getLong(cursor.getColumnIndex(b.f2997c.name()));
                        bVar.f2842c = cursor.getString(cursor.getColumnIndex(b.f2998d.name()));
                        bVar.f2843d = cursor.getLong(cursor.getColumnIndex(b.f2999e.name()));
                        bVar.f2844e = cursor.getLong(cursor.getColumnIndex(b.f3000f.name()));
                        bVar.f2845f = cursor.getString(cursor.getColumnIndex(b.f3001g.name()));
                        bVar.f2846g = cursor.getLong(cursor.getColumnIndex(b.f3002h.name()));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
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
                        eVar.f2878a = cursor.getString(cursor.getColumnIndex(f.f3026b.name()));
                        eVar.f2879b = cursor.getString(cursor.getColumnIndex(f.f3027c.name()));
                        eVar.f2880c = cursor.getLong(cursor.getColumnIndex(f.f3028d.name()));
                        eVar.f2881d = cursor.getLong(cursor.getColumnIndex(f.f3029e.name()));
                        eVar.f2882e = cursor.getLong(cursor.getColumnIndex(f.f3030f.name()));
                        eVar.f2883f = cursor.getString(cursor.getColumnIndex(f.f3031g.name()));
                        eVar.f2884g = cursor.getLong(cursor.getColumnIndex(f.f3032h.name()));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
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
                        aVar.f2827a = cursor.getString(cursor.getColumnIndex(a.f2989b.name()));
                        aVar.f2828b = cursor.getString(cursor.getColumnIndex(a.f2990c.name()));
                        aVar.f2829c = cursor.getLong(cursor.getColumnIndex(a.f2991d.name()));
                        aVar.f2830d = cursor.getString(cursor.getColumnIndex(a.f2992e.name()));
                        aVar.f2831e = cursor.getLong(cursor.getColumnIndex(a.f2993f.name()));
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
            synchronized (f2983a) {
                SQLiteDatabase b2 = b(this.f2987e);
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
