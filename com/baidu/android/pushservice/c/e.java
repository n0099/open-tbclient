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
    public static final Object f2957a;

    /* renamed from: b  reason: collision with root package name */
    public static String f2958b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C0034e f2959c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f2960d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f2961e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f2962a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f2963b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f2964c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f2965d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f2966e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f2967f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f2968g;
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
            f2962a = new a("ackId", 0);
            f2963b = new a("type", 1);
            f2964c = new a("value", 2);
            f2965d = new a("timestamp", 3);
            f2966e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f2967f = aVar;
            f2968g = new a[]{f2962a, f2963b, f2964c, f2965d, f2966e, aVar};
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
        public static final b f2969a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f2970b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f2971c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f2972d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f2973e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f2974f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f2975g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f2976h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f2977i;
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
            f2969a = new b("connectionId", 0);
            f2970b = new b("startTime", 1);
            f2971c = new b("stopTime", 2);
            f2972d = new b("reason", 3);
            f2973e = new b("retryTime", 4);
            f2974f = new b("retryCount", 5);
            f2975g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f2976h = bVar;
            f2977i = new b[]{f2969a, f2970b, f2971c, f2972d, f2973e, f2974f, f2975g, bVar};
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
        public static final c f2978a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f2979b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f2980c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f2981d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f2982e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f2983f;
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
            f2978a = new c("crashId", 0);
            f2979b = new c("exception", 1);
            f2980c = new c("timestamp", 2);
            f2981d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f2982e = cVar;
            f2983f = new c[]{f2978a, f2979b, f2980c, f2981d, cVar};
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
        public static final d f2984a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f2985b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f2986c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f2987d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f2988e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f2989f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f2990g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f2991h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f2992i;
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
            f2984a = new d("dbId", 0);
            f2985b = new d("tableName", 1);
            f2986c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f2987d = new d("method", 3);
            f2988e = new d("action", 4);
            f2989f = new d("startTime", 5);
            f2990g = new d("endTime", 6);
            f2991h = new d("duration", 7);
            f2992i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            j = dVar;
            k = new d[]{f2984a, f2985b, f2986c, f2987d, f2988e, f2989f, f2990g, f2991h, f2992i, dVar};
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
        public static final String f2993a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f2994b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f2995c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2996d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2997e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f2998f;

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
            f2993a = "CREATE TABLE crash (" + c.f2978a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f2979b.name() + " TEXT, " + c.f2980c.name() + " LONG, " + c.f2981d.name() + " TEXT, " + c.f2982e.name() + " LONG NOT NULL );";
            f2994b = "CREATE TABLE db (" + d.f2984a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f2985b.name() + " TEXT, " + d.f2986c.name() + " TEXT, " + d.f2987d.name() + " TEXT, " + d.f2988e.name() + " TEXT, " + d.f2989f.name() + " LONG, " + d.f2990g.name() + " LONG, " + d.f2991h.name() + " LONG, " + d.f2992i.name() + " TEXT, " + d.j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f2969a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f2970b.name());
            sb.append(" LONG, ");
            sb.append(b.f2971c.name());
            sb.append(" LONG, ");
            sb.append(b.f2972d.name());
            sb.append(" TEXT, ");
            sb.append(b.f2973e.name());
            sb.append(" LONG, ");
            sb.append(b.f2974f.name());
            sb.append(" LONG, ");
            sb.append(b.f2975g.name());
            sb.append(" TEXT, ");
            sb.append(b.f2976h.name());
            sb.append(" LONG NOT NULL );");
            f2995c = sb.toString();
            f2996d = "CREATE TABLE request (" + f.f2999a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f3000b.name() + " TEXT, " + f.f3001c.name() + " TEXT, " + f.f3002d.name() + " LONG, " + f.f3003e.name() + " LONG, " + f.f3004f.name() + " LONG, " + f.f3005g.name() + " TEXT, " + f.f3006h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f2962a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f2963b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f2964c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f2965d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f2966e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f2967f.name());
            sb2.append(" LONG NOT NULL);");
            f2997e = sb2.toString();
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
            this.f2998f = context;
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
                    sQLiteDatabase.execSQL(f2993a);
                    sQLiteDatabase.execSQL(f2994b);
                    sQLiteDatabase.execSQL(f2995c);
                    sQLiteDatabase.execSQL(f2996d);
                    sQLiteDatabase.execSQL(f2997e);
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
        public static final f f2999a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f3000b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f3001c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f3002d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f3003e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f3004f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f3005g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f3006h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f3007i;
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
            f2999a = new f("id", 0);
            f3000b = new f("method", 1);
            f3001c = new f("requestId", 2);
            f3002d = new f("timestamp", 3);
            f3003e = new f("responseTime", 4);
            f3004f = new f("errorCode", 5);
            f3005g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f3006h = fVar;
            f3007i = new f[]{f2999a, f3000b, f3001c, f3002d, f3003e, f3004f, f3005g, fVar};
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
        f2957a = new Object();
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
        this.f2961e = context;
        f2959c = new C0034e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f2960d == null) {
                synchronized (f2957a) {
                    if (f2960d == null) {
                        f2960d = new e(context.getApplicationContext());
                    }
                }
            }
            return f2960d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f2959c == null) {
                f2959c = new C0034e(context, "push_track.db", 1);
            }
            try {
                return f2959c.getWritableDatabase();
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
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
                            cVar.f2830a = rawQuery.getString(rawQuery.getColumnIndex(c.f2979b.name()));
                            cVar.f2831b = rawQuery.getLong(rawQuery.getColumnIndex(c.f2980c.name()));
                            cVar.f2832c = rawQuery.getString(rawQuery.getColumnIndex(c.f2981d.name()));
                            cVar.f2833d = rawQuery.getLong(rawQuery.getColumnIndex(c.f2982e.name()));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f2963b.name(), aVar.f2801a);
                    contentValues.put(a.f2964c.name(), aVar.f2802b);
                    contentValues.put(a.f2965d.name(), Long.valueOf(aVar.f2803c));
                    contentValues.put(a.f2966e.name(), aVar.f2804d);
                    contentValues.put(a.f2967f.name(), Long.valueOf(aVar.f2805e));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f2970b.name(), Long.valueOf(bVar.f2814a));
                    contentValues.put(b.f2971c.name(), Long.valueOf(bVar.f2815b));
                    contentValues.put(b.f2972d.name(), bVar.f2816c);
                    contentValues.put(b.f2973e.name(), Long.valueOf(bVar.f2817d));
                    contentValues.put(b.f2974f.name(), Long.valueOf(bVar.f2818e));
                    contentValues.put(b.f2975g.name(), bVar.f2819f);
                    contentValues.put(b.f2976h.name(), Long.valueOf(bVar.f2820g));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f2979b.name(), cVar.f2830a);
                    contentValues.put(c.f2980c.name(), Long.valueOf(cVar.f2831b));
                    contentValues.put(c.f2981d.name(), cVar.f2832c);
                    contentValues.put(c.f2982e.name(), Long.valueOf(cVar.f2833d));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f2985b.name(), dVar.f2843a);
                    contentValues.put(d.f2986c.name(), dVar.f2844b);
                    contentValues.put(d.f2987d.name(), dVar.f2845c);
                    contentValues.put(d.f2988e.name(), dVar.f2846d);
                    contentValues.put(d.f2989f.name(), Long.valueOf(dVar.f2847e));
                    contentValues.put(d.f2990g.name(), Long.valueOf(dVar.f2848f));
                    contentValues.put(d.f2991h.name(), Long.valueOf(dVar.f2849g));
                    contentValues.put(d.f2992i.name(), dVar.f2850h);
                    contentValues.put(d.j.name(), Long.valueOf(dVar.f2851i));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f3000b.name(), eVar.f2852a);
                    contentValues.put(f.f3001c.name(), eVar.f2853b);
                    contentValues.put(f.f3002d.name(), Long.valueOf(eVar.f2854c));
                    contentValues.put(f.f3003e.name(), Long.valueOf(eVar.f2855d));
                    contentValues.put(f.f3004f.name(), Long.valueOf(eVar.f2856e));
                    contentValues.put(f.f3005g.name(), eVar.f2857f);
                    contentValues.put(f.f3006h.name(), Long.valueOf(eVar.f2858g));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
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
                        dVar.f2843a = cursor.getString(cursor.getColumnIndex(d.f2985b.name()));
                        dVar.f2844b = cursor.getString(cursor.getColumnIndex(d.f2986c.name()));
                        dVar.f2845c = cursor.getString(cursor.getColumnIndex(d.f2987d.name()));
                        dVar.f2846d = cursor.getString(cursor.getColumnIndex(d.f2988e.name()));
                        dVar.f2847e = cursor.getLong(cursor.getColumnIndex(d.f2989f.name()));
                        dVar.f2848f = cursor.getLong(cursor.getColumnIndex(d.f2990g.name()));
                        dVar.f2849g = cursor.getLong(cursor.getColumnIndex(d.f2991h.name()));
                        dVar.f2850h = cursor.getString(cursor.getColumnIndex(d.f2992i.name()));
                        dVar.f2851i = cursor.getLong(cursor.getColumnIndex(d.j.name()));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
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
                        bVar.f2814a = cursor.getLong(cursor.getColumnIndex(b.f2970b.name()));
                        bVar.f2815b = cursor.getLong(cursor.getColumnIndex(b.f2971c.name()));
                        bVar.f2816c = cursor.getString(cursor.getColumnIndex(b.f2972d.name()));
                        bVar.f2817d = cursor.getLong(cursor.getColumnIndex(b.f2973e.name()));
                        bVar.f2818e = cursor.getLong(cursor.getColumnIndex(b.f2974f.name()));
                        bVar.f2819f = cursor.getString(cursor.getColumnIndex(b.f2975g.name()));
                        bVar.f2820g = cursor.getLong(cursor.getColumnIndex(b.f2976h.name()));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
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
                        eVar.f2852a = cursor.getString(cursor.getColumnIndex(f.f3000b.name()));
                        eVar.f2853b = cursor.getString(cursor.getColumnIndex(f.f3001c.name()));
                        eVar.f2854c = cursor.getLong(cursor.getColumnIndex(f.f3002d.name()));
                        eVar.f2855d = cursor.getLong(cursor.getColumnIndex(f.f3003e.name()));
                        eVar.f2856e = cursor.getLong(cursor.getColumnIndex(f.f3004f.name()));
                        eVar.f2857f = cursor.getString(cursor.getColumnIndex(f.f3005g.name()));
                        eVar.f2858g = cursor.getLong(cursor.getColumnIndex(f.f3006h.name()));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
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
                        aVar.f2801a = cursor.getString(cursor.getColumnIndex(a.f2963b.name()));
                        aVar.f2802b = cursor.getString(cursor.getColumnIndex(a.f2964c.name()));
                        aVar.f2803c = cursor.getLong(cursor.getColumnIndex(a.f2965d.name()));
                        aVar.f2804d = cursor.getString(cursor.getColumnIndex(a.f2966e.name()));
                        aVar.f2805e = cursor.getLong(cursor.getColumnIndex(a.f2967f.name()));
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
            synchronized (f2957a) {
                SQLiteDatabase b2 = b(this.f2961e);
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
