package com.baidu.searchbox.common.security;

import android.content.Context;
import com.baidu.searchbox.net.update.v2.SwitchListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
@UpdateAction(action = "security_js", module = "security")
/* loaded from: classes3.dex */
public class JSSecurityCommandListener extends SwitchListener {
    public static final String SWITCH = "security_js";

    @Override // com.baidu.searchbox.net.update.v2.SwitchListener
    public String getKey(String str, String str2) {
        return "security_js";
    }

    @Override // com.baidu.searchbox.net.update.v2.SwitchListener
    public boolean handleData(Context context, String str, String str2, String str3, boolean z) {
        SecurityPersistConfig.getInstance().setBoolean(SecurityPersistConfigConst.KEY_SEC_HTTPS_CHECK, z);
        return true;
    }
}
