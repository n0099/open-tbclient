package com.baidu.searchbox.retrieve.core.task;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.tieba.fg1;
/* loaded from: classes4.dex */
public class UploadTaskFetcher extends fg1<IUploadTask> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.fg1
    public IUploadTask createService() throws ServiceNotFoundException {
        return new UploadTask();
    }
}
