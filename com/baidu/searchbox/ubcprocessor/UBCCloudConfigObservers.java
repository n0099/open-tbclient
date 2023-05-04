package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.fj1;
import com.baidu.tieba.hj1;
/* loaded from: classes2.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public hj1<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        fj1 b = fj1.b();
        this.mObservers = b;
        b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
