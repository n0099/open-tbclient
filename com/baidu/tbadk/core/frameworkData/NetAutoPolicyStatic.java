package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class NetAutoPolicyStatic {
    static {
        b bVar = new b(0);
        bVar.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().addMessageRule(bVar);
        MessageManager.getInstance().addResponsedMessageRule(new c(0));
        d dVar = new d(2000999);
        dVar.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(dVar);
    }
}
