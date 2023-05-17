package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes3.dex */
public interface ICSPDataService {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("abtest", "csp");

    String config();
}
