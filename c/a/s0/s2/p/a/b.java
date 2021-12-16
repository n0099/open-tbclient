package c.a.s0.s2.p.a;

import c.a.d.f.p.l;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f22430b;

        /* renamed from: c  reason: collision with root package name */
        public InterfaceC1342b f22431c;

        public a(String str, String str2, InterfaceC1342b interfaceC1342b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, interfaceC1342b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f22430b = str2;
            this.f22431c = interfaceC1342b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidTplData doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(b.a);
                netWork.addPostData("forum_id", this.a);
                netWork.addPostData("user_id", this.f22430b);
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
                if (this.f22431c != null) {
                    ForbidTplData.ErrorInfo errorInfo = forbidTplData.error;
                    if (errorInfo.errno == 0 && l.isEmpty(errorInfo.errMsg)) {
                        this.f22431c.b(forbidTplData);
                    } else {
                        this.f22431c.a(forbidTplData);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.s0.s2.p.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1342b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1572811350, "Lc/a/s0/s2/p/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1572811350, "Lc/a/s0/s2/p/a/b;");
                return;
            }
        }
        a = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";
    }

    public static void b(String str, String str2, InterfaceC1342b interfaceC1342b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, interfaceC1342b) == null) {
            new a(str, str2, interfaceC1342b).execute(new String[0]);
        }
    }
}
