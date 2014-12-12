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
    public static AccountData L(String str, String str2) {
        ad adVar;
        String ov;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            adVar = new ad(sb.toString());
            adVar.o("un", str);
            adVar.o("passwd", str2);
            adVar.o("isphone", "0");
            adVar.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
            adVar.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
            adVar.oW().pV().pY().Kx = true;
            adVar.oW().pV().mIsNeedAddCommenParam = false;
            adVar.oW().pV().mIsUseCurrentBDUSS = false;
            ov = adVar.ov();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (adVar.oW().pW().ma() && ov != null) {
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            mVar.parserJson(ov);
            String userId = mVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(mVar.getUser().getUserName());
            if (mVar.getUser().getPassword() != null) {
                accountData.setPassword(mVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
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
        if (adVar.oZ()) {
            switch (adVar.pa()) {
                case 1:
                case 2:
                case 5:
                    adVar.dL();
                    ReloginManager.ob().d(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
