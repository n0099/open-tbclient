package c.a.q0.i3;

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
    public String f20236a;

    /* renamed from: b  reason: collision with root package name */
    public a f20237b;

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
        public NetWork f20238a;

        /* renamed from: b  reason: collision with root package name */
        public String f20239b;

        /* renamed from: c  reason: collision with root package name */
        public long f20240c;

        /* renamed from: d  reason: collision with root package name */
        public String f20241d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f20242e;

        /* renamed from: f  reason: collision with root package name */
        public int f20243f;

        /* renamed from: g  reason: collision with root package name */
        public String f20244g;

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
            this.f20238a = null;
            this.f20239b = null;
            this.f20240c = 0L;
            this.f20242e = null;
            new WeakReference(g0Var);
            this.f20239b = str;
            this.f20240c = j2;
            this.f20242e = new WeakReference<>(aVar);
            this.f20241d = str2;
            this.f20244g = str3;
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
                    if (this.f20240c != 0 && this.f20239b != null) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                        this.f20238a = netWork;
                        netWork.addPostData("fid", String.valueOf(this.f20240c));
                        this.f20238a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f20239b);
                        this.f20238a.addPostData("favo_type", "1");
                        this.f20238a.addPostData("st_type", this.f20241d);
                        this.f20238a.addPostData("authsid", this.f20244g);
                        this.f20238a.getNetContext().getRequest().mIsNeedTbs = true;
                        String postNetData = this.f20238a.postNetData();
                        if (!c.a.e.e.p.k.isEmpty(postNetData)) {
                            JSONObject jSONObject = new JSONObject(postNetData);
                            this.f20243f = jSONObject.optInt("error_code");
                            jSONObject.optString("error_msg");
                            AuthTokenData.parse(jSONObject);
                        }
                        if (this.f20238a.getNetContext().getResponse().isRequestSuccess()) {
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
                if (this.f20242e != null) {
                    c.a.q0.i3.r0.k kVar = new c.a.q0.i3.r0.k();
                    kVar.f20549a = this.f20240c;
                    a aVar = this.f20242e.get();
                    if (aVar == null) {
                        return;
                    }
                    if (num.intValue() == 1 && (netWork = this.f20238a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.f20239b);
                        aVar.b(this.f20239b, this.f20240c);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f20240c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f20239b));
                        kVar.f20550b = true;
                    } else {
                        kVar.f20550b = false;
                        NetWork netWork2 = this.f20238a;
                        if (netWork2 != null) {
                            String errorString = netWork2.isNetSuccess() ? this.f20238a.getErrorString() : this.f20238a.getNetException();
                            kVar.f20551c = errorString;
                            aVar.a(errorString, this.f20243f);
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
        this.f20236a = BarDetailForDirSwitch.BAR_DETAIL_DIR;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f20236a = str;
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f20237b = aVar;
        }
    }

    public void c(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2) == null) {
            new b(str, j2, this.f20236a, this.f20237b, this, null).execute(new Integer[0]);
        }
    }
}
