package com.baidu.live.tbadk.pay.channel;

import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannelBuilder;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class PayChannelManager {
    private HashMap<PayChannelType, IPayChannelBuilder> mPayChannelBuilders;

    public static PayChannelManager getInstance() {
        return InstanceHolder.sInst;
    }

    private PayChannelManager() {
        this.mPayChannelBuilders = new HashMap<>();
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        if (payChannelType != null && iPayChannelBuilder != null) {
            this.mPayChannelBuilders.put(payChannelType, iPayChannelBuilder);
        }
    }

    public boolean isPayChannelAvaliable(PayChannelType payChannelType) {
        return this.mPayChannelBuilders.containsKey(payChannelType);
    }

    public IPayChannel buildPayChannel(PayChannelType payChannelType) {
        IPayChannelBuilder iPayChannelBuilder;
        if (payChannelType != null && (iPayChannelBuilder = this.mPayChannelBuilders.get(payChannelType)) != null) {
            return iPayChannelBuilder.build();
        }
        return null;
    }

    /* loaded from: classes7.dex */
    public static class InstanceHolder {
        private static final PayChannelManager sInst = new PayChannelManager();
    }
}
