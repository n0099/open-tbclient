package com.baidu.behavior.record.api;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.List;
/* loaded from: classes3.dex */
public interface IBehaviorApi {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("behavior-api", "behavior-api");

    void addBehavior(int i, @NonNull String str, @NonNull String str2);

    void addBehavior(int i, @NonNull String str, @NonNull String str2, @NonNull String str3);

    void addBehavior(List<Behavior> list);
}
