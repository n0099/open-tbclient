package com.baidu.tbadk.core.relogin;

import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.a.c;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager XT = new ReloginManager();
    private boolean XS;
    private final ArrayList<HttpMessage> XU = new ArrayList<>();
    private final HttpMessageListener XV = new a(this, CmdConfigHttp.BG_LOGIN_HTTP_CMD);
    private final a.InterfaceC0040a XW = new b(this);

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.XV);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager tp() {
        return XT;
    }

    public void a(HttpMessage httpMessage) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_start", 0, "", new Object[0]);
        b(httpMessage);
        if (!this.XS) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.rf();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                e(currentAccountObj);
                return;
            }
            this.XS = true;
            if (tt()) {
                a(this.XW);
            } else {
                d(currentAccountObj);
            }
        }
    }

    private void d(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_local_start", 0, "", new Object[0]);
        MessageManager messageManager = MessageManager.getInstance();
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.BG_LOGIN_HTTP_CMD);
        httpMessage.addParam("un", accountData.getAccount());
        httpMessage.addParam("passwd", accountData.getPassword());
        httpMessage.addParam("isphone", "0");
        httpMessage.addParam("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        httpMessage.addParam("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        messageManager.sendMessage(httpMessage);
    }

    public void e(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_foreground", 0, "", new Object[0]);
        com.baidu.tbadk.core.a.b.rd();
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkCoreApplication.m411getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString(LoginActivityConfig.ACCOUNT, account);
        obtainMessage.setData(bundle);
        TbadkCoreApplication.m411getInst().handler.sendMessage(obtainMessage);
    }

    private void b(HttpMessage httpMessage) {
        if (!this.XU.contains(httpMessage)) {
            this.XU.add(httpMessage);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        d(0, bdUniqueId);
    }

    public void d(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.XU.iterator();
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
    public void tq() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.XU.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.XU.clear();
    }

    public boolean tr() {
        return this.XS;
    }

    public void aq(boolean z) {
        this.XS = z;
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
                l lVar = new l();
                lVar.parserJson(jSONObject);
                String userId = lVar.getUser().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.h.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = lVar.getUser().getUserName();
                String password = lVar.getUser().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(lVar.getUser().getUserId());
                accountData.setBDUSS(lVar.getUser().getBDUSS());
                accountData.setPortrait(lVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (lVar.rE() != null) {
                    accountData.setTbs(lVar.rE().getTbs());
                }
                com.baidu.tbadk.core.a.b.b(accountData);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            }
        }
    }

    public AccountData ts() {
        c vY = com.baidu.tbadk.coreExtra.a.a.vY();
        if (vY != null) {
            return vY.ts();
        }
        return null;
    }

    private void a(a.InterfaceC0040a interfaceC0040a) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_start", 0, "", new Object[0]);
        c vY = com.baidu.tbadk.coreExtra.a.a.vY();
        if (vY != null) {
            vY.a(interfaceC0040a);
        }
    }

    public boolean tt() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen();
    }
}
