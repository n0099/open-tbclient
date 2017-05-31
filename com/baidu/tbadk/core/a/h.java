package com.baidu.tbadk.core.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AccountData;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h {

    /* loaded from: classes.dex */
    public interface a {
        void onFailed();

        void onSuccess(String str);
    }

    public static boolean pc() {
        return com.baidu.adp.lib.b.e.eZ().Y("android_stoken_new") == 1;
    }

    public static String d(AccountData accountData) {
        if (accountData != null && pc()) {
            return accountData.getStoken();
        }
        return null;
    }

    public void a(String str, a aVar) {
        if (!StringUtils.isNull(str)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(TbConfig.PassConfig.TPL);
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new i(this, aVar), str, linkedList);
        }
    }
}
