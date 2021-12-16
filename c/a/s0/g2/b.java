package c.a.s0.g2;

import c.a.r0.s.m.a;
import c.a.r0.s.m.e;
import c.a.r0.s.r.s0;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ C1077b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0840a f17862b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17863c;

        public a(C1077b c1077b, a.InterfaceC0840a interfaceC0840a, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1077b, interfaceC0840a, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c1077b;
            this.f17862b = interfaceC0840a;
            this.f17863c = str;
        }

        @Override // c.a.r0.s.m.e.b
        public void onFailed() {
            a.InterfaceC0840a interfaceC0840a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (interfaceC0840a = this.f17862b) == null) {
                return;
            }
            interfaceC0840a.onFailure(this.f17863c, 1, null);
        }

        @Override // c.a.r0.s.m.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.d(str);
                this.a.execute(new String[0]);
            }
        }
    }

    /* renamed from: c.a.s0.g2.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1077b extends BdAsyncTask<String, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public final String f17864b;

        /* renamed from: c  reason: collision with root package name */
        public final String f17865c;

        /* renamed from: d  reason: collision with root package name */
        public final String f17866d;

        /* renamed from: e  reason: collision with root package name */
        public String f17867e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC0840a f17868f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f17869g;

        /* renamed from: c.a.s0.g2.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements a.InterfaceC0840a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1077b c1077b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1077b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.r0.s.m.a.InterfaceC0840a
            public void onBeforeLogin(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                }
            }

            @Override // c.a.r0.s.m.a.InterfaceC0840a
            public void onFailure(String str, int i2, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
                }
            }

            @Override // c.a.r0.s.m.a.InterfaceC0840a
            public void onSuccess(AccountData accountData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                }
            }
        }

        public C1077b(String str, String str2, String str3, a.InterfaceC0840a interfaceC0840a, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, interfaceC0840a, Boolean.valueOf(z)};
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
            this.f17864b = str;
            this.f17865c = str2;
            this.f17866d = str3;
            this.f17869g = z;
            this.f17868f = interfaceC0840a == null ? new a(this) : interfaceC0840a;
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
                this.a.addPostData("bdusstoken", this.f17865c + "|" + this.f17866d);
                if (!StringUtils.isNull(this.f17867e)) {
                    this.a.addPostData("stoken", this.f17867e);
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
                    String str = this.f17865c;
                    if (this.f17869g && (d2 = e.d(c.a.r0.s.m.a.b().d(str))) != null) {
                        str = d2.a + "|" + d2.f13161b;
                    }
                    accountData.setBDUSS(str);
                    accountData.setPortrait(s0Var.b().getPortrait());
                    accountData.setStoken(this.f17867e);
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
                    netWork.addPostData("stoken", c.a.r0.s.m.e.a(accountData));
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
                c.a.r0.s.c0.a.a("account", -1L, 0, "cslogin_result", this.a.getServerErrorCode(), this.a.getErrorString(), new Object[0]);
                if (accountData != null && accountData.getBDUSS() != null) {
                    this.f17868f.onSuccess(accountData);
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
                this.f17868f.onFailure(this.f17864b, i2, str);
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
                this.f17867e = str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f17868f.onBeforeLogin(this.f17864b);
            }
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0840a interfaceC0840a) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, str, str2, str3, str4, interfaceC0840a)) == null) {
            c.a.r0.s.m.e eVar = new c.a.r0.s.m.e();
            C1077b c1077b = new C1077b(str, str2, str3, interfaceC0840a, false);
            if (c.a.r0.s.m.e.b() && StringUtils.isNull(str4)) {
                eVar.c(str2, new a(c1077b, interfaceC0840a, str));
            } else {
                if (c.a.r0.s.m.e.b()) {
                    c1077b.d(str4);
                }
                c1077b.execute(new String[0]);
            }
            return c1077b;
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }
}
