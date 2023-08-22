package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.jk1;
import com.baidu.tieba.lk1;
/* loaded from: classes4.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public lk1<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        jk1 b = jk1.b();
        this.mObservers = b;
        b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
