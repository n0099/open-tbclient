package c.a.q0.i2.f.a;

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
    public static final String f18951a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.i2.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0908a extends BdAsyncTask<String, Object, ForbidResultData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f18952a;

        /* renamed from: b  reason: collision with root package name */
        public String f18953b;

        /* renamed from: c  reason: collision with root package name */
        public String f18954c;

        /* renamed from: d  reason: collision with root package name */
        public String f18955d;

        /* renamed from: e  reason: collision with root package name */
        public String f18956e;

        /* renamed from: f  reason: collision with root package name */
        public String f18957f;

        /* renamed from: g  reason: collision with root package name */
        public String f18958g;

        /* renamed from: h  reason: collision with root package name */
        public String f18959h;

        /* renamed from: i  reason: collision with root package name */
        public String f18960i;

        /* renamed from: j  reason: collision with root package name */
        public WeakReference<b> f18961j;

        public C0908a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
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
            this.f18952a = str;
            this.f18953b = str2;
            this.f18954c = str3;
            this.f18955d = str4;
            this.f18958g = str6;
            this.f18956e = str8;
            this.f18957f = str9;
            this.f18959h = str7;
            this.f18960i = str5;
            this.f18961j = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidResultData doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(a.f18951a);
                netWork.addPostData("day", this.f18958g);
                netWork.addPostData("un", this.f18955d);
                netWork.addPostData("fid", this.f18952a);
                netWork.addPostData("word", this.f18953b);
                netWork.addPostData("z", this.f18954c);
                netWork.addPostData("reason", this.f18959h);
                netWork.addPostData("ntn", "banid");
                netWork.addPostData("post_id", this.f18960i);
                netWork.addPostData("nick_name", this.f18956e);
                netWork.addPostData("portrait", this.f18957f);
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
                b bVar = this.f18961j.get();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1222592883, "Lc/a/q0/i2/f/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1222592883, "Lc/a/q0/i2/f/a/a;");
                return;
            }
        }
        f18951a = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;
    }

    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, bVar}) == null) {
            new C0908a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
        }
    }
}
