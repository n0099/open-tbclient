package com.baidu.tbadk.core.relogin;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountStorage;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.x25;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ReloginManager {
    public static /* synthetic */ Interceptable $ic;
    public static ReloginManager d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final ArrayList<HttpMessage> b;
    public final HttpMessageListener c;

    /* loaded from: classes4.dex */
    public static class BgLoginHttpResponsedMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BgLoginHttpResponsedMessage(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
                int statusCode = getStatusCode();
                int error = getError();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (statusCode == 200 && error == 0) {
                    x25 x25Var = new x25();
                    x25Var.e(jSONObject);
                    String userId = x25Var.c().getUserId();
                    if (userId != null && userId.length() > 0) {
                        AccountData accountData = new AccountData();
                        String userName = x25Var.c().getUserName();
                        String password = x25Var.c().getPassword();
                        accountData.setAccount(userName);
                        if (password != null) {
                            accountData.setPassword(password);
                        } else {
                            accountData.setPassword(currentAccountObj.getPassword());
                        }
                        accountData.setID(x25Var.c().getUserId());
                        accountData.setBDUSS(x25Var.c().getBDUSS());
                        accountData.setPortrait(x25Var.c().getPortrait());
                        accountData.setIsActive(1);
                        if (x25Var.a() != null) {
                            accountData.setTbs(x25Var.a().getTbs());
                        }
                        accountData.setGrowthSwitch(x25Var.b());
                        Logger.addLog("account", -1L, 0, "relogin_manager_save_account_to_db", 0, "", new Object[0]);
                        AccountStorage.saveAccountData(accountData);
                        Logger.addLog("account", -1L, 0, "relogin_manager_save_account_to_application", 0, "", new Object[0]);
                        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                        TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
                        return;
                    }
                    setErrorString(TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f0e40));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReloginManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReloginManager reloginManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reloginManager, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = reloginManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || !(httpResponsedMessage instanceof BgLoginHttpResponsedMessage)) {
                return;
            }
            this.a.a = false;
            BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (BgLoginHttpResponsedMessage) httpResponsedMessage;
            int statusCode = bgLoginHttpResponsedMessage.getStatusCode();
            int error = bgLoginHttpResponsedMessage.getError();
            Logger.addLog("account", -1L, 0, "login_auto_local_result", bgLoginHttpResponsedMessage.getError(), bgLoginHttpResponsedMessage.getErrorString(), new Object[0]);
            if ((statusCode == 200 && error != 0) || statusCode != 200) {
                this.a.f(TbadkCoreApplication.getCurrentAccountObj());
                if (bgLoginHttpResponsedMessage.getErrorString() != null) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), bgLoginHttpResponsedMessage.getErrorString());
                }
                this.a.b.clear();
                return;
            }
            this.a.j();
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
        d = new ReloginManager();
    }

    public static ReloginManager g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return d;
        }
        return (ReloginManager) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            Iterator<HttpMessage> it = this.b.iterator();
            while (it.hasNext()) {
                messageManager.sendMessage(it.next());
            }
            this.b.clear();
        }
    }

    public ReloginManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>();
        this.c = new a(this, CmdConfigHttp.BG_LOGIN_HTTP_CMD);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.registerListener(this.c);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
            tbHttpMessageTask.setNeedGzip(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void d(HttpMessage httpMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, httpMessage) == null) && !this.b.contains(httpMessage)) {
            this.b.add(httpMessage);
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
            this.a = z;
        }
    }

    public final void e(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountData) == null) {
            Logger.addLog("account", -1L, 0, "login_auto_local_start", 0, "", new Object[0]);
            MessageManager messageManager = MessageManager.getInstance();
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.BG_LOGIN_HTTP_CMD);
            httpMessage.addParam("un", accountData.getAccount());
            httpMessage.addParam("passwd", accountData.getPassword());
            httpMessage.addParam("isphone", "0");
            httpMessage.addParam("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            httpMessage.addParam("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            httpMessage.addParam("first_login", TbadkCoreApplication.getInst().getDeviceIsFirstLogin());
            messageManager.sendMessage(httpMessage);
        }
    }

    public void f(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            Logger.addLog("account", -1L, 0, "login_auto_foreground", 0, "", new Object[0]);
            AccountStorage.clearActiveAccount();
            TbadkCoreApplication.getInst().handler.sendMessage(TbadkCoreApplication.getInst().handler.obtainMessage(1));
        }
    }

    public void l(HttpMessage httpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, httpMessage) == null) {
            Logger.addLog("account", -1L, 0, "login_auto_start", 0, "", new Object[0]);
            d(httpMessage);
            if (this.a) {
                return;
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = AccountStorage.getActiveAccountData();
            }
            if (currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getAccount())) {
                this.a = true;
                if (!i()) {
                    e(currentAccountObj);
                    return;
                }
                return;
            }
            f(currentAccountObj);
        }
    }

    public void m(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, bdUniqueId) == null) {
            Iterator<HttpMessage> it = this.b.iterator();
            while (it.hasNext()) {
                HttpMessage next = it.next();
                BdUniqueId tag = next.getTag();
                int cmd = next.getCmd();
                if ((i != 0 && tag == bdUniqueId && i == cmd) || (i == 0 && bdUniqueId != null && tag == bdUniqueId)) {
                    it.remove();
                }
            }
        }
    }
}
