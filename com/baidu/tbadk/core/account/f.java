package com.baidu.tbadk.core.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class f {
    public static void a(String str, String str2, String str3, g gVar) {
        new h(str, str2, str3, gVar, false).execute(new String[0]);
    }

    public static AccountData h(String str, String str2, String str3) {
        ad adVar = new ad(TbConfig.LOGIN_FULL_ADDRESS);
        adVar.oZ().qg().mIsUseCurrentBDUSS = false;
        adVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        adVar.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
        adVar.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
        adVar.oZ().qg().Kx = false;
        String oy = adVar.oy();
        if (adVar.oZ().qh().ma() && oy != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(oy);
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(nVar.getUser().getUserId());
            accountData.setBDUSS(nVar.getUser().getBDUSS());
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
}
