package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import d.b.c0.a.b.b;
import d.b.c0.a.b.d;
/* loaded from: classes2.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public d<UBCCloudConfigObserver> mObservers;

    public UBCCloudConfigObservers() {
        initmObservers();
    }

    public void initmObservers() {
        b c2 = b.c();
        this.mObservers = c2;
        c2.b(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }
}
