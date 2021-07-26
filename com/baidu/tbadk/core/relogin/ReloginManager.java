package com.baidu.tbadk.core.relogin;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.l.c;
import d.a.p0.s.q.r0;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ReloginManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static ReloginManager f12375d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12376a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<HttpMessage> f12377b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f12378c;

    /* loaded from: classes3.dex */
    public static class BgLoginHttpResponsedMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BgLoginHttpResponsedMessage(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
                int statusCode = getStatusCode();
                int error = getError();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (statusCode == 200 && error == 0) {
                    r0 r0Var = new r0();
                    r0Var.d(jSONObject);
                    String userId = r0Var.b().getUserId();
                    if (userId != null && userId.length() > 0) {
                        AccountData accountData = new AccountData();
                        String userName = r0Var.b().getUserName();
                        String password = r0Var.b().getPassword();
                        accountData.setAccount(userName);
                        if (password != null) {
                            accountData.setPassword(password);
                        } else {
                            accountData.setPassword(currentAccountObj.getPassword());
                        }
                        accountData.setID(r0Var.b().getUserId());
                        accountData.setBDUSS(r0Var.b().getBDUSS());
                        accountData.setPortrait(r0Var.b().getPortrait());
                        if (r0Var.b() != null && r0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(r0Var.b().getBaijiahaoInfo().avatar)) {
                            accountData.setBjhAvatar(r0Var.b().getBaijiahaoInfo().avatar);
                        }
                        accountData.setIsActive(1);
                        if (r0Var.a() != null) {
                            accountData.setTbs(r0Var.a().getTbs());
                        }
                        d.a.p0.s.z.a.a("account", -1L, 0, "relogin_manager_save_account_to_db", 0, "", new Object[0]);
                        c.g(accountData);
                        d.a.p0.s.z.a.a("account", -1L, 0, "relogin_manager_save_account_to_application", 0, "", new Object[0]);
                        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                        TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
                        return;
                    }
                    setErrorString(TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReloginManager f12379a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReloginManager reloginManager, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reloginManager, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12379a = reloginManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof BgLoginHttpResponsedMessage)) {
                this.f12379a.f12376a = false;
                BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (BgLoginHttpResponsedMessage) httpResponsedMessage;
                int statusCode = bgLoginHttpResponsedMessage.getStatusCode();
                int error = bgLoginHttpResponsedMessage.getError();
                d.a.p0.s.z.a.a("account", -1L, 0, "login_auto_local_result", bgLoginHttpResponsedMessage.getError(), bgLoginHttpResponsedMessage.getErrorString(), new Object[0]);
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    this.f12379a.j();
                    return;
                }
                this.f12379a.f(TbadkCoreApplication.getCurrentAccountObj());
                if (bgLoginHttpResponsedMessage.getErrorString() != null) {
                    l.M(TbadkCoreApplication.getInst().getContext(), bgLoginHttpResponsedMessage.getErrorString());
                }
                this.f12379a.f12377b.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2069537314, "Lcom/baidu/tbadk/core/relogin/ReloginManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2069537314, "Lcom/baidu/tbadk/core/relogin/ReloginManager;");
                return;
            }
        }
        f12375d = new ReloginManager();
    }

    public ReloginManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12377b = new ArrayList<>();
        this.f12378c = new a(this, CmdConfigHttp.BG_LOGIN_HTTP_CMD);
    }

    public static ReloginManager g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f12375d : (ReloginManager) invokeV.objValue;
    }

    public final void d(HttpMessage httpMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, httpMessage) == null) || this.f12377b.contains(httpMessage)) {
            return;
        }
        this.f12377b.add(httpMessage);
    }

    public final void e(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountData) == null) {
            d.a.p0.s.z.a.a("account", -1L, 0, "login_auto_local_start", 0, "", new Object[0]);
            MessageManager messageManager = MessageManager.getInstance();
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.BG_LOGIN_HTTP_CMD);
            httpMessage.addParam("un", accountData.getAccount());
            httpMessage.addParam("passwd", accountData.getPassword());
            httpMessage.addParam("isphone", "0");
            httpMessage.addParam("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            httpMessage.addParam("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            messageManager.sendMessage(httpMessage);
        }
    }

    public void f(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            d.a.p0.s.z.a.a("account", -1L, 0, "login_auto_foreground", 0, "", new Object[0]);
            c.b();
            TbadkCoreApplication.getInst().handler.sendMessage(TbadkCoreApplication.getInst().handler.obtainMessage(1));
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12376a : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.getInst().isPassportV6ShouldOpen() : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            Iterator<HttpMessage> it = this.f12377b.iterator();
            while (it.hasNext()) {
                messageManager.sendMessage(it.next());
            }
            this.f12377b.clear();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.registerListener(this.f12378c);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
            tbHttpMessageTask.setNeedGzip(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void l(HttpMessage httpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, httpMessage) == null) {
            d.a.p0.s.z.a.a("account", -1L, 0, "login_auto_start", 0, "", new Object[0]);
            d(httpMessage);
            if (this.f12376a) {
                return;
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = c.e();
            }
            if (currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getAccount())) {
                this.f12376a = true;
                if (i()) {
                    return;
                }
                e(currentAccountObj);
                return;
            }
            f(currentAccountObj);
        }
    }

    public void m(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, bdUniqueId) == null) {
            Iterator<HttpMessage> it = this.f12377b.iterator();
            while (it.hasNext()) {
                HttpMessage next = it.next();
                BdUniqueId tag = next.getTag();
                int cmd = next.getCmd();
                if ((i2 != 0 && tag == bdUniqueId && i2 == cmd) || (i2 == 0 && bdUniqueId != null && tag == bdUniqueId)) {
                    it.remove();
                }
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            m(0, bdUniqueId);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f12376a = z;
        }
    }
}
