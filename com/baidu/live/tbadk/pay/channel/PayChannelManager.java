package com.baidu.live.tbadk.pay.channel;

import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannelBuilder;
/* loaded from: classes6.dex */
public class PayChannelManager {
    private IPayChannel mPayChannel;
    private IPayChannelBuilder mPayChannelBuilder;

    public static PayChannelManager getInstance() {
        return InstanceHolder.sInst;
    }

    private PayChannelManager() {
    }

    public void init(IPayChannelBuilder iPayChannelBuilder) {
        this.mPayChannelBuilder = iPayChannelBuilder;
        build();
    }

    public IPayChannel buildPayChannel() {
        if (this.mPayChannel != null) {
            return this.mPayChannel;
        }
        build();
        return this.mPayChannel;
    }

    private void build() {
        if (this.mPayChannelBuilder == null) {
            throw new RuntimeException("PayChannelBuilder must not be null! should invoke PayChannelManager.init() first~");
        }
        this.mPayChannel = this.mPayChannelBuilder.build();
    }

    /* loaded from: classes6.dex */
    public static class InstanceHolder {
        private static final PayChannelManager sInst = new PayChannelManager();
    }
}
