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

    public static AccountData j(String str, String str2, String str3) {
        ad adVar = new ad(TbConfig.LOGIN_FULL_ADDRESS);
        adVar.oW().pV().mIsUseCurrentBDUSS = false;
        adVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        adVar.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
        adVar.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
        adVar.oW().pV().Ke = false;
        String ov = adVar.ov();
        if (adVar.oW().pW().ma() && ov != null) {
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            mVar.parserJson(ov);
            AccountData accountData = new AccountData();
            accountData.setAccount(mVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(mVar.getUser().getUserId());
            accountData.setBDUSS(mVar.getUser().getBDUSS());
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
}
