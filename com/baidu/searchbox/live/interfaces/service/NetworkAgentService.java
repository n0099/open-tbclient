package com.baidu.searchbox.live.interfaces.service;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.net.INetWork;
/* loaded from: classes7.dex */
public interface NetworkAgentService {
    public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef("net");

    INetWork buildNetworkInstance();
}
