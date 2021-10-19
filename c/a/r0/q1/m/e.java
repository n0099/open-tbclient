package c.a.r0.q1.m;

import android.text.TextUtils;
import c.a.q0.c.f;
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
public class e extends c.a.q0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f23719a;

        /* renamed from: b  reason: collision with root package name */
        public String f23720b;

        /* renamed from: c  reason: collision with root package name */
        public String f23721c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f23722d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.e.a.e f23723e;

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
            this.f23719a = null;
            this.f23720b = str;
            this.f23721c = str2;
            this.f23722d = hashMap;
            this.f23723e = eVar2;
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
                    this.f23719a = new NetWork(TbConfig.SERVER_ADDRESS + this.f23721c);
                    Set<String> keySet = this.f23722d.keySet();
                    if (keySet.size() > 0) {
                        for (String str : keySet) {
                            if (!"url".equalsIgnoreCase(str)) {
                                this.f23719a.addPostData(str, this.f23722d.get(str));
                            }
                        }
                    }
                    this.f23719a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.f23719a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    boolean z = true;
                    this.f23719a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f23719a.postNetData();
                    if (!this.f23719a.getNetContext().getResponse().isNetSuccess()) {
                        fVar.f12806b = this.f23719a.getNetErrorCode();
                        fVar.f12807c = this.f23719a.getNetString();
                    } else {
                        fVar.f12806b = this.f23719a.getServerErrorCode();
                        fVar.f12807c = this.f23719a.getErrorString();
                    }
                    if (this.f23719a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        if (fVar.f12806b != 0) {
                            z = false;
                        }
                        fVar.f12805a = z;
                        return fVar;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                fVar.f12805a = false;
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
                c.a.e.a.e eVar = this.f23723e;
                if (eVar != null) {
                    eVar.c(fVar);
                }
                c.a.r0.q1.m.a.a().d(this.f23721c, this.f23722d, fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f23719a != null) {
                    this.f23719a.cancelNetConnect();
                    this.f23719a = null;
                }
                super.cancel(true);
                c.a.e.a.e eVar = this.f23723e;
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

    @Override // c.a.q0.c.a, c.a.q0.c.d
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

    @Override // c.a.q0.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "post" : (String) invokeV.objValue;
    }
}
