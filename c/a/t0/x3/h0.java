package c.a.t0.x3;

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
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public a f25064b;

    /* loaded from: classes8.dex */
    public interface a {
        void a(String str, long j2);

        void b(String str, long j2);
    }

    /* loaded from: classes8.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public String f25065b;

        /* renamed from: c  reason: collision with root package name */
        public long f25066c;

        /* renamed from: d  reason: collision with root package name */
        public String f25067d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f25068e;

        /* renamed from: f  reason: collision with root package name */
        public int f25069f;

        /* renamed from: g  reason: collision with root package name */
        public String f25070g;

        public b(String str, long j2, String str2, a aVar, h0 h0Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2), str2, aVar, h0Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f25065b = null;
            this.f25066c = 0L;
            this.f25068e = null;
            new WeakReference(h0Var);
            this.f25065b = str;
            this.f25066c = j2;
            this.f25068e = new WeakReference<>(aVar);
            this.f25067d = str2;
            this.f25070g = str3;
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
                    if (this.f25066c != 0 && this.f25065b != null) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                        this.a = netWork;
                        netWork.addPostData("fid", String.valueOf(this.f25066c));
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f25065b);
                        this.a.addPostData("favo_type", "1");
                        this.a.addPostData("st_type", this.f25067d);
                        this.a.addPostData("authsid", this.f25070g);
                        this.a.getNetContext().getRequest().mIsNeedTbs = true;
                        String postNetData = this.a.postNetData();
                        if (!c.a.d.f.p.m.isEmpty(postNetData)) {
                            JSONObject jSONObject = new JSONObject(postNetData);
                            this.f25069f = jSONObject.optInt("error_code");
                            jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                            AuthTokenData.parse(jSONObject);
                        }
                        if (this.a.getNetContext().getResponse().isRequestSuccess()) {
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
                if (this.f25068e != null) {
                    c.a.t0.x3.s0.f fVar = new c.a.t0.x3.s0.f();
                    fVar.a = this.f25066c;
                    a aVar = this.f25068e.get();
                    if (aVar == null) {
                        return;
                    }
                    if (num.intValue() == 1 && (netWork = this.a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.f25065b);
                        aVar.b(this.f25065b, this.f25066c);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f25066c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f25065b));
                        fVar.f25288b = true;
                    } else {
                        fVar.f25288b = false;
                        NetWork netWork2 = this.a;
                        if (netWork2 != null) {
                            String errorString = netWork2.isNetSuccess() ? this.a.getErrorString() : this.a.getNetException();
                            fVar.f25289c = errorString;
                            aVar.a(errorString, this.f25069f);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, fVar));
                }
            }
        }
    }

    public h0() {
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
        this.a = BarDetailForDirSwitch.BAR_DETAIL_DIR;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a = str;
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f25064b = aVar;
        }
    }

    public void c(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2) == null) {
            new b(str, j2, this.a, this.f25064b, this, null).execute(new Integer[0]);
        }
    }
}
