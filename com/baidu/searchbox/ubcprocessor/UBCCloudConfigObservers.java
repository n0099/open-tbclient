package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.a.a.b;
import com.baidu.pyramid.a.a.d;
/* loaded from: classes20.dex */
public class UBCCloudConfigObservers {
    d<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        this.mObservers = b.afE();
        this.mObservers.b(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
