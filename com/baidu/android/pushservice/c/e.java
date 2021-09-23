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
    public static final Object f37140a;

    /* renamed from: b  reason: collision with root package name */
    public static String f37141b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1588e f37142c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f37143d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f37144e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f37145a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f37146b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f37147c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f37148d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f37149e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f37150f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f37151g;
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
            f37145a = new a("ackId", 0);
            f37146b = new a("type", 1);
            f37147c = new a("value", 2);
            f37148d = new a("timestamp", 3);
            f37149e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f37150f = aVar;
            f37151g = new a[]{f37145a, f37146b, f37147c, f37148d, f37149e, aVar};
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
        public static final b f37152a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f37153b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f37154c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f37155d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f37156e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f37157f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f37158g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f37159h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f37160i;
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
            f37152a = new b("connectionId", 0);
            f37153b = new b("startTime", 1);
            f37154c = new b("stopTime", 2);
            f37155d = new b("reason", 3);
            f37156e = new b("retryTime", 4);
            f37157f = new b("retryCount", 5);
            f37158g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f37159h = bVar;
            f37160i = new b[]{f37152a, f37153b, f37154c, f37155d, f37156e, f37157f, f37158g, bVar};
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
        public static final c f37161a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f37162b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f37163c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f37164d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f37165e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f37166f;
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
            f37161a = new c("crashId", 0);
            f37162b = new c("exception", 1);
            f37163c = new c("timestamp", 2);
            f37164d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f37165e = cVar;
            f37166f = new c[]{f37161a, f37162b, f37163c, f37164d, cVar};
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
        public static final d f37167a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f37168b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f37169c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f37170d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f37171e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f37172f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f37173g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f37174h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f37175i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f37176j;
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
            f37167a = new d("dbId", 0);
            f37168b = new d("tableName", 1);
            f37169c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f37170d = new d("method", 3);
            f37171e = new d("action", 4);
            f37172f = new d("startTime", 5);
            f37173g = new d("endTime", 6);
            f37174h = new d("duration", 7);
            f37175i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f37176j = dVar;
            k = new d[]{f37167a, f37168b, f37169c, f37170d, f37171e, f37172f, f37173g, f37174h, f37175i, dVar};
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
    public static class C1588e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f37177a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f37178b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f37179c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f37180d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f37181e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f37182f;

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
            f37177a = "CREATE TABLE crash (" + c.f37161a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f37162b.name() + " TEXT, " + c.f37163c.name() + " LONG, " + c.f37164d.name() + " TEXT, " + c.f37165e.name() + " LONG NOT NULL );";
            f37178b = "CREATE TABLE db (" + d.f37167a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f37168b.name() + " TEXT, " + d.f37169c.name() + " TEXT, " + d.f37170d.name() + " TEXT, " + d.f37171e.name() + " TEXT, " + d.f37172f.name() + " LONG, " + d.f37173g.name() + " LONG, " + d.f37174h.name() + " LONG, " + d.f37175i.name() + " TEXT, " + d.f37176j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f37152a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f37153b.name());
            sb.append(" LONG, ");
            sb.append(b.f37154c.name());
            sb.append(" LONG, ");
            sb.append(b.f37155d.name());
            sb.append(" TEXT, ");
            sb.append(b.f37156e.name());
            sb.append(" LONG, ");
            sb.append(b.f37157f.name());
            sb.append(" LONG, ");
            sb.append(b.f37158g.name());
            sb.append(" TEXT, ");
            sb.append(b.f37159h.name());
            sb.append(" LONG NOT NULL );");
            f37179c = sb.toString();
            f37180d = "CREATE TABLE request (" + f.f37183a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f37184b.name() + " TEXT, " + f.f37185c.name() + " TEXT, " + f.f37186d.name() + " LONG, " + f.f37187e.name() + " LONG, " + f.f37188f.name() + " LONG, " + f.f37189g.name() + " TEXT, " + f.f37190h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f37145a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f37146b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f37147c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f37148d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f37149e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f37150f.name());
            sb2.append(" LONG NOT NULL);");
            f37181e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1588e(Context context, String str, int i2) {
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
            this.f37182f = context;
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
                    sQLiteDatabase.execSQL(f37177a);
                    sQLiteDatabase.execSQL(f37178b);
                    sQLiteDatabase.execSQL(f37179c);
                    sQLiteDatabase.execSQL(f37180d);
                    sQLiteDatabase.execSQL(f37181e);
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
        public static final f f37183a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f37184b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f37185c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f37186d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f37187e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f37188f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f37189g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f37190h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f37191i;
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
            f37183a = new f("id", 0);
            f37184b = new f("method", 1);
            f37185c = new f("requestId", 2);
            f37186d = new f("timestamp", 3);
            f37187e = new f("responseTime", 4);
            f37188f = new f("errorCode", 5);
            f37189g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f37190h = fVar;
            f37191i = new f[]{f37183a, f37184b, f37185c, f37186d, f37187e, f37188f, f37189g, fVar};
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
        f37140a = new Object();
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
        this.f37144e = context;
        f37142c = new C1588e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f37143d == null) {
                synchronized (f37140a) {
                    if (f37143d == null) {
                        f37143d = new e(context.getApplicationContext());
                    }
                }
            }
            return f37143d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f37142c == null) {
                f37142c = new C1588e(context, "push_track.db", 1);
            }
            try {
                return f37142c.getWritableDatabase();
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
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
                            cVar.f37008a = rawQuery.getString(rawQuery.getColumnIndex(c.f37162b.name()));
                            cVar.f37009b = rawQuery.getLong(rawQuery.getColumnIndex(c.f37163c.name()));
                            cVar.f37010c = rawQuery.getString(rawQuery.getColumnIndex(c.f37164d.name()));
                            cVar.f37011d = rawQuery.getLong(rawQuery.getColumnIndex(c.f37165e.name()));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f37146b.name(), aVar.f36978a);
                    contentValues.put(a.f37147c.name(), aVar.f36979b);
                    contentValues.put(a.f37148d.name(), Long.valueOf(aVar.f36980c));
                    contentValues.put(a.f37149e.name(), aVar.f36981d);
                    contentValues.put(a.f37150f.name(), Long.valueOf(aVar.f36982e));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f37153b.name(), Long.valueOf(bVar.f36991a));
                    contentValues.put(b.f37154c.name(), Long.valueOf(bVar.f36992b));
                    contentValues.put(b.f37155d.name(), bVar.f36993c);
                    contentValues.put(b.f37156e.name(), Long.valueOf(bVar.f36994d));
                    contentValues.put(b.f37157f.name(), Long.valueOf(bVar.f36995e));
                    contentValues.put(b.f37158g.name(), bVar.f36996f);
                    contentValues.put(b.f37159h.name(), Long.valueOf(bVar.f36997g));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f37162b.name(), cVar.f37008a);
                    contentValues.put(c.f37163c.name(), Long.valueOf(cVar.f37009b));
                    contentValues.put(c.f37164d.name(), cVar.f37010c);
                    contentValues.put(c.f37165e.name(), Long.valueOf(cVar.f37011d));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f37168b.name(), dVar.f37022a);
                    contentValues.put(d.f37169c.name(), dVar.f37023b);
                    contentValues.put(d.f37170d.name(), dVar.f37024c);
                    contentValues.put(d.f37171e.name(), dVar.f37025d);
                    contentValues.put(d.f37172f.name(), Long.valueOf(dVar.f37026e));
                    contentValues.put(d.f37173g.name(), Long.valueOf(dVar.f37027f));
                    contentValues.put(d.f37174h.name(), Long.valueOf(dVar.f37028g));
                    contentValues.put(d.f37175i.name(), dVar.f37029h);
                    contentValues.put(d.f37176j.name(), Long.valueOf(dVar.f37030i));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f37184b.name(), eVar.f37031a);
                    contentValues.put(f.f37185c.name(), eVar.f37032b);
                    contentValues.put(f.f37186d.name(), Long.valueOf(eVar.f37033c));
                    contentValues.put(f.f37187e.name(), Long.valueOf(eVar.f37034d));
                    contentValues.put(f.f37188f.name(), Long.valueOf(eVar.f37035e));
                    contentValues.put(f.f37189g.name(), eVar.f37036f);
                    contentValues.put(f.f37190h.name(), Long.valueOf(eVar.f37037g));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
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
                        dVar.f37022a = cursor.getString(cursor.getColumnIndex(d.f37168b.name()));
                        dVar.f37023b = cursor.getString(cursor.getColumnIndex(d.f37169c.name()));
                        dVar.f37024c = cursor.getString(cursor.getColumnIndex(d.f37170d.name()));
                        dVar.f37025d = cursor.getString(cursor.getColumnIndex(d.f37171e.name()));
                        dVar.f37026e = cursor.getLong(cursor.getColumnIndex(d.f37172f.name()));
                        dVar.f37027f = cursor.getLong(cursor.getColumnIndex(d.f37173g.name()));
                        dVar.f37028g = cursor.getLong(cursor.getColumnIndex(d.f37174h.name()));
                        dVar.f37029h = cursor.getString(cursor.getColumnIndex(d.f37175i.name()));
                        dVar.f37030i = cursor.getLong(cursor.getColumnIndex(d.f37176j.name()));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
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
                        bVar.f36991a = cursor.getLong(cursor.getColumnIndex(b.f37153b.name()));
                        bVar.f36992b = cursor.getLong(cursor.getColumnIndex(b.f37154c.name()));
                        bVar.f36993c = cursor.getString(cursor.getColumnIndex(b.f37155d.name()));
                        bVar.f36994d = cursor.getLong(cursor.getColumnIndex(b.f37156e.name()));
                        bVar.f36995e = cursor.getLong(cursor.getColumnIndex(b.f37157f.name()));
                        bVar.f36996f = cursor.getString(cursor.getColumnIndex(b.f37158g.name()));
                        bVar.f36997g = cursor.getLong(cursor.getColumnIndex(b.f37159h.name()));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
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
                        eVar.f37031a = cursor.getString(cursor.getColumnIndex(f.f37184b.name()));
                        eVar.f37032b = cursor.getString(cursor.getColumnIndex(f.f37185c.name()));
                        eVar.f37033c = cursor.getLong(cursor.getColumnIndex(f.f37186d.name()));
                        eVar.f37034d = cursor.getLong(cursor.getColumnIndex(f.f37187e.name()));
                        eVar.f37035e = cursor.getLong(cursor.getColumnIndex(f.f37188f.name()));
                        eVar.f37036f = cursor.getString(cursor.getColumnIndex(f.f37189g.name()));
                        eVar.f37037g = cursor.getLong(cursor.getColumnIndex(f.f37190h.name()));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
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
                        aVar.f36978a = cursor.getString(cursor.getColumnIndex(a.f37146b.name()));
                        aVar.f36979b = cursor.getString(cursor.getColumnIndex(a.f37147c.name()));
                        aVar.f36980c = cursor.getLong(cursor.getColumnIndex(a.f37148d.name()));
                        aVar.f36981d = cursor.getString(cursor.getColumnIndex(a.f37149e.name()));
                        aVar.f36982e = cursor.getLong(cursor.getColumnIndex(a.f37150f.name()));
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
            synchronized (f37140a) {
                SQLiteDatabase b2 = b(this.f37144e);
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
