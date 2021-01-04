package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.a.a.b;
import com.baidu.pyramid.a.a.d;
/* loaded from: classes7.dex */
public class UBCCloudConfigObservers {
    d<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        this.mObservers = b.ahA();
        this.mObservers.b(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
