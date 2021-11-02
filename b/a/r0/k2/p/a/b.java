package b.a.r0.k2.p.a;

import b.a.e.e.p.k;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.pb.account.forbid.ForbidTplData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f18661a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f18662a;

        /* renamed from: b  reason: collision with root package name */
        public String f18663b;

        /* renamed from: c  reason: collision with root package name */
        public InterfaceC0945b f18664c;

        public a(String str, String str2, InterfaceC0945b interfaceC0945b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, interfaceC0945b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18662a = str;
            this.f18663b = str2;
            this.f18664c = interfaceC0945b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidTplData doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(b.f18661a);
                netWork.addPostData("forum_id", this.f18662a);
                netWork.addPostData("user_id", this.f18663b);
                String postNetData = netWork.postNetData();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        return (ForbidTplData) OrmObject.objectWithJsonStr(postNetData, ForbidTplData.class);
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                        ForbidTplData forbidTplData = new ForbidTplData();
                        forbidTplData.error.errno = -1000;
                        return forbidTplData;
                    }
                }
                ForbidTplData forbidTplData2 = new ForbidTplData();
                forbidTplData2.error.errno = netWork.getServerErrorCode();
                forbidTplData2.error.errMsg = netWork.getErrorString();
                return forbidTplData2;
            }
            return (ForbidTplData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidTplData) == null) {
                super.onPostExecute(forbidTplData);
                if (this.f18664c != null) {
                    ForbidTplData.ErrorInfo errorInfo = forbidTplData.error;
                    if (errorInfo.errno == 0 && k.isEmpty(errorInfo.errMsg)) {
                        this.f18664c.b(forbidTplData);
                    } else {
                        this.f18664c.a(forbidTplData);
                    }
                }
            }
        }
    }

    /* renamed from: b.a.r0.k2.p.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0945b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(383373924, "Lb/a/r0/k2/p/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(383373924, "Lb/a/r0/k2/p/a/b;");
                return;
            }
        }
        f18661a = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";
    }

    public static void b(String str, String str2, InterfaceC0945b interfaceC0945b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, interfaceC0945b) == null) {
            new a(str, str2, interfaceC0945b).execute(new String[0]);
        }
    }
}
