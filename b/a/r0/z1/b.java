package b.a.r0.z1;

import b.a.q0.s.l.a;
import b.a.q0.s.l.e;
import b.a.q0.s.q.s0;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.switchs.CheckShowNameDialogSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C1429b f29397a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0720a f29398b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29399c;

        public a(C1429b c1429b, a.InterfaceC0720a interfaceC0720a, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1429b, interfaceC0720a, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29397a = c1429b;
            this.f29398b = interfaceC0720a;
            this.f29399c = str;
        }

        @Override // b.a.q0.s.l.e.b
        public void onFailed() {
            a.InterfaceC0720a interfaceC0720a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (interfaceC0720a = this.f29398b) == null) {
                return;
            }
            interfaceC0720a.onFailure(this.f29399c, 1, null);
        }

        @Override // b.a.q0.s.l.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f29397a.d(str);
                this.f29397a.execute(new String[0]);
            }
        }
    }

    /* renamed from: b.a.r0.z1.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1429b extends BdAsyncTask<String, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f29400a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29401b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29402c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29403d;

        /* renamed from: e  reason: collision with root package name */
        public String f29404e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC0720a f29405f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f29406g;

        /* renamed from: b.a.r0.z1.b$b$a */
        /* loaded from: classes6.dex */
        public class a implements a.InterfaceC0720a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1429b c1429b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1429b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // b.a.q0.s.l.a.InterfaceC0720a
            public void onBeforeLogin(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                }
            }

            @Override // b.a.q0.s.l.a.InterfaceC0720a
            public void onFailure(String str, int i2, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
                }
            }

            @Override // b.a.q0.s.l.a.InterfaceC0720a
            public void onSuccess(AccountData accountData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                }
            }
        }

        public C1429b(String str, String str2, String str3, a.InterfaceC0720a interfaceC0720a, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, interfaceC0720a, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29400a = null;
            this.f29401b = str;
            this.f29402c = str2;
            this.f29403d = str3;
            this.f29406g = z;
            this.f29405f = interfaceC0720a == null ? new a(this) : interfaceC0720a;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01b4  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccountData doInBackground(String... strArr) {
            InterceptResult invokeL;
            AccountData accountData;
            int i2;
            int i3;
            a.b d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.f29400a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
                this.f29400a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                this.f29400a.addPostData("bdusstoken", this.f29402c + "|" + this.f29403d);
                if (!StringUtils.isNull(this.f29404e)) {
                    this.f29400a.addPostData("stoken", this.f29404e);
                }
                this.f29400a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                this.f29400a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                this.f29400a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.f29400a.postNetData();
                if (!this.f29400a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    accountData = null;
                } else {
                    s0 s0Var = new s0();
                    s0Var.c(postNetData);
                    accountData = new AccountData();
                    accountData.setAccount(s0Var.b().getUserName());
                    accountData.setPassword("");
                    accountData.setID(s0Var.b().getUserId());
                    String str = this.f29402c;
                    if (this.f29406g && (d2 = e.d(b.a.q0.s.l.a.b().d(str))) != null) {
                        str = d2.f13917a + "|" + d2.f13918b;
                    }
                    accountData.setBDUSS(str);
                    accountData.setPortrait(s0Var.b().getPortrait());
                    accountData.setStoken(this.f29404e);
                    accountData.setIsActive(1);
                    if (s0Var.a() != null) {
                        accountData.setTbs(s0Var.a().getTbs());
                    }
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
                netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                if (accountData != null) {
                    netWork.addPostData(HttpRequest.BDUSS, accountData.getBDUSS());
                    netWork.addPostData("stoken", b.a.q0.s.l.e.a(accountData));
                }
                String postNetData2 = netWork.postNetData();
                if (!netWork.getNetContext().getResponse().isRequestSuccess() || postNetData2 == null) {
                    i2 = 0;
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(postNetData2);
                        JSONArray optJSONArray = jSONObject.optJSONArray(SetImageWatermarkTypeReqMsg.SWITCH);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                                if (optJSONObject != null && CheckShowNameDialogSwitch.KEY.equals(optJSONObject.optString("name"))) {
                                    i2 = optJSONObject.optInt("type", 0);
                                    break;
                                }
                            }
                        }
                        i2 = 0;
                        try {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                            if (accountData != null && jSONObject2 != null) {
                                accountData.setNameShow(jSONObject2.optString("name_show"));
                            }
                        } catch (JSONException e2) {
                            i3 = i2;
                            e = e2;
                            e.printStackTrace();
                            i2 = i3;
                            TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i2 == 1);
                            return accountData;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        i3 = 0;
                    }
                }
                TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i2 == 1);
                return accountData;
            }
            return (AccountData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountData) == null) {
                super.onPostExecute(accountData);
                int i2 = 0;
                ReloginManager.g().o(false);
                b.a.q0.s.a0.a.a("account", -1L, 0, "cslogin_result", this.f29400a.getServerErrorCode(), this.f29400a.getErrorString(), new Object[0]);
                if (accountData != null && accountData.getBDUSS() != null) {
                    this.f29405f.onSuccess(accountData);
                    return;
                }
                String str = null;
                if (this.f29400a != null) {
                    str = this.f29400a.getErrorString();
                    i2 = this.f29400a.getServerErrorCode();
                }
                if (str == null) {
                    str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
                }
                this.f29405f.onFailure(this.f29401b, i2, str);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                if (this.f29400a != null) {
                    this.f29400a.cancelNetConnect();
                }
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f29404e = str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f29405f.onBeforeLogin(this.f29401b);
            }
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0720a interfaceC0720a) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, str, str2, str3, str4, interfaceC0720a)) == null) {
            b.a.q0.s.l.e eVar = new b.a.q0.s.l.e();
            C1429b c1429b = new C1429b(str, str2, str3, interfaceC0720a, false);
            if (b.a.q0.s.l.e.b() && StringUtils.isNull(str4)) {
                eVar.c(str2, new a(c1429b, interfaceC0720a, str));
            } else {
                if (b.a.q0.s.l.e.b()) {
                    c1429b.d(str4);
                }
                c1429b.execute(new String[0]);
            }
            return c1429b;
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }
}
