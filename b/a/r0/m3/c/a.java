package b.a.r0.m3.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.m3.b.a f21236a;

    /* renamed from: b  reason: collision with root package name */
    public c f21237b;

    /* renamed from: c  reason: collision with root package name */
    public c f21238c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.e.e.l.c<b.a.e.l.d.a> f21239d;

    /* renamed from: b.a.r0.m3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1043a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21240a;

        public C1043a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21240a = aVar;
        }

        @Override // b.a.r0.m3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21240a.f21236a = null;
                if (this.f21240a.f21237b != null) {
                    this.f21240a.f21237b.a();
                }
            }
        }

        @Override // b.a.r0.m3.c.a.c
        public void b(b.a.r0.m3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f21240a.f21236a = aVar;
                if (this.f21240a.f21237b != null) {
                    this.f21240a.f21237b.b(aVar);
                }
            }
        }

        @Override // b.a.r0.m3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.f21240a.f21237b == null) {
                return;
            }
            this.f21240a.f21237b.c(obj);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21241a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21241a = aVar;
        }

        @Override // b.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.f21241a.f21237b != null) {
                    this.f21241a.f21237b.a();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || aVar.p() == null) {
                    if (this.f21241a.f21237b != null) {
                        this.f21241a.f21237b.a();
                    }
                } else if (this.f21241a.f21237b != null) {
                    this.f21241a.f21237b.c(aVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void b(b.a.r0.m3.b.a aVar);

        void c(Object obj);
    }

    /* loaded from: classes5.dex */
    public static class d extends BdAsyncTask<String, Void, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f21242a;

        /* renamed from: b  reason: collision with root package name */
        public c f21243b;

        public d(c cVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21243b = cVar;
            this.f21242a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Object doInBackground(String... strArr) {
            InterceptResult invokeL;
            b.a.r0.m3.b.a aVar;
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
                String postNetData = netWork.postNetData();
                if (!netWork.getNetContext().getResponse().isRequestSuccess() || c(postNetData)) {
                    aVar = null;
                } else {
                    aVar = new b.a.r0.m3.b.a();
                    aVar.b(postNetData);
                }
                if (!this.f21242a && (cVar = this.f21243b) != null) {
                    if (aVar != null) {
                        cVar.b(aVar);
                    } else {
                        cVar.a();
                    }
                }
                return aVar;
            }
            return invokeL.objValue;
        }

        public final boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str != null) {
                    try {
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(str);
                        return errorData.error_code != 0;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    if (this.f21242a && this.f21243b != null) {
                        if (obj instanceof b.a.r0.m3.b.a) {
                            this.f21243b.b((b.a.r0.m3.b.a) obj);
                        } else {
                            this.f21243b.a();
                        }
                    }
                } finally {
                    TTIStats.record("TbAdModel$TbAdTask.onPostExecute", System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
    }

    public a() {
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
        this.f21238c = new C1043a(this);
        this.f21239d = new b(this);
    }

    public b.a.r0.m3.b.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.r0.m3.b.a aVar = this.f21236a;
            if (aVar != null && !ListUtils.isEmpty(aVar.f21228a)) {
                for (b.a.r0.m3.b.b bVar : this.f21236a.f21228a) {
                    if (bVar != null && bVar.b() && bVar.f21231b == 3) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (b.a.r0.m3.b.b) invokeV.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            d dVar = new d(this.f21238c, z);
            dVar.setSelfExecute(true);
            dVar.execute(new String[0]);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.r0.m3.b.b c2 = c();
            if (c2 != null && !TextUtils.isEmpty(c2.f21234e)) {
                f(c2.f21233d, c2.f21234e, true);
                return;
            }
            c cVar = this.f21237b;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public final void f(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (i2 == 1 || i2 == 2) {
                if (z) {
                    b.a.e.e.l.d.h().m(str, 10, this.f21239d, null);
                } else {
                    b.a.e.e.l.d.h().m(str, 10, null, null);
                }
            }
        }
    }

    public void g() {
        b.a.r0.m3.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f21236a) == null || ListUtils.isEmpty(aVar.f21228a)) {
            return;
        }
        b.a.r0.m3.b.b c2 = c();
        for (b.a.r0.m3.b.b bVar : this.f21236a.f21228a) {
            if (bVar != null && bVar != c2 && bVar.b() && bVar.f21231b != 4) {
                f(bVar.f21233d, bVar.f21234e, false);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21237b = null;
        }
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f21237b = cVar;
        }
    }
}
