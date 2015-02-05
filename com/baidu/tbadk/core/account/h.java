package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, AccountData> {
    private final String Bs;
    private volatile ad CU = null;
    private final g CV;
    private final boolean CW;
    private final String mName;
    private final String mPtoken;

    public h(String str, String str2, String str3, g gVar, boolean z) {
        this.mName = str;
        this.Bs = str2;
        this.mPtoken = str3;
        this.CW = z;
        this.CV = gVar == null ? new i(this) : gVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.CV.onBeforeLogin(this.mName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public AccountData doInBackground(String... strArr) {
        AccountLoginHelper.OurToken a;
        this.CU = new ad(TbConfig.LOGIN_FULL_ADDRESS);
        this.CU.oS().pZ().mIsUseCurrentBDUSS = false;
        this.CU.o("bdusstoken", String.valueOf(this.Bs) + "|" + this.mPtoken);
        this.CU.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
        this.CU.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
        this.CU.oS().pZ().Ku = false;
        String or = this.CU.or();
        if (this.CU.oS().qa().lT() && or != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(or);
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(nVar.getUser().getUserId());
            String bduss = nVar.getUser().getBDUSS();
            if (this.CW && (a = n.a(AccountLoginHelper.parseBDUSS(bduss))) != null) {
                bduss = String.valueOf(a.mBduss) + "|" + a.mPtoken;
            }
            accountData.setBDUSS(bduss);
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.mK() != null) {
                accountData.setTbs(nVar.mK().getTbs());
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
        ReloginManager.nX().am(false);
        if (accountData != null && accountData.getBDUSS() != null) {
            this.CV.onSuccess(accountData);
            return;
        }
        if (this.CU == null) {
            str = null;
            i = 0;
        } else {
            str = this.CU.getErrorString();
            i = this.CU.oW();
        }
        if (str == null) {
            str = TbadkCoreApplication.m255getInst().getApp().getResources().getString(z.data_load_error);
        }
        this.CV.onFailure(this.mName, i, str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.CU != null) {
            this.CU.dJ();
        }
    }
}
