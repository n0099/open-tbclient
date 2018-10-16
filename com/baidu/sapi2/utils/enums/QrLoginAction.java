package com.baidu.sapi2.utils.enums;

import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
/* loaded from: classes.dex */
public enum QrLoginAction {
    NOTICE("notice"),
    LOGIN("login"),
    CANCEL(AiAppsUBCStatistic.VALUE_CANCEL);
    
    private String a;

    QrLoginAction(String str) {
        this.a = str;
    }

    public String getName() {
        return this.a;
    }
}
