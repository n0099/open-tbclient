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
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager b = new ReloginManager();
    private boolean a;
    private final ArrayList<HttpMessage> c = new ArrayList<>();
    private final HttpMessageListener d = new a(this, CmdConfigHttp.BG_LOGIN_HTTP_CMD);
    private final g e = new b(this);

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.d);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager a() {
        return b;
    }

    public void a(HttpMessage httpMessage) {
        b(httpMessage);
        if (!this.a) {
            this.a = true;
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.account.a.c();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                a(currentAccountObj);
            } else if (d()) {
                a(this.e);
            } else {
                b(currentAccountObj);
            }
        }
    }

    private void b(AccountData accountData) {
        MessageManager messageManager = MessageManager.getInstance();
        TbadkApplication.setCurrentAccount(null, TbadkApplication.m252getInst().getApp().getApplicationContext());
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.BG_LOGIN_HTTP_CMD);
        httpMessage.addParam("un", accountData.getAccount());
        httpMessage.addParam("passwd", accountData.getPassword());
        httpMessage.addParam("isphone", "0");
        httpMessage.addParam("channel_id", TbadkApplication.m252getInst().getPushChannelId());
        httpMessage.addParam("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
        messageManager.sendMessage(httpMessage);
    }

    public void a(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a();
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkApplication.m252getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString("account", account);
        obtainMessage.setData(bundle);
        TbadkApplication.m252getInst().handler.sendMessage(obtainMessage);
    }

    private void b(HttpMessage httpMessage) {
        if (!this.c.contains(httpMessage)) {
            this.c.add(httpMessage);
        }
    }

    public void a(BdUniqueId bdUniqueId) {
        a(0, bdUniqueId);
    }

    public void a(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.c.iterator();
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
    public void e() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.c.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.c.clear();
    }

    public boolean b() {
        return this.a;
    }

    public void a(boolean z) {
        this.a = z;
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
                jVar.a(jSONObject);
                String userId = jVar.a().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkApplication.m252getInst().getApp().getApplicationContext().getString(x.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = jVar.a().getUserName();
                String password = jVar.a().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(jVar.a().getUserId());
                accountData.setBDUSS(jVar.a().getBDUSS());
                accountData.setPortrait(jVar.a().getPortrait());
                accountData.setIsActive(1);
                if (jVar.b() != null) {
                    accountData.setTbs(jVar.b().getTbs());
                }
                com.baidu.tbadk.core.account.a.a(accountData);
                TbadkApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkApplication.setCurrentAccount(accountData, TbadkApplication.m252getInst().getApp().getApplicationContext());
            }
        }
    }

    public AccountData c() {
        SapiAccount session;
        AccountData a;
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null || SapiAccountManager.getInstance().getAccountService().blockingRelogin(reloginCredentials) != 0 || (session = SapiAccountManager.getInstance().getSession()) == null || (a = f.a(session.username, session.bduss, session.ptoken)) == null) {
            return null;
        }
        com.baidu.tbadk.core.account.a.a(a);
        TbadkApplication.setBdussAndTbsFromBackgroundInRelogin(a, a.getBDUSS(), a.getTbs());
        TbadkApplication.setCurrentAccount(a, TbadkApplication.m252getInst().getApp().getApplicationContext());
        return a;
    }

    private void a(g gVar) {
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null) {
            a(TbadkApplication.getCurrentAccountObj());
        }
        SapiAccountManager.getInstance().getAccountService().relogin(new c(this, gVar), reloginCredentials);
    }

    public boolean d() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkApplication.m252getInst().isPassportV6ShouldOpen();
    }
}
