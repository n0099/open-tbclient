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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object a;

    /* renamed from: b  reason: collision with root package name */
    public static String f30456b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1710e f30457c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f30458d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f30459e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f30460b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f30461c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f30462d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f30463e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f30464f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f30465g;
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
            f30460b = new a("type", 1);
            f30461c = new a("value", 2);
            f30462d = new a("timestamp", 3);
            f30463e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f30464f = aVar;
            f30465g = new a[]{a, f30460b, f30461c, f30462d, f30463e, aVar};
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
    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f30466b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f30467c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f30468d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f30469e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f30470f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f30471g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f30472h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f30473i;
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
            f30466b = new b(FetchLog.START_TIME, 1);
            f30467c = new b("stopTime", 2);
            f30468d = new b("reason", 3);
            f30469e = new b("retryTime", 4);
            f30470f = new b("retryCount", 5);
            f30471g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f30472h = bVar;
            f30473i = new b[]{a, f30466b, f30467c, f30468d, f30469e, f30470f, f30471g, bVar};
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
    /* loaded from: classes3.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f30474b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f30475c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f30476d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f30477e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f30478f;
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
            f30474b = new c("exception", 1);
            f30475c = new c("timestamp", 2);
            f30476d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f30477e = cVar;
            f30478f = new c[]{a, f30474b, f30475c, f30476d, cVar};
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
    /* loaded from: classes3.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f30479b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f30480c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f30481d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f30482e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f30483f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f30484g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f30485h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f30486i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f30487j;
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
            f30479b = new d("tableName", 1);
            f30480c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f30481d = new d("method", 3);
            f30482e = new d("action", 4);
            f30483f = new d(FetchLog.START_TIME, 5);
            f30484g = new d(FetchLog.END_TIME, 6);
            f30485h = new d("duration", 7);
            f30486i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f30487j = dVar;
            k = new d[]{a, f30479b, f30480c, f30481d, f30482e, f30483f, f30484g, f30485h, f30486i, dVar};
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
    /* loaded from: classes3.dex */
    public static class C1710e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f30488b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f30489c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f30490d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f30491e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f30492f;

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
            a = "CREATE TABLE crash (" + c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f30474b.name() + " TEXT, " + c.f30475c.name() + " LONG, " + c.f30476d.name() + " TEXT, " + c.f30477e.name() + " LONG NOT NULL );";
            f30488b = "CREATE TABLE db (" + d.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f30479b.name() + " TEXT, " + d.f30480c.name() + " TEXT, " + d.f30481d.name() + " TEXT, " + d.f30482e.name() + " TEXT, " + d.f30483f.name() + " LONG, " + d.f30484g.name() + " LONG, " + d.f30485h.name() + " LONG, " + d.f30486i.name() + " TEXT, " + d.f30487j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f30466b.name());
            sb.append(" LONG, ");
            sb.append(b.f30467c.name());
            sb.append(" LONG, ");
            sb.append(b.f30468d.name());
            sb.append(" TEXT, ");
            sb.append(b.f30469e.name());
            sb.append(" LONG, ");
            sb.append(b.f30470f.name());
            sb.append(" LONG, ");
            sb.append(b.f30471g.name());
            sb.append(" TEXT, ");
            sb.append(b.f30472h.name());
            sb.append(" LONG NOT NULL );");
            f30489c = sb.toString();
            f30490d = "CREATE TABLE request (" + f.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f30493b.name() + " TEXT, " + f.f30494c.name() + " TEXT, " + f.f30495d.name() + " LONG, " + f.f30496e.name() + " LONG, " + f.f30497f.name() + " LONG, " + f.f30498g.name() + " TEXT, " + f.f30499h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f30460b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f30461c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f30462d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f30463e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f30464f.name());
            sb2.append(" LONG NOT NULL);");
            f30491e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1710e(Context context, String str, int i2) {
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
            this.f30492f = context;
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
                    sQLiteDatabase.execSQL(f30488b);
                    sQLiteDatabase.execSQL(f30489c);
                    sQLiteDatabase.execSQL(f30490d);
                    sQLiteDatabase.execSQL(f30491e);
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
    /* loaded from: classes3.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f30493b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f30494c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f30495d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f30496e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f30497f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f30498g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f30499h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f30500i;
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
            f30493b = new f("method", 1);
            f30494c = new f("requestId", 2);
            f30495d = new f("timestamp", 3);
            f30496e = new f("responseTime", 4);
            f30497f = new f("errorCode", 5);
            f30498g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f30499h = fVar;
            f30500i = new f[]{a, f30493b, f30494c, f30495d, f30496e, f30497f, f30498g, fVar};
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
        this.f30459e = context;
        f30457c = new C1710e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f30458d == null) {
                synchronized (a) {
                    if (f30458d == null) {
                        f30458d = new e(context.getApplicationContext());
                    }
                }
            }
            return f30458d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f30457c == null) {
                f30457c = new C1710e(context, "push_track.db", 1);
            }
            try {
                return f30457c.getWritableDatabase();
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
                SQLiteDatabase b2 = b(this.f30459e);
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
                            cVar.a = rawQuery.getString(rawQuery.getColumnIndex(c.f30474b.name()));
                            cVar.f30342b = rawQuery.getLong(rawQuery.getColumnIndex(c.f30475c.name()));
                            cVar.f30343c = rawQuery.getString(rawQuery.getColumnIndex(c.f30476d.name()));
                            cVar.f30344d = rawQuery.getLong(rawQuery.getColumnIndex(c.f30477e.name()));
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
                SQLiteDatabase b2 = b(this.f30459e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f30460b.name(), aVar.a);
                    contentValues.put(a.f30461c.name(), aVar.f30316b);
                    contentValues.put(a.f30462d.name(), Long.valueOf(aVar.f30317c));
                    contentValues.put(a.f30463e.name(), aVar.f30318d);
                    contentValues.put(a.f30464f.name(), Long.valueOf(aVar.f30319e));
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
                SQLiteDatabase b2 = b(this.f30459e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f30466b.name(), Long.valueOf(bVar.a));
                    contentValues.put(b.f30467c.name(), Long.valueOf(bVar.f30327b));
                    contentValues.put(b.f30468d.name(), bVar.f30328c);
                    contentValues.put(b.f30469e.name(), Long.valueOf(bVar.f30329d));
                    contentValues.put(b.f30470f.name(), Long.valueOf(bVar.f30330e));
                    contentValues.put(b.f30471g.name(), bVar.f30331f);
                    contentValues.put(b.f30472h.name(), Long.valueOf(bVar.f30332g));
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
                SQLiteDatabase b2 = b(this.f30459e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f30474b.name(), cVar.a);
                    contentValues.put(c.f30475c.name(), Long.valueOf(cVar.f30342b));
                    contentValues.put(c.f30476d.name(), cVar.f30343c);
                    contentValues.put(c.f30477e.name(), Long.valueOf(cVar.f30344d));
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
                SQLiteDatabase b2 = b(this.f30459e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f30479b.name(), dVar.a);
                    contentValues.put(d.f30480c.name(), dVar.f30354b);
                    contentValues.put(d.f30481d.name(), dVar.f30355c);
                    contentValues.put(d.f30482e.name(), dVar.f30356d);
                    contentValues.put(d.f30483f.name(), Long.valueOf(dVar.f30357e));
                    contentValues.put(d.f30484g.name(), Long.valueOf(dVar.f30358f));
                    contentValues.put(d.f30485h.name(), Long.valueOf(dVar.f30359g));
                    contentValues.put(d.f30486i.name(), dVar.f30360h);
                    contentValues.put(d.f30487j.name(), Long.valueOf(dVar.f30361i));
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
                SQLiteDatabase b2 = b(this.f30459e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f30493b.name(), eVar.a);
                    contentValues.put(f.f30494c.name(), eVar.f30362b);
                    contentValues.put(f.f30495d.name(), Long.valueOf(eVar.f30363c));
                    contentValues.put(f.f30496e.name(), Long.valueOf(eVar.f30364d));
                    contentValues.put(f.f30497f.name(), Long.valueOf(eVar.f30365e));
                    contentValues.put(f.f30498g.name(), eVar.f30366f);
                    contentValues.put(f.f30499h.name(), Long.valueOf(eVar.f30367g));
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
                SQLiteDatabase b2 = b(this.f30459e);
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
                        dVar.a = cursor.getString(cursor.getColumnIndex(d.f30479b.name()));
                        dVar.f30354b = cursor.getString(cursor.getColumnIndex(d.f30480c.name()));
                        dVar.f30355c = cursor.getString(cursor.getColumnIndex(d.f30481d.name()));
                        dVar.f30356d = cursor.getString(cursor.getColumnIndex(d.f30482e.name()));
                        dVar.f30357e = cursor.getLong(cursor.getColumnIndex(d.f30483f.name()));
                        dVar.f30358f = cursor.getLong(cursor.getColumnIndex(d.f30484g.name()));
                        dVar.f30359g = cursor.getLong(cursor.getColumnIndex(d.f30485h.name()));
                        dVar.f30360h = cursor.getString(cursor.getColumnIndex(d.f30486i.name()));
                        dVar.f30361i = cursor.getLong(cursor.getColumnIndex(d.f30487j.name()));
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
                SQLiteDatabase b2 = b(this.f30459e);
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
                        bVar.a = cursor.getLong(cursor.getColumnIndex(b.f30466b.name()));
                        bVar.f30327b = cursor.getLong(cursor.getColumnIndex(b.f30467c.name()));
                        bVar.f30328c = cursor.getString(cursor.getColumnIndex(b.f30468d.name()));
                        bVar.f30329d = cursor.getLong(cursor.getColumnIndex(b.f30469e.name()));
                        bVar.f30330e = cursor.getLong(cursor.getColumnIndex(b.f30470f.name()));
                        bVar.f30331f = cursor.getString(cursor.getColumnIndex(b.f30471g.name()));
                        bVar.f30332g = cursor.getLong(cursor.getColumnIndex(b.f30472h.name()));
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
                SQLiteDatabase b2 = b(this.f30459e);
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
                        eVar.a = cursor.getString(cursor.getColumnIndex(f.f30493b.name()));
                        eVar.f30362b = cursor.getString(cursor.getColumnIndex(f.f30494c.name()));
                        eVar.f30363c = cursor.getLong(cursor.getColumnIndex(f.f30495d.name()));
                        eVar.f30364d = cursor.getLong(cursor.getColumnIndex(f.f30496e.name()));
                        eVar.f30365e = cursor.getLong(cursor.getColumnIndex(f.f30497f.name()));
                        eVar.f30366f = cursor.getString(cursor.getColumnIndex(f.f30498g.name()));
                        eVar.f30367g = cursor.getLong(cursor.getColumnIndex(f.f30499h.name()));
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
                SQLiteDatabase b2 = b(this.f30459e);
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
                        aVar.a = cursor.getString(cursor.getColumnIndex(a.f30460b.name()));
                        aVar.f30316b = cursor.getString(cursor.getColumnIndex(a.f30461c.name()));
                        aVar.f30317c = cursor.getLong(cursor.getColumnIndex(a.f30462d.name()));
                        aVar.f30318d = cursor.getString(cursor.getColumnIndex(a.f30463e.name()));
                        aVar.f30319e = cursor.getLong(cursor.getColumnIndex(a.f30464f.name()));
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
                SQLiteDatabase b2 = b(this.f30459e);
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
