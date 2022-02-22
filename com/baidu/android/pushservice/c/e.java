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
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
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
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object a;

    /* renamed from: b  reason: collision with root package name */
    public static String f32053b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1734e f32054c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f32055d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f32056e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f32057b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f32058c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f32059d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f32060e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f32061f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f32062g;
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
            a = new a("ackId", 0);
            f32057b = new a("type", 1);
            f32058c = new a("value", 2);
            f32059d = new a("timestamp", 3);
            f32060e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f32061f = aVar;
            f32062g = new a[]{a, f32057b, f32058c, f32059d, f32060e, aVar};
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
    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f32063b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f32064c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f32065d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f32066e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f32067f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f32068g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f32069h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f32070i;
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
            a = new b("connectionId", 0);
            f32063b = new b(FetchLog.START_TIME, 1);
            f32064c = new b("stopTime", 2);
            f32065d = new b("reason", 3);
            f32066e = new b("retryTime", 4);
            f32067f = new b("retryCount", 5);
            f32068g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f32069h = bVar;
            f32070i = new b[]{a, f32063b, f32064c, f32065d, f32066e, f32067f, f32068g, bVar};
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
    /* loaded from: classes10.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f32071b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f32072c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f32073d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f32074e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f32075f;
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
            a = new c("crashId", 0);
            f32071b = new c("exception", 1);
            f32072c = new c("timestamp", 2);
            f32073d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f32074e = cVar;
            f32075f = new c[]{a, f32071b, f32072c, f32073d, cVar};
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
    /* loaded from: classes10.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f32076b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f32077c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f32078d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f32079e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f32080f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f32081g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f32082h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f32083i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f32084j;
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
            a = new d("dbId", 0);
            f32076b = new d("tableName", 1);
            f32077c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f32078d = new d("method", 3);
            f32079e = new d("action", 4);
            f32080f = new d(FetchLog.START_TIME, 5);
            f32081g = new d(FetchLog.END_TIME, 6);
            f32082h = new d("duration", 7);
            f32083i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f32084j = dVar;
            k = new d[]{a, f32076b, f32077c, f32078d, f32079e, f32080f, f32081g, f32082h, f32083i, dVar};
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
    /* loaded from: classes10.dex */
    public static class C1734e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f32085b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f32086c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f32087d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f32088e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f32089f;

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
            a = "CREATE TABLE crash (" + c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f32071b.name() + " TEXT, " + c.f32072c.name() + " LONG, " + c.f32073d.name() + " TEXT, " + c.f32074e.name() + " LONG NOT NULL );";
            f32085b = "CREATE TABLE db (" + d.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f32076b.name() + " TEXT, " + d.f32077c.name() + " TEXT, " + d.f32078d.name() + " TEXT, " + d.f32079e.name() + " TEXT, " + d.f32080f.name() + " LONG, " + d.f32081g.name() + " LONG, " + d.f32082h.name() + " LONG, " + d.f32083i.name() + " TEXT, " + d.f32084j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f32063b.name());
            sb.append(" LONG, ");
            sb.append(b.f32064c.name());
            sb.append(" LONG, ");
            sb.append(b.f32065d.name());
            sb.append(" TEXT, ");
            sb.append(b.f32066e.name());
            sb.append(" LONG, ");
            sb.append(b.f32067f.name());
            sb.append(" LONG, ");
            sb.append(b.f32068g.name());
            sb.append(" TEXT, ");
            sb.append(b.f32069h.name());
            sb.append(" LONG NOT NULL );");
            f32086c = sb.toString();
            f32087d = "CREATE TABLE request (" + f.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f32090b.name() + " TEXT, " + f.f32091c.name() + " TEXT, " + f.f32092d.name() + " LONG, " + f.f32093e.name() + " LONG, " + f.f32094f.name() + " LONG, " + f.f32095g.name() + " TEXT, " + f.f32096h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f32057b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32058c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32059d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f32060e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32061f.name());
            sb2.append(" LONG NOT NULL);");
            f32088e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1734e(Context context, String str, int i2) {
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
            this.f32089f = context;
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
                    sQLiteDatabase.execSQL(a);
                    sQLiteDatabase.execSQL(f32085b);
                    sQLiteDatabase.execSQL(f32086c);
                    sQLiteDatabase.execSQL(f32087d);
                    sQLiteDatabase.execSQL(f32088e);
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
    /* loaded from: classes10.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f32090b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f32091c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f32092d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f32093e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f32094f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f32095g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f32096h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f32097i;
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
            a = new f("id", 0);
            f32090b = new f("method", 1);
            f32091c = new f("requestId", 2);
            f32092d = new f("timestamp", 3);
            f32093e = new f("responseTime", 4);
            f32094f = new f("errorCode", 5);
            f32095g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f32096h = fVar;
            f32097i = new f[]{a, f32090b, f32091c, f32092d, f32093e, f32094f, f32095g, fVar};
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
        a = new Object();
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
        this.f32056e = context;
        f32054c = new C1734e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f32055d == null) {
                synchronized (a) {
                    if (f32055d == null) {
                        f32055d = new e(context.getApplicationContext());
                    }
                }
            }
            return f32055d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f32054c == null) {
                f32054c = new C1734e(context, "push_track.db", 1);
            }
            try {
                return f32054c.getWritableDatabase();
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
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
                            cVar.a = rawQuery.getString(rawQuery.getColumnIndex(c.f32071b.name()));
                            cVar.f31939b = rawQuery.getLong(rawQuery.getColumnIndex(c.f32072c.name()));
                            cVar.f31940c = rawQuery.getString(rawQuery.getColumnIndex(c.f32073d.name()));
                            cVar.f31941d = rawQuery.getLong(rawQuery.getColumnIndex(c.f32074e.name()));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f32057b.name(), aVar.a);
                    contentValues.put(a.f32058c.name(), aVar.f31913b);
                    contentValues.put(a.f32059d.name(), Long.valueOf(aVar.f31914c));
                    contentValues.put(a.f32060e.name(), aVar.f31915d);
                    contentValues.put(a.f32061f.name(), Long.valueOf(aVar.f31916e));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f32063b.name(), Long.valueOf(bVar.a));
                    contentValues.put(b.f32064c.name(), Long.valueOf(bVar.f31924b));
                    contentValues.put(b.f32065d.name(), bVar.f31925c);
                    contentValues.put(b.f32066e.name(), Long.valueOf(bVar.f31926d));
                    contentValues.put(b.f32067f.name(), Long.valueOf(bVar.f31927e));
                    contentValues.put(b.f32068g.name(), bVar.f31928f);
                    contentValues.put(b.f32069h.name(), Long.valueOf(bVar.f31929g));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f32071b.name(), cVar.a);
                    contentValues.put(c.f32072c.name(), Long.valueOf(cVar.f31939b));
                    contentValues.put(c.f32073d.name(), cVar.f31940c);
                    contentValues.put(c.f32074e.name(), Long.valueOf(cVar.f31941d));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f32076b.name(), dVar.a);
                    contentValues.put(d.f32077c.name(), dVar.f31951b);
                    contentValues.put(d.f32078d.name(), dVar.f31952c);
                    contentValues.put(d.f32079e.name(), dVar.f31953d);
                    contentValues.put(d.f32080f.name(), Long.valueOf(dVar.f31954e));
                    contentValues.put(d.f32081g.name(), Long.valueOf(dVar.f31955f));
                    contentValues.put(d.f32082h.name(), Long.valueOf(dVar.f31956g));
                    contentValues.put(d.f32083i.name(), dVar.f31957h);
                    contentValues.put(d.f32084j.name(), Long.valueOf(dVar.f31958i));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f32090b.name(), eVar.a);
                    contentValues.put(f.f32091c.name(), eVar.f31959b);
                    contentValues.put(f.f32092d.name(), Long.valueOf(eVar.f31960c));
                    contentValues.put(f.f32093e.name(), Long.valueOf(eVar.f31961d));
                    contentValues.put(f.f32094f.name(), Long.valueOf(eVar.f31962e));
                    contentValues.put(f.f32095g.name(), eVar.f31963f);
                    contentValues.put(f.f32096h.name(), Long.valueOf(eVar.f31964g));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
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
                        dVar.a = cursor.getString(cursor.getColumnIndex(d.f32076b.name()));
                        dVar.f31951b = cursor.getString(cursor.getColumnIndex(d.f32077c.name()));
                        dVar.f31952c = cursor.getString(cursor.getColumnIndex(d.f32078d.name()));
                        dVar.f31953d = cursor.getString(cursor.getColumnIndex(d.f32079e.name()));
                        dVar.f31954e = cursor.getLong(cursor.getColumnIndex(d.f32080f.name()));
                        dVar.f31955f = cursor.getLong(cursor.getColumnIndex(d.f32081g.name()));
                        dVar.f31956g = cursor.getLong(cursor.getColumnIndex(d.f32082h.name()));
                        dVar.f31957h = cursor.getString(cursor.getColumnIndex(d.f32083i.name()));
                        dVar.f31958i = cursor.getLong(cursor.getColumnIndex(d.f32084j.name()));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
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
                        bVar.a = cursor.getLong(cursor.getColumnIndex(b.f32063b.name()));
                        bVar.f31924b = cursor.getLong(cursor.getColumnIndex(b.f32064c.name()));
                        bVar.f31925c = cursor.getString(cursor.getColumnIndex(b.f32065d.name()));
                        bVar.f31926d = cursor.getLong(cursor.getColumnIndex(b.f32066e.name()));
                        bVar.f31927e = cursor.getLong(cursor.getColumnIndex(b.f32067f.name()));
                        bVar.f31928f = cursor.getString(cursor.getColumnIndex(b.f32068g.name()));
                        bVar.f31929g = cursor.getLong(cursor.getColumnIndex(b.f32069h.name()));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
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
                        eVar.a = cursor.getString(cursor.getColumnIndex(f.f32090b.name()));
                        eVar.f31959b = cursor.getString(cursor.getColumnIndex(f.f32091c.name()));
                        eVar.f31960c = cursor.getLong(cursor.getColumnIndex(f.f32092d.name()));
                        eVar.f31961d = cursor.getLong(cursor.getColumnIndex(f.f32093e.name()));
                        eVar.f31962e = cursor.getLong(cursor.getColumnIndex(f.f32094f.name()));
                        eVar.f31963f = cursor.getString(cursor.getColumnIndex(f.f32095g.name()));
                        eVar.f31964g = cursor.getLong(cursor.getColumnIndex(f.f32096h.name()));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
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
                        aVar.a = cursor.getString(cursor.getColumnIndex(a.f32057b.name()));
                        aVar.f31913b = cursor.getString(cursor.getColumnIndex(a.f32058c.name()));
                        aVar.f31914c = cursor.getLong(cursor.getColumnIndex(a.f32059d.name()));
                        aVar.f31915d = cursor.getString(cursor.getColumnIndex(a.f32060e.name()));
                        aVar.f31916e = cursor.getLong(cursor.getColumnIndex(a.f32061f.name()));
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
            synchronized (a) {
                SQLiteDatabase b2 = b(this.f32056e);
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
