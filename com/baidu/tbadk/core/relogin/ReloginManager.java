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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.f;
import com.baidu.tbadk.core.account.g;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager Gf = new ReloginManager();
    private boolean Ge;
    private final ArrayList<HttpMessage> Gg = new ArrayList<>();
    private final HttpMessageListener Gh = new a(this, CmdConfigHttp.BG_LOGIN_HTTP_CMD);
    private final g Gi = new b(this);

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.Gh);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager nX() {
        return Gf;
    }

    public void a(HttpMessage httpMessage) {
        b(httpMessage);
        if (!this.Ge) {
            this.Ge = true;
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.account.a.md();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                d(currentAccountObj);
            } else if (ob()) {
                a(this.Gi);
            } else {
                c(currentAccountObj);
            }
        }
    }

    private void c(AccountData accountData) {
        MessageManager messageManager = MessageManager.getInstance();
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.BG_LOGIN_HTTP_CMD);
        httpMessage.addParam("un", accountData.getAccount());
        httpMessage.addParam("passwd", accountData.getPassword());
        httpMessage.addParam("isphone", "0");
        httpMessage.addParam("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
        httpMessage.addParam("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
        messageManager.sendMessage(httpMessage);
    }

    public void d(AccountData accountData) {
        com.baidu.tbadk.core.account.a.mb();
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkCoreApplication.m255getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString(LoginActivityConfig.ACCOUNT, account);
        obtainMessage.setData(bundle);
        TbadkCoreApplication.m255getInst().handler.sendMessage(obtainMessage);
    }

    private void b(HttpMessage httpMessage) {
        if (!this.Gg.contains(httpMessage)) {
            this.Gg.add(httpMessage);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        d(0, bdUniqueId);
    }

    public void d(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.Gg.iterator();
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
    public void nY() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.Gg.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.Gg.clear();
    }

    public boolean nZ() {
        return this.Ge;
    }

    public void am(boolean z) {
        this.Ge = z;
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
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (statusCode == 200 && error == 0) {
                n nVar = new n();
                nVar.parserJson(jSONObject);
                String userId = nVar.getUser().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkCoreApplication.m255getInst().getApp().getApplicationContext().getString(z.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = nVar.getUser().getUserName();
                String password = nVar.getUser().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(nVar.getUser().getUserId());
                accountData.setBDUSS(nVar.getUser().getBDUSS());
                accountData.setPortrait(nVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (nVar.mK() != null) {
                    accountData.setTbs(nVar.mK().getTbs());
                }
                com.baidu.tbadk.core.account.a.a(accountData);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
            }
        }
    }

    public AccountData oa() {
        SapiAccount session;
        AccountData h;
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null || SapiAccountManager.getInstance().getAccountService().blockingRelogin(reloginCredentials) != 0 || (session = SapiAccountManager.getInstance().getSession()) == null || (h = f.h(session.username, session.bduss, session.ptoken)) == null) {
            return null;
        }
        com.baidu.tbadk.core.account.a.a(h);
        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(h, h.getBDUSS(), h.getTbs());
        TbadkCoreApplication.setCurrentAccount(h, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
        return h;
    }

    private void a(g gVar) {
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null) {
            d(TbadkCoreApplication.getCurrentAccountObj());
        }
        SapiAccountManager.getInstance().getAccountService().relogin(new c(this, gVar), reloginCredentials);
    }

    public boolean ob() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.m255getInst().isPassportV6ShouldOpen();
    }
}
