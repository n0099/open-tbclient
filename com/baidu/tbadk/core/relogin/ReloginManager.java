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
import com.baidu.tbadk.core.data.y;
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
    private static ReloginManager Uh = new ReloginManager();
    private boolean Ug;
    private final ArrayList<HttpMessage> Ui = new ArrayList<>();
    private final HttpMessageListener Uj = new a(this, CmdConfigHttp.BG_LOGIN_HTTP_CMD);
    private final a.InterfaceC0033a Uk = new b(this);

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.Uj);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager sL() {
        return Uh;
    }

    public void a(HttpMessage httpMessage) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_start", 0, "", new Object[0]);
        b(httpMessage);
        if (!this.Ug) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.on();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                e(currentAccountObj);
                return;
            }
            this.Ug = true;
            if (sP()) {
                a(this.Uk);
            } else {
                d(currentAccountObj);
            }
        }
    }

    private void d(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_local_start", 0, "", new Object[0]);
        MessageManager messageManager = MessageManager.getInstance();
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m11getInst().getApp().getApplicationContext());
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.BG_LOGIN_HTTP_CMD);
        httpMessage.addParam("un", accountData.getAccount());
        httpMessage.addParam("passwd", accountData.getPassword());
        httpMessage.addParam("isphone", "0");
        httpMessage.addParam("channel_id", TbadkCoreApplication.m11getInst().getPushChannelId());
        httpMessage.addParam("channel_uid", TbadkCoreApplication.m11getInst().getPushChannelUserId());
        messageManager.sendMessage(httpMessage);
    }

    public void e(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_foreground", 0, "", new Object[0]);
        com.baidu.tbadk.core.a.b.ol();
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkCoreApplication.m11getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString(LoginActivityConfig.ACCOUNT, account);
        obtainMessage.setData(bundle);
        TbadkCoreApplication.m11getInst().handler.sendMessage(obtainMessage);
    }

    private void b(HttpMessage httpMessage) {
        if (!this.Ui.contains(httpMessage)) {
            this.Ui.add(httpMessage);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        d(0, bdUniqueId);
    }

    public void d(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.Ui.iterator();
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
    public void sM() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.Ui.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.Ui.clear();
    }

    public boolean sN() {
        return this.Ug;
    }

    public void aw(boolean z) {
        this.Ug = z;
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
                y yVar = new y();
                yVar.parserJson(jSONObject);
                String userId = yVar.getUser().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkCoreApplication.m11getInst().getApp().getApplicationContext().getString(t.j.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = yVar.getUser().getUserName();
                String password = yVar.getUser().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(yVar.getUser().getUserId());
                accountData.setBDUSS(yVar.getUser().getBDUSS());
                accountData.setPortrait(yVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (yVar.pz() != null) {
                    accountData.setTbs(yVar.pz().getTbs());
                }
                com.baidu.tbadk.core.a.b.b(accountData);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m11getInst().getApp().getApplicationContext());
            }
        }
    }

    public AccountData sO() {
        c wg = com.baidu.tbadk.coreExtra.a.a.wg();
        if (wg != null) {
            return wg.sO();
        }
        return null;
    }

    private void a(a.InterfaceC0033a interfaceC0033a) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_start", 0, "", new Object[0]);
        c wg = com.baidu.tbadk.coreExtra.a.a.wg();
        if (wg != null) {
            wg.a(interfaceC0033a);
        }
    }

    public boolean sP() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.m11getInst().isPassportV6ShouldOpen();
    }
}
