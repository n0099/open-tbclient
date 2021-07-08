package com.baidu.livesdk.api.service;

import java.util.Map;
/* loaded from: classes2.dex */
public interface Tab {
    void addTab(Map map);

    boolean isAddedTab(String str);

    void moveToTab(String str, Map map);
}
