package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.cj1;
import com.baidu.tieba.ej1;
/* loaded from: classes2.dex */
public class ExceptionHandlerComponent {
    @Inject
    public ej1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        cj1 b = cj1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
