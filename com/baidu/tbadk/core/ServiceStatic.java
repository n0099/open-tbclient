package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ServiceStatic {
    private static final CustomMessageListener Ts = new l(0);

    static {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_SYNC, Ts);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_SYNC, Ts);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_ACTIVE, Ts);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_ACTIVE, Ts);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_CLEARTEMP, Ts);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, Ts);
    }
}
