package com.baidu.tbadk.core.log;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class LogNotifyManagerStatic {
    static {
        MessageManager.getInstance().registerListener(new i(2000999));
    }
}
