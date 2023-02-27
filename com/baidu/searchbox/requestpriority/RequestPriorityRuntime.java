package com.baidu.searchbox.requestpriority;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes2.dex */
public class RequestPriorityRuntime {
    @Inject(force = false)
    public static IRequestPriorityManager getRequestPriorityManager() {
        return IRequestPriorityManager.EMPTY;
    }
}
