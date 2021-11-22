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
    public static final Object f36015a;

    /* renamed from: b  reason: collision with root package name */
    public static String f36016b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1584e f36017c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f36018d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f36019e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f36020a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f36021b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f36022c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f36023d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f36024e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f36025f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f36026g;
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
            f36020a = new a("ackId", 0);
            f36021b = new a("type", 1);
            f36022c = new a("value", 2);
            f36023d = new a("timestamp", 3);
            f36024e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f36025f = aVar;
            f36026g = new a[]{f36020a, f36021b, f36022c, f36023d, f36024e, aVar};
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
        public static final b f36027a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f36028b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f36029c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f36030d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f36031e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f36032f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f36033g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f36034h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f36035i;
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
            f36027a = new b("connectionId", 0);
            f36028b = new b("startTime", 1);
            f36029c = new b("stopTime", 2);
            f36030d = new b("reason", 3);
            f36031e = new b("retryTime", 4);
            f36032f = new b("retryCount", 5);
            f36033g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f36034h = bVar;
            f36035i = new b[]{f36027a, f36028b, f36029c, f36030d, f36031e, f36032f, f36033g, bVar};
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
        public static final c f36036a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f36037b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f36038c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f36039d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f36040e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f36041f;
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
            f36036a = new c("crashId", 0);
            f36037b = new c("exception", 1);
            f36038c = new c("timestamp", 2);
            f36039d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f36040e = cVar;
            f36041f = new c[]{f36036a, f36037b, f36038c, f36039d, cVar};
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
        public static final d f36042a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f36043b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f36044c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f36045d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f36046e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f36047f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f36048g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f36049h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f36050i;
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
            f36042a = new d("dbId", 0);
            f36043b = new d("tableName", 1);
            f36044c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f36045d = new d("method", 3);
            f36046e = new d("action", 4);
            f36047f = new d("startTime", 5);
            f36048g = new d("endTime", 6);
            f36049h = new d("duration", 7);
            f36050i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            j = dVar;
            k = new d[]{f36042a, f36043b, f36044c, f36045d, f36046e, f36047f, f36048g, f36049h, f36050i, dVar};
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
    public static class C1584e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f36051a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f36052b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f36053c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f36054d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f36055e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f36056f;

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
            f36051a = "CREATE TABLE crash (" + c.f36036a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f36037b.name() + " TEXT, " + c.f36038c.name() + " LONG, " + c.f36039d.name() + " TEXT, " + c.f36040e.name() + " LONG NOT NULL );";
            f36052b = "CREATE TABLE db (" + d.f36042a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f36043b.name() + " TEXT, " + d.f36044c.name() + " TEXT, " + d.f36045d.name() + " TEXT, " + d.f36046e.name() + " TEXT, " + d.f36047f.name() + " LONG, " + d.f36048g.name() + " LONG, " + d.f36049h.name() + " LONG, " + d.f36050i.name() + " TEXT, " + d.j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f36027a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f36028b.name());
            sb.append(" LONG, ");
            sb.append(b.f36029c.name());
            sb.append(" LONG, ");
            sb.append(b.f36030d.name());
            sb.append(" TEXT, ");
            sb.append(b.f36031e.name());
            sb.append(" LONG, ");
            sb.append(b.f36032f.name());
            sb.append(" LONG, ");
            sb.append(b.f36033g.name());
            sb.append(" TEXT, ");
            sb.append(b.f36034h.name());
            sb.append(" LONG NOT NULL );");
            f36053c = sb.toString();
            f36054d = "CREATE TABLE request (" + f.f36057a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f36058b.name() + " TEXT, " + f.f36059c.name() + " TEXT, " + f.f36060d.name() + " LONG, " + f.f36061e.name() + " LONG, " + f.f36062f.name() + " LONG, " + f.f36063g.name() + " TEXT, " + f.f36064h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f36020a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f36021b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f36022c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f36023d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f36024e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f36025f.name());
            sb2.append(" LONG NOT NULL);");
            f36055e = sb2.toString();
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
            this.f36056f = context;
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
                    sQLiteDatabase.execSQL(f36051a);
                    sQLiteDatabase.execSQL(f36052b);
                    sQLiteDatabase.execSQL(f36053c);
                    sQLiteDatabase.execSQL(f36054d);
                    sQLiteDatabase.execSQL(f36055e);
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
        public static final f f36057a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f36058b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f36059c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f36060d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f36061e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f36062f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f36063g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f36064h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f36065i;
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
            f36057a = new f("id", 0);
            f36058b = new f("method", 1);
            f36059c = new f("requestId", 2);
            f36060d = new f("timestamp", 3);
            f36061e = new f("responseTime", 4);
            f36062f = new f("errorCode", 5);
            f36063g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f36064h = fVar;
            f36065i = new f[]{f36057a, f36058b, f36059c, f36060d, f36061e, f36062f, f36063g, fVar};
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
        f36015a = new Object();
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
        this.f36019e = context;
        f36017c = new C1584e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f36018d == null) {
                synchronized (f36015a) {
                    if (f36018d == null) {
                        f36018d = new e(context.getApplicationContext());
                    }
                }
            }
            return f36018d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f36017c == null) {
                f36017c = new C1584e(context, "push_track.db", 1);
            }
            try {
                return f36017c.getWritableDatabase();
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
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
                            cVar.f35888a = rawQuery.getString(rawQuery.getColumnIndex(c.f36037b.name()));
                            cVar.f35889b = rawQuery.getLong(rawQuery.getColumnIndex(c.f36038c.name()));
                            cVar.f35890c = rawQuery.getString(rawQuery.getColumnIndex(c.f36039d.name()));
                            cVar.f35891d = rawQuery.getLong(rawQuery.getColumnIndex(c.f36040e.name()));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f36021b.name(), aVar.f35859a);
                    contentValues.put(a.f36022c.name(), aVar.f35860b);
                    contentValues.put(a.f36023d.name(), Long.valueOf(aVar.f35861c));
                    contentValues.put(a.f36024e.name(), aVar.f35862d);
                    contentValues.put(a.f36025f.name(), Long.valueOf(aVar.f35863e));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f36028b.name(), Long.valueOf(bVar.f35872a));
                    contentValues.put(b.f36029c.name(), Long.valueOf(bVar.f35873b));
                    contentValues.put(b.f36030d.name(), bVar.f35874c);
                    contentValues.put(b.f36031e.name(), Long.valueOf(bVar.f35875d));
                    contentValues.put(b.f36032f.name(), Long.valueOf(bVar.f35876e));
                    contentValues.put(b.f36033g.name(), bVar.f35877f);
                    contentValues.put(b.f36034h.name(), Long.valueOf(bVar.f35878g));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f36037b.name(), cVar.f35888a);
                    contentValues.put(c.f36038c.name(), Long.valueOf(cVar.f35889b));
                    contentValues.put(c.f36039d.name(), cVar.f35890c);
                    contentValues.put(c.f36040e.name(), Long.valueOf(cVar.f35891d));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f36043b.name(), dVar.f35901a);
                    contentValues.put(d.f36044c.name(), dVar.f35902b);
                    contentValues.put(d.f36045d.name(), dVar.f35903c);
                    contentValues.put(d.f36046e.name(), dVar.f35904d);
                    contentValues.put(d.f36047f.name(), Long.valueOf(dVar.f35905e));
                    contentValues.put(d.f36048g.name(), Long.valueOf(dVar.f35906f));
                    contentValues.put(d.f36049h.name(), Long.valueOf(dVar.f35907g));
                    contentValues.put(d.f36050i.name(), dVar.f35908h);
                    contentValues.put(d.j.name(), Long.valueOf(dVar.f35909i));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f36058b.name(), eVar.f35910a);
                    contentValues.put(f.f36059c.name(), eVar.f35911b);
                    contentValues.put(f.f36060d.name(), Long.valueOf(eVar.f35912c));
                    contentValues.put(f.f36061e.name(), Long.valueOf(eVar.f35913d));
                    contentValues.put(f.f36062f.name(), Long.valueOf(eVar.f35914e));
                    contentValues.put(f.f36063g.name(), eVar.f35915f);
                    contentValues.put(f.f36064h.name(), Long.valueOf(eVar.f35916g));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
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
                        dVar.f35901a = cursor.getString(cursor.getColumnIndex(d.f36043b.name()));
                        dVar.f35902b = cursor.getString(cursor.getColumnIndex(d.f36044c.name()));
                        dVar.f35903c = cursor.getString(cursor.getColumnIndex(d.f36045d.name()));
                        dVar.f35904d = cursor.getString(cursor.getColumnIndex(d.f36046e.name()));
                        dVar.f35905e = cursor.getLong(cursor.getColumnIndex(d.f36047f.name()));
                        dVar.f35906f = cursor.getLong(cursor.getColumnIndex(d.f36048g.name()));
                        dVar.f35907g = cursor.getLong(cursor.getColumnIndex(d.f36049h.name()));
                        dVar.f35908h = cursor.getString(cursor.getColumnIndex(d.f36050i.name()));
                        dVar.f35909i = cursor.getLong(cursor.getColumnIndex(d.j.name()));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
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
                        bVar.f35872a = cursor.getLong(cursor.getColumnIndex(b.f36028b.name()));
                        bVar.f35873b = cursor.getLong(cursor.getColumnIndex(b.f36029c.name()));
                        bVar.f35874c = cursor.getString(cursor.getColumnIndex(b.f36030d.name()));
                        bVar.f35875d = cursor.getLong(cursor.getColumnIndex(b.f36031e.name()));
                        bVar.f35876e = cursor.getLong(cursor.getColumnIndex(b.f36032f.name()));
                        bVar.f35877f = cursor.getString(cursor.getColumnIndex(b.f36033g.name()));
                        bVar.f35878g = cursor.getLong(cursor.getColumnIndex(b.f36034h.name()));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
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
                        eVar.f35910a = cursor.getString(cursor.getColumnIndex(f.f36058b.name()));
                        eVar.f35911b = cursor.getString(cursor.getColumnIndex(f.f36059c.name()));
                        eVar.f35912c = cursor.getLong(cursor.getColumnIndex(f.f36060d.name()));
                        eVar.f35913d = cursor.getLong(cursor.getColumnIndex(f.f36061e.name()));
                        eVar.f35914e = cursor.getLong(cursor.getColumnIndex(f.f36062f.name()));
                        eVar.f35915f = cursor.getString(cursor.getColumnIndex(f.f36063g.name()));
                        eVar.f35916g = cursor.getLong(cursor.getColumnIndex(f.f36064h.name()));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
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
                        aVar.f35859a = cursor.getString(cursor.getColumnIndex(a.f36021b.name()));
                        aVar.f35860b = cursor.getString(cursor.getColumnIndex(a.f36022c.name()));
                        aVar.f35861c = cursor.getLong(cursor.getColumnIndex(a.f36023d.name()));
                        aVar.f35862d = cursor.getString(cursor.getColumnIndex(a.f36024e.name()));
                        aVar.f35863e = cursor.getLong(cursor.getColumnIndex(a.f36025f.name()));
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
            synchronized (f36015a) {
                SQLiteDatabase b2 = b(this.f36019e);
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
