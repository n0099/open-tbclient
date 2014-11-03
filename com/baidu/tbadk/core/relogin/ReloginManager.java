package com.baidu.tbadk.core.relogin;

import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.f;
import com.baidu.tbadk.core.account.g;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager BU = new ReloginManager();
    private boolean BT;
    private final ArrayList<HttpMessage> BV = new ArrayList<>();
    private final HttpMessageListener BW = new a(this, CmdConfigHttp.BG_LOGIN_HTTP_CMD);
    private final g BX = new b(this);

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.BW);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager lf() {
        return BU;
    }

    public void a(HttpMessage httpMessage) {
        b(httpMessage);
        if (!this.BT) {
            this.BT = true;
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.account.a.jA();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                d(currentAccountObj);
            } else if (lj()) {
                a(this.BX);
            } else {
                c(currentAccountObj);
            }
        }
    }

    private void c(AccountData accountData) {
        MessageManager messageManager = MessageManager.getInstance();
        TbadkApplication.setCurrentAccount(null, TbadkApplication.m251getInst().getApp().getApplicationContext());
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.BG_LOGIN_HTTP_CMD);
        httpMessage.addParam("un", accountData.getAccount());
        httpMessage.addParam("passwd", accountData.getPassword());
        httpMessage.addParam("isphone", "0");
        httpMessage.addParam("channel_id", TbadkApplication.m251getInst().getPushChannelId());
        httpMessage.addParam("channel_uid", TbadkApplication.m251getInst().getPushChannelUserId());
        messageManager.sendMessage(httpMessage);
    }

    public void d(AccountData accountData) {
        com.baidu.tbadk.core.account.a.jy();
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkApplication.m251getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString(LoginActivityConfig.ACCOUNT, account);
        obtainMessage.setData(bundle);
        TbadkApplication.m251getInst().handler.sendMessage(obtainMessage);
    }

    private void b(HttpMessage httpMessage) {
        if (!this.BV.contains(httpMessage)) {
            this.BV.add(httpMessage);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        c(0, bdUniqueId);
    }

    public void c(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.BV.iterator();
        while (it.hasNext()) {
            HttpMessage next = it.next();
            BdUniqueId tag = next.getTag();
            int cmd = next.getCmd();
            if ((i != 0 && tag == bdUniqueId && i == cmd) || (i == 0 && bdUniqueId != null && tag == bdUniqueId)) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.BV.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.BV.clear();
    }

    public boolean lh() {
        return this.BT;
    }

    public void T(boolean z) {
        this.BT = z;
    }

    /* loaded from: classes.dex */
    public class BgLoginHttpResponsedMessage extends JsonHttpResponsedMessage {
        public BgLoginHttpResponsedMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
            int statusCode = getStatusCode();
            int error = getError();
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (statusCode == 200 && error == 0) {
                j jVar = new j();
                jVar.parserJson(jSONObject);
                String userId = jVar.getUser().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkApplication.m251getInst().getApp().getApplicationContext().getString(y.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = jVar.getUser().getUserName();
                String password = jVar.getUser().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(jVar.getUser().getUserId());
                accountData.setBDUSS(jVar.getUser().getBDUSS());
                accountData.setPortrait(jVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (jVar.jZ() != null) {
                    accountData.setTbs(jVar.jZ().getTbs());
                }
                com.baidu.tbadk.core.account.a.a(accountData);
                TbadkApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkApplication.setCurrentAccount(accountData, TbadkApplication.m251getInst().getApp().getApplicationContext());
            }
        }
    }

    public AccountData li() {
        SapiAccount session;
        AccountData f;
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null || SapiAccountManager.getInstance().getAccountService().blockingRelogin(reloginCredentials) != 0 || (session = SapiAccountManager.getInstance().getSession()) == null || (f = f.f(session.username, session.bduss, session.ptoken)) == null) {
            return null;
        }
        com.baidu.tbadk.core.account.a.a(f);
        TbadkApplication.setBdussAndTbsFromBackgroundInRelogin(f, f.getBDUSS(), f.getTbs());
        TbadkApplication.setCurrentAccount(f, TbadkApplication.m251getInst().getApp().getApplicationContext());
        return f;
    }

    private void a(g gVar) {
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null) {
            d(TbadkApplication.getCurrentAccountObj());
        }
        SapiAccountManager.getInstance().getAccountService().relogin(new c(this, gVar), reloginCredentials);
    }

    public boolean lj() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkApplication.m251getInst().isPassportV6ShouldOpen();
    }
}
