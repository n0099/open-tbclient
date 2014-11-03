package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ac;
/* loaded from: classes.dex */
public class c {
    public static void a(String str, String str2, d dVar) {
        e eVar = new e(str, str2, dVar);
        eVar.setPriority(3);
        eVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData A(String str, String str2) {
        ac acVar;
        String lA;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            acVar = new ac(sb.toString());
            acVar.k("un", str);
            acVar.k("passwd", str2);
            acVar.k("isphone", "0");
            acVar.k("channel_id", TbadkApplication.m251getInst().getPushChannelId());
            acVar.k("channel_uid", TbadkApplication.m251getInst().getPushChannelUserId());
            acVar.mc().na().nd().Gm = true;
            acVar.mc().na().mIsNeedAddCommenParam = false;
            acVar.mc().na().mIsUseCurrentBDUSS = false;
            lA = acVar.lA();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (acVar.mc().nb().jq() && lA != null) {
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.parserJson(lA);
            String userId = jVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(jVar.getUser().getUserName());
            if (jVar.getUser().getPassword() != null) {
                accountData.setPassword(jVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
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
        if (acVar.mf()) {
            switch (acVar.mg()) {
                case 1:
                case 2:
                case 5:
                    acVar.dM();
                    ReloginManager.lf().d(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
