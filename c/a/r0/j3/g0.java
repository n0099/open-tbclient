package c.a.r0.j3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f20800a;

    /* renamed from: b  reason: collision with root package name */
    public a f20801b;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, long j2);

        void b(String str, long j2);
    }

    /* loaded from: classes3.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20802a;

        /* renamed from: b  reason: collision with root package name */
        public String f20803b;

        /* renamed from: c  reason: collision with root package name */
        public long f20804c;

        /* renamed from: d  reason: collision with root package name */
        public String f20805d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f20806e;

        /* renamed from: f  reason: collision with root package name */
        public int f20807f;

        /* renamed from: g  reason: collision with root package name */
        public String f20808g;

        public b(String str, long j2, String str2, a aVar, g0 g0Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2), str2, aVar, g0Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20802a = null;
            this.f20803b = null;
            this.f20804c = 0L;
            this.f20806e = null;
            new WeakReference(g0Var);
            this.f20803b = str;
            this.f20804c = j2;
            this.f20806e = new WeakReference<>(aVar);
            this.f20805d = str2;
            this.f20808g = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                try {
                    if (this.f20804c != 0 && this.f20803b != null) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                        this.f20802a = netWork;
                        netWork.addPostData("fid", String.valueOf(this.f20804c));
                        this.f20802a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f20803b);
                        this.f20802a.addPostData("favo_type", "1");
                        this.f20802a.addPostData("st_type", this.f20805d);
                        this.f20802a.addPostData("authsid", this.f20808g);
                        this.f20802a.getNetContext().getRequest().mIsNeedTbs = true;
                        String postNetData = this.f20802a.postNetData();
                        if (!c.a.e.e.p.k.isEmpty(postNetData)) {
                            JSONObject jSONObject = new JSONObject(postNetData);
                            this.f20807f = jSONObject.optInt("error_code");
                            jSONObject.optString("error_msg");
                            AuthTokenData.parse(jSONObject);
                        }
                        if (this.f20802a.getNetContext().getResponse().isRequestSuccess()) {
                            return 1;
                        }
                    }
                    return 0;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return 0;
                }
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            NetWork netWork;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
                super.onPostExecute((b) num);
                if (this.f20806e != null) {
                    c.a.r0.j3.r0.k kVar = new c.a.r0.j3.r0.k();
                    kVar.f21117a = this.f20804c;
                    a aVar = this.f20806e.get();
                    if (aVar == null) {
                        return;
                    }
                    if (num.intValue() == 1 && (netWork = this.f20802a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.f20803b);
                        aVar.b(this.f20803b, this.f20804c);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f20804c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f20803b));
                        kVar.f21118b = true;
                    } else {
                        kVar.f21118b = false;
                        NetWork netWork2 = this.f20802a;
                        if (netWork2 != null) {
                            String errorString = netWork2.isNetSuccess() ? this.f20802a.getErrorString() : this.f20802a.getNetException();
                            kVar.f21119c = errorString;
                            aVar.a(errorString, this.f20807f);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, kVar));
                }
            }
        }
    }

    public g0() {
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
        this.f20800a = BarDetailForDirSwitch.BAR_DETAIL_DIR;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f20800a = str;
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f20801b = aVar;
        }
    }

    public void c(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2) == null) {
            new b(str, j2, this.f20800a, this.f20801b, this, null).execute(new Integer[0]);
        }
    }
}
