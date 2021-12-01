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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object a;

    /* renamed from: b  reason: collision with root package name */
    public static String f32348b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1661e f32349c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f32350d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f32351e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f32352b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f32353c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f32354d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f32355e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f32356f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f32357g;
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
            f32352b = new a("type", 1);
            f32353c = new a("value", 2);
            f32354d = new a("timestamp", 3);
            f32355e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f32356f = aVar;
            f32357g = new a[]{a, f32352b, f32353c, f32354d, f32355e, aVar};
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
    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f32358b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f32359c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f32360d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f32361e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f32362f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f32363g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f32364h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f32365i;
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
            f32358b = new b("startTime", 1);
            f32359c = new b("stopTime", 2);
            f32360d = new b("reason", 3);
            f32361e = new b("retryTime", 4);
            f32362f = new b("retryCount", 5);
            f32363g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f32364h = bVar;
            f32365i = new b[]{a, f32358b, f32359c, f32360d, f32361e, f32362f, f32363g, bVar};
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
    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f32366b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f32367c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f32368d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f32369e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f32370f;
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
            f32366b = new c("exception", 1);
            f32367c = new c("timestamp", 2);
            f32368d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f32369e = cVar;
            f32370f = new c[]{a, f32366b, f32367c, f32368d, cVar};
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
    /* loaded from: classes8.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f32371b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f32372c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f32373d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f32374e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f32375f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f32376g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f32377h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f32378i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f32379j;

        /* renamed from: k  reason: collision with root package name */
        public static final /* synthetic */ d[] f32380k;
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
            f32371b = new d("tableName", 1);
            f32372c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f32373d = new d("method", 3);
            f32374e = new d("action", 4);
            f32375f = new d("startTime", 5);
            f32376g = new d("endTime", 6);
            f32377h = new d("duration", 7);
            f32378i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f32379j = dVar;
            f32380k = new d[]{a, f32371b, f32372c, f32373d, f32374e, f32375f, f32376g, f32377h, f32378i, dVar};
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
    /* loaded from: classes8.dex */
    public static class C1661e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f32381b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f32382c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f32383d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f32384e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f32385f;

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
            a = "CREATE TABLE crash (" + c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f32366b.name() + " TEXT, " + c.f32367c.name() + " LONG, " + c.f32368d.name() + " TEXT, " + c.f32369e.name() + " LONG NOT NULL );";
            f32381b = "CREATE TABLE db (" + d.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f32371b.name() + " TEXT, " + d.f32372c.name() + " TEXT, " + d.f32373d.name() + " TEXT, " + d.f32374e.name() + " TEXT, " + d.f32375f.name() + " LONG, " + d.f32376g.name() + " LONG, " + d.f32377h.name() + " LONG, " + d.f32378i.name() + " TEXT, " + d.f32379j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f32358b.name());
            sb.append(" LONG, ");
            sb.append(b.f32359c.name());
            sb.append(" LONG, ");
            sb.append(b.f32360d.name());
            sb.append(" TEXT, ");
            sb.append(b.f32361e.name());
            sb.append(" LONG, ");
            sb.append(b.f32362f.name());
            sb.append(" LONG, ");
            sb.append(b.f32363g.name());
            sb.append(" TEXT, ");
            sb.append(b.f32364h.name());
            sb.append(" LONG NOT NULL );");
            f32382c = sb.toString();
            f32383d = "CREATE TABLE request (" + f.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f32386b.name() + " TEXT, " + f.f32387c.name() + " TEXT, " + f.f32388d.name() + " LONG, " + f.f32389e.name() + " LONG, " + f.f32390f.name() + " LONG, " + f.f32391g.name() + " TEXT, " + f.f32392h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f32352b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32353c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32354d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f32355e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32356f.name());
            sb2.append(" LONG NOT NULL);");
            f32384e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1661e(Context context, String str, int i2) {
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
            this.f32385f = context;
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
                    sQLiteDatabase.execSQL(f32381b);
                    sQLiteDatabase.execSQL(f32382c);
                    sQLiteDatabase.execSQL(f32383d);
                    sQLiteDatabase.execSQL(f32384e);
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
    /* loaded from: classes8.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f32386b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f32387c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f32388d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f32389e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f32390f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f32391g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f32392h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f32393i;
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
            f32386b = new f("method", 1);
            f32387c = new f("requestId", 2);
            f32388d = new f("timestamp", 3);
            f32389e = new f("responseTime", 4);
            f32390f = new f("errorCode", 5);
            f32391g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f32392h = fVar;
            f32393i = new f[]{a, f32386b, f32387c, f32388d, f32389e, f32390f, f32391g, fVar};
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
        this.f32351e = context;
        f32349c = new C1661e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f32350d == null) {
                synchronized (a) {
                    if (f32350d == null) {
                        f32350d = new e(context.getApplicationContext());
                    }
                }
            }
            return f32350d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f32349c == null) {
                f32349c = new C1661e(context, "push_track.db", 1);
            }
            try {
                return f32349c.getWritableDatabase();
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
                SQLiteDatabase b2 = b(this.f32351e);
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
                            cVar.a = rawQuery.getString(rawQuery.getColumnIndex(c.f32366b.name()));
                            cVar.f32230b = rawQuery.getLong(rawQuery.getColumnIndex(c.f32367c.name()));
                            cVar.f32231c = rawQuery.getString(rawQuery.getColumnIndex(c.f32368d.name()));
                            cVar.f32232d = rawQuery.getLong(rawQuery.getColumnIndex(c.f32369e.name()));
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
                SQLiteDatabase b2 = b(this.f32351e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f32352b.name(), aVar.a);
                    contentValues.put(a.f32353c.name(), aVar.f32204b);
                    contentValues.put(a.f32354d.name(), Long.valueOf(aVar.f32205c));
                    contentValues.put(a.f32355e.name(), aVar.f32206d);
                    contentValues.put(a.f32356f.name(), Long.valueOf(aVar.f32207e));
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
                SQLiteDatabase b2 = b(this.f32351e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f32358b.name(), Long.valueOf(bVar.a));
                    contentValues.put(b.f32359c.name(), Long.valueOf(bVar.f32215b));
                    contentValues.put(b.f32360d.name(), bVar.f32216c);
                    contentValues.put(b.f32361e.name(), Long.valueOf(bVar.f32217d));
                    contentValues.put(b.f32362f.name(), Long.valueOf(bVar.f32218e));
                    contentValues.put(b.f32363g.name(), bVar.f32219f);
                    contentValues.put(b.f32364h.name(), Long.valueOf(bVar.f32220g));
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
                SQLiteDatabase b2 = b(this.f32351e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f32366b.name(), cVar.a);
                    contentValues.put(c.f32367c.name(), Long.valueOf(cVar.f32230b));
                    contentValues.put(c.f32368d.name(), cVar.f32231c);
                    contentValues.put(c.f32369e.name(), Long.valueOf(cVar.f32232d));
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
                SQLiteDatabase b2 = b(this.f32351e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f32371b.name(), dVar.a);
                    contentValues.put(d.f32372c.name(), dVar.f32243b);
                    contentValues.put(d.f32373d.name(), dVar.f32244c);
                    contentValues.put(d.f32374e.name(), dVar.f32245d);
                    contentValues.put(d.f32375f.name(), Long.valueOf(dVar.f32246e));
                    contentValues.put(d.f32376g.name(), Long.valueOf(dVar.f32247f));
                    contentValues.put(d.f32377h.name(), Long.valueOf(dVar.f32248g));
                    contentValues.put(d.f32378i.name(), dVar.f32249h);
                    contentValues.put(d.f32379j.name(), Long.valueOf(dVar.f32250i));
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
                SQLiteDatabase b2 = b(this.f32351e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f32386b.name(), eVar.a);
                    contentValues.put(f.f32387c.name(), eVar.f32251b);
                    contentValues.put(f.f32388d.name(), Long.valueOf(eVar.f32252c));
                    contentValues.put(f.f32389e.name(), Long.valueOf(eVar.f32253d));
                    contentValues.put(f.f32390f.name(), Long.valueOf(eVar.f32254e));
                    contentValues.put(f.f32391g.name(), eVar.f32255f);
                    contentValues.put(f.f32392h.name(), Long.valueOf(eVar.f32256g));
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
                SQLiteDatabase b2 = b(this.f32351e);
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
                        dVar.a = cursor.getString(cursor.getColumnIndex(d.f32371b.name()));
                        dVar.f32243b = cursor.getString(cursor.getColumnIndex(d.f32372c.name()));
                        dVar.f32244c = cursor.getString(cursor.getColumnIndex(d.f32373d.name()));
                        dVar.f32245d = cursor.getString(cursor.getColumnIndex(d.f32374e.name()));
                        dVar.f32246e = cursor.getLong(cursor.getColumnIndex(d.f32375f.name()));
                        dVar.f32247f = cursor.getLong(cursor.getColumnIndex(d.f32376g.name()));
                        dVar.f32248g = cursor.getLong(cursor.getColumnIndex(d.f32377h.name()));
                        dVar.f32249h = cursor.getString(cursor.getColumnIndex(d.f32378i.name()));
                        dVar.f32250i = cursor.getLong(cursor.getColumnIndex(d.f32379j.name()));
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
                SQLiteDatabase b2 = b(this.f32351e);
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
                        bVar.a = cursor.getLong(cursor.getColumnIndex(b.f32358b.name()));
                        bVar.f32215b = cursor.getLong(cursor.getColumnIndex(b.f32359c.name()));
                        bVar.f32216c = cursor.getString(cursor.getColumnIndex(b.f32360d.name()));
                        bVar.f32217d = cursor.getLong(cursor.getColumnIndex(b.f32361e.name()));
                        bVar.f32218e = cursor.getLong(cursor.getColumnIndex(b.f32362f.name()));
                        bVar.f32219f = cursor.getString(cursor.getColumnIndex(b.f32363g.name()));
                        bVar.f32220g = cursor.getLong(cursor.getColumnIndex(b.f32364h.name()));
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
                SQLiteDatabase b2 = b(this.f32351e);
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
                        eVar.a = cursor.getString(cursor.getColumnIndex(f.f32386b.name()));
                        eVar.f32251b = cursor.getString(cursor.getColumnIndex(f.f32387c.name()));
                        eVar.f32252c = cursor.getLong(cursor.getColumnIndex(f.f32388d.name()));
                        eVar.f32253d = cursor.getLong(cursor.getColumnIndex(f.f32389e.name()));
                        eVar.f32254e = cursor.getLong(cursor.getColumnIndex(f.f32390f.name()));
                        eVar.f32255f = cursor.getString(cursor.getColumnIndex(f.f32391g.name()));
                        eVar.f32256g = cursor.getLong(cursor.getColumnIndex(f.f32392h.name()));
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
                SQLiteDatabase b2 = b(this.f32351e);
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
                        aVar.a = cursor.getString(cursor.getColumnIndex(a.f32352b.name()));
                        aVar.f32204b = cursor.getString(cursor.getColumnIndex(a.f32353c.name()));
                        aVar.f32205c = cursor.getLong(cursor.getColumnIndex(a.f32354d.name()));
                        aVar.f32206d = cursor.getString(cursor.getColumnIndex(a.f32355e.name()));
                        aVar.f32207e = cursor.getLong(cursor.getColumnIndex(a.f32356f.name()));
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
                SQLiteDatabase b2 = b(this.f32351e);
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
