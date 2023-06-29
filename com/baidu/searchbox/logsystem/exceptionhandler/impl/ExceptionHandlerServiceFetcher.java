package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler;
import com.baidu.tieba.wl1;
/* loaded from: classes4.dex */
public class ExceptionHandlerServiceFetcher extends wl1<ExceptionHandler> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.wl1
    public ExceptionHandler createService() throws ServiceNotFoundException {
        return new ExceptionHandlerImpl(false);
    }
}
