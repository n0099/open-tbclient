package com.baidu.searchbox.pms.init;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes4.dex */
public class PmsManager {
    public static IPmsManager sPmsManager;

    @Inject(force = false)
    public static IPmsManager getInstance() {
        if (sPmsManager == null) {
            sPmsManager = IPmsManager.EMPTY;
        }
        return PmsManagerImpl_Factory.get();
    }

    public static void setPmsManager(IPmsManager iPmsManager) {
        sPmsManager = iPmsManager;
    }
}
