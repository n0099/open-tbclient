package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.bl1;
import com.baidu.tieba.dl1;
/* loaded from: classes4.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public dl1<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        bl1 b = bl1.b();
        this.mObservers = b;
        b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
