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
    public static final Object f37144a;

    /* renamed from: b  reason: collision with root package name */
    public static String f37145b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1590e f37146c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f37147d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f37148e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f37149a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f37150b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f37151c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f37152d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f37153e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f37154f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f37155g;
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
            f37149a = new a("ackId", 0);
            f37150b = new a("type", 1);
            f37151c = new a("value", 2);
            f37152d = new a("timestamp", 3);
            f37153e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f37154f = aVar;
            f37155g = new a[]{f37149a, f37150b, f37151c, f37152d, f37153e, aVar};
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
        public static final b f37156a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f37157b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f37158c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f37159d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f37160e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f37161f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f37162g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f37163h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f37164i;
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
            f37156a = new b("connectionId", 0);
            f37157b = new b("startTime", 1);
            f37158c = new b("stopTime", 2);
            f37159d = new b("reason", 3);
            f37160e = new b("retryTime", 4);
            f37161f = new b("retryCount", 5);
            f37162g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f37163h = bVar;
            f37164i = new b[]{f37156a, f37157b, f37158c, f37159d, f37160e, f37161f, f37162g, bVar};
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
        public static final c f37165a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f37166b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f37167c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f37168d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f37169e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f37170f;
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
            f37165a = new c("crashId", 0);
            f37166b = new c("exception", 1);
            f37167c = new c("timestamp", 2);
            f37168d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f37169e = cVar;
            f37170f = new c[]{f37165a, f37166b, f37167c, f37168d, cVar};
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
        public static final d f37171a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f37172b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f37173c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f37174d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f37175e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f37176f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f37177g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f37178h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f37179i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f37180j;
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
            f37171a = new d("dbId", 0);
            f37172b = new d("tableName", 1);
            f37173c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f37174d = new d("method", 3);
            f37175e = new d("action", 4);
            f37176f = new d("startTime", 5);
            f37177g = new d("endTime", 6);
            f37178h = new d("duration", 7);
            f37179i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f37180j = dVar;
            k = new d[]{f37171a, f37172b, f37173c, f37174d, f37175e, f37176f, f37177g, f37178h, f37179i, dVar};
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
    public static class C1590e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f37181a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f37182b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f37183c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f37184d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f37185e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f37186f;

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
            f37181a = "CREATE TABLE crash (" + c.f37165a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f37166b.name() + " TEXT, " + c.f37167c.name() + " LONG, " + c.f37168d.name() + " TEXT, " + c.f37169e.name() + " LONG NOT NULL );";
            f37182b = "CREATE TABLE db (" + d.f37171a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f37172b.name() + " TEXT, " + d.f37173c.name() + " TEXT, " + d.f37174d.name() + " TEXT, " + d.f37175e.name() + " TEXT, " + d.f37176f.name() + " LONG, " + d.f37177g.name() + " LONG, " + d.f37178h.name() + " LONG, " + d.f37179i.name() + " TEXT, " + d.f37180j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f37156a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f37157b.name());
            sb.append(" LONG, ");
            sb.append(b.f37158c.name());
            sb.append(" LONG, ");
            sb.append(b.f37159d.name());
            sb.append(" TEXT, ");
            sb.append(b.f37160e.name());
            sb.append(" LONG, ");
            sb.append(b.f37161f.name());
            sb.append(" LONG, ");
            sb.append(b.f37162g.name());
            sb.append(" TEXT, ");
            sb.append(b.f37163h.name());
            sb.append(" LONG NOT NULL );");
            f37183c = sb.toString();
            f37184d = "CREATE TABLE request (" + f.f37187a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f37188b.name() + " TEXT, " + f.f37189c.name() + " TEXT, " + f.f37190d.name() + " LONG, " + f.f37191e.name() + " LONG, " + f.f37192f.name() + " LONG, " + f.f37193g.name() + " TEXT, " + f.f37194h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f37149a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f37150b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f37151c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f37152d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f37153e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f37154f.name());
            sb2.append(" LONG NOT NULL);");
            f37185e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1590e(Context context, String str, int i2) {
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
            this.f37186f = context;
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
                    sQLiteDatabase.execSQL(f37181a);
                    sQLiteDatabase.execSQL(f37182b);
                    sQLiteDatabase.execSQL(f37183c);
                    sQLiteDatabase.execSQL(f37184d);
                    sQLiteDatabase.execSQL(f37185e);
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
        public static final f f37187a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f37188b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f37189c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f37190d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f37191e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f37192f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f37193g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f37194h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f37195i;
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
            f37187a = new f("id", 0);
            f37188b = new f("method", 1);
            f37189c = new f("requestId", 2);
            f37190d = new f("timestamp", 3);
            f37191e = new f("responseTime", 4);
            f37192f = new f("errorCode", 5);
            f37193g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f37194h = fVar;
            f37195i = new f[]{f37187a, f37188b, f37189c, f37190d, f37191e, f37192f, f37193g, fVar};
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
        f37144a = new Object();
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
        this.f37148e = context;
        f37146c = new C1590e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f37147d == null) {
                synchronized (f37144a) {
                    if (f37147d == null) {
                        f37147d = new e(context.getApplicationContext());
                    }
                }
            }
            return f37147d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f37146c == null) {
                f37146c = new C1590e(context, "push_track.db", 1);
            }
            try {
                return f37146c.getWritableDatabase();
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
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
                            cVar.f37012a = rawQuery.getString(rawQuery.getColumnIndex(c.f37166b.name()));
                            cVar.f37013b = rawQuery.getLong(rawQuery.getColumnIndex(c.f37167c.name()));
                            cVar.f37014c = rawQuery.getString(rawQuery.getColumnIndex(c.f37168d.name()));
                            cVar.f37015d = rawQuery.getLong(rawQuery.getColumnIndex(c.f37169e.name()));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f37150b.name(), aVar.f36982a);
                    contentValues.put(a.f37151c.name(), aVar.f36983b);
                    contentValues.put(a.f37152d.name(), Long.valueOf(aVar.f36984c));
                    contentValues.put(a.f37153e.name(), aVar.f36985d);
                    contentValues.put(a.f37154f.name(), Long.valueOf(aVar.f36986e));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f37157b.name(), Long.valueOf(bVar.f36995a));
                    contentValues.put(b.f37158c.name(), Long.valueOf(bVar.f36996b));
                    contentValues.put(b.f37159d.name(), bVar.f36997c);
                    contentValues.put(b.f37160e.name(), Long.valueOf(bVar.f36998d));
                    contentValues.put(b.f37161f.name(), Long.valueOf(bVar.f36999e));
                    contentValues.put(b.f37162g.name(), bVar.f37000f);
                    contentValues.put(b.f37163h.name(), Long.valueOf(bVar.f37001g));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f37166b.name(), cVar.f37012a);
                    contentValues.put(c.f37167c.name(), Long.valueOf(cVar.f37013b));
                    contentValues.put(c.f37168d.name(), cVar.f37014c);
                    contentValues.put(c.f37169e.name(), Long.valueOf(cVar.f37015d));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f37172b.name(), dVar.f37026a);
                    contentValues.put(d.f37173c.name(), dVar.f37027b);
                    contentValues.put(d.f37174d.name(), dVar.f37028c);
                    contentValues.put(d.f37175e.name(), dVar.f37029d);
                    contentValues.put(d.f37176f.name(), Long.valueOf(dVar.f37030e));
                    contentValues.put(d.f37177g.name(), Long.valueOf(dVar.f37031f));
                    contentValues.put(d.f37178h.name(), Long.valueOf(dVar.f37032g));
                    contentValues.put(d.f37179i.name(), dVar.f37033h);
                    contentValues.put(d.f37180j.name(), Long.valueOf(dVar.f37034i));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f37188b.name(), eVar.f37035a);
                    contentValues.put(f.f37189c.name(), eVar.f37036b);
                    contentValues.put(f.f37190d.name(), Long.valueOf(eVar.f37037c));
                    contentValues.put(f.f37191e.name(), Long.valueOf(eVar.f37038d));
                    contentValues.put(f.f37192f.name(), Long.valueOf(eVar.f37039e));
                    contentValues.put(f.f37193g.name(), eVar.f37040f);
                    contentValues.put(f.f37194h.name(), Long.valueOf(eVar.f37041g));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
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
                        dVar.f37026a = cursor.getString(cursor.getColumnIndex(d.f37172b.name()));
                        dVar.f37027b = cursor.getString(cursor.getColumnIndex(d.f37173c.name()));
                        dVar.f37028c = cursor.getString(cursor.getColumnIndex(d.f37174d.name()));
                        dVar.f37029d = cursor.getString(cursor.getColumnIndex(d.f37175e.name()));
                        dVar.f37030e = cursor.getLong(cursor.getColumnIndex(d.f37176f.name()));
                        dVar.f37031f = cursor.getLong(cursor.getColumnIndex(d.f37177g.name()));
                        dVar.f37032g = cursor.getLong(cursor.getColumnIndex(d.f37178h.name()));
                        dVar.f37033h = cursor.getString(cursor.getColumnIndex(d.f37179i.name()));
                        dVar.f37034i = cursor.getLong(cursor.getColumnIndex(d.f37180j.name()));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
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
                        bVar.f36995a = cursor.getLong(cursor.getColumnIndex(b.f37157b.name()));
                        bVar.f36996b = cursor.getLong(cursor.getColumnIndex(b.f37158c.name()));
                        bVar.f36997c = cursor.getString(cursor.getColumnIndex(b.f37159d.name()));
                        bVar.f36998d = cursor.getLong(cursor.getColumnIndex(b.f37160e.name()));
                        bVar.f36999e = cursor.getLong(cursor.getColumnIndex(b.f37161f.name()));
                        bVar.f37000f = cursor.getString(cursor.getColumnIndex(b.f37162g.name()));
                        bVar.f37001g = cursor.getLong(cursor.getColumnIndex(b.f37163h.name()));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
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
                        eVar.f37035a = cursor.getString(cursor.getColumnIndex(f.f37188b.name()));
                        eVar.f37036b = cursor.getString(cursor.getColumnIndex(f.f37189c.name()));
                        eVar.f37037c = cursor.getLong(cursor.getColumnIndex(f.f37190d.name()));
                        eVar.f37038d = cursor.getLong(cursor.getColumnIndex(f.f37191e.name()));
                        eVar.f37039e = cursor.getLong(cursor.getColumnIndex(f.f37192f.name()));
                        eVar.f37040f = cursor.getString(cursor.getColumnIndex(f.f37193g.name()));
                        eVar.f37041g = cursor.getLong(cursor.getColumnIndex(f.f37194h.name()));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
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
                        aVar.f36982a = cursor.getString(cursor.getColumnIndex(a.f37150b.name()));
                        aVar.f36983b = cursor.getString(cursor.getColumnIndex(a.f37151c.name()));
                        aVar.f36984c = cursor.getLong(cursor.getColumnIndex(a.f37152d.name()));
                        aVar.f36985d = cursor.getString(cursor.getColumnIndex(a.f37153e.name()));
                        aVar.f36986e = cursor.getLong(cursor.getColumnIndex(a.f37154f.name()));
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
            synchronized (f37144a) {
                SQLiteDatabase b2 = b(this.f37148e);
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
