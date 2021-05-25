package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import d.a.e0.a.b.b;
import d.a.e0.a.b.d;
/* loaded from: classes2.dex */
public class UBCCloudConfigObservers {
    @Inject(force = false)
    public d<UBCCloudConfigObserver> mObservers;

    public UBCCloudConfigObservers() {
        initmObservers();
    }

    public void initmObservers() {
        b b2 = b.b();
        this.mObservers = b2;
        b2.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }
}
