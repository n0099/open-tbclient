package com.baidu.live.tbadk.pay.channel.interfaces;

import com.baidu.live.tbadk.core.data.PayChannelData;
/* loaded from: classes3.dex */
public interface IChannelPayController {
    public static final String TAG = "ChannelPayController";

    void pay(PayChannelData payChannelData);

    void release();
}
