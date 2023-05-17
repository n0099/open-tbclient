package com.baidu.searchbox.common.security;
/* loaded from: classes3.dex */
public class ComLogger {
    public static void log(String str, String str2) {
        if (!SecurityPersistConfig.getInstance().getBoolean(SecurityPersistConfigConst.KEY_SEC_ABILITY_LOG_ENABLE, SecurityPersistConfigConst.SEC_ABILITY_LOG_ENABLE_DEFAULT)) {
        }
    }
}
