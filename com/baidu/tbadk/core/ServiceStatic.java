package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class ServiceStatic {
    private static final CustomMessageListener CI = new k(0);

    static {
        MessageManager.getInstance().registerListener(2005009, CI);
        MessageManager.getInstance().registerListener(2005010, CI);
        MessageManager.getInstance().registerListener(2005011, CI);
        MessageManager.getInstance().registerListener(2005012, CI);
        MessageManager.getInstance().registerListener(2005013, CI);
        MessageManager.getInstance().registerListener(2005015, CI);
    }
}
