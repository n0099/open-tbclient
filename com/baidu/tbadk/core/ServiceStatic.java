package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class ServiceStatic {
    private static final CustomMessageListener CL = new k(0);

    static {
        MessageManager.getInstance().registerListener(2005009, CL);
        MessageManager.getInstance().registerListener(2005010, CL);
        MessageManager.getInstance().registerListener(2005011, CL);
        MessageManager.getInstance().registerListener(2005012, CL);
        MessageManager.getInstance().registerListener(2005013, CL);
        MessageManager.getInstance().registerListener(2005015, CL);
    }
}
