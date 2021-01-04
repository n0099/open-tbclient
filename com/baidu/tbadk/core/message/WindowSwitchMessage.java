package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class WindowSwitchMessage extends CustomResponsedMessage<Boolean> {
    public WindowSwitchMessage(Boolean bool) {
        super(2001014, bool);
    }
}
