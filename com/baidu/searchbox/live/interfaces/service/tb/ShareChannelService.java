package com.baidu.searchbox.live.interfaces.service.tb;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.sharechennel.IShareChannel;
/* loaded from: classes5.dex */
public interface ShareChannelService {
    public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.TB.SHARE_CHANNEL);

    IShareChannel buildShareChannel();
}
