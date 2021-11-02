package b.a.r0.l3;

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
/* loaded from: classes5.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f20561a;

    /* renamed from: b  reason: collision with root package name */
    public a f20562b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20563a;

        /* renamed from: b  reason: collision with root package name */
        public String f20564b;

        /* renamed from: c  reason: collision with root package name */
        public long f20565c;

        /* renamed from: d  reason: collision with root package name */
        public String f20566d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f20567e;

        /* renamed from: f  reason: collision with root package name */
        public int f20568f;

        /* renamed from: g  reason: collision with root package name */
        public String f20569g;

        public b(String str, long j, String str2, a aVar, h0 h0Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), str2, aVar, h0Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20563a = null;
            this.f20564b = null;
            this.f20565c = 0L;
            this.f20567e = null;
            new WeakReference(h0Var);
            this.f20564b = str;
            this.f20565c = j;
            this.f20567e = new WeakReference<>(aVar);
            this.f20566d = str2;
            this.f20569g = str3;
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
                    if (this.f20565c != 0 && this.f20564b != null) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                        this.f20563a = netWork;
                        netWork.addPostData("fid", String.valueOf(this.f20565c));
                        this.f20563a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f20564b);
                        this.f20563a.addPostData("favo_type", "1");
                        this.f20563a.addPostData("st_type", this.f20566d);
                        this.f20563a.addPostData("authsid", this.f20569g);
                        this.f20563a.getNetContext().getRequest().mIsNeedTbs = true;
                        String postNetData = this.f20563a.postNetData();
                        if (!b.a.e.e.p.k.isEmpty(postNetData)) {
                            JSONObject jSONObject = new JSONObject(postNetData);
                            this.f20568f = jSONObject.optInt("error_code");
                            jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                            AuthTokenData.parse(jSONObject);
                        }
                        if (this.f20563a.getNetContext().getResponse().isRequestSuccess()) {
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
                if (this.f20567e != null) {
                    b.a.r0.l3.s0.k kVar = new b.a.r0.l3.s0.k();
                    kVar.f20874a = this.f20565c;
                    a aVar = this.f20567e.get();
                    if (aVar == null) {
                        return;
                    }
                    if (num.intValue() == 1 && (netWork = this.f20563a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.f20564b);
                        aVar.b(this.f20564b, this.f20565c);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f20565c)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f20564b));
                        kVar.f20875b = true;
                    } else {
                        kVar.f20875b = false;
                        NetWork netWork2 = this.f20563a;
                        if (netWork2 != null) {
                            String errorString = netWork2.isNetSuccess() ? this.f20563a.getErrorString() : this.f20563a.getNetException();
                            kVar.f20876c = errorString;
                            aVar.a(errorString, this.f20568f);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, kVar));
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
        this.f20561a = BarDetailForDirSwitch.BAR_DETAIL_DIR;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f20561a = str;
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f20562b = aVar;
        }
    }

    public void c(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
            new b(str, j, this.f20561a, this.f20562b, this, null).execute(new Integer[0]);
        }
    }
}
