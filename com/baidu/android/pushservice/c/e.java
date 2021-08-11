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
    public static final Object f36867a;

    /* renamed from: b  reason: collision with root package name */
    public static String f36868b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1580e f36869c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f36870d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f36871e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f36872a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f36873b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f36874c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f36875d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f36876e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f36877f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f36878g;
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
            f36872a = new a("ackId", 0);
            f36873b = new a("type", 1);
            f36874c = new a("value", 2);
            f36875d = new a("timestamp", 3);
            f36876e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f36877f = aVar;
            f36878g = new a[]{f36872a, f36873b, f36874c, f36875d, f36876e, aVar};
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
        public static final b f36879a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f36880b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f36881c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f36882d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f36883e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f36884f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f36885g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f36886h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f36887i;
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
            f36879a = new b("connectionId", 0);
            f36880b = new b("startTime", 1);
            f36881c = new b("stopTime", 2);
            f36882d = new b("reason", 3);
            f36883e = new b("retryTime", 4);
            f36884f = new b("retryCount", 5);
            f36885g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f36886h = bVar;
            f36887i = new b[]{f36879a, f36880b, f36881c, f36882d, f36883e, f36884f, f36885g, bVar};
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
        public static final c f36888a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f36889b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f36890c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f36891d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f36892e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f36893f;
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
            f36888a = new c("crashId", 0);
            f36889b = new c("exception", 1);
            f36890c = new c("timestamp", 2);
            f36891d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f36892e = cVar;
            f36893f = new c[]{f36888a, f36889b, f36890c, f36891d, cVar};
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
        public static final d f36894a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f36895b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f36896c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f36897d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f36898e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f36899f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f36900g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f36901h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f36902i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f36903j;
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
            f36894a = new d("dbId", 0);
            f36895b = new d("tableName", 1);
            f36896c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f36897d = new d("method", 3);
            f36898e = new d("action", 4);
            f36899f = new d("startTime", 5);
            f36900g = new d("endTime", 6);
            f36901h = new d("duration", 7);
            f36902i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f36903j = dVar;
            k = new d[]{f36894a, f36895b, f36896c, f36897d, f36898e, f36899f, f36900g, f36901h, f36902i, dVar};
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
    public static class C1580e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f36904a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f36905b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f36906c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f36907d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f36908e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f36909f;

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
            f36904a = "CREATE TABLE crash (" + c.f36888a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f36889b.name() + " TEXT, " + c.f36890c.name() + " LONG, " + c.f36891d.name() + " TEXT, " + c.f36892e.name() + " LONG NOT NULL );";
            f36905b = "CREATE TABLE db (" + d.f36894a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f36895b.name() + " TEXT, " + d.f36896c.name() + " TEXT, " + d.f36897d.name() + " TEXT, " + d.f36898e.name() + " TEXT, " + d.f36899f.name() + " LONG, " + d.f36900g.name() + " LONG, " + d.f36901h.name() + " LONG, " + d.f36902i.name() + " TEXT, " + d.f36903j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f36879a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f36880b.name());
            sb.append(" LONG, ");
            sb.append(b.f36881c.name());
            sb.append(" LONG, ");
            sb.append(b.f36882d.name());
            sb.append(" TEXT, ");
            sb.append(b.f36883e.name());
            sb.append(" LONG, ");
            sb.append(b.f36884f.name());
            sb.append(" LONG, ");
            sb.append(b.f36885g.name());
            sb.append(" TEXT, ");
            sb.append(b.f36886h.name());
            sb.append(" LONG NOT NULL );");
            f36906c = sb.toString();
            f36907d = "CREATE TABLE request (" + f.f36910a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f36911b.name() + " TEXT, " + f.f36912c.name() + " TEXT, " + f.f36913d.name() + " LONG, " + f.f36914e.name() + " LONG, " + f.f36915f.name() + " LONG, " + f.f36916g.name() + " TEXT, " + f.f36917h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f36872a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f36873b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f36874c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f36875d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f36876e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f36877f.name());
            sb2.append(" LONG NOT NULL);");
            f36908e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1580e(Context context, String str, int i2) {
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
            this.f36909f = context;
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
                    sQLiteDatabase.execSQL(f36904a);
                    sQLiteDatabase.execSQL(f36905b);
                    sQLiteDatabase.execSQL(f36906c);
                    sQLiteDatabase.execSQL(f36907d);
                    sQLiteDatabase.execSQL(f36908e);
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
        public static final f f36910a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f36911b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f36912c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f36913d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f36914e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f36915f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f36916g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f36917h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f36918i;
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
            f36910a = new f("id", 0);
            f36911b = new f("method", 1);
            f36912c = new f("requestId", 2);
            f36913d = new f("timestamp", 3);
            f36914e = new f("responseTime", 4);
            f36915f = new f("errorCode", 5);
            f36916g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f36917h = fVar;
            f36918i = new f[]{f36910a, f36911b, f36912c, f36913d, f36914e, f36915f, f36916g, fVar};
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
        f36867a = new Object();
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
        this.f36871e = context;
        f36869c = new C1580e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f36870d == null) {
                synchronized (f36867a) {
                    if (f36870d == null) {
                        f36870d = new e(context.getApplicationContext());
                    }
                }
            }
            return f36870d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f36869c == null) {
                f36869c = new C1580e(context, "push_track.db", 1);
            }
            try {
                return f36869c.getWritableDatabase();
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
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
                            cVar.f36735a = rawQuery.getString(rawQuery.getColumnIndex(c.f36889b.name()));
                            cVar.f36736b = rawQuery.getLong(rawQuery.getColumnIndex(c.f36890c.name()));
                            cVar.f36737c = rawQuery.getString(rawQuery.getColumnIndex(c.f36891d.name()));
                            cVar.f36738d = rawQuery.getLong(rawQuery.getColumnIndex(c.f36892e.name()));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f36873b.name(), aVar.f36705a);
                    contentValues.put(a.f36874c.name(), aVar.f36706b);
                    contentValues.put(a.f36875d.name(), Long.valueOf(aVar.f36707c));
                    contentValues.put(a.f36876e.name(), aVar.f36708d);
                    contentValues.put(a.f36877f.name(), Long.valueOf(aVar.f36709e));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f36880b.name(), Long.valueOf(bVar.f36718a));
                    contentValues.put(b.f36881c.name(), Long.valueOf(bVar.f36719b));
                    contentValues.put(b.f36882d.name(), bVar.f36720c);
                    contentValues.put(b.f36883e.name(), Long.valueOf(bVar.f36721d));
                    contentValues.put(b.f36884f.name(), Long.valueOf(bVar.f36722e));
                    contentValues.put(b.f36885g.name(), bVar.f36723f);
                    contentValues.put(b.f36886h.name(), Long.valueOf(bVar.f36724g));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f36889b.name(), cVar.f36735a);
                    contentValues.put(c.f36890c.name(), Long.valueOf(cVar.f36736b));
                    contentValues.put(c.f36891d.name(), cVar.f36737c);
                    contentValues.put(c.f36892e.name(), Long.valueOf(cVar.f36738d));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f36895b.name(), dVar.f36749a);
                    contentValues.put(d.f36896c.name(), dVar.f36750b);
                    contentValues.put(d.f36897d.name(), dVar.f36751c);
                    contentValues.put(d.f36898e.name(), dVar.f36752d);
                    contentValues.put(d.f36899f.name(), Long.valueOf(dVar.f36753e));
                    contentValues.put(d.f36900g.name(), Long.valueOf(dVar.f36754f));
                    contentValues.put(d.f36901h.name(), Long.valueOf(dVar.f36755g));
                    contentValues.put(d.f36902i.name(), dVar.f36756h);
                    contentValues.put(d.f36903j.name(), Long.valueOf(dVar.f36757i));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f36911b.name(), eVar.f36758a);
                    contentValues.put(f.f36912c.name(), eVar.f36759b);
                    contentValues.put(f.f36913d.name(), Long.valueOf(eVar.f36760c));
                    contentValues.put(f.f36914e.name(), Long.valueOf(eVar.f36761d));
                    contentValues.put(f.f36915f.name(), Long.valueOf(eVar.f36762e));
                    contentValues.put(f.f36916g.name(), eVar.f36763f);
                    contentValues.put(f.f36917h.name(), Long.valueOf(eVar.f36764g));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
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
                        dVar.f36749a = cursor.getString(cursor.getColumnIndex(d.f36895b.name()));
                        dVar.f36750b = cursor.getString(cursor.getColumnIndex(d.f36896c.name()));
                        dVar.f36751c = cursor.getString(cursor.getColumnIndex(d.f36897d.name()));
                        dVar.f36752d = cursor.getString(cursor.getColumnIndex(d.f36898e.name()));
                        dVar.f36753e = cursor.getLong(cursor.getColumnIndex(d.f36899f.name()));
                        dVar.f36754f = cursor.getLong(cursor.getColumnIndex(d.f36900g.name()));
                        dVar.f36755g = cursor.getLong(cursor.getColumnIndex(d.f36901h.name()));
                        dVar.f36756h = cursor.getString(cursor.getColumnIndex(d.f36902i.name()));
                        dVar.f36757i = cursor.getLong(cursor.getColumnIndex(d.f36903j.name()));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
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
                        bVar.f36718a = cursor.getLong(cursor.getColumnIndex(b.f36880b.name()));
                        bVar.f36719b = cursor.getLong(cursor.getColumnIndex(b.f36881c.name()));
                        bVar.f36720c = cursor.getString(cursor.getColumnIndex(b.f36882d.name()));
                        bVar.f36721d = cursor.getLong(cursor.getColumnIndex(b.f36883e.name()));
                        bVar.f36722e = cursor.getLong(cursor.getColumnIndex(b.f36884f.name()));
                        bVar.f36723f = cursor.getString(cursor.getColumnIndex(b.f36885g.name()));
                        bVar.f36724g = cursor.getLong(cursor.getColumnIndex(b.f36886h.name()));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
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
                        eVar.f36758a = cursor.getString(cursor.getColumnIndex(f.f36911b.name()));
                        eVar.f36759b = cursor.getString(cursor.getColumnIndex(f.f36912c.name()));
                        eVar.f36760c = cursor.getLong(cursor.getColumnIndex(f.f36913d.name()));
                        eVar.f36761d = cursor.getLong(cursor.getColumnIndex(f.f36914e.name()));
                        eVar.f36762e = cursor.getLong(cursor.getColumnIndex(f.f36915f.name()));
                        eVar.f36763f = cursor.getString(cursor.getColumnIndex(f.f36916g.name()));
                        eVar.f36764g = cursor.getLong(cursor.getColumnIndex(f.f36917h.name()));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
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
                        aVar.f36705a = cursor.getString(cursor.getColumnIndex(a.f36873b.name()));
                        aVar.f36706b = cursor.getString(cursor.getColumnIndex(a.f36874c.name()));
                        aVar.f36707c = cursor.getLong(cursor.getColumnIndex(a.f36875d.name()));
                        aVar.f36708d = cursor.getString(cursor.getColumnIndex(a.f36876e.name()));
                        aVar.f36709e = cursor.getLong(cursor.getColumnIndex(a.f36877f.name()));
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
            synchronized (f36867a) {
                SQLiteDatabase b2 = b(this.f36871e);
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
