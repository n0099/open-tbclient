package c.a.r0.y1;

import c.a.q0.s.l.a;
import c.a.q0.s.l.e;
import c.a.q0.s.q.s0;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.NetWork;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C1368b f29267a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0689a f29268b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29269c;

        public a(C1368b c1368b, a.InterfaceC0689a interfaceC0689a, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1368b, interfaceC0689a, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29267a = c1368b;
            this.f29268b = interfaceC0689a;
            this.f29269c = str;
        }

        @Override // c.a.q0.s.l.e.b
        public void onFailed() {
            a.InterfaceC0689a interfaceC0689a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (interfaceC0689a = this.f29268b) == null) {
                return;
            }
            interfaceC0689a.a(this.f29269c, 1, null);
        }

        @Override // c.a.q0.s.l.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f29267a.d(str);
                this.f29267a.execute(new String[0]);
            }
        }
    }

    /* renamed from: c.a.r0.y1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1368b extends BdAsyncTask<String, Integer, AccountData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f29270a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29271b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29272c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29273d;

        /* renamed from: e  reason: collision with root package name */
        public String f29274e;

        /* renamed from: f  reason: collision with root package name */
        public final a.InterfaceC0689a f29275f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f29276g;

        /* renamed from: c.a.r0.y1.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements a.InterfaceC0689a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1368b c1368b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1368b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.q0.s.l.a.InterfaceC0689a
            public void a(String str, int i2, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
                }
            }

            @Override // c.a.q0.s.l.a.InterfaceC0689a
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }

            @Override // c.a.q0.s.l.a.InterfaceC0689a
            public void c(AccountData accountData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                }
            }
        }

        public C1368b(String str, String str2, String str3, a.InterfaceC0689a interfaceC0689a, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, interfaceC0689a, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29270a = null;
            this.f29271b = str;
            this.f29272c = str2;
            this.f29273d = str3;
            this.f29276g = z;
            this.f29275f = interfaceC0689a == null ? new a(this) : interfaceC0689a;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01e1  */
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
            JSONObject jSONObject;
            a.b d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.f29270a = new NetWork(TbConfig.LOGIN_FULL_ADDRESS);
                this.f29270a.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                this.f29270a.addPostData("bdusstoken", this.f29272c + "|" + this.f29273d);
                if (!StringUtils.isNull(this.f29274e)) {
                    this.f29270a.addPostData("stoken", this.f29274e);
                }
                this.f29270a.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                this.f29270a.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                this.f29270a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.f29270a.postNetData();
                if (!this.f29270a.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    accountData = null;
                } else {
                    s0 s0Var = new s0();
                    s0Var.c(postNetData);
                    accountData = new AccountData();
                    accountData.setAccount(s0Var.b().getUserName());
                    accountData.setPassword("");
                    accountData.setID(s0Var.b().getUserId());
                    String str = this.f29272c;
                    if (this.f29276g && (d2 = e.d(c.a.q0.s.l.a.b().d(str))) != null) {
                        str = d2.f14000a + "|" + d2.f14001b;
                    }
                    accountData.setBDUSS(str);
                    accountData.setPortrait(s0Var.b().getPortrait());
                    if (s0Var.b() != null && s0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(s0Var.b().getBaijiahaoInfo().avatar)) {
                        accountData.setBjhAvatar(s0Var.b().getBaijiahaoInfo().avatar);
                    }
                    accountData.setStoken(this.f29274e);
                    accountData.setIsActive(1);
                    if (s0Var.a() != null) {
                        accountData.setTbs(s0Var.a().getTbs());
                    }
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_SHOW_INIT_NAME_DIALOG);
                netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                if (accountData != null) {
                    netWork.addPostData("BDUSS", accountData.getBDUSS());
                    netWork.addPostData("stoken", c.a.q0.s.l.e.a(accountData));
                }
                String postNetData2 = netWork.postNetData();
                if (!netWork.getNetContext().getResponse().isRequestSuccess() || postNetData2 == null) {
                    i2 = 0;
                } else {
                    try {
                        jSONObject = new JSONObject(postNetData2);
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
                    } catch (JSONException e2) {
                        e = e2;
                        i3 = 0;
                    }
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                        if (accountData != null && jSONObject2 != null) {
                            accountData.setNameShow(jSONObject2.optString("name_show"));
                        }
                    } catch (JSONException e3) {
                        i3 = i2;
                        e = e3;
                        e.printStackTrace();
                        i2 = i3;
                        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i2 == 1);
                        return accountData;
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
                c.a.q0.s.z.a.a("account", -1L, 0, "cslogin_result", this.f29270a.getServerErrorCode(), this.f29270a.getErrorString(), new Object[0]);
                if (accountData != null && accountData.getBDUSS() != null) {
                    this.f29275f.c(accountData);
                    return;
                }
                String str = null;
                if (this.f29270a != null) {
                    str = this.f29270a.getErrorString();
                    i2 = this.f29270a.getServerErrorCode();
                }
                if (str == null) {
                    str = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.data_load_error);
                }
                this.f29275f.a(this.f29271b, i2, str);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                if (this.f29270a != null) {
                    this.f29270a.cancelNetConnect();
                }
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f29274e = str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f29275f.b(this.f29271b);
            }
        }
    }

    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0689a interfaceC0689a) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, str, str2, str3, str4, interfaceC0689a)) == null) {
            c.a.q0.s.l.e eVar = new c.a.q0.s.l.e();
            C1368b c1368b = new C1368b(str, str2, str3, interfaceC0689a, false);
            if (c.a.q0.s.l.e.b() && StringUtils.isNull(str4)) {
                eVar.c(str2, new a(c1368b, interfaceC0689a, str));
            } else {
                if (c.a.q0.s.l.e.b()) {
                    c1368b.d(str4);
                }
                c1368b.execute(new String[0]);
            }
            return c1368b;
        }
        return (BdAsyncTask) invokeLLLLL.objValue;
    }
}
