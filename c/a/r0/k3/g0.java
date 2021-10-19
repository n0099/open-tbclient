package c.a.r0.k3;

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
    public String f20990a;

    /* renamed from: b  reason: collision with root package name */
    public a f20991b;

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
        public NetWork f20992a;

        /* renamed from: b  reason: collision with root package name */
        public String f20993b;

        /* renamed from: c  reason: collision with root package name */
        public long f20994c;

        /* renamed from: d  reason: collision with root package name */
        public String f20995d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f20996e;

        /* renamed from: f  reason: collision with root package name */
        public int f20997f;

        /* renamed from: g  reason: collision with root package name */
        public String f20998g;

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
            this.f20992a = null;
            this.f20993b = null;
            this.f20994c = 0L;
            this.f20996e = null;
            new WeakReference(g0Var);
            this.f20993b = str;
            this.f20994c = j2;
            this.f20996e = new WeakReference<>(aVar);
            this.f20995d = str2;
            this.f20998g = str3;
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
                    if (this.f20994c != 0 && this.f20993b != null) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                        this.f20992a = netWork;
                        netWork.addPostData("fid", String.valueOf(this.f20994c));
                        this.f20992a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f20993b);
                        this.f20992a.addPostData("favo_type", "1");
                        this.f20992a.addPostData("st_type", this.f20995d);
                        this.f20992a.addPostData("authsid", this.f20998g);
                        this.f20992a.getNetContext().getRequest().mIsNeedTbs = true;
                        String postNetData = this.f20992a.postNetData();
                        if (!c.a.e.e.p.k.isEmpty(postNetData)) {
                            JSONObject jSONObject = new JSONObject(postNetData);
                            this.f20997f = jSONObject.optInt("error_code");
                            jSONObject.optString("error_msg");
                            AuthTokenData.parse(jSONObject);
                        }
                        if (this.f20992a.getNetContext().getResponse().isRequestSuccess()) {
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
                if (this.f20996e != null) {
                    c.a.r0.k3.r0.k kVar = new c.a.r0.k3.r0.k();
                    kVar.f21309a = this.f20994c;
                    a aVar = this.f20996e.get();
                    if (aVar == null) {
                        return;
                    }
                    if (num.intValue() == 1 && (netWork = this.f20992a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.f20993b);
                        aVar.b(this.f20993b, this.f20994c);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f20994c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f20993b));
                        kVar.f21310b = true;
                    } else {
                        kVar.f21310b = false;
                        NetWork netWork2 = this.f20992a;
                        if (netWork2 != null) {
                            String errorString = netWork2.isNetSuccess() ? this.f20992a.getErrorString() : this.f20992a.getNetException();
                            kVar.f21311c = errorString;
                            aVar.a(errorString, this.f20997f);
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
        this.f20990a = BarDetailForDirSwitch.BAR_DETAIL_DIR;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f20990a = str;
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f20991b = aVar;
        }
    }

    public void c(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2) == null) {
            new b(str, j2, this.f20990a, this.f20991b, this, null).execute(new Integer[0]);
        }
    }
}
