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
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.a.c;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager YR = new ReloginManager();
    private boolean YQ;
    private final ArrayList<HttpMessage> YS = new ArrayList<>();
    private final HttpMessageListener YT = new a(this, CmdConfigHttp.BG_LOGIN_HTTP_CMD);
    private final a.InterfaceC0042a YU = new b(this);

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.YT);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager vf() {
        return YR;
    }

    public void a(HttpMessage httpMessage) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_start", 0, "", new Object[0]);
        b(httpMessage);
        if (!this.YQ) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.qQ();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                e(currentAccountObj);
                return;
            }
            this.YQ = true;
            if (vj()) {
                a(this.YU);
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
        com.baidu.tbadk.core.a.b.qO();
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkCoreApplication.m411getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString(LoginActivityConfig.ACCOUNT, account);
        obtainMessage.setData(bundle);
        TbadkCoreApplication.m411getInst().handler.sendMessage(obtainMessage);
    }

    private void b(HttpMessage httpMessage) {
        if (!this.YS.contains(httpMessage)) {
            this.YS.add(httpMessage);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        d(0, bdUniqueId);
    }

    public void d(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.YS.iterator();
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
    public void vg() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.YS.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.YS.clear();
    }

    public boolean vh() {
        return this.YQ;
    }

    public void at(boolean z) {
        this.YQ = z;
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
                x xVar = new x();
                xVar.parserJson(jSONObject);
                String userId = xVar.getUser().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(t.j.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = xVar.getUser().getUserName();
                String password = xVar.getUser().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(xVar.getUser().getUserId());
                accountData.setBDUSS(xVar.getUser().getBDUSS());
                accountData.setPortrait(xVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (xVar.sf() != null) {
                    accountData.setTbs(xVar.sf().getTbs());
                }
                com.baidu.tbadk.core.a.b.b(accountData);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            }
        }
    }

    public AccountData vi() {
        c yn = com.baidu.tbadk.coreExtra.a.a.yn();
        if (yn != null) {
            return yn.vi();
        }
        return null;
    }

    private void a(a.InterfaceC0042a interfaceC0042a) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_start", 0, "", new Object[0]);
        c yn = com.baidu.tbadk.coreExtra.a.a.yn();
        if (yn != null) {
            yn.a(interfaceC0042a);
        }
    }

    public boolean vj() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen();
    }
}
