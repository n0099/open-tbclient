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
    public static String f31847b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1724e f31848c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f31849d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f31850e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f31851b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f31852c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f31853d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f31854e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f31855f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f31856g;
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
            f31851b = new a("type", 1);
            f31852c = new a("value", 2);
            f31853d = new a("timestamp", 3);
            f31854e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f31855f = aVar;
            f31856g = new a[]{a, f31851b, f31852c, f31853d, f31854e, aVar};
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
        public static final b f31857b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f31858c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f31859d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f31860e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f31861f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f31862g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f31863h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f31864i;
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
            f31857b = new b(FetchLog.START_TIME, 1);
            f31858c = new b("stopTime", 2);
            f31859d = new b("reason", 3);
            f31860e = new b("retryTime", 4);
            f31861f = new b("retryCount", 5);
            f31862g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f31863h = bVar;
            f31864i = new b[]{a, f31857b, f31858c, f31859d, f31860e, f31861f, f31862g, bVar};
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
        public static final c f31865b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f31866c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f31867d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f31868e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f31869f;
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
            f31865b = new c("exception", 1);
            f31866c = new c("timestamp", 2);
            f31867d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f31868e = cVar;
            f31869f = new c[]{a, f31865b, f31866c, f31867d, cVar};
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
        public static final d f31870b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f31871c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f31872d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f31873e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f31874f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f31875g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f31876h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f31877i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f31878j;
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
            f31870b = new d("tableName", 1);
            f31871c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f31872d = new d("method", 3);
            f31873e = new d("action", 4);
            f31874f = new d(FetchLog.START_TIME, 5);
            f31875g = new d(FetchLog.END_TIME, 6);
            f31876h = new d("duration", 7);
            f31877i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f31878j = dVar;
            k = new d[]{a, f31870b, f31871c, f31872d, f31873e, f31874f, f31875g, f31876h, f31877i, dVar};
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
    public static class C1724e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f31879b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f31880c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f31881d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f31882e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f31883f;

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
            a = "CREATE TABLE crash (" + c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f31865b.name() + " TEXT, " + c.f31866c.name() + " LONG, " + c.f31867d.name() + " TEXT, " + c.f31868e.name() + " LONG NOT NULL );";
            f31879b = "CREATE TABLE db (" + d.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f31870b.name() + " TEXT, " + d.f31871c.name() + " TEXT, " + d.f31872d.name() + " TEXT, " + d.f31873e.name() + " TEXT, " + d.f31874f.name() + " LONG, " + d.f31875g.name() + " LONG, " + d.f31876h.name() + " LONG, " + d.f31877i.name() + " TEXT, " + d.f31878j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f31857b.name());
            sb.append(" LONG, ");
            sb.append(b.f31858c.name());
            sb.append(" LONG, ");
            sb.append(b.f31859d.name());
            sb.append(" TEXT, ");
            sb.append(b.f31860e.name());
            sb.append(" LONG, ");
            sb.append(b.f31861f.name());
            sb.append(" LONG, ");
            sb.append(b.f31862g.name());
            sb.append(" TEXT, ");
            sb.append(b.f31863h.name());
            sb.append(" LONG NOT NULL );");
            f31880c = sb.toString();
            f31881d = "CREATE TABLE request (" + f.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f31884b.name() + " TEXT, " + f.f31885c.name() + " TEXT, " + f.f31886d.name() + " LONG, " + f.f31887e.name() + " LONG, " + f.f31888f.name() + " LONG, " + f.f31889g.name() + " TEXT, " + f.f31890h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f31851b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f31852c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f31853d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f31854e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f31855f.name());
            sb2.append(" LONG NOT NULL);");
            f31882e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1724e(Context context, String str, int i2) {
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
            this.f31883f = context;
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
                    sQLiteDatabase.execSQL(f31879b);
                    sQLiteDatabase.execSQL(f31880c);
                    sQLiteDatabase.execSQL(f31881d);
                    sQLiteDatabase.execSQL(f31882e);
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
        public static final f f31884b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f31885c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f31886d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f31887e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f31888f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f31889g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f31890h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f31891i;
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
            f31884b = new f("method", 1);
            f31885c = new f("requestId", 2);
            f31886d = new f("timestamp", 3);
            f31887e = new f("responseTime", 4);
            f31888f = new f("errorCode", 5);
            f31889g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f31890h = fVar;
            f31891i = new f[]{a, f31884b, f31885c, f31886d, f31887e, f31888f, f31889g, fVar};
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
        this.f31850e = context;
        f31848c = new C1724e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f31849d == null) {
                synchronized (a) {
                    if (f31849d == null) {
                        f31849d = new e(context.getApplicationContext());
                    }
                }
            }
            return f31849d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f31848c == null) {
                f31848c = new C1724e(context, "push_track.db", 1);
            }
            try {
                return f31848c.getWritableDatabase();
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
                SQLiteDatabase b2 = b(this.f31850e);
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
                            cVar.a = rawQuery.getString(rawQuery.getColumnIndex(c.f31865b.name()));
                            cVar.f31733b = rawQuery.getLong(rawQuery.getColumnIndex(c.f31866c.name()));
                            cVar.f31734c = rawQuery.getString(rawQuery.getColumnIndex(c.f31867d.name()));
                            cVar.f31735d = rawQuery.getLong(rawQuery.getColumnIndex(c.f31868e.name()));
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
                SQLiteDatabase b2 = b(this.f31850e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f31851b.name(), aVar.a);
                    contentValues.put(a.f31852c.name(), aVar.f31707b);
                    contentValues.put(a.f31853d.name(), Long.valueOf(aVar.f31708c));
                    contentValues.put(a.f31854e.name(), aVar.f31709d);
                    contentValues.put(a.f31855f.name(), Long.valueOf(aVar.f31710e));
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
                SQLiteDatabase b2 = b(this.f31850e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f31857b.name(), Long.valueOf(bVar.a));
                    contentValues.put(b.f31858c.name(), Long.valueOf(bVar.f31718b));
                    contentValues.put(b.f31859d.name(), bVar.f31719c);
                    contentValues.put(b.f31860e.name(), Long.valueOf(bVar.f31720d));
                    contentValues.put(b.f31861f.name(), Long.valueOf(bVar.f31721e));
                    contentValues.put(b.f31862g.name(), bVar.f31722f);
                    contentValues.put(b.f31863h.name(), Long.valueOf(bVar.f31723g));
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
                SQLiteDatabase b2 = b(this.f31850e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f31865b.name(), cVar.a);
                    contentValues.put(c.f31866c.name(), Long.valueOf(cVar.f31733b));
                    contentValues.put(c.f31867d.name(), cVar.f31734c);
                    contentValues.put(c.f31868e.name(), Long.valueOf(cVar.f31735d));
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
                SQLiteDatabase b2 = b(this.f31850e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f31870b.name(), dVar.a);
                    contentValues.put(d.f31871c.name(), dVar.f31745b);
                    contentValues.put(d.f31872d.name(), dVar.f31746c);
                    contentValues.put(d.f31873e.name(), dVar.f31747d);
                    contentValues.put(d.f31874f.name(), Long.valueOf(dVar.f31748e));
                    contentValues.put(d.f31875g.name(), Long.valueOf(dVar.f31749f));
                    contentValues.put(d.f31876h.name(), Long.valueOf(dVar.f31750g));
                    contentValues.put(d.f31877i.name(), dVar.f31751h);
                    contentValues.put(d.f31878j.name(), Long.valueOf(dVar.f31752i));
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
                SQLiteDatabase b2 = b(this.f31850e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f31884b.name(), eVar.a);
                    contentValues.put(f.f31885c.name(), eVar.f31753b);
                    contentValues.put(f.f31886d.name(), Long.valueOf(eVar.f31754c));
                    contentValues.put(f.f31887e.name(), Long.valueOf(eVar.f31755d));
                    contentValues.put(f.f31888f.name(), Long.valueOf(eVar.f31756e));
                    contentValues.put(f.f31889g.name(), eVar.f31757f);
                    contentValues.put(f.f31890h.name(), Long.valueOf(eVar.f31758g));
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
                SQLiteDatabase b2 = b(this.f31850e);
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
                        dVar.a = cursor.getString(cursor.getColumnIndex(d.f31870b.name()));
                        dVar.f31745b = cursor.getString(cursor.getColumnIndex(d.f31871c.name()));
                        dVar.f31746c = cursor.getString(cursor.getColumnIndex(d.f31872d.name()));
                        dVar.f31747d = cursor.getString(cursor.getColumnIndex(d.f31873e.name()));
                        dVar.f31748e = cursor.getLong(cursor.getColumnIndex(d.f31874f.name()));
                        dVar.f31749f = cursor.getLong(cursor.getColumnIndex(d.f31875g.name()));
                        dVar.f31750g = cursor.getLong(cursor.getColumnIndex(d.f31876h.name()));
                        dVar.f31751h = cursor.getString(cursor.getColumnIndex(d.f31877i.name()));
                        dVar.f31752i = cursor.getLong(cursor.getColumnIndex(d.f31878j.name()));
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
                SQLiteDatabase b2 = b(this.f31850e);
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
                        bVar.a = cursor.getLong(cursor.getColumnIndex(b.f31857b.name()));
                        bVar.f31718b = cursor.getLong(cursor.getColumnIndex(b.f31858c.name()));
                        bVar.f31719c = cursor.getString(cursor.getColumnIndex(b.f31859d.name()));
                        bVar.f31720d = cursor.getLong(cursor.getColumnIndex(b.f31860e.name()));
                        bVar.f31721e = cursor.getLong(cursor.getColumnIndex(b.f31861f.name()));
                        bVar.f31722f = cursor.getString(cursor.getColumnIndex(b.f31862g.name()));
                        bVar.f31723g = cursor.getLong(cursor.getColumnIndex(b.f31863h.name()));
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
                SQLiteDatabase b2 = b(this.f31850e);
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
                        eVar.a = cursor.getString(cursor.getColumnIndex(f.f31884b.name()));
                        eVar.f31753b = cursor.getString(cursor.getColumnIndex(f.f31885c.name()));
                        eVar.f31754c = cursor.getLong(cursor.getColumnIndex(f.f31886d.name()));
                        eVar.f31755d = cursor.getLong(cursor.getColumnIndex(f.f31887e.name()));
                        eVar.f31756e = cursor.getLong(cursor.getColumnIndex(f.f31888f.name()));
                        eVar.f31757f = cursor.getString(cursor.getColumnIndex(f.f31889g.name()));
                        eVar.f31758g = cursor.getLong(cursor.getColumnIndex(f.f31890h.name()));
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
                SQLiteDatabase b2 = b(this.f31850e);
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
                        aVar.a = cursor.getString(cursor.getColumnIndex(a.f31851b.name()));
                        aVar.f31707b = cursor.getString(cursor.getColumnIndex(a.f31852c.name()));
                        aVar.f31708c = cursor.getLong(cursor.getColumnIndex(a.f31853d.name()));
                        aVar.f31709d = cursor.getString(cursor.getColumnIndex(a.f31854e.name()));
                        aVar.f31710e = cursor.getLong(cursor.getColumnIndex(a.f31855f.name()));
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
                SQLiteDatabase b2 = b(this.f31850e);
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
