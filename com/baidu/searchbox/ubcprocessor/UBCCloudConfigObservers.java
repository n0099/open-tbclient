package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.a.a.a;
import com.baidu.pyramid.a.a.b;
/* loaded from: classes19.dex */
public class UBCCloudConfigObservers {
    b<UBCCloudConfigObserver> mObservers;

    public void initmObservers() {
        this.mObservers = a.WP();
        this.mObservers.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
    }

    public UBCCloudConfigObservers() {
        initmObservers();
    }
}
