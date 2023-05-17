package com.baidu.searchbox.common.security;

import android.content.Context;
import com.baidu.searchbox.net.update.v2.SwitchListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
@UpdateAction(action = MainSecurityListener.SWITCH, module = "security")
/* loaded from: classes3.dex */
public class MainSecurityListener extends SwitchListener {
    public static final String SWITCH = "main_security";

    @Override // com.baidu.searchbox.net.update.v2.SwitchListener
    public String getKey(String str, String str2) {
        return SWITCH;
    }

    @Override // com.baidu.searchbox.net.update.v2.SwitchListener
    public boolean handleData(Context context, String str, String str2, String str3, boolean z) {
        SecurityPersistConfig.getInstance().setBoolean(SecurityPersistConfigConst.KEY_SEC_MAIN_CHECK, z);
        return true;
    }
}
