package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult_ActiveUploadObserver_ListProvider;
import com.baidu.tieba.dj1;
import com.baidu.tieba.fj1;
/* loaded from: classes2.dex */
public class ActiveUploadObserver {
    @Inject(force = false)
    public fj1<IActiveUploadResult> mActiveObserverList;

    public void initmActiveObserverList() {
        dj1 b = dj1.b();
        this.mActiveObserverList = b;
        b.a(new IActiveUploadResult_ActiveUploadObserver_ListProvider());
    }

    public ActiveUploadObserver() {
        initmActiveObserverList();
    }
}
