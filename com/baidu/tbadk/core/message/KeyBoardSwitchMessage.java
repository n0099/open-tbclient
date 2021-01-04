package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class KeyBoardSwitchMessage extends CustomResponsedMessage<Boolean> {
    public KeyBoardSwitchMessage(Boolean bool) {
        super(2001013, bool);
    }
}
