package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult_ActiveUploadObserver_ListProvider;
import com.baidu.tieba.il1;
import com.baidu.tieba.kl1;
/* loaded from: classes4.dex */
public class ActiveUploadObserver {
    @Inject(force = false)
    public kl1<IActiveUploadResult> mActiveObserverList;

    public void initmActiveObserverList() {
        il1 b = il1.b();
        this.mActiveObserverList = b;
        b.a(new IActiveUploadResult_ActiveUploadObserver_ListProvider());
    }

    public ActiveUploadObserver() {
        initmActiveObserverList();
    }
}
