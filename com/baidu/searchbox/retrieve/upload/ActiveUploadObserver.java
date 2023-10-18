package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult_ActiveUploadObserver_ListProvider;
import com.baidu.tieba.we1;
import com.baidu.tieba.ye1;
/* loaded from: classes4.dex */
public class ActiveUploadObserver {
    @Inject(force = false)
    public ye1<IActiveUploadResult> mActiveObserverList;

    public void initmActiveObserverList() {
        we1 b = we1.b();
        this.mActiveObserverList = b;
        b.a(new IActiveUploadResult_ActiveUploadObserver_ListProvider());
    }

    public ActiveUploadObserver() {
        initmActiveObserverList();
    }
}
