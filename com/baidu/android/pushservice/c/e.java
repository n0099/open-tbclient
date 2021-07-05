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
    public static final Object f2954a;

    /* renamed from: b  reason: collision with root package name */
    public static String f2955b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C0034e f2956c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f2957d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f2958e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f2959a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f2960b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f2961c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f2962d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f2963e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f2964f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f2965g;
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
            f2959a = new a("ackId", 0);
            f2960b = new a("type", 1);
            f2961c = new a("value", 2);
            f2962d = new a("timestamp", 3);
            f2963e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f2964f = aVar;
            f2965g = new a[]{f2959a, f2960b, f2961c, f2962d, f2963e, aVar};
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
        public static final b f2966a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f2967b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f2968c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f2969d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f2970e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f2971f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f2972g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f2973h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f2974i;
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
            f2966a = new b("connectionId", 0);
            f2967b = new b("startTime", 1);
            f2968c = new b("stopTime", 2);
            f2969d = new b("reason", 3);
            f2970e = new b("retryTime", 4);
            f2971f = new b("retryCount", 5);
            f2972g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f2973h = bVar;
            f2974i = new b[]{f2966a, f2967b, f2968c, f2969d, f2970e, f2971f, f2972g, bVar};
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
        public static final c f2975a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f2976b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f2977c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f2978d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f2979e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f2980f;
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
            f2975a = new c("crashId", 0);
            f2976b = new c("exception", 1);
            f2977c = new c("timestamp", 2);
            f2978d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f2979e = cVar;
            f2980f = new c[]{f2975a, f2976b, f2977c, f2978d, cVar};
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
        public static final d f2981a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f2982b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f2983c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f2984d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f2985e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f2986f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f2987g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f2988h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f2989i;
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
            f2981a = new d("dbId", 0);
            f2982b = new d("tableName", 1);
            f2983c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f2984d = new d("method", 3);
            f2985e = new d("action", 4);
            f2986f = new d("startTime", 5);
            f2987g = new d("endTime", 6);
            f2988h = new d("duration", 7);
            f2989i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            j = dVar;
            k = new d[]{f2981a, f2982b, f2983c, f2984d, f2985e, f2986f, f2987g, f2988h, f2989i, dVar};
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
        public static final String f2990a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f2991b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f2992c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2993d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2994e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f2995f;

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
            f2990a = "CREATE TABLE crash (" + c.f2975a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f2976b.name() + " TEXT, " + c.f2977c.name() + " LONG, " + c.f2978d.name() + " TEXT, " + c.f2979e.name() + " LONG NOT NULL );";
            f2991b = "CREATE TABLE db (" + d.f2981a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f2982b.name() + " TEXT, " + d.f2983c.name() + " TEXT, " + d.f2984d.name() + " TEXT, " + d.f2985e.name() + " TEXT, " + d.f2986f.name() + " LONG, " + d.f2987g.name() + " LONG, " + d.f2988h.name() + " LONG, " + d.f2989i.name() + " TEXT, " + d.j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f2966a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f2967b.name());
            sb.append(" LONG, ");
            sb.append(b.f2968c.name());
            sb.append(" LONG, ");
            sb.append(b.f2969d.name());
            sb.append(" TEXT, ");
            sb.append(b.f2970e.name());
            sb.append(" LONG, ");
            sb.append(b.f2971f.name());
            sb.append(" LONG, ");
            sb.append(b.f2972g.name());
            sb.append(" TEXT, ");
            sb.append(b.f2973h.name());
            sb.append(" LONG NOT NULL );");
            f2992c = sb.toString();
            f2993d = "CREATE TABLE request (" + f.f2996a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f2997b.name() + " TEXT, " + f.f2998c.name() + " TEXT, " + f.f2999d.name() + " LONG, " + f.f3000e.name() + " LONG, " + f.f3001f.name() + " LONG, " + f.f3002g.name() + " TEXT, " + f.f3003h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f2959a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f2960b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f2961c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f2962d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f2963e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f2964f.name());
            sb2.append(" LONG NOT NULL);");
            f2994e = sb2.toString();
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
            this.f2995f = context;
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
                    sQLiteDatabase.execSQL(f2990a);
                    sQLiteDatabase.execSQL(f2991b);
                    sQLiteDatabase.execSQL(f2992c);
                    sQLiteDatabase.execSQL(f2993d);
                    sQLiteDatabase.execSQL(f2994e);
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
        public static final f f2996a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f2997b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f2998c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f2999d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f3000e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f3001f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f3002g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f3003h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f3004i;
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
            f2996a = new f("id", 0);
            f2997b = new f("method", 1);
            f2998c = new f("requestId", 2);
            f2999d = new f("timestamp", 3);
            f3000e = new f("responseTime", 4);
            f3001f = new f("errorCode", 5);
            f3002g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f3003h = fVar;
            f3004i = new f[]{f2996a, f2997b, f2998c, f2999d, f3000e, f3001f, f3002g, fVar};
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
        f2954a = new Object();
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
        this.f2958e = context;
        f2956c = new C0034e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f2957d == null) {
                synchronized (f2954a) {
                    if (f2957d == null) {
                        f2957d = new e(context.getApplicationContext());
                    }
                }
            }
            return f2957d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f2956c == null) {
                f2956c = new C0034e(context, "push_track.db", 1);
            }
            try {
                return f2956c.getWritableDatabase();
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
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
                            cVar.f2827a = rawQuery.getString(rawQuery.getColumnIndex(c.f2976b.name()));
                            cVar.f2828b = rawQuery.getLong(rawQuery.getColumnIndex(c.f2977c.name()));
                            cVar.f2829c = rawQuery.getString(rawQuery.getColumnIndex(c.f2978d.name()));
                            cVar.f2830d = rawQuery.getLong(rawQuery.getColumnIndex(c.f2979e.name()));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f2960b.name(), aVar.f2798a);
                    contentValues.put(a.f2961c.name(), aVar.f2799b);
                    contentValues.put(a.f2962d.name(), Long.valueOf(aVar.f2800c));
                    contentValues.put(a.f2963e.name(), aVar.f2801d);
                    contentValues.put(a.f2964f.name(), Long.valueOf(aVar.f2802e));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f2967b.name(), Long.valueOf(bVar.f2811a));
                    contentValues.put(b.f2968c.name(), Long.valueOf(bVar.f2812b));
                    contentValues.put(b.f2969d.name(), bVar.f2813c);
                    contentValues.put(b.f2970e.name(), Long.valueOf(bVar.f2814d));
                    contentValues.put(b.f2971f.name(), Long.valueOf(bVar.f2815e));
                    contentValues.put(b.f2972g.name(), bVar.f2816f);
                    contentValues.put(b.f2973h.name(), Long.valueOf(bVar.f2817g));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f2976b.name(), cVar.f2827a);
                    contentValues.put(c.f2977c.name(), Long.valueOf(cVar.f2828b));
                    contentValues.put(c.f2978d.name(), cVar.f2829c);
                    contentValues.put(c.f2979e.name(), Long.valueOf(cVar.f2830d));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f2982b.name(), dVar.f2840a);
                    contentValues.put(d.f2983c.name(), dVar.f2841b);
                    contentValues.put(d.f2984d.name(), dVar.f2842c);
                    contentValues.put(d.f2985e.name(), dVar.f2843d);
                    contentValues.put(d.f2986f.name(), Long.valueOf(dVar.f2844e));
                    contentValues.put(d.f2987g.name(), Long.valueOf(dVar.f2845f));
                    contentValues.put(d.f2988h.name(), Long.valueOf(dVar.f2846g));
                    contentValues.put(d.f2989i.name(), dVar.f2847h);
                    contentValues.put(d.j.name(), Long.valueOf(dVar.f2848i));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f2997b.name(), eVar.f2849a);
                    contentValues.put(f.f2998c.name(), eVar.f2850b);
                    contentValues.put(f.f2999d.name(), Long.valueOf(eVar.f2851c));
                    contentValues.put(f.f3000e.name(), Long.valueOf(eVar.f2852d));
                    contentValues.put(f.f3001f.name(), Long.valueOf(eVar.f2853e));
                    contentValues.put(f.f3002g.name(), eVar.f2854f);
                    contentValues.put(f.f3003h.name(), Long.valueOf(eVar.f2855g));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
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
                        dVar.f2840a = cursor.getString(cursor.getColumnIndex(d.f2982b.name()));
                        dVar.f2841b = cursor.getString(cursor.getColumnIndex(d.f2983c.name()));
                        dVar.f2842c = cursor.getString(cursor.getColumnIndex(d.f2984d.name()));
                        dVar.f2843d = cursor.getString(cursor.getColumnIndex(d.f2985e.name()));
                        dVar.f2844e = cursor.getLong(cursor.getColumnIndex(d.f2986f.name()));
                        dVar.f2845f = cursor.getLong(cursor.getColumnIndex(d.f2987g.name()));
                        dVar.f2846g = cursor.getLong(cursor.getColumnIndex(d.f2988h.name()));
                        dVar.f2847h = cursor.getString(cursor.getColumnIndex(d.f2989i.name()));
                        dVar.f2848i = cursor.getLong(cursor.getColumnIndex(d.j.name()));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
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
                        bVar.f2811a = cursor.getLong(cursor.getColumnIndex(b.f2967b.name()));
                        bVar.f2812b = cursor.getLong(cursor.getColumnIndex(b.f2968c.name()));
                        bVar.f2813c = cursor.getString(cursor.getColumnIndex(b.f2969d.name()));
                        bVar.f2814d = cursor.getLong(cursor.getColumnIndex(b.f2970e.name()));
                        bVar.f2815e = cursor.getLong(cursor.getColumnIndex(b.f2971f.name()));
                        bVar.f2816f = cursor.getString(cursor.getColumnIndex(b.f2972g.name()));
                        bVar.f2817g = cursor.getLong(cursor.getColumnIndex(b.f2973h.name()));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
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
                        eVar.f2849a = cursor.getString(cursor.getColumnIndex(f.f2997b.name()));
                        eVar.f2850b = cursor.getString(cursor.getColumnIndex(f.f2998c.name()));
                        eVar.f2851c = cursor.getLong(cursor.getColumnIndex(f.f2999d.name()));
                        eVar.f2852d = cursor.getLong(cursor.getColumnIndex(f.f3000e.name()));
                        eVar.f2853e = cursor.getLong(cursor.getColumnIndex(f.f3001f.name()));
                        eVar.f2854f = cursor.getString(cursor.getColumnIndex(f.f3002g.name()));
                        eVar.f2855g = cursor.getLong(cursor.getColumnIndex(f.f3003h.name()));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
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
                        aVar.f2798a = cursor.getString(cursor.getColumnIndex(a.f2960b.name()));
                        aVar.f2799b = cursor.getString(cursor.getColumnIndex(a.f2961c.name()));
                        aVar.f2800c = cursor.getLong(cursor.getColumnIndex(a.f2962d.name()));
                        aVar.f2801d = cursor.getString(cursor.getColumnIndex(a.f2963e.name()));
                        aVar.f2802e = cursor.getLong(cursor.getColumnIndex(a.f2964f.name()));
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
            synchronized (f2954a) {
                SQLiteDatabase b2 = b(this.f2958e);
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
