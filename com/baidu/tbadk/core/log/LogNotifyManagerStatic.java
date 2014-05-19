package com.baidu.tbadk.core.log;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
/* loaded from: classes.dex */
public class LogNotifyManagerStatic {
    static {
        MessageManager.getInstance().registerListener(new i(CmdConfig.CMD_DEBUGLOG_SPECIFIED));
    }
}
