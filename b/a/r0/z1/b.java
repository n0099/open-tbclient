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
        public final /* synthetic */ C1361b f27879a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0685a f27880b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f27881c;

        public a(C1361b c1361b, a.InterfaceC0685a interfaceC0685a, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1361b, interfaceC0685a, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27879a = c1361b;
            this.f27880b = interfaceC0685a;
            this.f27881c = str;
        }

        @Override // b.a.q0.s.l.e.b
        public void onFailed() {
            a.InterfaceC0685a interfaceC0685a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (interfaceC0685a = this.f27880b) == null) {
                return;
            }
            interfaceC0685a.a(this.f27881c, 1, null);
        }

        @Override // b.a.q0.s.l.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f27879a.d(str);
                this.f27879a.execute(new String[0]);
            }
        }
    }

    /* renamed from: b.a.r0.z1.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1361b extends BdAsyncTask<String, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f27882a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27883b;

        /* renamed from: c  reason: collision with root package name */
        public final String f27884c;

        /* renamed from: d  reason: collision with root package name */
        public final String f27885d;

        /* renamed from: e  reason: collision with root package name */
        public String f27886e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC0685a f27887f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f27888g;

        /* renamed from: b.a.r0.z1.b$b$a */
        /* loaded from: classes6.dex */
        public class a implements a.InterfaceC0685a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1361b c1361b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1361b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // b.a.q0.s.l.a.InterfaceC0685a
            public void a(String str, int i2, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
                }
            }

            @Override // b.a.q0.s.l.a.InterfaceC0685a
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }

            @Override // b.a.q0.s.l.a.InterfaceC0685a
            public void c(AccountData accountData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                }
            }
        }

        public C1361b(String str, String str2, String str3, a.InterfaceC0685a interfaceC0685a, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, interfaceC0685a, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27882a = null;
            this.f27883b = str;
            this.f27884c = str2;
            this.f27885d = str3;
            this.f27888g = z;
            this.f27887f = interfaceC0685a == null ? new a(this) : interfaceC0685a;
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
                this.f27882a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
                this.f27882a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                this.f27882a.addPostData("bdusstoken", this.f27884c + "|" + this.f27885d);
                if (!StringUtils.isNull(this.f27886e)) {
                    this.f27882a.addPostData("stoken", this.f27886e);
                }
                this.f27882a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                this.f27882a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                this.f27882a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.f27882a.postNetData();
                if (!this.f27882a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    accountData = null;
                } else {
                    s0 s0Var = new s0();
                    s0Var.c(postNetData);
                    accountData = new AccountData();
                    accountData.setAccount(s0Var.b().getUserName());
                    accountData.setPassword("");
                    accountData.setID(s0Var.b().getUserId());
                    String str = this.f27884c;
                    if (this.f27888g && (d2 = e.d(b.a.q0.s.l.a.b().d(str))) != null) {
                        str = d2.f13137a + "|" + d2.f13138b;
                    }
                    accountData.setBDUSS(str);
                    accountData.setPortrait(s0Var.b().getPortrait());
                    accountData.setStoken(this.f27886e);
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
                b.a.q0.s.a0.a.a("account", -1L, 0, "cslogin_result", this.f27882a.getServerErrorCode(), this.f27882a.getErrorString(), new Object[0]);
                if (accountData != null && accountData.getBDUSS() != null) {
                    this.f27887f.c(accountData);
                    return;
                }
                String str = null;
                if (this.f27882a != null) {
                    str = this.f27882a.getErrorString();
                    i2 = this.f27882a.getServerErrorCode();
                }
                if (str == null) {
                    str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
                }
                this.f27887f.a(this.f27883b, i2, str);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                if (this.f27882a != null) {
                    this.f27882a.cancelNetConnect();
                }
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f27886e = str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f27887f.b(this.f27883b);
            }
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0685a interfaceC0685a) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, str, str2, str3, str4, interfaceC0685a)) == null) {
            b.a.q0.s.l.e eVar = new b.a.q0.s.l.e();
            C1361b c1361b = new C1361b(str, str2, str3, interfaceC0685a, false);
            if (b.a.q0.s.l.e.b() && StringUtils.isNull(str4)) {
                eVar.c(str2, new a(c1361b, interfaceC0685a, str));
            } else {
                if (b.a.q0.s.l.e.b()) {
                    c1361b.d(str4);
                }
                c1361b.execute(new String[0]);
            }
            return c1361b;
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }
}
