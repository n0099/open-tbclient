package com.baidu.tbadk.core.account;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class f {
    public static void a(String str, String str2, String str3, g gVar) {
        new h(str, str2, str3, gVar, false).execute(new String[0]);
    }

    public static AccountData a(String str, String str2, String str3) {
        ae aeVar = new ae(TbConfig.LOGIN_FULL_ADDRESS);
        aeVar.a().a().c = false;
        aeVar.a("bdusstoken", String.valueOf(str2) + "|" + str3);
        aeVar.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
        aeVar.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
        aeVar.a().a().b = false;
        String h = aeVar.h();
        if (aeVar.a().b().b() && h != null) {
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.a(h);
            AccountData accountData = new AccountData();
            accountData.setAccount(jVar.a().getUserName());
            accountData.setPassword("");
            accountData.setID(jVar.a().getUserId());
            accountData.setBDUSS(jVar.a().getBDUSS());
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
}
