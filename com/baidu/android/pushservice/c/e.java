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
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object a;

    /* renamed from: b  reason: collision with root package name */
    public static String f31819b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1723e f31820c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f31821d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f31822e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f31823b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f31824c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f31825d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f31826e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f31827f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f31828g;
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
            f31823b = new a("type", 1);
            f31824c = new a("value", 2);
            f31825d = new a("timestamp", 3);
            f31826e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f31827f = aVar;
            f31828g = new a[]{a, f31823b, f31824c, f31825d, f31826e, aVar};
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
        public static final b f31829b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f31830c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f31831d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f31832e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f31833f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f31834g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f31835h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f31836i;
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
            f31829b = new b("startTime", 1);
            f31830c = new b("stopTime", 2);
            f31831d = new b("reason", 3);
            f31832e = new b("retryTime", 4);
            f31833f = new b("retryCount", 5);
            f31834g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f31835h = bVar;
            f31836i = new b[]{a, f31829b, f31830c, f31831d, f31832e, f31833f, f31834g, bVar};
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
        public static final c f31837b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f31838c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f31839d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f31840e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f31841f;
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
            f31837b = new c("exception", 1);
            f31838c = new c("timestamp", 2);
            f31839d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f31840e = cVar;
            f31841f = new c[]{a, f31837b, f31838c, f31839d, cVar};
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
        public static final d f31842b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f31843c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f31844d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f31845e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f31846f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f31847g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f31848h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f31849i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f31850j;
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
            f31842b = new d("tableName", 1);
            f31843c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f31844d = new d("method", 3);
            f31845e = new d("action", 4);
            f31846f = new d("startTime", 5);
            f31847g = new d("endTime", 6);
            f31848h = new d("duration", 7);
            f31849i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f31850j = dVar;
            k = new d[]{a, f31842b, f31843c, f31844d, f31845e, f31846f, f31847g, f31848h, f31849i, dVar};
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
    public static class C1723e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f31851b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f31852c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f31853d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f31854e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f31855f;

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
            a = "CREATE TABLE crash (" + c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f31837b.name() + " TEXT, " + c.f31838c.name() + " LONG, " + c.f31839d.name() + " TEXT, " + c.f31840e.name() + " LONG NOT NULL );";
            f31851b = "CREATE TABLE db (" + d.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f31842b.name() + " TEXT, " + d.f31843c.name() + " TEXT, " + d.f31844d.name() + " TEXT, " + d.f31845e.name() + " TEXT, " + d.f31846f.name() + " LONG, " + d.f31847g.name() + " LONG, " + d.f31848h.name() + " LONG, " + d.f31849i.name() + " TEXT, " + d.f31850j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f31829b.name());
            sb.append(" LONG, ");
            sb.append(b.f31830c.name());
            sb.append(" LONG, ");
            sb.append(b.f31831d.name());
            sb.append(" TEXT, ");
            sb.append(b.f31832e.name());
            sb.append(" LONG, ");
            sb.append(b.f31833f.name());
            sb.append(" LONG, ");
            sb.append(b.f31834g.name());
            sb.append(" TEXT, ");
            sb.append(b.f31835h.name());
            sb.append(" LONG NOT NULL );");
            f31852c = sb.toString();
            f31853d = "CREATE TABLE request (" + f.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f31856b.name() + " TEXT, " + f.f31857c.name() + " TEXT, " + f.f31858d.name() + " LONG, " + f.f31859e.name() + " LONG, " + f.f31860f.name() + " LONG, " + f.f31861g.name() + " TEXT, " + f.f31862h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f31823b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f31824c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f31825d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f31826e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f31827f.name());
            sb2.append(" LONG NOT NULL);");
            f31854e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1723e(Context context, String str, int i2) {
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
            this.f31855f = context;
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
                    sQLiteDatabase.execSQL(f31851b);
                    sQLiteDatabase.execSQL(f31852c);
                    sQLiteDatabase.execSQL(f31853d);
                    sQLiteDatabase.execSQL(f31854e);
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
        public static final f f31856b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f31857c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f31858d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f31859e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f31860f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f31861g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f31862h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f31863i;
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
            f31856b = new f("method", 1);
            f31857c = new f("requestId", 2);
            f31858d = new f("timestamp", 3);
            f31859e = new f("responseTime", 4);
            f31860f = new f("errorCode", 5);
            f31861g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f31862h = fVar;
            f31863i = new f[]{a, f31856b, f31857c, f31858d, f31859e, f31860f, f31861g, fVar};
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
        this.f31822e = context;
        f31820c = new C1723e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f31821d == null) {
                synchronized (a) {
                    if (f31821d == null) {
                        f31821d = new e(context.getApplicationContext());
                    }
                }
            }
            return f31821d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f31820c == null) {
                f31820c = new C1723e(context, "push_track.db", 1);
            }
            try {
                return f31820c.getWritableDatabase();
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
                SQLiteDatabase b2 = b(this.f31822e);
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
                            cVar.a = rawQuery.getString(rawQuery.getColumnIndex(c.f31837b.name()));
                            cVar.f31705b = rawQuery.getLong(rawQuery.getColumnIndex(c.f31838c.name()));
                            cVar.f31706c = rawQuery.getString(rawQuery.getColumnIndex(c.f31839d.name()));
                            cVar.f31707d = rawQuery.getLong(rawQuery.getColumnIndex(c.f31840e.name()));
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
                SQLiteDatabase b2 = b(this.f31822e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f31823b.name(), aVar.a);
                    contentValues.put(a.f31824c.name(), aVar.f31679b);
                    contentValues.put(a.f31825d.name(), Long.valueOf(aVar.f31680c));
                    contentValues.put(a.f31826e.name(), aVar.f31681d);
                    contentValues.put(a.f31827f.name(), Long.valueOf(aVar.f31682e));
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
                SQLiteDatabase b2 = b(this.f31822e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f31829b.name(), Long.valueOf(bVar.a));
                    contentValues.put(b.f31830c.name(), Long.valueOf(bVar.f31690b));
                    contentValues.put(b.f31831d.name(), bVar.f31691c);
                    contentValues.put(b.f31832e.name(), Long.valueOf(bVar.f31692d));
                    contentValues.put(b.f31833f.name(), Long.valueOf(bVar.f31693e));
                    contentValues.put(b.f31834g.name(), bVar.f31694f);
                    contentValues.put(b.f31835h.name(), Long.valueOf(bVar.f31695g));
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
                SQLiteDatabase b2 = b(this.f31822e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f31837b.name(), cVar.a);
                    contentValues.put(c.f31838c.name(), Long.valueOf(cVar.f31705b));
                    contentValues.put(c.f31839d.name(), cVar.f31706c);
                    contentValues.put(c.f31840e.name(), Long.valueOf(cVar.f31707d));
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
                SQLiteDatabase b2 = b(this.f31822e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f31842b.name(), dVar.a);
                    contentValues.put(d.f31843c.name(), dVar.f31717b);
                    contentValues.put(d.f31844d.name(), dVar.f31718c);
                    contentValues.put(d.f31845e.name(), dVar.f31719d);
                    contentValues.put(d.f31846f.name(), Long.valueOf(dVar.f31720e));
                    contentValues.put(d.f31847g.name(), Long.valueOf(dVar.f31721f));
                    contentValues.put(d.f31848h.name(), Long.valueOf(dVar.f31722g));
                    contentValues.put(d.f31849i.name(), dVar.f31723h);
                    contentValues.put(d.f31850j.name(), Long.valueOf(dVar.f31724i));
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
                SQLiteDatabase b2 = b(this.f31822e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f31856b.name(), eVar.a);
                    contentValues.put(f.f31857c.name(), eVar.f31725b);
                    contentValues.put(f.f31858d.name(), Long.valueOf(eVar.f31726c));
                    contentValues.put(f.f31859e.name(), Long.valueOf(eVar.f31727d));
                    contentValues.put(f.f31860f.name(), Long.valueOf(eVar.f31728e));
                    contentValues.put(f.f31861g.name(), eVar.f31729f);
                    contentValues.put(f.f31862h.name(), Long.valueOf(eVar.f31730g));
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
                SQLiteDatabase b2 = b(this.f31822e);
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
                        dVar.a = cursor.getString(cursor.getColumnIndex(d.f31842b.name()));
                        dVar.f31717b = cursor.getString(cursor.getColumnIndex(d.f31843c.name()));
                        dVar.f31718c = cursor.getString(cursor.getColumnIndex(d.f31844d.name()));
                        dVar.f31719d = cursor.getString(cursor.getColumnIndex(d.f31845e.name()));
                        dVar.f31720e = cursor.getLong(cursor.getColumnIndex(d.f31846f.name()));
                        dVar.f31721f = cursor.getLong(cursor.getColumnIndex(d.f31847g.name()));
                        dVar.f31722g = cursor.getLong(cursor.getColumnIndex(d.f31848h.name()));
                        dVar.f31723h = cursor.getString(cursor.getColumnIndex(d.f31849i.name()));
                        dVar.f31724i = cursor.getLong(cursor.getColumnIndex(d.f31850j.name()));
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
                SQLiteDatabase b2 = b(this.f31822e);
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
                        bVar.a = cursor.getLong(cursor.getColumnIndex(b.f31829b.name()));
                        bVar.f31690b = cursor.getLong(cursor.getColumnIndex(b.f31830c.name()));
                        bVar.f31691c = cursor.getString(cursor.getColumnIndex(b.f31831d.name()));
                        bVar.f31692d = cursor.getLong(cursor.getColumnIndex(b.f31832e.name()));
                        bVar.f31693e = cursor.getLong(cursor.getColumnIndex(b.f31833f.name()));
                        bVar.f31694f = cursor.getString(cursor.getColumnIndex(b.f31834g.name()));
                        bVar.f31695g = cursor.getLong(cursor.getColumnIndex(b.f31835h.name()));
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
                SQLiteDatabase b2 = b(this.f31822e);
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
                        eVar.a = cursor.getString(cursor.getColumnIndex(f.f31856b.name()));
                        eVar.f31725b = cursor.getString(cursor.getColumnIndex(f.f31857c.name()));
                        eVar.f31726c = cursor.getLong(cursor.getColumnIndex(f.f31858d.name()));
                        eVar.f31727d = cursor.getLong(cursor.getColumnIndex(f.f31859e.name()));
                        eVar.f31728e = cursor.getLong(cursor.getColumnIndex(f.f31860f.name()));
                        eVar.f31729f = cursor.getString(cursor.getColumnIndex(f.f31861g.name()));
                        eVar.f31730g = cursor.getLong(cursor.getColumnIndex(f.f31862h.name()));
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
                SQLiteDatabase b2 = b(this.f31822e);
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
                        aVar.a = cursor.getString(cursor.getColumnIndex(a.f31823b.name()));
                        aVar.f31679b = cursor.getString(cursor.getColumnIndex(a.f31824c.name()));
                        aVar.f31680c = cursor.getLong(cursor.getColumnIndex(a.f31825d.name()));
                        aVar.f31681d = cursor.getString(cursor.getColumnIndex(a.f31826e.name()));
                        aVar.f31682e = cursor.getLong(cursor.getColumnIndex(a.f31827f.name()));
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
                SQLiteDatabase b2 = b(this.f31822e);
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
