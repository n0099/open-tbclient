package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ServiceStatic {
    private static final CustomMessageListener Rf = new k(0);

    static {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_SYNC, Rf);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_SYNC, Rf);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_ACTIVE, Rf);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_ACTIVE, Rf);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_CLEARTEMP, Rf);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, Rf);
    }
}
