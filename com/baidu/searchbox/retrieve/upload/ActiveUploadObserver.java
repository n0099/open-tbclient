package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult_ActiveUploadObserver_ListProvider;
import com.baidu.tieba.bj1;
import com.baidu.tieba.dj1;
/* loaded from: classes2.dex */
public class ActiveUploadObserver {
    @Inject(force = false)
    public dj1<IActiveUploadResult> mActiveObserverList;

    public void initmActiveObserverList() {
        bj1 b = bj1.b();
        this.mActiveObserverList = b;
        b.a(new IActiveUploadResult_ActiveUploadObserver_ListProvider());
    }

    public ActiveUploadObserver() {
        initmActiveObserverList();
    }
}
