package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult_ActiveUploadObserver_ListProvider;
import com.baidu.tieba.lk1;
import com.baidu.tieba.nk1;
/* loaded from: classes2.dex */
public class ActiveUploadObserver {
    @Inject(force = false)
    public nk1<IActiveUploadResult> mActiveObserverList;

    public void initmActiveObserverList() {
        lk1 b = lk1.b();
        this.mActiveObserverList = b;
        b.a(new IActiveUploadResult_ActiveUploadObserver_ListProvider());
    }

    public ActiveUploadObserver() {
        initmActiveObserverList();
    }
}
