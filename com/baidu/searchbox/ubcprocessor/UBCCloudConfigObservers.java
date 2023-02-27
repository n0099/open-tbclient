package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.lk1;
import com.baidu.tieba.nk1;
/* loaded from: classes3.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public nk1<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        lk1 b = lk1.b();
        this.mObservers = b;
        b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
