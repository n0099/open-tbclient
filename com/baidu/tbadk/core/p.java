package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class p {
    private static final CustomMessageListener RR = new q(0);

    public static void init() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_SYNC, RR);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_SYNC, RR);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_ACTIVE, RR);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_ACTIVE, RR);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_CLEARTEMP, RR);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, RR);
    }
}
