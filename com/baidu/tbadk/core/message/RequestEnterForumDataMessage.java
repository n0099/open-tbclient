package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class RequestEnterForumDataMessage extends CustomResponsedMessage<Boolean> {
    private boolean isCache;

    public boolean isCache() {
        return this.isCache;
    }

    public void setCache(boolean z) {
        this.isCache = z;
    }

    public RequestEnterForumDataMessage(int i, Boolean bool) {
        super(2001323, bool);
        this.isCache = bool.booleanValue();
    }
}
