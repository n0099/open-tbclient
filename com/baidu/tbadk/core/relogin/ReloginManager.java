package com.baidu.tbadk.core.relogin;

import android.os.Bundle;
import android.os.Message;
import com.baidu.adp.framework.c;
import com.baidu.adp.framework.c.b;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.a.o;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.h;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.l;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.person.PersonInfoActivity;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ReloginManager {
    private static ReloginManager b = new ReloginManager();
    private boolean a;
    private ArrayList<HttpMessage> c = new ArrayList<>();
    private b d = new a(this, 1002001);

    private ReloginManager() {
        c a = c.a();
        a.a(this.d);
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b(1002001, n.a + "c/s/login");
        bVar.a(true);
        bVar.c(false);
        bVar.b(false);
        bVar.d(false);
        bVar.a(BgLoginHttpResponsedMessage.class);
        a.a(bVar);
    }

    public static ReloginManager a() {
        return b;
    }

    public final void a(HttpMessage httpMessage) {
        if (!this.c.contains(httpMessage)) {
            this.c.add(httpMessage);
        }
        if (!this.a) {
            this.a = true;
            AccountData N = TbadkApplication.N();
            if (N == null) {
                N = o.c();
            }
            if (N == null) {
                a(N);
                return;
            }
            c a = c.a();
            TbadkApplication.a((AccountData) null, TbadkApplication.j().b().getApplicationContext());
            HttpMessage httpMessage2 = new HttpMessage(1002001);
            httpMessage2.a(PersonInfoActivity.TAG_ID, N.getAccount());
            httpMessage2.a("passwd", N.getPassword());
            httpMessage2.a("isphone", "0");
            httpMessage2.a("channel_id", TbadkApplication.j().S());
            httpMessage2.a("channel_uid", TbadkApplication.j().R());
            a.a(httpMessage2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AccountData accountData) {
        String account = accountData == null ? "" : accountData.getAccount();
        Message obtainMessage = TbadkApplication.j().F.obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString("account", account);
        obtainMessage.setData(bundle);
        TbadkApplication.j().F.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(ReloginManager reloginManager) {
        c a = c.a();
        Iterator<HttpMessage> it = reloginManager.c.iterator();
        while (it.hasNext()) {
            a.a(it.next());
        }
        reloginManager.c.clear();
    }

    public final boolean b() {
        return this.a;
    }

    /* loaded from: classes.dex */
    public class BgLoginHttpResponsedMessage extends JsonHttpResponsedMessage {
        public BgLoginHttpResponsedMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public final void a(JSONObject jSONObject) {
            int d = d();
            int e = e();
            AccountData N = TbadkApplication.N();
            if (d == 200 && e == 0) {
                h hVar = new h();
                hVar.a(jSONObject);
                String userId = hVar.a().getUserId();
                if (userId == null || userId.length() <= 0) {
                    e(TbadkApplication.j().b().getApplicationContext().getString(l.neterror));
                    return;
                }
                AccountData accountData = new AccountData();
                String userName = hVar.a().getUserName();
                String password = hVar.a().getPassword();
                accountData.setAccount(userName);
                if (password != null) {
                    accountData.setPassword(password);
                } else {
                    accountData.setPassword(N.getPassword());
                }
                accountData.setID(hVar.a().getUserId());
                accountData.setBDUSS(hVar.a().getBDUSS());
                accountData.setPortrait(hVar.a().getPortrait());
                accountData.setIsActive(1);
                if (hVar.b() != null) {
                    accountData.setTbs(hVar.b().getTbs());
                }
                o.a(accountData);
                TbadkApplication.a(accountData, TbadkApplication.j().b().getApplicationContext());
            }
        }
    }
}
