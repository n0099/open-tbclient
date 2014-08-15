package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, AccountData> {
    private volatile ae a = null;
    private final String b;
    private final String c;
    private final String d;
    private final g e;
    private final boolean f;

    public h(String str, String str2, String str3, g gVar, boolean z) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f = z;
        this.e = gVar == null ? new i(this) : gVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.e.onBeforeLogin(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public AccountData doInBackground(String... strArr) {
        AccountLoginHelper.OurToken a;
        this.a = new ae(TbConfig.LOGIN_FULL_ADDRESS);
        this.a.a().a().c = false;
        this.a.a("bdusstoken", String.valueOf(this.c) + "|" + this.d);
        this.a.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
        this.a.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
        this.a.a().a().b = false;
        String h = this.a.h();
        if (this.a.a().b().b() && h != null) {
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.a(h);
            AccountData accountData = new AccountData();
            accountData.setAccount(jVar.a().getUserName());
            accountData.setPassword("");
            accountData.setID(jVar.a().getUserId());
            String bduss = jVar.a().getBDUSS();
            if (this.f && (a = n.a(AccountLoginHelper.parseBDUSS(bduss))) != null) {
                bduss = String.valueOf(a.mBduss) + "|" + a.mPtoken;
            }
            accountData.setBDUSS(bduss);
            accountData.setPortrait(jVar.a().getPortrait());
            accountData.setIsActive(1);
            if (jVar.b() != null) {
                accountData.setTbs(jVar.b().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(AccountData accountData) {
        String str;
        int i;
        super.onPostExecute(accountData);
        ReloginManager.a().a(false);
        if (accountData != null && accountData.getBDUSS() != null) {
            this.e.onSuccess(accountData);
            return;
        }
        if (this.a == null) {
            str = null;
            i = 0;
        } else {
            str = this.a.e();
            i = this.a.c();
        }
        if (str == null) {
            str = TbadkApplication.m252getInst().getApp().getResources().getString(x.data_load_error);
        }
        this.e.onFailure(this.b, i, str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.a != null) {
            this.a.f();
        }
    }
}
