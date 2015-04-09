package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class ServiceStatic {
    private static final CustomMessageListener Ou = new m(0);

    static {
        MessageManager.getInstance().registerListener(2005009, Ou);
        MessageManager.getInstance().registerListener(2005010, Ou);
        MessageManager.getInstance().registerListener(2005011, Ou);
        MessageManager.getInstance().registerListener(2005012, Ou);
        MessageManager.getInstance().registerListener(2005013, Ou);
        MessageManager.getInstance().registerListener(2005015, Ou);
    }
}
