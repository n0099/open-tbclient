package c.a.r0.k2.f.a;

import c.a.e.e.p.k;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f19703a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f19704a;

        /* renamed from: b  reason: collision with root package name */
        public String f19705b;

        /* renamed from: c  reason: collision with root package name */
        public InterfaceC0948b f19706c;

        public a(String str, String str2, InterfaceC0948b interfaceC0948b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, interfaceC0948b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19704a = str;
            this.f19705b = str2;
            this.f19706c = interfaceC0948b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidTplData doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(b.f19703a);
                netWork.addPostData("forum_id", this.f19704a);
                netWork.addPostData("user_id", this.f19705b);
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
                if (this.f19706c != null) {
                    ForbidTplData.ErrorInfo errorInfo = forbidTplData.error;
                    if (errorInfo.errno == 0 && k.isEmpty(errorInfo.errMsg)) {
                        this.f19706c.b(forbidTplData);
                    } else {
                        this.f19706c.a(forbidTplData);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.r0.k2.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0948b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-413451763, "Lc/a/r0/k2/f/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-413451763, "Lc/a/r0/k2/f/a/b;");
                return;
            }
        }
        f19703a = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";
    }

    public static void b(String str, String str2, InterfaceC0948b interfaceC0948b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, interfaceC0948b) == null) {
            new a(str, str2, interfaceC0948b).execute(new String[0]);
        }
    }
}
