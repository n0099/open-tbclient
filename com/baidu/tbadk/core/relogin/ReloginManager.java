package com.baidu.tbadk.core.relogin;

import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.b;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.d.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.a.c;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager adY = new ReloginManager();
    private boolean adX;
    private final ArrayList<HttpMessage> adZ = new ArrayList<>();
    private final HttpMessageListener aea = new HttpMessageListener(CmdConfigHttp.BG_LOGIN_HTTP_CMD) { // from class: com.baidu.tbadk.core.relogin.ReloginManager.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof BgLoginHttpResponsedMessage)) {
                ReloginManager.this.adX = false;
                BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (BgLoginHttpResponsedMessage) httpResponsedMessage;
                int statusCode = bgLoginHttpResponsedMessage.getStatusCode();
                int error = bgLoginHttpResponsedMessage.getError();
                a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_local_result", bgLoginHttpResponsedMessage.getError(), bgLoginHttpResponsedMessage.getErrorString(), new Object[0]);
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    ReloginManager.this.uv();
                    return;
                }
                ReloginManager.this.f(TbadkCoreApplication.getCurrentAccountObj());
                if (bgLoginHttpResponsedMessage.getErrorString() != null) {
                    k.showToast(TbadkCoreApplication.getInst().getContext(), bgLoginHttpResponsedMessage.getErrorString());
                }
                ReloginManager.this.adZ.clear();
            }
        }
    };
    private final a.InterfaceC0043a aeb = new a.InterfaceC0043a() { // from class: com.baidu.tbadk.core.relogin.ReloginManager.2
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0043a
        public void cp(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0043a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_success", 0, "", new Object[0]);
            ReloginManager.this.adX = false;
            if (accountData != null) {
                b.b(accountData);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
                ReloginManager.this.uv();
                return;
            }
            ReloginManager.this.f(TbadkCoreApplication.getCurrentAccountObj());
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0043a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_fail", i, str2, "uname", str);
            ReloginManager.this.adX = false;
            if (i == 1) {
                ReloginManager.this.f(TbadkCoreApplication.getCurrentAccountObj());
            }
        }
    };

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.aea);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager uu() {
        return adY;
    }

    public void a(HttpMessage httpMessage) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_start", 0, "", new Object[0]);
        b(httpMessage);
        if (!this.adX) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = b.pe();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                f(currentAccountObj);
                return;
            }
            this.adX = true;
            if (uy()) {
                a(this.aeb);
            } else {
                e(currentAccountObj);
            }
        }
    }

    private void e(AccountData accountData) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_local_start", 0, "", new Object[0]);
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

    public void f(AccountData accountData) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_foreground", 0, "", new Object[0]);
        b.pc();
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkCoreApplication.getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString(LoginActivityConfig.ACCOUNT, account);
        obtainMessage.setData(bundle);
        TbadkCoreApplication.getInst().handler.sendMessage(obtainMessage);
    }

    private void b(HttpMessage httpMessage) {
        if (!this.adZ.contains(httpMessage)) {
            this.adZ.add(httpMessage);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        d(0, bdUniqueId);
    }

    public void d(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.adZ.iterator();
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
    public void uv() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.adZ.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.adZ.clear();
    }

    public boolean uw() {
        return this.adX;
    }

    public void az(boolean z) {
        this.adX = z;
    }

    /* loaded from: classes.dex */
    public static class BgLoginHttpResponsedMessage extends JsonHttpResponsedMessage {
        public BgLoginHttpResponsedMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
            int statusCode = getStatusCode();
            int error = getError();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (statusCode == 200 && error == 0) {
                ak akVar = new ak();
                akVar.parserJson(jSONObject);
                String userId = akVar.getUser().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = akVar.getUser().getUserName();
                String password = akVar.getUser().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(akVar.getUser().getUserId());
                accountData.setBDUSS(akVar.getUser().getBDUSS());
                accountData.setPortrait(akVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (akVar.qn() != null) {
                    accountData.setTbs(akVar.qn().getTbs());
                }
                b.b(accountData);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            }
        }
    }

    public AccountData ux() {
        c xO = com.baidu.tbadk.coreExtra.a.a.xO();
        if (xO != null) {
            return xO.ux();
        }
        return null;
    }

    private void a(a.InterfaceC0043a interfaceC0043a) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_start", 0, "", new Object[0]);
        c xO = com.baidu.tbadk.coreExtra.a.a.xO();
        if (xO != null) {
            xO.a(interfaceC0043a);
        }
    }

    public boolean uy() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.getInst().isPassportV6ShouldOpen();
    }
}
