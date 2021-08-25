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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f36973a;

    /* renamed from: b  reason: collision with root package name */
    public static String f36974b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1584e f36975c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f36976d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f36977e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f36978a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f36979b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f36980c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f36981d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f36982e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f36983f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f36984g;
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
            f36978a = new a("ackId", 0);
            f36979b = new a("type", 1);
            f36980c = new a("value", 2);
            f36981d = new a("timestamp", 3);
            f36982e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f36983f = aVar;
            f36984g = new a[]{f36978a, f36979b, f36980c, f36981d, f36982e, aVar};
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
        public static final b f36985a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f36986b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f36987c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f36988d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f36989e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f36990f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f36991g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f36992h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f36993i;
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
            f36985a = new b("connectionId", 0);
            f36986b = new b("startTime", 1);
            f36987c = new b("stopTime", 2);
            f36988d = new b("reason", 3);
            f36989e = new b("retryTime", 4);
            f36990f = new b("retryCount", 5);
            f36991g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f36992h = bVar;
            f36993i = new b[]{f36985a, f36986b, f36987c, f36988d, f36989e, f36990f, f36991g, bVar};
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
    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f36994a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f36995b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f36996c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f36997d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f36998e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f36999f;
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
            f36994a = new c("crashId", 0);
            f36995b = new c("exception", 1);
            f36996c = new c("timestamp", 2);
            f36997d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f36998e = cVar;
            f36999f = new c[]{f36994a, f36995b, f36996c, f36997d, cVar};
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
    /* loaded from: classes4.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f37000a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f37001b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f37002c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f37003d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f37004e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f37005f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f37006g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f37007h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f37008i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f37009j;
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
            f37000a = new d("dbId", 0);
            f37001b = new d("tableName", 1);
            f37002c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f37003d = new d("method", 3);
            f37004e = new d("action", 4);
            f37005f = new d("startTime", 5);
            f37006g = new d("endTime", 6);
            f37007h = new d("duration", 7);
            f37008i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f37009j = dVar;
            k = new d[]{f37000a, f37001b, f37002c, f37003d, f37004e, f37005f, f37006g, f37007h, f37008i, dVar};
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
    /* loaded from: classes4.dex */
    public static class C1584e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f37010a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f37011b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f37012c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f37013d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f37014e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f37015f;

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
            f37010a = "CREATE TABLE crash (" + c.f36994a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f36995b.name() + " TEXT, " + c.f36996c.name() + " LONG, " + c.f36997d.name() + " TEXT, " + c.f36998e.name() + " LONG NOT NULL );";
            f37011b = "CREATE TABLE db (" + d.f37000a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f37001b.name() + " TEXT, " + d.f37002c.name() + " TEXT, " + d.f37003d.name() + " TEXT, " + d.f37004e.name() + " TEXT, " + d.f37005f.name() + " LONG, " + d.f37006g.name() + " LONG, " + d.f37007h.name() + " LONG, " + d.f37008i.name() + " TEXT, " + d.f37009j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f36985a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f36986b.name());
            sb.append(" LONG, ");
            sb.append(b.f36987c.name());
            sb.append(" LONG, ");
            sb.append(b.f36988d.name());
            sb.append(" TEXT, ");
            sb.append(b.f36989e.name());
            sb.append(" LONG, ");
            sb.append(b.f36990f.name());
            sb.append(" LONG, ");
            sb.append(b.f36991g.name());
            sb.append(" TEXT, ");
            sb.append(b.f36992h.name());
            sb.append(" LONG NOT NULL );");
            f37012c = sb.toString();
            f37013d = "CREATE TABLE request (" + f.f37016a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f37017b.name() + " TEXT, " + f.f37018c.name() + " TEXT, " + f.f37019d.name() + " LONG, " + f.f37020e.name() + " LONG, " + f.f37021f.name() + " LONG, " + f.f37022g.name() + " TEXT, " + f.f37023h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f36978a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f36979b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f36980c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f36981d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f36982e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f36983f.name());
            sb2.append(" LONG NOT NULL);");
            f37014e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1584e(Context context, String str, int i2) {
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
            this.f37015f = context;
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
                    sQLiteDatabase.execSQL(f37010a);
                    sQLiteDatabase.execSQL(f37011b);
                    sQLiteDatabase.execSQL(f37012c);
                    sQLiteDatabase.execSQL(f37013d);
                    sQLiteDatabase.execSQL(f37014e);
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
    /* loaded from: classes4.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f37016a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f37017b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f37018c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f37019d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f37020e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f37021f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f37022g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f37023h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f37024i;
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
            f37016a = new f("id", 0);
            f37017b = new f("method", 1);
            f37018c = new f("requestId", 2);
            f37019d = new f("timestamp", 3);
            f37020e = new f("responseTime", 4);
            f37021f = new f("errorCode", 5);
            f37022g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f37023h = fVar;
            f37024i = new f[]{f37016a, f37017b, f37018c, f37019d, f37020e, f37021f, f37022g, fVar};
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
        f36973a = new Object();
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
        this.f36977e = context;
        f36975c = new C1584e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f36976d == null) {
                synchronized (f36973a) {
                    if (f36976d == null) {
                        f36976d = new e(context.getApplicationContext());
                    }
                }
            }
            return f36976d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f36975c == null) {
                f36975c = new C1584e(context, "push_track.db", 1);
            }
            try {
                return f36975c.getWritableDatabase();
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
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
                            cVar.f36841a = rawQuery.getString(rawQuery.getColumnIndex(c.f36995b.name()));
                            cVar.f36842b = rawQuery.getLong(rawQuery.getColumnIndex(c.f36996c.name()));
                            cVar.f36843c = rawQuery.getString(rawQuery.getColumnIndex(c.f36997d.name()));
                            cVar.f36844d = rawQuery.getLong(rawQuery.getColumnIndex(c.f36998e.name()));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f36979b.name(), aVar.f36811a);
                    contentValues.put(a.f36980c.name(), aVar.f36812b);
                    contentValues.put(a.f36981d.name(), Long.valueOf(aVar.f36813c));
                    contentValues.put(a.f36982e.name(), aVar.f36814d);
                    contentValues.put(a.f36983f.name(), Long.valueOf(aVar.f36815e));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f36986b.name(), Long.valueOf(bVar.f36824a));
                    contentValues.put(b.f36987c.name(), Long.valueOf(bVar.f36825b));
                    contentValues.put(b.f36988d.name(), bVar.f36826c);
                    contentValues.put(b.f36989e.name(), Long.valueOf(bVar.f36827d));
                    contentValues.put(b.f36990f.name(), Long.valueOf(bVar.f36828e));
                    contentValues.put(b.f36991g.name(), bVar.f36829f);
                    contentValues.put(b.f36992h.name(), Long.valueOf(bVar.f36830g));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f36995b.name(), cVar.f36841a);
                    contentValues.put(c.f36996c.name(), Long.valueOf(cVar.f36842b));
                    contentValues.put(c.f36997d.name(), cVar.f36843c);
                    contentValues.put(c.f36998e.name(), Long.valueOf(cVar.f36844d));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f37001b.name(), dVar.f36855a);
                    contentValues.put(d.f37002c.name(), dVar.f36856b);
                    contentValues.put(d.f37003d.name(), dVar.f36857c);
                    contentValues.put(d.f37004e.name(), dVar.f36858d);
                    contentValues.put(d.f37005f.name(), Long.valueOf(dVar.f36859e));
                    contentValues.put(d.f37006g.name(), Long.valueOf(dVar.f36860f));
                    contentValues.put(d.f37007h.name(), Long.valueOf(dVar.f36861g));
                    contentValues.put(d.f37008i.name(), dVar.f36862h);
                    contentValues.put(d.f37009j.name(), Long.valueOf(dVar.f36863i));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f37017b.name(), eVar.f36864a);
                    contentValues.put(f.f37018c.name(), eVar.f36865b);
                    contentValues.put(f.f37019d.name(), Long.valueOf(eVar.f36866c));
                    contentValues.put(f.f37020e.name(), Long.valueOf(eVar.f36867d));
                    contentValues.put(f.f37021f.name(), Long.valueOf(eVar.f36868e));
                    contentValues.put(f.f37022g.name(), eVar.f36869f);
                    contentValues.put(f.f37023h.name(), Long.valueOf(eVar.f36870g));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
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
                        dVar.f36855a = cursor.getString(cursor.getColumnIndex(d.f37001b.name()));
                        dVar.f36856b = cursor.getString(cursor.getColumnIndex(d.f37002c.name()));
                        dVar.f36857c = cursor.getString(cursor.getColumnIndex(d.f37003d.name()));
                        dVar.f36858d = cursor.getString(cursor.getColumnIndex(d.f37004e.name()));
                        dVar.f36859e = cursor.getLong(cursor.getColumnIndex(d.f37005f.name()));
                        dVar.f36860f = cursor.getLong(cursor.getColumnIndex(d.f37006g.name()));
                        dVar.f36861g = cursor.getLong(cursor.getColumnIndex(d.f37007h.name()));
                        dVar.f36862h = cursor.getString(cursor.getColumnIndex(d.f37008i.name()));
                        dVar.f36863i = cursor.getLong(cursor.getColumnIndex(d.f37009j.name()));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
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
                        bVar.f36824a = cursor.getLong(cursor.getColumnIndex(b.f36986b.name()));
                        bVar.f36825b = cursor.getLong(cursor.getColumnIndex(b.f36987c.name()));
                        bVar.f36826c = cursor.getString(cursor.getColumnIndex(b.f36988d.name()));
                        bVar.f36827d = cursor.getLong(cursor.getColumnIndex(b.f36989e.name()));
                        bVar.f36828e = cursor.getLong(cursor.getColumnIndex(b.f36990f.name()));
                        bVar.f36829f = cursor.getString(cursor.getColumnIndex(b.f36991g.name()));
                        bVar.f36830g = cursor.getLong(cursor.getColumnIndex(b.f36992h.name()));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
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
                        eVar.f36864a = cursor.getString(cursor.getColumnIndex(f.f37017b.name()));
                        eVar.f36865b = cursor.getString(cursor.getColumnIndex(f.f37018c.name()));
                        eVar.f36866c = cursor.getLong(cursor.getColumnIndex(f.f37019d.name()));
                        eVar.f36867d = cursor.getLong(cursor.getColumnIndex(f.f37020e.name()));
                        eVar.f36868e = cursor.getLong(cursor.getColumnIndex(f.f37021f.name()));
                        eVar.f36869f = cursor.getString(cursor.getColumnIndex(f.f37022g.name()));
                        eVar.f36870g = cursor.getLong(cursor.getColumnIndex(f.f37023h.name()));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
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
                        aVar.f36811a = cursor.getString(cursor.getColumnIndex(a.f36979b.name()));
                        aVar.f36812b = cursor.getString(cursor.getColumnIndex(a.f36980c.name()));
                        aVar.f36813c = cursor.getLong(cursor.getColumnIndex(a.f36981d.name()));
                        aVar.f36814d = cursor.getString(cursor.getColumnIndex(a.f36982e.name()));
                        aVar.f36815e = cursor.getLong(cursor.getColumnIndex(a.f36983f.name()));
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
            synchronized (f36973a) {
                SQLiteDatabase b2 = b(this.f36977e);
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
