package com.baidu.searchbox.schemedispatch.monitor;

import java.util.List;
/* loaded from: classes4.dex */
public interface INoAlertCheck {
    void addAlwaysAllowSchema(String str);

    List<String> getAlwaysAllowSchema();

    String getNoAlertSwitch(String str);

    boolean isInNoAlertList(String str, List<String> list);
}
