package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ve1;
import com.baidu.tieba.xe1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public xe1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        ve1 b = ve1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
