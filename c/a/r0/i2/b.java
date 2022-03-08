package c.a.r0.i2;

import c.a.q0.r.m.a;
import c.a.q0.r.m.e;
import c.a.q0.r.r.s0;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ C1140b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0867a f18205b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18206c;

        public a(C1140b c1140b, a.InterfaceC0867a interfaceC0867a, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1140b, interfaceC0867a, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c1140b;
            this.f18205b = interfaceC0867a;
            this.f18206c = str;
        }

        @Override // c.a.q0.r.m.e.b
        public void onFailed() {
            a.InterfaceC0867a interfaceC0867a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (interfaceC0867a = this.f18205b) == null) {
                return;
            }
            interfaceC0867a.onFailure(this.f18206c, 1, null);
        }

        @Override // c.a.q0.r.m.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.d(str);
                this.a.execute(new String[0]);
            }
        }
    }

    /* renamed from: c.a.r0.i2.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1140b extends BdAsyncTask<String, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public final String f18207b;

        /* renamed from: c  reason: collision with root package name */
        public final String f18208c;

        /* renamed from: d  reason: collision with root package name */
        public final String f18209d;

        /* renamed from: e  reason: collision with root package name */
        public String f18210e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC0867a f18211f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f18212g;

        /* renamed from: c.a.r0.i2.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements a.InterfaceC0867a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1140b c1140b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1140b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.q0.r.m.a.InterfaceC0867a
            public void onBeforeLogin(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                }
            }

            @Override // c.a.q0.r.m.a.InterfaceC0867a
            public void onFailure(String str, int i2, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
                }
            }

            @Override // c.a.q0.r.m.a.InterfaceC0867a
            public void onSuccess(AccountData accountData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                }
            }
        }

        public C1140b(String str, String str2, String str3, a.InterfaceC0867a interfaceC0867a, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, interfaceC0867a, Boolean.valueOf(z)};
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
            this.f18207b = str;
            this.f18208c = str2;
            this.f18209d = str3;
            this.f18212g = z;
            this.f18211f = interfaceC0867a == null ? new a(this) : interfaceC0867a;
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
                this.a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
                this.a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                this.a.addPostData("bdusstoken", this.f18208c + "|" + this.f18209d);
                if (!StringUtils.isNull(this.f18210e)) {
                    this.a.addPostData("stoken", this.f18210e);
                }
                this.a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                this.a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                this.a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.a.postNetData();
                if (!this.a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    accountData = null;
                } else {
                    s0 s0Var = new s0();
                    s0Var.c(postNetData);
                    accountData = new AccountData();
                    accountData.setAccount(s0Var.b().getUserName());
                    accountData.setPassword("");
                    accountData.setID(s0Var.b().getUserId());
                    String str = this.f18208c;
                    if (this.f18212g && (d2 = e.d(c.a.q0.r.m.a.b().c(str))) != null) {
                        str = d2.a + "|" + d2.f13080b;
                    }
                    accountData.setBDUSS(str);
                    accountData.setPortrait(s0Var.b().getPortrait());
                    accountData.setStoken(this.f18210e);
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
                    netWork.addPostData("stoken", c.a.q0.r.m.e.a(accountData));
                }
                String postNetData2 = netWork.postNetData();
                if (!netWork.getNetContext().getResponse().isRequestSuccess() || postNetData2 == null) {
                    i2 = 0;
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(postNetData2);
                        JSONArray optJSONArray = jSONObject.optJSONArray("switch");
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
                c.a.q0.r.d0.a.a("account", -1L, 0, "cslogin_result", this.a.getServerErrorCode(), this.a.getErrorString(), new Object[0]);
                if (accountData != null && accountData.getBDUSS() != null) {
                    this.f18211f.onSuccess(accountData);
                    return;
                }
                String str = null;
                if (this.a != null) {
                    str = this.a.getErrorString();
                    i2 = this.a.getServerErrorCode();
                }
                if (str == null) {
                    str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
                }
                this.f18211f.onFailure(this.f18207b, i2, str);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                if (this.a != null) {
                    this.a.cancelNetConnect();
                }
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f18210e = str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f18211f.onBeforeLogin(this.f18207b);
            }
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0867a interfaceC0867a) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, str, str2, str3, str4, interfaceC0867a)) == null) {
            c.a.q0.r.m.e eVar = new c.a.q0.r.m.e();
            C1140b c1140b = new C1140b(str, str2, str3, interfaceC0867a, false);
            if (c.a.q0.r.m.e.b() && StringUtils.isNull(str4)) {
                eVar.c(str2, new a(c1140b, interfaceC0867a, str));
            } else {
                if (c.a.q0.r.m.e.b()) {
                    c1140b.d(str4);
                }
                c1140b.execute(new String[0]);
            }
            return c1140b;
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }
}
