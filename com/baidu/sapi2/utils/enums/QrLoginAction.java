package com.baidu.sapi2.utils.enums;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
/* loaded from: classes4.dex */
public enum QrLoginAction {
    NOTICE(LogConfig.KEY_NOTICE),
    LOGIN("login"),
    CANCEL(UgcUBCUtils.UGC_TIME_CANCEL);
    
    private String b;

    QrLoginAction(String str) {
        this.b = str;
    }

    public String getName() {
        return this.b;
    }
}
