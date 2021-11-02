package b.a.r0.q1.m;

import android.text.TextUtils;
import b.a.q0.c.f;
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
/* loaded from: classes5.dex */
public class e extends b.a.q0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f22610a;

        /* renamed from: b  reason: collision with root package name */
        public String f22611b;

        /* renamed from: c  reason: collision with root package name */
        public String f22612c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f22613d;

        /* renamed from: e  reason: collision with root package name */
        public b.a.e.a.e f22614e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, b.a.e.a.e eVar2) {
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
            this.f22610a = null;
            this.f22611b = str;
            this.f22612c = str2;
            this.f22613d = hashMap;
            this.f22614e = eVar2;
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
                    this.f22610a = new NetWork(TbConfig.SERVER_ADDRESS + this.f22612c);
                    Set<String> keySet = this.f22613d.keySet();
                    if (keySet.size() > 0) {
                        for (String str : keySet) {
                            if (!"url".equalsIgnoreCase(str)) {
                                this.f22610a.addPostData(str, this.f22613d.get(str));
                            }
                        }
                    }
                    this.f22610a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.f22610a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    boolean z = true;
                    this.f22610a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f22610a.postNetData();
                    if (!this.f22610a.getNetContext().getResponse().isNetSuccess()) {
                        fVar.f11970b = this.f22610a.getNetErrorCode();
                        fVar.f11971c = this.f22610a.getNetString();
                    } else {
                        fVar.f11970b = this.f22610a.getServerErrorCode();
                        fVar.f11971c = this.f22610a.getErrorString();
                    }
                    if (this.f22610a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        if (fVar.f11970b != 0) {
                            z = false;
                        }
                        fVar.f11969a = z;
                        return fVar;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                fVar.f11969a = false;
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
                b.a.e.a.e eVar = this.f22614e;
                if (eVar != null) {
                    eVar.c(fVar);
                }
                b.a.r0.q1.m.a.a().d(this.f22612c, this.f22613d, fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f22610a != null) {
                    this.f22610a.cancelNetConnect();
                    this.f22610a = null;
                }
                super.cancel(true);
                b.a.e.a.e eVar = this.f22614e;
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

    @Override // b.a.q0.c.a, b.a.q0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, b.a.e.a.e eVar) {
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

    @Override // b.a.q0.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "post" : (String) invokeV.objValue;
    }
}
