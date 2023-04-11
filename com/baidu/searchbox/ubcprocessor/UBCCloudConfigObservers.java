package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.cj1;
import com.baidu.tieba.ej1;
/* loaded from: classes2.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public ej1<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        cj1 b = cj1.b();
        this.mObservers = b;
        b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
