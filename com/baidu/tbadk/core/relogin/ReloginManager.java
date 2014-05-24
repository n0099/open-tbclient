package com.baidu.tbadk.core.relogin;

import android.os.Bundle;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.i;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager b = new ReloginManager();
    private boolean a;
    private ArrayList<HttpMessage> c = new ArrayList<>();
    private HttpMessageListener d = new a(this, 1003001);

    private ReloginManager() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.d);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003001, TbConfig.SERVER_ADDRESS + TbConfig.LOGIN_ADDRESS);
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
        c(httpMessage);
        if (!this.a) {
            this.a = true;
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.account.a.c();
            }
            if (currentAccountObj == null) {
                b(currentAccountObj);
            } else {
                a(currentAccountObj);
            }
        }
    }

    private void a(AccountData accountData) {
        MessageManager messageManager = MessageManager.getInstance();
        TbadkApplication.setCurrentAccount(null, TbadkApplication.m252getInst().getApp().getApplicationContext());
        HttpMessage httpMessage = new HttpMessage(1003001);
        httpMessage.addParam("un", accountData.getAccount());
        httpMessage.addParam("passwd", accountData.getPassword());
        httpMessage.addParam("isphone", "0");
        httpMessage.addParam("channel_id", TbadkApplication.m252getInst().getPushChannelId());
        httpMessage.addParam("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
        messageManager.sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AccountData accountData) {
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkApplication.m252getInst().handler.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString("account", account);
        obtainMessage.setData(bundle);
        TbadkApplication.m252getInst().handler.sendMessage(obtainMessage);
    }

    private void c(HttpMessage httpMessage) {
        if (!this.c.contains(httpMessage)) {
            this.c.add(httpMessage);
        }
    }

    public void b(HttpMessage httpMessage) {
        if (this.c.contains(httpMessage)) {
            this.c.remove(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
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
                i iVar = new i();
                iVar.a(jSONObject);
                String userId = iVar.a().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkApplication.m252getInst().getApp().getApplicationContext().getString(y.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = iVar.a().getUserName();
                String password = iVar.a().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(iVar.a().getUserId());
                accountData.setBDUSS(iVar.a().getBDUSS());
                accountData.setPortrait(iVar.a().getPortrait());
                accountData.setIsActive(1);
                if (iVar.b() != null) {
                    accountData.setTbs(iVar.b().getTbs());
                }
                com.baidu.tbadk.core.account.a.a(accountData);
                TbadkApplication.setCurrentAccount(accountData, TbadkApplication.m252getInst().getApp().getApplicationContext());
            }
        }
    }
}
