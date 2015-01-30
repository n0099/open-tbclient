package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class c {
    public static void a(String str, String str2, d dVar) {
        e eVar = new e(str, str2, dVar);
        eVar.setPriority(3);
        eVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData O(String str, String str2) {
        ad adVar;
        String oy;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            adVar = new ad(sb.toString());
            adVar.o("un", str);
            adVar.o("passwd", str2);
            adVar.o("isphone", "0");
            adVar.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
            adVar.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
            adVar.oZ().qg().qj().KQ = true;
            adVar.oZ().qg().mIsNeedAddCommenParam = false;
            adVar.oZ().qg().mIsUseCurrentBDUSS = false;
            oy = adVar.oy();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (adVar.oZ().qh().ma() && oy != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(oy);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            if (nVar.getUser().getPassword() != null) {
                accountData.setPassword(nVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
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
        if (adVar.pc()) {
            switch (adVar.pd()) {
                case 1:
                case 2:
                case 5:
                    adVar.dJ();
                    ReloginManager.oe().d(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
