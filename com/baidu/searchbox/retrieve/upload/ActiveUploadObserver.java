package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult_ActiveUploadObserver_ListProvider;
import com.baidu.tieba.fj1;
import com.baidu.tieba.hj1;
/* loaded from: classes2.dex */
public class ActiveUploadObserver {
    @Inject(force = false)
    public hj1<IActiveUploadResult> mActiveObserverList;

    public void initmActiveObserverList() {
        fj1 b = fj1.b();
        this.mActiveObserverList = b;
        b.a(new IActiveUploadResult_ActiveUploadObserver_ListProvider());
    }

    public ActiveUploadObserver() {
        initmActiveObserverList();
    }
}
