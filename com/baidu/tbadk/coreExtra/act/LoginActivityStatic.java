package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
public class LoginActivityStatic {
    static {
        b.checkPassV6Switch();
        if (!b.wa()) {
            TbadkCoreApplication.m411getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
        }
    }
}
