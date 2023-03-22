package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.bj1;
import com.baidu.tieba.dj1;
/* loaded from: classes2.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public dj1<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        bj1 b = bj1.b();
        this.mObservers = b;
        b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
