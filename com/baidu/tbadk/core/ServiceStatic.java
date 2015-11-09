package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ServiceStatic {
    private static final CustomMessageListener Tt = new l(0);

    static {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_SYNC, Tt);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_SYNC, Tt);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_ACTIVE, Tt);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_ACTIVE, Tt);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_CLEARTEMP, Tt);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, Tt);
    }
}
