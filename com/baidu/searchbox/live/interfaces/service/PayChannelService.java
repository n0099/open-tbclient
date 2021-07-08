package com.baidu.searchbox.live.interfaces.service;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.pay.IPayChannel;
import com.baidu.searchbox.live.interfaces.pay.PayChannelType;
/* loaded from: classes2.dex */
public interface PayChannelService {
    public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.PAY_CHANNEL);

    IPayChannel buildPayChannel(PayChannelType payChannelType);
}
