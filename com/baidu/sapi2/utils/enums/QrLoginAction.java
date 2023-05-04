package com.baidu.sapi2.utils.enums;

import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleData;
/* loaded from: classes2.dex */
public enum QrLoginAction {
    NOTICE(TopBubbleData.NOTICE),
    LOGIN("login"),
    CANCEL("cancel");
    
    public String name;

    QrLoginAction(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
