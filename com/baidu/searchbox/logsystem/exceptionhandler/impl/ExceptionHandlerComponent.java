package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.mk1;
import com.baidu.tieba.ok1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public ok1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        mk1 b = mk1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
