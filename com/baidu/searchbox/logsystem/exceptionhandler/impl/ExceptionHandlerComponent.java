package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.kk1;
import com.baidu.tieba.mk1;
/* loaded from: classes2.dex */
public class ExceptionHandlerComponent {
    @Inject
    public mk1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        kk1 b = kk1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
