package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class ServiceStatic {
    private static final CustomMessageListener Os = new m(0);

    static {
        MessageManager.getInstance().registerListener(2005009, Os);
        MessageManager.getInstance().registerListener(2005010, Os);
        MessageManager.getInstance().registerListener(2005011, Os);
        MessageManager.getInstance().registerListener(2005012, Os);
        MessageManager.getInstance().registerListener(2005013, Os);
        MessageManager.getInstance().registerListener(2005015, Os);
    }
}
