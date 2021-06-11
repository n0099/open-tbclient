package com.baidu.tbadk.core.relogin;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.r.l.c;
import d.a.m0.r.q.q0;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ReloginManager {

    /* renamed from: d  reason: collision with root package name */
    public static ReloginManager f12193d = new ReloginManager();

    /* renamed from: a  reason: collision with root package name */
    public boolean f12194a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<HttpMessage> f12195b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f12196c = new a(CmdConfigHttp.BG_LOGIN_HTTP_CMD);

    /* loaded from: classes3.dex */
    public static class BgLoginHttpResponsedMessage extends JsonHttpResponsedMessage {
        public BgLoginHttpResponsedMessage(int i2) {
            super(i2);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
            int statusCode = getStatusCode();
            int error = getError();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (statusCode == 200 && error == 0) {
                q0 q0Var = new q0();
                q0Var.d(jSONObject);
                String userId = q0Var.b().getUserId();
                if (userId != null && userId.length() > 0) {
                    AccountData accountData = new AccountData();
                    String userName = q0Var.b().getUserName();
                    String password = q0Var.b().getPassword();
                    accountData.setAccount(userName);
                    if (password != null) {
                        accountData.setPassword(password);
                    } else {
                        accountData.setPassword(currentAccountObj.getPassword());
                    }
                    accountData.setID(q0Var.b().getUserId());
                    accountData.setBDUSS(q0Var.b().getBDUSS());
                    accountData.setPortrait(q0Var.b().getPortrait());
                    if (q0Var.b() != null && q0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(q0Var.b().getBaijiahaoInfo().avatar)) {
                        accountData.setBjhAvatar(q0Var.b().getBaijiahaoInfo().avatar);
                    }
                    accountData.setIsActive(1);
                    if (q0Var.a() != null) {
                        accountData.setTbs(q0Var.a().getTbs());
                    }
                    d.a.m0.r.z.a.a("account", -1L, 0, "relogin_manager_save_account_to_db", 0, "", new Object[0]);
                    c.g(accountData);
                    d.a.m0.r.z.a.a("account", -1L, 0, "relogin_manager_save_account_to_application", 0, "", new Object[0]);
                    TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                    TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                }
                setErrorString(TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof BgLoginHttpResponsedMessage)) {
                return;
            }
            ReloginManager.this.f12194a = false;
            BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (BgLoginHttpResponsedMessage) httpResponsedMessage;
            int statusCode = bgLoginHttpResponsedMessage.getStatusCode();
            int error = bgLoginHttpResponsedMessage.getError();
            d.a.m0.r.z.a.a("account", -1L, 0, "login_auto_local_result", bgLoginHttpResponsedMessage.getError(), bgLoginHttpResponsedMessage.getErrorString(), new Object[0]);
            if ((statusCode != 200 || error == 0) && statusCode == 200) {
                ReloginManager.this.j();
                return;
            }
            ReloginManager.this.f(TbadkCoreApplication.getCurrentAccountObj());
            if (bgLoginHttpResponsedMessage.getErrorString() != null) {
                l.M(TbadkCoreApplication.getInst().getContext(), bgLoginHttpResponsedMessage.getErrorString());
            }
            ReloginManager.this.f12195b.clear();
        }
    }

    public static ReloginManager g() {
        return f12193d;
    }

    public final void d(HttpMessage httpMessage) {
        if (this.f12195b.contains(httpMessage)) {
            return;
        }
        this.f12195b.add(httpMessage);
    }

    public final void e(AccountData accountData) {
        d.a.m0.r.z.a.a("account", -1L, 0, "login_auto_local_start", 0, "", new Object[0]);
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
        d.a.m0.r.z.a.a("account", -1L, 0, "login_auto_foreground", 0, "", new Object[0]);
        c.b();
        TbadkCoreApplication.getInst().handler.sendMessage(TbadkCoreApplication.getInst().handler.obtainMessage(1));
    }

    public boolean h() {
        return this.f12194a;
    }

    public boolean i() {
        return Build.VERSION.SDK_INT >= 9 && !TbConfig.USE_OLD_LOGIN && TbadkCoreApplication.getInst().isPassportV6ShouldOpen();
    }

    public final void j() {
        MessageManager messageManager = MessageManager.getInstance();
        Iterator<HttpMessage> it = this.f12195b.iterator();
        while (it.hasNext()) {
            messageManager.sendMessage(it.next());
        }
        this.f12195b.clear();
    }

    public void k() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerListener(this.f12196c);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.BG_LOGIN_HTTP_CMD, TbConfig.LOGIN_FULL_ADDRESS);
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(BgLoginHttpResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void l(HttpMessage httpMessage) {
        d.a.m0.r.z.a.a("account", -1L, 0, "login_auto_start", 0, "", new Object[0]);
        d(httpMessage);
        if (this.f12194a) {
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = c.e();
        }
        if (currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getAccount())) {
            this.f12194a = true;
            if (i()) {
                return;
            }
            e(currentAccountObj);
            return;
        }
        f(currentAccountObj);
    }

    public void m(int i2, BdUniqueId bdUniqueId) {
        Iterator<HttpMessage> it = this.f12195b.iterator();
        while (it.hasNext()) {
            HttpMessage next = it.next();
            BdUniqueId tag = next.getTag();
            int cmd = next.getCmd();
            if ((i2 != 0 && tag == bdUniqueId && i2 == cmd) || (i2 == 0 && bdUniqueId != null && tag == bdUniqueId)) {
                it.remove();
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        m(0, bdUniqueId);
    }

    public void o(boolean z) {
        this.f12194a = z;
    }
}
