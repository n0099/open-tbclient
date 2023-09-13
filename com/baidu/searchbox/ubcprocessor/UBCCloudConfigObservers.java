package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.nk1;
import com.baidu.tieba.pk1;
/* loaded from: classes4.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public pk1<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        nk1 b = nk1.b();
        this.mObservers = b;
        b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
