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
import com.baidu.tbadk.core.a.d;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.act.l;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager SR = new ReloginManager();
    private boolean SQ;
    private final ArrayList<HttpMessage> SS = new ArrayList<>();
    private final HttpMessageListener SU = new a(this, CmdConfigHttp.BG_LOGIN_HTTP_CMD);
    private final com.baidu.tbadk.core.a.b SV = new b(this);

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.SU);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager sg() {
        return SR;
    }

    public void a(HttpMessage httpMessage) {
        b(httpMessage);
        if (!this.SQ) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = d.qm();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                e(currentAccountObj);
                return;
            }
            this.SQ = true;
            if (sk()) {
                a(this.SV);
            } else {
                d(currentAccountObj);
            }
        }
    }

    private void d(AccountData accountData) {
        MessageManager messageManager = MessageManager.getInstance();
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.BG_LOGIN_HTTP_CMD);
        httpMessage.addParam("un", accountData.getAccount());
        httpMessage.addParam("passwd", accountData.getPassword());
        httpMessage.addParam("isphone", GameInfoData.NOT_FROM_DETAIL);
        httpMessage.addParam("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        httpMessage.addParam("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        messageManager.sendMessage(httpMessage);
    }

    public void e(AccountData accountData) {
        d.qk();
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkCoreApplication.m411getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString(LoginActivityConfig.ACCOUNT, account);
        obtainMessage.setData(bundle);
        TbadkCoreApplication.m411getInst().handler.sendMessage(obtainMessage);
    }

    private void b(HttpMessage httpMessage) {
        if (!this.SS.contains(httpMessage)) {
            this.SS.add(httpMessage);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        d(0, bdUniqueId);
    }

    public void d(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.SS.iterator();
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
    public void sh() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.SS.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.SS.clear();
    }

    public boolean si() {
        return this.SQ;
    }

    public void am(boolean z) {
        this.SQ = z;
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
                    setErrorString(TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(t.neterror));
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
                if (nVar.qK() != null) {
                    accountData.setTbs(nVar.qK().getTbs());
                }
                d.b(accountData);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            }
        }
    }

    public AccountData sj() {
        l uV = com.baidu.tbadk.coreExtra.act.a.uV();
        if (uV != null) {
            return uV.sj();
        }
        return null;
    }

    private void a(com.baidu.tbadk.core.a.b bVar) {
        l uV = com.baidu.tbadk.coreExtra.act.a.uV();
        if (uV != null) {
            uV.a(bVar);
        }
    }

    public boolean sk() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen();
    }
}
