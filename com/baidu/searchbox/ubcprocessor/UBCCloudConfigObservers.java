package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.rf1;
import com.baidu.tieba.tf1;
/* loaded from: classes4.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public tf1<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        rf1 b = rf1.b();
        this.mObservers = b;
        b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
