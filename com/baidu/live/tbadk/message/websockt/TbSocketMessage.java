package com.baidu.live.tbadk.message.websockt;

import com.baidu.live.adp.framework.message.SocketMessage;
/* loaded from: classes6.dex */
public abstract class TbSocketMessage extends SocketMessage {
    protected abstract Object encode();

    public TbSocketMessage(int i, Object obj) {
        super(i, obj);
        init();
    }

    public TbSocketMessage(int i) {
        super(i);
        init();
    }

    public TbSocketMessage(int i, int i2) {
        super(i, Integer.valueOf(i2));
        init();
    }

    private void init() {
    }

    @Override // com.baidu.live.adp.framework.message.SocketMessage
    public Object getData() {
        return encode();
    }
}
