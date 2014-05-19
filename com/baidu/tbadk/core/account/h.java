package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, AccountData> {
    private volatile al a = null;
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
        this.a = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOGIN_ADDRESS);
        this.a.a().a().c = false;
        this.a.a("bdusstoken", String.valueOf(this.c) + "|" + this.d);
        this.a.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
        this.a.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
        this.a.a().a().b = false;
        String i = this.a.i();
        BdLog.d("simon", "ReLoginModel", i);
        if (this.a.a().b().b() || (this.a.c() && this.a.d() == 1)) {
            com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
            iVar.a(i);
            AccountData accountData = new AccountData();
            accountData.setAccount(iVar.a().getUserName());
            accountData.setPassword("");
            accountData.setID(iVar.a().getUserId());
            String bduss = iVar.a().getBDUSS();
            if (this.f && (a = n.a(AccountLoginHelper.parseBDUSS(bduss))) != null) {
                bduss = String.valueOf(a.mBduss) + "|" + a.mPtoken;
            }
            accountData.setBDUSS(bduss);
            accountData.setPortrait(iVar.a().getPortrait());
            accountData.setIsActive(1);
            if (iVar.b() != null) {
                accountData.setTbs(iVar.b().getTbs());
                return accountData;
            }
            return accountData;
        }
        BdLog.d(getClass().getName(), "doInBackground", "reLogin fail");
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(AccountData accountData) {
        super.onPostExecute(accountData);
        if (accountData != null && accountData.getBDUSS() != null) {
            this.e.onSuccess(accountData);
            return;
        }
        String str = null;
        if (this.a != null) {
            str = this.a.f();
        }
        if (str == null) {
            str = TbadkApplication.m252getInst().getApp().getResources().getString(u.data_load_error);
        }
        this.e.onFailure(this.b, str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.a != null) {
            this.a.g();
        }
    }
}
