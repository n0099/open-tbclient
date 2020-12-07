package com.baidu.tbadk.core.relogin;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.b;
import com.baidu.tbadk.core.d.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ReloginManager {
    private static ReloginManager eQQ = new ReloginManager();
    private boolean eQP;
    private final ArrayList<HttpMessage> eQR = new ArrayList<>();
    private final HttpMessageListener eQS = new HttpMessageListener(1001101) { // from class: com.baidu.tbadk.core.relogin.ReloginManager.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof BgLoginHttpResponsedMessage)) {
                ReloginManager.this.eQP = false;
                BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (BgLoginHttpResponsedMessage) httpResponsedMessage;
                int statusCode = bgLoginHttpResponsedMessage.getStatusCode();
                int error = bgLoginHttpResponsedMessage.getError();
                a.a("account", -1L, 0, "login_auto_local_result", bgLoginHttpResponsedMessage.getError(), bgLoginHttpResponsedMessage.getErrorString(), new Object[0]);
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    ReloginManager.this.bsH();
                    return;
                }
                ReloginManager.this.e(TbadkCoreApplication.getCurrentAccountObj());
                if (bgLoginHttpResponsedMessage.getErrorString() != null) {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), bgLoginHttpResponsedMessage.getErrorString());
                }
                ReloginManager.this.eQR.clear();
            }
        }
    };

    private ReloginManager() {
    }

    public void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.eQS);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001101, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static ReloginManager bsG() {
        return eQQ;
    }

    public void a(HttpMessage httpMessage) {
        a.a("account", -1L, 0, "login_auto_start", 0, "", new Object[0]);
        b(httpMessage);
        if (!this.eQP) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = b.blZ();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                e(currentAccountObj);
                return;
            }
            this.eQP = true;
            if (!bsJ()) {
                d(currentAccountObj);
            }
        }
    }

    private void d(AccountData accountData) {
        a.a("account", -1L, 0, "login_auto_local_start", 0, "", new Object[0]);
        MessageManager messageManager = MessageManager.getInstance();
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
        HttpMessage httpMessage = new HttpMessage(1001101);
        httpMessage.addParam("un", accountData.getAccount());
        httpMessage.addParam("passwd", accountData.getPassword());
        httpMessage.addParam("isphone", "0");
        httpMessage.addParam(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
        httpMessage.addParam("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
        messageManager.sendMessage(httpMessage);
    }

    public void e(AccountData accountData) {
        a.a("account", -1L, 0, "login_auto_foreground", 0, "", new Object[0]);
        b.blX();
        TbadkCoreApplication.getInst().handler.sendMessage(TbadkCoreApplication.getInst().handler.obtainMessage(1));
    }

    private void b(HttpMessage httpMessage) {
        if (!this.eQR.contains(httpMessage)) {
            this.eQR.add(httpMessage);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        d(0, bdUniqueId);
    }

    public void d(int i, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.eQR.iterator();
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
    public void bsH() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.eQR.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.eQR.clear();
    }

    public boolean bsI() {
        return this.eQP;
    }

    public void jp(boolean z) {
        this.eQP = z;
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
                ap apVar = new ap();
                apVar.parserJson(jSONObject);
                String userId = apVar.getUser().getUserId();
                if (userId == null || userId.length() <= 0) {
                    setErrorString(TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = apVar.getUser().getUserName();
                String password = apVar.getUser().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(currentAccountObj.getPassword());
                }
                accountData.setID(apVar.getUser().getUserId());
                accountData.setBDUSS(apVar.getUser().getBDUSS());
                accountData.setPortrait(apVar.getUser().getPortrait());
                if (apVar.getUser() != null && apVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(apVar.getUser().getBaijiahaoInfo().avatar)) {
                    accountData.setBjhAvatar(apVar.getUser().getBaijiahaoInfo().avatar);
                }
                accountData.setIsActive(1);
                if (apVar.getAnti() != null) {
                    accountData.setTbs(apVar.getAnti().getTbs());
                }
                a.a("account", -1L, 0, "relogin_manager_save_account_to_db", 0, "", new Object[0]);
                b.b(accountData);
                a.a("account", -1L, 0, "relogin_manager_save_account_to_application", 0, "", new Object[0]);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            }
        }
    }

    public boolean bsJ() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.getInst().isPassportV6ShouldOpen();
    }
}
