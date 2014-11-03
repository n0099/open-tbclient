package com.baidu.tbadk.core.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ac;
/* loaded from: classes.dex */
public class f {
    public static void a(String str, String str2, String str3, g gVar) {
        new h(str, str2, str3, gVar, false).execute(new String[0]);
    }

    public static AccountData f(String str, String str2, String str3) {
        ac acVar = new ac(TbConfig.LOGIN_FULL_ADDRESS);
        acVar.mc().na().mIsUseCurrentBDUSS = false;
        acVar.k("bdusstoken", String.valueOf(str2) + "|" + str3);
        acVar.k("channel_id", TbadkApplication.m251getInst().getPushChannelId());
        acVar.k("channel_uid", TbadkApplication.m251getInst().getPushChannelUserId());
        acVar.mc().na().FU = false;
        String lA = acVar.lA();
        if (acVar.mc().nb().jq() && lA != null) {
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.parserJson(lA);
            AccountData accountData = new AccountData();
            accountData.setAccount(jVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(jVar.getUser().getUserId());
            accountData.setBDUSS(jVar.getUser().getBDUSS());
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
}
