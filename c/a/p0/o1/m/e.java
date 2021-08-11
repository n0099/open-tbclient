package c.a.p0.o1.m;

import android.text.TextUtils;
import c.a.o0.c.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes3.dex */
public class e extends c.a.o0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f22606a;

        /* renamed from: b  reason: collision with root package name */
        public String f22607b;

        /* renamed from: c  reason: collision with root package name */
        public String f22608c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f22609d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.e.a.e f22610e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, c.a.e.a.e eVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, hashMap, eVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22606a = null;
            this.f22607b = str;
            this.f22608c = str2;
            this.f22609d = hashMap;
            this.f22610e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                f fVar = new f();
                try {
                    this.f22606a = new NetWork(TbConfig.SERVER_ADDRESS + this.f22608c);
                    Set<String> keySet = this.f22609d.keySet();
                    if (keySet.size() > 0) {
                        for (String str : keySet) {
                            if (!"url".equalsIgnoreCase(str)) {
                                this.f22606a.addPostData(str, this.f22609d.get(str));
                            }
                        }
                    }
                    this.f22606a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.f22606a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    boolean z = true;
                    this.f22606a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f22606a.postNetData();
                    if (!this.f22606a.getNetContext().getResponse().isNetSuccess()) {
                        fVar.f12681b = this.f22606a.getNetErrorCode();
                        fVar.f12682c = this.f22606a.getNetString();
                    } else {
                        fVar.f12681b = this.f22606a.getServerErrorCode();
                        fVar.f12682c = this.f22606a.getErrorString();
                    }
                    if (this.f22606a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        if (fVar.f12681b != 0) {
                            z = false;
                        }
                        fVar.f12680a = z;
                        return fVar;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                fVar.f12680a = false;
                return fVar;
            }
            return (f) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                c.a.e.a.e eVar = this.f22610e;
                if (eVar != null) {
                    eVar.c(fVar);
                }
                c.a.p0.o1.m.a.a().d(this.f22608c, this.f22609d, fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f22606a != null) {
                    this.f22606a.cancelNetConnect();
                    this.f22606a = null;
                }
                super.cancel(true);
                c.a.e.a.e eVar = this.f22610e;
                if (eVar != null) {
                    eVar.c(null);
                }
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.o0.c.a, c.a.o0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, c.a.e.a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, obj, hashMap, str, eVar) == null) || hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a aVar = new a(this, str, str2, hashMap, eVar);
        aVar.setPriority(2);
        aVar.execute(new Object[0]);
    }

    @Override // c.a.o0.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "post" : (String) invokeV.objValue;
    }
}
