package c.a.q0.j3.c;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.j3.b.a f21195a;

    /* renamed from: b  reason: collision with root package name */
    public c f21196b;

    /* renamed from: c  reason: collision with root package name */
    public c f21197c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.e.l.c<c.a.e.l.d.a> f21198d;

    /* renamed from: c.a.q0.j3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0989a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21199a;

        public C0989a(a aVar) {
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
            this.f21199a = aVar;
        }

        @Override // c.a.q0.j3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21199a.f21195a = null;
                if (this.f21199a.f21196b != null) {
                    this.f21199a.f21196b.a();
                }
            }
        }

        @Override // c.a.q0.j3.c.a.c
        public void b(c.a.q0.j3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f21199a.f21195a = aVar;
                if (this.f21199a.f21196b != null) {
                    this.f21199a.f21196b.b(aVar);
                }
            }
        }

        @Override // c.a.q0.j3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.f21199a.f21196b == null) {
                return;
            }
            this.f21199a.f21196b.c(obj);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21200a;

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
            this.f21200a = aVar;
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.f21200a.f21196b != null) {
                    this.f21200a.f21196b.a();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || aVar.p() == null) {
                    if (this.f21200a.f21196b != null) {
                        this.f21200a.f21196b.a();
                    }
                } else if (this.f21200a.f21196b != null) {
                    this.f21200a.f21196b.c(aVar);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b(c.a.q0.j3.b.a aVar);

        void c(Object obj);
    }

    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<String, Void, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f21201a;

        public d(a aVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21201a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Object doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
                String postNetData = netWork.postNetData();
                if (!netWork.getNetContext().getResponse().isRequestSuccess() || c(postNetData)) {
                    return null;
                }
                c.a.q0.j3.b.a aVar = new c.a.q0.j3.b.a();
                aVar.b(postNetData);
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
                    if (this.f21201a != null) {
                        if (obj instanceof c.a.q0.j3.b.a) {
                            this.f21201a.b((c.a.q0.j3.b.a) obj);
                        } else {
                            this.f21201a.a();
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
        this.f21197c = new C0989a(this);
        this.f21198d = new b(this);
    }

    public c.a.q0.j3.b.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.q0.j3.b.a aVar = this.f21195a;
            if (aVar != null && !ListUtils.isEmpty(aVar.f21187a)) {
                for (c.a.q0.j3.b.b bVar : this.f21195a.f21187a) {
                    if (bVar != null && bVar.b() && bVar.f21190b == 3) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (c.a.q0.j3.b.b) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d dVar = new d(this, this.f21197c);
            dVar.setSelfExecute(true);
            dVar.execute(new String[0]);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.j3.b.b c2 = c();
            if (c2 != null && !TextUtils.isEmpty(c2.f21193e)) {
                f(c2.f21192d, c2.f21193e, true);
                return;
            }
            c cVar = this.f21196b;
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
                    c.a.e.e.l.d.h().m(str, 10, this.f21198d, null);
                } else {
                    c.a.e.e.l.d.h().m(str, 10, null, null);
                }
            }
        }
    }

    public void g() {
        c.a.q0.j3.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f21195a) == null || ListUtils.isEmpty(aVar.f21187a)) {
            return;
        }
        c.a.q0.j3.b.b c2 = c();
        for (c.a.q0.j3.b.b bVar : this.f21195a.f21187a) {
            if (bVar != null && bVar != c2 && bVar.b() && bVar.f21190b != 4) {
                f(bVar.f21192d, bVar.f21193e, false);
            }
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f21196b = cVar;
        }
    }
}
