package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class BackgroundSwitchMessage extends CustomResponsedMessage<Boolean> {
    public BackgroundSwitchMessage(Boolean bool) {
        super(2001011, bool);
    }
}
