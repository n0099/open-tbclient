package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, AccountData> {
    private final String mName;
    private final String mPtoken;
    private final String xP;
    private volatile ac yV = null;
    private final g yW;
    private final boolean yX;

    public h(String str, String str2, String str3, g gVar, boolean z) {
        this.mName = str;
        this.xP = str2;
        this.mPtoken = str3;
        this.yX = z;
        this.yW = gVar == null ? new i(this) : gVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.yW.onBeforeLogin(this.mName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public AccountData doInBackground(String... strArr) {
        AccountLoginHelper.OurToken a;
        this.yV = new ac(TbConfig.LOGIN_FULL_ADDRESS);
        this.yV.mc().na().mIsUseCurrentBDUSS = false;
        this.yV.k("bdusstoken", String.valueOf(this.xP) + "|" + this.mPtoken);
        this.yV.k("channel_id", TbadkApplication.m251getInst().getPushChannelId());
        this.yV.k("channel_uid", TbadkApplication.m251getInst().getPushChannelUserId());
        this.yV.mc().na().FT = false;
        String lA = this.yV.lA();
        if (this.yV.mc().nb().jq() && lA != null) {
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.parserJson(lA);
            AccountData accountData = new AccountData();
            accountData.setAccount(jVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(jVar.getUser().getUserId());
            String bduss = jVar.getUser().getBDUSS();
            if (this.yX && (a = n.a(AccountLoginHelper.parseBDUSS(bduss))) != null) {
                bduss = String.valueOf(a.mBduss) + "|" + a.mPtoken;
            }
            accountData.setBDUSS(bduss);
            accountData.setPortrait(jVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (jVar.jZ() != null) {
                accountData.setTbs(jVar.jZ().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(AccountData accountData) {
        String str;
        int i;
        super.onPostExecute((h) accountData);
        ReloginManager.lf().T(false);
        if (accountData != null && accountData.getBDUSS() != null) {
            this.yW.onSuccess(accountData);
            return;
        }
        if (this.yV == null) {
            str = null;
            i = 0;
        } else {
            str = this.yV.getErrorString();
            i = this.yV.mg();
        }
        if (str == null) {
            str = TbadkApplication.m251getInst().getApp().getResources().getString(y.data_load_error);
        }
        this.yW.onFailure(this.mName, i, str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.yV != null) {
            this.yV.dM();
        }
    }
}
