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
    private final String Bv;
    private volatile ad CV = null;
    private final g CW;
    private final boolean CX;
    private final String mName;
    private final String mPtoken;

    public h(String str, String str2, String str3, g gVar, boolean z) {
        this.mName = str;
        this.Bv = str2;
        this.mPtoken = str3;
        this.CX = z;
        this.CW = gVar == null ? new i(this) : gVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.CW.onBeforeLogin(this.mName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public AccountData doInBackground(String... strArr) {
        AccountLoginHelper.OurToken a;
        this.CV = new ad(TbConfig.LOGIN_FULL_ADDRESS);
        this.CV.oW().pV().mIsUseCurrentBDUSS = false;
        this.CV.o("bdusstoken", String.valueOf(this.Bv) + "|" + this.mPtoken);
        this.CV.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
        this.CV.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
        this.CV.oW().pV().Ke = false;
        String ov = this.CV.ov();
        if (this.CV.oW().pW().ma() && ov != null) {
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            mVar.parserJson(ov);
            AccountData accountData = new AccountData();
            accountData.setAccount(mVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(mVar.getUser().getUserId());
            String bduss = mVar.getUser().getBDUSS();
            if (this.CX && (a = n.a(AccountLoginHelper.parseBDUSS(bduss))) != null) {
                bduss = String.valueOf(a.mBduss) + "|" + a.mPtoken;
            }
            accountData.setBDUSS(bduss);
            accountData.setPortrait(mVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (mVar.mP() != null) {
                accountData.setTbs(mVar.mP().getTbs());
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
        ReloginManager.ob().ak(false);
        if (accountData != null && accountData.getBDUSS() != null) {
            this.CW.onSuccess(accountData);
            return;
        }
        if (this.CV == null) {
            str = null;
            i = 0;
        } else {
            str = this.CV.getErrorString();
            i = this.CV.pa();
        }
        if (str == null) {
            str = TbadkCoreApplication.m255getInst().getApp().getResources().getString(z.data_load_error);
        }
        this.CW.onFailure(this.mName, i, str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.CV != null) {
            this.CV.dL();
        }
    }
}
