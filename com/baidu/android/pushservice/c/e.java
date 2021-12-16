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
    public static String f32718b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C1700e f32719c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f32720d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f32721e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f32722b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f32723c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f32724d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f32725e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f32726f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f32727g;
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
            f32722b = new a("type", 1);
            f32723c = new a("value", 2);
            f32724d = new a("timestamp", 3);
            f32725e = new a("ext", 4);
            a aVar = new a("aliasId", 5);
            f32726f = aVar;
            f32727g = new a[]{a, f32722b, f32723c, f32724d, f32725e, aVar};
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
        public static final b f32728b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f32729c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f32730d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f32731e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f32732f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f32733g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f32734h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ b[] f32735i;
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
            f32728b = new b("startTime", 1);
            f32729c = new b("stopTime", 2);
            f32730d = new b("reason", 3);
            f32731e = new b("retryTime", 4);
            f32732f = new b("retryCount", 5);
            f32733g = new b("ext", 6);
            b bVar = new b("aliasId", 7);
            f32734h = bVar;
            f32735i = new b[]{a, f32728b, f32729c, f32730d, f32731e, f32732f, f32733g, bVar};
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
        public static final c f32736b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f32737c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f32738d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f32739e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ c[] f32740f;
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
            f32736b = new c("exception", 1);
            f32737c = new c("timestamp", 2);
            f32738d = new c("ext", 3);
            c cVar = new c("aliasId", 4);
            f32739e = cVar;
            f32740f = new c[]{a, f32736b, f32737c, f32738d, cVar};
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
        public static final d f32741b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f32742c;

        /* renamed from: d  reason: collision with root package name */
        public static final d f32743d;

        /* renamed from: e  reason: collision with root package name */
        public static final d f32744e;

        /* renamed from: f  reason: collision with root package name */
        public static final d f32745f;

        /* renamed from: g  reason: collision with root package name */
        public static final d f32746g;

        /* renamed from: h  reason: collision with root package name */
        public static final d f32747h;

        /* renamed from: i  reason: collision with root package name */
        public static final d f32748i;

        /* renamed from: j  reason: collision with root package name */
        public static final d f32749j;

        /* renamed from: k  reason: collision with root package name */
        public static final /* synthetic */ d[] f32750k;
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
            f32741b = new d("tableName", 1);
            f32742c = new d(PushClientConstants.TAG_CLASS_NAME, 2);
            f32743d = new d("method", 3);
            f32744e = new d("action", 4);
            f32745f = new d("startTime", 5);
            f32746g = new d("endTime", 6);
            f32747h = new d("duration", 7);
            f32748i = new d("ext", 8);
            d dVar = new d("aliasId", 9);
            f32749j = dVar;
            f32750k = new d[]{a, f32741b, f32742c, f32743d, f32744e, f32745f, f32746g, f32747h, f32748i, dVar};
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
    public static class C1700e extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String a;

        /* renamed from: b  reason: collision with root package name */
        public static final String f32751b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f32752c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f32753d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f32754e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public Context f32755f;

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
            a = "CREATE TABLE crash (" + c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f32736b.name() + " TEXT, " + c.f32737c.name() + " LONG, " + c.f32738d.name() + " TEXT, " + c.f32739e.name() + " LONG NOT NULL );";
            f32751b = "CREATE TABLE db (" + d.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.f32741b.name() + " TEXT, " + d.f32742c.name() + " TEXT, " + d.f32743d.name() + " TEXT, " + d.f32744e.name() + " TEXT, " + d.f32745f.name() + " LONG, " + d.f32746g.name() + " LONG, " + d.f32747h.name() + " LONG, " + d.f32748i.name() + " TEXT, " + d.f32749j.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.a.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.f32728b.name());
            sb.append(" LONG, ");
            sb.append(b.f32729c.name());
            sb.append(" LONG, ");
            sb.append(b.f32730d.name());
            sb.append(" TEXT, ");
            sb.append(b.f32731e.name());
            sb.append(" LONG, ");
            sb.append(b.f32732f.name());
            sb.append(" LONG, ");
            sb.append(b.f32733g.name());
            sb.append(" TEXT, ");
            sb.append(b.f32734h.name());
            sb.append(" LONG NOT NULL );");
            f32752c = sb.toString();
            f32753d = "CREATE TABLE request (" + f.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.f32756b.name() + " TEXT, " + f.f32757c.name() + " TEXT, " + f.f32758d.name() + " LONG, " + f.f32759e.name() + " LONG, " + f.f32760f.name() + " LONG, " + f.f32761g.name() + " TEXT, " + f.f32762h.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.a.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.f32722b.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32723c.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32724d.name());
            sb2.append(" LONG, ");
            sb2.append(a.f32725e.name());
            sb2.append(" TEXT, ");
            sb2.append(a.f32726f.name());
            sb2.append(" LONG NOT NULL);");
            f32754e = sb2.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1700e(Context context, String str, int i2) {
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
            this.f32755f = context;
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
                    sQLiteDatabase.execSQL(f32751b);
                    sQLiteDatabase.execSQL(f32752c);
                    sQLiteDatabase.execSQL(f32753d);
                    sQLiteDatabase.execSQL(f32754e);
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
        public static final f f32756b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f32757c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f32758d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f32759e;

        /* renamed from: f  reason: collision with root package name */
        public static final f f32760f;

        /* renamed from: g  reason: collision with root package name */
        public static final f f32761g;

        /* renamed from: h  reason: collision with root package name */
        public static final f f32762h;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ f[] f32763i;
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
            f32756b = new f("method", 1);
            f32757c = new f("requestId", 2);
            f32758d = new f("timestamp", 3);
            f32759e = new f("responseTime", 4);
            f32760f = new f("errorCode", 5);
            f32761g = new f("ext", 6);
            f fVar = new f("aliasId", 7);
            f32762h = fVar;
            f32763i = new f[]{a, f32756b, f32757c, f32758d, f32759e, f32760f, f32761g, fVar};
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
        this.f32721e = context;
        f32719c = new C1700e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f32720d == null) {
                synchronized (a) {
                    if (f32720d == null) {
                        f32720d = new e(context.getApplicationContext());
                    }
                }
            }
            return f32720d;
        }
        return (e) invokeL.objValue;
    }

    public static SQLiteDatabase b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f32719c == null) {
                f32719c = new C1700e(context, "push_track.db", 1);
            }
            try {
                return f32719c.getWritableDatabase();
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
                SQLiteDatabase b2 = b(this.f32721e);
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
                            cVar.a = rawQuery.getString(rawQuery.getColumnIndex(c.f32736b.name()));
                            cVar.f32600b = rawQuery.getLong(rawQuery.getColumnIndex(c.f32737c.name()));
                            cVar.f32601c = rawQuery.getString(rawQuery.getColumnIndex(c.f32738d.name()));
                            cVar.f32602d = rawQuery.getLong(rawQuery.getColumnIndex(c.f32739e.name()));
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
                SQLiteDatabase b2 = b(this.f32721e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(a.f32722b.name(), aVar.a);
                    contentValues.put(a.f32723c.name(), aVar.f32574b);
                    contentValues.put(a.f32724d.name(), Long.valueOf(aVar.f32575c));
                    contentValues.put(a.f32725e.name(), aVar.f32576d);
                    contentValues.put(a.f32726f.name(), Long.valueOf(aVar.f32577e));
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
                SQLiteDatabase b2 = b(this.f32721e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f32728b.name(), Long.valueOf(bVar.a));
                    contentValues.put(b.f32729c.name(), Long.valueOf(bVar.f32585b));
                    contentValues.put(b.f32730d.name(), bVar.f32586c);
                    contentValues.put(b.f32731e.name(), Long.valueOf(bVar.f32587d));
                    contentValues.put(b.f32732f.name(), Long.valueOf(bVar.f32588e));
                    contentValues.put(b.f32733g.name(), bVar.f32589f);
                    contentValues.put(b.f32734h.name(), Long.valueOf(bVar.f32590g));
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
                SQLiteDatabase b2 = b(this.f32721e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.f32736b.name(), cVar.a);
                    contentValues.put(c.f32737c.name(), Long.valueOf(cVar.f32600b));
                    contentValues.put(c.f32738d.name(), cVar.f32601c);
                    contentValues.put(c.f32739e.name(), Long.valueOf(cVar.f32602d));
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
                SQLiteDatabase b2 = b(this.f32721e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.f32741b.name(), dVar.a);
                    contentValues.put(d.f32742c.name(), dVar.f32613b);
                    contentValues.put(d.f32743d.name(), dVar.f32614c);
                    contentValues.put(d.f32744e.name(), dVar.f32615d);
                    contentValues.put(d.f32745f.name(), Long.valueOf(dVar.f32616e));
                    contentValues.put(d.f32746g.name(), Long.valueOf(dVar.f32617f));
                    contentValues.put(d.f32747h.name(), Long.valueOf(dVar.f32618g));
                    contentValues.put(d.f32748i.name(), dVar.f32619h);
                    contentValues.put(d.f32749j.name(), Long.valueOf(dVar.f32620i));
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
                SQLiteDatabase b2 = b(this.f32721e);
                if (b2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.f32756b.name(), eVar.a);
                    contentValues.put(f.f32757c.name(), eVar.f32621b);
                    contentValues.put(f.f32758d.name(), Long.valueOf(eVar.f32622c));
                    contentValues.put(f.f32759e.name(), Long.valueOf(eVar.f32623d));
                    contentValues.put(f.f32760f.name(), Long.valueOf(eVar.f32624e));
                    contentValues.put(f.f32761g.name(), eVar.f32625f);
                    contentValues.put(f.f32762h.name(), Long.valueOf(eVar.f32626g));
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
                SQLiteDatabase b2 = b(this.f32721e);
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
                        dVar.a = cursor.getString(cursor.getColumnIndex(d.f32741b.name()));
                        dVar.f32613b = cursor.getString(cursor.getColumnIndex(d.f32742c.name()));
                        dVar.f32614c = cursor.getString(cursor.getColumnIndex(d.f32743d.name()));
                        dVar.f32615d = cursor.getString(cursor.getColumnIndex(d.f32744e.name()));
                        dVar.f32616e = cursor.getLong(cursor.getColumnIndex(d.f32745f.name()));
                        dVar.f32617f = cursor.getLong(cursor.getColumnIndex(d.f32746g.name()));
                        dVar.f32618g = cursor.getLong(cursor.getColumnIndex(d.f32747h.name()));
                        dVar.f32619h = cursor.getString(cursor.getColumnIndex(d.f32748i.name()));
                        dVar.f32620i = cursor.getLong(cursor.getColumnIndex(d.f32749j.name()));
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
                SQLiteDatabase b2 = b(this.f32721e);
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
                        bVar.a = cursor.getLong(cursor.getColumnIndex(b.f32728b.name()));
                        bVar.f32585b = cursor.getLong(cursor.getColumnIndex(b.f32729c.name()));
                        bVar.f32586c = cursor.getString(cursor.getColumnIndex(b.f32730d.name()));
                        bVar.f32587d = cursor.getLong(cursor.getColumnIndex(b.f32731e.name()));
                        bVar.f32588e = cursor.getLong(cursor.getColumnIndex(b.f32732f.name()));
                        bVar.f32589f = cursor.getString(cursor.getColumnIndex(b.f32733g.name()));
                        bVar.f32590g = cursor.getLong(cursor.getColumnIndex(b.f32734h.name()));
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
                SQLiteDatabase b2 = b(this.f32721e);
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
                        eVar.a = cursor.getString(cursor.getColumnIndex(f.f32756b.name()));
                        eVar.f32621b = cursor.getString(cursor.getColumnIndex(f.f32757c.name()));
                        eVar.f32622c = cursor.getLong(cursor.getColumnIndex(f.f32758d.name()));
                        eVar.f32623d = cursor.getLong(cursor.getColumnIndex(f.f32759e.name()));
                        eVar.f32624e = cursor.getLong(cursor.getColumnIndex(f.f32760f.name()));
                        eVar.f32625f = cursor.getString(cursor.getColumnIndex(f.f32761g.name()));
                        eVar.f32626g = cursor.getLong(cursor.getColumnIndex(f.f32762h.name()));
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
                SQLiteDatabase b2 = b(this.f32721e);
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
                        aVar.a = cursor.getString(cursor.getColumnIndex(a.f32722b.name()));
                        aVar.f32574b = cursor.getString(cursor.getColumnIndex(a.f32723c.name()));
                        aVar.f32575c = cursor.getLong(cursor.getColumnIndex(a.f32724d.name()));
                        aVar.f32576d = cursor.getString(cursor.getColumnIndex(a.f32725e.name()));
                        aVar.f32577e = cursor.getLong(cursor.getColumnIndex(a.f32726f.name()));
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
                SQLiteDatabase b2 = b(this.f32721e);
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
