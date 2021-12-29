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
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object a;

    /* renamed from: b  reason: collision with root package name */
    public static String f32862b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1707e f32863c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f32864d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f32865e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f32866b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f32867c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f32868d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f32869e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f32870f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f32871g;
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
            f32866b = new a("type", 1);
            f32867c = new a("value", 2);
            f32868d = new a("timestamp", 3);
            f32869e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f32870f = aVar;
            f32871g = new a[]{a, f32866b, f32867c, f32868d, f32869e, aVar};
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
    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f32872b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f32873c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f32874d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f32875e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f32876f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f32877g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f32878h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f32879i;
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
            f32872b = new b("startTime", 1);
            f32873c = new b("stopTime", 2);
            f32874d = new b("reason", 3);
            f32875e = new b("retryTime", 4);
            f32876f = new b("retryCount", 5);
            f32877g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f32878h = bVar;
            f32879i = new b[]{a, f32872b, f32873c, f32874d, f32875e, f32876f, f32877g, bVar};
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
    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f32880b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f32881c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f32882d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f32883e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f32884f;
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
            f32880b = new c("exception", 1);
            f32881c = new c("timestamp", 2);
            f32882d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f32883e = cVar;
            f32884f = new c[]{a, f32880b, f32881c, f32882d, cVar};
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
    /* loaded from: classes9.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f32885b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f32886c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f32887d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f32888e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f32889f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f32890g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f32891h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f32892i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f32893j;

        /* renamed from: k  reason: collision with root package name */
        public static final /* synthetic */ d[] f32894k;
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
            f32885b = new d("tableName", 1);
            f32886c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f32887d = new d("method", 3);
            f32888e = new d("action", 4);
            f32889f = new d("startTime", 5);
            f32890g = new d("endTime", 6);
            f32891h = new d("duration", 7);
            f32892i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f32893j = dVar;
            f32894k = new d[]{a, f32885b, f32886c, f32887d, f32888e, f32889f, f32890g, f32891h, f32892i, dVar};
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
    /* loaded from: classes9.dex */
    public static class C1707e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f32895b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f32896c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f32897d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f32898e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f32899f;

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
            a = "CREATE TABLE crash (" + c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f32880b.name() + " TEXT, " + c.f32881c.name() + " LONG, " + c.f32882d.name() + " TEXT, " + c.f32883e.name() + " LONG NOT NULL );";
            f32895b = "CREATE TABLE db (" + d.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f32885b.name() + " TEXT, " + d.f32886c.name() + " TEXT, " + d.f32887d.name() + " TEXT, " + d.f32888e.name() + " TEXT, " + d.f32889f.name() + " LONG, " + d.f32890g.name() + " LONG, " + d.f32891h.name() + " LONG, " + d.f32892i.name() + " TEXT, " + d.f32893j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f32872b.name());
            sb.append(" LONG, ");
            sb.append(b.f32873c.name());
            sb.append(" LONG, ");
            sb.append(b.f32874d.name());
            sb.append(" TEXT, ");
            sb.append(b.f32875e.name());
            sb.append(" LONG, ");
            sb.append(b.f32876f.name());
            sb.append(" LONG, ");
            sb.append(b.f32877g.name());
            sb.append(" TEXT, ");
            sb.append(b.f32878h.name());
            sb.append(" LONG NOT NULL );");
            f32896c = sb.toString();
            f32897d = "CREATE TABLE request (" + f.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f32900b.name() + " TEXT, " + f.f32901c.name() + " TEXT, " + f.f32902d.name() + " LONG, " + f.f32903e.name() + " LONG, " + f.f32904f.name() + " LONG, " + f.f32905g.name() + " TEXT, " + f.f32906h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f32866b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32867c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32868d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f32869e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32870f.name());
            sb2.append(" LONG NOT NULL);");
            f32898e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1707e(Context context, String str, int i2) {
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
            this.f32899f = context;
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
                    sQLiteDatabase.execSQL(f32895b);
                    sQLiteDatabase.execSQL(f32896c);
                    sQLiteDatabase.execSQL(f32897d);
                    sQLiteDatabase.execSQL(f32898e);
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
    /* loaded from: classes9.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f32900b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f32901c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f32902d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f32903e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f32904f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f32905g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f32906h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f32907i;
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
            f32900b = new f("method", 1);
            f32901c = new f("requestId", 2);
            f32902d = new f("timestamp", 3);
            f32903e = new f("responseTime", 4);
            f32904f = new f("errorCode", 5);
            f32905g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f32906h = fVar;
            f32907i = new f[]{a, f32900b, f32901c, f32902d, f32903e, f32904f, f32905g, fVar};
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
        this.f32865e = context;
        f32863c = new C1707e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f32864d == null) {
                synchronized (a) {
                    if (f32864d == null) {
                        f32864d = new e(context.getApplicationContext());
                    }
                }
            }
            return f32864d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f32863c == null) {
                f32863c = new C1707e(context, "push_track.db", 1);
            }
            try {
                return f32863c.getWritableDatabase();
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
                SQLiteDatabase b2 = b(this.f32865e);
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
                            cVar.a = rawQuery.getString(rawQuery.getColumnIndex(c.f32880b.name()));
                            cVar.f32744b = rawQuery.getLong(rawQuery.getColumnIndex(c.f32881c.name()));
                            cVar.f32745c = rawQuery.getString(rawQuery.getColumnIndex(c.f32882d.name()));
                            cVar.f32746d = rawQuery.getLong(rawQuery.getColumnIndex(c.f32883e.name()));
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
                SQLiteDatabase b2 = b(this.f32865e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f32866b.name(), aVar.a);
                    contentValues.put(a.f32867c.name(), aVar.f32718b);
                    contentValues.put(a.f32868d.name(), Long.valueOf(aVar.f32719c));
                    contentValues.put(a.f32869e.name(), aVar.f32720d);
                    contentValues.put(a.f32870f.name(), Long.valueOf(aVar.f32721e));
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
                SQLiteDatabase b2 = b(this.f32865e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f32872b.name(), Long.valueOf(bVar.a));
                    contentValues.put(b.f32873c.name(), Long.valueOf(bVar.f32729b));
                    contentValues.put(b.f32874d.name(), bVar.f32730c);
                    contentValues.put(b.f32875e.name(), Long.valueOf(bVar.f32731d));
                    contentValues.put(b.f32876f.name(), Long.valueOf(bVar.f32732e));
                    contentValues.put(b.f32877g.name(), bVar.f32733f);
                    contentValues.put(b.f32878h.name(), Long.valueOf(bVar.f32734g));
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
                SQLiteDatabase b2 = b(this.f32865e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f32880b.name(), cVar.a);
                    contentValues.put(c.f32881c.name(), Long.valueOf(cVar.f32744b));
                    contentValues.put(c.f32882d.name(), cVar.f32745c);
                    contentValues.put(c.f32883e.name(), Long.valueOf(cVar.f32746d));
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
                SQLiteDatabase b2 = b(this.f32865e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f32885b.name(), dVar.a);
                    contentValues.put(d.f32886c.name(), dVar.f32757b);
                    contentValues.put(d.f32887d.name(), dVar.f32758c);
                    contentValues.put(d.f32888e.name(), dVar.f32759d);
                    contentValues.put(d.f32889f.name(), Long.valueOf(dVar.f32760e));
                    contentValues.put(d.f32890g.name(), Long.valueOf(dVar.f32761f));
                    contentValues.put(d.f32891h.name(), Long.valueOf(dVar.f32762g));
                    contentValues.put(d.f32892i.name(), dVar.f32763h);
                    contentValues.put(d.f32893j.name(), Long.valueOf(dVar.f32764i));
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
                SQLiteDatabase b2 = b(this.f32865e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f32900b.name(), eVar.a);
                    contentValues.put(f.f32901c.name(), eVar.f32765b);
                    contentValues.put(f.f32902d.name(), Long.valueOf(eVar.f32766c));
                    contentValues.put(f.f32903e.name(), Long.valueOf(eVar.f32767d));
                    contentValues.put(f.f32904f.name(), Long.valueOf(eVar.f32768e));
                    contentValues.put(f.f32905g.name(), eVar.f32769f);
                    contentValues.put(f.f32906h.name(), Long.valueOf(eVar.f32770g));
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
                SQLiteDatabase b2 = b(this.f32865e);
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
                        dVar.a = cursor.getString(cursor.getColumnIndex(d.f32885b.name()));
                        dVar.f32757b = cursor.getString(cursor.getColumnIndex(d.f32886c.name()));
                        dVar.f32758c = cursor.getString(cursor.getColumnIndex(d.f32887d.name()));
                        dVar.f32759d = cursor.getString(cursor.getColumnIndex(d.f32888e.name()));
                        dVar.f32760e = cursor.getLong(cursor.getColumnIndex(d.f32889f.name()));
                        dVar.f32761f = cursor.getLong(cursor.getColumnIndex(d.f32890g.name()));
                        dVar.f32762g = cursor.getLong(cursor.getColumnIndex(d.f32891h.name()));
                        dVar.f32763h = cursor.getString(cursor.getColumnIndex(d.f32892i.name()));
                        dVar.f32764i = cursor.getLong(cursor.getColumnIndex(d.f32893j.name()));
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
                SQLiteDatabase b2 = b(this.f32865e);
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
                        bVar.a = cursor.getLong(cursor.getColumnIndex(b.f32872b.name()));
                        bVar.f32729b = cursor.getLong(cursor.getColumnIndex(b.f32873c.name()));
                        bVar.f32730c = cursor.getString(cursor.getColumnIndex(b.f32874d.name()));
                        bVar.f32731d = cursor.getLong(cursor.getColumnIndex(b.f32875e.name()));
                        bVar.f32732e = cursor.getLong(cursor.getColumnIndex(b.f32876f.name()));
                        bVar.f32733f = cursor.getString(cursor.getColumnIndex(b.f32877g.name()));
                        bVar.f32734g = cursor.getLong(cursor.getColumnIndex(b.f32878h.name()));
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
                SQLiteDatabase b2 = b(this.f32865e);
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
                        eVar.a = cursor.getString(cursor.getColumnIndex(f.f32900b.name()));
                        eVar.f32765b = cursor.getString(cursor.getColumnIndex(f.f32901c.name()));
                        eVar.f32766c = cursor.getLong(cursor.getColumnIndex(f.f32902d.name()));
                        eVar.f32767d = cursor.getLong(cursor.getColumnIndex(f.f32903e.name()));
                        eVar.f32768e = cursor.getLong(cursor.getColumnIndex(f.f32904f.name()));
                        eVar.f32769f = cursor.getString(cursor.getColumnIndex(f.f32905g.name()));
                        eVar.f32770g = cursor.getLong(cursor.getColumnIndex(f.f32906h.name()));
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
                SQLiteDatabase b2 = b(this.f32865e);
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
                        aVar.a = cursor.getString(cursor.getColumnIndex(a.f32866b.name()));
                        aVar.f32718b = cursor.getString(cursor.getColumnIndex(a.f32867c.name()));
                        aVar.f32719c = cursor.getLong(cursor.getColumnIndex(a.f32868d.name()));
                        aVar.f32720d = cursor.getString(cursor.getColumnIndex(a.f32869e.name()));
                        aVar.f32721e = cursor.getLong(cursor.getColumnIndex(a.f32870f.name()));
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
                SQLiteDatabase b2 = b(this.f32865e);
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
