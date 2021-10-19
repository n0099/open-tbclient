package c.a.r0.k2.f.a;

import c.a.e.e.p.k;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.pb.account.forbid.ForbidResultData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f19692a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.k2.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0947a extends BdAsyncTask<String, Object, ForbidResultData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f19693a;

        /* renamed from: b  reason: collision with root package name */
        public String f19694b;

        /* renamed from: c  reason: collision with root package name */
        public String f19695c;

        /* renamed from: d  reason: collision with root package name */
        public String f19696d;

        /* renamed from: e  reason: collision with root package name */
        public String f19697e;

        /* renamed from: f  reason: collision with root package name */
        public String f19698f;

        /* renamed from: g  reason: collision with root package name */
        public String f19699g;

        /* renamed from: h  reason: collision with root package name */
        public String f19700h;

        /* renamed from: i  reason: collision with root package name */
        public String f19701i;

        /* renamed from: j  reason: collision with root package name */
        public WeakReference<b> f19702j;

        public C0947a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, str5, str6, str7, str8, str9, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19693a = str;
            this.f19694b = str2;
            this.f19695c = str3;
            this.f19696d = str4;
            this.f19699g = str6;
            this.f19697e = str8;
            this.f19698f = str9;
            this.f19700h = str7;
            this.f19701i = str5;
            this.f19702j = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidResultData doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(a.f19692a);
                netWork.addPostData("day", this.f19699g);
                netWork.addPostData("un", this.f19696d);
                netWork.addPostData("fid", this.f19693a);
                netWork.addPostData("word", this.f19694b);
                netWork.addPostData("z", this.f19695c);
                netWork.addPostData("reason", this.f19700h);
                netWork.addPostData("ntn", "banid");
                netWork.addPostData("post_id", this.f19701i);
                netWork.addPostData("nick_name", this.f19697e);
                netWork.addPostData("portrait", this.f19698f);
                netWork.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = netWork.postNetData();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        return (ForbidResultData) OrmObject.objectWithJsonStr(postNetData, ForbidResultData.class);
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                        ForbidResultData forbidResultData = new ForbidResultData();
                        forbidResultData.error_code = -1000;
                        return forbidResultData;
                    }
                }
                ForbidResultData forbidResultData2 = new ForbidResultData();
                forbidResultData2.error_code = netWork.getServerErrorCode();
                forbidResultData2.error_msg = netWork.getErrorString();
                return forbidResultData2;
            }
            return (ForbidResultData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidResultData) == null) {
                super.onPostExecute(forbidResultData);
                b bVar = this.f19702j.get();
                if (bVar != null) {
                    if (forbidResultData.error_code == 0 && k.isEmpty(forbidResultData.error_msg)) {
                        bVar.a(forbidResultData);
                    } else {
                        bVar.b(forbidResultData);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-413451794, "Lc/a/r0/k2/f/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-413451794, "Lc/a/r0/k2/f/a/a;");
                return;
            }
        }
        f19692a = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;
    }

    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, bVar}) == null) {
            new C0947a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
        }
    }
}
