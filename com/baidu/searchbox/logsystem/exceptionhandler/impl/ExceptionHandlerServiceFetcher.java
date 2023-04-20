package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler;
import com.baidu.tieba.rj1;
/* loaded from: classes2.dex */
public class ExceptionHandlerServiceFetcher extends rj1<ExceptionHandler> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.rj1
    public ExceptionHandler createService() throws ServiceNotFoundException {
        return new ExceptionHandlerImpl(false);
    }
}
