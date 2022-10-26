package com.baidu.behavior.record.api;

import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.List;
/* loaded from: classes.dex */
public interface IBehaviorApi {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("behavior-api", "behavior-api");

    void addBehavior(int i, String str, String str2);

    void addBehavior(int i, String str, String str2, String str3);

    void addBehavior(List list);
}
