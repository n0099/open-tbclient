package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.we1;
import com.baidu.tieba.ye1;
/* loaded from: classes4.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public ye1<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        we1 b = we1.b();
        this.mObservers = b;
        b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
