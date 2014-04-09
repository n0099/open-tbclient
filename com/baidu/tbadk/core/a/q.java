package com.baidu.tbadk.core.a;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public final class q {
    public static void a(String str, String str2, r rVar) {
        s sVar = new s(str, str2, rVar);
        sVar.setPriority(3);
        sVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData b(String str, String str2) {
        ak akVar;
        String i;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tbadk.core.data.n.a);
            sb.append("c/s/login");
            akVar = new ak(sb.toString());
            akVar.a("un", str);
            akVar.a("passwd", str2);
            akVar.a("isphone", "0");
            akVar.a("channel_id", TbadkApplication.j().S());
            akVar.a("channel_uid", TbadkApplication.j().R());
            akVar.a().a().a().d = true;
            akVar.a().a().d = false;
            akVar.a().a().c = false;
            i = akVar.i();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("LoginModel".toString(), "login", e.getMessage());
        }
        if (akVar.a().b().b() && i != null) {
            com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
            hVar.a(i);
            String userId = hVar.a().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(hVar.a().getUserName());
            if (hVar.a().getPassword() != null) {
                accountData.setPassword(hVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(hVar.a().getUserId());
            accountData.setBDUSS(hVar.a().getBDUSS());
            accountData.setPortrait(hVar.a().getPortrait());
            accountData.setIsActive(1);
            if (hVar.b() != null) {
                accountData.setTbs(hVar.b().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (akVar.c()) {
            switch (akVar.d()) {
                case 1:
                case 2:
                case 5:
                    akVar.g();
                    break;
            }
            return null;
        }
        return null;
    }
}
