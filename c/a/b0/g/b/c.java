package c.a.b0.g.b;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import c.a.b0.d0.k;
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
    public final c.a.b0.z.d a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f1486e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1487f;

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
            this.f1487f = cVar;
            this.f1486e = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1487f.a.beginTransaction();
                try {
                    for (Map.Entry entry : this.f1486e.entrySet()) {
                        c.a.b0.g.d.a aVar = (c.a.b0.g.d.a) entry.getValue();
                        if (aVar != null) {
                            c.a.b0.w.a.a a = c.a.b0.g.b.d.a(aVar);
                            if (!TextUtils.isEmpty(a.c())) {
                                this.f1487f.a.a(a, new c.a.b0.z.b[0]);
                            }
                        }
                    }
                    this.f1487f.a.setTransactionSuccessful();
                } finally {
                    this.f1487f.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.w.a.a f1488e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1489f;

        public b(c cVar, c.a.b0.w.a.a aVar) {
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
            this.f1489f = cVar;
            this.f1488e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1489f.a.a(this.f1488e, new c.a.b0.z.b[0]);
            }
        }
    }

    /* renamed from: c.a.b0.g.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0031c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.w.a.a f1490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1491f;

        public RunnableC0031c(c cVar, c.a.b0.w.a.a aVar) {
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
            this.f1491f = cVar;
            this.f1490e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1491f.a.update(this.f1490e, new c.a.b0.z.b[0]);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f1492b;
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
                    hashMap.put("v", "4.2.1.3");
                    hashMap.put("e", this.a.toString());
                    c.a.b0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.CHECK).h("12").i(Result.RESULT_FAILED).j(new JSONObject(hashMap).toString()));
                }
            }

            @Override // c.a.b0.g.b.f
            public void a(HashMap<String, c.a.b0.g.d.a> hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
                }
            }

            @Override // c.a.b0.g.b.f
            public void b(c.a.b0.w.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                }
            }

            public void update(c.a.b0.w.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(702648872, "Lc/a/b0/g/b/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(702648872, "Lc/a/b0/g/b/c$d;");
                    return;
                }
            }
            try {
                if (k.b()) {
                    a = new c(null);
                } else {
                    a = b(null);
                }
            } catch (Throwable th) {
                a = b(th);
            }
            f1492b = a;
        }

        public static f b(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) ? new a(th) : (f) invokeL.objValue;
        }
    }

    public /* synthetic */ c(c.a.b0.g.b.b bVar) {
        this();
    }

    public static f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.f1492b : (f) invokeV.objValue;
    }

    @Override // c.a.b0.g.b.f
    public void a(HashMap<String, c.a.b0.g.d.a> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || c.a.b0.u.c.c(hashMap)) {
            return;
        }
        c.a.b0.a0.b.c(new a(this, hashMap), "update_apk_data", 3);
    }

    @Override // c.a.b0.g.b.f
    public void b(c.a.b0.w.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        c.a.b0.a0.b.c(new b(this, aVar), "update_apk_data", 3);
    }

    public void update(c.a.b0.w.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        c.a.b0.a0.b.c(new RunnableC0031c(this, aVar), "update_apk_data", 3);
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
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(c.a.b0.e.a.b().getDatabasePath("nad.core.download.db").getPath(), null, 0);
        openDatabase.setLocale(Locale.US);
        this.a = new g(openDatabase);
    }
}
