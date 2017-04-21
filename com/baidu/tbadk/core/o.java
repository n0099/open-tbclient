package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class o {
    private static final CustomMessageListener SQ = new p(0);

    public static void init() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_SYNC, SQ);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_SYNC, SQ);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_ACTIVE, SQ);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_ACTIVE, SQ);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_CLEARTEMP, SQ);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, SQ);
    }
}
