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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.b;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.d.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager aTJ = new ReloginManager();
    private boolean aTI;
    private final ArrayList<HttpMessage> aTK = new ArrayList<>();
    private final HttpMessageListener aTL = new HttpMessageListener(CmdConfigHttp.BG_LOGIN_HTTP_CMD) { // from class: com.baidu.tbadk.core.relogin.ReloginManager.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof BgLoginHttpResponsedMessage)) {
                ReloginManager.this.aTI = false;
                BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (BgLoginHttpResponsedMessage) httpResponsedMessage;
                int statusCode = bgLoginHttpResponsedMessage.getStatusCode();
                int error = bgLoginHttpResponsedMessage.getError();
                a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_local_result", bgLoginHttpResponsedMessage.getError(), bgLoginHttpResponsedMessage.getErrorString(), new Object[0]);
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    ReloginManager.this.BL();
                    return;
                }
                ReloginManager.this.e(TbadkCoreApplication.getCurrentAccountObj());
                if (bgLoginHttpResponsedMessage.getErrorString() != null) {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), bgLoginHttpResponsedMessage.getErrorString());
                }
                ReloginManager.this.aTK.clear();
            }
        }
    };

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.aTL);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager BK() {
        return aTJ;
    }

    public void a(HttpMessage httpMessage) {
        a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_start", 0, "", new Object[0]);
        b(httpMessage);
        if (!this.aTI) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = b.xz();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                e(currentAccountObj);
                return;
            }
            this.aTI = true;
            if (!BN()) {
                d(currentAccountObj);
            }
        }
    }

    private void d(AccountData accountData) {
        a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_local_start", 0, "", new Object[0]);
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

    public void e(AccountData accountData) {
        a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_foreground", 0, "", new Object[0]);
        b.xx();
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkCoreApplication.getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString(LoginActivityConfig.ACCOUNT, account);
        obtainMessage.setData(bundle);
        TbadkCoreApplication.getInst().handler.sendMessage(obtainMessage);
    }

    private void b(HttpMessage httpMessage) {
        if (!this.aTK.contains(httpMessage)) {
            this.aTK.add(httpMessage);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        d(0, bdUniqueId);
    }

    public void d(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.aTK.iterator();
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
    public void BL() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.aTK.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.aTK.clear();
    }

    public boolean BM() {
        return this.aTI;
    }

    public void bi(boolean z) {
        this.aTI = z;
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
                ae aeVar = new ae();
                aeVar.parserJson(jSONObject);
                String userId = aeVar.getUser().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = aeVar.getUser().getUserName();
                String password = aeVar.getUser().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(aeVar.getUser().getUserId());
                accountData.setBDUSS(aeVar.getUser().getBDUSS());
                accountData.setPortrait(aeVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (aeVar.yn() != null) {
                    accountData.setTbs(aeVar.yn().getTbs());
                }
                b.b(accountData);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            }
        }
    }

    public boolean BN() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.getInst().isPassportV6ShouldOpen();
    }
}
