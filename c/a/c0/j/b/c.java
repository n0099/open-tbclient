package c.a.c0.j.b;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import c.a.c0.g0.k;
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
    public final c.a.c0.c0.d a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f1941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1942f;

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
            this.f1942f = cVar;
            this.f1941e = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1942f.a.beginTransaction();
                try {
                    for (Map.Entry entry : this.f1941e.entrySet()) {
                        c.a.c0.j.d.a aVar = (c.a.c0.j.d.a) entry.getValue();
                        if (aVar != null) {
                            c.a.c0.z.a.a a = c.a.c0.j.b.d.a(aVar);
                            if (!TextUtils.isEmpty(a.c())) {
                                this.f1942f.a.a(a, new c.a.c0.c0.b[0]);
                            }
                        }
                    }
                    this.f1942f.a.setTransactionSuccessful();
                } finally {
                    this.f1942f.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.z.a.a f1943e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1944f;

        public b(c cVar, c.a.c0.z.a.a aVar) {
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
            this.f1944f = cVar;
            this.f1943e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1944f.a.a(this.f1943e, new c.a.c0.c0.b[0]);
            }
        }
    }

    /* renamed from: c.a.c0.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0058c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.z.a.a f1945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1946f;

        public RunnableC0058c(c cVar, c.a.c0.z.a.a aVar) {
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
            this.f1946f = cVar;
            this.f1945e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1946f.a.update(this.f1945e, new c.a.c0.c0.b[0]);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static f a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f1947b;
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
                    hashMap.put("v", "4.4.3.3");
                    hashMap.put("e", this.a.toString());
                    c.a.c0.a0.a.b(new ClogBuilder().r(ClogBuilder.LogType.CHECK).h("12").i(Result.RESULT_FAILED).j(new JSONObject(hashMap).toString()));
                }
            }

            @Override // c.a.c0.j.b.f
            public void a(HashMap<String, c.a.c0.j.d.a> hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
                }
            }

            @Override // c.a.c0.j.b.f
            public void b(c.a.c0.z.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                }
            }

            public void update(c.a.c0.z.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-160838778, "Lc/a/c0/j/b/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-160838778, "Lc/a/c0/j/b/c$d;");
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
            f1947b = a;
        }

        public static f b(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) ? new a(th) : (f) invokeL.objValue;
        }
    }

    public /* synthetic */ c(c.a.c0.j.b.b bVar) {
        this();
    }

    public static f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.f1947b : (f) invokeV.objValue;
    }

    @Override // c.a.c0.j.b.f
    public void a(HashMap<String, c.a.c0.j.d.a> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || c.a.c0.x.c.c(hashMap)) {
            return;
        }
        c.a.c0.d0.b.c(new a(this, hashMap), "update_apk_data", 3);
    }

    @Override // c.a.c0.j.b.f
    public void b(c.a.c0.z.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        c.a.c0.d0.b.c(new b(this, aVar), "update_apk_data", 3);
    }

    public void update(c.a.c0.z.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        c.a.c0.d0.b.c(new RunnableC0058c(this, aVar), "update_apk_data", 3);
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
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(c.a.c0.h.a.b().getDatabasePath("nad.core.download.db").getPath(), null, 0);
        openDatabase.setLocale(Locale.US);
        this.a = new g(openDatabase);
    }
}
