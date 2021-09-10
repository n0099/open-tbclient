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
    public static final Object f37092a;

    /* renamed from: b  reason: collision with root package name */
    public static String f37093b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1584e f37094c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f37095d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f37096e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f37097a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f37098b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f37099c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f37100d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f37101e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f37102f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f37103g;
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
            f37097a = new a("ackId", 0);
            f37098b = new a("type", 1);
            f37099c = new a("value", 2);
            f37100d = new a("timestamp", 3);
            f37101e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f37102f = aVar;
            f37103g = new a[]{f37097a, f37098b, f37099c, f37100d, f37101e, aVar};
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
        public static final b f37104a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f37105b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f37106c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f37107d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f37108e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f37109f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f37110g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f37111h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f37112i;
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
            f37104a = new b("connectionId", 0);
            f37105b = new b("startTime", 1);
            f37106c = new b("stopTime", 2);
            f37107d = new b("reason", 3);
            f37108e = new b("retryTime", 4);
            f37109f = new b("retryCount", 5);
            f37110g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f37111h = bVar;
            f37112i = new b[]{f37104a, f37105b, f37106c, f37107d, f37108e, f37109f, f37110g, bVar};
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
        public static final c f37113a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f37114b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f37115c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f37116d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f37117e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f37118f;
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
            f37113a = new c("crashId", 0);
            f37114b = new c("exception", 1);
            f37115c = new c("timestamp", 2);
            f37116d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f37117e = cVar;
            f37118f = new c[]{f37113a, f37114b, f37115c, f37116d, cVar};
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
        public static final d f37119a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f37120b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f37121c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f37122d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f37123e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f37124f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f37125g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f37126h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f37127i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f37128j;
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
            f37119a = new d("dbId", 0);
            f37120b = new d("tableName", 1);
            f37121c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f37122d = new d("method", 3);
            f37123e = new d("action", 4);
            f37124f = new d("startTime", 5);
            f37125g = new d("endTime", 6);
            f37126h = new d("duration", 7);
            f37127i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f37128j = dVar;
            k = new d[]{f37119a, f37120b, f37121c, f37122d, f37123e, f37124f, f37125g, f37126h, f37127i, dVar};
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
        public static final String f37129a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f37130b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f37131c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f37132d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f37133e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f37134f;

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
            f37129a = "CREATE TABLE crash (" + c.f37113a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f37114b.name() + " TEXT, " + c.f37115c.name() + " LONG, " + c.f37116d.name() + " TEXT, " + c.f37117e.name() + " LONG NOT NULL );";
            f37130b = "CREATE TABLE db (" + d.f37119a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f37120b.name() + " TEXT, " + d.f37121c.name() + " TEXT, " + d.f37122d.name() + " TEXT, " + d.f37123e.name() + " TEXT, " + d.f37124f.name() + " LONG, " + d.f37125g.name() + " LONG, " + d.f37126h.name() + " LONG, " + d.f37127i.name() + " TEXT, " + d.f37128j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.f37104a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f37105b.name());
            sb.append(" LONG, ");
            sb.append(b.f37106c.name());
            sb.append(" LONG, ");
            sb.append(b.f37107d.name());
            sb.append(" TEXT, ");
            sb.append(b.f37108e.name());
            sb.append(" LONG, ");
            sb.append(b.f37109f.name());
            sb.append(" LONG, ");
            sb.append(b.f37110g.name());
            sb.append(" TEXT, ");
            sb.append(b.f37111h.name());
            sb.append(" LONG NOT NULL );");
            f37131c = sb.toString();
            f37132d = "CREATE TABLE request (" + f.f37135a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f37136b.name() + " TEXT, " + f.f37137c.name() + " TEXT, " + f.f37138d.name() + " LONG, " + f.f37139e.name() + " LONG, " + f.f37140f.name() + " LONG, " + f.f37141g.name() + " TEXT, " + f.f37142h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.f37097a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f37098b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f37099c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f37100d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f37101e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f37102f.name());
            sb2.append(" LONG NOT NULL);");
            f37133e = sb2.toString();
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
            this.f37134f = context;
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
                    sQLiteDatabase.execSQL(f37129a);
                    sQLiteDatabase.execSQL(f37130b);
                    sQLiteDatabase.execSQL(f37131c);
                    sQLiteDatabase.execSQL(f37132d);
                    sQLiteDatabase.execSQL(f37133e);
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
        public static final f f37135a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f37136b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f37137c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f37138d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f37139e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f37140f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f37141g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f37142h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f37143i;
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
            f37135a = new f("id", 0);
            f37136b = new f("method", 1);
            f37137c = new f("requestId", 2);
            f37138d = new f("timestamp", 3);
            f37139e = new f("responseTime", 4);
            f37140f = new f("errorCode", 5);
            f37141g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f37142h = fVar;
            f37143i = new f[]{f37135a, f37136b, f37137c, f37138d, f37139e, f37140f, f37141g, fVar};
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
        f37092a = new Object();
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
        this.f37096e = context;
        f37094c = new C1584e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f37095d == null) {
                synchronized (f37092a) {
                    if (f37095d == null) {
                        f37095d = new e(context.getApplicationContext());
                    }
                }
            }
            return f37095d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f37094c == null) {
                f37094c = new C1584e(context, "push_track.db", 1);
            }
            try {
                return f37094c.getWritableDatabase();
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
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
                            cVar.f36960a = rawQuery.getString(rawQuery.getColumnIndex(c.f37114b.name()));
                            cVar.f36961b = rawQuery.getLong(rawQuery.getColumnIndex(c.f37115c.name()));
                            cVar.f36962c = rawQuery.getString(rawQuery.getColumnIndex(c.f37116d.name()));
                            cVar.f36963d = rawQuery.getLong(rawQuery.getColumnIndex(c.f37117e.name()));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f37098b.name(), aVar.f36930a);
                    contentValues.put(a.f37099c.name(), aVar.f36931b);
                    contentValues.put(a.f37100d.name(), Long.valueOf(aVar.f36932c));
                    contentValues.put(a.f37101e.name(), aVar.f36933d);
                    contentValues.put(a.f37102f.name(), Long.valueOf(aVar.f36934e));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f37105b.name(), Long.valueOf(bVar.f36943a));
                    contentValues.put(b.f37106c.name(), Long.valueOf(bVar.f36944b));
                    contentValues.put(b.f37107d.name(), bVar.f36945c);
                    contentValues.put(b.f37108e.name(), Long.valueOf(bVar.f36946d));
                    contentValues.put(b.f37109f.name(), Long.valueOf(bVar.f36947e));
                    contentValues.put(b.f37110g.name(), bVar.f36948f);
                    contentValues.put(b.f37111h.name(), Long.valueOf(bVar.f36949g));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f37114b.name(), cVar.f36960a);
                    contentValues.put(c.f37115c.name(), Long.valueOf(cVar.f36961b));
                    contentValues.put(c.f37116d.name(), cVar.f36962c);
                    contentValues.put(c.f37117e.name(), Long.valueOf(cVar.f36963d));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f37120b.name(), dVar.f36974a);
                    contentValues.put(d.f37121c.name(), dVar.f36975b);
                    contentValues.put(d.f37122d.name(), dVar.f36976c);
                    contentValues.put(d.f37123e.name(), dVar.f36977d);
                    contentValues.put(d.f37124f.name(), Long.valueOf(dVar.f36978e));
                    contentValues.put(d.f37125g.name(), Long.valueOf(dVar.f36979f));
                    contentValues.put(d.f37126h.name(), Long.valueOf(dVar.f36980g));
                    contentValues.put(d.f37127i.name(), dVar.f36981h);
                    contentValues.put(d.f37128j.name(), Long.valueOf(dVar.f36982i));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f37136b.name(), eVar.f36983a);
                    contentValues.put(f.f37137c.name(), eVar.f36984b);
                    contentValues.put(f.f37138d.name(), Long.valueOf(eVar.f36985c));
                    contentValues.put(f.f37139e.name(), Long.valueOf(eVar.f36986d));
                    contentValues.put(f.f37140f.name(), Long.valueOf(eVar.f36987e));
                    contentValues.put(f.f37141g.name(), eVar.f36988f);
                    contentValues.put(f.f37142h.name(), Long.valueOf(eVar.f36989g));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
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
                        dVar.f36974a = cursor.getString(cursor.getColumnIndex(d.f37120b.name()));
                        dVar.f36975b = cursor.getString(cursor.getColumnIndex(d.f37121c.name()));
                        dVar.f36976c = cursor.getString(cursor.getColumnIndex(d.f37122d.name()));
                        dVar.f36977d = cursor.getString(cursor.getColumnIndex(d.f37123e.name()));
                        dVar.f36978e = cursor.getLong(cursor.getColumnIndex(d.f37124f.name()));
                        dVar.f36979f = cursor.getLong(cursor.getColumnIndex(d.f37125g.name()));
                        dVar.f36980g = cursor.getLong(cursor.getColumnIndex(d.f37126h.name()));
                        dVar.f36981h = cursor.getString(cursor.getColumnIndex(d.f37127i.name()));
                        dVar.f36982i = cursor.getLong(cursor.getColumnIndex(d.f37128j.name()));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
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
                        bVar.f36943a = cursor.getLong(cursor.getColumnIndex(b.f37105b.name()));
                        bVar.f36944b = cursor.getLong(cursor.getColumnIndex(b.f37106c.name()));
                        bVar.f36945c = cursor.getString(cursor.getColumnIndex(b.f37107d.name()));
                        bVar.f36946d = cursor.getLong(cursor.getColumnIndex(b.f37108e.name()));
                        bVar.f36947e = cursor.getLong(cursor.getColumnIndex(b.f37109f.name()));
                        bVar.f36948f = cursor.getString(cursor.getColumnIndex(b.f37110g.name()));
                        bVar.f36949g = cursor.getLong(cursor.getColumnIndex(b.f37111h.name()));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
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
                        eVar.f36983a = cursor.getString(cursor.getColumnIndex(f.f37136b.name()));
                        eVar.f36984b = cursor.getString(cursor.getColumnIndex(f.f37137c.name()));
                        eVar.f36985c = cursor.getLong(cursor.getColumnIndex(f.f37138d.name()));
                        eVar.f36986d = cursor.getLong(cursor.getColumnIndex(f.f37139e.name()));
                        eVar.f36987e = cursor.getLong(cursor.getColumnIndex(f.f37140f.name()));
                        eVar.f36988f = cursor.getString(cursor.getColumnIndex(f.f37141g.name()));
                        eVar.f36989g = cursor.getLong(cursor.getColumnIndex(f.f37142h.name()));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
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
                        aVar.f36930a = cursor.getString(cursor.getColumnIndex(a.f37098b.name()));
                        aVar.f36931b = cursor.getString(cursor.getColumnIndex(a.f37099c.name()));
                        aVar.f36932c = cursor.getLong(cursor.getColumnIndex(a.f37100d.name()));
                        aVar.f36933d = cursor.getString(cursor.getColumnIndex(a.f37101e.name()));
                        aVar.f36934e = cursor.getLong(cursor.getColumnIndex(a.f37102f.name()));
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
            synchronized (f37092a) {
                SQLiteDatabase b2 = b(this.f37096e);
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
