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
    private volatile ad CX = null;
    private final g CY;
    private final boolean CZ;
    private final String mName;
    private final String mPtoken;

    public h(String str, String str2, String str3, g gVar, boolean z) {
        this.mName = str;
        this.Bv = str2;
        this.mPtoken = str3;
        this.CZ = z;
        this.CY = gVar == null ? new i(this) : gVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.CY.onBeforeLogin(this.mName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public AccountData doInBackground(String... strArr) {
        AccountLoginHelper.OurToken a;
        this.CX = new ad(TbConfig.LOGIN_FULL_ADDRESS);
        this.CX.oZ().qg().mIsUseCurrentBDUSS = false;
        this.CX.o("bdusstoken", String.valueOf(this.Bv) + "|" + this.mPtoken);
        this.CX.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
        this.CX.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
        this.CX.oZ().qg().Kx = false;
        String oy = this.CX.oy();
        if (this.CX.oZ().qh().ma() && oy != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(oy);
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(nVar.getUser().getUserId());
            String bduss = nVar.getUser().getBDUSS();
            if (this.CZ && (a = n.a(AccountLoginHelper.parseBDUSS(bduss))) != null) {
                bduss = String.valueOf(a.mBduss) + "|" + a.mPtoken;
            }
            accountData.setBDUSS(bduss);
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.mR() != null) {
                accountData.setTbs(nVar.mR().getTbs());
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
        ReloginManager.oe().am(false);
        if (accountData != null && accountData.getBDUSS() != null) {
            this.CY.onSuccess(accountData);
            return;
        }
        if (this.CX == null) {
            str = null;
            i = 0;
        } else {
            str = this.CX.getErrorString();
            i = this.CX.pd();
        }
        if (str == null) {
            str = TbadkCoreApplication.m255getInst().getApp().getResources().getString(z.data_load_error);
        }
        this.CY.onFailure(this.mName, i, str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.CX != null) {
            this.CX.dJ();
        }
    }
}
