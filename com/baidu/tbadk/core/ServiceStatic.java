package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class ServiceStatic {
    private static final CustomMessageListener OQ = new m(0);

    static {
        MessageManager.getInstance().registerListener(2005009, OQ);
        MessageManager.getInstance().registerListener(2005010, OQ);
        MessageManager.getInstance().registerListener(2005011, OQ);
        MessageManager.getInstance().registerListener(2005012, OQ);
        MessageManager.getInstance().registerListener(2005013, OQ);
        MessageManager.getInstance().registerListener(2005015, OQ);
    }
}
