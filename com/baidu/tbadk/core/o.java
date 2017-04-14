package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class o {
    private static final CustomMessageListener SO = new p(0);

    public static void init() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_SYNC, SO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_SYNC, SO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_ACTIVE, SO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_ACTIVE, SO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_CLEARTEMP, SO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, SO);
    }
}
