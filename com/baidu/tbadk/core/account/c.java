package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class c {
    public static void a(String str, String str2, d dVar) {
        e eVar = new e(str, str2, dVar);
        eVar.setPriority(3);
        eVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData b(String str, String str2) {
        al alVar;
        String i;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.SERVER_ADDRESS);
            sb.append(TbConfig.LOGIN_ADDRESS);
            alVar = new al(sb.toString());
            alVar.a("un", str);
            alVar.a("passwd", str2);
            alVar.a("isphone", "0");
            alVar.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
            alVar.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
            alVar.a().a().a().d = true;
            alVar.a().a().d = false;
            alVar.a().a().c = false;
            i = alVar.i();
        } catch (Exception e) {
            BdLog.e("LoginModel".toString(), TbConfig.ST_TYPE_LOGIN, e.getMessage());
        }
        if (alVar.a().b().b() && i != null) {
            com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
            iVar.a(i);
            String userId = iVar.a().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(iVar.a().getUserName());
            if (iVar.a().getPassword() != null) {
                accountData.setPassword(iVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(iVar.a().getUserId());
            accountData.setBDUSS(iVar.a().getBDUSS());
            accountData.setPortrait(iVar.a().getPortrait());
            accountData.setIsActive(1);
            if (iVar.b() != null) {
                accountData.setTbs(iVar.b().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (alVar.c()) {
            switch (alVar.d()) {
                case 1:
                case 2:
                case 5:
                    alVar.g();
                    break;
            }
            return null;
        }
        return null;
    }
}
