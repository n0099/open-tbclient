package c.a.d0.j.b;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import c.a.d0.h0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.alipay.Result;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.d0.c0.d a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f2788e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f2789f;

        public a(c cVar, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2789f = cVar;
            this.f2788e = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2789f.a.beginTransaction();
                try {
                    for (Map.Entry entry : this.f2788e.entrySet()) {
                        c.a.d0.j.d.a aVar = (c.a.d0.j.d.a) entry.getValue();
                        if (aVar != null) {
                            c.a.d0.z.a.a a = c.a.d0.j.b.d.a(aVar);
                            if (!TextUtils.isEmpty(a.c())) {
                                this.f2789f.a.a(a, new c.a.d0.c0.b[0]);
                            }
                        }
                    }
                    this.f2789f.a.setTransactionSuccessful();
                } finally {
                    this.f2789f.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.z.a.a f2790e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f2791f;

        public b(c cVar, c.a.d0.z.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2791f = cVar;
            this.f2790e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2791f.a.a(this.f2790e, new c.a.d0.c0.b[0]);
            }
        }
    }

    /* renamed from: c.a.d0.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0084c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.z.a.a f2792e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f2793f;

        public RunnableC0084c(c cVar, c.a.d0.z.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2793f = cVar;
            this.f2792e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2793f.a.update(this.f2792e, new c.a.d0.c0.b[0]);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f2794b;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class a implements f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;

            public a(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = th;
                if (this.a != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("v", "4.5.0.13");
                    hashMap.put("e", this.a.toString());
                    c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CHECK).i("12").j(Result.RESULT_FAILED).k(new JSONObject(hashMap).toString()));
                }
            }

            @Override // c.a.d0.j.b.f
            public void a(HashMap<String, c.a.d0.j.d.a> hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
                }
            }

            @Override // c.a.d0.j.b.f
            public void b(c.a.d0.z.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                }
            }

            public void update(c.a.d0.z.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1957790137, "Lc/a/d0/j/b/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1957790137, "Lc/a/d0/j/b/c$d;");
                    return;
                }
            }
            try {
                if (l.b()) {
                    a = new c(null);
                } else {
                    a = b(null);
                }
            } catch (Throwable th) {
                a = b(th);
            }
            f2794b = a;
        }

        public static f b(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) ? new a(th) : (f) invokeL.objValue;
        }
    }

    public /* synthetic */ c(c.a.d0.j.b.b bVar) {
        this();
    }

    public static f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.f2794b : (f) invokeV.objValue;
    }

    @Override // c.a.d0.j.b.f
    public void a(HashMap<String, c.a.d0.j.d.a> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || c.a.d0.x.c.c(hashMap)) {
            return;
        }
        c.a.d0.d0.b.c(new a(this, hashMap), "update_apk_data", 3);
    }

    @Override // c.a.d0.j.b.f
    public void b(c.a.d0.z.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        c.a.d0.d0.b.c(new b(this, aVar), "update_apk_data", 3);
    }

    public void update(c.a.d0.z.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        c.a.d0.d0.b.c(new RunnableC0084c(this, aVar), "update_apk_data", 3);
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e eVar = new e();
        eVar.getReadableDatabase();
        eVar.close();
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(c.a.d0.h.a.b().getDatabasePath("nad.core.download.db").getPath(), null, 0);
        openDatabase.setLocale(Locale.US);
        this.a = new g(openDatabase);
    }
}
