package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class c {
    public static void a(String str, String str2, d dVar) {
        e eVar = new e(str, str2, dVar);
        eVar.setPriority(3);
        eVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData b(String str, String str2) {
        ae aeVar;
        String h;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            aeVar = new ae(sb.toString());
            aeVar.a("un", str);
            aeVar.a("passwd", str2);
            aeVar.a("isphone", "0");
            aeVar.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
            aeVar.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
            aeVar.a().a().a().d = true;
            aeVar.a().a().d = false;
            aeVar.a().a().c = false;
            h = aeVar.h();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (aeVar.a().b().b() && h != null) {
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.a(h);
            String userId = jVar.a().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(jVar.a().getUserName());
            if (jVar.a().getPassword() != null) {
                accountData.setPassword(jVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
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
        if (aeVar.b()) {
            switch (aeVar.c()) {
                case 1:
                case 2:
                case 5:
                    aeVar.f();
                    ReloginManager.a().a((AccountData) null);
                    break;
            }
            return null;
        }
        return null;
    }
}
